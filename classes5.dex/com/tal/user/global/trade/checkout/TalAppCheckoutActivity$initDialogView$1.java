package com.tal.user.global.trade.checkout;

import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalAppCheckoutActivity.kt */
final class TalAppCheckoutActivity$initDialogView$1 extends Lambda implements Function1<ImageView, Unit> {
    final /* synthetic */ TalAppCheckoutActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TalAppCheckoutActivity$initDialogView$1(TalAppCheckoutActivity talAppCheckoutActivity) {
        super(1);
        this.this$0 = talAppCheckoutActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ImageView imageView) {
        BottomSheetDialog access$getTalAppAdyenCardDialog$p;
        BottomSheetDialog access$getTalAppAdyenCardDialog$p2;
        if (!this.this$0.isFinishing() && (access$getTalAppAdyenCardDialog$p = this.this$0.talAppAdyenCardDialog) != null && access$getTalAppAdyenCardDialog$p.isShowing() && (access$getTalAppAdyenCardDialog$p2 = this.this$0.talAppAdyenCardDialog) != null) {
            access$getTalAppAdyenCardDialog$p2.dismiss();
        }
    }
}
