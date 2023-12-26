package com.tal.thinkacademy.networkprobe;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Platform.kt */
final class Platform$httpClient$1 extends Lambda implements Function1<HttpClientConfig<OkHttpConfig>, Unit> {
    final /* synthetic */ NetProbeConfig $config;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Platform$httpClient$1(NetProbeConfig netProbeConfig) {
        super(1);
        this.$config = netProbeConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpClientConfig<OkHttpConfig>) (HttpClientConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HttpClientConfig<OkHttpConfig> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "$this$HttpClient");
        final NetProbeConfig netProbeConfig = this.$config;
        httpClientConfig.engine(new Function1<OkHttpConfig, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OkHttpConfig) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OkHttpConfig okHttpConfig) {
                Intrinsics.checkNotNullParameter(okHttpConfig, "$this$engine");
                final NetProbeConfig netProbeConfig = netProbeConfig;
                okHttpConfig.config(new Function1<OkHttpClient.Builder, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((OkHttpClient.Builder) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(OkHttpClient.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "$this$config");
                        builder.connectTimeout(netProbeConfig.connectTimeout(), TimeUnit.MILLISECONDS);
                        builder.callTimeout(netProbeConfig.connectTimeout(), TimeUnit.MILLISECONDS);
                        builder.eventListenerFactory(TraceEventListener.Factory);
                        builder.protocols(CollectionsKt.listOf(Protocol.HTTP_1_1));
                        SSLSocketFactory createSSLSocketFactory = TrustAllCerts.Companion.createSSLSocketFactory();
                        if (createSSLSocketFactory != null) {
                            X509TrustManager trustAllCerts = new TrustAllCerts();
                            if (!(builder instanceof OkHttpClient.Builder)) {
                                builder.sslSocketFactory(createSSLSocketFactory, trustAllCerts);
                            } else {
                                OkHttp3Instrumentation.sslSocketFactory(builder, createSSLSocketFactory, trustAllCerts);
                            }
                        }
                    }
                });
            }
        });
    }
}
