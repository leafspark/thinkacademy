package com.sensorsdata.analytics.android.sdk.visual.bridge;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class JSBridgeHelper implements WebViewJavascriptBridge {
    private static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    private static final String CALL_TYPE_GET_VISUAL_PROPERTIES = "getJSVisualProperties";
    /* access modifiers changed from: private */
    public Map<String, OnBridgeCallback> mCallbacks = new ArrayMap();
    private SAJSListener mSAJSListener;

    public void addSAJSListener() {
        if (this.mSAJSListener == null) {
            this.mSAJSListener = new SAJSListener() {
                public void onReceiveJSMessage(WeakReference<View> weakReference, String str) {
                    OnBridgeCallback onBridgeCallback;
                    JSONObject optJSONObject;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (TextUtils.equals(JSBridgeHelper.CALL_TYPE_GET_VISUAL_PROPERTIES, jSONObject.optString("callType"))) {
                            String optString = jSONObject.optString("message_id");
                            if (!TextUtils.isEmpty(optString) && (onBridgeCallback = (OnBridgeCallback) JSBridgeHelper.this.mCallbacks.remove(optString)) != null && (optJSONObject = jSONObject.optJSONObject(DbParams.KEY_DATA)) != null) {
                                onBridgeCallback.onCallBack(optJSONObject.toString());
                            }
                        }
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            };
            SensorsDataAPI.sharedInstance().addSAJSListener(this.mSAJSListener);
        }
    }

    public synchronized void sendToWeb(final View view, final String str, Object obj, OnBridgeCallback onBridgeCallback) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSRequest jSRequest = new JSRequest();
                jSRequest.methodName = str;
                if (onBridgeCallback != null) {
                    String format = String.format(CALLBACK_ID_FORMAT, new Object[]{Long.valueOf(SystemClock.currentThreadTimeMillis())});
                    this.mCallbacks.put(format, onBridgeCallback);
                    jSRequest.messageId = format;
                }
                final JSONObject jSONObject = null;
                if (obj instanceof String) {
                    jSONObject = new JSONObject((String) obj);
                } else if (obj instanceof JSONObject) {
                    jSONObject = new JSONObject();
                    jSONObject.put("message_id", jSRequest.messageId);
                    jSONObject.put("platform", "Android");
                    SensorsDataUtils.mergeJSONObject((JSONObject) obj, jSONObject);
                }
                if (jSONObject != null) {
                    if (view != null) {
                        view.post(new Runnable() {
                            public void run() {
                                View view = view;
                                JSBridgeHelper.invokeWebViewLoad(view, "loadUrl", new Object[]{"javascript:window.sensorsdata_app_call_js(" + ("'" + str + "','" + Base64.encodeToString(jSONObject.toString().getBytes(), 0) + "'") + ")"}, new Class[]{String.class});
                            }
                        });
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void sendToWeb(View view, String str, Object obj) {
        sendToWeb(view, str, obj, (OnBridgeCallback) null);
    }

    /* access modifiers changed from: private */
    public static void invokeWebViewLoad(View view, String str, Object[] objArr, Class[] clsArr) {
        try {
            view.getClass().getMethod(str, clsArr).invoke(view, objArr);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
