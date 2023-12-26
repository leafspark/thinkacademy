package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.OaidHelper;
import com.sensorsdata.analytics.android.sdk.aop.push.PushLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.ActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.ActivityPageLeaveCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.FragmentPageLeaveCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.FragmentViewScreenCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallation;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallationWithCallback;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.internal.api.FragmentAPI;
import com.sensorsdata.analytics.android.sdk.internal.api.IFragmentAPI;
import com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SAContextManager;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.live.util.ViewLevelCons;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class AbstractSensorsDataAPI implements ISensorsDataAPI {
    static boolean SHOW_DEBUG_INFO_VIEW = true;
    protected static final String TAG = "SA.SensorsDataAPI";
    static final String VERSION = "6.0.0";
    protected static boolean isChangeEnableNetworkFlag = false;
    protected static SensorsDataGPSLocation mGPSLocation;
    static boolean mIsMainProcess = false;
    protected static SAConfigOptions mSAConfigOptions;
    protected static final Map<Context, SensorsDataAPI> sInstanceMap = new HashMap();
    private boolean isTrackEventWithPluginVersion;
    protected ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    protected boolean mAutoTrack;
    protected List<Integer> mAutoTrackIgnoredActivities;
    protected boolean mClearReferrerWhenAppEnd;
    protected final Context mContext;
    protected String mCookie;
    protected String mCurrentScreenTitle;
    protected SensorsDataAPI.DebugMode mDebugMode;
    protected SensorsDataDeepLinkCallback mDeepLinkCallback;
    protected boolean mDisableDefaultRemoteConfig;
    protected boolean mDisableTrackDeviceId;
    protected final PersistentDistinctId mDistinctId;
    protected SensorsDataDynamicSuperProperties mDynamicSuperPropertiesCallBack;
    boolean mEnableDeepLinkInstallSource;
    protected boolean mEnableNetworkRequest;
    protected List<SAEventListener> mEventListenerList;
    protected final PersistentFirstDay mFirstDay;
    protected final PersistentFirstStart mFirstStart;
    protected final PersistentFirstTrackInstallation mFirstTrackInstallation;
    protected final PersistentFirstTrackInstallationWithCallback mFirstTrackInstallationWithCallback;
    protected IFragmentAPI mFragmentAPI;
    protected List<SAFunctionListener> mFunctionListenerList;
    protected List<Integer> mHeatMapActivities;
    protected List<Class> mIgnoredViewTypeList;
    protected SimpleDateFormat mIsFirstDayDateFormat;
    protected JSONObject mLastScreenTrackProperties;
    protected String mLastScreenUrl;
    protected String mLoginId;
    protected final Object mLoginIdLock;
    protected AnalyticsMessages mMessages;
    protected SensorsDataScreenOrientationDetector mOrientationDetector;
    protected String mOriginServerUrl;
    protected String mReferrerScreenTitle;
    BaseSensorsDataSDKRemoteManager mRemoteManager;
    protected SAContextManager mSAContextManager;
    private CopyOnWriteArrayList<SAJSListener> mSAJSListeners;
    protected boolean mSDKConfigInit;
    SensorsDataEncrypt mSensorsDataEncrypt;
    protected String mServerUrl;
    protected int mSessionTime;
    protected final PersistentSuperProperties mSuperProperties;
    protected SensorsDataTrackEventCallBack mTrackEventCallBack;
    protected TrackTaskManager mTrackTaskManager;
    protected TrackTaskManagerThread mTrackTaskManagerThread;
    protected final Map<String, EventTimer> mTrackTimer;
    protected List<Integer> mVisualizedAutoTrackActivities;

    public AbstractSensorsDataAPI(Context context, SAConfigOptions sAConfigOptions, SensorsDataAPI.DebugMode debugMode) {
        this.mLoginIdLock = new Object();
        this.mIgnoredViewTypeList = new ArrayList();
        this.mLoginId = null;
        this.mDebugMode = SensorsDataAPI.DebugMode.DEBUG_OFF;
        this.mEnableNetworkRequest = true;
        this.mClearReferrerWhenAppEnd = false;
        this.mDisableDefaultRemoteConfig = false;
        this.mDisableTrackDeviceId = false;
        this.mSessionTime = 30000;
        this.mEnableDeepLinkInstallSource = false;
        this.isTrackEventWithPluginVersion = false;
        this.mContext = context;
        setDebugMode(debugMode);
        String packageName = context.getApplicationContext().getPackageName();
        this.mAutoTrackIgnoredActivities = new ArrayList();
        this.mHeatMapActivities = new ArrayList();
        this.mVisualizedAutoTrackActivities = new ArrayList();
        PersistentLoader.initLoader(context);
        this.mDistinctId = (PersistentDistinctId) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.DISTINCT_ID);
        this.mSuperProperties = (PersistentSuperProperties) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.SUPER_PROPERTIES);
        this.mFirstStart = (PersistentFirstStart) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.FIRST_START);
        this.mFirstTrackInstallation = (PersistentFirstTrackInstallation) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.FIRST_INSTALL);
        this.mFirstTrackInstallationWithCallback = (PersistentFirstTrackInstallationWithCallback) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.FIRST_INSTALL_CALLBACK);
        this.mFirstDay = (PersistentFirstDay) PersistentLoader.loadPersistent(PersistentLoader.PersistentName.FIRST_DAY);
        this.mTrackTimer = new HashMap();
        this.mFragmentAPI = new FragmentAPI();
        try {
            mSAConfigOptions = sAConfigOptions.clone();
            this.mTrackTaskManager = TrackTaskManager.getInstance();
            this.mTrackTaskManagerThread = new TrackTaskManagerThread();
            new Thread(this.mTrackTaskManagerThread, ThreadNameConstants.THREAD_TASK_QUEUE).start();
            SensorsDataExceptionHandler.init();
            initSAConfig(mSAConfigOptions.mServerUrl, packageName);
            this.mSAContextManager = new SAContextManager(context, this.mDisableTrackDeviceId);
            this.mMessages = AnalyticsMessages.getInstance(context, (SensorsDataAPI) this);
            SensorsDataRemoteManager sensorsDataRemoteManager = new SensorsDataRemoteManager((SensorsDataAPI) this);
            this.mRemoteManager = sensorsDataRemoteManager;
            sensorsDataRemoteManager.applySDKConfigFromCache();
            if (mSAConfigOptions.isVisualizedPropertiesEnabled()) {
                VisualPropertiesManager.getInstance().requestVisualConfig(context, (SensorsDataAPI) this);
            }
            if (this.mDebugMode != SensorsDataAPI.DebugMode.DEBUG_OFF && mIsMainProcess && SHOW_DEBUG_INFO_VIEW && !isSDKDisabled()) {
                showDebugModeWarning();
            }
            registerLifecycleCallbacks();
            registerObserver();
            if (!mSAConfigOptions.isDisableSDK()) {
                delayInitTask();
            }
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, String.format(Locale.CHINA, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", new Object[]{this.mServerUrl, Integer.valueOf(mSAConfigOptions.mFlushInterval), debugMode}));
            }
            this.mLoginId = DbAdapter.getInstance().getLoginId();
            SensorsDataUtils.initUniAppStatus();
        } catch (Throwable th) {
            SALog.d(TAG, th.getMessage());
        }
    }

    protected AbstractSensorsDataAPI() {
        this.mLoginIdLock = new Object();
        this.mIgnoredViewTypeList = new ArrayList();
        this.mLoginId = null;
        this.mDebugMode = SensorsDataAPI.DebugMode.DEBUG_OFF;
        this.mEnableNetworkRequest = true;
        this.mClearReferrerWhenAppEnd = false;
        this.mDisableDefaultRemoteConfig = false;
        this.mDisableTrackDeviceId = false;
        this.mSessionTime = 30000;
        this.mEnableDeepLinkInstallSource = false;
        this.isTrackEventWithPluginVersion = false;
        this.mContext = null;
        this.mMessages = null;
        this.mDistinctId = null;
        this.mSuperProperties = null;
        this.mFirstStart = null;
        this.mFirstDay = null;
        this.mFirstTrackInstallation = null;
        this.mFirstTrackInstallationWithCallback = null;
        this.mTrackTimer = null;
        this.mSensorsDataEncrypt = null;
    }

    /* access modifiers changed from: protected */
    public void delayExecution(Activity activity) {
        ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            activityLifecycleCallbacks.onActivityCreated(activity, (Bundle) null);
            AppStateManager.getInstance().onActivityCreated(activity, (Bundle) null);
            this.mActivityLifecycleCallbacks.onActivityStarted(activity);
        }
        if (SALog.isLogEnabled()) {
            SALog.i(TAG, "SDK init success by：" + activity.getClass().getName());
        }
    }

    private static boolean isSDKDisabledByRemote() {
        boolean isSDKDisabledByRemote = SensorsDataRemoteManager.isSDKDisabledByRemote();
        if (isSDKDisabledByRemote) {
            SALog.i(TAG, "remote config: SDK is disabled");
        }
        return isSDKDisabledByRemote;
    }

    private static boolean isSDKDisableByLocal() {
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions != null) {
            return sAConfigOptions.isDisableSDK;
        }
        SALog.i(TAG, "SAConfigOptions is null");
        return true;
    }

    public static boolean isSDKDisabled() {
        return isSDKDisableByLocal() || isSDKDisabledByRemote();
    }

    public void addEventListener(SAEventListener sAEventListener) {
        try {
            if (this.mEventListenerList == null) {
                this.mEventListenerList = new ArrayList();
            }
            this.mEventListenerList.add(sAEventListener);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void removeEventListener(SAEventListener sAEventListener) {
        try {
            List<SAEventListener> list = this.mEventListenerList;
            if (list != null && list.contains(sAEventListener)) {
                this.mEventListenerList.remove(sAEventListener);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void addSAJSListener(SAJSListener sAJSListener) {
        try {
            if (this.mSAJSListeners == null) {
                this.mSAJSListeners = new CopyOnWriteArrayList<>();
            }
            if (!this.mSAJSListeners.contains(sAJSListener)) {
                this.mSAJSListeners.add(sAJSListener);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void removeSAJSListener(SAJSListener sAJSListener) {
        try {
            CopyOnWriteArrayList<SAJSListener> copyOnWriteArrayList = this.mSAJSListeners;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(sAJSListener)) {
                this.mSAJSListeners.remove(sAJSListener);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleJsMessage(WeakReference<View> weakReference, String str) {
        CopyOnWriteArrayList<SAJSListener> copyOnWriteArrayList = this.mSAJSListeners;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<SAJSListener> it = this.mSAJSListeners.iterator();
            while (it.hasNext()) {
                SAJSListener next = it.next();
                if (next != null) {
                    try {
                        next.onReceiveJSMessage(weakReference, str);
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            }
        }
    }

    public void addFunctionListener(SAFunctionListener sAFunctionListener) {
        try {
            if (this.mFunctionListenerList == null) {
                this.mFunctionListenerList = new ArrayList();
            }
            if (sAFunctionListener != null && !this.mFunctionListenerList.contains(sAFunctionListener)) {
                this.mFunctionListenerList.add(sAFunctionListener);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void removeFunctionListener(SAFunctionListener sAFunctionListener) {
        try {
            List<SAFunctionListener> list = this.mFunctionListenerList;
            if (list != null && sAFunctionListener != null) {
                list.remove(sAFunctionListener);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static SAConfigOptions getConfigOptions() {
        return mSAConfigOptions;
    }

    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public boolean isSaveDeepLinkInfo() {
        return mSAConfigOptions.mEnableSaveDeepLinkInfo;
    }

    public SensorsDataDeepLinkCallback getDeepLinkCallback() {
        return this.mDeepLinkCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean _trackEventFromH5(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String optString = new JSONObject(str).optString("server_url");
            if (TextUtils.isEmpty(optString) || !new ServerUrl(optString).check(new ServerUrl(this.mServerUrl))) {
                return false;
            }
            trackEventFromH5(str);
            return true;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return false;
    }

    public void trackInternal(String str, JSONObject jSONObject) {
        trackInternal(str, jSONObject, (ViewNode) null);
    }

    public void trackInternal(final String str, final JSONObject jSONObject, final ViewNode viewNode) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    if (viewNode != null && SensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                        VisualPropertiesManager.getInstance().mergeVisualProperties(VisualPropertiesManager.VisualEventType.APP_CLICK, jSONObject, viewNode);
                    }
                    AbstractSensorsDataAPI.this.trackEvent(EventType.TRACK, str, jSONObject, (String) null);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public SensorsDataAPI.DebugMode getDebugMode() {
        return this.mDebugMode;
    }

    public void setDebugMode(SensorsDataAPI.DebugMode debugMode) {
        this.mDebugMode = debugMode;
        if (debugMode == SensorsDataAPI.DebugMode.DEBUG_OFF) {
            enableLog(false);
            SALog.setDebug(false);
            this.mServerUrl = this.mOriginServerUrl;
            return;
        }
        enableLog(true);
        SALog.setDebug(true);
        setServerUrl(this.mOriginServerUrl);
    }

    /* access modifiers changed from: package-private */
    public void enableAutoTrack(int i) {
        if (i > 0 && i <= 15) {
            try {
                this.mAutoTrack = true;
                SAConfigOptions sAConfigOptions = mSAConfigOptions;
                sAConfigOptions.setAutoTrackEventType(i | sAConfigOptions.mAutoTrackEventType);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public BaseSensorsDataSDKRemoteManager getRemoteManager() {
        return this.mRemoteManager;
    }

    public void setRemoteManager(BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        this.mRemoteManager = baseSensorsDataSDKRemoteManager;
    }

    public SensorsDataEncrypt getSensorsDataEncrypt() {
        return this.mSensorsDataEncrypt;
    }

    public boolean isDisableDefaultRemoteConfig() {
        return this.mDisableDefaultRemoteConfig;
    }

    public void appBecomeActive() {
        EventTimer eventTimer;
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry next : this.mTrackTimer.entrySet()) {
                    if (!(next == null || (eventTimer = (EventTimer) next.getValue()) == null)) {
                        eventTimer.setStartTime(SystemClock.elapsedRealtime());
                    }
                }
            } catch (Exception e) {
                SALog.i(TAG, "appBecomeActive error:" + e.getMessage());
            }
        }
    }

    public void appEnterBackground() {
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry next : this.mTrackTimer.entrySet()) {
                    if (next != null) {
                        if (!"$AppEnd".equals(next.getKey())) {
                            EventTimer eventTimer = (EventTimer) next.getValue();
                            if (eventTimer != null && !eventTimer.isPaused()) {
                                eventTimer.setEventAccumulatedDuration(((eventTimer.getEventAccumulatedDuration() + SystemClock.elapsedRealtime()) - eventTimer.getStartTime()) - ((long) getSessionIntervalTime()));
                                eventTimer.setStartTime(SystemClock.elapsedRealtime());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SALog.i(TAG, "appEnterBackground error:" + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void trackChannelDebugInstallation() {
        final JSONObject jSONObject = new JSONObject();
        addTimeProperty(jSONObject);
        transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(AbstractSensorsDataAPI.this.mContext, AbstractSensorsDataAPI.this.mSAContextManager.getAndroidId(), OaidHelper.getOAID(AbstractSensorsDataAPI.this.mContext)));
                    AbstractSensorsDataAPI.this.trackEvent(EventType.TRACK, "$ChannelDebugInstall", jSONObject, (String) null);
                    JSONObject jSONObject = new JSONObject();
                    SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject);
                    jSONObject.put("$first_visit_time", new Date());
                    AbstractSensorsDataAPI.this.trackEvent(EventType.PROFILE_SET_ONCE, (String) null, jSONObject, (String) null);
                    AbstractSensorsDataAPI.this.flush();
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    public void trackAutoEvent(String str, JSONObject jSONObject) {
        trackAutoEvent(str, jSONObject, (ViewNode) null);
    }

    /* access modifiers changed from: package-private */
    public void trackAutoEvent(String str, JSONObject jSONObject, ViewNode viewNode) {
        trackInternal(str, SADataHelper.appendLibMethodAutoTrack(jSONObject), viewNode);
    }

    public SAContextManager getSAContextManager() {
        return this.mSAContextManager;
    }

    /* access modifiers changed from: package-private */
    public void registerNetworkListener() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                NetworkUtils.registerNetworkListener(AbstractSensorsDataAPI.this.mContext);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void unregisterNetworkListener() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                NetworkUtils.unregisterNetworkListener(AbstractSensorsDataAPI.this.mContext);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void addTimeProperty(JSONObject jSONObject) {
        if (!jSONObject.has("$time")) {
            try {
                jSONObject.put("$time", new Date(System.currentTimeMillis()));
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFirstDay(long j) {
        String str = (String) this.mFirstDay.get();
        if (str == null) {
            return true;
        }
        try {
            if (this.mIsFirstDayDateFormat == null) {
                this.mIsFirstDayDateFormat = new SimpleDateFormat(TimeUtils.YYYY_MM_DD, Locale.getDefault());
            }
            return str.equals(this.mIsFirstDayDateFormat.format(Long.valueOf(j)));
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void trackItemEvent(String str, String str2, String str3, long j, JSONObject jSONObject) {
        try {
            SADataHelper.assertKey(str);
            SADataHelper.assertValue(str2);
            SADataHelper.assertPropertyTypes(jSONObject);
            if (!mSAConfigOptions.isDataCollectEnable) {
                transformItemTaskQueue(str, str2, str3, j, jSONObject);
                return;
            }
            String str4 = null;
            if (jSONObject != null && jSONObject.has("$project")) {
                str4 = (String) jSONObject.get("$project");
                jSONObject.remove("$project");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("$lib", "Android");
            jSONObject2.put("$lib_version", "6.0.0");
            jSONObject2.put("$lib_method", "code");
            this.mSAContextManager.addKeyIfExist(jSONObject2, "$app_version");
            JSONObject jSONObject3 = (JSONObject) this.mSuperProperties.get();
            if (jSONObject3 != null && jSONObject3.has("$app_version")) {
                jSONObject2.put("$app_version", jSONObject3.get("$app_version"));
            }
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            if (stackTrace.length > 1) {
                StackTraceElement stackTraceElement = stackTrace[0];
                String format = String.format("%s##%s##%s##%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())});
                if (!TextUtils.isEmpty(format)) {
                    jSONObject2.put("$lib_detail", format);
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("item_type", str);
            jSONObject4.put("item_id", str2);
            jSONObject4.put(ClassParamsKt.TYPE, str3);
            jSONObject4.put("time", j);
            jSONObject4.put("properties", TimeUtils.formatDate(jSONObject));
            jSONObject4.put("lib", jSONObject2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject4.put("project", str4);
            }
            this.mMessages.enqueueEventMessage(str3, jSONObject4);
            SALog.i(TAG, "track event:\n" + JSONUtils.formatJson(jSONObject4.toString()));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: protected */
    public void trackEvent(EventType eventType, String str, JSONObject jSONObject, String str2) {
        trackEvent(eventType, str, jSONObject, (JSONObject) null, getDistinctId(), getLoginId(), str2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:74|75|76) */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012b, code lost:
        throw new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException("Unexpected property");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0124 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackEvent(com.sensorsdata.analytics.android.sdk.EventType r12, java.lang.String r13, org.json.JSONObject r14, org.json.JSONObject r15, java.lang.String r16, java.lang.String r17, java.lang.String r18) {
        /*
            r11 = this;
            r10 = r11
            r0 = r13
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x012c }
            if (r2 != 0) goto L_0x003a
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.EventTimer> r1 = r10.mTrackTimer     // Catch:{ Exception -> 0x012c }
            monitor-enter(r1)     // Catch:{ Exception -> 0x012c }
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.EventTimer> r2 = r10.mTrackTimer     // Catch:{ all -> 0x0037 }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x0037 }
            com.sensorsdata.analytics.android.sdk.EventTimer r2 = (com.sensorsdata.analytics.android.sdk.EventTimer) r2     // Catch:{ all -> 0x0037 }
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.EventTimer> r3 = r10.mTrackTimer     // Catch:{ all -> 0x0037 }
            r3.remove(r13)     // Catch:{ all -> 0x0037 }
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "_SATimer"
            boolean r1 = r13.endsWith(r1)     // Catch:{ Exception -> 0x012c }
            if (r1 == 0) goto L_0x0034
            int r1 = r13.length()     // Catch:{ Exception -> 0x012c }
            r3 = 45
            if (r1 <= r3) goto L_0x0034
            r1 = 0
            int r4 = r13.length()     // Catch:{ Exception -> 0x012c }
            int r4 = r4 - r3
            java.lang.String r0 = r13.substring(r1, r4)     // Catch:{ Exception -> 0x012c }
        L_0x0034:
            r3 = r0
            r9 = r2
            goto L_0x003c
        L_0x0037:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            throw r0     // Catch:{ Exception -> 0x012c }
        L_0x003a:
            r3 = r0
            r9 = r1
        L_0x003c:
            boolean r0 = r12.isTrack()     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0050
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertKey(r3)     // Catch:{ Exception -> 0x012c }
            com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager r0 = r10.mRemoteManager     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0050
            boolean r0 = r0.ignoreEvent(r3)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0050
            return
        L_0x0050:
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(r14)     // Catch:{ Exception -> 0x012c }
            boolean r0 = r12.isTrack()     // Catch:{ JSONException -> 0x0124 }
            if (r0 == 0) goto L_0x00cb
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r10.mSAContextManager     // Catch:{ JSONException -> 0x0124 }
            java.util.Map r0 = r0.getDeviceInfo()     // Catch:{ JSONException -> 0x0124 }
            if (r0 == 0) goto L_0x0067
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0124 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0124 }
            goto L_0x006c
        L_0x0067:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0124 }
            r1.<init>()     // Catch:{ JSONException -> 0x0124 }
        L_0x006c:
            r11.getCarrier(r1)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r0 = "$AppEnd"
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0124 }
            if (r0 != 0) goto L_0x0086
            java.lang.String r0 = "$AppDeeplinkLaunch"
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0124 }
            if (r0 != 0) goto L_0x0086
            org.json.JSONObject r0 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getLatestUtmProperties()     // Catch:{ JSONException -> 0x0124 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r0, r1)     // Catch:{ JSONException -> 0x0124 }
        L_0x0086:
            r0 = r15
            r11.mergerDynamicAndSuperProperties(r1, r15)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r0 = r10.mReferrerScreenTitle     // Catch:{ JSONException -> 0x0124 }
            if (r0 == 0) goto L_0x0093
            java.lang.String r2 = "$referrer_title"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0124 }
        L_0x0093:
            android.content.Context r0 = r10.mContext     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(r0)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r2 = "$wifi"
            java.lang.String r4 = "WIFI"
            boolean r4 = r4.equals(r0)     // Catch:{ JSONException -> 0x0124 }
            r1.put(r2, r4)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r2 = "$network_type"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x0124 }
            com.sensorsdata.analytics.android.sdk.SensorsDataGPSLocation r0 = mGPSLocation     // Catch:{ Exception -> 0x00b1 }
            if (r0 == 0) goto L_0x00b5
            r0.toJSON(r1)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ JSONException -> 0x0124 }
        L_0x00b5:
            java.lang.String r0 = r11.getScreenOrientation()     // Catch:{ Exception -> 0x00c5 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00c5 }
            if (r2 != 0) goto L_0x00c9
            java.lang.String r2 = "$screen_orientation"
            r1.put(r2, r0)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ JSONException -> 0x0124 }
        L_0x00c9:
            r5 = r1
            goto L_0x00d7
        L_0x00cb:
            boolean r0 = r12.isProfile()     // Catch:{ JSONException -> 0x0124 }
            if (r0 == 0) goto L_0x0123
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0124 }
            r0.<init>()     // Catch:{ JSONException -> 0x0124 }
            r5 = r0
        L_0x00d7:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = mSAConfigOptions     // Catch:{ JSONException -> 0x0124 }
            boolean r0 = r0.isDataCollectEnable     // Catch:{ JSONException -> 0x0124 }
            if (r0 != 0) goto L_0x0116
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ JSONException -> 0x0124 }
            if (r0 == 0) goto L_0x0109
            java.lang.String r0 = "SA.SensorsDataAPI"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0124 }
            r1.<init>()     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r2 = "track event, isDataCollectEnable = false, eventName = "
            r1.append(r2)     // Catch:{ JSONException -> 0x0124 }
            r1.append(r3)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r2 = ",property = "
            r1.append(r2)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r2 = r5.toString()     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r2)     // Catch:{ JSONException -> 0x0124 }
            r1.append(r2)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0124 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0124 }
        L_0x0109:
            r1 = r11
            r2 = r12
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
            r1.transformEventTaskQueue(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0124 }
            return
        L_0x0116:
            r1 = r11
            r2 = r12
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
            r1.trackEventInternal(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0124 }
            goto L_0x0130
        L_0x0123:
            return
        L_0x0124:
            com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException     // Catch:{ Exception -> 0x012c }
            java.lang.String r1 = "Unexpected property"
            r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x012c }
            throw r0     // Catch:{ Exception -> 0x012c }
        L_0x012c:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0130:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.trackEvent(com.sensorsdata.analytics.android.sdk.EventType, java.lang.String, org.json.JSONObject, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void trackEventH5(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!mSAConfigOptions.isDataCollectEnable) {
                    transformH5TaskQueue(str);
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("_hybrid_h5", true);
                String string = jSONObject.getString(ClassParamsKt.TYPE);
                EventType valueOf = EventType.valueOf(string.toUpperCase(Locale.getDefault()));
                if (valueOf == EventType.TRACK_SIGNUP) {
                    jSONObject.put("original_id", getAnonymousId());
                } else if (!TextUtils.isEmpty(getLoginId())) {
                    jSONObject.put("distinct_id", getLoginId());
                } else {
                    jSONObject.put("distinct_id", getAnonymousId());
                }
                jSONObject.put("anonymous_id", getAnonymousId());
                long currentTimeMillis = System.currentTimeMillis();
                jSONObject.put("time", currentTimeMillis);
                try {
                    jSONObject.put("_track_id", new SecureRandom().nextInt());
                } catch (Exception unused) {
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("properties");
                SADataHelper.assertPropertyTypes(optJSONObject);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("lib");
                if (optJSONObject2 != null) {
                    this.mSAContextManager.addKeyIfExist(optJSONObject2, "$app_version");
                    JSONObject jSONObject2 = (JSONObject) this.mSuperProperties.get();
                    if (jSONObject2 != null && jSONObject2.has("$app_version")) {
                        optJSONObject2.put("$app_version", jSONObject2.get("$app_version"));
                    }
                }
                if (valueOf.isTrack()) {
                    Map<String, Object> deviceInfo = this.mSAContextManager.getDeviceInfo();
                    if (deviceInfo != null) {
                        for (Map.Entry next : deviceInfo.entrySet()) {
                            String str2 = (String) next.getKey();
                            if (!TextUtils.isEmpty(str2) && !"$lib".equals(str2)) {
                                if (!"$lib_version".equals(str2)) {
                                    optJSONObject.put((String) next.getKey(), next.getValue());
                                }
                            }
                        }
                    }
                    getCarrier(optJSONObject);
                    String networkType = NetworkUtils.networkType(this.mContext);
                    optJSONObject.put("$wifi", "WIFI".equals(networkType));
                    optJSONObject.put("$network_type", networkType);
                    mergerDynamicAndSuperProperties(optJSONObject, getDynamicProperty());
                    if (valueOf.isTrack()) {
                        optJSONObject.put("$is_first_day", isFirstDay(currentTimeMillis));
                    }
                    SensorsDataUtils.mergeJSONObject(ChannelUtils.getLatestUtmProperties(), optJSONObject);
                }
                if (jSONObject.has("_nocache")) {
                    jSONObject.remove("_nocache");
                }
                if (jSONObject.has("server_url")) {
                    jSONObject.remove("server_url");
                }
                if (jSONObject.has("_flush_time")) {
                    jSONObject.remove("_flush_time");
                }
                if (optJSONObject.has("$project")) {
                    jSONObject.put("project", optJSONObject.optString("$project"));
                    optJSONObject.remove("$project");
                }
                if (optJSONObject.has("$token")) {
                    jSONObject.put("token", optJSONObject.optString("$token"));
                    optJSONObject.remove("$token");
                }
                if (optJSONObject.has("$time")) {
                    try {
                        long j = optJSONObject.getLong("$time");
                        if (TimeUtils.isDateValid(j)) {
                            jSONObject.put("time", j);
                        }
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                    optJSONObject.remove("$time");
                }
                String optString = jSONObject.optString("event");
                if (valueOf.isTrack()) {
                    SADataHelper.assertKey(optString);
                    if (!isEnterDb(optString, optJSONObject)) {
                        SALog.d(TAG, optString + " event can not enter database");
                        return;
                    } else if (!this.isTrackEventWithPluginVersion && !optJSONObject.has("$lib_plugin_version")) {
                        JSONArray pluginVersion = getPluginVersion();
                        if (pluginVersion == null) {
                            this.isTrackEventWithPluginVersion = true;
                        } else {
                            try {
                                optJSONObject.put("$lib_plugin_version", pluginVersion);
                                this.isTrackEventWithPluginVersion = true;
                            } catch (Exception e2) {
                                SALog.printStackTrace(e2);
                            }
                        }
                    }
                }
                jSONObject.put("properties", optJSONObject);
                if (valueOf == EventType.TRACK_SIGNUP) {
                    String string2 = jSONObject.getString("distinct_id");
                    synchronized (this.mLoginIdLock) {
                        if (!string2.equals(DbAdapter.getInstance().getLoginId()) && !string2.equals(getAnonymousId())) {
                            this.mLoginId = string2;
                            DbAdapter.getInstance().commitLoginId(string2);
                            jSONObject.put("login_id", string2);
                            try {
                                List<SAEventListener> list = this.mEventListenerList;
                                if (list != null) {
                                    for (SAEventListener login : list) {
                                        login.login();
                                    }
                                }
                            } catch (Exception e3) {
                                SALog.printStackTrace(e3);
                            }
                            try {
                                if (this.mFunctionListenerList != null) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("distinctId", string2);
                                    for (SAFunctionListener call : this.mFunctionListenerList) {
                                        call.call("login", jSONObject3);
                                    }
                                }
                            } catch (Exception e4) {
                                SALog.printStackTrace(e4);
                            }
                            this.mMessages.enqueueEventMessage(string, jSONObject);
                            if (SALog.isLogEnabled()) {
                                SALog.i(TAG, "track event:\n" + JSONUtils.formatJson(jSONObject.toString()));
                            }
                        }
                    }
                    return;
                }
                if (!TextUtils.isEmpty(getLoginId())) {
                    jSONObject.put("login_id", getLoginId());
                }
                try {
                    if (this.mEventListenerList != null && valueOf.isTrack()) {
                        for (SAEventListener trackEvent : this.mEventListenerList) {
                            trackEvent.trackEvent(jSONObject);
                        }
                    }
                } catch (Exception e5) {
                    SALog.printStackTrace(e5);
                }
                try {
                    if (this.mFunctionListenerList != null && valueOf.isTrack()) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("eventJSON", jSONObject);
                        for (SAFunctionListener call2 : this.mFunctionListenerList) {
                            call2.call("trackEvent", jSONObject4);
                        }
                    }
                } catch (Exception e6) {
                    SALog.printStackTrace(e6);
                }
                this.mMessages.enqueueEventMessage(string, jSONObject);
                if (SALog.isLogEnabled()) {
                    SALog.i(TAG, "track event from H5:\n" + JSONUtils.formatJson(jSONObject.toString()));
                    return;
                }
                return;
            }
            return;
        } catch (Exception e7) {
            SALog.printStackTrace(e7);
        }
    }

    public void transformTaskQueue(final Runnable runnable) {
        if (!mSAConfigOptions.isDataCollectEnable) {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    AbstractSensorsDataAPI.this.mTrackTaskManager.transformTaskQueue(runnable);
                }
            });
        } else {
            this.mTrackTaskManager.addTrackEventTask(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void initSAConfig(String str, String str2) {
        Bundle appInfoBundle = AppInfoUtils.getAppInfoBundle(this.mContext);
        if (mSAConfigOptions == null) {
            this.mSDKConfigInit = false;
            mSAConfigOptions = new SAConfigOptions(str);
        } else {
            this.mSDKConfigInit = true;
        }
        if (mSAConfigOptions.mEnableEncrypt) {
            this.mSensorsDataEncrypt = new SensorsDataEncrypt(this.mContext, mSAConfigOptions.mPersistentSecretKey, mSAConfigOptions.getEncryptors());
        }
        DbAdapter.getInstance(this.mContext, str2, this.mSensorsDataEncrypt);
        this.mTrackTaskManager.setDataCollectEnable(mSAConfigOptions.isDataCollectEnable);
        if (mSAConfigOptions.mInvokeLog) {
            enableLog(mSAConfigOptions.mLogEnabled);
        } else {
            enableLog(appInfoBundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", this.mDebugMode != SensorsDataAPI.DebugMode.DEBUG_OFF));
        }
        SALog.setDisableSDK(mSAConfigOptions.isDisableSDK);
        setServerUrl(str);
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            SensorsDataExceptionHandler.enableAppCrash();
        }
        if (mSAConfigOptions.mFlushInterval == 0) {
            mSAConfigOptions.setFlushInterval(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushInterval", ViewLevelCons.LEVEL_VideoCallDriver_VideoCallView));
        }
        if (mSAConfigOptions.mFlushBulkSize == 0) {
            mSAConfigOptions.setFlushBulkSize(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100));
        }
        if (mSAConfigOptions.mMaxCacheSize == 0) {
            mSAConfigOptions.setMaxCacheSize(33554432);
        }
        if (mSAConfigOptions.isSubProcessFlushData && DbAdapter.getInstance().isFirstProcess()) {
            DbAdapter.getInstance().commitFirstProcessState(false);
            DbAdapter.getInstance().commitSubProcessFlushState(false);
        }
        this.mAutoTrack = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.AutoTrack", false);
        if (mSAConfigOptions.mAutoTrackEventType != 0) {
            enableAutoTrack(mSAConfigOptions.mAutoTrackEventType);
            this.mAutoTrack = true;
        }
        if (!mSAConfigOptions.mInvokeHeatMapEnabled) {
            mSAConfigOptions.mHeatMapEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.HeatMap", false);
        }
        if (!mSAConfigOptions.mInvokeVisualizedEnabled) {
            mSAConfigOptions.mVisualizedEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.VisualizedAutoTrack", false);
        }
        enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
        if (!TextUtils.isEmpty(mSAConfigOptions.mAnonymousId)) {
            identify(mSAConfigOptions.mAnonymousId);
        }
        if (mSAConfigOptions.isDisableSDK) {
            this.mEnableNetworkRequest = false;
            isChangeEnableNetworkFlag = true;
        }
        SHOW_DEBUG_INFO_VIEW = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.ShowDebugInfoView", true);
        this.mDisableDefaultRemoteConfig = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableDefaultRemoteConfig", false);
        if (mSAConfigOptions.isDataCollectEnable) {
            mIsMainProcess = AppInfoUtils.isMainProcess(this.mContext, appInfoBundle);
        }
        this.mDisableTrackDeviceId = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableTrackDeviceId", false);
    }

    /* access modifiers changed from: protected */
    public void applySAConfigOptions() {
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            SensorsDataExceptionHandler.enableAppCrash();
        }
        if (mSAConfigOptions.mAutoTrackEventType != 0) {
            this.mAutoTrack = true;
        }
        if (mSAConfigOptions.mInvokeLog) {
            enableLog(mSAConfigOptions.mLogEnabled);
        }
        enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
        if (!TextUtils.isEmpty(mSAConfigOptions.mAnonymousId)) {
            identify(mSAConfigOptions.mAnonymousId);
        }
        if (!mSAConfigOptions.mVisualizedEnabled && mSAConfigOptions.mVisualizedPropertiesEnabled) {
            SALog.i(TAG, "当前已开启可视化全埋点自定义属性（enableVisualizedProperties），可视化全埋点采集开关已失效！");
            mSAConfigOptions.enableVisualizedAutoTrack(true);
        }
    }

    /* access modifiers changed from: protected */
    public void trackTimerState(String str, boolean z) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final String str2 = str;
        final boolean z2 = z;
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                boolean z;
                try {
                    SADataHelper.assertKey(str2);
                    synchronized (AbstractSensorsDataAPI.this.mTrackTimer) {
                        EventTimer eventTimer = AbstractSensorsDataAPI.this.mTrackTimer.get(str2);
                        if (!(eventTimer == null || eventTimer.isPaused() == (z = z2))) {
                            eventTimer.setTimerState(z, elapsedRealtime);
                        }
                    }
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public JSONObject getDynamicProperty() {
        try {
            SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties = this.mDynamicSuperPropertiesCallBack;
            if (sensorsDataDynamicSuperProperties == null) {
                return null;
            }
            JSONObject dynamicSuperProperties = sensorsDataDynamicSuperProperties.getDynamicSuperProperties();
            SADataHelper.assertPropertyTypes(dynamicSuperProperties);
            return dynamicSuperProperties;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    private void mergerDynamicAndSuperProperties(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject superProperties = getSuperProperties();
        if (jSONObject2 == null) {
            jSONObject2 = getDynamicProperty();
        }
        SensorsDataUtils.mergeJSONObject(SensorsDataUtils.mergeSuperJSONObject(jSONObject2, superProperties), jSONObject);
    }

    private void showDebugModeWarning() {
        try {
            if (this.mDebugMode != SensorsDataAPI.DebugMode.DEBUG_OFF && !TextUtils.isEmpty(this.mServerUrl)) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        String str;
                        if (AbstractSensorsDataAPI.this.mDebugMode == SensorsDataAPI.DebugMode.DEBUG_ONLY) {
                            str = "现在您打开了 SensorsData SDK 的 'DEBUG_ONLY' 模式，此模式下只校验数据但不导入数据，数据出错时会以 Toast 的方式提示开发者，请上线前一定使用 DEBUG_OFF 模式。";
                        } else {
                            str = AbstractSensorsDataAPI.this.mDebugMode == SensorsDataAPI.DebugMode.DEBUG_AND_TRACK ? "现在您打开了神策 SensorsData SDK 的 'DEBUG_AND_TRACK' 模式，此模式下校验数据并且导入数据，数据出错时会以 Toast 的方式提示开发者，请上线前一定使用 DEBUG_OFF 模式。" : null;
                        }
                        CharSequence appName = AppInfoUtils.getAppName(AbstractSensorsDataAPI.this.mContext);
                        if (!TextUtils.isEmpty(appName)) {
                            str = String.format(Locale.CHINA, "%s：%s", new Object[]{appName, str});
                        }
                        Toast.makeText(AbstractSensorsDataAPI.this.mContext, str, 1).show();
                    }
                });
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private boolean isEnterDb(String str, JSONObject jSONObject) {
        boolean z;
        String str2;
        if (this.mTrackEventCallBack == null) {
            return true;
        }
        SALog.d(TAG, "SDK have set trackEvent callBack");
        try {
            z = this.mTrackEventCallBack.onTrackEvent(str, jSONObject);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            z = true;
        }
        if (z) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        SADataHelper.assertKey(next);
                        Object opt = jSONObject.opt(next);
                        if ((opt instanceof CharSequence) || (opt instanceof Number) || (opt instanceof JSONArray) || (opt instanceof Boolean) || (opt instanceof Date)) {
                            if ("app_crashed_reason".equals(next)) {
                                if ((opt instanceof String) && ((String) opt).length() > 16382) {
                                    SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + opt.toString() + "']");
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(((String) opt).substring(0, 16382));
                                    sb.append("$");
                                    opt = sb.toString();
                                }
                            } else if ((opt instanceof String) && ((String) opt).length() > 8191) {
                                SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + opt.toString() + "']");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(((String) opt).substring(0, 8191));
                                sb2.append("$");
                                opt = sb2.toString();
                            }
                            if (opt instanceof Date) {
                                jSONObject.put(next, TimeUtils.formatDate((Date) opt, Locale.CHINA));
                            } else {
                                jSONObject.put(next, opt);
                            }
                        } else {
                            Object[] objArr = new Object[3];
                            objArr[0] = next;
                            String str3 = "";
                            if (opt == null) {
                                str2 = str3;
                            } else {
                                str2 = opt.toString();
                            }
                            objArr[1] = str2;
                            if (opt != null) {
                                str3 = opt.getClass().getCanonicalName();
                            }
                            objArr[2] = str3;
                            SALog.d(TAG, String.format("The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date. [key='%s', value='%s', class='%s']", objArr));
                            return false;
                        }
                    } catch (Exception e2) {
                        SALog.printStackTrace(e2);
                        return false;
                    }
                }
            } catch (Exception e3) {
                SALog.printStackTrace(e3);
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x024b: MOVE  (r9v4 org.json.JSONObject) = (r30v0 org.json.JSONObject)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01ba A[Catch:{ Exception -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[SYNTHETIC, Splitter:B:18:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x033f A[Catch:{ Exception -> 0x0349 }, LOOP:0: B:193:0x0339->B:195:0x033f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x036d A[Catch:{ Exception -> 0x0379 }, LOOP:1: B:204:0x0367->B:206:0x036d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[SYNTHETIC, Splitter:B:36:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC, Splitter:B:66:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016a A[Catch:{ Exception -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017c A[Catch:{ Exception -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018e A[SYNTHETIC, Splitter:B:95:0x018e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0063=Splitter:B:23:0x0063, B:43:0x009b=Splitter:B:43:0x009b} */
    public void trackEventInternal(com.sensorsdata.analytics.android.sdk.EventType r28, java.lang.String r29, org.json.JSONObject r30, org.json.JSONObject r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, com.sensorsdata.analytics.android.sdk.EventTimer r35) throws org.json.JSONException {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            java.lang.String r6 = "$sf_internal_login_id"
            java.lang.String r7 = "$sf_internal_anonymous_id"
            java.lang.String r8 = "$time"
            java.lang.String r9 = "$token"
            java.lang.String r10 = "$project"
            long r11 = java.lang.System.currentTimeMillis()
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r14 = "$AppStart"
            java.lang.String r15 = "$lib_version"
            r17 = r11
            java.lang.String r11 = "$lib_detail"
            java.lang.String r12 = "code"
            java.lang.String r2 = "$app_version"
            r19 = r6
            java.lang.String r6 = "$lib_method"
            java.lang.String r20 = "6.0.0"
            if (r4 == 0) goto L_0x00de
            boolean r0 = r4.has(r11)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0041
            java.lang.String r21 = r4.getString(r11)     // Catch:{ Exception -> 0x0044 }
            r4.remove(r11)     // Catch:{ Exception -> 0x003f }
            goto L_0x004a
        L_0x003f:
            r0 = move-exception
            goto L_0x0047
        L_0x0041:
            r21 = 0
            goto L_0x004a
        L_0x0044:
            r0 = move-exception
            r21 = 0
        L_0x0047:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x004a:
            java.lang.String r0 = "$AppEnd"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            r22 = r11
            java.lang.String r11 = "event_time"
            if (r0 == 0) goto L_0x0088
            long r23 = r4.optLong(r11)     // Catch:{ Exception -> 0x00a4 }
            r25 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r23 = r17
        L_0x0063:
            java.lang.String r0 = r4.optString(r15)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r16 = r4.optString(r2)     // Catch:{ Exception -> 0x0086 }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0084 }
            if (r17 != 0) goto L_0x0074
            r20 = r0
            goto L_0x0077
        L_0x0074:
            r4.remove(r15)     // Catch:{ Exception -> 0x0084 }
        L_0x0077:
            boolean r0 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x0084 }
            if (r0 == 0) goto L_0x0080
            r4.remove(r2)     // Catch:{ Exception -> 0x0084 }
        L_0x0080:
            r4.remove(r11)     // Catch:{ Exception -> 0x0084 }
            goto L_0x00b0
        L_0x0084:
            r0 = move-exception
            goto L_0x00ad
        L_0x0086:
            r0 = move-exception
            goto L_0x00ab
        L_0x0088:
            boolean r0 = r14.equals(r3)     // Catch:{ Exception -> 0x00a4 }
            if (r0 == 0) goto L_0x009f
            long r23 = r4.optLong(r11)     // Catch:{ Exception -> 0x00a4 }
            r25 = 0
            int r0 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r0 <= 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r23 = r17
        L_0x009b:
            r4.remove(r11)     // Catch:{ Exception -> 0x0086 }
            goto L_0x00a1
        L_0x009f:
            r23 = r17
        L_0x00a1:
            r16 = 0
            goto L_0x00b0
        L_0x00a4:
            r0 = move-exception
            goto L_0x00a9
        L_0x00a6:
            r0 = move-exception
            r22 = r11
        L_0x00a9:
            r23 = r17
        L_0x00ab:
            r16 = 0
        L_0x00ad:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x00b0:
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r30, r31)
            boolean r0 = r28.isTrack()
            if (r0 == 0) goto L_0x00d0
            java.lang.String r0 = r4.optString(r6)
            java.lang.String r11 = "autoTrack"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x00c9
            r13.put(r6, r11)
            goto L_0x00d3
        L_0x00c9:
            r13.put(r6, r12)
            r5.put(r6, r12)
            goto L_0x00d3
        L_0x00d0:
            r13.put(r6, r12)
        L_0x00d3:
            r17 = r14
            r6 = r16
            r14 = r20
            r16 = r21
            r11 = r23
            goto L_0x00f5
        L_0x00de:
            r22 = r11
            r13.put(r6, r12)
            boolean r0 = r28.isTrack()
            if (r0 == 0) goto L_0x00ec
            r5.put(r6, r12)
        L_0x00ec:
            r11 = r17
            r6 = 0
            r16 = 0
            r17 = r14
            r14 = r20
        L_0x00f5:
            if (r35 == 0) goto L_0x010f
            java.lang.String r0 = r35.duration()     // Catch:{ Exception -> 0x010b }
            double r3 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x010b }
            r20 = 0
            int r0 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x010f
            java.lang.String r0 = "event_duration"
            r5.put(r0, r3)     // Catch:{ Exception -> 0x010b }
            goto L_0x010f
        L_0x010b:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x010f:
            java.lang.String r0 = "$lib"
            java.lang.String r3 = "Android"
            r13.put(r0, r3)
            r13.put(r15, r14)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0125
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager
            r0.addKeyIfExist(r13, r2)
            goto L_0x0128
        L_0x0125:
            r13.put(r2, r6)
        L_0x0128:
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties r0 = r1.mSuperProperties
            java.lang.Object r0 = r0.get()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            if (r0 == 0) goto L_0x013f
            boolean r3 = r0.has(r2)
            if (r3 == 0) goto L_0x013f
            java.lang.Object r0 = r0.get(r2)
            r13.put(r2, r0)
        L_0x013f:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.security.SecureRandom r0 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = "_track_id"
            int r0 = r0.nextInt()     // Catch:{ Exception -> 0x0152 }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x0152 }
        L_0x0152:
            java.lang.String r0 = "time"
            r2.put(r0, r11)
            java.lang.String r3 = r28.getEventType()
            java.lang.String r4 = "type"
            r2.put(r4, r3)
            java.lang.String r3 = r27.getAnonymousId()
            boolean r4 = r5.has(r10)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x0176
            java.lang.String r4 = "project"
            java.lang.String r6 = r5.optString(r10)     // Catch:{ Exception -> 0x01ed }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x01ed }
            r5.remove(r10)     // Catch:{ Exception -> 0x01ed }
        L_0x0176:
            boolean r4 = r5.has(r9)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x0188
            java.lang.String r4 = "token"
            java.lang.String r6 = r5.optString(r9)     // Catch:{ Exception -> 0x01ed }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x01ed }
            r5.remove(r9)     // Catch:{ Exception -> 0x01ed }
        L_0x0188:
            boolean r4 = r5.has(r8)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x01b0
            java.lang.Object r4 = r5.opt(r8)     // Catch:{ Exception -> 0x01a9 }
            boolean r6 = r4 instanceof java.util.Date     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x01ad
            r6 = r4
            java.util.Date r6 = (java.util.Date) r6     // Catch:{ Exception -> 0x01a9 }
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.isDateValid((java.util.Date) r6)     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x01ad
            java.util.Date r4 = (java.util.Date) r4     // Catch:{ Exception -> 0x01a9 }
            long r9 = r4.getTime()     // Catch:{ Exception -> 0x01a9 }
            r2.put(r0, r9)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x01ad
        L_0x01a9:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x01ed }
        L_0x01ad:
            r5.remove(r8)     // Catch:{ Exception -> 0x01ed }
        L_0x01b0:
            java.lang.String r0 = "$PlanPopupDisplay"
            r4 = r29
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01e6
            boolean r0 = r5.has(r7)     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01c7
            java.lang.String r3 = r5.optString(r7)     // Catch:{ Exception -> 0x01eb }
            r5.remove(r7)     // Catch:{ Exception -> 0x01eb }
        L_0x01c7:
            r6 = r19
            boolean r0 = r5.has(r6)     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01d7
            java.lang.String r7 = r5.optString(r6)     // Catch:{ Exception -> 0x01eb }
            r5.remove(r6)     // Catch:{ Exception -> 0x01e4 }
            goto L_0x01d9
        L_0x01d7:
            r7 = r33
        L_0x01d9:
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01e4 }
            if (r0 != 0) goto L_0x01e1
            r0 = r7
            goto L_0x01f8
        L_0x01e1:
            r0 = r7
            r7 = r3
            goto L_0x01f8
        L_0x01e4:
            r0 = move-exception
            goto L_0x01f2
        L_0x01e6:
            r7 = r32
            r0 = r33
            goto L_0x01f8
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f0
        L_0x01ed:
            r0 = move-exception
            r4 = r29
        L_0x01f0:
            r7 = r33
        L_0x01f2:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            r0 = r7
            r7 = r32
        L_0x01f8:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "distinct_id"
            if (r6 == 0) goto L_0x0208
            java.lang.String r6 = r27.getAnonymousId()
            r2.put(r8, r6)
            goto L_0x020b
        L_0x0208:
            r2.put(r8, r7)
        L_0x020b:
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x0216
            java.lang.String r6 = "login_id"
            r2.put(r6, r0)
        L_0x0216:
            java.lang.String r0 = "anonymous_id"
            r2.put(r0, r3)
            java.lang.String r0 = "lib"
            r2.put(r0, r13)
            com.sensorsdata.analytics.android.sdk.EventType r0 = com.sensorsdata.analytics.android.sdk.EventType.TRACK
            java.lang.String r3 = "event"
            r6 = r28
            if (r6 != r0) goto L_0x0235
            r2.put(r3, r4)
            boolean r0 = r1.isFirstDay(r11)
            java.lang.String r3 = "$is_first_day"
            r5.put(r3, r0)
            goto L_0x0243
        L_0x0235:
            com.sensorsdata.analytics.android.sdk.EventType r0 = com.sensorsdata.analytics.android.sdk.EventType.TRACK_SIGNUP
            if (r6 != r0) goto L_0x0243
            r2.put(r3, r4)
            java.lang.String r0 = "original_id"
            r3 = r34
            r2.put(r0, r3)
        L_0x0243:
            boolean r0 = r1.mAutoTrack
            java.lang.String r3 = "%s##%s##%s##%s"
            r7 = 0
            r8 = 1
            if (r0 == 0) goto L_0x0293
            r9 = r30
            if (r9 == 0) goto L_0x0293
            boolean r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.isAutoTrackType(r29)
            if (r0 == 0) goto L_0x0293
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.autoTrackEventTypeFromEventName(r29)
            if (r0 == 0) goto L_0x0293
            boolean r0 = r1.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r0)
            if (r0 != 0) goto L_0x0293
            java.lang.String r0 = "$screen_name"
            boolean r0 = r9.has(r0)
            if (r0 == 0) goto L_0x0293
            java.lang.String r0 = "$screen_name"
            java.lang.String r0 = r9.getString(r0)
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 != 0) goto L_0x0293
            java.lang.String r9 = "\\|"
            java.lang.String[] r0 = r0.split(r9)
            int r9 = r0.length
            if (r9 <= 0) goto L_0x0293
            r9 = 4
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r0 = r0[r7]
            r9[r7] = r0
            java.lang.String r0 = ""
            r9[r8] = r0
            r10 = 2
            r9[r10] = r0
            r10 = 3
            r9[r10] = r0
            java.lang.String r16 = java.lang.String.format(r3, r9)
        L_0x0293:
            boolean r0 = android.text.TextUtils.isEmpty(r16)
            if (r0 == 0) goto L_0x02cc
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            int r9 = r0.length
            if (r9 <= r8) goto L_0x02cc
            r0 = r0[r7]
            r9 = 4
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r10 = r0.getClassName()
            r9[r7] = r10
            java.lang.String r7 = r0.getMethodName()
            r9[r8] = r7
            r7 = 2
            java.lang.String r10 = r0.getFileName()
            r9[r7] = r10
            r7 = 3
            int r0 = r0.getLineNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9[r7] = r0
            java.lang.String r16 = java.lang.String.format(r3, r9)
        L_0x02cc:
            r0 = r16
            r3 = r22
            r13.put(r3, r0)
            java.lang.String r0 = "$device_id"
            boolean r3 = r5.has(r0)
            if (r3 == 0) goto L_0x02e0
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r3 = r1.mSAContextManager
            r3.addKeyIfExist(r5, r0)
        L_0x02e0:
            boolean r0 = r28.isTrack()
            if (r0 == 0) goto L_0x0324
            boolean r0 = r1.isEnterDb(r4, r5)
            if (r0 != 0) goto L_0x0303
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r2 = " event can not enter database"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "SA.SensorsDataAPI"
            com.sensorsdata.analytics.android.sdk.SALog.d(r2, r0)
            return
        L_0x0303:
            boolean r0 = r1.isTrackEventWithPluginVersion
            if (r0 != 0) goto L_0x0324
            java.lang.String r0 = "$lib_plugin_version"
            boolean r0 = r5.has(r0)
            if (r0 != 0) goto L_0x0324
            org.json.JSONArray r0 = r27.getPluginVersion()
            if (r0 != 0) goto L_0x0318
            r1.isTrackEventWithPluginVersion = r8
            goto L_0x0324
        L_0x0318:
            java.lang.String r3 = "$lib_plugin_version"
            r5.put(r3, r0)     // Catch:{ Exception -> 0x0320 }
            r1.isTrackEventWithPluginVersion = r8     // Catch:{ Exception -> 0x0320 }
            goto L_0x0324
        L_0x0320:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0324:
            java.lang.String r0 = "properties"
            r2.put(r0, r5)
            java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> r0 = r1.mEventListenerList     // Catch:{ Exception -> 0x0349 }
            if (r0 == 0) goto L_0x034d
            boolean r0 = r28.isTrack()     // Catch:{ Exception -> 0x0349 }
            if (r0 == 0) goto L_0x034d
            java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> r0 = r1.mEventListenerList     // Catch:{ Exception -> 0x0349 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0349 }
        L_0x0339:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x0349 }
            if (r3 == 0) goto L_0x034d
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x0349 }
            com.sensorsdata.analytics.android.sdk.listener.SAEventListener r3 = (com.sensorsdata.analytics.android.sdk.listener.SAEventListener) r3     // Catch:{ Exception -> 0x0349 }
            r3.trackEvent(r2)     // Catch:{ Exception -> 0x0349 }
            goto L_0x0339
        L_0x0349:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x034d:
            java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener> r0 = r1.mFunctionListenerList     // Catch:{ Exception -> 0x0379 }
            if (r0 == 0) goto L_0x037d
            boolean r0 = r28.isTrack()     // Catch:{ Exception -> 0x0379 }
            if (r0 == 0) goto L_0x037d
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0379 }
            r0.<init>()     // Catch:{ Exception -> 0x0379 }
            java.lang.String r3 = "eventJSON"
            r0.put(r3, r2)     // Catch:{ Exception -> 0x0379 }
            java.util.List<com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener> r3 = r1.mFunctionListenerList     // Catch:{ Exception -> 0x0379 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0379 }
        L_0x0367:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x0379 }
            if (r5 == 0) goto L_0x037d
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x0379 }
            com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener r5 = (com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener) r5     // Catch:{ Exception -> 0x0379 }
            java.lang.String r7 = "trackEvent"
            r5.call(r7, r0)     // Catch:{ Exception -> 0x0379 }
            goto L_0x0367
        L_0x0379:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x037d:
            com.sensorsdata.analytics.android.sdk.AnalyticsMessages r0 = r1.mMessages
            java.lang.String r3 = r28.getEventType()
            r0.enqueueEventMessage(r3, r2)
            r3 = r17
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L_0x0393
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager
            r0.setAppStartSuccess(r8)
        L_0x0393:
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r0 == 0) goto L_0x03b7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "track event:\n"
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "SA.SensorsDataAPI"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r0)
        L_0x03b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.trackEventInternal(com.sensorsdata.analytics.android.sdk.EventType, java.lang.String, org.json.JSONObject, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, com.sensorsdata.analytics.android.sdk.EventTimer):void");
    }

    private void transformEventTaskQueue(EventType eventType, String str, JSONObject jSONObject, JSONObject jSONObject2, String str2, String str3, String str4, EventTimer eventTimer) {
        String str5 = str;
        JSONObject jSONObject3 = jSONObject2;
        try {
            if (!jSONObject3.has("$time") && !"$AppStart".equals(str) && !"$AppEnd".equals(str)) {
                jSONObject3.put("$time", new Date(System.currentTimeMillis()));
            }
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
        final EventType eventType2 = eventType;
        final JSONObject jSONObject4 = jSONObject2;
        final String str6 = str;
        final JSONObject jSONObject5 = jSONObject;
        final String str7 = str2;
        final String str8 = str3;
        final EventTimer eventTimer2 = eventTimer;
        final String str9 = str4;
        this.mTrackTaskManager.transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    if (eventType2.isTrack()) {
                        JSONUtils.mergeDistinctProperty(new JSONObject(AbstractSensorsDataAPI.this.mSAContextManager.getDeviceInfo()), jSONObject4);
                    }
                    if ("$SignUp".equals(str6)) {
                        AbstractSensorsDataAPI abstractSensorsDataAPI = AbstractSensorsDataAPI.this;
                        abstractSensorsDataAPI.trackEventInternal(eventType2, str6, jSONObject5, jSONObject4, str7, str8, abstractSensorsDataAPI.getAnonymousId(), eventTimer2);
                        return;
                    }
                    AbstractSensorsDataAPI.this.trackEventInternal(eventType2, str6, jSONObject5, jSONObject4, str7, str8, str9, eventTimer2);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    private void transformH5TaskQueue(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("properties");
            if (optJSONObject != null && !optJSONObject.has("$time")) {
                optJSONObject.put("$time", System.currentTimeMillis());
            }
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "track H5, isDataCollectEnable = false, eventInfo = " + JSONUtils.formatJson(str));
            }
            this.mTrackTaskManager.transformTaskQueue(new Runnable() {
                public void run() {
                    try {
                        AbstractSensorsDataAPI.this.trackEventH5(jSONObject.toString());
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private void transformItemTaskQueue(String str, String str2, String str3, long j, JSONObject jSONObject) {
        if (SALog.isLogEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("track item, isDataCollectEnable = false, itemType = ");
            String str4 = str;
            sb.append(str);
            sb.append(",itemId = ");
            String str5 = str2;
            sb.append(str2);
            SALog.i(TAG, sb.toString());
        } else {
            String str6 = str;
            String str7 = str2;
        }
        final String str8 = str;
        final String str9 = str2;
        final String str10 = str3;
        final long j2 = j;
        final JSONObject jSONObject2 = jSONObject;
        this.mTrackTaskManager.transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    AbstractSensorsDataAPI.this.trackItemEvent(str8, str9, str10, j2, jSONObject2);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    private JSONArray getPluginVersion() {
        try {
            if (TextUtils.isEmpty(SensorsDataAPI.ANDROID_PLUGIN_VERSION)) {
                return null;
            }
            SALog.i(TAG, "android plugin version: " + SensorsDataAPI.ANDROID_PLUGIN_VERSION);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("android:" + SensorsDataAPI.ANDROID_PLUGIN_VERSION);
            return jSONArray;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    private void registerLifecycleCallbacks() {
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                Application application = (Application) this.mContext.getApplicationContext();
                SensorsDataActivityLifecycleCallbacks sensorsDataActivityLifecycleCallbacks = new SensorsDataActivityLifecycleCallbacks();
                application.registerActivityLifecycleCallbacks(sensorsDataActivityLifecycleCallbacks);
                application.registerActivityLifecycleCallbacks(AppStateManager.getInstance());
                ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks((SensorsDataAPI) this, this.mFirstStart, this.mFirstDay, this.mContext);
                this.mActivityLifecycleCallbacks = activityLifecycleCallbacks;
                sensorsDataActivityLifecycleCallbacks.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
                SensorsDataExceptionHandler.addExceptionListener(this.mActivityLifecycleCallbacks);
                FragmentTrackHelper.addFragmentCallbacks(new FragmentViewScreenCallbacks());
                if (mSAConfigOptions.isTrackPageLeave()) {
                    ActivityPageLeaveCallbacks activityPageLeaveCallbacks = new ActivityPageLeaveCallbacks();
                    sensorsDataActivityLifecycleCallbacks.addActivityLifecycleCallbacks(activityPageLeaveCallbacks);
                    SensorsDataExceptionHandler.addExceptionListener(activityPageLeaveCallbacks);
                    FragmentPageLeaveCallbacks fragmentPageLeaveCallbacks = new FragmentPageLeaveCallbacks();
                    FragmentTrackHelper.addFragmentCallbacks(fragmentPageLeaveCallbacks);
                    SensorsDataExceptionHandler.addExceptionListener(fragmentPageLeaveCallbacks);
                }
                if (mSAConfigOptions.isEnableTrackPush()) {
                    sensorsDataActivityLifecycleCallbacks.addActivityLifecycleCallbacks(new PushLifecycleCallbacks());
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private void registerObserver() {
        SensorsDataContentObserver sensorsDataContentObserver = new SensorsDataContentObserver();
        ContentResolver contentResolver = this.mContext.getContentResolver();
        contentResolver.registerContentObserver(DbParams.getInstance().getDataCollectUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getSessionTimeUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getLoginIdUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getDisableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getEnableSDKUri(), false, sensorsDataContentObserver);
    }

    public boolean isDeepLinkInstallSource() {
        return this.mEnableDeepLinkInstallSource;
    }

    /* access modifiers changed from: protected */
    public void delayInitTask() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    if (AbstractSensorsDataAPI.this.isSaveDeepLinkInfo()) {
                        ChannelUtils.loadUtmByLocal(AbstractSensorsDataAPI.this.mContext);
                    } else {
                        ChannelUtils.clearLocalUtm(AbstractSensorsDataAPI.this.mContext);
                    }
                    AbstractSensorsDataAPI.this.registerNetworkListener();
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        });
    }

    private void getCarrier(JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString("$carrier")) && mSAConfigOptions.isDataCollectEnable) {
                String carrier = SensorsDataUtils.getCarrier(this.mContext);
                if (!TextUtils.isEmpty(carrier)) {
                    jSONObject.put("$carrier", carrier);
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
