package com.bonree.sdk.agent.engine.external;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.network.okhttp3.external.Ok3EventFactory;
import com.bonree.sdk.agent.engine.network.okhttp3.external.OkHttp3Interceptor;
import com.bonree.sdk.agent.engine.network.okhttp3.external.OkHttp3NetworkInterceptor;
import com.bonree.sdk.agent.engine.network.okhttp3.external.Okhttp3CallWarrper;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.i.l;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.o;
import com.bonree.sdk.n.b;
import com.bonree.sdk.q.d;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkUrlFactory;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class OkHttp3Instrumentation {
    private static final String OKHTTP3_NEWCALL = "okhttp3/newCall";
    private static final String OKHTTP3_OKURLFACTORY_OPEN = "okhttp3/OkUrlFactory/open";
    private static final f mLog = a.a();

    public static OkHttpClient init() {
        try {
            if (!g.a().b()) {
                return new OkHttpClient();
            }
            mLog.c("okhttp3 init", new Object[0]);
            return getOkHttpClient(new OkHttpClient().newBuilder());
        } catch (Throwable th) {
            mLog.a(" OkHttpClient init:", th);
            return new OkHttpClient();
        }
    }

    private static OkHttpClient getOkHttpClient(OkHttpClient.Builder builder) {
        OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor();
        setEventListener(builder);
        OkHttpClient build = builder.addInterceptor(okHttp3Interceptor).addNetworkInterceptor(new OkHttp3NetworkInterceptor()).build();
        okHttp3Interceptor.a(build);
        return build;
    }

    private static void setEventListener(OkHttpClient.Builder builder) {
        try {
            if (!o.b()) {
                a.a().c("Current okhttp3 version not support EventListener!", new Object[0]);
                return;
            }
            EventListener.Factory eventListenerFactory = builder.build().eventListenerFactory();
            if (eventListenerFactory == null || !(eventListenerFactory instanceof Ok3EventFactory)) {
                Ok3EventFactory ok3EventFactory = new Ok3EventFactory();
                ok3EventFactory.a(eventListenerFactory);
                builder.eventListenerFactory(ok3EventFactory);
            }
        } catch (Throwable unused) {
            a.a().c("Current okhttp3 version not support EventListener!", new Object[0]);
        }
    }

    public static OkHttpClient.Builder sslSocketFactory(OkHttpClient.Builder builder, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        builder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        return builder;
    }

    /* JADX INFO: finally extract failed */
    public static OkHttpClient builderInit(OkHttpClient.Builder builder) {
        try {
            if (!g.a().b()) {
                filterInterceptor(builder);
                removeFactory(builder);
                OkHttpClient build = builder.build();
                listRemoveNull(builder);
                return build;
            }
            mLog.c("okhttp3 builderInit", new Object[0]);
            filterInterceptor(builder);
            OkHttpClient okHttpClient = getOkHttpClient(builder);
            listRemoveNull(builder);
            return okHttpClient;
        } catch (Throwable th) {
            listRemoveNull(builder);
            throw th;
        }
    }

    private static synchronized void listRemoveNull(OkHttpClient.Builder builder) {
        synchronized (OkHttp3Instrumentation.class) {
            if (builder != null) {
                try {
                    if (builder.networkInterceptors() != null) {
                        builder.networkInterceptors().remove((Object) null);
                    }
                } catch (Throwable unused) {
                    invokeReplaceInterceptors(builder, "networkInterceptors");
                }
            }
            if (builder != null) {
                try {
                    if (builder.interceptors() != null) {
                        builder.interceptors().remove((Object) null);
                    }
                } catch (Throwable unused2) {
                    invokeReplaceInterceptors(builder, "interceptors");
                    return;
                }
            }
        }
        return;
    }

    private static void invokeReplaceInterceptors(OkHttpClient.Builder builder, String str) {
        if (builder != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    List<Interceptor> list = null;
                    if ("networkInterceptors".equals(str)) {
                        list = builder.networkInterceptors();
                    } else if ("interceptors".equals(str)) {
                        list = builder.interceptors();
                    }
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Interceptor interceptor : list) {
                            if (interceptor != null && !(interceptor instanceof OkHttp3NetworkInterceptor) && !(interceptor instanceof OkHttp3Interceptor)) {
                                arrayList.add(interceptor);
                            }
                        }
                        Field declaredField = builder.getClass().getDeclaredField(str);
                        declaredField.setAccessible(true);
                        declaredField.set(builder, arrayList);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void filterInterceptor(OkHttpClient.Builder builder) {
        filterInterceptor((List<Interceptor>) builder.interceptors());
        filterInterceptor((List<Interceptor>) builder.networkInterceptors());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void filterInterceptor(java.util.List<okhttp3.Interceptor> r5) {
        /*
            java.lang.Class<com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation> r0 = com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation.class
            monitor-enter(r0)
            r1 = 0
            if (r5 == 0) goto L_0x0067
            int r2 = r5.size()     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x000d
            goto L_0x0067
        L_0x000d:
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x003d }
        L_0x0011:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x002b
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x003d }
            okhttp3.Interceptor r3 = (okhttp3.Interceptor) r3     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x0027
            boolean r4 = r3 instanceof com.bonree.sdk.agent.engine.network.okhttp3.external.OkHttp3Interceptor     // Catch:{ all -> 0x003d }
            if (r4 != 0) goto L_0x0027
            boolean r3 = r3 instanceof com.bonree.sdk.agent.engine.network.okhttp3.external.OkHttp3NetworkInterceptor     // Catch:{ all -> 0x003d }
            if (r3 == 0) goto L_0x0011
        L_0x0027:
            r2.remove()     // Catch:{ all -> 0x003d }
            goto L_0x0011
        L_0x002b:
            if (r5 == 0) goto L_0x003b
            int r2 = r5.size()     // Catch:{ Exception -> 0x0039 }
            if (r2 != 0) goto L_0x0034
            goto L_0x003b
        L_0x0034:
            r5.remove(r1)     // Catch:{ Exception -> 0x0039 }
            monitor-exit(r0)
            return
        L_0x0039:
            monitor-exit(r0)
            return
        L_0x003b:
            monitor-exit(r0)
            return
        L_0x003d:
            r2 = move-exception
            com.bonree.sdk.be.f r3 = mLog     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "FilterInterceptor error: "
            r3.a((java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x0055
            int r2 = r5.size()     // Catch:{ Exception -> 0x0053 }
            if (r2 != 0) goto L_0x004e
            goto L_0x0055
        L_0x004e:
            r5.remove(r1)     // Catch:{ Exception -> 0x0053 }
            monitor-exit(r0)
            return
        L_0x0053:
            monitor-exit(r0)
            return
        L_0x0055:
            monitor-exit(r0)
            return
        L_0x0057:
            r2 = move-exception
            if (r5 == 0) goto L_0x0065
            int r3 = r5.size()     // Catch:{ Exception -> 0x0064 }
            if (r3 != 0) goto L_0x0061
            goto L_0x0065
        L_0x0061:
            r5.remove(r1)     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            throw r2     // Catch:{ all -> 0x0075 }
        L_0x0065:
            monitor-exit(r0)
            return
        L_0x0067:
            if (r5 == 0) goto L_0x007a
            int r2 = r5.size()     // Catch:{ Exception -> 0x0078 }
            if (r2 != 0) goto L_0x0070
            goto L_0x007a
        L_0x0070:
            r5.remove(r1)     // Catch:{ Exception -> 0x0078 }
            monitor-exit(r0)
            return
        L_0x0075:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        L_0x0078:
            monitor-exit(r0)
            return
        L_0x007a:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation.filterInterceptor(java.util.List):void");
    }

    public static Call newCall(OkHttpClient okHttpClient, Request request) {
        try {
            String uuid = UUID.randomUUID().toString();
            if (g.a().b()) {
                SSLSocketFactory sslSocketFactory = okHttpClient.sslSocketFactory();
                if (sslSocketFactory != null) {
                    f fVar = mLog;
                    fVar.c("okhttp3 newCall sslSocketFactory:" + sslSocketFactory.getClass().getName(), new Object[0]);
                }
                addInterceptors(okHttpClient);
                addEventListener(okHttpClient);
                if (!(request == null || request.url() == null)) {
                    o.a(request, "br_interactive_uuid", uuid);
                    l.a(OKHTTP3_NEWCALL, request.url().url(), uuid);
                }
                Okhttp3CallWarrper okhttp3CallWarrper = new Okhttp3CallWarrper(okHttpClient.newCall(request), uuid, getOk3Timeout(okHttpClient));
                if (!(request == null || request.url() == null)) {
                    l.b(OKHTTP3_NEWCALL, request.url().url(), uuid);
                }
                return okhttp3CallWarrper;
            }
            removeInterceptors(okHttpClient);
            removeFactory(okHttpClient);
            if (!(request == null || request.url() == null)) {
                l.a(OKHTTP3_NEWCALL, request.url().url(), (String) null);
            }
            Call newCall = okHttpClient.newCall(request);
            if (!(request == null || request.url() == null)) {
                l.b(OKHTTP3_NEWCALL, request.url().url(), (String) null);
            }
            return newCall;
        } catch (Throwable th) {
            mLog.a(" OkHttpClient newCall:", th);
            return okHttpClient.newCall(request);
        }
    }

    private static void addEventListener(OkHttpClient okHttpClient) {
        if (!o.b()) {
            a.a().c("Current okhttp3 version not support EventListener!", new Object[0]);
            return;
        }
        EventListener.Factory eventListenerFactory = okHttpClient.eventListenerFactory();
        Ok3EventFactory ok3EventFactory = null;
        if (eventListenerFactory != null) {
            if (!(eventListenerFactory instanceof Ok3EventFactory)) {
                ok3EventFactory = new Ok3EventFactory();
                ok3EventFactory.a(eventListenerFactory);
            } else {
                return;
            }
        }
        try {
            z.a("eventListenerFactory", okHttpClient, ok3EventFactory);
        } catch (Throwable unused) {
        }
    }

    private static void removeFactory(OkHttpClient.Builder builder) {
        if (o.b()) {
            try {
                Object a = z.a((Object) builder, "eventListenerFactory");
                if (a != null && (a instanceof Ok3EventFactory)) {
                    builder.eventListenerFactory((EventListener.Factory) z.a(a, "mUserFactory"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void removeFactory(OkHttpClient okHttpClient) {
        if (o.b()) {
            try {
                EventListener.Factory eventListenerFactory = okHttpClient.eventListenerFactory();
                if (eventListenerFactory != null && (eventListenerFactory instanceof Ok3EventFactory)) {
                    z.a("eventListenerFactory", okHttpClient, z.a((Object) eventListenerFactory, "mUserFactory"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static int getOk3Timeout(OkHttpClient okHttpClient) {
        int i;
        try {
            i = okHttpClient.callTimeoutMillis();
        } catch (Throwable unused) {
            i = 0;
        }
        if (i > 0) {
            return i;
        }
        return okHttpClient.connectTimeoutMillis() + okHttpClient.readTimeoutMillis() + okHttpClient.writeTimeoutMillis();
    }

    private static void addInterceptors(OkHttpClient okHttpClient) {
        try {
            List networkInterceptors = okHttpClient.networkInterceptors();
            if (networkInterceptors != null) {
                ArrayList arrayList = new ArrayList(networkInterceptors);
                filterInterceptor((List<Interceptor>) arrayList);
                arrayList.add(new OkHttp3NetworkInterceptor());
                z.a("networkInterceptors", okHttpClient, arrayList);
            }
            OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor();
            List interceptors = okHttpClient.interceptors();
            if (interceptors != null) {
                ArrayList arrayList2 = new ArrayList(interceptors);
                filterInterceptor((List<Interceptor>) arrayList2);
                arrayList2.add(okHttp3Interceptor);
                z.a("interceptors", okHttpClient, arrayList2);
            }
            okHttp3Interceptor.a(okHttpClient);
        } catch (Throwable th) {
            mLog.a(" OkHttpClient addInterceptors:", th);
        }
    }

    private static void removeInterceptors(OkHttpClient okHttpClient) {
        try {
            List networkInterceptors = okHttpClient.networkInterceptors();
            if (networkInterceptors != null) {
                ArrayList arrayList = new ArrayList(networkInterceptors);
                filterInterceptor((List<Interceptor>) arrayList);
                z.a("networkInterceptors", okHttpClient, arrayList);
            }
            OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor();
            List interceptors = okHttpClient.interceptors();
            if (interceptors != null) {
                ArrayList arrayList2 = new ArrayList(interceptors);
                filterInterceptor((List<Interceptor>) arrayList2);
                z.a("interceptors", okHttpClient, arrayList2);
            }
            okHttp3Interceptor.a(okHttpClient);
        } catch (Throwable th) {
            mLog.a(" OkHttpClient addInterceptors:", th);
        }
    }

    public static WebSocket newWebSocket(OkHttpClient okHttpClient, Request request, WebSocketListener webSocketListener) {
        try {
            if (g.a().b()) {
                addInterceptors(okHttpClient);
            } else {
                removeInterceptors(okHttpClient);
            }
        } catch (Throwable th) {
            mLog.a(" OkHttpClient newWebSocket:", th);
        }
        return okHttpClient.newWebSocket(request, webSocketListener);
    }

    public static boolean newSend(WebSocket webSocket, String str) {
        if (webSocket != null) {
            try {
                if (!TextUtils.isEmpty(str) && g.a().b()) {
                    return com.bonree.sdk.agent.engine.network.websocket.a.a(webSocket, str);
                }
            } catch (Throwable th) {
                mLog.a(" OkHttpClient newSend:", th);
            }
        }
        return webSocket.send(str);
    }

    public static boolean newSend(WebSocket webSocket, ByteString byteString) {
        if (!(webSocket == null || byteString == null)) {
            try {
                if (g.a().b()) {
                    return com.bonree.sdk.agent.engine.network.websocket.a.a(webSocket, byteString);
                }
            } catch (Throwable th) {
                mLog.a(" OkHttpClient newSend:", th);
            }
        }
        return webSocket.send(byteString);
    }

    public static HttpURLConnection open(OkUrlFactory okUrlFactory, URL url) {
        try {
            b bVar = new b();
            l.a(OKHTTP3_OKURLFACTORY_OPEN, url, bVar.X());
            HttpURLConnection open = okUrlFactory.open(url);
            l.b(OKHTTP3_OKURLFACTORY_OPEN, url, bVar.X());
            if (open == null) {
                return null;
            }
            if (!g.a().b()) {
                return open;
            }
            if (open instanceof HttpsURLConnection) {
                return new d((HttpsURLConnection) open, bVar);
            }
            return open instanceof HttpURLConnection ? new com.bonree.sdk.q.a(open, bVar) : open;
        } catch (Throwable th) {
            mLog.a(" OkHttpClient open:", th);
            return okUrlFactory.open(url);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.OkHttpClient.Builder sslSocketFactory(okhttp3.OkHttpClient.Builder r6, javax.net.ssl.SSLSocketFactory r7) {
        /*
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "okhttp3.internal.platform.AndroidPlatform"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = "socketAdapters"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ all -> 0x0055 }
            r2 = 1
            r1.setAccessible(r2)     // Catch:{ all -> 0x0055 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x0055 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x001d
            goto L_0x0055
        L_0x001d:
            boolean r1 = r7 instanceof com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0055
            r1 = 0
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0055 }
        L_0x0026:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = "okhttp3.internal.platform.android.BrSocketAdapter"
            if (r4 == 0) goto L_0x0045
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0055 }
            okhttp3.internal.platform.android.SocketAdapter r4 = (okhttp3.internal.platform.android.SocketAdapter) r4     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0026
            java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0055 }
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0026
            goto L_0x0046
        L_0x0045:
            r2 = r1
        L_0x0046:
            if (r2 != 0) goto L_0x0055
            java.lang.Class r1 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x0055 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ all -> 0x0055 }
            okhttp3.internal.platform.android.BrSocketAdapter r1 = (okhttp3.internal.platform.android.BrSocketAdapter) r1     // Catch:{ all -> 0x0055 }
            r0.add(r1)     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r6.sslSocketFactory(r7)     // Catch:{ all -> 0x0058 }
        L_0x0058:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation.sslSocketFactory(okhttp3.OkHttpClient$Builder, javax.net.ssl.SSLSocketFactory):okhttp3.OkHttpClient$Builder");
    }
}
