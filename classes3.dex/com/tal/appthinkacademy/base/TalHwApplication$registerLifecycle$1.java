package com.tal.appthinkacademy.base;

import android.app.Activity;
import android.os.Bundle;
import com.tal.app.thinkacademy.business.home.main.LaunchActivity;
import com.tal.app.thinkacademy.business.home.main.MainActivity;
import com.tal.app.thinkacademy.business.home.main.push.PushCenter;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.appthinkacademy.Tag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/tal/appthinkacademy/base/TalHwApplication$registerLifecycle$1", "Lcom/tal/appthinkacademy/base/CustomActivityLifecycle;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityResumed", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalHwApplication.kt */
public final class TalHwApplication$registerLifecycle$1 extends CustomActivityLifecycle {
    TalHwApplication$registerLifecycle$1() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        XesLog.i(Tag.APPLICATION, new Object[]{Intrinsics.stringPlus("onActivityCreated ", activity.getLocalClassName())});
        if (activity instanceof MainActivity) {
            PushCenter.Companion.get().setMainAlive(true);
            PushCenter.Companion.get().consume();
        }
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        XesLog.i(Tag.APPLICATION, new Object[]{Intrinsics.stringPlus("onActivityResumed ", activity.getLocalClassName())});
        if (!(activity instanceof LaunchActivity)) {
            PushCenter.Companion.get().consume();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        XesLog.i(Tag.APPLICATION, new Object[]{Intrinsics.stringPlus("onActivityDestroyed ", activity.getLocalClassName())});
        if (activity instanceof MainActivity) {
            PushCenter.Companion.get().setMainAlive(false);
        }
    }
}
