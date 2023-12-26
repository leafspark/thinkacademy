package com.bonree.sdk.bc;

import com.bonree.sdk.af.a;
import com.bonree.sdk.bc.w;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectionKey;

public class e {
    private static a.C0004a c = null;
    private static long d = 2147483647L;
    protected long a;
    protected SelectionKey b;

    static void a(a.C0004a aVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected e(java.nio.channels.SelectableChannel r1, long r2) throws java.io.IOException {
        /*
            r0 = this;
            r0.<init>()
            r0.a = r2
            java.nio.channels.Selector r2 = java.nio.channels.Selector.open()     // Catch:{ all -> 0x0017 }
            r3 = 0
            r1.configureBlocking(r3)     // Catch:{ all -> 0x0015 }
            r3 = 1
            java.nio.channels.SelectionKey r3 = r1.register(r2, r3)     // Catch:{ all -> 0x0015 }
            r0.b = r3     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r3 = move-exception
            goto L_0x0019
        L_0x0017:
            r3 = move-exception
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.close()
        L_0x001e:
            r1.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.e.<init>(java.nio.channels.SelectableChannel, long):void");
    }

    protected static void a(SelectionKey selectionKey, long j) throws IOException {
        int i;
        long currentTimeMillis = j - System.currentTimeMillis();
        int i2 = (currentTimeMillis > 0 ? 1 : (currentTimeMillis == 0 ? 0 : -1));
        if (i2 > 0) {
            i = selectionKey.selector().select(currentTimeMillis);
        } else {
            i = i2 == 0 ? selectionKey.selector().selectNow() : 0;
        }
        if (i == 0) {
            throw new SocketTimeoutException();
        }
    }

    protected static void a(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr) {
        if (br.a("verbosemsg")) {
            System.err.println(com.bonree.sdk.bd.e.a(str, bArr));
        }
    }

    /* access modifiers changed from: package-private */
    public void a() throws IOException {
        this.b.selector().close();
        this.b.channel().close();
    }

    private e() {
    }

    static void a(long j) {
        if (j < 0 || j > 2147483647L) {
            throw new w.d(j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0075 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(java.lang.String r16, boolean r17) {
        /*
            r0 = r16
            if (r0 == 0) goto L_0x0095
            int r1 = r16.length()
            if (r1 == 0) goto L_0x0095
            r1 = 0
            char r2 = r0.charAt(r1)
            boolean r2 = java.lang.Character.isDigit(r2)
            if (r2 == 0) goto L_0x0095
            r2 = 0
            r4 = r2
            r6 = r4
        L_0x0019:
            int r8 = r16.length()
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r1 >= r8) goto L_0x007b
            char r8 = r0.charAt(r1)
            boolean r11 = java.lang.Character.isDigit(r8)
            if (r11 == 0) goto L_0x0043
            r9 = 10
            long r9 = r9 * r6
            int r8 = java.lang.Character.getNumericValue(r8)
            long r11 = (long) r8
            long r9 = r9 + r11
            int r6 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x003d
            r6 = r9
            goto L_0x0072
        L_0x003d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L_0x0043:
            char r8 = java.lang.Character.toUpperCase(r8)
            r11 = 68
            r12 = 60
            if (r8 == r11) goto L_0x0067
            r11 = 72
            if (r8 == r11) goto L_0x006a
            r11 = 77
            if (r8 == r11) goto L_0x006b
            r11 = 83
            if (r8 == r11) goto L_0x006c
            r11 = 87
            if (r8 != r11) goto L_0x0061
            r14 = 7
            long r6 = r6 * r14
            goto L_0x0067
        L_0x0061:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L_0x0067:
            r14 = 24
            long r6 = r6 * r14
        L_0x006a:
            long r6 = r6 * r12
        L_0x006b:
            long r6 = r6 * r12
        L_0x006c:
            long r4 = r4 + r6
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x0075
            r6 = r2
        L_0x0072:
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0075:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L_0x007b:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0080
            r4 = r6
        L_0x0080:
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 > 0) goto L_0x008f
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x008e
            if (r17 == 0) goto L_0x008e
            r4 = r0
        L_0x008e:
            return r4
        L_0x008f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L_0x0095:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.e.a(java.lang.String, boolean):long");
    }

    public static long a(String str) {
        return a(str, true);
    }

    public static String b(long j) {
        a(j);
        StringBuffer stringBuffer = new StringBuffer();
        long j2 = j % 60;
        long j3 = j / 60;
        long j4 = j3 % 60;
        long j5 = j3 / 60;
        long j6 = j5 % 24;
        long j7 = j5 / 24;
        long j8 = j7 % 7;
        long j9 = j7 / 7;
        int i = (j9 > 0 ? 1 : (j9 == 0 ? 0 : -1));
        if (i > 0) {
            stringBuffer.append(j9 + "W");
        }
        int i2 = (j8 > 0 ? 1 : (j8 == 0 ? 0 : -1));
        if (i2 > 0) {
            stringBuffer.append(j8 + "D");
        }
        int i3 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i3 > 0) {
            stringBuffer.append(j6 + "H");
        }
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 > 0) {
            stringBuffer.append(j4 + "M");
        }
        if (j2 > 0 || (i == 0 && i2 == 0 && i3 == 0 && i4 == 0)) {
            stringBuffer.append(j2 + "S");
        }
        return stringBuffer.toString();
    }
}
