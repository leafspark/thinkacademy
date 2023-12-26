package com.amazonaws.util;

import java.util.Collection;

public class ValidationUtils {
    public static <T> T assertNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(String.format("%s cannot be null", new Object[]{str}));
    }

    public static void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void assertAllAreNull(String str, Object... objArr) {
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            if (objArr[i] == null) {
                i++;
            } else {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static int assertIsPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(String.format("%s must be positive", new Object[]{str}));
    }

    public static <T extends Collection<?>> T assertNotEmpty(T t, String str) {
        assertNotNull(t, str);
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[]{str}));
    }

    public static <T> T[] assertNotEmpty(T[] tArr, String str) {
        assertNotNull(tArr, str);
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[]{str}));
    }

    public static String assertStringNotEmpty(String str, String str2) {
        assertNotNull(str, str2);
        if (!str.isEmpty()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("%s cannot be empty", new Object[]{str2}));
    }
}
