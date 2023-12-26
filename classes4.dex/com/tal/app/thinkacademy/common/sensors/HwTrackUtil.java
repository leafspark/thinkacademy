package com.tal.app.thinkacademy.common.sensors;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/sensors/HwTrackUtil;", "", "()V", "TAG", "", "setUserInfo", "", "track", "eventName", "jsonObject", "Lorg/json/JSONObject;", "trackTimerEnd", "properties", "trackTimerStart", "userLogin", "userLogout", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwTrackUtil.kt */
public final class HwTrackUtil {
    public static final HwTrackUtil INSTANCE = new HwTrackUtil();
    private static final String TAG = "HwTrackUtil";

    private HwTrackUtil() {
    }

    public final void track(String str) {
        track(str, (JSONObject) null);
    }

    public final void track(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                SensorsDataAPI.sharedInstance().track(str);
            } else {
                SensorsDataAPI.sharedInstance().track(str, jSONObject);
            }
        }
    }

    public final void trackTimerStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            SensorsDataAPI.sharedInstance().trackTimerStart(str);
        }
    }

    public final void trackTimerEnd(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                SensorsDataAPI.sharedInstance().trackTimerEnd(str);
            } else {
                SensorsDataAPI.sharedInstance().trackTimerEnd(str, jSONObject);
            }
        }
    }

    public final void userLogin() {
        SensorsProperty.Companion.getInstance().login();
    }

    public final void setUserInfo() {
        SensorsProperty.Companion.getInstance().profileSet();
    }

    public final void userLogout() {
        SensorsProperty.Companion.getInstance().logout();
    }
}
