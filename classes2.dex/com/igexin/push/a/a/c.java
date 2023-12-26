package com.igexin.push.a.a;

public class c implements com.igexin.push.f.b.c {
    private static c c;
    private long a = 0;
    private long b = 0;
    private boolean d = false;

    private c() {
    }

    public static c c() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    public void a() {
        d();
    }

    public void a(long j) {
        this.a = j;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.a > this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        if (r2.getTimeInMillis() < r0) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007a, code lost:
        if (r2.getTimeInMillis() < r0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r12 = this;
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            r12.b = r0
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = com.igexin.push.config.l.b
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0087
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            boolean r5 = com.igexin.push.util.a.a((long) r0)
            r6 = 5
            r7 = 13
            r8 = 12
            r9 = 11
            if (r5 == 0) goto L_0x0058
            boolean r5 = r12.d
            if (r5 != 0) goto L_0x0031
            r12.d = r3
            com.igexin.push.core.c r5 = com.igexin.push.core.c.a()
            com.igexin.push.e.a r5 = r5.i()
            r5.c()
        L_0x0031:
            int r5 = com.igexin.push.config.l.a
            int r10 = com.igexin.push.config.l.b
            int r5 = r5 + r10
            r10 = 24
            if (r5 <= r10) goto L_0x0041
            int r5 = com.igexin.push.config.l.a
            int r11 = com.igexin.push.config.l.b
            int r5 = r5 + r11
            int r5 = r5 - r10
            goto L_0x0046
        L_0x0041:
            int r5 = com.igexin.push.config.l.a
            int r10 = com.igexin.push.config.l.b
            int r5 = r5 + r10
        L_0x0046:
            r2.set(r9, r5)
            r2.set(r8, r4)
            r2.set(r7, r4)
            long r4 = r2.getTimeInMillis()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x007f
            goto L_0x007c
        L_0x0058:
            boolean r5 = r12.d
            if (r5 == 0) goto L_0x0069
            r12.d = r4
            com.igexin.push.core.c r5 = com.igexin.push.core.c.a()
            com.igexin.push.e.a r5 = r5.i()
            r5.b()
        L_0x0069:
            int r5 = com.igexin.push.config.l.a
            r2.set(r9, r5)
            r2.set(r8, r4)
            r2.set(r7, r4)
            long r4 = r2.getTimeInMillis()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x007f
        L_0x007c:
            r2.add(r6, r3)
        L_0x007f:
            long r4 = r2.getTimeInMillis()
            long r4 = r4 - r0
            r12.b = r4
            goto L_0x0098
        L_0x0087:
            boolean r2 = r12.d
            if (r2 == 0) goto L_0x0098
            r12.d = r4
            com.igexin.push.core.c r2 = com.igexin.push.core.c.a()
            com.igexin.push.e.a r2 = r2.i()
            r2.b()
        L_0x0098:
            long r4 = com.igexin.push.config.l.c
            long r6 = r12.b
            long r6 = r6 + r0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b7
            long r4 = com.igexin.push.config.l.c
            long r4 = r4 - r0
            r12.b = r4
            boolean r0 = r12.d
            if (r0 != 0) goto L_0x00b7
            r12.d = r3
            com.igexin.push.core.c r0 = com.igexin.push.core.c.a()
            com.igexin.push.e.a r0 = r0.i()
            r0.c()
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.a.a.c.d():void");
    }
}
