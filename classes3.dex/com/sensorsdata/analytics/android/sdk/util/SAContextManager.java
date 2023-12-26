package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SAContextManager {
    private boolean isAppStartSuccess;
    private String mAndroidId;
    private final Context mContext;
    private Map<String, Object> mDeviceInfo;
    private boolean mDisableTrackDeviceId;

    public SAContextManager(Context context, boolean z) {
        this.mContext = context;
        this.mDisableTrackDeviceId = z;
    }

    public Map<String, Object> getDeviceInfo() {
        try {
            if (this.mDeviceInfo == null && SensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
                setupDeviceInfo();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return this.mDeviceInfo;
    }

    public void addKeyIfExist(JSONObject jSONObject, String str) {
        try {
            if (this.mDeviceInfo == null && SensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
                setupDeviceInfo();
            }
            Map<String, Object> map = this.mDeviceInfo;
            if (map != null && map.containsKey(str)) {
                jSONObject.put(str, this.mDeviceInfo.get(str));
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public String getAndroidId() {
        if (TextUtils.isEmpty(this.mAndroidId) && SensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
            this.mAndroidId = SensorsDataUtils.getAndroidID(this.mContext);
        }
        return this.mAndroidId;
    }

    public JSONObject getPresetProperties() {
        JSONObject jSONObject = new JSONObject();
        String str = "$app_name";
        try {
            if (this.mDeviceInfo == null) {
                setupDeviceInfo();
            }
            jSONObject.put("$app_version", this.mDeviceInfo.get("$app_version"));
            jSONObject.put("$lib", "Android");
            jSONObject.put("$lib_version", this.mDeviceInfo.get("$lib_version"));
            jSONObject.put("$manufacturer", this.mDeviceInfo.get("$manufacturer"));
            jSONObject.put("$model", this.mDeviceInfo.get("$model"));
            jSONObject.put("$brand", this.mDeviceInfo.get("$brand"));
            jSONObject.put("$os", this.mDeviceInfo.get("$os"));
            jSONObject.put("$os_version", this.mDeviceInfo.get("$os_version"));
            jSONObject.put("$screen_height", this.mDeviceInfo.get("$screen_height"));
            jSONObject.put("$screen_width", this.mDeviceInfo.get("$screen_width"));
            String networkType = NetworkUtils.networkType(this.mContext);
            jSONObject.put("$wifi", "WIFI".equals(networkType));
            jSONObject.put("$network_type", networkType);
            jSONObject.put("$carrier", this.mDeviceInfo.get("$carrier"));
            jSONObject.put("$app_id", this.mDeviceInfo.get("$app_id"));
            jSONObject.put("$timezone_offset", this.mDeviceInfo.get("$timezone_offset"));
            if (this.mDeviceInfo.containsKey("$device_id")) {
                jSONObject.put("$device_id", this.mDeviceInfo.get("$device_id"));
            }
            String str2 = str;
            jSONObject.put(str2, this.mDeviceInfo.get(str2));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    private void setupDeviceInfo() {
        HashMap hashMap = new HashMap();
        String harmonyOSVersion = DeviceUtils.getHarmonyOSVersion();
        if (!TextUtils.isEmpty(harmonyOSVersion)) {
            hashMap.put("$os", "HarmonyOS");
            hashMap.put("$os_version", harmonyOSVersion);
        } else {
            hashMap.put("$os", "Android");
            hashMap.put("$os_version", DeviceUtils.getOS());
        }
        hashMap.put("$lib", "Android");
        hashMap.put("$lib_version", SensorsDataAPI.sharedInstance().getSDKVersion());
        hashMap.put("$manufacturer", DeviceUtils.getManufacturer());
        hashMap.put("$model", DeviceUtils.getModel());
        hashMap.put("$brand", DeviceUtils.getBrand());
        hashMap.put("$app_version", AppInfoUtils.getAppVersionName(this.mContext));
        int[] deviceSize = DeviceUtils.getDeviceSize(this.mContext);
        hashMap.put("$screen_width", Integer.valueOf(deviceSize[0]));
        hashMap.put("$screen_height", Integer.valueOf(deviceSize[1]));
        String carrier = SensorsDataUtils.getCarrier(this.mContext);
        if (!TextUtils.isEmpty(carrier)) {
            hashMap.put("$carrier", carrier);
        }
        String androidID = SensorsDataUtils.getAndroidID(this.mContext);
        this.mAndroidId = androidID;
        if (!this.mDisableTrackDeviceId && !TextUtils.isEmpty(androidID)) {
            hashMap.put("$device_id", this.mAndroidId);
        }
        Integer zoneOffset = TimeUtils.getZoneOffset();
        if (zoneOffset != null) {
            hashMap.put("$timezone_offset", zoneOffset);
        }
        hashMap.put("$app_id", AppInfoUtils.getProcessName(this.mContext));
        hashMap.put("$app_name", AppInfoUtils.getAppName(this.mContext));
        this.mDeviceInfo = Collections.unmodifiableMap(hashMap);
    }

    public boolean isAppStartSuccess() {
        return this.isAppStartSuccess;
    }

    public void setAppStartSuccess(boolean z) {
        this.isAppStartSuccess = z;
    }
}
