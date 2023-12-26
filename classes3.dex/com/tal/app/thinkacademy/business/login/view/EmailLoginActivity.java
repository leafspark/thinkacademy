package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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
import com.tal.app.thinkacademy.business.login.databinding.ActivityLoginEmailBinding;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.login.widget.OtpLoginDialog;
import com.tal.app.thinkacademy.business.login.widget.PasswordUtil;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesUploadPrinter;
import com.tal.app.thinkacademy.lib.util.KeyboardUtils;
import com.tal.app.thinkacademy.lib.util.RegexUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@PadAutoCenterScreen(designHeight = 620.0f)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\u0012\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J*\u0010)\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0002J\b\u0010-\u001a\u00020\u0012H\u0002J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/EmailLoginActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/LoginViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityLoginEmailBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "()V", "mIsAgree", "", "mLoginDialog", "Lcom/tal/app/thinkacademy/business/login/widget/OtpLoginDialog;", "mLoginType", "", "mShowPassword", "tag", "", "kotlin.jvm.PlatformType", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "init", "login", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTextChanged", "before", "setAgreeState", "setListener", "setLoginState", "showLoginDialog", "msg", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmailLoginActivity.kt */
public final class EmailLoginActivity extends BaseVmActivity<LoginViewModel, ActivityLoginEmailBinding> implements View.OnClickListener, ClearEditText.CustomTextWatcher {
    /* access modifiers changed from: private */
    public boolean mIsAgree;
    private OtpLoginDialog mLoginDialog;
    private int mLoginType = 2;
    private boolean mShowPassword;
    private final String tag = "EmailLoginActivity";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EmailLoginActivity.kt */
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
    public ActivityLoginEmailBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityLoginEmailBinding inflate = ActivityLoginEmailBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        EmailLoginActivity.super.onCreate(bundle);
        overridePendingTransition(R.anim.dialog_bottom_in, R.anim.dialog_bottom_out);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        init();
        setListener();
    }

    public void startObserve() {
        getMViewModel().getAccountLoginData().observe((LifecycleOwner) this, new EmailLoginActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m68startObserve$lambda0(EmailLoginActivity emailLoginActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(emailLoginActivity, "this$0");
        emailLoginActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            UserBean userBean = (UserBean) stateData.getData();
            XesLog.dt("UserInfo", new Object[]{userBean});
            if (userBean != null) {
                ShareDataManager.getInstance().initUserSP(String.valueOf(userBean.getUid()));
                LoginIn.INSTANCE.loginInfo(userBean, true, (Context) emailLoginActivity, 1);
                StringBuilder sb = new StringBuilder();
                File externalCacheDir = emailLoginActivity.getApplication().getExternalCacheDir();
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
            emailLoginActivity.showLoginDialog(msg);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        emailLoginActivity.showToast(CommonKtxKt.formatBadResult(stateData));
    }

    private final void init() {
        this.mIsAgree = getIntent().getBooleanExtra(PasswordSettingsActivityKt.isAgree, false);
        setAgreeState();
        TextView textView = getBinding().loginAgreementTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.loginAgreementTips");
        JumpToAgreementUtil.INSTANCE.loginAgreementTips((Context) this, textView);
        XesDataBus.with("close_account_verification").observe((LifecycleOwner) this, new EmailLoginActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1  reason: not valid java name */
    public static final void m67init$lambda1(EmailLoginActivity emailLoginActivity, Object obj) {
        Intrinsics.checkNotNullParameter(emailLoginActivity, "this$0");
        emailLoginActivity.finish();
    }

    private final void setListener() {
        ClearEditText.CustomTextWatcher customTextWatcher = this;
        getBinding().etEmailAddress.addCustomTextWatcher(customTextWatcher);
        getBinding().etPassword.addCustomTextWatcher(customTextWatcher);
        View.OnClickListener onClickListener = this;
        getBinding().tvSkip.setOnClickListener(onClickListener);
        getBinding().ivPasswordEye.setOnClickListener(onClickListener);
        getBinding().tvOtpLogin.setOnClickListener(onClickListener);
        getBinding().tvForgetPassword.setOnClickListener(onClickListener);
        getBinding().ivLoginPhone.setOnClickListener(onClickListener);
        getBinding().ivLoginId.setOnClickListener(onClickListener);
        getBinding().ivAgree.setOnClickListener(onClickListener);
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvSignIn;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSignIn");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new EmailLoginActivity$setListener$1(this), 1, (Object) null);
    }

    private final void showLoginDialog(String str) {
        if (this.mLoginDialog == null) {
            this.mLoginDialog = new OtpLoginDialog((Context) this, new EmailLoginActivity$showLoginDialog$1(this));
        }
        OtpLoginDialog otpLoginDialog = this.mLoginDialog;
        if (otpLoginDialog != null) {
            otpLoginDialog.show(str);
        }
    }

    /* access modifiers changed from: private */
    public final void login() {
        KeyboardUtils.hideSoftInput((View) getBinding().etPassword);
        if (!this.mIsAgree) {
            showToast(getString(R.string.policies_tip));
            return;
        }
        showLoading();
        String obj = StringsKt.trim(String.valueOf(getBinding().etEmailAddress.getText())).toString();
        String password = PasswordUtil.INSTANCE.getPassword(String.valueOf(getBinding().etPassword.getText()));
        LoginTrack.INSTANCE.signInClick("邮箱", "密码登陆", 0);
        getMViewModel().accountLogin(obj, password, this.mLoginType, "", "邮箱", "密码登陆");
    }

    private final void setLoginState() {
        boolean isEmail = RegexUtils.isEmail(StringsKt.trim(String.valueOf(getBinding().etEmailAddress.getText())).toString());
        boolean z = true;
        boolean z2 = StringsKt.trim(String.valueOf(getBinding().etPassword.getText())).toString().length() >= 6;
        TextView textView = getBinding().tvSignIn;
        if (!isEmail || !z2) {
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
        MethodInfo.onClickEventEnter(view, EmailLoginActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.tv_otp_login;
        if (valueOf != null && valueOf.intValue() == i) {
            Intent intent = new Intent((Context) this, OtpLoginActivity.class);
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
                        int i5 = R.id.iv_login_phone;
                        if (valueOf != null && valueOf.intValue() == i5) {
                            Intent intent2 = new Intent((Context) this, PhoneLoginActivity.class);
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
                intent4.putExtra(PasswordSettingsActivityKt.accountName, StringsKt.trim(String.valueOf(getBinding().etEmailAddress.getText())).toString());
                intent4.putExtra(PasswordSettingsActivityKt.checkType, 2);
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
            getBinding().etEmailAddress.clearFocus();
            getBinding().etPassword.clearFocus();
        }
        return EmailLoginActivity.super.dispatchTouchEvent(motionEvent);
    }
}
