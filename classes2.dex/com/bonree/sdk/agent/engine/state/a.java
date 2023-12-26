package com.bonree.sdk.agent.engine.state;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;

public final class a extends f implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private String a;

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    /* access modifiers changed from: protected */
    public final void register() {
        if (this.services.size() == 1 || !this.isRegisterSuccessful) {
            try {
                com.bonree.sdk.be.a.a().c("AndroidAppStateEngine is start.", new Object[0]);
                Application application = (Application) com.bonree.sdk.bs.a.a();
                if (application != null) {
                    application.registerComponentCallbacks(this);
                    application.registerActivityLifecycleCallbacks(this);
                    this.isRegisterSuccessful = true;
                }
            } catch (Throwable th) {
                com.bonree.sdk.be.a.a().a("AndroidAppStateEngine is start error ; ", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void unRegister() {
        if (isEmptyServices()) {
            com.bonree.sdk.be.a.a().c("AndroidAppStateEngine is stop.", new Object[0]);
            Context a2 = com.bonree.sdk.bs.a.a();
            if (a2 != null) {
                a2.unregisterComponentCallbacks(this);
                ((Application) a2).unregisterActivityLifecycleCallbacks(this);
            }
            this.isRegisterSuccessful = false;
        }
    }

    public final void setViewName(Object obj) {
        if (obj != null && (obj instanceof Activity)) {
            this.mViewName = obj.getClass().getName();
        }
    }

    public final String getViewName() {
        return this.mViewName;
    }

    public final void onActivityStarted(Activity activity) {
        this.activeActivityCount.incrementAndGet();
        if (this.mHappenBackground) {
            this.mHappenBackground = false;
            notifyService(e.FOREGROUND);
        }
    }

    public final void onActivityResumed(Activity activity) {
        setViewName(activity);
        this.a = com.bonree.sdk.z.a.n;
    }

    public final void onTrimMemory(int i) {
        com.bonree.sdk.be.a.a().c("trim memory: %d, background: %b", Integer.valueOf(i), Boolean.valueOf(this.mHappenBackground));
        if (!TextUtils.equals(this.a, com.bonree.sdk.z.a.n) && i == 20) {
            this.activeActivityCount.set(0);
            if (!this.mHappenBackground) {
                this.mHappenBackground = true;
                notifyService(e.BACKGROUND);
            }
        }
    }

    public final void onActivityStopped(Activity activity) {
        int decrementAndGet = this.activeActivityCount.get() > 0 ? this.activeActivityCount.decrementAndGet() : 0;
        if (!this.mHappenBackground && decrementAndGet == 0) {
            this.mHappenBackground = true;
            notifyService(e.BACKGROUND);
            this.activeActivityCount.set(0);
        }
    }

    public final void onActivityPaused(Activity activity) {
        this.a = com.bonree.sdk.z.a.p;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        setViewName(activity);
    }
}
