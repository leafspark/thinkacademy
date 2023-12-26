package com.sensorsdata.analytics.android.sdk.visual;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol;
import com.sensorsdata.analytics.android.sdk.visual.snap.EditState;
import com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import kotlin.io.ConstantsKt;
import org.json.JSONObject;

public abstract class AbstractViewCrawler implements VTrack {
    private static final int MESSAGE_SEND_STATE_FOR_EDITING = 1;
    private static final String TAG = "SA.AbstractViewCrawler";
    public static final String TYPE_HEAT_MAP = "heat_map";
    public static final String TYPE_VISUAL = "visual";
    private final Activity mActivity;
    /* access modifiers changed from: private */
    public String mAppVersion;
    /* access modifiers changed from: private */
    public final EditState mEditState;
    /* access modifiers changed from: private */
    public String mFeatureCode;
    private final LifecycleCallbacks mLifecycleCallbacks;
    /* access modifiers changed from: private */
    public JSONObject mMessageObject;
    /* access modifiers changed from: private */
    public final ViewCrawlerHandler mMessageThreadHandler;
    /* access modifiers changed from: private */
    public String mPostUrl;
    private boolean mServiceRunning = false;
    /* access modifiers changed from: private */
    public String mType;

    AbstractViewCrawler(Activity activity, String str, String str2, String str3, String str4) {
        this.mActivity = activity;
        this.mFeatureCode = str2;
        EditState editState = new EditState();
        this.mEditState = editState;
        this.mType = str4;
        editState.add(activity);
        this.mLifecycleCallbacks = new LifecycleCallbacks();
        try {
            this.mPostUrl = URLDecoder.decode(str3, Base64Coder.CHARSET_UTF8);
            this.mMessageObject = new JSONObject("{\"type\":\"snapshot_request\",\"payload\":{\"config\":{\"classes\":[{\"name\":\"android.view.View\",\"properties\":[{\"name\":\"importantForAccessibility\",\"get\":{\"selector\":\"isImportantForAccessibility\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}},{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.TextView\",\"properties\":[{\"name\":\"importantForAccessibility\",\"get\":{\"selector\":\"isImportantForAccessibility\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}},{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]},{\"name\":\"android.widget.ImageView\",\"properties\":[{\"name\":\"importantForAccessibility\",\"get\":{\"selector\":\"isImportantForAccessibility\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}},{\"name\":\"clickable\",\"get\":{\"selector\":\"isClickable\",\"parameters\":[],\"result\":{\"type\":\"java.lang.Boolean\"}}}]}]}}}");
        } catch (Exception e) {
            SALog.printStackTrace(e);
            this.mMessageObject = null;
        }
        ((Application) this.mActivity.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        try {
            this.mAppVersion = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            this.mAppVersion = "";
        }
        HandlerThread handlerThread = new HandlerThread(VisualizedAutoTrackViewCrawler.class.getCanonicalName(), 10);
        handlerThread.start();
        this.mMessageThreadHandler = new ViewCrawlerHandler(this.mActivity, handlerThread.getLooper(), str);
    }

    public void startUpdates() {
        try {
            if (!TextUtils.isEmpty(this.mFeatureCode) && !TextUtils.isEmpty(this.mPostUrl)) {
                ((Application) this.mActivity.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
                this.mMessageThreadHandler.start();
                ViewCrawlerHandler viewCrawlerHandler = this.mMessageThreadHandler;
                viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(1));
                this.mServiceRunning = true;
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void stopUpdates(boolean z) {
        if (z) {
            try {
                this.mFeatureCode = null;
                this.mPostUrl = null;
            } catch (Exception e) {
                SALog.printStackTrace(e);
                return;
            }
        }
        this.mMessageThreadHandler.removeMessages(1);
        ((Application) this.mActivity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        this.mServiceRunning = false;
    }

    public boolean isServiceRunning() {
        return this.mServiceRunning;
    }

    private class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private LifecycleCallbacks() {
        }

        public void onActivityResumed(Activity activity) {
            AbstractViewCrawler.this.mEditState.add(activity);
        }

        public void onActivityPaused(Activity activity) {
            AbstractViewCrawler.this.mEditState.remove(activity);
        }
    }

    private class ViewCrawlerHandler extends Handler {
        private String mAppId;
        private StringBuilder mLastImageHash;
        private final EditProtocol mProtocol;
        private final String mSDKVersion;
        private ViewSnapshot mSnapshot;
        private boolean mUseGzip;

        public void start() {
        }

        private ViewCrawlerHandler(Context context, Looper looper, String str) {
            super(looper);
            this.mSnapshot = null;
            this.mProtocol = new EditProtocol(new ResourceReader.Ids(str, context));
            this.mLastImageHash = new StringBuilder();
            this.mUseGzip = true;
            this.mAppId = AppInfoUtils.getProcessName(context);
            this.mSDKVersion = SensorsDataAPI.sharedInstance().getSDKVersion();
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                sendSnapshot(AbstractViewCrawler.this.mMessageObject);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:0x02f9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x02fa, code lost:
            r2 = r0;
            r14 = r5;
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0556, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0557, code lost:
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
            r2 = r0;
            r14 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x0563, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0564, code lost:
            r21 = r2;
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
            r14 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x0571, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x0572, code lost:
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
            r5 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x057c, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x057d, code lost:
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x025b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x025c, code lost:
            r2 = r0;
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0267, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0268, code lost:
            r5 = r0;
            r10 = r16;
            r8 = r17;
            r7 = r18;
            r4 = r19;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x02f9 A[ExcHandler: all (r0v19 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r3 r5 r6 r17 r18 r19 
          PHI: (r3v18 java.io.ByteArrayOutputStream) = (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v19 java.io.ByteArrayOutputStream), (r3v26 java.io.ByteArrayOutputStream), (r3v26 java.io.ByteArrayOutputStream) binds: [B:131:0x03b3, B:143:0x0411, B:154:0x0434, B:159:0x0440, B:152:0x0431, B:153:?, B:136:0x03c7, B:126:0x0396, B:127:?, B:121:0x035f, B:122:?, B:116:0x0340, B:117:?, B:109:0x0317, B:99:0x02dd, B:100:?, B:69:0x0205, B:70:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r5v9 java.io.ByteArrayOutputStream) = (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v10 java.io.ByteArrayOutputStream), (r5v26 java.io.ByteArrayOutputStream), (r5v26 java.io.ByteArrayOutputStream) binds: [B:131:0x03b3, B:143:0x0411, B:154:0x0434, B:159:0x0440, B:152:0x0431, B:153:?, B:136:0x03c7, B:126:0x0396, B:127:?, B:121:0x035f, B:122:?, B:116:0x0340, B:117:?, B:109:0x0317, B:99:0x02dd, B:100:?, B:69:0x0205, B:70:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v7 java.util.zip.GZIPOutputStream) = (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v8 java.util.zip.GZIPOutputStream), (r6v17 java.util.zip.GZIPOutputStream), (r6v17 java.util.zip.GZIPOutputStream) binds: [B:131:0x03b3, B:143:0x0411, B:154:0x0434, B:159:0x0440, B:152:0x0431, B:153:?, B:136:0x03c7, B:126:0x0396, B:127:?, B:121:0x035f, B:122:?, B:116:0x0340, B:117:?, B:109:0x0317, B:99:0x02dd, B:100:?, B:69:0x0205, B:70:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r17v2 java.lang.String) = (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v3 java.lang.String), (r17v5 java.lang.String), (r17v5 java.lang.String) binds: [B:131:0x03b3, B:143:0x0411, B:154:0x0434, B:159:0x0440, B:152:0x0431, B:153:?, B:136:0x03c7, B:126:0x0396, B:127:?, B:121:0x035f, B:122:?, B:116:0x0340, B:117:?, B:109:0x0317, B:99:0x02dd, B:100:?, B:69:0x0205, B:70:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v3 java.lang.String), (r18v5 java.lang.String), (r18v5 java.lang.String) binds: [B:131:0x03b3, B:143:0x0411, B:154:0x0434, B:159:0x0440, B:152:0x0431, B:153:?, B:136:0x03c7, B:126:0x0396, B:127:?, B:121:0x035f, B:122:?, B:116:0x0340, B:117:?, B:109:0x0317, B:99:0x02dd, B:100:?, B:69:0x0205, B:70:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r19v2 java.lang.String) = (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v3 java.lang.String), (r19v5 java.lang.String), (r19v5 java.lang.String) binds: [B:131:0x03b3, B:143:0x0411, B:154:0x0434, B:159:0x0440, B:152:0x0431, B:153:?, B:136:0x03c7, B:126:0x0396, B:127:?, B:121:0x035f, B:122:?, B:116:0x0340, B:117:?, B:109:0x0317, B:99:0x02dd, B:100:?, B:69:0x0205, B:70:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:143:0x0411] */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0312  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0317 A[SYNTHETIC, Splitter:B:109:0x0317] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x0340 A[SYNTHETIC, Splitter:B:116:0x0340] */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x035f A[SYNTHETIC, Splitter:B:121:0x035f] */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x0396 A[SYNTHETIC, Splitter:B:126:0x0396] */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x03b3 A[SYNTHETIC, Splitter:B:131:0x03b3] */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x0514 A[SYNTHETIC, Splitter:B:176:0x0514] */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x0521 A[SYNTHETIC, Splitter:B:181:0x0521] */
        /* JADX WARNING: Removed duplicated region for block: B:186:0x052e A[SYNTHETIC, Splitter:B:186:0x052e] */
        /* JADX WARNING: Removed duplicated region for block: B:198:0x0556 A[ExcHandler: all (r0v21 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:96:0x02d5] */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x057c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:91:0x02a7] */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x05b9 A[SYNTHETIC, Splitter:B:226:0x05b9] */
        /* JADX WARNING: Removed duplicated region for block: B:231:0x05c4 A[SYNTHETIC, Splitter:B:231:0x05c4] */
        /* JADX WARNING: Removed duplicated region for block: B:236:0x05cf A[SYNTHETIC, Splitter:B:236:0x05cf] */
        /* JADX WARNING: Removed duplicated region for block: B:249:0x05ec A[SYNTHETIC, Splitter:B:249:0x05ec] */
        /* JADX WARNING: Removed duplicated region for block: B:254:0x05f7 A[SYNTHETIC, Splitter:B:254:0x05f7] */
        /* JADX WARNING: Removed duplicated region for block: B:259:0x0602 A[SYNTHETIC, Splitter:B:259:0x0602] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x015f A[SYNTHETIC, Splitter:B:42:0x015f] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0180 A[SYNTHETIC, Splitter:B:48:0x0180] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x025b A[ExcHandler: all (r0v38 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:57:0x019a] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x029d  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x02dd A[SYNTHETIC, Splitter:B:99:0x02dd] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void sendSnapshot(org.json.JSONObject r23) {
            /*
                r22 = this;
                r1 = r22
                java.lang.String r2 = "{"
                java.lang.String r3 = "Can't close writer."
                java.lang.String r4 = "Can't close payload_out."
                java.lang.String r5 = "Can't close gos."
                java.lang.String r6 = "Can't close os."
                java.lang.String r7 = "\","
                java.lang.String r8 = ","
                java.lang.String r9 = "SA.AbstractViewCrawler"
                long r10 = java.lang.System.currentTimeMillis()
                java.lang.String r12 = "payload"
                r13 = r23
                org.json.JSONObject r12 = r13.getJSONObject(r12)     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
                java.lang.String r13 = "config"
                boolean r13 = r12.has(r13)     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
                if (r13 == 0) goto L_0x002e
                com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol r13 = r1.mProtocol     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r12 = r13.readSnapshotConfig(r12)     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
                r1.mSnapshot = r12     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
            L_0x002e:
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r12 = r1.mSnapshot     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
                if (r12 != 0) goto L_0x0038
                java.lang.String r2 = "Snapshot should be initialize at first calling."
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r2)     // Catch:{ JSONException -> 0x061d, BadInstructionsException -> 0x0615 }
                return
            L_0x0038:
                java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream
                r12.<init>()
                java.io.OutputStreamWriter r13 = new java.io.OutputStreamWriter
                r13.<init>(r12)
                r13.write(r2)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = "\"type\": \"snapshot_response\","
                r13.write(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r15.<init>()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = "\"feature_code\": \""
                r15.append(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r14 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = r14.mFeatureCode     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r15.append(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r15.append(r7)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = r15.toString()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.<init>()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = "\"app_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r15 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = r15.mAppVersion     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r7)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.<init>()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = "\"lib_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = r1.mSDKVersion     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r7)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = "\"os\": \"Android\","
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = "\"lib\": \"Android\","
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.<init>()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = "\"app_id\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = r1.mAppId     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r7)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.<init>()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r15 = "\"app_enablevisualizedproperties\": "
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                boolean r15 = r15.isVisualizedPropertiesEnabled()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r15)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r14.append(r8)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                r13.write(r14)     // Catch:{ IOException -> 0x05a8, all -> 0x059e }
                org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ Exception -> 0x014a, IOException -> 0x013e, all -> 0x0136 }
                r14.<init>()     // Catch:{ Exception -> 0x014a, IOException -> 0x013e, all -> 0x0136 }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x014a, IOException -> 0x013e, all -> 0x0136 }
                r16 = r3
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x0134 }
                boolean r3 = r15.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r3)     // Catch:{ Exception -> 0x0134 }
                if (r3 != 0) goto L_0x00f7
                java.lang.String r3 = "$AppClick"
                r14.put(r3)     // Catch:{ Exception -> 0x0134 }
            L_0x00f7:
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0134 }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r15 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN     // Catch:{ Exception -> 0x0134 }
                boolean r3 = r3.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r15)     // Catch:{ Exception -> 0x0134 }
                if (r3 != 0) goto L_0x0108
                java.lang.String r3 = "$AppViewScreen"
                r14.put(r3)     // Catch:{ Exception -> 0x0134 }
            L_0x0108:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0134 }
                r3.<init>()     // Catch:{ Exception -> 0x0134 }
                java.lang.String r15 = "\"app_autotrack\": "
                r3.append(r15)     // Catch:{ Exception -> 0x0134 }
                java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0134 }
                r3.append(r14)     // Catch:{ Exception -> 0x0134 }
                r3.append(r8)     // Catch:{ Exception -> 0x0134 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0134 }
                r13.write(r3)     // Catch:{ Exception -> 0x0134 }
                goto L_0x0151
            L_0x0124:
                r0 = move-exception
                r2 = r0
                r8 = r4
                r7 = r5
                r4 = r6
                r10 = r16
                goto L_0x05a4
            L_0x012d:
                r0 = move-exception
                r8 = r4
                r7 = r5
                r4 = r6
                r10 = r16
                goto L_0x0143
            L_0x0134:
                r0 = move-exception
                goto L_0x014d
            L_0x0136:
                r0 = move-exception
                r2 = r0
                r10 = r3
                r8 = r4
                r7 = r5
                r4 = r6
                goto L_0x05a4
            L_0x013e:
                r0 = move-exception
                r10 = r3
                r8 = r4
                r7 = r5
                r4 = r6
            L_0x0143:
                r2 = 0
                r3 = 0
            L_0x0145:
                r6 = 0
                r14 = 0
            L_0x0147:
                r5 = r0
                goto L_0x05b2
            L_0x014a:
                r0 = move-exception
                r16 = r3
            L_0x014d:
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ IOException -> 0x0597, all -> 0x0590 }
            L_0x0151:
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r3 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ IOException -> 0x0597, all -> 0x0590 }
                java.lang.String r3 = r3.getVisualConfigVersion()     // Catch:{ IOException -> 0x0597, all -> 0x0590 }
                boolean r14 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0597, all -> 0x0590 }
                if (r14 != 0) goto L_0x0176
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                r14.<init>()     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                java.lang.String r15 = "\"config_version\": \""
                r14.append(r15)     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                r14.append(r3)     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                r14.append(r7)     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                java.lang.String r3 = r14.toString()     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                r13.write(r3)     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
            L_0x0176:
                boolean r3 = r1.mUseGzip     // Catch:{ IOException -> 0x0597, all -> 0x0590 }
                java.lang.String r7 = ",\"snapshot_time_millis\": "
                java.lang.String r14 = "}"
                java.lang.String r15 = "\""
                if (r3 == 0) goto L_0x029d
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                r3.<init>()     // Catch:{ IOException -> 0x012d, all -> 0x0124 }
                r17 = r4
                java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0293, all -> 0x0289 }
                r4.<init>(r3)     // Catch:{ IOException -> 0x0293, all -> 0x0289 }
                r18 = r5
                java.lang.String r5 = "{\"activities\":"
                r4.write(r5)     // Catch:{ IOException -> 0x027d, all -> 0x0272 }
                r4.flush()     // Catch:{ IOException -> 0x027d, all -> 0x0272 }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r5 = r1.mSnapshot     // Catch:{ IOException -> 0x027d, all -> 0x0272 }
                r19 = r6
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r6 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0267, all -> 0x025b }
                com.sensorsdata.analytics.android.sdk.visual.snap.EditState r6 = r6.mEditState     // Catch:{ IOException -> 0x0267, all -> 0x025b }
                r20 = r2
                java.lang.StringBuilder r2 = r1.mLastImageHash     // Catch:{ IOException -> 0x0267, all -> 0x025b }
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r2 = r5.snapshots(r6, r3, r2)     // Catch:{ IOException -> 0x0267, all -> 0x025b }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                long r5 = r5 - r10
                r4.write(r7)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                r4.write(r5)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r5 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.lang.String r5 = r5.getDebugInfo()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                if (r6 != 0) goto L_0x01d0
                r4.write(r8)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.lang.String r6 = "\"event_debug\": "
                r4.write(r6)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                r4.write(r5)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
            L_0x01d0:
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r5 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.lang.String r5 = r5.getVisualLogInfo()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                if (r6 != 0) goto L_0x01e9
                r4.write(r8)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.lang.String r6 = "\"log_info\":"
                r4.write(r6)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                r4.write(r5)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
            L_0x01e9:
                r4.write(r14)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                r4.flush()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                r3.close()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.lang.String r4 = r3.toString()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                int r6 = r4.length     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                r5.<init>(r6)     // Catch:{ IOException -> 0x024f, all -> 0x025b }
                java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0242, all -> 0x0234 }
                r6.<init>(r5)     // Catch:{ IOException -> 0x0242, all -> 0x0234 }
                r6.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r6.close()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                byte[] r4 = r5.toByteArray()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r5.close()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r10 = "\"gzip_payload\": \""
                r7.append(r10)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r10 = new java.lang.String     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                char[] r4 = com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r10.<init>(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r10)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                goto L_0x02d5
            L_0x0234:
                r0 = move-exception
                r2 = r0
                r14 = r5
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                r6 = 0
                goto L_0x05ea
            L_0x0242:
                r0 = move-exception
                r14 = r5
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                r6 = 0
                goto L_0x0147
            L_0x024f:
                r0 = move-exception
                r5 = r0
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x05b0
            L_0x025b:
                r0 = move-exception
                r2 = r0
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x05a5
            L_0x0267:
                r0 = move-exception
                r5 = r0
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x0286
            L_0x0272:
                r0 = move-exception
                r2 = r0
                r4 = r6
                r10 = r16
                r8 = r17
                r7 = r18
                goto L_0x05a5
            L_0x027d:
                r0 = move-exception
                r5 = r0
                r4 = r6
                r10 = r16
                r8 = r17
                r7 = r18
            L_0x0286:
                r2 = 0
                goto L_0x05b0
            L_0x0289:
                r0 = move-exception
                r2 = r0
                r7 = r5
                r4 = r6
                r10 = r16
                r8 = r17
                goto L_0x05a5
            L_0x0293:
                r0 = move-exception
                r7 = r5
                r4 = r6
                r10 = r16
                r8 = r17
                r2 = 0
                goto L_0x0145
            L_0x029d:
                r20 = r2
                r17 = r4
                r18 = r5
                r19 = r6
                java.lang.String r2 = "\"payload\": {"
                r13.write(r2)     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                java.lang.String r2 = "\"activities\":"
                r13.write(r2)     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                r13.flush()     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot r2 = r1.mSnapshot     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r3 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                com.sensorsdata.analytics.android.sdk.visual.snap.EditState r3 = r3.mEditState     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                java.lang.StringBuilder r4 = r1.mLastImageHash     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r2 = r2.snapshots(r3, r12, r4)     // Catch:{ IOException -> 0x0586, all -> 0x057c }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0571, all -> 0x057c }
                long r3 = r3 - r10
                r13.write(r7)     // Catch:{ IOException -> 0x0571, all -> 0x057c }
                java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ IOException -> 0x0571, all -> 0x057c }
                r13.write(r3)     // Catch:{ IOException -> 0x0571, all -> 0x057c }
                r13.write(r14)     // Catch:{ IOException -> 0x0571, all -> 0x057c }
                r3 = 0
                r5 = 0
                r6 = 0
            L_0x02d5:
                java.lang.String r4 = r2.screenName     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                if (r4 != 0) goto L_0x0312
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = ",\"screen_name\": \""
                r4.append(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = r2.screenName     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.append(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r2.screenName     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                goto L_0x0313
            L_0x02f9:
                r0 = move-exception
                r2 = r0
                r14 = r5
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x05ea
            L_0x0306:
                r0 = move-exception
            L_0x0307:
                r14 = r5
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x0147
            L_0x0312:
                r4 = 0
            L_0x0313:
                boolean r7 = r2.hasFragment     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                if (r7 == 0) goto L_0x0326
                com.sensorsdata.analytics.android.sdk.AppStateManager r7 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = r7.getFragmentScreenName()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                if (r10 != 0) goto L_0x0326
                r4 = r7
            L_0x0326:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                r7.<init>()     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                java.lang.String r10 = "page_name： "
                r7.append(r10)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                r7.append(r4)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r7)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                if (r7 != 0) goto L_0x0357
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r10 = ",\"page_name\": \""
                r7.append(r10)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
            L_0x0357:
                java.lang.String r4 = r2.activityTitle     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                if (r4 != 0) goto L_0x0378
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = ",\"title\": \""
                r4.append(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = r2.activityTitle     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.append(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
            L_0x0378:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                r4.<init>()     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                java.lang.String r7 = ",\"is_webview\": "
                r4.append(r7)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                boolean r7 = r2.isWebView     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                r4.append(r7)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                r13.write(r4)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                java.lang.String r4 = r2.webLibVersion     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                if (r4 != 0) goto L_0x03af
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = ",\"web_lib_version\": \""
                r4.append(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = r2.webLibVersion     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.append(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
            L_0x03af:
                boolean r4 = r2.isWebView     // Catch:{ IOException -> 0x0563, all -> 0x0556 }
                if (r4 == 0) goto L_0x050a
                java.lang.String r4 = r2.webViewUrl     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                if (r4 != 0) goto L_0x050a
                com.sensorsdata.analytics.android.sdk.visual.WebNodesManager r4 = com.sensorsdata.analytics.android.sdk.visual.WebNodesManager.getInstance()     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                java.lang.String r7 = r2.webViewUrl     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo r4 = r4.getWebPageInfo(r7)     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                if (r4 == 0) goto L_0x0411
                java.lang.String r7 = r4.getUrl()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                if (r7 != 0) goto L_0x03ec
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r10 = ",\"h5_url\": \""
                r7.append(r10)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r10 = r4.getUrl()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r10)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
            L_0x03ec:
                java.lang.String r7 = r4.getTitle()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                if (r7 != 0) goto L_0x0411
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.<init>()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r10 = ",\"h5_title\": \""
                r7.append(r10)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r4.getTitle()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r7.append(r15)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                java.lang.String r4 = r7.toString()     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
            L_0x0411:
                java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo$AlertInfo> r4 = r2.alertInfos     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                if (r4 == 0) goto L_0x050a
                int r7 = r4.size()     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                if (r7 <= 0) goto L_0x050a
                java.lang.String r7 = ",\"app_alert_infos\":"
                r13.write(r7)     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                r13.flush()     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                java.lang.String r7 = "["
                r13.write(r7)     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                r7 = 0
            L_0x0429:
                int r10 = r4.size()     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                if (r7 >= r10) goto L_0x04ef
                if (r7 <= 0) goto L_0x0434
                r13.write(r8)     // Catch:{ IOException -> 0x0306, all -> 0x02f9 }
            L_0x0434:
                java.lang.Object r10 = r4.get(r7)     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo$AlertInfo r10 = (com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo.AlertInfo) r10     // Catch:{ IOException -> 0x0505, all -> 0x02f9 }
                if (r10 == 0) goto L_0x04df
                java.lang.String r11 = "heat_map"
                r21 = r2
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r2 = r2.mType     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                boolean r2 = android.text.TextUtils.equals(r11, r2)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                if (r2 == 0) goto L_0x045b
                java.lang.String r2 = r10.title     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r11 = "可视化全埋点"
                r23 = r4
                java.lang.String r4 = "点击分析"
                java.lang.String r2 = r2.replace(r11, r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r10.title = r2     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                goto L_0x045d
            L_0x045b:
                r23 = r4
            L_0x045d:
                r2 = r20
                r13.write(r2)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = "\"title\":"
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r11 = r10.title     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r11)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r8)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = "\"message\":"
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r11 = r10.message     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r11)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r8)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = "\"link_text\":"
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r11 = r10.linkText     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r11)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r8)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = "\"link_url\":"
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.<init>()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r10 = r10.linkUrl     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r10)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r4.append(r15)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r4)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.write(r14)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                goto L_0x04e5
            L_0x04df:
                r21 = r2
                r23 = r4
                r2 = r20
            L_0x04e5:
                int r7 = r7 + 1
                r4 = r23
                r20 = r2
                r2 = r21
                goto L_0x0429
            L_0x04ef:
                r21 = r2
                java.lang.String r2 = "]"
                r13.write(r2)     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                r13.flush()     // Catch:{ IOException -> 0x04fa, all -> 0x02f9 }
                goto L_0x050c
            L_0x04fa:
                r0 = move-exception
                r14 = r5
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x0552
            L_0x0505:
                r0 = move-exception
                r21 = r2
                goto L_0x0307
            L_0x050a:
                r21 = r2
            L_0x050c:
                r13.write(r14)     // Catch:{ IOException -> 0x0548, all -> 0x0556 }
                r13.flush()     // Catch:{ IOException -> 0x0548, all -> 0x0556 }
                if (r5 == 0) goto L_0x051f
                r5.close()     // Catch:{ Exception -> 0x0518 }
                goto L_0x051f
            L_0x0518:
                r0 = move-exception
                r2 = r0
                r4 = r19
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r4, r2)
            L_0x051f:
                if (r6 == 0) goto L_0x052c
                r6.close()     // Catch:{ Exception -> 0x0525 }
                goto L_0x052c
            L_0x0525:
                r0 = move-exception
                r2 = r0
                r7 = r18
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r7, r2)
            L_0x052c:
                if (r3 == 0) goto L_0x0539
                r3.close()     // Catch:{ Exception -> 0x0532 }
                goto L_0x0539
            L_0x0532:
                r0 = move-exception
                r2 = r0
                r8 = r17
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r8, r2)
            L_0x0539:
                r13.close()     // Catch:{ IOException -> 0x053d }
                goto L_0x0544
            L_0x053d:
                r0 = move-exception
                r2 = r0
                r10 = r16
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r10, r2)
            L_0x0544:
                r2 = r21
                goto L_0x05e1
            L_0x0548:
                r0 = move-exception
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                r14 = r5
            L_0x0552:
                r2 = r21
                goto L_0x0147
            L_0x0556:
                r0 = move-exception
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                r2 = r0
                r14 = r5
                goto L_0x05ea
            L_0x0563:
                r0 = move-exception
                r21 = r2
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                r14 = r5
                goto L_0x0147
            L_0x0571:
                r0 = move-exception
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                r5 = r0
                goto L_0x05af
            L_0x057c:
                r0 = move-exception
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x05a3
            L_0x0586:
                r0 = move-exception
                r10 = r16
                r8 = r17
                r7 = r18
                r4 = r19
                goto L_0x05ad
            L_0x0590:
                r0 = move-exception
                r8 = r4
                r7 = r5
                r4 = r6
                r10 = r16
                goto L_0x05a3
            L_0x0597:
                r0 = move-exception
                r8 = r4
                r7 = r5
                r4 = r6
                r10 = r16
                goto L_0x05ad
            L_0x059e:
                r0 = move-exception
                r10 = r3
                r8 = r4
                r7 = r5
                r4 = r6
            L_0x05a3:
                r2 = r0
            L_0x05a4:
                r3 = 0
            L_0x05a5:
                r6 = 0
                r14 = 0
                goto L_0x05ea
            L_0x05a8:
                r0 = move-exception
                r10 = r3
                r8 = r4
                r7 = r5
                r4 = r6
            L_0x05ad:
                r5 = r0
                r2 = 0
            L_0x05af:
                r3 = 0
            L_0x05b0:
                r6 = 0
                r14 = 0
            L_0x05b2:
                java.lang.String r11 = "Can't write snapshot request to server"
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r11, r5)     // Catch:{ all -> 0x05e8 }
                if (r14 == 0) goto L_0x05c2
                r14.close()     // Catch:{ Exception -> 0x05bd }
                goto L_0x05c2
            L_0x05bd:
                r0 = move-exception
                r5 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r4, r5)
            L_0x05c2:
                if (r6 == 0) goto L_0x05cd
                r6.close()     // Catch:{ Exception -> 0x05c8 }
                goto L_0x05cd
            L_0x05c8:
                r0 = move-exception
                r4 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r7, r4)
            L_0x05cd:
                if (r3 == 0) goto L_0x05d8
                r3.close()     // Catch:{ Exception -> 0x05d3 }
                goto L_0x05d8
            L_0x05d3:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r8, r3)
            L_0x05d8:
                r13.close()     // Catch:{ IOException -> 0x05dc }
                goto L_0x05e1
            L_0x05dc:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r10, r3)
            L_0x05e1:
                r1.onSnapFinished(r2)
                r1.postSnapshot(r12)
                return
            L_0x05e8:
                r0 = move-exception
                r2 = r0
            L_0x05ea:
                if (r14 == 0) goto L_0x05f5
                r14.close()     // Catch:{ Exception -> 0x05f0 }
                goto L_0x05f5
            L_0x05f0:
                r0 = move-exception
                r5 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r4, r5)
            L_0x05f5:
                if (r6 == 0) goto L_0x0600
                r6.close()     // Catch:{ Exception -> 0x05fb }
                goto L_0x0600
            L_0x05fb:
                r0 = move-exception
                r4 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r7, r4)
            L_0x0600:
                if (r3 == 0) goto L_0x060b
                r3.close()     // Catch:{ Exception -> 0x0606 }
                goto L_0x060b
            L_0x0606:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r8, r3)
            L_0x060b:
                r13.close()     // Catch:{ IOException -> 0x060f }
                goto L_0x0614
            L_0x060f:
                r0 = move-exception
                r3 = r0
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r10, r3)
            L_0x0614:
                throw r2
            L_0x0615:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = "VisualizedAutoTrack server sent malformed message with snapshot request"
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r3, r2)
                return
            L_0x061d:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = "Payload with snapshot config required with snapshot request"
                com.sensorsdata.analytics.android.sdk.SALog.i(r9, r3, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler.sendSnapshot(org.json.JSONObject):void");
        }

        private void onSnapFinished(SnapInfo snapInfo) {
            if (snapInfo != null && !WebNodesManager.getInstance().hasWebView()) {
                WebNodesManager.getInstance().clear();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.InputStream} */
        /* JADX WARNING: type inference failed for: r6v12 */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:29|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x01a4, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x01a5, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x01ae, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x01af, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01b8, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01b9, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x01c2, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01c3, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r4 = r6.getErrorStream();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0118, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0119, code lost:
            r6 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0143, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0144, code lost:
            r6 = r4;
            r4 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0164, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0165, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x016e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x016f, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0178, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0179, code lost:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x009c */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x017e A[SYNTHETIC, Splitter:B:100:0x017e] */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0183  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0197  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x01a0 A[SYNTHETIC, Splitter:B:107:0x01a0] */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x01aa A[SYNTHETIC, Splitter:B:112:0x01aa] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x01b4 A[SYNTHETIC, Splitter:B:117:0x01b4] */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x01be A[SYNTHETIC, Splitter:B:122:0x01be] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0143 A[ExcHandler: all (th java.lang.Throwable), PHI: r4 
          PHI: (r4v4 java.io.BufferedOutputStream) = (r4v0 java.io.BufferedOutputStream), (r4v0 java.io.BufferedOutputStream), (r4v10 java.io.BufferedOutputStream) binds: [B:25:0x0085, B:29:0x009c, B:38:0x00e7] A[DONT_GENERATE, DONT_INLINE], Splitter:B:25:0x0085] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0160 A[SYNTHETIC, Splitter:B:85:0x0160] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x016a A[SYNTHETIC, Splitter:B:90:0x016a] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0174 A[SYNTHETIC, Splitter:B:95:0x0174] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void postSnapshot(java.io.ByteArrayOutputStream r12) {
            /*
                r11 = this;
                java.lang.String r0 = "SA.AbstractViewCrawler"
                java.lang.String r1 = "UTF-8"
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                java.lang.String r2 = r2.mFeatureCode
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x01c7
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r2 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                java.lang.String r2 = r2.mPostUrl
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x001e
                goto L_0x01c7
            L_0x001e:
                r2 = 1000(0x3e8, double:4.94E-321)
                r4 = 0
                r5 = 1
                java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r7 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.lang.String r7 = r7.mPostUrl     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.net.URLConnection r6 = r6.openConnection()     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r7 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                if (r7 == 0) goto L_0x006d
                boolean r8 = r7.isDisableSDK()     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                if (r8 == 0) goto L_0x005d
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r0 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r0 = r0.mMessageThreadHandler     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r1 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r1 = r1.mMessageThreadHandler     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                android.os.Message r1 = r1.obtainMessage(r5)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                r0.sendMessageDelayed(r1, r2)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                if (r12 == 0) goto L_0x005c
                r12.close()     // Catch:{ Exception -> 0x0058 }
                goto L_0x005c
            L_0x0058:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
            L_0x005c:
                return
            L_0x005d:
                javax.net.ssl.SSLSocketFactory r8 = r7.mSSLSocketFactory     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                if (r8 == 0) goto L_0x006d
                boolean r8 = r6 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                if (r8 == 0) goto L_0x006d
                r8 = r6
                javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                javax.net.ssl.SSLSocketFactory r7 = r7.mSSLSocketFactory     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                r8.setSSLSocketFactory(r7)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
            L_0x006d:
                r6.setDoOutput(r5)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.lang.String r7 = "POST"
                r6.setRequestMethod(r7)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.lang.String r7 = "Content-type"
                java.lang.String r8 = "text/plain"
                r6.setRequestProperty(r7, r8)     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ Exception -> 0x0157, all -> 0x0153 }
                java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0150, all -> 0x014d }
                r8.<init>(r7)     // Catch:{ Exception -> 0x0150, all -> 0x014d }
                java.lang.String r9 = r12.toString()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                byte[] r9 = r9.getBytes(r1)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r8.write(r9)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r8.flush()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                int r9 = r6.getResponseCode()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.io.InputStream r4 = r6.getInputStream()     // Catch:{ FileNotFoundException -> 0x009c }
                goto L_0x00a0
            L_0x009c:
                java.io.InputStream r4 = r6.getErrorStream()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
            L_0x00a0:
                byte[] r6 = r11.slurp(r4)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r10.<init>(r6, r1)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r1.<init>()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.String r6 = "responseCode="
                r1.append(r6)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r1.append(r9)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r1.<init>()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.String r6 = "response="
                r1.append(r6)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r1.append(r10)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r0.<init>(r10)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                r1 = 200(0xc8, float:2.8E-43)
                if (r9 != r1) goto L_0x011b
                java.lang.String r1 = "delay"
                int r1 = r0.getInt(r1)     // Catch:{ Exception -> 0x0148, all -> 0x0143 }
                if (r1 >= 0) goto L_0x00e4
                r1 = 0
                goto L_0x00e5
            L_0x00e4:
                r1 = r5
            L_0x00e5:
                java.lang.String r6 = "visualized_sdk_config"
                java.lang.String r6 = r0.optString(r6)     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                java.lang.String r9 = "visualized_config_disabled"
                boolean r9 = r0.optBoolean(r9)     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                if (r10 == 0) goto L_0x00f9
                if (r9 == 0) goto L_0x010a
            L_0x00f9:
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r9 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                boolean r9 = r9.isVisualizedPropertiesEnabled()     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                if (r9 == 0) goto L_0x010a
                com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r9 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                r9.save2Cache(r6)     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
            L_0x010a:
                com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r6 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                java.lang.String r9 = "visualized_debug_mode_enabled"
                boolean r0 = r0.optBoolean(r9)     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                r6.setDebugModeEnabled(r0)     // Catch:{ Exception -> 0x0118, all -> 0x0143 }
                goto L_0x011c
            L_0x0118:
                r0 = move-exception
                r6 = r4
                goto L_0x014b
            L_0x011b:
                r1 = r5
            L_0x011c:
                r8.close()     // Catch:{ Exception -> 0x0120 }
                goto L_0x0124
            L_0x0120:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0124:
                if (r4 == 0) goto L_0x012e
                r4.close()     // Catch:{ Exception -> 0x012a }
                goto L_0x012e
            L_0x012a:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x012e:
                if (r7 == 0) goto L_0x0138
                r7.close()     // Catch:{ Exception -> 0x0134 }
                goto L_0x0138
            L_0x0134:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0138:
                if (r12 == 0) goto L_0x0181
                r12.close()     // Catch:{ Exception -> 0x013e }
                goto L_0x0181
            L_0x013e:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
                goto L_0x0181
            L_0x0143:
                r0 = move-exception
                r6 = r4
                r4 = r8
                goto L_0x019e
            L_0x0148:
                r0 = move-exception
                r6 = r4
                r1 = r5
            L_0x014b:
                r4 = r8
                goto L_0x015b
            L_0x014d:
                r0 = move-exception
                r6 = r4
                goto L_0x019e
            L_0x0150:
                r0 = move-exception
                r6 = r4
                goto L_0x015a
            L_0x0153:
                r0 = move-exception
                r6 = r4
                r7 = r6
                goto L_0x019e
            L_0x0157:
                r0 = move-exception
                r6 = r4
                r7 = r6
            L_0x015a:
                r1 = r5
            L_0x015b:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x019d }
                if (r4 == 0) goto L_0x0168
                r4.close()     // Catch:{ Exception -> 0x0164 }
                goto L_0x0168
            L_0x0164:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0168:
                if (r6 == 0) goto L_0x0172
                r6.close()     // Catch:{ Exception -> 0x016e }
                goto L_0x0172
            L_0x016e:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x0172:
                if (r7 == 0) goto L_0x017c
                r7.close()     // Catch:{ Exception -> 0x0178 }
                goto L_0x017c
            L_0x0178:
                r0 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            L_0x017c:
                if (r12 == 0) goto L_0x0181
                r12.close()     // Catch:{ Exception -> 0x013e }
            L_0x0181:
                if (r1 == 0) goto L_0x0197
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r12 = r12.mMessageThreadHandler
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r0 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler$ViewCrawlerHandler r0 = r0.mMessageThreadHandler
                android.os.Message r0 = r0.obtainMessage(r5)
                r12.sendMessageDelayed(r0, r2)
                goto L_0x019c
            L_0x0197:
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler r12 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this
                r12.stopUpdates(r5)
            L_0x019c:
                return
            L_0x019d:
                r0 = move-exception
            L_0x019e:
                if (r4 == 0) goto L_0x01a8
                r4.close()     // Catch:{ Exception -> 0x01a4 }
                goto L_0x01a8
            L_0x01a4:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01a8:
                if (r6 == 0) goto L_0x01b2
                r6.close()     // Catch:{ Exception -> 0x01ae }
                goto L_0x01b2
            L_0x01ae:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01b2:
                if (r7 == 0) goto L_0x01bc
                r7.close()     // Catch:{ Exception -> 0x01b8 }
                goto L_0x01bc
            L_0x01b8:
                r1 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
            L_0x01bc:
                if (r12 == 0) goto L_0x01c6
                r12.close()     // Catch:{ Exception -> 0x01c2 }
                goto L_0x01c6
            L_0x01c2:
                r12 = move-exception
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
            L_0x01c6:
                throw r0
            L_0x01c7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler.postSnapshot(java.io.ByteArrayOutputStream):void");
        }

        private byte[] slurp(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[ConstantsKt.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr, 0, ConstantsKt.DEFAULT_BUFFER_SIZE);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }
    }
}
