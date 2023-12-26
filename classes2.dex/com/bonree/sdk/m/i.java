package com.bonree.sdk.m;

import com.bonree.sdk.agent.engine.external.MethodInfo;
import java.net.URI;
import java.net.URL;

public final class i {
    private static void c(String str, URI uri, String str2) {
        if (uri != null) {
            MethodInfo.beforeMethod(str, 1, uri.toString(), str2);
        }
    }

    public static void a(String str, URL url, String str2) {
        if (url != null) {
            MethodInfo.beforeMethod(str, 1, url.toString(), str2);
        }
    }

    private static void c(String str, URL url, String str2, int i) {
        if (url != null) {
            MethodInfo.beforeMethod(str, 1, url.toString(), str2, i);
        }
    }

    public static void a(String str, String str2, String str3) {
        MethodInfo.beforeMethod(str, 1, str2, str3);
    }

    private static void c(String str, String str2, String str3, int i) {
        MethodInfo.beforeMethod(str, 1, str2, str3, i);
    }

    public static void a(String str, URI uri, String str2) {
        if (uri != null) {
            e(str, uri.toString(), str2);
        }
    }

    public static void a(String str, URI uri, String str2, int i) {
        if (uri != null) {
            a(str, uri.toString(), str2, i);
        }
    }

    private static void c(String str, URL url, String str2) {
        if (url != null) {
            e(str, url.toString(), str2);
        }
    }

    public static void a(String str, URL url, String str2, int i) {
        if (url != null) {
            a(str, url.toString(), str2, i);
        }
    }

    private static void e(String str, String str2, String str3) {
        MethodInfo.beforeMethod(str, 13, str2, str3);
    }

    public static void a(String str, String str2, String str3, int i) {
        MethodInfo.beforeMethod(str, 13, str2, str3, i);
    }

    private static void d(String str, URI uri, String str2) {
        if (uri != null) {
            b(str, uri.toString(), str2);
        }
    }

    private static void d(String str, URL url, String str2) {
        if (url != null) {
            b(str, url.toString(), str2);
        }
    }

    public static void b(String str, String str2, String str3) {
        MethodInfo.beforeMethod(str, 14, str2, str3);
    }

    private static void e(String str, URI uri, String str2) {
        if (uri != null) {
            MethodInfo.afterMethod(str, 1, uri.toString(), str2);
        }
    }

    public static void b(String str, URL url, String str2) {
        if (url != null) {
            MethodInfo.afterMethod(str, 1, url.toString(), str2);
        }
    }

    public static void c(String str, String str2, String str3) {
        MethodInfo.afterMethod(str, 1, str2, str3);
    }

    public static void b(String str, URI uri, String str2) {
        if (uri != null) {
            f(str, uri.toString(), str2);
        }
    }

    public static void b(String str, URI uri, String str2, int i) {
        if (uri != null) {
            b(str, uri.toString(), str2, i);
        }
    }

    private static void e(String str, URL url, String str2) {
        if (url != null) {
            f(str, url.toString(), str2);
        }
    }

    public static void b(String str, URL url, String str2, int i) {
        if (url != null) {
            b(str, url.toString(), str2, i);
        }
    }

    private static void f(String str, String str2, String str3) {
        MethodInfo.afterMethod(str, 13, str2, str3);
    }

    public static void b(String str, String str2, String str3, int i) {
        MethodInfo.afterMethod(str, 13, str2, str3, i);
    }

    private static void f(String str, URI uri, String str2) {
        if (uri != null) {
            d(str, uri.toString(), str2);
        }
    }

    private static void f(String str, URL url, String str2) {
        if (url != null) {
            d(str, url.toString(), str2);
        }
    }

    public static void d(String str, String str2, String str3) {
        MethodInfo.afterMethod(str, 14, str2, str3);
    }
}
