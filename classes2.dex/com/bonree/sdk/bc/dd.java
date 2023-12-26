package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import com.bonree.sdk.ac.e;
import com.bonree.sdk.ac.f;
import com.bonree.sdk.bc.w;
import com.bonree.sdk.bd.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class dd {
    private static String a = " \t\n;()\"";
    private static String b = "\"";
    private static int c = 0;
    private static int d = 1;
    private static int e = 2;
    private static int f = 3;
    private static int g = 4;
    private static int h = 5;
    private PushbackInputStream i;
    private boolean j;
    private int k;
    private boolean l;
    private String m;
    private a n;
    private StringBuffer o;
    private boolean p;
    private String q;
    private int r;

    public static class a {
        public int a;
        public String b;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.a = -1;
            this.b = null;
        }

        private a a(int i, StringBuffer stringBuffer) {
            String str;
            if (i >= 0) {
                this.a = i;
                if (stringBuffer == null) {
                    str = null;
                } else {
                    str = stringBuffer.toString();
                }
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException();
        }

        public final String toString() {
            int i = this.a;
            if (i == 0) {
                return "<eof>";
            }
            if (i == 1) {
                return "<eol>";
            }
            if (i == 2) {
                return "<whitespace>";
            }
            if (i == 3) {
                return "<identifier: " + this.b + ">";
            } else if (i == 4) {
                return "<quoted_string: " + this.b + ">";
            } else if (i != 5) {
                return "<unknown>";
            } else {
                return "<comment: " + this.b + ">";
            }
        }

        public final boolean a() {
            int i = this.a;
            return i == 3 || i == 4;
        }

        public final boolean b() {
            int i = this.a;
            return i == 1 || i == 0;
        }

        static /* synthetic */ a a(a aVar, int i, StringBuffer stringBuffer) {
            String str;
            if (i >= 0) {
                aVar.a = i;
                if (stringBuffer == null) {
                    str = null;
                } else {
                    str = stringBuffer.toString();
                }
                aVar.b = str;
                return aVar;
            }
            throw new IllegalArgumentException();
        }
    }

    static class b extends dc {
        String a;

        public b(String str, int i, String str2) {
            super(str + ":" + i + ": " + str2);
            this.a = str2;
        }

        public final String a() {
            return this.a;
        }
    }

    public dd(InputStream inputStream) {
        this.i = new PushbackInputStream(!(inputStream instanceof BufferedInputStream) ? new BufferedInputStream(inputStream) : inputStream, 2);
        this.j = false;
        this.k = 0;
        this.l = false;
        this.m = a;
        this.n = new a((byte) 0);
        this.o = new StringBuffer();
        this.q = "<none>";
        this.r = 1;
    }

    public dd(String str) {
        this((InputStream) new ByteArrayInputStream(str.getBytes()));
    }

    public dd(File file) throws FileNotFoundException {
        this((InputStream) new FileInputStream(file));
        this.p = true;
        this.q = file.getName();
    }

    private int p() throws IOException {
        int read = this.i.read();
        if (read == 13) {
            int read2 = this.i.read();
            if (read2 != 10) {
                this.i.unread(read2);
            }
            read = 10;
        }
        if (read == 10) {
            this.r++;
        }
        return read;
    }

    private void c(int i2) throws IOException {
        if (i2 != -1) {
            this.i.unread(i2);
            if (i2 == 10) {
                this.r--;
            }
        }
    }

    private int q() throws IOException {
        int p2;
        int i2 = 0;
        while (true) {
            p2 = p();
            if (p2 == 32 || p2 == 9 || (p2 == 10 && this.k > 0)) {
                i2++;
            }
        }
        c(p2);
        return i2;
    }

    private void r() throws dc {
        if (this.k > 0) {
            throw a("unbalanced parentheses");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0126 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bonree.sdk.bc.dd.a a(boolean r8, boolean r9) throws java.io.IOException {
        /*
            r7 = this;
            boolean r9 = r7.j
            r0 = 2
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L_0x0029
            r7.j = r2
            com.bonree.sdk.bc.dd$a r9 = r7.n
            int r9 = r9.a
            if (r9 != r0) goto L_0x0014
            if (r8 == 0) goto L_0x0029
            com.bonree.sdk.bc.dd$a r8 = r7.n
            return r8
        L_0x0014:
            com.bonree.sdk.bc.dd$a r9 = r7.n
            int r9 = r9.a
            r3 = 5
            if (r9 == r3) goto L_0x0029
            com.bonree.sdk.bc.dd$a r8 = r7.n
            int r8 = r8.a
            if (r8 != r1) goto L_0x0026
            int r8 = r7.r
            int r8 = r8 + r1
            r7.r = r8
        L_0x0026:
            com.bonree.sdk.bc.dd$a r8 = r7.n
            return r8
        L_0x0029:
            int r9 = r7.q()
            r3 = 0
            if (r9 <= 0) goto L_0x0039
            if (r8 == 0) goto L_0x0039
            com.bonree.sdk.bc.dd$a r8 = r7.n
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r8, r0, r3)
            return r8
        L_0x0039:
            r8 = 3
            java.lang.StringBuffer r9 = r7.o
            r9.setLength(r2)
            r9 = 4
        L_0x0040:
            int r0 = r7.p()
            r4 = 10
            r5 = -1
            if (r0 == r5) goto L_0x007e
            java.lang.String r6 = r7.m
            int r6 = r6.indexOf(r0)
            if (r6 == r5) goto L_0x0052
            goto L_0x007e
        L_0x0052:
            r6 = 92
            if (r0 != r6) goto L_0x0069
            int r0 = r7.p()
            if (r0 == r5) goto L_0x0062
            java.lang.StringBuffer r4 = r7.o
            r4.append(r6)
            goto L_0x0077
        L_0x0062:
            java.lang.String r8 = "unterminated escape sequence"
            com.bonree.sdk.bc.dc r8 = r7.a((java.lang.String) r8)
            throw r8
        L_0x0069:
            boolean r5 = r7.l
            if (r5 == 0) goto L_0x0077
            if (r0 == r4) goto L_0x0070
            goto L_0x0077
        L_0x0070:
            java.lang.String r8 = "newline in quoted string"
            com.bonree.sdk.bc.dc r8 = r7.a((java.lang.String) r8)
            throw r8
        L_0x0077:
            java.lang.StringBuffer r4 = r7.o
            char r0 = (char) r0
            r4.append(r0)
            goto L_0x0040
        L_0x007e:
            if (r0 != r5) goto L_0x00a3
            boolean r9 = r7.l
            if (r9 != 0) goto L_0x009c
            java.lang.StringBuffer r9 = r7.o
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0093
            com.bonree.sdk.bc.dd$a r8 = r7.n
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r8, r2, r3)
            return r8
        L_0x0093:
            com.bonree.sdk.bc.dd$a r9 = r7.n
            java.lang.StringBuffer r0 = r7.o
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r9, r8, r0)
            return r8
        L_0x009c:
            java.lang.String r8 = "EOF in quoted string"
            com.bonree.sdk.bc.dc r8 = r7.a((java.lang.String) r8)
            throw r8
        L_0x00a3:
            java.lang.StringBuffer r6 = r7.o
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0133
            if (r8 == r9) goto L_0x0133
            r6 = 40
            if (r0 != r6) goto L_0x00ba
            int r0 = r7.k
            int r0 = r0 + r1
            r7.k = r0
            r7.q()
            goto L_0x0040
        L_0x00ba:
            r6 = 41
            if (r0 != r6) goto L_0x00d2
            int r0 = r7.k
            if (r0 <= 0) goto L_0x00cb
            int r0 = r0 + -1
            r7.k = r0
            r7.q()
            goto L_0x0040
        L_0x00cb:
            java.lang.String r8 = "invalid close parenthesis"
            com.bonree.sdk.bc.dc r8 = r7.a((java.lang.String) r8)
            throw r8
        L_0x00d2:
            r6 = 34
            if (r0 != r6) goto L_0x00ee
            boolean r0 = r7.l
            if (r0 != 0) goto L_0x00e3
            r7.l = r1
            java.lang.String r8 = b
            r7.m = r8
            r8 = r9
            goto L_0x0040
        L_0x00e3:
            r7.l = r2
            java.lang.String r0 = a
            r7.m = r0
            r7.q()
            goto L_0x0040
        L_0x00ee:
            if (r0 != r4) goto L_0x00f7
            com.bonree.sdk.bc.dd$a r8 = r7.n
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r8, r1, r3)
            return r8
        L_0x00f7:
            r6 = 59
            if (r0 != r6) goto L_0x012d
        L_0x00fb:
            int r0 = r7.p()
            if (r0 == r4) goto L_0x010a
            if (r0 == r5) goto L_0x010a
            java.lang.StringBuffer r6 = r7.o
            char r0 = (char) r0
            r6.append(r0)
            goto L_0x00fb
        L_0x010a:
            if (r0 != r5) goto L_0x0118
            if (r8 == r9) goto L_0x0118
            r7.r()
            com.bonree.sdk.bc.dd$a r8 = r7.n
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r8, r2, r3)
            return r8
        L_0x0118:
            int r0 = r7.k
            if (r0 <= 0) goto L_0x0126
            r7.q()
            java.lang.StringBuffer r0 = r7.o
            r0.setLength(r2)
            goto L_0x0040
        L_0x0126:
            com.bonree.sdk.bc.dd$a r8 = r7.n
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r8, r1, r3)
            return r8
        L_0x012d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0133:
            r7.c(r0)
            java.lang.StringBuffer r0 = r7.o
            int r0 = r0.length()
            if (r0 != 0) goto L_0x014a
            if (r8 == r9) goto L_0x014a
            r7.r()
            com.bonree.sdk.bc.dd$a r8 = r7.n
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r8, r2, r3)
            return r8
        L_0x014a:
            com.bonree.sdk.bc.dd$a r9 = r7.n
            java.lang.StringBuffer r0 = r7.o
            com.bonree.sdk.bc.dd$a r8 = com.bonree.sdk.bc.dd.a.a(r9, r8, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.dd.a(boolean, boolean):com.bonree.sdk.bc.dd$a");
    }

    public final a a() throws IOException {
        return a(false, false);
    }

    public final void b() {
        if (!this.j) {
            if (this.n.a == 1) {
                this.r--;
            }
            this.j = true;
            return;
        }
        throw new IllegalStateException("Cannot unget multiple tokens");
    }

    public final String d() throws IOException {
        return b("an identifier");
    }

    public final long e() throws IOException {
        String b2 = b("an integer");
        if (Character.isDigit(b2.charAt(0))) {
            try {
                return Long.parseLong(b2);
            } catch (NumberFormatException unused) {
                throw a("expected an integer");
            }
        } else {
            throw a("expected an integer");
        }
    }

    public final long f() throws IOException {
        long e2 = e();
        if (e2 >= 0 && e2 <= 4294967295L) {
            return e2;
        }
        throw a("expected an 32 bit unsigned integer");
    }

    public final int g() throws IOException {
        long e2 = e();
        if (e2 >= 0 && e2 <= 65535) {
            return (int) e2;
        }
        throw a("expected an 16 bit unsigned integer");
    }

    public final int h() throws IOException {
        long e2 = e();
        if (e2 >= 0 && e2 <= 255) {
            return (int) e2;
        }
        throw a("expected an 8 bit unsigned integer");
    }

    public final long i() throws IOException {
        try {
            return e.a(b("a TTL value"), true);
        } catch (NumberFormatException unused) {
            throw a("expected a TTL value");
        }
    }

    public final long j() throws IOException {
        try {
            return e.a(b("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw a("expected a TTL-like value");
        }
    }

    public final bn a(bn bnVar) throws IOException {
        try {
            bn a2 = bn.a(b("a name"), bnVar);
            if (a2.b()) {
                return a2;
            }
            throw new w.d(a2);
        } catch (dc e2) {
            throw a(e2.getMessage());
        }
    }

    public final byte[] a(int i2) throws IOException {
        String b2 = b("an address");
        byte[] a2 = i.a(b2, i2);
        if (a2 != null) {
            return a2;
        }
        throw a("Invalid address: " + b2);
    }

    public final InetAddress b(int i2) throws IOException {
        try {
            return i.b(b("an address"), i2);
        } catch (UnknownHostException e2) {
            throw a(e2.getMessage());
        }
    }

    public final byte[] a(boolean z) throws IOException {
        String s = s();
        if (s == null) {
            return null;
        }
        byte[] a2 = f.a(s);
        if (a2 != null) {
            return a2;
        }
        throw a("invalid base64 encoding");
    }

    public final byte[] l() throws IOException {
        return a(false);
    }

    public final byte[] b(boolean z) throws IOException {
        String s = s();
        if (s != null) {
            byte[] a2 = e.a(s);
            if (a2 != null) {
                return a2;
            }
            throw a("invalid hex encoding");
        } else if (!z) {
            return null;
        } else {
            throw a("expected hex encoded string");
        }
    }

    public final byte[] m() throws IOException {
        return b(false);
    }

    public final byte[] n() throws IOException {
        byte[] a2 = e.a(b("a hex string"));
        if (a2 != null) {
            return a2;
        }
        throw a("invalid hex encoding");
    }

    public final byte[] a(c cVar) throws IOException {
        byte[] a2 = cVar.a(b("a base32 string"));
        if (a2 != null) {
            return a2;
        }
        throw a("invalid base32 encoding");
    }

    public final dc a(String str) {
        return new b(this.q, this.r, str);
    }

    public final void o() {
        if (this.p) {
            try {
                this.i.close();
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        o();
    }

    public final String c() throws IOException {
        a a2 = a(false, false);
        if (a2.a()) {
            return a2.b;
        }
        throw a("expected a string");
    }

    private String b(String str) throws IOException {
        a a2 = a(false, false);
        if (a2.a == 3) {
            return a2.b;
        }
        throw a("expected " + str);
    }

    public final void k() throws IOException {
        a a2 = a(false, false);
        if (a2.a != 1 && a2.a != 0) {
            throw a("expected EOL or EOF");
        }
    }

    private String s() throws IOException {
        StringBuffer stringBuffer = null;
        while (true) {
            a a2 = a(false, false);
            if (!a2.a()) {
                break;
            }
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(a2.b);
        }
        b();
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }
}
