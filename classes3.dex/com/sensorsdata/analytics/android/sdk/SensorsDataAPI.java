package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.OaidHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.SAContextManager;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataAPI extends AbstractSensorsDataAPI {
    static String ANDROID_PLUGIN_VERSION = "3.4.2";
    static final String MIN_PLUGIN_VERSION = "3.4.0";
    static final String VERSION = "6.0.0";
    public static final int VTRACK_SUPPORTED_MIN_API = 16;

    public String getSDKVersion() {
        return "6.0.0";
    }

    public /* bridge */ /* synthetic */ void addEventListener(SAEventListener sAEventListener) {
        super.addEventListener(sAEventListener);
    }

    public /* bridge */ /* synthetic */ void addFunctionListener(SAFunctionListener sAFunctionListener) {
        super.addFunctionListener(sAFunctionListener);
    }

    public /* bridge */ /* synthetic */ void addSAJSListener(SAJSListener sAJSListener) {
        super.addSAJSListener(sAJSListener);
    }

    public /* bridge */ /* synthetic */ void appBecomeActive() {
        super.appBecomeActive();
    }

    public /* bridge */ /* synthetic */ void appEnterBackground() {
        super.appEnterBackground();
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ DebugMode getDebugMode() {
        return super.getDebugMode();
    }

    public /* bridge */ /* synthetic */ SensorsDataDeepLinkCallback getDeepLinkCallback() {
        return super.getDeepLinkCallback();
    }

    public /* bridge */ /* synthetic */ BaseSensorsDataSDKRemoteManager getRemoteManager() {
        return super.getRemoteManager();
    }

    public /* bridge */ /* synthetic */ SAContextManager getSAContextManager() {
        return super.getSAContextManager();
    }

    public /* bridge */ /* synthetic */ SensorsDataEncrypt getSensorsDataEncrypt() {
        return super.getSensorsDataEncrypt();
    }

    public /* bridge */ /* synthetic */ boolean isDeepLinkInstallSource() {
        return super.isDeepLinkInstallSource();
    }

    public /* bridge */ /* synthetic */ boolean isDisableDefaultRemoteConfig() {
        return super.isDisableDefaultRemoteConfig();
    }

    public /* bridge */ /* synthetic */ void removeEventListener(SAEventListener sAEventListener) {
        super.removeEventListener(sAEventListener);
    }

    public /* bridge */ /* synthetic */ void removeFunctionListener(SAFunctionListener sAFunctionListener) {
        super.removeFunctionListener(sAFunctionListener);
    }

    public /* bridge */ /* synthetic */ void removeSAJSListener(SAJSListener sAJSListener) {
        super.removeSAJSListener(sAJSListener);
    }

    public /* bridge */ /* synthetic */ void setDebugMode(DebugMode debugMode) {
        super.setDebugMode(debugMode);
    }

    public /* bridge */ /* synthetic */ void setRemoteManager(BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        super.setRemoteManager(baseSensorsDataSDKRemoteManager);
    }

    public /* bridge */ /* synthetic */ void trackAutoEvent(String str, JSONObject jSONObject) {
        super.trackAutoEvent(str, jSONObject);
    }

    public /* bridge */ /* synthetic */ void trackInternal(String str, JSONObject jSONObject) {
        super.trackInternal(str, jSONObject);
    }

    public /* bridge */ /* synthetic */ void trackInternal(String str, JSONObject jSONObject, ViewNode viewNode) {
        super.trackInternal(str, jSONObject, viewNode);
    }

    public /* bridge */ /* synthetic */ void transformTaskQueue(Runnable runnable) {
        super.transformTaskQueue(runnable);
    }

    SensorsDataAPI() {
    }

    SensorsDataAPI(Context context, SAConfigOptions sAConfigOptions, DebugMode debugMode) {
        super(context, sAConfigOptions, debugMode);
    }

    public static SensorsDataAPI sharedInstance(Context context) {
        if (isSDKDisabled()) {
            return new SensorsDataAPIEmptyImplementation();
        }
        if (context == null) {
            return new SensorsDataAPIEmptyImplementation();
        }
        synchronized (sInstanceMap) {
            SensorsDataAPI sensorsDataAPI = (SensorsDataAPI) sInstanceMap.get(context.getApplicationContext());
            if (sensorsDataAPI != null) {
                return sensorsDataAPI;
            }
            SALog.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
            SensorsDataAPIEmptyImplementation sensorsDataAPIEmptyImplementation = new SensorsDataAPIEmptyImplementation();
            return sensorsDataAPIEmptyImplementation;
        }
    }

    public static void startWithConfigOptions(Context context, SAConfigOptions sAConfigOptions) {
        if (context == null || sAConfigOptions == null) {
            throw new NullPointerException("Context、SAConfigOptions 不可以为 null");
        }
        SensorsDataAPI instance = getInstance(context, DebugMode.DEBUG_OFF, sAConfigOptions);
        if (!instance.mSDKConfigInit) {
            instance.applySAConfigOptions();
        }
    }

    private static SensorsDataAPI getInstance(Context context, DebugMode debugMode, SAConfigOptions sAConfigOptions) {
        SensorsDataAPI sensorsDataAPI;
        if (context == null) {
            return new SensorsDataAPIEmptyImplementation();
        }
        synchronized (sInstanceMap) {
            Context applicationContext = context.getApplicationContext();
            sensorsDataAPI = (SensorsDataAPI) sInstanceMap.get(applicationContext);
            if (sensorsDataAPI == null) {
                sensorsDataAPI = new SensorsDataAPI(applicationContext, sAConfigOptions, debugMode);
                sInstanceMap.put(applicationContext, sensorsDataAPI);
                if (context instanceof Activity) {
                    sensorsDataAPI.delayExecution((Activity) context);
                }
            }
        }
        return sensorsDataAPI;
    }

    private static SensorsDataAPI getSDKInstance() {
        synchronized (sInstanceMap) {
            if (sInstanceMap.size() > 0) {
                Iterator it = sInstanceMap.values().iterator();
                if (it.hasNext()) {
                    SensorsDataAPI sensorsDataAPI = (SensorsDataAPI) it.next();
                    return sensorsDataAPI;
                }
            }
            SensorsDataAPIEmptyImplementation sensorsDataAPIEmptyImplementation = new SensorsDataAPIEmptyImplementation();
            return sensorsDataAPIEmptyImplementation;
        }
    }

    public static SensorsDataAPI sharedInstance() {
        if (isSDKDisabled()) {
            return new SensorsDataAPIEmptyImplementation();
        }
        return getSDKInstance();
    }

    public static void disableSDK() {
        SALog.i("SA.SensorsDataAPI", "call static function disableSDK");
        try {
            final SensorsDataAPI sharedInstance = sharedInstance();
            if (!(sharedInstance instanceof SensorsDataAPIEmptyImplementation) && getConfigOptions() != null) {
                if (!getConfigOptions().isDisableSDK) {
                    final boolean z = !SensorsDataContentObserver.isDisableFromObserver;
                    sharedInstance.transformTaskQueue(new Runnable() {
                        public void run() {
                            if (z) {
                                sharedInstance.trackInternal("$AppDataTrackingClose", (JSONObject) null);
                            }
                        }
                    });
                    if (sharedInstance.isNetworkRequestEnable()) {
                        sharedInstance.enableNetworkRequest(false);
                        isChangeEnableNetworkFlag = true;
                    } else {
                        isChangeEnableNetworkFlag = false;
                    }
                    sharedInstance.unregisterNetworkListener();
                    sharedInstance.clearTrackTimer();
                    DbAdapter.getInstance().commitAppStartTime(0);
                    getConfigOptions().disableSDK(true);
                    SALog.setDisableSDK(true);
                    if (!SensorsDataContentObserver.isDisableFromObserver) {
                        sharedInstance.getContext().getContentResolver().notifyChange(DbParams.getInstance().getDisableSDKUri(), (ContentObserver) null);
                    }
                    SensorsDataContentObserver.isDisableFromObserver = false;
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void enableSDK() {
        SALog.i("SA.SensorsDataAPI", "call static function enableSDK");
        try {
            SensorsDataAPI sDKInstance = getSDKInstance();
            if (!(sDKInstance instanceof SensorsDataAPIEmptyImplementation) && getConfigOptions() != null) {
                if (getConfigOptions().isDisableSDK) {
                    getConfigOptions().disableSDK(false);
                    try {
                        SALog.setDisableSDK(false);
                        sDKInstance.enableLog(SALog.isLogEnabled());
                        SALog.i("SA.SensorsDataAPI", "enableSDK, enable log");
                        if (sDKInstance.mFirstDay.get() == null) {
                            sDKInstance.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), TimeUtils.YYYY_MM_DD));
                        }
                        sDKInstance.delayInitTask();
                        if (isChangeEnableNetworkFlag) {
                            sDKInstance.enableNetworkRequest(true);
                            isChangeEnableNetworkFlag = false;
                        }
                        if (getConfigOptions().isVisualizedPropertiesEnabled()) {
                            VisualPropertiesManager.getInstance().requestVisualConfig();
                        }
                        sDKInstance.getRemoteManager().pullSDKConfigFromServer();
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                    if (!SensorsDataContentObserver.isEnableFromObserver) {
                        sDKInstance.getContext().getContentResolver().notifyChange(DbParams.getInstance().getEnableSDKUri(), (ContentObserver) null);
                    }
                    SensorsDataContentObserver.isEnableFromObserver = false;
                }
            }
        } catch (Exception e2) {
            SALog.printStackTrace(e2);
        }
    }

    public JSONObject getPresetProperties() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = this.mSAContextManager.getPresetProperties();
            jSONObject.put("$is_first_day", isFirstDay(System.currentTimeMillis()));
            return jSONObject;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return jSONObject;
        }
    }

    public void enableLog(boolean z) {
        SALog.setEnableLog(z);
    }

    public long getMaxCacheSize() {
        return mSAConfigOptions.mMaxCacheSize;
    }

    public void setMaxCacheSize(long j) {
        mSAConfigOptions.setMaxCacheSize(j);
    }

    public void setFlushNetworkPolicy(int i) {
        mSAConfigOptions.setNetworkTypePolicy(i);
    }

    /* access modifiers changed from: package-private */
    public int getFlushNetworkPolicy() {
        return mSAConfigOptions.mNetworkTypePolicy;
    }

    public int getFlushInterval() {
        return mSAConfigOptions.mFlushInterval;
    }

    public void setFlushInterval(int i) {
        mSAConfigOptions.setFlushInterval(i);
    }

    public int getFlushBulkSize() {
        return mSAConfigOptions.mFlushBulkSize;
    }

    public void setFlushBulkSize(int i) {
        if (i < 0) {
            SALog.i("SA.SensorsDataAPI", "The value of flushBulkSize is invalid");
        }
        mSAConfigOptions.setFlushBulkSize(i);
    }

    public int getSessionIntervalTime() {
        return this.mSessionTime;
    }

    public void setSessionIntervalTime(int i) {
        if (DbAdapter.getInstance() == null) {
            SALog.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
        } else if (i < 10000 || i > 300000) {
            SALog.i("SA.SensorsDataAPI", "SessionIntervalTime:" + i + " is invalid, session interval time is between 10s and 300s.");
        } else if (i != this.mSessionTime) {
            this.mSessionTime = i;
            DbAdapter.getInstance().commitSessionIntervalTime(i);
        }
    }

    public void setGPSLocation(double d, double d2) {
        setGPSLocation(d, d2, (String) null);
    }

    public void setGPSLocation(double d, double d2, String str) {
        try {
            final double d3 = d;
            final double d4 = d2;
            final String str2 = str;
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (AbstractSensorsDataAPI.mGPSLocation == null) {
                            AbstractSensorsDataAPI.mGPSLocation = new SensorsDataGPSLocation();
                        }
                        AbstractSensorsDataAPI.mGPSLocation.setLatitude((long) (d3 * Math.pow(10.0d, 6.0d)));
                        AbstractSensorsDataAPI.mGPSLocation.setLongitude((long) (d4 * Math.pow(10.0d, 6.0d)));
                        AbstractSensorsDataAPI.mGPSLocation.setCoordinate(SADataHelper.assertPropertyLength(str2));
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void clearGPSLocation() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    AbstractSensorsDataAPI.mGPSLocation = null;
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void enableTrackScreenOrientation(boolean z) {
        if (z) {
            try {
                if (this.mOrientationDetector == null) {
                    this.mOrientationDetector = new SensorsDataScreenOrientationDetector(this.mContext, 3);
                }
                this.mOrientationDetector.enable();
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        } else if (this.mOrientationDetector != null) {
            this.mOrientationDetector.disable();
            this.mOrientationDetector = null;
        }
    }

    public void resumeTrackScreenOrientation() {
        try {
            if (this.mOrientationDetector != null) {
                this.mOrientationDetector.enable();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void stopTrackScreenOrientation() {
        try {
            if (this.mOrientationDetector != null) {
                this.mOrientationDetector.disable();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public String getScreenOrientation() {
        try {
            if (this.mOrientationDetector != null) {
                return this.mOrientationDetector.getOrientation();
            }
            return null;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    public void setCookie(String str, boolean z) {
        if (z) {
            try {
                this.mCookie = URLEncoder.encode(str, Base64Coder.CHARSET_UTF8);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        } else {
            this.mCookie = str;
        }
    }

    public String getCookie(boolean z) {
        if (!z) {
            return this.mCookie;
        }
        try {
            return URLDecoder.decode(this.mCookie, Base64Coder.CHARSET_UTF8);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    public void enableAutoTrack(List<AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.mAutoTrack = true;
                    for (AutoTrackEventType access$000 : list) {
                        mSAConfigOptions.setAutoTrackEventType(access$000.eventValue | mSAConfigOptions.mAutoTrackEventType);
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void disableAutoTrack(List<AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (mSAConfigOptions.mAutoTrackEventType != 0) {
                    for (AutoTrackEventType next : list) {
                        if ((mSAConfigOptions.mAutoTrackEventType | next.eventValue) == mSAConfigOptions.mAutoTrackEventType) {
                            mSAConfigOptions.setAutoTrackEventType(next.eventValue ^ mSAConfigOptions.mAutoTrackEventType);
                        }
                    }
                    if (mSAConfigOptions.mAutoTrackEventType == 0) {
                        this.mAutoTrack = false;
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void disableAutoTrack(AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType != null) {
            try {
                if (mSAConfigOptions.mAutoTrackEventType != 0) {
                    int access$000 = mSAConfigOptions.mAutoTrackEventType | autoTrackEventType.eventValue;
                    if (access$000 == autoTrackEventType.eventValue) {
                        mSAConfigOptions.setAutoTrackEventType(0);
                    } else {
                        mSAConfigOptions.setAutoTrackEventType(autoTrackEventType.eventValue ^ access$000);
                    }
                    if (mSAConfigOptions.mAutoTrackEventType == 0) {
                        this.mAutoTrack = false;
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public boolean isAutoTrackEnabled() {
        Boolean isAutoTrackEnabled;
        if (isSDKDisabled()) {
            return false;
        }
        if (this.mRemoteManager == null || (isAutoTrackEnabled = this.mRemoteManager.isAutoTrackEnabled()) == null) {
            return this.mAutoTrack;
        }
        return isAutoTrackEnabled.booleanValue();
    }

    public void trackFragmentAppViewScreen() {
        this.mFragmentAPI.trackFragmentAppViewScreen();
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mFragmentAPI.isTrackFragmentAppViewScreenEnabled();
    }

    public void showUpWebView(WebView webView, boolean z) {
        showUpWebView(webView, z, (JSONObject) null);
    }

    public void showUpWebView(WebView webView, boolean z, boolean z2) {
        showUpWebView(webView, (JSONObject) null, z, z2);
    }

    @Deprecated
    public void showUpWebView(WebView webView, JSONObject jSONObject, boolean z, boolean z2) {
        if (Build.VERSION.SDK_INT < 17 && !z) {
            SALog.d("SA.SensorsDataAPI", "For applications targeted to API level JELLY_BEAN or below, this feature NOT SUPPORTED");
        } else if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new AppWebViewInterface(this.mContext, jSONObject, z2, webView), "SensorsData_APP_JS_Bridge");
            SensorsDataAutoTrackHelper.addWebViewVisualInterface(webView);
        }
    }

    @Deprecated
    public void showUpWebView(WebView webView, boolean z, JSONObject jSONObject) {
        showUpWebView(webView, jSONObject, z, false);
    }

    @Deprecated
    public void showUpX5WebView(Object obj, JSONObject jSONObject, boolean z, boolean z2) {
        Method method;
        try {
            if (Build.VERSION.SDK_INT < 17 && !z) {
                SALog.d("SA.SensorsDataAPI", "For applications targeted to API level JELLY_BEAN or below, this feature NOT SUPPORTED");
            } else if (obj != null && (method = obj.getClass().getMethod("addJavascriptInterface", new Class[]{Object.class, String.class})) != null) {
                method.invoke(obj, new Object[]{new AppWebViewInterface(this.mContext, jSONObject, z2), "SensorsData_APP_JS_Bridge"});
                SensorsDataAutoTrackHelper.addWebViewVisualInterface((View) obj);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void showUpX5WebView(Object obj, boolean z) {
        if (obj != null) {
            try {
                Method method = obj.getClass().getMethod("addJavascriptInterface", new Class[]{Object.class, String.class});
                if (method != null) {
                    method.invoke(obj, new Object[]{new AppWebViewInterface(this.mContext, (JSONObject) null, z, (View) obj), "SensorsData_APP_JS_Bridge"});
                    SensorsDataAutoTrackHelper.addWebViewVisualInterface((View) obj);
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void showUpX5WebView(Object obj) {
        showUpX5WebView(obj, false);
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            for (Class next : list) {
                if (next != null) {
                    int hashCode = next.hashCode();
                    if (!this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                        this.mAutoTrackIgnoredActivities.add(Integer.valueOf(hashCode));
                    }
                }
            }
        }
    }

    public void resumeAutoTrackActivities(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                for (Class next : list) {
                    if (next != null) {
                        int hashCode = next.hashCode();
                        if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                            this.mAutoTrackIgnoredActivities.remove(Integer.valueOf(hashCode));
                        }
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                int hashCode = cls.hashCode();
                if (!this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.add(Integer.valueOf(hashCode));
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void resumeAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                int hashCode = cls.hashCode();
                if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.remove(Integer.valueOf(hashCode));
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void enableAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.enableAutoTrackFragment(cls);
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.enableAutoTrackFragments(list);
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if ((this.mAutoTrackIgnoredActivities != null && this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(cls.hashCode()))) || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
            return true;
        }
        if (cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreen.class) != null) {
            return true;
        }
        return false;
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        return this.mFragmentAPI.isFragmentAutoTrackAppViewScreen(cls);
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.ignoreAutoTrackFragments(list);
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.ignoreAutoTrackFragment(cls);
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragments(list);
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragment(cls);
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if ((this.mAutoTrackIgnoredActivities != null && this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(cls.hashCode()))) || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
            return true;
        }
        if (cls.getAnnotation(SensorsDataIgnoreTrackAppClick.class) != null) {
            return true;
        }
        return false;
    }

    public boolean isAutoTrackEventTypeIgnored(AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType == null) {
            return false;
        }
        return isAutoTrackEventTypeIgnored(autoTrackEventType.eventValue);
    }

    public boolean isAutoTrackEventTypeIgnored(int i) {
        Boolean isAutoTrackEventTypeIgnored;
        if (this.mRemoteManager == null || (isAutoTrackEventTypeIgnored = this.mRemoteManager.isAutoTrackEventTypeIgnored(i)) == null) {
            return (i | mSAConfigOptions.mAutoTrackEventType) != mSAConfigOptions.mAutoTrackEventType;
        }
        if (isAutoTrackEventTypeIgnored.booleanValue()) {
            SALog.i("SA.SensorsDataAPI", "remote config: " + AutoTrackEventType.autoTrackEventName(i) + " is ignored by remote config");
        }
        return isAutoTrackEventTypeIgnored.booleanValue();
    }

    public void setViewID(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            view.setTag(R.id.sensors_analytics_tag_view_id, str);
        }
    }

    public void setViewID(Dialog dialog, String str) {
        if (dialog != null) {
            try {
                if (!TextUtils.isEmpty(str) && dialog.getWindow() != null) {
                    dialog.getWindow().getDecorView().setTag(R.id.sensors_analytics_tag_view_id, str);
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void setViewID(Object obj, String str) {
        Class<?> cls;
        Method method;
        Window window;
        if (obj != null) {
            Class<?> cls2 = null;
            try {
                cls = Class.forName("androidx.appcompat.app.AlertDialog");
            } catch (Exception unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName("androidx.appcompat.app.AlertDialog");
            } catch (Exception unused2) {
            }
            if (cls == null) {
                cls = cls2;
            }
            if (cls != null) {
                try {
                    if (cls.isInstance(obj) && !TextUtils.isEmpty(str) && (method = obj.getClass().getMethod("getWindow", new Class[0])) != null && (window = (Window) method.invoke(obj, new Object[0])) != null) {
                        window.getDecorView().setTag(R.id.sensors_analytics_tag_view_id, str);
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        }
    }

    public void setViewActivity(View view, Activity activity) {
        if (view != null && activity != null) {
            try {
                view.setTag(R.id.sensors_analytics_tag_view_activity, activity);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void setViewFragmentName(View view, String str) {
        if (view != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    view.setTag(R.id.sensors_analytics_tag_view_fragment_name2, str);
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void ignoreView(View view) {
        if (view != null) {
            view.setTag(R.id.sensors_analytics_tag_view_ignored, DbParams.GZIP_DATA_EVENT);
        }
    }

    public void ignoreView(View view, boolean z) {
        if (view != null) {
            view.setTag(R.id.sensors_analytics_tag_view_ignored, z ? DbParams.GZIP_DATA_EVENT : "0");
        }
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view != null && jSONObject != null) {
            view.setTag(R.id.sensors_analytics_tag_view_properties, jSONObject);
        }
    }

    public List<Class> getIgnoredViewTypeList() {
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new ArrayList();
        }
        return this.mIgnoredViewTypeList;
    }

    public void ignoreViewType(Class cls) {
        if (cls != null) {
            if (this.mIgnoredViewTypeList == null) {
                this.mIgnoredViewTypeList = new ArrayList();
            }
            if (!this.mIgnoredViewTypeList.contains(cls)) {
                this.mIgnoredViewTypeList.add(cls);
            }
        }
    }

    public boolean isVisualizedAutoTrackActivity(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            return this.mVisualizedAutoTrackActivities.size() == 0 || this.mVisualizedAutoTrackActivities.contains(Integer.valueOf(cls.hashCode()));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void addVisualizedAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            try {
                this.mVisualizedAutoTrackActivities.add(Integer.valueOf(cls.hashCode()));
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void addVisualizedAutoTrackActivities(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (Class next : list) {
                        if (next != null) {
                            int hashCode = next.hashCode();
                            if (!this.mVisualizedAutoTrackActivities.contains(Integer.valueOf(hashCode))) {
                                this.mVisualizedAutoTrackActivities.add(Integer.valueOf(hashCode));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public boolean isVisualizedAutoTrackEnabled() {
        return mSAConfigOptions.mVisualizedEnabled || mSAConfigOptions.mVisualizedPropertiesEnabled;
    }

    public boolean isHeatMapActivity(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            return this.mHeatMapActivities.size() == 0 || this.mHeatMapActivities.contains(Integer.valueOf(cls.hashCode()));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void addHeatMapActivity(Class<?> cls) {
        if (cls != null) {
            try {
                this.mHeatMapActivities.add(Integer.valueOf(cls.hashCode()));
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void addHeatMapActivities(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (Class next : list) {
                        if (next != null) {
                            int hashCode = next.hashCode();
                            if (!this.mHeatMapActivities.contains(Integer.valueOf(hashCode))) {
                                this.mHeatMapActivities.add(Integer.valueOf(hashCode));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public boolean isHeatMapEnabled() {
        return mSAConfigOptions.mHeatMapEnabled;
    }

    public String getDistinctId() {
        try {
            String loginId = getLoginId();
            if (!TextUtils.isEmpty(loginId)) {
                return loginId;
            }
            return getAnonymousId();
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public String getAnonymousId() {
        try {
            synchronized (this.mDistinctId) {
                if (!mSAConfigOptions.isDataCollectEnable) {
                    return "";
                }
                String str = (String) this.mDistinctId.get();
                return str;
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public void resetAnonymousId() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    synchronized (SensorsDataAPI.this.mDistinctId) {
                        SALog.i("SA.SensorsDataAPI", "resetAnonymousId is called");
                        String androidId = SensorsDataAPI.this.mSAContextManager.getAndroidId();
                        if (TextUtils.equals(androidId, (CharSequence) SensorsDataAPI.this.mDistinctId.get())) {
                            SALog.i("SA.SensorsDataAPI", "DistinctId not change");
                            return;
                        }
                        if (!SensorsDataUtils.isValidAndroidId(androidId)) {
                            androidId = UUID.randomUUID().toString();
                        }
                        SensorsDataAPI.this.mDistinctId.commit(androidId);
                        try {
                            if (SensorsDataAPI.this.mEventListenerList != null) {
                                for (SAEventListener resetAnonymousId : SensorsDataAPI.this.mEventListenerList) {
                                    resetAnonymousId.resetAnonymousId();
                                }
                            }
                        } catch (Exception e) {
                            SALog.printStackTrace(e);
                        }
                        try {
                            if (SensorsDataAPI.this.mFunctionListenerList != null) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("distinctId", androidId);
                                for (SAFunctionListener call : SensorsDataAPI.this.mFunctionListenerList) {
                                    call.call("resetAnonymousId", jSONObject);
                                }
                            }
                        } catch (Exception e2) {
                            SALog.printStackTrace(e2);
                        }
                    }
                    return;
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public String getLoginId() {
        if (AppInfoUtils.isTaskExecuteThread()) {
            return DbAdapter.getInstance().getLoginId();
        }
        return this.mLoginId;
    }

    public void identify(final String str) {
        try {
            SADataHelper.assertValue(str);
            try {
                this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                    public void run() {
                        try {
                            synchronized (SensorsDataAPI.this.mDistinctId) {
                                try {
                                    SALog.i("SA.SensorsDataAPI", "identify is called");
                                    if (!str.equals(SensorsDataAPI.this.mDistinctId.get())) {
                                        SensorsDataAPI.this.mDistinctId.commit(str);
                                        if (SensorsDataAPI.this.mEventListenerList != null) {
                                            for (SAEventListener identify : SensorsDataAPI.this.mEventListenerList) {
                                                identify.identify();
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    SALog.printStackTrace(e);
                                }
                                try {
                                    if (SensorsDataAPI.this.mFunctionListenerList != null) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("distinctId", str);
                                        for (SAFunctionListener call : SensorsDataAPI.this.mFunctionListenerList) {
                                            call.call("identify", jSONObject);
                                        }
                                    }
                                } catch (Exception e2) {
                                    SALog.printStackTrace(e2);
                                }
                            }
                            return;
                        } catch (Exception e3) {
                            SALog.printStackTrace(e3);
                        }
                    }
                });
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        } catch (Exception e2) {
            SALog.printStackTrace(e2);
        }
    }

    public void login(String str) {
        login(str, (JSONObject) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void login(final java.lang.String r4, final org.json.JSONObject r5) {
        /*
            r3 = this;
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertValue(r4)     // Catch:{ Exception -> 0x002a }
            java.lang.Object r0 = r3.mLoginIdLock     // Catch:{ Exception -> 0x002a }
            monitor-enter(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r1 = r3.getAnonymousId()     // Catch:{ all -> 0x0027 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0025
            r3.mLoginId = r4     // Catch:{ all -> 0x0027 }
            boolean r1 = com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver.isLoginFromObserver     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x001b
            r4 = 0
            com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver.isLoginFromObserver = r4     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x001b:
            com.sensorsdata.analytics.android.sdk.TrackTaskManager r1 = r3.mTrackTaskManager     // Catch:{ all -> 0x0027 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$6 r2 = new com.sensorsdata.analytics.android.sdk.SensorsDataAPI$6     // Catch:{ all -> 0x0027 }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x0027 }
            r1.addTrackEventTask(r2)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            goto L_0x002e
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAPI.login(java.lang.String, org.json.JSONObject):void");
    }

    public void logout() {
        try {
            this.mLoginId = null;
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        synchronized (SensorsDataAPI.this.mLoginIdLock) {
                            SALog.i("SA.SensorsDataAPI", "logout is called");
                            if (!TextUtils.isEmpty(DbAdapter.getInstance().getLoginId())) {
                                DbAdapter.getInstance().commitLoginId((String) null);
                                try {
                                    if (SensorsDataAPI.this.mEventListenerList != null) {
                                        for (SAEventListener logout : SensorsDataAPI.this.mEventListenerList) {
                                            logout.logout();
                                        }
                                    }
                                } catch (Exception e) {
                                    SALog.printStackTrace(e);
                                }
                                try {
                                    if (SensorsDataAPI.this.mFunctionListenerList != null) {
                                        for (SAFunctionListener call : SensorsDataAPI.this.mFunctionListenerList) {
                                            call.call("logout", (JSONObject) null);
                                        }
                                    }
                                } catch (Exception e2) {
                                    SALog.printStackTrace(e2);
                                }
                                SALog.i("SA.SensorsDataAPI", "Clean loginId");
                            }
                        }
                        return;
                    } catch (Exception e3) {
                        SALog.printStackTrace(e3);
                    }
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void trackInstallation(String str, JSONObject jSONObject, boolean z) {
        try {
            final JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
            }
            addTimeProperty(jSONObject2);
            final String loginId = getLoginId();
            final String distinctId = getDistinctId();
            final boolean z2 = z;
            final String str2 = str;
            transformTaskQueue(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:45:0x012c A[Catch:{ Exception -> 0x0150 }] */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x0138 A[Catch:{ Exception -> 0x0150 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r23 = this;
                        r1 = r23
                        java.lang.String r2 = "$ios_install_disable_callback"
                        boolean r0 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mIsMainProcess
                        if (r0 != 0) goto L_0x0009
                        return
                    L_0x0009:
                        boolean r0 = r2     // Catch:{ Exception -> 0x0150 }
                        if (r0 == 0) goto L_0x001c
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallationWithCallback r0 = r0.mFirstTrackInstallationWithCallback     // Catch:{ Exception -> 0x0150 }
                        java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0150 }
                        java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0150 }
                        boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0150 }
                        goto L_0x002a
                    L_0x001c:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallation r0 = r0.mFirstTrackInstallation     // Catch:{ Exception -> 0x0150 }
                        java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0150 }
                        java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0150 }
                        boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0150 }
                    L_0x002a:
                        if (r0 == 0) goto L_0x014a
                        r3 = 0
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e2 }
                        boolean r0 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmProperties(r0)     // Catch:{ Exception -> 0x00e2 }
                        if (r0 != 0) goto L_0x003e
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00e2 }
                        android.content.Context r0 = r0.mContext     // Catch:{ Exception -> 0x00e2 }
                        org.json.JSONObject r4 = r3     // Catch:{ Exception -> 0x00e2 }
                        com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.mergeUtmByMetaData(r0, r4)     // Catch:{ Exception -> 0x00e2 }
                    L_0x003e:
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e2 }
                        boolean r0 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.hasUtmProperties(r0)     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r4 = "$gaid"
                        java.lang.String r5 = "$oaid"
                        if (r0 != 0) goto L_0x00bb
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00e2 }
                        com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r0.mSAContextManager     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r0 = r0.getAndroidId()     // Catch:{ Exception -> 0x00e2 }
                        org.json.JSONObject r6 = r3     // Catch:{ Exception -> 0x00e2 }
                        boolean r6 = r6.has(r5)     // Catch:{ Exception -> 0x00e2 }
                        if (r6 == 0) goto L_0x007f
                        org.json.JSONObject r6 = r3     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r6 = r6.optString(r5)     // Catch:{ Exception -> 0x00e2 }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r7 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00e2 }
                        android.content.Context r7 = r7.mContext     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r7 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(r7, r0, r6)     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r8 = "SA.SensorsDataAPI"
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e2 }
                        r9.<init>()     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r10 = "properties has oaid "
                        r9.append(r10)     // Catch:{ Exception -> 0x00e2 }
                        r9.append(r6)     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00e2 }
                        com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x00e2 }
                        goto L_0x008f
                    L_0x007f:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00e2 }
                        android.content.Context r6 = r6.mContext     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r6 = com.sensorsdata.analytics.android.sdk.advert.utils.OaidHelper.getOAID(r6)     // Catch:{ Exception -> 0x00e2 }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r7 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00e2 }
                        android.content.Context r7 = r7.mContext     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r7 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getDeviceInfo(r7, r0, r6)     // Catch:{ Exception -> 0x00e2 }
                    L_0x008f:
                        org.json.JSONObject r8 = r3     // Catch:{ Exception -> 0x00e2 }
                        boolean r8 = r8.has(r4)     // Catch:{ Exception -> 0x00e2 }
                        if (r8 == 0) goto L_0x00ab
                        java.lang.String r8 = "%s##gaid=%s"
                        r9 = 2
                        java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00e2 }
                        r9[r3] = r7     // Catch:{ Exception -> 0x00e2 }
                        r7 = 1
                        org.json.JSONObject r10 = r3     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r10 = r10.optString(r4)     // Catch:{ Exception -> 0x00e2 }
                        r9[r7] = r10     // Catch:{ Exception -> 0x00e2 }
                        java.lang.String r7 = java.lang.String.format(r8, r9)     // Catch:{ Exception -> 0x00e2 }
                    L_0x00ab:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r8 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00e2 }
                        android.content.Context r8 = r8.mContext     // Catch:{ Exception -> 0x00e2 }
                        boolean r6 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.isGetDeviceInfo(r8, r0, r6)     // Catch:{ Exception -> 0x00e2 }
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e0 }
                        java.lang.String r8 = "$ios_install_source"
                        r0.put(r8, r7)     // Catch:{ Exception -> 0x00e0 }
                        goto L_0x00bc
                    L_0x00bb:
                        r6 = r3
                    L_0x00bc:
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e0 }
                        boolean r0 = r0.has(r5)     // Catch:{ Exception -> 0x00e0 }
                        if (r0 == 0) goto L_0x00c9
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e0 }
                        r0.remove(r5)     // Catch:{ Exception -> 0x00e0 }
                    L_0x00c9:
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e0 }
                        boolean r0 = r0.has(r4)     // Catch:{ Exception -> 0x00e0 }
                        if (r0 == 0) goto L_0x00d6
                        org.json.JSONObject r0 = r3     // Catch:{ Exception -> 0x00e0 }
                        r0.remove(r4)     // Catch:{ Exception -> 0x00e0 }
                    L_0x00d6:
                        boolean r0 = r2     // Catch:{ Exception -> 0x00e0 }
                        if (r0 == 0) goto L_0x00e7
                        org.json.JSONObject r4 = r3     // Catch:{ Exception -> 0x00e0 }
                        r4.put(r2, r0)     // Catch:{ Exception -> 0x00e0 }
                        goto L_0x00e7
                    L_0x00e0:
                        r0 = move-exception
                        goto L_0x00e4
                    L_0x00e2:
                        r0 = move-exception
                        r6 = r3
                    L_0x00e4:
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x0150 }
                    L_0x00e7:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r7 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.EventType r8 = com.sensorsdata.analytics.android.sdk.EventType.TRACK     // Catch:{ Exception -> 0x0150 }
                        java.lang.String r9 = r4     // Catch:{ Exception -> 0x0150 }
                        org.json.JSONObject r10 = r3     // Catch:{ Exception -> 0x0150 }
                        r11 = 0
                        java.lang.String r12 = r5     // Catch:{ Exception -> 0x0150 }
                        java.lang.String r13 = r6     // Catch:{ Exception -> 0x0150 }
                        r14 = 0
                        r7.trackEvent(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0150 }
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0150 }
                        r0.<init>()     // Catch:{ Exception -> 0x0150 }
                        org.json.JSONObject r4 = r3     // Catch:{ Exception -> 0x0150 }
                        r4.remove(r2)     // Catch:{ Exception -> 0x0150 }
                        org.json.JSONObject r2 = r3     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r2, r0)     // Catch:{ Exception -> 0x0150 }
                        java.lang.String r2 = "$first_visit_time"
                        java.util.Date r4 = new java.util.Date     // Catch:{ Exception -> 0x0150 }
                        r4.<init>()     // Catch:{ Exception -> 0x0150 }
                        r0.put(r2, r4)     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.EventType r16 = com.sensorsdata.analytics.android.sdk.EventType.PROFILE_SET_ONCE     // Catch:{ Exception -> 0x0150 }
                        r17 = 0
                        r19 = 0
                        java.lang.String r2 = r5     // Catch:{ Exception -> 0x0150 }
                        java.lang.String r4 = r6     // Catch:{ Exception -> 0x0150 }
                        r22 = 0
                        r18 = r0
                        r20 = r2
                        r21 = r4
                        r15.trackEvent(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0150 }
                        boolean r0 = r2     // Catch:{ Exception -> 0x0150 }
                        if (r0 == 0) goto L_0x0138
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallationWithCallback r0 = r0.mFirstTrackInstallationWithCallback     // Catch:{ Exception -> 0x0150 }
                        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0150 }
                        r0.commit(r2)     // Catch:{ Exception -> 0x0150 }
                        goto L_0x0143
                    L_0x0138:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallation r0 = r0.mFirstTrackInstallation     // Catch:{ Exception -> 0x0150 }
                        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0150 }
                        r0.commit(r2)     // Catch:{ Exception -> 0x0150 }
                    L_0x0143:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        android.content.Context r0 = r0.mContext     // Catch:{ Exception -> 0x0150 }
                        com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.saveCorrectTrackInstallation(r0, r6)     // Catch:{ Exception -> 0x0150 }
                    L_0x014a:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x0150 }
                        r0.flush()     // Catch:{ Exception -> 0x0150 }
                        goto L_0x0154
                    L_0x0150:
                        r0 = move-exception
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
                    L_0x0154:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass8.run():void");
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void trackInstallation(String str, JSONObject jSONObject) {
        trackInstallation(str, jSONObject, false);
    }

    public void trackInstallation(String str) {
        trackInstallation(str, (JSONObject) null, false);
    }

    public void trackAppInstall(JSONObject jSONObject, boolean z) {
        trackInstallation("$AppInstall", jSONObject, z);
    }

    public void trackAppInstall(JSONObject jSONObject) {
        trackAppInstall(jSONObject, false);
    }

    public void trackAppInstall() {
        trackAppInstall((JSONObject) null, false);
    }

    /* access modifiers changed from: package-private */
    public void trackChannelDebugInstallation() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(SensorsDataAPI.this.mContext, SensorsDataAPI.this.mSAContextManager.getAndroidId(), OaidHelper.getOAID(SensorsDataAPI.this.mContext)));
                    SensorsDataAPI.this.trackEvent(EventType.TRACK, "$ChannelDebugInstall", jSONObject, (String) null);
                    JSONObject jSONObject2 = new JSONObject();
                    SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
                    jSONObject2.put("$first_visit_time", new Date());
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET_ONCE, (String) null, jSONObject2, (String) null);
                    SensorsDataAPI.this.flush();
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void trackChannelEvent(String str) {
        trackChannelEvent(str, (JSONObject) null);
    }

    public void trackChannelEvent(final String str, JSONObject jSONObject) {
        if (getConfigOptions().isAutoAddChannelCallbackEvent) {
            track(str, jSONObject);
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
        }
        addTimeProperty(jSONObject2);
        transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    jSONObject2.put("$is_channel_callback_event", ChannelUtils.isFirstChannelEvent(str));
                    if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                        ChannelUtils.mergeUtmByMetaData(SensorsDataAPI.this.mContext, jSONObject2);
                    }
                    if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                        if (jSONObject2.has("$oaid")) {
                            String optString = jSONObject2.optString("$oaid");
                            jSONObject2.put("$channel_device_info", ChannelUtils.getDeviceInfo(SensorsDataAPI.this.mContext, SensorsDataAPI.this.mSAContextManager.getAndroidId(), optString));
                            SALog.i("SA.SensorsDataAPI", "properties has oaid " + optString);
                        } else {
                            jSONObject2.put("$channel_device_info", ChannelUtils.getDeviceInfo(SensorsDataAPI.this.mContext, SensorsDataAPI.this.mSAContextManager.getAndroidId(), OaidHelper.getOAID(SensorsDataAPI.this.mContext)));
                        }
                    }
                    if (jSONObject2.has("$oaid")) {
                        jSONObject2.remove("$oaid");
                    }
                } catch (Exception e) {
                    try {
                        SALog.printStackTrace(e);
                    } catch (Exception e2) {
                        SALog.printStackTrace(e2);
                        return;
                    }
                }
                SensorsDataAPI.this.trackEvent(EventType.TRACK, str, jSONObject2, (String) null);
            }
        });
    }

    public void track(final String str, final JSONObject jSONObject) {
        try {
            final JSONObject dynamicProperty = getDynamicProperty();
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.trackEvent(EventType.TRACK, str, ChannelUtils.checkOrSetChannelCallbackEvent(AbstractSensorsDataAPI.getConfigOptions().isAutoAddChannelCallbackEvent, str, jSONObject, SensorsDataAPI.this.mContext), dynamicProperty, SensorsDataAPI.this.getDistinctId(), SensorsDataAPI.this.getLoginId(), (String) null);
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void track(String str) {
        track(str, (JSONObject) null);
    }

    @Deprecated
    public void trackTimer(String str, TimeUnit timeUnit) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final String str2 = str;
        final TimeUnit timeUnit2 = timeUnit;
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertKey(str2);
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        SensorsDataAPI.this.mTrackTimer.put(str2, new EventTimer(timeUnit2, elapsedRealtime));
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void removeTimer(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertKey(str);
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        SensorsDataAPI.this.mTrackTimer.remove(str);
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public String trackTimerStart(String str) {
        try {
            String format = String.format("%s_%s_%s", new Object[]{str, UUID.randomUUID().toString().replace("-", "_"), "SATimer"});
            trackTimer(format, TimeUnit.SECONDS);
            trackTimer(str, TimeUnit.SECONDS);
            return format;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public void trackTimerPause(String str) {
        trackTimerState(str, true);
    }

    public void trackTimerResume(String str) {
        trackTimerState(str, false);
    }

    public void trackTimerEnd(String str, JSONObject jSONObject) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final String str2 = str;
        final JSONObject jSONObject2 = jSONObject;
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                if (str2 != null) {
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        EventTimer eventTimer = (EventTimer) SensorsDataAPI.this.mTrackTimer.get(str2);
                        if (eventTimer != null) {
                            eventTimer.setEndTime(elapsedRealtime);
                        }
                    }
                }
                try {
                    SensorsDataAPI.this.trackEvent(EventType.TRACK, str2, ChannelUtils.checkOrSetChannelCallbackEvent(AbstractSensorsDataAPI.getConfigOptions().isAutoAddChannelCallbackEvent, str2, jSONObject2, SensorsDataAPI.this.mContext), (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void trackTimerEnd(String str) {
        trackTimerEnd(str, (JSONObject) null);
    }

    public void clearTrackTimer() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        SensorsDataAPI.this.mTrackTimer.clear();
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public String getLastScreenUrl() {
        return this.mLastScreenUrl;
    }

    public void clearReferrerWhenAppEnd() {
        this.mClearReferrerWhenAppEnd = true;
    }

    public void clearLastScreenUrl() {
        if (this.mClearReferrerWhenAppEnd) {
            this.mLastScreenUrl = null;
        }
    }

    public JSONObject getLastScreenTrackProperties() {
        return this.mLastScreenTrackProperties;
    }

    @Deprecated
    public void trackViewScreen(final String str, final JSONObject jSONObject) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    if (!TextUtils.isEmpty(str) || jSONObject != null) {
                        String str = str;
                        JSONObject jSONObject = new JSONObject();
                        SensorsDataAPI.this.mLastScreenTrackProperties = jSONObject;
                        if (SensorsDataAPI.this.mLastScreenUrl != null) {
                            jSONObject.put("$referrer", SensorsDataAPI.this.mLastScreenUrl);
                        }
                        SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                        sensorsDataAPI.mReferrerScreenTitle = sensorsDataAPI.mCurrentScreenTitle;
                        JSONObject jSONObject2 = jSONObject;
                        if (jSONObject2 != null) {
                            if (jSONObject2.has(AopConstants.TITLE)) {
                                SensorsDataAPI.this.mCurrentScreenTitle = jSONObject.getString(AopConstants.TITLE);
                            } else {
                                SensorsDataAPI.this.mCurrentScreenTitle = null;
                            }
                            if (jSONObject.has("$url")) {
                                str = jSONObject.optString("$url");
                            }
                        }
                        jSONObject.put("$url", str);
                        SensorsDataAPI.this.mLastScreenUrl = str;
                        JSONObject jSONObject3 = jSONObject;
                        if (jSONObject3 != null) {
                            SensorsDataUtils.mergeJSONObject(jSONObject3, jSONObject);
                        }
                        SensorsDataAPI.this.trackEvent(EventType.TRACK, "$AppViewScreen", jSONObject, (String) null);
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void trackViewScreen(final Activity activity) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    Activity activity = activity;
                    if (activity != null) {
                        SensorsDataAPI.this.trackViewScreen(SensorsDataUtils.getScreenUrl(activity), AopUtil.buildTitleAndScreenName(activity));
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void trackViewScreen(final Object obj) {
        Class<?> cls;
        Class<?> cls2;
        if (obj != null) {
            Class<?> cls3 = null;
            try {
                cls = Class.forName("androidx.fragment.app.Fragment");
            } catch (Exception unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName("android.app.Fragment");
            } catch (Exception unused2) {
                cls2 = null;
            }
            try {
                cls3 = Class.forName("androidx.fragment.app.Fragment");
            } catch (Exception unused3) {
            }
            if ((cls != null && cls.isInstance(obj)) || ((cls2 != null && cls2.isInstance(obj)) || (cls3 != null && cls3.isInstance(obj)))) {
                this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
                        r2 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r5.getClass().getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class);
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r8 = this;
                            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a7 }
                            r0.<init>()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r1 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r1 = r1.getCanonicalName()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r2 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r3 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
                            boolean r2 = r2.isAnnotationPresent(r3)     // Catch:{ Exception -> 0x00a7 }
                            r3 = 0
                            if (r2 == 0) goto L_0x0033
                            java.lang.Object r2 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r4 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
                            java.lang.annotation.Annotation r2 = r2.getAnnotation(r4)     // Catch:{ Exception -> 0x00a7 }
                            com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle r2 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r2     // Catch:{ Exception -> 0x00a7 }
                            if (r2 == 0) goto L_0x0033
                            java.lang.String r2 = r2.title()     // Catch:{ Exception -> 0x00a7 }
                            goto L_0x0034
                        L_0x0033:
                            r2 = r3
                        L_0x0034:
                            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00a7 }
                            r5 = 11
                            if (r4 < r5) goto L_0x007a
                            r4 = 0
                            java.lang.Object r5 = r5     // Catch:{ Exception -> 0x0056 }
                            java.lang.Class r5 = r5.getClass()     // Catch:{ Exception -> 0x0056 }
                            java.lang.String r6 = "getActivity"
                            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0056 }
                            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch:{ Exception -> 0x0056 }
                            if (r5 == 0) goto L_0x0056
                            java.lang.Object r6 = r5     // Catch:{ Exception -> 0x0056 }
                            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0056 }
                            java.lang.Object r5 = r5.invoke(r6, r7)     // Catch:{ Exception -> 0x0056 }
                            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ Exception -> 0x0056 }
                            r3 = r5
                        L_0x0056:
                            if (r3 == 0) goto L_0x007a
                            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a7 }
                            if (r5 == 0) goto L_0x0062
                            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(r3)     // Catch:{ Exception -> 0x00a7 }
                        L_0x0062:
                            java.util.Locale r5 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r6 = "%s|%s"
                            r7 = 2
                            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r3 = r3.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r3 = r3.getCanonicalName()     // Catch:{ Exception -> 0x00a7 }
                            r7[r4] = r3     // Catch:{ Exception -> 0x00a7 }
                            r3 = 1
                            r7[r3] = r1     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r1 = java.lang.String.format(r5, r6, r7)     // Catch:{ Exception -> 0x00a7 }
                        L_0x007a:
                            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a7 }
                            if (r3 != 0) goto L_0x0085
                            java.lang.String r3 = "$title"
                            r0.put(r3, r2)     // Catch:{ Exception -> 0x00a7 }
                        L_0x0085:
                            java.lang.String r2 = "$screen_name"
                            r0.put(r2, r1)     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r1 = r5     // Catch:{ Exception -> 0x00a7 }
                            boolean r2 = r1 instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker     // Catch:{ Exception -> 0x00a7 }
                            if (r2 == 0) goto L_0x009b
                            com.sensorsdata.analytics.android.sdk.ScreenAutoTracker r1 = (com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) r1     // Catch:{ Exception -> 0x00a7 }
                            org.json.JSONObject r1 = r1.getTrackProperties()     // Catch:{ Exception -> 0x00a7 }
                            if (r1 == 0) goto L_0x009b
                            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r1, r0)     // Catch:{ Exception -> 0x00a7 }
                        L_0x009b:
                            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r2 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getScreenUrl(r2)     // Catch:{ Exception -> 0x00a7 }
                            r1.trackViewScreen(r2, r0)     // Catch:{ Exception -> 0x00a7 }
                            goto L_0x00ab
                        L_0x00a7:
                            r0 = move-exception
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
                        L_0x00ab:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass18.run():void");
                    }
                });
            }
        }
    }

    public void trackViewAppClick(View view) {
        trackViewAppClick(view, (JSONObject) null);
    }

    public void trackViewAppClick(View view, JSONObject jSONObject) {
        if (view != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (AopUtil.injectClickInfo(view, jSONObject, true)) {
                trackInternal(AopConstants.APP_CLICK_EVENT_NAME, jSONObject, AopUtil.addViewPathProperties(AopUtil.getActivityFromContext(view.getContext(), view), view, jSONObject));
            }
        }
    }

    public void flush() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mMessages.flush();
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void flushSync() {
        flush();
    }

    public void flushScheduled() {
        try {
            this.mMessages.flushScheduled();
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
        this.mDynamicSuperPropertiesCallBack = sensorsDataDynamicSuperProperties;
    }

    public void setTrackEventCallBack(SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
        this.mTrackEventCallBack = sensorsDataTrackEventCallBack;
    }

    public void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        this.mDeepLinkCallback = sensorsDataDeepLinkCallback;
    }

    public void stopTrackThread() {
        if (this.mTrackTaskManagerThread != null && !this.mTrackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread.stop();
            SALog.i("SA.SensorsDataAPI", "Data collection thread has been stopped");
        }
    }

    public void startTrackThread() {
        if (this.mTrackTaskManagerThread == null || this.mTrackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread = new TrackTaskManagerThread();
            new Thread(this.mTrackTaskManagerThread).start();
            SALog.i("SA.SensorsDataAPI", "Data collection thread has been started");
        }
    }

    @Deprecated
    public void enableDataCollect() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    if (!AbstractSensorsDataAPI.mSAConfigOptions.isDataCollectEnable) {
                        SensorsDataAPI.this.mContext.getContentResolver().notifyChange(DbParams.getInstance().getDataCollectUri(), (ContentObserver) null);
                    }
                    AbstractSensorsDataAPI.mSAConfigOptions.isDataCollectEnable = true;
                    AbstractSensorsDataAPI.mIsMainProcess = AppInfoUtils.isMainProcess(SensorsDataAPI.this.mContext, (Bundle) null);
                    SensorsDataAPI.this.mSAContextManager.getDeviceInfo();
                    SensorsDataAPI.this.mTrackTaskManager.setDataCollectEnable(true);
                    if (SensorsDataAPI.this.mFirstDay.get() == null) {
                        SensorsDataAPI.this.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), TimeUtils.YYYY_MM_DD));
                    }
                    try {
                        if (SensorsDataAPI.this.mFunctionListenerList != null) {
                            for (SAFunctionListener call : SensorsDataAPI.this.mFunctionListenerList) {
                                call.call("enableDataCollect", (JSONObject) null);
                            }
                        }
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            });
            flush();
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void deleteAll() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.mMessages.deleteAll();
            }
        });
    }

    public JSONObject getSuperProperties() {
        JSONObject jSONObject;
        synchronized (this.mSuperProperties) {
            try {
                jSONObject = new JSONObject(((JSONObject) this.mSuperProperties.get()).toString());
            } catch (JSONException e) {
                SALog.printStackTrace(e);
                return new JSONObject();
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    public void registerSuperProperties(final JSONObject jSONObject) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONObject jSONObject = jSONObject;
                    if (jSONObject != null) {
                        SADataHelper.assertPropertyTypes(jSONObject);
                        synchronized (SensorsDataAPI.this.mSuperProperties) {
                            SensorsDataAPI.this.mSuperProperties.commit(SensorsDataUtils.mergeSuperJSONObject(jSONObject, (JSONObject) SensorsDataAPI.this.mSuperProperties.get()));
                        }
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void unregisterSuperProperty(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    synchronized (SensorsDataAPI.this.mSuperProperties) {
                        JSONObject jSONObject = (JSONObject) SensorsDataAPI.this.mSuperProperties.get();
                        jSONObject.remove(str);
                        SensorsDataAPI.this.mSuperProperties.commit(jSONObject);
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void clearSuperProperties() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                synchronized (SensorsDataAPI.this.mSuperProperties) {
                    SensorsDataAPI.this.mSuperProperties.commit(new JSONObject());
                }
            }
        });
    }

    public void profileSet(final JSONObject jSONObject) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET, (String) null, jSONObject, (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileSet(final String str, final Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET, (String) null, new JSONObject().put(str, obj), (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileSetOnce(final JSONObject jSONObject) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET_ONCE, (String) null, jSONObject, (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileSetOnce(final String str, final Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET_ONCE, (String) null, new JSONObject().put(str, obj), (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileIncrement(final Map<String, ? extends Number> map) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_INCREMENT, (String) null, new JSONObject(map), (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileIncrement(final String str, final Number number) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_INCREMENT, (String) null, new JSONObject().put(str, number), (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileAppend(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, jSONArray);
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_APPEND, (String) null, jSONObject, (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileAppend(final String str, final Set<String> set) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : set) {
                        jSONArray.put(put);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, jSONArray);
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_APPEND, (String) null, jSONObject, (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileUnset(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_UNSET, (String) null, new JSONObject().put(str, true), (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileDelete() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_DELETE, (String) null, (JSONObject) null, (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public boolean isDebugMode() {
        return this.mDebugMode.isDebugMode();
    }

    public boolean isNetworkRequestEnable() {
        return this.mEnableNetworkRequest;
    }

    public void enableNetworkRequest(boolean z) {
        this.mEnableNetworkRequest = z;
    }

    public void setServerUrl(String str) {
        setServerUrl(str, false);
    }

    public void setServerUrl(final String str, boolean z) {
        int lastIndexOf;
        if (z) {
            try {
                if (this.mRemoteManager != null) {
                    try {
                        this.mRemoteManager.requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                SALog.printStackTrace(e2);
                return;
            }
        }
        if (!TextUtils.equals(str, this.mOriginServerUrl) && getConfigOptions().isVisualizedPropertiesEnabled()) {
            try {
                VisualPropertiesManager.getInstance().requestVisualConfig();
            } catch (Exception e3) {
                SALog.printStackTrace(e3);
            }
        }
        this.mOriginServerUrl = str;
        if (TextUtils.isEmpty(str)) {
            this.mServerUrl = str;
            SALog.i("SA.SensorsDataAPI", "Server url is null or empty.");
            return;
        }
        final Uri parse = Uri.parse(str);
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                String host = parse.getHost();
                if (!TextUtils.isEmpty(host) && host.contains("_")) {
                    SALog.i("SA.SensorsDataAPI", "Server url " + str + " contains '_' is not recommend，see details: https://en.wikipedia.org/wiki/Hostname");
                }
            }
        });
        if (this.mDebugMode != DebugMode.DEBUG_OFF) {
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path) && (lastIndexOf = path.lastIndexOf(47)) != -1) {
                this.mServerUrl = parse.buildUpon().path(path.substring(0, lastIndexOf) + "/debug").build().toString();
                return;
            }
            return;
        }
        this.mServerUrl = str;
    }

    public void trackEventFromH5(String str, boolean z) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z) {
                    String optString = jSONObject.optString("server_url");
                    if (TextUtils.isEmpty(optString) || !new ServerUrl(optString).check(new ServerUrl(this.mServerUrl))) {
                        return;
                    }
                }
                trackEventFromH5(str);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void trackEventFromH5(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.trackEventH5(str);
            }
        });
    }

    public void profilePushId(final String str, final String str2) {
        transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertKey(str);
                    if (TextUtils.isEmpty(str2)) {
                        SALog.d("SA.SensorsDataAPI", "pushId is empty");
                        return;
                    }
                    String str = SensorsDataAPI.this.getDistinctId() + str2;
                    SharedPreferences sharedPreferences = SensorsDataUtils.getSharedPreferences(SensorsDataAPI.this.mContext);
                    if (!sharedPreferences.getString("distinctId_" + str, "").equals(str)) {
                        SensorsDataAPI.this.profileSet(str, str2);
                        sharedPreferences.edit().putString("distinctId_" + str, str).apply();
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void profileUnsetPushId(final String str) {
        transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertKey(str);
                    String distinctId = SensorsDataAPI.this.getDistinctId();
                    SharedPreferences sharedPreferences = SensorsDataUtils.getSharedPreferences(SensorsDataAPI.this.mContext);
                    String str = "distinctId_" + str;
                    if (sharedPreferences.getString(str, "").startsWith(distinctId)) {
                        SensorsDataAPI.this.profileUnset(str);
                        sharedPreferences.edit().remove(str).apply();
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void itemSet(final String str, final String str2, final JSONObject jSONObject) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.trackItemEvent(str, str2, EventType.ITEM_SET.getEventType(), System.currentTimeMillis(), jSONObject);
            }
        });
    }

    public void itemDelete(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.trackItemEvent(str, str2, EventType.ITEM_DELETE.getEventType(), System.currentTimeMillis(), (JSONObject) null);
            }
        });
    }

    public void enableDeepLinkInstallSource(boolean z) {
        this.mEnableDeepLinkInstallSource = z;
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    public void trackDeepLinkLaunch(String str) {
        trackDeepLinkLaunch(str, (String) null);
    }

    public void trackDeepLinkLaunch(String str, final String str2) {
        final JSONObject jSONObject = new JSONObject();
        final boolean isDeepLinkInstallSource = isDeepLinkInstallSource();
        try {
            jSONObject.put("$deeplink_url", str);
            jSONObject.put("$time", new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        sharedInstance().transformTaskQueue(new Runnable() {
            public void run() {
                if (isDeepLinkInstallSource) {
                    try {
                        JSONObject jSONObject = jSONObject;
                        Context context = SensorsDataAPI.this.mContext;
                        String androidId = SensorsDataAPI.this.mSAContextManager.getAndroidId();
                        String str = str2;
                        if (str == null) {
                            str = OaidHelper.getOAID(SensorsDataAPI.this.mContext);
                        }
                        jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(context, androidId, str));
                    } catch (JSONException e) {
                        SALog.printStackTrace(e);
                    }
                }
                SensorsDataAPI.this.trackInternal("$AppDeeplinkLaunch", jSONObject);
            }
        });
    }

    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);
        
        private final boolean debugMode;
        private final boolean debugWriteData;

        private DebugMode(boolean z, boolean z2) {
            this.debugMode = z;
            this.debugWriteData = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean isDebugMode() {
            return this.debugMode;
        }

        /* access modifiers changed from: package-private */
        public boolean isDebugWriteData() {
            return this.debugWriteData;
        }
    }

    public enum AutoTrackEventType {
        APP_START(1),
        APP_END(2),
        APP_CLICK(4),
        APP_VIEW_SCREEN(8);
        
        /* access modifiers changed from: private */
        public final int eventValue;

        static String autoTrackEventName(int i) {
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "" : "$AppViewScreen" : AopConstants.APP_CLICK_EVENT_NAME : "$AppEnd" : "$AppStart";
        }

        private AutoTrackEventType(int i) {
            this.eventValue = i;
        }

        static AutoTrackEventType autoTrackEventTypeFromEventName(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -618659154:
                    if (str.equals("$AppViewScreen")) {
                        c = 0;
                        break;
                    }
                    break;
                case -441870274:
                    if (str.equals("$AppEnd")) {
                        c = 1;
                        break;
                    }
                    break;
                case 562530347:
                    if (str.equals(AopConstants.APP_CLICK_EVENT_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case 577537797:
                    if (str.equals("$AppStart")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return APP_VIEW_SCREEN;
                case 1:
                    return APP_END;
                case 2:
                    return APP_CLICK;
                case 3:
                    return APP_START;
                default:
                    return null;
            }
        }

        static boolean isAutoTrackType(String str) {
            if (!TextUtils.isEmpty(str)) {
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -618659154:
                        if (str.equals("$AppViewScreen")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -441870274:
                        if (str.equals("$AppEnd")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 562530347:
                        if (str.equals(AopConstants.APP_CLICK_EVENT_NAME)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 577537797:
                        if (str.equals("$AppStart")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int getEventValue() {
            return this.eventValue;
        }
    }

    public final class NetworkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 16;
        public static final int TYPE_ALL = 255;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_WIFI = 8;

        public NetworkType() {
        }
    }
}
