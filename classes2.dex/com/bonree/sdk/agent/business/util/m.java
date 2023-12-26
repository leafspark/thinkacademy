package com.bonree.sdk.agent.business.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class m implements X509TrustManager {
    private /* synthetic */ k a;

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    m(k kVar) {
        this.a = kVar;
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (k.a(this.a) && x509CertificateArr != null && x509CertificateArr.length != 0) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                x509Certificate.checkValidity();
                try {
                    x509Certificate.verify(this.a.p.getPublicKey());
                } catch (NoSuchAlgorithmException e) {
                    this.a.r.a("verify customer certificate publicKey exception", (Throwable) e);
                } catch (SignatureException e2) {
                    this.a.r.a("verify customer certificate publicKey exception", (Throwable) e2);
                } catch (NoSuchProviderException e3) {
                    this.a.r.a("verify customer certificate publicKey exception", (Throwable) e3);
                } catch (InvalidKeyException e4) {
                    this.a.r.a("verify customer certificate publicKey exception", (Throwable) e4);
                }
            }
        }
    }
}
