package com.tal.app.thinkacademy.business.shop.classdetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.entity.AccountListEntity;
import com.tal.app.thinkacademy.business.login.entity.AddNewStudent;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.UserInfo;
import com.tal.app.thinkacademy.business.shop.bean.request.PerfectInforRequest;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.AddStudentDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ChooseStudentDialog;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.PerfectInforDialog;
import com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B>\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u000e\u00104\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u00105\u001a\u00020\fJ\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020/H\u0002J\u0006\u00109\u001a\u00020\fJ\b\u0010:\u001a\u00020\fH\u0002J\b\u0010;\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\fH\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u00108\u001a\u00020/H\u0002J\u0010\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u000207H\u0002J\u0006\u0010@\u001a\u00020\fR\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/StudentInfo;", "", "mViewModel", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;", "activity", "Lcom/tal/app/thinkacademy/common/base/XesBaseActivity;", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/shop/classdetail/AccountListTypeEnum;", "Lkotlin/ParameterName;", "name", "type", "", "(Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;Lcom/tal/app/thinkacademy/common/base/XesBaseActivity;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "getActivity", "()Lcom/tal/app/thinkacademy/common/base/XesBaseActivity;", "setActivity", "(Lcom/tal/app/thinkacademy/common/base/XesBaseActivity;)V", "context", "Ljava/lang/ref/WeakReference;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "mAccountListEntity", "Lcom/tal/app/thinkacademy/business/login/entity/AccountListEntity;", "mAccountListTypeEnum", "mAddStudentDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/AddStudentDialog;", "mGetUserInfoType", "Lcom/tal/app/thinkacademy/business/shop/classdetail/GetUserInfoType;", "mGradePosition", "", "mGradeStageList", "", "Lcom/tal/app/thinkacademy/common/user/Grade;", "mGradeStageListEnum", "Lcom/tal/app/thinkacademy/business/shop/classdetail/GradeStageListEnum;", "mPerfectInforDialog", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/PerfectInforDialog;", "mPerfectInforRequest", "Lcom/tal/app/thinkacademy/business/shop/bean/request/PerfectInforRequest;", "mSwitchLogin", "Lcom/tal/app/thinkacademy/business/shop/classdetail/SwitchLogin;", "mUserInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/UserInfo;", "getMViewModel", "()Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;", "setMViewModel", "(Lcom/tal/app/thinkacademy/business/shop/viewmodel/SeletedStudentViewModel;)V", "getAccountList", "gotoPerfectInfo", "inforIsPerfect", "", "userInfo", "onDestroy", "saveUserInfo", "showAddStudentDialog", "showChooseStudentDialog", "showPerfectInforDialog", "showSwitchToast", "success", "viewmModelObserve", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentInfo.kt */
public final class StudentInfo {
    /* access modifiers changed from: private */
    public final String TAG;
    private XesBaseActivity activity;
    private WeakReference<XesBaseActivity> context;
    private Function1<? super AccountListTypeEnum, Unit> listener;
    private AccountListEntity mAccountListEntity;
    /* access modifiers changed from: private */
    public AccountListTypeEnum mAccountListTypeEnum;
    /* access modifiers changed from: private */
    public AddStudentDialog mAddStudentDialog;
    private GetUserInfoType mGetUserInfoType;
    private int mGradePosition;
    /* access modifiers changed from: private */
    public List<Grade> mGradeStageList;
    /* access modifiers changed from: private */
    public GradeStageListEnum mGradeStageListEnum;
    /* access modifiers changed from: private */
    public PerfectInforDialog mPerfectInforDialog;
    /* access modifiers changed from: private */
    public PerfectInforRequest mPerfectInforRequest;
    /* access modifiers changed from: private */
    public SwitchLogin mSwitchLogin;
    private UserInfo mUserInfo;
    private SeletedStudentViewModel mViewModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudentInfo.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SwitchLogin.values().length];
            iArr2[SwitchLogin.OnlySwitch.ordinal()] = 1;
            iArr2[SwitchLogin.AddStudent.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[GradeStageListEnum.values().length];
            iArr3[GradeStageListEnum.PerfectInfor.ordinal()] = 1;
            iArr3[GradeStageListEnum.AddStudent.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public StudentInfo(SeletedStudentViewModel seletedStudentViewModel, XesBaseActivity xesBaseActivity, Function1<? super AccountListTypeEnum, Unit> function1) {
        Intrinsics.checkNotNullParameter(xesBaseActivity, "activity");
        this.mViewModel = seletedStudentViewModel;
        this.activity = xesBaseActivity;
        this.listener = function1;
        this.context = new WeakReference<>(this.activity);
        this.mGetUserInfoType = GetUserInfoType.PerfectInfor;
        this.mSwitchLogin = SwitchLogin.OnlySwitch;
        this.mGradeStageListEnum = GradeStageListEnum.PerfectInfor;
        this.mGradeStageList = new ArrayList();
        this.mGradePosition = -1;
        this.mAccountListTypeEnum = AccountListTypeEnum.GoToBuy;
        this.TAG = "商城用户选择";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StudentInfo(SeletedStudentViewModel seletedStudentViewModel, XesBaseActivity xesBaseActivity, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(seletedStudentViewModel, xesBaseActivity, (i & 4) != 0 ? null : function1);
    }

    public final SeletedStudentViewModel getMViewModel() {
        return this.mViewModel;
    }

    public final void setMViewModel(SeletedStudentViewModel seletedStudentViewModel) {
        this.mViewModel = seletedStudentViewModel;
    }

    public final XesBaseActivity getActivity() {
        return this.activity;
    }

    public final void setActivity(XesBaseActivity xesBaseActivity) {
        Intrinsics.checkNotNullParameter(xesBaseActivity, "<set-?>");
        this.activity = xesBaseActivity;
    }

    public final Function1<AccountListTypeEnum, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(Function1<? super AccountListTypeEnum, Unit> function1) {
        this.listener = function1;
    }

    public final void gotoPerfectInfo() {
        XesBaseActivity xesBaseActivity;
        WeakReference<XesBaseActivity> weakReference = this.context;
        if (weakReference != null && (xesBaseActivity = (XesBaseActivity) weakReference.get()) != null) {
            xesBaseActivity.showLoading();
            SeletedStudentViewModel mViewModel2 = getMViewModel();
            if (mViewModel2 != null) {
                mViewModel2.checkUserInfo();
            }
        }
    }

    public final void getAccountList(AccountListTypeEnum accountListTypeEnum) {
        Intrinsics.checkNotNullParameter(accountListTypeEnum, ClassParamsKt.TYPE);
        this.mAccountListTypeEnum = accountListTypeEnum;
        SeletedStudentViewModel seletedStudentViewModel = this.mViewModel;
        if (seletedStudentViewModel != null) {
            seletedStudentViewModel.getAccountList();
        }
    }

    public final void viewmModelObserve() {
        LifecycleOwner lifecycleOwner;
        StateLiveData<GradeStageList> gradeStageList;
        StateLiveData<Object> modifyUserInfo;
        StateLiveData<AddNewStudent> addNewStudent;
        StateLiveData<UserBean> loginData;
        StateLiveData<UserInfo> checkUserInfo;
        StateLiveData<AccountListEntity> accountList;
        WeakReference<XesBaseActivity> weakReference = this.context;
        if (weakReference != null && (lifecycleOwner = (XesBaseActivity) weakReference.get()) != null) {
            SeletedStudentViewModel mViewModel2 = getMViewModel();
            if (!(mViewModel2 == null || (accountList = mViewModel2.getAccountList()) == null)) {
                accountList.observe(lifecycleOwner, new StudentInfo$$ExternalSyntheticLambda1(lifecycleOwner, this));
            }
            SeletedStudentViewModel mViewModel3 = getMViewModel();
            if (!(mViewModel3 == null || (checkUserInfo = mViewModel3.getCheckUserInfo()) == null)) {
                checkUserInfo.observe(lifecycleOwner, new StudentInfo$$ExternalSyntheticLambda3(lifecycleOwner, this));
            }
            SeletedStudentViewModel mViewModel4 = getMViewModel();
            if (!(mViewModel4 == null || (loginData = mViewModel4.getLoginData()) == null)) {
                loginData.observe(lifecycleOwner, new StudentInfo$$ExternalSyntheticLambda2(lifecycleOwner, this));
            }
            SeletedStudentViewModel mViewModel5 = getMViewModel();
            if (!(mViewModel5 == null || (addNewStudent = mViewModel5.getAddNewStudent()) == null)) {
                addNewStudent.observe(lifecycleOwner, new StudentInfo$$ExternalSyntheticLambda4(lifecycleOwner, this));
            }
            SeletedStudentViewModel mViewModel6 = getMViewModel();
            if (!(mViewModel6 == null || (modifyUserInfo = mViewModel6.getModifyUserInfo()) == null)) {
                modifyUserInfo.observe(lifecycleOwner, new StudentInfo$$ExternalSyntheticLambda5(lifecycleOwner, this));
            }
            SeletedStudentViewModel mViewModel7 = getMViewModel();
            if (mViewModel7 != null && (gradeStageList = mViewModel7.getGradeStageList()) != null) {
                gradeStageList.observe(lifecycleOwner, new StudentInfo$$ExternalSyntheticLambda0(lifecycleOwner, this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-11$lambda-2  reason: not valid java name */
    public static final void m255viewmModelObserve$lambda11$lambda2(XesBaseActivity xesBaseActivity, StudentInfo studentInfo, StateData stateData) {
        AccountListEntity accountListEntity;
        Intrinsics.checkNotNullParameter(xesBaseActivity, "$activity");
        Intrinsics.checkNotNullParameter(studentInfo, "this$0");
        xesBaseActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        } else if (stateData.getData() != null && (accountListEntity = (AccountListEntity) stateData.getData()) != null) {
            studentInfo.mAccountListEntity = accountListEntity;
            if (accountListEntity.getCurrentAccount() != null) {
                XesLog.dt(studentInfo.TAG, new Object[]{"有当前账号,弹窗选择账号"});
                studentInfo.showChooseStudentDialog();
                return;
            }
            Function1<AccountListTypeEnum, Unit> listener2 = studentInfo.getListener();
            if (listener2 != null) {
                listener2.invoke(studentInfo.mAccountListTypeEnum);
            }
            XesLog.dt(studentInfo.TAG, new Object[]{"获取用户列表：当前账号没有，直接购买"});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-11$lambda-4  reason: not valid java name */
    public static final void m256viewmModelObserve$lambda11$lambda4(XesBaseActivity xesBaseActivity, StudentInfo studentInfo, StateData stateData) {
        Intrinsics.checkNotNullParameter(xesBaseActivity, "$activity");
        Intrinsics.checkNotNullParameter(studentInfo, "this$0");
        xesBaseActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        } else if (stateData.getData() == null) {
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        } else {
            UserInfo userInfo = (UserInfo) stateData.getData();
            if (userInfo != null) {
                studentInfo.mUserInfo = userInfo;
                if (studentInfo.mGradeStageList.isEmpty()) {
                    XesLog.dt(studentInfo.TAG, new Object[]{"获取用户信息完毕，没有年级列表，先获取年级列表"});
                    studentInfo.mGradeStageListEnum = GradeStageListEnum.PerfectInfor;
                    xesBaseActivity.showLoading();
                    SeletedStudentViewModel mViewModel2 = studentInfo.getMViewModel();
                    if (mViewModel2 != null) {
                        mViewModel2.getGradeStageList();
                        return;
                    }
                    return;
                }
                XesLog.dt(studentInfo.TAG, new Object[]{"获取用户信息完毕，有年级列表，直接去完善信息"});
                studentInfo.showPerfectInforDialog(userInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-11$lambda-5  reason: not valid java name */
    public static final void m257viewmModelObserve$lambda11$lambda5(XesBaseActivity xesBaseActivity, StudentInfo studentInfo, StateData stateData) {
        Intrinsics.checkNotNullParameter(xesBaseActivity, "$activity");
        Intrinsics.checkNotNullParameter(studentInfo, "this$0");
        xesBaseActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            studentInfo.showSwitchToast(false);
        } else if (stateData.getData() == null) {
            xesBaseActivity.showToast(xesBaseActivity.getString(R.string.many_attempts_tip));
        } else {
            ShareDataManager.getInstance().remove(ShareDataManager.SHAREDATA_NOT_CLEAR, new String[]{"user_uid"});
            ShareDataManager.getInstance().clearUser_sharedata();
            UserInfoBll.Companion.getInstance().clearUserInfo();
            XesWebViewCookieUtils.clearCookies();
            UserBean userBean = (UserBean) stateData.getData();
            ShareDataManager.getInstance().initUserSP(String.valueOf(userBean == null ? null : userBean.getUid()));
            LoginIn.INSTANCE.loginInfo((UserBean) stateData.getData(), false, (Context) xesBaseActivity, 1);
            XesDataBus.with("user_center_login_bus").setStickyData("switchLogin");
            studentInfo.showSwitchToast(true);
            int i = WhenMappings.$EnumSwitchMapping$1[studentInfo.mSwitchLogin.ordinal()];
            if (i == 1) {
                XesLog.dt(studentInfo.TAG, new Object[]{"直接切换账号，直接去购买"});
                Function1<? super AccountListTypeEnum, Unit> function1 = studentInfo.listener;
                if (function1 != null) {
                    function1.invoke(studentInfo.mAccountListTypeEnum);
                }
            } else if (i == 2) {
                XesLog.dt(studentInfo.TAG, new Object[]{"新增账号后的，切换账号"});
                xesBaseActivity.showLoading();
                SeletedStudentViewModel seletedStudentViewModel = studentInfo.mViewModel;
                if (seletedStudentViewModel != null) {
                    seletedStudentViewModel.getAccountList();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-11$lambda-6  reason: not valid java name */
    public static final void m258viewmModelObserve$lambda11$lambda6(XesBaseActivity xesBaseActivity, StudentInfo studentInfo, StateData stateData) {
        AddNewStudent addNewStudent;
        Integer id;
        Intrinsics.checkNotNullParameter(xesBaseActivity, "$activity");
        Intrinsics.checkNotNullParameter(studentInfo, "this$0");
        xesBaseActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            XesDataBus.with("add_new_student").setStickyData("add_new_student");
            AddStudentDialog addStudentDialog = studentInfo.mAddStudentDialog;
            if (addStudentDialog != null) {
                addStudentDialog.dismiss();
            }
            studentInfo.mSwitchLogin = SwitchLogin.AddStudent;
            xesBaseActivity.showLoading();
            SeletedStudentViewModel seletedStudentViewModel = studentInfo.mViewModel;
            if (seletedStudentViewModel != null) {
                String str = null;
                if (!(stateData == null || (addNewStudent = (AddNewStudent) stateData.getData()) == null || (id = addNewStudent.getId()) == null)) {
                    str = id.toString();
                }
                seletedStudentViewModel.switchLogin(str);
                return;
            }
            return;
        }
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: viewmModelObserve$lambda-11$lambda-7  reason: not valid java name */
    public static final void m259viewmModelObserve$lambda11$lambda7(XesBaseActivity xesBaseActivity, StudentInfo studentInfo, StateData stateData) {
        Intrinsics.checkNotNullParameter(xesBaseActivity, "$activity");
        Intrinsics.checkNotNullParameter(studentInfo, "this$0");
        xesBaseActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            PerfectInforDialog perfectInforDialog = studentInfo.mPerfectInforDialog;
            if (perfectInforDialog != null) {
                perfectInforDialog.dismiss();
            }
            studentInfo.saveUserInfo();
            XesLog.dt(studentInfo.TAG, new Object[]{"修改用户信息完毕，流程结束"});
            return;
        }
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e A[SYNTHETIC] */
    /* renamed from: viewmModelObserve$lambda-11$lambda-10  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m254viewmModelObserve$lambda11$lambda10(com.tal.app.thinkacademy.common.base.XesBaseActivity r8, com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo r9, com.tal.app.thinkacademy.common.entity.StateData r10) {
        /*
            java.lang.String r0 = "$activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r8.hideLoading()
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r8 = r10.getStatus()
            int[] r0 = com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r0[r8]
            r0 = 1
            r1 = 0
            if (r8 != r0) goto L_0x00a4
            java.lang.Object r8 = r10.getData()
            com.tal.app.thinkacademy.common.user.GradeStageList r8 = (com.tal.app.thinkacademy.common.user.GradeStageList) r8
            if (r8 != 0) goto L_0x0027
            goto L_0x00b2
        L_0x0027:
            java.lang.Object r8 = r10.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.tal.app.thinkacademy.common.user.GradeStageList r8 = (com.tal.app.thinkacademy.common.user.GradeStageList) r8
            java.util.List r8 = r8.getList()
            int r10 = r8.size()
            r2 = r1
        L_0x0039:
            if (r2 >= r10) goto L_0x0082
            int r3 = r2 + 1
            java.lang.Object r2 = r8.get(r2)
            com.tal.app.thinkacademy.common.user.GradeStage r2 = (com.tal.app.thinkacademy.common.user.GradeStage) r2
            java.util.List r2 = r2.getList()
            int r4 = r2.size()
            r5 = r1
        L_0x004c:
            if (r5 >= r4) goto L_0x0080
            int r6 = r5 + 1
            java.lang.Object r5 = r2.get(r5)
            com.tal.app.thinkacademy.common.user.Grade r5 = (com.tal.app.thinkacademy.common.user.Grade) r5
            java.util.List<com.tal.app.thinkacademy.common.user.Grade> r7 = r9.mGradeStageList
            r7.add(r5)
            com.tal.app.thinkacademy.business.shop.bean.UserInfo r7 = r9.mUserInfo
            if (r7 != 0) goto L_0x0061
        L_0x005f:
            r5 = r1
            goto L_0x0073
        L_0x0061:
            java.lang.Integer r7 = r7.getGradeId()
            int r5 = r5.getValue()
            if (r7 != 0) goto L_0x006c
            goto L_0x005f
        L_0x006c:
            int r7 = r7.intValue()
            if (r7 != r5) goto L_0x005f
            r5 = r0
        L_0x0073:
            if (r5 == 0) goto L_0x007e
            java.util.List<com.tal.app.thinkacademy.common.user.Grade> r5 = r9.mGradeStageList
            int r5 = r5.size()
            int r5 = r5 - r0
            r9.mGradePosition = r5
        L_0x007e:
            r5 = r6
            goto L_0x004c
        L_0x0080:
            r2 = r3
            goto L_0x0039
        L_0x0082:
            com.tal.app.thinkacademy.business.shop.classdetail.GradeStageListEnum r8 = r9.mGradeStageListEnum
            int[] r10 = com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo.WhenMappings.$EnumSwitchMapping$2
            int r8 = r8.ordinal()
            r8 = r10[r8]
            if (r8 == r0) goto L_0x009b
            r10 = 2
            if (r8 != r10) goto L_0x0095
            r9.showAddStudentDialog()
            goto L_0x00b2
        L_0x0095:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x009b:
            com.tal.app.thinkacademy.business.shop.bean.UserInfo r8 = r9.mUserInfo
            if (r8 != 0) goto L_0x00a0
            goto L_0x00b2
        L_0x00a0:
            r9.showPerfectInforDialog(r8)
            goto L_0x00b2
        L_0x00a4:
            r8 = 17
            com.tal.app.thinkacademy.lib.util.ToastUtils.setGravity(r8, r1, r1)
            java.lang.String r8 = r10.getMsg()
            java.lang.Object[] r9 = new java.lang.Object[r1]
            com.tal.app.thinkacademy.lib.util.ToastUtils.showShort(r8, r9)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo.m254viewmModelObserve$lambda11$lambda10(com.tal.app.thinkacademy.common.base.XesBaseActivity, com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo, com.tal.app.thinkacademy.common.entity.StateData):void");
    }

    public final void onDestroy() {
        this.mViewModel = null;
        this.context = null;
    }

    private final void showChooseStudentDialog() {
        Context context2;
        WeakReference<XesBaseActivity> weakReference = this.context;
        if (weakReference != null && (context2 = (XesBaseActivity) weakReference.get()) != null && !context2.isFinishing()) {
            new ChooseStudentDialog(context2, this.mAccountListEntity, new StudentInfo$showChooseStudentDialog$1$1(this, context2)).show();
        }
    }

    private final void showPerfectInforDialog(UserInfo userInfo) {
        Context context2;
        WeakReference<XesBaseActivity> weakReference = this.context;
        if (weakReference != null && (context2 = (XesBaseActivity) weakReference.get()) != null && !context2.isFinishing()) {
            PerfectInforDialog perfectInforDialog = new PerfectInforDialog(context2, userInfo, this.mGradeStageList, this.mGradePosition, new StudentInfo$showPerfectInforDialog$1$1(context2, this));
            this.mPerfectInforDialog = perfectInforDialog;
            perfectInforDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showAddStudentDialog() {
        Context context2;
        WeakReference<XesBaseActivity> weakReference = this.context;
        if (weakReference != null && (context2 = (XesBaseActivity) weakReference.get()) != null && !context2.isFinishing()) {
            AddStudentDialog addStudentDialog = new AddStudentDialog(context2, this.mGradeStageList, new StudentInfo$showAddStudentDialog$1$1(context2, this));
            this.mAddStudentDialog = addStudentDialog;
            addStudentDialog.show();
        }
    }

    private final void showSwitchToast(boolean z) {
        XesBaseActivity xesBaseActivity;
        WeakReference<XesBaseActivity> weakReference = this.context;
        if (weakReference != null && (xesBaseActivity = (XesBaseActivity) weakReference.get()) != null) {
            LayoutInflater layoutInflater = xesBaseActivity.getLayoutInflater();
            int i = R.layout.layout_custom_toast;
            View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ayout_custom_toast, null)");
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
            if (z) {
                imageView.setImageResource(R.drawable.add_account_success);
                textView.setText(xesBaseActivity.getString(R.string.switch_successfully));
            } else {
                imageView.setImageResource(R.drawable.add_account_failed);
                textView.setText(xesBaseActivity.getString(R.string.switch_failed));
            }
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showCustomShort(inflate);
        }
    }

    private final boolean inforIsPerfect(UserInfo userInfo) {
        CharSequence firstName = userInfo.getFirstName();
        if (!(firstName == null || StringsKt.isBlank(firstName))) {
            CharSequence lastName = userInfo.getLastName();
            if (!(lastName == null || StringsKt.isBlank(lastName))) {
                CharSequence gradeName = userInfo.getGradeName();
                if (!(gradeName == null || StringsKt.isBlank(gradeName))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void saveUserInfo() {
        com.tal.app.thinkacademy.common.user.UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        PerfectInforRequest perfectInforRequest = null;
        UserBean userBean = new UserBean((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 1023, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(userInfoEntity);
        String uid = userInfoEntity.getUid();
        Intrinsics.checkNotNull(uid);
        userBean.setUid(Integer.valueOf(Integer.parseInt(uid)));
        PerfectInforRequest perfectInforRequest2 = this.mPerfectInforRequest;
        if (perfectInforRequest2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPerfectInforRequest");
            perfectInforRequest2 = null;
        }
        userBean.setAvatar(perfectInforRequest2.getAvatar());
        userBean.setPhone(userInfoEntity.getPhone());
        userBean.setEmail(userInfoEntity.getEmail());
        PerfectInforRequest perfectInforRequest3 = this.mPerfectInforRequest;
        if (perfectInforRequest3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPerfectInforRequest");
        } else {
            perfectInforRequest = perfectInforRequest3;
        }
        userBean.setNickName(perfectInforRequest.getNickName());
        userBean.setCountryCallingCode(userInfoEntity.getCountryCallingCode());
        userBean.setUnifiedAccessToken(userInfoEntity.getUnifiedAccessToken());
        userBean.setCard(userInfoEntity.getCard());
        UserInfoBll.Companion.getInstance().saveUserInfo(userBean);
    }
}
