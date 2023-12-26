package com.tal.app.thinkacademy.lib.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesStatusBar;", "", "()V", "setStatusBar", "", "activity", "Landroid/app/Activity;", "darkContent", "", "statusBarColor", "", "translucent", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesStatusBar.kt */
public final class XesStatusBar {
    public static final XesStatusBar INSTANCE = new XesStatusBar();

    private XesStatusBar() {
    }

    public static /* synthetic */ void setStatusBar$default(XesStatusBar xesStatusBar, Activity activity, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        xesStatusBar.setStatusBar(activity, z, i, z2);
    }

    public final void setStatusBar(Activity activity, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        int systemUiVisibility = decorView.getSystemUiVisibility();
        XesLog.dt("XesStatusBar", Intrinsics.stringPlus("visibility = ", Integer.valueOf(systemUiVisibility)));
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(i);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            systemUiVisibility = z ? systemUiVisibility | 8192 : systemUiVisibility & -8193;
        }
        if (z2) {
            systemUiVisibility = systemUiVisibility | 1024 | 256;
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }
}
