package com.wushuangtech.utils;

public class GenericUtils {
    public static <T> T newInstance(Class<?> cls, Object[] objArr) throws Exception {
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return cls.getConstructor(clsArr).newInstance(objArr);
    }
}
