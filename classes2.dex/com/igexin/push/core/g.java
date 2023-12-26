package com.igexin.push.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.b.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.util.c;
import com.igexin.sdk.PushConsts;

public class g implements Application.ActivityLifecycleCallbacks {
    private long a;
    private int b;

    private void a(Activity activity) {
        try {
            b.a("GALC|" + activity.getComponentName().getClassName() + " onAStart " + this.b, new Object[0]);
            if (this.b == 0) {
                Context applicationContext = activity.getApplicationContext();
                if (!c.a(applicationContext) && System.currentTimeMillis() - this.a > 20000) {
                    Intent intent = new Intent(applicationContext, e.a().a(applicationContext));
                    intent.putExtra("action", PushConsts.ACTION_SERVICE_ONRESUME);
                    x.a().a(applicationContext, intent);
                    b.a("GALC|on fg, start>>>>>>", new Object[0]);
                    this.a = System.currentTimeMillis();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            a(activity);
            this.b++;
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            int i = this.b - 1;
            this.b = i;
            this.b = Math.max(i, 0);
            b.a("GALC|" + activity.getComponentName().getClassName() + " onAStopp " + this.b, new Object[0]);
            if (this.b == 0) {
                b.a("GALC|>>>>>> on bg", new Object[0]);
            }
        }
    }
}
