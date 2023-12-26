package com.bonree.sdk.bc;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class br {
    private static Map a;

    private br() {
    }

    private static void a() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    if (a == null) {
                        a = new HashMap();
                    }
                    a.put(nextToken.toLowerCase(), "true");
                } else {
                    String substring = nextToken.substring(0, indexOf);
                    String substring2 = nextToken.substring(indexOf + 1);
                    if (a == null) {
                        a = new HashMap();
                    }
                    a.put(substring.toLowerCase(), substring2.toLowerCase());
                }
            }
        }
    }

    private static void b() {
        a = null;
    }

    private static void c(String str) {
        if (a == null) {
            a = new HashMap();
        }
        a.put(str.toLowerCase(), "true");
    }

    private static void a(String str, String str2) {
        if (a == null) {
            a = new HashMap();
        }
        a.put(str.toLowerCase(), str2.toLowerCase());
    }

    private static void d(String str) {
        Map map = a;
        if (map != null) {
            map.remove(str.toLowerCase());
        }
    }

    public static boolean a(String str) {
        Map map = a;
        if (map == null || map.get(str.toLowerCase()) == null) {
            return false;
        }
        return true;
    }

    private static String e(String str) {
        Map map = a;
        if (map == null) {
            return null;
        }
        return (String) map.get(str.toLowerCase());
    }

    public static int b(String str) {
        String str2;
        Map map = a;
        if (map == null) {
            str2 = null;
        } else {
            str2 = (String) map.get(str.toLowerCase());
        }
        if (str2 == null) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(str2);
            if (parseInt > 0) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static {
        try {
            String property = System.getProperty("dnsjava.options");
            if (property != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    int indexOf = nextToken.indexOf(61);
                    if (indexOf == -1) {
                        if (a == null) {
                            a = new HashMap();
                        }
                        a.put(nextToken.toLowerCase(), "true");
                    } else {
                        String substring = nextToken.substring(0, indexOf);
                        String substring2 = nextToken.substring(indexOf + 1);
                        if (a == null) {
                            a = new HashMap();
                        }
                        a.put(substring.toLowerCase(), substring2.toLowerCase());
                    }
                }
            }
        } catch (SecurityException unused) {
        }
    }
}
