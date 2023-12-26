package com.bonree.sdk.bf;

import com.bonree.sdk.bp.h;
import com.bonree.sdk.bp.v;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class r {
    private com.bonree.sdk.bk.a a;
    private v.b b;
    private v.a c;
    private Set<v<? extends h>> d;

    /* synthetic */ r(com.bonree.sdk.bk.a aVar, v.b bVar, v.a aVar2, Set set, byte b2) {
        this(aVar, bVar, aVar2, set);
    }

    private r(com.bonree.sdk.bk.a aVar, v.b bVar, v.a aVar2, Set<v<? extends h>> set) {
        this.a = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.d = Collections.unmodifiableSet(set);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(9);
        sb.append(this.c);
        sb.append(9);
        sb.append(this.b);
        sb.append(10);
        for (v<? extends h> append : this.d) {
            sb.append(append);
            sb.append(10);
        }
        return sb.toString();
    }

    private static a a() {
        return new a((byte) 0);
    }

    public static final class a {
        private static /* synthetic */ boolean e = true;
        private com.bonree.sdk.bk.a a;
        private v.b b;
        private v.a c;
        private Set<v<? extends h>> d;

        static {
            Class<r> cls = r.class;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.d = new LinkedHashSet(8);
        }

        private a a(v<? extends h> vVar) {
            if (this.a == null) {
                this.a = vVar.a;
                this.b = vVar.b;
                this.c = vVar.c;
            } else if (!b(vVar)) {
                throw new IllegalArgumentException("Can not add " + vVar + " to RRSet " + this.a + ' ' + this.b + ' ' + this.c);
            }
            boolean add = this.d.add(vVar);
            if (e || add) {
                return this;
            }
            throw new AssertionError();
        }

        private boolean b(v<? extends h> vVar) {
            com.bonree.sdk.bk.a aVar = this.a;
            if (aVar == null) {
                return true;
            }
            if (aVar.equals(vVar.a) && this.b == vVar.b && this.c == vVar.c) {
                return true;
            }
            return false;
        }

        private boolean c(v<? extends h> vVar) {
            if (!b(vVar)) {
                return false;
            }
            if (this.a == null) {
                this.a = vVar.a;
                this.b = vVar.b;
                this.c = vVar.c;
            } else if (!b(vVar)) {
                throw new IllegalArgumentException("Can not add " + vVar + " to RRSet " + this.a + ' ' + this.b + ' ' + this.c);
            }
            boolean add = this.d.add(vVar);
            if (e || add) {
                return true;
            }
            throw new AssertionError();
        }

        private r a() {
            com.bonree.sdk.bk.a aVar = this.a;
            if (aVar != null) {
                return new r(aVar, this.b, this.c, this.d, (byte) 0);
            }
            throw new IllegalStateException();
        }
    }
}
