package com.sensorsdata.analytics.android.sdk.internal.rpc;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

public class SensorsDataContentObserver extends ContentObserver {
    public static boolean isDisableFromObserver = false;
    public static boolean isEnableFromObserver = false;
    public static boolean isLoginFromObserver = false;

    public SensorsDataContentObserver() {
        super(new Handler(Looper.getMainLooper()));
    }

    public void onChange(boolean z, Uri uri) {
        try {
            if (DbParams.getInstance().getDataCollectUri().equals(uri)) {
                SensorsDataAPI.sharedInstance().enableDataCollect();
            } else if (DbParams.getInstance().getSessionTimeUri().equals(uri)) {
                SensorsDataAPI.sharedInstance().setSessionIntervalTime(DbAdapter.getInstance().getSessionIntervalTime());
            } else if (DbParams.getInstance().getLoginIdUri().equals(uri)) {
                String loginId = DbAdapter.getInstance().getLoginId();
                if (TextUtils.isEmpty(loginId)) {
                    SensorsDataAPI.sharedInstance().logout();
                    return;
                }
                isLoginFromObserver = true;
                SensorsDataAPI.sharedInstance().login(loginId);
            } else if (DbParams.getInstance().getDisableSDKUri().equals(uri)) {
                if (!SensorsDataAPI.getConfigOptions().isDisableSDK()) {
                    isDisableFromObserver = true;
                    SensorsDataAPI.disableSDK();
                }
            } else if (DbParams.getInstance().getEnableSDKUri().equals(uri) && SensorsDataAPI.getConfigOptions().isDisableSDK()) {
                isEnableFromObserver = true;
                SensorsDataAPI.enableSDK();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
