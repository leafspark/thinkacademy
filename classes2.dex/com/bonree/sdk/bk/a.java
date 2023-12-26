package com.bonree.sdk.bk;

import com.bonree.sdk.bi.b;
import com.bonree.sdk.bk.b;
import com.bonree.sdk.bo.c;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public final class a implements Serializable, CharSequence, Comparable<a> {
    public static final a a = new a(".");
    public static final a b = new a("in-addr.arpa");
    public static final a c = new a("ip6.arpa");
    private static final long e = 1;
    private static final String f = "[.。．｡]";
    private static int g = 255;
    private static int h = 128;
    private static boolean i = true;
    private static /* synthetic */ boolean t = true;
    public final String d;
    private final String j;
    private transient byte[] k;
    private transient byte[] l;
    private transient String m;
    private transient String n;
    private transient String o;
    private transient b[] p;
    private transient b[] q;
    private transient int r;
    private int s;

    private a(String str) {
        this(str, true);
    }

    private a(String str, boolean z) {
        this.s = -1;
        if (str.isEmpty()) {
            this.j = a.j;
        } else {
            int length = str.length();
            int i2 = length - 1;
            if (length >= 2 && str.charAt(i2) == '.') {
                str = str.subSequence(0, i2).toString();
            }
            if (z) {
                this.j = str;
            } else {
                this.j = c.a(str);
            }
        }
        this.d = this.j.toLowerCase(Locale.US);
        if (i) {
            d();
        }
    }

    private a(b[] bVarArr, boolean z) {
        this.s = -1;
        this.q = bVarArr;
        this.p = new b[bVarArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            i2 += bVarArr[i3].length() + 1;
            this.p[i3] = bVarArr[i3].b();
        }
        this.j = a(bVarArr, i2);
        this.d = a(this.p, i2);
        if (z && i) {
            d();
        }
    }

    private static String a(b[] bVarArr, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int length = bVarArr.length - 1; length >= 0; length--) {
            sb.append(bVarArr[length]);
            sb.append('.');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void d() {
        g();
        if (this.k.length > 255) {
            throw new b.a(this.d, this.k);
        }
    }

    public final void a(OutputStream outputStream) throws IOException {
        g();
        outputStream.write(this.k);
    }

    private byte[] e() {
        g();
        return (byte[]) this.k.clone();
    }

    private byte[] f() {
        if (this.l == null) {
            h();
            this.l = a(this.q);
        }
        return (byte[]) this.l.clone();
    }

    private void g() {
        if (this.k == null) {
            h();
            this.k = a(this.p);
        }
    }

    private static byte[] a(com.bonree.sdk.bi.b[] bVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        for (int length = bVarArr.length - 1; length >= 0; length--) {
            bVarArr[length].a(byteArrayOutputStream);
        }
        byteArrayOutputStream.write(0);
        if (t || byteArrayOutputStream.size() <= 255) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new AssertionError();
    }

    private void h() {
        if (this.p != null && this.q != null) {
            return;
        }
        if (c()) {
            com.bonree.sdk.bi.b[] bVarArr = new com.bonree.sdk.bi.b[0];
            this.p = bVarArr;
            this.q = bVarArr;
            return;
        }
        this.p = b(this.d);
        this.q = b(this.j);
    }

    private static com.bonree.sdk.bi.b[] b(String str) {
        String[] split = str.split(f, 128);
        for (int i2 = 0; i2 < split.length / 2; i2++) {
            String str2 = split[i2];
            int length = (split.length - i2) - 1;
            split[i2] = split[length];
            split[length] = str2;
        }
        try {
            return com.bonree.sdk.bi.b.a(split);
        } catch (b.a e2) {
            throw new b.C0015b(str, e2.a);
        }
    }

    public final String a() {
        return this.j;
    }

    private String i() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String b2 = c.b(this.d);
        this.m = b2;
        return b2;
    }

    private String j() {
        m();
        return this.n;
    }

    private String k() {
        m();
        return this.o;
    }

    private com.bonree.sdk.bi.b l() {
        h();
        com.bonree.sdk.bi.b[] bVarArr = this.p;
        return bVarArr[bVarArr.length - 1];
    }

    private void m() {
        if (this.o == null) {
            String[] split = this.d.split(f, 2);
            this.o = split[0];
            if (split.length > 1) {
                this.n = split[1];
            } else {
                this.n = "";
            }
        }
    }

    public final int b() {
        if (this.s < 0) {
            if (c()) {
                this.s = 1;
            } else {
                this.s = this.d.length() + 2;
            }
        }
        return this.s;
    }

    public final int length() {
        return this.d.length();
    }

    public final char charAt(int i2) {
        return this.d.charAt(i2);
    }

    public final CharSequence subSequence(int i2, int i3) {
        return this.d.subSequence(i2, i3);
    }

    public final String toString() {
        return this.d;
    }

    public static a a(CharSequence charSequence) {
        return a(charSequence.toString());
    }

    public static a a(String str) {
        return new a(str, false);
    }

    public static a a(a aVar, a aVar2) {
        aVar.h();
        aVar2.h();
        int length = aVar.q.length;
        com.bonree.sdk.bi.b[] bVarArr = aVar2.q;
        com.bonree.sdk.bi.b[] bVarArr2 = new com.bonree.sdk.bi.b[(length + bVarArr.length)];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        com.bonree.sdk.bi.b[] bVarArr3 = aVar.q;
        System.arraycopy(bVarArr3, 0, bVarArr2, aVar2.q.length, bVarArr3.length);
        return new a(bVarArr2, true);
    }

    private static a a(CharSequence charSequence, a aVar) {
        com.bonree.sdk.bi.b a2 = com.bonree.sdk.bi.b.a(charSequence.toString());
        aVar.h();
        com.bonree.sdk.bi.b[] bVarArr = aVar.q;
        com.bonree.sdk.bi.b[] bVarArr2 = new com.bonree.sdk.bi.b[(bVarArr.length + 1)];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        bVarArr2[aVar.q.length] = a2;
        return new a(bVarArr2, true);
    }

    private static a a(com.bonree.sdk.bi.b bVar, a aVar) {
        aVar.h();
        com.bonree.sdk.bi.b[] bVarArr = aVar.q;
        com.bonree.sdk.bi.b[] bVarArr2 = new com.bonree.sdk.bi.b[(bVarArr.length + 1)];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        bVarArr2[aVar.q.length] = bVar;
        return new a(bVarArr2, true);
    }

    private static a a(com.bonree.sdk.bi.b bVar, com.bonree.sdk.bi.b bVar2, a aVar) {
        aVar.g();
        com.bonree.sdk.bi.b[] bVarArr = aVar.q;
        com.bonree.sdk.bi.b[] bVarArr2 = new com.bonree.sdk.bi.b[(bVarArr.length + 2)];
        System.arraycopy(bVarArr, 0, bVarArr2, 0, bVarArr.length);
        com.bonree.sdk.bi.b[] bVarArr3 = aVar.q;
        bVarArr2[bVarArr3.length] = bVar2;
        bVarArr2[bVarArr3.length + 1] = bVar;
        return new a(bVarArr2, true);
    }

    private static a a(a... aVarArr) {
        int i2 = 0;
        for (a aVar : aVarArr) {
            aVar.h();
            i2 += aVar.q.length;
        }
        com.bonree.sdk.bi.b[] bVarArr = new com.bonree.sdk.bi.b[i2];
        int i3 = 0;
        for (int length = aVarArr.length - 1; length >= 0; length--) {
            a aVar2 = aVarArr[length];
            com.bonree.sdk.bi.b[] bVarArr2 = aVar2.q;
            System.arraycopy(bVarArr2, 0, bVarArr, i3, bVarArr2.length);
            i3 += aVar2.q.length;
        }
        return new a(bVarArr, true);
    }

    public static a a(String[] strArr) {
        return new a(com.bonree.sdk.bi.b.a(strArr), true);
    }

    public static a a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & 192) == 192) {
            int readUnsignedByte2 = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte2));
            return a(bArr, readUnsignedByte2, (HashSet<Integer>) hashSet);
        } else if (readUnsignedByte == 0) {
            return a;
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            return a(new a(new String(bArr2, StandardCharsets.US_ASCII)), a(dataInputStream, bArr));
        }
    }

    private static a a(byte[] bArr, int i2, HashSet<Integer> hashSet) throws IllegalStateException {
        while (true) {
            byte b2 = bArr[i2] & 255;
            if ((b2 & 192) == 192) {
                i2 = (bArr[i2 + 1] & 255) + ((b2 & 63) << 8);
                if (!hashSet.contains(Integer.valueOf(i2))) {
                    hashSet.add(Integer.valueOf(i2));
                } else {
                    throw new IllegalStateException("Cyclic offsets detected.");
                }
            } else if (b2 == 0) {
                return a;
            } else {
                int i3 = i2 + 1;
                return a(new a(new String(bArr, i3, b2, StandardCharsets.US_ASCII)), a(bArr, i3 + b2, hashSet));
            }
        }
    }

    /* renamed from: a */
    public final int compareTo(a aVar) {
        return this.d.compareTo(aVar.d);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        g();
        aVar.g();
        return Arrays.equals(this.k, aVar.k);
    }

    public final int hashCode() {
        if (this.r == 0 && !c()) {
            g();
            this.r = Arrays.hashCode(this.k);
        }
        return this.r;
    }

    private boolean c(a aVar) {
        h();
        aVar.h();
        if (this.p.length - 1 != aVar.p.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            com.bonree.sdk.bi.b[] bVarArr = aVar.p;
            if (i2 >= bVarArr.length) {
                return true;
            }
            if (!this.p[i2].equals(bVarArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public final boolean b(a aVar) {
        h();
        aVar.h();
        if (this.p.length < aVar.p.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            com.bonree.sdk.bi.b[] bVarArr = aVar.p;
            if (i2 >= bVarArr.length) {
                return true;
            }
            if (!this.p[i2].equals(bVarArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    private int n() {
        h();
        return this.p.length;
    }

    private com.bonree.sdk.bi.b[] o() {
        h();
        return (com.bonree.sdk.bi.b[]) this.p.clone();
    }

    private com.bonree.sdk.bi.b a(int i2) {
        h();
        return this.p[i2];
    }

    private com.bonree.sdk.bi.b[] p() {
        h();
        return (com.bonree.sdk.bi.b[]) this.q.clone();
    }

    private a b(int i2) {
        h();
        com.bonree.sdk.bi.b[] bVarArr = this.p;
        if (i2 > bVarArr.length) {
            throw new IllegalArgumentException();
        } else if (i2 == bVarArr.length) {
            return this;
        } else {
            if (i2 == 0) {
                return a;
            }
            return new a((com.bonree.sdk.bi.b[]) Arrays.copyOfRange(this.q, 0, i2), false);
        }
    }

    private a q() {
        if (c()) {
            return a;
        }
        h();
        int length = this.p.length - 1;
        h();
        com.bonree.sdk.bi.b[] bVarArr = this.p;
        if (length > bVarArr.length) {
            throw new IllegalArgumentException();
        } else if (length == bVarArr.length) {
            return this;
        } else {
            if (length == 0) {
                return a;
            }
            return new a((com.bonree.sdk.bi.b[]) Arrays.copyOfRange(this.q, 0, length), false);
        }
    }

    public final boolean c() {
        return this.d.isEmpty() || this.d.equals(".");
    }
}
