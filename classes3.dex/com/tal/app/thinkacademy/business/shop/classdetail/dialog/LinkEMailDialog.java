package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopLinkMailDialogLayoutBinding;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.SchoolContactInfo;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B4\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/LinkEMailDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopLinkMailDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "email", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mListener", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mSchoolCode", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkEMailDialog.kt */
public final class LinkEMailDialog extends BaseBindDialog<ShopLinkMailDialogLayoutBinding> {
    private Function1<? super String, Unit> mListener;
    private String mSchoolCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkEMailDialog(Context context, Function1<? super String, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListener = function1;
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
        this.mSchoolCode = string;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        this.binding.dialogClose.setOnClickListener(new LinkEMailDialog$$ExternalSyntheticLambda1(this));
        this.binding.mailEdit.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LinkEMailDialog this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                TextView textView = this.this$0.binding.linkMailBtnNext;
                boolean z = false;
                if ((editable == null ? 0 : editable.length()) > 0) {
                    z = true;
                }
                textView.setEnabled(z);
            }
        });
        this.binding.linkMailBtnNext.setOnClickListener(new LinkEMailDialog$$ExternalSyntheticLambda0(this));
        SchoolContactInfo schoolContactInfo = SchoolConstants.INSTANCE.getSchoolContactInfo(this.mSchoolCode);
        if (schoolContactInfo != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{context.getString(R.string.link_phone_num_dialog_tips), schoolContactInfo.getContactInfo()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String contactInfo = schoolContactInfo.getContactInfo();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = this.binding.linkNumberTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.linkNumberTips");
            textHighLightUtil.setTextHighLightWithClick(textView, format, contactInfo == null ? "" : contactInfo, R.color.color_3370FF, new LinkEMailDialog$$ExternalSyntheticLambda2(schoolContactInfo, context));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkEMailDialog(Context context, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function1);
    }

    public final Function1<String, Unit> getMListener() {
        return this.mListener;
    }

    public final void setMListener(Function1<? super String, Unit> function1) {
        this.mListener = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m282_init_$lambda1(LinkEMailDialog linkEMailDialog, View view) {
        Intrinsics.checkNotNullParameter(linkEMailDialog, "this$0");
        linkEMailDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m283_init_$lambda2(LinkEMailDialog linkEMailDialog, View view) {
        Intrinsics.checkNotNullParameter(linkEMailDialog, "this$0");
        if (CommonUtilsKt.isFastClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String obj = StringsKt.trim(linkEMailDialog.binding.mailEdit.getText().toString()).toString();
        if (!(obj.length() == 0)) {
            Function1<? super String, Unit> function1 = linkEMailDialog.mListener;
            if (function1 != null) {
                function1.invoke(obj);
            }
        } else {
            ToastUtils.showLong(R.string.input_is_empty);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-4$lambda-3  reason: not valid java name */
    public static final void m284lambda4$lambda3(SchoolContactInfo schoolContactInfo, Context context, View view) {
        Intrinsics.checkNotNullParameter(schoolContactInfo, "$schoolContactInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        String str = "";
        if (schoolContactInfo.isPhone()) {
            String contactInfo = schoolContactInfo.getContactInfo();
            if (contactInfo != null) {
                str = contactInfo;
            }
            CommonUtilsKt.startCallPhoneNumber(str, context);
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
    public ShopLinkMailDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopLinkMailDialogLayoutBinding inflate = ShopLinkMailDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
