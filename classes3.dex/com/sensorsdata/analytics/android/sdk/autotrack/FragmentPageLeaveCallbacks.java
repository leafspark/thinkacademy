package com.sensorsdata.analytics.android.sdk.autotrack;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.autotrack.utils.AutoTrackUtils;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentPageLeaveCallbacks implements SAFragmentLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String START_TIME = "sa_start_time";
    private final HashMap<Integer, JSONObject> mResumedFragments = new HashMap<>();

    public void onCreate(Object obj) {
    }

    public void onStart(Object obj) {
    }

    public void onStop(Object obj) {
    }

    public void onViewCreated(Object obj, View view, Bundle bundle) {
    }

    public void onResume(Object obj) {
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        }
    }

    public void onPause(Object obj) {
        try {
            if (this.mResumedFragments.containsKey(Integer.valueOf(obj.hashCode()))) {
                trackAppPageLeave(obj);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void onHiddenChanged(Object obj, boolean z) {
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    public void setUserVisibleHint(Object obj, boolean z) {
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    private void trackAppPageLeave(Object obj) {
        try {
            int hashCode = obj.hashCode();
            if (this.mResumedFragments.containsKey(Integer.valueOf(hashCode))) {
                JSONObject jSONObject = this.mResumedFragments.get(Integer.valueOf(hashCode));
                this.mResumedFragments.remove(Integer.valueOf(hashCode));
                if (jSONObject != null) {
                    trackPageLeaveEvent(jSONObject);
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private void trackFragmentStart(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(START_TIME, SystemClock.elapsedRealtime());
            String screenUrl = SensorsDataUtils.getScreenUrl(obj);
            jSONObject.put("$url", screenUrl);
            String lastScreenUrl = AutoTrackUtils.getLastScreenUrl();
            if (!TextUtils.isEmpty(lastScreenUrl)) {
                jSONObject.put("$referrer", lastScreenUrl);
            }
            AopUtil.getScreenNameAndTitleFromFragment(jSONObject, obj, (Activity) null);
            this.mResumedFragments.put(Integer.valueOf(obj.hashCode()), jSONObject);
            AutoTrackUtils.setLastScreenUrl(screenUrl);
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            Iterator<Integer> it = this.mResumedFragments.keySet().iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = this.mResumedFragments.get(Integer.valueOf(it.next().intValue()));
                if (jSONObject != null) {
                    trackPageLeaveEvent(jSONObject);
                    it.remove();
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private void trackPageLeaveEvent(JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(START_TIME);
            jSONObject.remove(START_TIME);
            double duration = TimeUtils.duration(optLong, SystemClock.elapsedRealtime());
            if (duration >= 0.05d) {
                jSONObject.put("event_duration", duration);
                SensorsDataAPI.sharedInstance().trackInternal("$AppPageLeave", jSONObject);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
