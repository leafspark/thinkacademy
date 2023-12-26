package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class AppWebViewInterface {
    private static final String TAG = "SA.AppWebViewInterface";
    private boolean enableVerify;
    private Context mContext;
    private WeakReference<View> mWebView;
    private JSONObject properties;

    AppWebViewInterface(Context context, JSONObject jSONObject, boolean z) {
        this(context, jSONObject, z, (View) null);
    }

    AppWebViewInterface(Context context, JSONObject jSONObject, boolean z, View view) {
        this.mContext = context;
        this.properties = jSONObject;
        this.enableVerify = z;
        if (view != null) {
            this.mWebView = new WeakReference<>(view);
        }
    }

    @JavascriptInterface
    public String sensorsdata_call_app() {
        try {
            if (this.properties == null) {
                this.properties = new JSONObject();
            }
            this.properties.put(ClassParamsKt.TYPE, "Android");
            String loginId = SensorsDataAPI.sharedInstance(this.mContext).getLoginId();
            if (!TextUtils.isEmpty(loginId)) {
                this.properties.put("distinct_id", loginId);
                this.properties.put("is_login", true);
            } else {
                this.properties.put("distinct_id", SensorsDataAPI.sharedInstance(this.mContext).getAnonymousId());
                this.properties.put("is_login", false);
            }
            return this.properties.toString();
        } catch (JSONException e) {
            SALog.i(TAG, e.getMessage());
            return null;
        }
    }

    @JavascriptInterface
    public void sensorsdata_track(String str) {
        try {
            SensorsDataAPI.sharedInstance(this.mContext).trackEventFromH5(str, this.enableVerify);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    @JavascriptInterface
    public boolean sensorsdata_verify(String str) {
        try {
            if (this.enableVerify) {
                return SensorsDataAPI.sharedInstance(this.mContext)._trackEventFromH5(str);
            }
            sensorsdata_track(str);
            return true;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    @JavascriptInterface
    public String sensorsdata_get_server_url() {
        SensorsDataAPI.sharedInstance();
        return SensorsDataAPI.getConfigOptions().isAutoTrackWebView ? SensorsDataAPI.sharedInstance().getServerUrl() : "";
    }

    @JavascriptInterface
    public boolean sensorsdata_visual_verify(String str) {
        try {
            if (!this.enableVerify) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String optString = new JSONObject(str).optString("server_url");
            return !TextUtils.isEmpty(optString) && new ServerUrl(optString).check(new ServerUrl(SensorsDataAPI.sharedInstance().getServerUrl()));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return false;
    }

    @JavascriptInterface
    public void sensorsdata_js_call_app(String str) {
        try {
            if (this.mWebView != null) {
                SensorsDataAPI.sharedInstance().handleJsMessage(this.mWebView, str);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    @JavascriptInterface
    public boolean sensorsdata_abtest_module() {
        try {
            if (ReflectUtil.callStaticMethod(ReflectUtil.getCurrentClass(new String[]{"com.sensorsdata.abtest.SensorsABTest"}), "shareInstance", new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    @JavascriptInterface
    public String sensorsdata_get_app_visual_config() {
        try {
            if (!SensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                return null;
            }
            VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().registerListeners();
            String visualCache = VisualPropertiesManager.getInstance().getVisualPropertiesCache().getVisualCache();
            if (!TextUtils.isEmpty(visualCache)) {
                return Base64.encodeToString(visualCache.getBytes(), 0);
            }
            return null;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
