package com.bonree.sdk.bc;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public final class dq implements Serializable {
    private static final long a = -9220510891189510942L;
    private static int b = 1;
    private static int c = 2;
    /* access modifiers changed from: private */
    public Map d;
    /* access modifiers changed from: private */
    public bn e;
    /* access modifiers changed from: private */
    public Object f;
    private int g;
    private bx h;
    private ck i;
    private boolean j;

    class a implements Iterator {
        private Iterator a;
        private bx[] b;
        private int c;
        private boolean d;

        a(boolean z) {
            synchronized (dq.this) {
                this.a = dq.this.d.entrySet().iterator();
            }
            this.d = z;
            bx[] a2 = dq.a(dq.this.f);
            this.b = new bx[a2.length];
            int i = 2;
            for (int i2 = 0; i2 < a2.length; i2++) {
                int q = a2[i2].i().q();
                if (q == 6) {
                    this.b[0] = a2[i2];
                } else if (q == 2) {
                    this.b[1] = a2[i2];
                } else {
                    this.b[i] = a2[i2];
                    i++;
                }
            }
        }

        public final boolean hasNext() {
            return this.b != null || this.d;
        }

        public final Object next() {
            if (hasNext()) {
                bx[] bxVarArr = this.b;
                if (bxVarArr == null) {
                    this.d = false;
                    dq dqVar = dq.this;
                    return dq.a(dqVar.f, 6);
                }
                int i = this.c;
                int i2 = i + 1;
                this.c = i2;
                bx bxVar = bxVarArr[i];
                if (i2 == bxVarArr.length) {
                    this.b = null;
                    while (true) {
                        if (!this.a.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) this.a.next();
                        if (!entry.getKey().equals(dq.this.e)) {
                            bx[] a2 = dq.a(entry.getValue());
                            if (a2.length != 0) {
                                this.b = a2;
                                this.c = 0;
                                break;
                            }
                        }
                    }
                }
                return bxVar;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void a() throws IOException {
        Object a2 = a(this.e);
        this.f = a2;
        if (a2 != null) {
            bx a3 = a(a2, 6);
            if (a3 == null || a3.e() != 1) {
                throw new IOException(this.e + ": exactly 1 SOA must be specified");
            }
            this.i = (ck) a3.c().next();
            bx a4 = a(this.f, 2);
            this.h = a4;
            if (a4 == null) {
                throw new IOException(this.e + ": no NS set specified");
            }
            return;
        }
        throw new IOException(this.e + ": no data specified");
    }

    private final void a(ca caVar) throws IOException {
        int p = caVar.p();
        bn o = caVar.o();
        if (p == 6 && !o.equals(this.e)) {
            throw new IOException("SOA owner " + o + " does not match zone origin " + this.e);
        } else if (o.a(this.e)) {
            bn o2 = caVar.o();
            int q = caVar.q();
            synchronized (this) {
                bx a2 = a(o2, q);
                if (a2 == null) {
                    a(o2, new bx(caVar));
                } else {
                    a2.a(caVar);
                }
            }
        }
    }

    private dq(bn bnVar, String str) throws IOException {
        this.g = 1;
        this.d = new TreeMap();
        if (bnVar != null) {
            ba baVar = new ba(str, bnVar);
            this.e = bnVar;
            while (true) {
                ca a2 = baVar.a();
                if (a2 != null) {
                    a(a2);
                } else {
                    a();
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("no zone name specified");
        }
    }

    private dq(bn bnVar, ca[] caVarArr) throws IOException {
        this.g = 1;
        this.d = new TreeMap();
        if (bnVar != null) {
            this.e = bnVar;
            for (ca a2 : caVarArr) {
                a(a2);
            }
            a();
            return;
        }
        throw new IllegalArgumentException("no zone name specified");
    }

    private void a(ds dsVar) throws IOException, dr {
        this.d = new TreeMap();
        this.e = dsVar.a();
        for (ca a2 : dsVar.b()) {
            a(a2);
        }
        if (dsVar.c()) {
            a();
            return;
        }
        throw new IllegalArgumentException("zones can only be created from AXFRs");
    }

    private dq(ds dsVar) throws IOException, dr {
        this.g = 1;
        a(dsVar);
    }

    private dq(bn bnVar, int i2, String str) throws IOException, dr {
        this.g = 1;
        ds a2 = ds.a(bnVar, (SocketAddress) new InetSocketAddress(str, 53), (cx) null);
        a2.b(i2);
        a(a2);
    }

    private bn b() {
        return this.e;
    }

    private bx c() {
        return this.h;
    }

    private ck d() {
        return this.i;
    }

    private int e() {
        return this.g;
    }

    private Object a(bn bnVar) {
        return this.d.get(bnVar);
    }

    /* access modifiers changed from: private */
    public static bx[] a(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            return (bx[]) list.toArray(new bx[list.size()]);
        }
        return new bx[]{(bx) obj};
    }

    /* access modifiers changed from: private */
    public static bx a(Object obj, int i2) {
        if (i2 == 255) {
            throw new IllegalArgumentException("oneRRset(ANY)");
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i3 = 0; i3 < list.size(); i3++) {
                bx bxVar = (bx) list.get(i3);
                if (bxVar.i().q() == i2) {
                    return bxVar;
                }
            }
            return null;
        } else {
            bx bxVar2 = (bx) obj;
            if (bxVar2.i().q() == i2) {
                return bxVar2;
            }
            return null;
        }
    }

    private bx a(bn bnVar, int i2) {
        Object a2 = a(bnVar);
        if (a2 == null) {
            return null;
        }
        return a(a2, i2);
    }

    private void a(bn bnVar, bx bxVar) {
        if (!this.j && bnVar.a()) {
            this.j = true;
        }
        Object obj = this.d.get(bnVar);
        if (obj == null) {
            this.d.put(bnVar, bxVar);
            return;
        }
        int q = bxVar.i().q();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((bx) list.get(i2)).i().q() == q) {
                    list.set(i2, bxVar);
                    return;
                }
            }
            list.add(bxVar);
            return;
        }
        bx bxVar2 = (bx) obj;
        if (bxVar2.i().q() == q) {
            this.d.put(bnVar, bxVar);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(bxVar2);
        linkedList.add(bxVar);
        this.d.put(bnVar, linkedList);
    }

    private void b(bn bnVar, int i2) {
        Object obj = this.d.get(bnVar);
        if (obj != null) {
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (((bx) list.get(i3)).i().q() == i2) {
                        list.remove(i3);
                        if (list.size() == 0) {
                            this.d.remove(bnVar);
                            return;
                        }
                        return;
                    }
                }
            } else if (((bx) obj).i().q() == i2) {
                this.d.remove(bnVar);
            }
        }
    }

    private cq c(bn bnVar, int i2) {
        bx a2;
        bx a3;
        if (!bnVar.a(this.e)) {
            return cq.a(1);
        }
        int d2 = bnVar.d();
        int d3 = this.e.d();
        int i3 = d3;
        while (true) {
            int i4 = 0;
            if (i3 <= d2) {
                boolean z = i3 == d3;
                boolean z2 = i3 == d2;
                Object a4 = a(z ? this.e : z2 ? bnVar : new bn(bnVar, d2 - i3));
                if (a4 != null) {
                    if (!z && (a3 = a(a4, 2)) != null) {
                        return new cq(3, a3);
                    }
                    if (!z2 || i2 != 255) {
                        if (z2) {
                            bx a5 = a(a4, i2);
                            if (a5 != null) {
                                cq cqVar = new cq(6);
                                cqVar.a(a5);
                                return cqVar;
                            }
                            bx a6 = a(a4, 5);
                            if (a6 != null) {
                                return new cq(4, a6);
                            }
                        } else {
                            bx a7 = a(a4, 39);
                            if (a7 != null) {
                                return new cq(5, a7);
                            }
                        }
                        if (z2) {
                            return cq.a(2);
                        }
                    } else {
                        cq cqVar2 = new cq(6);
                        bx[] a8 = a(a4);
                        while (i4 < a8.length) {
                            cqVar2.a(a8[i4]);
                            i4++;
                        }
                        return cqVar2;
                    }
                }
                i3++;
            } else {
                if (this.j) {
                    while (i4 < d2 - d3) {
                        i4++;
                        Object a9 = a(bnVar.a(i4));
                        if (a9 != null && (a2 = a(a9, i2)) != null) {
                            cq cqVar3 = new cq(6);
                            cqVar3.a(a2);
                            return cqVar3;
                        }
                    }
                }
                return cq.a(1);
            }
        }
    }

    private bx e(bn bnVar, int i2) {
        Object a2 = a(bnVar);
        if (a2 == null) {
            return null;
        }
        return a(a2, i2);
    }

    private void b(ca caVar) {
        bn o = caVar.o();
        int q = caVar.q();
        synchronized (this) {
            bx a2 = a(o, q);
            if (a2 == null) {
                a(o, new bx(caVar));
            } else {
                a2.a(caVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.bonree.sdk.bc.ca r6) {
        /*
            r5 = this;
            com.bonree.sdk.bc.bn r0 = r6.o()
            int r1 = r6.q()
            monitor-enter(r5)
            com.bonree.sdk.bc.bx r2 = r5.a((com.bonree.sdk.bc.bn) r0, (int) r1)     // Catch:{ all -> 0x0070 }
            if (r2 != 0) goto L_0x0011
            monitor-exit(r5)     // Catch:{ all -> 0x0070 }
            return
        L_0x0011:
            int r3 = r2.e()     // Catch:{ all -> 0x0070 }
            r4 = 1
            if (r3 != r4) goto L_0x006b
            com.bonree.sdk.bc.ca r3 = r2.i()     // Catch:{ all -> 0x0070 }
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x0070 }
            if (r3 == 0) goto L_0x006b
            java.util.Map r6 = r5.d     // Catch:{ all -> 0x0070 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x0070 }
            if (r6 == 0) goto L_0x006e
            boolean r2 = r6 instanceof java.util.List     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0059
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0070 }
            r2 = 0
        L_0x0031:
            int r3 = r6.size()     // Catch:{ all -> 0x0070 }
            if (r2 >= r3) goto L_0x006e
            java.lang.Object r3 = r6.get(r2)     // Catch:{ all -> 0x0070 }
            com.bonree.sdk.bc.bx r3 = (com.bonree.sdk.bc.bx) r3     // Catch:{ all -> 0x0070 }
            com.bonree.sdk.bc.ca r3 = r3.i()     // Catch:{ all -> 0x0070 }
            int r3 = r3.q()     // Catch:{ all -> 0x0070 }
            if (r3 != r1) goto L_0x0056
            r6.remove(r2)     // Catch:{ all -> 0x0070 }
            int r6 = r6.size()     // Catch:{ all -> 0x0070 }
            if (r6 != 0) goto L_0x006e
            java.util.Map r6 = r5.d     // Catch:{ all -> 0x0070 }
            r6.remove(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x006e
        L_0x0056:
            int r2 = r2 + 1
            goto L_0x0031
        L_0x0059:
            com.bonree.sdk.bc.bx r6 = (com.bonree.sdk.bc.bx) r6     // Catch:{ all -> 0x0070 }
            com.bonree.sdk.bc.ca r6 = r6.i()     // Catch:{ all -> 0x0070 }
            int r6 = r6.q()     // Catch:{ all -> 0x0070 }
            if (r6 != r1) goto L_0x006e
            java.util.Map r6 = r5.d     // Catch:{ all -> 0x0070 }
            r6.remove(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x006e
        L_0x006b:
            r2.b(r6)     // Catch:{ all -> 0x0070 }
        L_0x006e:
            monitor-exit(r5)     // Catch:{ all -> 0x0070 }
            return
        L_0x0070:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0070 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.dq.c(com.bonree.sdk.bc.ca):void");
    }

    private Iterator f() {
        return new a(false);
    }

    private Iterator g() {
        return new a(true);
    }

    private void a(StringBuffer stringBuffer, Object obj) {
        bx[] a2 = a(obj);
        for (bx bxVar : a2) {
            Iterator c2 = bxVar.c();
            while (c2.hasNext()) {
                stringBuffer.append(c2.next() + "\n");
            }
            Iterator d2 = bxVar.d();
            while (d2.hasNext()) {
                stringBuffer.append(d2.next() + "\n");
            }
        }
    }

    private String h() {
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer, this.f);
        for (Map.Entry entry : this.d.entrySet()) {
            if (!this.e.equals(entry.getKey())) {
                a(stringBuffer, entry.getValue());
            }
        }
        return stringBuffer.toString();
    }

    private cq d(bn bnVar, int i2) {
        bx a2;
        bx a3;
        if (bnVar.a(this.e)) {
            int d2 = bnVar.d();
            int d3 = this.e.d();
            int i3 = d3;
            while (true) {
                int i4 = 0;
                if (i3 <= d2) {
                    boolean z = i3 == d3;
                    boolean z2 = i3 == d2;
                    Object a4 = a(z ? this.e : z2 ? bnVar : new bn(bnVar, d2 - i3));
                    if (a4 != null) {
                        if (!z && (a3 = a(a4, 2)) != null) {
                            return new cq(3, a3);
                        }
                        if (!z2 || i2 != 255) {
                            if (z2) {
                                bx a5 = a(a4, i2);
                                if (a5 != null) {
                                    cq cqVar = new cq(6);
                                    cqVar.a(a5);
                                    return cqVar;
                                }
                                bx a6 = a(a4, 5);
                                if (a6 != null) {
                                    return new cq(4, a6);
                                }
                            } else {
                                bx a7 = a(a4, 39);
                                if (a7 != null) {
                                    return new cq(5, a7);
                                }
                            }
                            if (z2) {
                                return cq.a(2);
                            }
                        } else {
                            cq cqVar2 = new cq(6);
                            bx[] a8 = a(a4);
                            while (i4 < a8.length) {
                                cqVar2.a(a8[i4]);
                                i4++;
                            }
                            return cqVar2;
                        }
                    }
                    i3++;
                } else if (this.j) {
                    while (i4 < d2 - d3) {
                        i4++;
                        Object a9 = a(bnVar.a(i4));
                        if (a9 != null && (a2 = a(a9, i2)) != null) {
                            cq cqVar3 = new cq(6);
                            cqVar3.a(a2);
                            return cqVar3;
                        }
                    }
                }
            }
        }
        return cq.a(1);
    }

    private void a(bx bxVar) {
        a(bxVar.i().o(), bxVar);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer, this.f);
        for (Map.Entry entry : this.d.entrySet()) {
            if (!this.e.equals(entry.getKey())) {
                a(stringBuffer, entry.getValue());
            }
        }
        return stringBuffer.toString();
    }
}
