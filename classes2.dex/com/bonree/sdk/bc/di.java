package com.bonree.sdk.bc;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.security.SecureRandom;

final class di extends e {
    private static final int c = 1024;
    private static final int d = 65535;
    private static final int e = 64511;
    /* access modifiers changed from: private */
    public static SecureRandom f = new SecureRandom();
    /* access modifiers changed from: private */
    public static volatile boolean g = true;
    private boolean h = false;

    static {
        new Thread(new dj()).start();
    }

    private di(long j) throws IOException {
        super(DatagramChannel.open(), j);
    }

    private void a(InetSocketAddress inetSocketAddress) throws IOException {
        InetSocketAddress inetSocketAddress2;
        if (g) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException unused) {
            }
            if (g) {
                return;
            }
        }
        DatagramChannel datagramChannel = (DatagramChannel) this.b.channel();
        int i = 0;
        while (i < 1024) {
            try {
                int nextInt = f.nextInt(e) + 1024;
                if (inetSocketAddress != null) {
                    inetSocketAddress2 = new InetSocketAddress(inetSocketAddress.getAddress(), nextInt);
                } else {
                    inetSocketAddress2 = new InetSocketAddress(nextInt);
                }
                datagramChannel.socket().bind(inetSocketAddress2);
                this.h = true;
                return;
            } catch (SocketException unused2) {
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (g == false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.net.SocketAddress r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 1
            if (r8 == 0) goto L_0x0010
            boolean r1 = r8 instanceof java.net.InetSocketAddress
            if (r1 == 0) goto L_0x005a
            r1 = r8
            java.net.InetSocketAddress r1 = (java.net.InetSocketAddress) r1
            int r1 = r1.getPort()
            if (r1 != 0) goto L_0x005a
        L_0x0010:
            r1 = r8
            java.net.InetSocketAddress r1 = (java.net.InetSocketAddress) r1
            boolean r2 = g
            if (r2 == 0) goto L_0x0020
            r2 = 2
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x001c }
        L_0x001c:
            boolean r2 = g
            if (r2 != 0) goto L_0x0055
        L_0x0020:
            java.nio.channels.SelectionKey r2 = r7.b
            java.nio.channels.SelectableChannel r2 = r2.channel()
            java.nio.channels.DatagramChannel r2 = (java.nio.channels.DatagramChannel) r2
            r3 = 0
        L_0x0029:
            r4 = 1024(0x400, float:1.435E-42)
            if (r3 >= r4) goto L_0x0055
            java.security.SecureRandom r5 = f     // Catch:{ SocketException -> 0x0052 }
            r6 = 64511(0xfbff, float:9.0399E-41)
            int r5 = r5.nextInt(r6)     // Catch:{ SocketException -> 0x0052 }
            int r5 = r5 + r4
            if (r1 == 0) goto L_0x0043
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ SocketException -> 0x0052 }
            java.net.InetAddress r6 = r1.getAddress()     // Catch:{ SocketException -> 0x0052 }
            r4.<init>(r6, r5)     // Catch:{ SocketException -> 0x0052 }
            goto L_0x0048
        L_0x0043:
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ SocketException -> 0x0052 }
            r4.<init>(r5)     // Catch:{ SocketException -> 0x0052 }
        L_0x0048:
            java.net.DatagramSocket r5 = r2.socket()     // Catch:{ SocketException -> 0x0052 }
            r5.bind(r4)     // Catch:{ SocketException -> 0x0052 }
            r7.h = r0     // Catch:{ SocketException -> 0x0052 }
            goto L_0x0055
        L_0x0052:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x0055:
            boolean r1 = r7.h
            if (r1 == 0) goto L_0x005a
            return
        L_0x005a:
            if (r8 == 0) goto L_0x006d
            java.nio.channels.SelectionKey r1 = r7.b
            java.nio.channels.SelectableChannel r1 = r1.channel()
            java.nio.channels.DatagramChannel r1 = (java.nio.channels.DatagramChannel) r1
            java.net.DatagramSocket r1 = r1.socket()
            r1.bind(r8)
            r7.h = r0
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.di.a(java.net.SocketAddress):void");
    }

    private void b(SocketAddress socketAddress) throws IOException {
        if (!this.h) {
            a((SocketAddress) null);
        }
        ((DatagramChannel) this.b.channel()).connect(socketAddress);
    }

    private void a(byte[] bArr) throws IOException {
        DatagramChannel datagramChannel = (DatagramChannel) this.b.channel();
        a("UDP write", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
        datagramChannel.write(ByteBuffer.wrap(bArr));
    }

    private byte[] a(int i) throws IOException {
        DatagramChannel datagramChannel = (DatagramChannel) this.b.channel();
        byte[] bArr = new byte[i];
        this.b.interestOps(1);
        while (!this.b.isReadable()) {
            try {
                a(this.b, this.a);
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
        long read = (long) datagramChannel.read(ByteBuffer.wrap(bArr));
        if (read > 0) {
            int i2 = (int) read;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            a("UDP read", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr2);
            return bArr2;
        }
        throw new EOFException();
    }

    static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, int i, long j) throws IOException {
        di diVar = new di(j);
        try {
            diVar.a(socketAddress);
            if (!diVar.h) {
                diVar.a((SocketAddress) null);
            }
            ((DatagramChannel) diVar.b.channel()).connect(socketAddress2);
            DatagramChannel datagramChannel = (DatagramChannel) diVar.b.channel();
            a("UDP write", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
            datagramChannel.write(ByteBuffer.wrap(bArr));
            return diVar.a(i);
        } finally {
            diVar.a();
        }
    }

    private static byte[] a(SocketAddress socketAddress, byte[] bArr, int i, long j) throws IOException {
        return a((SocketAddress) null, socketAddress, bArr, i, j);
    }
}
