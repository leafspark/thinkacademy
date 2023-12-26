package com.sensorsdata.analytics.android.sdk.visual;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.util.ThreadUtils;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public class VisualDebugHelper {
    private static final String TAG = "SA.VP.VisualDebugHelper";
    private TrackEventAdapter mEventListener = null;
    private JSONArray mJsonArray;
    private final Object object = new Object();

    /* access modifiers changed from: package-private */
    public void startMonitor() {
        try {
            if (this.mEventListener == null) {
                final ExecutorService singlePool = ThreadUtils.getSinglePool();
                this.mEventListener = new TrackEventAdapter() {
                    public void trackEvent(final JSONObject jSONObject) {
                        singlePool.execute(new Runnable() {
                            public void run() {
                                VisualDebugHelper.this.handlerEvent(jSONObject);
                            }
                        });
                    }
                };
            }
            SensorsDataAPI.sharedInstance().addEventListener(this.mEventListener);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void stopMonitor() {
        try {
            if (this.mEventListener != null) {
                SensorsDataAPI.sharedInstance().removeEventListener(this.mEventListener);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void handlerEvent(org.json.JSONObject r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            if (r11 != 0) goto L_0x0005
            monitor-exit(r10)
            return
        L_0x0005:
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r0 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()     // Catch:{ Exception -> 0x016d }
            boolean r0 = r0.isServiceRunning()     // Catch:{ Exception -> 0x016d }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r10)
            return
        L_0x0011:
            java.lang.String r0 = "event"
            java.lang.String r0 = r11.optString(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.String r1 = "$AppClick"
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch:{ Exception -> 0x016d }
            if (r1 != 0) goto L_0x0044
            java.lang.String r1 = "$WebClick"
            boolean r1 = android.text.TextUtils.equals(r1, r0)     // Catch:{ Exception -> 0x016d }
            if (r1 != 0) goto L_0x0044
            java.lang.String r11 = "SA.VP.VisualDebugHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016d }
            r1.<init>()     // Catch:{ Exception -> 0x016d }
            java.lang.String r2 = "eventName is "
            r1.append(r2)     // Catch:{ Exception -> 0x016d }
            r1.append(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.String r0 = " filter"
            r1.append(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x016d }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x016d }
            monitor-exit(r10)
            return
        L_0x0044:
            java.lang.String r1 = "properties"
            org.json.JSONObject r1 = r11.optJSONObject(r1)     // Catch:{ Exception -> 0x016d }
            if (r1 != 0) goto L_0x004e
            monitor-exit(r10)
            return
        L_0x004e:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r2 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x016d }
            boolean r2 = r2.checkAppIdAndProject()     // Catch:{ Exception -> 0x016d }
            if (r2 != 0) goto L_0x005a
            monitor-exit(r10)
            return
        L_0x005a:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r2 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x016d }
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig r2 = r2.getVisualConfig()     // Catch:{ Exception -> 0x016d }
            if (r2 != 0) goto L_0x0066
            monitor-exit(r10)
            return
        L_0x0066:
            java.util.List<com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualPropertiesConfig> r4 = r2.events     // Catch:{ Exception -> 0x016d }
            if (r4 == 0) goto L_0x0162
            int r2 = r4.size()     // Catch:{ Exception -> 0x016d }
            if (r2 != 0) goto L_0x0072
            goto L_0x0162
        L_0x0072:
            java.lang.String r2 = "$AppClick"
            boolean r2 = android.text.TextUtils.equals(r2, r0)     // Catch:{ Exception -> 0x016d }
            if (r2 == 0) goto L_0x00f1
            java.lang.String r2 = "$screen_name"
            java.lang.String r6 = r1.optString(r2)     // Catch:{ Exception -> 0x016d }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x016d }
            if (r2 == 0) goto L_0x008f
            java.lang.String r11 = "SA.VP.VisualDebugHelper"
            java.lang.String r0 = "screenName is empty "
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x016d }
            monitor-exit(r10)
            return
        L_0x008f:
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r3 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x016d }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager$VisualEventType r5 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.VisualEventType.getVisualEventType(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.String r0 = "$element_path"
            java.lang.String r7 = r1.optString(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.String r0 = "$element_position"
            java.lang.String r8 = r1.optString(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.String r0 = "$element_content"
            java.lang.String r9 = r1.optString(r0)     // Catch:{ Exception -> 0x016d }
            java.util.List r0 = r3.getMatchEventConfigList(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x016d }
            int r1 = r0.size()     // Catch:{ Exception -> 0x016d }
            if (r1 <= 0) goto L_0x0171
            java.lang.Object r1 = r10.object     // Catch:{ Exception -> 0x016d }
            monitor-enter(r1)     // Catch:{ Exception -> 0x016d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ee }
        L_0x00ba:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00ee }
            if (r2 == 0) goto L_0x00eb
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00ee }
            com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig$VisualPropertiesConfig r2 = (com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig.VisualPropertiesConfig) r2     // Catch:{ all -> 0x00ee }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6 }
            r3.<init>()     // Catch:{ Exception -> 0x00e6 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r11, r3)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r4 = "event_name"
            java.lang.String r2 = r2.eventName     // Catch:{ Exception -> 0x00e6 }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x00e6 }
            org.json.JSONArray r2 = r10.mJsonArray     // Catch:{ Exception -> 0x00e6 }
            if (r2 != 0) goto L_0x00e0
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x00e6 }
            r2.<init>()     // Catch:{ Exception -> 0x00e6 }
            r10.mJsonArray = r2     // Catch:{ Exception -> 0x00e6 }
        L_0x00e0:
            org.json.JSONArray r2 = r10.mJsonArray     // Catch:{ Exception -> 0x00e6 }
            r2.put(r3)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ba
        L_0x00e6:
            r2 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)     // Catch:{ all -> 0x00ee }
            goto L_0x00ba
        L_0x00eb:
            monitor-exit(r1)     // Catch:{ all -> 0x00ee }
            goto L_0x0171
        L_0x00ee:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ee }
            throw r11     // Catch:{ Exception -> 0x016d }
        L_0x00f1:
            java.lang.String r2 = "$WebClick"
            boolean r0 = android.text.TextUtils.equals(r2, r0)     // Catch:{ Exception -> 0x016d }
            if (r0 == 0) goto L_0x0171
            java.lang.String r0 = "sensorsdata_web_visual_eventName"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Exception -> 0x015d }
            if (r0 != 0) goto L_0x011d
            int r0 = r11.hashCode()     // Catch:{ Exception -> 0x015d }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r1 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x015d }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper r1 = r1.getVisualPropertiesH5Helper()     // Catch:{ Exception -> 0x015d }
            org.json.JSONArray r1 = r1.getEventName(r0)     // Catch:{ Exception -> 0x015d }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager r2 = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance()     // Catch:{ Exception -> 0x015d }
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesH5Helper r2 = r2.getVisualPropertiesH5Helper()     // Catch:{ Exception -> 0x015d }
            r2.clearCache(r0)     // Catch:{ Exception -> 0x015d }
            r0 = r1
        L_0x011d:
            if (r0 == 0) goto L_0x0171
            int r1 = r0.length()     // Catch:{ Exception -> 0x015d }
            if (r1 <= 0) goto L_0x0171
            java.lang.Object r1 = r10.object     // Catch:{ Exception -> 0x015d }
            monitor-enter(r1)     // Catch:{ Exception -> 0x015d }
            r2 = 0
        L_0x0129:
            int r3 = r0.length()     // Catch:{ all -> 0x015a }
            if (r2 >= r3) goto L_0x0158
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0151 }
            r3.<init>()     // Catch:{ Exception -> 0x0151 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r11, r3)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = "event_name"
            java.lang.String r5 = r0.optString(r2)     // Catch:{ Exception -> 0x0151 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0151 }
            org.json.JSONArray r4 = r10.mJsonArray     // Catch:{ Exception -> 0x0151 }
            if (r4 != 0) goto L_0x014b
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0151 }
            r4.<init>()     // Catch:{ Exception -> 0x0151 }
            r10.mJsonArray = r4     // Catch:{ Exception -> 0x0151 }
        L_0x014b:
            org.json.JSONArray r4 = r10.mJsonArray     // Catch:{ Exception -> 0x0151 }
            r4.put(r3)     // Catch:{ Exception -> 0x0151 }
            goto L_0x0155
        L_0x0151:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ all -> 0x015a }
        L_0x0155:
            int r2 = r2 + 1
            goto L_0x0129
        L_0x0158:
            monitor-exit(r1)     // Catch:{ all -> 0x015a }
            goto L_0x0171
        L_0x015a:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x015a }
            throw r11     // Catch:{ Exception -> 0x015d }
        L_0x015d:
            r11 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)     // Catch:{ Exception -> 0x016d }
            goto L_0x0171
        L_0x0162:
            java.lang.String r11 = "SA.VP.VisualDebugHelper"
            java.lang.String r0 = "propertiesConfigs is empty "
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x016d }
            monitor-exit(r10)
            return
        L_0x016b:
            r11 = move-exception
            goto L_0x0173
        L_0x016d:
            r11 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r11)     // Catch:{ all -> 0x016b }
        L_0x0171:
            monitor-exit(r10)
            return
        L_0x0173:
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper.handlerEvent(org.json.JSONObject):void");
    }

    /* access modifiers changed from: package-private */
    public String getDebugInfo() {
        synchronized (this.object) {
            JSONArray jSONArray = this.mJsonArray;
            if (jSONArray == null) {
                return null;
            }
            String jSONArray2 = jSONArray.toString();
            this.mJsonArray = null;
            return jSONArray2;
        }
    }

    private static abstract class TrackEventAdapter implements SAEventListener {
        public void identify() {
        }

        public void login() {
        }

        public void logout() {
        }

        public void resetAnonymousId() {
        }

        private TrackEventAdapter() {
        }
    }
}
