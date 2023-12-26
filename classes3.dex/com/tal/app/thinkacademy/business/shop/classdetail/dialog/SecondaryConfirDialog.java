package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogSecondaryConfirBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/SecondaryConfirDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/BusShopDialogSecondaryConfirBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondaryConfirDialog.kt */
public final class SecondaryConfirDialog extends BaseBindDialog<BusShopDialogSecondaryConfirBinding> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SecondaryConfirDialog(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecondaryConfirDialog(Context context, final Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        layoutParams(new ViewGroup.LayoutParams(-1, -1));
        dimAmount(0.0f);
        canceledOnTouchOutside(false);
        TextView textView = this.binding.tvContinue;
        if (textView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(textView, 300, new Function0<Unit>(this) {
                final /* synthetic */ SecondaryConfirDialog this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.dismiss();
                    Function0<Unit> function0 = function0;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
        TextView textView2 = this.binding.tvCancel;
        if (textView2 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(textView2, 300, new Function0<Unit>(this) {
                final /* synthetic */ SecondaryConfirDialog this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public BusShopDialogSecondaryConfirBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BusShopDialogSecondaryConfirBinding inflate = BusShopDialogSecondaryConfirBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
