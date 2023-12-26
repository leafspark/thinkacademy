package com.bonree.sdk.bc;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public final class ab implements cd {
    private static final int a = 5;
    /* access modifiers changed from: private */
    public List b;
    /* access modifiers changed from: private */
    public boolean c = false;
    /* access modifiers changed from: private */
    public int d = 0;
    /* access modifiers changed from: private */
    public int e = 3;

    static /* synthetic */ int c(ab abVar) {
        int i = abVar.d;
        abVar.d = i + 1;
        return i;
    }

    static class a implements cf {
        cf a;
        private cd[] b;
        private int[] c;
        private Object[] d;
        private int e;
        private int f;
        private boolean g;
        private bb h;
        private bb i;
        private Throwable j;

        public a(ab abVar, bb bbVar) {
            List a2 = abVar.b;
            this.b = (cd[]) a2.toArray(new cd[a2.size()]);
            if (abVar.c) {
                int length = this.b.length;
                int c2 = ab.c(abVar) % length;
                if (abVar.d > length) {
                    int unused = abVar.d = abVar.d % length;
                }
                if (c2 > 0) {
                    cd[] cdVarArr = new cd[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        cdVarArr[i2] = this.b[(i2 + c2) % length];
                    }
                    this.b = cdVarArr;
                }
            }
            cd[] cdVarArr2 = this.b;
            this.c = new int[cdVarArr2.length];
            this.d = new Object[cdVarArr2.length];
            this.e = abVar.e;
            this.h = bbVar;
        }

        public final void a(int i2) {
            int[] iArr = this.c;
            iArr[i2] = iArr[i2] + 1;
            this.f++;
            try {
                this.d[i2] = this.b[i2].a(this.h, (cf) this);
            } catch (Throwable th) {
                synchronized (this) {
                    this.j = th;
                    this.g = true;
                    if (this.a == null) {
                        notifyAll();
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            wait();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
            r0 = r3.i;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
            if (r0 != null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
            r0 = r3.j;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
            if ((r0 instanceof java.io.IOException) == false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
            if ((r0 instanceof java.lang.RuntimeException) == false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
            if ((r0 instanceof java.lang.Error) != false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            throw ((java.lang.Error) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
            throw new java.lang.IllegalStateException("ExtendedResolver failure");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
            throw ((java.lang.RuntimeException) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
            throw ((java.io.IOException) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            if (r3.g == false) goto L_0x0030;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002c */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002c A[LOOP:0: B:7:0x002c->B:35:0x002c, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.bonree.sdk.bc.bb a() throws java.io.IOException {
            /*
                r3 = this;
                r0 = 0
                int[] r1 = r3.c     // Catch:{ Exception -> 0x0023 }
                r2 = r1[r0]     // Catch:{ Exception -> 0x0023 }
                int r2 = r2 + 1
                r1[r0] = r2     // Catch:{ Exception -> 0x0023 }
                int r1 = r3.f     // Catch:{ Exception -> 0x0023 }
                int r1 = r1 + 1
                r3.f = r1     // Catch:{ Exception -> 0x0023 }
                java.lang.Object[] r1 = r3.d     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x0023 }
                r2.<init>()     // Catch:{ Exception -> 0x0023 }
                r1[r0] = r2     // Catch:{ Exception -> 0x0023 }
                com.bonree.sdk.bc.cd[] r1 = r3.b     // Catch:{ Exception -> 0x0023 }
                r1 = r1[r0]     // Catch:{ Exception -> 0x0023 }
                com.bonree.sdk.bc.bb r2 = r3.h     // Catch:{ Exception -> 0x0023 }
                com.bonree.sdk.bc.bb r0 = r1.a((com.bonree.sdk.bc.bb) r2)     // Catch:{ Exception -> 0x0023 }
                return r0
            L_0x0023:
                r1 = move-exception
                java.lang.Object[] r2 = r3.d
                r0 = r2[r0]
                r3.a(r0, r1)
                monitor-enter(r3)
            L_0x002c:
                boolean r0 = r3.g     // Catch:{ all -> 0x0059 }
                if (r0 != 0) goto L_0x0034
                r3.wait()     // Catch:{ InterruptedException -> 0x002c }
                goto L_0x002c
            L_0x0034:
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                com.bonree.sdk.bc.bb r0 = r3.i
                if (r0 == 0) goto L_0x003a
                return r0
            L_0x003a:
                java.lang.Throwable r0 = r3.j
                boolean r1 = r0 instanceof java.io.IOException
                if (r1 != 0) goto L_0x0056
                boolean r1 = r0 instanceof java.lang.RuntimeException
                if (r1 != 0) goto L_0x0053
                boolean r1 = r0 instanceof java.lang.Error
                if (r1 == 0) goto L_0x004b
                java.lang.Error r0 = (java.lang.Error) r0
                throw r0
            L_0x004b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "ExtendedResolver failure"
                r0.<init>(r1)
                throw r0
            L_0x0053:
                java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0
                throw r0
            L_0x0056:
                java.io.IOException r0 = (java.io.IOException) r0
                throw r0
            L_0x0059:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.ab.a.a():com.bonree.sdk.bc.bb");
        }

        public final void a(cf cfVar) {
            this.a = cfVar;
            a(0);
        }

        public final void a(bb bbVar) {
            if (br.a("verbose")) {
                System.err.println("ExtendedResolver: received message");
            }
            synchronized (this) {
                if (!this.g) {
                    this.i = bbVar;
                    this.g = true;
                    cf cfVar = this.a;
                    if (cfVar == null) {
                        notifyAll();
                    } else {
                        cfVar.a(bbVar);
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0097, code lost:
            if ((r5.j instanceof java.lang.Exception) != false) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0099, code lost:
            r5.j = new java.lang.RuntimeException(r5.j.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a6, code lost:
            r5.a.a(r5, (java.lang.Exception) r5.j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00af, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x006f A[DONT_GENERATE] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0071  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.Object r6, java.lang.Exception r7) {
            /*
                r5 = this;
                java.lang.String r0 = "verbose"
                boolean r0 = com.bonree.sdk.bc.br.a(r0)
                if (r0 == 0) goto L_0x001b
                java.io.PrintStream r0 = java.lang.System.err
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "ExtendedResolver: got "
                r1.<init>(r2)
                r1.append(r7)
                java.lang.String r1 = r1.toString()
                r0.println(r1)
            L_0x001b:
                monitor-enter(r5)
                int r0 = r5.f     // Catch:{ all -> 0x00b0 }
                r1 = 1
                int r0 = r0 - r1
                r5.f = r0     // Catch:{ all -> 0x00b0 }
                boolean r0 = r5.g     // Catch:{ all -> 0x00b0 }
                if (r0 == 0) goto L_0x0028
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return
            L_0x0028:
                r0 = 0
                r2 = r0
            L_0x002a:
                java.lang.Object[] r3 = r5.d     // Catch:{ all -> 0x00b0 }
                int r4 = r3.length     // Catch:{ all -> 0x00b0 }
                if (r2 >= r4) goto L_0x0036
                r4 = r3[r2]     // Catch:{ all -> 0x00b0 }
                if (r4 == r6) goto L_0x0036
                int r2 = r2 + 1
                goto L_0x002a
            L_0x0036:
                int r6 = r3.length     // Catch:{ all -> 0x00b0 }
                if (r2 != r6) goto L_0x003b
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return
            L_0x003b:
                int[] r6 = r5.c     // Catch:{ all -> 0x00b0 }
                r3 = r6[r2]     // Catch:{ all -> 0x00b0 }
                if (r3 != r1) goto L_0x0048
                com.bonree.sdk.bc.cd[] r3 = r5.b     // Catch:{ all -> 0x00b0 }
                int r3 = r3.length     // Catch:{ all -> 0x00b0 }
                int r3 = r3 - r1
                if (r2 >= r3) goto L_0x0048
                r0 = r1
            L_0x0048:
                boolean r3 = r7 instanceof java.io.InterruptedIOException     // Catch:{ all -> 0x00b0 }
                if (r3 == 0) goto L_0x005a
                r6 = r6[r2]     // Catch:{ all -> 0x00b0 }
                int r3 = r5.e     // Catch:{ all -> 0x00b0 }
                if (r6 >= r3) goto L_0x0055
                r5.a((int) r2)     // Catch:{ all -> 0x00b0 }
            L_0x0055:
                java.lang.Throwable r6 = r5.j     // Catch:{ all -> 0x00b0 }
                if (r6 != 0) goto L_0x006b
                goto L_0x0069
            L_0x005a:
                boolean r6 = r7 instanceof java.net.SocketException     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x0069
                java.lang.Throwable r6 = r5.j     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x0066
                boolean r6 = r6 instanceof java.io.InterruptedIOException     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x006b
            L_0x0066:
                r5.j = r7     // Catch:{ all -> 0x00b0 }
                goto L_0x006b
            L_0x0069:
                r5.j = r7     // Catch:{ all -> 0x00b0 }
            L_0x006b:
                boolean r6 = r5.g     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x0071
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return
            L_0x0071:
                if (r0 == 0) goto L_0x0077
                int r2 = r2 + r1
                r5.a((int) r2)     // Catch:{ all -> 0x00b0 }
            L_0x0077:
                boolean r6 = r5.g     // Catch:{ all -> 0x00b0 }
                if (r6 == 0) goto L_0x007d
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return
            L_0x007d:
                int r6 = r5.f     // Catch:{ all -> 0x00b0 }
                if (r6 != 0) goto L_0x008c
                r5.g = r1     // Catch:{ all -> 0x00b0 }
                com.bonree.sdk.bc.cf r6 = r5.a     // Catch:{ all -> 0x00b0 }
                if (r6 != 0) goto L_0x008c
                r5.notifyAll()     // Catch:{ all -> 0x00b0 }
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return
            L_0x008c:
                boolean r6 = r5.g     // Catch:{ all -> 0x00b0 }
                if (r6 != 0) goto L_0x0092
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return
            L_0x0092:
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                java.lang.Throwable r6 = r5.j
                boolean r6 = r6 instanceof java.lang.Exception
                if (r6 != 0) goto L_0x00a6
                java.lang.RuntimeException r6 = new java.lang.RuntimeException
                java.lang.Throwable r7 = r5.j
                java.lang.String r7 = r7.getMessage()
                r6.<init>(r7)
                r5.j = r6
            L_0x00a6:
                com.bonree.sdk.bc.cf r6 = r5.a
                java.lang.Throwable r7 = r5.j
                java.lang.Exception r7 = (java.lang.Exception) r7
                r6.a(r5, r7)
                return
            L_0x00b0:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.ab.a.a(java.lang.Object, java.lang.Exception):void");
        }
    }

    private void a() {
        this.b = new ArrayList();
    }

    public ab() throws UnknownHostException {
        a();
        String[] a2 = ce.e().a();
        if (a2 != null) {
            for (String crVar : a2) {
                cr crVar2 = new cr(crVar);
                crVar2.c(5);
                this.b.add(crVar2);
            }
            return;
        }
        this.b.add(new cr());
    }

    private ab(String[] strArr) throws UnknownHostException {
        a();
        for (String crVar : strArr) {
            cr crVar2 = new cr(crVar);
            crVar2.c(5);
            this.b.add(crVar2);
        }
    }

    private ab(cd[] cdVarArr) throws UnknownHostException {
        a();
        for (cd add : cdVarArr) {
            this.b.add(add);
        }
    }

    public final void a(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            ((cd) this.b.get(i2)).a(i);
        }
    }

    public final void a(boolean z) {
        for (int i = 0; i < this.b.size(); i++) {
            ((cd) this.b.get(i)).a(z);
        }
    }

    public final void b(boolean z) {
        for (int i = 0; i < this.b.size(); i++) {
            ((cd) this.b.get(i)).b(z);
        }
    }

    public final void b(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            ((cd) this.b.get(i2)).b(i);
        }
    }

    public final void a(int i, int i2, int i3, List list) {
        for (int i4 = 0; i4 < this.b.size(); i4++) {
            ((cd) this.b.get(i4)).a(i, i2, i3, list);
        }
    }

    public final void a(cx cxVar) {
        for (int i = 0; i < this.b.size(); i++) {
            ((cd) this.b.get(i)).a(cxVar);
        }
    }

    public final void a(int i, int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            ((cd) this.b.get(i3)).a(i, i2);
        }
    }

    public final void c(int i) {
        a(5, 0);
    }

    public final bb a(bb bbVar) throws IOException {
        return new a(this, bbVar).a();
    }

    public final Object a(bb bbVar, cf cfVar) {
        a aVar = new a(this, bbVar);
        aVar.a = cfVar;
        aVar.a(0);
        return aVar;
    }

    private cd d(int i) {
        if (i < this.b.size()) {
            return (cd) this.b.get(i);
        }
        return null;
    }

    private cd[] b() {
        List list = this.b;
        return (cd[]) list.toArray(new cd[list.size()]);
    }

    private void a(cd cdVar) {
        this.b.add(cdVar);
    }

    private void b(cd cdVar) {
        this.b.remove(cdVar);
    }

    private void c(boolean z) {
        this.c = z;
    }

    private void e(int i) {
        this.e = i;
    }
}
