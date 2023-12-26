package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogClassinBinding;
import com.tal.app.thinkacademy.common.utils.ClipboardUtilKt;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/ClassinDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/StudyDialogClassinBinding;", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "listener", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/OutsideOfClassType;", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;Lkotlin/jvm/functions/Function2;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassinDialog.kt */
public final class ClassinDialog extends BaseBindDialog<StudyDialogClassinBinding> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassinDialog(Context context, TheOutsideEntity theOutsideEntity, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, theOutsideEntity, (i & 4) != 0 ? null : function2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassinDialog(Context context, TheOutsideEntity theOutsideEntity, Function2<? super OutsideOfClassType, ? super TheOutsideEntity, Unit> function2) {
        super(context, true);
        String str;
        String str2;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(theOutsideEntity, "entity");
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.binding.tvClassinLink.setText(theOutsideEntity.getClassinLink());
        this.binding.llCopyClassinLink.setOnClickListener(new ClassinDialog$$ExternalSyntheticLambda0(context, theOutsideEntity));
        this.binding.tvGotIt.setOnClickListener(new ClassinDialog$$ExternalSyntheticLambda1(this));
        TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
        TextView textView = this.binding.tvDownload;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvDownload");
        if (context == null || (string2 = context.getString(R.string.classin_dialog_hint)) == null) {
            str = "";
        } else {
            str = string2;
        }
        if (context == null || (string = context.getString(R.string.download_classin)) == null) {
            str2 = "";
        } else {
            str2 = string;
        }
        textHighLightUtil.setTextHighLightWithClick(textView, str, str2, R.color.color_3370FF, new ClassinDialog$$ExternalSyntheticLambda2(function2, this, theOutsideEntity));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m406_init_$lambda0(Context context, TheOutsideEntity theOutsideEntity, View view) {
        Intrinsics.checkNotNullParameter(theOutsideEntity, "$entity");
        ToastUtils.showShort(R.string.copied);
        String classinLink = theOutsideEntity.getClassinLink();
        if (classinLink == null) {
            classinLink = "";
        }
        ClipboardUtilKt.copyClipboard(context, classinLink);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m407_init_$lambda1(ClassinDialog classinDialog, View view) {
        Intrinsics.checkNotNullParameter(classinDialog, "this$0");
        classinDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m408_init_$lambda3(Function2 function2, ClassinDialog classinDialog, TheOutsideEntity theOutsideEntity, View view) {
        Intrinsics.checkNotNullParameter(classinDialog, "this$0");
        Intrinsics.checkNotNullParameter(theOutsideEntity, "$entity");
        if (function2 != null) {
            classinDialog.dismiss();
            function2.invoke(OutsideOfClassType.CLASS_IN, theOutsideEntity);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public StudyDialogClassinBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        StudyDialogClassinBinding inflate = StudyDialogClassinBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
