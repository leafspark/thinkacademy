package com.sensorsdata.analytics.android.sdk.visual.property;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualConfigRequestHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

public class VisualPropertiesManager {
    private static final String PROPERTY_TYPE_NUMBER = "NUMBER";
    private static final String TAG = "SA.VP.VisualPropertiesManager";
    private static VisualPropertiesManager sInstance;
    private CollectLogListener mCollectLogListener;
    private VisualPropertiesCache mConfigCache;
    private VisualConfigRequestHelper mRequestHelper = new VisualConfigRequestHelper();
    private VisualConfig mVisualConfig;
    private VisualPropertiesH5Helper mVisualPropertiesH5Helper = new VisualPropertiesH5Helper();

    interface CollectLogListener {
        void onCheckEventConfigFailure();

        void onCheckVisualConfigFailure(String str);

        void onFindPropertyElementFailure(String str, String str2, String str3);

        void onOtherError(String str);

        void onParsePropertyContentFailure(String str, String str2, String str3, String str4);

        void onStart(String str, String str2, ViewNode viewNode);

        void onSwitchClose();
    }

    private VisualPropertiesManager() {
        VisualPropertiesCache visualPropertiesCache = new VisualPropertiesCache();
        this.mConfigCache = visualPropertiesCache;
        this.mVisualConfig = visualPropertiesCache.getVisualConfig();
    }

    public static VisualPropertiesManager getInstance() {
        if (sInstance == null) {
            synchronized (VisualPropertiesManager.class) {
                if (sInstance == null) {
                    sInstance = new VisualPropertiesManager();
                }
            }
        }
        return sInstance;
    }

    public void requestVisualConfig(Context context, SensorsDataAPI sensorsDataAPI) {
        if (sensorsDataAPI != null) {
            try {
                if (sensorsDataAPI.isNetworkRequestEnable()) {
                    this.mRequestHelper.requestVisualConfig(context, getVisualConfigVersion(), new VisualConfigRequestHelper.IApiCallback() {
                        public void onSuccess(String str) {
                            VisualPropertiesManager.this.save2Cache(str);
                        }
                    });
                    return;
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
                return;
            }
        }
        SALog.i(TAG, "Close network request");
    }

    public void requestVisualConfig() {
        try {
            Context context = SensorsDataAPI.sharedInstance().getContext();
            if (context != null) {
                requestVisualConfig(context, SensorsDataAPI.sharedInstance());
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public VisualPropertiesH5Helper getVisualPropertiesH5Helper() {
        return this.mVisualPropertiesH5Helper;
    }

    public VisualPropertiesCache getVisualPropertiesCache() {
        return this.mConfigCache;
    }

    public VisualConfig getVisualConfig() {
        return this.mVisualConfig;
    }

    public void save2Cache(String str) {
        this.mConfigCache.save2Cache(str);
        this.mVisualConfig = this.mConfigCache.getVisualConfig();
    }

    public String getVisualConfigVersion() {
        VisualConfig visualConfig = this.mVisualConfig;
        if (visualConfig != null) {
            return visualConfig.version;
        }
        return null;
    }

    public void registerCollectLogListener(CollectLogListener collectLogListener) {
        this.mCollectLogListener = collectLogListener;
    }

    public void unRegisterCollectLogListener() {
        this.mCollectLogListener = null;
    }

    public enum VisualEventType {
        APP_CLICK("appclick", AopConstants.APP_CLICK_EVENT_NAME),
        WEB_CLICK("appclick", AopConstants.WEB_CLICK_EVENT_NAME);
        
        private String trackEventType;
        /* access modifiers changed from: private */
        public String visualEventType;

        private VisualEventType(String str, String str2) {
            this.visualEventType = str;
            this.trackEventType = str2;
        }

        public String getVisualEventType() {
            return this.visualEventType;
        }

        public static VisualEventType getVisualEventType(String str) {
            for (VisualEventType visualEventType2 : values()) {
                if (TextUtils.equals(visualEventType2.trackEventType, str)) {
                    return visualEventType2;
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        r4 = r14.getView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeVisualProperties(com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType r12, org.json.JSONObject r13, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r14) {
        /*
            r11 = this;
            java.lang.String r0 = "propertiesConfigs is empty"
            java.lang.String r1 = "activity is null or not in white list and return"
            java.lang.String r2 = "SA.VP.VisualPropertiesManager"
            java.lang.String r3 = "$screen_name"
            java.lang.String r7 = r13.optString(r3)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r3 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r3 == 0) goto L_0x0017
            java.lang.String r4 = r12.visualEventType     // Catch:{ Exception -> 0x0139 }
            r3.onStart(r4, r7, r14)     // Catch:{ Exception -> 0x0139 }
        L_0x0017:
            java.lang.String r3 = "mergeVisualProperties eventType: %s, screenName:%s "
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0139 }
            r5 = 0
            java.lang.String r6 = r12.getVisualEventType()     // Catch:{ Exception -> 0x0139 }
            r4[r5] = r6     // Catch:{ Exception -> 0x0139 }
            r5 = 1
            r4[r5] = r7     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0139 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0139 }
            if (r3 == 0) goto L_0x0039
            java.lang.String r12 = "screenName is empty and return"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x0139 }
            return
        L_0x0039:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0139 }
            boolean r3 = r3.isVisualizedAutoTrackEnabled()     // Catch:{ Exception -> 0x0139 }
            if (r3 != 0) goto L_0x0050
            java.lang.String r12 = "you should call 'enableVisualizedAutoTrack(true)' first"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r12 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r12 == 0) goto L_0x004f
            r12.onSwitchClose()     // Catch:{ Exception -> 0x0139 }
        L_0x004f:
            return
        L_0x0050:
            r3 = 0
            if (r14 == 0) goto L_0x0074
            java.lang.ref.WeakReference r4 = r14.getView()     // Catch:{ Exception -> 0x0139 }
            if (r4 == 0) goto L_0x0074
            java.lang.Object r5 = r4.get()     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x0074
            java.lang.Object r5 = r4.get()     // Catch:{ Exception -> 0x0139 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x0139 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0139 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0139 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r4 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getActivityFromContext(r5, r4)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0075
        L_0x0074:
            r4 = r3
        L_0x0075:
            if (r4 != 0) goto L_0x007f
            com.sensorsdata.analytics.android.sdk.AppStateManager r4 = com.sensorsdata.analytics.android.sdk.AppStateManager.getInstance()     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r4 = r4.getForegroundActivity()     // Catch:{ Exception -> 0x0139 }
        L_0x007f:
            if (r4 == 0) goto L_0x012e
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r5 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0139 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ Exception -> 0x0139 }
            boolean r4 = r5.isVisualizedAutoTrackActivity(r4)     // Catch:{ Exception -> 0x0139 }
            if (r4 != 0) goto L_0x0091
            goto L_0x012e
        L_0x0091:
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig r1 = r11.mVisualConfig     // Catch:{ Exception -> 0x0139 }
            if (r1 != 0) goto L_0x00a4
            java.lang.String r12 = "visual properties is empty and return"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r12 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r12 == 0) goto L_0x00a3
            java.lang.String r13 = "本地缓存无自定义属性配置"
            r12.onCheckVisualConfigFailure(r13)     // Catch:{ Exception -> 0x0139 }
        L_0x00a3:
            return
        L_0x00a4:
            boolean r1 = r11.checkAppIdAndProject()     // Catch:{ Exception -> 0x0139 }
            if (r1 != 0) goto L_0x00b4
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r12 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r12 == 0) goto L_0x00b3
            java.lang.String r13 = "本地缓存的 AppId 或 Project 与当前项目不一致"
            r12.onCheckVisualConfigFailure(r13)     // Catch:{ Exception -> 0x0139 }
        L_0x00b3:
            return
        L_0x00b4:
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig r1 = r11.mVisualConfig     // Catch:{ Exception -> 0x0139 }
            java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualPropertiesConfig> r5 = r1.events     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x0123
            int r1 = r5.size()     // Catch:{ Exception -> 0x0139 }
            if (r1 != 0) goto L_0x00c2
            goto L_0x0123
        L_0x00c2:
            if (r14 == 0) goto L_0x00d4
            java.lang.String r0 = r14.getViewPath()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r1 = r14.getViewPosition()     // Catch:{ Exception -> 0x0139 }
            java.lang.String r3 = r14.getViewContent()     // Catch:{ Exception -> 0x0139 }
            r8 = r0
            r9 = r1
            r10 = r3
            goto L_0x00d7
        L_0x00d4:
            r8 = r3
            r9 = r8
            r10 = r9
        L_0x00d7:
            r4 = r11
            r6 = r12
            java.util.List r12 = r4.getMatchEventConfigList(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0139 }
            int r0 = r12.size()     // Catch:{ Exception -> 0x0139 }
            if (r0 != 0) goto L_0x00f0
            java.lang.String r12 = "event config is empty and return"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r12)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r12 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r12 == 0) goto L_0x00ef
            r12.onCheckEventConfigFailure()     // Catch:{ Exception -> 0x0139 }
        L_0x00ef:
            return
        L_0x00f0:
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0139 }
        L_0x00f4:
            boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x0139 }
            if (r0 == 0) goto L_0x013d
            java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualPropertiesConfig r0 = (com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig) r0     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualEvent r5 = r0.event     // Catch:{ Exception -> 0x0139 }
            if (r5 == 0) goto L_0x0109
            boolean r1 = r5.isH5     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x0109
            goto L_0x00f4
        L_0x0109:
            java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualProperty> r4 = r0.properties     // Catch:{ Exception -> 0x0139 }
            if (r4 == 0) goto L_0x011d
            int r1 = r4.size()     // Catch:{ Exception -> 0x0139 }
            if (r1 != 0) goto L_0x0114
            goto L_0x011d
        L_0x0114:
            java.lang.String r8 = r0.eventName     // Catch:{ Exception -> 0x0139 }
            r3 = r11
            r6 = r13
            r7 = r14
            r3.mergeVisualProperty(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00f4
        L_0x011d:
            java.lang.String r0 = "properties is empty "
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00f4
        L_0x0123:
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r12 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r12 == 0) goto L_0x012d
            r12.onOtherError(r0)     // Catch:{ Exception -> 0x0139 }
        L_0x012d:
            return
        L_0x012e:
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x0139 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r12 = r11.mCollectLogListener     // Catch:{ Exception -> 0x0139 }
            if (r12 == 0) goto L_0x0138
            r12.onOtherError(r1)     // Catch:{ Exception -> 0x0139 }
        L_0x0138:
            return
        L_0x0139:
            r12 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r12)
        L_0x013d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.mergeVisualProperties(com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$VisualEventType, org.json.JSONObject, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode):void");
    }

    public List<VisualConfig.VisualPropertiesConfig> getMatchEventConfigList(List<VisualConfig.VisualPropertiesConfig> list, VisualEventType visualEventType, String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        try {
            for (VisualConfig.VisualPropertiesConfig next : list) {
                if (TextUtils.equals(next.eventType, visualEventType.getVisualEventType())) {
                    VisualConfig.VisualEvent visualEvent = next.event;
                    if (TextUtils.isEmpty(str) || TextUtils.equals(visualEvent.screenName, str)) {
                        if (visualEventType == VisualEventType.APP_CLICK || visualEventType == VisualEventType.WEB_CLICK) {
                            if (!TextUtils.equals(visualEvent.elementPath, str2)) {
                                SALog.i(TAG, String.format("event element_path is not match: current element_path is %s, config element_path is %s ", new Object[]{str2, visualEvent.elementPath}));
                            } else if (visualEvent.limitElementPosition && !TextUtils.equals(visualEvent.elementPosition, str3)) {
                                SALog.i(TAG, String.format("event element_position is not match: current element_position is %s, config element_position is %s ", new Object[]{str3, visualEvent.elementPosition}));
                            } else if (visualEvent.limitElementContent && !TextUtils.equals(visualEvent.elementContent, str4)) {
                                SALog.i(TAG, String.format("event element_content is not match: current element_content is %s, config element_content is %s ", new Object[]{str4, visualEvent.elementContent}));
                            }
                        }
                        arrayList.add(next);
                    }
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return arrayList;
    }

    public boolean checkAppIdAndProject() {
        String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
        if (TextUtils.isEmpty(serverUrl)) {
            SALog.i(TAG, "serverUrl is empty and return");
            return false;
        }
        String queryParameter = Uri.parse(serverUrl).getQueryParameter("project");
        String processName = AppInfoUtils.getProcessName(SensorsDataAPI.sharedInstance().getContext());
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(processName)) {
            SALog.i(TAG, "project or app_id is empty and return");
            return false;
        } else if (!TextUtils.equals(processName, this.mVisualConfig.appId)) {
            SALog.i(TAG, String.format("app_id is not equals: current app_id is %s, config app_id is %s ", new Object[]{processName, this.mVisualConfig.appId}));
            return false;
        } else if (TextUtils.equals(queryParameter, this.mVisualConfig.project)) {
            return true;
        } else {
            SALog.i(TAG, String.format("project is not equals: current project is %s, config project is %s ", new Object[]{queryParameter, this.mVisualConfig.project}));
            return false;
        }
    }

    private void mergeVisualProperty(List<VisualConfig.VisualProperty> list, VisualConfig.VisualEvent visualEvent, JSONObject jSONObject, ViewNode viewNode, String str) {
        try {
            HashSet hashSet = new HashSet();
            for (VisualConfig.VisualProperty next : list) {
                if (!next.isH5 || TextUtils.isEmpty(next.webViewElementPath)) {
                    mergeAppVisualProperty(next, visualEvent, jSONObject, viewNode);
                } else {
                    hashSet.add(next.webViewElementPath + next.screenName);
                }
            }
            if (hashSet.size() > 0) {
                this.mVisualPropertiesH5Helper.mergeJSVisualProperties(jSONObject, hashSet, str);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e2 A[Catch:{ Exception -> 0x01a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0196 A[Catch:{ Exception -> 0x01a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeAppVisualProperty(com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualProperty r8, com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualEvent r9, org.json.JSONObject r10, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r11) {
        /*
            r7 = this;
            java.lang.String r0 = "-"
            java.lang.String r1 = r8.name     // Catch:{ Exception -> 0x01a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r2 = "SA.VP.VisualPropertiesManager"
            if (r1 == 0) goto L_0x0012
            java.lang.String r8 = "config visual property name is empty"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ Exception -> 0x01a0 }
            return
        L_0x0012:
            java.lang.String r1 = r8.elementPath     // Catch:{ Exception -> 0x01a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01a0 }
            if (r1 == 0) goto L_0x0020
            java.lang.String r8 = "config visual property elementPath is empty"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ Exception -> 0x01a0 }
            return
        L_0x0020:
            r1 = 0
            if (r11 == 0) goto L_0x0077
            java.lang.String r3 = r11.getViewPosition()     // Catch:{ Exception -> 0x01a0 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r3 != 0) goto L_0x0077
            if (r9 == 0) goto L_0x0077
            java.lang.String r3 = r9.elementPosition     // Catch:{ Exception -> 0x01a0 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r3 != 0) goto L_0x0077
            boolean r3 = r9.limitElementPosition     // Catch:{ Exception -> 0x01a0 }
            if (r3 != 0) goto L_0x0077
            java.lang.String r3 = r8.elementPosition     // Catch:{ Exception -> 0x01a0 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r3 != 0) goto L_0x0077
            java.lang.String r3 = r8.elementPath     // Catch:{ Exception -> 0x01a0 }
            java.lang.String[] r3 = r3.split(r0)     // Catch:{ Exception -> 0x01a0 }
            r3 = r3[r1]     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r9 = r9.elementPath     // Catch:{ Exception -> 0x01a0 }
            java.lang.String[] r9 = r9.split(r0)     // Catch:{ Exception -> 0x01a0 }
            r9 = r9[r1]     // Catch:{ Exception -> 0x01a0 }
            boolean r9 = android.text.TextUtils.equals(r3, r9)     // Catch:{ Exception -> 0x01a0 }
            if (r9 == 0) goto L_0x0077
            java.lang.String r9 = r11.getViewPosition()     // Catch:{ Exception -> 0x01a0 }
            r8.elementPosition = r9     // Catch:{ Exception -> 0x01a0 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a0 }
            r9.<init>()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "visualProperty elementPosition replace: "
            r9.append(r0)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = r11.getViewPosition()     // Catch:{ Exception -> 0x01a0 }
            r9.append(r0)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01a0 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r9)     // Catch:{ Exception -> 0x01a0 }
        L_0x0077:
            r9 = 1
            r0 = 0
            com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable r3 = com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable.getInstance()     // Catch:{ Exception -> 0x00db }
            if (r11 == 0) goto L_0x0084
            java.lang.ref.WeakReference r11 = r11.getView()     // Catch:{ Exception -> 0x00db }
            goto L_0x0085
        L_0x0084:
            r11 = r0
        L_0x0085:
            java.lang.String r4 = r8.elementPath     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = r8.elementPosition     // Catch:{ Exception -> 0x00db }
            java.lang.String r6 = r8.screenName     // Catch:{ Exception -> 0x00db }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r11 = r3.getViewNode(r11, r4, r5, r6)     // Catch:{ Exception -> 0x00db }
            if (r11 == 0) goto L_0x00d9
            java.lang.String r3 = r8.elementPath     // Catch:{ Exception -> 0x00db }
            java.lang.String r4 = r11.getViewPath()     // Catch:{ Exception -> 0x00db }
            boolean r3 = android.text.TextUtils.equals(r3, r4)     // Catch:{ Exception -> 0x00db }
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = r8.elementPosition     // Catch:{ Exception -> 0x00db }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00db }
            java.lang.String r4 = r8.elementPosition     // Catch:{ Exception -> 0x00db }
            java.lang.String r5 = r11.getViewPosition()     // Catch:{ Exception -> 0x00db }
            boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch:{ Exception -> 0x00db }
            r3 = r3 | r4
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = r11.getViewContent()     // Catch:{ Exception -> 0x00db }
            java.lang.ref.WeakReference r4 = r11.getView()     // Catch:{ Exception -> 0x00d7 }
            if (r4 == 0) goto L_0x00bf
            java.lang.ref.WeakReference r11 = r11.getView()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00c0
        L_0x00bf:
            r11 = r0
        L_0x00c0:
            if (r11 == 0) goto L_0x00e0
            java.lang.Object r4 = r11.get()     // Catch:{ Exception -> 0x00d7 }
            if (r4 == 0) goto L_0x00e0
            java.lang.Object r11 = r11.get()     // Catch:{ Exception -> 0x00d7 }
            android.view.View r11 = (android.view.View) r11     // Catch:{ Exception -> 0x00d7 }
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r11 = com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewContentAndType(r11, r9)     // Catch:{ Exception -> 0x00d7 }
            java.lang.String r3 = r11.getViewContent()     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00e0
        L_0x00d7:
            r11 = move-exception
            goto L_0x00dd
        L_0x00d9:
            r3 = r0
            goto L_0x00e0
        L_0x00db:
            r11 = move-exception
            r3 = r0
        L_0x00dd:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)     // Catch:{ Exception -> 0x01a0 }
        L_0x00e0:
            if (r3 == 0) goto L_0x0192
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r11 == 0) goto L_0x00ea
            goto L_0x0192
        L_0x00ea:
            java.lang.String r11 = "find property target view success, property element_path: %s,element_position: %s,element_content: %s"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r5 = r8.elementPath     // Catch:{ Exception -> 0x01a0 }
            r4[r1] = r5     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r5 = r8.elementPosition     // Catch:{ Exception -> 0x01a0 }
            r4[r9] = r5     // Catch:{ Exception -> 0x01a0 }
            r5 = 2
            r4[r5] = r3     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r11 = java.lang.String.format(r11, r4)     // Catch:{ Exception -> 0x01a0 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r11)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r11 = r8.regular     // Catch:{ Exception -> 0x01a0 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x01a0 }
            if (r11 != 0) goto L_0x0152
            java.lang.String r11 = r8.regular     // Catch:{ Exception -> 0x0140 }
            r0 = 40
            java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11, r0)     // Catch:{ Exception -> 0x0140 }
            java.util.regex.Matcher r11 = r11.matcher(r3)     // Catch:{ Exception -> 0x0140 }
            boolean r0 = r11.find()     // Catch:{ Exception -> 0x0140 }
            if (r0 == 0) goto L_0x012d
            java.lang.String r0 = r11.group()     // Catch:{ Exception -> 0x0140 }
            java.lang.String r11 = "propertyValue is: %s"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0140 }
            r9[r1] = r0     // Catch:{ Exception -> 0x0140 }
            java.lang.String r9 = java.lang.String.format(r11, r9)     // Catch:{ Exception -> 0x0140 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r9)     // Catch:{ Exception -> 0x0140 }
            goto L_0x0152
        L_0x012d:
            java.lang.String r9 = "matcher not find continue"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r9)     // Catch:{ Exception -> 0x0140 }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x0140 }
            if (r9 == 0) goto L_0x013f
            java.lang.String r10 = r8.name     // Catch:{ Exception -> 0x0140 }
            java.lang.String r11 = r8.type     // Catch:{ Exception -> 0x0140 }
            java.lang.String r0 = r8.regular     // Catch:{ Exception -> 0x0140 }
            r9.onParsePropertyContentFailure(r10, r11, r3, r0)     // Catch:{ Exception -> 0x0140 }
        L_0x013f:
            return
        L_0x0140:
            r9 = move-exception
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r10 = r7.mCollectLogListener     // Catch:{ Exception -> 0x01a0 }
            if (r10 == 0) goto L_0x014e
            java.lang.String r11 = r8.name     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = r8.type     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r8 = r8.regular     // Catch:{ Exception -> 0x01a0 }
            r10.onParsePropertyContentFailure(r11, r0, r3, r8)     // Catch:{ Exception -> 0x01a0 }
        L_0x014e:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r9)     // Catch:{ Exception -> 0x01a0 }
            return
        L_0x0152:
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01a0 }
            if (r9 != 0) goto L_0x01a4
            java.lang.String r9 = "NUMBER"
            java.lang.String r11 = r8.type     // Catch:{ Exception -> 0x01a0 }
            boolean r9 = android.text.TextUtils.equals(r9, r11)     // Catch:{ Exception -> 0x01a0 }
            if (r9 == 0) goto L_0x017f
            if (r0 == 0) goto L_0x01a4
            java.lang.String r8 = r8.name     // Catch:{ Exception -> 0x0172 }
            java.text.NumberFormat r9 = java.text.NumberFormat.getInstance()     // Catch:{ Exception -> 0x0172 }
            java.lang.Number r9 = r9.parse(r0)     // Catch:{ Exception -> 0x0172 }
            r10.put(r8, r9)     // Catch:{ Exception -> 0x0172 }
            goto L_0x01a4
        L_0x0172:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x01a0 }
            if (r9 == 0) goto L_0x01a4
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x01a0 }
            r9.onOtherError(r8)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a4
        L_0x017f:
            java.lang.String r8 = r8.name     // Catch:{ JSONException -> 0x0185 }
            r10.put(r8, r0)     // Catch:{ JSONException -> 0x0185 }
            goto L_0x01a4
        L_0x0185:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x01a0 }
            if (r9 == 0) goto L_0x01a4
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x01a0 }
            r9.onOtherError(r8)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a4
        L_0x0192:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$CollectLogListener r9 = r7.mCollectLogListener     // Catch:{ Exception -> 0x01a0 }
            if (r9 == 0) goto L_0x019f
            java.lang.String r10 = r8.name     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r11 = r8.elementPath     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r8 = r8.elementPosition     // Catch:{ Exception -> 0x01a0 }
            r9.onFindPropertyElementFailure(r10, r11, r8)     // Catch:{ Exception -> 0x01a0 }
        L_0x019f:
            return
        L_0x01a0:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.mergeAppVisualProperty(com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualProperty, com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualEvent, org.json.JSONObject, com.sensorsdata.analytics.android.sdk.visual.model.ViewNode):void");
    }
}
