package com.sensorsdata.analytics.android.sdk.remote;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import org.json.JSONArray;
import org.json.JSONObject;

public class SensorsDataSDKRemoteConfig {
    static final int REMOTE_EVENT_TYPE_NO_USE = -1;
    private int autoTrackMode = -1;
    private boolean disableDebugMode = false;
    private boolean disableSDK = false;
    private int effectMode;
    private JSONArray eventBlacklist;
    private int mAutoTrackEventType;
    private SecreteKey mSecretKey;
    private String newVersion;
    private String oldVersion;

    /* access modifiers changed from: package-private */
    public String getOldVersion() {
        return this.oldVersion;
    }

    public void setOldVersion(String str) {
        this.oldVersion = str;
    }

    /* access modifiers changed from: package-private */
    public boolean isDisableDebugMode() {
        return this.disableDebugMode;
    }

    public void setDisableDebugMode(boolean z) {
        this.disableDebugMode = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isDisableSDK() {
        return this.disableSDK;
    }

    public void setDisableSDK(boolean z) {
        this.disableSDK = z;
    }

    public SecreteKey getSecretKey() {
        return this.mSecretKey;
    }

    public void setSecretKey(SecreteKey secreteKey) {
        this.mSecretKey = secreteKey;
    }

    /* access modifiers changed from: package-private */
    public int getAutoTrackMode() {
        return this.autoTrackMode;
    }

    public void setAutoTrackMode(int i) {
        this.autoTrackMode = i;
        if (i == -1 || i == 0) {
            this.mAutoTrackEventType = 0;
            return;
        }
        if ((i & 1) == 1) {
            this.mAutoTrackEventType |= 1;
        }
        if ((i & 2) == 2) {
            this.mAutoTrackEventType |= 2;
        }
        if ((i & 4) == 4) {
            this.mAutoTrackEventType |= 4;
        }
        if ((i & 8) == 8) {
            this.mAutoTrackEventType |= 8;
        }
    }

    /* access modifiers changed from: package-private */
    public int getAutoTrackEventType() {
        return this.mAutoTrackEventType;
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoTrackEventTypeIgnored(int i) {
        int i2 = this.autoTrackMode;
        if (i2 == -1) {
            return false;
        }
        if (i2 == 0) {
            return true;
        }
        int i3 = this.mAutoTrackEventType;
        if ((i | i3) != i3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v", this.oldVersion);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disableDebugMode", this.disableDebugMode);
            jSONObject2.put("autoTrackMode", this.autoTrackMode);
            jSONObject2.put("disableSDK", this.disableSDK);
            jSONObject2.put("event_blacklist", this.eventBlacklist);
            jSONObject2.put("nv", this.newVersion);
            jSONObject2.put("effect_mode", this.effectMode);
            jSONObject.put("configs", jSONObject2);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public String toString() {
        return "{ v=" + this.oldVersion + ", disableDebugMode=" + this.disableDebugMode + ", disableSDK=" + this.disableSDK + ", autoTrackMode=" + this.autoTrackMode + ", event_blacklist=" + this.eventBlacklist + ", nv=" + this.newVersion + ", effect_mode=" + this.effectMode + "}";
    }

    public JSONArray getEventBlacklist() {
        return this.eventBlacklist;
    }

    public void setEventBlacklist(JSONArray jSONArray) {
        this.eventBlacklist = jSONArray;
    }

    public String getNewVersion() {
        return this.newVersion;
    }

    public void setNewVersion(String str) {
        this.newVersion = str;
    }

    public void setEffectMode(int i) {
        this.effectMode = i;
    }

    public int getEffectMode() {
        return this.effectMode;
    }
}
