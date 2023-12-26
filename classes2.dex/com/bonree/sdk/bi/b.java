package com.bonree.sdk.bi;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public abstract class b implements CharSequence, Comparable<b> {
    private static int b = 63;
    private static b c;
    private static boolean d = true;
    public final String a;
    private transient String e;
    private transient b f;
    private transient byte[] g;

    public /* synthetic */ int compareTo(Object obj) {
        return b().a.compareTo(((b) obj).b().a);
    }

    static {
        a("*");
    }

    protected b(String str) {
        this.a = str;
        if (d) {
            e();
            if (this.g.length > 63) {
                throw new a(str);
            }
        }
    }

    private String c() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return this.a;
    }

    private String d() {
        return getClass().getSimpleName();
    }

    public final int length() {
        return this.a.length();
    }

    public final char charAt(int i) {
        return this.a.charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }

    public final String toString() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.a.equals(((b) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final b b() {
        if (this.f == null) {
            this.f = a(this.a.toLowerCase(Locale.US));
        }
        return this.f;
    }

    private void e() {
        if (this.g == null) {
            this.g = this.a.getBytes(StandardCharsets.US_ASCII);
        }
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream) {
        e();
        byteArrayOutputStream.write(this.g.length);
        byte[] bArr = this.g;
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    private int a(b bVar) {
        return b().a.compareTo(bVar.b().a);
    }

    public static b a(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Label is null or empty");
        } else if (d.c(str)) {
            return d.d(str);
        } else {
            return f.d(str);
        }
    }

    public static b[] a(String[] strArr) {
        b[] bVarArr = new b[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bVarArr[i] = a(strArr[i]);
        }
        return bVarArr;
    }

    public static boolean b(String str) {
        return str.toLowerCase(Locale.US).startsWith("xn--");
    }

    public static class a extends IllegalArgumentException {
        private static final long b = 1;
        public final String a;

        a(String str) {
            this.a = str;
        }
    }
}
