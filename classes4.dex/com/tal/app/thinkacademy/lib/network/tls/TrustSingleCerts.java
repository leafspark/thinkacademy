package com.tal.app.thinkacademy.lib.network.tls;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/tls/TrustSingleCerts;", "Ljavax/net/ssl/X509TrustManager;", "()V", "checkClientTrusted", "", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrustSingleCerts.kt */
public final class TrustSingleCerts implements X509TrustManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/tls/TrustSingleCerts$Companion;", "", "()V", "createSSLSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "certificates", "", "Ljava/io/InputStream;", "([Ljava/io/InputStream;)Ljavax/net/ssl/SSLSocketFactory;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TrustSingleCerts.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SSLSocketFactory createSSLSocketFactory(InputStream... inputStreamArr) {
            Intrinsics.checkNotNullParameter(inputStreamArr, "certificates");
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load((KeyStore.LoadStoreParameter) null);
                int length = inputStreamArr.length;
                for (int i = 0; i < length; i++) {
                    InputStream inputStream = inputStreamArr[i];
                    instance2.setCertificateEntry(String.valueOf(i), instance.generateCertificate(inputStream));
                    inputStream.close();
                }
                SSLContext instance3 = SSLContext.getInstance("TLS");
                TrustManagerFactory instance4 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance4.init(instance2);
                instance3.init((KeyManager[]) null, instance4.getTrustManagers(), new SecureRandom());
                return instance3.getSocketFactory();
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return (X509Certificate[]) ((Object[]) new X509Certificate[0]);
    }
}
