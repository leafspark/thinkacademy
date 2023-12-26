package com.bonree.sdk.u;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.util.c;
import com.bonree.sdk.agent.engine.network.okhttp3.external.Okhttp3Dns;
import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.m.j;
import com.bonree.sdk.m.o;
import com.bonree.sdk.n.b;
import com.bonree.sdk.v.d;
import com.bonree.sdk.v.e;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSource;

public final class a extends j {
    public static void a(b bVar, Request request) {
        if (request == null) {
            g.b("Missing request", new Object[0]);
            return;
        }
        try {
            Headers headers = request.headers();
            if (headers != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : headers.names()) {
                    linkedHashMap.put(str, headers.get(str));
                }
                bVar.a((Map<String, String>) linkedHashMap);
                bVar.h(headers.toString());
            }
            bVar.j(request.method());
            bVar.c(request.url().toString());
            RequestBody body = request.body();
            if (body != null) {
                bVar.j(body.contentLength());
            }
        } catch (Throwable th) {
            g.a("parse request failed:", th);
        }
    }

    public static Response a(b bVar, Response response) {
        b(bVar, response);
        bVar.n();
        com.bonree.sdk.m.a.a().a((Object) bVar);
        return response;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x009a A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bf A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f3 A[Catch:{ all -> 0x0106 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(com.bonree.sdk.n.b r9, okhttp3.Response r10) {
        /*
            java.lang.String r0 = " "
            long r1 = com.bonree.sdk.d.a.b()     // Catch:{ all -> 0x0106 }
            r9.f((long) r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            if (r10 != 0) goto L_0x001b
            r10 = 642(0x282, float:9.0E-43)
            java.lang.String r0 = "okhttp3 Missing response"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0106 }
            com.bonree.sdk.be.g.b(r0, r2)     // Catch:{ all -> 0x0106 }
            goto L_0x00fd
        L_0x001b:
            okhttp3.Request r1 = r10.request()     // Catch:{ all -> 0x0106 }
            okhttp3.HttpUrl r1 = r1.url()     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0106 }
            r9.c((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
            okhttp3.Protocol r1 = r10.protocol()     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0106 }
            okhttp3.Headers r5 = r10.headers()     // Catch:{ all -> 0x0106 }
            java.util.Map r5 = r5.toMultimap()     // Catch:{ all -> 0x0106 }
            java.util.Map r5 = com.bonree.sdk.bs.u.d((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r5)     // Catch:{ all -> 0x0106 }
            if (r5 == 0) goto L_0x0043
            r9.b((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ all -> 0x0106 }
        L_0x0043:
            okhttp3.Headers r5 = r10.headers()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0106 }
            int r6 = r10.code()     // Catch:{ all -> 0x0106 }
            java.lang.String r7 = "http/1.1"
            boolean r7 = r7.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0106 }
            if (r7 != 0) goto L_0x0062
            java.lang.String r7 = "http/1.0"
            boolean r7 = r7.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0106 }
            if (r7 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r0 = r5
            goto L_0x0096
        L_0x0062:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r7.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r8 = r1.toUpperCase()     // Catch:{ all -> 0x0106 }
            r7.append(r8)     // Catch:{ all -> 0x0106 }
            r7.append(r0)     // Catch:{ all -> 0x0106 }
            r7.append(r6)     // Catch:{ all -> 0x0106 }
            r7.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r10.message()     // Catch:{ all -> 0x0106 }
            r7.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r7.<init>()     // Catch:{ all -> 0x0106 }
            r7.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = "\r\n"
            r7.append(r0)     // Catch:{ all -> 0x0106 }
            r7.append(r5)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0106 }
        L_0x0096:
            r5 = 101(0x65, float:1.42E-43)
            if (r6 != r5) goto L_0x00bf
            java.lang.String r1 = r9.f()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = "https://"
            boolean r1 = r1.startsWith(r5)     // Catch:{ all -> 0x0106 }
            if (r1 != 0) goto L_0x00b9
            java.lang.String r1 = r9.f()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = "wss://"
            boolean r1 = r1.startsWith(r5)     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x00b3
            goto L_0x00b9
        L_0x00b3:
            java.lang.String r1 = "ws"
            r9.g((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
            goto L_0x00c2
        L_0x00b9:
            java.lang.String r1 = "wss"
            r9.g((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
            goto L_0x00c2
        L_0x00bf:
            r9.g((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
        L_0x00c2:
            java.lang.String r1 = "Content-Type"
            java.lang.String r1 = r10.header(r1)     // Catch:{ all -> 0x0106 }
            if (r1 == 0) goto L_0x00d3
            int r5 = r1.length()     // Catch:{ all -> 0x0106 }
            if (r5 <= 0) goto L_0x00d3
            r9.f((java.lang.String) r1)     // Catch:{ all -> 0x0106 }
        L_0x00d3:
            long r7 = b(r10)     // Catch:{ all -> 0x0106 }
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00fa
            boolean r1 = a((okhttp3.Response) r10)     // Catch:{ all -> 0x0106 }
            if (r1 != 0) goto L_0x00fa
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            okhttp3.ResponseBody r10 = r10.peekBody(r3)     // Catch:{ all -> 0x0106 }
            if (r10 == 0) goto L_0x00f3
            long r3 = r10.contentLength()     // Catch:{ all -> 0x0106 }
            r1 = r0
            r10 = r6
            goto L_0x00fd
        L_0x00f3:
            java.lang.String r10 = "OkHttp3TransactionStateUtil: Missing body or content length"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0106 }
            com.bonree.sdk.be.g.b(r10, r1)     // Catch:{ all -> 0x0106 }
        L_0x00fa:
            r1 = r0
            r10 = r6
            r3 = r7
        L_0x00fd:
            if (r10 != 0) goto L_0x0101
            r10 = 200(0xc8, float:2.8E-43)
        L_0x0101:
            int r0 = (int) r3     // Catch:{ all -> 0x0106 }
            a(r9, r1, r0, r10)     // Catch:{ all -> 0x0106 }
            return
        L_0x0106:
            r9 = move-exception
            java.lang.String r10 = "parse response failed:"
            com.bonree.sdk.be.g.a((java.lang.String) r10, (java.lang.Throwable) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.u.a.b(com.bonree.sdk.n.b, okhttp3.Response):void");
    }

    private static boolean a(Response response) {
        BufferedSource source;
        Object a;
        try {
            if (response.body() == null || (source = response.body().source()) == null || !TextUtils.equals("okio.RealBufferedSource", source.getClass().getName()) || (a = z.a((Object) source, "source")) == null) {
                return false;
            }
            String name = a.getClass().getName();
            if (!TextUtils.equals("okhttp3.internal.http1.Http1Codec$ChunkedSource", name)) {
                if (!TextUtils.equals("okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource", name)) {
                    Object a2 = z.a(a, "delegate");
                    if (a2 == null) {
                        return false;
                    }
                    String name2 = a2.getClass().getName();
                    return TextUtils.equals("okhttp3.internal.http1.Http1Codec$ChunkedSource", name2) || TextUtils.equals("okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource", name2);
                }
            }
        } catch (Throwable th) {
            g.a("isChunkedSource false. because:", th.getCause());
        }
    }

    private static long b(Response response) {
        String header;
        long j = -1;
        if (response == null) {
            return -1;
        }
        try {
            if (response.body() != null) {
                j = response.body().contentLength();
            }
            if (j >= 0 || (header = response.header("Content-length")) == null || header.length() <= 0) {
                return j;
            }
            return Long.parseLong(header);
        } catch (NumberFormatException e) {
            g.b("Failed to parse content length: " + e, new Object[0]);
            return j;
        } catch (Throwable th) {
            g.a("parse response failed:", th);
            return j;
        }
    }

    private static Response c(b bVar, Response response) {
        bVar.n();
        com.bonree.sdk.m.a.a().a((Object) bVar);
        return response;
    }

    public static boolean a(OkHttpClient okHttpClient) {
        try {
            Object a = z.a((Object) okHttpClient, "cache");
            if (a == null) {
                return false;
            }
            try {
                if (((Integer) z.a(a, "networkCount")).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                g.a("parse delegate fail", new Object[0]);
            }
        } catch (Exception unused2) {
        }
    }

    public static void a(b bVar, OkHttpClient okHttpClient) {
        ArrayDeque arrayDeque;
        Object obj = null;
        try {
            Object a = z.a((Object) okHttpClient, "connectionPool");
            if (a != null) {
                obj = z.a(a, "delegate");
                if (obj != null) {
                    arrayDeque = (ArrayDeque) z.a(obj, "connections");
                } else {
                    arrayDeque = (ArrayDeque) z.a(a, "connections");
                }
                if (arrayDeque == null) {
                    return;
                }
                if (arrayDeque.size() == 1) {
                    Object a2 = z.a(arrayDeque.getFirst(), "rawSocket");
                    if (a2 != null) {
                        Object a3 = z.a(a2, "impl");
                        if (a3 instanceof d) {
                            ((d) a3).a(bVar);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            g.a("socket guanlian fail:" + th, new Object[0]);
        }
    }

    public static Request a(Request request, b bVar) {
        try {
            if (request.tag() == null) {
                o.a(request, (Object) bVar);
            } else {
                g.a("request tag  not null:", new Object[0]);
            }
            return request;
        } catch (Throwable unused) {
            g.a("set request tag fail", new Object[0]);
            return request;
        }
    }

    public static void a(Exception exc, b bVar) {
        c.a(bVar, exc);
        if (!bVar.h()) {
            bVar.r();
            com.bonree.sdk.m.g.a().notifyService((com.bonree.sdk.n.c) bVar);
        }
        g.a("okhttp3 error data:" + bVar.toString(), new Object[0]);
    }

    public static void a(OkHttpClient okHttpClient, b bVar) {
        if (okHttpClient != null) {
            try {
                if (okHttpClient.dns() == null) {
                    return;
                }
                if (!(okHttpClient.dns() instanceof Okhttp3Dns)) {
                    z.a("dns", okHttpClient, new Okhttp3Dns(okHttpClient.dns(), bVar));
                } else {
                    okHttpClient.dns().a(bVar);
                }
            } catch (Throwable unused) {
                g.b("replaceDefaultDns failed:");
            }
        }
    }

    public static b a(Request request) {
        if (request == null || request.tag() == null || !(request.tag() instanceof b)) {
            return null;
        }
        return (b) request.tag();
    }

    public static void a(Socket socket, b bVar) {
        if (socket != null && bVar != null) {
            try {
                if (socket instanceof e) {
                    ((e) socket).a(bVar);
                    return;
                }
                Object obj = null;
                try {
                    obj = z.a(z.a((Object) socket, "socket"), "impl");
                } catch (Throwable unused) {
                }
                if (obj == null) {
                    obj = z.a((Object) socket, "impl");
                }
                if (obj instanceof d) {
                    ((d) obj).a(bVar);
                }
            } catch (Throwable th) {
                g.b("network error: " + th);
            }
        }
    }
}
