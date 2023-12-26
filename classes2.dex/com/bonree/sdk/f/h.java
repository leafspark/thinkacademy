package com.bonree.sdk.f;

import android.os.Handler;
import android.os.Looper;

public final class h extends Handler {
    public static int a = 0;
    public static int b = 1;
    boolean c = false;
    private d d;

    /* access modifiers changed from: package-private */
    public final boolean a() {
        try {
            return getLooper().getThread().isAlive();
        } catch (Throwable unused) {
            return false;
        }
    }

    h(d dVar, Looper looper) {
        super(looper);
        this.d = dVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c A[LOOP:1: B:38:0x007c->B:74:0x007c, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r14) {
        /*
            r13 = this;
            super.handleMessage(r14)
            r0 = 0
            r1 = 0
            r13.removeCallbacksAndMessages(r0)     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.d r2 = r13.d     // Catch:{ all -> 0x0169 }
            if (r2 != 0) goto L_0x000f
            r13.c = r1
            return
        L_0x000f:
            int r2 = r14.what     // Catch:{ all -> 0x0169 }
            if (r2 != 0) goto L_0x001c
            boolean r2 = com.bonree.sdk.d.e.v()     // Catch:{ all -> 0x0169 }
            if (r2 == 0) goto L_0x001c
            r13.c = r1
            return
        L_0x001c:
            com.bonree.sdk.d.a r2 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x0169 }
            boolean r2 = r2.Y()     // Catch:{ all -> 0x0169 }
            if (r2 == 0) goto L_0x0029
            r13.c = r1
            return
        L_0x0029:
            r2 = 1
            r13.c = r2     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.d r3 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.g r3 = r3.c     // Catch:{ all -> 0x0169 }
            java.io.File r3 = r3.b()     // Catch:{ all -> 0x0169 }
            if (r3 != 0) goto L_0x0039
            r13.c = r1
            return
        L_0x0039:
            java.io.File[] r3 = r3.listFiles()     // Catch:{ all -> 0x0169 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ all -> 0x0169 }
            int r5 = com.bonree.sdk.d.a.e     // Catch:{ all -> 0x0169 }
            long r5 = (long) r5     // Catch:{ all -> 0x0169 }
            long r4 = r4.toMillis(r5)     // Catch:{ all -> 0x0169 }
            if (r3 == 0) goto L_0x007c
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x004f
            goto L_0x007c
        L_0x004f:
            int r6 = r3.length     // Catch:{ all -> 0x007c }
            r7 = r1
        L_0x0051:
            if (r7 >= r6) goto L_0x007c
            r8 = r3[r7]     // Catch:{ all -> 0x007c }
            long r9 = r8.lastModified()     // Catch:{ all -> 0x007c }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007c }
            long r11 = r11 - r9
            int r9 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0079
            boolean r9 = r8.delete()     // Catch:{ all -> 0x007c }
            if (r9 != 0) goto L_0x0079
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x007c }
            java.lang.String r10 = "file del failed %s. "
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ all -> 0x007c }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x007c }
            r11[r1] = r8     // Catch:{ all -> 0x007c }
            r9.e(r10, r11)     // Catch:{ all -> 0x007c }
        L_0x0079:
            int r7 = r7 + 1
            goto L_0x0051
        L_0x007c:
            com.bonree.sdk.f.d r3 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.g r3 = r3.c     // Catch:{ all -> 0x0169 }
            java.io.File r3 = r3.a()     // Catch:{ all -> 0x0169 }
            if (r3 == 0) goto L_0x0151
            int r4 = r14.what     // Catch:{ all -> 0x0169 }
            if (r4 != 0) goto L_0x0093
            boolean r4 = com.bonree.sdk.d.e.v()     // Catch:{ all -> 0x0169 }
            if (r4 == 0) goto L_0x0093
            r13.c = r1
            return
        L_0x0093:
            boolean r4 = r3.isFile()     // Catch:{ all -> 0x0169 }
            r5 = 2
            if (r4 != 0) goto L_0x00b5
            boolean r4 = r3.delete()     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.d r6 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r6 = r6.a     // Catch:{ all -> 0x0169 }
            java.lang.String r7 = "found dir ,del %s, %b"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0169 }
            java.lang.String r9 = r3.getName()     // Catch:{ all -> 0x0169 }
            r8[r1] = r9     // Catch:{ all -> 0x0169 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0169 }
            r8[r2] = r4     // Catch:{ all -> 0x0169 }
            r6.d(r7, r8)     // Catch:{ all -> 0x0169 }
        L_0x00b5:
            int r4 = r14.what     // Catch:{ all -> 0x0169 }
            int r6 = b     // Catch:{ all -> 0x0169 }
            if (r4 != r6) goto L_0x0103
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x0169 }
            java.lang.String r6 = "brjc"
            boolean r4 = r4.endsWith(r6)     // Catch:{ all -> 0x0169 }
            if (r4 != 0) goto L_0x0103
            boolean r4 = r3.delete()     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r6 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0169 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            java.lang.String r8 = "DEL  "
            r7.<init>(r8)     // Catch:{ all -> 0x0169 }
            java.lang.String r8 = r3.getName()     // Catch:{ all -> 0x0169 }
            r7.append(r8)     // Catch:{ all -> 0x0169 }
            java.lang.String r8 = "  "
            r7.append(r8)     // Catch:{ all -> 0x0169 }
            r7.append(r4)     // Catch:{ all -> 0x0169 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0169 }
            r6.a((java.lang.String) r7)     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.d r6 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r6 = r6.a     // Catch:{ all -> 0x0169 }
            java.lang.String r7 = "BR_CRASH not br crash file ,del %s, %b"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0169 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0169 }
            r5[r1] = r3     // Catch:{ all -> 0x0169 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0169 }
            r5[r2] = r3     // Catch:{ all -> 0x0169 }
            r6.c(r7, r5)     // Catch:{ all -> 0x0169 }
            goto L_0x007c
        L_0x0103:
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x0169 }
            java.lang.String r5 = "brnc"
            boolean r4 = r4.endsWith(r5)     // Catch:{ all -> 0x0169 }
            int r5 = r14.what     // Catch:{ all -> 0x0169 }
            boolean r4 = r13.a(r3, r4)     // Catch:{ all -> 0x0169 }
            if (r4 != 0) goto L_0x013e
            com.bonree.sdk.be.f r14 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0169 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            java.lang.String r5 = "UP LF Fail.. "
            r4.<init>(r5)     // Catch:{ all -> 0x0169 }
            java.lang.String r5 = r3.getName()     // Catch:{ all -> 0x0169 }
            r4.append(r5)     // Catch:{ all -> 0x0169 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0169 }
            r14.a((java.lang.String) r4)     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.d r14 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r14 = r14.a     // Catch:{ all -> 0x0169 }
            java.lang.String r4 = "Local file upload failed  %s！"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0169 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0169 }
            r2[r1] = r3     // Catch:{ all -> 0x0169 }
            r14.c(r4, r2)     // Catch:{ all -> 0x0169 }
            goto L_0x0151
        L_0x013e:
            com.bonree.sdk.f.d r4 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r4 = r4.a     // Catch:{ all -> 0x0169 }
            java.lang.String r5 = "Local file upload && del file successful!   %s"
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0169 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0169 }
            r6[r1] = r3     // Catch:{ all -> 0x0169 }
            r4.c(r5, r6)     // Catch:{ all -> 0x0169 }
            goto L_0x007c
        L_0x0151:
            r13.removeCallbacksAndMessages(r0)     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.f.d r14 = r13.d     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r14 = r14.a     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = "Local file upload completed!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0169 }
            r14.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0169 }
            com.bonree.sdk.be.f r14 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = "UP ALL LF END"
            r14.a((java.lang.String) r0)     // Catch:{ all -> 0x0169 }
            r13.c = r1
            return
        L_0x0169:
            r14 = move-exception
            com.bonree.sdk.f.d r0 = r13.d     // Catch:{ all -> 0x0176 }
            com.bonree.sdk.be.f r0 = r0.a     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = "Local file upload error！"
            r0.a((java.lang.String) r2, (java.lang.Throwable) r14)     // Catch:{ all -> 0x0176 }
            r13.c = r1
            return
        L_0x0176:
            r14 = move-exception
            r13.c = r1
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.h.handleMessage(android.os.Message):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x014a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01c1, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(java.io.File r11, boolean r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            if (r11 == 0) goto L_0x01c0
            r1 = 2
            r2 = 1
            boolean r3 = r11.isFile()     // Catch:{ all -> 0x0197 }
            if (r3 != 0) goto L_0x000e
            goto L_0x01c0
        L_0x000e:
            if (r11 != 0) goto L_0x0012
            r3 = 0
            goto L_0x0024
        L_0x0012:
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0197 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0197 }
            r4.<init>(r11)     // Catch:{ all -> 0x0197 }
            r3.<init>(r4)     // Catch:{ all -> 0x0197 }
            java.lang.Object r4 = r3.readObject()     // Catch:{ all -> 0x0197 }
            r3.close()     // Catch:{ all -> 0x0197 }
            r3 = r4
        L_0x0024:
            com.bonree.sdk.f.c r3 = (com.bonree.sdk.f.c) r3     // Catch:{ all -> 0x0197 }
            if (r12 == 0) goto L_0x00b5
            byte[] r4 = r3.c()     // Catch:{ all -> 0x0197 }
            byte[] r4 = com.bonree.sdk.bc.t.b((byte[]) r4)     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0197 }
            r5.<init>(r4)     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.common.gson.Gson r4 = new com.bonree.sdk.common.gson.Gson     // Catch:{ all -> 0x0197 }
            r4.<init>()     // Catch:{ all -> 0x0197 }
            java.lang.Class<com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean> r6 = com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean.class
            java.lang.Object r6 = r4.fromJson((java.lang.String) r5, r6)     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean r6 = (com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r6     // Catch:{ all -> 0x0197 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0197 }
            r7.<init>(r5)     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = "e"
            java.lang.Object r5 = r7.get(r5)     // Catch:{ all -> 0x0197 }
            org.json.JSONArray r5 = (org.json.JSONArray) r5     // Catch:{ all -> 0x0197 }
            r7 = r0
        L_0x0050:
            int r8 = r5.length()     // Catch:{ all -> 0x0197 }
            if (r7 >= r8) goto L_0x00a6
            java.lang.Object r8 = r5.get(r7)     // Catch:{ all -> 0x0197 }
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ all -> 0x0197 }
            java.lang.String r9 = "v"
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x0197 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0197 }
            java.lang.Class<com.bonree.sdk.agent.business.entity.CrashEventInfoBean> r9 = com.bonree.sdk.agent.business.entity.CrashEventInfoBean.class
            java.lang.Object r8 = r4.fromJson((java.lang.String) r8, r9)     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.agent.business.entity.CrashEventInfoBean r8 = (com.bonree.sdk.agent.business.entity.CrashEventInfoBean) r8     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.f.d r9 = r10.d     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.d.e r9 = r9.b     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.af.a r9 = r9.f()     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.agent.business.entity.CrashEventInfoBean r9 = r9.a((com.bonree.sdk.agent.business.entity.CrashEventInfoBean) r8)     // Catch:{ all -> 0x0197 }
            if (r9 != 0) goto L_0x0099
            boolean r3 = r11.delete()     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.f.d r4 = r10.d     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.be.f r4 = r4.a     // Catch:{ all -> 0x0197 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
            java.lang.String r6 = "CrashEvent update error ,valid file ! "
            r5.<init>(r6)     // Catch:{ all -> 0x0197 }
            r5.append(r3)     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0197 }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ all -> 0x0197 }
            r4.e(r5, r6)     // Catch:{ all -> 0x0197 }
            monitor-exit(r10)
            return r3
        L_0x0099:
            java.util.List<com.bonree.sdk.agent.business.entity.EventBean> r9 = r6.mEvents     // Catch:{ all -> 0x0197 }
            java.lang.Object r9 = r9.get(r7)     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.agent.business.entity.EventBean r9 = (com.bonree.sdk.agent.business.entity.EventBean) r9     // Catch:{ all -> 0x0197 }
            r9.mEventInfo = r8     // Catch:{ all -> 0x0197 }
            int r7 = r7 + 1
            goto L_0x0050
        L_0x00a6:
            com.bonree.sdk.f.d r4 = r10.d     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.c.a r4 = r4.d     // Catch:{ all -> 0x0197 }
            com.bonree.sdk.agent.business.util.i r4 = r4.e()     // Catch:{ all -> 0x0197 }
            byte[] r4 = r4.a((com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean) r6)     // Catch:{ all -> 0x0197 }
            r3.a((byte[]) r4)     // Catch:{ all -> 0x0197 }
        L_0x00b5:
            if (r3 == 0) goto L_0x014b
            boolean r4 = r3.d()     // Catch:{ all -> 0x0181 }
            if (r4 != 0) goto L_0x00bf
            goto L_0x014b
        L_0x00bf:
            com.bonree.sdk.be.f r4 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = "UP LF.. "
            r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.d r4 = r10.d     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.be.f r4 = r4.a     // Catch:{ all -> 0x0181 }
            java.lang.String r5 = "UPLOAD TYPE STORAGE: %s"
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0181 }
            java.lang.String r7 = r11.getName()     // Catch:{ all -> 0x0181 }
            r6[r0] = r7     // Catch:{ all -> 0x0181 }
            r4.c(r5, r6)     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.d r4 = r10.d     // Catch:{ all -> 0x0181 }
            byte[] r5 = r3.c()     // Catch:{ all -> 0x0181 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0181 }
            r6.<init>()     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.d.a r7 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x0181 }
            java.lang.String r7 = r7.O()     // Catch:{ all -> 0x0181 }
            r6.append(r7)     // Catch:{ all -> 0x0181 }
            java.lang.String r7 = r3.a()     // Catch:{ all -> 0x0181 }
            r6.append(r7)     // Catch:{ all -> 0x0181 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = r3.b()     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean r3 = r4.a(r5, r6, r3, r2)     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.d r4 = r10.d     // Catch:{ all -> 0x0181 }
            boolean r3 = r4.a((com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean) r3)     // Catch:{ all -> 0x0181 }
            if (r3 == 0) goto L_0x0116
            com.bonree.sdk.f.d r12 = r10.d     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.g r12 = r12.c     // Catch:{ all -> 0x0181 }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0181 }
            boolean r11 = r12.a((java.lang.String) r11)     // Catch:{ all -> 0x0181 }
            monitor-exit(r10)
            return r11
        L_0x0116:
            if (r12 == 0) goto L_0x0149
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0181 }
            r12.<init>()     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = r11.getAbsolutePath()     // Catch:{ all -> 0x0181 }
            r12.append(r3)     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = "pok"
            r12.append(r3)     // Catch:{ all -> 0x0181 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0181 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0181 }
            r3.<init>(r12)     // Catch:{ all -> 0x0181 }
            boolean r11 = r11.renameTo(r3)     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.d r3 = r10.d     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.be.f r3 = r3.a     // Catch:{ all -> 0x0181 }
            java.lang.String r4 = "renameTo: %s , result: %b"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0181 }
            r1[r0] = r12     // Catch:{ all -> 0x0181 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x0181 }
            r1[r2] = r11     // Catch:{ all -> 0x0181 }
            r3.c(r4, r1)     // Catch:{ all -> 0x0181 }
        L_0x0149:
            monitor-exit(r10)
            return r0
        L_0x014b:
            com.bonree.sdk.f.d r12 = r10.d     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.be.f r12 = r12.a     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = "The local upload file is invalid !!!  %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0181 }
            java.lang.String r3 = r11.getAbsolutePath()     // Catch:{ all -> 0x0181 }
            r2[r0] = r3     // Catch:{ all -> 0x0181 }
            r12.e(r1, r2)     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.be.f r12 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0181 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0181 }
            java.lang.String r2 = "UP LF INVALID.. "
            r1.<init>(r2)     // Catch:{ all -> 0x0181 }
            java.lang.String r2 = r11.getName()     // Catch:{ all -> 0x0181 }
            r1.append(r2)     // Catch:{ all -> 0x0181 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0181 }
            r12.a((java.lang.String) r1)     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.d r12 = r10.d     // Catch:{ all -> 0x0181 }
            com.bonree.sdk.f.g r12 = r12.c     // Catch:{ all -> 0x0181 }
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0181 }
            boolean r11 = r12.a((java.lang.String) r11)     // Catch:{ all -> 0x0181 }
            monitor-exit(r10)
            return r11
        L_0x0181:
            r11 = move-exception
            com.bonree.sdk.be.f r12 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0194 }
            java.lang.String r1 = "Upload local file error: "
            r12.a((java.lang.String) r1, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0194 }
            com.bonree.sdk.f.d r12 = r10.d     // Catch:{ all -> 0x0194 }
            com.bonree.sdk.be.f r12 = r12.a     // Catch:{ all -> 0x0194 }
            java.lang.String r1 = " Upload storage error: %s "
            r12.a((java.lang.String) r1, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0194 }
            monitor-exit(r10)
            return r0
        L_0x0194:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        L_0x0197:
            r3 = move-exception
            boolean r11 = r11.delete()     // Catch:{ all -> 0x01be }
            com.bonree.sdk.f.d r4 = r10.d     // Catch:{ all -> 0x01be }
            com.bonree.sdk.be.f r4 = r4.a     // Catch:{ all -> 0x01be }
            java.lang.String r5 = "Local file is  valid ,delete %b ! native crash ?: %b"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x01be }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x01be }
            r1[r0] = r6     // Catch:{ all -> 0x01be }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x01be }
            r1[r2] = r12     // Catch:{ all -> 0x01be }
            r4.d(r5, r1)     // Catch:{ all -> 0x01be }
            com.bonree.sdk.f.d r12 = r10.d     // Catch:{ all -> 0x01be }
            com.bonree.sdk.be.f r12 = r12.a     // Catch:{ all -> 0x01be }
            java.lang.String r1 = "Local file is  valid error: "
            r12.a((java.lang.String) r1, (java.lang.Throwable) r3)     // Catch:{ all -> 0x01be }
            monitor-exit(r10)
            return r11
        L_0x01be:
            monitor-exit(r10)
            return r0
        L_0x01c0:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.h.a(java.io.File, boolean):boolean");
    }
}
