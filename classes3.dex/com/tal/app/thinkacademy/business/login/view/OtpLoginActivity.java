package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer;
import com.tal.app.thinkacademy.business.login.widget.PatternUtil;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.ChosenSchoolBean;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesUploadPrinter;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;

@PadAutoCenterScreen(designHeight = 620.0f)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0002J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0014J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\b\u00100\u001a\u00020\u001aH\u0002J\u0012\u00101\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020\u001aH\u0014J\b\u00108\u001a\u00020\u001aH\u0016J*\u00109\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010:\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020\u001aH\u0002J\b\u0010<\u001a\u00020\u001aH\u0002J\b\u0010=\u001a\u00020\u001aH\u0002J\b\u0010>\u001a\u00020\u001aH\u0002J\b\u0010?\u001a\u00020\u001aH\u0002J\b\u0010@\u001a\u00020\u001aH\u0002J\u0012\u0010A\u001a\u00020\u001a2\b\b\u0002\u0010B\u001a\u00020\tH\u0002J\b\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/OtpLoginActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/LoginViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityLoginOtpBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "Lcom/tal/app/thinkacademy/business/login/widget/LoginCountDownTimer$ITimerListener;", "()V", "isRightPhoneNumber", "", "mChangeCountryDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mChosenCountryIndex", "", "mChosenSchoolBean", "Lcom/tal/app/thinkacademy/common/entity/ChosenSchoolBean;", "mEmailTimer", "Lcom/tal/app/thinkacademy/business/login/widget/LoginCountDownTimer;", "mFromPath", "", "mIsAgree", "mLoginType", "mPhoneLengthMax", "mPhoneLengthMin", "mSmsTimer", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "changeStatus", "phoneLengthMax", "phoneLengthMin", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getInternationalList", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "init", "login", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinish", "onTextChanged", "before", "resetStatus", "setAgreeState", "setListener", "setLoginState", "showEmailLogin", "showPhoneLogin", "showTitle", "show", "showWheelDialog", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OtpLoginActivity.kt */
public final class OtpLoginActivity extends BaseVmActivity<LoginViewModel, ActivityLoginOtpBinding> implements View.OnClickListener, ClearEditText.CustomTextWatcher, LoginCountDownTimer.ITimerListener {
    /* access modifiers changed from: private */
    public boolean isRightPhoneNumber;
    private WheelDialog mChangeCountryDialog;
    /* access modifiers changed from: private */
    public int mChosenCountryIndex;
    private ChosenSchoolBean mChosenSchoolBean;
    /* access modifiers changed from: private */
    public LoginCountDownTimer mEmailTimer;
    private String mFromPath;
    private boolean mIsAgree;
    /* access modifiers changed from: private */
    public int mLoginType;
    /* access modifiers changed from: private */
    public int mPhoneLengthMax;
    /* access modifiers changed from: private */
    public int mPhoneLengthMin;
    /* access modifiers changed from: private */
    public LoginCountDownTimer mSmsTimer;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OtpLoginActivity.kt */
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
        OtpLoginActivity.super.onCreate(bundle);
        overridePendingTransition(R.anim.dialog_bottom_in, R.anim.dialog_bottom_out);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        init();
        setListener();
    }

    private final void init() {
        this.mFromPath = getIntent().getStringExtra("login_page_path");
        if (getIntent().getBooleanExtra(PasswordSettingsActivityKt.isEmailLogin, false)) {
            getBinding().rbEmail.setChecked(true);
            showEmailLogin();
        }
        this.mChosenCountryIndex = getIntent().getIntExtra(AccountVerificationActivityKt.ChosenCountryIndex, -1);
        this.mChosenSchoolBean = (ChosenSchoolBean) ShareDataManager.getInstance().getCacheEntity(ChosenSchoolBean.class, "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
        this.mIsAgree = getIntent().getBooleanExtra(PasswordSettingsActivityKt.isAgree, false);
        setAgreeState();
        if (this.mChosenSchoolBean != null) {
            if (this.mChosenCountryIndex == -1) {
                TextView textView = getBinding().tvCountryCode;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.Login_format_call_code);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Login_format_call_code)");
                Object[] objArr = new Object[1];
                ChosenSchoolBean chosenSchoolBean = this.mChosenSchoolBean;
                objArr[0] = chosenSchoolBean == null ? null : chosenSchoolBean.countryCallingCode;
                String format = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView.setText(format);
                ChosenSchoolBean chosenSchoolBean2 = this.mChosenSchoolBean;
                this.mPhoneLengthMin = chosenSchoolBean2 == null ? 1 : chosenSchoolBean2.phoneMinLength;
                ChosenSchoolBean chosenSchoolBean3 = this.mChosenSchoolBean;
                this.mPhoneLengthMax = chosenSchoolBean3 == null ? 99 : chosenSchoolBean3.phoneMaxLength;
                SchoolConstants schoolConstants = SchoolConstants.INSTANCE;
                ChosenSchoolBean chosenSchoolBean4 = this.mChosenSchoolBean;
                SchoolDataInfo schoolInfo = schoolConstants.getSchoolInfo(chosenSchoolBean4 == null ? 0 : chosenSchoolBean4.schoolCode);
                if (schoolInfo != null) {
                    this.mPhoneLengthMin = schoolInfo.getPhoneMinLength();
                    this.mPhoneLengthMax = schoolInfo.getPhoneMaxLength();
                }
                getBinding().etPhoneNumber.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
                if (getInternationalList() != null) {
                    List<ConfigInfo.Country> internationalList = getInternationalList();
                    if (internationalList != null) {
                        Iterator it = internationalList.iterator();
                        int i = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            ConfigInfo.Country country = (ConfigInfo.Country) next;
                            ChosenSchoolBean chosenSchoolBean5 = this.mChosenSchoolBean;
                            if (Intrinsics.areEqual((Object) chosenSchoolBean5 == null ? null : chosenSchoolBean5.countryCallingCode, (Object) country.getCountryCallingCode())) {
                                this.mChosenCountryIndex = i;
                                this.mPhoneLengthMin = country.getPhoneMinLength();
                                this.mPhoneLengthMax = country.getPhoneMaxLength();
                                getBinding().etPhoneNumber.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
                                break;
                            }
                            i = i2;
                        }
                    }
                } else {
                    return;
                }
            } else {
                List<ConfigInfo.Country> internationalList2 = getInternationalList();
                if (internationalList2 != null) {
                    ConfigInfo.Country country2 = internationalList2.get(this.mChosenCountryIndex);
                    TextView textView2 = getBinding().tvCountryCode;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string2 = getString(R.string.Login_format_call_code);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.Login_format_call_code)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{country2.getCountryCallingCode()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    textView2.setText(format2);
                    this.mPhoneLengthMin = country2.getPhoneMinLength();
                    this.mPhoneLengthMax = country2.getPhoneMaxLength();
                    getBinding().etPhoneNumber.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter(), new InputFilter.LengthFilter(this.mPhoneLengthMax)});
                }
            }
        }
        TextView textView3 = getBinding().loginAgreementTips;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.loginAgreementTips");
        JumpToAgreementUtil.INSTANCE.loginAgreementTips((Context) this, textView3);
        HashMap hashMap = new HashMap();
        hashMap.put("login_page_path", this.mFromPath);
        LeanplumUtil.commonTrack("login_page_pv", hashMap);
        String stringExtra = getIntent().getStringExtra("login_source");
        if (stringExtra != null) {
            LoginTrack.INSTANCE.registerPupPv(stringExtra);
        }
    }

    private final void setListener() {
        ClearEditText.CustomTextWatcher customTextWatcher = this;
        getBinding().etPhoneNumber.addCustomTextWatcher(customTextWatcher);
        getBinding().etSmsCode.addCustomTextWatcher(customTextWatcher);
        getBinding().etEmailAddress.addCustomTextWatcher(customTextWatcher);
        getBinding().etEmailCode.addCustomTextWatcher(customTextWatcher);
        getBinding().rgSwitch.setOnCheckedChangeListener(new OtpLoginActivity$$ExternalSyntheticLambda0(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvSmsSend;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSmsSend");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new OtpLoginActivity$setListener$2(this), 1, (Object) null);
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        TextView textView2 = getBinding().tvEmailSend;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvEmailSend");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil2, textView2, 0, new OtpLoginActivity$setListener$3(this), 1, (Object) null);
        RxUnDoubleUtil rxUnDoubleUtil3 = RxUnDoubleUtil.INSTANCE;
        TextView textView3 = getBinding().tvCountryCode;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvCountryCode");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil3, textView3, 0, new OtpLoginActivity$setListener$4(this), 1, (Object) null);
        RxUnDoubleUtil rxUnDoubleUtil4 = RxUnDoubleUtil.INSTANCE;
        TextView textView4 = getBinding().tvSignIn;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvSignIn");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil4, textView4, 0, new OtpLoginActivity$setListener$5(this), 1, (Object) null);
        View.OnClickListener onClickListener = this;
        getBinding().ivAgree.setOnClickListener(onClickListener);
        getBinding().tvSkip.setOnClickListener(onClickListener);
        getBinding().tvPasswordLogin.setOnClickListener(onClickListener);
        KeyboardVisibilityEvent.setEventListener((Activity) this, (LifecycleOwner) this, new OtpLoginActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-5  reason: not valid java name */
    public static final void m99setListener$lambda5(OtpLoginActivity otpLoginActivity, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(otpLoginActivity, "this$0");
        if (i == R.id.rb_phone) {
            otpLoginActivity.showPhoneLogin();
        } else if (i == R.id.rb_email) {
            otpLoginActivity.showEmailLogin();
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-6  reason: not valid java name */
    public static final void m100setListener$lambda6(OtpLoginActivity otpLoginActivity, boolean z) {
        Intrinsics.checkNotNullParameter(otpLoginActivity, "this$0");
        if (!z) {
            showTitle$default(otpLoginActivity, false, 1, (Object) null);
        } else {
            otpLoginActivity.showTitle(false);
        }
    }

    private final void showPhoneLogin() {
        this.mLoginType = 0;
        getBinding().groupSms.setVisibility(0);
        getBinding().groupEmail.setVisibility(8);
        getBinding().tvDecs.setText(getString(R.string.otp_sms_desc));
        setLoginState();
    }

    private final void showEmailLogin() {
        this.mLoginType = 2;
        getBinding().groupSms.setVisibility(8);
        getBinding().groupEmail.setVisibility(0);
        getBinding().tvDecs.setText(getString(R.string.otp_email_desc));
        setLoginState();
    }

    static /* synthetic */ void showTitle$default(OtpLoginActivity otpLoginActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        otpLoginActivity.showTitle(z);
    }

    private final void showTitle(boolean z) {
        if (z) {
            getBinding().groupTitle.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = getBinding().rgSwitch.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.getMarginStart(), SizeUtils.dp2px(20.0f), layoutParams2.getMarginEnd(), 0);
            getBinding().rgSwitch.setLayoutParams(layoutParams2);
            return;
        }
        getBinding().groupTitle.setVisibility(8);
        ViewGroup.LayoutParams layoutParams3 = getBinding().rgSwitch.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.setMargins(layoutParams4.getMarginStart(), SizeUtils.dp2px(120.0f), layoutParams4.getMarginEnd(), 0);
        getBinding().rgSwitch.setLayoutParams(layoutParams4);
    }

    public void onFinish() {
        LoginCountDownTimer loginCountDownTimer = this.mEmailTimer;
        boolean z = false;
        if (loginCountDownTimer != null && !loginCountDownTimer.isTick()) {
            getBinding().tvEmailSend.setEnabled(true);
        }
        LoginCountDownTimer loginCountDownTimer2 = this.mSmsTimer;
        if (loginCountDownTimer2 != null && !loginCountDownTimer2.isTick()) {
            z = true;
        }
        if (z) {
            getBinding().tvSmsSend.setEnabled(true);
        }
    }

    private final void setLoginState() {
        String obj = StringsKt.trim(String.valueOf(getBinding().etPhoneNumber.getText())).toString();
        int i = this.mPhoneLengthMin;
        int i2 = this.mPhoneLengthMax;
        int length = obj.length();
        boolean z = true;
        boolean z2 = i <= length && length <= i2;
        boolean z3 = StringsKt.trim(String.valueOf(getBinding().etSmsCode.getText())).toString().length() == 6;
        boolean emailIsCompliance = PatternUtil.INSTANCE.emailIsCompliance(StringsKt.trim(String.valueOf(getBinding().etEmailAddress.getText())).toString());
        boolean z4 = StringsKt.trim(String.valueOf(getBinding().etEmailCode.getText())).toString().length() == 6;
        if (this.mLoginType == 0) {
            TextView textView = getBinding().tvSignIn;
            if (!z2 || !z3) {
                z = false;
            }
            textView.setEnabled(z);
            return;
        }
        TextView textView2 = getBinding().tvSignIn;
        if (!emailIsCompliance || !z4) {
            z = false;
        }
        textView2.setEnabled(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(android.text.Editable r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.getCurrentFocus()
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r1 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etPhoneNumber
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0063
            r0 = 0
            if (r5 != 0) goto L_0x0017
            r1 = r0
            goto L_0x001b
        L_0x0017:
            int r1 = r5.length()
        L_0x001b:
            int r2 = r4.mPhoneLengthMax
            r3 = 1
            if (r1 > r2) goto L_0x002e
            if (r5 != 0) goto L_0x0024
            r5 = r0
            goto L_0x0028
        L_0x0024:
            int r5 = r5.length()
        L_0x0028:
            int r1 = r4.mPhoneLengthMin
            if (r5 < r1) goto L_0x002e
            r5 = r3
            goto L_0x002f
        L_0x002e:
            r5 = r0
        L_0x002f:
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r1 = r4.mSmsTimer
            if (r1 != 0) goto L_0x003f
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r0
            android.widget.TextView r0 = r0.tvSmsSend
            r0.setEnabled(r5)
            goto L_0x008a
        L_0x003f:
            if (r1 != 0) goto L_0x0043
        L_0x0041:
            r3 = r0
            goto L_0x0049
        L_0x0043:
            boolean r1 = r1.isTick()
            if (r1 != r3) goto L_0x0041
        L_0x0049:
            if (r3 == 0) goto L_0x0057
            androidx.viewbinding.ViewBinding r5 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r5 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r5
            android.widget.TextView r5 = r5.tvSmsSend
            r5.setEnabled(r0)
            goto L_0x008a
        L_0x0057:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r0
            android.widget.TextView r0 = r0.tvSmsSend
            r0.setEnabled(r5)
            goto L_0x008a
        L_0x0063:
            android.view.View r0 = r4.getCurrentFocus()
            androidx.viewbinding.ViewBinding r1 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r1 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etEmailAddress
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x008a
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r0 = r4.mEmailTimer
            if (r0 != 0) goto L_0x008a
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r0
            android.widget.TextView r0 = r0.tvEmailSend
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = com.tal.app.thinkacademy.lib.util.RegexUtils.isEmail(r5)
            r0.setEnabled(r5)
        L_0x008a:
            r4.setLoginState()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.OtpLoginActivity.afterTextChanged(android.text.Editable):void");
    }

    /* access modifiers changed from: private */
    public final void login() {
        if (!this.mIsAgree) {
            showToast(getString(R.string.policies_tip));
            return;
        }
        showLoading();
        if (this.mLoginType == 0) {
            LoginTrack.INSTANCE.signInClick("手机号", "验证码", 0);
            String obj = StringsKt.trim(String.valueOf(getBinding().etPhoneNumber.getText())).toString();
            CharSequence text = getBinding().tvCountryCode.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvCountryCode.text");
            getMViewModel().codeLogin(StringsKt.trim(text.subSequence(1, text.length()).toString()).toString(), StringsKt.trim(String.valueOf(getBinding().etSmsCode.getText())).toString(), obj, this.mLoginType, "手机号", "验证码");
            return;
        }
        LoginTrack.INSTANCE.signInClick("邮箱", "验证码", 0);
        getMViewModel().codeLogin("", StringsKt.trim(String.valueOf(getBinding().etEmailCode.getText())).toString(), StringsKt.trim(String.valueOf(getBinding().etEmailAddress.getText())).toString(), this.mLoginType, "邮箱", "验证码");
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getCodeData().observe(lifecycleOwner, new OtpLoginActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().getLoginData().observe(lifecycleOwner, new OtpLoginActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-7  reason: not valid java name */
    public static final void m101startObserve$lambda7(OtpLoginActivity otpLoginActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(otpLoginActivity, "this$0");
        otpLoginActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            if (otpLoginActivity.mLoginType == 0) {
                otpLoginActivity.getBinding().tvSmsSend.setEnabled(true);
            } else {
                otpLoginActivity.getBinding().tvEmailSend.setEnabled(true);
            }
            Intrinsics.checkNotNullExpressionValue(stateData, "it");
            otpLoginActivity.showToast(CommonKtxKt.formatBadResult(stateData));
            XesLog.et("UserInfo", new Object[]{stateData.getMsg()});
        } else if (otpLoginActivity.mLoginType == 0) {
            otpLoginActivity.getBinding().tvSmsSend.setText(otpLoginActivity.getText(R.string.resend));
            LoginCountDownTimer loginCountDownTimer = otpLoginActivity.mSmsTimer;
            if (loginCountDownTimer != null) {
                loginCountDownTimer.start();
            }
        } else {
            otpLoginActivity.getBinding().tvEmailSend.setText(otpLoginActivity.getText(R.string.resend));
            LoginCountDownTimer loginCountDownTimer2 = otpLoginActivity.mEmailTimer;
            if (loginCountDownTimer2 != null) {
                loginCountDownTimer2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-9  reason: not valid java name */
    public static final void m102startObserve$lambda9(OtpLoginActivity otpLoginActivity, StateData stateData) {
        OtpLoginActivity otpLoginActivity2 = otpLoginActivity;
        Intrinsics.checkNotNullParameter(otpLoginActivity2, "this$0");
        otpLoginActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            UserBean userBean = (UserBean) stateData.getData();
            XesLog.dt("UserInfo", new Object[]{userBean});
            if (userBean != null) {
                String obj = StringsKt.trim(String.valueOf(otpLoginActivity.getBinding().etPhoneNumber.getText())).toString();
                CharSequence text = otpLoginActivity.getBinding().tvCountryCode.getText();
                Intrinsics.checkNotNullExpressionValue(text, "binding.tvCountryCode.text");
                LeanplumUtil.longTrack$default("click_login", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, obj, StringsKt.trim(text.subSequence(1, text.length()).toString()).toString(), (String) null, (String) null, (String) null, 14846, (Object) null);
                ShareDataManager.getInstance().initUserSP(String.valueOf(userBean.getUid()));
                boolean z = ShareDataManager.getInstance().getBoolean("show_set_password", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
                Context context = (Context) otpLoginActivity2;
                LoginIn.INSTANCE.loginInfo(userBean, true, context, 1);
                if (!userBean.getPasswordModified() && !z) {
                    Intent intent = new Intent(context, PasswordSettingsActivity.class);
                    intent.putExtra(PasswordSettingsActivityKt.accountName, userBean.getPhone());
                    intent.putExtra(PasswordSettingsActivityKt.countryCallingCode, userBean.getCountryCallingCode());
                    otpLoginActivity2.startActivity(intent);
                    ShareDataManager.getInstance().put("show_set_password", true, ShareDataManager.SHAREDATA_NOT_CLEAR);
                }
                StringBuilder sb = new StringBuilder();
                File externalCacheDir = otpLoginActivity.getApplication().getExternalCacheDir();
                sb.append(externalCacheDir == null ? null : externalCacheDir.getAbsolutePath());
                sb.append(File.separator);
                sb.append("xesxeslog");
                XesUploadPrinter.getInstance(sb.toString()).setUserInfo(String.valueOf(userBean.getUid()), ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), userBean.getUnifiedAccessToken());
                ShareDataManager.getInstance().put("modify_nickname", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
                return;
            }
            return;
        }
        stateData.getCode();
        XesLog.et("UserInfo", new Object[]{stateData.getMsg()});
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        otpLoginActivity2.showToast(CommonKtxKt.formatBadResult(stateData));
    }

    /* access modifiers changed from: private */
    public final void showWheelDialog() {
        if (this.mChangeCountryDialog == null) {
            List<ConfigInfo.Country> internationalList = getInternationalList();
            WheelDialog wheelDialog = new WheelDialog((Context) this, new OtpLoginActivity$showWheelDialog$1(this, internationalList), (Function0) null, 4, (DefaultConstructorMarker) null);
            this.mChangeCountryDialog = wheelDialog;
            wheelDialog.setWheelAdapter(new OtpLoginActivity$showWheelDialog$2(internationalList));
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
        getBinding().tvSmsSend.setEnabled(false);
        LoginCountDownTimer loginCountDownTimer = this.mSmsTimer;
        if (!(loginCountDownTimer == null || loginCountDownTimer == null)) {
            loginCountDownTimer.reset();
        }
        getBinding().tvSmsSecond.setVisibility(8);
        getBinding().tvSmsSend.setText(R.string.send);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if ((r7 <= r0 && r0 <= r6) != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void changeStatus(int r6, int r7) {
        /*
            r5 = this;
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r0 = (com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding) r0
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.etPhoneNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = r1.length()
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto L_0x001d
            r2 = r3
            goto L_0x001e
        L_0x001d:
            r2 = r4
        L_0x001e:
            if (r2 == 0) goto L_0x002e
            int r0 = r0.length()
            if (r7 > r0) goto L_0x002a
            if (r0 > r6) goto L_0x002a
            r6 = r3
            goto L_0x002b
        L_0x002a:
            r6 = r4
        L_0x002b:
            if (r6 == 0) goto L_0x002e
            goto L_0x004c
        L_0x002e:
            int r6 = r1.length()
            if (r6 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r3 = r4
        L_0x0036:
            if (r3 == 0) goto L_0x0042
            int r6 = com.tal.app.thinkacademy.business.login.R.string.login_phone_number_empty
            java.lang.String r6 = r5.getString(r6)
            r5.showToast(r6)
            goto L_0x004b
        L_0x0042:
            int r6 = com.tal.app.thinkacademy.business.login.R.string.login_phone_number_error
            java.lang.String r6 = r5.getString(r6)
            r5.showToast(r6)
        L_0x004b:
            r3 = r4
        L_0x004c:
            r5.isRightPhoneNumber = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.OtpLoginActivity.changeStatus(int, int):void");
    }

    /* access modifiers changed from: private */
    public final List<ConfigInfo.Country> getInternationalList() {
        return ImConfig.INSTANCE.getInternationalInfo();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            getBinding().etPhoneNumber.clearFocus();
            getBinding().etSmsCode.clearFocus();
        }
        return OtpLoginActivity.super.dispatchTouchEvent(motionEvent);
    }

    private final void setAgreeState() {
        if (this.mIsAgree) {
            getBinding().ivAgree.setImageResource(R.drawable.login_icon_checked);
        } else {
            getBinding().ivAgree.setImageResource(R.drawable.login_icon_unchecked);
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, OtpLoginActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.iv_agree;
        if (valueOf != null && valueOf.intValue() == i) {
            this.mIsAgree = !this.mIsAgree;
            setAgreeState();
        } else {
            int i2 = R.id.tv_sign_in;
            if (valueOf != null && valueOf.intValue() == i2) {
                login();
            } else {
                int i3 = R.id.tv_skip;
                if (valueOf != null && valueOf.intValue() == i3) {
                    finish();
                } else {
                    int i4 = R.id.tv_password_login;
                    if (valueOf != null && valueOf.intValue() == i4) {
                        Intent intent = new Intent((Context) this, PhoneLoginActivity.class);
                        intent.putExtra(AccountVerificationActivityKt.ChosenCountryIndex, this.mChosenCountryIndex);
                        intent.putExtra(PasswordSettingsActivityKt.accountName, StringsKt.trim(String.valueOf(getBinding().etPhoneNumber.getText())).toString());
                        intent.putExtra(PasswordSettingsActivityKt.isAgree, this.mIsAgree);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        OtpLoginActivity.super.onDestroy();
        LoginCountDownTimer loginCountDownTimer = this.mSmsTimer;
        if (loginCountDownTimer != null) {
            loginCountDownTimer.cancel();
        }
        this.mSmsTimer = null;
        LoginCountDownTimer loginCountDownTimer2 = this.mEmailTimer;
        if (loginCountDownTimer2 != null) {
            loginCountDownTimer2.cancel();
        }
        this.mEmailTimer = null;
    }

    /* access modifiers changed from: protected */
    public ActivityLoginOtpBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityLoginOtpBinding inflate = ActivityLoginOtpBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
