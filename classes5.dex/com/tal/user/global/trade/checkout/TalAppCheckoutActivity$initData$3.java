package com.tal.user.global.trade.checkout;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tal.user.global.trade.entity.PayInfoEntity;
import com.tal.user.global.trade.listener.TalTradeWebviewListener;
import com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/user/global/trade/entity/PayInfoEntity;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initData$3<T> implements Observer<PayInfoEntity> {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    TalAppCheckoutActivity$initData$3(TalAppCheckoutActivity talAppCheckoutActivity) {
        this.this$0 = talAppCheckoutActivity;
    }

    public final void onChanged(PayInfoEntity payInfoEntity) {
        if (payInfoEntity != null) {
            LinearLayout linearLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0).llwxGotoPay;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llwxGotoPay");
            linearLayout.setVisibility(0);
            TalAppCheckoutActivity.access$getBinding$p(this.this$0).wvGotoPay.setTalTradeWebviewListener(new TalTradeWebviewListener(this) {
                final /* synthetic */ TalAppCheckoutActivity$initData$3 this$0;

                {
                    this.this$0 = r1;
                }

                public void webviewPayBack() {
                    LinearLayout linearLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0.this$0).llwxGotoPay;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llwxGotoPay");
                    linearLayout.setVisibility(8);
                }

                public void webviewPaSuccess() {
                    LinearLayout linearLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0.this$0).llwxGotoPay;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llwxGotoPay");
                    linearLayout.setVisibility(8);
                }

                public void webviewPageError() {
                    TextView textView = TalAppCheckoutActivity.access$getBinding$p(this.this$0.this$0).tvTalTradeWebViewCloseIcon;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTalTradeWebViewCloseIcon");
                    textView.setVisibility(0);
                }
            });
            TalTradeCommentWebViewWithPay talTradeCommentWebViewWithPay = TalAppCheckoutActivity.access$getBinding$p(this.this$0).wvGotoPay;
            Intrinsics.checkNotNullExpressionValue(talTradeCommentWebViewWithPay, "binding.wvGotoPay");
            talTradeCommentWebViewWithPay.setUrl(payInfoEntity.getPayData());
        }
    }
}
