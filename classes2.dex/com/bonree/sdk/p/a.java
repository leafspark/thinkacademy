package com.bonree.sdk.p;

import android.os.Build;
import android.text.TextUtils;
import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.m.j;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import com.bonree.sdk.v.d;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public final class a extends j {
    public static void a(b bVar, HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null && bVar != null) {
            try {
                int contentLength = httpURLConnection.getContentLength();
                int responseCode = httpURLConnection.getResponseCode();
                bVar.j(httpURLConnection.getRequestMethod());
                if (bVar.G() == 0) {
                    bVar.f(com.bonree.sdk.d.a.b());
                }
                a(bVar, "", contentLength, responseCode);
            } catch (Throwable th) {
                g.a("Failed to retrieve response code due to exception: ", th);
            }
        }
    }

    public static void b(b bVar, HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            a(bVar, httpURLConnection.getURL().toString());
        }
    }

    private static boolean b(b bVar, Object obj) throws Exception {
        Object a = obj != null ? z.a(obj, "userResponse") : null;
        if (a == null) {
            return true;
        }
        Object a2 = z.a(a, a.getClass().getName(), "networkResponse", (Class[]) null, new Object[0]);
        Object a3 = z.a(a, a.getClass().getName(), "cacheResponse", (Class[]) null, new Object[0]);
        if (a2 == null && a3 != null) {
            bVar.a(true);
        }
        return true;
    }

    public static void c(b bVar, HttpURLConnection httpURLConnection) {
        if (!bVar.h()) {
            a(bVar, httpURLConnection);
        }
    }

    public static void a(Exception exc, HttpURLConnection httpURLConnection, b bVar) {
        a(bVar, exc);
        a(httpURLConnection, bVar);
    }

    private static void a(HttpURLConnection httpURLConnection, b bVar) {
        if (!bVar.h()) {
            a(bVar, httpURLConnection);
            if (TextUtils.isEmpty(bVar.f())) {
                bVar.c(httpURLConnection.getURL().toString());
            }
            bVar.j(httpURLConnection.getRequestMethod());
            int contentLength = httpURLConnection.getContentLength();
            if (contentLength >= 0) {
                bVar.d((long) contentLength);
            }
            int i = bVar.i();
            try {
                i = httpURLConnection.getResponseCode();
            } catch (Throwable unused) {
            }
            bVar.a(i);
            bVar.r();
            com.bonree.sdk.m.g.a().notifyService((c) bVar);
            g.a("httpsUrlConnection error:" + bVar.toString(), new Object[0]);
        }
    }

    private static void b(b bVar, HttpsURLConnection httpsURLConnection) {
        c(bVar, httpsURLConnection);
        a(bVar, (HttpURLConnection) httpsURLConnection, true);
    }

    private static void a(b bVar, HttpURLConnection httpURLConnection, boolean z) {
        Object obj;
        Map<String, String> d;
        try {
            String url = httpURLConnection.getURL().toString();
            if (!TextUtils.isEmpty(url)) {
                bVar.c(url);
            }
            if (z) {
                obj = z.a(z.a((Object) httpURLConnection, "delegate"), "httpEngine");
            } else {
                obj = z.a((Object) httpURLConnection, "httpEngine");
            }
            if (Build.VERSION.SDK_INT <= 19) {
                if (z.a(obj, "responseHeaders") == null) {
                    return;
                }
            } else if (obj != null && z.a(obj, "userResponse") == null) {
                return;
            }
            String contentType = httpURLConnection.getContentType();
            String str = "";
            if (contentType != null) {
                if (!str.equals(contentType)) {
                    bVar.f(contentType);
                }
            }
            if (bVar.i() <= 0) {
                bVar.a(httpURLConnection.getResponseCode());
            }
            if (httpURLConnection != null && httpURLConnection.getHeaderFields() != null && httpURLConnection.getHeaderFields().size() > 0 && (d = u.d((Map<String, List<String>>) httpURLConnection.getHeaderFields())) != null) {
                bVar.b(d);
                u.a f = u.f((Map<String, List<String>>) httpURLConnection.getHeaderFields());
                String str2 = null;
                if (f != null) {
                    if (!TextUtils.isEmpty(f.b)) {
                        str = f.b;
                    }
                    bVar.a(f.c);
                    str2 = f.a;
                }
                if ("http/1.1".equals(str.toLowerCase()) || "http/1.0".equals(str.toLowerCase())) {
                    str2 = (str.toUpperCase() + " " + httpURLConnection.getResponseCode() + " ") + HTTP.CRLF + str2;
                }
                bVar.g(str);
                bVar.b(str2);
            }
        } catch (Throwable th) {
            g.b("httpsUrlConnctionExtension getHeaderFields error:" + th);
        }
    }

    private static void c(b bVar, HttpsURLConnection httpsURLConnection) {
        Object a;
        Object a2;
        if (httpsURLConnection != null) {
            try {
                if (("com.android.okhttp.internal.huc.HttpsURLConnectionImpl".equals(httpsURLConnection.getClass().getName()) || "com.android.okhttp.internal.http.HttpsURLConnectionImpl".equals(httpsURLConnection.getClass().getName())) && (a = z.a((Object) httpsURLConnection, "delegate")) != null && (a2 = z.a(a, "httpEngine")) != null) {
                    c(bVar, a2);
                }
            } catch (Throwable th) {
                g.b("httpsurlconnectionextension : " + th.toString(), new Object[0]);
            }
        }
    }

    private static void f(b bVar, HttpURLConnection httpURLConnection) {
        Object a;
        if (httpURLConnection != null) {
            try {
                if (("com.android.okhttp.internal.huc.HttpURLConnectionImpl".equals(httpURLConnection.getClass().getName()) || "com.android.okhttp.internal.http.HttpURLConnectionImpl".equals(httpURLConnection.getClass().getName())) && (a = z.a((Object) httpURLConnection, "httpEngine")) != null) {
                    c(bVar, a);
                }
            } catch (Throwable th) {
                g.b("httpurlconnection extension : " + th.toString(), new Object[0]);
            }
        }
    }

    private static void c(b bVar, Object obj) throws Exception {
        Object a;
        Object a2;
        Object a3;
        a(bVar, obj);
        Object a4 = z.a(obj, "networkRequest");
        if (!(a4 == null || (a3 = z.a(a4, "headers")) == null)) {
            Object a5 = z.a(a3, a3.getClass().getName(), "names", (Class[]) null, new Object[0]);
            try {
                if (a5 instanceof Set) {
                    Method a6 = z.a(a3.getClass().getName(), "get", new Class[]{String.class});
                    a6.setAccessible(true);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str : (Set) a5) {
                        linkedHashMap.put(str, (String) a6.invoke(a3, new Object[]{str}));
                    }
                    bVar.a((Map<String, String>) linkedHashMap);
                } else {
                    String[] split = a3.toString().split("\n");
                    if (split != null && split.length > 1) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (String split2 : split) {
                            String[] split3 = split2.split(": ");
                            linkedHashMap2.put(split3[0], split3[1]);
                        }
                        bVar.a((Map<String, String>) linkedHashMap2);
                    }
                }
            } catch (Throwable th) {
                com.bonree.sdk.be.a.a().a("matchSocket get headers error:%s", th);
            }
            bVar.h(a3.toString());
        }
        Object a7 = z.a(obj, "transport");
        if (a7 != null && (a = z.a(a7, "httpConnection")) != null && (a2 = z.a(a, "socket")) != null) {
            SocketImpl socketImpl = (SocketImpl) z.a(z.a((Class<?>) Socket.class, "impl"), a2);
            if (socketImpl instanceof d) {
                ((d) socketImpl).a(bVar);
            }
        }
    }

    private static void a(b bVar, Object obj) {
        Object obj2;
        if (obj != null) {
            try {
                obj2 = z.a(obj, "userResponse");
            } catch (Throwable th) {
                g.a("httpsUrlConnctionExtension userResponse checkIsCache error url:" + bVar.f() + "  error: ", th);
            }
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            Object a = z.a(obj2, obj2.getClass().getName(), "networkResponse", (Class[]) null, new Object[0]);
            Object a2 = z.a(obj2, obj2.getClass().getName(), "cacheResponse", (Class[]) null, new Object[0]);
            if (a == null && a2 != null) {
                bVar.a(true);
            }
        }
        try {
            if (z.a(obj, "cacheResponse") != null) {
                bVar.a(true);
            }
        } catch (Throwable unused) {
            g.b("httpsurlconnectionextension httpEngine no cache url: " + bVar.f(), new Object[0]);
        }
    }

    public static void a(b bVar, HttpsURLConnection httpsURLConnection) {
        c(bVar, httpsURLConnection);
        a(bVar, (HttpURLConnection) httpsURLConnection, true);
        bVar.n();
        if (300 > bVar.i() || 310 < bVar.i()) {
            com.bonree.sdk.m.g.a().notifyService((c) bVar);
            g.a("httpsUrlConnection data: %s", bVar);
            return;
        }
        g.a("httpsUrlConnection data is redirect", new Object[0]);
    }

    public static void a(Throwable th, HttpURLConnection httpURLConnection, b bVar) {
        com.bonree.sdk.agent.business.util.c.a(bVar, th);
        g.b("TransactionStateUtil: Attempting to convert network exception " + th.getClass().getName() + " to error code.");
        a(httpURLConnection, bVar);
    }

    private static void e(b bVar, HttpURLConnection httpURLConnection) {
        Object a;
        if (httpURLConnection != null) {
            try {
                if (("com.android.okhttp.internal.huc.HttpURLConnectionImpl".equals(httpURLConnection.getClass().getName()) || "com.android.okhttp.internal.http.HttpURLConnectionImpl".equals(httpURLConnection.getClass().getName())) && (a = z.a((Object) httpURLConnection, "httpEngine")) != null) {
                    c(bVar, a);
                }
            } catch (Throwable th) {
                g.b("httpurlconnection extension : " + th.toString(), new Object[0]);
            }
        }
        a(bVar, httpURLConnection, false);
        if (TextUtils.isEmpty(bVar.Q())) {
            bVar.j(httpURLConnection.getRequestMethod());
        }
    }

    public static void d(b bVar, HttpURLConnection httpURLConnection) {
        Object a;
        if (httpURLConnection != null) {
            try {
                if (("com.android.okhttp.internal.huc.HttpURLConnectionImpl".equals(httpURLConnection.getClass().getName()) || "com.android.okhttp.internal.http.HttpURLConnectionImpl".equals(httpURLConnection.getClass().getName())) && (a = z.a((Object) httpURLConnection, "httpEngine")) != null) {
                    c(bVar, a);
                }
            } catch (Throwable th) {
                g.b("httpurlconnection extension : " + th.toString(), new Object[0]);
            }
        }
        a(bVar, httpURLConnection, false);
        if (TextUtils.isEmpty(bVar.Q())) {
            bVar.j(httpURLConnection.getRequestMethod());
        }
        bVar.n();
        if (300 <= bVar.i() && 310 >= bVar.i()) {
            g.a("httpsUrlConnection data is redirect", new Object[0]);
            com.bonree.sdk.m.a.a().a((Object) bVar);
        } else if (!bVar.p()) {
            bVar.r();
            com.bonree.sdk.m.g.a().notifyService((c) bVar);
            g.a("httpUrlConnection data:" + bVar.toString(), new Object[0]);
        }
    }
}
