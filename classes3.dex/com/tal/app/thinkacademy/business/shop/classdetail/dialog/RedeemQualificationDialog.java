package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemQualificationDialogLayoutBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.SchoolContactInfo;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012'\b\u0002\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R-\u0010\u0012\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/RedeemQualificationDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopRedeemQualificationDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "code", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mClassId", "getMClassId", "()Ljava/lang/String;", "setMClassId", "(Ljava/lang/String;)V", "mListener", "mSchoolCode", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedeemQualificationDialog.kt */
public final class RedeemQualificationDialog extends BaseBindDialog<ShopRedeemQualificationDialogLayoutBinding> {
    private String mClassId;
    private Function1<? super String, Unit> mListener;
    private String mSchoolCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemQualificationDialog(Context context, Function1<? super String, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function1;
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
        this.mSchoolCode = string;
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
        this.binding.dialogClose.setOnClickListener(new RedeemQualificationDialog$$ExternalSyntheticLambda1(this));
        this.binding.btnApply.setOnClickListener(new RedeemQualificationDialog$$ExternalSyntheticLambda0(this));
        SchoolContactInfo schoolContactInfo = SchoolConstants.INSTANCE.getSchoolContactInfo(this.mSchoolCode);
        if (schoolContactInfo != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{context.getString(R.string.redeem_dialog_desc), schoolContactInfo.getContactInfo()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String contactInfo = schoolContactInfo.getContactInfo();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = this.binding.idDesc;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.idDesc");
            textHighLightUtil.setTextHighLightWithClick(textView, format, contactInfo == null ? "" : contactInfo, R.color.color_3370FF, new RedeemQualificationDialog$$ExternalSyntheticLambda2(schoolContactInfo, context, this));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemQualificationDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    public final String getMClassId() {
        return this.mClassId;
    }

    public final void setMClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mClassId = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m307_init_$lambda1(RedeemQualificationDialog redeemQualificationDialog, View view) {
        Intrinsics.checkNotNullParameter(redeemQualificationDialog, "this$0");
        redeemQualificationDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m308_init_$lambda2(RedeemQualificationDialog redeemQualificationDialog, View view) {
        Intrinsics.checkNotNullParameter(redeemQualificationDialog, "this$0");
        Editable text = redeemQualificationDialog.binding.redeemEdit.getText();
        CharSequence charSequence = text;
        if (charSequence == null || charSequence.length() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        Function1<? super String, Unit> function1 = redeemQualificationDialog.mListener;
        if (function1 != null) {
            function1.invoke(text.toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-3  reason: not valid java name */
    public static final void m309lambda4$lambda3(SchoolContactInfo schoolContactInfo, Context context, RedeemQualificationDialog redeemQualificationDialog, View view) {
        Intrinsics.checkNotNullParameter(schoolContactInfo, "$schoolContactInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(redeemQualificationDialog, "this$0");
        String str = "";
        if (schoolContactInfo.isPhone()) {
            String contactInfo = schoolContactInfo.getContactInfo();
            if (contactInfo != null) {
                str = contactInfo;
            }
            CommonUtilsKt.startCallPhoneNumber(str, context);
            ShopTrack.INSTANCE.hw_classdetal_redeem_telephonenumber_click(redeemQualificationDialog.mClassId);
        } else {
            String contactInfo2 = schoolContactInfo.getContactInfo();
            if (contactInfo2 != null) {
                str = contactInfo2;
            }
            CommonUtilsKt.startCallEmail(str, context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public ShopRedeemQualificationDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopRedeemQualificationDialogLayoutBinding inflate = ShopRedeemQualificationDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
