package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.sensorsdata.analytics.android.sdk.visual.ViewTreeStatusObservable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class AppStateManager implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "AppStateManager";
    private static volatile AppStateManager mSingleton;
    private String mCurrentFragmentName = null;
    private int mCurrentRootWindowsHashCode = -1;
    private WeakReference<Activity> mForeGroundActivity = new WeakReference<>((Object) null);

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    private AppStateManager() {
    }

    public static AppStateManager getInstance() {
        if (mSingleton == null) {
            synchronized (AppStateManager.class) {
                if (mSingleton == null) {
                    mSingleton = new AppStateManager();
                }
            }
        }
        return mSingleton;
    }

    public Activity getForegroundActivity() {
        return (Activity) this.mForeGroundActivity.get();
    }

    private void setForegroundActivity(Activity activity) {
        this.mForeGroundActivity = new WeakReference<>(activity);
    }

    public void setFragmentScreenName(Object obj, String str) {
        try {
            Method method = obj.getClass().getMethod("getParentFragment", new Class[0]);
            if (method == null) {
                return;
            }
            if (method.invoke(obj, new Object[0]) == null) {
                this.mCurrentFragmentName = str;
                SALog.i(TAG, "setFragmentScreenName | " + str + " is not nested fragment and set");
                return;
            }
            SALog.i(TAG, "setFragmentScreenName | " + str + " is nested fragment and ignored");
        } catch (Exception unused) {
        }
    }

    public String getFragmentScreenName() {
        return this.mCurrentFragmentName;
    }

    public int getCurrentRootWindowsHashCode() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Window window;
        if (!(this.mCurrentRootWindowsHashCode != -1 || (weakReference = this.mForeGroundActivity) == null || weakReference.get() == null || (activity = (Activity) this.mForeGroundActivity.get()) == null || (window = activity.getWindow()) == null || !window.isActive())) {
            this.mCurrentRootWindowsHashCode = window.getDecorView().hashCode();
        }
        return this.mCurrentRootWindowsHashCode;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        setForegroundActivity(activity);
        if (!activity.isChild()) {
            this.mCurrentRootWindowsHashCode = -1;
        }
    }

    public void onActivityResumed(Activity activity) {
        setForegroundActivity(activity);
        Window window = activity.getWindow();
        View decorView = (window == null || !window.isActive()) ? null : window.getDecorView();
        if (SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled() && Build.VERSION.SDK_INT >= 16 && decorView != null) {
            monitorViewTreeChange(decorView);
        }
        if (!activity.isChild() && decorView != null) {
            this.mCurrentRootWindowsHashCode = decorView.hashCode();
        }
    }

    public void onActivityPaused(Activity activity) {
        Window window;
        if (Build.VERSION.SDK_INT >= 16 && (window = activity.getWindow()) != null && window.isActive()) {
            unRegisterViewTreeChange(window.getDecorView());
        }
        if (!activity.isChild()) {
            this.mCurrentRootWindowsHashCode = -1;
        }
    }

    public void onActivityDestroyed(Activity activity) {
        ViewTreeStatusObservable.getInstance().clearWebViewCache();
    }

    private void unRegisterViewTreeChange(View view) {
        try {
            if (view.getTag(R.id.sensors_analytics_tag_view_tree_observer_listeners) != null) {
                ViewTreeStatusObservable instance = ViewTreeStatusObservable.getInstance();
                if (Build.VERSION.SDK_INT < 16) {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(instance);
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(instance);
                }
                view.getViewTreeObserver().removeOnGlobalFocusChangeListener(instance);
                view.getViewTreeObserver().removeOnScrollChangedListener(instance);
                view.setTag(R.id.sensors_analytics_tag_view_tree_observer_listeners, (Object) null);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    private void monitorViewTreeChange(View view) {
        try {
            if (view.getTag(R.id.sensors_analytics_tag_view_tree_observer_listeners) == null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(ViewTreeStatusObservable.getInstance());
                view.getViewTreeObserver().addOnScrollChangedListener(ViewTreeStatusObservable.getInstance());
                view.getViewTreeObserver().addOnGlobalFocusChangeListener(ViewTreeStatusObservable.getInstance());
                view.setTag(R.id.sensors_analytics_tag_view_tree_observer_listeners, true);
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }
}
