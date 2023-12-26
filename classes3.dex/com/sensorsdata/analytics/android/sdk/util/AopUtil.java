package com.sensorsdata.analytics.android.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.CompoundButton;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AopUtil {
    private static final String TAG = "AopUtil";
    private static LruCache<String, WeakReference<Object>> sLruCache = new LruCache<>(10);
    private static ArrayList<String> sOSViewPackage = new ArrayList<String>() {
        {
            add("android##widget");
            add("android##support##v7##widget");
            add("android##support##design##widget");
            add("android##support##text##emoji##widget");
            add("androidx##appcompat##widget");
            add("androidx##emoji##widget");
            add("androidx##cardview##widget");
            add("com##google##android##material");
        }
    };

    public static String traverseView(StringBuilder sb, ViewGroup viewGroup) {
        if (sb == null) {
            try {
                sb = new StringBuilder();
            } catch (Throwable th) {
                SALog.d(TAG, th.getMessage());
                return sb != null ? sb.toString() : "";
            }
        }
        if (viewGroup == null) {
            return sb.toString();
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                if (childAt.getVisibility() == 0) {
                    if (childAt instanceof ViewGroup) {
                        traverseView(sb, (ViewGroup) childAt);
                    } else if (!isViewIgnored(childAt)) {
                        String viewText = getViewText(childAt);
                        if (!TextUtils.isEmpty(viewText)) {
                            sb.append(viewText);
                            sb.append("-");
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|(2:4|5)|(2:9|10)|11|12|(1:14)(1:(2:23|(1:25)(2:26|(2:28|(1:30)(1:31))(2:32|(1:34)(2:35|(1:37)(2:38|(1:40)(2:41|(3:43|(1:45)|46)(1:47)))))))(3:18|(1:20)(1:21)|22))|48|(1:52)|53|(2:55|56)|59) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d9, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00da, code lost:
        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001a A[Catch:{ Exception -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[Catch:{ Exception -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d4 A[Catch:{ Exception -> 0x00d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getViewText(android.view.View r5) {
        /*
            java.lang.String r0 = "androidx.appcompat.widget.SwitchCompat"
            boolean r1 = r5 instanceof android.widget.EditText
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0009
            return r2
        L_0x0009:
            r1 = 0
            java.lang.Class r3 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r3 = r1
        L_0x0010:
            if (r3 != 0) goto L_0x0016
            java.lang.Class r3 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            boolean r0 = r5 instanceof android.widget.CheckBox     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x0023
            r0 = r5
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x0023:
            if (r3 == 0) goto L_0x0058
            boolean r0 = r3.isInstance(r5)     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x0058
            r0 = r5
            android.widget.CompoundButton r0 = (android.widget.CompoundButton) r0     // Catch:{ Exception -> 0x00d9 }
            boolean r0 = r0.isChecked()     // Catch:{ Exception -> 0x00d9 }
            r1 = 0
            if (r0 == 0) goto L_0x0042
            java.lang.Class r0 = r5.getClass()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r3 = "getTextOn"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00d9 }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x004e
        L_0x0042:
            java.lang.Class r0 = r5.getClass()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r3 = "getTextOff"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00d9 }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch:{ Exception -> 0x00d9 }
        L_0x004e:
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00d9 }
            java.lang.Object r0 = r0.invoke(r5, r1)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x0058:
            boolean r0 = r5 instanceof android.widget.RadioButton     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x0064
            r0 = r5
            android.widget.RadioButton r0 = (android.widget.RadioButton) r0     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x0064:
            boolean r0 = r5 instanceof android.widget.ToggleButton     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x007b
            r0 = r5
            android.widget.ToggleButton r0 = (android.widget.ToggleButton) r0     // Catch:{ Exception -> 0x00d9 }
            boolean r1 = r0.isChecked()     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x0076
            java.lang.CharSequence r0 = r0.getTextOn()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x0076:
            java.lang.CharSequence r0 = r0.getTextOff()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x007b:
            boolean r0 = r5 instanceof android.widget.Button     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x0087
            r0 = r5
            android.widget.Button r0 = (android.widget.Button) r0     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x0087:
            boolean r0 = r5 instanceof android.widget.CheckedTextView     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x0093
            r0 = r5
            android.widget.CheckedTextView r0 = (android.widget.CheckedTextView) r0     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x0093:
            boolean r0 = r5 instanceof android.widget.TextView     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x009f
            r0 = r5
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00be
        L_0x009f:
            boolean r0 = r5 instanceof android.widget.ImageView     // Catch:{ Exception -> 0x00d9 }
            if (r0 == 0) goto L_0x00ba
            r0 = r5
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r3 = r0.getContentDescription()     // Catch:{ Exception -> 0x00d9 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00d9 }
            if (r3 != 0) goto L_0x00b8
            java.lang.CharSequence r0 = r0.getContentDescription()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x00d9 }
        L_0x00b8:
            r0 = r1
            goto L_0x00be
        L_0x00ba:
            java.lang.CharSequence r0 = r5.getContentDescription()     // Catch:{ Exception -> 0x00d9 }
        L_0x00be:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00ce
            boolean r1 = r5 instanceof android.widget.TextView     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00ce
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x00d9 }
            java.lang.CharSequence r0 = r5.getHint()     // Catch:{ Exception -> 0x00d9 }
        L_0x00ce:
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00d9 }
            if (r5 != 0) goto L_0x00dd
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x00d9 }
            return r5
        L_0x00d9:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x00dd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.AopUtil.getViewText(android.view.View):java.lang.String");
    }

    public static Activity getActivityFromContext(Context context, View view) {
        Object tag;
        Activity activity;
        Activity activity2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                if (context instanceof ContextWrapper) {
                    while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                    }
                }
                if (activity2 == null || view == null || (tag = view.getTag(R.id.sensors_analytics_tag_view_activity)) == null || !(tag instanceof Activity)) {
                    return activity2;
                }
                return (Activity) tag;
            }
            activity2 = activity;
            return activity2 == null ? activity2 : activity2;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094 A[Catch:{ Exception -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A[Catch:{ Exception -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getScreenNameAndTitleFromFragment(org.json.JSONObject r8, java.lang.Object r9, android.app.Activity r10) {
        /*
            boolean r0 = r9 instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker     // Catch:{ Exception -> 0x00a9 }
            r1 = 0
            java.lang.String r2 = "$title"
            java.lang.String r3 = "$screen_name"
            if (r0 == 0) goto L_0x002c
            r0 = r9
            com.sensorsdata.analytics.android.sdk.ScreenAutoTracker r0 = (com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) r0     // Catch:{ Exception -> 0x00a9 }
            org.json.JSONObject r0 = r0.getTrackProperties()     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x002c
            boolean r4 = r0.has(r3)     // Catch:{ Exception -> 0x00a9 }
            if (r4 == 0) goto L_0x001d
            java.lang.String r4 = r0.optString(r3)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x001e
        L_0x001d:
            r4 = r1
        L_0x001e:
            boolean r5 = r0.has(r2)     // Catch:{ Exception -> 0x00a9 }
            if (r5 == 0) goto L_0x0028
            java.lang.String r1 = r0.optString(r2)     // Catch:{ Exception -> 0x00a9 }
        L_0x0028:
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r0, r8)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x002d
        L_0x002c:
            r4 = r1
        L_0x002d:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x0051
            java.lang.Class r0 = r9.getClass()     // Catch:{ Exception -> 0x00a9 }
            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r5 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
            boolean r0 = r0.isAnnotationPresent(r5)     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x0051
            java.lang.Class r0 = r9.getClass()     // Catch:{ Exception -> 0x00a9 }
            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r5 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r5)     // Catch:{ Exception -> 0x00a9 }
            com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle r0 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r0     // Catch:{ Exception -> 0x00a9 }
            if (r0 == 0) goto L_0x0051
            java.lang.String r1 = r0.title()     // Catch:{ Exception -> 0x00a9 }
        L_0x0051:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00a9 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00a9 }
            if (r0 != 0) goto L_0x005d
            if (r5 == 0) goto L_0x008e
        L_0x005d:
            if (r10 != 0) goto L_0x0063
            android.app.Activity r10 = getActivityFromFragment(r9)     // Catch:{ Exception -> 0x00a9 }
        L_0x0063:
            if (r10 == 0) goto L_0x008e
            if (r0 == 0) goto L_0x006b
            java.lang.String r1 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(r10)     // Catch:{ Exception -> 0x00a9 }
        L_0x006b:
            if (r5 == 0) goto L_0x008e
            java.lang.Class r0 = r9.getClass()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r0 = r0.getCanonicalName()     // Catch:{ Exception -> 0x00a9 }
            java.util.Locale r4 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = "%s|%s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00a9 }
            r7 = 0
            java.lang.Class r10 = r10.getClass()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = r10.getCanonicalName()     // Catch:{ Exception -> 0x00a9 }
            r6[r7] = r10     // Catch:{ Exception -> 0x00a9 }
            r10 = 1
            r6[r10] = r0     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r4 = java.lang.String.format(r4, r5, r6)     // Catch:{ Exception -> 0x00a9 }
        L_0x008e:
            boolean r10 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x0097
            r8.put(r2, r1)     // Catch:{ Exception -> 0x00a9 }
        L_0x0097:
            boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00a9 }
            if (r10 == 0) goto L_0x00a5
            java.lang.Class r9 = r9.getClass()     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r4 = r9.getCanonicalName()     // Catch:{ Exception -> 0x00a9 }
        L_0x00a5:
            r8.put(r3, r4)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r8 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.AopUtil.getScreenNameAndTitleFromFragment(org.json.JSONObject, java.lang.Object, android.app.Activity):void");
    }

    public static Activity getActivityFromFragment(Object obj) {
        if (Build.VERSION.SDK_INT < 11) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod("getActivity", new Class[0]);
            if (method != null) {
                return (Activity) method.invoke(obj, new Object[0]);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject buildTitleAndScreenName(Activity activity) {
        JSONObject trackProperties;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AopConstants.SCREEN_NAME, activity.getClass().getCanonicalName());
            String activityTitle = getActivityTitle(activity);
            if (!TextUtils.isEmpty(activityTitle)) {
                jSONObject.put(AopConstants.TITLE, activityTitle);
            }
            if ((activity instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) activity).getTrackProperties()) != null) {
                SensorsDataUtils.mergeJSONObject(trackProperties, jSONObject);
            }
            return jSONObject;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return new JSONObject();
        }
    }

    public static JSONObject buildTitleNoAutoTrackerProperties(Activity activity) {
        JSONObject trackProperties;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AopConstants.SCREEN_NAME, activity.getClass().getCanonicalName());
            String activityTitle = getActivityTitle(activity);
            if (!TextUtils.isEmpty(activityTitle)) {
                jSONObject.put(AopConstants.TITLE, activityTitle);
            }
            if ((activity instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) activity).getTrackProperties()) != null) {
                if (trackProperties.has(AopConstants.SCREEN_NAME)) {
                    jSONObject.put(AopConstants.SCREEN_NAME, trackProperties.optString(AopConstants.SCREEN_NAME));
                }
                if (trackProperties.has(AopConstants.TITLE)) {
                    jSONObject.put(AopConstants.TITLE, trackProperties.optString(AopConstants.TITLE));
                }
            }
            return jSONObject;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return new JSONObject();
        }
    }

    public static String getCompoundButtonText(View view) {
        Method method;
        try {
            if (((CompoundButton) view).isChecked()) {
                method = view.getClass().getMethod("getTextOn", new Class[0]);
            } else {
                method = view.getClass().getMethod("getTextOff", new Class[0]);
            }
            return (String) method.invoke(view, new Object[0]);
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getViewId(View view) {
        String str = null;
        try {
            String str2 = (String) view.getTag(R.id.sensors_analytics_tag_view_id);
            try {
                return (!TextUtils.isEmpty(str2) || view.getId() == -1) ? str2 : view.getContext().getResources().getResourceEntryName(view.getId());
            } catch (Exception unused) {
                str = str2;
                return str;
            }
        } catch (Exception unused2) {
            return str;
        }
    }

    public static String getViewType(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return (!TextUtils.isEmpty(str2) && isOSViewByPackage(str)) ? str2 : str;
    }

    public static String getViewGroupTypeByReflect(View view) {
        String canonicalName = view.getClass().getCanonicalName();
        Class<?> classByName = getClassByName("androidx.cardview.widget.CardView");
        if (classByName != null && classByName.isInstance(view)) {
            return getViewType(canonicalName, "CardView");
        }
        Class<?> classByName2 = getClassByName("androidx.cardview.widget.CardView");
        if (classByName2 != null && classByName2.isInstance(view)) {
            return getViewType(canonicalName, "CardView");
        }
        Class<?> classByName3 = getClassByName("com.google.android.material.navigation.NavigationView");
        if (classByName3 != null && classByName3.isInstance(view)) {
            return getViewType(canonicalName, "NavigationView");
        }
        Class<?> classByName4 = getClassByName("com.google.android.material.navigation.NavigationView");
        return (classByName4 == null || !classByName4.isInstance(view)) ? canonicalName : getViewType(canonicalName, "NavigationView");
    }

    public static String getViewTypeByReflect(View view) {
        String canonicalName = view.getClass().getCanonicalName();
        Class<?> classByName = getClassByName("android.widget.Switch");
        if (classByName != null && classByName.isInstance(view)) {
            return getViewType(canonicalName, "Switch");
        }
        Class<?> classByName2 = getClassByName("androidx.appcompat.widget.SwitchCompat");
        if (classByName2 != null && classByName2.isInstance(view)) {
            return getViewType(canonicalName, "SwitchCompat");
        }
        Class<?> classByName3 = getClassByName("androidx.appcompat.widget.SwitchCompat");
        return (classByName3 == null || !classByName3.isInstance(view)) ? canonicalName : getViewType(canonicalName, "SwitchCompat");
    }

    private static Class<?> getClassByName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static boolean isViewIgnored(Class cls) {
        if (cls == null) {
            return true;
        }
        try {
            List<Class> ignoredViewTypeList = SensorsDataAPI.sharedInstance().getIgnoredViewTypeList();
            if (ignoredViewTypeList.isEmpty()) {
                return false;
            }
            for (Class isAssignableFrom : ignoredViewTypeList) {
                if (isAssignableFrom.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isViewIgnored(View view) {
        if (view == null) {
            return true;
        }
        try {
            List<Class> ignoredViewTypeList = SensorsDataAPI.sharedInstance().getIgnoredViewTypeList();
            if (ignoredViewTypeList != null) {
                for (Class isAssignableFrom : ignoredViewTypeList) {
                    if (isAssignableFrom.isAssignableFrom(view.getClass())) {
                        return true;
                    }
                }
            }
            return DbParams.GZIP_DATA_EVENT.equals(view.getTag(R.id.sensors_analytics_tag_view_ignored));
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return true;
        }
    }

    private static String getActivityTitle(Activity activity) {
        PackageManager packageManager;
        if (activity != null) {
            try {
                String charSequence = !TextUtils.isEmpty(activity.getTitle()) ? activity.getTitle().toString() : null;
                if (Build.VERSION.SDK_INT >= 11) {
                    String toolbarTitle = SensorsDataUtils.getToolbarTitle(activity);
                    if (!TextUtils.isEmpty(toolbarTitle)) {
                        charSequence = toolbarTitle;
                    }
                }
                if (!TextUtils.isEmpty(charSequence) || (packageManager = activity.getPackageManager()) == null) {
                    return charSequence;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 0);
                return !TextUtils.isEmpty(activityInfo.loadLabel(packageManager)) ? activityInfo.loadLabel(packageManager).toString() : charSequence;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void mergeJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    jSONObject2.put(next, TimeUtils.formatDate((Date) obj));
                } else {
                    jSONObject2.put(next, obj);
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private static boolean isOSViewByPackage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace(".", "##");
        Iterator<String> it = sOSViewPackage.iterator();
        while (it.hasNext()) {
            if (replace.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean injectClickInfo(View view, JSONObject jSONObject, boolean z) {
        if (!(view == null || jSONObject == null)) {
            try {
                if (!ViewUtil.isTrackEvent(view, z)) {
                    return false;
                }
                Context context = view.getContext();
                JSONObject jSONObject2 = new JSONObject();
                Activity activityFromContext = getActivityFromContext(context, view);
                String viewId = getViewId(view);
                if (!TextUtils.isEmpty(viewId)) {
                    jSONObject2.put(AopConstants.ELEMENT_ID, viewId);
                }
                ViewNode viewContentAndType = ViewUtil.getViewContentAndType(view);
                String viewContent = viewContentAndType.getViewContent();
                if (!TextUtils.isEmpty(viewContent)) {
                    jSONObject2.put(AopConstants.ELEMENT_CONTENT, viewContent);
                }
                jSONObject2.put(AopConstants.ELEMENT_TYPE, viewContentAndType.getViewType());
                if (activityFromContext != null) {
                    SensorsDataUtils.mergeJSONObject(buildTitleAndScreenName(activityFromContext), jSONObject2);
                }
                Object fragmentFromView = getFragmentFromView(view, activityFromContext);
                if (fragmentFromView != null) {
                    getScreenNameAndTitleFromFragment(jSONObject2, fragmentFromView, activityFromContext);
                }
                JSONObject jSONObject3 = (JSONObject) view.getTag(R.id.sensors_analytics_tag_view_properties);
                if (jSONObject3 != null) {
                    mergeJSONObject(jSONObject3, jSONObject2);
                }
                JSONUtils.mergeDistinctProperty(jSONObject2, jSONObject);
                return true;
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }
        return false;
    }

    public static Object getFragmentFromView(View view) {
        return getFragmentFromView(view, (Activity) null);
    }

    public static Object getFragmentFromView(View view, Activity activity) {
        Object obj;
        Window window;
        if (view == null) {
            return null;
        }
        try {
            String str = (String) view.getTag(R.id.sensors_analytics_tag_view_fragment_name);
            String str2 = (String) view.getTag(R.id.sensors_analytics_tag_view_fragment_name2);
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                if (activity == null) {
                    activity = getActivityFromContext(view.getContext(), view);
                }
                if (!(activity == null || (window = activity.getWindow()) == null || !window.isActive() || window.getDecorView().getRootView().getTag(R.id.sensors_analytics_tag_view_fragment_name) == null)) {
                    str = traverseParentViewTag(view);
                }
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            WeakReference weakReference = sLruCache.get(str);
            if (weakReference != null && (obj = weakReference.get()) != null) {
                return obj;
            }
            Object newInstance = Class.forName(str).newInstance();
            sLruCache.put(str, new WeakReference(newInstance));
            return newInstance;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    public static ViewNode addViewPathProperties(Activity activity, View view, JSONObject jSONObject) {
        if (view == null || activity == null) {
            return null;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }
        if ((SensorsDataAPI.sharedInstance().isHeatMapEnabled() || SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) && (SensorsDataAPI.sharedInstance().isHeatMapActivity(activity.getClass()) || SensorsDataAPI.sharedInstance().isVisualizedAutoTrackActivity(activity.getClass()))) {
            String elementSelector = ViewUtil.getElementSelector(view);
            if (!TextUtils.isEmpty(elementSelector)) {
                jSONObject.put(AopConstants.ELEMENT_SELECTOR, elementSelector);
            }
        }
        ViewNode viewNode = ViewTreeStatusObservable.getInstance().getViewNode(view);
        if (viewNode != null) {
            if (!TextUtils.isEmpty(viewNode.getViewPath()) && ((SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled() && SensorsDataAPI.sharedInstance().isVisualizedAutoTrackActivity(activity.getClass())) || (SensorsDataAPI.sharedInstance().isHeatMapEnabled() && SensorsDataAPI.sharedInstance().isHeatMapActivity(activity.getClass())))) {
                jSONObject.put(AopConstants.ELEMENT_PATH, viewNode.getViewPath());
            }
            if (!TextUtils.isEmpty(viewNode.getViewPosition())) {
                jSONObject.put(AopConstants.ELEMENT_POSITION, viewNode.getViewPosition());
            }
            return viewNode;
        }
        return null;
    }

    private static String traverseParentViewTag(View view) {
        try {
            ViewParent parent = view.getParent();
            String str = null;
            while (TextUtils.isEmpty(str) && (parent instanceof View)) {
                str = (String) ((View) parent).getTag(R.id.sensors_analytics_tag_view_fragment_name);
                parent = parent.getParent();
            }
            return str;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }
}
