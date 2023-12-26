package io.agora.rtc.audio;

import io.agora.rtc.internal.Logging;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Class safeFindClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method safeGetMethod(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object safeCallMethod(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            method = null;
        }
        if (method == null) {
            Logging.e(TAG, "cannot  find method:  " + cls.getSimpleName() + "." + str + ":" + Arrays.toString(clsArr));
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            Logging.e(TAG, "cannot  execute method:  " + cls.getSimpleName() + "." + str + ":" + Arrays.toString(clsArr));
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            Logging.e(TAG, "cannot  execute method:  " + cls.getSimpleName() + "." + str + ":" + Arrays.toString(clsArr));
            return null;
        }
    }
}
