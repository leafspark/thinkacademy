package com.bonree.sdk.agent.engine.network.socket.external;

import com.bonree.sdk.bs.z;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;

public final class BrSSLSocketFactoryBeforeV14 extends SSLSocketFactory {
    private static boolean a = false;
    private static SSLSocketFactory context;
    private static SSLParametersImpl parameters;
    private SSLSocketFactory delegate;
    private SSLParametersImpl sslParameters;

    public BrSSLSocketFactoryBeforeV14(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
        this.sslParameters = a(sSLSocketFactory);
    }

    private static SSLParametersImpl a(SSLSocketFactory sSLSocketFactory) {
        SSLParametersImpl sSLParametersImpl;
        try {
            sSLParametersImpl = (SSLParametersImpl) z.b(z.a((Class) sSLSocketFactory.getClass(), SSLParametersImpl.class, false), (Object) sSLSocketFactory);
        } catch (Throwable unused) {
            sSLParametersImpl = null;
        }
        if (sSLParametersImpl == null) {
            sSLParametersImpl = b();
        }
        parameters = sSLParametersImpl;
        return sSLParametersImpl;
    }

    private static SSLParametersImpl b() {
        try {
            Method declaredMethod = SSLParametersImpl.class.getDeclaredMethod("getDefault", new Class[0]);
            declaredMethod.setAccessible(true);
            return (SSLParametersImpl) declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|6|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() {
        /*
            boolean r0 = a
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            javax.net.ssl.SSLSocketFactory r0 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory()
            com.bonree.sdk.agent.engine.network.socket.external.BrSSLSocketFactoryBeforeV14 r1 = new com.bonree.sdk.agent.engine.network.socket.external.BrSSLSocketFactoryBeforeV14     // Catch:{ ThreadDeath -> 0x0024, all -> 0x0022 }
            r1.<init>(r0)     // Catch:{ ThreadDeath -> 0x0024, all -> 0x0022 }
            r2 = 1
            java.net.Socket r3 = r1.createSocket()     // Catch:{ SocketException -> 0x001a }
            java.lang.String r4 = "localhost"
            r5 = 6895(0x1aef, float:9.662E-42)
            r1.createSocket((java.net.Socket) r3, (java.lang.String) r4, (int) r5, (boolean) r2)     // Catch:{ SocketException -> 0x001a }
        L_0x001a:
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r1)     // Catch:{ ThreadDeath -> 0x0024, all -> 0x0022 }
            context = r0     // Catch:{ ThreadDeath -> 0x0024, all -> 0x0022 }
            a = r2     // Catch:{ ThreadDeath -> 0x0024, all -> 0x0022 }
            return r2
        L_0x0022:
            r0 = 0
            return r0
        L_0x0024:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.network.socket.external.BrSSLSocketFactoryBeforeV14.a():boolean");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    public final Socket createSocket() {
        return new i(a(this.sslParameters));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    public final Socket createSocket(String str, int i) throws IOException {
        return new i(str, i, a(this.sslParameters));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return new i(str, i, inetAddress, i2, a(this.sslParameters));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return new i(inetAddress, i, a(this.sslParameters));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return new i(inetAddress, i, inetAddress2, i2, a(this.sslParameters));
    }

    private static SSLParametersImpl a(SSLParametersImpl sSLParametersImpl) {
        try {
            Method declaredMethod = SSLParametersImpl.class.getDeclaredMethod("clone", new Class[0]);
            declaredMethod.setAccessible(true);
            return (SSLParametersImpl) declaredMethod.invoke(sSLParametersImpl, new Object[0]);
        } catch (Throwable unused) {
            return parameters;
        }
    }

    public final String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return new j(socket, str, i, z, a(this.sslParameters));
    }
}
