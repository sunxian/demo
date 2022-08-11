package com.example.demo.proxy.tencent.cglib.FastClass;

import com.example.demo.proxy.tencent.cglib.ThirdPartyTVCglibClass;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.reflect.FastClass;

import java.lang.reflect.InvocationTargetException;

/**
 * @author sunxian
 * @version 2022-08-11 9:27
 */
public class ThirdPartyTVCglibClass$$EnhancerByCGLIB$$6682532b$$FastClassByCGLIB$$437adfc6 extends FastClass {
    public ThirdPartyTVCglibClass$$EnhancerByCGLIB$$6682532b$$FastClassByCGLIB$$437adfc6(Class var1) {
        super(var1);
    }

    public int getIndex(Signature var1) {
        String var10000 = var1.toString();
        switch(var10000.hashCode()) {
            case -1882565338:
                if (var10000.equals("CGLIB$equals$1(Ljava/lang/Object;)Z")) {
                    return 16;
                }
                break;
            case -1870561232:
                if (var10000.equals("CGLIB$findMethodProxy(Lorg/springframework/cglib/core/Signature;)Lorg/springframework/cglib/proxy/MethodProxy;")) {
                    return 9;
                }
                break;
            case -1745842178:
                if (var10000.equals("setCallbacks([Lorg/springframework/cglib/proxy/Callback;)V")) {
                    return 17;
                }
                break;
            case -1641413109:
                if (var10000.equals("newInstance([Lorg/springframework/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 4;
                }
                break;
            case -1457535688:
                if (var10000.equals("CGLIB$STATICHOOK1()V")) {
                    return 10;
                }
                break;
            case -1411842725:
                if (var10000.equals("CGLIB$hashCode$3()I")) {
                    return 13;
                }
                break;
            case -1332317346:
                if (var10000.equals("getVideoInfo()Ljava/lang/String;")) {
                    return 7;
                }
                break;
            case -1034266769:
                if (var10000.equals("CGLIB$SET_STATIC_CALLBACKS([Lorg/springframework/cglib/proxy/Callback;)V")) {
                    return 18;
                }
                break;
            case -1025895669:
                if (var10000.equals("CGLIB$SET_THREAD_CALLBACKS([Lorg/springframework/cglib/proxy/Callback;)V")) {
                    return 19;
                }
                break;
            case -988317324:
                if (var10000.equals("newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lorg/springframework/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 6;
                }
                break;
            case -508378822:
                if (var10000.equals("clone()Ljava/lang/Object;")) {
                    return 3;
                }
                break;
            case 610042816:
                if (var10000.equals("newInstance(Lorg/springframework/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 5;
                }
                break;
            case 1132856532:
                if (var10000.equals("getCallbacks()[Lorg/springframework/cglib/proxy/Callback;")) {
                    return 11;
                }
                break;
            case 1246779367:
                if (var10000.equals("setCallback(ILorg/springframework/cglib/proxy/Callback;)V")) {
                    return 8;
                }
                break;
            case 1306468936:
                if (var10000.equals("CGLIB$toString$2()Ljava/lang/String;")) {
                    return 15;
                }
                break;
            case 1364367423:
                if (var10000.equals("getCallback(I)Lorg/springframework/cglib/proxy/Callback;")) {
                    return 12;
                }
                break;
            case 1577356589:
                if (var10000.equals("CGLIB$getVideoInfo$0()Ljava/lang/String;")) {
                    return 20;
                }
                break;
            case 1800494055:
                if (var10000.equals("CGLIB$clone$4()Ljava/lang/Object;")) {
                    return 14;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return 0;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return 1;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return 2;
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
                            return 1;
                    }
                }
                break;
            case -1295482945:
                if (var1.equals("equals")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("java.lang.Object")) {
                                return 0;
                            }
                    }
                }
                break;
            case -1053468136:
                if (var1.equals("getCallbacks")) {
                    switch(var2.length) {
                        case 0:
                            return 11;
                    }
                }
                break;
            case -697859998:
                if (var1.equals("CGLIB$getVideoInfo$0")) {
                    switch(var2.length) {
                        case 0:
                            return 20;
                    }
                }
                break;
            case -124978609:
                if (var1.equals("CGLIB$equals$1")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("java.lang.Object")) {
                                return 16;
                            }
                    }
                }
                break;
            case -60403779:
                if (var1.equals("CGLIB$SET_STATIC_CALLBACKS")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) {
                                return 18;
                            }
                    }
                }
                break;
            case -29025555:
                if (var1.equals("CGLIB$hashCode$3")) {
                    switch(var2.length) {
                        case 0:
                            return 13;
                    }
                }
                break;
            case 85179481:
                if (var1.equals("CGLIB$SET_THREAD_CALLBACKS")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) {
                                return 19;
                            }
                    }
                }
                break;
            case 94756189:
                if (var1.equals("clone")) {
                    switch(var2.length) {
                        case 0:
                            return 3;
                    }
                }
                break;
            case 147696667:
                if (var1.equals("hashCode")) {
                    switch(var2.length) {
                        case 0:
                            return 2;
                    }
                }
                break;
            case 161998109:
                if (var1.equals("CGLIB$STATICHOOK1")) {
                    switch(var2.length) {
                        case 0:
                            return 10;
                    }
                }
                break;
            case 495524492:
                if (var1.equals("setCallbacks")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) {
                                return 17;
                            }
                    }
                }
                break;
            case 1154623345:
                if (var1.equals("CGLIB$findMethodProxy")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("org.springframework.cglib.core.Signature")) {
                                return 9;
                            }
                    }
                }
                break;
            case 1323018515:
                if (var1.equals("getVideoInfo")) {
                    switch(var2.length) {
                        case 0:
                            return 7;
                    }
                }
                break;
            case 1543336189:
                if (var1.equals("CGLIB$toString$2")) {
                    switch(var2.length) {
                        case 0:
                            return 15;
                    }
                }
                break;
            case 1811874389:
                if (var1.equals("newInstance")) {
                    switch(var2.length) {
                        case 1:
                            String var10001 = var2[0].getName();
                            switch(var10001.hashCode()) {
                                case -1997738671:
                                    if (var10001.equals("[Lorg.springframework.cglib.proxy.Callback;")) {
                                        return 4;
                                    }
                                    break;
                                case 1364160985:
                                    if (var10001.equals("org.springframework.cglib.proxy.Callback")) {
                                        return 5;
                                    }
                            }
                        case 2:
                        default:
                            break;
                        case 3:
                            if (var2[0].getName().equals("[Ljava.lang.Class;") && var2[1].getName().equals("[Ljava.lang.Object;") && var2[2].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) {
                                return 6;
                            }
                    }
                }
                break;
            case 1817099975:
                if (var1.equals("setCallback")) {
                    switch(var2.length) {
                        case 2:
                            if (var2[0].getName().equals("int") && var2[1].getName().equals("org.springframework.cglib.proxy.Callback")) {
                                return 8;
                            }
                    }
                }
                break;
            case 1905679803:
                if (var1.equals("getCallback")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("int")) {
                                return 12;
                            }
                    }
                }
                break;
            case 1951977610:
                if (var1.equals("CGLIB$clone$4")) {
                    switch(var2.length) {
                        case 0:
                            return 14;
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
        6682532b var10000 = (6682532b)var2;
        int var10001 = var1;

        try {
            switch(var10001) {
                case 0:
                    return new Boolean(var10000.equals(var3[0]));
                case 1:
                    return var10000.toString();
                case 2:
                    return new Integer(var10000.hashCode());
                case 3:
                    return var10000.clone();
                case 4:
                    return var10000.newInstance((Callback[])var3[0]);
                case 5:
                    return var10000.newInstance((Callback)var3[0]);
                case 6:
                    return var10000.newInstance((Class[])var3[0], (Object[])var3[1], (Callback[])var3[2]);
                case 7:
                    return var10000.getVideoInfo();
                case 8:
                    var10000.setCallback(((Number)var3[0]).intValue(), (Callback)var3[1]);
                    return null;
                case 9:
                    return 6682532b.CGLIB$findMethodProxy((Signature)var3[0]);
                case 10:
                    6682532b.CGLIB$STATICHOOK1();
                    return null;
                case 11:
                    return var10000.getCallbacks();
                case 12:
                    return var10000.getCallback(((Number)var3[0]).intValue());
                case 13:
                    return new Integer(var10000.CGLIB$hashCode$3());
                case 14:
                    return var10000.CGLIB$clone$4();
                case 15:
                    return var10000.CGLIB$toString$2();
                case 16:
                    return new Boolean(var10000.CGLIB$equals$1(var3[0]));
                case 17:
                    var10000.setCallbacks((Callback[])var3[0]);
                    return null;
                case 18:
                    6682532b.CGLIB$SET_STATIC_CALLBACKS((Callback[])var3[0]);
                    return null;
                case 19:
                    6682532b.CGLIB$SET_THREAD_CALLBACKS((Callback[])var3[0]);
                    return null;
                case 20:
                    return var10000.CGLIB$getVideoInfo$0();
            }
        } catch (Throwable var4) {
            throw new InvocationTargetException(var4);
        }

        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    public Object newInstance(int var1, Object[] var2) throws InvocationTargetException {
        6682532b var10000 = new 6682532b;
        6682532b var10001 = var10000;
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
        return 20;
    }
}