package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.io.File;
import org.json.JSONObject;

abstract class DataOperation {
    String TAG = "EventDataOperation";
    ContentResolver contentResolver;
    private Context mContext;
    private final File mDatabaseFile;

    /* access modifiers changed from: package-private */
    public abstract int insertData(Uri uri, ContentValues contentValues);

    /* access modifiers changed from: package-private */
    public abstract int insertData(Uri uri, JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public abstract String[] queryData(Uri uri, int i);

    DataOperation(Context context) {
        this.mContext = context;
        this.contentResolver = context.getContentResolver();
        this.mDatabaseFile = context.getDatabasePath(DbParams.DATABASE_NAME);
    }

    /* access modifiers changed from: package-private */
    public int queryDataCount(Uri uri) {
        return queryDataCount(uri, (String[]) null, (String) null, (String[]) null, (String) null);
    }

    /* access modifiers changed from: package-private */
    public int queryDataCount(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor = null;
        try {
            cursor = this.contentResolver.query(uri, strArr, str, strArr2, str2);
            if (cursor != null) {
                int count = cursor.getCount();
                if (cursor != null) {
                    cursor.close();
                }
                return count;
            }
            if (cursor == null) {
                return 0;
            }
            cursor.close();
            return 0;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            if (cursor == null) {
                return 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteData(Uri uri, String str) {
        try {
            if ("DB_DELETE_ALL".equals(str)) {
                this.contentResolver.delete(uri, (String) null, (String[]) null);
                return;
            }
            this.contentResolver.delete(uri, "_id <= ?", new String[]{str});
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: package-private */
    public String parseData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf("\t");
            if (lastIndexOf > -1) {
                String replaceFirst = str.substring(lastIndexOf).replaceFirst("\t", "");
                str = str.substring(0, lastIndexOf);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(replaceFirst) || !replaceFirst.equals(String.valueOf(str.hashCode()))) {
                    return "";
                }
            }
            return str;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: package-private */
    public int deleteDataLowMemory(Uri uri) {
        if (belowMemThreshold()) {
            SALog.i(this.TAG, "There is not enough space left on the device to store events, so will delete 100 oldest events");
            String[] queryData = queryData(uri, 100);
            if (queryData == null) {
                return -2;
            }
            deleteData(uri, queryData[0]);
            if (queryDataCount(uri) <= 0) {
                return -2;
            }
        }
        return 0;
    }

    private long getMaxCacheSize(Context context) {
        try {
            return SensorsDataAPI.sharedInstance(context).getMaxCacheSize();
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return 33554432;
        }
    }

    private boolean belowMemThreshold() {
        if (!this.mDatabaseFile.exists() || this.mDatabaseFile.length() < getMaxCacheSize(this.mContext)) {
            return false;
        }
        return true;
    }
}
