package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ReminderTwoButton;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ReminderTwoButton$ButtonType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
final class ShopClassDetailActivity$showCancelStudFollowDialog$1 extends Lambda implements Function1<ReminderTwoButton.ButtonType, Unit> {
    final /* synthetic */ ShopClassDetailActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReminderTwoButton.ButtonType.values().length];
            iArr[ReminderTwoButton.ButtonType.BUTTON_LEFT.ordinal()] = 1;
            iArr[ReminderTwoButton.ButtonType.BUTTON_RIGHT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailActivity$showCancelStudFollowDialog$1(ShopClassDetailActivity shopClassDetailActivity) {
        super(1);
        this.this$0 = shopClassDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ReminderTwoButton.ButtonType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ReminderTwoButton.ButtonType buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[buttonType.ordinal()];
        if (i == 1) {
            ShopTrack.INSTANCE.hw_classdetal_cancel_cancel_click(this.this$0.mClassId);
        } else if (i == 2) {
            this.this$0.showLoading();
            this.this$0.getMViewModel().requestStuFollowCancel(this.this$0.mSkuId);
            ShopTrack.INSTANCE.hw_classdetal_cancel_confirm_click(this.this$0.mClassId);
        }
    }
}
