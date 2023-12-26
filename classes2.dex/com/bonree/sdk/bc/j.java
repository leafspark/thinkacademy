package com.bonree.sdk.bc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j {
    private static final int f = 50000;
    private List<String> a;
    private a b;
    private int c;
    private int d;
    private int e;

    interface c {
        int a(int i);

        boolean a();

        int b();
    }

    private static int b(long j, long j2) {
        if (j2 >= 0 && j2 < j) {
            j = j2;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j;
        if (currentTimeMillis < 0 || currentTimeMillis > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) currentTimeMillis;
    }

    static class b extends bx implements c {
        private static final long a = 5971755205903597024L;
        private int b;
        private int c;

        public b(ca caVar, int i, long j) {
            this.b = i;
            this.c = j.a(caVar.s(), j);
            a(caVar);
        }

        public b(bx bxVar, int i, long j) {
            super(bxVar);
            this.b = i;
            this.c = j.a(bxVar.h(), j);
        }

        public final boolean a() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.c;
        }

        public final int a(int i) {
            return this.b - i;
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.toString());
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.b);
            return stringBuffer.toString();
        }
    }

    static class d implements c {
        private int a;
        private bn b;
        private int c;
        private int d;

        public d(bn bnVar, int i, ck ckVar, int i2, long j) {
            this.b = bnVar;
            this.a = i;
            long e = ckVar != null ? ckVar.e() : 0;
            this.c = i2;
            this.d = j.a(e, j);
        }

        public final int b() {
            return this.a;
        }

        public final boolean a() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.d;
        }

        public final int a(int i) {
            return this.c - i;
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.a == 0) {
                stringBuffer.append("NXDOMAIN " + this.b);
            } else {
                stringBuffer.append("NXRRSET " + this.b + " " + df.b(this.a));
            }
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.c);
            return stringBuffer.toString();
        }
    }

    static class a extends LinkedHashMap {
        private int a;

        a(int i) {
            super(16, 0.75f, true);
            this.a = -1;
            this.a = j.f;
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i) {
            this.a = i;
        }

        /* access modifiers changed from: protected */
        public final boolean removeEldestEntry(Map.Entry entry) {
            return this.a >= 0 && size() > this.a;
        }
    }

    public j(int i) {
        this.c = -1;
        this.d = -1;
        this.e = i;
        this.b = new a(f);
        this.a = new ArrayList();
    }

    public j() {
        this(1);
    }

    private j(String str) throws IOException {
        this.c = -1;
        this.d = -1;
        this.b = new a(f);
        ba baVar = new ba(str);
        while (true) {
            ca a2 = baVar.a();
            if (a2 != null) {
                a(a2, 0);
            } else {
                return;
            }
        }
    }

    private synchronized Object a(bn bnVar) {
        return this.b.get(bnVar);
    }

    private synchronized void b(bn bnVar) {
        this.b.remove(bnVar);
    }

    private synchronized c[] a(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            return (c[]) list.toArray(new c[list.size()]);
        }
        return new c[]{(c) obj};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r2.b() == r7) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[SYNTHETIC, Splitter:B:19:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bonree.sdk.bc.j.c a(com.bonree.sdk.bc.bn r5, java.lang.Object r6, int r7, int r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 255(0xff, float:3.57E-43)
            if (r7 == r0) goto L_0x0049
            boolean r0 = r6 instanceof java.util.List     // Catch:{ all -> 0x0047 }
            r1 = 0
            if (r0 == 0) goto L_0x0023
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0047 }
            r0 = 0
        L_0x000d:
            int r2 = r6.size()     // Catch:{ all -> 0x0047 }
            if (r0 >= r2) goto L_0x002d
            java.lang.Object r2 = r6.get(r0)     // Catch:{ all -> 0x0047 }
            com.bonree.sdk.bc.j$c r2 = (com.bonree.sdk.bc.j.c) r2     // Catch:{ all -> 0x0047 }
            int r3 = r2.b()     // Catch:{ all -> 0x0047 }
            if (r3 != r7) goto L_0x0020
            goto L_0x002e
        L_0x0020:
            int r0 = r0 + 1
            goto L_0x000d
        L_0x0023:
            r2 = r6
            com.bonree.sdk.bc.j$c r2 = (com.bonree.sdk.bc.j.c) r2     // Catch:{ all -> 0x0047 }
            int r6 = r2.b()     // Catch:{ all -> 0x0047 }
            if (r6 != r7) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            if (r2 != 0) goto L_0x0032
            monitor-exit(r4)
            return r1
        L_0x0032:
            boolean r6 = r2.a()     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x003d
            r4.a((com.bonree.sdk.bc.bn) r5, (int) r7)     // Catch:{ all -> 0x0047 }
            monitor-exit(r4)
            return r1
        L_0x003d:
            int r5 = r2.a(r8)     // Catch:{ all -> 0x0047 }
            if (r5 >= 0) goto L_0x0045
            monitor-exit(r4)
            return r1
        L_0x0045:
            monitor-exit(r4)
            return r2
        L_0x0047:
            r5 = move-exception
            goto L_0x0051
        L_0x0049:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0047 }
            java.lang.String r6 = "oneElement(ANY)"
            r5.<init>(r6)     // Catch:{ all -> 0x0047 }
            throw r5     // Catch:{ all -> 0x0047 }
        L_0x0051:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.j.a(com.bonree.sdk.bc.bn, java.lang.Object, int, int):com.bonree.sdk.bc.j$c");
    }

    private synchronized c b(bn bnVar, int i, int i2) {
        Object a2 = a(bnVar);
        if (a2 == null) {
            return null;
        }
        return a(bnVar, a2, i, i2);
    }

    private synchronized void a(bn bnVar, c cVar) {
        Object obj = this.b.get(bnVar);
        if (obj == null) {
            this.b.put(bnVar, cVar);
            return;
        }
        int b2 = cVar.b();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                if (((c) list.get(i)).b() == b2) {
                    list.set(i, cVar);
                    return;
                }
            }
            list.add(cVar);
            return;
        }
        c cVar2 = (c) obj;
        if (cVar2.b() == b2) {
            this.b.put(bnVar, cVar);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(cVar2);
        linkedList.add(cVar);
        this.b.put(bnVar, linkedList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bonree.sdk.bc.bn r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.bonree.sdk.bc.j$a r0 = r3.b     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r3)
            return
        L_0x000b:
            boolean r1 = r0 instanceof java.util.List     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0039
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x004a }
            r1 = 0
        L_0x0012:
            int r2 = r0.size()     // Catch:{ all -> 0x004a }
            if (r1 >= r2) goto L_0x0037
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x004a }
            com.bonree.sdk.bc.j$c r2 = (com.bonree.sdk.bc.j.c) r2     // Catch:{ all -> 0x004a }
            int r2 = r2.b()     // Catch:{ all -> 0x004a }
            if (r2 != r5) goto L_0x0034
            r0.remove(r1)     // Catch:{ all -> 0x004a }
            int r5 = r0.size()     // Catch:{ all -> 0x004a }
            if (r5 != 0) goto L_0x0032
            com.bonree.sdk.bc.j$a r5 = r3.b     // Catch:{ all -> 0x004a }
            r5.remove(r4)     // Catch:{ all -> 0x004a }
        L_0x0032:
            monitor-exit(r3)
            return
        L_0x0034:
            int r1 = r1 + 1
            goto L_0x0012
        L_0x0037:
            monitor-exit(r3)
            return
        L_0x0039:
            com.bonree.sdk.bc.j$c r0 = (com.bonree.sdk.bc.j.c) r0     // Catch:{ all -> 0x004a }
            int r0 = r0.b()     // Catch:{ all -> 0x004a }
            if (r0 == r5) goto L_0x0043
            monitor-exit(r3)
            return
        L_0x0043:
            com.bonree.sdk.bc.j$a r5 = r3.b     // Catch:{ all -> 0x004a }
            r5.remove(r4)     // Catch:{ all -> 0x004a }
            monitor-exit(r3)
            return
        L_0x004a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.j.a(com.bonree.sdk.bc.bn, int):void");
    }

    public final synchronized void a() {
        this.b.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bonree.sdk.bc.ca r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bonree.sdk.bc.bn r6 = r5.o()     // Catch:{ all -> 0x0036 }
            int r0 = r5.q()     // Catch:{ all -> 0x0036 }
            boolean r1 = com.bonree.sdk.bc.df.d(r0)     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r4)
            return
        L_0x0011:
            r1 = 0
            com.bonree.sdk.bc.j$c r6 = r4.b(r6, r0, r1)     // Catch:{ all -> 0x0036 }
            if (r6 != 0) goto L_0x0025
            com.bonree.sdk.bc.j$b r6 = new com.bonree.sdk.bc.j$b     // Catch:{ all -> 0x0036 }
            int r0 = r4.d     // Catch:{ all -> 0x0036 }
            long r2 = (long) r0     // Catch:{ all -> 0x0036 }
            r6.<init>((com.bonree.sdk.bc.ca) r5, (int) r1, (long) r2)     // Catch:{ all -> 0x0036 }
            r4.a((com.bonree.sdk.bc.bx) r6, (int) r1)     // Catch:{ all -> 0x0036 }
            monitor-exit(r4)
            return
        L_0x0025:
            int r0 = r6.a(r1)     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.bonree.sdk.bc.j.b     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            com.bonree.sdk.bc.j$b r6 = (com.bonree.sdk.bc.j.b) r6     // Catch:{ all -> 0x0036 }
            r6.a((com.bonree.sdk.bc.ca) r5)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r4)
            return
        L_0x0036:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.j.a(com.bonree.sdk.bc.ca, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bonree.sdk.bc.bx r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r8.h()     // Catch:{ all -> 0x004d }
            com.bonree.sdk.bc.ca r2 = r8.i()     // Catch:{ all -> 0x004d }
            com.bonree.sdk.bc.bn r2 = r2.o()     // Catch:{ all -> 0x004d }
            com.bonree.sdk.bc.ca r3 = r8.i()     // Catch:{ all -> 0x004d }
            int r3 = r3.q()     // Catch:{ all -> 0x004d }
            r4 = 0
            com.bonree.sdk.bc.j$c r4 = r7.b(r2, r3, r4)     // Catch:{ all -> 0x004d }
            r5 = 0
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            if (r4 == 0) goto L_0x004b
            int r8 = r4.a(r9)     // Catch:{ all -> 0x004d }
            if (r8 > 0) goto L_0x004b
            r7.a((com.bonree.sdk.bc.bn) r2, (int) r3)     // Catch:{ all -> 0x004d }
            monitor-exit(r7)
            return
        L_0x002d:
            if (r4 == 0) goto L_0x0036
            int r0 = r4.a(r9)     // Catch:{ all -> 0x004d }
            if (r0 > 0) goto L_0x0036
            r4 = 0
        L_0x0036:
            if (r4 != 0) goto L_0x004b
            boolean r0 = r8 instanceof com.bonree.sdk.bc.j.b     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x003f
            com.bonree.sdk.bc.j$b r8 = (com.bonree.sdk.bc.j.b) r8     // Catch:{ all -> 0x004d }
            goto L_0x0048
        L_0x003f:
            com.bonree.sdk.bc.j$b r0 = new com.bonree.sdk.bc.j$b     // Catch:{ all -> 0x004d }
            int r1 = r7.d     // Catch:{ all -> 0x004d }
            long r3 = (long) r1     // Catch:{ all -> 0x004d }
            r0.<init>((com.bonree.sdk.bc.bx) r8, (int) r9, (long) r3)     // Catch:{ all -> 0x004d }
            r8 = r0
        L_0x0048:
            r7.a((com.bonree.sdk.bc.bn) r2, (com.bonree.sdk.bc.j.c) r8)     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r7)
            return
        L_0x004d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.j.a(com.bonree.sdk.bc.bx, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.bonree.sdk.bc.bn r13, int r14, com.bonree.sdk.bc.ck r15, int r16) {
        /*
            r12 = this;
            r1 = r12
            r0 = r13
            r6 = r16
            monitor-enter(r12)
            r2 = 0
            if (r15 == 0) goto L_0x000e
            long r4 = r15.s()     // Catch:{ all -> 0x0045 }
            goto L_0x000f
        L_0x000e:
            r4 = r2
        L_0x000f:
            r7 = 0
            r8 = r14
            com.bonree.sdk.bc.j$c r7 = r12.b(r13, r14, r7)     // Catch:{ all -> 0x0045 }
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0026
            if (r7 == 0) goto L_0x0043
            int r2 = r7.a(r6)     // Catch:{ all -> 0x0045 }
            if (r2 > 0) goto L_0x0043
            r12.a((com.bonree.sdk.bc.bn) r13, (int) r14)     // Catch:{ all -> 0x0045 }
            monitor-exit(r12)
            return
        L_0x0026:
            if (r7 == 0) goto L_0x002f
            int r2 = r7.a(r6)     // Catch:{ all -> 0x0045 }
            if (r2 > 0) goto L_0x002f
            r7 = 0
        L_0x002f:
            if (r7 != 0) goto L_0x0043
            com.bonree.sdk.bc.j$d r9 = new com.bonree.sdk.bc.j$d     // Catch:{ all -> 0x0045 }
            int r2 = r1.c     // Catch:{ all -> 0x0045 }
            long r10 = (long) r2     // Catch:{ all -> 0x0045 }
            r2 = r9
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0045 }
            r12.a((com.bonree.sdk.bc.bn) r13, (com.bonree.sdk.bc.j.c) r9)     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r12)
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.j.a(com.bonree.sdk.bc.bn, int, com.bonree.sdk.bc.ck, int):void");
    }

    private synchronized cq c(bn bnVar, int i, int i2) {
        bn bnVar2;
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            int d2 = bnVar.d();
            int i5 = d2;
            while (i5 > 0) {
                boolean z = i5 == 1;
                boolean z2 = i5 == d2;
                if (z) {
                    bnVar2 = bn.a;
                    bn bnVar3 = bnVar;
                } else if (z2) {
                    bnVar2 = bnVar;
                    bn bnVar4 = bnVar2;
                } else {
                    bnVar2 = new bn(bnVar, d2 - i5);
                }
                Object obj = this.b.get(bnVar2);
                if (obj != null) {
                    if (z2 && i3 == 255) {
                        cq cqVar = new cq(6);
                        c[] a2 = a(obj);
                        int i6 = 0;
                        for (c cVar : a2) {
                            if (cVar.a()) {
                                a(bnVar2, cVar.b());
                            } else if ((cVar instanceof b) && cVar.a(i4) >= 0) {
                                cqVar.a((bx) (b) cVar);
                                i6++;
                            }
                        }
                        if (i6 > 0) {
                            return cqVar;
                        }
                    } else if (z2) {
                        c a3 = a(bnVar2, obj, i3, i4);
                        if (a3 != null && (a3 instanceof b)) {
                            cq cqVar2 = new cq(6);
                            cqVar2.a((bx) (b) a3);
                            return cqVar2;
                        } else if (a3 != null) {
                            cq cqVar3 = new cq(2);
                            return cqVar3;
                        } else {
                            c a4 = a(bnVar2, obj, 5, i4);
                            if (a4 != null && (a4 instanceof b)) {
                                cq cqVar4 = new cq(4, (b) a4);
                                return cqVar4;
                            }
                        }
                    } else {
                        c a5 = a(bnVar2, obj, 39, i4);
                        if (a5 != null && (a5 instanceof b)) {
                            cq cqVar5 = new cq(5, (b) a5);
                            return cqVar5;
                        }
                    }
                    c a6 = a(bnVar2, obj, 2, i4);
                    if (a6 != null && (a6 instanceof b)) {
                        cq cqVar6 = new cq(3, (b) a6);
                        return cqVar6;
                    } else if (!z2) {
                        continue;
                    } else if (a(bnVar2, obj, 0, i4) != null) {
                        cq a7 = cq.a(1);
                        return a7;
                    }
                }
                i5--;
            }
            cq a8 = cq.a(0);
            return a8;
        }
    }

    public final cq a(bn bnVar, int i, int i2) {
        return c(bnVar, i, i2);
    }

    private bx[] b(bn bnVar, int i) {
        return d(bnVar, i, 3);
    }

    private bx[] c(bn bnVar, int i) {
        return d(bnVar, i, 2);
    }

    private static int a(int i, boolean z) {
        if (i == 1) {
            return z ? 4 : 3;
        }
        if (i == 2) {
            return z ? 4 : 3;
        }
        if (i == 3) {
            return 1;
        }
        throw new IllegalArgumentException("getCred: invalid section");
    }

    private static void a(bx bxVar, Set set) {
        if (bxVar.i().c() != null) {
            Iterator c2 = bxVar.c();
            while (c2.hasNext()) {
                bn c3 = ((ca) c2.next()).c();
                if (c3 != null) {
                    set.add(c3);
                }
            }
        }
    }

    public final cq a(bb bbVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        char c2;
        bb bbVar2 = bbVar;
        boolean b2 = bbVar.a().b(5);
        ca b3 = bbVar.b();
        int c3 = bbVar.a().c();
        boolean a2 = br.a("verbosecache");
        if ((c3 != 0 && c3 != 3) || b3 == null) {
            return null;
        }
        bn o = b3.o();
        int p = b3.p();
        int r = b3.r();
        HashSet hashSet = new HashSet();
        bx[] b4 = bbVar2.b(1);
        cq cqVar = null;
        bn bnVar = o;
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            i = 2;
            if (i4 >= b4.length) {
                break;
            }
            if (b4[i4].i().r() == r) {
                int q = b4[i4].i().q();
                bn o2 = b4[i4].i().o();
                String bnVar2 = o2.toString();
                i3 = r;
                if (bnVar2.length() > 2) {
                    List<String> list = this.a;
                    if (bnVar2.endsWith(".")) {
                        z = a2;
                        i2 = 0;
                        bnVar2 = bnVar2.substring(0, bnVar2.length() - 1);
                    } else {
                        z = a2;
                        i2 = 0;
                    }
                    list.add(bnVar2);
                } else {
                    z = a2;
                    i2 = 0;
                }
                int a3 = a(1, b2);
                if ((q == p || p == 255) && o2.equals(bnVar)) {
                    a(b4[i4], a3);
                    if (bnVar == o) {
                        cq cqVar2 = cqVar == null ? new cq(6) : cqVar;
                        cqVar2.a(b4[i4]);
                        cqVar = cqVar2;
                    }
                    a(b4[i4], (Set) hashSet);
                    c2 = 5;
                    z2 = true;
                    i4++;
                    char c4 = c2;
                    r = i3;
                    a2 = z;
                } else if (q == 5 && o2.equals(bnVar)) {
                    a(b4[i4], a3);
                    if (bnVar == o) {
                        cqVar = new cq(4, b4[i4]);
                    }
                    bnVar = ((i) b4[i4].i()).d_();
                } else if (q == 39 && bnVar.a(o2)) {
                    a(b4[i4], a3);
                    if (bnVar == o) {
                        c2 = 5;
                        cqVar = new cq(5, b4[i4]);
                    } else {
                        c2 = 5;
                    }
                    try {
                        bnVar = bnVar.a((s) b4[i4].i());
                        i4++;
                        char c42 = c2;
                        r = i3;
                        a2 = z;
                    } catch (bo unused) {
                        i = 2;
                    }
                }
            } else {
                i3 = r;
                z = a2;
            }
            c2 = 5;
            i4++;
            char c422 = c2;
            r = i3;
            a2 = z;
        }
        z = a2;
        i2 = 0;
        bx[] b5 = bbVar2.b(i);
        bx bxVar = null;
        bx bxVar2 = null;
        for (int i5 = i2; i5 < b5.length; i5++) {
            if (b5[i5].i().q() == 6 && bnVar.a(b5[i5].i().o())) {
                bxVar2 = b5[i5];
            } else if (b5[i5].i().q() == 2 && bnVar.a(b5[i5].i().o())) {
                bxVar = b5[i5];
            }
        }
        if (!z2) {
            if (c3 == 3) {
                p = i2;
            }
            if (c3 == 3 || bxVar2 != null || bxVar == null) {
                a(bnVar, p, bxVar2 != null ? (ck) bxVar2.i() : null, a(2, b2));
                if (cqVar == null) {
                    cqVar = cq.a(c3 == 3 ? 1 : 2);
                }
            } else {
                a(bxVar, a(2, b2));
                a(bxVar, (Set) hashSet);
                if (cqVar == null) {
                    cqVar = new cq(3, bxVar);
                }
            }
        } else if (c3 == 0 && bxVar != null) {
            a(bxVar, a(2, b2));
            a(bxVar, (Set) hashSet);
        }
        cq cqVar3 = cqVar;
        bx[] b6 = bbVar2.b(3);
        for (int i6 = i2; i6 < b6.length; i6++) {
            int q2 = b6[i6].i().q();
            if ((q2 == 1 || q2 == 28 || q2 == 38) && hashSet.contains(b6[i6].i().o())) {
                a(b6[i6], a(3, b2));
            }
        }
        if (z) {
            System.out.println("addMessage: " + cqVar3);
        }
        return cqVar3;
    }

    private void d(bn bnVar, int i) {
        a(bnVar, i);
    }

    private void c(bn bnVar) {
        b(bnVar);
    }

    private void a(int i) {
        this.c = i;
    }

    private int b() {
        return this.c;
    }

    private void b(int i) {
        this.d = i;
    }

    private int c() {
        return this.d;
    }

    private int d() {
        return this.b.size();
    }

    private int e() {
        return this.b.a();
    }

    private void c(int i) {
        this.b.a(i);
    }

    private int f() {
        return this.e;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this) {
            for (Object a2 : this.b.values()) {
                c[] a3 = a(a2);
                for (c append : a3) {
                    stringBuffer.append(append);
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    private List g() {
        return this.a;
    }

    private bx[] d(bn bnVar, int i, int i2) {
        cq c2 = c(bnVar, i, i2);
        if (c2.f()) {
            return c2.g();
        }
        return null;
    }

    static /* synthetic */ int a(long j, long j2) {
        if (j2 >= 0 && j2 < j) {
            j = j2;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j;
        if (currentTimeMillis < 0 || currentTimeMillis > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) currentTimeMillis;
    }
}
