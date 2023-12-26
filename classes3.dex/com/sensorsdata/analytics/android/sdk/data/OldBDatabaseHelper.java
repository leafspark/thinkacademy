package com.sensorsdata.analytics.android.sdk.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OldBDatabaseHelper extends SQLiteOpenHelper {
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    OldBDatabaseHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r3 == 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004b, code lost:
        if (r3 != null) goto L_0x0059;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONArray getAllEvents() {
        /*
            r9 = this;
            java.lang.String r0 = "data"
            java.lang.String r1 = "created_at"
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r9.getReadableDatabase()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = "SELECT * FROM %s ORDER BY %s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0050 }
            r7 = 0
            java.lang.String r8 = "events"
            r6[r7] = r8     // Catch:{ Exception -> 0x0050 }
            r7 = 1
            r6[r7] = r1     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0050 }
            android.database.Cursor r3 = r4.rawQuery(r5, r3)     // Catch:{ Exception -> 0x0050 }
        L_0x0023:
            boolean r4 = r3.moveToNext()     // Catch:{ Exception -> 0x0050 }
            if (r4 == 0) goto L_0x0048
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0050 }
            r4.<init>()     // Catch:{ Exception -> 0x0050 }
            int r5 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0050 }
            r4.put(r1, r5)     // Catch:{ Exception -> 0x0050 }
            int r5 = r3.getColumnIndex(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0050 }
            r4.put(r0, r5)     // Catch:{ Exception -> 0x0050 }
            r2.put(r4)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0023
        L_0x0048:
            r9.close()
            if (r3 == 0) goto L_0x005c
            goto L_0x0059
        L_0x004e:
            r0 = move-exception
            goto L_0x005d
        L_0x0050:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x004e }
            r9.close()
            if (r3 == 0) goto L_0x005c
        L_0x0059:
            r3.close()
        L_0x005c:
            return r2
        L_0x005d:
            r9.close()
            if (r3 == 0) goto L_0x0065
            r3.close()
        L_0x0065:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.OldBDatabaseHelper.getAllEvents():org.json.JSONArray");
    }
}
