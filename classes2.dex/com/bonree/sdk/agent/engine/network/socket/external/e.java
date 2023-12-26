package com.bonree.sdk.agent.engine.network.socket.external;

import android.text.TextUtils;
import com.bonree.sdk.bc.cx;
import com.bonree.sdk.be.g;
import com.bonree.sdk.d.a;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.f;
import com.bonree.sdk.v.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainSocketImpl;
import java.net.SocketAddress;

public final class e extends PlainSocketImpl implements d {
    private f a = new f();

    public final void connect(String str, int i) throws IOException {
        a(str, i, "");
        try {
            this.a.b(a.b());
            e.super.connect(str, i);
            this.a.c(a.b());
        } catch (IOException e) {
            this.a.a((Throwable) e);
            throw e;
        }
    }

    public final void connect(InetAddress inetAddress, int i) throws IOException {
        a(cx.a.a(inetAddress), i, cx.a.a((Serializable) inetAddress, i));
        try {
            this.a.b(a.b());
            e.super.connect(inetAddress, i);
            this.a.c(a.b());
        } catch (IOException e) {
            this.a.a((Throwable) e);
            throw e;
        }
    }

    public final void connect(SocketAddress socketAddress, int i) throws IOException {
        int b = cx.a.b(socketAddress);
        String a2 = cx.a.a(socketAddress);
        if (TextUtils.isEmpty(a2) && (socketAddress instanceof InetSocketAddress)) {
            a2 = ((InetSocketAddress) socketAddress).getHostName();
        }
        a(a2, b, cx.a.a((Serializable) socketAddress, b));
        try {
            this.a.b(a.b());
            e.super.connect(socketAddress, i);
            this.a.c(a.b());
        } catch (IOException e) {
            this.a.a((Throwable) e);
            throw e;
        }
    }

    private void a(String str, int i, String str2) {
        this.a.b(str);
        this.a.a(i);
        this.a.a(str2);
        this.a.d(Thread.currentThread().getId());
        this.a.c(Thread.currentThread().getName());
        g.a("connect:" + str + "      port:" + i + "      ip:" + str2 + "  id:" + this.a.l() + "  threadName:" + this.a.m(), new Object[0]);
    }

    public final InputStream getInputStream() throws IOException {
        try {
            InputStream inputStream = e.super.getInputStream();
            if (inputStream == null) {
                return null;
            }
            if (inputStream instanceof a) {
                return inputStream;
            }
            return new a(this.a, inputStream);
        } catch (Throwable unused) {
            return e.super.getInputStream();
        }
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            OutputStream outputStream = e.super.getOutputStream();
            if (outputStream == null) {
                return null;
            }
            if (outputStream instanceof d) {
                return outputStream;
            }
            return new d(this.a, outputStream);
        } catch (Throwable unused) {
            return e.super.getOutputStream();
        }
    }

    public final void a(b bVar) {
        this.a.a(bVar);
    }

    public final f a() {
        return this.a;
    }
}
