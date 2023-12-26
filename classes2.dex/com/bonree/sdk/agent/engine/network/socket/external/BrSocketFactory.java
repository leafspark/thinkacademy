package com.bonree.sdk.agent.engine.network.socket.external;

import com.android.org.conscrypt.SSLParametersImpl;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.z;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

public final class BrSocketFactory extends SSLSocketFactory {
    private static final f a = a.a();
    private static boolean b = false;
    private static SSLParametersImpl parameters;
    private static SSLSocketFactory sslSocketFactory;
    private SSLSocketFactory delegate;
    private SSLParametersImpl sslParameters;

    public BrSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
        this.sslParameters = a(sSLSocketFactory);
    }

    private static SSLParametersImpl a(SSLSocketFactory sSLSocketFactory) {
        SSLParametersImpl sSLParametersImpl;
        try {
            sSLParametersImpl = (SSLParametersImpl) z.b(z.a((Class) sSLSocketFactory.getClass(), SSLParametersImpl.class, false), (Object) sSLSocketFactory);
        } catch (Throwable th) {
            f fVar = a;
            fVar.e("getSSLParmetersImpl:" + th, new Object[0]);
            sSLParametersImpl = null;
        }
        if (sSLParametersImpl == null) {
            sSLParametersImpl = b();
        }
        parameters = sSLParametersImpl;
        f fVar2 = a;
        fVar2.c("SSLParametersImpl success:" + parameters, new Object[0]);
        return sSLParametersImpl;
    }

    private static SSLParametersImpl b() {
        try {
            Method declaredMethod = SSLParametersImpl.class.getDeclaredMethod("getDefault", new Class[0]);
            declaredMethod.setAccessible(true);
            return (SSLParametersImpl) declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable th) {
            f fVar = a;
            fVar.e("getSSLParametersImplDefault:" + th, new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() throws java.lang.ThreadDeath {
        /*
            boolean r0 = b
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            javax.net.ssl.SSLSocketFactory r0 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory()
            com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory r2 = new com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory     // Catch:{ ThreadDeath -> 0x0031, all -> 0x0022 }
            r2.<init>(r0)     // Catch:{ ThreadDeath -> 0x0031, all -> 0x0022 }
            java.net.Socket r3 = r2.createSocket()     // Catch:{ SocketException -> 0x001a }
            java.lang.String r4 = "localhost"
            r5 = 7876(0x1ec4, float:1.1037E-41)
            r2.createSocket((java.net.Socket) r3, (java.lang.String) r4, (int) r5, (boolean) r1)     // Catch:{ SocketException -> 0x001a }
        L_0x001a:
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r2)     // Catch:{ ThreadDeath -> 0x0031, all -> 0x0022 }
            sslSocketFactory = r0     // Catch:{ ThreadDeath -> 0x0031, all -> 0x0022 }
            b = r1     // Catch:{ ThreadDeath -> 0x0031, all -> 0x0022 }
            return r1
        L_0x0022:
            com.bonree.sdk.be.f r0 = a
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "localThrowable: "
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "brsocket"
            r0.e(r2, r1)
            return r3
        L_0x0031:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory.a():boolean");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    public final Socket createSocket() {
        return new b(a(this.sslParameters));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    public final Socket createSocket(String str, int i) {
        return new b(str, i, a(this.sslParameters));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return new b(str, i, inetAddress, i2, a(this.sslParameters));
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return new b(inetAddress, i, a(this.sslParameters));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return new b(inetAddress, i, inetAddress2, i2, a(this.sslParameters));
    }

    private static SSLParametersImpl a(SSLParametersImpl sSLParametersImpl) {
        try {
            Method declaredMethod = SSLParametersImpl.class.getDeclaredMethod("clone", new Class[0]);
            declaredMethod.setAccessible(true);
            return (SSLParametersImpl) declaredMethod.invoke(sSLParametersImpl, new Object[0]);
        } catch (Throwable th) {
            f fVar = a;
            fVar.e("getSSLParmetersImpl:" + th, new Object[0]);
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
        return new c(socket, str, i, z, a(this.sslParameters));
    }
}
