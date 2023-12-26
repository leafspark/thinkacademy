package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopTakeAdmissionDialogLayoutBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B4\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J*\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000eR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R7\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/TakeAdmissionDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopTakeAdmissionDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isRedeem", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mClassId", "", "getMClassId", "()Ljava/lang/String;", "setMClassId", "(Ljava/lang/String;)V", "mIsCanStartTest", "getMIsCanStartTest", "()Z", "setMIsCanStartTest", "(Z)V", "mListener", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setData", "times", "", "examId", "phone", "msg", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakeAdmissionDialog.kt */
public final class TakeAdmissionDialog extends BaseBindDialog<ShopTakeAdmissionDialogLayoutBinding> {
    private String mClassId;
    private boolean mIsCanStartTest;
    private Function1<? super Boolean, Unit> mListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TakeAdmissionDialog(Context context, Function1<? super Boolean, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function1;
        this.mClassId = "0";
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
        this.binding.dialogClose.setOnClickListener(new TakeAdmissionDialog$$ExternalSyntheticLambda1(this));
        this.binding.reminderBtnLeft.setOnClickListener(new TakeAdmissionDialog$$ExternalSyntheticLambda0(this));
        this.binding.reminderBtnRight.setOnClickListener(new TakeAdmissionDialog$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TakeAdmissionDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    public final Function1<Boolean, Unit> getMListener() {
        return this.mListener;
    }

    public final void setMListener(Function1<? super Boolean, Unit> function1) {
        this.mListener = function1;
    }

    public final boolean getMIsCanStartTest() {
        return this.mIsCanStartTest;
    }

    public final void setMIsCanStartTest(boolean z) {
        this.mIsCanStartTest = z;
    }

    public final String getMClassId() {
        return this.mClassId;
    }

    public final void setMClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mClassId = str;
    }

    /* access modifiers changed from: protected */
    public ShopTakeAdmissionDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopTakeAdmissionDialogLayoutBinding inflate = ShopTakeAdmissionDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m324_init_$lambda1(TakeAdmissionDialog takeAdmissionDialog, View view) {
        Intrinsics.checkNotNullParameter(takeAdmissionDialog, "this$0");
        takeAdmissionDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m325_init_$lambda2(TakeAdmissionDialog takeAdmissionDialog, View view) {
        Intrinsics.checkNotNullParameter(takeAdmissionDialog, "this$0");
        takeAdmissionDialog.dismiss();
        if (takeAdmissionDialog.mIsCanStartTest) {
            ShopTrack.INSTANCE.hw_classdetal_cancel_click(takeAdmissionDialog.mClassId);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m326_init_$lambda3(TakeAdmissionDialog takeAdmissionDialog, View view) {
        Function1<? super Boolean, Unit> function1;
        Intrinsics.checkNotNullParameter(takeAdmissionDialog, "this$0");
        takeAdmissionDialog.dismiss();
        if (takeAdmissionDialog.mIsCanStartTest && (function1 = takeAdmissionDialog.mListener) != null) {
            function1.invoke(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setData(int i, int i2, String str, String str2) {
        boolean z = true;
        if (i > 0) {
            this.binding.reminderBtnLeft.setVisibility(0);
            this.binding.reminderBtnRight.setText(R.string.take_admission_start_test);
            this.binding.dialogTitle.setText(R.string.take_admission_dialog_title);
            this.mIsCanStartTest = true;
            TextView textView = this.binding.takeAdmissionText;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.take_admission_dialog_msg);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ake_admission_dialog_msg)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        } else {
            this.binding.reminderBtnLeft.setVisibility(8);
            this.binding.reminderBtnRight.setText(R.string.i_got_it);
            this.binding.dialogTitle.setText(R.string.unable_to_sign_up);
            this.mIsCanStartTest = false;
            if (i2 >= 0) {
                this.binding.takeAdmissionText.setText(str2);
            } else {
                CharSequence charSequence = str;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    CharSequence charSequence2 = str2;
                    if (!(charSequence2 == null || charSequence2.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
                        TextView textView2 = this.binding.takeAdmissionText;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.takeAdmissionText");
                        textHighLightUtil.setTextHighLightWithClick(textView2, str2, str, R.color.color_3370FF, new TakeAdmissionDialog$$ExternalSyntheticLambda4(this));
                    }
                }
                this.binding.takeAdmissionText.setText(str2);
            }
        }
        TextHighLightUtil textHighLightUtil2 = TextHighLightUtil.INSTANCE;
        TextView textView3 = this.binding.takeAdmissionTipInfo;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.takeAdmissionTipInfo");
        String string2 = getContext().getString(R.string.take_admission_dialog_tips_info);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…mission_dialog_tips_info)");
        String string3 = getContext().getString(R.string.take_admission_dialog_tips_info_highlight);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…alog_tips_info_highlight)");
        textHighLightUtil2.setTextHighLightWithClick(textView3, string2, string3, R.color.color_ffaa0a, new TakeAdmissionDialog$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-4  reason: not valid java name */
    public static final void m327setData$lambda4(TakeAdmissionDialog takeAdmissionDialog, View view) {
        Intrinsics.checkNotNullParameter(takeAdmissionDialog, "this$0");
        takeAdmissionDialog.dismiss();
        ShopTrack.INSTANCE.hw_classdetal_unablesign_telephone_click(takeAdmissionDialog.mClassId);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setData$lambda-5  reason: not valid java name */
    public static final void m328setData$lambda5(TakeAdmissionDialog takeAdmissionDialog, View view) {
        Intrinsics.checkNotNullParameter(takeAdmissionDialog, "this$0");
        takeAdmissionDialog.dismiss();
        Function1<? super Boolean, Unit> function1 = takeAdmissionDialog.mListener;
        if (function1 != null) {
            function1.invoke(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
