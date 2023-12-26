package com.tal.app.thinkacademy.lib.download.util;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.tal.app.thinkacademy.lib.download.interceptor.NetInterceptor;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHelper {
    private static final long CONNECT_TIMEOUT = 30;
    private static final long READ_TIMEOUT = 60;
    private static final long WRITE_TIMEOUT = 60;
    private static HttpHelper mInstance;
    private OkHttpClient mOkHttpClient;
    private SSLSocketFactory sslSocketFactory = createSSLSocketFactory();
    private X509TrustManager trustManager;

    public Call downloadFileByRange(String str, long j, long j2, Callback callback) throws IOException {
        Request.Builder builder = new Request.Builder();
        return doAsync(builder.header("RANGE", "bytes=" + j + "-" + j2).url(str).build(), callback);
    }

    public Call downloadFileByUrl(String str, Callback callback) throws IOException {
        return doAsync(new Request.Builder().url(str).build(), callback);
    }

    private Call doAsync(Request request, Callback callback) throws IOException {
        OkHttpClient okHttpClient = this.mOkHttpClient;
        Call newCall = !(okHttpClient instanceof OkHttpClient) ? okHttpClient.newCall(request) : OkHttp3Instrumentation.newCall(okHttpClient, request);
        newCall.enqueue(callback);
        return newCall;
    }

    private Response doSync(Request request) throws IOException {
        OkHttpClient okHttpClient = this.mOkHttpClient;
        return (!(okHttpClient instanceof OkHttpClient) ? okHttpClient.newCall(request) : OkHttp3Instrumentation.newCall(okHttpClient, request)).execute();
    }

    public static HttpHelper getInstance() {
        if (mInstance == null) {
            synchronized (HttpHelper.class) {
                if (mInstance == null) {
                    mInstance = new HttpHelper();
                }
            }
        }
        return mInstance;
    }

    private HttpHelper() {
        OkHttpClient.Builder readTimeout = new OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS);
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        X509TrustManager x509TrustManager = this.trustManager;
        boolean z = readTimeout instanceof OkHttpClient.Builder;
        if (!z) {
            readTimeout.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        } else {
            OkHttp3Instrumentation.sslSocketFactory(readTimeout, sSLSocketFactory, x509TrustManager);
        }
        readTimeout.addInterceptor(new NetInterceptor());
        readTimeout.connectionPool(new ConnectionPool(32, 5, TimeUnit.MINUTES));
        Dns dns = DownloadEngine.getInstance().getDns();
        if (dns != null) {
            readTimeout.dns(dns);
        }
        readTimeout.retryOnConnectionFailure(true);
        this.mOkHttpClient = !z ? readTimeout.build() : OkHttp3Instrumentation.builderInit(readTimeout);
    }

    private SSLSocketFactory createSSLSocketFactory() {
        try {
            this.trustManager = new MyTrustManager();
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{this.trustManager}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public class MyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public MyTrustManager() {
        }
    }
}
