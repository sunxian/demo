package com.example.demo.proxy2.staticProxy;

import org.springframework.cglib.core.Signature;
import org.springframework.cglib.reflect.FastClass;

import java.lang.reflect.InvocationTargetException;

/**
 * @author sunxian
 * @version 2022-08-15 9:45
 */
public class LandLord$$FastClassByCGLIB$$18a0559e  extends FastClass {
    public LandLord$$FastClassByCGLIB$$18a0559e(Class var1) {
        super(var1);
    }

    public int getIndex(Signature var1) {
        String var10000 = var1.toString();
        switch(var10000.hashCode()) {
            case 1092831644:
                if (var10000.equals("rent()V")) {
                    return 0;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return 1;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return 2;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return 3;
                }
        }

        return -1;
    }

    public int getIndex(String var1, Class[] var2) {
        switch(var1.hashCode()) {
            case -1776922004:
                if (var1.equals("toString")) {
                    switch(var2.length) {
                        case 0:
                            return 2;
                    }
                }
                break;
            case -1295482945:
                if (var1.equals("equals")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("java.lang.Object")) {
                                return 1;
                            }
                    }
                }
                break;
            case 3496761:
                if (var1.equals("rent")) {
                    switch(var2.length) {
                        case 0:
                            return 0;
                    }
                }
                break;
            case 147696667:
                if (var1.equals("hashCode")) {
                    switch(var2.length) {
                        case 0:
                            return 3;
                    }
                }
        }

        return -1;
    }

    public int getIndex(Class[] var1) {
        switch(var1.length) {
            case 0:
                return 0;
            default:
                return -1;
        }
    }

    public Object invoke(int var1, Object var2, Object[] var3) throws InvocationTargetException {
        LandLord var10000 = (LandLord)var2;
        int var10001 = var1;

        try {
            switch(var10001) {
                case 0:
                    var10000.rent();
                    return null;
                case 1:
                    return new Boolean(var10000.equals(var3[0]));
                case 2:
                    return var10000.toString();
                case 3:
                    return new Integer(var10000.hashCode());
            }
        } catch (Throwable var4) {
            throw new InvocationTargetException(var4);
        }

        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    public Object newInstance(int var1, Object[] var2) throws InvocationTargetException {
        LandLord var10000 = new LandLord;
        LandLord var10001 = var10000;
        int var10002 = var1;

        try {
            switch(var10002) {
                case 0:
                    var10001.<init>();
                    return var10000;
            }
        } catch (Throwable var3) {
            throw new InvocationTargetException(var3);
        }

        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    public int getMaxIndex() {
        return 3;
    }
}
