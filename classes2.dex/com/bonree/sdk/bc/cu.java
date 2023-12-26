package com.bonree.sdk.bc;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

final class cu extends e {
    public cu(long j) throws IOException {
        super(SocketChannel.open(), j);
    }

    /* access modifiers changed from: package-private */
    public final void a(SocketAddress socketAddress) throws IOException {
        ((SocketChannel) this.b.channel()).socket().bind(socketAddress);
    }

    /* access modifiers changed from: package-private */
    public final void b(SocketAddress socketAddress) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        if (!socketChannel.connect(socketAddress)) {
            this.b.interestOps(8);
            while (!socketChannel.finishConnect()) {
                try {
                    if (!this.b.isConnectable()) {
                        a(this.b, this.a);
                    }
                } finally {
                    if (this.b.isValid()) {
                        this.b.interestOps(0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        a("TCP write", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), bArr);
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) bArr.length}), ByteBuffer.wrap(bArr)};
        this.b.interestOps(4);
        int i = 0;
        while (i < bArr.length + 2) {
            try {
                if (this.b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write >= 0) {
                        i += (int) write;
                        if (i >= bArr.length + 2) {
                            continue;
                        } else if (System.currentTimeMillis() > this.a) {
                            throw new SocketTimeoutException();
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    a(this.b, this.a);
                }
            } finally {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
            }
        }
    }

    private byte[] a(int i) throws IOException {
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        byte[] bArr = new byte[i];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b.interestOps(1);
        int i2 = 0;
        while (i2 < i) {
            try {
                if (this.b.isReadable()) {
                    long read = (long) socketChannel.read(wrap);
                    if (read >= 0) {
                        i2 += (int) read;
                        if (i2 >= i) {
                            continue;
                        } else if (System.currentTimeMillis() > this.a) {
                            throw new SocketTimeoutException();
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    a(this.b, this.a);
                }
            } catch (Throwable th) {
                if (this.b.isValid()) {
                    this.b.interestOps(0);
                }
                throw th;
            }
        }
        if (this.b.isValid()) {
            this.b.interestOps(0);
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final byte[] b() throws IOException {
        byte[] a = a(2);
        byte[] a2 = a(((a[0] & 255) << 8) + (a[1] & 255));
        SocketChannel socketChannel = (SocketChannel) this.b.channel();
        a("TCP read", socketChannel.socket().getLocalSocketAddress(), socketChannel.socket().getRemoteSocketAddress(), a2);
        return a2;
    }

    static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) throws IOException {
        cu cuVar = new cu(j);
        if (socketAddress != null) {
            try {
                cuVar.a(socketAddress);
            } catch (Throwable th) {
                cuVar.a();
                throw th;
            }
        }
        cuVar.b(socketAddress2);
        cuVar.a(bArr);
        byte[] b = cuVar.b();
        cuVar.a();
        return b;
    }

    private static byte[] a(SocketAddress socketAddress, byte[] bArr, long j) throws IOException {
        return a((SocketAddress) null, socketAddress, bArr, j);
    }
}
