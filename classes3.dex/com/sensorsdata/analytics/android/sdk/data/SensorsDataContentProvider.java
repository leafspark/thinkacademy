package com.sensorsdata.analytics.android.sdk.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

public class SensorsDataContentProvider extends ContentProvider {
    private static final UriMatcher uriMatcher = new UriMatcher(-1);
    private SensorsDataDBHelper dbHelper;
    private SAProviderHelper mProviderHelper;

    public String getType(Uri uri) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        String str;
        try {
            Context context = getContext();
            if (context == null) {
                return true;
            }
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (UnsupportedOperationException unused) {
                str = "com.sensorsdata.analytics.android.sdk.test";
            }
            SensorsDataDBHelper sensorsDataDBHelper = new SensorsDataDBHelper(context);
            this.dbHelper = sensorsDataDBHelper;
            SAProviderHelper sAProviderHelper = new SAProviderHelper(context, sensorsDataDBHelper);
            this.mProviderHelper = sAProviderHelper;
            UriMatcher uriMatcher2 = uriMatcher;
            sAProviderHelper.appendUri(uriMatcher2, str + ".SensorsDataContentProvider");
            this.mProviderHelper.migratingDB(context, str);
            return true;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return true;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            if (1 == uriMatcher.match(uri)) {
                return this.mProviderHelper.deleteEvents(str, strArr);
            }
            return 0;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return 0;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!(contentValues == null || contentValues.size() == 0)) {
            try {
                int match = uriMatcher.match(uri);
                if (match == 1) {
                    return this.mProviderHelper.insertEvent(uri, contentValues);
                }
                if (match == 8) {
                    return this.mProviderHelper.insertChannelPersistent(uri, contentValues);
                }
                this.mProviderHelper.insertPersistent(match, uri, contentValues);
                return uri;
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
        return uri;
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.dbHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            for (ContentValues insert : contentValuesArr) {
                insert(uri, insert);
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            return r2;
        } catch (SQLiteException e) {
            SALog.printStackTrace(e);
            return 0;
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            int match = uriMatcher.match(uri);
            if (match == 1) {
                return this.mProviderHelper.queryByTable(DbParams.TABLE_EVENTS, strArr, str, strArr2, str2);
            }
            if (match == 8) {
                return this.mProviderHelper.queryByTable(DbParams.TABLE_CHANNEL_PERSISTENT, strArr, str, strArr2, str2);
            }
            return this.mProviderHelper.queryPersistent(match);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }
}
