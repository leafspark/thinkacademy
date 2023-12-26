package com.tal.app.thinkacademy.lib.imageloader.http;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/SSLSocketClient;", "", "()V", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "sSLSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getSSLSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "getTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "trustManagers", "", "Ljavax/net/ssl/TrustManager;", "getTrustManagers", "()[Ljavax/net/ssl/TrustManager;", "MyTrustManager", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSLSocketClient.kt */
public final class SSLSocketClient {
    public static final SSLSocketClient INSTANCE = new SSLSocketClient();

    /* access modifiers changed from: private */
    /* renamed from: _get_hostnameVerifier_$lambda-0  reason: not valid java name */
    public static final boolean m88_get_hostnameVerifier_$lambda0(String str, SSLSession sSLSession) {
        return true;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return SSLSocketClient$$ExternalSyntheticLambda0.INSTANCE;
    }

    private SSLSocketClient() {
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init((KeyManager[]) null, getTrustManagers(), new SecureRandom());
            SSLSocketFactory socketFactory = instance.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "{\n            val sslCon…t.socketFactory\n        }");
            return socketFactory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final TrustManager[] getTrustManagers() {
        return new TrustManager[]{getTrustManager()};
    }

    public final X509TrustManager getTrustManager() {
        return new MyTrustManager();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/SSLSocketClient$MyTrustManager;", "Ljavax/net/ssl/X509TrustManager;", "()V", "checkClientTrusted", "", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SSLSocketClient.kt */
    private static final class MyTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
            Intrinsics.checkNotNullParameter(str, "authType");
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
            Intrinsics.checkNotNullParameter(str, "authType");
        }

        public X509Certificate[] getAcceptedIssuers() {
            return (X509Certificate[]) ((Object[]) new X509Certificate[0]);
        }
    }
}
