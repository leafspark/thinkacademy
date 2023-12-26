package com.sensorsdata.analytics.android.sdk.autotrack;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.sensorsdata.analytics.android.sdk.AopConstants;
import com.sensorsdata.analytics.android.sdk.AppStateManager;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.WeakSet;
import java.util.Set;
import org.json.JSONObject;

public class FragmentViewScreenCallbacks implements SAFragmentLifecycleCallbacks {
    private static final String TAG = "SA.FragmentViewScreenCallbacks";
    private final Set<Object> mPageFragments = new WeakSet();

    public void onCreate(Object obj) {
    }

    public void onStart(Object obj) {
    }

    public void onStop(Object obj) {
    }

    public void onViewCreated(Object obj, View view, Bundle bundle) {
        Window window;
        try {
            String name = obj.getClass().getName();
            view.setTag(R.id.sensors_analytics_tag_view_fragment_name, name);
            if (view instanceof ViewGroup) {
                traverseView(name, (ViewGroup) view);
            }
            Activity activityFromContext = AopUtil.getActivityFromContext(view.getContext(), view);
            if (activityFromContext != null && (window = activityFromContext.getWindow()) != null && window.isActive()) {
                window.getDecorView().getRootView().setTag(R.id.sensors_analytics_tag_view_fragment_name, "");
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void onResume(Object obj) {
        try {
            if (isFragmentValid(obj)) {
                trackFragmentAppViewScreen(obj);
                this.mPageFragments.add(obj);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void onPause(Object obj) {
        if (obj != null) {
            this.mPageFragments.remove(obj);
        }
    }

    public void onHiddenChanged(Object obj, boolean z) {
        if (obj == null) {
            try {
                SALog.d(TAG, "fragment is null,return");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        } else if (z) {
            this.mPageFragments.remove(obj);
            SALog.d(TAG, "fragment hidden is true,return");
        } else if (isFragmentValid(obj)) {
            trackFragmentAppViewScreen(obj);
            this.mPageFragments.add(obj);
        }
    }

    public void setUserVisibleHint(Object obj, boolean z) {
        if (obj == null) {
            try {
                SALog.d(TAG, "object is null");
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        } else if (!z) {
            this.mPageFragments.remove(obj);
            SALog.d(TAG, "fragment isVisibleToUser is false,return");
        } else if (isFragmentValid(obj)) {
            trackFragmentAppViewScreen(obj);
            this.mPageFragments.add(obj);
        }
    }

    private void trackFragmentAppViewScreen(Object obj) {
        JSONObject trackProperties;
        try {
            JSONObject jSONObject = new JSONObject();
            AopUtil.getScreenNameAndTitleFromFragment(jSONObject, obj, (Activity) null);
            AppStateManager.getInstance().setFragmentScreenName(obj, jSONObject.optString(AopConstants.SCREEN_NAME));
            if ((obj instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) obj).getTrackProperties()) != null) {
                SensorsDataUtils.mergeJSONObject(trackProperties, jSONObject);
            }
            SensorsDataAPI.sharedInstance().trackViewScreen(SensorsDataUtils.getScreenUrl(obj), SADataHelper.appendLibMethodAutoTrack(jSONObject));
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private boolean isFragmentValid(Object obj) {
        if (obj == null) {
            SALog.d(TAG, "fragment is null,return");
            return false;
        } else if (SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
            SALog.d(TAG, "AutoTrackEventTypeIgnored,return");
            return false;
        } else if (!SensorsDataAPI.sharedInstance().isTrackFragmentAppViewScreenEnabled()) {
            SALog.d(TAG, "TrackFragmentAppViewScreenEnabled is false,return");
            return false;
        } else if ("com.bumptech.glide.manager.SupportRequestManagerFragment".equals(obj.getClass().getCanonicalName())) {
            SALog.d(TAG, "fragment is SupportRequestManagerFragment,return");
            return false;
        } else if (!SensorsDataAPI.sharedInstance().isFragmentAutoTrackAppViewScreen(obj.getClass())) {
            SALog.d(TAG, "fragment class ignored,return");
            return false;
        } else if (this.mPageFragments.contains(obj)) {
            SALog.d(TAG, "pageFragment contains,return");
            return false;
        } else if (SAFragmentUtils.isFragmentVisible(obj)) {
            return true;
        } else {
            SALog.d(TAG, "fragment is not visible,return");
            return false;
        }
    }

    private static void traverseView(String str, ViewGroup viewGroup) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    childAt.setTag(R.id.sensors_analytics_tag_view_fragment_name, str);
                    if ((childAt instanceof ViewGroup) && !(childAt instanceof ListView) && !(childAt instanceof GridView) && !(childAt instanceof Spinner) && !(childAt instanceof RadioGroup)) {
                        traverseView(str, (ViewGroup) childAt);
                    }
                }
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
