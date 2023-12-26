package com.yanzhenjie.andserver.util;

import java.util.Collection;
import java.util.Map;

public abstract class Assert {
    public static void state(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void isTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isNull(Object obj, String str) {
        if (obj != null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void hasLength(String str, String str2) {
        if (!StringUtils.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void hasText(String str, String str2) {
        if (!StringUtils.hasText(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void doesNotContain(String str, String str2, String str3) {
        if (StringUtils.hasLength(str) && StringUtils.hasLength(str2) && str.contains(str2)) {
            throw new IllegalArgumentException(str3);
        }
    }

    public static void notEmpty(Object[] objArr, String str) {
        if (ObjectUtils.isEmpty(objArr)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void noNullElements(Object[] objArr, String str) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                if (objArr[i] != null) {
                    i++;
                } else {
                    throw new IllegalArgumentException(str);
                }
            }
        }
    }

    public static void notEmpty(Collection<?> collection, String str) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Map<?, ?> map, String str) {
        if (CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str) {
        notNull(cls, "Type to check against must not be null");
        if (!cls.isInstance(obj)) {
            instanceCheckFailed(cls, obj, str);
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        isInstanceOf(cls, obj, "");
    }

    public static void isAssignable(Class<?> cls, Class<?> cls2, String str) {
        notNull(cls, "Super type to check against must not be null");
        if (cls2 == null || !cls.isAssignableFrom(cls2)) {
            assignableCheckFailed(cls, cls2, str);
        }
    }

    public static void isAssignable(Class<?> cls, Class<?> cls2) {
        isAssignable(cls, cls2, "");
    }

    private static void instanceCheckFailed(Class<?> cls, Object obj, String str) {
        String str2;
        String name = obj != null ? obj.getClass().getName() : "null";
        boolean z = true;
        if (!StringUtils.hasLength(str)) {
            str2 = "";
        } else if (endsWithSeparator(str)) {
            str2 = str + " ";
        } else {
            str2 = messageWithTypeName(str, name);
            z = false;
        }
        if (z) {
            str2 = str2 + "Object of class [" + name + "] must be an instance of " + cls;
        }
        throw new IllegalArgumentException(str2);
    }

    private static void assignableCheckFailed(Class<?> cls, Class<?> cls2, String str) {
        String str2;
        boolean z = true;
        if (!StringUtils.hasLength(str)) {
            str2 = "";
        } else if (endsWithSeparator(str)) {
            str2 = str + " ";
        } else {
            str2 = messageWithTypeName(str, cls2);
            z = false;
        }
        if (z) {
            str2 = str2 + cls2 + " is not assignable to " + cls;
        }
        throw new IllegalArgumentException(str2);
    }

    private static boolean endsWithSeparator(String str) {
        return str.endsWith(":") || str.endsWith(";") || str.endsWith(",") || str.endsWith(".");
    }

    private static String messageWithTypeName(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.endsWith(" ") ? "" : ": ");
        sb.append(obj);
        return sb.toString();
    }
}
