package com.bonree.sdk.bj;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.bonree.sdk.bn.a;
import com.bonree.sdk.bp.h;
import com.bonree.sdk.bp.r;
import com.bonree.sdk.bp.v;
import com.facebook.soloader.MinElf;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a {
    private static final Logger p = Logger.getLogger(a.class.getName());
    public final int a;
    public final b b;
    public final c c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final List<c> k;
    public final List<v<? extends h>> l;
    public final List<v<? extends h>> m;
    public final List<v<? extends h>> n;
    public final long o;
    private int q;
    private com.bonree.sdk.bn.a r;
    private byte[] s;
    private String t;
    private String u;
    private long v;
    private a w;
    private transient Integer x;

    enum d {
        answer,
        authority,
        additional
    }

    public enum c {
        NO_ERROR(0),
        FORMAT_ERR(1),
        SERVER_FAIL(2),
        NX_DOMAIN(3),
        NO_IMP(4),
        REFUSED(5),
        YXDOMAIN(6),
        YXRRSET(7),
        NXRRSET(8),
        NOT_AUTH(9),
        NOT_ZONE(10),
        BADVERS_BADSIG(16),
        BADKEY(17),
        BADTIME(18),
        BADMODE(19),
        BADNAME(20),
        BADALG(21),
        BADTRUNC(22),
        BADCOOKIE(23);
        
        private static final Map<Integer, c> a = null;
        private final byte b;

        static {
            a = new HashMap(values().length);
            for (c cVar : values()) {
                a.put(Integer.valueOf(cVar.b), cVar);
            }
        }

        private c(int i) {
            this.b = (byte) i;
        }

        public final byte a() {
            return this.b;
        }

        public static c a(int i) throws IllegalArgumentException {
            if (i >= 0 && i <= 65535) {
                return a.get(Integer.valueOf(i));
            }
            throw new IllegalArgumentException();
        }
    }

    public enum b {
        QUERY,
        INVERSE_QUERY,
        STATUS,
        UNASSIGNED3,
        NOTIFY,
        UPDATE;
        
        private static final b[] a = null;
        private final byte b;

        static {
            int i;
            a = new b[values().length];
            b[] values = values();
            int length = values.length;
            while (i < length) {
                b bVar = values[i];
                b[] bVarArr = a;
                byte b2 = bVar.b;
                if (bVarArr[b2] == null) {
                    bVarArr[b2] = bVar;
                    i++;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public final byte a() {
            return this.b;
        }

        public static b a(int i) throws IllegalArgumentException {
            if (i < 0 || i > 15) {
                throw new IllegalArgumentException();
            }
            b[] bVarArr = a;
            if (i >= bVarArr.length) {
                return null;
            }
            return bVarArr[i];
        }
    }

    protected a(C0014a aVar) {
        this.v = -1;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.o = aVar.k;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        if (aVar.l == null) {
            this.k = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(aVar.l.size());
            arrayList.addAll(aVar.l);
            this.k = Collections.unmodifiableList(arrayList);
        }
        if (aVar.m == null) {
            this.l = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(aVar.m.size());
            arrayList2.addAll(aVar.m);
            this.l = Collections.unmodifiableList(arrayList2);
        }
        if (aVar.n == null) {
            this.m = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(aVar.n.size());
            arrayList3.addAll(aVar.n);
            this.m = Collections.unmodifiableList(arrayList3);
        }
        if (aVar.o == null && aVar.p == null) {
            this.n = Collections.emptyList();
        } else {
            int size = aVar.o != null ? 0 + aVar.o.size() : 0;
            ArrayList arrayList4 = new ArrayList(aVar.p != null ? size + 1 : size);
            if (aVar.o != null) {
                arrayList4.addAll(aVar.o);
            }
            if (aVar.p != null) {
                com.bonree.sdk.bn.a aVar2 = new com.bonree.sdk.bn.a(aVar.p);
                this.r = aVar2;
                arrayList4.add(aVar2.a());
            }
            this.n = Collections.unmodifiableList(arrayList4);
        }
        int a2 = a(this.n);
        this.q = a2;
        if (a2 != -1) {
            do {
                a2++;
                if (a2 >= this.n.size()) {
                    return;
                }
            } while (this.n.get(a2).b != v.b.OPT);
            throw new IllegalArgumentException("There must be only one OPT pseudo RR in the additional section");
        }
    }

    public a(byte[] bArr) throws IOException {
        this.v = -1;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.a = dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        boolean z = true;
        this.d = ((readUnsignedShort >> 15) & 1) == 1;
        this.b = b.a((readUnsignedShort >> 11) & 15);
        this.e = ((readUnsignedShort >> 10) & 1) == 1;
        this.f = ((readUnsignedShort >> 9) & 1) == 1;
        this.g = ((readUnsignedShort >> 8) & 1) == 1;
        this.h = ((readUnsignedShort >> 7) & 1) == 1;
        this.i = ((readUnsignedShort >> 5) & 1) == 1;
        this.j = ((readUnsignedShort >> 4) & 1) != 1 ? false : z;
        this.c = c.a(readUnsignedShort & 15);
        this.o = System.currentTimeMillis();
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        int readUnsignedShort5 = dataInputStream.readUnsignedShort();
        this.k = new ArrayList(readUnsignedShort2);
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            this.k.add(new c(dataInputStream, bArr));
        }
        this.l = new ArrayList(readUnsignedShort3);
        for (int i3 = 0; i3 < readUnsignedShort3; i3++) {
            this.l.add(v.a(dataInputStream, bArr));
        }
        this.m = new ArrayList(readUnsignedShort4);
        for (int i4 = 0; i4 < readUnsignedShort4; i4++) {
            this.m.add(v.a(dataInputStream, bArr));
        }
        this.n = new ArrayList(readUnsignedShort5);
        for (int i5 = 0; i5 < readUnsignedShort5; i5++) {
            this.n.add(v.a(dataInputStream, bArr));
        }
        this.q = a(this.n);
    }

    private a(a aVar) {
        this.v = -1;
        this.a = 0;
        this.d = aVar.d;
        this.b = aVar.b;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.c = aVar.c;
        this.o = aVar.o;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.q = aVar.q;
    }

    private static int a(List<v<? extends h>> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).b == v.b.OPT) {
                return i2;
            }
        }
        return -1;
    }

    public final byte[] a() {
        return (byte[]) h().clone();
    }

    public final DatagramPacket a(InetAddress inetAddress, int i2) {
        byte[] h2 = h();
        return new DatagramPacket(h2, h2.length, inetAddress, i2);
    }

    private void a(OutputStream outputStream, boolean z) throws IOException {
        byte[] h2 = h();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeShort(h2.length);
        dataOutputStream.write(h2);
    }

    private ByteBuffer g() {
        return ByteBuffer.wrap((byte[]) h().clone());
    }

    private byte[] h() {
        byte[] bArr = this.s;
        if (bArr != null) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i2 = this.d ? 32768 : 0;
        b bVar = this.b;
        if (bVar != null) {
            i2 += bVar.a() << 11;
        }
        if (this.e) {
            i2 += PictureFileUtils.KB;
        }
        if (this.f) {
            i2 += 512;
        }
        if (this.g) {
            i2 += WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT;
        }
        if (this.h) {
            i2 += 128;
        }
        if (this.i) {
            i2 += 32;
        }
        if (this.j) {
            i2 += 16;
        }
        c cVar = this.c;
        if (cVar != null) {
            i2 += cVar.a();
        }
        try {
            dataOutputStream.writeShort((short) this.a);
            dataOutputStream.writeShort((short) i2);
            List<c> list = this.k;
            if (list == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list.size());
            }
            List<v<? extends h>> list2 = this.l;
            if (list2 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list2.size());
            }
            List<v<? extends h>> list3 = this.m;
            if (list3 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list3.size());
            }
            List<v<? extends h>> list4 = this.n;
            if (list4 == null) {
                dataOutputStream.writeShort(0);
            } else {
                dataOutputStream.writeShort((short) list4.size());
            }
            List<c> list5 = this.k;
            if (list5 != null) {
                for (c a2 : list5) {
                    dataOutputStream.write(a2.a());
                }
            }
            List<v<? extends h>> list6 = this.l;
            if (list6 != null) {
                for (v<? extends h> a3 : list6) {
                    dataOutputStream.write(a3.a());
                }
            }
            List<v<? extends h>> list7 = this.m;
            if (list7 != null) {
                for (v<? extends h> a4 : list7) {
                    dataOutputStream.write(a4.a());
                }
            }
            List<v<? extends h>> list8 = this.n;
            if (list8 != null) {
                for (v<? extends h> a5 : list8) {
                    dataOutputStream.write(a5.a());
                }
            }
            dataOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.s = byteArray;
            return byteArray;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private int i() {
        int i2 = this.d ? 32768 : 0;
        b bVar = this.b;
        if (bVar != null) {
            i2 += bVar.a() << 11;
        }
        if (this.e) {
            i2 += PictureFileUtils.KB;
        }
        if (this.f) {
            i2 += 512;
        }
        if (this.g) {
            i2 += WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT;
        }
        if (this.h) {
            i2 += 128;
        }
        if (this.i) {
            i2 += 32;
        }
        if (this.j) {
            i2 += 16;
        }
        c cVar = this.c;
        return cVar != null ? i2 + cVar.a() : i2;
    }

    public final c b() {
        return this.k.get(0);
    }

    private List<c> j() {
        ArrayList arrayList = new ArrayList(this.k.size());
        arrayList.addAll(this.k);
        return arrayList;
    }

    private List<v<? extends h>> k() {
        ArrayList arrayList = new ArrayList(this.l.size());
        arrayList.addAll(this.l);
        return arrayList;
    }

    private List<v<? extends h>> l() {
        ArrayList arrayList = new ArrayList(this.m.size());
        arrayList.addAll(this.m);
        return arrayList;
    }

    private com.bonree.sdk.bn.a m() {
        v vVar;
        com.bonree.sdk.bn.a aVar = this.r;
        if (aVar != null) {
            return aVar;
        }
        int i2 = this.q;
        if (i2 == -1) {
            vVar = null;
        } else {
            vVar = this.n.get(i2);
        }
        if (vVar == null) {
            return null;
        }
        com.bonree.sdk.bn.a aVar2 = new com.bonree.sdk.bn.a((v<r>) vVar);
        this.r = aVar2;
        return aVar2;
    }

    private v<r> n() {
        int i2 = this.q;
        if (i2 == -1) {
            return null;
        }
        return this.n.get(i2);
    }

    public String toString() {
        String str = this.t;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder("DnsMessage");
        d().a(sb);
        String sb2 = sb.toString();
        this.t = sb2;
        return sb2;
    }

    private String p() {
        String str = this.u;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(";; ->>HEADER<<- opcode: ");
        sb.append(this.b);
        sb.append(", status: ");
        sb.append(this.c);
        sb.append(", id: ");
        sb.append(this.a);
        sb.append("\n;; flags:");
        if (!this.d) {
            sb.append(" qr");
        }
        if (this.e) {
            sb.append(" aa");
        }
        if (this.f) {
            sb.append(" tr");
        }
        if (this.g) {
            sb.append(" rd");
        }
        if (this.h) {
            sb.append(" ra");
        }
        if (this.i) {
            sb.append(" ad");
        }
        if (this.j) {
            sb.append(" cd");
        }
        sb.append("; QUERY: ");
        sb.append(this.k.size());
        sb.append(", ANSWER: ");
        sb.append(this.l.size());
        sb.append(", AUTHORITY: ");
        sb.append(this.m.size());
        sb.append(", ADDITIONAL: ");
        sb.append(this.n.size());
        sb.append("\n\n");
        Iterator<v<? extends h>> it = this.n.iterator();
        while (true) {
            if (it.hasNext()) {
                com.bonree.sdk.bn.a a2 = com.bonree.sdk.bn.a.a(it.next());
                if (a2 != null) {
                    sb.append(";; OPT PSEUDOSECTION:\n; ");
                    sb.append(a2.b());
                    break;
                }
            } else {
                break;
            }
        }
        if (this.k.size() != 0) {
            sb.append(";; QUESTION SECTION:\n");
            for (c cVar : this.k) {
                sb.append(';');
                sb.append(cVar.toString());
                sb.append(10);
            }
        }
        if (this.m.size() != 0) {
            sb.append("\n;; AUTHORITY SECTION:\n");
            for (v<? extends h> vVar : this.m) {
                sb.append(vVar.toString());
                sb.append(10);
            }
        }
        if (this.l.size() != 0) {
            sb.append("\n;; ANSWER SECTION:\n");
            for (v<? extends h> vVar2 : this.l) {
                sb.append(vVar2.toString());
                sb.append(10);
            }
        }
        if (this.n.size() != 0) {
            boolean z = false;
            for (v next : this.n) {
                if (next.b != v.b.OPT) {
                    if (!z) {
                        z = true;
                        sb.append("\n;; ADDITIONAL SECTION:\n");
                    }
                    sb.append(next.toString());
                    sb.append(10);
                }
            }
        }
        if (this.o > 0) {
            sb.append("\n;; WHEN: ");
            sb.append(new Date(this.o).toString());
        }
        String sb2 = sb.toString();
        this.u = sb2;
        return sb2;
    }

    public final <D extends h> Set<D> a(c cVar) {
        if (this.c != c.NO_ERROR) {
            return null;
        }
        HashSet hashSet = new HashSet(this.l.size());
        for (v next : this.l) {
            if (next.a(cVar) && !hashSet.add(next.f)) {
                Logger logger = p;
                Level level = Level.WARNING;
                logger.log(level, "DnsMessage contains duplicate answers. Record: " + next + "; DnsMessage: " + this);
            }
        }
        return hashSet;
    }

    public final long c() {
        long j2 = this.v;
        if (j2 >= 0) {
            return j2;
        }
        this.v = Long.MAX_VALUE;
        for (v<? extends h> vVar : this.l) {
            this.v = Math.min(this.v, vVar.e);
        }
        return this.v;
    }

    public final C0014a d() {
        return new C0014a(this, (byte) 0);
    }

    public final a e() {
        if (this.w == null) {
            this.w = new a(this);
        }
        return this.w;
    }

    private C0014a a(c cVar) {
        if (!this.d) {
            return f().a(true).a(cVar).a(this.a).b(b());
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        if (this.x == null) {
            this.x = Integer.valueOf(Arrays.hashCode(h()));
        }
        return this.x.intValue();
    }

    private <D extends h> List<v<D>> a(boolean z, d dVar, Class<D> cls) {
        List<v<? extends h>> list;
        int i2 = b.a[dVar.ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            list = this.l;
        } else if (i2 == 2) {
            list = this.m;
        } else if (i2 == 3) {
            list = this.n;
        } else {
            throw new AssertionError("Unknown section name " + dVar);
        }
        if (!z) {
            i3 = list.size();
        }
        ArrayList arrayList = new ArrayList(i3);
        for (v<? extends h> a2 : list) {
            v<E> a3 = a2.a((Class<E>) cls);
            if (a3 != null) {
                arrayList.add(a3);
                if (z) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private <D extends h> List<v<D>> a(d dVar, Class<D> cls) {
        return a(false, dVar, cls);
    }

    private <D extends h> v<D> b(d dVar, Class<D> cls) {
        List<v<D>> a2 = a(true, dVar, cls);
        if (a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    private <D extends h> List<v<D>> a(Class<D> cls) {
        return a(false, d.answer, cls);
    }

    private <D extends h> List<v<D>> b(Class<D> cls) {
        return a(false, d.authority, cls);
    }

    private <D extends h> List<v<D>> c(Class<D> cls) {
        return a(false, d.additional, cls);
    }

    private <D extends h> v<D> d(Class<D> cls) {
        return b(d.answer, cls);
    }

    private <D extends h> v<D> e(Class<D> cls) {
        return b(d.authority, cls);
    }

    private <D extends h> v<D> f(Class<D> cls) {
        return b(d.additional, cls);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(h(), ((a) obj).h());
    }

    public static C0014a f() {
        return new C0014a((byte) 0);
    }

    /* renamed from: com.bonree.sdk.bj.a$a  reason: collision with other inner class name */
    public static final class C0014a {
        /* access modifiers changed from: private */
        public int a;
        /* access modifiers changed from: private */
        public b b;
        /* access modifiers changed from: private */
        public c c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public boolean e;
        /* access modifiers changed from: private */
        public boolean f;
        /* access modifiers changed from: private */
        public boolean g;
        /* access modifiers changed from: private */
        public boolean h;
        /* access modifiers changed from: private */
        public boolean i;
        /* access modifiers changed from: private */
        public boolean j;
        /* access modifiers changed from: private */
        public long k;
        /* access modifiers changed from: private */
        public List<c> l;
        /* access modifiers changed from: private */
        public List<v<? extends h>> m;
        /* access modifiers changed from: private */
        public List<v<? extends h>> n;
        /* access modifiers changed from: private */
        public List<v<? extends h>> o;
        /* access modifiers changed from: private */
        public a.C0016a p;

        /* synthetic */ C0014a(byte b2) {
            this();
        }

        /* synthetic */ C0014a(a aVar, byte b2) {
            this(aVar);
        }

        private C0014a() {
            this.b = b.QUERY;
            this.c = c.NO_ERROR;
            this.k = -1;
        }

        private C0014a(a aVar) {
            this.b = b.QUERY;
            this.c = c.NO_ERROR;
            this.k = -1;
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.o;
            ArrayList arrayList = new ArrayList(aVar.k.size());
            this.l = arrayList;
            arrayList.addAll(aVar.k);
            ArrayList arrayList2 = new ArrayList(aVar.l.size());
            this.m = arrayList2;
            arrayList2.addAll(aVar.l);
            ArrayList arrayList3 = new ArrayList(aVar.m.size());
            this.n = arrayList3;
            arrayList3.addAll(aVar.m);
            ArrayList arrayList4 = new ArrayList(aVar.n.size());
            this.o = arrayList4;
            arrayList4.addAll(aVar.n);
        }

        public final C0014a a(int i2) {
            this.a = i2 & MinElf.PN_XNUM;
            return this;
        }

        public final C0014a a(b bVar) {
            this.b = bVar;
            return this;
        }

        public final C0014a a(c cVar) {
            this.c = cVar;
            return this;
        }

        public final C0014a a(boolean z) {
            this.d = z;
            return this;
        }

        public final C0014a b(boolean z) {
            this.e = true;
            return this;
        }

        private C0014a d(boolean z) {
            this.f = z;
            return this;
        }

        public final C0014a c(boolean z) {
            this.g = true;
            return this;
        }

        private C0014a e(boolean z) {
            this.h = z;
            return this;
        }

        private C0014a f(boolean z) {
            this.i = z;
            return this;
        }

        @Deprecated
        private C0014a g(boolean z) {
            this.j = z;
            return this;
        }

        private C0014a h(boolean z) {
            this.j = z;
            return this;
        }

        public final void a(a aVar) {
            this.d = aVar.d;
            this.e = aVar.i;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
        }

        private C0014a a(long j2) {
            this.k = j2;
            return this;
        }

        public final C0014a a(c cVar) {
            if (this.l == null) {
                this.l = new ArrayList(1);
            }
            this.l.add(cVar);
            return this;
        }

        private C0014a a(List<c> list) {
            this.l = list;
            return this;
        }

        public final C0014a b(c cVar) {
            ArrayList arrayList = new ArrayList(1);
            this.l = arrayList;
            arrayList.add(cVar);
            return this;
        }

        private C0014a a(v<? extends h> vVar) {
            if (this.m == null) {
                this.m = new ArrayList(1);
            }
            this.m.add(vVar);
            return this;
        }

        public final C0014a a(Collection<v<? extends h>> collection) {
            if (this.m == null) {
                this.m = new ArrayList(collection.size());
            }
            this.m.addAll(collection);
            return this;
        }

        private C0014a c(Collection<v<? extends h>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            this.m = arrayList;
            arrayList.addAll(collection);
            return this;
        }

        private List<v<? extends h>> c() {
            List<v<? extends h>> list = this.m;
            return list == null ? Collections.emptyList() : list;
        }

        private C0014a b(v<? extends h> vVar) {
            if (this.n == null) {
                this.n = new ArrayList(8);
            }
            this.n.add(vVar);
            return this;
        }

        private C0014a d(Collection<v<? extends h>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            this.n = arrayList;
            arrayList.addAll(collection);
            return this;
        }

        public final C0014a b(Collection<v<? extends h>> collection) {
            ArrayList arrayList = new ArrayList(collection.size());
            this.o = arrayList;
            arrayList.addAll(collection);
            return this;
        }

        private C0014a c(v<? extends h> vVar) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            this.o.add(vVar);
            return this;
        }

        private C0014a b(List<v<? extends h>> list) {
            if (this.o == null) {
                this.o = new ArrayList(list.size());
            }
            this.o.addAll(list);
            return this;
        }

        private List<v<? extends h>> d() {
            List<v<? extends h>> list = this.o;
            return list == null ? Collections.emptyList() : list;
        }

        public final a.C0016a a() {
            if (this.p == null) {
                this.p = com.bonree.sdk.bn.a.c();
            }
            return this.p;
        }

        public final a b() {
            return new a(this);
        }

        /* access modifiers changed from: private */
        public void a(StringBuilder sb) {
            sb.append('(');
            sb.append(this.a);
            sb.append(' ');
            sb.append(this.b);
            sb.append(' ');
            sb.append(this.c);
            sb.append(' ');
            if (this.d) {
                sb.append("resp[qr=1]");
            } else {
                sb.append("query[qr=0]");
            }
            if (this.e) {
                sb.append(" aa");
            }
            if (this.f) {
                sb.append(" tr");
            }
            if (this.g) {
                sb.append(" rd");
            }
            if (this.h) {
                sb.append(" ra");
            }
            if (this.i) {
                sb.append(" ad");
            }
            if (this.j) {
                sb.append(" cd");
            }
            sb.append(")\n");
            List<c> list = this.l;
            if (list != null) {
                for (c append : list) {
                    sb.append("[Q: ");
                    sb.append(append);
                    sb.append("]\n");
                }
            }
            List<v<? extends h>> list2 = this.m;
            if (list2 != null) {
                for (v<? extends h> append2 : list2) {
                    sb.append("[A: ");
                    sb.append(append2);
                    sb.append("]\n");
                }
            }
            List<v<? extends h>> list3 = this.n;
            if (list3 != null) {
                for (v<? extends h> append3 : list3) {
                    sb.append("[N: ");
                    sb.append(append3);
                    sb.append("]\n");
                }
            }
            List<v<? extends h>> list4 = this.o;
            if (list4 != null) {
                for (v next : list4) {
                    sb.append("[X: ");
                    com.bonree.sdk.bn.a a2 = com.bonree.sdk.bn.a.a((v<? extends h>) next);
                    if (a2 != null) {
                        sb.append(a2.toString());
                    } else {
                        sb.append(next);
                    }
                    sb.append("]\n");
                }
            }
            if (sb.charAt(sb.length() - 1) == 10) {
                sb.setLength(sb.length() - 1);
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Builder of DnsMessage");
            a(sb);
            return sb.toString();
        }
    }

    public final void a(OutputStream outputStream) throws IOException {
        byte[] h2 = h();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeShort(h2.length);
        dataOutputStream.write(h2);
    }

    private boolean o() {
        v vVar;
        com.bonree.sdk.bn.a aVar = this.r;
        com.bonree.sdk.bn.a aVar2 = null;
        if (aVar == null) {
            int i2 = this.q;
            if (i2 == -1) {
                vVar = null;
            } else {
                vVar = this.n.get(i2);
            }
            if (vVar != null) {
                aVar2 = new com.bonree.sdk.bn.a((v<r>) vVar);
                this.r = aVar2;
            }
            aVar = aVar2;
        }
        if (aVar == null) {
            return false;
        }
        return aVar.a;
    }
}
