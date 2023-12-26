package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import org.json.JSONObject;

class EncryptDataOperation extends DataOperation {
    private SensorsDataEncrypt mSensorsDataEncrypt;

    EncryptDataOperation(Context context, SensorsDataEncrypt sensorsDataEncrypt) {
        super(context);
        this.mSensorsDataEncrypt = sensorsDataEncrypt;
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            JSONObject encryptTrackData = this.mSensorsDataEncrypt.encryptTrackData(jSONObject);
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbParams.KEY_DATA, encryptTrackData.toString() + "\t" + encryptTrackData.toString().hashCode());
            contentValues.put(DbParams.KEY_CREATED_AT, Long.valueOf(System.currentTimeMillis()));
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Throwable th) {
            SALog.d(this.TAG, th.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, ContentValues contentValues) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] queryData(android.net.Uri r18, int r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "9"
            r4 = 0
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            r6.<init>()     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            r7.<init>()     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            android.content.ContentResolver r8 = r1.contentResolver     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            r0.<init>()     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            java.lang.String r9 = "created_at ASC LIMIT "
            r0.append(r9)     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            r9 = r19
            r0.append(r9)     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            java.lang.String r13 = r0.toString()     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            r9 = r18
            android.database.Cursor r8 = r8.query(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0141, all -> 0x013e }
            if (r8 == 0) goto L_0x0135
            r9 = 0
        L_0x0030:
            boolean r0 = r8.moveToNext()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r10 = "pkv"
            java.lang.String r11 = "payloads"
            java.lang.String r12 = "$"
            java.lang.String r13 = "ekey"
            if (r0 == 0) goto L_0x00c4
            boolean r0 = r8.isLast()     // Catch:{ Exception -> 0x0131 }
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "_id"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r9 = r8.getString(r0)     // Catch:{ Exception -> 0x0131 }
        L_0x004e:
            java.lang.String r0 = "data"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r1.parseData(r0)     // Catch:{ Exception -> 0x00be }
            boolean r14 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00be }
            if (r14 == 0) goto L_0x0063
            goto L_0x0030
        L_0x0063:
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x00be }
            r14.<init>(r0)     // Catch:{ Exception -> 0x00be }
            boolean r0 = r14.has(r13)     // Catch:{ Exception -> 0x00be }
            if (r0 != 0) goto L_0x0074
            com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt r0 = r1.mSensorsDataEncrypt     // Catch:{ Exception -> 0x00be }
            org.json.JSONObject r14 = r0.encryptTrackData(r14)     // Catch:{ Exception -> 0x00be }
        L_0x0074:
            boolean r0 = r14.has(r13)     // Catch:{ Exception -> 0x00be }
            if (r0 == 0) goto L_0x00b9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be }
            r0.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r13 = r14.getString(r13)     // Catch:{ Exception -> 0x00be }
            r0.append(r13)     // Catch:{ Exception -> 0x00be }
            r0.append(r12)     // Catch:{ Exception -> 0x00be }
            int r10 = r14.getInt(r10)     // Catch:{ Exception -> 0x00be }
            r0.append(r10)     // Catch:{ Exception -> 0x00be }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00be }
            boolean r10 = r6.containsKey(r0)     // Catch:{ Exception -> 0x00be }
            if (r10 == 0) goto L_0x00a8
            java.lang.Object r0 = r6.get(r0)     // Catch:{ Exception -> 0x00be }
            org.json.JSONArray r0 = (org.json.JSONArray) r0     // Catch:{ Exception -> 0x00be }
            java.lang.String r10 = r14.getString(r11)     // Catch:{ Exception -> 0x00be }
            r0.put(r10)     // Catch:{ Exception -> 0x00be }
            goto L_0x0030
        L_0x00a8:
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ Exception -> 0x00be }
            r10.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r11 = r14.getString(r11)     // Catch:{ Exception -> 0x00be }
            r10.put(r11)     // Catch:{ Exception -> 0x00be }
            r6.put(r0, r10)     // Catch:{ Exception -> 0x00be }
            goto L_0x0030
        L_0x00b9:
            r7.put(r14)     // Catch:{ Exception -> 0x00be }
            goto L_0x0030
        L_0x00be:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x0131 }
            goto L_0x0030
        L_0x00c4:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0131 }
            r0.<init>()     // Catch:{ Exception -> 0x0131 }
            java.util.Set r14 = r6.keySet()     // Catch:{ Exception -> 0x0131 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0131 }
        L_0x00d1:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x0131 }
            if (r15 == 0) goto L_0x0118
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x0131 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0131 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0131 }
            r5.<init>()     // Catch:{ Exception -> 0x0131 }
            int r3 = r15.indexOf(r12)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r3 = r15.substring(r4, r3)     // Catch:{ Exception -> 0x0131 }
            r5.put(r13, r3)     // Catch:{ Exception -> 0x0131 }
            int r3 = r15.indexOf(r12)     // Catch:{ Exception -> 0x0131 }
            r16 = 1
            int r3 = r3 + 1
            java.lang.String r3 = r15.substring(r3)     // Catch:{ Exception -> 0x0131 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0131 }
            r5.put(r10, r3)     // Catch:{ Exception -> 0x0131 }
            java.lang.Object r3 = r6.get(r15)     // Catch:{ Exception -> 0x0131 }
            r5.put(r11, r3)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r3 = "flush_time"
            r15 = r2
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012f }
            r5.put(r3, r1)     // Catch:{ Exception -> 0x012f }
            r0.put(r5)     // Catch:{ Exception -> 0x012f }
            r1 = r17
            r2 = r15
            goto L_0x00d1
        L_0x0118:
            r15 = r2
            int r1 = r0.length()     // Catch:{ Exception -> 0x012f }
            if (r1 <= 0) goto L_0x0125
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012f }
            r2 = r15
            goto L_0x0138
        L_0x0125:
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x012f }
            java.lang.String r2 = "1"
            r0 = r1
            goto L_0x0138
        L_0x012d:
            r0 = move-exception
            goto L_0x0146
        L_0x012f:
            r0 = move-exception
            goto L_0x0133
        L_0x0131:
            r0 = move-exception
            r15 = r2
        L_0x0133:
            r1 = 0
            goto L_0x0146
        L_0x0135:
            r15 = r2
            r0 = 0
            r9 = 0
        L_0x0138:
            if (r8 == 0) goto L_0x0150
            r8.close()
            goto L_0x0150
        L_0x013e:
            r0 = move-exception
            r5 = 0
            goto L_0x0162
        L_0x0141:
            r0 = move-exception
            r15 = r2
            r1 = 0
            r8 = 0
            r9 = 0
        L_0x0146:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x0160 }
            if (r8 == 0) goto L_0x014e
            r8.close()
        L_0x014e:
            r0 = r1
            r2 = r15
        L_0x0150:
            if (r9 == 0) goto L_0x015e
            r1 = 3
            java.lang.String[] r1 = new java.lang.String[r1]
            r1[r4] = r9
            r3 = 1
            r1[r3] = r0
            r0 = 2
            r1[r0] = r2
            return r1
        L_0x015e:
            r1 = 0
            return r1
        L_0x0160:
            r0 = move-exception
            r5 = r8
        L_0x0162:
            if (r5 == 0) goto L_0x0167
            r5.close()
        L_0x0167:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation.queryData(android.net.Uri, int):java.lang.String[]");
    }

    /* access modifiers changed from: package-private */
    public void deleteData(Uri uri, String str) {
        super.deleteData(uri, str);
    }
}
