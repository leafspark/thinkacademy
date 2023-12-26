package com.igexin.push.core.c;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.didi.hummer.adapter.tracker.ITrackerAdapter;
import com.igexin.b.a.b.c;
import com.igexin.push.config.l;
import com.igexin.push.core.d;
import org.json.JSONObject;

public class b extends com.igexin.push.f.a.b {
    public static final String a = "com.igexin.push.core.c.b";

    public b(String str) {
        super(str);
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x021d A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x023d A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0257 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0271 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0291 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b1 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02d1 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02f1 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0311 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0331 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0355 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0375 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0184 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0192 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a0 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c7 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d9 A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01eb A[Catch:{ all -> 0x0385 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(byte[] r23) {
        /*
            r22 = this;
            java.lang.String r0 = "sdk.hide.righticon.blacklist"
            java.lang.String r1 = "sdk.httpdata.maxsize"
            java.lang.String r2 = "sdk.polling.exit.heartbeat.cnt"
            java.lang.String r3 = "sdk.polling.login.interval"
            java.lang.String r4 = "sdk.polling.dis.cnt"
            java.lang.String r5 = "sdk.watchout.service"
            java.lang.String r6 = "sdk.watchout.app"
            java.lang.String r7 = "sdk.report.initialize.enable"
            java.lang.String r8 = "sdk.needlook.enable"
            java.lang.String r9 = "sdk.feature.setsilenttime.enable"
            java.lang.String r10 = "sdk.domainbackup.enable"
            java.lang.String r11 = "sdk.feature.sendmessage.enable"
            java.lang.String r12 = "sdk.startservice.limit"
            java.lang.String r13 = "sdk.ups.push.disable.brand"
            java.lang.String r14 = "sdk.sdcard.enabled"
            java.lang.String r15 = "tag"
            r16 = r0
            java.lang.String r0 = "config"
            r17 = r1
            java.lang.String r1 = "result"
            r18 = r2
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x038a }
            r19 = r3
            r3 = r23
            r2.<init>(r3)     // Catch:{ all -> 0x038a }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x038a }
            r3.<init>(r2)     // Catch:{ all -> 0x038a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x038a }
            r2.<init>()     // Catch:{ all -> 0x038a }
            r20 = r4
            java.lang.String r4 = a     // Catch:{ all -> 0x038a }
            r2.append(r4)     // Catch:{ all -> 0x038a }
            java.lang.String r4 = "|parse sdk config from server resp = "
            r2.append(r4)     // Catch:{ all -> 0x038a }
            r2.append(r3)     // Catch:{ all -> 0x038a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x038a }
            r21 = r5
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x038a }
            com.igexin.b.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r5)     // Catch:{ all -> 0x038a }
            com.igexin.push.core.b.i r2 = com.igexin.push.core.b.i.a()     // Catch:{ all -> 0x038a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x038a }
            r2.c((long) r4)     // Catch:{ all -> 0x038a }
            boolean r2 = r3.has(r1)     // Catch:{ all -> 0x038a }
            if (r2 == 0) goto L_0x0387
            java.lang.String r2 = "ok"
            java.lang.String r1 = r3.getString(r1)     // Catch:{ all -> 0x038a }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x038a }
            if (r1 == 0) goto L_0x0387
            boolean r1 = r3.has(r0)     // Catch:{ all -> 0x038a }
            if (r1 != 0) goto L_0x007d
            goto L_0x0387
        L_0x007d:
            boolean r1 = r3.has(r15)     // Catch:{ all -> 0x038a }
            if (r1 == 0) goto L_0x0089
            java.lang.String r1 = r3.getString(r15)     // Catch:{ all -> 0x038a }
            com.igexin.push.config.l.s = r1     // Catch:{ all -> 0x038a }
        L_0x0089:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x038a }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x038a }
            r1.<init>(r0)     // Catch:{ all -> 0x038a }
            boolean r0 = r1.has(r14)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x00b4
            r0 = 1
            boolean r0 = r1.optBoolean(r14, r0)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x00aa
            com.igexin.sdk.a.b r0 = new com.igexin.sdk.a.b     // Catch:{ all -> 0x038a }
            android.content.Context r2 = com.igexin.push.core.d.g     // Catch:{ all -> 0x038a }
            r0.<init>(r2)     // Catch:{ all -> 0x038a }
            r0.b()     // Catch:{ all -> 0x038a }
            goto L_0x00b4
        L_0x00aa:
            com.igexin.sdk.a.b r0 = new com.igexin.sdk.a.b     // Catch:{ all -> 0x038a }
            android.content.Context r2 = com.igexin.push.core.d.g     // Catch:{ all -> 0x038a }
            r0.<init>(r2)     // Catch:{ all -> 0x038a }
            r0.a()     // Catch:{ all -> 0x038a }
        L_0x00b4:
            boolean r0 = r1.has(r13)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x00c0
            java.lang.String r0 = r1.getString(r13)     // Catch:{ all -> 0x038a }
            com.igexin.push.config.l.L = r0     // Catch:{ all -> 0x038a }
        L_0x00c0:
            java.lang.String r0 = com.igexin.push.config.l.L     // Catch:{ all -> 0x038a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x00cc
            java.lang.String r0 = "null"
            com.igexin.push.config.l.L = r0     // Catch:{ all -> 0x038a }
        L_0x00cc:
            boolean r0 = r1.has(r12)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r1.getString(r12)     // Catch:{ all -> 0x038a }
            com.igexin.push.config.l.K = r0     // Catch:{ all -> 0x038a }
        L_0x00d8:
            boolean r0 = r1.has(r11)     // Catch:{ all -> 0x038a }
            java.lang.String r2 = "false"
            java.lang.String r3 = "true"
            if (r0 == 0) goto L_0x00f8
            java.lang.String r0 = r1.getString(r11)     // Catch:{ all -> 0x038a }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038a }
            if (r4 != 0) goto L_0x00f2
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x00f8
        L_0x00f2:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x038a }
            com.igexin.push.config.l.g = r0     // Catch:{ all -> 0x038a }
        L_0x00f8:
            boolean r0 = r1.has(r10)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x0114
            java.lang.String r0 = r1.getString(r10)     // Catch:{ all -> 0x038a }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038a }
            if (r4 != 0) goto L_0x010e
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x0114
        L_0x010e:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x038a }
            com.igexin.push.config.l.f = r0     // Catch:{ all -> 0x038a }
        L_0x0114:
            boolean r0 = r1.has(r9)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x013a
            java.lang.String r0 = r1.getString(r9)     // Catch:{ all -> 0x038a }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038a }
            if (r4 != 0) goto L_0x012a
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x013a
        L_0x012a:
            int r0 = com.igexin.push.config.l.b     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x013a
            com.igexin.push.core.v r0 = com.igexin.push.core.v.a()     // Catch:{ all -> 0x038a }
            r4 = 12
            java.lang.String r5 = "server"
            r9 = 0
            r0.a((int) r4, (int) r9, (java.lang.String) r5)     // Catch:{ all -> 0x038a }
        L_0x013a:
            boolean r0 = r1.has(r8)     // Catch:{ all -> 0x038a }
            if (r0 == 0) goto L_0x0160
            java.lang.String r0 = r1.getString(r8)     // Catch:{ all -> 0x038a }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038a }
            if (r4 != 0) goto L_0x0150
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x038a }
            if (r4 == 0) goto L_0x0160
        L_0x0150:
            boolean r4 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x038a }
            com.igexin.push.config.l.k = r4     // Catch:{ all -> 0x038a }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x038a }
            r4 = r22
            r4.d(r0)     // Catch:{ all -> 0x0385 }
            goto L_0x0162
        L_0x0160:
            r4 = r22
        L_0x0162:
            boolean r0 = r1.has(r7)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x017e
            java.lang.String r0 = r1.getString(r7)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x0178
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x017e
        L_0x0178:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.m = r0     // Catch:{ all -> 0x0385 }
        L_0x017e:
            boolean r0 = r1.has(r6)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x018a
            java.lang.String r0 = r1.getString(r6)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.i = r0     // Catch:{ all -> 0x0385 }
        L_0x018a:
            r0 = r21
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x0198
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.j = r0     // Catch:{ all -> 0x0385 }
        L_0x0198:
            r0 = r20
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x01aa
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.t = r0     // Catch:{ all -> 0x0385 }
        L_0x01aa:
            r0 = r19
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x01bf
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0385 }
            int r0 = r0 * 1000
            long r5 = (long) r0     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.u = r5     // Catch:{ all -> 0x0385 }
        L_0x01bf:
            r0 = r18
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x01d1
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.v = r0     // Catch:{ all -> 0x0385 }
        L_0x01d1:
            r0 = r17
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x01e3
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.w = r0     // Catch:{ all -> 0x0385 }
        L_0x01e3:
            r0 = r16
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x01f1
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.x = r0     // Catch:{ all -> 0x0385 }
        L_0x01f1:
            java.lang.String r0 = "sdk.taskid.blacklist"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            java.lang.String r5 = "none"
            if (r0 == 0) goto L_0x0215
            java.lang.String r0 = "sdk.taskid.blacklist"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.y = r0     // Catch:{ all -> 0x0385 }
            java.lang.String r0 = com.igexin.push.config.l.y     // Catch:{ all -> 0x0385 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0385 }
            if (r0 != 0) goto L_0x0213
            com.igexin.push.core.w r0 = com.igexin.push.core.w.a()     // Catch:{ all -> 0x0385 }
            r0.e()     // Catch:{ all -> 0x0385 }
            goto L_0x0215
        L_0x0213:
            com.igexin.push.config.l.y = r5     // Catch:{ all -> 0x0385 }
        L_0x0215:
            java.lang.String r0 = "sdk.applink.feedback.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x0235
            java.lang.String r0 = "sdk.applink.feedback.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r6 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r6 != 0) goto L_0x022f
            boolean r6 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r6 == 0) goto L_0x0235
        L_0x022f:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.z = r0     // Catch:{ all -> 0x0385 }
        L_0x0235:
            java.lang.String r0 = "sdk.applink.domains"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x024f
            java.lang.String r0 = "sdk.applink.domains"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.A = r0     // Catch:{ all -> 0x0385 }
            java.lang.String r0 = com.igexin.push.config.l.A     // Catch:{ all -> 0x0385 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x024f
            com.igexin.push.config.l.A = r5     // Catch:{ all -> 0x0385 }
        L_0x024f:
            java.lang.String r0 = "sdk.del.alarm.brand"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x0269
            java.lang.String r0 = "sdk.del.alarm.brand"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.B = r0     // Catch:{ all -> 0x0385 }
            java.lang.String r0 = com.igexin.push.config.l.B     // Catch:{ all -> 0x0385 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x0269
            com.igexin.push.config.l.B = r5     // Catch:{ all -> 0x0385 }
        L_0x0269:
            java.lang.String r0 = "sdk.miuipush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x0289
            java.lang.String r0 = "sdk.miuipush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x0283
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x0289
        L_0x0283:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.C = r0     // Catch:{ all -> 0x0385 }
        L_0x0289:
            java.lang.String r0 = "sdk.flymepush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x02a9
            java.lang.String r0 = "sdk.flymepush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x02a3
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x02a9
        L_0x02a3:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.D = r0     // Catch:{ all -> 0x0385 }
        L_0x02a9:
            java.lang.String r0 = "sdk.hmspush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x02c9
            java.lang.String r0 = "sdk.hmspush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x02c3
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x02c9
        L_0x02c3:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.E = r0     // Catch:{ all -> 0x0385 }
        L_0x02c9:
            java.lang.String r0 = "sdk.colorospush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x02e9
            java.lang.String r0 = "sdk.colorospush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x02e3
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x02e9
        L_0x02e3:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.F = r0     // Catch:{ all -> 0x0385 }
        L_0x02e9:
            java.lang.String r0 = "sdk.vivopush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x0309
            java.lang.String r0 = "sdk.vivopush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x0303
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x0309
        L_0x0303:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.G = r0     // Catch:{ all -> 0x0385 }
        L_0x0309:
            java.lang.String r0 = "sdk.stpush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x0329
            java.lang.String r0 = "sdk.stpush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x0323
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x0329
        L_0x0323:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.I = r0     // Catch:{ all -> 0x0385 }
        L_0x0329:
            java.lang.String r0 = "sdk.fcmpush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x034d
            java.lang.String r0 = "sdk.fcmpush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r5 != 0) goto L_0x0343
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r5 == 0) goto L_0x034d
        L_0x0343:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0385 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.H = r0     // Catch:{ all -> 0x0385 }
        L_0x034d:
            java.lang.String r0 = "sdk.oaid.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x036d
            java.lang.String r0 = "sdk.oaid.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0385 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0385 }
            if (r3 != 0) goto L_0x0367
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x0385 }
            if (r2 == 0) goto L_0x036d
        L_0x0367:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.J = r0     // Catch:{ all -> 0x0385 }
        L_0x036d:
            java.lang.String r0 = "sdk.upload.gzip.limit"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0385 }
            if (r0 == 0) goto L_0x037d
            java.lang.String r0 = "sdk.upload.gzip.limit"
            long r0 = r1.getLong(r0)     // Catch:{ all -> 0x0385 }
            com.igexin.push.config.l.M = r0     // Catch:{ all -> 0x0385 }
        L_0x037d:
            com.igexin.push.config.a r0 = com.igexin.push.config.a.a()     // Catch:{ all -> 0x0385 }
            r0.f()     // Catch:{ all -> 0x0385 }
            goto L_0x03ad
        L_0x0385:
            r0 = move-exception
            goto L_0x038d
        L_0x0387:
            r4 = r22
            return
        L_0x038a:
            r0 = move-exception
            r4 = r22
        L_0x038d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = a
            r1.append(r2)
            java.lang.String r2 = "|"
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
        L_0x03ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.b.c(byte[]):void");
    }

    private void d(byte[] bArr) {
        try {
            c.b().a(new c(this, bArr), false, true);
        } catch (Exception unused) {
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            c(bArr);
        }
    }

    public void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "sdkconfig");
            jSONObject.put("cid", d.u);
            jSONObject.put("appid", d.a);
            jSONObject.put(ITrackerAdapter.ParamKey.SDK_VERSION, "4.4.3.1");
            jSONObject.put("tag", l.s);
            b((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes());
        } catch (Exception unused) {
        }
    }

    public int b_() {
        return 0;
    }
}
