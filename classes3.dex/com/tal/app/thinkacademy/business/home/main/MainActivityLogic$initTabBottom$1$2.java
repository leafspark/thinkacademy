package com.tal.app.thinkacademy.business.home.main;

import android.view.ViewTreeObserver;
import com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/business/home/main/MainActivityLogic$initTabBottom$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainActivityLogic.kt */
public final class MainActivityLogic$initTabBottom$1$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ XesTabBottomLayout $this_run;
    final /* synthetic */ MainActivityLogic this$0;

    MainActivityLogic$initTabBottom$1$2(XesTabBottomLayout xesTabBottomLayout, MainActivityLogic mainActivityLogic) {
        this.$this_run = xesTabBottomLayout;
        this.this$0 = mainActivityLogic;
    }

    public void onGlobalLayout() {
        this.$this_run.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.this$0.mainDialogManager = new MainDialogManager((MainActivity) this.this$0.activityProvider);
        MainDialogManager access$getMainDialogManager$p = this.this$0.mainDialogManager;
        if (access$getMainDialogManager$p != null) {
            access$getMainDialogManager$p.startChain();
        }
    }
}
