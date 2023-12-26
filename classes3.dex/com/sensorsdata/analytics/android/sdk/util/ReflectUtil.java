package com.sensorsdata.analytics.android.sdk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {
    static <T> T findField(Class<?> cls, Object obj, String... strArr) {
        Field findFieldObj = findFieldObj(cls, strArr);
        if (findFieldObj == null) {
            return null;
        }
        try {
            return findFieldObj.get(obj);
        } catch (Exception | IllegalAccessException unused) {
            return null;
        }
    }

    public static <T> T findField(String[] strArr, Object obj, String... strArr2) {
        Class<?> currentClass = getCurrentClass(strArr);
        if (currentClass != null) {
            return findField(currentClass, obj, strArr2);
        }
        return null;
    }

    public static Class<?> getCurrentClass(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        Class<?> cls = null;
        for (int i = 0; i < strArr.length; i++) {
            try {
                cls = Class.forName(strArr[i]);
            } catch (Exception unused) {
                cls = null;
            }
            if (cls != null) {
                break;
            }
        }
        return cls;
    }

    static boolean isInstance(Object obj, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (String cls : strArr) {
            try {
                z = Class.forName(cls).isInstance(obj);
            } catch (Exception unused) {
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        Method method = getMethod(obj.getClass(), str, clsArr);
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        Method method;
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        if (!(cls == null || (method = getMethod(cls, str, clsArr)) == null)) {
            try {
                return method.invoke((Object) null, objArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    static Method getDeclaredRecur(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> cls2;
        while (true) {
            Class<? super Object> cls3 = cls;
            if (cls3 == Object.class) {
                return null;
            }
            try {
                Method declaredMethod = cls3.getDeclaredMethod(str, clsArr);
                if (declaredMethod != null) {
                    return declaredMethod;
                }
                cls2 = cls3;
                cls3 = cls2;
            } catch (NoSuchMethodException unused) {
                cls2 = cls3.getSuperclass();
            }
        }
    }

    static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    static Field findFieldObj(Class<?> cls, String... strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    Field field = null;
                    for (int i = 0; i < strArr.length; i++) {
                        try {
                            field = cls.getDeclaredField(strArr[i]);
                        } catch (NoSuchFieldException unused) {
                            field = null;
                        }
                        if (field != null) {
                            break;
                        }
                    }
                    if (field == null) {
                        return null;
                    }
                    field.setAccessible(true);
                    return field;
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    static Field findFieldObjRecur(Class<?> cls, String str) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 == Object.class) {
                return null;
            }
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            }
        }
    }

    static <T> T findFieldRecur(Object obj, String str) {
        Field findFieldObjRecur = findFieldObjRecur(obj.getClass(), str);
        if (findFieldObjRecur == null) {
            return null;
        }
        try {
            return findFieldObjRecur.get(obj);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }
}
