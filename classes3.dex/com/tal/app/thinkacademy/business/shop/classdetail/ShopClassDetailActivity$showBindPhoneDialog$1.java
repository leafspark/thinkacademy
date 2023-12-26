package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailViewModel;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.PhoneEmailBindState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/PhoneEmailBindState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
final class ShopClassDetailActivity$showBindPhoneDialog$1 extends Lambda implements Function1<PhoneEmailBindState, Unit> {
    final /* synthetic */ ShopClassDetailActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhoneEmailBindState.values().length];
            iArr[PhoneEmailBindState.BACK.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailActivity$showBindPhoneDialog$1(ShopClassDetailActivity shopClassDetailActivity) {
        super(1);
        this.this$0 = shopClassDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PhoneEmailBindState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PhoneEmailBindState phoneEmailBindState) {
        Intrinsics.checkNotNullParameter(phoneEmailBindState, "it");
        if (WhenMappings.$EnumSwitchMapping$0[phoneEmailBindState.ordinal()] == 1) {
            this.this$0.showLinkNumberDialog();
        } else if (this.this$0.mBtnBuyState != ShopClassDetailViewModel.DetailBuySate.Full) {
            this.this$0.gotoOrderPage();
        }
    }
}
