package com.example.demo.proxy.tencent.cglib;


import org.springframework.cglib.core.*;
import org.springframework.cglib.proxy.MethodInterceptorGenerator;
import org.springframework.cglib.reflect.FastClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sunxian
 * @version 2022-08-11 11:23
 */
public class MethodProxy {


    private Signature sig1;
    private Signature sig2;
    private org.springframework.cglib.proxy.MethodProxy.CreateInfo createInfo;
    private final Object initLock = new Object();
    private volatile org.springframework.cglib.proxy.MethodProxy.FastClassInfo fastClassInfo;

    /**
     * 一个MethodProxy对象，包含了两个方法的名称，一个是被代理类中的原始方法
     * 另外一个则是代理类中生成的用来调用被代理类原始方法的方法名
     * 当执行MethodProxy.invoke()方法时，其实就是用的被代理类的方法索引
     * 当执行MethodProxy.invokeSuper()方法时，用的是代理类中的方法的索引
     * c1是代理类实现的父类的class
     * c2是代理类的class
     * name1是被代理类中的原始方法名
     * name2是代理类中新增的用来调用被代理类原始方法的方法的名字
     */
    public static org.springframework.cglib.proxy.MethodProxy create(Class c1, Class c2, String desc, String name1, String name2) {
        org.springframework.cglib.proxy.MethodProxy proxy = new org.springframework.cglib.proxy.MethodProxy();
        proxy.sig1 = new Signature(name1, desc);
        proxy.sig2 = new Signature(name2, desc);
        proxy.createInfo = new org.springframework.cglib.proxy.MethodProxy.CreateInfo(c1, c2);
        return proxy;
    }

    private void init() {
        if (this.fastClassInfo == null) {
            synchronized(this.initLock) {
                if (this.fastClassInfo == null) {
                    CreateInfo ci = createInfo;
                    FastClassInfo fci = new FastClassInfo();
                    // helper中生成了对应Class的FastClass实例，这里可以看出就是生成了两个Class的FastClass
                    fci.f1 = helper(ci, ci.c1);
                    fci.f2 = helper(ci, ci.c2);
                    // 获取方法的下标,sig1原本的方法名,sig2是为了调用父类方法生成的特殊方法的方法名
                    fci.i1 = fci.f1.getIndex(sig1);
                    fci.i2 = fci.f2.getIndex(sig2);
                    // 存储在本地变量上
                    fastClassInfo = fci;
                    createInfo = null;
                }
            }
        }

    }

    private static FastClass helper(org.springframework.cglib.proxy.MethodProxy.CreateInfo ci, Class type) {
        FastClass.Generator g = new FastClass.Generator();
        g.setType(type);
        g.setContextClass(type);
        g.setClassLoader(ci.c2.getClassLoader());
        g.setNamingPolicy(ci.namingPolicy);
        g.setStrategy(ci.strategy);
        g.setAttemptLoad(ci.attemptLoad);
        return g.create();
    }

    private MethodProxy() {
    }

    public Signature getSignature() {
        return this.sig1;
    }

    public String getSuperName() {
        return this.sig2.getName();
    }

    public int getSuperIndex() {
        this.init();
        return this.fastClassInfo.i2;
    }

    FastClass getFastClass() {
        this.init();
        return this.fastClassInfo.f1;
    }

    FastClass getSuperFastClass() {
        this.init();
        return this.fastClassInfo.f2;
    }

    public static org.springframework.cglib.proxy.MethodProxy find(Class type, Signature sig) {
        try {
            Method m = type.getDeclaredMethod("CGLIB$findMethodProxy", MethodInterceptorGenerator.FIND_PROXY_TYPES);
            return (org.springframework.cglib.proxy.MethodProxy)m.invoke((Object)null, sig);
        } catch (NoSuchMethodException var3) {
            throw new IllegalArgumentException("Class " + type + " does not use a MethodInterceptor");
        } catch (InvocationTargetException | IllegalAccessException var4) {
            throw new CodeGenerationException(var4);
        }
    }

    public Object invoke(Object obj, Object[] args) throws Throwable {
        try {
            this.init();
            org.springframework.cglib.proxy.MethodProxy.FastClassInfo fci = this.fastClassInfo;
            return fci.f1.invoke(fci.i1, obj, args);
        } catch (InvocationTargetException var4) {
            throw var4.getTargetException();
        } catch (IllegalArgumentException var5) {
            if (this.fastClassInfo.i1 < 0) {
                throw new IllegalArgumentException("Protected method: " + this.sig1);
            } else {
                throw var5;
            }
        }
    }

    public Object invokeSuper(Object obj, Object[] args) throws Throwable {
        try {
            // 调用init方法，当前MethodProxy所代表的方法在在FastClass中的索引
            init();
            FastClassInfo fci = fastClassInfo;
            // 这里的f2就是一个FastClass，fci.i2就是在init方法中计算出来的索引
            return fci.f2.invoke(fci.i2, obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    private static class CreateInfo {
        Class c1;
        Class c2;
        NamingPolicy namingPolicy;
        GeneratorStrategy strategy;
        boolean attemptLoad;

        public CreateInfo(Class c1, Class c2) {
            this.c1 = c1;
            this.c2 = c2;
            AbstractClassGenerator fromEnhancer = AbstractClassGenerator.getCurrent();
            if (fromEnhancer != null) {
                this.namingPolicy = fromEnhancer.getNamingPolicy();
                this.strategy = fromEnhancer.getStrategy();
                this.attemptLoad = fromEnhancer.getAttemptLoad();
            }

        }
    }

    private static class FastClassInfo {
        // 被代理类的FastClass
        FastClass f1;
        // 代理类的FastClass
        FastClass f2;
        int i1;
        int i2;

        private FastClassInfo() {
        }
    }

}
