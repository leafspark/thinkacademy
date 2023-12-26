package com.sensorsdata.analytics.android.sdk.aop.push;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import java.util.Date;
import org.json.JSONObject;

public class PushAutoTrackHelper {
    private static final String TAG = "SA.PushAutoTrackHelper";
    private static long lastPushClickTime;

    public static void trackJPushOpenActivity(Intent intent) {
        if (intent != null && isTrackPushEnabled()) {
            JSONObject jSONObject = null;
            String uri = intent.getData() != null ? intent.getData().toString() : null;
            if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
                uri = intent.getExtras().getString("JMessageExtra");
            }
            SALog.i(TAG, "trackJPushOpenActivity is called, Intent data is " + uri);
            if (!TextUtils.isEmpty(uri)) {
                try {
                    jSONObject = new JSONObject(uri);
                } catch (Exception unused) {
                    try {
                        SALog.i(TAG, "Failed to construct JSON");
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                        return;
                    }
                }
                if (jSONObject != null) {
                    String optString = jSONObject.optString("n_title");
                    String optString2 = jSONObject.optString("n_content");
                    String optString3 = jSONObject.optString("n_extras");
                    String jPushSDKName = PushUtils.getJPushSDKName((byte) jSONObject.optInt("rom_type"));
                    SALog.i(TAG, String.format("trackJPushOpenActivity is called, title is %s, content is %s, extras is %s, appPushChannel is %s", new Object[]{optString, optString2, optString3, jPushSDKName}));
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if (!TextUtils.isEmpty(jPushSDKName)) {
                            trackNotificationOpenedEvent(getSFData(optString3), optString, optString2, "JPush", jPushSDKName);
                        }
                    }
                }
            }
        }
    }

    public static void trackNotificationOpenedEvent(String str, String str2, String str3, String str4, String str5) {
        trackNotificationOpenedEvent(str, str2, str3, str4, str5, 0);
    }

    private static void trackNotificationOpenedEvent(String str, String str2, String str3, String str4, String str5, long j) {
        try {
            if (isRepeatEvent()) {
                SALog.i(TAG, String.format("$AppPushClick Repeat trigger, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", new Object[]{str2, str3, str, str5, str4}));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("$app_push_msg_title", str2);
            jSONObject.put("$app_push_msg_content", str3);
            jSONObject.put("$app_push_service_name", str4);
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("$app_push_channel", str5.toUpperCase());
            }
            JSONObject jSONObject2 = null;
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        SALog.i(TAG, "sfData is " + str);
                        jSONObject2 = new JSONObject(str);
                    } catch (Exception unused) {
                        SALog.i(TAG, "Failed to construct JSON");
                    }
                }
                if (jSONObject2 != null && jSONObject2.has("sf_plan_id")) {
                    jSONObject.put("$sf_msg_title", str2);
                    jSONObject.put("$sf_msg_content", str3);
                    jSONObject.put("$sf_msg_id", jSONObject2.opt("sf_msg_id"));
                    jSONObject.put("$sf_plan_id", jSONObject2.opt("sf_plan_id"));
                    jSONObject.put("$sf_audience_id", jSONObject2.opt("sf_audience_id"));
                    jSONObject.put("$sf_link_url", jSONObject2.opt("sf_link_url"));
                    jSONObject.put("$sf_plan_strategy_id", jSONObject2.opt("sf_plan_strategy_id"));
                    jSONObject.put("$sf_plan_type", jSONObject2.opt("sf_plan_type"));
                    jSONObject.put("$sf_strategy_unit_id", jSONObject2.opt("sf_strategy_unit_id"));
                    jSONObject.put("$sf_enter_plan_time", jSONObject2.opt("sf_enter_plan_time"));
                    jSONObject.put("$sf_channel_id", jSONObject2.opt("sf_channel_id"));
                    jSONObject.put("$sf_channel_category", jSONObject2.opt("sf_channel_category"));
                    jSONObject.put("$sf_channel_service_name", jSONObject2.opt("sf_channel_service_name"));
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
            if (j > 0) {
                try {
                    jSONObject.put("$time", new Date(j));
                } catch (Exception e2) {
                    SALog.printStackTrace(e2);
                }
            }
            SensorsDataAPI.sharedInstance().track("$AppPushClick", jSONObject);
        } catch (Exception e3) {
            SALog.printStackTrace(e3);
        }
    }

    public static void trackGeTuiNotificationClicked(String str, String str2, String str3, long j) {
        trackNotificationOpenedEvent(str3, str, str2, "GeTui", (String) null, j);
    }

    private static boolean isRepeatEvent() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        SALog.i(TAG, "currentTime: " + elapsedRealtime + ",lastPushClickTime: " + lastPushClickTime);
        if (elapsedRealtime - lastPushClickTime <= 2000) {
            return true;
        }
        lastPushClickTime = elapsedRealtime;
        return false;
    }

    public static void trackJPushAppOpenNotification(String str, String str2, String str3, String str4) {
        if (isTrackPushEnabled()) {
            SALog.i(TAG, String.format("trackJPushAppOpenNotification is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", new Object[]{str2, str3, str, str4, "JPush"}));
            trackNotificationOpenedEvent(getSFData(str), str2, str3, "JPush", str4);
        }
    }

    public static void trackMeizuAppOpenNotification(String str, String str2, String str3, String str4) {
        JSONObject optJSONObject;
        if (isTrackPushEnabled()) {
            SALog.i(TAG, String.format("trackMeizuAppOpenNotification is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", new Object[]{str2, str3, str, "Meizu", str4}));
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                try {
                    SALog.i(TAG, "Failed to construct JSON");
                } catch (Exception e) {
                    try {
                        SALog.printStackTrace(e);
                    } catch (Exception e2) {
                        SALog.printStackTrace(e2);
                        return;
                    }
                }
            }
            if (jSONObject != null && jSONObject.has("JMessageExtra")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("JMessageExtra");
                if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("m_content")) == null)) {
                    str = optJSONObject.optString("n_extras");
                }
                str4 = "JPush";
            }
            trackNotificationOpenedEvent(getSFData(str), str2, str3, str4, "Meizu");
        }
    }

    public static void onGeTuiNotificationClicked(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "gtNotificationMessage is null");
        } else if (isTrackPushEnabled()) {
            try {
                String str = (String) ReflectUtil.callMethod(obj, "getMessageId", new Object[0]);
                String str2 = (String) ReflectUtil.callMethod(obj, "getTitle", new Object[0]);
                String str3 = (String) ReflectUtil.callMethod(obj, "getContent", new Object[0]);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    PushProcess.getInstance().trackGTClickDelayed(str, str2, str3);
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void onGeTuiReceiveMessageData(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "gtNotificationMessage is null");
        } else if (isTrackPushEnabled()) {
            try {
                byte[] bArr = (byte[]) ReflectUtil.callMethod(obj, "getPayload", new Object[0]);
                String str = (String) ReflectUtil.callMethod(obj, "getMessageId", new Object[0]);
                if (bArr != null && !TextUtils.isEmpty(str)) {
                    PushProcess.getInstance().trackReceiveMessageData(new String(bArr), str);
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void onUMengNotificationClick(Object obj) {
        if (obj == null) {
            SALog.i(TAG, "UMessage is null");
        } else if (isTrackPushEnabled()) {
            try {
                JSONObject jSONObject = (JSONObject) ReflectUtil.callMethod(obj, "getRaw", new Object[0]);
                if (jSONObject == null) {
                    SALog.i(TAG, "onUMengNotificationClick:raw is null");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("body");
                if (optJSONObject != null) {
                    String optString = jSONObject.optString("extra");
                    String optString2 = optJSONObject.optString("title");
                    String optString3 = optJSONObject.optString("text");
                    trackNotificationOpenedEvent(getSFData(optString), optString2, optString3, "UMeng", (String) null);
                    SALog.i(TAG, String.format("onUMengNotificationClick is called, title is %s, content is %s, extras is %s", new Object[]{optString2, optString3, optString}));
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r3 = new org.json.JSONObject(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onUMengActivityMessage(android.content.Intent r6) {
        /*
            java.lang.String r0 = "body"
            java.lang.String r1 = "SA.PushAutoTrackHelper"
            if (r6 != 0) goto L_0x000c
            java.lang.String r6 = "intent is null"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r6)
            return
        L_0x000c:
            boolean r2 = isTrackPushEnabled()
            if (r2 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r2 = r6.getStringExtra(r0)     // Catch:{ Exception -> 0x005f }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x005f }
            if (r3 != 0) goto L_0x0063
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x005f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x005f }
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x0063
            java.lang.String r2 = "extra"
            java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "title"
            java.lang.String r3 = r0.optString(r3)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "text"
            java.lang.String r0 = r0.optString(r4)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "message_source"
            java.lang.String r6 = r6.getStringExtra(r4)     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = getSFData(r2)     // Catch:{ Exception -> 0x005f }
            java.lang.String r5 = "UMeng"
            trackNotificationOpenedEvent(r4, r3, r0, r5, r6)     // Catch:{ Exception -> 0x005f }
            java.lang.String r6 = "onUMengActivityMessage is called, title is %s, content is %s, extras is %s"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x005f }
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x005f }
            r3 = 1
            r4[r3] = r0     // Catch:{ Exception -> 0x005f }
            r0 = 2
            r4[r0] = r2     // Catch:{ Exception -> 0x005f }
            java.lang.String r6 = java.lang.String.format(r6, r4)     // Catch:{ Exception -> 0x005f }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r6 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r6)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onUMengActivityMessage(android.content.Intent):void");
    }

    public static void onNotify(NotificationManager notificationManager, String str, int i, Notification notification) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().onNotify(str, i, notification);
                SALog.i(TAG, "onNotify");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void onNotify(NotificationManager notificationManager, int i, Notification notification) {
        if (isTrackPushEnabled()) {
            try {
                onNotify(notificationManager, (String) null, i, notification);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void onNewIntent(Object obj, Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                if (obj instanceof Activity) {
                    PushProcess.getInstance().onNotificationClick((Activity) obj, intent);
                    SALog.i(TAG, "onNewIntent");
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void hookPendingIntentGetActivityBundle(PendingIntent pendingIntent, Context context, int i, Intent intent, int i2, Bundle bundle) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookIntentGetActivity(Context context, int i, Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookIntentGetActivityBundle(Context context, int i, Intent intent, int i2, Bundle bundle) {
        hookIntent(intent);
    }

    public static void hookPendingIntentGetActivity(PendingIntent pendingIntent, Context context, int i, Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void onBroadcastReceiver(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        onBroadcastServiceIntent(intent);
    }

    public static void onServiceStart(Service service, Intent intent, int i) {
        onBroadcastServiceIntent(intent);
    }

    public static void onServiceStartCommand(Service service, Intent intent, int i, int i2) {
        onBroadcastServiceIntent(intent);
    }

    public static void hookIntentGetBroadcast(Context context, int i, Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookPendingIntentGetBroadcast(PendingIntent pendingIntent, Context context, int i, Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookIntentGetService(Context context, int i, Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookPendingIntentGetService(PendingIntent pendingIntent, Context context, int i, Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookIntentGetForegroundService(Context context, int i, Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookPendingIntentGetForegroundService(PendingIntent pendingIntent, Context context, int i, Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    private static void hookPendingIntent(Intent intent, PendingIntent pendingIntent) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().hookPendingIntent(intent, pendingIntent);
                SALog.i(TAG, "hookPendingIntent");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    private static void onBroadcastServiceIntent(Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().onNotificationClick((Context) null, intent);
                SALog.i(TAG, "onBroadcastServiceIntent");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    private static void hookIntent(Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                PushProcess.getInstance().hookIntent(intent);
                SALog.i(TAG, "hookIntent");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    private static boolean isTrackPushEnabled() {
        try {
            if (!(SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) && SensorsDataAPI.getConfigOptions() != null) {
                if (SensorsDataAPI.getConfigOptions().mEnableTrackPush) {
                    return true;
                }
            }
            SALog.i(TAG, "SDK or push disabled.");
            return false;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    private static String getSFData(String str) {
        try {
            return new JSONObject(str).optString("sf_data");
        } catch (Exception unused) {
            SALog.i(TAG, "get sf_data failed");
            return null;
        }
    }
}
