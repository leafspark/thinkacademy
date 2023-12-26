package com.tal.app.thinkacademy.lib.network;

import android.content.Context;
import android.content.res.AssetManager;
import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.config.DefaultNetConfig;
import com.tal.app.thinkacademy.lib.network.config.INetConfig;
import com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor;
import com.tal.app.thinkacademy.lib.network.tls.SSLState;
import com.tal.app.thinkacademy.lib.network.tls.TrustAllCerts;
import com.tal.app.thinkacademy.lib.network.tls.TrustSingleCerts;
import com.tal.app.thinkacademy.lib.network.trace.NetTraceEventListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011¢\u0006\u0002\u0010\u0012J'\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b`\fX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/NetworkManager;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "netConfig", "Lcom/tal/app/thinkacademy/lib/network/config/INetConfig;", "retrofit", "Lretrofit2/Retrofit;", "retrofitMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "serviceMap", "create", "T", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "baseUrl", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "createRetrofit", "getRetrofit", "init", "", "context", "Landroid/content/Context;", "config", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkManager.kt */
public final class NetworkManager {
    public static final NetworkManager INSTANCE = new NetworkManager();
    private static OkHttpClient client;
    private static INetConfig netConfig = new DefaultNetConfig();
    private static Retrofit retrofit;
    private static final HashMap<String, Retrofit> retrofitMap = new HashMap<>();
    private static final HashMap<String, Object> serviceMap = new HashMap<>();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetworkManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SSLState.values().length];
            iArr[SSLState.ALL.ordinal()] = 1;
            iArr[SSLState.SINGLE.ordinal()] = 2;
            iArr[SSLState.DOUBLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private NetworkManager() {
    }

    public final void init(Context context, INetConfig iNetConfig) {
        SSLSocketFactory createSSLSocketFactory;
        AssetManager assets;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (iNetConfig == null) {
            iNetConfig = new DefaultNetConfig();
        }
        netConfig = iNetConfig;
        OkHttpClient.Builder eventListenerFactory = builder.callTimeout(iNetConfig.callTimeout(), TimeUnit.SECONDS).connectTimeout(iNetConfig.connectTimeout(), TimeUnit.SECONDS).readTimeout(iNetConfig.readTimeout(), TimeUnit.SECONDS).writeTimeout(iNetConfig.writeTimeout(), TimeUnit.SECONDS).retryOnConnectionFailure(iNetConfig.retryOnConnectionFailure()).dns(iNetConfig.dns()).eventListenerFactory(NetTraceEventListener.Factory);
        for (Interceptor addInterceptor : iNetConfig.interceptor()) {
            eventListenerFactory.addInterceptor(addInterceptor);
        }
        for (Interceptor addNetworkInterceptor : iNetConfig.networkInterceptor()) {
            eventListenerFactory.addNetworkInterceptor(addNetworkInterceptor);
        }
        Interceptor customHttpLoggingInterceptor = new CustomHttpLoggingInterceptor(NetworkManager$$ExternalSyntheticLambda0.INSTANCE);
        customHttpLoggingInterceptor.setLevel(CustomHttpLoggingInterceptor.Level.BODY);
        eventListenerFactory.addNetworkInterceptor(customHttpLoggingInterceptor);
        int i = WhenMappings.$EnumSwitchMapping$0[iNetConfig.sslState().ordinal()];
        if (i == 1) {
            SSLSocketFactory createSSLSocketFactory2 = TrustAllCerts.Companion.createSSLSocketFactory();
            if (createSSLSocketFactory2 != null) {
                X509TrustManager trustAllCerts = new TrustAllCerts();
                if (!(eventListenerFactory instanceof OkHttpClient.Builder)) {
                    eventListenerFactory.sslSocketFactory(createSSLSocketFactory2, trustAllCerts);
                } else {
                    OkHttp3Instrumentation.sslSocketFactory(eventListenerFactory, createSSLSocketFactory2, trustAllCerts);
                }
            }
        } else if (i != 2) {
            if (i == 3) {
                if (iNetConfig.clientCer() == null) {
                    throw new IllegalArgumentException("ClientCer path was null".toString());
                } else if (iNetConfig.serverCer() == null) {
                    throw new IllegalArgumentException("ServerCer path was null".toString());
                }
            }
        } else if (iNetConfig.serverCer() != null) {
            String serverCer = iNetConfig.serverCer();
            InputStream inputStream = null;
            if (!(serverCer == null || context == null || (assets = context.getAssets()) == null)) {
                inputStream = assets.open(serverCer);
            }
            if (!(inputStream == null || (createSSLSocketFactory = TrustSingleCerts.Companion.createSSLSocketFactory(inputStream)) == null)) {
                X509TrustManager trustSingleCerts = new TrustSingleCerts();
                if (!(eventListenerFactory instanceof OkHttpClient.Builder)) {
                    eventListenerFactory.sslSocketFactory(createSSLSocketFactory, trustSingleCerts);
                } else {
                    OkHttp3Instrumentation.sslSocketFactory(eventListenerFactory, createSSLSocketFactory, trustSingleCerts);
                }
            }
        } else {
            throw new IllegalArgumentException("ServerCer path was null".toString());
        }
        OkHttpClient.Builder hostnameVerifier = eventListenerFactory.hostnameVerifier(iNetConfig.hostnameVerifier());
        client = !(hostnameVerifier instanceof OkHttpClient.Builder) ? hostnameVerifier.build() : OkHttp3Instrumentation.builderInit(hostnameVerifier);
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-9$lambda-8$lambda-0  reason: not valid java name */
    public static final void m90init$lambda9$lambda8$lambda0(String str) {
        XesLog.it("HW_NETWORK", str);
    }

    private final Retrofit createRetrofit(String str) {
        if (client == null) {
            init((Context) null, new DefaultNetConfig());
            Unit unit = Unit.INSTANCE;
        }
        if (client != null) {
            Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(str);
            OkHttpClient okHttpClient = client;
            Retrofit.Builder addConverterFactory = (!(baseUrl instanceof Retrofit.Builder) ? baseUrl.client(okHttpClient) : Retrofit2Instrumentation.client(baseUrl, okHttpClient)).addConverterFactory(netConfig.converterFactory());
            Retrofit build = !(addConverterFactory instanceof Retrofit.Builder) ? addConverterFactory.build() : Retrofit2Instrumentation.build(addConverterFactory);
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            retrofit = build;
        }
        Map map = retrofitMap;
        Retrofit retrofit2 = retrofit;
        if (retrofit2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retrofit");
            retrofit2 = null;
        }
        map.put(str, retrofit2);
        Retrofit retrofit3 = retrofit;
        if (retrofit3 != null) {
            return retrofit3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        return null;
    }

    private final Retrofit getRetrofit(String str) {
        Retrofit retrofit2;
        HashMap<String, Retrofit> hashMap = retrofitMap;
        if (hashMap.containsKey(str)) {
            Retrofit retrofit3 = hashMap.get(str);
            Intrinsics.checkNotNull(retrofit3);
            Intrinsics.checkNotNullExpressionValue(retrofit3, "{\n            retrofitMap[baseUrl]!!\n        }");
            retrofit2 = retrofit3;
        } else {
            retrofit2 = createRetrofit(str);
        }
        retrofit = retrofit2;
        if (retrofit2 != null) {
            return retrofit2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("retrofit");
        return null;
    }

    public final <T> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "service");
        return create(netConfig.baseUrl(), cls);
    }

    public final <T> T create(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(cls, "service");
        HashMap<String, Object> hashMap = serviceMap;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str + cls.getPackage() + cls.getSimpleName());
        }
        T create = getRetrofit(str).create(cls);
        Objects.requireNonNull(create, "null cannot be cast to non-null type kotlin.Any");
        hashMap.put(str + cls.getPackage() + cls.getSimpleName(), create);
        return create;
    }
}
