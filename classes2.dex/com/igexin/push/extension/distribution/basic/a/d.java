package com.igexin.push.extension.distribution.basic.a;

import java.net.ServerSocket;

public class d {
    private static final String a = ("EXT-" + d.class.getName());
    private static d d;
    private Long b;
    private ServerSocket c;

    private d() {
    }

    public static d a() {
        if (d == null) {
            d = new d();
        }
        return d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.igexin.b.a.c.b.a(a + "|port 51688 has occupy by others", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x017e
            boolean r1 = com.igexin.push.core.d.l     // Catch:{ all -> 0x017c }
            if (r1 == 0) goto L_0x017e
            boolean r1 = com.igexin.push.core.d.k     // Catch:{ all -> 0x017c }
            if (r1 == 0) goto L_0x017e
            java.net.ServerSocket r1 = r8.c     // Catch:{ Exception -> 0x001a }
            if (r1 != 0) goto L_0x0032
            java.net.ServerSocket r1 = new java.net.ServerSocket     // Catch:{ Exception -> 0x001a }
            r2 = 51688(0xc9e8, float:7.243E-41)
            r1.<init>(r2)     // Catch:{ Exception -> 0x001a }
            r8.c = r1     // Catch:{ Exception -> 0x001a }
            goto L_0x0032
        L_0x001a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r1.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r2 = a     // Catch:{ all -> 0x017c }
            r1.append(r2)     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "|port 51688 has occupy by others"
            r1.append(r2)     // Catch:{ all -> 0x017c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x017c }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x017c }
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x017c }
        L_0x0032:
            java.net.ServerSocket r1 = r8.c     // Catch:{ all -> 0x017c }
            if (r1 == 0) goto L_0x017e
            long r1 = com.igexin.push.extension.distribution.basic.c.e.h     // Catch:{ all -> 0x017c }
            r3 = 180000(0x2bf20, double:8.8932E-319)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0041
            com.igexin.push.extension.distribution.basic.c.e.h = r3     // Catch:{ all -> 0x017c }
        L_0x0041:
            long r1 = com.igexin.push.extension.distribution.basic.c.e.g     // Catch:{ all -> 0x017c }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0049
            com.igexin.push.extension.distribution.basic.c.e.g = r3     // Catch:{ all -> 0x017c }
        L_0x0049:
            java.lang.Long r1 = r8.b     // Catch:{ all -> 0x017c }
            if (r1 != 0) goto L_0x007d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017c }
            long r3 = com.igexin.push.extension.distribution.basic.c.e.i     // Catch:{ all -> 0x017c }
            long r1 = r1 - r3
            long r3 = com.igexin.push.extension.distribution.basic.c.e.h     // Catch:{ all -> 0x017c }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0073
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r9.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r1 = a     // Catch:{ all -> 0x017c }
            r9.append(r1)     // Catch:{ all -> 0x017c }
            java.lang.String r1 = "|lastReportInterval < reportCidRestartThreshold not report"
            r9.append(r1)     // Catch:{ all -> 0x017c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x017c }
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x017c }
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r1)     // Catch:{ all -> 0x017c }
            return
        L_0x0073:
            long r3 = com.igexin.push.extension.distribution.basic.c.e.g     // Catch:{ all -> 0x017c }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x007b
            r1 = 2
            goto L_0x008f
        L_0x007b:
            r1 = r0
            goto L_0x008f
        L_0x007d:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017c }
            java.lang.Long r3 = r8.b     // Catch:{ all -> 0x017c }
            long r3 = r3.longValue()     // Catch:{ all -> 0x017c }
            long r1 = r1 - r3
            long r3 = com.igexin.push.extension.distribution.basic.c.e.g     // Catch:{ all -> 0x017c }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0163
            r1 = 1
        L_0x008f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r2.<init>()     // Catch:{ all -> 0x017c }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x017c }
            r2.append(r3)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = "/libs"
            r2.append(r3)     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x017c }
            java.util.List r2 = com.igexin.push.extension.distribution.basic.g.e.a((java.lang.String) r2)     // Catch:{ all -> 0x017c }
            if (r2 != 0) goto L_0x00b0
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x017c }
            r2.<init>()     // Catch:{ all -> 0x017c }
            goto L_0x00bc
        L_0x00b0:
            int r3 = r2.size()     // Catch:{ all -> 0x017c }
            if (r3 <= 0) goto L_0x0162
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ all -> 0x017c }
            r3.<init>(r2)     // Catch:{ all -> 0x017c }
            r2 = r3
        L_0x00bc:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r4 = "appinfo"
            r3.put(r4, r2)     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "deviceid"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "ANDROID-"
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = com.igexin.push.core.d.A     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            r3.put(r2, r4)     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "type"
            r3.put(r2, r1)     // Catch:{ all -> 0x017c }
            java.lang.String r1 = "pkg"
            android.content.Context r2 = com.igexin.push.core.d.g     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x017c }
            r3.put(r1, r2)     // Catch:{ all -> 0x017c }
            boolean r1 = r3 instanceof org.json.JSONObject     // Catch:{ all -> 0x017c }
            if (r1 != 0) goto L_0x00f6
            r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x00fc
        L_0x00f6:
            r1 = r3
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x017c }
            com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r1)     // Catch:{ all -> 0x017c }
        L_0x00fc:
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x017c }
            r1.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "action"
            java.lang.String r4 = "sendMessage"
            r1.putString(r2, r4)     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "taskid"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "6T5@S_"
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r5.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r6 = com.igexin.push.core.d.u     // Catch:{ all -> 0x017c }
            r5.append(r6)     // Catch:{ all -> 0x017c }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017c }
            r5.append(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = com.igexin.b.b.a.a((java.lang.String) r5)     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            r1.putString(r2, r4)     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "extraData"
            boolean r4 = r3 instanceof org.json.JSONObject     // Catch:{ all -> 0x017c }
            if (r4 != 0) goto L_0x0142
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0148
        L_0x0142:
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x017c }
            java.lang.String r3 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r3)     // Catch:{ all -> 0x017c }
        L_0x0148:
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x017c }
            r1.putByteArray(r2, r3)     // Catch:{ all -> 0x017c }
            com.igexin.push.core.a.e r2 = com.igexin.push.core.a.e.a()     // Catch:{ all -> 0x017c }
            r2.a((android.os.Bundle) r1)     // Catch:{ all -> 0x017c }
            com.igexin.push.extension.distribution.basic.d.b r1 = com.igexin.push.extension.distribution.basic.d.b.a()     // Catch:{ all -> 0x017c }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017c }
            r1.a(r2)     // Catch:{ all -> 0x017c }
            goto L_0x017e
        L_0x0162:
            return
        L_0x0163:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r9.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r1 = a     // Catch:{ all -> 0x017c }
            r9.append(r1)     // Catch:{ all -> 0x017c }
            java.lang.String r1 = "|offline time < reportCidOfflineThreshold not report"
            r9.append(r1)     // Catch:{ all -> 0x017c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x017c }
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x017c }
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r1)     // Catch:{ all -> 0x017c }
            return
        L_0x017c:
            r9 = move-exception
            goto L_0x018b
        L_0x017e:
            if (r9 != 0) goto L_0x01aa
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017c }
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x017c }
            r8.b = r9     // Catch:{ all -> 0x017c }
            goto L_0x01aa
        L_0x018b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = a
            r1.append(r2)
            java.lang.String r2 = "|do report exception:"
            r1.append(r2)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.igexin.b.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r0)
        L_0x01aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.d.a(boolean):void");
    }
}
