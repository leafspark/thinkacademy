package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import org.json.JSONObject;

class EventDataOperation extends DataOperation {
    EventDataOperation(Context context) {
        super(context);
        this.TAG = "EventDataOperation";
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbParams.KEY_DATA, jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
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
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] queryData(android.net.Uri r10, int r11) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            android.content.ContentResolver r3 = r9.contentResolver     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            java.lang.String r8 = "created_at ASC LIMIT "
            r4.append(r8)     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            r4.append(r11)     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            r4 = r10
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x008c, all -> 0x008a }
            if (r10 == 0) goto L_0x0082
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0080 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r3 = ","
            java.lang.String r4 = "["
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0080 }
            r4 = r2
        L_0x002d:
            boolean r5 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0080 }
            if (r5 == 0) goto L_0x007b
            boolean r5 = r10.isLast()     // Catch:{ SQLiteException -> 0x0080 }
            if (r5 == 0) goto L_0x0045
            java.lang.String r3 = "]"
            java.lang.String r4 = "_id"
            int r4 = r10.getColumnIndex(r4)     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r4 = r10.getString(r4)     // Catch:{ SQLiteException -> 0x0080 }
        L_0x0045:
            java.lang.String r5 = "data"
            int r5 = r10.getColumnIndex(r5)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = r10.getString(r5)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = r9.parseData(r5)     // Catch:{ Exception -> 0x0076 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0076 }
            if (r6 != 0) goto L_0x002d
            int r6 = r5.length()     // Catch:{ Exception -> 0x0076 }
            int r6 = r6 - r0
            r11.append(r5, r1, r6)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = ",\"_flush_time\":"
            r11.append(r5)     // Catch:{ Exception -> 0x0076 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0076 }
            r11.append(r5)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = "}"
            r11.append(r5)     // Catch:{ Exception -> 0x0076 }
            r11.append(r3)     // Catch:{ Exception -> 0x0076 }
            goto L_0x002d
        L_0x0076:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x002d
        L_0x007b:
            java.lang.String r11 = r11.toString()     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r11 = move-exception
            goto L_0x008e
        L_0x0082:
            r11 = r2
            r4 = r11
        L_0x0084:
            if (r10 == 0) goto L_0x009c
            r10.close()
            goto L_0x009c
        L_0x008a:
            r11 = move-exception
            goto L_0x00ae
        L_0x008c:
            r11 = move-exception
            r10 = r2
        L_0x008e:
            java.lang.String r3 = r9.TAG     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = "Could not pull records for SensorsData out of database events. Waiting to send."
            com.sensorsdata.analytics.android.sdk.SALog.i(r3, r4, r11)     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x009a
            r10.close()
        L_0x009a:
            r11 = r2
            r4 = r11
        L_0x009c:
            if (r4 == 0) goto L_0x00ab
            r10 = 3
            java.lang.String[] r10 = new java.lang.String[r10]
            r10[r1] = r4
            r10[r0] = r11
            r11 = 2
            java.lang.String r0 = "1"
            r10[r11] = r0
            return r10
        L_0x00ab:
            return r2
        L_0x00ac:
            r11 = move-exception
            r2 = r10
        L_0x00ae:
            if (r2 == 0) goto L_0x00b3
            r2.close()
        L_0x00b3:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.EventDataOperation.queryData(android.net.Uri, int):java.lang.String[]");
    }

    /* access modifiers changed from: package-private */
    public void deleteData(Uri uri, String str) {
        super.deleteData(uri, str);
    }
}
