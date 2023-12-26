package com.tal.user.global.trade.checkout;

import android.widget.TextView;
import com.tal.user.global.trade.listener.TalTradePayClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initDialogView$2 extends Lambda implements Function1<TextView, Unit> {
    final /* synthetic */ TalTradePayClickListener $talTradePayClickListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TalAppCheckoutActivity$initDialogView$2(TalTradePayClickListener talTradePayClickListener) {
        super(1);
        this.$talTradePayClickListener = talTradePayClickListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextView textView) {
        this.$talTradePayClickListener.onClick();
    }
}
