package com.igexin.assist.control.fcm;

import java.lang.reflect.Method;
import java.util.Objects;

public class InvokeUtil {
    private static Method compareMethods(Method[] methodArr, String str, Class<?>[] clsArr) {
        Objects.requireNonNull(str, "Method name must not be null.");
        for (Method method : methodArr) {
            if (method.getName().equals(str) && isClassArrayEquals(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method compareMethods = compareMethods(r1.getDeclaredMethods(), str, clsArr);
            Class<? super Object> cls2 = cls;
            if (compareMethods != null) {
                compareMethods.setAccessible(true);
                return compareMethods;
            } else if (cls2.getSuperclass() != null) {
                cls2 = cls2.getSuperclass();
            } else {
                throw new NoSuchMethodException();
            }
        }
    }

    private static boolean isClassArrayEquals(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr2[i] != null && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                return false;
            }
        }
        return true;
    }
}
