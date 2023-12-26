package com.tal.app.thinkacademy.lib.network.config;

import com.tal.app.thinkacademy.lib.network.tls.AllHostnameVerifier;
import com.tal.app.thinkacademy.lib.network.tls.SSLState;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/config/INetConfig;", "", "baseUrl", "", "callTimeout", "", "clientCer", "connectTimeout", "converterFactory", "Lretrofit2/Converter$Factory;", "dns", "Lokhttp3/Dns;", "eventListener", "Lokhttp3/EventListener;", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "interceptor", "", "Lokhttp3/Interceptor;", "networkInterceptor", "readTimeout", "retryOnConnectionFailure", "", "serverCer", "sslState", "Lcom/tal/app/thinkacademy/lib/network/tls/SSLState;", "writeTimeout", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: INetConfig.kt */
public interface INetConfig {
    String baseUrl();

    long callTimeout();

    String clientCer();

    long connectTimeout();

    Converter.Factory converterFactory();

    Dns dns();

    EventListener eventListener();

    HostnameVerifier hostnameVerifier();

    List<Interceptor> interceptor();

    List<Interceptor> networkInterceptor();

    long readTimeout();

    boolean retryOnConnectionFailure();

    String serverCer();

    SSLState sslState();

    long writeTimeout();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: INetConfig.kt */
    public static final class DefaultImpls {
        public static long callTimeout(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return 30;
        }

        public static String clientCer(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return null;
        }

        public static long connectTimeout(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return 5;
        }

        public static EventListener eventListener(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return null;
        }

        public static long readTimeout(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return 10;
        }

        public static boolean retryOnConnectionFailure(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return true;
        }

        public static String serverCer(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return null;
        }

        public static long writeTimeout(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return 10;
        }

        public static Dns dns(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return Dns.SYSTEM;
        }

        public static SSLState sslState(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return SSLState.ALL;
        }

        public static List<Interceptor> interceptor(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return new ArrayList<>();
        }

        public static List<Interceptor> networkInterceptor(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return new ArrayList<>();
        }

        public static HostnameVerifier hostnameVerifier(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            return new AllHostnameVerifier();
        }

        public static Converter.Factory converterFactory(INetConfig iNetConfig) {
            Intrinsics.checkNotNullParameter(iNetConfig, "this");
            Converter.Factory create = GsonConverterFactory.create();
            Intrinsics.checkNotNullExpressionValue(create, "create()");
            return create;
        }
    }
}
