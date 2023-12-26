package com.bonree.sdk.bc;

import java.io.IOException;
import java.util.ArrayList;

public final class af {
    private long a;
    private long b;
    private long c;
    private String d;
    private int e;
    private int f;
    private long g;
    private String h;
    private bn i;
    private long j;

    public static boolean a(int i2) {
        df.a(i2);
        return i2 == 12 || i2 == 5 || i2 == 39 || i2 == 1 || i2 == 28 || i2 == 2;
    }

    public af(long j2, long j3, long j4, String str, int i2, int i3, long j5, String str2, bn bnVar) {
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        if (j6 < 0 || j7 < 0 || j6 > j7 || j8 <= 0) {
            throw new IllegalArgumentException("invalid range specification");
        } else if (a(i2)) {
            p.a(i3);
            this.a = j6;
            this.b = j7;
            this.c = j8;
            this.d = str;
            this.e = i2;
            this.f = i3;
            this.g = j5;
            this.h = str2;
            this.i = bnVar;
            this.j = j6;
        } else {
            throw new IllegalArgumentException("unsupported type");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        if (r3 == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        r11 = -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
        r16 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0095, code lost:
        if (r5 != ',') goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0097, code lost:
        r3 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009a, code lost:
        if (r3 >= r0.length) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009c, code lost:
        r5 = (char) (r0[r3] & 255);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a1, code lost:
        if (r5 == ',') goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a3, code lost:
        if (r5 == '}') goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a5, code lost:
        if (r5 < '0') goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a7, code lost:
        if (r5 > '9') goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a9, code lost:
        r5 = (char) (r5 - '0');
        r16 = (r16 * 10) + ((long) r5);
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ba, code lost:
        throw new com.bonree.sdk.bc.dc("invalid width");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bb, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bc, code lost:
        if (r5 != ',') goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00be, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c3, code lost:
        if (r8 == r0.length) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c5, code lost:
        r3 = (char) (r0[r8] & 255);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cc, code lost:
        if (r3 != 'o') goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ce, code lost:
        r3 = false;
        r5 = 1;
        r13 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d5, code lost:
        if (r3 != 'x') goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d7, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d8, code lost:
        r5 = 1;
        r13 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00de, code lost:
        if (r3 != 'X') goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e0, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e4, code lost:
        if (r3 != 'd') goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ec, code lost:
        throw new com.bonree.sdk.bc.dc("invalid base");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f2, code lost:
        throw new com.bonree.sdk.bc.dc("invalid base");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00f3, code lost:
        r3 = false;
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00f5, code lost:
        r8 = r8 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00f7, code lost:
        if (r8 == r0.length) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00fb, code lost:
        if (r0[r8] != 125) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00fd, code lost:
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0107, code lost:
        throw new com.bonree.sdk.bc.dc("invalid modifiers");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r18, long r19) throws java.io.IOException {
        /*
            byte[] r0 = r18.getBytes()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r3 = 0
            r4 = 0
        L_0x000b:
            int r5 = r0.length
            if (r3 >= r5) goto L_0x0168
            byte r5 = r0[r3]
            r5 = r5 & 255(0xff, float:3.57E-43)
            char r5 = (char) r5
            if (r4 == 0) goto L_0x001c
            r1.append(r5)
            r2 = 1
            r4 = 0
            goto L_0x0165
        L_0x001c:
            r7 = 92
            if (r5 != r7) goto L_0x0031
            int r4 = r3 + 1
            int r5 = r0.length
            if (r4 == r5) goto L_0x0029
            r2 = 1
            r4 = 1
            goto L_0x0165
        L_0x0029:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            java.lang.String r1 = "invalid escape character"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            r7 = 36
            if (r5 != r7) goto L_0x0161
            int r8 = r3 + 1
            int r9 = r0.length
            if (r8 >= r9) goto L_0x0049
            byte r9 = r0[r8]
            if (r9 != r7) goto L_0x0049
            byte r3 = r0[r8]
            r3 = r3 & 255(0xff, float:3.57E-43)
            char r3 = (char) r3
            r1.append(r3)
        L_0x0046:
            r3 = r8
            goto L_0x0164
        L_0x0049:
            int r7 = r0.length
            r13 = 10
            r2 = 48
            if (r8 >= r7) goto L_0x0108
            byte r7 = r0[r8]
            r11 = 123(0x7b, float:1.72E-43)
            if (r7 != r11) goto L_0x0108
            int r3 = r8 + 1
            int r7 = r0.length
            if (r3 >= r7) goto L_0x0064
            byte r7 = r0[r3]
            r11 = 45
            if (r7 != r11) goto L_0x0064
            r8 = r3
            r3 = 1
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            r11 = 0
        L_0x0067:
            int r7 = r8 + 1
            int r9 = r0.length
            r10 = 57
            r15 = 125(0x7d, float:1.75E-43)
            r6 = 44
            if (r7 >= r9) goto L_0x0090
            byte r5 = r0[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            char r5 = (char) r5
            if (r5 == r6) goto L_0x008f
            if (r5 == r15) goto L_0x008f
            if (r5 < r2) goto L_0x0087
            if (r5 > r10) goto L_0x0087
            int r5 = r5 + -48
            char r5 = (char) r5
            long r11 = r11 * r13
            long r8 = (long) r5
            long r11 = r11 + r8
            r8 = r7
            goto L_0x0067
        L_0x0087:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            java.lang.String r1 = "invalid offset"
            r0.<init>(r1)
            throw r0
        L_0x008f:
            r8 = r7
        L_0x0090:
            if (r3 == 0) goto L_0x0093
            long r11 = -r11
        L_0x0093:
            r16 = 0
            if (r5 != r6) goto L_0x00bc
        L_0x0097:
            int r3 = r8 + 1
            int r7 = r0.length
            if (r3 >= r7) goto L_0x00bc
            byte r5 = r0[r3]
            r5 = r5 & 255(0xff, float:3.57E-43)
            char r5 = (char) r5
            if (r5 == r6) goto L_0x00bb
            if (r5 == r15) goto L_0x00bb
            if (r5 < r2) goto L_0x00b3
            if (r5 > r10) goto L_0x00b3
            int r5 = r5 + -48
            char r5 = (char) r5
            long r16 = r16 * r13
            long r7 = (long) r5
            long r16 = r16 + r7
            r8 = r3
            goto L_0x0097
        L_0x00b3:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            java.lang.String r1 = "invalid width"
            r0.<init>(r1)
            throw r0
        L_0x00bb:
            r8 = r3
        L_0x00bc:
            if (r5 != r6) goto L_0x00f3
            int r8 = r8 + 1
            int r3 = r0.length
            java.lang.String r5 = "invalid base"
            if (r8 == r3) goto L_0x00ed
            byte r3 = r0[r8]
            r3 = r3 & 255(0xff, float:3.57E-43)
            char r3 = (char) r3
            r6 = 111(0x6f, float:1.56E-43)
            if (r3 != r6) goto L_0x00d3
            r3 = 0
            r5 = 1
            r13 = 8
            goto L_0x00f5
        L_0x00d3:
            r6 = 120(0x78, float:1.68E-43)
            if (r3 != r6) goto L_0x00dc
            r3 = 0
        L_0x00d8:
            r5 = 1
            r13 = 16
            goto L_0x00f5
        L_0x00dc:
            r6 = 88
            if (r3 != r6) goto L_0x00e2
            r3 = 1
            goto L_0x00d8
        L_0x00e2:
            r6 = 100
            if (r3 != r6) goto L_0x00e7
            goto L_0x00f3
        L_0x00e7:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            r0.<init>(r5)
            throw r0
        L_0x00ed:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            r0.<init>(r5)
            throw r0
        L_0x00f3:
            r3 = 0
            r5 = 1
        L_0x00f5:
            int r8 = r8 + r5
            int r5 = r0.length
            if (r8 == r5) goto L_0x0100
            byte r5 = r0[r8]
            if (r5 != r15) goto L_0x0100
            r5 = r16
            goto L_0x010e
        L_0x0100:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            java.lang.String r1 = "invalid modifiers"
            r0.<init>(r1)
            throw r0
        L_0x0108:
            r8 = r3
            r3 = 0
            r5 = 0
            r11 = 0
        L_0x010e:
            long r9 = r19 + r11
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x0159
            r11 = 8
            int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0121
            java.lang.String r7 = java.lang.Long.toOctalString(r9)
            goto L_0x0130
        L_0x0121:
            r11 = 16
            int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x012c
            java.lang.String r7 = java.lang.Long.toHexString(r9)
            goto L_0x0130
        L_0x012c:
            java.lang.String r7 = java.lang.Long.toString(r9)
        L_0x0130:
            if (r3 == 0) goto L_0x0136
            java.lang.String r7 = r7.toUpperCase()
        L_0x0136:
            r9 = 0
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0154
            int r3 = r7.length()
            long r9 = (long) r3
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0154
            int r3 = (int) r5
            int r5 = r7.length()
            int r3 = r3 - r5
        L_0x014b:
            int r5 = r3 + -1
            if (r3 <= 0) goto L_0x0154
            r1.append(r2)
            r3 = r5
            goto L_0x014b
        L_0x0154:
            r1.append(r7)
            goto L_0x0046
        L_0x0159:
            com.bonree.sdk.bc.dc r0 = new com.bonree.sdk.bc.dc
            java.lang.String r1 = "invalid offset expansion"
            r0.<init>(r1)
            throw r0
        L_0x0161:
            r1.append(r5)
        L_0x0164:
            r2 = 1
        L_0x0165:
            int r3 = r3 + r2
            goto L_0x000b
        L_0x0168:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.af.a(java.lang.String, long):java.lang.String");
    }

    public final ca a() throws IOException {
        long j2 = this.j;
        if (j2 > this.b) {
            return null;
        }
        bn a2 = bn.a(a(this.d, j2), this.i);
        String a3 = a(this.h, this.j);
        this.j += this.c;
        return ca.a(a2, this.e, this.f, this.g, a3, this.i);
    }

    public final ca[] b() throws IOException {
        ArrayList arrayList = new ArrayList();
        long j2 = this.a;
        while (j2 < this.b) {
            arrayList.add(ca.a(bn.a(a(this.d, this.j), this.i), this.e, this.f, this.g, a(this.h, this.j), this.i));
            j2 += this.c;
        }
        return (ca[]) arrayList.toArray(new ca[arrayList.size()]);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("$GENERATE ");
        stringBuffer.append(this.a + "-" + this.b);
        if (this.c > 1) {
            stringBuffer.append("/" + this.c);
        }
        stringBuffer.append(" ");
        stringBuffer.append(this.d + " ");
        stringBuffer.append(this.g + " ");
        if (this.f != 1 || !br.a("noPrintIN")) {
            stringBuffer.append(p.b(this.f) + " ");
        }
        stringBuffer.append(df.b(this.e) + " ");
        stringBuffer.append(this.h + " ");
        return stringBuffer.toString();
    }
}
