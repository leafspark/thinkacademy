package com.bonree.sdk.f;

import com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean;
import com.bonree.sdk.common.json.JSONArray;
import com.bonree.sdk.common.json.JSONObject;

public class f {
    private UploadDataResponseBean a;
    private boolean b;

    public final UploadDataResponseBean a() {
        return this.a;
    }

    public final void a(UploadDataResponseBean uploadDataResponseBean) {
        this.a = uploadDataResponseBean;
    }

    public final boolean b() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public f(UploadDataResponseBean uploadDataResponseBean, boolean z) {
        this.a = null;
        this.b = true;
    }

    public final void c() {
        this.a = null;
        this.b = true;
    }

    public f() {
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0152 */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015d A[Catch:{ all -> 0x0182 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r48) {
        /*
            java.lang.String r0 = "d"
            java.lang.String r1 = "udr"
            com.bonree.sdk.common.json.JSONObject r3 = new com.bonree.sdk.common.json.JSONObject     // Catch:{ all -> 0x02de }
            r4 = r48
            r3.<init>((java.lang.String) r4)     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONObject r4 = r3.getJSONObject(r1)     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r5 = r4.getJSONArray(r0)     // Catch:{ all -> 0x02de }
            int r6 = r5.length()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r7 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r7.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONObject r8 = new com.bonree.sdk.common.json.JSONObject     // Catch:{ all -> 0x02de }
            r8.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r9 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r9.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r10 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r10.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r11 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r11.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r12 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r12.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r13 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r13.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r14 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r14.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r15 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r15.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r15 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r15.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r2 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r2.<init>()     // Catch:{ all -> 0x02de }
            r16 = r1
            com.bonree.sdk.common.json.JSONArray r1 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r1.<init>()     // Catch:{ all -> 0x02de }
            r17 = r3
            com.bonree.sdk.common.json.JSONArray r3 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r3.<init>()     // Catch:{ all -> 0x02de }
            r48 = r7
            com.bonree.sdk.common.json.JSONArray r7 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r7.<init>()     // Catch:{ all -> 0x02de }
            r18 = r0
            java.lang.String r0 = ""
            r19 = 0
            r21 = r4
            r26 = r0
            r28 = r8
            r22 = r19
            r24 = r22
            r4 = 0
            r20 = 0
            r27 = 0
        L_0x0078:
            java.lang.String r8 = "ut"
            r29 = r3
            java.lang.String r3 = "amt"
            r30 = r8
            java.lang.String r8 = "car"
            r31 = r7
            java.lang.String r7 = "si"
            r32 = r7
            java.lang.String r7 = "s"
            r33 = r3
            java.lang.String r3 = "nr"
            r34 = r1
            java.lang.String r1 = "l"
            r35 = r8
            java.lang.String r8 = "i"
            r36 = r2
            java.lang.String r2 = "dci"
            r37 = r7
            java.lang.String r7 = "we"
            r38 = r0
            java.lang.String r0 = "wi"
            r39 = r15
            java.lang.String r15 = "ar"
            r40 = r3
            java.lang.String r3 = "cmt"
            r41 = r3
            java.lang.String r3 = "cuf"
            r42 = r3
            java.lang.String r3 = "ti"
            if (r4 >= r6) goto L_0x019c
            r43 = r6
            com.bonree.sdk.common.json.JSONObject r6 = r5.getJSONObject(r4)     // Catch:{ all -> 0x02de }
            a(r6, r9, r15)     // Catch:{ all -> 0x02de }
            a(r6, r10, r0, r4)     // Catch:{ all -> 0x02de }
            a(r6, r11, r7, r4)     // Catch:{ all -> 0x02de }
            a(r6, r12, r2)     // Catch:{ all -> 0x02de }
            a(r6, r13, r8)     // Catch:{ all -> 0x02de }
            a(r6, r14, r1)     // Catch:{ all -> 0x02de }
            r0 = r40
            com.bonree.sdk.common.json.JSONArray r0 = r6.getJSONArray(r0)     // Catch:{ all -> 0x0121 }
            r1 = 0
        L_0x00d3:
            int r2 = r0.length()     // Catch:{ all -> 0x0121 }
            if (r1 >= r2) goto L_0x0121
            com.bonree.sdk.common.json.JSONArray r2 = r0.getJSONArray(r1)     // Catch:{ all -> 0x0121 }
            if (r4 != 0) goto L_0x00e8
            r7 = r39
            r7.put((java.lang.Object) r2)     // Catch:{ all -> 0x00e5 }
            goto L_0x0113
        L_0x00e5:
            r0 = r38
            goto L_0x0125
        L_0x00e8:
            r7 = r39
            if (r1 == 0) goto L_0x0113
            r8 = 0
            java.lang.String r15 = r2.getString(r8)     // Catch:{ all -> 0x0110 }
            if (r15 == 0) goto L_0x010b
            java.lang.String r15 = r2.getString(r8)     // Catch:{ all -> 0x0110 }
            r19 = r0
            r0 = r38
            if (r15 == r0) goto L_0x0118
            java.lang.String r15 = r2.getString(r8)     // Catch:{ all -> 0x0126 }
            int r15 = r15.length()     // Catch:{ all -> 0x0126 }
            if (r15 <= 0) goto L_0x0118
            r7.put((java.lang.Object) r2)     // Catch:{ all -> 0x0126 }
            goto L_0x0118
        L_0x010b:
            r19 = r0
            r0 = r38
            goto L_0x0118
        L_0x0110:
            r0 = r38
            goto L_0x0126
        L_0x0113:
            r19 = r0
            r0 = r38
            r8 = 0
        L_0x0118:
            int r1 = r1 + 1
            r38 = r0
            r39 = r7
            r0 = r19
            goto L_0x00d3
        L_0x0121:
            r0 = r38
            r7 = r39
        L_0x0125:
            r8 = 0
        L_0x0126:
            r1 = r36
            r2 = r37
            a(r6, r1, r2)     // Catch:{ all -> 0x02de }
            r2 = r34
            r15 = r35
            a(r6, r2, r15)     // Catch:{ all -> 0x02de }
            r15 = r41
            long r22 = r6.getLong(r15)     // Catch:{ all -> 0x02de }
            r15 = r33
            long r24 = r6.getLong(r15)     // Catch:{ all -> 0x02de }
            r15 = r32
            java.lang.String r26 = r6.getString(r15)     // Catch:{ all -> 0x02de }
            java.lang.String r15 = "nsi"
            com.bonree.sdk.common.json.JSONObject r27 = r6.getJSONObject(r15)     // Catch:{ all -> 0x0152 }
            java.lang.String r15 = "asr"
            com.bonree.sdk.common.json.JSONObject r20 = r6.getJSONObject(r15)     // Catch:{ all -> 0x0152 }
        L_0x0152:
            com.bonree.sdk.common.json.JSONArray r3 = r6.getJSONArray(r3)     // Catch:{ all -> 0x0182 }
            r15 = r8
        L_0x0157:
            int r8 = r3.length()     // Catch:{ all -> 0x0182 }
            if (r15 >= r8) goto L_0x0182
            com.bonree.sdk.common.json.JSONObject r8 = r3.getJSONObject(r15)     // Catch:{ all -> 0x0182 }
            r32 = r5
            r5 = r42
            java.lang.String r8 = r8.getString(r5)     // Catch:{ all -> 0x0184 }
            if (r8 == 0) goto L_0x0177
            com.bonree.sdk.common.json.JSONObject r8 = r3.getJSONObject(r15)     // Catch:{ all -> 0x0184 }
            r42 = r5
            r5 = r31
            r5.put((java.lang.Object) r8)     // Catch:{ all -> 0x0186 }
            goto L_0x017b
        L_0x0177:
            r42 = r5
            r5 = r31
        L_0x017b:
            int r15 = r15 + 1
            r31 = r5
            r5 = r32
            goto L_0x0157
        L_0x0182:
            r32 = r5
        L_0x0184:
            r5 = r31
        L_0x0186:
            r3 = r29
            r8 = r30
            a(r6, r3, r8, r4)     // Catch:{ all -> 0x02de }
            int r4 = r4 + 1
            r15 = r7
            r6 = r43
            r7 = r5
            r5 = r32
            r46 = r2
            r2 = r1
            r1 = r46
            goto L_0x0078
        L_0x019c:
            r44 = r29
            r45 = r30
            r6 = r39
            r4 = r41
            r29 = r3
            r3 = r40
            r5 = r28
            r46 = r22
            r22 = r13
            r23 = r14
            r13 = r46
            r5.put((java.lang.String) r4, (long) r13)     // Catch:{ all -> 0x02de }
            r5.put((java.lang.String) r15, (java.lang.Object) r9)     // Catch:{ all -> 0x02de }
            r5.put((java.lang.String) r0, (java.lang.Object) r10)     // Catch:{ all -> 0x02de }
            r5.put((java.lang.String) r7, (java.lang.Object) r11)     // Catch:{ all -> 0x02de }
            r5.put((java.lang.String) r2, (java.lang.Object) r12)     // Catch:{ all -> 0x02de }
            r0 = r22
            r5.put((java.lang.String) r8, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r0 = r23
            r5.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r5.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x02de }
            r0 = r36
            r1 = r37
            r5.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r0 = r26
            r1 = r32
            r5.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r0 = r34
            r1 = r35
            r5.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r0 = r24
            r2 = r33
            r5.put((java.lang.String) r2, (long) r0)     // Catch:{ all -> 0x02de }
            r1 = r29
            r0 = r31
            r5.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r0 = r44
            r2 = r45
            r5.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            java.lang.String r0 = "nsi"
            r2 = r27
            r5.put((java.lang.String) r0, (java.lang.Object) r2)     // Catch:{ all -> 0x02de }
            java.lang.String r0 = "asr"
            if (r20 != 0) goto L_0x0205
            java.lang.Object r20 = com.bonree.sdk.common.json.JSONObject.NULL     // Catch:{ all -> 0x02de }
        L_0x0205:
            r2 = r20
            r5.put((java.lang.String) r0, (java.lang.Object) r2)     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r0 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r0.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r2 = r5.getJSONArray(r1)     // Catch:{ all -> 0x02de }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x02de }
            r3.<init>()     // Catch:{ all -> 0x02de }
            r8 = 0
        L_0x0219:
            int r4 = r2.length()     // Catch:{ all -> 0x02de }
            if (r8 >= r4) goto L_0x023f
            com.bonree.sdk.common.json.JSONObject r4 = r2.getJSONObject(r8)     // Catch:{ all -> 0x02de }
            r6 = r42
            java.lang.String r4 = r4.getString(r6)     // Catch:{ all -> 0x02de }
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x02de }
            if (r4 != 0) goto L_0x023a
            com.bonree.sdk.common.json.JSONObject r4 = r2.getJSONObject(r8)     // Catch:{ all -> 0x02de }
            java.lang.String r4 = r4.getString(r6)     // Catch:{ all -> 0x02de }
            r3.add(r4)     // Catch:{ all -> 0x02de }
        L_0x023a:
            int r8 = r8 + 1
            r42 = r6
            goto L_0x0219
        L_0x023f:
            r6 = r42
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x02de }
            if (r4 != 0) goto L_0x02ba
            r8 = 0
        L_0x0248:
            int r4 = r3.size()     // Catch:{ all -> 0x02de }
            if (r8 >= r4) goto L_0x02ba
            com.bonree.sdk.common.json.JSONObject r4 = new com.bonree.sdk.common.json.JSONObject     // Catch:{ all -> 0x02de }
            r4.<init>()     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONArray r7 = new com.bonree.sdk.common.json.JSONArray     // Catch:{ all -> 0x02de }
            r7.<init>()     // Catch:{ all -> 0x02de }
            java.lang.Object r9 = r3.get(r8)     // Catch:{ all -> 0x02de }
            r4.put((java.lang.String) r6, (java.lang.Object) r9)     // Catch:{ all -> 0x02de }
            r9 = 0
            r10 = 0
        L_0x0261:
            int r11 = r2.length()     // Catch:{ all -> 0x02de }
            if (r9 >= r11) goto L_0x02af
            java.lang.Object r11 = r3.get(r8)     // Catch:{ all -> 0x02de }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x02de }
            com.bonree.sdk.common.json.JSONObject r12 = r2.getJSONObject(r9)     // Catch:{ all -> 0x02de }
            java.lang.String r12 = r12.getString(r6)     // Catch:{ all -> 0x02de }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x02de }
            if (r11 == 0) goto L_0x02ac
            com.bonree.sdk.common.json.JSONObject r11 = r2.getJSONObject(r9)     // Catch:{ all -> 0x02de }
            java.lang.String r12 = "tc"
            com.bonree.sdk.common.json.JSONArray r11 = r11.getJSONArray(r12)     // Catch:{ all -> 0x02de }
            r12 = r10
            r10 = 0
        L_0x0287:
            int r13 = r11.length()     // Catch:{ all -> 0x02de }
            if (r10 >= r13) goto L_0x02ab
            com.bonree.sdk.common.json.JSONArray r13 = r11.getJSONArray(r10)     // Catch:{ all -> 0x02de }
            java.lang.String r14 = "[\"nsi\",\"bnc\"]"
            java.lang.String r15 = r13.toString()     // Catch:{ all -> 0x02de }
            boolean r14 = r14.equals(r15)     // Catch:{ all -> 0x02de }
            if (r14 == 0) goto L_0x02a3
            int r12 = r12 + 1
            r14 = 1
            if (r12 == r14) goto L_0x02a3
            r13 = 0
        L_0x02a3:
            if (r13 == 0) goto L_0x02a8
            r7.put((java.lang.Object) r13)     // Catch:{ all -> 0x02de }
        L_0x02a8:
            int r10 = r10 + 1
            goto L_0x0287
        L_0x02ab:
            r10 = r12
        L_0x02ac:
            int r9 = r9 + 1
            goto L_0x0261
        L_0x02af:
            java.lang.String r9 = "tc"
            r4.put((java.lang.String) r9, (java.lang.Object) r7)     // Catch:{ all -> 0x02de }
            r0.put((java.lang.Object) r4)     // Catch:{ all -> 0x02de }
            int r8 = r8 + 1
            goto L_0x0248
        L_0x02ba:
            r5.remove(r1)     // Catch:{ all -> 0x02de }
            r5.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            r1 = r18
            r0 = r21
            r0.remove(r1)     // Catch:{ all -> 0x02de }
            r2 = r48
            r2.put((java.lang.Object) r5)     // Catch:{ all -> 0x02de }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x02de }
            r2 = r16
            r1 = r17
            r1.remove(r2)     // Catch:{ all -> 0x02de }
            r1.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ all -> 0x02de }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x02de }
            return r0
        L_0x02de:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.f.a(java.lang.String):java.lang.String");
    }

    private static void a(JSONObject jSONObject, JSONArray jSONArray, String str) {
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(str);
            for (int i = 0; i < jSONArray2.length(); i++) {
                jSONArray.put((Object) jSONArray2.getJSONObject(i));
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(JSONObject jSONObject, JSONArray jSONArray, String str, int i) {
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(str);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                if (i == 0) {
                    jSONArray.put((Object) jSONArray3);
                } else if (i2 != 0) {
                    jSONArray.put((Object) jSONArray3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(JSONObject jSONObject, JSONArray jSONArray, String str, int i) {
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(str);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                if (i == 0) {
                    jSONArray.put((Object) jSONArray3);
                } else if (!(i2 == 0 || jSONArray3.getString(0) == null || jSONArray3.getString(0) == "" || jSONArray3.getString(0).length() <= 0)) {
                    jSONArray.put((Object) jSONArray3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(JSONObject jSONObject, JSONArray jSONArray, String str) {
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(str);
            for (int i = 0; i < jSONArray2.length(); i++) {
                if (jSONArray2.getJSONObject(i).getString("cuf") != null) {
                    jSONArray.put((Object) jSONArray2.getJSONObject(i));
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(JSONObject jSONObject, JSONArray jSONArray, String str) {
        try {
            jSONArray.put((Object) jSONObject.getJSONArray(str));
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, JSONArray jSONArray, String str) {
        try {
            jSONArray.put((Object) jSONObject.getJSONObject(str));
        } catch (Throwable unused) {
        }
    }
}
