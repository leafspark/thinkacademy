package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.ThreadUtils;
import com.sensorsdata.analytics.android.sdk.visual.WebViewVisualInterface;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataAutoTrackHelper {
    private static final String TAG = "SensorsDataAutoTrackHelper";
    private static HashMap<Integer, Long> eventTimestamp = new HashMap<>();

    public static void trackRN(Object obj, int i, int i2, boolean z) {
    }

    /* access modifiers changed from: private */
    public static boolean isDeBounceTrack(Object obj) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l = eventTimestamp.get(Integer.valueOf(obj.hashCode()));
        if (l != null && elapsedRealtime - l.longValue() < 500) {
            return true;
        }
        eventTimestamp.put(Integer.valueOf(obj.hashCode()), Long.valueOf(elapsedRealtime));
        return false;
    }

    public static void trackExpandableListViewOnGroupClick(ExpandableListView expandableListView, View view, int i) {
        Context context;
        if (expandableListView != null && view != null) {
            try {
                if (SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_CLICK) && (context = expandableListView.getContext()) != null) {
                    String str = null;
                    Activity activity = context instanceof Activity ? (Activity) context : null;
                    if (activity == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activity.getClass())) {
                        Object fragmentFromView = AopUtil.getFragmentFromView(expandableListView, activity);
                        if ((fragmentFromView == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) && !AopUtil.isViewIgnored(ExpandableListView.class) && !AopUtil.isViewIgnored((View) expandableListView)) {
                            JSONObject jSONObject = new JSONObject();
                            ViewNode addViewPathProperties = AopUtil.addViewPathProperties(activity, view, jSONObject);
                            if (activity != null) {
                                SensorsDataUtils.mergeJSONObject(AopUtil.buildTitleAndScreenName(activity), jSONObject);
                            }
                            String viewId = AopUtil.getViewId(expandableListView);
                            if (!TextUtils.isEmpty(viewId)) {
                                jSONObject.put(AopConstants.ELEMENT_ID, viewId);
                            }
                            jSONObject.put(AopConstants.ELEMENT_TYPE, "ExpandableListView");
                            if (view instanceof ViewGroup) {
                                try {
                                    str = AopUtil.traverseView(new StringBuilder(), (ViewGroup) view);
                                    if (!TextUtils.isEmpty(str)) {
                                        str = str.substring(0, str.length() - 1);
                                    }
                                } catch (Exception e) {
                                    SALog.printStackTrace(e);
                                }
                            } else {
                                str = AopUtil.getViewText(view);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put(AopConstants.ELEMENT_CONTENT, str);
                            }
                            if (fragmentFromView != null) {
                                AopUtil.getScreenNameAndTitleFromFragment(jSONObject, fragmentFromView, activity);
                            }
                            JSONObject jSONObject2 = (JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties);
                            if (jSONObject2 != null) {
                                AopUtil.mergeJSONObject(jSONObject2, jSONObject);
                            }
                            ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
                            if (expandableListAdapter != null && (expandableListAdapter instanceof SensorsExpandableListViewItemTrackProperties)) {
                                try {
                                    JSONObject sensorsGroupItemTrackProperties = ((SensorsExpandableListViewItemTrackProperties) expandableListAdapter).getSensorsGroupItemTrackProperties(i);
                                    if (sensorsGroupItemTrackProperties != null) {
                                        AopUtil.mergeJSONObject(sensorsGroupItemTrackProperties, jSONObject);
                                    }
                                } catch (JSONException e2) {
                                    SALog.printStackTrace(e2);
                                }
                            }
                            SensorsDataAPI.sharedInstance().trackAutoEvent(AopConstants.APP_CLICK_EVENT_NAME, jSONObject, addViewPathProperties);
                        }
                    }
                }
            } catch (Exception e3) {
                SALog.printStackTrace(e3);
            }
        }
    }

    public static void trackExpandableListViewOnChildClick(ExpandableListView expandableListView, View view, int i, int i2) {
        Context context;
        JSONObject sensorsChildItemTrackProperties;
        if (expandableListView != null && view != null) {
            try {
                if (SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_CLICK) && (context = expandableListView.getContext()) != null) {
                    Activity activityFromContext = AopUtil.getActivityFromContext(context, expandableListView);
                    if (activityFromContext == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activityFromContext.getClass())) {
                        Object fragmentFromView = AopUtil.getFragmentFromView(expandableListView, activityFromContext);
                        if ((fragmentFromView == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) && !AopUtil.isViewIgnored(ExpandableListView.class) && !AopUtil.isViewIgnored((View) expandableListView) && !AopUtil.isViewIgnored(view)) {
                            JSONObject jSONObject = (JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties);
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
                            if (!(expandableListAdapter == null || !(expandableListAdapter instanceof SensorsExpandableListViewItemTrackProperties) || (sensorsChildItemTrackProperties = ((SensorsExpandableListViewItemTrackProperties) expandableListAdapter).getSensorsChildItemTrackProperties(i, i2)) == null)) {
                                AopUtil.mergeJSONObject(sensorsChildItemTrackProperties, jSONObject);
                            }
                            ViewNode addViewPathProperties = AopUtil.addViewPathProperties(activityFromContext, view, jSONObject);
                            if (activityFromContext != null) {
                                SensorsDataUtils.mergeJSONObject(AopUtil.buildTitleAndScreenName(activityFromContext), jSONObject);
                            }
                            String viewId = AopUtil.getViewId(expandableListView);
                            if (!TextUtils.isEmpty(viewId)) {
                                jSONObject.put(AopConstants.ELEMENT_ID, viewId);
                            }
                            jSONObject.put(AopConstants.ELEMENT_TYPE, "ExpandableListView");
                            String str = null;
                            if (view instanceof ViewGroup) {
                                try {
                                    str = AopUtil.traverseView(new StringBuilder(), (ViewGroup) view);
                                    if (!TextUtils.isEmpty(str)) {
                                        str = str.substring(0, str.length() - 1);
                                    }
                                } catch (Exception e) {
                                    SALog.printStackTrace(e);
                                }
                            } else {
                                str = AopUtil.getViewText(view);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put(AopConstants.ELEMENT_CONTENT, str);
                            }
                            if (fragmentFromView != null) {
                                AopUtil.getScreenNameAndTitleFromFragment(jSONObject, fragmentFromView, activityFromContext);
                            }
                            JSONObject jSONObject2 = (JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties);
                            if (jSONObject2 != null) {
                                AopUtil.mergeJSONObject(jSONObject2, jSONObject);
                            }
                            SensorsDataAPI.sharedInstance().trackAutoEvent(AopConstants.APP_CLICK_EVENT_NAME, jSONObject, addViewPathProperties);
                        }
                    }
                }
            } catch (Exception e2) {
                SALog.printStackTrace(e2);
            }
        }
    }

    public static void trackTabHost(final String str) {
        try {
            ThreadUtils.getSinglePool().execute(new Runnable() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.String} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.sensorsdata.analytics.android.sdk.visual.model.ViewNode} */
                /* JADX WARNING: type inference failed for: r2v12, types: [com.sensorsdata.analytics.android.sdk.visual.model.ViewNode] */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x009d }
                        boolean r0 = r0.isAutoTrackEnabled()     // Catch:{ Exception -> 0x009d }
                        if (r0 != 0) goto L_0x000b
                        return
                    L_0x000b:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x009d }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x009d }
                        boolean r0 = r0.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r1)     // Catch:{ Exception -> 0x009d }
                        if (r0 == 0) goto L_0x0018
                        return
                    L_0x0018:
                        java.lang.Class<android.widget.TabHost> r0 = android.widget.TabHost.class
                        boolean r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.isViewIgnored((java.lang.Class) r0)     // Catch:{ Exception -> 0x009d }
                        if (r0 == 0) goto L_0x0021
                        return
                    L_0x0021:
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x009d }
                        r0.<init>()     // Catch:{ Exception -> 0x009d }
                        java.lang.String r1 = r2     // Catch:{ Exception -> 0x009d }
                        android.view.View r1 = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getClickView((java.lang.String) r1)     // Catch:{ Exception -> 0x009d }
                        r2 = 0
                        if (r1 == 0) goto L_0x007e
                        android.content.Context r3 = r1.getContext()     // Catch:{ Exception -> 0x009d }
                        if (r3 != 0) goto L_0x0036
                        return
                    L_0x0036:
                        boolean r4 = r3 instanceof android.app.Activity     // Catch:{ Exception -> 0x009d }
                        if (r4 == 0) goto L_0x003d
                        android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ Exception -> 0x009d }
                        goto L_0x003e
                    L_0x003d:
                        r3 = r2
                    L_0x003e:
                        if (r3 == 0) goto L_0x0072
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x009d }
                        java.lang.Class r4 = r3.getClass()     // Catch:{ Exception -> 0x009d }
                        boolean r2 = r2.isActivityAutoTrackAppClickIgnored(r4)     // Catch:{ Exception -> 0x009d }
                        if (r2 == 0) goto L_0x004f
                        return
                    L_0x004f:
                        org.json.JSONObject r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.buildTitleAndScreenName(r3)     // Catch:{ Exception -> 0x009d }
                        com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r2, r0)     // Catch:{ Exception -> 0x009d }
                        java.lang.Object r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getFragmentFromView(r1, r3)     // Catch:{ Exception -> 0x009d }
                        if (r2 == 0) goto L_0x006e
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x009d }
                        java.lang.Class r5 = r2.getClass()     // Catch:{ Exception -> 0x009d }
                        boolean r4 = r4.isActivityAutoTrackAppClickIgnored(r5)     // Catch:{ Exception -> 0x009d }
                        if (r4 == 0) goto L_0x006b
                        return
                    L_0x006b:
                        com.sensorsdata.analytics.android.sdk.util.AopUtil.getScreenNameAndTitleFromFragment(r0, r2, r3)     // Catch:{ Exception -> 0x009d }
                    L_0x006e:
                        com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r3, r1, r0)     // Catch:{ Exception -> 0x009d }
                    L_0x0072:
                        com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewContentAndType(r1)     // Catch:{ Exception -> 0x009d }
                        java.lang.String r1 = r1.getViewContent()     // Catch:{ Exception -> 0x009d }
                        r6 = r2
                        r2 = r1
                        r1 = r6
                        goto L_0x007f
                    L_0x007e:
                        r1 = r2
                    L_0x007f:
                        boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x009d }
                        if (r3 == 0) goto L_0x0087
                        java.lang.String r2 = r2     // Catch:{ Exception -> 0x009d }
                    L_0x0087:
                        java.lang.String r3 = "$element_content"
                        r0.put(r3, r2)     // Catch:{ Exception -> 0x009d }
                        java.lang.String r2 = "$element_type"
                        java.lang.String r3 = "TabHost"
                        r0.put(r2, r3)     // Catch:{ Exception -> 0x009d }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x009d }
                        java.lang.String r3 = "$AppClick"
                        r2.trackAutoEvent(r3, r0, r1)     // Catch:{ Exception -> 0x009d }
                        goto L_0x00a1
                    L_0x009d:
                        r0 = move-exception
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
                    L_0x00a1:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.AnonymousClass1.run():void");
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0195 A[Catch:{ Exception -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01d3 A[Catch:{ Exception -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ac A[Catch:{ Exception -> 0x01f5 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ad A[Catch:{ Exception -> 0x01f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackTabLayoutSelected(java.lang.Object r10, java.lang.Object r11) {
        /*
            java.lang.String r0 = "com.google.android.material.tabs.TabLayout$Tab"
            java.lang.String r1 = "com.google.android.material.tabs.TabLayout"
            if (r11 != 0) goto L_0x0007
            return
        L_0x0007:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x01f5 }
            boolean r2 = r2.isAutoTrackEnabled()     // Catch:{ Exception -> 0x01f5 }
            if (r2 != 0) goto L_0x0012
            return
        L_0x0012:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x01f5 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x01f5 }
            boolean r2 = r2.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r3)     // Catch:{ Exception -> 0x01f5 }
            if (r2 == 0) goto L_0x001f
            return
        L_0x001f:
            r2 = 0
            java.lang.Class r3 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0026
        L_0x0025:
            r3 = r2
        L_0x0026:
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            if (r3 != 0) goto L_0x0031
            if (r1 != 0) goto L_0x0031
            return
        L_0x0031:
            if (r3 == 0) goto L_0x003a
            boolean r3 = com.sensorsdata.analytics.android.sdk.util.AopUtil.isViewIgnored((java.lang.Class) r3)     // Catch:{ Exception -> 0x01f5 }
            if (r3 == 0) goto L_0x003a
            return
        L_0x003a:
            if (r1 == 0) goto L_0x0043
            boolean r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.isViewIgnored((java.lang.Class) r1)     // Catch:{ Exception -> 0x01f5 }
            if (r1 == 0) goto L_0x0043
            return
        L_0x0043:
            boolean r1 = isDeBounceTrack(r11)     // Catch:{ Exception -> 0x01f5 }
            if (r1 == 0) goto L_0x004a
            return
        L_0x004a:
            boolean r1 = r10 instanceof android.content.Context     // Catch:{ Exception -> 0x01f5 }
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0059
            r1 = r10
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x01f5 }
            android.app.Activity r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getActivityFromContext(r1, r2)     // Catch:{ Exception -> 0x01f5 }
            r5 = r3
            goto L_0x009c
        L_0x0059:
            java.lang.Class r1 = r10.getClass()     // Catch:{ Exception -> 0x0095 }
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch:{ Exception -> 0x0095 }
            int r5 = r1.length     // Catch:{ Exception -> 0x0095 }
            r7 = r2
            r6 = r3
        L_0x0064:
            if (r6 >= r5) goto L_0x009a
            r8 = r1[r6]     // Catch:{ Exception -> 0x0093 }
            r8.setAccessible(r4)     // Catch:{ Exception -> 0x0093 }
            java.lang.Object r8 = r8.get(r10)     // Catch:{ Exception -> 0x0093 }
            boolean r9 = r8 instanceof android.app.Activity     // Catch:{ Exception -> 0x0093 }
            if (r9 == 0) goto L_0x0078
            android.app.Activity r8 = (android.app.Activity) r8     // Catch:{ Exception -> 0x0093 }
            r5 = r3
            r1 = r8
            goto L_0x009c
        L_0x0078:
            boolean r9 = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragment(r8)     // Catch:{ Exception -> 0x0093 }
            if (r9 == 0) goto L_0x0082
            r5 = r4
            r1 = r7
            r10 = r8
            goto L_0x009c
        L_0x0082:
            boolean r9 = r8 instanceof android.view.View     // Catch:{ Exception -> 0x0093 }
            if (r9 == 0) goto L_0x0090
            android.view.View r8 = (android.view.View) r8     // Catch:{ Exception -> 0x0093 }
            android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x0093 }
            android.app.Activity r7 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getActivityFromContext(r8, r2)     // Catch:{ Exception -> 0x0093 }
        L_0x0090:
            int r6 = r6 + 1
            goto L_0x0064
        L_0x0093:
            r1 = move-exception
            goto L_0x0097
        L_0x0095:
            r1 = move-exception
            r7 = r2
        L_0x0097:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)     // Catch:{ Exception -> 0x01f5 }
        L_0x009a:
            r5 = r3
            r1 = r7
        L_0x009c:
            if (r1 == 0) goto L_0x00ad
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x01f5 }
            java.lang.Class r7 = r1.getClass()     // Catch:{ Exception -> 0x01f5 }
            boolean r6 = r6.isActivityAutoTrackAppClickIgnored(r7)     // Catch:{ Exception -> 0x01f5 }
            if (r6 == 0) goto L_0x00ad
            return
        L_0x00ad:
            if (r5 == 0) goto L_0x00be
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x01f5 }
            java.lang.Class r7 = r10.getClass()     // Catch:{ Exception -> 0x01f5 }
            boolean r6 = r6.isActivityAutoTrackAppClickIgnored(r7)     // Catch:{ Exception -> 0x01f5 }
            if (r6 == 0) goto L_0x00be
            return
        L_0x00be:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x01f5 }
            r6.<init>()     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r7 = "$element_type"
            java.lang.String r8 = "TabLayout"
            r6.put(r7, r8)     // Catch:{ Exception -> 0x01f5 }
            if (r5 == 0) goto L_0x00d4
            android.app.Activity r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getActivityFromFragment(r10)     // Catch:{ Exception -> 0x01f5 }
            com.sensorsdata.analytics.android.sdk.util.AopUtil.getScreenNameAndTitleFromFragment(r6, r10, r1)     // Catch:{ Exception -> 0x01f5 }
            goto L_0x00dd
        L_0x00d4:
            if (r1 == 0) goto L_0x00dd
            org.json.JSONObject r10 = com.sensorsdata.analytics.android.sdk.util.AopUtil.buildTitleAndScreenName(r1)     // Catch:{ Exception -> 0x01f5 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r10, r6)     // Catch:{ Exception -> 0x01f5 }
        L_0x00dd:
            java.lang.Class r10 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00e3
        L_0x00e2:
            r10 = r2
        L_0x00e3:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
            r0 = r2
        L_0x00e9:
            if (r10 == 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r10 = r0
        L_0x00ed:
            if (r10 == 0) goto L_0x01eb
            java.lang.String r0 = "getText"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x00f8 }
            java.lang.reflect.Method r0 = r10.getMethod(r0, r5)     // Catch:{ NoSuchMethodException -> 0x00f8 }
            goto L_0x00f9
        L_0x00f8:
            r0 = r2
        L_0x00f9:
            java.lang.String r5 = "$element_content"
            if (r0 == 0) goto L_0x0108
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r0 = r0.invoke(r11, r7)     // Catch:{ Exception -> 0x01f5 }
            if (r0 == 0) goto L_0x0108
            r6.put(r5, r0)     // Catch:{ Exception -> 0x01f5 }
        L_0x0108:
            if (r1 == 0) goto L_0x01eb
            java.lang.String r0 = "mCustomView"
            java.lang.reflect.Field r0 = r10.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0114 }
            goto L_0x011c
        L_0x0111:
            r10 = move-exception
            goto L_0x01e8
        L_0x0114:
            java.lang.String r0 = "customView"
            java.lang.reflect.Field r0 = r10.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x011b }
            goto L_0x011c
        L_0x011b:
            r0 = r2
        L_0x011c:
            if (r0 == 0) goto L_0x015c
            r0.setAccessible(r4)     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ Exception -> 0x0111 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x0111 }
            if (r0 == 0) goto L_0x015d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0157 }
            r7.<init>()     // Catch:{ Exception -> 0x0157 }
            boolean r8 = r0 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x0157 }
            if (r8 == 0) goto L_0x0149
            r8 = r0
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ Exception -> 0x0157 }
            java.lang.String r7 = com.sensorsdata.analytics.android.sdk.util.AopUtil.traverseView(r7, r8)     // Catch:{ Exception -> 0x0157 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0157 }
            if (r8 != 0) goto L_0x014d
            int r8 = r7.length()     // Catch:{ Exception -> 0x0157 }
            int r8 = r8 - r4
            java.lang.String r7 = r7.substring(r3, r8)     // Catch:{ Exception -> 0x0157 }
            goto L_0x014d
        L_0x0149:
            java.lang.String r7 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewText(r0)     // Catch:{ Exception -> 0x0157 }
        L_0x014d:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0157 }
            if (r3 != 0) goto L_0x015d
            r6.put(r5, r7)     // Catch:{ Exception -> 0x0157 }
            goto L_0x015d
        L_0x0157:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ Exception -> 0x0111 }
            goto L_0x015d
        L_0x015c:
            r0 = r2
        L_0x015d:
            java.lang.String r3 = "view"
            java.lang.reflect.Field r3 = r10.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0172 }
            r3.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x0172 }
            java.lang.Object r3 = r3.get(r11)     // Catch:{ IllegalAccessException -> 0x016d }
            android.view.View r3 = (android.view.View) r3     // Catch:{ IllegalAccessException -> 0x016d }
            goto L_0x0177
        L_0x016d:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ NoSuchFieldException -> 0x0172 }
            goto L_0x0176
        L_0x0172:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ Exception -> 0x0111 }
        L_0x0176:
            r3 = r2
        L_0x0177:
            if (r3 != 0) goto L_0x0193
            java.lang.String r5 = "mView"
            java.lang.reflect.Field r5 = r10.getDeclaredField(r5)     // Catch:{ NoSuchFieldException -> 0x018f }
            r5.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x018f }
            java.lang.Object r5 = r5.get(r11)     // Catch:{ IllegalAccessException -> 0x018a }
            android.view.View r5 = (android.view.View) r5     // Catch:{ IllegalAccessException -> 0x018a }
            r3 = r5
            goto L_0x0193
        L_0x018a:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)     // Catch:{ NoSuchFieldException -> 0x018f }
            goto L_0x0193
        L_0x018f:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)     // Catch:{ Exception -> 0x0111 }
        L_0x0193:
            if (r3 == 0) goto L_0x0199
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r1, r3, r6)     // Catch:{ Exception -> 0x0111 }
        L_0x0199:
            r3 = -1
            if (r0 == 0) goto L_0x01a2
            int r5 = r0.getId()     // Catch:{ Exception -> 0x0111 }
            if (r5 != r3) goto L_0x01b9
        L_0x01a2:
            java.lang.String r0 = "mParent"
            java.lang.reflect.Field r10 = r10.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x01a9 }
            goto L_0x01af
        L_0x01a9:
            java.lang.String r0 = "parent"
            java.lang.reflect.Field r10 = r10.getDeclaredField(r0)     // Catch:{ Exception -> 0x0111 }
        L_0x01af:
            r10.setAccessible(r4)     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x0111 }
            r0 = r10
            android.view.View r0 = (android.view.View) r0     // Catch:{ Exception -> 0x0111 }
        L_0x01b9:
            if (r0 == 0) goto L_0x01d8
            int r10 = r0.getId()     // Catch:{ Exception -> 0x0111 }
            if (r10 == r3) goto L_0x01d8
            android.content.res.Resources r10 = r1.getResources()     // Catch:{ Exception -> 0x0111 }
            int r11 = r0.getId()     // Catch:{ Exception -> 0x0111 }
            java.lang.String r10 = r10.getResourceEntryName(r11)     // Catch:{ Exception -> 0x0111 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0111 }
            if (r11 != 0) goto L_0x01d8
            java.lang.String r11 = "$element_id"
            r6.put(r11, r10)     // Catch:{ Exception -> 0x0111 }
        L_0x01d8:
            if (r0 == 0) goto L_0x01eb
            int r10 = com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_properties     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r10 = r0.getTag(r10)     // Catch:{ Exception -> 0x0111 }
            org.json.JSONObject r10 = (org.json.JSONObject) r10     // Catch:{ Exception -> 0x0111 }
            if (r10 == 0) goto L_0x01eb
            com.sensorsdata.analytics.android.sdk.util.AopUtil.mergeJSONObject(r10, r6)     // Catch:{ Exception -> 0x0111 }
            goto L_0x01eb
        L_0x01e8:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r10)     // Catch:{ Exception -> 0x01f5 }
        L_0x01eb:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r10 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r11 = "$AppClick"
            r10.trackAutoEvent(r11, r6, r2)     // Catch:{ Exception -> 0x01f5 }
            goto L_0x01f9
        L_0x01f5:
            r10 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r10)
        L_0x01f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackTabLayoutSelected(java.lang.Object, java.lang.Object):void");
    }

    public static void trackMenuItem(MenuItem menuItem) {
        trackMenuItem((Object) null, menuItem);
    }

    public static void trackMenuItem(final Object obj, final MenuItem menuItem) {
        try {
            ThreadUtils.getSinglePool().execute(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:42:0x0080 A[Catch:{ Exception -> 0x00d4 }] */
                /* JADX WARNING: Removed duplicated region for block: B:45:0x008d A[Catch:{ Exception -> 0x00d4 }] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x009e A[Catch:{ Exception -> 0x00d4 }] */
                /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9 A[Catch:{ Exception -> 0x00d4 }] */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x00ac A[Catch:{ Exception -> 0x00d4 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r6 = this;
                        android.view.MenuItem r0 = r3     // Catch:{ Exception -> 0x00d4 }
                        if (r0 != 0) goto L_0x0005
                        return
                    L_0x0005:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d4 }
                        boolean r0 = r0.isAutoTrackEnabled()     // Catch:{ Exception -> 0x00d4 }
                        if (r0 != 0) goto L_0x0010
                        return
                    L_0x0010:
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d4 }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x00d4 }
                        boolean r0 = r0.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r1)     // Catch:{ Exception -> 0x00d4 }
                        if (r0 == 0) goto L_0x001d
                        return
                    L_0x001d:
                        java.lang.Class<android.view.MenuItem> r0 = android.view.MenuItem.class
                        boolean r0 = com.sensorsdata.analytics.android.sdk.util.AopUtil.isViewIgnored((java.lang.Class) r0)     // Catch:{ Exception -> 0x00d4 }
                        if (r0 == 0) goto L_0x0026
                        return
                    L_0x0026:
                        android.view.MenuItem r0 = r3     // Catch:{ Exception -> 0x00d4 }
                        boolean r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.isDeBounceTrack(r0)     // Catch:{ Exception -> 0x00d4 }
                        if (r0 == 0) goto L_0x002f
                        return
                    L_0x002f:
                        java.lang.Object r0 = r2     // Catch:{ Exception -> 0x00d4 }
                        r1 = 0
                        if (r0 == 0) goto L_0x003b
                        boolean r2 = r0 instanceof android.content.Context     // Catch:{ Exception -> 0x00d4 }
                        if (r2 == 0) goto L_0x003b
                        android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x00d4 }
                        goto L_0x003c
                    L_0x003b:
                        r0 = r1
                    L_0x003c:
                        android.view.MenuItem r2 = r3     // Catch:{ Exception -> 0x00d4 }
                        android.view.View r2 = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getClickView((android.view.MenuItem) r2)     // Catch:{ Exception -> 0x00d4 }
                        if (r0 != 0) goto L_0x004a
                        if (r2 == 0) goto L_0x004a
                        android.content.Context r0 = r2.getContext()     // Catch:{ Exception -> 0x00d4 }
                    L_0x004a:
                        if (r0 == 0) goto L_0x0051
                        android.app.Activity r3 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getActivityFromContext(r0, r1)     // Catch:{ Exception -> 0x00d4 }
                        goto L_0x0052
                    L_0x0051:
                        r3 = r1
                    L_0x0052:
                        if (r3 == 0) goto L_0x0063
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r4 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d4 }
                        java.lang.Class r5 = r3.getClass()     // Catch:{ Exception -> 0x00d4 }
                        boolean r4 = r4.isActivityAutoTrackAppClickIgnored(r5)     // Catch:{ Exception -> 0x00d4 }
                        if (r4 == 0) goto L_0x0063
                        return
                    L_0x0063:
                        if (r0 == 0) goto L_0x0078
                        android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0074 }
                        android.view.MenuItem r4 = r3     // Catch:{ Exception -> 0x0074 }
                        int r4 = r4.getItemId()     // Catch:{ Exception -> 0x0074 }
                        java.lang.String r0 = r0.getResourceEntryName(r4)     // Catch:{ Exception -> 0x0074 }
                        goto L_0x0079
                    L_0x0074:
                        r0 = move-exception
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x00d4 }
                    L_0x0078:
                        r0 = r1
                    L_0x0079:
                        org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d4 }
                        r4.<init>()     // Catch:{ Exception -> 0x00d4 }
                        if (r3 == 0) goto L_0x0087
                        org.json.JSONObject r5 = com.sensorsdata.analytics.android.sdk.util.AopUtil.buildTitleAndScreenName(r3)     // Catch:{ Exception -> 0x00d4 }
                        com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r5, r4)     // Catch:{ Exception -> 0x00d4 }
                    L_0x0087:
                        boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00d4 }
                        if (r5 != 0) goto L_0x0092
                        java.lang.String r5 = "$element_id"
                        r4.put(r5, r0)     // Catch:{ Exception -> 0x00d4 }
                    L_0x0092:
                        android.view.MenuItem r0 = r3     // Catch:{ Exception -> 0x00d4 }
                        java.lang.CharSequence r0 = r0.getTitle()     // Catch:{ Exception -> 0x00d4 }
                        boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00d4 }
                        if (r0 != 0) goto L_0x00a9
                        android.view.MenuItem r0 = r3     // Catch:{ Exception -> 0x00d4 }
                        java.lang.CharSequence r0 = r0.getTitle()     // Catch:{ Exception -> 0x00d4 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d4 }
                        goto L_0x00aa
                    L_0x00a9:
                        r0 = r1
                    L_0x00aa:
                        if (r2 == 0) goto L_0x00be
                        boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00d4 }
                        if (r1 == 0) goto L_0x00ba
                        com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r0 = com.sensorsdata.analytics.android.sdk.util.ViewUtil.getViewContentAndType(r2)     // Catch:{ Exception -> 0x00d4 }
                        java.lang.String r0 = r0.getViewContent()     // Catch:{ Exception -> 0x00d4 }
                    L_0x00ba:
                        com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r3, r2, r4)     // Catch:{ Exception -> 0x00d4 }
                    L_0x00be:
                        java.lang.String r2 = "$element_content"
                        r4.put(r2, r0)     // Catch:{ Exception -> 0x00d4 }
                        java.lang.String r0 = "$element_type"
                        java.lang.String r2 = "MenuItem"
                        r4.put(r0, r2)     // Catch:{ Exception -> 0x00d4 }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00d4 }
                        java.lang.String r2 = "$AppClick"
                        r0.trackAutoEvent(r2, r4, r1)     // Catch:{ Exception -> 0x00d4 }
                        goto L_0x00d8
                    L_0x00d4:
                        r0 = move-exception
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
                    L_0x00d8:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.AnonymousClass2.run():void");
                }
            });
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void trackRadioGroup(RadioGroup radioGroup, int i) {
        Context context;
        if (radioGroup != null) {
            try {
                View findViewById = radioGroup.findViewById(i);
                if (findViewById == null) {
                    return;
                }
                if (findViewById.isPressed()) {
                    if (SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_CLICK) && (context = radioGroup.getContext()) != null) {
                        Activity activityFromContext = AopUtil.getActivityFromContext(context, radioGroup);
                        if (activityFromContext == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activityFromContext.getClass())) {
                            Object fragmentFromView = AopUtil.getFragmentFromView(radioGroup, activityFromContext);
                            if ((fragmentFromView == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) && !AopUtil.isViewIgnored((View) radioGroup)) {
                                JSONObject jSONObject = new JSONObject();
                                String viewId = AopUtil.getViewId(radioGroup);
                                if (!TextUtils.isEmpty(viewId)) {
                                    jSONObject.put(AopConstants.ELEMENT_ID, viewId);
                                }
                                if (activityFromContext != null) {
                                    SensorsDataUtils.mergeJSONObject(AopUtil.buildTitleAndScreenName(activityFromContext), jSONObject);
                                }
                                String str = "RadioButton";
                                if (findViewById != null) {
                                    str = AopUtil.getViewType(findViewById.getClass().getCanonicalName(), str);
                                }
                                jSONObject.put(AopConstants.ELEMENT_TYPE, str);
                                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                                ViewNode viewNode = null;
                                if (activityFromContext != null) {
                                    try {
                                        RadioButton radioButton = (RadioButton) activityFromContext.findViewById(checkedRadioButtonId);
                                        if (radioButton != null) {
                                            if (!TextUtils.isEmpty(radioButton.getText())) {
                                                String charSequence = radioButton.getText().toString();
                                                if (!TextUtils.isEmpty(charSequence)) {
                                                    jSONObject.put(AopConstants.ELEMENT_CONTENT, charSequence);
                                                }
                                            }
                                            viewNode = AopUtil.addViewPathProperties(activityFromContext, radioButton, jSONObject);
                                        }
                                    } catch (Exception e) {
                                        SALog.printStackTrace(e);
                                    }
                                }
                                if (fragmentFromView != null) {
                                    AopUtil.getScreenNameAndTitleFromFragment(jSONObject, fragmentFromView, activityFromContext);
                                }
                                JSONObject jSONObject2 = (JSONObject) radioGroup.getTag(R.id.sensors_analytics_tag_view_properties);
                                if (jSONObject2 != null) {
                                    AopUtil.mergeJSONObject(jSONObject2, jSONObject);
                                }
                                SensorsDataAPI.sharedInstance().trackAutoEvent(AopConstants.APP_CLICK_EVENT_NAME, jSONObject, viewNode);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                SALog.printStackTrace(e2);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:104:0x016b */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0122 A[SYNTHETIC, Splitter:B:86:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0138 A[SYNTHETIC, Splitter:B:91:0x0138] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackDialog(android.content.DialogInterface r10, int r11) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AlertDialog"
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0175 }
            boolean r1 = r1.isAutoTrackEnabled()     // Catch:{ Exception -> 0x0175 }
            if (r1 != 0) goto L_0x000d
            return
        L_0x000d:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0175 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK     // Catch:{ Exception -> 0x0175 }
            boolean r1 = r1.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r2)     // Catch:{ Exception -> 0x0175 }
            if (r1 == 0) goto L_0x001a
            return
        L_0x001a:
            boolean r1 = r10 instanceof android.app.Dialog     // Catch:{ Exception -> 0x0175 }
            r2 = 0
            if (r1 == 0) goto L_0x0022
            android.app.Dialog r10 = (android.app.Dialog) r10     // Catch:{ Exception -> 0x0175 }
            goto L_0x0023
        L_0x0022:
            r10 = r2
        L_0x0023:
            if (r10 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r1 = isDeBounceTrack(r10)     // Catch:{ Exception -> 0x0175 }
            if (r1 == 0) goto L_0x002d
            return
        L_0x002d:
            android.content.Context r1 = r10.getContext()     // Catch:{ Exception -> 0x0175 }
            android.app.Activity r1 = com.sensorsdata.analytics.android.sdk.util.AopUtil.getActivityFromContext(r1, r2)     // Catch:{ Exception -> 0x0175 }
            if (r1 != 0) goto L_0x003b
            android.app.Activity r1 = r10.getOwnerActivity()     // Catch:{ Exception -> 0x0175 }
        L_0x003b:
            if (r1 == 0) goto L_0x004c
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0175 }
            java.lang.Class r4 = r1.getClass()     // Catch:{ Exception -> 0x0175 }
            boolean r3 = r3.isActivityAutoTrackAppClickIgnored(r4)     // Catch:{ Exception -> 0x0175 }
            if (r3 == 0) goto L_0x004c
            return
        L_0x004c:
            java.lang.Class<android.app.Dialog> r3 = android.app.Dialog.class
            boolean r3 = com.sensorsdata.analytics.android.sdk.util.AopUtil.isViewIgnored((java.lang.Class) r3)     // Catch:{ Exception -> 0x0175 }
            if (r3 == 0) goto L_0x0055
            return
        L_0x0055:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0175 }
            r3.<init>()     // Catch:{ Exception -> 0x0175 }
            android.view.Window r4 = r10.getWindow()     // Catch:{ Exception -> 0x0082 }
            if (r4 == 0) goto L_0x0086
            boolean r4 = r4.isActive()     // Catch:{ Exception -> 0x0082 }
            if (r4 == 0) goto L_0x0086
            android.view.Window r4 = r10.getWindow()     // Catch:{ Exception -> 0x0082 }
            android.view.View r4 = r4.getDecorView()     // Catch:{ Exception -> 0x0082 }
            int r5 = com.sensorsdata.analytics.android.sdk.R.id.sensors_analytics_tag_view_id     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r4 = r4.getTag(r5)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0082 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0082 }
            if (r5 != 0) goto L_0x0086
            java.lang.String r5 = "$element_id"
            r3.put(r5, r4)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r4 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r4)     // Catch:{ Exception -> 0x0175 }
        L_0x0086:
            if (r1 == 0) goto L_0x008f
            org.json.JSONObject r4 = com.sensorsdata.analytics.android.sdk.util.AopUtil.buildTitleAndScreenName(r1)     // Catch:{ Exception -> 0x0175 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r4, r3)     // Catch:{ Exception -> 0x0175 }
        L_0x008f:
            com.sensorsdata.analytics.android.sdk.visual.util.VisualUtil.mergeRnScreenNameAndTitle(r3)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r4 = "$element_type"
            java.lang.String r5 = "Dialog"
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0175 }
            java.lang.Class r4 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x009e }
            goto L_0x009f
        L_0x009e:
            r4 = r2
        L_0x009f:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00a5
        L_0x00a4:
            r0 = r2
        L_0x00a5:
            if (r4 != 0) goto L_0x00aa
            if (r0 != 0) goto L_0x00aa
            return
        L_0x00aa:
            if (r4 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = r0
        L_0x00ae:
            boolean r0 = r10 instanceof android.app.AlertDialog     // Catch:{ Exception -> 0x0175 }
            java.lang.String r5 = "$element_content"
            if (r0 == 0) goto L_0x00f6
            android.app.AlertDialog r10 = (android.app.AlertDialog) r10     // Catch:{ Exception -> 0x0175 }
            android.widget.Button r0 = r10.getButton(r11)     // Catch:{ Exception -> 0x0175 }
            if (r0 == 0) goto L_0x00d3
            java.lang.CharSequence r10 = r0.getText()     // Catch:{ Exception -> 0x0175 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0175 }
            if (r10 != 0) goto L_0x00cd
            java.lang.CharSequence r10 = r0.getText()     // Catch:{ Exception -> 0x0175 }
            r3.put(r5, r10)     // Catch:{ Exception -> 0x0175 }
        L_0x00cd:
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r1, r0, r3)     // Catch:{ Exception -> 0x0175 }
            goto L_0x016b
        L_0x00d3:
            android.widget.ListView r10 = r10.getListView()     // Catch:{ Exception -> 0x0175 }
            if (r10 == 0) goto L_0x016b
            android.widget.ListAdapter r0 = r10.getAdapter()     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r0 = r0.getItem(r11)     // Catch:{ Exception -> 0x0175 }
            if (r0 == 0) goto L_0x00ea
            boolean r4 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0175 }
            if (r4 == 0) goto L_0x00ea
            r3.put(r5, r0)     // Catch:{ Exception -> 0x0175 }
        L_0x00ea:
            android.view.View r10 = r10.getChildAt(r11)     // Catch:{ Exception -> 0x0175 }
            if (r10 == 0) goto L_0x016b
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r1, r10, r3)     // Catch:{ Exception -> 0x0175 }
            goto L_0x016b
        L_0x00f6:
            boolean r0 = r4.isInstance(r10)     // Catch:{ Exception -> 0x0175 }
            if (r0 == 0) goto L_0x016b
            r0 = 0
            java.lang.Class r4 = r10.getClass()     // Catch:{ Exception -> 0x011f }
            java.lang.String r6 = "getButton"
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x011f }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x011f }
            r8[r0] = r9     // Catch:{ Exception -> 0x011f }
            java.lang.reflect.Method r4 = r4.getMethod(r6, r8)     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x011f
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x011f }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x011f }
            r6[r0] = r7     // Catch:{ Exception -> 0x011f }
            java.lang.Object r4 = r4.invoke(r10, r6)     // Catch:{ Exception -> 0x011f }
            android.widget.Button r4 = (android.widget.Button) r4     // Catch:{ Exception -> 0x011f }
            goto L_0x0120
        L_0x011f:
            r4 = r2
        L_0x0120:
            if (r4 == 0) goto L_0x0138
            java.lang.CharSequence r10 = r4.getText()     // Catch:{ Exception -> 0x0175 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0175 }
            if (r10 != 0) goto L_0x0133
            java.lang.CharSequence r10 = r4.getText()     // Catch:{ Exception -> 0x0175 }
            r3.put(r5, r10)     // Catch:{ Exception -> 0x0175 }
        L_0x0133:
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r1, r4, r3)     // Catch:{ Exception -> 0x0175 }
            goto L_0x016b
        L_0x0138:
            java.lang.Class r4 = r10.getClass()     // Catch:{ Exception -> 0x016b }
            java.lang.String r6 = "getListView"
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x016b }
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ Exception -> 0x016b }
            if (r4 == 0) goto L_0x016b
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x016b }
            java.lang.Object r10 = r4.invoke(r10, r0)     // Catch:{ Exception -> 0x016b }
            android.widget.ListView r10 = (android.widget.ListView) r10     // Catch:{ Exception -> 0x016b }
            if (r10 == 0) goto L_0x016b
            android.widget.ListAdapter r0 = r10.getAdapter()     // Catch:{ Exception -> 0x016b }
            java.lang.Object r0 = r0.getItem(r11)     // Catch:{ Exception -> 0x016b }
            if (r0 == 0) goto L_0x0161
            boolean r4 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x016b }
            if (r4 == 0) goto L_0x0161
            r3.put(r5, r0)     // Catch:{ Exception -> 0x016b }
        L_0x0161:
            android.view.View r10 = r10.getChildAt(r11)     // Catch:{ Exception -> 0x016b }
            if (r10 == 0) goto L_0x016b
            com.sensorsdata.analytics.android.sdk.visual.model.ViewNode r2 = com.sensorsdata.analytics.android.sdk.util.AopUtil.addViewPathProperties(r1, r10, r3)     // Catch:{ Exception -> 0x016b }
        L_0x016b:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r10 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0175 }
            java.lang.String r11 = "$AppClick"
            r10.trackAutoEvent(r11, r3, r2)     // Catch:{ Exception -> 0x0175 }
            goto L_0x0179
        L_0x0175:
            r10 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r10)
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackDialog(android.content.DialogInterface, int):void");
    }

    public static void trackListView(AdapterView<?> adapterView, View view, int i) {
        Context context;
        if (view != null) {
            try {
                if (SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_CLICK) && (context = view.getContext()) != null) {
                    Activity activityFromContext = AopUtil.getActivityFromContext(context, view);
                    if (activityFromContext == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activityFromContext.getClass())) {
                        Object fragmentFromView = AopUtil.getFragmentFromView(adapterView, activityFromContext);
                        if ((fragmentFromView == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) && !AopUtil.isViewIgnored((View) adapterView)) {
                            JSONObject jSONObject = new JSONObject();
                            if (adapterView instanceof ListView) {
                                jSONObject.put(AopConstants.ELEMENT_TYPE, "ListView");
                                if (AopUtil.isViewIgnored(ListView.class)) {
                                    return;
                                }
                            } else if (adapterView instanceof GridView) {
                                jSONObject.put(AopConstants.ELEMENT_TYPE, "GridView");
                                if (AopUtil.isViewIgnored(GridView.class)) {
                                    return;
                                }
                            } else if (adapterView instanceof Spinner) {
                                jSONObject.put(AopConstants.ELEMENT_TYPE, "Spinner");
                                if (AopUtil.isViewIgnored(Spinner.class)) {
                                    return;
                                }
                            }
                            String viewId = AopUtil.getViewId(adapterView);
                            if (!TextUtils.isEmpty(viewId)) {
                                jSONObject.put(AopConstants.ELEMENT_ID, viewId);
                            }
                            Object adapter = adapterView.getAdapter();
                            if (adapter instanceof HeaderViewListAdapter) {
                                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                            }
                            if (adapter instanceof SensorsAdapterViewItemTrackProperties) {
                                try {
                                    JSONObject sensorsItemTrackProperties = ((SensorsAdapterViewItemTrackProperties) adapter).getSensorsItemTrackProperties(i);
                                    if (sensorsItemTrackProperties != null) {
                                        AopUtil.mergeJSONObject(sensorsItemTrackProperties, jSONObject);
                                    }
                                } catch (JSONException e) {
                                    SALog.printStackTrace(e);
                                }
                            }
                            ViewNode addViewPathProperties = AopUtil.addViewPathProperties(activityFromContext, view, jSONObject);
                            if (activityFromContext != null) {
                                SensorsDataUtils.mergeJSONObject(AopUtil.buildTitleAndScreenName(activityFromContext), jSONObject);
                            }
                            String str = null;
                            if (view instanceof ViewGroup) {
                                try {
                                    str = AopUtil.traverseView(new StringBuilder(), (ViewGroup) view);
                                    if (!TextUtils.isEmpty(str)) {
                                        str = str.substring(0, str.length() - 1);
                                    }
                                } catch (Exception e2) {
                                    SALog.printStackTrace(e2);
                                }
                            } else {
                                str = AopUtil.getViewText(view);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put(AopConstants.ELEMENT_CONTENT, str);
                            }
                            if (fragmentFromView != null) {
                                AopUtil.getScreenNameAndTitleFromFragment(jSONObject, fragmentFromView, activityFromContext);
                            }
                            JSONObject jSONObject2 = (JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties);
                            if (jSONObject2 != null) {
                                AopUtil.mergeJSONObject(jSONObject2, jSONObject);
                            }
                            SensorsDataAPI.sharedInstance().trackAutoEvent(AopConstants.APP_CLICK_EVENT_NAME, jSONObject, addViewPathProperties);
                        }
                    }
                }
            } catch (Exception e3) {
                SALog.printStackTrace(e3);
            }
        }
    }

    public static void trackDrawerOpened(View view) {
        if (view != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AopConstants.ELEMENT_CONTENT, "Open");
                SensorsDataAPI.sharedInstance().setViewProperties(view, jSONObject);
                trackViewOnClick(view);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void trackDrawerClosed(View view) {
        if (view != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AopConstants.ELEMENT_CONTENT, "Close");
                SensorsDataAPI.sharedInstance().setViewProperties(view, jSONObject);
                trackViewOnClick(view);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void trackViewOnClick(View view) {
        if (view != null) {
            trackViewOnClick(view, view.isPressed());
        }
    }

    public static void trackViewOnClick(View view, boolean z) {
        if (view != null) {
            try {
                if (SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_CLICK)) {
                    Activity activityFromContext = AopUtil.getActivityFromContext(view.getContext(), view);
                    if (activityFromContext == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(activityFromContext.getClass())) {
                        Object fragmentFromView = AopUtil.getFragmentFromView(view, activityFromContext);
                        if ((fragmentFromView == null || !SensorsDataAPI.sharedInstance().isActivityAutoTrackAppClickIgnored(fragmentFromView.getClass())) && !AopUtil.isViewIgnored(view) && !SensorsDataUtils.isDoubleClick(view)) {
                            JSONObject jSONObject = new JSONObject();
                            if (AopUtil.injectClickInfo(view, jSONObject, z)) {
                                SensorsDataAPI.sharedInstance().trackAutoEvent(AopConstants.APP_CLICK_EVENT_NAME, jSONObject, AopUtil.addViewPathProperties(activityFromContext, view, jSONObject));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public static void track(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (Exception e) {
                        SALog.printStackTrace(e);
                    }
                }
                SensorsDataAPI.sharedInstance().trackInternal(str, jSONObject);
            }
        } catch (Exception e2) {
            SALog.printStackTrace(e2);
        }
    }

    public static void showChannelDebugActiveDialog(final Activity activity) {
        SensorsDataDialogUtils.showDialog(activity, "成功开启调试模式", "此模式下不需要卸载 App，点击“激活”按钮可反复触发激活", "激活", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SensorsDataAPI.sharedInstance().trackChannelDebugInstallation();
                SensorsDataAutoTrackHelper.showChannelDebugActiveDialog(activity);
            }
        }, "取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SensorsDataDialogUtils.startLaunchActivity(activity);
            }
        });
    }

    public static void loadUrl(View view, String str) {
        loadUrl2(view, str);
        invokeWebViewLoad(view, "loadUrl", new Object[]{str}, new Class[]{String.class});
    }

    public static void loadUrl2(View view, String str) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadUrl(View view, String str, Map<String, String> map) {
        loadUrl2(view, str, map);
        invokeWebViewLoad(view, "loadUrl", new Object[]{str, map}, new Class[]{String.class, Map.class});
    }

    public static void loadUrl2(View view, String str, Map<String, String> map) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadData(View view, String str, String str2, String str3) {
        loadData2(view, str, str2, str3);
        invokeWebViewLoad(view, "loadData", new Object[]{str, str2, str3}, new Class[]{String.class, String.class, String.class});
    }

    public static void loadData2(View view, String str, String str2, String str3) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadDataWithBaseURL(View view, String str, String str2, String str3, String str4, String str5) {
        loadDataWithBaseURL2(view, str, str2, str3, str4, str5);
        invokeWebViewLoad(view, "loadDataWithBaseURL", new Object[]{str, str2, str3, str4, str5}, new Class[]{String.class, String.class, String.class, String.class, String.class});
    }

    public static void loadDataWithBaseURL2(View view, String str, String str2, String str3, String str4, String str5) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void postUrl(View view, String str, byte[] bArr) {
        postUrl2(view, str, bArr);
        invokeWebViewLoad(view, "postUrl", new Object[]{str, bArr}, new Class[]{String.class, byte[].class});
    }

    public static void postUrl2(View view, String str, byte[] bArr) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    private static void setupH5Bridge(View view) {
        if (!(SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation)) {
            if (isSupportJellyBean()) {
                SensorsDataAPI.sharedInstance();
                if (SensorsDataAPI.getConfigOptions() != null) {
                    SensorsDataAPI.sharedInstance();
                    if (SensorsDataAPI.getConfigOptions().isAutoTrackWebView) {
                        setupWebView(view);
                    }
                }
            }
            if (isSupportJellyBean()) {
                addWebViewVisualInterface(view);
            }
        }
    }

    private static void invokeWebViewLoad(View view, String str, Object[] objArr, Class[] clsArr) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
            return;
        }
        try {
            view.getClass().getMethod(str, clsArr).invoke(view, objArr);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    static void addWebViewVisualInterface(View view) {
        if (view != null && view.getTag(R.id.sensors_analytics_tag_view_webview_visual) == null) {
            view.setTag(R.id.sensors_analytics_tag_view_webview_visual, new Object());
            addJavascriptInterface(view, new WebViewVisualInterface(view), "SensorsData_App_Visual_Bridge");
        }
    }

    private static boolean isSupportJellyBean() {
        if (Build.VERSION.SDK_INT >= 17 || SensorsDataAPI.getConfigOptions().isWebViewSupportJellyBean) {
            return true;
        }
        SALog.d(TAG, "For applications targeted to API level JELLY_BEAN or below, this feature NOT SUPPORTED");
        return false;
    }

    private static void setupWebView(View view) {
        if (view != null && view.getTag(R.id.sensors_analytics_tag_view_webview) == null) {
            view.setTag(R.id.sensors_analytics_tag_view_webview, new Object());
            addJavascriptInterface(view, new AppWebViewInterface(SensorsDataAPI.sharedInstance().getContext(), (JSONObject) null, false, view), "SensorsData_APP_New_H5_Bridge");
        }
    }

    private static void addJavascriptInterface(View view, Object obj, String str) {
        try {
            Class<?> cls = view.getClass();
            try {
                Object invoke = cls.getMethod("getSettings", new Class[0]).invoke(view, new Object[0]);
                if (invoke != null) {
                    invoke.getClass().getMethod("setJavaScriptEnabled", new Class[]{Boolean.TYPE}).invoke(invoke, new Object[]{true});
                }
            } catch (Exception unused) {
            }
            cls.getMethod("addJavascriptInterface", new Class[]{Object.class, String.class}).invoke(view, new Object[]{obj, str});
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
