package com.tal.app.thinkacademy.common.network.config;

import com.tal.app.thinkacademy.common.network.interceptor.CommonHeaderInterceptor;
import com.tal.app.thinkacademy.common.network.interceptor.CustomCacheInterceptor;
import com.tal.app.thinkacademy.common.network.interceptor.RetryInterceptor;
import com.tal.app.thinkacademy.common.network.interceptor.SignInterceptor;
import com.tal.app.thinkacademy.lib.network.config.INetConfig;
import com.tal.app.thinkacademy.lib.network.tls.SSLState;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/config/HWNetConfig;", "Lcom/tal/app/thinkacademy/lib/network/config/INetConfig;", "()V", "baseUrl", "", "interceptor", "", "Lokhttp3/Interceptor;", "networkInterceptor", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HWNetConfig.kt */
public final class HWNetConfig implements INetConfig {
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

    public List<Interceptor> interceptor() {
        List<Interceptor> arrayList = new ArrayList<>();
        arrayList.add(new CommonHeaderInterceptor());
        arrayList.add(new SignInterceptor());
        arrayList.add(new RetryInterceptor());
        arrayList.add(new CustomCacheInterceptor());
        return arrayList;
    }

    public List<Interceptor> networkInterceptor() {
        return INetConfig.DefaultImpls.networkInterceptor(this);
    }
}
