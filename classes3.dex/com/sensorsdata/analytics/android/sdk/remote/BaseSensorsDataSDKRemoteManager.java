package com.sensorsdata.analytics.android.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseSensorsDataSDKRemoteManager {
    protected static final String TAG = "SA.SensorsDataSDKRemoteConfigBase";
    protected static SensorsDataSDKRemoteConfig mSDKRemoteConfig;
    protected Context mContext;
    protected boolean mDisableDefaultRemoteConfig;
    protected SAConfigOptions mSAConfigOptions = SensorsDataAPI.getConfigOptions();
    protected SensorsDataAPI mSensorsDataAPI;
    protected SensorsDataEncrypt mSensorsDataEncrypt;

    public enum RandomTimeType {
        RandomTimeTypeWrite,
        RandomTimeTypeClean,
        RandomTimeTypeNone
    }

    public abstract void applySDKConfigFromCache();

    public abstract void pullSDKConfigFromServer();

    public abstract void requestRemoteConfig(RandomTimeType randomTimeType, boolean z);

    public abstract void resetPullSDKConfigTimer();

    /* access modifiers changed from: protected */
    public abstract void setSDKRemoteConfig(SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig);

    protected BaseSensorsDataSDKRemoteManager(SensorsDataAPI sensorsDataAPI) {
        this.mSensorsDataAPI = sensorsDataAPI;
        this.mContext = sensorsDataAPI.getContext();
        this.mSensorsDataEncrypt = sensorsDataAPI.getSensorsDataEncrypt();
        this.mDisableDefaultRemoteConfig = sensorsDataAPI.isDisableDefaultRemoteConfig();
    }

    public boolean ignoreEvent(String str) {
        SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (!(sensorsDataSDKRemoteConfig == null || sensorsDataSDKRemoteConfig.getEventBlacklist() == null)) {
            try {
                int length = mSDKRemoteConfig.getEventBlacklist().length();
                for (int i = 0; i < length; i++) {
                    if (str.equals(mSDKRemoteConfig.getEventBlacklist().get(i))) {
                        SALog.i(TAG, "remote config: " + str + " is ignored by remote config");
                        return true;
                    }
                }
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public SensorsDataSDKRemoteConfig toSDKRemoteConfig(String str) {
        SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = new SensorsDataSDKRemoteConfig();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                sensorsDataSDKRemoteConfig.setOldVersion(jSONObject.optString("v"));
                String optString = jSONObject.optString("configs");
                SecreteKey secreteKey = new SecreteKey("", -1, "", "");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    sensorsDataSDKRemoteConfig.setDisableDebugMode(jSONObject2.optBoolean("disableDebugMode", false));
                    sensorsDataSDKRemoteConfig.setDisableSDK(jSONObject2.optBoolean("disableSDK", false));
                    sensorsDataSDKRemoteConfig.setAutoTrackMode(jSONObject2.optInt("autoTrackMode", -1));
                    sensorsDataSDKRemoteConfig.setEventBlacklist(jSONObject2.optJSONArray("event_blacklist"));
                    sensorsDataSDKRemoteConfig.setNewVersion(jSONObject2.optString("nv", ""));
                    sensorsDataSDKRemoteConfig.setEffectMode(jSONObject2.optInt("effect_mode", 0));
                    if (this.mSAConfigOptions.getEncryptors() != null && !this.mSAConfigOptions.getEncryptors().isEmpty()) {
                        JSONObject optJSONObject = jSONObject2.optJSONObject("key_v2");
                        if (optJSONObject != null) {
                            String[] split = optJSONObject.optString(ClassParamsKt.TYPE).split("\\+");
                            if (split.length == 2) {
                                String str2 = split[0];
                                String str3 = split[1];
                                for (SAEncryptListener sAEncryptListener : this.mSAConfigOptions.getEncryptors()) {
                                    if (str2.equals(sAEncryptListener.asymmetricEncryptType()) && str3.equals(sAEncryptListener.symmetricEncryptType())) {
                                        secreteKey.key = optJSONObject.optString("public_key");
                                        secreteKey.version = optJSONObject.optInt("pkv");
                                        secreteKey.asymmetricEncryptType = str2;
                                        secreteKey.symmetricEncryptType = str3;
                                    }
                                }
                            }
                        }
                        if (TextUtils.isEmpty(secreteKey.key)) {
                            parseSecreteKey(jSONObject2.optJSONObject("key"), secreteKey);
                        }
                        sensorsDataSDKRemoteConfig.setSecretKey(secreteKey);
                    }
                } else {
                    sensorsDataSDKRemoteConfig.setDisableDebugMode(false);
                    sensorsDataSDKRemoteConfig.setDisableSDK(false);
                    sensorsDataSDKRemoteConfig.setAutoTrackMode(-1);
                    sensorsDataSDKRemoteConfig.setSecretKey(secreteKey);
                    sensorsDataSDKRemoteConfig.setEventBlacklist(new JSONArray());
                    sensorsDataSDKRemoteConfig.setNewVersion("");
                    sensorsDataSDKRemoteConfig.setEffectMode(0);
                }
                return sensorsDataSDKRemoteConfig;
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return sensorsDataSDKRemoteConfig;
    }

    private void parseSecreteKey(JSONObject jSONObject, SecreteKey secreteKey) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("key_ec") && SensorsDataEncrypt.isECEncrypt()) {
                    String optString = jSONObject.optString("key_ec");
                    if (!TextUtils.isEmpty(optString)) {
                        jSONObject = new JSONObject(optString);
                    }
                }
                secreteKey.key = jSONObject.optString("public_key");
                secreteKey.symmetricEncryptType = "AES";
                if (jSONObject.has(ClassParamsKt.TYPE)) {
                    String optString2 = jSONObject.optString(ClassParamsKt.TYPE);
                    secreteKey.key = optString2 + ":" + secreteKey.key;
                    secreteKey.asymmetricEncryptType = optString2;
                } else {
                    secreteKey.asymmetricEncryptType = "RSA";
                }
                secreteKey.version = jSONObject.optInt("pkv");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public Boolean isAutoTrackEventTypeIgnored(int i) {
        SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig == null || sensorsDataSDKRemoteConfig.getAutoTrackMode() == -1) {
            return null;
        }
        if (mSDKRemoteConfig.getAutoTrackMode() == 0) {
            return true;
        }
        return Boolean.valueOf(mSDKRemoteConfig.isAutoTrackEventTypeIgnored(i));
    }

    public static boolean isSDKDisabledByRemote() {
        SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig == null) {
            return false;
        }
        return sensorsDataSDKRemoteConfig.isDisableSDK();
    }

    public Boolean isAutoTrackEnabled() {
        SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
        if (sensorsDataSDKRemoteConfig == null) {
            return null;
        }
        if (sensorsDataSDKRemoteConfig.getAutoTrackMode() != 0) {
            return mSDKRemoteConfig.getAutoTrackMode() > 0 ? true : null;
        }
        SALog.i(TAG, "remote config: AutoTrackMode is closing by remote config");
        return false;
    }

    /* access modifiers changed from: protected */
    public String buildRemoteUrl(boolean z) {
        String str;
        SensorsDataEncrypt sensorsDataEncrypt;
        String str2;
        String serverUrl = this.mSensorsDataAPI.getServerUrl();
        SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
        String str3 = null;
        String str4 = sAConfigOptions != null ? sAConfigOptions.mRemoteConfigUrl : null;
        if (!TextUtils.isEmpty(str4) && Patterns.WEB_URL.matcher(str4).matches()) {
            SALog.i(TAG, "SAConfigOptions remote url is " + str4);
        } else if (TextUtils.isEmpty(serverUrl) || !Patterns.WEB_URL.matcher(serverUrl).matches()) {
            SALog.i(TAG, String.format(Locale.CHINA, "ServerUlr: %s, SAConfigOptions remote url: %s", new Object[]{serverUrl, str4}));
            SALog.i(TAG, "Remote config url verification failed");
            return null;
        } else {
            int lastIndexOf = serverUrl.lastIndexOf("/");
            if (lastIndexOf != -1) {
                str2 = serverUrl.substring(0, lastIndexOf) + "/config/Android.conf";
            } else {
                str2 = null;
            }
            SALog.i(TAG, "SensorsDataAPI remote url is " + str4);
        }
        if (z && (SensorsDataUtils.checkVersionIsNew(this.mContext, this.mSensorsDataAPI.getSDKVersion()) || ((sensorsDataEncrypt = this.mSensorsDataEncrypt) != null && sensorsDataEncrypt.isPublicSecretKeyNull()))) {
            z = false;
        }
        Uri parse = Uri.parse(str4);
        Uri.Builder buildUpon = parse.buildUpon();
        if (!TextUtils.isEmpty(str4) && z) {
            SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig = mSDKRemoteConfig;
            if (sensorsDataSDKRemoteConfig != null) {
                str3 = sensorsDataSDKRemoteConfig.getOldVersion();
                str = sensorsDataSDKRemoteConfig.getNewVersion();
                SALog.i(TAG, "The current config: " + sensorsDataSDKRemoteConfig.toString());
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str3) && TextUtils.isEmpty(parse.getQueryParameter("v"))) {
                buildUpon.appendQueryParameter("v", str3);
            }
            if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(parse.getQueryParameter("nv"))) {
                buildUpon.appendQueryParameter("nv", str);
            }
        }
        if (!TextUtils.isEmpty(serverUrl) && TextUtils.isEmpty(parse.getQueryParameter("project"))) {
            String queryParameter = Uri.parse(serverUrl).getQueryParameter("project");
            if (!TextUtils.isEmpty(queryParameter)) {
                buildUpon.appendQueryParameter("project", queryParameter);
            }
        }
        if (TextUtils.isEmpty(parse.getQueryParameter("app_id"))) {
            buildUpon.appendQueryParameter("app_id", AppInfoUtils.getProcessName(this.mContext));
        }
        buildUpon.build();
        String builder = buildUpon.toString();
        SALog.i(TAG, "Android remote config url is " + builder);
        return builder;
    }

    /* access modifiers changed from: protected */
    public void requestRemoteConfig(boolean z, HttpCallback.StringCallback stringCallback) {
        try {
            String buildRemoteUrl = buildRemoteUrl(z);
            if (!TextUtils.isEmpty(buildRemoteUrl)) {
                new RequestHelper.Builder(HttpMethod.GET, buildRemoteUrl).callback(stringCallback).execute();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
