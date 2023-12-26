package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/shop/ShopHomeNativeFragment$mAppOnBackCallback$1", "Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager$FrontBackCallback;", "onChanged", "", "front", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
public final class ShopHomeNativeFragment$mAppOnBackCallback$1 implements XesActivityManager.FrontBackCallback {
    final /* synthetic */ ShopHomeNativeFragment this$0;

    ShopHomeNativeFragment$mAppOnBackCallback$1(ShopHomeNativeFragment shopHomeNativeFragment) {
        this.this$0 = shopHomeNativeFragment;
    }

    public void onChanged(boolean z) {
        if (z) {
            XesLog.it(this.this$0.TAG, new Object[]{"App回到前台"});
            if (this.this$0.isSelect) {
                this.this$0.enterMallModule();
                return;
            }
            return;
        }
        XesLog.it(this.this$0.TAG, new Object[]{"App退到后台"});
        if (this.this$0.isSelect) {
            this.this$0.leaveMallModule();
        }
    }
}
