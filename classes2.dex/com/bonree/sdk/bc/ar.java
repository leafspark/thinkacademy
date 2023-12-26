package com.bonree.sdk.bc;

import com.bonree.sdk.bc.dd;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class ar extends ca {
    private static final long a = 9058224788126750409L;
    private static NumberFormat b;
    private static NumberFormat c;
    private long d;
    private long e;
    private long j;
    private long k;
    private long l;
    private long m;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        b = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        c = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(3);
    }

    ar() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ar();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ar(bn bnVar, int i, long j2, double d2, double d3, double d4, double d5, double d6, double d7) {
        super(bnVar, 29, i, j2);
        this.k = (long) ((d2 * 3600.0d * 1000.0d) + 2.147483648E9d);
        this.l = (long) ((3600.0d * d3 * 1000.0d) + 2.147483648E9d);
        this.m = (long) ((d4 + 100000.0d) * 100.0d);
        this.d = (long) (d5 * 100.0d);
        this.e = (long) (d6 * 100.0d);
        this.j = (long) (d7 * 100.0d);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        if (tVar.g() == 0) {
            this.d = b(tVar.g());
            this.e = b(tVar.g());
            this.j = b(tVar.g());
            this.k = tVar.i();
            this.l = tVar.i();
            this.m = tVar.i();
            return;
        }
        throw new Cdo("Invalid LOC version");
    }

    private static double b(String str) {
        if (str.matches("^-?\\d+$")) {
            return (double) Integer.parseInt(str);
        }
        if (str.matches("^-?\\d+\\.\\d*$")) {
            String[] split = str.split("\\.");
            double parseInt = (double) Integer.parseInt(split[0]);
            double parseInt2 = (double) Integer.parseInt(split[1]);
            if (parseInt < 0.0d) {
                parseInt2 = -parseInt2;
            }
            return parseInt + (parseInt2 / Math.pow(10.0d, (double) split[1].length()));
        }
        throw new NumberFormatException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(com.bonree.sdk.bc.dd r19, java.lang.String r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "latitude"
            boolean r2 = r1.equals(r2)
            int r3 = r19.g()
            java.lang.String r4 = "Invalid LOC "
            r5 = 180(0xb4, float:2.52E-43)
            if (r3 > r5) goto L_0x00d7
            r5 = 90
            if (r3 <= r5) goto L_0x001a
            if (r2 != 0) goto L_0x00d7
        L_0x001a:
            java.lang.String r5 = r19.c()
            r6 = 0
            r8 = 0
            int r9 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0070 }
            if (r9 < 0) goto L_0x005a
            r10 = 59
            if (r9 > r10) goto L_0x005a
            java.lang.String r5 = r19.c()     // Catch:{ NumberFormatException -> 0x0071 }
            double r10 = b((java.lang.String) r5)     // Catch:{ NumberFormatException -> 0x0071 }
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0042
            r6 = 4633641066610819072(0x404e000000000000, double:60.0)
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0042
            java.lang.String r5 = r19.c()     // Catch:{ NumberFormatException -> 0x0058 }
            goto L_0x0072
        L_0x0042:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0058 }
            r6.<init>(r4)     // Catch:{ NumberFormatException -> 0x0058 }
            r6.append(r1)     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r7 = " seconds"
            r6.append(r7)     // Catch:{ NumberFormatException -> 0x0058 }
            java.lang.String r6 = r6.toString()     // Catch:{ NumberFormatException -> 0x0058 }
            com.bonree.sdk.bc.dc r6 = r0.a((java.lang.String) r6)     // Catch:{ NumberFormatException -> 0x0058 }
            throw r6     // Catch:{ NumberFormatException -> 0x0058 }
        L_0x0058:
            r6 = r10
            goto L_0x0071
        L_0x005a:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0071 }
            r10.<init>(r4)     // Catch:{ NumberFormatException -> 0x0071 }
            r10.append(r1)     // Catch:{ NumberFormatException -> 0x0071 }
            java.lang.String r11 = " minutes"
            r10.append(r11)     // Catch:{ NumberFormatException -> 0x0071 }
            java.lang.String r10 = r10.toString()     // Catch:{ NumberFormatException -> 0x0071 }
            com.bonree.sdk.bc.dc r10 = r0.a((java.lang.String) r10)     // Catch:{ NumberFormatException -> 0x0071 }
            throw r10     // Catch:{ NumberFormatException -> 0x0071 }
        L_0x0070:
            r9 = r8
        L_0x0071:
            r10 = r6
        L_0x0072:
            int r6 = r5.length()
            r7 = 1
            if (r6 != r7) goto L_0x00c6
            r6 = 4652007308841189376(0x408f400000000000, double:1000.0)
            long r12 = (long) r9
            long r14 = (long) r3
            r16 = 60
            long r14 = r14 * r16
            long r12 = r12 + r14
            long r12 = r12 * r16
            double r12 = (double) r12
            double r10 = r10 + r12
            double r10 = r10 * r6
            long r6 = (long) r10
            char r3 = r5.charAt(r8)
            char r3 = java.lang.Character.toUpperCase(r3)
            if (r2 == 0) goto L_0x0099
            r5 = 83
            if (r3 == r5) goto L_0x009f
        L_0x0099:
            if (r2 != 0) goto L_0x00a1
            r5 = 87
            if (r3 != r5) goto L_0x00a1
        L_0x009f:
            long r6 = -r6
            goto L_0x00bf
        L_0x00a1:
            if (r2 == 0) goto L_0x00a7
            r5 = 78
            if (r3 != r5) goto L_0x00ae
        L_0x00a7:
            if (r2 != 0) goto L_0x00bf
            r2 = 69
            if (r3 != r2) goto L_0x00ae
            goto L_0x00bf
        L_0x00ae:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r1)
            throw r0
        L_0x00bf:
            r0 = 2147483648(0x80000000, double:1.0609978955E-314)
            long r6 = r6 + r0
            return r6
        L_0x00c6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r1)
            throw r0
        L_0x00d7:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r1 = " degrees"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.bonree.sdk.bc.dc r0 = r0.a((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.ar.a(com.bonree.sdk.bc.dd, java.lang.String):long");
    }

    private long a(dd ddVar, String str, boolean z, long j2, long j3, long j4) throws IOException {
        dd.a a2 = ddVar.a();
        if (!(a2.a == 1 || a2.a == 0)) {
            String str2 = a2.b;
            if (str2.length() > 1 && str2.charAt(str2.length() - 1) == 'm') {
                str2 = str2.substring(0, str2.length() - 1);
            }
            try {
                long b2 = (long) (b(str2) * 100.0d);
                if (b2 >= j2 && b2 <= j3) {
                    return b2;
                }
                throw ddVar.a("Invalid LOC " + str);
            } catch (NumberFormatException unused) {
                throw ddVar.a("Invalid LOC " + str);
            }
        } else if (!z) {
            ddVar.b();
            return j4;
        } else {
            throw ddVar.a("Invalid LOC " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.k = a(ddVar, "latitude");
        this.l = a(ddVar, "longitude");
        this.m = a(ddVar, "altitude", true, -10000000, 4284967295L, 0) + 10000000;
        dd ddVar2 = ddVar;
        this.d = a(ddVar2, "size", false, 0, 9000000000L, 100);
        this.e = a(ddVar2, "horizontal precision", false, 0, 9000000000L, 1000000);
        this.j = a(ddVar2, "vertical precision", false, 0, 9000000000L, 1000);
    }

    private static void a(StringBuffer stringBuffer, NumberFormat numberFormat, long j2, long j3) {
        stringBuffer.append(j2 / j3);
        long j4 = j2 % j3;
        if (j4 != 0) {
            stringBuffer.append(".");
            stringBuffer.append(numberFormat.format(j4));
        }
    }

    private String a(long j2, char c2, char c3) {
        StringBuffer stringBuffer = new StringBuffer();
        long j3 = j2 - 2147483648L;
        if (j3 < 0) {
            j3 = -j3;
            c2 = c3;
        }
        stringBuffer.append(j3 / 3600000);
        long j4 = j3 % 3600000;
        stringBuffer.append(" ");
        stringBuffer.append(j4 / 60000);
        stringBuffer.append(" ");
        StringBuffer stringBuffer2 = stringBuffer;
        a(stringBuffer2, c, j4 % 60000, 1000);
        stringBuffer.append(" ");
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.k, 'N', 'S'));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.l, 'E', 'W'));
        stringBuffer.append(" ");
        StringBuffer stringBuffer2 = stringBuffer;
        a(stringBuffer2, b, this.m - 10000000, 100);
        stringBuffer.append("m ");
        a(stringBuffer2, b, this.d, 100);
        stringBuffer.append("m ");
        a(stringBuffer2, b, this.e, 100);
        stringBuffer.append("m ");
        a(stringBuffer2, b, this.j, 100);
        stringBuffer.append("m");
        return stringBuffer.toString();
    }

    private double d() {
        return ((double) (this.k - 2147483648L)) / 3600000.0d;
    }

    private double e() {
        return ((double) (this.l - 2147483648L)) / 3600000.0d;
    }

    private double f() {
        return ((double) (this.m - 10000000)) / 100.0d;
    }

    private double g() {
        return ((double) this.d) / 100.0d;
    }

    private double h() {
        return ((double) this.e) / 100.0d;
    }

    private double i() {
        return ((double) this.j) / 100.0d;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(0);
        vVar.b(b(this.d));
        vVar.b(b(this.e));
        vVar.b(b(this.j));
        vVar.a(this.k);
        vVar.a(this.l);
        vVar.a(this.m);
    }

    private static long b(int i) throws Cdo {
        long j2 = (long) (i >> 4);
        int i2 = i & 15;
        if (j2 > 9 || i2 > 9) {
            throw new Cdo("Invalid LOC Encoding");
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return j2;
            }
            j2 *= 10;
            i2 = i3;
        }
    }

    private static int b(long j2) {
        byte b2 = 0;
        while (j2 > 9) {
            b2 = (byte) (b2 + 1);
            j2 /= 10;
        }
        return (int) ((j2 << 4) + ((long) b2));
    }
}
