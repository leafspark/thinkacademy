package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class SensorsDataActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private final Set<SAActivityLifecycleCallbacks> mActivityCallbacks = new HashSet();

    public interface SAActivityLifecycleCallbacks extends Application.ActivityLifecycleCallbacks {
        void onNewIntent(Intent intent);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (SAActivityLifecycleCallbacks onActivityCreated : this.mActivityCallbacks) {
            try {
                onActivityCreated.onActivityCreated(activity, bundle);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        for (SAActivityLifecycleCallbacks onActivityStarted : this.mActivityCallbacks) {
            try {
                onActivityStarted.onActivityStarted(activity);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        for (SAActivityLifecycleCallbacks onActivityResumed : this.mActivityCallbacks) {
            try {
                onActivityResumed.onActivityResumed(activity);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        for (SAActivityLifecycleCallbacks onActivityPaused : this.mActivityCallbacks) {
            try {
                onActivityPaused.onActivityPaused(activity);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        for (SAActivityLifecycleCallbacks onActivityStopped : this.mActivityCallbacks) {
            try {
                onActivityStopped.onActivityStopped(activity);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (SAActivityLifecycleCallbacks onActivitySaveInstanceState : this.mActivityCallbacks) {
            try {
                onActivitySaveInstanceState.onActivitySaveInstanceState(activity, bundle);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (SAActivityLifecycleCallbacks onActivityDestroyed : this.mActivityCallbacks) {
            try {
                onActivityDestroyed.onActivityDestroyed(activity);
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void addActivityLifecycleCallbacks(SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mActivityCallbacks.add(sAActivityLifecycleCallbacks);
    }
}
