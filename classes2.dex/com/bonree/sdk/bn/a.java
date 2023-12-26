package com.bonree.sdk.bn;

import com.bonree.sdk.bp.h;
import com.bonree.sdk.bp.r;
import com.bonree.sdk.bp.v;
import com.facebook.soloader.MinElf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {
    private static int b = 32768;
    private static /* synthetic */ boolean j = true;
    public final boolean a;
    private int c;
    private int d;
    private int e;
    private int f;
    private List<c> g;
    private v<r> h;
    private String i;

    public enum b {
        UNKNOWN(-1, f.class),
        NSID(3, e.class);
        
        private static Map<Integer, b> a;
        public final int asInt;
        public final Class<? extends c> clazz;

        static {
            int i;
            a = new HashMap(values().length);
            for (b bVar : values()) {
                a.put(Integer.valueOf(bVar.asInt), bVar);
            }
        }

        private b(int i, Class<? extends c> cls) {
            this.asInt = i;
            this.clazz = cls;
        }

        public static b a(int i) {
            b bVar = a.get(Integer.valueOf(i));
            return bVar == null ? UNKNOWN : bVar;
        }
    }

    public a(v<r> vVar) {
        if (j || vVar.b == v.b.OPT) {
            this.c = vVar.d;
            this.d = (int) ((vVar.e >> 8) & 255);
            this.e = (int) ((vVar.e >> 16) & 255);
            this.f = ((int) vVar.e) & MinElf.PN_XNUM;
            this.a = (vVar.e & 32768) > 0;
            this.g = ((r) vVar.f).a;
            this.h = vVar;
            return;
        }
        throw new AssertionError();
    }

    public a(C0016a aVar) {
        this.c = aVar.a;
        int i2 = 0;
        this.d = 0;
        this.e = 0;
        i2 = aVar.d ? 32768 : i2;
        this.a = aVar.d;
        this.f = i2;
        if (aVar.e != null) {
            this.g = aVar.e;
        } else {
            this.g = Collections.emptyList();
        }
    }

    private <O extends c> O a(b bVar) {
        Iterator<c> it = this.g.iterator();
        while (it.hasNext()) {
            O o = (c) it.next();
            if (o.a().equals(bVar)) {
                return o;
            }
        }
        return null;
    }

    public final v<r> a() {
        if (this.h == null) {
            this.h = new v(com.bonree.sdk.bk.a.a, v.b.OPT, this.c, ((long) this.f) | ((long) (this.d << 8)) | ((long) (this.e << 16)), new r(this.g));
        }
        return this.h;
    }

    public final String b() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EDNS: version: ");
            sb.append(this.e);
            sb.append(", flags:");
            if (this.a) {
                sb.append(" do");
            }
            sb.append("; udp: ");
            sb.append(this.c);
            if (!this.g.isEmpty()) {
                sb.append(10);
                Iterator<c> it = this.g.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    sb.append(next.a());
                    sb.append(": ");
                    sb.append(next.c());
                    if (it.hasNext()) {
                        sb.append(10);
                    }
                }
            }
            this.i = sb.toString();
        }
        return this.i;
    }

    public String toString() {
        return b();
    }

    public static a a(v<? extends h> vVar) {
        if (vVar.b != v.b.OPT) {
            return null;
        }
        return new a((v<r>) vVar);
    }

    public static C0016a c() {
        return new C0016a((byte) 0);
    }

    /* renamed from: com.bonree.sdk.bn.a$a  reason: collision with other inner class name */
    public static final class C0016a {
        /* access modifiers changed from: private */
        public int a;
        private int b;
        private int c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public List<c> e;

        static /* synthetic */ int b(C0016a aVar) {
            return 0;
        }

        static /* synthetic */ int c(C0016a aVar) {
            return 0;
        }

        /* synthetic */ C0016a(byte b2) {
            this();
        }

        private C0016a() {
        }

        public final C0016a a(int i) {
            if (i <= 65535) {
                this.a = i;
                return this;
            }
            throw new IllegalArgumentException("UDP payload size must not be greater than 65536, was " + i);
        }

        public final C0016a a(boolean z) {
            this.d = z;
            return this;
        }

        private C0016a b() {
            this.d = true;
            return this;
        }

        private C0016a a(c cVar) {
            if (this.e == null) {
                this.e = new ArrayList(4);
            }
            this.e.add(cVar);
            return this;
        }

        public final a a() {
            return new a(this);
        }
    }
}
