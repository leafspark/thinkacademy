package com.igexin.push.extension.distribution.basic.c;

import com.igexin.push.core.CoreConsts;
import java.lang.reflect.Method;

public class b {
    public static final String a = a();

    private static String a() {
        String str = "com.igexin.sdk.action.doaction";
        Class<CoreConsts> cls = CoreConsts.class;
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            CoreConsts newInstance = cls.newInstance();
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (method.isAnnotationPresent(Deprecated.class) && method.getParameterTypes().length == 0) {
                    str = (String) method.invoke(newInstance, new Object[0]);
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
