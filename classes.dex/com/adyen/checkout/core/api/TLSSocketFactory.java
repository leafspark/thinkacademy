package com.adyen.checkout.core.api;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

class TLSSocketFactory extends SSLSocketFactory {
    private final String[] mEnabledProtocols = {"TLSv1.2"};
    private final SSLSocketFactory mInternalSslSocketFactory;

    TLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.mInternalSslSocketFactory = instance.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.mInternalSslSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.mInternalSslSocketFactory.getSupportedCipherSuites();
    }

    public Socket createSocket() throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket());
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return enableTlsOnSocket(this.mInternalSslSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket enableTlsOnSocket(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(this.mEnabledProtocols);
        }
        return socket;
    }
}
