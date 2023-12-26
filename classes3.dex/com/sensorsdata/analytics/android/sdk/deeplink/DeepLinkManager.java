package com.sensorsdata.analytics.android.sdk.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.ServerUrl;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.OaidHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.Date;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepLinkManager {
    public static final String IS_ANALYTICS_DEEPLINK = "is_analytics_deeplink";
    private static DeepLinkProcessor mDeepLinkProcessor;

    public enum DeepLinkType {
        CHANNEL,
        SENSORSDATA
    }

    public interface OnDeepLinkParseFinishCallback {
        void onFinish(DeepLinkType deepLinkType, String str, boolean z, long j);
    }

    private static boolean isDeepLink(Intent intent) {
        return Build.VERSION.SDK_INT >= 11 && intent != null && "android.intent.action.VIEW".equals(intent.getAction());
    }

    private static boolean isUtmDeepLink(Intent intent) {
        if (isDeepLink(intent) && intent.getData() != null) {
            Uri data = intent.getData();
            if (data.isOpaque()) {
                SALog.d("ChannelDeepLink", data.toString() + " isOpaque");
                return false;
            }
            Set<String> queryParameterNames = data.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                return ChannelUtils.hasLinkUtmProperties(queryParameterNames);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r3 = r3.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isSensorsDataDeepLink(android.content.Intent r3, java.lang.String r4) {
        /*
            boolean r0 = isDeepLink(r3)
            r1 = 0
            if (r0 == 0) goto L_0x004b
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x004b
            android.net.Uri r0 = r3.getData()
            if (r0 != 0) goto L_0x0014
            goto L_0x004b
        L_0x0014:
            android.net.Uri r3 = r3.getData()
            java.util.List r0 = r3.getPathSegments()
            if (r0 == 0) goto L_0x004b
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x004b
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "sd"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x004b
            java.lang.String r3 = r3.getHost()
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x004b
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x004a
            java.lang.String r4 = "sensorsdata"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x004b
        L_0x004a:
            r1 = 1
        L_0x004b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.deeplink.DeepLinkManager.isSensorsDataDeepLink(android.content.Intent, java.lang.String):boolean");
    }

    private static DeepLinkProcessor createDeepLink(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        if (isSensorsDataDeepLink(intent, new ServerUrl(str).getHost())) {
            return new SensorsDataDeepLink(intent, str);
        }
        if (isUtmDeepLink(intent)) {
            return new ChannelDeepLink(intent);
        }
        return null;
    }

    private static void trackDeepLinkLaunchEvent(final Context context, DeepLinkProcessor deepLinkProcessor) {
        final JSONObject jSONObject = new JSONObject();
        final SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
        final boolean z = (deepLinkProcessor instanceof SensorsDataDeepLink) && sharedInstance.isDeepLinkInstallSource();
        try {
            jSONObject.put("$deeplink_url", deepLinkProcessor.getDeepLinkUrl());
            jSONObject.put("$time", new Date(System.currentTimeMillis()));
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
        SensorsDataUtils.mergeJSONObject(ChannelUtils.getLatestUtmProperties(), jSONObject);
        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
        sharedInstance.transformTaskQueue(new Runnable() {
            public void run() {
                if (z) {
                    try {
                        JSONObject jSONObject = jSONObject;
                        Context context = context;
                        jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(context, SensorsDataUtils.getAndroidID(context), OaidHelper.getOAID(context)));
                    } catch (JSONException e) {
                        SALog.printStackTrace(e);
                    }
                }
                sharedInstance.trackInternal("$AppDeeplinkLaunch", jSONObject);
            }
        });
    }

    public static boolean parseDeepLink(final Activity activity, final boolean z, final SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        try {
            Intent intent = activity.getIntent();
            DeepLinkProcessor createDeepLink = createDeepLink(intent, SensorsDataAPI.sharedInstance().getServerUrl());
            mDeepLinkProcessor = createDeepLink;
            if (createDeepLink == null) {
                return false;
            }
            ChannelUtils.clearUtm(activity.getApplicationContext());
            mDeepLinkProcessor.setDeepLinkParseFinishCallback(new OnDeepLinkParseFinishCallback() {
                public void onFinish(DeepLinkType deepLinkType, String str, boolean z, long j) {
                    if (z) {
                        ChannelUtils.saveDeepLinkInfo(activity.getApplicationContext());
                    }
                    if (sensorsDataDeepLinkCallback != null && deepLinkType == DeepLinkType.SENSORSDATA) {
                        sensorsDataDeepLinkCallback.onReceive(str, z, j);
                    }
                }
            });
            mDeepLinkProcessor.parseDeepLink(intent);
            trackDeepLinkLaunchEvent(activity.getApplicationContext(), mDeepLinkProcessor);
            return true;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    public static void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            DeepLinkProcessor deepLinkProcessor = mDeepLinkProcessor;
            if (deepLinkProcessor != null) {
                deepLinkProcessor.mergeDeepLinkProperty(jSONObject);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void resetDeepLinkProcessor() {
        mDeepLinkProcessor = null;
    }
}
