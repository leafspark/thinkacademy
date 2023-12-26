package com.tal.user.global.trade.checkout;

import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tal.user.global.trade.base.TalTradeLoadingDialog;
import com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initData$1<T> implements Observer<Integer> {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    TalAppCheckoutActivity$initData$1(TalAppCheckoutActivity talAppCheckoutActivity) {
        this.this$0 = talAppCheckoutActivity;
    }

    public final void onChanged(Integer num) {
        BottomSheetDialog access$getTalAppAdyenCardDialog$p;
        BottomSheetDialog access$getTalAppAdyenCardDialog$p2;
        BottomSheetDialog access$getTalAppAdyenCardDialog$p3;
        BottomSheetDialog access$getTalAppAdyenCardDialog$p4;
        if (num != null && num.intValue() == 1) {
            TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScPaying;
            Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout, "binding.rlScPaying");
            if (talTradeSecondaryConfirmationLayout.getVisibility() == 0) {
                TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout2 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScPaying;
                Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout2, "binding.rlScPaying");
                talTradeSecondaryConfirmationLayout2.setVisibility(8);
            }
            if (!this.this$0.isFinishing() && (access$getTalAppAdyenCardDialog$p3 = this.this$0.talAppAdyenCardDialog) != null && access$getTalAppAdyenCardDialog$p3.isShowing() && (access$getTalAppAdyenCardDialog$p4 = this.this$0.talAppAdyenCardDialog) != null) {
                access$getTalAppAdyenCardDialog$p4.dismiss();
            }
            TalTradeLoadingDialog talTradeLoadingDialog = (TalTradeLoadingDialog) TalAppCheckoutActivity.access$getViewModel$p(this.this$0).getTalTradeLoadingDialog().getValue();
            if (talTradeLoadingDialog != null && talTradeLoadingDialog.isShowing()) {
                TalAppCheckoutActivity.access$getViewModel$p(this.this$0).dismissProgressDialog();
            }
            this.this$0.payOrderSuccess();
        } else if (num != null && num.intValue() == 2) {
            this.this$0.cancelTime();
            this.this$0.setSystemCancel(true);
            TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout3 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScFail;
            Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout3, "binding.rlScFail");
            talTradeSecondaryConfirmationLayout3.setVisibility(0);
        } else if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4)) {
            this.this$0.cancelTime();
            this.this$0.setSystemCancel(true);
            this.this$0.startTimeOutViewTime = System.currentTimeMillis();
            TalAppCheckoutActivity.access$getBinding$p(this.this$0).tvTalTradeGoodsTimmer.cancleCountDown();
            TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout4 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScTimeout;
            Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout4, "binding.rlScTimeout");
            talTradeSecondaryConfirmationLayout4.setVisibility(0);
        } else if (num != null && num.intValue() == 5) {
            TalTradeLoadingDialog talTradeLoadingDialog2 = (TalTradeLoadingDialog) TalAppCheckoutActivity.access$getViewModel$p(this.this$0).getTalTradeLoadingDialog().getValue();
            if (talTradeLoadingDialog2 == null || talTradeLoadingDialog2.isShowing()) {
                TalAppCheckoutActivity talAppCheckoutActivity = this.this$0;
                talAppCheckoutActivity.setCountLoding(talAppCheckoutActivity.getCountLoding() + 1);
                if (this.this$0.getCountLoding() > 2) {
                    this.this$0.setCountLoding(0);
                    this.this$0.setSystemCancel(true);
                    TalAppCheckoutActivity.access$getViewModel$p(this.this$0).dismissProgressDialog();
                    this.this$0.cancelTime();
                    TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout5 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScPaying;
                    Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout5, "binding.rlScPaying");
                    talTradeSecondaryConfirmationLayout5.setVisibility(0);
                    return;
                }
                return;
            }
            this.this$0.cancelTime();
            this.this$0.setSystemCancel(true);
            TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout6 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScPaying;
            Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout6, "binding.rlScPaying");
            talTradeSecondaryConfirmationLayout6.setVisibility(0);
        } else if (num == null || num.intValue() != 99) {
            TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout7 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).rlScPaying;
            Intrinsics.checkNotNullExpressionValue(talTradeSecondaryConfirmationLayout7, "binding.rlScPaying");
            talTradeSecondaryConfirmationLayout7.setVisibility(8);
            TalAppCheckoutActivity.access$getViewModel$p(this.this$0).dismissProgressDialog();
        } else if (!this.this$0.isFinishing() && (access$getTalAppAdyenCardDialog$p = this.this$0.talAppAdyenCardDialog) != null && access$getTalAppAdyenCardDialog$p.isShowing() && (access$getTalAppAdyenCardDialog$p2 = this.this$0.talAppAdyenCardDialog) != null) {
            access$getTalAppAdyenCardDialog$p2.dismiss();
        }
    }
}
