package com.bonree.sdk.bp;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.bonree.sdk.bj.a;
import com.bonree.sdk.bj.c;
import com.bonree.sdk.bp.h;
import com.luck.picture.lib.camera.CustomCameraView;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class v<D extends h> {
    public final com.bonree.sdk.bk.a a;
    public final b b;
    public final a c;
    public final int d;
    public final long e;
    public final D f;
    private boolean g;
    private transient byte[] h;
    private transient Integer i;

    public enum b {
        UNKNOWN(-1),
        A(1, a.class),
        NS(2, m.class),
        MD(3),
        MF(4),
        CNAME(5, c.class),
        SOA(6, x.class),
        MB(7),
        MG(8),
        MR(9),
        NULL(10),
        WKS(11),
        PTR(12, s.class),
        HINFO(13),
        MINFO(14),
        MX(15, l.class),
        TXT(16, aa.class),
        RP(17),
        AFSDB(18),
        X25(19),
        ISDN(20),
        RT(21),
        NSAP(22),
        NSAP_PTR(23),
        SIG(24),
        KEY(25),
        PX(26),
        GPOS(27),
        AAAA(28, b.class),
        LOC(29),
        NXT(30),
        EID(31),
        NIMLOC(32),
        SRV(33, y.class),
        ATMA(34),
        NAPTR(35),
        KX(36),
        CERT(37),
        A6(38),
        DNAME(39, e.class),
        SINK(40),
        OPT(41, r.class),
        APL(42),
        DS(43, g.class),
        SSHFP(44),
        IPSECKEY(45),
        RRSIG(46, t.class),
        NSEC(47, n.class),
        DNSKEY(48, f.class),
        DHCID(49),
        NSEC3(50, o.class),
        NSEC3PARAM(51, p.class),
        TLSA(52, z.class),
        HIP(55),
        NINFO(56),
        RKEY(57),
        TALINK(58),
        CDS(59),
        CDNSKEY(60),
        OPENPGPKEY(61, q.class),
        CSYNC(62),
        SPF(99),
        UINFO(100),
        UID(101),
        GID(102),
        UNSPEC(103),
        NID(104),
        L32(105),
        L64(106),
        LP(107),
        EUI48(108),
        EUI64(109),
        TKEY(249),
        TSIG(250),
        IXFR(251),
        AXFR(252),
        MAILB(253),
        MAILA(254),
        ANY(255),
        URI(WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT),
        CAA(CustomCameraView.BUTTON_STATE_ONLY_CAPTURE),
        TA(32768),
        DLV(32769, d.class);
        
        private static final Map<Integer, b> c = null;
        private static final Map<Class<?>, b> d = null;
        private final int a;
        /* access modifiers changed from: private */
        public final Class<?> b;

        static {
            c = new HashMap();
            d = new HashMap();
            for (b bVar : values()) {
                c.put(Integer.valueOf(bVar.a), bVar);
                Class<?> cls = bVar.b;
                if (cls != null) {
                    d.put(cls, bVar);
                }
            }
        }

        private b(int i) {
            this(r2, r3, i, (Class) null);
        }

        private <D extends h> b(int i, Class<D> cls) {
            this.a = i;
            this.b = cls;
        }

        public final int a() {
            return this.a;
        }

        private <D extends h> Class<D> b() {
            return this.b;
        }

        public static b a(int i) {
            b bVar = c.get(Integer.valueOf(i));
            return bVar == null ? UNKNOWN : bVar;
        }

        private static <D extends h> b a(Class<D> cls) {
            return d.get(cls);
        }
    }

    public enum a {
        IN(1),
        CH(3),
        HS(4),
        NONE(254),
        ANY(255);
        
        private static final HashMap<Integer, a> a = null;
        private final int b;

        static {
            int i;
            a = new HashMap<>();
            for (a aVar : values()) {
                a.put(Integer.valueOf(aVar.b), aVar);
            }
        }

        private a(int i) {
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public static a a(int i) {
            return a.get(Integer.valueOf(i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.bonree.sdk.bp.x} */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.bonree.sdk.bp.y] */
    /* JADX WARNING: type inference failed for: r0v8, types: [com.bonree.sdk.bp.b] */
    /* JADX WARNING: type inference failed for: r0v9, types: [com.bonree.sdk.bp.a] */
    /* JADX WARNING: type inference failed for: r0v14, types: [com.bonree.sdk.bp.aa] */
    /* JADX WARNING: type inference failed for: r0v15, types: [com.bonree.sdk.bp.r] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.bonree.sdk.bp.f] */
    /* JADX WARNING: type inference failed for: r0v17, types: [com.bonree.sdk.bp.t] */
    /* JADX WARNING: type inference failed for: r0v18, types: [com.bonree.sdk.bp.g] */
    /* JADX WARNING: type inference failed for: r0v19, types: [com.bonree.sdk.bp.n] */
    /* JADX WARNING: type inference failed for: r0v20, types: [com.bonree.sdk.bp.o] */
    /* JADX WARNING: type inference failed for: r0v21, types: [com.bonree.sdk.bp.p] */
    /* JADX WARNING: type inference failed for: r0v22, types: [com.bonree.sdk.bp.z] */
    /* JADX WARNING: type inference failed for: r0v23, types: [com.bonree.sdk.bp.q] */
    /* JADX WARNING: type inference failed for: r0v24, types: [com.bonree.sdk.bp.d] */
    /* JADX WARNING: type inference failed for: r0v25, types: [com.bonree.sdk.bp.ab] */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d1, code lost:
        r19 = r8;
        r8 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d9, code lost:
        r19 = r8;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0111, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011f, code lost:
        return new com.bonree.sdk.bp.v(r2, r3, r5, r4, r6, r8, r19);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bonree.sdk.bp.v<com.bonree.sdk.bp.h> a(java.io.DataInputStream r22, byte[] r23) throws java.io.IOException {
        /*
            r0 = r22
            r1 = r23
            com.bonree.sdk.bk.a r2 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            int r3 = r22.readUnsignedShort()
            com.bonree.sdk.bp.v$b r3 = com.bonree.sdk.bp.v.b.a((int) r3)
            int r4 = r22.readUnsignedShort()
            r5 = r4 & 32767(0x7fff, float:4.5916E-41)
            com.bonree.sdk.bp.v$a r5 = com.bonree.sdk.bp.v.a.a(r5)
            r6 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 & r4
            if (r6 <= 0) goto L_0x0022
            r6 = 1
            goto L_0x0023
        L_0x0022:
            r6 = 0
        L_0x0023:
            r8 = r6
            int r6 = r22.readUnsignedShort()
            long r6 = (long) r6
            r9 = 16
            long r6 = r6 << r9
            int r9 = r22.readUnsignedShort()
            long r9 = (long) r9
            long r6 = r6 + r9
            int r9 = r22.readUnsignedShort()
            int[] r10 = com.bonree.sdk.bp.w.a
            int r11 = r3.ordinal()
            r10 = r10[r11]
            switch(r10) {
                case 1: goto L_0x00dc;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00bf;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00b0;
                case 7: goto L_0x00a6;
                case 8: goto L_0x009c;
                case 9: goto L_0x0092;
                case 10: goto L_0x0087;
                case 11: goto L_0x0082;
                case 12: goto L_0x007d;
                case 13: goto L_0x0078;
                case 14: goto L_0x0073;
                case 15: goto L_0x006d;
                case 16: goto L_0x0067;
                case 17: goto L_0x0061;
                case 18: goto L_0x005b;
                case 19: goto L_0x004f;
                case 20: goto L_0x0049;
                default: goto L_0x0041;
            }
        L_0x0041:
            r19 = r8
            com.bonree.sdk.bp.ab r0 = com.bonree.sdk.bp.ab.a(r0, r9, r3)
            goto L_0x0111
        L_0x0049:
            com.bonree.sdk.bp.d r0 = com.bonree.sdk.bp.d.a(r0, r9)
            goto L_0x00d9
        L_0x004f:
            byte[] r1 = new byte[r9]
            r0.readFully(r1)
            com.bonree.sdk.bp.q r0 = new com.bonree.sdk.bp.q
            r0.<init>(r1)
            goto L_0x00d9
        L_0x005b:
            com.bonree.sdk.bp.z r0 = com.bonree.sdk.bp.z.a(r0, r9)
            goto L_0x00d9
        L_0x0061:
            com.bonree.sdk.bp.p r0 = com.bonree.sdk.bp.p.a((java.io.DataInputStream) r22)
            goto L_0x00d9
        L_0x0067:
            com.bonree.sdk.bp.o r0 = com.bonree.sdk.bp.o.a((java.io.DataInputStream) r0, (int) r9)
            goto L_0x00d9
        L_0x006d:
            com.bonree.sdk.bp.n r0 = com.bonree.sdk.bp.n.a(r0, r1, r9)
            goto L_0x00d9
        L_0x0073:
            com.bonree.sdk.bp.g r0 = com.bonree.sdk.bp.g.a(r0, r9)
            goto L_0x00d9
        L_0x0078:
            com.bonree.sdk.bp.t r0 = com.bonree.sdk.bp.t.a(r0, r1, r9)
            goto L_0x00d9
        L_0x007d:
            com.bonree.sdk.bp.f r0 = com.bonree.sdk.bp.f.a(r0, r9)
            goto L_0x00d9
        L_0x0082:
            com.bonree.sdk.bp.r r0 = com.bonree.sdk.bp.r.a(r0, r9)
            goto L_0x00d9
        L_0x0087:
            byte[] r1 = new byte[r9]
            r0.readFully(r1)
            com.bonree.sdk.bp.aa r0 = new com.bonree.sdk.bp.aa
            r0.<init>(r1)
            goto L_0x00d9
        L_0x0092:
            com.bonree.sdk.bk.a r0 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            com.bonree.sdk.bp.s r1 = new com.bonree.sdk.bp.s
            r1.<init>((com.bonree.sdk.bk.a) r0)
            goto L_0x00d1
        L_0x009c:
            com.bonree.sdk.bk.a r0 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            com.bonree.sdk.bp.e r1 = new com.bonree.sdk.bp.e
            r1.<init>((com.bonree.sdk.bk.a) r0)
            goto L_0x00d1
        L_0x00a6:
            com.bonree.sdk.bk.a r0 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            com.bonree.sdk.bp.c r1 = new com.bonree.sdk.bp.c
            r1.<init>((com.bonree.sdk.bk.a) r0)
            goto L_0x00d1
        L_0x00b0:
            com.bonree.sdk.bk.a r0 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            com.bonree.sdk.bp.m r1 = new com.bonree.sdk.bp.m
            r1.<init>(r0)
            goto L_0x00d1
        L_0x00ba:
            com.bonree.sdk.bp.a r0 = com.bonree.sdk.bp.a.a(r22)
            goto L_0x00d9
        L_0x00bf:
            com.bonree.sdk.bp.b r0 = com.bonree.sdk.bp.b.a(r22)
            goto L_0x00d9
        L_0x00c4:
            int r9 = r22.readUnsignedShort()
            com.bonree.sdk.bk.a r0 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            com.bonree.sdk.bp.l r1 = new com.bonree.sdk.bp.l
            r1.<init>((int) r9, (com.bonree.sdk.bk.a) r0)
        L_0x00d1:
            r19 = r8
            r8 = r1
            goto L_0x0112
        L_0x00d5:
            com.bonree.sdk.bp.y r0 = com.bonree.sdk.bp.y.a(r22, r23)
        L_0x00d9:
            r19 = r8
            goto L_0x0111
        L_0x00dc:
            com.bonree.sdk.bk.a r10 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            com.bonree.sdk.bk.a r11 = com.bonree.sdk.bk.a.a((java.io.DataInputStream) r22, (byte[]) r23)
            int r1 = r22.readInt()
            long r12 = (long) r1
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r12 = r12 & r14
            int r1 = r22.readInt()
            int r16 = r22.readInt()
            int r17 = r22.readInt()
            int r0 = r22.readInt()
            r19 = r8
            long r8 = (long) r0
            long r20 = r8 & r14
            com.bonree.sdk.bp.x r0 = new com.bonree.sdk.bp.x
            r9 = r0
            r14 = r1
            r15 = r16
            r16 = r17
            r17 = r20
            r9.<init>((com.bonree.sdk.bk.a) r10, (com.bonree.sdk.bk.a) r11, (long) r12, (int) r14, (int) r15, (int) r16, (long) r17)
        L_0x0111:
            r8 = r0
        L_0x0112:
            com.bonree.sdk.bp.v r9 = new com.bonree.sdk.bp.v
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r7 = r8
            r8 = r19
            r0.<init>(r1, r2, r3, r4, r5, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bp.v.a(java.io.DataInputStream, byte[]):com.bonree.sdk.bp.v");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private v(com.bonree.sdk.bk.a aVar, b bVar, a aVar2, long j, D d2, boolean z) {
        this(aVar, bVar, aVar2, aVar2.a() + (z ? 32768 : 0), j, d2, z);
    }

    private v(String str, b bVar, a aVar, long j, D d2, boolean z) {
        this(com.bonree.sdk.bk.a.a(str), bVar, aVar, j, d2, z);
    }

    private v(String str, b bVar, int i2, long j, D d2) {
        this(com.bonree.sdk.bk.a.a(str), bVar, a.NONE, i2, j, d2, false);
    }

    public v(com.bonree.sdk.bk.a aVar, b bVar, int i2, long j, D d2) {
        this(aVar, bVar, a.NONE, i2, j, d2, false);
    }

    private v(com.bonree.sdk.bk.a aVar, b bVar, a aVar2, int i2, long j, D d2, boolean z) {
        this.a = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.d = i2;
        this.e = j;
        this.f = d2;
        this.g = z;
    }

    private void a(OutputStream outputStream) throws IOException {
        if (this.f != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            this.a.a((OutputStream) dataOutputStream);
            dataOutputStream.writeShort(this.b.a());
            dataOutputStream.writeShort(this.d);
            dataOutputStream.writeInt((int) this.e);
            dataOutputStream.writeShort(this.f.b());
            this.f.b(dataOutputStream);
            return;
        }
        throw new IllegalStateException("Empty Record has no byte representation");
    }

    public final byte[] a() {
        if (this.h == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.a.b() + 10 + this.f.b());
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                if (this.f != null) {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(dataOutputStream);
                    this.a.a((OutputStream) dataOutputStream2);
                    dataOutputStream2.writeShort(this.b.a());
                    dataOutputStream2.writeShort(this.d);
                    dataOutputStream2.writeInt((int) this.e);
                    dataOutputStream2.writeShort(this.f.b());
                    this.f.b(dataOutputStream2);
                    this.h = byteArrayOutputStream.toByteArray();
                } else {
                    throw new IllegalStateException("Empty Record has no byte representation");
                }
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
        return (byte[]) this.h.clone();
    }

    public final String toString() {
        return this.a.a() + ".\t" + this.e + 9 + this.c + 9 + this.b + 9 + this.f;
    }

    public final boolean a(c cVar) {
        if (cVar.b == this.b || cVar.b == b.ANY) {
            return (cVar.c == this.c || cVar.c == a.ANY) && cVar.a.equals(this.a);
        }
        return false;
    }

    private boolean e() {
        return this.g;
    }

    public final D b() {
        return this.f;
    }

    private long f() {
        return this.e;
    }

    public final c c() {
        int i2 = w.a[this.b.ordinal()];
        if (i2 == 11) {
            return null;
        }
        if (i2 != 13) {
            return new c(this.a, this.b, this.c);
        }
        return new c(this.a, ((t) this.f).a, this.c);
    }

    public final a.C0014a d() {
        c c2 = c();
        if (c2 == null) {
            return null;
        }
        return c2.b();
    }

    public final int hashCode() {
        if (this.i == null) {
            this.i = Integer.valueOf(((((((this.a.hashCode() + 37) * 37) + this.b.hashCode()) * 37) + this.c.hashCode()) * 37) + this.f.hashCode());
        }
        return this.i.intValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        v vVar = (v) obj;
        return this.a.equals(vVar.a) && this.b == vVar.b && this.c == vVar.c && this.f.equals(vVar.f);
    }

    public final <E extends h> v<E> a(Class<E> cls) {
        if (this.b.b == cls) {
            return this;
        }
        return null;
    }

    private <E extends h> v<E> b(Class<E> cls) {
        v<E> a2 = a(cls);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalArgumentException("The instance " + this + " can not be cast to a Record with" + cls);
    }

    private static <E extends h> void a(Collection<v<E>> collection, Class<E> cls, Collection<v<? extends h>> collection2) {
        for (v<? extends h> a2 : collection2) {
            v<E> a3 = a2.a(cls);
            if (a3 != null) {
                collection.add(a3);
            }
        }
    }

    private static <E extends h> List<v<E>> a(Class<E> cls, Collection<v<? extends h>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        a(arrayList, cls, collection);
        return arrayList;
    }
}
