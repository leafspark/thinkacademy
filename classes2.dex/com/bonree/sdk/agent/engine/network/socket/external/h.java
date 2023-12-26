package com.bonree.sdk.agent.engine.network.socket.external;

import android.text.TextUtils;
import com.bonree.sdk.bc.cx;
import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.f;
import com.bonree.sdk.v.a;
import com.bonree.sdk.v.d;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.util.Objects;

public final class h extends SocketImpl implements d {
    private static Field a = null;
    private static Field b = null;
    private static Field c = null;
    private static Field d = null;
    private static Method[] e = new Method[20];
    private static boolean f = false;
    private static Throwable g;
    private SocketImpl h;
    private f i = new f();

    static {
        Class<SocketImpl> cls = SocketImpl.class;
        try {
            a = cls.getDeclaredField("address");
            b = cls.getDeclaredField("fd");
            c = cls.getDeclaredField("localport");
            Field declaredField = cls.getDeclaredField("port");
            d = declaredField;
            Field field = a;
            AccessibleObject[] accessibleObjectArr = {b, c, declaredField};
            if (field != null) {
                field.setAccessible(true);
            }
            z.a(accessibleObjectArr);
            e[0] = cls.getDeclaredMethod("accept", new Class[]{SocketImpl.class});
            e[1] = cls.getDeclaredMethod("available", new Class[0]);
            e[2] = cls.getDeclaredMethod("bind", new Class[]{InetAddress.class, Integer.TYPE});
            e[3] = cls.getDeclaredMethod("close", new Class[0]);
            e[4] = cls.getDeclaredMethod("connect", new Class[]{InetAddress.class, Integer.TYPE});
            e[5] = cls.getDeclaredMethod("connect", new Class[]{SocketAddress.class, Integer.TYPE});
            e[6] = cls.getDeclaredMethod("connect", new Class[]{String.class, Integer.TYPE});
            e[7] = cls.getDeclaredMethod("create", new Class[]{Boolean.TYPE});
            e[8] = cls.getDeclaredMethod("getFileDescriptor", new Class[0]);
            e[9] = cls.getDeclaredMethod("getInetAddress", new Class[0]);
            e[10] = cls.getDeclaredMethod("getInputStream", new Class[0]);
            e[11] = cls.getDeclaredMethod("getLocalPort", new Class[0]);
            e[12] = cls.getDeclaredMethod("getOutputStream", new Class[0]);
            e[13] = cls.getDeclaredMethod("getPort", new Class[0]);
            e[14] = cls.getDeclaredMethod("listen", new Class[]{Integer.TYPE});
            e[15] = cls.getDeclaredMethod("sendUrgentData", new Class[]{Integer.TYPE});
            e[16] = cls.getDeclaredMethod("setPerformancePreferences", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE});
            e[17] = cls.getDeclaredMethod("shutdownInput", new Class[0]);
            e[18] = cls.getDeclaredMethod("shutdownOutput", new Class[0]);
            e[19] = cls.getDeclaredMethod("supportsUrgentData", new Class[0]);
            z.a(e);
            f = true;
        } catch (SecurityException e2) {
            f = false;
            g = e2;
        } catch (NoSuchMethodException e3) {
            f = false;
            g = e3;
        } catch (NoSuchFieldException e4) {
            f = false;
            g = e4;
        } catch (Throwable th) {
            f = false;
            g = th;
        }
    }

    public h(SocketImpl socketImpl) {
        Objects.requireNonNull(socketImpl, "delegate was null");
        this.h = socketImpl;
        e();
    }

    private static boolean b() {
        return f;
    }

    private static Throwable c() {
        return g;
    }

    public final f a() {
        return this.i;
    }

    private static void a(Throwable th) {
        g = th;
    }

    private void d() {
        try {
            a.set(this.h, this.address);
            b.set(this.h, this.fd);
            c.setInt(this.h, this.localport);
            d.setInt(this.h, this.port);
        } catch (IllegalAccessException | IllegalArgumentException unused) {
        }
    }

    private void e() {
        try {
            this.address = (InetAddress) a.get(this.h);
            this.fd = (FileDescriptor) b.get(this.h);
            this.localport = c.getInt(this.h);
            this.port = d.getInt(this.h);
        } catch (IllegalArgumentException e2) {
            throw new a((Throwable) e2);
        } catch (IllegalAccessException e3) {
            throw new a((Throwable) e3);
        }
    }

    private <T> T a(int i2, Object[] objArr) {
        try {
            return b(i2, objArr);
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new a(th);
        }
    }

    public final InputStream getInputStream() throws IOException {
        g.a("getInputStream :" + com.bonree.sdk.d.a.b(), new Object[0]);
        InputStream inputStream = (InputStream) c(10, new Object[0]);
        if (inputStream == null) {
            return null;
        }
        if (inputStream instanceof a) {
            return inputStream;
        }
        try {
            return new a(this.i, inputStream);
        } catch (Throwable unused) {
            return inputStream;
        }
    }

    private Object c(int i2, Object[] objArr) throws IOException {
        try {
            return b(i2, objArr);
        } catch (IOException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Throwable th) {
            throw new a(th);
        }
    }

    public final OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = (OutputStream) c(12, new Object[0]);
        if (outputStream == null) {
            return null;
        }
        if (outputStream instanceof d) {
            return outputStream;
        }
        try {
            return new d(this.i, outputStream);
        } catch (Throwable unused) {
            return outputStream;
        }
    }

    public final void create(boolean z) throws IOException {
        c(7, new Object[]{Boolean.valueOf(z)});
    }

    public final void connect(String str, int i2) throws IOException {
        a(str, i2, "");
        try {
            this.i.b(com.bonree.sdk.d.a.b());
            c(6, new Object[]{str, Integer.valueOf(i2)});
            this.i.c(com.bonree.sdk.d.a.b());
        } catch (IOException e2) {
            this.i.a((Throwable) e2);
            throw e2;
        }
    }

    public final void connect(InetAddress inetAddress, int i2) throws IOException {
        a(cx.a.a(inetAddress), i2, cx.a.a((Serializable) inetAddress, i2));
        try {
            this.i.b(com.bonree.sdk.d.a.b());
            c(4, new Object[]{inetAddress, Integer.valueOf(i2)});
            this.i.c(com.bonree.sdk.d.a.b());
        } catch (IOException e2) {
            this.i.a((Throwable) e2);
            throw e2;
        }
    }

    public final void connect(SocketAddress socketAddress, int i2) throws IOException {
        int b2 = cx.a.b(socketAddress);
        String a2 = cx.a.a(socketAddress);
        if (TextUtils.isEmpty(a2) && (socketAddress instanceof InetSocketAddress)) {
            a2 = ((InetSocketAddress) socketAddress).getHostName();
        }
        a(a2, b2, cx.a.a((Serializable) socketAddress, b2));
        try {
            this.i.b(com.bonree.sdk.d.a.b());
            c(5, new Object[]{socketAddress, Integer.valueOf(i2)});
            this.i.c(com.bonree.sdk.d.a.b());
        } catch (IOException e2) {
            this.i.a((Throwable) e2);
            throw e2;
        }
    }

    private void a(String str, int i2, String str2) {
        this.i.b(str);
        this.i.a(i2);
        this.i.a(str2);
        this.i.d(Thread.currentThread().getId());
        this.i.c(Thread.currentThread().getName());
        g.a("connect:" + str + "      port:" + i2 + "      ip:" + str2 + "  id:" + this.i.l() + "  threadName:" + this.i.m(), new Object[0]);
    }

    public final void bind(InetAddress inetAddress, int i2) throws IOException {
        c(2, new Object[]{inetAddress, Integer.valueOf(i2)});
    }

    public final void listen(int i2) throws IOException {
        c(14, new Object[]{Integer.valueOf(i2)});
    }

    public final void accept(SocketImpl socketImpl) throws IOException {
        c(0, new Object[]{socketImpl});
    }

    public final int available() throws IOException {
        Integer num = (Integer) c(1, new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        throw new a("Received a null Integer");
    }

    public final void close() throws IOException {
        c(3, new Object[0]);
    }

    public final void shutdownInput() throws IOException {
        c(17, new Object[0]);
    }

    public final void shutdownOutput() throws IOException {
        c(18, new Object[0]);
    }

    public final FileDescriptor getFileDescriptor() {
        return (FileDescriptor) a(8, new Object[0]);
    }

    public final InetAddress getInetAddress() {
        return (InetAddress) a(9, new Object[0]);
    }

    public final int getPort() {
        return ((Integer) a(13, new Object[0])).intValue();
    }

    public final boolean supportsUrgentData() {
        return ((Boolean) a(19, new Object[0])).booleanValue();
    }

    public final void sendUrgentData(int i2) throws IOException {
        c(15, new Object[]{Integer.valueOf(i2)});
    }

    public final int getLocalPort() {
        return ((Integer) a(11, new Object[0])).intValue();
    }

    public final String toString() {
        return this.h.toString();
    }

    public final void setPerformancePreferences(int i2, int i3, int i4) {
        a(16, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final void setOption(int i2, Object obj) throws SocketException {
        this.h.setOption(i2, obj);
    }

    public final Object getOption(int i2) throws SocketException {
        return this.h.getOption(i2);
    }

    private SocketImpl f() {
        return this.h;
    }

    public final void a(b bVar) {
        this.i.a(bVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        throw new com.bonree.sdk.v.a((java.lang.Throwable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r5 = r4.getTargetException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r5 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if ((r5 instanceof java.lang.Exception) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        if ((r5 instanceof java.lang.Error) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        throw ((java.lang.Error) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        throw new com.bonree.sdk.v.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        throw ((java.lang.Exception) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        throw new com.bonree.sdk.v.a((java.lang.Throwable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0067, code lost:
        throw new com.bonree.sdk.v.a((java.lang.Throwable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006e, code lost:
        throw new com.bonree.sdk.v.a((java.lang.Throwable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0073, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        throw new com.bonree.sdk.v.a(r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T b(int r4, java.lang.Object[] r5) throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.reflect.Field r0 = a     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.net.SocketImpl r1 = r3.h     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.net.InetAddress r2 = r3.address     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            r0.set(r1, r2)     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.lang.reflect.Field r0 = b     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.net.SocketImpl r1 = r3.h     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.io.FileDescriptor r2 = r3.fd     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            r0.set(r1, r2)     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.lang.reflect.Field r0 = c     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.net.SocketImpl r1 = r3.h     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            int r2 = r3.localport     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            r0.setInt(r1, r2)     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.lang.reflect.Field r0 = d     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            java.net.SocketImpl r1 = r3.h     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            int r2 = r3.port     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
            r0.setInt(r1, r2)     // Catch:{ IllegalAccessException | IllegalArgumentException -> 0x0024 }
        L_0x0024:
            java.lang.reflect.Method[] r0 = e     // Catch:{ IllegalArgumentException -> 0x0068, IllegalAccessException -> 0x0061, InvocationTargetException -> 0x0040, ClassCastException -> 0x0039, all -> 0x0032 }
            r4 = r0[r4]     // Catch:{ IllegalArgumentException -> 0x0068, IllegalAccessException -> 0x0061, InvocationTargetException -> 0x0040, ClassCastException -> 0x0039, all -> 0x0032 }
            java.net.SocketImpl r0 = r3.h     // Catch:{ IllegalArgumentException -> 0x0068, IllegalAccessException -> 0x0061, InvocationTargetException -> 0x0040, ClassCastException -> 0x0039, all -> 0x0032 }
            java.lang.Object r4 = r4.invoke(r0, r5)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalAccessException -> 0x0061, InvocationTargetException -> 0x0040, ClassCastException -> 0x0039, all -> 0x0032 }
            r3.e()
            return r4
        L_0x0032:
            r4 = move-exception
            com.bonree.sdk.v.a r5 = new com.bonree.sdk.v.a     // Catch:{ all -> 0x006f }
            r5.<init>((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x0039:
            r4 = move-exception
            com.bonree.sdk.v.a r5 = new com.bonree.sdk.v.a     // Catch:{ all -> 0x006f }
            r5.<init>((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x0040:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getTargetException()     // Catch:{ all -> 0x006f }
            if (r5 == 0) goto L_0x005b
            boolean r4 = r5 instanceof java.lang.Exception     // Catch:{ all -> 0x006f }
            if (r4 != 0) goto L_0x0058
            boolean r4 = r5 instanceof java.lang.Error     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x0052
            java.lang.Error r5 = (java.lang.Error) r5     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x0052:
            com.bonree.sdk.v.a r4 = new com.bonree.sdk.v.a     // Catch:{ all -> 0x006f }
            r4.<init>((java.lang.Throwable) r5)     // Catch:{ all -> 0x006f }
            throw r4     // Catch:{ all -> 0x006f }
        L_0x0058:
            java.lang.Exception r5 = (java.lang.Exception) r5     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x005b:
            com.bonree.sdk.v.a r5 = new com.bonree.sdk.v.a     // Catch:{ all -> 0x006f }
            r5.<init>((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x0061:
            r4 = move-exception
            com.bonree.sdk.v.a r5 = new com.bonree.sdk.v.a     // Catch:{ all -> 0x006f }
            r5.<init>((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x0068:
            r4 = move-exception
            com.bonree.sdk.v.a r5 = new com.bonree.sdk.v.a     // Catch:{ all -> 0x006f }
            r5.<init>((java.lang.Throwable) r4)     // Catch:{ all -> 0x006f }
            throw r5     // Catch:{ all -> 0x006f }
        L_0x006f:
            r4 = move-exception
            r3.e()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.network.socket.external.h.b(int, java.lang.Object[]):java.lang.Object");
    }
}
