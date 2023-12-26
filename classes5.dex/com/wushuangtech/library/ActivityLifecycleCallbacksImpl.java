package com.wushuangtech.library;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityLifecycleCallbacksImpl";
    private int mActivityNum = 0;
    private WeakReference<Activity> mTopActivity;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    ActivityLifecycleCallbacksImpl() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResumed(android.app.Activity r5) {
        /*
            r4 = this;
            int r0 = r4.mActivityNum
            r1 = 1
            int r0 = r0 + r1
            r4.mActivityNum = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Activity changed, resume: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r2 = " | num: "
            r0.append(r2)
            int r2 = r4.mActivityNum
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ActivityLifecycleCallbacksImpl"
            com.wushuangtech.utils.OmniLog.i(r2, r0)
            java.lang.ref.WeakReference<android.app.Activity> r0 = r4.mTopActivity
            r2 = 0
            if (r0 != 0) goto L_0x0034
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r5)
            r4.mTopActivity = r0
        L_0x0032:
            r0 = r1
            goto L_0x004f
        L_0x0034:
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 != 0) goto L_0x0044
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r5)
            r4.mTopActivity = r0
            goto L_0x0032
        L_0x0044:
            if (r0 == r5) goto L_0x004e
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r5)
            r4.mTopActivity = r0
            goto L_0x0032
        L_0x004e:
            r0 = r2
        L_0x004f:
            if (r0 == 0) goto L_0x005e
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            r3 = 20
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r5
            r0.sendSyncGlobalMessage(r3, r1)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.ActivityLifecycleCallbacksImpl.onActivityResumed(android.app.Activity):void");
    }

    public void onActivityStopped(Activity activity) {
        this.mActivityNum--;
        OmniLog.i(TAG, "Activity changed, stop: " + activity + " | num: " + this.mActivityNum);
    }
}
