package com.sensorsdata.analytics.android.sdk.deeplink;

import android.content.Intent;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.ServerUrl;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class SensorsDataDeepLink extends AbsDeepLink {
    /* access modifiers changed from: private */
    public String errorMsg;
    /* access modifiers changed from: private */
    public String pageParams;
    private String project;
    private String serverUrl;
    /* access modifiers changed from: private */
    public boolean success;

    public SensorsDataDeepLink(Intent intent, String str) {
        super(intent);
        this.serverUrl = str;
        this.project = new ServerUrl(str).getProject();
    }

    public void parseDeepLink(Intent intent) {
        if (intent != null && intent.getData() != null) {
            String lastPathSegment = intent.getData().getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment)) {
                final long currentTimeMillis = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put("key", lastPathSegment);
                hashMap.put("system_type", "ANDROID");
                hashMap.put("project", this.project);
                new RequestHelper.Builder(HttpMethod.GET, getRequestUrl()).params(hashMap).callback(new HttpCallback.JsonCallback() {
                    public void onFailure(int i, String str) {
                        String unused = SensorsDataDeepLink.this.errorMsg = str;
                        boolean unused2 = SensorsDataDeepLink.this.success = false;
                    }

                    public void onResponse(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            boolean unused = SensorsDataDeepLink.this.success = true;
                            ChannelUtils.parseParams(JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
                            String unused2 = SensorsDataDeepLink.this.pageParams = jSONObject.optString("page_params");
                            String unused3 = SensorsDataDeepLink.this.errorMsg = jSONObject.optString("errorMsg");
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                boolean unused4 = SensorsDataDeepLink.this.success = false;
                                return;
                            }
                            return;
                        }
                        boolean unused5 = SensorsDataDeepLink.this.success = false;
                    }

                    public void onAfter() {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.pageParams)) {
                                jSONObject.put("$deeplink_options", SensorsDataDeepLink.this.pageParams);
                            }
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                jSONObject.put("$deeplink_match_fail_reason", SensorsDataDeepLink.this.errorMsg);
                            }
                            jSONObject.put("$deeplink_url", SensorsDataDeepLink.this.getDeepLinkUrl());
                            jSONObject.put("$event_duration", String.format(Locale.CHINA, "%.3f", new Object[]{Float.valueOf(((float) currentTimeMillis) / 1000.0f)}));
                        } catch (JSONException e) {
                            SALog.printStackTrace(e);
                        }
                        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
                        if (SensorsDataDeepLink.this.mCallBack != null) {
                            SensorsDataDeepLink.this.mCallBack.onFinish(DeepLinkManager.DeepLinkType.SENSORSDATA, SensorsDataDeepLink.this.pageParams, SensorsDataDeepLink.this.success, currentTimeMillis);
                        }
                        SensorsDataAPI.sharedInstance().trackInternal("$AppDeeplinkMatchedResult", jSONObject);
                    }
                }).execute();
            }
        }
    }

    public void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            jSONObject.put("$deeplink_url", getDeepLinkUrl());
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public String getRequestUrl() {
        int lastIndexOf;
        if (TextUtils.isEmpty(this.serverUrl) || (lastIndexOf = this.serverUrl.lastIndexOf("/")) == -1) {
            return "";
        }
        return this.serverUrl.substring(0, lastIndexOf) + "/sdk/deeplink/param";
    }
}
