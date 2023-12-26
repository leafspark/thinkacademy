package com.tal.app.thinkacademy.business.login.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.DialogWheelBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007J\u0014\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/login/databinding/DialogWheelBinding;", "context", "Landroid/content/Context;", "confirmBlock", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "cancelBlock", "Lkotlin/Function0;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "mCurrentIndex", "mScale", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "getCurrentItem", "setCurrentItem", "setWheelAdapter", "adapter", "Lcom/tal/app/thinkacademy/lib/commui/wheel/adapter/WheelAdapter;", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WheelDialog.kt */
public class WheelDialog extends BaseBindDialog<DialogWheelBinding> {
    private int mCurrentIndex;
    private final float mScale;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WheelDialog(Context context, Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1, (i & 4) != 0 ? null : function0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WheelDialog(Context context, Function1<? super Integer, Unit> function1, Function0<Unit> function0) {
        super(context);
        LinearLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScale = 0.7f;
        BaseDialog gravity = gravity(80);
        if (PadAutoUtil.isAdaptPad()) {
            layoutParams = new LinearLayout.LayoutParams((int) (((float) ScreenUtils.getScreenWidth()) * 0.7f), -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        gravity.layoutParams(layoutParams).canceledOnTouchOutside(true);
        this.binding.wheelView.setCyclic(false);
        this.binding.wheelView.setItemHeight(SizeUtils.dp2px(60.0f));
        this.binding.wheelView.setRoundRadius(SizeUtils.dp2px(30.0f));
        this.binding.wheelView.setTextColorCenter(ContextCompat.getColor(context, R.color.color_ffaa0a));
        this.binding.wheelView.setTextColorOut(ContextCompat.getColor(context, R.color.color_a2aab8));
        this.binding.wheelView.setDividerColor(ContextCompat.getColor(context, R.color.color_14ffaa0a));
        this.binding.wheelView.setDividerType(WheelView.DividerType.ROUND_RECT);
        this.binding.wheelView.setOnItemSelectedListener(new WheelDialog$$ExternalSyntheticLambda2(this));
        this.binding.ivCancel.setOnClickListener(new WheelDialog$$ExternalSyntheticLambda0(function0, this));
        this.binding.ivConfirm.setOnClickListener(new WheelDialog$$ExternalSyntheticLambda1(function1, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m178_init_$lambda0(WheelDialog wheelDialog, int i) {
        Intrinsics.checkNotNullParameter(wheelDialog, "this$0");
        wheelDialog.mCurrentIndex = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m179_init_$lambda1(Function0 function0, WheelDialog wheelDialog, View view) {
        Intrinsics.checkNotNullParameter(wheelDialog, "this$0");
        if (function0 != null) {
            function0.invoke();
        }
        wheelDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m180_init_$lambda2(Function1 function1, WheelDialog wheelDialog, View view) {
        Intrinsics.checkNotNullParameter(wheelDialog, "this$0");
        if (function1 != null) {
            function1.invoke(Integer.valueOf(wheelDialog.mCurrentIndex));
        }
        wheelDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setWheelAdapter(WheelAdapter<String> wheelAdapter) {
        Intrinsics.checkNotNullParameter(wheelAdapter, "adapter");
        this.binding.wheelView.setAdapter(wheelAdapter);
    }

    public final void setCurrentItem(int i) {
        this.mCurrentIndex = i;
        this.binding.wheelView.setCurrentItem(i);
    }

    public final int getCurrentItem() {
        return this.mCurrentIndex;
    }

    /* access modifiers changed from: protected */
    public DialogWheelBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogWheelBinding inflate = DialogWheelBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
