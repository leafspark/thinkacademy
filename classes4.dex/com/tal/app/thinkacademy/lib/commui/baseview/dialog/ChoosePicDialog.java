package com.tal.app.thinkacademy.lib.commui.baseview.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.databinding.DialogCommonChoosePhotoBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/lib/commui/databinding/DialogCommonChoosePhotoBinding;", "context", "Landroid/content/Context;", "itemType", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicDialogItemType;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicType;", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicDialogItemType;Lkotlin/jvm/functions/Function1;)V", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setItemType", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChoosePicDialog.kt */
public final class ChoosePicDialog extends BaseBindDialog<DialogCommonChoosePhotoBinding> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChoosePicDialog.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChoosePicDialogItemType.values().length];
            iArr[ChoosePicDialogItemType.IMAGE.ordinal()] = 1;
            iArr[ChoosePicDialogItemType.VIDEO.ordinal()] = 2;
            iArr[ChoosePicDialogItemType.ALL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChoosePicDialog(Context context) {
        this(context, (ChoosePicDialogItemType) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChoosePicDialog(Context context, ChoosePicDialogItemType choosePicDialogItemType) {
        this(context, choosePicDialogItemType, (Function1) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(choosePicDialogItemType, "itemType");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChoosePicDialog(Context context, ChoosePicDialogItemType choosePicDialogItemType, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? ChoosePicDialogItemType.IMAGE : choosePicDialogItemType, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChoosePicDialog(Context context, ChoosePicDialogItemType choosePicDialogItemType, Function1<? super ChoosePicType, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(choosePicDialogItemType, "itemType");
        gravity(80).layoutParams(new LinearLayout.LayoutParams(-1, -2)).canceledOnTouchOutside(true);
        setItemType(choosePicDialogItemType);
        this.binding.tvTake.setOnClickListener(new ChoosePicDialog$$ExternalSyntheticLambda3(function1, this));
        this.binding.tvChoose.setOnClickListener(new ChoosePicDialog$$ExternalSyntheticLambda2(function1, this));
        this.binding.tvCancel.setOnClickListener(new ChoosePicDialog$$ExternalSyntheticLambda1(function1, this));
        this.binding.tvChooseVideo.setOnClickListener(new ChoosePicDialog$$ExternalSyntheticLambda4(function1, this));
        this.binding.tvTakeVideo.setOnClickListener(new ChoosePicDialog$$ExternalSyntheticLambda0(function1, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m75_init_$lambda1(Function1 function1, ChoosePicDialog choosePicDialog, View view) {
        Intrinsics.checkNotNullParameter(choosePicDialog, "this$0");
        if (function1 != null) {
            function1.invoke(ChoosePicType.take);
        }
        choosePicDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m76_init_$lambda3(Function1 function1, ChoosePicDialog choosePicDialog, View view) {
        Intrinsics.checkNotNullParameter(choosePicDialog, "this$0");
        if (function1 != null) {
            function1.invoke(ChoosePicType.choose);
        }
        choosePicDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final void m77_init_$lambda5(Function1 function1, ChoosePicDialog choosePicDialog, View view) {
        Intrinsics.checkNotNullParameter(choosePicDialog, "this$0");
        if (function1 != null) {
            function1.invoke(ChoosePicType.cancel);
        }
        choosePicDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-6  reason: not valid java name */
    public static final void m78_init_$lambda6(Function1 function1, ChoosePicDialog choosePicDialog, View view) {
        Intrinsics.checkNotNullParameter(choosePicDialog, "this$0");
        if (function1 != null) {
            function1.invoke(ChoosePicType.CHOOSE_VIDEO);
        }
        choosePicDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-7  reason: not valid java name */
    public static final void m79_init_$lambda7(Function1 function1, ChoosePicDialog choosePicDialog, View view) {
        Intrinsics.checkNotNullParameter(choosePicDialog, "this$0");
        if (function1 != null) {
            function1.invoke(ChoosePicType.TAKE_VIDEO);
        }
        choosePicDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChoosePicDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (Function1<? super ChoosePicType, Unit>) (i & 2) != 0 ? null : function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChoosePicDialog(Context context, Function1<? super ChoosePicType, Unit> function1) {
        this(context, ChoosePicDialogItemType.IMAGE, function1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setItemType(ChoosePicDialogItemType choosePicDialogItemType) {
        Intrinsics.checkNotNullParameter(choosePicDialogItemType, "itemType");
        int i = WhenMappings.$EnumSwitchMapping$0[choosePicDialogItemType.ordinal()];
        if (i == 1) {
            this.binding.tvTake.setVisibility(0);
            this.binding.tvChoose.setVisibility(0);
            this.binding.tvChooseVideo.setVisibility(8);
            this.binding.tvTakeVideo.setVisibility(8);
        } else if (i == 2) {
            this.binding.tvTake.setVisibility(8);
            this.binding.tvChoose.setVisibility(8);
            this.binding.tvChooseVideo.setVisibility(0);
            this.binding.tvTakeVideo.setVisibility(0);
        } else if (i == 3) {
            this.binding.tvTake.setVisibility(0);
            this.binding.tvChoose.setVisibility(0);
            this.binding.tvChooseVideo.setVisibility(0);
            this.binding.tvTakeVideo.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public DialogCommonChoosePhotoBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogCommonChoosePhotoBinding inflate = DialogCommonChoosePhotoBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
