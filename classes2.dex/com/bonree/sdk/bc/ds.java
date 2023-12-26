package com.bonree.sdk.bc;

import com.bonree.sdk.bc.cx;
import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public final class ds {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final int h = 7;
    private bn i;
    private int j;
    private int k;
    private long l;
    private boolean m;
    private c n;
    private SocketAddress o;
    private SocketAddress p;
    private cu q;
    private cx r;
    private cx.a s;
    private long t = 900000;
    private int u;
    private long v;
    private long w;
    private ca x;
    private int y;

    public interface c {
        void a() throws dr;

        void a(ca caVar) throws dr;

        void b() throws dr;

        void b(ca caVar) throws dr;

        void c(ca caVar) throws dr;
    }

    public static class b {
        public long a;
        public long b;
        public List c;
        public List d;

        /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
            this.c = new ArrayList();
            this.d = new ArrayList();
        }
    }

    static class a implements c {
        /* access modifiers changed from: private */
        public List a;
        /* access modifiers changed from: private */
        public List b;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void a() {
            this.a = new ArrayList();
        }

        public final void b() {
            this.b = new ArrayList();
        }

        public final void a(ca caVar) {
            b bVar = new b((byte) 0);
            bVar.d.add(caVar);
            bVar.a = ds.b(caVar);
            this.b.add(bVar);
        }

        public final void b(ca caVar) {
            List list = this.b;
            b bVar = (b) list.get(list.size() - 1);
            bVar.c.add(caVar);
            bVar.b = ds.b(caVar);
        }

        public final void c(ca caVar) {
            List list;
            List list2 = this.b;
            if (list2 != null) {
                b bVar = (b) list2.get(list2.size() - 1);
                if (bVar.c.size() > 0) {
                    list = bVar.c;
                } else {
                    list = bVar.d;
                }
            } else {
                list = this.a;
            }
            list.add(caVar);
        }
    }

    private ds() {
    }

    private ds(bn bnVar, int i2, long j2, boolean z, SocketAddress socketAddress, cx cxVar) {
        this.p = socketAddress;
        this.r = cxVar;
        if (bnVar.b()) {
            this.i = bnVar;
        } else {
            try {
                this.i = bn.a(bnVar, bn.a);
            } catch (bo unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.j = i2;
        this.k = 1;
        this.l = j2;
        this.m = z;
        this.u = 0;
    }

    public static ds a(bn bnVar, SocketAddress socketAddress, cx cxVar) {
        return new ds(bnVar, 252, 0, false, socketAddress, cxVar);
    }

    private static ds a(bn bnVar, String str, int i2, cx cxVar) throws UnknownHostException {
        return a(bnVar, (SocketAddress) new InetSocketAddress(str, 53), cxVar);
    }

    public static ds a(bn bnVar, String str, cx cxVar) throws UnknownHostException {
        return a(bnVar, str, 0, (cx) null);
    }

    private static ds a(bn bnVar, long j2, boolean z, SocketAddress socketAddress, cx cxVar) {
        return new ds(bnVar, 251, j2, z, socketAddress, cxVar);
    }

    private static ds a(bn bnVar, long j2, boolean z, String str, int i2, cx cxVar) throws UnknownHostException {
        return new ds(bnVar, 251, j2, z, new InetSocketAddress(str, 53), cxVar);
    }

    public final bn a() {
        return this.i;
    }

    private int e() {
        return this.j;
    }

    public final void a(int i2) {
        if (i2 >= 0) {
            this.t = ((long) i2) * 1000;
            return;
        }
        throw new IllegalArgumentException("timeout cannot be negative");
    }

    public final void b(int i2) {
        p.a(i2);
        this.k = i2;
    }

    public final void a(SocketAddress socketAddress) {
        this.o = socketAddress;
    }

    private void f() throws IOException {
        cu cuVar = new cu(System.currentTimeMillis() + this.t);
        this.q = cuVar;
        SocketAddress socketAddress = this.o;
        if (socketAddress != null) {
            cuVar.a(socketAddress);
        }
        this.q.b(this.p);
    }

    private void g() throws IOException {
        ca a2 = ca.a(this.i, this.j, this.k);
        bb bbVar = new bb();
        bbVar.a().c(0);
        bbVar.a(a2, 0);
        if (this.j == 251) {
            bn bnVar = this.i;
            int i2 = this.k;
            bn bnVar2 = bn.a;
            bbVar.a((ca) new ck(bnVar, i2, 0, bnVar2, bnVar2, this.l, 0, 0, 0, 0), 2);
        }
        cx cxVar = this.r;
        if (cxVar != null) {
            cxVar.a(bbVar, (cy) null);
            this.s = new cx.a(this.r, bbVar.c());
        }
        this.q.a(bbVar.c(MinElf.PN_XNUM));
    }

    /* access modifiers changed from: private */
    public static long b(ca caVar) {
        return ((ck) caVar).d();
    }

    private void a(String str) {
        if (br.a("verbose")) {
            PrintStream printStream = System.out;
            printStream.println(this.i + ": " + str);
        }
    }

    private static void b(String str) throws dr {
        throw new dr(str);
    }

    private void h() throws dr {
        if (!this.m) {
            b("server doesn't support IXFR");
        }
        a("falling back to AXFR");
        this.j = 252;
        this.u = 0;
    }

    private void c(ca caVar) throws dr {
        while (true) {
            int p2 = caVar.p();
            switch (this.u) {
                case 0:
                    if (p2 != 6) {
                        b("missing initial SOA");
                    }
                    this.x = caVar;
                    long b2 = b(caVar);
                    this.v = b2;
                    if (this.j == 251) {
                        long j2 = this.l;
                        if (b2 < 0 || b2 > 4294967295L) {
                            throw new IllegalArgumentException(b2 + " out of range");
                        } else if (j2 < 0 || j2 > 4294967295L) {
                            throw new IllegalArgumentException(j2 + " out of range");
                        } else {
                            long j3 = b2 - j2;
                            if (j3 >= 4294967295L) {
                                j3 -= 4294967296L;
                            } else if (j3 < -4294967295L) {
                                j3 += 4294967296L;
                            }
                            if (((int) j3) <= 0) {
                                a("up to date");
                                this.u = 7;
                                return;
                            }
                        }
                    }
                    this.u = 1;
                    return;
                case 1:
                    if (this.j != 251 || p2 != 6 || b(caVar) != this.l) {
                        this.y = 252;
                        this.n.a();
                        this.n.c(this.x);
                        a("got nonincremental response");
                        this.u = 6;
                        break;
                    } else {
                        this.y = 251;
                        this.n.b();
                        a("got incremental response");
                        this.u = 2;
                        break;
                    }
                case 2:
                    this.n.a(caVar);
                    this.u = 3;
                    return;
                case 3:
                    if (p2 == 6) {
                        this.w = b(caVar);
                        this.u = 4;
                        break;
                    } else {
                        this.n.c(caVar);
                        return;
                    }
                case 4:
                    this.n.b(caVar);
                    this.u = 5;
                    return;
                case 5:
                    if (p2 != 6) {
                        break;
                    } else {
                        long b3 = b(caVar);
                        if (b3 != this.v) {
                            if (b3 == this.w) {
                                this.u = 2;
                                break;
                            } else {
                                b("IXFR out of sync: expected serial " + this.w + " , got " + b3);
                                break;
                            }
                        } else {
                            this.u = 7;
                            return;
                        }
                    }
                case 6:
                    if (p2 != 1 || caVar.r() == this.k) {
                        this.n.c(caVar);
                        if (p2 == 6) {
                            this.u = 7;
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    b("extra data");
                    return;
                default:
                    b("invalid state");
                    return;
            }
        }
        this.n.c(caVar);
    }

    private void i() {
        try {
            cu cuVar = this.q;
            if (cuVar != null) {
                cuVar.a();
            }
        } catch (IOException unused) {
        }
    }

    private static bb a(byte[] bArr) throws Cdo {
        try {
            return new bb(bArr);
        } catch (IOException e2) {
            if (e2 instanceof Cdo) {
                throw ((Cdo) e2);
            }
            throw new Cdo("Error parsing message");
        }
    }

    private void a(c cVar) throws IOException, dr {
        this.n = cVar;
        try {
            cu cuVar = new cu(System.currentTimeMillis() + this.t);
            this.q = cuVar;
            SocketAddress socketAddress = this.o;
            if (socketAddress != null) {
                cuVar.a(socketAddress);
            }
            this.q.b(this.p);
            j();
        } finally {
            i();
        }
    }

    public final List b() throws IOException, dr {
        a aVar = new a((byte) 0);
        a((c) aVar);
        if (aVar.a != null) {
            return aVar.a;
        }
        return aVar.b;
    }

    private a k() throws IllegalArgumentException {
        c cVar = this.n;
        if (cVar instanceof a) {
            return (a) cVar;
        }
        throw new IllegalArgumentException("ZoneTransferIn used callback interface");
    }

    public final boolean c() {
        return this.y == 252;
    }

    public final List d() {
        return k().a;
    }

    private boolean l() {
        return this.y == 251;
    }

    private List m() {
        return k().b;
    }

    private boolean n() {
        a k2 = k();
        return k2.a == null && k2.b == null;
    }

    private static ds a(bn bnVar, long j2, boolean z, String str, cx cxVar) throws UnknownHostException {
        return new ds(bnVar, 251, j2, z, new InetSocketAddress(str, 53), cxVar);
    }

    private void j() throws IOException, dr {
        while (true) {
            ca a2 = ca.a(this.i, this.j, this.k);
            bb bbVar = new bb();
            bbVar.a().c(0);
            bbVar.a(a2, 0);
            if (this.j == 251) {
                bn bnVar = this.i;
                int i2 = this.k;
                bn bnVar2 = bn.a;
                bbVar.a((ca) new ck(bnVar, i2, 0, bnVar2, bnVar2, this.l, 0, 0, 0, 0), 2);
            }
            cx cxVar = this.r;
            if (cxVar != null) {
                cxVar.a(bbVar, (cy) null);
                this.s = new cx.a(this.r, bbVar.c());
            }
            this.q.a(bbVar.c(MinElf.PN_XNUM));
            while (this.u != 7) {
                byte[] b2 = this.q.b();
                bb a3 = a(b2);
                if (a3.a().c() == 0 && this.s != null) {
                    a3.c();
                    if (this.s.a(a3, b2) != 0) {
                        b("TSIG failure");
                    }
                }
                ca[] a4 = a3.a(1);
                if (this.u == 0) {
                    int f2 = a3.f();
                    if (f2 != 0) {
                        if (this.j == 251 && f2 == 4) {
                            h();
                        } else {
                            b(bz.a(f2));
                        }
                    }
                    ca b3 = a3.b();
                    if (!(b3 == null || b3.p() == this.j)) {
                        b("invalid question section");
                    }
                    if (a4.length == 0 && this.j == 251) {
                        h();
                    }
                }
                for (ca c2 : a4) {
                    c(c2);
                }
                if (this.u == 7 && this.s != null && !a3.d()) {
                    b("last message must be signed");
                }
            }
            return;
        }
    }
}
