package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import org.json.JSONException;
import org.json.JSONObject;

public class DbAdapter {
    private static DbAdapter instance;
    private final DbParams mDbParams;
    private DataOperation mPersistentOperation;
    private DataOperation mTrackEventOperation;

    private DbAdapter(Context context, String str, SensorsDataEncrypt sensorsDataEncrypt) {
        this.mDbParams = DbParams.getInstance(str);
        if (sensorsDataEncrypt != null) {
            this.mTrackEventOperation = new EncryptDataOperation(context.getApplicationContext(), sensorsDataEncrypt);
        } else {
            this.mTrackEventOperation = new EventDataOperation(context.getApplicationContext());
        }
        this.mPersistentOperation = new PersistentDataOperation(context.getApplicationContext());
    }

    public static DbAdapter getInstance(Context context, String str, SensorsDataEncrypt sensorsDataEncrypt) {
        if (instance == null) {
            instance = new DbAdapter(context, str, sensorsDataEncrypt);
        }
        return instance;
    }

    public static DbAdapter getInstance() {
        DbAdapter dbAdapter = instance;
        if (dbAdapter != null) {
            return dbAdapter;
        }
        throw new IllegalStateException("The static method getInstance(Context context, String packageName) should be called before calling getInstance()");
    }

    public int addJSON(JSONObject jSONObject) {
        int insertData = this.mTrackEventOperation.insertData(this.mDbParams.getEventUri(), jSONObject);
        return insertData == 0 ? this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri()) : insertData;
    }

    public void deleteAllEvents() {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), "DB_DELETE_ALL");
    }

    public int cleanupEvents(String str) {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), str);
        return this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri());
    }

    public void commitActivityCount(int i) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getActivityStartCountUri(), new JSONObject().put("value", i));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public int getActivityCount() {
        String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getActivityStartCountUri(), 1);
        if (queryData == null || queryData.length <= 0) {
            return 0;
        }
        return Integer.parseInt(queryData[0]);
    }

    public void commitAppStartTime(long j) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppStartTimeUri(), new JSONObject().put("value", j));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public long getAppStartTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppStartTimeUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return 0;
            }
            return Long.parseLong(queryData[0]);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return 0;
        }
    }

    public void commitAppEndTime(long j) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppPausedUri(), new JSONObject().put("value", j));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public long getAppEndTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppPausedUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return 0;
            }
            return Long.parseLong(queryData[0]);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return 0;
        }
    }

    public void commitAppEndData(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppEndDataUri(), new JSONObject().put("value", str));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public String getAppEndData() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppEndDataUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public void commitLoginId(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdUri(), new JSONObject().put("value", str));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public String getLoginId() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public void commitSessionIntervalTime(int i) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSessionTimeUri(), new JSONObject().put("value", i));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public int getSessionIntervalTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSessionTimeUri(), 1);
            if (queryData != null && queryData.length > 0) {
                return Integer.parseInt(queryData[0]);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return 0;
    }

    public boolean isFirstChannelEvent(String str) {
        try {
            return this.mTrackEventOperation.queryDataCount(this.mDbParams.getChannelPersistentUri(), (String[]) null, "event_name = ? ", new String[]{str}, (String) null) <= 0;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    public void addChannelEvent(String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbParams.KEY_CHANNEL_EVENT_NAME, str);
            contentValues.put(DbParams.KEY_CHANNEL_RESULT, true);
            this.mTrackEventOperation.insertData(this.mDbParams.getChannelPersistentUri(), contentValues);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void commitSubProcessFlushState(boolean z) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSubProcessUri(), new JSONObject().put("value", z));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public boolean isSubProcessFlushing() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSubProcessUri(), 1);
            if (queryData == null || queryData.length <= 0 || Integer.parseInt(queryData[0]) == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return true;
    }

    public void commitFirstProcessState(boolean z) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getFirstProcessUri(), new JSONObject().put("value", z));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public boolean isFirstProcess() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getFirstProcessUri(), 1);
            if (queryData == null || queryData.length <= 0 || Integer.parseInt(queryData[0]) == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return true;
    }

    public void commitRemoteConfig(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getRemoteConfigUri(), new JSONObject().put("value", str));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public String getRemoteConfig() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getRemoteConfigUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public String[] generateDataString(String str, int i) {
        try {
            return this.mTrackEventOperation.queryData(this.mDbParams.getEventUri(), i);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }
}
