package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityPasswordSettingsBinding;
import com.tal.app.thinkacademy.business.login.entity.SetPasswordData;
import com.tal.app.thinkacademy.business.login.presenter.ChangePasswordViewModel;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesUploadPrinter;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PadAutoCenterScreen(designHeight = 620.0f)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0014J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/PasswordSettingsActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/ChangePasswordViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/LiveLoginActivityPasswordSettingsBinding;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mAccountName", "mCountryCallingCode", "mIsShowSkip", "", "mIvConfirmPasswordShow", "mIvPasswordShow", "mType", "", "Ljava/lang/Integer;", "mVerificationCode", "containSpecial", "password", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "passwordChecking", "setListener", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordSettingsActivity.kt */
public final class PasswordSettingsActivity extends BaseVmActivity<ChangePasswordViewModel, LiveLoginActivityPasswordSettingsBinding> {
    private final String TAG = "PasswordSettingsActivity";
    /* access modifiers changed from: private */
    public String mAccountName;
    /* access modifiers changed from: private */
    public String mCountryCallingCode = "";
    private boolean mIsShowSkip = true;
    /* access modifiers changed from: private */
    public boolean mIvConfirmPasswordShow;
    /* access modifiers changed from: private */
    public boolean mIvPasswordShow;
    /* access modifiers changed from: private */
    public Integer mType = 1;
    /* access modifiers changed from: private */
    public String mVerificationCode;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PasswordSettingsActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public LiveLoginActivityPasswordSettingsBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveLoginActivityPasswordSettingsBinding inflate = LiveLoginActivityPasswordSettingsBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PasswordSettingsActivity.super.onCreate(bundle);
        overridePendingTransition(R.anim.dialog_bottom_in, R.anim.dialog_bottom_out);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        init();
        setListener();
    }

    private final void init() {
        String stringExtra;
        Intent intent = getIntent();
        String str = null;
        this.mAccountName = intent == null ? null : intent.getStringExtra(PasswordSettingsActivityKt.accountName);
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra(PasswordSettingsActivityKt.verificationCode);
        }
        this.mVerificationCode = str;
        Intent intent3 = getIntent();
        String str2 = "";
        if (!(intent3 == null || (stringExtra = intent3.getStringExtra(PasswordSettingsActivityKt.countryCallingCode)) == null)) {
            str2 = stringExtra;
        }
        this.mCountryCallingCode = str2;
        Intent intent4 = getIntent();
        boolean z = true;
        this.mType = intent4 == null ? 1 : Integer.valueOf(intent4.getIntExtra(PasswordSettingsActivityKt.checkType, 1));
        Intent intent5 = getIntent();
        if (intent5 != null) {
            z = Boolean.valueOf(intent5.getBooleanExtra(PasswordSettingsActivityKt.isShowSkip, true)).booleanValue();
        }
        this.mIsShowSkip = z;
        if (z) {
            getBinding().icBack.setVisibility(8);
            getBinding().tvSkip.setVisibility(0);
            return;
        }
        getBinding().icBack.setVisibility(0);
        getBinding().tvSkip.setVisibility(8);
    }

    private final void setListener() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = getBinding().icBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.icBack");
        rxUnDoubleUtil.setOnUnDoubleClickListener(imageView, 500, new PasswordSettingsActivity$setListener$1(this));
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        View view = getBinding().tvSkip;
        Intrinsics.checkNotNullExpressionValue(view, "binding.tvSkip");
        rxUnDoubleUtil2.setOnUnDoubleClickListener(view, 500, new PasswordSettingsActivity$setListener$2(this));
        getBinding().etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        RxUnDoubleUtil rxUnDoubleUtil3 = RxUnDoubleUtil.INSTANCE;
        ImageView imageView2 = getBinding().ivPasswordShow;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivPasswordShow");
        rxUnDoubleUtil3.setOnUnDoubleClickListener(imageView2, 200, new PasswordSettingsActivity$setListener$3(this));
        getBinding().etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        RxUnDoubleUtil rxUnDoubleUtil4 = RxUnDoubleUtil.INSTANCE;
        ImageView imageView3 = getBinding().ivConfirmPasswordShow;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivConfirmPasswordShow");
        rxUnDoubleUtil4.setOnUnDoubleClickListener(imageView3, 200, new PasswordSettingsActivity$setListener$4(this));
        RxUnDoubleUtil rxUnDoubleUtil5 = RxUnDoubleUtil.INSTANCE;
        View view2 = getBinding().tvConfirm;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.tvConfirm");
        rxUnDoubleUtil5.setOnUnDoubleClickListener(view2, 300, new PasswordSettingsActivity$setListener$5(this));
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getSetPasswordData().observe(lifecycleOwner, new PasswordSettingsActivity$$ExternalSyntheticLambda0(this));
        getMViewModel().getChangePasswordData().observe(lifecycleOwner, new PasswordSettingsActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m103startObserve$lambda1(PasswordSettingsActivity passwordSettingsActivity, StateData stateData) {
        PasswordSettingsActivity passwordSettingsActivity2 = passwordSettingsActivity;
        Intrinsics.checkNotNullParameter(passwordSettingsActivity2, "this$0");
        passwordSettingsActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            SetPasswordData setPasswordData = (SetPasswordData) stateData.getData();
            XesLog.dt(passwordSettingsActivity2.TAG, new Object[]{Intrinsics.stringPlus("setPasswordData--SUCCESS--", setPasswordData)});
            XesDataBus.with("close_account_verification").postStickyData("close_account_verification");
            passwordSettingsActivity2.showToast(passwordSettingsActivity2.getString(R.string.password_set_successfully));
            if (setPasswordData != null) {
                ShareDataManager.getInstance().initUserSP(String.valueOf(setPasswordData.getUid()));
                LoginIn loginIn = LoginIn.INSTANCE;
                UserBean userBean = r5;
                UserBean userBean2 = new UserBean(setPasswordData.getUid(), setPasswordData.getAvatar(), setPasswordData.getPhone(), setPasswordData.getEmail(), setPasswordData.getNickName(), setPasswordData.getCountryCallingCode(), setPasswordData.getUnifiedAccessToken(), 0, (String) null, false, 896, (DefaultConstructorMarker) null);
                loginIn.loginInfo(userBean, true, (Context) passwordSettingsActivity2, 1);
                StringBuilder sb = new StringBuilder();
                File externalCacheDir = passwordSettingsActivity.getApplication().getExternalCacheDir();
                sb.append(externalCacheDir == null ? null : externalCacheDir.getAbsolutePath());
                sb.append(File.separator);
                sb.append("xesxeslog");
                XesUploadPrinter.getInstance(sb.toString()).setUserInfo(String.valueOf(setPasswordData.getUid()), ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), setPasswordData.getUnifiedAccessToken());
                ShareDataManager.getInstance().put("modify_nickname", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
            }
            passwordSettingsActivity.finish();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        passwordSettingsActivity2.showToast(CommonKtxKt.formatBadResult(stateData));
        XesLog.et(passwordSettingsActivity2.TAG, new Object[]{Intrinsics.stringPlus("setPasswordData--", stateData.getMsg())});
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-2  reason: not valid java name */
    public static final void m104startObserve$lambda2(PasswordSettingsActivity passwordSettingsActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(passwordSettingsActivity, "this$0");
        passwordSettingsActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            XesLog.dt(passwordSettingsActivity.TAG, new Object[]{"changePasswordData--SUCCESS"});
            XesDataBus.with("close_account_verification").postStickyData("close_account_verification");
            passwordSettingsActivity.showToast(passwordSettingsActivity.getString(R.string.password_set_successfully));
            passwordSettingsActivity.finish();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        passwordSettingsActivity.showToast(CommonKtxKt.formatBadResult(stateData));
        XesLog.et(passwordSettingsActivity.TAG, new Object[]{Intrinsics.stringPlus("changePasswordData--", stateData.getMsg())});
    }

    /* access modifiers changed from: private */
    public final boolean passwordChecking(String str) {
        int length = str.length();
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < length) {
            char charAt = str.charAt(i);
            i++;
            if (Character.isDigit(charAt)) {
                z = true;
            }
            if (!('a' <= charAt && charAt < '{')) {
                if (!('A' <= charAt && charAt < '[')) {
                }
            }
            z2 = true;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean containSpecial(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            i++;
            boolean isDigit = Character.isDigit(charAt);
            boolean z = 'a' <= charAt && charAt < '{';
            boolean z2 = 'A' <= charAt && charAt < '[';
            if (!isDigit && !z && !z2) {
                return true;
            }
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            getBinding().etPassword.clearFocus();
            getBinding().ivPasswordShow.clearFocus();
        }
        return PasswordSettingsActivity.super.dispatchTouchEvent(motionEvent);
    }
}
