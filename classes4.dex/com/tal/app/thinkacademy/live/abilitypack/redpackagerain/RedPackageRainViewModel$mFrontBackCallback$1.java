package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.live.Tag;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$mFrontBackCallback$1", "Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager$FrontBackCallback;", "onChanged", "", "front", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainViewModel.kt */
public final class RedPackageRainViewModel$mFrontBackCallback$1 implements XesActivityManager.FrontBackCallback {
    final /* synthetic */ RedPackageRainViewModel this$0;

    RedPackageRainViewModel$mFrontBackCallback$1(RedPackageRainViewModel redPackageRainViewModel) {
        this.this$0 = redPackageRainViewModel;
    }

    public void onChanged(boolean z) {
        this.this$0.mIsFront = Boolean.valueOf(z);
        if (z) {
            XesLog.i(Tag.RED_PACKAGE_RAIN, "回到前台");
            String access$getMMsg$p = this.this$0.mMsg;
            if (access$getMMsg$p != null) {
                RedPackageRainViewModel redPackageRainViewModel = this.this$0;
                redPackageRainViewModel.onReceiveRedPackageRainMessage(access$getMMsg$p, true);
                redPackageRainViewModel.mMsg = null;
                return;
            }
            return;
        }
        XesLog.i(Tag.RED_PACKAGE_RAIN, "退到后台");
    }
}
