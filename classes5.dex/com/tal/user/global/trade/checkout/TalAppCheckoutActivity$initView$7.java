package com.tal.user.global.trade.checkout;

import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initView$7 extends Lambda implements Function1<TextView, Unit> {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TalAppCheckoutActivity$initView$7(TalAppCheckoutActivity talAppCheckoutActivity) {
        super(1);
        this.this$0 = talAppCheckoutActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "it");
        LinearLayout linearLayout = TalAppCheckoutActivity.access$getBinding$p(this.this$0).llwxGotoPay;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llwxGotoPay");
        linearLayout.setVisibility(8);
        TextView textView2 = TalAppCheckoutActivity.access$getBinding$p(this.this$0).tvTalTradeWebViewCloseIcon;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTalTradeWebViewCloseIcon");
        textView2.setVisibility(8);
    }
}
