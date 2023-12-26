package com.tal.app.thinkacademy.lib.network.config;

import com.tal.app.thinkacademy.lib.network.config.INetConfig;
import com.tal.app.thinkacademy.lib.network.tls.SSLState;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/config/DefaultNetConfig;", "Lcom/tal/app/thinkacademy/lib/network/config/INetConfig;", "()V", "baseUrl", "", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultNetConfig.kt */
public final class DefaultNetConfig implements INetConfig {
    public String baseUrl() {
        return "https://oversea-api.thethinkacademy.com/";
    }

    public long callTimeout() {
        return INetConfig.DefaultImpls.callTimeout(this);
    }

    public String clientCer() {
        return INetConfig.DefaultImpls.clientCer(this);
    }

    public long connectTimeout() {
        return INetConfig.DefaultImpls.connectTimeout(this);
    }

    public Converter.Factory converterFactory() {
        return INetConfig.DefaultImpls.converterFactory(this);
    }

    public Dns dns() {
        return INetConfig.DefaultImpls.dns(this);
    }

    public EventListener eventListener() {
        return INetConfig.DefaultImpls.eventListener(this);
    }

    public HostnameVerifier hostnameVerifier() {
        return INetConfig.DefaultImpls.hostnameVerifier(this);
    }

    public List<Interceptor> interceptor() {
        return INetConfig.DefaultImpls.interceptor(this);
    }

    public List<Interceptor> networkInterceptor() {
        return INetConfig.DefaultImpls.networkInterceptor(this);
    }

    public long readTimeout() {
        return INetConfig.DefaultImpls.readTimeout(this);
    }

    public boolean retryOnConnectionFailure() {
        return INetConfig.DefaultImpls.retryOnConnectionFailure(this);
    }

    public String serverCer() {
        return INetConfig.DefaultImpls.serverCer(this);
    }

    public SSLState sslState() {
        return INetConfig.DefaultImpls.sslState(this);
    }

    public long writeTimeout() {
        return INetConfig.DefaultImpls.writeTimeout(this);
    }
}
