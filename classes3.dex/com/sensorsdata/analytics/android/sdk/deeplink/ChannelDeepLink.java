package com.sensorsdata.analytics.android.sdk.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelDeepLink extends AbsDeepLink {
    ChannelDeepLink(Intent intent) {
        super(intent);
    }

    public void parseDeepLink(Intent intent) {
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (data.isOpaque()) {
                SALog.d("ChannelDeepLink", data.toString() + " isOpaque");
                return;
            }
            Set<String> queryParameterNames = data.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                HashMap hashMap = new HashMap();
                for (String next : queryParameterNames) {
                    String queryParameter = data.getQueryParameter(next);
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = "";
                    }
                    hashMap.put(next, queryParameter);
                }
                ChannelUtils.parseParams(hashMap);
                if (this.mCallBack != null) {
                    this.mCallBack.onFinish(DeepLinkManager.DeepLinkType.CHANNEL, (String) null, true, 0);
                }
            }
        }
    }

    public void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            jSONObject.put("$deeplink_url", getDeepLinkUrl());
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
    }
}
