package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivityLoginPhoneBinding;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.login.widget.OtpLoginDialog;
import com.tal.app.thinkacademy.business.login.widget.PasswordUtil;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesUploadPrinter;
import com.tal.app.thinkacademy.lib.util.KeyboardUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@PadAutoCenterScreen(designHeight = 620.0f)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J*\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0014J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\u0012\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u000100H\u0014J*\u00101\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020\u0017H\u0002J\b\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0017H\u0002J\u0010\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020\u0017H\u0002J\b\u0010:\u001a\u00020\u0017H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/PhoneLoginActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/LoginViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityLoginPhoneBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "()V", "mChangeCountryDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mChosenCountryIndex", "", "mIsAgree", "", "mLoginDialog", "Lcom/tal/app/thinkacademy/business/login/widget/OtpLoginDialog;", "mLoginType", "mPhoneLengthMax", "mPhoneLengthMin", "mShowPassword", "tag", "", "kotlin.jvm.PlatformType", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getInternationalList", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "init", "login", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTextChanged", "before", "resetStatus", "setAgreeState", "setListener", "setLoginState", "showLoginDialog", "msg", "showWheelDialog", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneLoginActivity.kt */
public final class PhoneLoginActivity extends BaseVmActivity<LoginViewModel, ActivityLoginPhoneBinding> implements View.OnClickListener, ClearEditText.CustomTextWatcher {
    private WheelDialog mChangeCountryDialog;
    /* access modifiers changed from: private */
    public int mChosenCountryIndex;
    /* access modifiers changed from: private */
    public boolean mIsAgree;
    private OtpLoginDialog mLoginDialog;
    private int mLoginType;
    /* access modifiers changed from: private */
    public int mPhoneLengthMax = 99;
    /* access modifiers changed from: private */
    public int mPhoneLengthMin = 1;
    private boolean mShowPassword;
    private final String tag = "PhoneLoginActivity";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhoneLoginActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PhoneLoginActivity.super.onCreate(bundle);
        overridePendingTransition(R.anim.dialog_bottom_in, R.anim.dialog_bottom_out);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        init();
        setListener();
    }

    public void startObserve() {
        getMViewModel().getAccountLoginData().observe((LifecycleOwner) this, new PhoneLoginActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m111startObserve$lambda0(PhoneLoginActivity phoneLoginActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(phoneLoginActivity, "this$0");
        phoneLoginActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            UserBean userBean = (UserBean) stateData.getData();
            XesLog.dt("UserInfo", new Object[]{userBean});
            if (userBean != null) {
                ShareDataManager.getInstance().initUserSP(String.valueOf(userBean.getUid()));
                LoginIn.INSTANCE.loginInfo(userBean, true, (Context) phoneLoginActivity, 1);
                StringBuilder sb = new StringBuilder();
                File externalCacheDir = phoneLoginActivity.getApplication().getExternalCacheDir();
                sb.append(externalCacheDir == null ? null : externalCacheDir.getAbsolutePath());
                sb.append(File.separator);
                sb.append("xesxeslog");
                XesUploadPrinter.getInstance(sb.toString()).setUserInfo(String.valueOf(userBean.getUid()), ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), userBean.getUnifiedAccessToken());
                ShareDataManager.getInstance().put("modify_nickname", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
                return;
            }
            return;
        }
        XesLog.et("UserInfo", new Object[]{stateData.getMsg()});
        if (stateData.getCode() == 100108) {
            String msg = stateData.getMsg();
            Intrinsics.checkNotNull(msg);
            phoneLoginActivity.showLoginDialog(msg);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        phoneLoginActivity.showToast(CommonKtxKt.formatBadResult(stateData));
    }

    private final void init() {
        int intExtra = getIntent().getIntExtra(AccountVerificationActivityKt.ChosenCountryIndex, 0);
        this.mChosenCountryIndex = intExtra;
        if (intExtra < 0) {
            this.mChosenCountryIndex = 0;
        }
        getBinding().etPhoneNumber.setText(getIntent().getStringExtra(PasswordSettingsActivityKt.accountName));
        this.mIsAgree = getIntent().getBooleanExtra(PasswordSettingsActivityKt.isAgree, false);
        setAgreeState();
        List<ConfigInfo.Country> internationalList = getInternationalList();
        if (internationalList != null) {
            ConfigInfo.Country country = internationalList.get(this.mChosenCountryIndex);
            TextView textView = getBinding().tvCountryCode;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.Login_format_call_code);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Login_format_call_code)");
            String format = String.format(string, Arrays.copyOf(new Object[]{country.getCountryCallingCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            this.mPhoneLengthMin = country.getPhoneMinLength();
            this.mPhoneLengthMax = country.getPhoneMaxLength();
            getBinding().etPhoneNumber.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
        }
        TextView textView2 = getBinding().loginAgreementTips;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.loginAgreementTips");
        JumpToAgreementUtil.INSTANCE.loginAgreementTips((Context) this, textView2);
        XesDataBus.with("close_account_verification").observe((LifecycleOwner) this, new PhoneLoginActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-2  reason: not valid java name */
    public static final void m110init$lambda2(PhoneLoginActivity phoneLoginActivity, Object obj) {
        Intrinsics.checkNotNullParameter(phoneLoginActivity, "this$0");
        phoneLoginActivity.finish();
    }

    private final void setListener() {
        ClearEditText.CustomTextWatcher customTextWatcher = this;
        getBinding().etPhoneNumber.addCustomTextWatcher(customTextWatcher);
        getBinding().etPassword.addCustomTextWatcher(customTextWatcher);
        View.OnClickListener onClickListener = this;
        getBinding().tvSkip.setOnClickListener(onClickListener);
        getBinding().ivPasswordEye.setOnClickListener(onClickListener);
        getBinding().tvOtpLogin.setOnClickListener(onClickListener);
        getBinding().tvForgetPassword.setOnClickListener(onClickListener);
        getBinding().ivAgree.setOnClickListener(onClickListener);
        getBinding().ivLoginEmail.setOnClickListener(onClickListener);
        getBinding().ivLoginId.setOnClickListener(onClickListener);
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvCountryCode;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvCountryCode");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new PhoneLoginActivity$setListener$1(this), 1, (Object) null);
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        TextView textView2 = getBinding().tvSignIn;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvSignIn");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil2, textView2, 0, new PhoneLoginActivity$setListener$2(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final List<ConfigInfo.Country> getInternationalList() {
        return ImConfig.INSTANCE.getInternationalInfo();
    }

    /* access modifiers changed from: private */
    public final void showWheelDialog() {
        if (this.mChangeCountryDialog == null) {
            WheelDialog wheelDialog = new WheelDialog((Context) this, new PhoneLoginActivity$showWheelDialog$1(this), (Function0) null, 4, (DefaultConstructorMarker) null);
            this.mChangeCountryDialog = wheelDialog;
            wheelDialog.setWheelAdapter(new PhoneLoginActivity$showWheelDialog$2(this));
        }
        WheelDialog wheelDialog2 = this.mChangeCountryDialog;
        if (wheelDialog2 != null) {
            wheelDialog2.setCurrentItem(this.mChosenCountryIndex);
        }
        WheelDialog wheelDialog3 = this.mChangeCountryDialog;
        if (wheelDialog3 != null) {
            wheelDialog3.show();
        }
    }

    private final void showLoginDialog(String str) {
        if (this.mLoginDialog == null) {
            this.mLoginDialog = new OtpLoginDialog((Context) this, new PhoneLoginActivity$showLoginDialog$1(this));
        }
        OtpLoginDialog otpLoginDialog = this.mLoginDialog;
        if (otpLoginDialog != null) {
            otpLoginDialog.show(str);
        }
    }

    /* access modifiers changed from: private */
    public final void resetStatus() {
        getBinding().etPhoneNumber.setText("");
    }

    /* access modifiers changed from: private */
    public final void login() {
        KeyboardUtils.hideSoftInput((View) getBinding().etPassword);
        if (!this.mIsAgree) {
            showToast(getString(R.string.policies_tip));
            return;
        }
        showLoading();
        String obj = StringsKt.trim(String.valueOf(getBinding().etPhoneNumber.getText())).toString();
        String password = PasswordUtil.INSTANCE.getPassword(String.valueOf(getBinding().etPassword.getText()));
        String str = null;
        if (getBinding().tvCountryCode.getText().length() > 1) {
            CharSequence text = getBinding().tvCountryCode.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvCountryCode.text");
            str = StringsKt.trim(text.subSequence(1, text.length()).toString()).toString();
        }
        LoginTrack.INSTANCE.signInClick("手机号", "密码登陆", 0);
        getMViewModel().accountLogin(obj, password, this.mLoginType, str, "手机号", "密码登陆");
    }

    private final void setLoginState() {
        int i = this.mPhoneLengthMin;
        int i2 = this.mPhoneLengthMax;
        int length = StringsKt.trim(String.valueOf(getBinding().etPhoneNumber.getText())).toString().length();
        boolean z = true;
        boolean z2 = i <= length && length <= i2;
        boolean z3 = StringsKt.trim(String.valueOf(getBinding().etPassword.getText())).toString().length() >= 6;
        TextView textView = getBinding().tvSignIn;
        if (!z2 || !z3) {
            z = false;
        }
        textView.setEnabled(z);
    }

    private final void setAgreeState() {
        if (this.mIsAgree) {
            getBinding().ivAgree.setImageResource(R.drawable.login_icon_checked);
        } else {
            getBinding().ivAgree.setImageResource(R.drawable.login_icon_unchecked);
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PhoneLoginActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.tv_otp_login;
        if (valueOf != null && valueOf.intValue() == i) {
            Intent intent = new Intent((Context) this, OtpLoginActivity.class);
            intent.putExtra(AccountVerificationActivityKt.ChosenCountryIndex, this.mChosenCountryIndex);
            intent.putExtra(PasswordSettingsActivityKt.isAgree, this.mIsAgree);
            startActivity(intent);
            finish();
        } else {
            int i2 = R.id.tv_forget_password;
            if (valueOf == null || valueOf.intValue() != i2) {
                int i3 = R.id.iv_password_eye;
                if (valueOf != null && valueOf.intValue() == i3) {
                    String obj = StringsKt.trim(String.valueOf(getBinding().etPassword.getText())).toString();
                    if (this.mShowPassword) {
                        this.mShowPassword = false;
                        getBinding().ivPasswordEye.setImageResource(R.drawable.password_icon_eye_close);
                        ClearEditText clearEditText = getBinding().etPassword;
                        if (clearEditText != null) {
                            clearEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                        getBinding().etPassword.setSelection(obj.length());
                    } else {
                        this.mShowPassword = true;
                        getBinding().ivPasswordEye.setImageResource(R.drawable.password_icon_eye_open);
                        ClearEditText clearEditText2 = getBinding().etPassword;
                        if (clearEditText2 != null) {
                            clearEditText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        }
                        getBinding().etPassword.setSelection(obj.length());
                    }
                } else {
                    int i4 = R.id.tv_skip;
                    if (valueOf != null && valueOf.intValue() == i4) {
                        finish();
                    } else {
                        int i5 = R.id.iv_login_email;
                        if (valueOf != null && valueOf.intValue() == i5) {
                            Intent intent2 = new Intent((Context) this, EmailLoginActivity.class);
                            intent2.putExtra(PasswordSettingsActivityKt.isAgree, this.mIsAgree);
                            startActivity(intent2);
                            finish();
                        } else {
                            int i6 = R.id.iv_login_id;
                            if (valueOf != null && valueOf.intValue() == i6) {
                                Intent intent3 = new Intent((Context) this, IdLoginActivity.class);
                                intent3.putExtra(PasswordSettingsActivityKt.isAgree, this.mIsAgree);
                                startActivity(intent3);
                                finish();
                            } else {
                                int i7 = R.id.iv_agree;
                                if (valueOf != null && valueOf.intValue() == i7) {
                                    this.mIsAgree = !this.mIsAgree;
                                    setAgreeState();
                                    setLoginState();
                                }
                            }
                        }
                    }
                }
            } else if (!this.mIsAgree) {
                showToast(getString(R.string.policies_tip));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            } else {
                Intent intent4 = new Intent((Context) this, AccountVerificationActivity.class);
                intent4.putExtra(AccountVerificationActivityKt.ChosenCountryIndex, this.mChosenCountryIndex);
                intent4.putExtra(PasswordSettingsActivityKt.accountName, StringsKt.trim(String.valueOf(getBinding().etPhoneNumber.getText())).toString());
                startActivity(intent4);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void afterTextChanged(Editable editable) {
        if (Intrinsics.areEqual((Object) getCurrentFocus(), (Object) getBinding().etPassword)) {
            Intrinsics.checkNotNull(editable);
            if (editable.length() > 0) {
                getBinding().ivPasswordEye.setVisibility(0);
            } else {
                getBinding().ivPasswordEye.setVisibility(8);
            }
        }
        setLoginState();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            getBinding().etPhoneNumber.clearFocus();
            getBinding().etPassword.clearFocus();
        }
        return PhoneLoginActivity.super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public ActivityLoginPhoneBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityLoginPhoneBinding inflate = ActivityLoginPhoneBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
