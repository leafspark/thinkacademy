package com.adyen.checkout.core.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class SSLSocketUtil {
    public static final SSLSocketFactory TLS_SOCKET_FACTORY;

    static {
        try {
            TLS_SOCKET_FACTORY = getTLSSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not initialize SSLSocketFactory.", e);
        }
    }

    private static SSLSocketFactory getTLSSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        return instance.getSocketFactory();
    }

    private SSLSocketUtil() {
        throw new AssertionError("private constructor");
    }
}
