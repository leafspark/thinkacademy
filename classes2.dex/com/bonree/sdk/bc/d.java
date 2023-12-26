package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import com.bonree.sdk.ac.e;
import com.bonree.sdk.bc.dd;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d extends ca {
    private static final long a = -1348173791712935864L;
    private List b;

    /* access modifiers changed from: private */
    public static boolean b(int i, int i2) {
        if (i2 < 0 || i2 >= 256) {
            return false;
        }
        return (i != 1 || i2 <= 32) && (i != 2 || i2 <= 128);
    }

    public static class a {
        public final int a;
        public final boolean b;
        public final int c;
        public final Object d;

        /* synthetic */ a(int i, boolean z, Object obj, int i2, byte b2) {
            this(i, z, obj, i2);
        }

        private a(int i, boolean z, Object obj, int i2) {
            this.a = i;
            this.b = z;
            this.d = obj;
            this.c = i2;
            if (!d.b(i, i2)) {
                throw new IllegalArgumentException("invalid prefix length");
            }
        }

        public a(boolean z, InetAddress inetAddress, int i) {
            this(i.a(inetAddress), z, inetAddress, i);
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.b) {
                stringBuffer.append("!");
            }
            stringBuffer.append(this.a);
            stringBuffer.append(":");
            int i = this.a;
            if (i == 1 || i == 2) {
                stringBuffer.append(((InetAddress) this.d).getHostAddress());
            } else {
                stringBuffer.append(e.a((byte[]) this.d));
            }
            stringBuffer.append("/");
            stringBuffer.append(this.c);
            return stringBuffer.toString();
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d.equals(aVar.d)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return this.d.hashCode() + this.c + (this.b ? 1 : 0);
        }
    }

    d() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new d();
    }

    private d(bn bnVar, int i, long j, List list) {
        super(bnVar, 42, i, j);
        this.b = new ArrayList(list.size());
        for (Object next : list) {
            if (next instanceof a) {
                a aVar = (a) next;
                if (aVar.a == 1 || aVar.a == 2) {
                    this.b.add(aVar);
                } else {
                    throw new IllegalArgumentException("unknown family");
                }
            } else {
                throw new IllegalArgumentException("illegal element");
            }
        }
    }

    private static byte[] a(byte[] bArr, int i) throws Cdo {
        if (bArr.length > i) {
            throw new Cdo("invalid address length");
        } else if (bArr.length == i) {
            return bArr;
        } else {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        a aVar;
        this.b = new ArrayList(1);
        while (tVar.b() != 0) {
            int h = tVar.h();
            int g = tVar.g();
            int g2 = tVar.g();
            boolean z = (g2 & 128) != 0;
            byte[] d = tVar.d(g2 & -129);
            if (b(h, g)) {
                if (h == 1 || h == 2) {
                    int a2 = i.a(h);
                    if (d.length <= a2) {
                        if (d.length != a2) {
                            byte[] bArr = new byte[a2];
                            System.arraycopy(d, 0, bArr, 0, d.length);
                            d = bArr;
                        }
                        aVar = new a(z, InetAddress.getByAddress(d), g);
                    } else {
                        throw new Cdo("invalid address length");
                    }
                } else {
                    aVar = new a(h, z, d, g, (byte) 0);
                }
                this.b.add(aVar);
            } else {
                throw new Cdo("invalid prefix length");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = new ArrayList(1);
        while (true) {
            dd.a a2 = ddVar.a();
            if (a2.a()) {
                String str = a2.b;
                boolean startsWith = str.startsWith("!");
                int indexOf = str.indexOf(58, startsWith ? 1 : 0);
                if (indexOf >= 0) {
                    int indexOf2 = str.indexOf(47, indexOf);
                    if (indexOf2 >= 0) {
                        String substring = str.substring(startsWith, indexOf);
                        String substring2 = str.substring(indexOf + 1, indexOf2);
                        String substring3 = str.substring(indexOf2 + 1);
                        try {
                            int parseInt = Integer.parseInt(substring);
                            if (parseInt == 1 || parseInt == 2) {
                                try {
                                    int parseInt2 = Integer.parseInt(substring3);
                                    if (b(parseInt, parseInt2)) {
                                        byte[] a3 = i.a(substring2, parseInt);
                                        if (a3 != null) {
                                            this.b.add(new a(startsWith, InetAddress.getByAddress(a3), parseInt2));
                                        } else {
                                            throw ddVar.a("invalid IP address " + substring2);
                                        }
                                    } else {
                                        throw ddVar.a("invalid prefix length");
                                    }
                                } catch (NumberFormatException unused) {
                                    throw ddVar.a("invalid prefix length");
                                }
                            } else {
                                throw ddVar.a("unknown family");
                            }
                        } catch (NumberFormatException unused2) {
                            throw ddVar.a("invalid family");
                        }
                    } else {
                        throw ddVar.a("invalid address prefix element");
                    }
                } else {
                    throw ddVar.a("invalid address prefix element");
                }
            } else {
                ddVar.b();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            stringBuffer.append((a) it.next());
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private List d() {
        return this.b;
    }

    private static int b(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != 0) {
                return length + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        int i;
        byte[] bArr;
        for (a aVar : this.b) {
            if (aVar.a == 1 || aVar.a == 2) {
                bArr = ((InetAddress) aVar.d).getAddress();
                int length = bArr.length - 1;
                while (true) {
                    if (length < 0) {
                        i = 0;
                        break;
                    } else if (bArr[length] != 0) {
                        i = length + 1;
                        break;
                    } else {
                        length--;
                    }
                }
            } else {
                bArr = (byte[]) aVar.d;
                i = bArr.length;
            }
            int i2 = aVar.b ? i | 128 : i;
            vVar.c(aVar.a);
            vVar.b(aVar.c);
            vVar.b(i2);
            vVar.a(bArr, 0, i);
        }
    }
}
