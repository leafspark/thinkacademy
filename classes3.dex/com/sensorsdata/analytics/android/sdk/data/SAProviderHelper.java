package com.sensorsdata.analytics.android.sdk.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppEndData;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppPaused;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppStartTime;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFlushDataState;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import org.json.JSONArray;
import org.json.JSONObject;

class SAProviderHelper {
    private ContentResolver contentResolver;
    /* access modifiers changed from: private */
    public boolean isDbWritable = true;
    private boolean isFirstProcessStarted = true;
    private Context mContext;
    private SQLiteOpenHelper mDbHelper;
    private int mSessionTime = 30000;
    private PersistentAppEndData persistentAppEndData;
    private PersistentAppPaused persistentAppPaused;
    private PersistentAppStartTime persistentAppStartTime;
    private PersistentFlushDataState persistentFlushDataState;
    private PersistentLoginId persistentLoginId;
    private PersistentRemoteSDKConfig persistentRemoteSDKConfig;
    private int startActivityCount = 0;

    public interface URI_CODE {
        public static final int ACTIVITY_START_COUNT = 2;
        public static final int APP_END_DATA = 4;
        public static final int APP_PAUSED_TIME = 5;
        public static final int APP_START_TIME = 3;
        public static final int CHANNEL_PERSISTENT = 8;
        public static final int DISABLE_SDK = 11;
        public static final int EVENTS = 1;
        public static final int FIRST_PROCESS_START = 10;
        public static final int FLUSH_DATA = 9;
        public static final int LOGIN_ID = 7;
        public static final int REMOTE_CONFIG = 12;
        public static final int SESSION_INTERVAL_TIME = 6;
    }

    public SAProviderHelper(Context context, SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            this.mDbHelper = sQLiteOpenHelper;
            this.mContext = context;
            this.contentResolver = context.getContentResolver();
            PersistentLoader.initLoader(context);
            this.persistentAppEndData = (PersistentAppEndData) PersistentLoader.loadPersistent("app_end_data");
            this.persistentAppStartTime = (PersistentAppStartTime) PersistentLoader.loadPersistent("app_start_time");
            this.persistentAppPaused = (PersistentAppPaused) PersistentLoader.loadPersistent("app_end_time");
            this.persistentLoginId = (PersistentLoginId) PersistentLoader.loadPersistent("events_login_id");
            this.persistentFlushDataState = (PersistentFlushDataState) PersistentLoader.loadPersistent("sub_process_flush_data");
            this.persistentRemoteSDKConfig = (PersistentRemoteSDKConfig) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.REMOTE_CONFIG);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void migratingDB(final Context context, final String str) {
        try {
            if (AppInfoUtils.getAppInfoBundle(context).getBoolean("com.sensorsdata.analytics.android.EnableMigratingDB", true)) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            if (context.getDatabasePath(str).exists()) {
                                OldBDatabaseHelper oldBDatabaseHelper = new OldBDatabaseHelper(context, str);
                                SQLiteDatabase access$000 = SAProviderHelper.this.getWritableDatabase();
                                if (access$000 != null) {
                                    JSONArray allEvents = oldBDatabaseHelper.getAllEvents();
                                    for (int i = 0; i < allEvents.length(); i++) {
                                        JSONObject jSONObject = allEvents.getJSONObject(i);
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put(DbParams.KEY_DATA, jSONObject.getString(DbParams.KEY_DATA));
                                        contentValues.put(DbParams.KEY_CREATED_AT, jSONObject.getString(DbParams.KEY_CREATED_AT));
                                        access$000.insert(DbParams.TABLE_EVENTS, "_id", contentValues);
                                    }
                                }
                            }
                            if (SAProviderHelper.this.isDbWritable) {
                                context.deleteDatabase(str);
                            }
                        } catch (Exception e) {
                            SALog.printStackTrace(e);
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void appendUri(UriMatcher uriMatcher, String str) {
        try {
            uriMatcher.addURI(str, DbParams.TABLE_EVENTS, 1);
            uriMatcher.addURI(str, DbParams.TABLE_ACTIVITY_START_COUNT, 2);
            uriMatcher.addURI(str, "app_start_time", 3);
            uriMatcher.addURI(str, "app_end_data", 4);
            uriMatcher.addURI(str, "app_end_time", 5);
            uriMatcher.addURI(str, DbParams.TABLE_SESSION_INTERVAL_TIME, 6);
            uriMatcher.addURI(str, "events_login_id", 7);
            uriMatcher.addURI(str, DbParams.TABLE_CHANNEL_PERSISTENT, 8);
            uriMatcher.addURI(str, "sub_process_flush_data", 9);
            uriMatcher.addURI(str, DbParams.TABLE_FIRST_PROCESS_START, 10);
            uriMatcher.addURI(str, DbParams.TABLE_DATA_DISABLE_SDK, 11);
            uriMatcher.addURI(str, DbParams.TABLE_REMOTE_CONFIG, 12);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public Uri insertEvent(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !contentValues.containsKey(DbParams.KEY_DATA)) {
                return uri;
            }
            return !contentValues.containsKey(DbParams.KEY_CREATED_AT) ? uri : ContentUris.withAppendedId(uri, writableDatabase.insert(DbParams.TABLE_EVENTS, "_id", contentValues));
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return uri;
        }
    }

    public int deleteEvents(String str, String[] strArr) {
        if (!this.isDbWritable) {
            return 0;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.delete(DbParams.TABLE_EVENTS, str, strArr);
            }
        } catch (SQLiteException e) {
            this.isDbWritable = false;
            SALog.printStackTrace(e);
        }
        return 0;
    }

    public Uri insertChannelPersistent(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !contentValues.containsKey(DbParams.KEY_CHANNEL_EVENT_NAME)) {
                return uri;
            }
            return !contentValues.containsKey(DbParams.KEY_CHANNEL_RESULT) ? uri : ContentUris.withAppendedId(uri, writableDatabase.insertWithOnConflict(DbParams.TABLE_CHANNEL_PERSISTENT, (String) null, contentValues, 5));
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return uri;
        }
    }

    public void insertPersistent(int i, Uri uri, ContentValues contentValues) {
        switch (i) {
            case 2:
                this.startActivityCount = contentValues.getAsInteger(DbParams.TABLE_ACTIVITY_START_COUNT).intValue();
                return;
            case 3:
                this.persistentAppStartTime.commit(contentValues.getAsLong("app_start_time"));
                return;
            case 4:
                this.persistentAppEndData.commit(contentValues.getAsString("app_end_data"));
                return;
            case 5:
                this.persistentAppPaused.commit(contentValues.getAsLong("app_end_time"));
                return;
            case 6:
                this.mSessionTime = contentValues.getAsInteger(DbParams.TABLE_SESSION_INTERVAL_TIME).intValue();
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 7:
                this.persistentLoginId.commit(contentValues.getAsString("events_login_id"));
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 9:
                this.persistentFlushDataState.commit(contentValues.getAsBoolean("sub_process_flush_data"));
                return;
            case 10:
                this.isFirstProcessStarted = contentValues.getAsBoolean(DbParams.TABLE_FIRST_PROCESS_START).booleanValue();
                return;
            case 12:
                try {
                    this.persistentRemoteSDKConfig.commit(contentValues.getAsString(DbParams.TABLE_REMOTE_CONFIG));
                    return;
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                    return;
                }
            default:
                return;
        }
    }

    public Cursor queryByTable(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        if (!this.isDbWritable) {
            return null;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.query(str, strArr, str2, strArr2, (String) null, (String) null, str3);
            }
            return null;
        } catch (SQLiteException e) {
            this.isDbWritable = false;
            SALog.printStackTrace(e);
            return null;
        }
    }

    public Cursor queryPersistent(int i) {
        Object obj;
        String str;
        int i2;
        switch (i) {
            case 2:
                obj = Integer.valueOf(this.startActivityCount);
                str = DbParams.TABLE_ACTIVITY_START_COUNT;
                break;
            case 3:
                obj = this.persistentAppStartTime.get();
                str = "app_start_time";
                break;
            case 4:
                obj = this.persistentAppEndData.get();
                str = "app_end_data";
                break;
            case 5:
                obj = this.persistentAppPaused.get();
                str = "app_end_time";
                break;
            case 6:
                obj = Integer.valueOf(this.mSessionTime);
                str = DbParams.TABLE_SESSION_INTERVAL_TIME;
                break;
            case 7:
                obj = this.persistentLoginId.get();
                str = "events_login_id";
                break;
            case 9:
                synchronized (SensorsDataContentProvider.class) {
                    if (((Boolean) this.persistentFlushDataState.get()).booleanValue()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                        this.persistentFlushDataState.commit(true);
                    }
                }
                obj = i2;
                str = "sub_process_flush_data";
                break;
            case 10:
                obj = Integer.valueOf(this.isFirstProcessStarted ? 1 : 0);
                str = DbParams.TABLE_FIRST_PROCESS_START;
                break;
            case 12:
                try {
                    obj = this.persistentRemoteSDKConfig.get();
                    str = null;
                    break;
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                    return null;
                }
            default:
                obj = null;
                str = null;
                break;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{str});
        matrixCursor.addRow(new Object[]{obj});
        return matrixCursor;
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase getWritableDatabase() {
        try {
            if (!isDBExist()) {
                this.mDbHelper.close();
                this.isDbWritable = true;
            }
            return this.mDbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            SALog.printStackTrace(e);
            this.isDbWritable = false;
            return null;
        }
    }

    private boolean isDBExist() {
        return this.mContext.getDatabasePath(DbParams.DATABASE_NAME).exists();
    }
}
