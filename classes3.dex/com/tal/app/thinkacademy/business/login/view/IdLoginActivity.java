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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivityLoginIdBinding;
import com.tal.app.thinkacademy.business.login.databinding.DialogIdHistoryBinding;
import com.tal.app.thinkacademy.business.login.presenter.LoginViewModel;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.login.widget.OtpLoginDialog;
import com.tal.app.thinkacademy.business.login.widget.PasswordUtil;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesUploadPrinter;
import com.tal.app.thinkacademy.lib.util.KeyboardUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@PadAutoCenterScreen(designHeight = 620.0f)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J*\u0010\u001b\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0014J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0012\u0010)\u001a\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J*\u0010/\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u00101\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u0018H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/IdLoginActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/LoginViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityLoginIdBinding;", "Landroid/view/View$OnClickListener;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "()V", "mHistoryPopup", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "mHistoryView", "Lcom/tal/app/thinkacademy/business/login/databinding/DialogIdHistoryBinding;", "mIsAgree", "", "mLoginDialog", "Lcom/tal/app/thinkacademy/business/login/widget/OtpLoginDialog;", "mLoginType", "", "mShowPassword", "mShowPopup", "mTempIdIndex", "tag", "", "kotlin.jvm.PlatformType", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "init", "login", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTextChanged", "before", "setAgreeState", "setListener", "setLoginState", "showHistoryPopup", "showLoginDialog", "msg", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IdLoginActivity.kt */
public final class IdLoginActivity extends BaseVmActivity<LoginViewModel, ActivityLoginIdBinding> implements View.OnClickListener, ClearEditText.CustomTextWatcher {
    private EasyPopup mHistoryPopup;
    private DialogIdHistoryBinding mHistoryView;
    /* access modifiers changed from: private */
    public boolean mIsAgree;
    private OtpLoginDialog mLoginDialog;
    private int mLoginType = 1;
    private boolean mShowPassword;
    private boolean mShowPopup;
    private int mTempIdIndex;
    private final String tag = "IdLoginActivity";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdLoginActivity.kt */
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
    public ActivityLoginIdBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityLoginIdBinding inflate = ActivityLoginIdBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IdLoginActivity.super.onCreate(bundle);
        overridePendingTransition(R.anim.dialog_bottom_in, R.anim.dialog_bottom_out);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        init();
        setListener();
    }

    public void startObserve() {
        getMViewModel().getAccountLoginData().observe((LifecycleOwner) this, new IdLoginActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m81startObserve$lambda0(IdLoginActivity idLoginActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(idLoginActivity, "this$0");
        idLoginActivity.hideLoading();
        boolean z = true;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            UserBean userBean = (UserBean) stateData.getData();
            XesLog.dt("UserInfo", new Object[]{userBean});
            if (userBean != null) {
                ShareDataManager.getInstance().initUserSP(String.valueOf(userBean.getUid()));
                LoginIn.INSTANCE.loginInfo(userBean, true, (Context) idLoginActivity, 1);
                StringBuilder sb = new StringBuilder();
                File externalCacheDir = idLoginActivity.getApplication().getExternalCacheDir();
                sb.append(externalCacheDir == null ? null : externalCacheDir.getAbsolutePath());
                sb.append(File.separator);
                sb.append("xesxeslog");
                XesUploadPrinter.getInstance(sb.toString()).setUserInfo(String.valueOf(userBean.getUid()), ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), userBean.getUnifiedAccessToken());
                ShareDataManager.getInstance().put("modify_nickname", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
                if (idLoginActivity.mLoginType == 1) {
                    String string = ShareDataManager.getInstance().getString("student_ids", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
                    String obj = StringsKt.trim(String.valueOf(idLoginActivity.getBinding().etStudentId.getText())).toString();
                    CharSequence charSequence = string;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = false;
                    }
                    if (z) {
                        ShareDataManager.getInstance().put("student_ids", obj, ShareDataManager.SHAREDATA_NOT_CLEAR);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "ids");
                    if (!StringsKt.contains$default(charSequence, obj, false, 2, (Object) null)) {
                        ShareDataManager.getInstance().put("student_ids", obj + ' ' + string, ShareDataManager.SHAREDATA_NOT_CLEAR);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        XesLog.et("UserInfo", new Object[]{stateData.getMsg()});
        if (stateData.getCode() == 100108) {
            String msg = stateData.getMsg();
            Intrinsics.checkNotNull(msg);
            idLoginActivity.showLoginDialog(msg);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        idLoginActivity.showToast(CommonKtxKt.formatBadResult(stateData));
    }

    private final void init() {
        boolean z = false;
        this.mIsAgree = getIntent().getBooleanExtra(PasswordSettingsActivityKt.isAgree, false);
        setAgreeState();
        CharSequence string = ShareDataManager.getInstance().getString("student_ids", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (string == null || string.length() == 0) {
            z = true;
        }
        if (z) {
            getBinding().ivIdHistory.setVisibility(8);
        }
        TextView textView = getBinding().loginAgreementTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.loginAgreementTips");
        JumpToAgreementUtil.INSTANCE.loginAgreementTips((Context) this, textView);
        XesDataBus.with("close_account_verification").observe((LifecycleOwner) this, new IdLoginActivity$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1  reason: not valid java name */
    public static final void m76init$lambda1(IdLoginActivity idLoginActivity, Object obj) {
        Intrinsics.checkNotNullParameter(idLoginActivity, "this$0");
        idLoginActivity.finish();
    }

    private final void setListener() {
        ClearEditText.CustomTextWatcher customTextWatcher = this;
        getBinding().etStudentId.addCustomTextWatcher(customTextWatcher);
        getBinding().etPassword.addCustomTextWatcher(customTextWatcher);
        View.OnClickListener onClickListener = this;
        getBinding().tvSkip.setOnClickListener(onClickListener);
        getBinding().ivPasswordEye.setOnClickListener(onClickListener);
        getBinding().tvOtpLogin.setOnClickListener(onClickListener);
        getBinding().tvForgetPassword.setOnClickListener(onClickListener);
        getBinding().ivIdHistory.setOnClickListener(onClickListener);
        getBinding().ivLoginPhone.setOnClickListener(onClickListener);
        getBinding().ivLoginEmail.setOnClickListener(onClickListener);
        getBinding().ivAgree.setOnClickListener(onClickListener);
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvSignIn;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSignIn");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new IdLoginActivity$setListener$1(this), 1, (Object) null);
    }

    private final void showHistoryPopup() {
        View view;
        View view2;
        WheelView wheelView;
        WheelView wheelView2;
        WheelView wheelView3;
        WheelView wheelView4;
        WheelView wheelView5;
        WheelView wheelView6;
        WheelView wheelView7;
        WheelView wheelView8;
        WheelView wheelView9;
        WheelView wheelView10;
        EasyPopup focusAndOutsideEnable;
        EasyPopup keyCodeBack;
        EasyPopup backgroundDimEnable;
        EasyPopup width;
        EasyPopup height;
        EasyPopup onDismissListener;
        this.mTempIdIndex = 0;
        WheelView wheelView11 = null;
        if (this.mHistoryPopup == null) {
            Context context = (Context) this;
            this.mHistoryPopup = new EasyPopup(context);
            DialogIdHistoryBinding inflate = DialogIdHistoryBinding.inflate(getLayoutInflater());
            this.mHistoryView = inflate;
            EasyPopup easyPopup = this.mHistoryPopup;
            if (easyPopup != null) {
                LinearLayout root = inflate == null ? null : inflate.getRoot();
                Intrinsics.checkNotNull(root);
                EasyPopup contentView = easyPopup.setContentView(root);
                if (!(contentView == null || (focusAndOutsideEnable = contentView.setFocusAndOutsideEnable(true)) == null || (keyCodeBack = focusAndOutsideEnable.setKeyCodeBack(true)) == null || (backgroundDimEnable = keyCodeBack.setBackgroundDimEnable(false)) == null || (width = backgroundDimEnable.setWidth(ScreenUtils.getScreenWidth() - SizeUtils.dp2px(32.0f))) == null || (height = width.setHeight(SizeUtils.dp2px(232.0f))) == null || (onDismissListener = height.setOnDismissListener(new IdLoginActivity$$ExternalSyntheticLambda2(this))) == null)) {
                    onDismissListener.createPopup();
                }
            }
            DialogIdHistoryBinding dialogIdHistoryBinding = this.mHistoryView;
            if (!(dialogIdHistoryBinding == null || (wheelView10 = dialogIdHistoryBinding.wheelView) == null)) {
                wheelView10.setCyclic(false);
            }
            DialogIdHistoryBinding dialogIdHistoryBinding2 = this.mHistoryView;
            if (!(dialogIdHistoryBinding2 == null || (wheelView9 = dialogIdHistoryBinding2.wheelView) == null)) {
                wheelView9.setItemsVisibleCount(3);
            }
            DialogIdHistoryBinding dialogIdHistoryBinding3 = this.mHistoryView;
            if (!(dialogIdHistoryBinding3 == null || (wheelView8 = dialogIdHistoryBinding3.wheelView) == null)) {
                wheelView8.setItemHeight(SizeUtils.dp2px(60.0f));
            }
            DialogIdHistoryBinding dialogIdHistoryBinding4 = this.mHistoryView;
            if (!(dialogIdHistoryBinding4 == null || (wheelView7 = dialogIdHistoryBinding4.wheelView) == null)) {
                wheelView7.setRoundRadius(SizeUtils.dp2px(30.0f));
            }
            DialogIdHistoryBinding dialogIdHistoryBinding5 = this.mHistoryView;
            if (!(dialogIdHistoryBinding5 == null || (wheelView6 = dialogIdHistoryBinding5.wheelView) == null)) {
                wheelView6.setTextColorCenter(ContextCompat.getColor(context, R.color.color_ffaa0a));
            }
            DialogIdHistoryBinding dialogIdHistoryBinding6 = this.mHistoryView;
            if (!(dialogIdHistoryBinding6 == null || (wheelView5 = dialogIdHistoryBinding6.wheelView) == null)) {
                wheelView5.setTextColorOut(ContextCompat.getColor(context, R.color.color_a2aab8));
            }
            DialogIdHistoryBinding dialogIdHistoryBinding7 = this.mHistoryView;
            if (!(dialogIdHistoryBinding7 == null || (wheelView4 = dialogIdHistoryBinding7.wheelView) == null)) {
                wheelView4.setTextSize(18.0f);
            }
            DialogIdHistoryBinding dialogIdHistoryBinding8 = this.mHistoryView;
            if (!(dialogIdHistoryBinding8 == null || (wheelView3 = dialogIdHistoryBinding8.wheelView) == null)) {
                wheelView3.setDividerColor(ContextCompat.getColor(context, R.color.color_14ffaa0a));
            }
            DialogIdHistoryBinding dialogIdHistoryBinding9 = this.mHistoryView;
            if (!(dialogIdHistoryBinding9 == null || (wheelView2 = dialogIdHistoryBinding9.wheelView) == null)) {
                wheelView2.setDividerType(WheelView.DividerType.ROUND_RECT);
            }
            String string = ShareDataManager.getInstance().getString("student_ids", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
            Intrinsics.checkNotNullExpressionValue(string, "ids");
            List split$default = StringsKt.split$default(string, new String[]{" "}, false, 0, 6, (Object) null);
            DialogIdHistoryBinding dialogIdHistoryBinding10 = this.mHistoryView;
            WheelView wheelView12 = dialogIdHistoryBinding10 == null ? null : dialogIdHistoryBinding10.wheelView;
            if (wheelView12 != null) {
                wheelView12.setAdapter(new IdLoginActivity$showHistoryPopup$2(split$default));
            }
            DialogIdHistoryBinding dialogIdHistoryBinding11 = this.mHistoryView;
            if (dialogIdHistoryBinding11 != null) {
                wheelView11 = dialogIdHistoryBinding11.wheelView;
            }
            if (wheelView11 != null) {
                wheelView11.setCurrentItem(0);
            }
            DialogIdHistoryBinding dialogIdHistoryBinding12 = this.mHistoryView;
            if (!(dialogIdHistoryBinding12 == null || (wheelView = dialogIdHistoryBinding12.wheelView) == null)) {
                wheelView.setOnItemSelectedListener(new IdLoginActivity$$ExternalSyntheticLambda5(this));
            }
            EasyPopup easyPopup2 = this.mHistoryPopup;
            if (!(easyPopup2 == null || (view2 = easyPopup2.getView(R.id.iv_cancel)) == null)) {
                view2.setOnClickListener(new IdLoginActivity$$ExternalSyntheticLambda0(this));
            }
            EasyPopup easyPopup3 = this.mHistoryPopup;
            if (!(easyPopup3 == null || (view = easyPopup3.getView(R.id.iv_confirm)) == null)) {
                view.setOnClickListener(new IdLoginActivity$$ExternalSyntheticLambda1(split$default, this));
            }
        } else {
            DialogIdHistoryBinding dialogIdHistoryBinding13 = this.mHistoryView;
            if (dialogIdHistoryBinding13 != null) {
                wheelView11 = dialogIdHistoryBinding13.wheelView;
            }
            if (wheelView11 != null) {
                wheelView11.setCurrentItem(0);
            }
        }
        EasyPopup easyPopup4 = this.mHistoryPopup;
        if (easyPopup4 != null) {
            easyPopup4.showAsDropDown(getBinding().layoutId, 0, SizeUtils.dp2px(10.0f));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showHistoryPopup$lambda-2  reason: not valid java name */
    public static final void m77showHistoryPopup$lambda2(IdLoginActivity idLoginActivity) {
        Intrinsics.checkNotNullParameter(idLoginActivity, "this$0");
        idLoginActivity.mShowPopup = false;
        idLoginActivity.getBinding().ivIdHistory.setImageResource(R.drawable.login_icon_arrow_down);
    }

    /* access modifiers changed from: private */
    /* renamed from: showHistoryPopup$lambda-3  reason: not valid java name */
    public static final void m78showHistoryPopup$lambda3(IdLoginActivity idLoginActivity, int i) {
        Intrinsics.checkNotNullParameter(idLoginActivity, "this$0");
        idLoginActivity.mTempIdIndex = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: showHistoryPopup$lambda-4  reason: not valid java name */
    public static final void m79showHistoryPopup$lambda4(IdLoginActivity idLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(idLoginActivity, "this$0");
        EasyPopup easyPopup = idLoginActivity.mHistoryPopup;
        if (easyPopup != null) {
            easyPopup.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showHistoryPopup$lambda-5  reason: not valid java name */
    public static final void m80showHistoryPopup$lambda5(List list, IdLoginActivity idLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(idLoginActivity, "this$0");
        String str = (String) list.get(idLoginActivity.mTempIdIndex);
        idLoginActivity.getBinding().etStudentId.setText(str);
        idLoginActivity.getBinding().etStudentId.setSelection(str.length());
        EasyPopup easyPopup = idLoginActivity.mHistoryPopup;
        if (easyPopup != null) {
            easyPopup.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showLoginDialog(String str) {
        if (this.mLoginDialog == null) {
            this.mLoginDialog = new OtpLoginDialog((Context) this, new IdLoginActivity$showLoginDialog$1(this));
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
        String obj = StringsKt.trim(String.valueOf(getBinding().etStudentId.getText())).toString();
        String password = PasswordUtil.INSTANCE.getPassword(String.valueOf(getBinding().etPassword.getText()));
        LoginTrack.INSTANCE.signInClick("学员编号", "密码登陆", 0);
        getMViewModel().accountLogin(obj, password, this.mLoginType, "", "学员编号", "密码登陆");
    }

    private final void setLoginState() {
        String obj = StringsKt.trim(String.valueOf(getBinding().etStudentId.getText())).toString();
        IntRange intRange = new IntRange(12, 14);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        int length = obj.length();
        boolean z = true;
        boolean z2 = first <= length && length <= last;
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
        MethodInfo.onClickEventEnter(view, IdLoginActivity.class);
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
                        int i5 = R.id.iv_id_history;
                        if (valueOf != null && valueOf.intValue() == i5) {
                            KeyboardUtils.hideSoftInput((Activity) this);
                            if (!this.mShowPopup) {
                                this.mShowPopup = true;
                                getBinding().ivIdHistory.setImageResource(R.drawable.login_icon_arrow_up);
                                showHistoryPopup();
                            } else {
                                this.mShowPopup = false;
                                getBinding().ivIdHistory.setImageResource(R.drawable.login_icon_arrow_down);
                                EasyPopup easyPopup = this.mHistoryPopup;
                                if (easyPopup != null) {
                                    easyPopup.dismiss();
                                }
                            }
                        } else {
                            int i6 = R.id.iv_login_phone;
                            if (valueOf != null && valueOf.intValue() == i6) {
                                Intent intent2 = new Intent((Context) this, PhoneLoginActivity.class);
                                intent2.putExtra(PasswordSettingsActivityKt.isAgree, this.mIsAgree);
                                startActivity(intent2);
                                finish();
                            } else {
                                int i7 = R.id.iv_login_email;
                                if (valueOf != null && valueOf.intValue() == i7) {
                                    Intent intent3 = new Intent((Context) this, EmailLoginActivity.class);
                                    intent3.putExtra(PasswordSettingsActivityKt.isAgree, this.mIsAgree);
                                    startActivity(intent3);
                                    finish();
                                } else {
                                    int i8 = R.id.iv_agree;
                                    if (valueOf != null && valueOf.intValue() == i8) {
                                        this.mIsAgree = !this.mIsAgree;
                                        setAgreeState();
                                        setLoginState();
                                    }
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
                startActivity(new Intent((Context) this, AccountVerificationActivity.class));
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
            getBinding().etStudentId.clearFocus();
            getBinding().etPassword.clearFocus();
        }
        return IdLoginActivity.super.dispatchTouchEvent(motionEvent);
    }
}
