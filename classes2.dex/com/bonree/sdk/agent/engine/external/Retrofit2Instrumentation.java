package com.bonree.sdk.agent.engine.external;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.network.okhttp3.external.Ok3EventFactory;
import com.bonree.sdk.agent.engine.network.okhttp3.external.Ok3EventListener;
import com.bonree.sdk.agent.engine.network.okhttp3.external.OkHttp3Interceptor;
import com.bonree.sdk.agent.engine.network.okhttp3.external.OkHttp3NetworkInterceptor;
import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.i.l;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.k;
import com.bonree.sdk.m.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class Retrofit2Instrumentation {
    private static final String RETROFIT2_ENQUEUE = "retrofit2/enqueue";
    private static final String RETROFIT2_EXECUTE = "retrofit2/execute";

    public static Retrofit build(Retrofit.Builder builder) {
        try {
            if (!g.a().b()) {
                return builder.build();
            }
            com.bonree.sdk.be.g.a("retrofit2 build come in", new Object[0]);
            if (z.a((Object) builder, "callFactory") == null) {
                builder.client(new OkHttpClient.Builder().addNetworkInterceptor(new OkHttp3NetworkInterceptor()).addInterceptor(new OkHttp3Interceptor()).build());
            }
            return builder.build();
        } catch (Throwable th) {
            a.a().a("Retrofit2Instrumentation build error", th);
        }
    }

    public static Retrofit.Builder client(Retrofit.Builder builder, OkHttpClient okHttpClient) {
        try {
            if (!g.a().b()) {
                removeInterceptors(okHttpClient);
                return builder.client(okHttpClient);
            }
            com.bonree.sdk.be.g.a("retrofit2 client come in", new Object[0]);
            addInterceptor(okHttpClient);
            return builder.client(okHttpClient);
        } catch (Throwable unused) {
        }
    }

    private static void addInterceptor(OkHttpClient okHttpClient) {
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
        } catch (Throwable unused) {
        }
    }

    private static void filterInterceptor(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            filterInterceptor((List<Interceptor>) okHttpClient.interceptors());
            filterInterceptor((List<Interceptor>) okHttpClient.networkInterceptors());
        }
    }

    private static void filterInterceptor(List<Interceptor> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = null;
            for (Interceptor next : list) {
                if ((next instanceof OkHttp3Interceptor) || (next instanceof OkHttp3NetworkInterceptor)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                }
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                list.removeAll(arrayList);
            }
        }
    }

    public static void enqueue(Call call, Callback callback) {
        if (call == null || call.request() == null || call.request().url() == null || call.request().url().url() == null) {
            call.enqueue(callback);
            return;
        }
        String str = null;
        int i = 0;
        if (ad.b(call.request().header("br_interactive_uuid"))) {
            checkInterceptorAndListener(call);
            str = UUID.randomUUID().toString();
            o.a(call.request(), "br_interactive_uuid", str);
            i = getRetrofit2Timeout(call);
            l.a(RETROFIT2_ENQUEUE, call.request().url().url(), str, i);
            if (call.request() != null) {
                k.b().a(call.request().url().host(), call.request().url().uri().getPath(), str, call, k.a.g);
            }
        }
        call.enqueue(callback);
        if (!ad.b(str)) {
            l.b(RETROFIT2_ENQUEUE, call.request().url().url(), str, i);
        }
    }

    public static Response execute(Call call) throws IOException {
        if (call == null || call.request() == null || call.request().url() == null || call.request().url().url() == null) {
            return call.execute();
        }
        String str = null;
        int i = 0;
        if (ad.b(call.request().header("br_interactive_uuid"))) {
            checkInterceptorAndListener(call);
            str = UUID.randomUUID().toString();
            o.a(call.request(), "br_interactive_uuid", str);
            i = getRetrofit2Timeout(call);
            l.a(RETROFIT2_EXECUTE, call.request().url().url(), str, i);
            if (call.request() != null) {
                k.b().a(call.request().url().host(), call.request().url().uri().getPath(), str, call, k.a.g);
            }
        }
        try {
            Response execute = call.execute();
            if (!ad.b(str)) {
                l.b(RETROFIT2_EXECUTE, call.request().url().url(), str, i);
            }
            return execute;
        } catch (IOException e) {
            throw e;
        }
    }

    private static void checkInterceptorAndListener(Call call) {
        if (!g.a().b()) {
            Object ok3Client = getOk3Client(call, false);
            if (ok3Client != null && (ok3Client instanceof OkHttpClient)) {
                OkHttpClient okHttpClient = (OkHttpClient) ok3Client;
                removeInterceptors(okHttpClient);
                removeEventListener(okHttpClient);
                com.bonree.sdk.be.g.a("br component remove success!");
                return;
            }
            return;
        }
        Object ok3Client2 = getOk3Client(call, true);
        if (ok3Client2 != null && (ok3Client2 instanceof OkHttpClient)) {
            OkHttpClient okHttpClient2 = (OkHttpClient) ok3Client2;
            addInterceptor(okHttpClient2);
            if (o.b()) {
                addEventListener(okHttpClient2);
            }
            com.bonree.sdk.be.g.a("br component add success!");
        }
    }

    private static void addEventListener(OkHttpClient okHttpClient) {
        try {
            EventListener.Factory eventListenerFactory = okHttpClient.eventListenerFactory();
            if (eventListenerFactory == null || !(eventListenerFactory instanceof Ok3EventFactory)) {
                Ok3EventFactory ok3EventFactory = new Ok3EventFactory();
                ok3EventFactory.a(eventListenerFactory);
                try {
                    z.a("eventListenerFactory", okHttpClient, ok3EventFactory);
                } catch (Throwable unused) {
                }
                com.bonree.sdk.be.g.a(" Retrofit2Instrumentation addEventListener finish", new Object[0]);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.g.a(" Retrofit2Instrumentation addEventListener:", th);
        }
    }

    private static int getRetrofit2Timeout(Call call) {
        Object ok3Client = getOk3Client(call, true);
        if (ok3Client == null || !(ok3Client instanceof OkHttpClient)) {
            return 10000;
        }
        int i = 0;
        try {
            i = ((OkHttpClient) ok3Client).callTimeoutMillis();
        } catch (Throwable unused) {
        }
        if (i > 0) {
            return i;
        }
        OkHttpClient okHttpClient = (OkHttpClient) ok3Client;
        return okHttpClient.connectTimeoutMillis() + okHttpClient.readTimeoutMillis() + okHttpClient.writeTimeoutMillis();
    }

    private static Object getOk3Client(Call call, boolean z) {
        com.bonree.sdk.be.g.a("Retrofit2Instrumentation getOk3Client: %s", call.getClass().toString());
        try {
            return maybeOkHttpCall(z.a((Object) call, "delegate"), z);
        } catch (Throwable th) {
            com.bonree.sdk.be.g.a(" Retrofit2Instrumentation getOk3Client normal error :", th);
            return null;
        }
    }

    private static Object maybeOkHttpCall(Object obj, boolean z) throws Throwable {
        Object obj2;
        Object obj3;
        if (obj == null || !ad.a((CharSequence) obj.getClass().getName(), (CharSequence) "retrofit2.OkHttpCall")) {
            com.bonree.sdk.be.g.b("retrofit2 okhttpCall type error: " + obj);
            return null;
        }
        Object a = z.a(obj, "rawCall");
        if (z && o.b() && a != null) {
            try {
                if (ad.a((CharSequence) a.getClass().getName(), (CharSequence) "okhttp3.RealCall") || ad.a((CharSequence) a.getClass().getName(), (CharSequence) "okhttp3.internal.connection.RealCall")) {
                    obj2 = z.a(a, "eventListener");
                    obj3 = a;
                    if (!(obj2 instanceof Ok3EventListener) && (obj2 instanceof EventListener)) {
                        z.a("eventListener", obj3, new Ok3EventListener((EventListener) obj2));
                    }
                    return z.a(a, "client");
                }
            } catch (Throwable th) {
                com.bonree.sdk.be.g.a("retrofit2 event collect error:", th);
            }
        }
        try {
            Object a2 = z.a(obj, "callFactory");
            if (a2 != null) {
                return a2;
            }
        } catch (Exception e) {
            com.bonree.sdk.be.g.b("retrofit2 callFactory not found: %s", e);
        }
        if (a != null) {
            try {
                return z.a(a, "client");
            } catch (Exception e2) {
                com.bonree.sdk.be.g.a("retrofit2 realCall client error: %s", (Throwable) e2);
            }
        }
        com.bonree.sdk.be.g.b("retrofit2 okhttpCall client error end.");
        return null;
    }

    private static void removeEventListener(OkHttpClient okHttpClient) {
        try {
            EventListener.Factory eventListenerFactory = okHttpClient.eventListenerFactory();
            if (eventListenerFactory != null && (eventListenerFactory instanceof Ok3EventFactory)) {
                z.a("eventListenerFactory", okHttpClient, z.a((Object) eventListenerFactory, "mUserFactory"));
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.g.a(" Retrofit2Instrumentation removeEventListener:", th);
        }
    }

    public static String getVersion() {
        String a = o.a();
        return TextUtils.isEmpty(a) ? OkHttp2Instrumentation.getVersion() : a;
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
            com.bonree.sdk.be.g.a(" Retrofit2Instrumentation removeInterceptors:", th);
        }
    }
}
