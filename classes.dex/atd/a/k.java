package atd.a;

import atd.s0.a;
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

final class k extends SSLSocketFactory {
    private final SSLSocketFactory a;
    private final String[] b = {a.a(-101402841770560L)};

    k() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance(a.a(-101385661901376L));
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.a = instance.getSocketFactory();
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(this.b);
        }
        return socket;
    }

    public Socket createSocket() throws IOException {
        return a(this.a.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return a(this.a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a(this.a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.a.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
