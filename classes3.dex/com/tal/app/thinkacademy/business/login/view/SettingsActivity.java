package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginOut;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivitySettingsBinding;
import com.tal.app.thinkacademy.business.login.databinding.DialogMarsSuccessBinding;
import com.tal.app.thinkacademy.business.login.databinding.DialogQuitBinding;
import com.tal.app.thinkacademy.business.login.databinding.LoginDialogChangePasswordBinding;
import com.tal.app.thinkacademy.business.login.databinding.LoginDialogChangePasswordErrorBinding;
import com.tal.app.thinkacademy.business.login.entity.AccountCheckData;
import com.tal.app.thinkacademy.business.login.entity.Extra;
import com.tal.app.thinkacademy.business.login.entity.Helper;
import com.tal.app.thinkacademy.business.login.presenter.SettingsViewModel;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.login.widget.SwitchLanguageDialog;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.ChosenSchoolBean;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0014H\u0014J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\b\u00102\u001a\u00020#H\u0002J\n\u00103\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u00107\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020#H\u0003J\b\u0010>\u001a\u00020#H\u0002J\b\u0010?\u001a\u00020#H\u0016J\u0010\u0010@\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u001cj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u001dX\u0004¢\u0006\u0002\n\u0000R*\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u001cj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/SettingsActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/SettingsViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivitySettingsBinding;", "Landroid/view/View$OnClickListener;", "()V", "mChangeCountryDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mChangePasswordDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/login/databinding/LoginDialogChangePasswordBinding;", "mChangePasswordErrorDialog", "Lcom/tal/app/thinkacademy/business/login/databinding/LoginDialogChangePasswordErrorBinding;", "mClearDialog", "Lcom/tal/app/thinkacademy/business/login/databinding/DialogQuitBinding;", "mConfirmDialog", "Lcom/tal/app/thinkacademy/business/login/databinding/DialogMarsSuccessBinding;", "mHits", "", "mIsNewVersion", "", "mNameList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mOldIndex", "", "mSchoolIndexMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mSchoolMap", "mSelectLanguageDialog", "Lcom/tal/app/thinkacademy/business/login/widget/SwitchLanguageDialog;", "mSignOutDialog", "changePassworkError", "", "changeSchool", "schoolCode", "clearCache", "clearContent", "continuousClick", "count", "duration", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "dialogClick", "getStateChange", "goneSchool", "isLatest", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "selectSchool", "setListener", "setSchoolState", "setViewValues", "showConfirmDialog", "startObserve", "updateSchoolInfo", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsActivity.kt */
public final class SettingsActivity extends BaseVmActivity<SettingsViewModel, ActivitySettingsBinding> implements View.OnClickListener {
    private WheelDialog mChangeCountryDialog;
    /* access modifiers changed from: private */
    public BaseBindDialog<LoginDialogChangePasswordBinding> mChangePasswordDialog;
    private BaseBindDialog<LoginDialogChangePasswordErrorBinding> mChangePasswordErrorDialog;
    /* access modifiers changed from: private */
    public BaseBindDialog<DialogQuitBinding> mClearDialog;
    private BaseBindDialog<DialogMarsSuccessBinding> mConfirmDialog;
    private long[] mHits = new long[10];
    private boolean mIsNewVersion;
    /* access modifiers changed from: private */
    public final ArrayList<String> mNameList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int mOldIndex = -1;
    private final HashMap<Integer, Integer> mSchoolIndexMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<Integer, Integer> mSchoolMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SwitchLanguageDialog mSelectLanguageDialog;
    /* access modifiers changed from: private */
    public BaseBindDialog<DialogQuitBinding> mSignOutDialog;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SettingsActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public ActivitySettingsBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivitySettingsBinding inflate = ActivitySettingsBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SettingsActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        setViewValues();
        setListener();
        getStateChange();
        LeanplumUtil.commonTrack$default("my_homepage_pv", (HashMap) null, 2, (Object) null);
    }

    private final void setViewValues() {
        ChosenSchoolBean chosenSchoolBean;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new SettingsActivity$setViewValues$1(this, (Continuation<? super SettingsActivity$setViewValues$1>) null), 3, (Object) null);
        TextView textView = getBinding().tvVersionNumber;
        Resources resources = getResources();
        Intrinsics.checkNotNull(resources);
        textView.setText(TextUtils.concat(new CharSequence[]{resources.getString(R.string.Version), " ", AppUtils.getAppVersionName()}));
        if (!TextUtils.equals(ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), "8601") && (chosenSchoolBean = (ChosenSchoolBean) ShareDataManager.getInstance().getCacheEntity(ChosenSchoolBean.class, "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR)) != null) {
            getBinding().tvCountryName.setText(chosenSchoolBean.countryName);
        }
        getBinding().tvSelectLanguage.setText(HwLanguageUtil.INSTANCE.getCurrentLanguage().getNameDesc());
        setSchoolState();
    }

    private final void setListener() {
        getBinding().settingsTitleBar.setOnTitleBarListener(new SettingsActivity$setListener$1(this));
        View.OnClickListener onClickListener = this;
        getBinding().tvCountryName.setOnClickListener(onClickListener);
        getBinding().layoutVersion.setOnClickListener(onClickListener);
        getBinding().tvSignOut.setOnClickListener(onClickListener);
        getBinding().layoutSwitchAccount.setOnClickListener(onClickListener);
        getBinding().layoutNotification.setOnClickListener(onClickListener);
        getBinding().layoutAboutUs.setOnClickListener(onClickListener);
        getBinding().layoutDeleteAccount.setOnClickListener(onClickListener);
        getBinding().layoutAddress.setOnClickListener(onClickListener);
        dialogClick();
    }

    /* access modifiers changed from: private */
    public final void continuousClick(int i, long j) {
        long[] jArr = this.mHits;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.mHits;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.mHits[0] >= SystemClock.uptimeMillis() - j) {
            this.mHits = new long[i];
            updateSchoolInfo(8601);
            showConfirmDialog();
            getBinding().tvCountryName.setText("");
        }
    }

    private final void getStateChange() {
        XesDataBus.with("user_center_app_version_refresh").observerSticky((LifecycleOwner) this, true, new SettingsActivity$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: getStateChange$lambda-0  reason: not valid java name */
    public static final void m122getStateChange$lambda0(SettingsActivity settingsActivity, Object obj) {
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        settingsActivity.mIsNewVersion = ShareDataManager.getInstance().getBoolean("is_new_version", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
        settingsActivity.getBinding().tvVersionTip.setText(settingsActivity.isLatest());
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getSignOutData().observe(lifecycleOwner, new SettingsActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().getAccountSwitchSchool().observe(lifecycleOwner, new SettingsActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().getAccountCheckData().observe(lifecycleOwner, new SettingsActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m124startObserve$lambda1(SettingsActivity settingsActivity, StateData stateData) {
        StateData.DataStatus dataStatus;
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        settingsActivity.hideLoading();
        StateData.DataStatus dataStatus2 = null;
        if (stateData == null) {
            dataStatus = null;
        } else {
            dataStatus = stateData.getStatus();
        }
        if (dataStatus == StateData.DataStatus.SUCCESS) {
            LeanplumUtil.commonTrack$default("log_out_success", (HashMap) null, 2, (Object) null);
            settingsActivity.finish();
            LoginOut.INSTANCE.loginOut((Context) settingsActivity, true);
            return;
        }
        if (stateData != null) {
            dataStatus2 = stateData.getStatus();
        }
        if (dataStatus2 == StateData.DataStatus.ERROR) {
            ToastUtils.showLong(settingsActivity.getString(R.string.Login_out_failed), new Object[0]);
        } else {
            ToastUtils.showLong(R.string.login_no_network);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-3  reason: not valid java name */
    public static final void m125startObserve$lambda3(SettingsActivity settingsActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        settingsActivity.hideLoading();
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            Integer num = (Integer) stateData.getData();
            if (num != null) {
                settingsActivity.changeSchool(num.intValue());
            }
        } else if (i != 2) {
            ToastUtils.showLong(R.string.login_no_network);
        } else {
            ToastUtils.showLong(R.string.login_no_network);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-5  reason: not valid java name */
    public static final void m126startObserve$lambda5(SettingsActivity settingsActivity, StateData stateData) {
        StateData.DataStatus dataStatus;
        Helper helper;
        Extra extra;
        Helper helper2;
        Extra extra2;
        Helper helper3;
        Integer status;
        Helper helper4;
        Extra extra3;
        Helper helper5;
        Integer status2;
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        settingsActivity.hideLoading();
        String str = null;
        if (stateData == null) {
            dataStatus = null;
        } else {
            dataStatus = stateData.getStatus();
        }
        if (dataStatus == StateData.DataStatus.SUCCESS) {
            AccountCheckData accountCheckData = (AccountCheckData) stateData.getData();
            boolean z = false;
            if (accountCheckData == null ? false : Intrinsics.areEqual((Object) accountCheckData.getContinue(), (Object) false)) {
                Intent intent = new Intent((Context) settingsActivity, AccountVerificationActivity.class);
                AccountCheckData accountCheckData2 = (AccountCheckData) stateData.getData();
                intent.putExtra(PasswordSettingsActivityKt.checkType, (accountCheckData2 == null || (helper5 = accountCheckData2.getHelper()) == null || (status2 = helper5.getStatus()) == null) ? 1 : status2.intValue());
                AccountCheckData accountCheckData3 = (AccountCheckData) stateData.getData();
                intent.putExtra(PasswordSettingsActivityKt.countryCallingCode, (accountCheckData3 == null || (helper4 = accountCheckData3.getHelper()) == null || (extra3 = helper4.getExtra()) == null) ? null : extra3.getCountryCallingCode());
                AccountCheckData accountCheckData4 = (AccountCheckData) stateData.getData();
                if (!(accountCheckData4 == null || (helper3 = accountCheckData4.getHelper()) == null || (status = helper3.getStatus()) == null || status.intValue() != 1)) {
                    z = true;
                }
                if (z) {
                    AccountCheckData accountCheckData5 = (AccountCheckData) stateData.getData();
                    if (!(accountCheckData5 == null || (helper2 = accountCheckData5.getHelper()) == null || (extra2 = helper2.getExtra()) == null)) {
                        str = extra2.getPhone();
                    }
                } else {
                    AccountCheckData accountCheckData6 = (AccountCheckData) stateData.getData();
                    if (!(accountCheckData6 == null || (helper = accountCheckData6.getHelper()) == null || (extra = helper.getExtra()) == null)) {
                        str = extra.getEmail();
                    }
                }
                intent.putExtra(PasswordSettingsActivityKt.accountName, str);
                settingsActivity.startActivity(intent);
                return;
            }
            return;
        }
        if (stateData != null) {
            str = stateData.getStatus();
        }
        if (str == StateData.DataStatus.ERROR) {
            settingsActivity.changePassworkError();
        } else {
            settingsActivity.changePassworkError();
        }
    }

    private final void changePassworkError() {
        BaseBindDialog<LoginDialogChangePasswordErrorBinding> baseBindDialog;
        if (this.mChangePasswordErrorDialog == null) {
            BaseBindDialog<LoginDialogChangePasswordErrorBinding> settingsActivity$changePassworkError$1 = new SettingsActivity$changePassworkError$1(this);
            settingsActivity$changePassworkError$1.gravity(17);
            settingsActivity$changePassworkError$1.layoutParams(new LinearLayout.LayoutParams(-1, -2));
            settingsActivity$changePassworkError$1.canceledOnTouchOutside(true);
            RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
            TextView textView = settingsActivity$changePassworkError$1.binding.tvConfirm;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvConfirm");
            rxUnDoubleUtil.setOnUnDoubleClickListener(textView, 500, new SettingsActivity$changePassworkError$2$1(settingsActivity$changePassworkError$1));
            this.mChangePasswordErrorDialog = (BaseBindDialog) settingsActivity$changePassworkError$1;
        }
        if (!isFinishing() && (baseBindDialog = this.mChangePasswordErrorDialog) != null && !baseBindDialog.isShowing()) {
            baseBindDialog.show();
        }
    }

    private final void setSchoolState() {
        ConfigInfo.SchoolRule[] campusRouteList = ImConfig.INSTANCE.getCampusRouteList();
        if (campusRouteList != null) {
            String string = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
            ConfigInfo.SchoolRule schoolRule = null;
            int length = campusRouteList.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i2 = i + 1;
                ConfigInfo.SchoolRule schoolRule2 = campusRouteList[i];
                if (Intrinsics.areEqual((Object) schoolRule2.getSchoolCode(), (Object) string)) {
                    schoolRule = schoolRule2;
                    break;
                }
                i = i2;
            }
            boolean z = ShareDataManager.getInstance().getBoolean("location_country", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
            if (schoolRule == null) {
                return;
            }
            if (z && !schoolRule.getGeoRule()) {
                goneSchool();
            } else if (!z && !schoolRule.getManualRule()) {
                goneSchool();
            }
        }
    }

    private final void showConfirmDialog() {
        TextView textView;
        if (this.mConfirmDialog == null) {
            BaseBindDialog<DialogMarsSuccessBinding> settingsActivity$showConfirmDialog$1 = new SettingsActivity$showConfirmDialog$1(this);
            settingsActivity$showConfirmDialog$1.gravity(80).layoutParams(new LinearLayout.LayoutParams(-1, -2)).canceledOnTouchOutside(false);
            BaseBindDialog<DialogMarsSuccessBinding> baseBindDialog = (BaseBindDialog) settingsActivity$showConfirmDialog$1;
            this.mConfirmDialog = baseBindDialog;
            DialogMarsSuccessBinding dialogMarsSuccessBinding = baseBindDialog.binding;
            if (!(dialogMarsSuccessBinding == null || (textView = dialogMarsSuccessBinding.tvKnew) == null)) {
                textView.setOnClickListener(new SettingsActivity$$ExternalSyntheticLambda0(this));
            }
        }
        BaseBindDialog<DialogMarsSuccessBinding> baseBindDialog2 = this.mConfirmDialog;
        if (baseBindDialog2 != null) {
            baseBindDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showConfirmDialog$lambda-9  reason: not valid java name */
    public static final void m123showConfirmDialog$lambda9(SettingsActivity settingsActivity, View view) {
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        settingsActivity.changeSchool(8601);
        BaseBindDialog<DialogMarsSuccessBinding> baseBindDialog = settingsActivity.mConfirmDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void changeSchool(int i) {
        ChooseSchoolUtil.INSTANCE.finishAllActivitiesToMain();
    }

    private final void goneSchool() {
        getBinding().layoutCountry.setVisibility(8);
        getBinding().tvCountryTip.setVisibility(8);
    }

    private final void selectSchool() {
        List schoolList;
        LeanplumUtil.commonTrack$default("school_selector_show", (HashMap) null, 2, (Object) null);
        Object cacheEntity = ShareDataManager.getInstance().getCacheEntity(ChosenSchoolBean.class, "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(cacheEntity, "getInstance().getCacheEn…EDATA_NOT_CLEAR\n        )");
        ChosenSchoolBean chosenSchoolBean = (ChosenSchoolBean) cacheEntity;
        if (this.mSchoolMap.isEmpty() && (schoolList = SchoolConstants.INSTANCE.getSchoolList()) != null) {
            int i = 0;
            for (Object next : schoolList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SchoolDataInfo schoolDataInfo = (SchoolDataInfo) next;
                int tryParseInt = ParseUtils.tryParseInt(schoolDataInfo.getSchoolCode(), 0);
                this.mSchoolMap.put(Integer.valueOf(i), Integer.valueOf(tryParseInt));
                this.mSchoolIndexMap.put(Integer.valueOf(tryParseInt), Integer.valueOf(i));
                ArrayList<String> arrayList = this.mNameList;
                String schoolName = schoolDataInfo.getSchoolName();
                if (schoolName == null) {
                    schoolName = "";
                }
                arrayList.add(schoolName);
                i = i2;
            }
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int i3 = this.mSchoolIndexMap.get(Integer.valueOf(chosenSchoolBean.schoolCode));
        if (i3 == null) {
            i3 = 0;
        }
        intRef.element = i3.intValue();
        if (Intrinsics.areEqual((Object) ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), (Object) "8601")) {
            this.mOldIndex = -1;
            intRef.element = 0;
        } else {
            this.mOldIndex = intRef.element;
        }
        if (this.mChangeCountryDialog == null) {
            WheelDialog wheelDialog = new WheelDialog((Context) this, new SettingsActivity$selectSchool$2(intRef, this), SettingsActivity$selectSchool$3.INSTANCE);
            this.mChangeCountryDialog = wheelDialog;
            wheelDialog.setWheelAdapter(new SettingsActivity$selectSchool$4(this));
        }
        WheelDialog wheelDialog2 = this.mChangeCountryDialog;
        if (wheelDialog2 != null) {
            wheelDialog2.setCurrentItem(intRef.element);
        }
        WheelDialog wheelDialog3 = this.mChangeCountryDialog;
        if (wheelDialog3 != null) {
            wheelDialog3.show();
        }
        LoginTrack.INSTANCE.switchSchoolPopShow();
    }

    /* access modifiers changed from: private */
    public final void updateSchoolInfo(int i) {
        ShareDataManager.getInstance().put("school_code", String.valueOf(i), ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().saveCacheGsonEntity(ChooseSchoolUtil.INSTANCE.getChosenSchoolBean(i), "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
    }

    private final void dialogClick() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvSignOut;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSignOut");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new SettingsActivity$dialogClick$1(this), 1, (Object) null);
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        LinearLayout linearLayout = getBinding().layoutClearCache;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.layoutClearCache");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil2, linearLayout, 0, new SettingsActivity$dialogClick$2(this), 1, (Object) null);
        RxUnDoubleUtil rxUnDoubleUtil3 = RxUnDoubleUtil.INSTANCE;
        LinearLayout linearLayout2 = getBinding().layoutSetPassword;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.layoutSetPassword");
        rxUnDoubleUtil3.setOnUnDoubleClickListener(linearLayout2, 500, new SettingsActivity$dialogClick$3(this));
        RxUnDoubleUtil rxUnDoubleUtil4 = RxUnDoubleUtil.INSTANCE;
        LinearLayout linearLayout3 = getBinding().layoutLanguage;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.layoutLanguage");
        rxUnDoubleUtil4.setOnUnDoubleClickListener(linearLayout3, 500, new SettingsActivity$dialogClick$4(this));
    }

    private final String isLatest() {
        if (this.mIsNewVersion) {
            return getString(R.string.update_now);
        }
        return getString(R.string.null_string);
    }

    /* access modifiers changed from: private */
    public final void clearCache() {
        showToast(getString(R.string.cleaning));
        clearContent();
        new Handler(Looper.getMainLooper()).postDelayed(new SettingsActivity$$ExternalSyntheticLambda5(this), 2000);
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCache$lambda-11  reason: not valid java name */
    public static final void m121clearCache$lambda11(SettingsActivity settingsActivity) {
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        settingsActivity.getBinding().tvCacheSize.setText(AppCacheUtil.getCacheSize((Context) settingsActivity));
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, SettingsActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.tv_country_name;
        if (valueOf != null && valueOf.intValue() == i) {
            LeanplumUtil.commonTrack$default("click_change_school", (HashMap) null, 2, (Object) null);
            selectSchool();
        } else {
            int i2 = R.id.layout_version;
            if (valueOf != null && valueOf.intValue() == i2) {
                showLoading();
                AppVersionBll.Companion.getInstance().checkUpdate((Context) this, false, new SettingsActivity$onClick$1(this));
            } else {
                int i3 = R.id.layout_switch_account;
                if (valueOf != null && valueOf.intValue() == i3) {
                    startActivity(new Intent((Context) this, MyAccountListActivity.class));
                } else {
                    int i4 = R.id.layout_notification;
                    if (valueOf != null && valueOf.intValue() == i4) {
                        startActivity(new Intent((Context) this, NotificationActivity.class));
                    } else {
                        int i5 = R.id.layout_about_us;
                        if (valueOf != null && valueOf.intValue() == i5) {
                            startActivity(new Intent((Context) this, AboutUsActivity.class));
                        } else {
                            int i6 = R.id.layout_delete_account;
                            if (valueOf != null && valueOf.intValue() == i6) {
                                JumpToAgreementUtil.INSTANCE.jump2PolicyTip(JumpToAgreementUtil.MENU_LOGOUT_POLICY);
                                LoginTrack.INSTANCE.hw_delete_account_click();
                            } else {
                                int i7 = R.id.layout_address;
                                if (valueOf != null && valueOf.intValue() == i7) {
                                    JumpToAgreementUtil.INSTANCE.jump2PolicyTip(JumpToAgreementUtil.MENU_MY_ADDRESSES);
                                }
                            }
                        }
                    }
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    private final void clearContent() {
        PlayerPreLoadHelp.Companion.getInstance().clearCacheData();
        AppCacheUtil.clearCache((Context) this);
        ShareDataManager.getInstance().clearCanClear_sharedata();
    }
}
