package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.ShopWheelAdapter;
import com.tal.app.thinkacademy.business.shop.databinding.ShopDialogWheelBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00128\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\u0017\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ShopWheelDialog;", "T", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopDialogWheelBinding;", "context", "Landroid/content/Context;", "listen", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "select", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/ShopWheelAdapter;", "mSelectPosition", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setCurrentIndex", "setData", "list", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopWheelDialog.kt */
public final class ShopWheelDialog<T> extends BaseBindDialog<ShopDialogWheelBinding> {
    private ShopWheelAdapter<T> mAdapter;
    private int mSelectPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopWheelDialog(Context context, Function2<? super Integer, ? super String, Unit> function2) {
        super(context);
        BaseDialog layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "listen");
        BaseDialog gravity = gravity(80);
        if (!(gravity == null || (layoutParams = gravity.layoutParams(new LinearLayout.LayoutParams(-1, -2))) == null)) {
            layoutParams.canceledOnTouchOutside(true);
        }
        this.binding.wheelView.setCyclic(false);
        this.binding.wheelView.setItemHeight(SizeUtils.dp2px(60.0f));
        this.binding.wheelView.setRoundRadius(SizeUtils.dp2px(30.0f));
        this.binding.wheelView.setTextColorCenter(ContextCompat.getColor(context, R.color.color_ffaa0a));
        this.binding.wheelView.setTextColorOut(ContextCompat.getColor(context, R.color.color_a2aab8));
        this.binding.wheelView.setDividerColor(ContextCompat.getColor(context, R.color.color_14ffaa0a));
        this.binding.wheelView.setDividerType(WheelView.DividerType.ROUND_RECT);
        this.mAdapter = new ShopWheelAdapter<>();
        this.binding.wheelView.setAdapter(this.mAdapter);
        this.binding.wheelView.setOnItemSelectedListener(new ShopWheelDialog$$ExternalSyntheticLambda2(this));
        this.binding.ivCancel.setOnClickListener(new ShopWheelDialog$$ExternalSyntheticLambda0(this));
        this.binding.ivConfirm.setOnClickListener(new ShopWheelDialog$$ExternalSyntheticLambda1(this, function2));
    }

    /* access modifiers changed from: protected */
    public ShopDialogWheelBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopDialogWheelBinding inflate = ShopDialogWheelBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m317_init_$lambda0(ShopWheelDialog shopWheelDialog, int i) {
        Intrinsics.checkNotNullParameter(shopWheelDialog, "this$0");
        shopWheelDialog.mSelectPosition = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m318_init_$lambda1(ShopWheelDialog shopWheelDialog, View view) {
        Intrinsics.checkNotNullParameter(shopWheelDialog, "this$0");
        shopWheelDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m319_init_$lambda2(ShopWheelDialog shopWheelDialog, Function2 function2, View view) {
        Intrinsics.checkNotNullParameter(shopWheelDialog, "this$0");
        Intrinsics.checkNotNullParameter(function2, "$listen");
        ShopWheelAdapter<T> shopWheelAdapter = shopWheelDialog.mAdapter;
        if ((shopWheelAdapter == null ? 0 : shopWheelAdapter.getItemsCount()) > 0) {
            Integer valueOf = Integer.valueOf(shopWheelDialog.mSelectPosition);
            ShopWheelAdapter<T> shopWheelAdapter2 = shopWheelDialog.mAdapter;
            function2.invoke(valueOf, shopWheelAdapter2 == null ? null : shopWheelAdapter2.getItem(shopWheelDialog.mSelectPosition));
        }
        shopWheelDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setData(List<? extends T> list) {
        ShopWheelAdapter<T> shopWheelAdapter = this.mAdapter;
        if (shopWheelAdapter != null) {
            shopWheelAdapter.setData(list);
        }
        this.binding.wheelView.setAdapter(this.mAdapter);
    }

    public final void setCurrentIndex(int i) {
        ShopWheelAdapter<T> shopWheelAdapter = this.mAdapter;
        if ((shopWheelAdapter == null ? 0 : shopWheelAdapter.getItemsCount()) > 0) {
            this.binding.wheelView.setCurrentItem(i);
        }
    }
}
