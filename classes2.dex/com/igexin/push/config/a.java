package com.igexin.push.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.igexin.b.a.b.c;
import com.igexin.push.core.b.b;

public class a implements b {
    public static final String a = "com.igexin.push.config.a";
    private static a b;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {String.valueOf(i)};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.delete("config", "id = ?", strArr);
        } else {
            SQLiteInstrumentation.delete(sQLiteDatabase, "config", "id = ?", strArr);
        }
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", str);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.replace("config", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.replace(sQLiteDatabase, "config", (String) null, contentValues);
        }
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", bArr);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.replace("config", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.replace(sQLiteDatabase, "config", (String) null, contentValues);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void a(String str) {
        c.b().a(new g(this, str), true, false);
    }

    public void b() {
        c.b().a(new b(this), false, true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|(3:31|(1:33)|34)(2:29|30)|(3:37|(2:39|(2:41|(2:43|(2:45|(2:47|(1:(2:50|(2:52|(2:54|(1:(1:(1:(2:59|(1:61)(3:117|118|(2:120|221)(1:220)))(2:121|222))(2:122|223))(2:123|224))(2:124|(2:126|226)(1:225)))(2:127|(2:129|228)(1:227)))(2:130|(2:132|230)(1:229)))(2:133|231))(2:134|(2:136|233)(1:232)))(2:137|(2:139|235)(1:234)))(2:140|(2:142|237)(1:236)))(2:143|(2:145|239)(1:238)))(2:146|(2:148|241)(1:240)))(2:149|(2:151|243)(1:242))|182)(2:184|182)|8|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0265, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0266, code lost:
        com.igexin.b.a.c.b.a(a + "|" + r2.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0287, code lost:
        if (r12 != null) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x028b, code lost:
        if (r12 != null) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x028d, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0290, code lost:
        r12 = new java.lang.StringBuilder();
        r2 = a;
        r12.append(r2);
        r12.append("|current ver = ");
        r12.append("4.4.3.1");
        r12.append(", last ver = ");
        r12.append(com.igexin.push.core.d.N);
        com.igexin.b.a.c.b.a(r12.toString(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02bd, code lost:
        if ("4.4.3.1".equals(com.igexin.push.core.d.N) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02c1, code lost:
        if (com.igexin.push.config.l.h == null) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02cd, code lost:
        if (com.igexin.push.config.l.h.a().isEmpty() != false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02cf, code lost:
        com.igexin.b.a.c.b.a(r2 + "|extMap is empty  = false", new java.lang.Object[0]);
        r12 = com.igexin.push.config.l.h.a().keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02f7, code lost:
        if (r12.hasNext() == false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02f9, code lost:
        r1 = com.igexin.push.config.l.h.a().get(r12.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0309, code lost:
        if (r1 == null) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x030b, code lost:
        com.igexin.push.util.c.b(r1.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0313, code lost:
        com.igexin.push.config.l.h = null;
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        r12 = new java.io.File(com.igexin.push.core.d.X).listFiles();
        r0 = r12.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0325, code lost:
        if (r1 >= r0) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0327, code lost:
        r2 = r12[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0333, code lost:
        if (r2.getName().startsWith("tdata_") == false) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0335, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0338, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029 A[LOOP:0: B:7:0x0029->B:182:0x0029, LOOP_START, SYNTHETIC, Splitter:B:7:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.database.sqlite.SQLiteDatabase r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            java.lang.String r3 = "config"
            java.lang.String r2 = "id"
            java.lang.String r4 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r2, r4}     // Catch:{ all -> 0x028a }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "id"
            boolean r2 = r12 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ all -> 0x028a }
            if (r2 != 0) goto L_0x0020
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r12
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x028a }
            goto L_0x0027
        L_0x0020:
            r2 = r12
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ all -> 0x028a }
            android.database.Cursor r12 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x028a }
        L_0x0027:
            if (r12 == 0) goto L_0x0287
        L_0x0029:
            boolean r2 = r12.moveToNext()     // Catch:{ all -> 0x028b }
            if (r2 == 0) goto L_0x0287
            int r2 = r12.getInt(r1)     // Catch:{ all -> 0x028b }
            r3 = 20
            r4 = 58
            r5 = 64
            r6 = 22
            r7 = 21
            r8 = 1
            if (r2 == r3) goto L_0x0068
            if (r2 == r7) goto L_0x0068
            if (r2 == r6) goto L_0x0068
            r3 = 24
            if (r2 == r3) goto L_0x0068
            r3 = 26
            if (r2 == r3) goto L_0x0068
            r3 = 45
            if (r2 == r3) goto L_0x0068
            r3 = 51
            if (r2 == r3) goto L_0x0068
            r3 = 56
            if (r2 == r3) goto L_0x0068
            if (r2 == r4) goto L_0x0068
            r3 = 62
            if (r2 == r3) goto L_0x0068
            if (r2 != r5) goto L_0x0061
            goto L_0x0068
        L_0x0061:
            java.lang.String r3 = r12.getString(r8)     // Catch:{ all -> 0x0265 }
            r9 = r3
            r3 = r0
            goto L_0x0075
        L_0x0068:
            byte[] r3 = r12.getBlob(r8)     // Catch:{ all -> 0x0265 }
            if (r3 == 0) goto L_0x0074
            java.lang.String r9 = com.igexin.push.core.d.E     // Catch:{ all -> 0x0265 }
            byte[] r3 = com.igexin.b.a.a.a.c(r3, r9)     // Catch:{ all -> 0x0265 }
        L_0x0074:
            r9 = r0
        L_0x0075:
            if (r3 != 0) goto L_0x007a
            if (r9 != 0) goto L_0x007a
            goto L_0x0029
        L_0x007a:
            java.lang.String r10 = "null"
            if (r2 == r8) goto L_0x0257
            r8 = 2
            if (r2 == r8) goto L_0x0249
            r8 = 3
            if (r2 == r8) goto L_0x023b
            r8 = 4
            if (r2 == r8) goto L_0x022d
            r8 = 7
            if (r2 == r8) goto L_0x021f
            r8 = 28
            if (r2 == r8) goto L_0x0215
            if (r2 == r5) goto L_0x020c
            r5 = 66
            if (r2 == r5) goto L_0x01fe
            r5 = 15
            if (r2 == r5) goto L_0x01f0
            r5 = 16
            if (r2 == r5) goto L_0x01e2
            if (r2 == r7) goto L_0x01d9
            if (r2 == r6) goto L_0x01d0
            if (r2 == r4) goto L_0x01c7
            r4 = 59
            if (r2 == r4) goto L_0x01b9
            switch(r2) {
                case 24: goto L_0x01af;
                case 25: goto L_0x01a1;
                case 26: goto L_0x018e;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            switch(r2) {
                case 40: goto L_0x0180;
                case 41: goto L_0x0171;
                case 42: goto L_0x0163;
                case 43: goto L_0x0155;
                default: goto L_0x00ac;
            }
        L_0x00ac:
            switch(r2) {
                case 45: goto L_0x014c;
                case 46: goto L_0x013e;
                case 47: goto L_0x0130;
                case 48: goto L_0x0122;
                case 49: goto L_0x0114;
                case 50: goto L_0x0106;
                case 51: goto L_0x00ee;
                case 52: goto L_0x00e0;
                case 53: goto L_0x00d6;
                case 54: goto L_0x00c8;
                case 55: goto L_0x00ba;
                case 56: goto L_0x00b1;
                default: goto L_0x00af;
            }
        L_0x00af:
            goto L_0x0029
        L_0x00b1:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.A = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x00ba:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.z = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x00c8:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.I = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x00d6:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            com.igexin.push.config.l.K = r9     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x00e0:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.G = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x00ee:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.y = r2     // Catch:{ all -> 0x028b }
            java.lang.String r2 = com.igexin.push.config.l.y     // Catch:{ all -> 0x028b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            com.igexin.push.core.w r2 = com.igexin.push.core.w.a()     // Catch:{ all -> 0x028b }
            r2.e()     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0106:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.H = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0114:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.F = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0122:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.E = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0130:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.D = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x013e:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.C = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x014c:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.x = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0155:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.w = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0163:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.v = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0171:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            long r2 = (long) r2     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.u = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0180:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.t = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x018e:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0029 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0029 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x0029 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0029 }
            java.lang.String[] r2 = com.igexin.push.core.a.r.a(r3)     // Catch:{ Exception -> 0x0029 }
            com.igexin.push.config.SDKUrlConfig.setIdcConfigUrl(r2)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0029
        L_0x01a1:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.m = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01af:
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0029 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0029 }
            com.igexin.push.config.n.a((java.lang.String) r2, (boolean) r1)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0029
        L_0x01b9:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            long r2 = java.lang.Long.parseLong(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.M = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01c7:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.B = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01d0:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.j = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01d9:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.i = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01e2:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.e = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01f0:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.d = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x01fe:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.J = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x020c:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x028b }
            r2.<init>(r3)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.L = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0215:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            com.igexin.push.config.l.s = r9     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x021f:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.g = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x022d:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            boolean r2 = java.lang.Boolean.parseBoolean(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.f = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x023b:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            long r2 = java.lang.Long.parseLong(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.c = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0249:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.b = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0257:
            boolean r2 = r9.equals(r10)     // Catch:{ all -> 0x028b }
            if (r2 != 0) goto L_0x0029
            int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x028b }
            com.igexin.push.config.l.a = r2     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0265:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028b }
            r3.<init>()     // Catch:{ all -> 0x028b }
            java.lang.String r4 = a     // Catch:{ all -> 0x028b }
            r3.append(r4)     // Catch:{ all -> 0x028b }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x028b }
            r3.append(r2)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x028b }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x028b }
            com.igexin.b.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x028b }
            goto L_0x0029
        L_0x0287:
            if (r12 == 0) goto L_0x0290
            goto L_0x028d
        L_0x028a:
            r12 = r0
        L_0x028b:
            if (r12 == 0) goto L_0x0290
        L_0x028d:
            r12.close()
        L_0x0290:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = a
            r12.append(r2)
            java.lang.String r3 = "|current ver = "
            r12.append(r3)
            java.lang.String r3 = "4.4.3.1"
            r12.append(r3)
            java.lang.String r4 = ", last ver = "
            r12.append(r4)
            java.lang.String r4 = com.igexin.push.core.d.N
            r12.append(r4)
            java.lang.String r12 = r12.toString()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r12, (java.lang.Object[]) r4)
            java.lang.String r12 = com.igexin.push.core.d.N
            boolean r12 = r3.equals(r12)
            if (r12 != 0) goto L_0x034b
            com.igexin.push.core.bean.e r12 = com.igexin.push.config.l.h
            if (r12 == 0) goto L_0x0319
            com.igexin.push.core.bean.e r12 = com.igexin.push.config.l.h
            java.util.Map r12 = r12.a()
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0313
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r2)
            java.lang.String r2 = "|extMap is empty  = false"
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r12, (java.lang.Object[]) r1)
            com.igexin.push.core.bean.e r12 = com.igexin.push.config.l.h
            java.util.Map r12 = r12.a()
            java.util.Set r12 = r12.keySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x02f3:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0313
            com.igexin.push.core.bean.e r1 = com.igexin.push.config.l.h
            java.util.Map r1 = r1.a()
            java.lang.Object r2 = r12.next()
            java.lang.Object r1 = r1.get(r2)
            com.igexin.push.core.bean.d r1 = (com.igexin.push.core.bean.d) r1
            if (r1 == 0) goto L_0x02f3
            java.lang.String r1 = r1.a()
            com.igexin.push.util.c.b((java.lang.String) r1)
            goto L_0x02f3
        L_0x0313:
            com.igexin.push.config.l.h = r0
            r11.g()
            goto L_0x033b
        L_0x0319:
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x033b }
            java.lang.String r0 = com.igexin.push.core.d.X     // Catch:{ Exception -> 0x033b }
            r12.<init>(r0)     // Catch:{ Exception -> 0x033b }
            java.io.File[] r12 = r12.listFiles()     // Catch:{ Exception -> 0x033b }
            int r0 = r12.length     // Catch:{ Exception -> 0x033b }
        L_0x0325:
            if (r1 >= r0) goto L_0x033b
            r2 = r12[r1]     // Catch:{ Exception -> 0x033b }
            java.lang.String r4 = r2.getName()     // Catch:{ Exception -> 0x033b }
            java.lang.String r5 = "tdata_"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Exception -> 0x033b }
            if (r4 == 0) goto L_0x0338
            r2.delete()     // Catch:{ Exception -> 0x033b }
        L_0x0338:
            int r1 = r1 + 1
            goto L_0x0325
        L_0x033b:
            com.igexin.push.core.b.i r12 = com.igexin.push.core.b.i.a()
            r12.e((java.lang.String) r3)
            com.igexin.push.core.b.i r12 = com.igexin.push.core.b.i.a()
            r0 = 0
            r12.c((long) r0)
        L_0x034b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void b(String str) {
        c.b().a(new h(this, str), true, false);
    }

    public void c() {
        c.b().a(new c(this), false, true);
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, String.valueOf(l.a));
        a(sQLiteDatabase, 2, String.valueOf(l.b));
        a(sQLiteDatabase, 3, String.valueOf(l.c));
        a(sQLiteDatabase, 4, String.valueOf(l.f));
        a(sQLiteDatabase, 7, String.valueOf(l.g));
        a(sQLiteDatabase, 15, String.valueOf(l.d));
        a(sQLiteDatabase, 3, String.valueOf(l.c));
        a(sQLiteDatabase, 25, String.valueOf(l.m));
    }

    public void d() {
        c.b().a(new d(this), false, true);
    }

    public void e() {
        c.b().a(new e(this), false, true);
    }

    public void f() {
        c.b().a(new f(this), false, true);
    }

    public void g() {
        c.b().a(new i(this), true, false);
    }
}
