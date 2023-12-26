package com.bonree.sdk.agent.engine.network.socket.external;

import com.bonree.sdk.bc.cx;
import com.bonree.sdk.d.a;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.f;
import com.bonree.sdk.v.e;
import com.bonree.sdk.v.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;

public final class i extends OpenSSLSocketImpl implements e {
    private String a;
    private f b;

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    protected i(SSLParametersImpl sSLParametersImpl) {
        super(sSLParametersImpl);
        a((Socket) this);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    protected i(String str, int i, SSLParametersImpl sSLParametersImpl) {
        super(str, i, sSLParametersImpl);
        a((Socket) this);
        this.a = str;
        this.b.a(i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    protected i(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) {
        super(inetAddress, i, sSLParametersImpl);
        a((Socket) this);
        this.a = cx.a.a(inetAddress);
        this.b.a(i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    protected i(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) {
        super(str, i, inetAddress, i2, sSLParametersImpl);
        a((Socket) this);
        this.a = str;
        this.b.a(i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.bonree.sdk.agent.engine.network.socket.external.i, java.net.Socket] */
    protected i(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) {
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
            i.super.startHandshake();
            this.b.a(this.a, (int) (a.b() - b2));
        } catch (IOException e) {
            throw e;
        }
    }

    public final InputStream getInputStream() throws IOException {
        try {
            InputStream inputStream = i.super.getInputStream();
            if (inputStream == null) {
                return null;
            }
            if (inputStream instanceof a) {
                return inputStream;
            }
            return new a(this.b, inputStream);
        } catch (Throwable unused) {
            return i.super.getInputStream();
        }
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            OutputStream outputStream = i.super.getOutputStream();
            if (outputStream == null) {
                return null;
            }
            if (outputStream instanceof d) {
                return outputStream;
            }
            return new d(this.b, outputStream);
        } catch (IOException unused) {
            return i.super.getOutputStream();
        }
    }

    public final void a(b bVar) {
        this.b.a(bVar);
    }
}
