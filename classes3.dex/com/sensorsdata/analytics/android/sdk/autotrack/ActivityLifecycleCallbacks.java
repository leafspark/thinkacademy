package com.sensorsdata.analytics.android.sdk.autotrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart;
import com.sensorsdata.analytics.android.sdk.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sensorsdata.analytics.android.sdk.visual.HeatMapService;
import com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService;
import com.tal.app.thinkacademy.live.util.ViewLevelCons;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class ActivityLifecycleCallbacks implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String APP_VERSION = "$app_version";
    private static final String EVENT_TIMER = "event_timer";
    private static final String LIB_VERSION = "$lib_version";
    private static final String TAG = "SA.ActivityLifecycleCallbacks";
    private static final int TIME_INTERVAL = 2000;
    private static final String TRACK_TIMER = "track_timer";
    private final String APP_END_DATA = "app_end_data";
    private final String APP_END_MESSAGE_TIME = "app_end_message_time";
    private final String APP_END_TIME = "app_end_time";
    private final String APP_RESET_STATE = "app_reset_state";
    private final String APP_START_TIME = "app_start_time";
    private final String ELAPSE_TIME = "elapse_time";
    private final int MESSAGE_CODE_APP_END = 0;
    private final int MESSAGE_CODE_START = 100;
    private final int MESSAGE_CODE_STOP = ViewLevelCons.LEVEL_MediaControlPlaybackDriver_gesture;
    private final int MESSAGE_CODE_TIMER = 300;
    private final String TIME = "time";
    private JSONObject activityProperty = new JSONObject();
    private final JSONObject endDataProperty = new JSONObject();
    private Set<Integer> hashSet = new HashSet();
    private final Context mContext;
    private boolean mDataCollectState;
    private final DbAdapter mDbAdapter;
    private JSONObject mDeepLinkProperty = new JSONObject();
    private final PersistentFirstDay mFirstDay;
    private final PersistentFirstStart mFirstStart;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public final SensorsDataAPI mSensorsDataInstance;
    private int mStartActivityCount;
    /* access modifiers changed from: private */
    public int mStartTimerCount;
    /* access modifiers changed from: private */
    public long messageReceiveTime = 0;
    private boolean resumeFromBackground = false;

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onNewIntent(Intent intent) {
    }

    public ActivityLifecycleCallbacks(SensorsDataAPI sensorsDataAPI, PersistentFirstStart persistentFirstStart, PersistentFirstDay persistentFirstDay, Context context) {
        this.mSensorsDataInstance = sensorsDataAPI;
        this.mFirstStart = persistentFirstStart;
        this.mFirstDay = persistentFirstDay;
        this.mDbAdapter = DbAdapter.getInstance();
        this.mContext = context;
        this.mDataCollectState = SensorsDataAPI.getConfigOptions().isDataCollectEnable();
        initHandler();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity)) {
            SensorsDataUtils.handleSchemeUrl(activity, activity.getIntent());
        }
    }

    public void onActivityStarted(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && !hasActivity(activity)) {
            if (this.mStartActivityCount == 0) {
                buildScreenProperties(activity);
            }
            sendActivityHandleMessage(100);
            addActivity(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        JSONObject trackProperties;
        try {
            buildScreenProperties(activity);
            if (this.mSensorsDataInstance.isAutoTrackEnabled() && !this.mSensorsDataInstance.isActivityAutoTrackAppViewScreenIgnored(activity.getClass()) && !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                JSONObject jSONObject = new JSONObject();
                SensorsDataUtils.mergeJSONObject(this.activityProperty, jSONObject);
                if ((activity instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) activity).getTrackProperties()) != null) {
                    SensorsDataUtils.mergeJSONObject(trackProperties, jSONObject);
                }
                DeepLinkManager.mergeDeepLinkProperty(jSONObject);
                DeepLinkManager.resetDeepLinkProcessor();
                this.mSensorsDataInstance.trackViewScreen(SensorsDataUtils.getScreenUrl(activity), SADataHelper.appendLibMethodAutoTrack(jSONObject));
            }
        } catch (Throwable th) {
            SALog.i(TAG, th);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && hasActivity(activity)) {
            sendActivityHandleMessage(ViewLevelCons.LEVEL_MediaControlPlaybackDriver_gesture);
            removeActivity(activity);
        }
    }

    private void initHandler() {
        try {
            HandlerThread handlerThread = new HandlerThread("SENSORS_DATA_THREAD");
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 100) {
                            ActivityLifecycleCallbacks.this.handleStartedMessage(message);
                        } else if (i == 200) {
                            ActivityLifecycleCallbacks.this.handleStoppedMessage(message);
                        } else if (i == 300) {
                            if (ActivityLifecycleCallbacks.this.mSensorsDataInstance.isAutoTrackEnabled() && ActivityLifecycleCallbacks.this.isAutoTrackAppEnd()) {
                                ActivityLifecycleCallbacks.this.generateAppEndData(0, 0);
                            }
                            if (ActivityLifecycleCallbacks.this.mStartTimerCount > 0) {
                                ActivityLifecycleCallbacks.this.mHandler.sendEmptyMessageDelayed(300, 2000);
                            }
                        }
                    } else if (ActivityLifecycleCallbacks.this.messageReceiveTime == 0 || SystemClock.elapsedRealtime() - ActivityLifecycleCallbacks.this.messageReceiveTime >= ((long) ActivityLifecycleCallbacks.this.mSensorsDataInstance.getSessionIntervalTime())) {
                        long unused = ActivityLifecycleCallbacks.this.messageReceiveTime = SystemClock.elapsedRealtime();
                        Bundle data = message.getData();
                        long j = data.getLong("app_start_time");
                        long j2 = data.getLong("app_end_time");
                        String string = data.getString("app_end_data");
                        if (data.getBoolean("app_reset_state")) {
                            ActivityLifecycleCallbacks.this.resetState();
                            if (DbAdapter.getInstance().getActivityCount() <= 0) {
                                ActivityLifecycleCallbacks.this.trackAppEnd(j, j2, string);
                                return;
                            }
                            return;
                        }
                        ActivityLifecycleCallbacks.this.trackAppEnd(j, j2 == 0 ? data.getLong("app_end_message_time") : j2 + 2000, string);
                    } else {
                        SALog.i(ActivityLifecycleCallbacks.TAG, "$AppEnd 事件已触发。");
                    }
                }
            };
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:47|48|(1:50)(1:51)|52) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r11 = r10.mDbAdapter;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f7, code lost:
        if (r6 > 0) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        r6 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fe, code lost:
        r11.commitAppStartTime(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f3 */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0135 A[Catch:{ Exception -> 0x013d }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleStartedMessage(android.os.Message r11) {
        /*
            r10 = this;
            r0 = 0
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r1 = r10.mDbAdapter     // Catch:{ Exception -> 0x011e }
            int r1 = r1.getActivityCount()     // Catch:{ Exception -> 0x011e }
            r10.mStartActivityCount = r1     // Catch:{ Exception -> 0x011e }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r2 = r10.mDbAdapter     // Catch:{ Exception -> 0x011e }
            r3 = 1
            int r1 = r1 + r3
            r10.mStartActivityCount = r1     // Catch:{ Exception -> 0x011e }
            r2.commitActivityCount(r1)     // Catch:{ Exception -> 0x011e }
            int r1 = r10.mStartActivityCount     // Catch:{ Exception -> 0x011e }
            if (r1 != r3) goto L_0x012d
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x011e }
            boolean r1 = r1.isSaveDeepLinkInfo()     // Catch:{ Exception -> 0x011e }
            if (r1 == 0) goto L_0x0029
            org.json.JSONObject r1 = com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getLatestUtmProperties()     // Catch:{ Exception -> 0x011e }
            org.json.JSONObject r2 = r10.endDataProperty     // Catch:{ Exception -> 0x011e }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r1, r2)     // Catch:{ Exception -> 0x011e }
        L_0x0029:
            android.os.Handler r1 = r10.mHandler     // Catch:{ Exception -> 0x011e }
            r1.removeMessages(r0)     // Catch:{ Exception -> 0x011e }
            boolean r1 = r10.isSessionTimeOut()     // Catch:{ Exception -> 0x011e }
            if (r1 == 0) goto L_0x012d
            android.os.Handler r2 = r10.mHandler     // Catch:{ Exception -> 0x011b }
            android.os.Message r4 = r10.obtainAppEndMessage(r0)     // Catch:{ Exception -> 0x011b }
            r2.sendMessage(r4)     // Catch:{ Exception -> 0x011b }
            r10.checkFirstDay()     // Catch:{ Exception -> 0x011b }
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart r2 = r10.mFirstStart     // Catch:{ Exception -> 0x011b }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x011b }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x011b }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x011b }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x006d }
            r4.appBecomeActive()     // Catch:{ Exception -> 0x006d }
            boolean r4 = r10.resumeFromBackground     // Catch:{ Exception -> 0x006d }
            if (r4 == 0) goto L_0x0063
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x006d }
            com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager r4 = r4.getRemoteManager()     // Catch:{ Exception -> 0x006d }
            r4.applySDKConfigFromCache()     // Catch:{ Exception -> 0x006d }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x006d }
            r4.resumeTrackScreenOrientation()     // Catch:{ Exception -> 0x006d }
        L_0x0063:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x006d }
            com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager r4 = r4.getRemoteManager()     // Catch:{ Exception -> 0x006d }
            r4.pullSDKConfigFromServer()     // Catch:{ Exception -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ Exception -> 0x011b }
        L_0x0071:
            android.os.Bundle r11 = r11.getData()     // Catch:{ Exception -> 0x011b }
            r4 = 0
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x00d7 }
            boolean r6 = r6.isAutoTrackEnabled()     // Catch:{ Exception -> 0x00d7 }
            if (r6 == 0) goto L_0x00dd
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x00d7 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r7 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_START     // Catch:{ Exception -> 0x00d7 }
            boolean r6 = r6.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r7)     // Catch:{ Exception -> 0x00d7 }
            if (r6 != 0) goto L_0x00dd
            if (r2 == 0) goto L_0x0094
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart r6 = r10.mFirstStart     // Catch:{ Exception -> 0x00d7 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x00d7 }
            r6.commit(r0)     // Catch:{ Exception -> 0x00d7 }
        L_0x0094:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d7 }
            r0.<init>()     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r6 = "$resume_from_background"
            boolean r7 = r10.resumeFromBackground     // Catch:{ Exception -> 0x00d7 }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r6 = "$is_first_time"
            r0.put(r6, r2)     // Catch:{ Exception -> 0x00d7 }
            org.json.JSONObject r2 = r10.activityProperty     // Catch:{ Exception -> 0x00d7 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r2, r0)     // Catch:{ Exception -> 0x00d7 }
            org.json.JSONObject r2 = r10.mDeepLinkProperty     // Catch:{ Exception -> 0x00d7 }
            if (r2 == 0) goto L_0x00b4
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r2, r0)     // Catch:{ Exception -> 0x00d7 }
            r2 = 0
            r10.mDeepLinkProperty = r2     // Catch:{ Exception -> 0x00d7 }
        L_0x00b4:
            java.lang.String r2 = "time"
            long r6 = r11.getLong(r2)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r2 = "event_time"
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c1
            goto L_0x00c5
        L_0x00c1:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d7 }
        L_0x00c5:
            r0.put(r2, r6)     // Catch:{ Exception -> 0x00d7 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r10.mSensorsDataInstance     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r6 = "$AppStart"
            r2.trackAutoEvent(r6, r0)     // Catch:{ Exception -> 0x00d7 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d7 }
            r0.flush()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00dd
        L_0x00d7:
            r0 = move-exception
            java.lang.String r2 = "SA.ActivityLifecycleCallbacks"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x011b }
        L_0x00dd:
            java.lang.String r0 = "elapse_time"
            long r6 = r11.getLong(r0)     // Catch:{ Exception -> 0x011b }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r11 = r10.mDbAdapter     // Catch:{ Exception -> 0x00f3 }
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00eb
            r8 = r6
            goto L_0x00ef
        L_0x00eb:
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x00f3 }
        L_0x00ef:
            r11.commitAppStartTime(r8)     // Catch:{ Exception -> 0x00f3 }
            goto L_0x0101
        L_0x00f3:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r11 = r10.mDbAdapter     // Catch:{ Exception -> 0x011b }
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fa
            goto L_0x00fe
        L_0x00fa:
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x011b }
        L_0x00fe:
            r11.commitAppStartTime(r6)     // Catch:{ Exception -> 0x011b }
        L_0x0101:
            boolean r11 = r10.resumeFromBackground     // Catch:{ Exception -> 0x011b }
            if (r11 == 0) goto L_0x0118
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService r11 = com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance()     // Catch:{ Exception -> 0x0114 }
            r11.resume()     // Catch:{ Exception -> 0x0114 }
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r11 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x0114 }
            r11.resume()     // Catch:{ Exception -> 0x0114 }
            goto L_0x0118
        L_0x0114:
            r11 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)     // Catch:{ Exception -> 0x011b }
        L_0x0118:
            r10.resumeFromBackground = r3     // Catch:{ Exception -> 0x011b }
            goto L_0x012d
        L_0x011b:
            r11 = move-exception
            r0 = r1
            goto L_0x011f
        L_0x011e:
            r11 = move-exception
        L_0x011f:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)
            if (r0 == 0) goto L_0x012d
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r11 = r10.mDbAdapter
            long r0 = android.os.SystemClock.elapsedRealtime()
            r11.commitAppStartTime(r0)
        L_0x012d:
            int r11 = r10.mStartTimerCount     // Catch:{ Exception -> 0x013d }
            int r0 = r11 + 1
            r10.mStartTimerCount = r0     // Catch:{ Exception -> 0x013d }
            if (r11 != 0) goto L_0x0141
            android.os.Handler r11 = r10.mHandler     // Catch:{ Exception -> 0x013d }
            r0 = 300(0x12c, float:4.2E-43)
            r11.sendEmptyMessage(r0)     // Catch:{ Exception -> 0x013d }
            goto L_0x0141
        L_0x013d:
            r11 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.autotrack.ActivityLifecycleCallbacks.handleStartedMessage(android.os.Message):void");
    }

    /* access modifiers changed from: private */
    public void handleStoppedMessage(Message message) {
        try {
            int i = this.mStartTimerCount - 1;
            this.mStartTimerCount = i;
            int i2 = 0;
            if (i <= 0) {
                this.mHandler.removeMessages(300);
                this.mStartTimerCount = 0;
            }
            int activityCount = this.mDbAdapter.getActivityCount();
            this.mStartActivityCount = activityCount;
            if (activityCount > 0) {
                i2 = activityCount - 1;
                this.mStartActivityCount = i2;
            }
            this.mStartActivityCount = i2;
            this.mDbAdapter.commitActivityCount(i2);
            if (this.mStartActivityCount <= 0) {
                this.mSensorsDataInstance.flush();
                Bundle data = message.getData();
                generateAppEndData(data.getLong("time"), data.getLong("elapse_time"));
                this.mHandler.sendMessageDelayed(obtainAppEndMessage(true), (long) this.mSensorsDataInstance.getSessionIntervalTime());
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: private */
    public void trackAppEnd(long j, long j2, String str) {
        try {
            if (this.mSensorsDataInstance.isAutoTrackEnabled() && isAutoTrackAppEnd() && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                long optLong = jSONObject.optLong(EVENT_TIMER);
                long optLong2 = jSONObject.optLong(TRACK_TIMER);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(AopConstants.SCREEN_NAME, jSONObject.optString(AopConstants.SCREEN_NAME));
                jSONObject2.put(AopConstants.TITLE, jSONObject.optString(AopConstants.TITLE));
                jSONObject2.put(LIB_VERSION, jSONObject.optString(LIB_VERSION));
                jSONObject2.put(APP_VERSION, jSONObject.optString(APP_VERSION));
                if (j > 0) {
                    jSONObject2.put("event_duration", TimeUtils.duration(j, optLong));
                }
                if (optLong2 != 0) {
                    j2 = optLong2;
                }
                jSONObject2.put("event_time", j2);
                ChannelUtils.mergeUtmToEndData(jSONObject, jSONObject2);
                this.mSensorsDataInstance.trackAutoEvent("$AppEnd", jSONObject2);
                this.mDbAdapter.commitAppEndData("");
                this.mSensorsDataInstance.flush();
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: private */
    public void generateAppEndData(long j, long j2) {
        try {
            if (this.mDataCollectState || this.mSensorsDataInstance.getSAContextManager().isAppStartSuccess()) {
                this.mDataCollectState = true;
                if (SensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
                    if (j == 0) {
                        j = System.currentTimeMillis();
                    }
                    JSONObject jSONObject = this.endDataProperty;
                    if (j2 == 0) {
                        j2 = SystemClock.elapsedRealtime();
                    }
                    jSONObject.put(EVENT_TIMER, j2);
                    this.endDataProperty.put(TRACK_TIMER, j);
                    this.endDataProperty.put(APP_VERSION, AppInfoUtils.getAppVersionName(this.mContext));
                    this.endDataProperty.put(LIB_VERSION, SensorsDataAPI.sharedInstance().getSDKVersion());
                    ChannelUtils.mergeUtmToEndData(ChannelUtils.getLatestUtmProperties(), this.endDataProperty);
                    this.mDbAdapter.commitAppEndData(this.endDataProperty.toString());
                    this.mDbAdapter.commitAppEndTime(j);
                }
            }
        } catch (Throwable th) {
            SALog.d(TAG, th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isSessionTimeOut() {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 946656000000(0xdc69183800, double:4.677102080295E-312)
            long r0 = java.lang.Math.max(r0, r2)
            r2 = 0
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x003a }
            java.lang.String r4 = r4.getAppEndData()     // Catch:{ Exception -> 0x003a }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x003a }
            if (r5 != 0) goto L_0x0029
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x003a }
            r5.<init>(r4)     // Catch:{ Exception -> 0x003a }
            java.lang.String r4 = "track_timer"
            long r4 = r5.optLong(r4)     // Catch:{ Exception -> 0x003a }
            goto L_0x002a
        L_0x0029:
            r4 = r2
        L_0x002a:
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x003f
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r2 = r8.mDbAdapter     // Catch:{ Exception -> 0x0035 }
            long r4 = r2.getAppEndTime()     // Catch:{ Exception -> 0x0035 }
            goto L_0x003f
        L_0x0035:
            r2 = move-exception
            r6 = r4
            r4 = r2
            r2 = r6
            goto L_0x003b
        L_0x003a:
            r4 = move-exception
        L_0x003b:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)
            r4 = r2
        L_0x003f:
            long r0 = r0 - r4
            long r0 = java.lang.Math.abs(r0)
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r8.mSensorsDataInstance
            int r2 = r2.getSessionIntervalTime()
            long r2 = (long) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SessionTimeOut:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SA.ActivityLifecycleCallbacks"
            com.sensorsdata.analytics.android.sdk.SALog.d(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.autotrack.ActivityLifecycleCallbacks.isSessionTimeOut():boolean");
    }

    private void sendActivityHandleMessage(int i) {
        Message obtainMessage = this.mHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putLong("time", System.currentTimeMillis());
        bundle.putLong("elapse_time", SystemClock.elapsedRealtime());
        obtainMessage.what = i;
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    private Message obtainAppEndMessage(boolean z) {
        Message obtain = Message.obtain(this.mHandler);
        obtain.what = 0;
        Bundle bundle = new Bundle();
        bundle.putLong("app_start_time", DbAdapter.getInstance().getAppStartTime());
        bundle.putLong("app_end_time", DbAdapter.getInstance().getAppEndTime());
        bundle.putString("app_end_data", DbAdapter.getInstance().getAppEndData());
        bundle.putLong("app_end_message_time", System.currentTimeMillis());
        bundle.putBoolean("app_reset_state", z);
        obtain.setData(bundle);
        return obtain;
    }

    /* access modifiers changed from: private */
    public void resetState() {
        try {
            this.mSensorsDataInstance.stopTrackScreenOrientation();
            this.mSensorsDataInstance.getRemoteManager().resetPullSDKConfigTimer();
            HeatMapService.getInstance().stop();
            VisualizedAutoTrackService.getInstance().stop();
            this.mSensorsDataInstance.appEnterBackground();
            this.resumeFromBackground = true;
            this.mSensorsDataInstance.clearLastScreenUrl();
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private void checkFirstDay() {
        if (this.mFirstDay.get() == null && SensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
            this.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), TimeUtils.YYYY_MM_DD));
        }
    }

    /* access modifiers changed from: private */
    public boolean isAutoTrackAppEnd() {
        return !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_END);
    }

    private void buildScreenProperties(Activity activity) {
        JSONObject buildTitleNoAutoTrackerProperties = AopUtil.buildTitleNoAutoTrackerProperties(activity);
        this.activityProperty = buildTitleNoAutoTrackerProperties;
        SensorsDataUtils.mergeJSONObject(buildTitleNoAutoTrackerProperties, this.endDataProperty);
        if (!SensorsDataAPI.getConfigOptions().isDisableSDK() && isDeepLinkParseSuccess(activity)) {
            ChannelUtils.removeDeepLinkInfo(this.endDataProperty);
            if (this.mDeepLinkProperty == null) {
                this.mDeepLinkProperty = new JSONObject();
            }
            DeepLinkManager.mergeDeepLinkProperty(this.mDeepLinkProperty);
        }
    }

    private boolean isDeepLinkParseSuccess(Activity activity) {
        Intent intent;
        try {
            if ((!SensorsDataUtils.isUniApp() || !ChannelUtils.isDeepLinkBlackList(activity)) && (intent = activity.getIntent()) != null && intent.getData() != null && !intent.getBooleanExtra(DeepLinkManager.IS_ANALYTICS_DEEPLINK, false) && DeepLinkManager.parseDeepLink(activity, SensorsDataAPI.getConfigOptions().isSaveDeepLinkInfo(), this.mSensorsDataInstance.getDeepLinkCallback())) {
                intent.putExtra(DeepLinkManager.IS_ANALYTICS_DEEPLINK, true);
                return true;
            }
        } catch (Throwable th) {
            SALog.i(TAG, th.getMessage());
        }
        return false;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (TextUtils.isEmpty(DbAdapter.getInstance().getAppEndData())) {
            DbAdapter.getInstance().commitAppStartTime(SystemClock.elapsedRealtime());
        } else {
            DbAdapter.getInstance().commitAppEndTime(System.currentTimeMillis());
        }
        if (SensorsDataAPI.getConfigOptions().isMultiProcessFlush()) {
            DbAdapter.getInstance().commitSubProcessFlushState(false);
        }
        DbAdapter.getInstance().commitActivityCount(0);
    }

    /* access modifiers changed from: package-private */
    public void addActivity(Activity activity) {
        if (activity != null) {
            this.hashSet.add(Integer.valueOf(activity.hashCode()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasActivity(Activity activity) {
        if (activity != null) {
            return this.hashSet.contains(Integer.valueOf(activity.hashCode()));
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            this.hashSet.remove(Integer.valueOf(activity.hashCode()));
        }
    }
}
