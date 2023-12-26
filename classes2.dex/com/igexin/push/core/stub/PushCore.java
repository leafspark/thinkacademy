package com.igexin.push.core.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.c;
import com.igexin.push.core.f.a;
import com.igexin.push.core.f.b;
import com.igexin.sdk.IPushCore;
import java.util.HashMap;
import java.util.Map;

public class PushCore implements IPushCore {
    private c a;
    private Map<Activity, a> b = new HashMap();

    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        a aVar = this.b.get(activity);
        return aVar != null && aVar.a(menu);
    }

    public void onActivityDestroy(Activity activity) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.h();
            this.b.remove(activity);
            b.a().c(aVar);
        }
    }

    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        a aVar = this.b.get(activity);
        return aVar != null && aVar.a(i, keyEvent);
    }

    public void onActivityNewIntent(Activity activity, Intent intent) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.a(intent);
        }
    }

    public void onActivityPause(Activity activity) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.f();
        }
    }

    public void onActivityRestart(Activity activity) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.d();
        }
    }

    public void onActivityResume(Activity activity) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.e();
        }
    }

    public void onActivityStart(Activity activity, Intent intent) {
        if (activity != null && intent != null && intent.hasExtra("activityid")) {
            a a2 = b.a().a(Long.valueOf(intent.getLongExtra("activityid", 0)));
            if (a2 != null) {
                a2.a(activity);
                this.b.put(activity, a2);
                a2.c();
                return;
            }
            activity.finish();
        }
    }

    public void onActivityStop(Activity activity) {
        a aVar = this.b.get(activity);
        if (aVar != null) {
            aVar.g();
        }
    }

    public IBinder onServiceBind(Intent intent) {
        return null;
    }

    public void onServiceDestroy() {
    }

    public int onServiceStartCommand(Intent intent, int i, int i2) {
        if (this.a == null) {
            return 2;
        }
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.f;
        obtain.obj = intent;
        this.a.a(obtain);
        return 2;
    }

    public boolean start(Context context) {
        c a2 = c.a();
        this.a = a2;
        a2.a(context);
        return true;
    }
}
