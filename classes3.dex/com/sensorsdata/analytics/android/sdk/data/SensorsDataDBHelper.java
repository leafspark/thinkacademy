package com.sensorsdata.analytics.android.sdk.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

class SensorsDataDBHelper extends SQLiteOpenHelper {
    private static final String CHANNEL_EVENT_PERSISTENT_TABLE = String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s INTEGER)", new Object[]{DbParams.TABLE_CHANNEL_PERSISTENT, DbParams.KEY_CHANNEL_EVENT_NAME, DbParams.KEY_CHANNEL_RESULT});
    private static final String CREATE_EVENTS_TABLE = String.format("CREATE TABLE %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL);", new Object[]{DbParams.TABLE_EVENTS, DbParams.KEY_DATA, DbParams.KEY_CREATED_AT});
    private static final String EVENTS_TIME_INDEX = String.format("CREATE INDEX IF NOT EXISTS time_idx ON %s (%s);", new Object[]{DbParams.TABLE_EVENTS, DbParams.KEY_CREATED_AT});
    private static final String TAG = "SA.SQLiteOpenHelper";

    SensorsDataDBHelper(Context context) {
        super(context, DbParams.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 5);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SALog.i(TAG, "Creating a new Sensors Analytics DB");
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(EVENTS_TIME_INDEX);
        sQLiteDatabase.execSQL(CHANNEL_EVENT_PERSISTENT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SALog.i(TAG, "Upgrading app, replacing Sensors Analytics DB");
        sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{DbParams.TABLE_EVENTS}));
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(EVENTS_TIME_INDEX);
        sQLiteDatabase.execSQL(CHANNEL_EVENT_PERSISTENT_TABLE);
    }
}
