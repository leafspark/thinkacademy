package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.tal.app.thinkacademy.lib.network.tls.AllHostnameVerifier;
import com.tal.app.thinkacademy.lib.network.tls.TrustAllCerts;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressManager;", "", "()V", "LISTENER", "com/tal/app/thinkacademy/lib/imageloader/progress/ProgressManager$LISTENER$1", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressManager$LISTENER$1;", "listenersMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;", "okHttpClient", "Lokhttp3/Call$Factory;", "getOkHttpClient", "()Lokhttp3/Call$Factory;", "setOkHttpClient", "(Lokhttp3/Call$Factory;)V", "addListener", "", "url", "listener", "getProgressListener", "removeListener", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressManager.kt */
public final class ProgressManager {
    public static final ProgressManager INSTANCE = new ProgressManager();
    /* access modifiers changed from: private */
    public static final ProgressManager$LISTENER$1 LISTENER = new ProgressManager$LISTENER$1();
    private static final ConcurrentHashMap<String, OnProgressListener> listenersMap = new ConcurrentHashMap<>();
    private static Call.Factory okHttpClient;

    private ProgressManager() {
    }

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory createSSLSocketFactory = TrustAllCerts.Companion.createSSLSocketFactory();
        Intrinsics.checkNotNull(createSSLSocketFactory);
        X509TrustManager trustAllCerts = new TrustAllCerts();
        OkHttpClient.Builder addNetworkInterceptor = (!(builder instanceof OkHttpClient.Builder) ? builder.sslSocketFactory(createSSLSocketFactory, trustAllCerts) : OkHttp3Instrumentation.sslSocketFactory(builder, createSSLSocketFactory, trustAllCerts)).hostnameVerifier(new AllHostnameVerifier()).addNetworkInterceptor(new ProgressManager$special$$inlined$addNetworkInterceptor$1());
        okHttpClient = (Call.Factory) (!(addNetworkInterceptor instanceof OkHttpClient.Builder) ? addNetworkInterceptor.build() : OkHttp3Instrumentation.builderInit(addNetworkInterceptor));
    }

    public final Call.Factory getOkHttpClient() {
        return okHttpClient;
    }

    public final void setOkHttpClient(Call.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        okHttpClient = factory;
    }

    public final void addListener(String str, OnProgressListener onProgressListener) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!TextUtils.isEmpty(str) && onProgressListener != null) {
            listenersMap.put(str, onProgressListener);
            onProgressListener.onProgress(false, 1, 0, 0);
        }
    }

    public final void removeListener(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!TextUtils.isEmpty(str)) {
            listenersMap.remove(str);
        }
    }

    public final OnProgressListener getProgressListener(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, OnProgressListener> concurrentHashMap = listenersMap;
            if (concurrentHashMap.size() != 0) {
                return concurrentHashMap.get(str);
            }
        }
        return null;
    }
}
