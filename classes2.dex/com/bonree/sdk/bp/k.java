package com.bonree.sdk.bp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class k<IA extends InetAddress> extends h {
    protected final byte[] a;
    private transient IA b;

    protected k(byte[] bArr) {
        this.a = bArr;
    }

    protected k(IA ia) {
        this(ia.getAddress());
        this.b = ia;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.a);
    }

    private byte[] d() {
        return (byte[]) this.a.clone();
    }

    private IA e() {
        if (this.b == null) {
            try {
                this.b = InetAddress.getByAddress(this.a);
            } catch (UnknownHostException e) {
                throw new IllegalStateException(e);
            }
        }
        return this.b;
    }

    private static k<? extends InetAddress> a(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return new a((Inet4Address) inetAddress);
        }
        return new b((Inet6Address) inetAddress);
    }
}
