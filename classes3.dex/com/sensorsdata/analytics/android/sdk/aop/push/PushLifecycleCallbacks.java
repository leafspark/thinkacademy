package com.sensorsdata.analytics.android.sdk.aop.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataActivityLifecycleCallbacks;

public class PushLifecycleCallbacks implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        PushProcess.getInstance().onNotificationClick(activity, activity.getIntent());
    }

    public void onActivityStarted(Activity activity) {
        PushProcess.getInstance().onNotificationClick(activity, activity.getIntent());
    }
}
