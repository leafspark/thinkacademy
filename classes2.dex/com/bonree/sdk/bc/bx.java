package com.bonree.sdk.bc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bx implements Serializable {
    private static final long a = -3270249290171239695L;
    private List b;
    private short c;
    private short d;

    public bx() {
        this.b = new ArrayList(1);
        this.c = 0;
        this.d = 0;
    }

    public bx(ca caVar) {
        this();
        c(caVar);
    }

    public bx(bx bxVar) {
        synchronized (bxVar) {
            this.b = (List) ((ArrayList) bxVar.b).clone();
            this.c = bxVar.c;
            this.d = bxVar.d;
        }
    }

    private void c(ca caVar) {
        if (caVar instanceof bw) {
            this.b.add(caVar);
            this.c = (short) (this.c + 1);
        } else if (this.c == 0) {
            this.b.add(caVar);
        } else {
            List list = this.b;
            list.add(list.size() - this.c, caVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.bonree.sdk.bc.ca r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.List r0 = r5.b     // Catch:{ all -> 0x0075 }
            int r0 = r0.size()     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x000e
            r5.c(r6)     // Catch:{ all -> 0x0075 }
            monitor-exit(r5)
            return
        L_0x000e:
            com.bonree.sdk.bc.ca r0 = r5.i()     // Catch:{ all -> 0x0075 }
            boolean r1 = r6.a((com.bonree.sdk.bc.ca) r0)     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x006d
            long r1 = r6.s()     // Catch:{ all -> 0x0075 }
            long r3 = r0.s()     // Catch:{ all -> 0x0075 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0060
            long r1 = r6.s()     // Catch:{ all -> 0x0075 }
            long r3 = r0.s()     // Catch:{ all -> 0x0075 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x003c
            com.bonree.sdk.bc.ca r6 = r6.t()     // Catch:{ all -> 0x0075 }
            long r0 = r0.s()     // Catch:{ all -> 0x0075 }
            r6.a((long) r0)     // Catch:{ all -> 0x0075 }
            goto L_0x0060
        L_0x003c:
            r0 = 0
        L_0x003d:
            java.util.List r1 = r5.b     // Catch:{ all -> 0x0075 }
            int r1 = r1.size()     // Catch:{ all -> 0x0075 }
            if (r0 >= r1) goto L_0x0060
            java.util.List r1 = r5.b     // Catch:{ all -> 0x0075 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0075 }
            com.bonree.sdk.bc.ca r1 = (com.bonree.sdk.bc.ca) r1     // Catch:{ all -> 0x0075 }
            com.bonree.sdk.bc.ca r1 = r1.t()     // Catch:{ all -> 0x0075 }
            long r2 = r6.s()     // Catch:{ all -> 0x0075 }
            r1.a((long) r2)     // Catch:{ all -> 0x0075 }
            java.util.List r2 = r5.b     // Catch:{ all -> 0x0075 }
            r2.set(r0, r1)     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 1
            goto L_0x003d
        L_0x0060:
            java.util.List r0 = r5.b     // Catch:{ all -> 0x0075 }
            boolean r0 = r0.contains(r6)     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006b
            r5.c(r6)     // Catch:{ all -> 0x0075 }
        L_0x006b:
            monitor-exit(r5)
            return
        L_0x006d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "record does not match rrset"
            r6.<init>(r0)     // Catch:{ all -> 0x0075 }
            throw r6     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.bx.a(com.bonree.sdk.bc.ca):void");
    }

    public final synchronized void b(ca caVar) {
        if (this.b.remove(caVar) && (caVar instanceof bw)) {
            this.c = (short) (this.c - 1);
        }
    }

    private synchronized void a() {
        this.b.clear();
        this.d = 0;
        this.c = 0;
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        int i;
        int i2;
        int size = this.b.size();
        if (z) {
            i = size - this.c;
        } else {
            i = this.c;
        }
        if (i == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z) {
            i2 = size - this.c;
        } else if (!z2) {
            i2 = 0;
        } else {
            if (this.d >= i) {
                this.d = 0;
            }
            i2 = this.d;
            this.d = (short) (i2 + 1);
        }
        ArrayList arrayList = new ArrayList(i);
        if (z) {
            arrayList.addAll(this.b.subList(i2, i));
            if (i2 != 0) {
                arrayList.addAll(this.b.subList(0, i2));
            }
        } else {
            arrayList.addAll(this.b.subList(i2, size));
        }
        return arrayList.iterator();
    }

    private synchronized Iterator a(boolean z) {
        return a(true, z);
    }

    public final synchronized Iterator c() {
        return a(true, true);
    }

    public final synchronized Iterator d() {
        return a(false, false);
    }

    public final synchronized int e() {
        return this.b.size() - this.c;
    }

    public final bn f() {
        return i().o();
    }

    public final int b() {
        return i().q();
    }

    public final int g() {
        return i().r();
    }

    public final synchronized long h() {
        return i().s();
    }

    public final synchronized ca i() {
        if (this.b.size() != 0) {
        } else {
            throw new IllegalStateException("rrset is empty");
        }
        return (ca) this.b.get(0);
    }

    private static String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            stringBuffer.append("[");
            stringBuffer.append(((ca) it.next()).b());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        if (this.b.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(i().o() + " ");
        stringBuffer.append(h() + " ");
        stringBuffer.append(p.b(i().r()) + " ");
        stringBuffer.append(df.b(i().q()) + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.c > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
