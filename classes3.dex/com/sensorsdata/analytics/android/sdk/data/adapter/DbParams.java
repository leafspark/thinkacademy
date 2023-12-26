package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.net.Uri;

public class DbParams {
    public static final String DATABASE_NAME = "sensorsdata";
    public static final int DATABASE_VERSION = 5;
    static final String DB_DELETE_ALL = "DB_DELETE_ALL";
    public static final int DB_OUT_OF_MEMORY_ERROR = -2;
    static final int DB_UPDATE_ERROR = -1;
    public static final String GZIP_DATA_ENCRYPT = "9";
    public static final String GZIP_DATA_EVENT = "1";
    public static final String KEY_CHANNEL_EVENT_NAME = "event_name";
    public static final String KEY_CHANNEL_RESULT = "result";
    public static final String KEY_CREATED_AT = "created_at";
    public static final String KEY_DATA = "data";
    public static final String TABLE_ACTIVITY_START_COUNT = "activity_started_count";
    public static final String TABLE_APP_END_DATA = "app_end_data";
    public static final String TABLE_APP_END_TIME = "app_end_time";
    public static final String TABLE_APP_START_TIME = "app_start_time";
    public static final String TABLE_CHANNEL_PERSISTENT = "t_channel";
    public static final String TABLE_DATA_COLLECT = "data_collect";
    public static final String TABLE_DATA_DISABLE_SDK = "disable_SDK";
    public static final String TABLE_DATA_ENABLE_SDK = "enable_SDK";
    public static final String TABLE_EVENTS = "events";
    public static final String TABLE_FIRST_PROCESS_START = "first_process_start";
    public static final String TABLE_LOGIN_ID = "events_login_id";
    public static final String TABLE_REMOTE_CONFIG = "remote_config";
    public static final String TABLE_SESSION_INTERVAL_TIME = "session_interval_time";
    public static final String TABLE_SUB_PROCESS_FLUSH_DATA = "sub_process_flush_data";
    static final String VALUE = "value";
    private static DbParams instance;
    private final Uri mActivityStartCountUri;
    private final Uri mAppEndDataUri;
    private final Uri mAppEndUri;
    private final Uri mAppStartTimeUri;
    private final Uri mChannelPersistentUri;
    private final Uri mDataCollectUri;
    private final Uri mDisableSDKUri;
    private final Uri mEnableSDKUri;
    private final Uri mFirstProcessUri;
    private final Uri mLoginIdUri;
    private final Uri mRemoteConfigUri;
    private final Uri mSessionTimeUri;
    private final Uri mSubProcessUri;
    private final Uri mUri;

    private DbParams(String str) {
        this.mUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_EVENTS);
        this.mActivityStartCountUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_ACTIVITY_START_COUNT);
        this.mAppStartTimeUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + "app_start_time");
        this.mAppEndDataUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + "app_end_data");
        this.mAppEndUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + "app_end_time");
        this.mSessionTimeUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_SESSION_INTERVAL_TIME);
        this.mLoginIdUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + "events_login_id");
        this.mChannelPersistentUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_CHANNEL_PERSISTENT);
        this.mSubProcessUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + "sub_process_flush_data");
        this.mFirstProcessUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_FIRST_PROCESS_START);
        this.mDataCollectUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_DATA_COLLECT);
        this.mEnableSDKUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_DATA_ENABLE_SDK);
        this.mDisableSDKUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_DATA_DISABLE_SDK);
        this.mRemoteConfigUri = Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_REMOTE_CONFIG);
    }

    public static DbParams getInstance(String str) {
        if (instance == null) {
            instance = new DbParams(str);
        }
        return instance;
    }

    public static DbParams getInstance() {
        DbParams dbParams = instance;
        if (dbParams != null) {
            return dbParams;
        }
        throw new IllegalStateException("The static method getInstance(String packageName) should be called before calling getInstance()");
    }

    /* access modifiers changed from: package-private */
    public Uri getEventUri() {
        return this.mUri;
    }

    public Uri getActivityStartCountUri() {
        return this.mActivityStartCountUri;
    }

    /* access modifiers changed from: package-private */
    public Uri getAppStartTimeUri() {
        return this.mAppStartTimeUri;
    }

    /* access modifiers changed from: package-private */
    public Uri getAppPausedUri() {
        return this.mAppEndUri;
    }

    /* access modifiers changed from: package-private */
    public Uri getAppEndDataUri() {
        return this.mAppEndDataUri;
    }

    public Uri getSessionTimeUri() {
        return this.mSessionTimeUri;
    }

    public Uri getLoginIdUri() {
        return this.mLoginIdUri;
    }

    public Uri getChannelPersistentUri() {
        return this.mChannelPersistentUri;
    }

    /* access modifiers changed from: package-private */
    public Uri getSubProcessUri() {
        return this.mSubProcessUri;
    }

    public Uri getFirstProcessUri() {
        return this.mFirstProcessUri;
    }

    public Uri getDataCollectUri() {
        return this.mDataCollectUri;
    }

    public Uri getDisableSDKUri() {
        return this.mDisableSDKUri;
    }

    public Uri getEnableSDKUri() {
        return this.mEnableSDKUri;
    }

    public Uri getRemoteConfigUri() {
        return this.mRemoteConfigUri;
    }
}
