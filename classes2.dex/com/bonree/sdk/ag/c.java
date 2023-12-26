package com.bonree.sdk.ag;

import android.os.Build;
import android.text.TextUtils;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.ANREventInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.crash.anr.AnrEngine;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public final class c extends f implements com.bonree.sdk.agent.engine.crash.a {
    private static final String p = "Unknown Source";
    private static final String q = "Proguard";
    private static final int s = 3000;
    private final String g = "Anr";
    private String h;
    private String i = "";
    private String j = "";
    private String k;
    private String l;
    private int m;
    private ReadWriteLock n = new ReentrantReadWriteLock();
    private final List<a> o = Collections.synchronizedList(new ArrayList());
    private EventBean r;

    public interface a {
        void h();
    }

    public c(e eVar) {
        super(eVar);
    }

    public final synchronized boolean b() {
        if (!this.a) {
            a("Anr", a.d.a);
            this.c.c("AnrService is start .", new Object[0]);
            this.a = true;
            AnrEngine.getEngine().registerService(this);
            a("Anr", a.d.c);
        } else {
            a("Anr", a.d.b);
        }
        return true;
    }

    public final synchronized boolean c() {
        if (this.a) {
            a("Anr", a.d.d);
            this.c.c("AnrService is stop .", new Object[0]);
            this.a = false;
            AnrEngine.getEngine().unRegisterService(this);
            g();
            synchronized (this.o) {
                this.o.clear();
            }
        } else {
            this.c.d("AnrService no need stoped!", new Object[0]);
        }
        a("Anr", a.d.e);
        return true;
    }

    private void g() {
        this.k = null;
        this.h = null;
        this.l = "";
        this.i = "";
    }

    private void h() {
        synchronized (this.o) {
            this.o.clear();
        }
    }

    public final void a(com.bonree.sdk.ah.a aVar) {
        com.bonree.sdk.d.a.a.e("AnrService onAnrCallback", new Object[0]);
        this.c.c("AnrService processing messages...  %s", aVar);
        if (aVar != null) {
            this.h = aVar.d();
            this.k = aVar.a();
            if (aVar.e() == 1) {
                if (aVar.b() != null) {
                    new com.bonree.sdk.bs.c(5000, new d(this, aVar)).a();
                }
            } else if (aVar.e() == 2) {
                if (aVar.c() != null) {
                    a c = aVar.c();
                    if (c != null) {
                        Throwable cause = c.getCause();
                        if (cause != null) {
                            StringBuilder sb = new StringBuilder();
                            while (cause != null) {
                                sb.append(cause.getMessage());
                                sb.append(HTTP.CRLF);
                                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                                    sb.append("at ");
                                    sb.append(stackTraceElement.toString());
                                    sb.append(HTTP.CRLF);
                                }
                                cause = cause.getCause();
                            }
                            this.l = com.bonree.sdk.an.a.c(sb.toString());
                        }
                        String a2 = ad.a(400);
                        if (!TextUtils.isEmpty(a2)) {
                            if (this.h == null) {
                                this.h = "HiLog:\r\n" + a2;
                            } else {
                                this.h += "\r\nHiLog:\r\n" + a2;
                            }
                        }
                    }
                    a("watchdog", aVar.b());
                }
            } else if (aVar.e() == 3) {
                this.c.e("Anr handleNativeSignalAnr", new Object[0]);
                e(aVar.b());
                a("nativeSignal", aVar.b());
            }
        }
    }

    private void b(com.bonree.sdk.ah.a aVar) {
        if (aVar.b() != null) {
            new com.bonree.sdk.bs.c(5000, new d(this, aVar)).a();
        }
    }

    private void c(com.bonree.sdk.ah.a aVar) {
        if (aVar.c() != null) {
            a(aVar.c());
            a("watchdog", aVar.b());
        }
    }

    private void d(com.bonree.sdk.ah.a aVar) {
        this.c.e("Anr handleNativeSignalAnr", new Object[0]);
        e(aVar.b());
        a("nativeSignal", aVar.b());
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean b(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r0 = "\""
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            boolean r4 = com.bonree.sdk.bs.ad.a((java.lang.String) r18)
            r5 = 0
            if (r4 == 0) goto L_0x0013
            return r5
        L_0x0013:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x00b3 }
            r9.<init>(r2)     // Catch:{ all -> 0x00b3 }
            java.io.InputStreamReader r10 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ab }
            r10.<init>(r9)     // Catch:{ all -> 0x00ab }
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ all -> 0x00a6 }
            r11.<init>(r10)     // Catch:{ all -> 0x00a6 }
            java.lang.String r12 = "\r\n"
            r13 = r5
            r14 = 0
        L_0x0026:
            java.lang.String r15 = r11.readLine()     // Catch:{ all -> 0x009d }
            if (r15 == 0) goto L_0x008d
            java.lang.String r4 = " "
            if (r14 == 0) goto L_0x0037
            boolean r16 = r15.startsWith(r4)     // Catch:{ all -> 0x009d }
            if (r16 != 0) goto L_0x0037
            r14 = 0
        L_0x0037:
            java.lang.String r8 = "\"main\" prio="
            boolean r8 = r15.contains(r8)     // Catch:{ all -> 0x009d }
            if (r8 == 0) goto L_0x006c
            if (r14 != 0) goto L_0x006c
            int r8 = r15.indexOf(r0)     // Catch:{ all -> 0x009d }
            int r14 = r8 + 1
            int r7 = r15.indexOf(r0, r14)     // Catch:{ all -> 0x009d }
            r6 = -1
            if (r8 == r6) goto L_0x0054
            if (r7 == r6) goto L_0x0054
            java.lang.String r5 = r15.substring(r14, r7)     // Catch:{ all -> 0x009d }
        L_0x0054:
            java.lang.String r7 = "tid="
            int r7 = r15.indexOf(r7)     // Catch:{ all -> 0x009d }
            int r8 = r7 + 1
            int r4 = r15.indexOf(r4, r8)     // Catch:{ all -> 0x009d }
            if (r7 == r6) goto L_0x006b
            if (r4 == r6) goto L_0x006b
            int r7 = r7 + 4
            java.lang.String r4 = r15.substring(r7, r4)     // Catch:{ all -> 0x009d }
            r13 = r4
        L_0x006b:
            r14 = 1
        L_0x006c:
            if (r14 == 0) goto L_0x0026
            java.lang.String r4 = r15.trim()     // Catch:{ all -> 0x009d }
            java.lang.String r6 = "native"
            boolean r4 = r4.startsWith(r6)     // Catch:{ all -> 0x009d }
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = r15.trim()     // Catch:{ all -> 0x009d }
            java.lang.String r6 = "at"
            boolean r4 = r4.startsWith(r6)     // Catch:{ all -> 0x009d }
            if (r4 == 0) goto L_0x0026
        L_0x0086:
            r3.append(r15)     // Catch:{ all -> 0x009d }
            r3.append(r12)     // Catch:{ all -> 0x009d }
            goto L_0x0026
        L_0x008d:
            r4 = 3
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r4 = 0
            r0[r4] = r11
            r4 = 1
            r0[r4] = r10
            r4 = 2
            r0[r4] = r9
            com.bonree.sdk.bs.ad.a((java.io.Closeable[]) r0)
            goto L_0x00d0
        L_0x009d:
            r0 = move-exception
            r4 = r0
            r0 = r5
            goto L_0x00b1
        L_0x00a1:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r13 = r0
            goto L_0x00b1
        L_0x00a6:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r11 = r0
            goto L_0x00b0
        L_0x00ab:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r10 = r0
            r11 = r10
        L_0x00b0:
            r13 = r11
        L_0x00b1:
            r5 = r9
            goto L_0x00b9
        L_0x00b3:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r10 = r0
            r11 = r10
            r13 = r11
        L_0x00b9:
            com.bonree.sdk.be.f r6 = r1.c     // Catch:{ all -> 0x010e }
            java.lang.String r7 = "Anrread e= %s"
            r6.a((java.lang.String) r7, (java.lang.Throwable) r4)     // Catch:{ all -> 0x010e }
            r4 = 3
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r6 = 0
            r4[r6] = r11
            r6 = 1
            r4[r6] = r10
            r6 = 2
            r4[r6] = r5
            com.bonree.sdk.bs.ad.a((java.io.Closeable[]) r4)
            r5 = r0
        L_0x00d0:
            com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean r0 = new com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean
            r0.<init>()
            r0.mThreadName = r5
            r0.mThreadId = r13
            java.lang.String r3 = r3.toString()
            r0.mDumpInfo = r3
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
            boolean r2 = r3.exists()
            if (r2 == 0) goto L_0x010d
            boolean r2 = r3.isFile()
            if (r2 == 0) goto L_0x010d
            boolean r2 = r3.delete()
            com.bonree.sdk.be.f r4 = r1.c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "delete anr log success.file:%s state="
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r3
            r4.c(r2, r5)
        L_0x010d:
            return r0
        L_0x010e:
            r0 = move-exception
            r2 = 3
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r3 = 0
            r2[r3] = r11
            r3 = 1
            r2[r3] = r10
            r3 = 2
            r2[r3] = r5
            com.bonree.sdk.bs.ad.a((java.io.Closeable[]) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ag.c.b(java.lang.String):com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r2 = "addAnrLogBean:"
            r1.<init>(r2)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.append(r6)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0.e(r1, r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            com.bonree.sdk.be.f r0 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "Anr addAnrLogBean:"
            r1.<init>(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.append(r6)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0.c(r1, r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r0 = "nativeSignal"
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r0 == 0) goto L_0x0067
            com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean r7 = r5.b((java.lang.String) r7)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            com.bonree.sdk.be.f r0 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "Anr mainThreadDump: "
            r1.<init>(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.append(r7)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0.c(r1, r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r7 == 0) goto L_0x0057
            java.lang.String r0 = r7.mDumpInfo     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r0 = com.bonree.sdk.an.a.b((java.lang.String) r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r5.i = r0     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
        L_0x0057:
            java.lang.String r0 = r7.mThreadId     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r0 == 0) goto L_0x0073
            java.lang.String r0 = r7.mThreadName     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r0 == 0) goto L_0x0073
        L_0x0067:
            com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean r7 = com.bonree.sdk.an.a.a((boolean) r2)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r0 = r7.mDumpInfo     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r0 = com.bonree.sdk.an.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r5.i = r0     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
        L_0x0073:
            if (r7 == 0) goto L_0x00a7
            com.bonree.sdk.be.f r0 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "Anr mainThreadDump:"
            r1.<init>(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.append(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0.c(r1, r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.d.a.a     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = " mainThreadDump:"
            r1.<init>(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.append(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0.e(r1, r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
        L_0x00a7:
            r0 = 1
            if (r7 != 0) goto L_0x00b7
            com.bonree.sdk.be.f r7 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = "anr filter: mainThreadDump == null! type is %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0[r2] = r6     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r7.d(r1, r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            monitor-exit(r5)
            return
        L_0x00b7:
            java.lang.String r1 = r7.mDumpInfo     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            int r1 = r1.hashCode()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            int r3 = r5.m     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 == r3) goto L_0x01a5
            java.lang.String r1 = r5.j     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r5.i     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 == 0) goto L_0x00cd
            goto L_0x01a5
        L_0x00cd:
            java.lang.String r1 = r5.h     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 == 0) goto L_0x00ee
            com.bonree.sdk.d.a r1 = com.bonree.sdk.d.a.k()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r1 = r1.z()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 != 0) goto L_0x00ee
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r3 = 27
            if (r1 > r3) goto L_0x00ee
            com.bonree.sdk.be.f r1 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "anr message miss: mAnrMessage isMiss !"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.d(r3, r4)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
        L_0x00ee:
            java.lang.String r1 = r5.i     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 == 0) goto L_0x0107
            com.bonree.sdk.be.f r1 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "anr filter: mCausedBy isMiss !"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.d(r3, r4)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r1 = com.bonree.sdk.d.a.L()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 == 0) goto L_0x0107
        L_0x0105:
            r1 = r0
            goto L_0x011a
        L_0x0107:
            java.lang.String r1 = r5.l     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r1 == 0) goto L_0x0119
            com.bonree.sdk.be.f r1 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "anr filter: mAnrTraceInfo isInvalid !"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.d(r3, r4)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            goto L_0x0105
        L_0x0119:
            r1 = r2
        L_0x011a:
            if (r1 == 0) goto L_0x011e
            monitor-exit(r5)
            return
        L_0x011e:
            java.lang.String r1 = r7.mDumpInfo     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            int r1 = r1.hashCode()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r5.m = r1     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = r5.i     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r5.j = r1     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            com.bonree.sdk.agent.business.entity.ANREventInfoBean r1 = new com.bonree.sdk.agent.business.entity.ANREventInfoBean     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.<init>()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r5.l     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = com.bonree.sdk.bs.ad.j(r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.mAnrTrace = r3     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r5.h     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.mAnrMessage = r3     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r5.k     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.mAnrType = r3     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.mAnrThread = r7     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = r5.i     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.anrCauseBy = r3     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r7 = r7.mDumpInfo     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r7 = c((java.lang.String) r7)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            boolean r3 = com.bonree.sdk.bs.ad.a((java.lang.String) r7)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            if (r3 == 0) goto L_0x0153
            java.lang.String r7 = r5.i     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
        L_0x0153:
            java.lang.String r7 = r5.f(r7)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r1.mAnrPart = r7     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            monitor-enter(r5)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            com.bonree.sdk.agent.business.entity.EventBean r7 = new com.bonree.sdk.agent.business.entity.EventBean     // Catch:{ all -> 0x01a2 }
            r7.<init>()     // Catch:{ all -> 0x01a2 }
            r5.r = r7     // Catch:{ all -> 0x01a2 }
            long r3 = r5.a()     // Catch:{ all -> 0x01a2 }
            r7.mEventTime = r3     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.agent.business.entity.EventBean r7 = r5.r     // Catch:{ all -> 0x01a2 }
            java.lang.String r3 = "anr"
            r7.mEventType = r3     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.agent.business.entity.EventBean r7 = r5.r     // Catch:{ all -> 0x01a2 }
            java.lang.String[] r3 = r7.getStateIndex()     // Catch:{ all -> 0x01a2 }
            r7.mStateIndex = r3     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.agent.business.entity.EventBean r7 = r5.r     // Catch:{ all -> 0x01a2 }
            r7.mEventInfo = r1     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.agent.business.entity.EventBean r7 = r5.r     // Catch:{ all -> 0x01a2 }
            r7.uploadStateKey()     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.agent.business.entity.EventBean r7 = r5.r     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.ax.c r3 = com.bonree.sdk.ax.c.h()     // Catch:{ all -> 0x01a2 }
            java.util.List r3 = r3.e()     // Catch:{ all -> 0x01a2 }
            r7.mTraceInfoList = r3     // Catch:{ all -> 0x01a2 }
            monitor-exit(r5)     // Catch:{ all -> 0x01a2 }
            com.bonree.sdk.be.f r7 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r3 = "Anr information collected successfully! type is %s "
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0[r2] = r6     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r7.c(r3, r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r5.g()     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r5.a((com.bonree.sdk.agent.business.entity.ANREventInfoBean) r1)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            monitor-exit(r5)
            return
        L_0x01a2:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x01a2 }
            throw r6     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
        L_0x01a5:
            com.bonree.sdk.be.f r7 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = "anr filter: mDumpInfo.hashCode is %d, anrCauseBy is %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            int r4 = r5.m     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r3[r2] = r4     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r4 = r5.i     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r3[r0] = r4     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r7.e(r1, r3)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            com.bonree.sdk.be.f r7 = r5.c     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            java.lang.String r1 = "anr filter: collect of the same anr data! type is %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r0[r2] = r6     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            r7.d(r1, r0)     // Catch:{ Exception -> 0x01cb, all -> 0x01c8 }
            monitor-exit(r5)
            return
        L_0x01c8:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x01cb:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ag.c.a(java.lang.String, java.lang.String):void");
    }

    private static String c(String str) {
        if (ad.a(str)) {
            return null;
        }
        for (String str2 : str.split(HTTP.CRLF)) {
            if (str2.trim().startsWith("at") && str2.contains(com.bonree.sdk.bs.a.a().getPackageName())) {
                return str2;
            }
        }
        return null;
    }

    public final EventBean e() {
        EventBean eventBean;
        synchronized (this) {
            eventBean = this.r;
            if (eventBean != null) {
                b(eventBean);
            }
            this.r = null;
        }
        return eventBean;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[Catch:{ all -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b A[SYNTHETIC, Splitter:B:35:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0058 A[EDGE_INSN: B:45:0x0058->B:25:0x0058 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(java.lang.String r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0082 }
            r1.<init>(r7)     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r7.<init>()     // Catch:{ all -> 0x0082 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0082 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0082 }
            r3.<init>(r1)     // Catch:{ all -> 0x0082 }
            r2.<init>(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "-{5}\\send\\s\\d+\\s-{5}"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x007f }
            r1 = 0
            r3 = r1
        L_0x0020:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x007f }
            if (r4 != 0) goto L_0x002c
            int r5 = r7.length()     // Catch:{ all -> 0x007f }
            if (r5 != 0) goto L_0x0058
        L_0x002c:
            int r3 = r3 + 1
            r5 = 3000(0xbb8, float:4.204E-42)
            if (r3 > r5) goto L_0x0058
            if (r0 == 0) goto L_0x0040
            if (r4 != 0) goto L_0x0037
            goto L_0x0040
        L_0x0037:
            java.util.regex.Matcher r5 = r0.matcher(r4)     // Catch:{ all -> 0x007f }
            boolean r5 = r5.matches()     // Catch:{ all -> 0x007f }
            goto L_0x0041
        L_0x0040:
            r5 = r1
        L_0x0041:
            if (r5 == 0) goto L_0x0049
            int r5 = r7.length()     // Catch:{ all -> 0x007f }
            if (r5 != 0) goto L_0x0058
        L_0x0049:
            boolean r5 = com.bonree.sdk.bs.ad.a((java.lang.String) r4)     // Catch:{ all -> 0x007f }
            if (r5 != 0) goto L_0x0020
            r7.append(r4)     // Catch:{ all -> 0x007f }
            java.lang.String r4 = "\r\n"
            r7.append(r4)     // Catch:{ all -> 0x007f }
            goto L_0x0020
        L_0x0058:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x007f }
            r6.l = r7     // Catch:{ all -> 0x007f }
            com.bonree.sdk.be.f r7 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            java.lang.String r3 = "Anr initAnrTrace: "
            r0.<init>(r3)     // Catch:{ all -> 0x007f }
            java.lang.String r3 = r6.l     // Catch:{ all -> 0x007f }
            int r3 = r3.length()     // Catch:{ all -> 0x007f }
            r0.append(r3)     // Catch:{ all -> 0x007f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007f }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x007f }
            r7.c(r0, r1)     // Catch:{ all -> 0x007f }
            r2.close()     // Catch:{ IOException -> 0x007e }
        L_0x007e:
            return
        L_0x007f:
            r7 = move-exception
            r0 = r2
            goto L_0x0083
        L_0x0082:
            r7 = move-exception
        L_0x0083:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008f }
            r6.l = r7     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x008e
            r0.close()     // Catch:{ IOException -> 0x008e }
        L_0x008e:
            return
        L_0x008f:
            r7 = move-exception
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x0095 }
        L_0x0095:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ag.c.d(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[SYNTHETIC, Splitter:B:38:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(java.lang.String r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "logcat:"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x007c }
            r2.<init>(r11)     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r11.<init>()     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r3.<init>()     // Catch:{ all -> 0x007c }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x007c }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x007c }
            r5.<init>(r2)     // Catch:{ all -> 0x007c }
            r4.<init>(r5)     // Catch:{ all -> 0x007c }
            r1 = 0
            r2 = r1
            r5 = r2
            r6 = r5
        L_0x0023:
            java.lang.String r7 = r4.readLine()     // Catch:{ all -> 0x0079 }
            if (r7 != 0) goto L_0x002f
            int r8 = r11.length()     // Catch:{ all -> 0x0079 }
            if (r8 != 0) goto L_0x005a
        L_0x002f:
            boolean r8 = r0.equals(r7)     // Catch:{ all -> 0x0079 }
            if (r8 == 0) goto L_0x0036
            r2 = 1
        L_0x0036:
            boolean r8 = com.bonree.sdk.bs.ad.a((java.lang.String) r7)     // Catch:{ all -> 0x0079 }
            if (r8 != 0) goto L_0x0023
            java.lang.String r8 = "\r\n"
            r9 = 3000(0xbb8, float:4.204E-42)
            if (r2 == 0) goto L_0x004d
            if (r5 >= r9) goto L_0x004d
            int r5 = r5 + 1
            r3.append(r7)     // Catch:{ all -> 0x0079 }
            r3.append(r8)     // Catch:{ all -> 0x0079 }
            goto L_0x0023
        L_0x004d:
            if (r6 >= r9) goto L_0x0058
            int r6 = r6 + 1
            r11.append(r7)     // Catch:{ all -> 0x0079 }
            r11.append(r8)     // Catch:{ all -> 0x0079 }
            goto L_0x0023
        L_0x0058:
            if (r5 < r9) goto L_0x0023
        L_0x005a:
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0079 }
            r10.l = r11     // Catch:{ all -> 0x0079 }
            java.lang.String r11 = r10.h     // Catch:{ all -> 0x0079 }
            if (r11 != 0) goto L_0x006b
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x0079 }
            r10.h = r11     // Catch:{ all -> 0x0079 }
            goto L_0x0075
        L_0x006b:
            java.lang.StringBuilder r11 = r3.insert(r1, r11)     // Catch:{ all -> 0x0079 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0079 }
            r10.h = r11     // Catch:{ all -> 0x0079 }
        L_0x0075:
            r4.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            return
        L_0x0079:
            r11 = move-exception
            r1 = r4
            goto L_0x007d
        L_0x007c:
            r11 = move-exception
        L_0x007d:
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0089 }
            r10.l = r11     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ IOException -> 0x0088 }
        L_0x0088:
            return
        L_0x0089:
            r11 = move-exception
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008f }
        L_0x008f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ag.c.e(java.lang.String):void");
    }

    private void a(a aVar) {
        if (aVar != null) {
            Throwable cause = aVar.getCause();
            if (cause != null) {
                StringBuilder sb = new StringBuilder();
                while (cause != null) {
                    sb.append(cause.getMessage());
                    sb.append(HTTP.CRLF);
                    for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                        sb.append("at ");
                        sb.append(stackTraceElement.toString());
                        sb.append(HTTP.CRLF);
                    }
                    cause = cause.getCause();
                }
                this.l = com.bonree.sdk.an.a.c(sb.toString());
            }
            String a2 = ad.a(400);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if (this.h == null) {
                this.h = "HiLog:\r\n" + a2;
                return;
            }
            this.h += "\r\nHiLog:\r\n" + a2;
        }
    }

    private String f(String str) {
        try {
            if (ad.a(str)) {
                return "AnrPart";
            }
            String[] split = str.split("\\(");
            if (!str.contains(p)) {
                if (!str.contains(q)) {
                    String[] split2 = split[split.length - 1].split("\\.");
                    if (!ad.a(split2[0])) {
                        return split2[0].replaceAll("\\)", "");
                    }
                    return split2[0];
                }
            }
            if (split.length < 2) {
                return "AnrPart";
            }
            String[] split3 = split[split.length - 2].split("\\.");
            if (split3.length >= 2) {
                return split3[split3.length - 2];
            }
            return "AnrPart";
        } catch (Exception e) {
            this.c.a("Anr initAnrPartByCaused:", (Throwable) e);
            return "AnrPart";
        }
    }

    private static boolean a(Pattern pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    private boolean i() {
        if (ad.a(this.h) && !com.bonree.sdk.d.a.k().z() && Build.VERSION.SDK_INT <= 27) {
            this.c.d("anr message miss: mAnrMessage isMiss !", new Object[0]);
        }
        if (ad.a(this.i)) {
            this.c.d("anr filter: mCausedBy isMiss !", new Object[0]);
            if (com.bonree.sdk.d.a.L()) {
                return true;
            }
        }
        if (!ad.a(this.l)) {
            return false;
        }
        this.c.d("anr filter: mAnrTraceInfo isInvalid !", new Object[0]);
        return true;
    }

    private void a(ANREventInfoBean aNREventInfoBean) {
        this.n.readLock().lock();
        try {
            for (a h2 : this.o) {
                h2.h();
            }
        } finally {
            this.n.readLock().unlock();
        }
    }

    public final void a(a aVar) {
        this.n.writeLock().lock();
        try {
            if (!this.o.contains(aVar)) {
                this.o.add(aVar);
            }
        } finally {
            this.n.writeLock().unlock();
        }
    }

    public final void b(a aVar) {
        this.n.writeLock().lock();
        try {
            if (!this.o.isEmpty()) {
                this.o.remove(aVar);
            }
        } finally {
            this.n.writeLock().unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a A[SYNTHETIC, Splitter:B:34:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0057 A[EDGE_INSN: B:44:0x0057->B:24:0x0057 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.bonree.sdk.ag.c r6, java.lang.String r7) {
        /*
            if (r7 == 0) goto L_0x0095
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0081 }
            r1.<init>(r7)     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r7.<init>()     // Catch:{ all -> 0x0081 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0081 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x0081 }
            r3.<init>(r1)     // Catch:{ all -> 0x0081 }
            r2.<init>(r3)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "-{5}\\send\\s\\d+\\s-{5}"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x007e }
            r1 = 0
            r3 = r1
        L_0x001f:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x007e }
            if (r4 != 0) goto L_0x002b
            int r5 = r7.length()     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0057
        L_0x002b:
            int r3 = r3 + 1
            r5 = 3000(0xbb8, float:4.204E-42)
            if (r3 > r5) goto L_0x0057
            if (r0 == 0) goto L_0x003f
            if (r4 != 0) goto L_0x0036
            goto L_0x003f
        L_0x0036:
            java.util.regex.Matcher r5 = r0.matcher(r4)     // Catch:{ all -> 0x007e }
            boolean r5 = r5.matches()     // Catch:{ all -> 0x007e }
            goto L_0x0040
        L_0x003f:
            r5 = r1
        L_0x0040:
            if (r5 == 0) goto L_0x0048
            int r5 = r7.length()     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0057
        L_0x0048:
            boolean r5 = com.bonree.sdk.bs.ad.a((java.lang.String) r4)     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x001f
            r7.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = "\r\n"
            r7.append(r4)     // Catch:{ all -> 0x007e }
            goto L_0x001f
        L_0x0057:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x007e }
            r6.l = r7     // Catch:{ all -> 0x007e }
            com.bonree.sdk.be.f r7 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "Anr initAnrTrace: "
            r0.<init>(r3)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r6.l     // Catch:{ all -> 0x007e }
            int r3 = r3.length()     // Catch:{ all -> 0x007e }
            r0.append(r3)     // Catch:{ all -> 0x007e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007e }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r7.c(r0, r1)     // Catch:{ all -> 0x007e }
            r2.close()     // Catch:{ IOException -> 0x007d }
        L_0x007d:
            return
        L_0x007e:
            r7 = move-exception
            r0 = r2
            goto L_0x0082
        L_0x0081:
            r7 = move-exception
        L_0x0082:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008e }
            r6.l = r7     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x008d }
        L_0x008d:
            return
        L_0x008e:
            r6 = move-exception
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ IOException -> 0x0094 }
        L_0x0094:
            throw r6
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ag.c.a(com.bonree.sdk.ag.c, java.lang.String):void");
    }
}
