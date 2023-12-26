package com.bonree.sdk.agent.engine.network.socket.external;

import com.android.org.conscrypt.OpenSSLSocketImpl;
import com.android.org.conscrypt.SSLParametersImpl;
import com.bonree.sdk.bc.cx;
import com.bonree.sdk.d.a;
import com.bonree.sdk.n.f;
import com.bonree.sdk.v.e;
import com.bonree.sdk.v.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public final class b extends OpenSSLSocketImpl implements e {
    private String a;
    private f b;

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    protected b(SSLParametersImpl sSLParametersImpl) {
        super(sSLParametersImpl);
        a((Socket) this);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    protected b(String str, int i, SSLParametersImpl sSLParametersImpl) {
        super(str, i, sSLParametersImpl);
        a((Socket) this);
        this.a = str;
        this.b.a(i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    protected b(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, sSLParametersImpl);
        a((Socket) this);
        this.a = cx.a.a(inetAddress);
        this.b.a(i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    protected b(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) {
        super(str, i, inetAddress, i2, sSLParametersImpl);
        a((Socket) this);
        this.a = str;
        this.b.a(i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.Socket, com.bonree.sdk.agent.engine.network.socket.external.b] */
    protected b(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
        a((Socket) this);
        this.a = cx.a.a(inetAddress);
        this.b.a(i);
    }

    private void a(Socket socket) {
        f a2 = g.a(socket);
        if (a2 != null) {
            this.b = a2;
        } else {
            this.b = new f();
        }
    }

    public final void startHandshake() throws IOException {
        try {
            long b2 = a.b();
            b.super.startHandshake();
            this.b.a(this.a, (int) (a.b() - b2));
        } catch (IOException e) {
            throw e;
        }
    }

    public final InputStream getInputStream() throws IOException {
        try {
            InputStream inputStream = b.super.getInputStream();
            if (inputStream == null) {
                return null;
            }
            if (inputStream instanceof a) {
                return inputStream;
            }
            return new a(this.b, inputStream);
        } catch (Throwable unused) {
            return b.super.getInputStream();
        }
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            OutputStream outputStream = b.super.getOutputStream();
            if (outputStream == null) {
                return null;
            }
            if (outputStream instanceof d) {
                return outputStream;
            }
            return new d(this.b, outputStream);
        } catch (IOException unused) {
            return b.super.getOutputStream();
        }
    }

    public final void a(com.bonree.sdk.n.b bVar) {
        this.b.a(bVar);
    }
}
