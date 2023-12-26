package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader;
import com.tal.app.thinkacademy.business.shop.bean.request.ModifyEmailRequest;
import com.tal.app.thinkacademy.business.shop.databinding.ShopBindEmailDialogLayoutBinding;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.SchoolContactInfo;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B<\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u000eH\u0016J!\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H@ø\u0001\u0000¢\u0006\u0002\u0010\"JC\u0010#\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u000eH\u0016J\u0012\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010-\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010.\u001a\u00020\u000eH\u0002J\u001c\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/BindEmailDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopBindEmailDialogLayoutBinding;", "Lcom/tal/app/thinkacademy/business/login/widget/LoginCountDownTimer$ITimerListener;", "context", "Landroid/content/Context;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/PhoneEmailBindState;", "Lkotlin/ParameterName;", "name", "state", "", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleCoroutineScope;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "mCallCode", "mEmail", "mLifecycleScope", "mListener", "mSchoolCode", "mSmsTimer", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/VerifyCodeCountDownTimer;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "dismiss", "getModifyEmail", "", "body", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;", "Lcom/tal/app/thinkacademy/business/shop/bean/request/ModifyEmailRequest;", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSmsCode", "contactInfo", "countryCallingCode", "type", "", "scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFinish", "requestModifyEmail", "code", "requestSmsCode", "sendSmsCode", "setData", "phone", "callCode", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BindEmailDialog.kt */
public final class BindEmailDialog extends BaseBindDialog<ShopBindEmailDialogLayoutBinding> implements LoginCountDownTimer.ITimerListener {
    /* access modifiers changed from: private */
    public final String TAG;
    private String mCallCode;
    private String mEmail;
    private LifecycleCoroutineScope mLifecycleScope;
    /* access modifiers changed from: private */
    public Function1<? super PhoneEmailBindState, Unit> mListener;
    private String mSchoolCode;
    /* access modifiers changed from: private */
    public VerifyCodeCountDownTimer mSmsTimer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BindEmailDialog(Context context, LifecycleCoroutineScope lifecycleCoroutineScope, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, lifecycleCoroutineScope, (i & 4) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BindEmailDialog(Context context, LifecycleCoroutineScope lifecycleCoroutineScope, Function1<? super PhoneEmailBindState, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleCoroutineScope, "lifecycleScope");
        this.mLifecycleScope = lifecycleCoroutineScope;
        this.TAG = "BindPhoneDialog";
        this.mListener = function1;
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…SHAREDATA_NOT_CLEAR\n    )");
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
        this.binding.dialogClose.setOnClickListener(new BindEmailDialog$$ExternalSyntheticLambda0(this));
        this.binding.dialogBack.setOnClickListener(new BindEmailDialog$$ExternalSyntheticLambda3(this));
        this.binding.phoneEdit.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ BindEmailDialog this$0;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                TextView textView = this.this$0.binding.btnConfirm;
                boolean z = false;
                if ((editable == null ? 0 : editable.length()) > 0) {
                    z = true;
                }
                textView.setEnabled(z);
            }
        });
        this.binding.sendCode.setOnClickListener(new BindEmailDialog$$ExternalSyntheticLambda2(this));
        this.binding.btnConfirm.setOnClickListener(new BindEmailDialog$$ExternalSyntheticLambda1(this));
        SchoolContactInfo schoolContactInfo = SchoolConstants.INSTANCE.getSchoolContactInfo(this.mSchoolCode);
        if (schoolContactInfo != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{context.getString(R.string.link_phone_num_dialog_tips), schoolContactInfo.getContactInfo()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String contactInfo = schoolContactInfo.getContactInfo();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = this.binding.linkNumberTips;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.linkNumberTips");
            textHighLightUtil.setTextHighLightWithClick(textView, format, contactInfo == null ? "" : contactInfo, R.color.color_3370FF, new BindEmailDialog$$ExternalSyntheticLambda4(schoolContactInfo, context));
        }
    }

    /* access modifiers changed from: protected */
    public ShopBindEmailDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopBindEmailDialogLayoutBinding inflate = ShopBindEmailDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m267_init_$lambda1(BindEmailDialog bindEmailDialog, View view) {
        Intrinsics.checkNotNullParameter(bindEmailDialog, "this$0");
        bindEmailDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m268_init_$lambda2(BindEmailDialog bindEmailDialog, View view) {
        Intrinsics.checkNotNullParameter(bindEmailDialog, "this$0");
        Function1<? super PhoneEmailBindState, Unit> function1 = bindEmailDialog.mListener;
        if (function1 != null) {
            function1.invoke(PhoneEmailBindState.BACK);
        }
        bindEmailDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m269_init_$lambda3(BindEmailDialog bindEmailDialog, View view) {
        Intrinsics.checkNotNullParameter(bindEmailDialog, "this$0");
        if (bindEmailDialog.mSmsTimer == null) {
            TextView textView = bindEmailDialog.binding.sendCode;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.sendCode");
            VerifyCodeCountDownTimer verifyCodeCountDownTimer = new VerifyCodeCountDownTimer(60000, 1000, textView);
            bindEmailDialog.mSmsTimer = verifyCodeCountDownTimer;
            verifyCodeCountDownTimer.setTimerListener(bindEmailDialog);
        }
        VerifyCodeCountDownTimer verifyCodeCountDownTimer2 = bindEmailDialog.mSmsTimer;
        boolean z = true;
        if (verifyCodeCountDownTimer2 == null || !verifyCodeCountDownTimer2.isTick()) {
            z = false;
        }
        if (z) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        bindEmailDialog.binding.sendCode.setEnabled(false);
        bindEmailDialog.binding.phoneEdit.clearFocus();
        bindEmailDialog.sendSmsCode();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final void m270_init_$lambda4(BindEmailDialog bindEmailDialog, View view) {
        Intrinsics.checkNotNullParameter(bindEmailDialog, "this$0");
        if (CommonUtilsKt.isFastClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String obj = StringsKt.trim(bindEmailDialog.binding.phoneEdit.getText().toString()).toString();
        if (!(obj.length() == 0)) {
            bindEmailDialog.requestModifyEmail(obj);
        } else {
            ToastUtils.showLong(R.string.input_is_empty);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-6$lambda-5  reason: not valid java name */
    public static final void m271lambda6$lambda5(SchoolContactInfo schoolContactInfo, Context context, View view) {
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

    public static /* synthetic */ void setData$default(BindEmailDialog bindEmailDialog, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        bindEmailDialog.setData(str, str2);
    }

    public final void setData(String str, String str2) {
        this.mEmail = str;
        this.mCallCode = str2;
        this.binding.phoneEdit.setText("");
        this.binding.phoneEdit.clearFocus();
        this.binding.sendCode.setText(R.string.send);
        this.binding.sendCode.setEnabled(true);
    }

    public void dismiss() {
        BindEmailDialog.super.dismiss();
        this.binding.phoneEdit.setText("");
        VerifyCodeCountDownTimer verifyCodeCountDownTimer = this.mSmsTimer;
        if (verifyCodeCountDownTimer != null) {
            verifyCodeCountDownTimer.cancel();
        }
        this.mSmsTimer = null;
    }

    private final void sendSmsCode() {
        requestSmsCode(this.mEmail, this.mCallCode);
    }

    public void onFinish() {
        this.binding.sendCode.setText(R.string.resend);
        this.binding.sendCode.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[PHI: r15 
      PHI: (r15v2 java.lang.Object) = (r15v5 java.lang.Object), (r15v1 java.lang.Object) binds: [B:19:0x0078, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSmsCode(java.lang.String r11, java.lang.String r12, java.lang.Integer r13, java.lang.Integer r14, kotlin.coroutines.Continuation<java.lang.Object> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getSmsCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getSmsCode$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getSmsCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getSmsCode$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getSmsCode$1
            r0.<init>(r10, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x007b
        L_0x002e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0036:
            java.lang.Object r11 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r11 = (com.tal.app.thinkacademy.common.network.NetData) r11
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x006e
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r15)
            com.tal.app.thinkacademy.common.network.NetData r15 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.login.config.ApiService> r6 = com.tal.app.thinkacademy.business.login.config.ApiService.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r6)
            com.tal.app.thinkacademy.business.login.config.ApiService r2 = (com.tal.app.thinkacademy.business.login.config.ApiService) r2
            com.tal.app.thinkacademy.business.login.entity.post.GetCode r6 = new com.tal.app.thinkacademy.business.login.entity.post.GetCode
            com.tal.app.thinkacademy.business.login.entity.post.GetCodeHeader r7 = new com.tal.app.thinkacademy.business.login.entity.post.GetCodeHeader
            r7.<init>(r4, r5, r4)
            com.tal.app.thinkacademy.business.login.entity.post.GetCodeData r8 = new com.tal.app.thinkacademy.business.login.entity.post.GetCodeData
            r8.<init>(r11, r12, r13, r14)
            r6.<init>(r7, r8)
            r0.L$0 = r15
            r0.label = r5
            java.lang.Object r11 = r2.getSmsCode(r6, r0)
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r9 = r15
            r15 = r11
            r11 = r9
        L_0x006e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r15 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r15
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r15 = r11.transform(r15, r0)
            if (r15 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog.getSmsCode(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object getSmsCode$default(BindEmailDialog bindEmailDialog, String str, String str2, Integer num, Integer num2, Continuation continuation, int i, Object obj) {
        String str3 = (i & 1) != 0 ? "" : str;
        String str4 = (i & 2) != 0 ? "" : str2;
        if ((i & 4) != 0) {
            num = 2;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = 3;
        }
        return bindEmailDialog.getSmsCode(str3, str4, num3, num2, continuation);
    }

    private final void requestSmsCode(String str, String str2) {
        BuildersKt.launch$default(this.mLifecycleScope, new HandlerException(new BindEmailDialog$requestSmsCode$1(this)), (CoroutineStart) null, new BindEmailDialog$requestSmsCode$2(this, str, str2, (Continuation<? super BindEmailDialog$requestSmsCode$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0069, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getModifyEmail(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody<com.tal.app.thinkacademy.business.shop.bean.request.ModifyEmailRequest> r8, kotlin.coroutines.Continuation<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getModifyEmail$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getModifyEmail$1 r0 = (com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getModifyEmail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getModifyEmail$1 r0 = new com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog$getModifyEmail$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r8 = (com.tal.app.thinkacademy.common.network.NetData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r8 = r2.getEmailModify(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005e:
            com.tal.app.thinkacademy.lib.restful.HiResponse r9 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r9
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r9 = r8.transform(r9, r0)
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog.getModifyEmail(com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void requestModifyEmail(String str) {
        BuildersKt.launch$default(this.mLifecycleScope, new HandlerException(new BindEmailDialog$requestModifyEmail$1(this)), (CoroutineStart) null, new BindEmailDialog$requestModifyEmail$2(this, new ShopRequestCommonBody(new ModifyEmailRequest(this.mEmail, str), (ShopRequestCommonHeader) null, 2, (DefaultConstructorMarker) null), (Continuation<? super BindEmailDialog$requestModifyEmail$2>) null), 2, (Object) null);
    }
}
