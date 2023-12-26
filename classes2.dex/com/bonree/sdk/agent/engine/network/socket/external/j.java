package com.bonree.sdk.agent.engine.network.socket.external;

import com.bonree.sdk.d.a;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.f;
import com.bonree.sdk.v.e;
import com.bonree.sdk.v.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImplWrapper;
import org.apache.harmony.xnet.provider.jsse.SSLParametersImpl;

public final class j extends OpenSSLSocketImplWrapper implements e {
    private String a;
    private f b;

    protected j(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i, z, sSLParametersImpl);
        f a2 = g.a(socket);
        if (a2 != null) {
            this.b = a2;
        } else {
            this.b = new f();
        }
        this.a = str;
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
            j.super.startHandshake();
            this.b.a(this.a, (int) (a.b() - b2));
        } catch (IOException e) {
            throw e;
        }
    }

    public final InputStream getInputStream() throws IOException {
        try {
            InputStream inputStream = j.super.getInputStream();
            if (inputStream == null) {
                return null;
            }
            if (inputStream instanceof a) {
                return inputStream;
            }
            return new a(this.b, inputStream);
        } catch (Throwable th) {
            com.bonree.sdk.be.g.b("bopenSSLSocketImplWrapper error:" + th);
            return j.super.getInputStream();
        }
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            OutputStream outputStream = j.super.getOutputStream();
            if (outputStream == null) {
                return null;
            }
            if (outputStream instanceof d) {
                return outputStream;
            }
            return new d(this.b, outputStream);
        } catch (Throwable th) {
            com.bonree.sdk.be.g.b("bopenSSLSocketImplWrapper error:" + th);
            return j.super.getOutputStream();
        }
    }

    public final void a(b bVar) {
        this.b.a(bVar);
    }
}
