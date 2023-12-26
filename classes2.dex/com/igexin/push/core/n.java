package com.igexin.push.core;

import android.content.ContentValues;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class n {
    private static volatile n e;
    private final Object a = new Object();
    private boolean b = false;
    private final Map<String, Object> c = new HashMap();
    private final ExecutorService d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private n() {
        b();
    }

    public static n a() {
        if (e == null) {
            synchronized (n.class) {
                if (e == null) {
                    e = new n();
                }
            }
        }
        return e;
    }

    private void b() {
        Thread thread = new Thread(new o(this), "MessageTaskIDPreferences-load");
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void c() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.a
            monitor-enter(r0)
            boolean r1 = r7.b     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            r0 = 0
            r1 = 1
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            r4 = 604800000(0x240c8400, double:2.988109026E-315)
            long r2 = r2 - r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            r4.<init>()     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            java.lang.String r5 = " createtime >= "
            r4.append(r5)     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            r4.append(r2)     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            com.igexin.push.core.c r3 = com.igexin.push.core.c.a()     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            com.igexin.push.b.b r3 = r3.k()     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            java.lang.String r4 = "message"
            java.lang.String r5 = "taskid"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            android.database.Cursor r2 = r3.a((java.lang.String) r4, (java.lang.String[]) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x0090, all -> 0x0078 }
            if (r2 == 0) goto L_0x0058
            int r3 = r2.getCount()     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            if (r3 > 0) goto L_0x0042
            goto L_0x0058
        L_0x0042:
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            if (r3 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Object> r3 = r7.c     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            java.lang.String r4 = "taskid"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            goto L_0x0042
        L_0x0058:
            java.lang.String r0 = "MessageTaskIDPreference|db cnt = 0"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0076, all -> 0x0074 }
        L_0x0060:
            java.lang.Object r0 = r7.a
            monitor-enter(r0)
            r7.b = r1     // Catch:{ all -> 0x0071 }
            java.lang.Object r1 = r7.a     // Catch:{ all -> 0x0071 }
            r1.notifyAll()     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x00a0
            r2.close()     // Catch:{ all -> 0x00a0 }
            goto L_0x00a0
        L_0x0071:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r1
        L_0x0074:
            r0 = move-exception
            goto L_0x007c
        L_0x0076:
            r0 = r2
            goto L_0x0090
        L_0x0078:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
        L_0x007c:
            java.lang.Object r3 = r7.a
            monitor-enter(r3)
            r7.b = r1     // Catch:{ all -> 0x008d }
            java.lang.Object r1 = r7.a     // Catch:{ all -> 0x008d }
            r1.notifyAll()     // Catch:{ all -> 0x008d }
            monitor-exit(r3)     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ all -> 0x008c }
        L_0x008c:
            throw r0
        L_0x008d:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008d }
            throw r0
        L_0x0090:
            java.lang.Object r2 = r7.a
            monitor-enter(r2)
            r7.b = r1     // Catch:{ all -> 0x00a1 }
            java.lang.Object r1 = r7.a     // Catch:{ all -> 0x00a1 }
            r1.notifyAll()     // Catch:{ all -> 0x00a1 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x00a0
            r0.close()     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            return
        L_0x00a1:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a1 }
            throw r0
        L_0x00a4:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.c():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:13:0x0003, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.a
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r2.b     // Catch:{ all -> 0x000f }
            if (r1 != 0) goto L_0x000d
            java.lang.Object r1 = r2.a     // Catch:{ InterruptedException -> 0x0003 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0003 }
            goto L_0x0003
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.d():void");
    }

    public void a(String str, ContentValues contentValues) {
        if (!TextUtils.isEmpty(str)) {
            d();
            synchronized (this.a) {
                this.c.put(str, (Object) null);
            }
            this.d.execute(new p(this, contentValues));
        }
    }

    public boolean a(String str) {
        boolean containsKey;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d();
        synchronized (this.a) {
            containsKey = this.c.containsKey(str);
        }
        return containsKey;
    }

    public void b(String str, ContentValues contentValues) {
        if (a(str)) {
            this.d.execute(new q(this, contentValues, str));
        }
    }
}
