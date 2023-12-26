package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.databinding.ShopPriceInfoDialogLayoutBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/PriceInfoDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopPriceInfoDialogLayoutBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setText", "", "str", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PriceInfoDialog.kt */
public final class PriceInfoDialog extends BaseBindDialog<ShopPriceInfoDialogLayoutBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PriceInfoDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        gravity(80);
        animType(BaseDialog.AnimInType.BOTTOM);
        this.binding.dialogClose.setOnClickListener(new PriceInfoDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: protected */
    public ShopPriceInfoDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopPriceInfoDialogLayoutBinding inflate = ShopPriceInfoDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m303_init_$lambda1(PriceInfoDialog priceInfoDialog, View view) {
        Intrinsics.checkNotNullParameter(priceInfoDialog, "this$0");
        priceInfoDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setText(String str) {
        this.binding.priceDiscText.setText(str);
    }
}
