package com.sensorsdata.analytics.android.sdk.visual.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.HashMap;
import org.json.JSONObject;

public class PairingCodeRequestHelper {
    private static final String TAG = "SA.ParingCodeHttpRequest";
    private static final String URL_VERIFY_SUFFIX = "api/sdk/heat_maps/scanning/pairing_code";

    public interface IApiCallback {
        void onFailure(String str);

        void onSuccess();
    }

    public void verifyPairingCodeRequest(final Context context, String str, final IApiCallback iApiCallback) {
        try {
            if (TextUtils.isEmpty(SensorsDataAPI.sharedInstance().getServerUrl())) {
                SALog.i(TAG, "verifyParingCodeRequest | server url is null and return");
                return;
            }
            Uri parse = Uri.parse(SensorsDataAPI.sharedInstance().getServerUrl());
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(parse.getScheme()).encodedAuthority(parse.getAuthority());
            HashMap hashMap = new HashMap();
            hashMap.put("pairing_code", str);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sensorsdata-project", parse.getQueryParameter("project"));
            new RequestHelper.Builder(HttpMethod.GET, builder.appendEncodedPath(URL_VERIFY_SUFFIX).toString()).params(hashMap).header(hashMap2).callback(new HttpCallback.JsonCallback() {
                public void onAfter() {
                }

                public void onFailure(int i, String str) {
                    IApiCallback iApiCallback = iApiCallback;
                    if (iApiCallback != null) {
                        iApiCallback.onFailure(str);
                    }
                }

                public void onResponse(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        SALog.i(PairingCodeRequestHelper.TAG, "verifyParingCodeRequest onResponse | response: " + jSONObject.toString());
                        if (jSONObject.optBoolean("is_success")) {
                            String optString = jSONObject.optString("url");
                            SALog.i(PairingCodeRequestHelper.TAG, "verifyParingCodeRequest onResponse | url: " + optString);
                            if (!TextUtils.isEmpty(optString)) {
                                SensorsDataUtils.handleSchemeUrl((Activity) context, new Intent().setData(Uri.parse(optString)));
                            }
                            IApiCallback iApiCallback = iApiCallback;
                            if (iApiCallback != null) {
                                iApiCallback.onSuccess();
                                return;
                            }
                            return;
                        }
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onFailure(jSONObject.optString("error_msg"));
                        }
                    }
                }
            }).execute();
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
