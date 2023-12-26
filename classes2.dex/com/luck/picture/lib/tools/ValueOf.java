package com.luck.picture.lib.tools;

public class ValueOf {
    public static <T> T to(Object obj, T t) {
        return obj == null ? t : obj;
    }

    public static String toString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static double toDouble(Object obj) {
        return toDouble(obj, 0);
    }

    public static double toDouble(Object obj, int i) {
        if (obj == null) {
            return (double) i;
        }
        try {
            return Double.valueOf(obj.toString().trim()).doubleValue();
        } catch (Exception unused) {
            return (double) i;
        }
    }

    public static long toLong(Object obj, long j) {
        long j2;
        if (obj == null) {
            return j;
        }
        try {
            String trim = obj.toString().trim();
            if (trim.contains(".")) {
                j2 = Long.valueOf(trim.substring(0, trim.lastIndexOf("."))).longValue();
            } else {
                j2 = Long.valueOf(trim).longValue();
            }
            return j2;
        } catch (Exception unused) {
            return j;
        }
    }

    public static long toLong(Object obj) {
        return toLong(obj, 0);
    }

    public static float toFloat(Object obj, long j) {
        if (obj == null) {
            return (float) j;
        }
        try {
            return Float.valueOf(obj.toString().trim()).floatValue();
        } catch (Exception unused) {
            return (float) j;
        }
    }

    public static float toFloat(Object obj) {
        return toFloat(obj, 0);
    }

    public static int toInt(Object obj, int i) {
        int i2;
        if (obj == null) {
            return i;
        }
        try {
            String trim = obj.toString().trim();
            if (trim.contains(".")) {
                i2 = Integer.valueOf(trim.substring(0, trim.lastIndexOf("."))).intValue();
            } else {
                i2 = Integer.valueOf(trim).intValue();
            }
            return i2;
        } catch (Exception unused) {
            return i;
        }
    }

    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    public static boolean toBoolean(Object obj) {
        return toBoolean(obj, false);
    }

    public static boolean toBoolean(Object obj, boolean z) {
        if (obj == null) {
            return false;
        }
        try {
            return !"false".equals(obj.toString().trim().trim());
        } catch (Exception unused) {
            return z;
        }
    }
}
