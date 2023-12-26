package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer;
import com.tal.app.thinkacademy.business.login.widget.PatternUtil;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@PadAutoCenterScreen(designHeight = 620.0f)
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J*\u0010#\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0016J\u0018\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000eH\u0014J\u0010\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000103H\u0002J\b\u00104\u001a\u00020 H\u0002J\u0012\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020 H\u0014J\b\u00109\u001a\u00020 H\u0016J*\u0010:\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010<\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020 H\u0002J\b\u0010>\u001a\u00020 H\u0002J\b\u0010?\u001a\u00020 H\u0002J\b\u0010@\u001a\u00020 H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/AccountVerificationActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/LoginViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/LiveLoginActivityAccountVerificationBinding;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "Lcom/tal/app/thinkacademy/business/login/widget/LoginCountDownTimer$ITimerListener;", "()V", "KTypeEmail", "", "KTypeSms", "TAG", "", "kotlin.jvm.PlatformType", "isOnDestroy", "", "isRightNumber", "mChangeCountryDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mChosenCountryIndex", "mContactInfo", "mCountryCallingCode", "mInitCountry", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "mIsLogin", "mPhoneLengthMax", "mPhoneLengthMin", "mTimer", "Lcom/tal/app/thinkacademy/business/login/widget/LoginCountDownTimer;", "mType", "Ljava/lang/Integer;", "mVerificationCode", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "changeStatus", "phoneLengthMax", "phoneLengthMin", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getInternationalList", "", "init", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onTextChanged", "before", "resetStatus", "setListener", "setLoginState", "showWheelDialog", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountVerificationActivity.kt */
public final class AccountVerificationActivity extends BaseVmActivity<LoginViewModel, LiveLoginActivityAccountVerificationBinding> implements ClearEditText.CustomTextWatcher, LoginCountDownTimer.ITimerListener {
    private final int KTypeEmail = 2;
    /* access modifiers changed from: private */
    public final int KTypeSms = 1;
    private final String TAG = "AccountVerificationActivity";
    private boolean isOnDestroy;
    /* access modifiers changed from: private */
    public boolean isRightNumber;
    private WheelDialog mChangeCountryDialog;
    /* access modifiers changed from: private */
    public int mChosenCountryIndex;
    /* access modifiers changed from: private */
    public String mContactInfo = "";
    /* access modifiers changed from: private */
    public String mCountryCallingCode = "";
    private ConfigInfo.Country mInitCountry;
    /* access modifiers changed from: private */
    public boolean mIsLogin = true;
    /* access modifiers changed from: private */
    public int mPhoneLengthMax = 99;
    /* access modifiers changed from: private */
    public int mPhoneLengthMin = 1;
    /* access modifiers changed from: private */
    public LoginCountDownTimer mTimer;
    /* access modifiers changed from: private */
    public Integer mType = 1;
    /* access modifiers changed from: private */
    public String mVerificationCode = "";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountVerificationActivity.kt */
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
        AccountVerificationActivity.super.onCreate(bundle);
        overridePendingTransition(R.anim.dialog_bottom_in, R.anim.dialog_bottom_out);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        init();
        setListener();
    }

    private final void init() {
        int i;
        Intent intent = getIntent();
        boolean z = true;
        this.mType = intent == null ? 1 : Integer.valueOf(intent.getIntExtra(PasswordSettingsActivityKt.checkType, 1));
        Intent intent2 = getIntent();
        String str = null;
        this.mContactInfo = intent2 == null ? null : intent2.getStringExtra(PasswordSettingsActivityKt.accountName);
        if (UserInfoBll.Companion.getInstance().isGuest()) {
            this.mIsLogin = false;
            ConstraintLayout constraintLayout = getBinding().layoutPhoneLogin;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            ConstraintLayout constraintLayout2 = getBinding().layoutEmailLogin;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            int i2 = this.KTypeSms;
            Integer num = this.mType;
            if (num != null && i2 == num.intValue()) {
                ClearEditText clearEditText = getBinding().etVerificationCode;
                if (clearEditText != null) {
                    clearEditText.setHint(getString(R.string.otp_code));
                }
                ConstraintLayout constraintLayout3 = getBinding().layoutPhoneNotLogin;
                if (constraintLayout3 != null) {
                    constraintLayout3.setVisibility(0);
                }
                ConstraintLayout constraintLayout4 = getBinding().layoutEmailNotLogin;
                if (constraintLayout4 != null) {
                    constraintLayout4.setVisibility(8);
                }
                Intent intent3 = getIntent();
                this.mChosenCountryIndex = intent3 == null ? 0 : Integer.valueOf(intent3.getIntExtra(AccountVerificationActivityKt.ChosenCountryIndex, 0)).intValue();
                List<ConfigInfo.Country> internationalList = getInternationalList();
                ConfigInfo.Country country = internationalList == null ? null : internationalList.get(this.mChosenCountryIndex);
                this.mInitCountry = country;
                if (country == null) {
                    i = 1;
                } else {
                    i = Integer.valueOf(country.getPhoneMinLength()).intValue();
                }
                this.mPhoneLengthMin = i;
                ConfigInfo.Country country2 = this.mInitCountry;
                this.mPhoneLengthMax = country2 == null ? 99 : Integer.valueOf(country2.getPhoneMaxLength()).intValue();
                ConfigInfo.Country country3 = this.mInitCountry;
                if (country3 != null) {
                    str = country3.getCountryCallingCode();
                }
                this.mCountryCallingCode = str;
                TextView textView = getBinding().tvCountryCode;
                if (textView != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getString(R.string.Login_format_call_code);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Login_format_call_code)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{this.mCountryCallingCode}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    textView.setText(format);
                }
                ClearEditText clearEditText2 = getBinding().etPhoneNumber;
                if (clearEditText2 != null) {
                    clearEditText2.setText(this.mContactInfo);
                }
                ClearEditText clearEditText3 = getBinding().etPhoneNumber;
                if (clearEditText3 != null) {
                    clearEditText3.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
                }
                getBinding().etPhoneNumber.addCustomTextWatcher(this);
                TextView textView2 = getBinding().tvSend;
                int i3 = this.mPhoneLengthMin;
                int i4 = this.mPhoneLengthMax;
                String str2 = this.mContactInfo;
                int length = str2 == null ? 0 : str2.length();
                if (i3 > length || length > i4) {
                    z = false;
                }
                textView2.setEnabled(z);
            } else {
                ClearEditText clearEditText4 = getBinding().etVerificationCode;
                if (clearEditText4 != null) {
                    clearEditText4.setHint(getString(R.string.verification_code));
                }
                ConstraintLayout constraintLayout5 = getBinding().layoutPhoneNotLogin;
                if (constraintLayout5 != null) {
                    constraintLayout5.setVisibility(8);
                }
                ConstraintLayout constraintLayout6 = getBinding().layoutPhoneLogin;
                if (constraintLayout6 != null) {
                    constraintLayout6.setVisibility(8);
                }
                ConstraintLayout constraintLayout7 = getBinding().layoutEmailNotLogin;
                if (constraintLayout7 != null) {
                    constraintLayout7.setVisibility(0);
                }
                ClearEditText clearEditText5 = getBinding().etEmailNumber;
                if (clearEditText5 != null) {
                    clearEditText5.setText(this.mContactInfo);
                }
                getBinding().etEmailNumber.addCustomTextWatcher(this);
                getBinding().tvSend.setEnabled(PatternUtil.INSTANCE.emailIsCompliance(this.mContactInfo));
            }
        } else {
            this.mIsLogin = true;
            getBinding().tvSend.setEnabled(true);
            ConstraintLayout constraintLayout8 = getBinding().layoutPhoneNotLogin;
            if (constraintLayout8 != null) {
                constraintLayout8.setVisibility(8);
            }
            ConstraintLayout constraintLayout9 = getBinding().layoutEmailNotLogin;
            if (constraintLayout9 != null) {
                constraintLayout9.setVisibility(8);
            }
            int i5 = this.KTypeSms;
            Integer num2 = this.mType;
            if (num2 != null && i5 == num2.intValue()) {
                ClearEditText clearEditText6 = getBinding().etVerificationCode;
                if (clearEditText6 != null) {
                    clearEditText6.setHint(getString(R.string.otp_code));
                }
                ConstraintLayout constraintLayout10 = getBinding().layoutPhoneLogin;
                if (constraintLayout10 != null) {
                    constraintLayout10.setVisibility(0);
                }
                ConstraintLayout constraintLayout11 = getBinding().layoutEmailLogin;
                if (constraintLayout11 != null) {
                    constraintLayout11.setVisibility(8);
                }
                TextView textView3 = getBinding().phoneNumberLogin;
                if (textView3 != null) {
                    textView3.setText(this.mContactInfo);
                }
                Intent intent4 = getIntent();
                if (intent4 != null) {
                    str = intent4.getStringExtra(PasswordSettingsActivityKt.countryCallingCode);
                }
                this.mCountryCallingCode = str;
                TextView textView4 = getBinding().tvCountryCodeLogin;
                if (textView4 != null) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string2 = getString(R.string.Login_format_call_code);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.Login_format_call_code)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.mCountryCallingCode}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    textView4.setText(format2);
                }
            } else {
                ClearEditText clearEditText7 = getBinding().etVerificationCode;
                if (clearEditText7 != null) {
                    clearEditText7.setHint(getString(R.string.verification_code));
                }
                ConstraintLayout constraintLayout12 = getBinding().layoutPhoneLogin;
                if (constraintLayout12 != null) {
                    constraintLayout12.setVisibility(8);
                }
                ConstraintLayout constraintLayout13 = getBinding().layoutEmailLogin;
                if (constraintLayout13 != null) {
                    constraintLayout13.setVisibility(0);
                }
                TextView textView5 = getBinding().emailNumberLogin;
                if (textView5 != null) {
                    textView5.setText(this.mContactInfo);
                }
            }
        }
        getBinding().etVerificationCode.addCustomTextWatcher(this);
    }

    private final void setListener() {
        ImageView imageView = getBinding().icBack;
        if (imageView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView, 500, new AccountVerificationActivity$setListener$1(this));
        }
        TextView textView = getBinding().tvCountryCode;
        if (textView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(textView, 500, new AccountVerificationActivity$setListener$2(this));
        }
        TextView textView2 = getBinding().tvSend;
        if (textView2 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(textView2, 500, new AccountVerificationActivity$setListener$3(this));
        }
        TextView textView3 = getBinding().tvNextStep;
        if (textView3 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(textView3, 500, new AccountVerificationActivity$setListener$4(this));
        }
        XesDataBus.with("close_account_verification").observe((LifecycleOwner) this, new AccountVerificationActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-0  reason: not valid java name */
    public static final void m56setListener$lambda0(AccountVerificationActivity accountVerificationActivity, Object obj) {
        Intrinsics.checkNotNullParameter(accountVerificationActivity, "this$0");
        if (!accountVerificationActivity.isOnDestroy) {
            accountVerificationActivity.finish();
        }
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getCodeData().observe(lifecycleOwner, new AccountVerificationActivity$$ExternalSyntheticLambda0(this));
        getMViewModel().getSecurityCheckData().observe(lifecycleOwner, new AccountVerificationActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m57startObserve$lambda1(AccountVerificationActivity accountVerificationActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(accountVerificationActivity, "this$0");
        accountVerificationActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            accountVerificationActivity.getBinding().tvSend.setText(accountVerificationActivity.getText(R.string.resend));
            LoginCountDownTimer loginCountDownTimer = accountVerificationActivity.mTimer;
            if (loginCountDownTimer != null) {
                loginCountDownTimer.start();
                return;
            }
            return;
        }
        accountVerificationActivity.getBinding().tvSend.setEnabled(true);
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        accountVerificationActivity.showToast(CommonKtxKt.formatBadResult(stateData));
        XesLog.et(accountVerificationActivity.TAG, new Object[]{Intrinsics.stringPlus("codeData--", stateData.getMsg())});
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-3  reason: not valid java name */
    public static final void m58startObserve$lambda3(AccountVerificationActivity accountVerificationActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(accountVerificationActivity, "this$0");
        accountVerificationActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            XesLog.dt(accountVerificationActivity.TAG, new Object[]{"loginData--SUCCESS"});
            Intent intent = new Intent((Context) accountVerificationActivity, PasswordSettingsActivity.class);
            intent.putExtra(PasswordSettingsActivityKt.accountName, accountVerificationActivity.mContactInfo);
            intent.putExtra(PasswordSettingsActivityKt.verificationCode, accountVerificationActivity.mVerificationCode);
            intent.putExtra(PasswordSettingsActivityKt.countryCallingCode, accountVerificationActivity.mCountryCallingCode);
            intent.putExtra(PasswordSettingsActivityKt.checkType, accountVerificationActivity.mType);
            intent.putExtra(PasswordSettingsActivityKt.isShowSkip, false);
            accountVerificationActivity.startActivity(intent);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        accountVerificationActivity.showToast(CommonKtxKt.formatBadResult(stateData));
        XesLog.et(accountVerificationActivity.TAG, new Object[]{"loginData--ERROR"});
    }

    public void onFinish() {
        getBinding().tvSend.setEnabled(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(android.text.Editable r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.getCurrentFocus()
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etPhoneNumber
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r2 = 1
            if (r1 == 0) goto L_0x0015
            r0 = r2
            goto L_0x0021
        L_0x0015:
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etEmailNumber
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x0021:
            if (r0 == 0) goto L_0x0087
            boolean r0 = r4.mIsLogin
            r1 = 0
            if (r0 == 0) goto L_0x002a
        L_0x0028:
            r5 = r2
            goto L_0x0054
        L_0x002a:
            java.lang.Integer r0 = r4.mType
            int r3 = r4.KTypeSms
            if (r0 != 0) goto L_0x0031
            goto L_0x004a
        L_0x0031:
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x004a
            int r0 = r4.mPhoneLengthMin
            int r3 = r4.mPhoneLengthMax
            if (r5 != 0) goto L_0x003f
            r5 = r1
            goto L_0x0043
        L_0x003f:
            int r5 = r5.length()
        L_0x0043:
            if (r0 > r5) goto L_0x0048
            if (r5 > r3) goto L_0x0048
            goto L_0x0028
        L_0x0048:
            r5 = r1
            goto L_0x0054
        L_0x004a:
            com.tal.app.thinkacademy.business.login.widget.PatternUtil r0 = com.tal.app.thinkacademy.business.login.widget.PatternUtil.INSTANCE
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r5 = r0.emailIsCompliance(r5)
        L_0x0054:
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r0 = r4.mTimer
            if (r0 != 0) goto L_0x0064
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r0
            android.widget.TextView r0 = r0.tvSend
            r0.setEnabled(r5)
            goto L_0x0087
        L_0x0064:
            if (r0 != 0) goto L_0x0068
        L_0x0066:
            r2 = r1
            goto L_0x006e
        L_0x0068:
            boolean r0 = r0.isTick()
            if (r0 != r2) goto L_0x0066
        L_0x006e:
            if (r2 == 0) goto L_0x007c
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r5 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r5
            android.widget.TextView r5 = r5.tvSend
            r5.setEnabled(r1)
            goto L_0x0087
        L_0x007c:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r0
            android.widget.TextView r0 = r0.tvSend
            r0.setEnabled(r5)
        L_0x0087:
            r4.setLoginState()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity.afterTextChanged(android.text.Editable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r3 = kotlin.text.StringsKt.trim((r3 = (r3 = r3.getText()).toString())).toString();
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setLoginState() {
        /*
            r5 = this;
            boolean r0 = r5.mIsLogin
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0009
        L_0x0006:
            r0 = r1
            goto L_0x0069
        L_0x0009:
            java.lang.Integer r0 = r5.mType
            int r3 = r5.KTypeSms
            if (r0 != 0) goto L_0x0010
            goto L_0x004c
        L_0x0010:
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x004c
            int r0 = r5.mPhoneLengthMin
            int r3 = r5.mPhoneLengthMax
            androidx.viewbinding.ViewBinding r4 = r5.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r4 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r4
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r4 = r4.etPhoneNumber
            if (r4 != 0) goto L_0x0026
        L_0x0024:
            r4 = r2
            goto L_0x0045
        L_0x0026:
            android.text.Editable r4 = r4.getText()
            if (r4 != 0) goto L_0x002d
            goto L_0x0024
        L_0x002d:
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L_0x0034
            goto L_0x0024
        L_0x0034:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r4 = kotlin.text.StringsKt.trim(r4)
            java.lang.String r4 = r4.toString()
            if (r4 != 0) goto L_0x0041
            goto L_0x0024
        L_0x0041:
            int r4 = r4.length()
        L_0x0045:
            if (r0 > r4) goto L_0x004a
            if (r4 > r3) goto L_0x004a
            goto L_0x0006
        L_0x004a:
            r0 = r2
            goto L_0x0069
        L_0x004c:
            com.tal.app.thinkacademy.business.login.widget.PatternUtil r0 = com.tal.app.thinkacademy.business.login.widget.PatternUtil.INSTANCE
            androidx.viewbinding.ViewBinding r3 = r5.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r3 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r3
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r3 = r3.etEmailNumber
            r4 = 0
            if (r3 != 0) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            android.text.Editable r3 = r3.getText()
            if (r3 != 0) goto L_0x0061
            goto L_0x0065
        L_0x0061:
            java.lang.String r4 = r3.toString()
        L_0x0065:
            boolean r0 = r0.emailIsCompliance(r4)
        L_0x0069:
            androidx.viewbinding.ViewBinding r3 = r5.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r3 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r3
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r3 = r3.etVerificationCode
            if (r3 != 0) goto L_0x0075
        L_0x0073:
            r3 = r2
            goto L_0x0098
        L_0x0075:
            android.text.Editable r3 = r3.getText()
            if (r3 != 0) goto L_0x007c
            goto L_0x0073
        L_0x007c:
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0083
            goto L_0x0073
        L_0x0083:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim(r3)
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0090
            goto L_0x0073
        L_0x0090:
            int r3 = r3.length()
            r4 = 6
            if (r3 != r4) goto L_0x0073
            r3 = r1
        L_0x0098:
            androidx.viewbinding.ViewBinding r4 = r5.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r4 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r4
            android.widget.TextView r4 = r4.tvNextStep
            if (r4 != 0) goto L_0x00a3
            goto L_0x00ac
        L_0x00a3:
            if (r0 == 0) goto L_0x00a8
            if (r3 == 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r1 = r2
        L_0x00a9:
            r4.setEnabled(r1)
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity.setLoginState():void");
    }

    /* access modifiers changed from: private */
    public final void showWheelDialog() {
        if (this.mChangeCountryDialog == null) {
            WheelDialog wheelDialog = new WheelDialog((Context) this, new AccountVerificationActivity$showWheelDialog$1(this), (Function0) null, 4, (DefaultConstructorMarker) null);
            this.mChangeCountryDialog = wheelDialog;
            wheelDialog.setWheelAdapter(new AccountVerificationActivity$showWheelDialog$2(this));
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

    /* access modifiers changed from: private */
    public final void resetStatus() {
        getBinding().etPhoneNumber.setText("");
        getBinding().tvSend.setEnabled(false);
        LoginCountDownTimer loginCountDownTimer = this.mTimer;
        if (!(loginCountDownTimer == null || loginCountDownTimer == null)) {
            loginCountDownTimer.reset();
        }
        getBinding().tvSecond.setVisibility(8);
        getBinding().tvSend.setText(getText(R.string.send));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        if ((r6 <= r0 && r0 <= r5) != false) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void changeStatus(int r5, int r6) {
        /*
            r4 = this;
            boolean r0 = r4.mIsLogin
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0009
        L_0x0006:
            r1 = r2
            goto L_0x00a9
        L_0x0009:
            java.lang.Integer r0 = r4.mType
            int r3 = r4.KTypeSms
            if (r0 != 0) goto L_0x0011
            goto L_0x007f
        L_0x0011:
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x007f
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r0
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.etPhoneNumber
            android.text.Editable r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0030
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r0 = r1
            goto L_0x0031
        L_0x0030:
            r0 = r2
        L_0x0031:
            if (r0 != 0) goto L_0x0051
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r0
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.etPhoneNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r0 = r0.length()
            if (r6 > r0) goto L_0x004d
            if (r0 > r5) goto L_0x004d
            r5 = r2
            goto L_0x004e
        L_0x004d:
            r5 = r1
        L_0x004e:
            if (r5 == 0) goto L_0x0051
            goto L_0x0006
        L_0x0051:
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r5 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r5
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r5 = r5.etPhoneNumber
            android.text.Editable r5 = r5.getText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0069
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r2 = r1
        L_0x0069:
            if (r2 == 0) goto L_0x0075
            int r5 = com.tal.app.thinkacademy.business.login.R.string.login_phone_number_empty
            java.lang.String r5 = r4.getString(r5)
            r4.showToast(r5)
            goto L_0x00a9
        L_0x0075:
            int r5 = com.tal.app.thinkacademy.business.login.R.string.login_phone_number_error
            java.lang.String r5 = r4.getString(r5)
            r4.showToast(r5)
            goto L_0x00a9
        L_0x007f:
            com.tal.app.thinkacademy.business.login.widget.PatternUtil r5 = com.tal.app.thinkacademy.business.login.widget.PatternUtil.INSTANCE
            androidx.viewbinding.ViewBinding r6 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r6 = (com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding) r6
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = r6.etEmailNumber
            r0 = 0
            if (r6 != 0) goto L_0x008d
            goto L_0x0098
        L_0x008d:
            android.text.Editable r6 = r6.getText()
            if (r6 != 0) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            java.lang.String r0 = r6.toString()
        L_0x0098:
            boolean r5 = r5.emailIsCompliance(r0)
            if (r5 == 0) goto L_0x00a0
            goto L_0x0006
        L_0x00a0:
            int r5 = com.tal.app.thinkacademy.business.login.R.string.login_email_number_empty
            java.lang.String r5 = r4.getString(r5)
            r4.showToast(r5)
        L_0x00a9:
            r4.isRightNumber = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity.changeStatus(int, int):void");
    }

    /* access modifiers changed from: private */
    public final List<ConfigInfo.Country> getInternationalList() {
        return ImConfig.INSTANCE.getInternationalInfo();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            getBinding().etPhoneNumber.clearFocus();
            getBinding().etVerificationCode.clearFocus();
        }
        return AccountVerificationActivity.super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AccountVerificationActivity.super.onDestroy();
        this.isOnDestroy = true;
        LoginCountDownTimer loginCountDownTimer = this.mTimer;
        if (loginCountDownTimer != null) {
            if (loginCountDownTimer != null) {
                loginCountDownTimer.cancel();
            }
            this.mTimer = null;
        }
    }

    /* access modifiers changed from: protected */
    public LiveLoginActivityAccountVerificationBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveLoginActivityAccountVerificationBinding inflate = LiveLoginActivityAccountVerificationBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
