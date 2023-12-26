package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
final class ShopHomeNativeFragment$showFullError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ShopHomeNativeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeFragment$showFullError$1(ShopHomeNativeFragment shopHomeNativeFragment) {
        super(0);
        this.this$0 = shopHomeNativeFragment;
    }

    public final void invoke() {
        this.this$0.showFullLoading();
        ShopHomeNativeVm access$getMViewModel = this.this$0.getMViewModel();
        if (access$getMViewModel != null) {
            access$getMViewModel.getChannelList();
        }
    }
}
