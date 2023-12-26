package com.bonree.sdk.bc;

import com.bonree.sdk.bc.w;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public final class u extends ao {
    private static final long j = -8679800040426675002L;

    public final /* bridge */ /* synthetic */ int d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ byte[] e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ int f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ PublicKey f_() throws w.b {
        return super.f_();
    }

    public final /* bridge */ /* synthetic */ int g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ int h() {
        return super.h();
    }

    public static class b {
        private static int a = 3;
        private static final byte f = 54;
        private static final byte g = 92;
        private MessageDigest b;
        private int c;
        private byte[] d;
        private byte[] e;

        private b() {
        }

        private void c(byte[] bArr) {
            if (bArr.length > this.c) {
                bArr = this.b.digest(bArr);
                this.b.reset();
            }
            int i = this.c;
            this.d = new byte[i];
            this.e = new byte[i];
            int i2 = 0;
            while (i2 < bArr.length) {
                this.d[i2] = (byte) (54 ^ bArr[i2]);
                this.e[i2] = (byte) (92 ^ bArr[i2]);
                i2++;
            }
            while (i2 < this.c) {
                this.d[i2] = f;
                this.e[i2] = g;
                i2++;
            }
            this.b.update(this.d);
        }

        private b(MessageDigest messageDigest, int i, byte[] bArr) {
            messageDigest.reset();
            this.b = messageDigest;
            this.c = 64;
            c(bArr);
        }

        public b(String str, int i, byte[] bArr) {
            try {
                this.b = MessageDigest.getInstance(str);
                this.c = i;
                c(bArr);
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalArgumentException("unknown digest algorithm " + str);
            }
        }

        private b(MessageDigest messageDigest, byte[] bArr) {
            this(messageDigest, 64, bArr);
        }

        private b(String str, byte[] bArr) {
            this(str, 64, bArr);
        }

        public void a(byte[] bArr, int i, int i2) {
            this.b.update(bArr, i, i2);
        }

        public void a(byte[] bArr) {
            this.b.update(bArr);
        }

        public byte[] a() {
            byte[] digest = this.b.digest();
            this.b.reset();
            this.b.update(this.e);
            return this.b.digest(digest);
        }

        public boolean b(byte[] bArr) {
            return a(bArr, false);
        }

        public boolean a(byte[] bArr, boolean z) {
            byte[] a2 = a();
            if (z && bArr.length < a2.length) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                System.arraycopy(a2, 0, bArr2, 0, length);
                a2 = bArr2;
            }
            return Arrays.equals(bArr, a2);
        }

        public void b() {
            this.b.reset();
            this.b.update(this.d);
        }

        public int c() {
            return this.b.getDigestLength();
        }
    }

    public static class a {
        private static int a = 256;
        private static int b = 1;
        private static int c = 128;
        private long d;
        private long e;
        private long f;
        private String g;
        private int h;
        private int i;
        private long j;
        private String k;
        private bn l;
        private long m;

        private a() {
        }

        public static boolean a(int i2) {
            df.a(i2);
            return i2 == 12 || i2 == 5 || i2 == 39 || i2 == 1 || i2 == 28 || i2 == 2;
        }

        public a(long j2, long j3, long j4, String str, int i2, int i3, long j5, String str2, bn bnVar) {
            long j6 = j2;
            long j7 = j3;
            long j8 = j4;
            if (j6 < 0 || j7 < 0 || j6 > j7 || j8 <= 0) {
                throw new IllegalArgumentException("invalid range specification");
            } else if (a(i2)) {
                p.a(i3);
                this.d = j6;
                this.e = j7;
                this.f = j8;
                this.g = str;
                this.h = i2;
                this.i = i3;
                this.j = j5;
                this.k = str2;
                this.l = bnVar;
                this.m = j6;
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
            throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.u.a.a(java.lang.String, long):java.lang.String");
        }

        public ca a() throws IOException {
            long j2 = this.m;
            if (j2 > this.e) {
                return null;
            }
            bn a2 = bn.a(a(this.g, j2), this.l);
            String a3 = a(this.k, this.m);
            this.m += this.f;
            return ca.a(a2, this.h, this.i, this.j, a3, this.l);
        }

        public ca[] b() throws IOException {
            ArrayList arrayList = new ArrayList();
            long j2 = this.d;
            while (j2 < this.e) {
                arrayList.add(ca.a(bn.a(a(this.g, this.m), this.l), this.h, this.i, this.j, a(this.k, this.m), this.l));
                j2 += this.f;
            }
            return (ca[]) arrayList.toArray(new ca[arrayList.size()]);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("$GENERATE ");
            stringBuffer.append(this.d + "-" + this.e);
            if (this.f > 1) {
                stringBuffer.append("/" + this.f);
            }
            stringBuffer.append(" ");
            stringBuffer.append(this.g + " ");
            stringBuffer.append(this.j + " ");
            if (this.i != 1 || !br.a("noPrintIN")) {
                stringBuffer.append(p.b(this.i) + " ");
            }
            stringBuffer.append(df.b(this.h) + " ");
            stringBuffer.append(this.k + " ");
            return stringBuffer.toString();
        }
    }

    u() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new u();
    }

    private u(bn bnVar, int i, long j2, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 48, i, j2, i2, i3, i4, bArr);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private u(com.bonree.sdk.bc.bn r12, int r13, long r14, int r16, int r17, int r18, java.security.PublicKey r19) throws com.bonree.sdk.bc.w.b {
        /*
            r11 = this;
            r8 = r18
            r10 = r19
            byte[] r9 = com.bonree.sdk.bc.w.a((java.security.PublicKey) r10, (int) r8)
            r2 = 48
            r0 = r11
            r1 = r12
            r3 = r13
            r4 = r14
            r6 = r16
            r7 = r17
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r0.e = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.u.<init>(com.bonree.sdk.bc.bn, int, long, int, int, int, java.security.PublicKey):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.a = ddVar.g();
        this.b = ddVar.h();
        String c = ddVar.c();
        this.c = w.a.a(c);
        if (this.c >= 0) {
            this.d = ddVar.l();
            return;
        }
        throw ddVar.a("Invalid algorithm: " + c);
    }
}
