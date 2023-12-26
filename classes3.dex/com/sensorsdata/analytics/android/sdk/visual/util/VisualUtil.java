package com.sensorsdata.analytics.android.sdk.visual.util;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.ViewUtil;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.Pathfinder;
import org.json.JSONObject;

public class VisualUtil {
    public static int getVisibility(View view) {
        if (!(view instanceof Spinner) && ViewUtil.isViewSelfVisible(view) && view.isShown()) {
            return 0;
        }
        return 8;
    }

    public static boolean isSupportElementContent(View view) {
        return !(view instanceof SeekBar) && !(view instanceof RatingBar) && !(view instanceof Switch);
    }

    public static boolean isForbiddenClick(View view) {
        if (ViewUtil.instanceOfWebView(view) || (view instanceof AdapterView)) {
            return true;
        }
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (Build.VERSION.SDK_INT < 15 || !textView.isTextSelectable() || textView.hasOnClickListeners()) {
            return false;
        }
        return true;
    }

    public static boolean isSupportClick(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AdapterView) || ViewUtil.instanceOfRecyclerView(parent) || (view instanceof RatingBar) || (view instanceof SeekBar)) {
            return true;
        }
        return false;
    }

    public static int getChildIndex(ViewParent viewParent, View view) {
        try {
            if (!(viewParent instanceof ViewGroup)) {
                return -1;
            }
            ViewGroup viewGroup = (ViewGroup) viewParent;
            String viewId = AopUtil.getViewId(view);
            String canonicalName = view.getClass().getCanonicalName();
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (Pathfinder.hasClassName(childAt, canonicalName)) {
                    String viewId2 = AopUtil.getViewId(childAt);
                    if ((viewId == null || viewId.equals(viewId2)) && childAt == view) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return -1;
        }
    }

    public static JSONObject getScreenNameAndTitle(View view, SnapInfo snapInfo) {
        if (view == null) {
            return null;
        }
        Activity activityFromContext = AopUtil.getActivityFromContext(view.getContext(), view);
        if (activityFromContext == null) {
            activityFromContext = AppStateManager.getInstance().getForegroundActivity();
        }
        if (activityFromContext == null || activityFromContext.getWindow() == null || !activityFromContext.getWindow().isActive()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Object fragmentFromView = AopUtil.getFragmentFromView(view, activityFromContext);
        if (fragmentFromView != null) {
            AopUtil.getScreenNameAndTitleFromFragment(jSONObject, fragmentFromView, activityFromContext);
            if (snapInfo == null || snapInfo.hasFragment) {
                return jSONObject;
            }
            snapInfo.hasFragment = true;
            return jSONObject;
        }
        JSONObject buildTitleAndScreenName = AopUtil.buildTitleAndScreenName(activityFromContext);
        mergeRnScreenNameAndTitle(buildTitleAndScreenName, view);
        return buildTitleAndScreenName;
    }

    public static void mergeRnScreenNameAndTitle(JSONObject jSONObject) {
        mergeRnScreenNameAndTitle(jSONObject, (View) null);
    }

    public static void mergeRnScreenNameAndTitle(JSONObject jSONObject, View view) {
        Object tag;
        try {
            String str = (String) ReflectUtil.callStaticMethod(ReflectUtil.getCurrentClass(new String[]{"com.sensorsdata.analytics.utils.RNViewUtils"}), "getVisualizeProperties", new Object[0]);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                if (view == null || !jSONObject2.optBoolean("isSetRNViewTag", false) || ((tag = view.getTag(R.id.sensors_analytics_tag_view_rn_key)) != null && ((Boolean) tag).booleanValue())) {
                    String optString = jSONObject2.optString(AopConstants.SCREEN_NAME);
                    String optString2 = jSONObject2.optString(AopConstants.TITLE);
                    if (jSONObject.has(AopConstants.SCREEN_NAME)) {
                        jSONObject.put(AopConstants.SCREEN_NAME, optString);
                    }
                    if (jSONObject.has(AopConstants.TITLE)) {
                        jSONObject.put(AopConstants.TITLE, optString2);
                    }
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
