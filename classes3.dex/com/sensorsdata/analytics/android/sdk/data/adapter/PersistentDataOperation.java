package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

class PersistentDataOperation extends DataOperation {
    PersistentDataOperation(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public String[] queryData(Uri uri, int i) {
        return handleQueryUri(uri);
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, JSONObject jSONObject) {
        return handleInsertUri(uri, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, ContentValues contentValues) {
        this.contentResolver.insert(uri, contentValues);
        return 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0083, code lost:
        switch(r5) {
            case 0: goto L_0x00df;
            case 1: goto L_0x00d5;
            case 2: goto L_0x00c9;
            case 3: goto L_0x00bd;
            case 4: goto L_0x00b1;
            case 5: goto L_0x00a9;
            case 6: goto L_0x009d;
            case 7: goto L_0x0091;
            case 8: goto L_0x0089;
            default: goto L_0x0086;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0088, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r4.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_REMOTE_CONFIG, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        r4.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START, java.lang.Boolean.valueOf(r1.optBoolean("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009d, code lost:
        r4.put("sub_process_flush_data", java.lang.Boolean.valueOf(r1.optBoolean("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a9, code lost:
        r4.put("events_login_id", r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b1, code lost:
        r4.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME, java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bd, code lost:
        r4.put("app_start_time", java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c9, code lost:
        r4.put("app_end_time", java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d5, code lost:
        r4.put("app_end_data", r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00df, code lost:
        r4.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT, java.lang.Integer.valueOf(r1.optInt("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r16.contentResolver.insert(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f1, code lost:
        r0 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleInsertUri(android.net.Uri r17, org.json.JSONObject r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = -1
            if (r0 != 0) goto L_0x0008
            return r2
        L_0x0008:
            r3 = 0
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x00f6 }
            r4.<init>()     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r5 = r17.getPath()     // Catch:{ Exception -> 0x00f6 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00f6 }
            if (r6 != 0) goto L_0x00f3
            r6 = 1
            java.lang.String r5 = r5.substring(r6)     // Catch:{ Exception -> 0x00f6 }
            int r7 = r5.hashCode()     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r8 = "sub_process_flush_data"
            java.lang.String r9 = "app_end_time"
            java.lang.String r10 = "app_end_data"
            java.lang.String r11 = "app_start_time"
            java.lang.String r12 = "remote_config"
            java.lang.String r13 = "first_process_start"
            java.lang.String r14 = "session_interval_time"
            java.lang.String r15 = "events_login_id"
            java.lang.String r6 = "activity_started_count"
            switch(r7) {
                case -1437430111: goto L_0x0078;
                case -1436067305: goto L_0x0070;
                case -1173524450: goto L_0x0068;
                case -1109940413: goto L_0x0060;
                case 204459355: goto L_0x0057;
                case 791585128: goto L_0x004f;
                case 1521941740: goto L_0x0047;
                case 1522425871: goto L_0x003f;
                case 1964784692: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0080
        L_0x0037:
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 6
            goto L_0x0081
        L_0x003f:
            boolean r5 = r5.equals(r9)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 2
            goto L_0x0081
        L_0x0047:
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 1
            goto L_0x0081
        L_0x004f:
            boolean r5 = r5.equals(r11)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 3
            goto L_0x0081
        L_0x0057:
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 8
            goto L_0x0081
        L_0x0060:
            boolean r5 = r5.equals(r13)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 7
            goto L_0x0081
        L_0x0068:
            boolean r5 = r5.equals(r14)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 4
            goto L_0x0081
        L_0x0070:
            boolean r5 = r5.equals(r15)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = 5
            goto L_0x0081
        L_0x0078:
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x0080
            r5 = r3
            goto L_0x0081
        L_0x0080:
            r5 = r2
        L_0x0081:
            java.lang.String r7 = "value"
            switch(r5) {
                case 0: goto L_0x00df;
                case 1: goto L_0x00d5;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00b1;
                case 5: goto L_0x00a9;
                case 6: goto L_0x009d;
                case 7: goto L_0x0091;
                case 8: goto L_0x0089;
                default: goto L_0x0086;
            }
        L_0x0086:
            r1 = r16
            return r2
        L_0x0089:
            java.lang.String r1 = r1.optString(r7)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r12, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x0091:
            boolean r1 = r1.optBoolean(r7)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r13, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x009d:
            boolean r1 = r1.optBoolean(r7)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r8, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x00a9:
            java.lang.String r1 = r1.optString(r7)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r15, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x00b1:
            long r1 = r1.optLong(r7)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r14, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x00bd:
            long r1 = r1.optLong(r7)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r11, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x00c9:
            long r1 = r1.optLong(r7)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r9, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x00d5:
            java.lang.String r1 = r1.optString(r7)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r10, r1)     // Catch:{ Exception -> 0x00f6 }
        L_0x00dc:
            r1 = r16
            goto L_0x00eb
        L_0x00df:
            int r1 = r1.optInt(r7)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00f6 }
            r4.put(r6, r1)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00dc
        L_0x00eb:
            android.content.ContentResolver r2 = r1.contentResolver     // Catch:{ Exception -> 0x00f1 }
            r2.insert(r0, r4)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x00fc
        L_0x00f1:
            r0 = move-exception
            goto L_0x00f9
        L_0x00f3:
            r1 = r16
            goto L_0x00fc
        L_0x00f6:
            r0 = move-exception
            r1 = r16
        L_0x00f9:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x00fc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation.handleInsertUri(android.net.Uri, org.json.JSONObject):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00cc, code lost:
        if (r11 != null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d9, code lost:
        if (r11 != null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00db, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00de, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] handleQueryUri(android.net.Uri r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r11.getPath()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r2 = 1
            java.lang.String r1 = r1.substring(r2)     // Catch:{ Exception -> 0x00d4, all -> 0x00cf }
            android.content.ContentResolver r3 = r10.contentResolver     // Catch:{ Exception -> 0x00d4, all -> 0x00cf }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r11
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00d4, all -> 0x00cf }
            if (r11 == 0) goto L_0x00cc
            int r3 = r11.getCount()     // Catch:{ Exception -> 0x00ca }
            if (r3 <= 0) goto L_0x00cc
            r11.moveToNext()     // Catch:{ Exception -> 0x00ca }
            r3 = -1
            int r4 = r1.hashCode()     // Catch:{ Exception -> 0x00ca }
            r5 = 0
            switch(r4) {
                case -1437430111: goto L_0x0085;
                case -1436067305: goto L_0x007b;
                case -1173524450: goto L_0x0071;
                case -1109940413: goto L_0x0067;
                case 204459355: goto L_0x005d;
                case 791585128: goto L_0x0052;
                case 1521941740: goto L_0x0048;
                case 1522425871: goto L_0x003e;
                case 1964784692: goto L_0x0034;
                default: goto L_0x0033;
            }     // Catch:{ Exception -> 0x00ca }
        L_0x0033:
            goto L_0x008e
        L_0x0034:
            java.lang.String r4 = "sub_process_flush_data"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = r2
            goto L_0x008e
        L_0x003e:
            java.lang.String r4 = "app_end_time"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 6
            goto L_0x008e
        L_0x0048:
            java.lang.String r4 = "app_end_data"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 3
            goto L_0x008e
        L_0x0052:
            java.lang.String r4 = "app_start_time"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 8
            goto L_0x008e
        L_0x005d:
            java.lang.String r4 = "remote_config"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 5
            goto L_0x008e
        L_0x0067:
            java.lang.String r4 = "first_process_start"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 2
            goto L_0x008e
        L_0x0071:
            java.lang.String r4 = "session_interval_time"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 7
            goto L_0x008e
        L_0x007b:
            java.lang.String r4 = "events_login_id"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = 4
            goto L_0x008e
        L_0x0085:
            java.lang.String r4 = "activity_started_count"
            boolean r1 = r1.equals(r4)     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            r3 = r5
        L_0x008e:
            switch(r3) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x00b7;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00a9;
                case 4: goto L_0x00a9;
                case 5: goto L_0x00a9;
                case 6: goto L_0x0097;
                case 7: goto L_0x0097;
                case 8: goto L_0x0097;
                default: goto L_0x0091;
            }
        L_0x0091:
            if (r11 == 0) goto L_0x00c9
            r11.close()
            goto L_0x00c9
        L_0x0097:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00ca }
            long r2 = r11.getLong(r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00ca }
            r1[r5] = r2     // Catch:{ Exception -> 0x00ca }
            if (r11 == 0) goto L_0x00a8
            r11.close()
        L_0x00a8:
            return r1
        L_0x00a9:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = r11.getString(r5)     // Catch:{ Exception -> 0x00ca }
            r1[r5] = r2     // Catch:{ Exception -> 0x00ca }
            if (r11 == 0) goto L_0x00b6
            r11.close()
        L_0x00b6:
            return r1
        L_0x00b7:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00ca }
            int r2 = r11.getInt(r5)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00ca }
            r1[r5] = r2     // Catch:{ Exception -> 0x00ca }
            if (r11 == 0) goto L_0x00c8
            r11.close()
        L_0x00c8:
            return r1
        L_0x00c9:
            return r0
        L_0x00ca:
            r1 = move-exception
            goto L_0x00d6
        L_0x00cc:
            if (r11 == 0) goto L_0x00de
            goto L_0x00db
        L_0x00cf:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x00e0
        L_0x00d4:
            r1 = move-exception
            r11 = r0
        L_0x00d6:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)     // Catch:{ all -> 0x00df }
            if (r11 == 0) goto L_0x00de
        L_0x00db:
            r11.close()
        L_0x00de:
            return r0
        L_0x00df:
            r0 = move-exception
        L_0x00e0:
            if (r11 == 0) goto L_0x00e5
            r11.close()
        L_0x00e5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation.handleQueryUri(android.net.Uri):java.lang.String[]");
    }
}
