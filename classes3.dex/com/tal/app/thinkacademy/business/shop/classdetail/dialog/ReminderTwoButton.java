package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.flyco.roundview.RoundTextView;
import com.flyco.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.databinding.ShopReminderTwoButtonDialogLayoutBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB4\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ReminderTwoButton;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopReminderTwoButtonDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ReminderTwoButton$ButtonType;", "Lkotlin/ParameterName;", "name", "btnType", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mListener", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setButtonColor", "leftBgColor", "", "leftTextColor", "rightBgColor", "rightTextColor", "setButtonText", "left", "", "right", "setMsgText", "str", "setTitle", "ButtonType", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReminderTwoButton.kt */
public final class ReminderTwoButton extends BaseBindDialog<ShopReminderTwoButtonDialogLayoutBinding> {
    private Function1<? super ButtonType, Unit> mListener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ReminderTwoButton$ButtonType;", "", "(Ljava/lang/String;I)V", "BUTTON_LEFT", "BUTTON_RIGHT", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReminderTwoButton.kt */
    public enum ButtonType {
        BUTTON_LEFT,
        BUTTON_RIGHT
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReminderTwoButton(Context context, Function1<? super ButtonType, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function1;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        RoundTextView roundTextView = this.binding.reminderBtnLeft;
        if (roundTextView != null) {
            roundTextView.setOnClickListener(new ReminderTwoButton$$ExternalSyntheticLambda1(this));
        }
        RoundTextView roundTextView2 = this.binding.reminderBtnRight;
        if (roundTextView2 != null) {
            roundTextView2.setOnClickListener(new ReminderTwoButton$$ExternalSyntheticLambda0(this));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReminderTwoButton(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m310_init_$lambda1(ReminderTwoButton reminderTwoButton, View view) {
        Intrinsics.checkNotNullParameter(reminderTwoButton, "this$0");
        Function1<? super ButtonType, Unit> function1 = reminderTwoButton.mListener;
        if (function1 != null) {
            function1.invoke(ButtonType.BUTTON_LEFT);
        }
        reminderTwoButton.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m311_init_$lambda2(ReminderTwoButton reminderTwoButton, View view) {
        Intrinsics.checkNotNullParameter(reminderTwoButton, "this$0");
        Function1<? super ButtonType, Unit> function1 = reminderTwoButton.mListener;
        if (function1 != null) {
            function1.invoke(ButtonType.BUTTON_RIGHT);
        }
        reminderTwoButton.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setTitle(String str) {
        TextView textView = this.binding.reminderTitle;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setButtonText(String str, String str2) {
        RoundTextView roundTextView = this.binding.reminderBtnLeft;
        if (roundTextView != null) {
            roundTextView.setText(str);
        }
        RoundTextView roundTextView2 = this.binding.reminderBtnRight;
        if (roundTextView2 != null) {
            roundTextView2.setText(str2);
        }
    }

    public final void setButtonColor(int i, int i2, int i3, int i4) {
        RoundTextView roundTextView = this.binding.reminderBtnLeft;
        RoundViewDelegate roundViewDelegate = null;
        RoundViewDelegate delegate = roundTextView == null ? null : roundTextView.getDelegate();
        if (delegate != null) {
            delegate.setBackgroundColor(i);
        }
        RoundTextView roundTextView2 = this.binding.reminderBtnLeft;
        if (roundTextView2 != null) {
            roundTextView2.setTextColor(i2);
        }
        RoundTextView roundTextView3 = this.binding.reminderBtnRight;
        if (roundTextView3 != null) {
            roundViewDelegate = roundTextView3.getDelegate();
        }
        if (roundViewDelegate != null) {
            roundViewDelegate.setBackgroundColor(i3);
        }
        this.binding.reminderBtnRight.setTextColor(i4);
    }

    public final void setMsgText(String str) {
        TextView textView = this.binding.reminderMsg;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public ShopReminderTwoButtonDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopReminderTwoButtonDialogLayoutBinding inflate = ShopReminderTwoButtonDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
