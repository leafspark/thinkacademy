package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.gyf.immersionbar.ImmersionBar;
import com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog;
import com.tal.app.thinkacademy.business.study.study.entity.CurrentSchool;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.vm.StudyCenterVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.LayoutStudyFragmentBinding;
import com.tal.app.thinkacademy.common.base.BaseMgrVmFragment;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.entity.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\fH\u0014J\b\u0010\"\u001a\u00020\u0007H\u0014J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020$H\u0016J\u001a\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002J2\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fH\u0016J\u0012\u0010<\u001a\u00020$2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u001a\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010B\u001a\u00020$H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/StudyPageFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseMgrVmFragment;", "Lcom/tal/app/thinkacademy/business/study/study/vm/StudyCenterVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/LayoutStudyFragmentBinding;", "Lcom/tal/app/thinkacademy/business/study/study/ISwitchAccount;", "()V", "KTabSwitch", "", "fragList", "", "Landroidx/fragment/app/Fragment;", "isBuyClassSwitch", "", "isCanSwitchTab", "isGetSchoolsTimeout", "isShowStudyPage", "mHandler", "Landroid/os/Handler;", "mLiveCoursesFragment", "Lcom/tal/app/thinkacademy/business/study/study/LiveCoursesFragment;", "mRecordedCoursesFragment", "Lcom/tal/app/thinkacademy/business/study/study/RecordedCoursesFragment;", "mSchoolCode", "", "mShowTab", "Lcom/tal/app/thinkacademy/business/study/study/ShowTab;", "mSwitchDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/SwitchDialog;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "getFragmentId", "initTimeZone", "", "onDestroy", "onHiddenChanged", "hidden", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setFragments", "setLogSchoolCode", "showLive", "showLogin", "showRecorded", "showSwitchDialog", "list", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "switchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "showTab", "isHaveCourse", "isSwitchDirectly", "switchAccount", "data", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "switchSchool", "context", "Landroid/content/Context;", "timeZoneTipShow", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyPageFragment.kt */
public final class StudyPageFragment extends BaseMgrVmFragment<StudyCenterVM, LayoutStudyFragmentBinding> implements ISwitchAccount {
    /* access modifiers changed from: private */
    public final int KTabSwitch = 1;
    private final List<Fragment> fragList = new ArrayList();
    private boolean isBuyClassSwitch;
    /* access modifiers changed from: private */
    public boolean isCanSwitchTab;
    /* access modifiers changed from: private */
    public boolean isGetSchoolsTimeout;
    private boolean isShowStudyPage;
    private Handler mHandler = new StudyPageFragment$mHandler$1(this, Looper.getMainLooper());
    /* access modifiers changed from: private */
    public LiveCoursesFragment mLiveCoursesFragment;
    /* access modifiers changed from: private */
    public RecordedCoursesFragment mRecordedCoursesFragment;
    /* access modifiers changed from: private */
    public String mSchoolCode = "";
    /* access modifiers changed from: private */
    public ShowTab mShowTab = ShowTab.None;
    /* access modifiers changed from: private */
    public SwitchDialog mSwitchDialog;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyPageFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ShowTab.values().length];
            iArr2[ShowTab.None.ordinal()] = 1;
            iArr2[ShowTab.Recorded.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SwitchType.values().length];
            iArr3[SwitchType.Account.ordinal()] = 1;
            iArr3[SwitchType.School.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutStudyFragmentBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutStudyFragmentBinding inflate = LayoutStudyFragmentBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public int getFragmentId() {
        return R.id.fragment;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        StudyPageFragment.super.onViewCreated(view, bundle);
        XesTabBottomLayout.clipBottomPadding(getBinding().studyRootCl);
        ImmersionBar.setStatusBarView((Fragment) this, new View[]{getBinding().statusBarView});
        if (Intrinsics.areEqual((Object) ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), (Object) "8601")) {
            findViewById(R.id.llSchoolMars).setVisibility(0);
        }
        getBinding().tvLive.setSelected(true);
        LifecycleOwner lifecycleOwner = getmActivity();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "getmActivity()");
        XesDataBus.with("user_center_login_bus").observe(lifecycleOwner, new StudyPageFragment$onViewCreated$$inlined$observe$1(this));
        LifecycleOwner lifecycleOwner2 = getmActivity();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "getmActivity()");
        XesDataBus.with("user_center_logout_bus").observe(lifecycleOwner2, new StudyPageFragment$onViewCreated$$inlined$observe$2(this));
        LifecycleOwner lifecycleOwner3 = getmActivity();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "getmActivity()");
        XesDataBus.with("seleted_time_zone").observe(lifecycleOwner3, new StudyPageFragment$onViewCreated$$inlined$observe$3(this));
        LifecycleOwner lifecycleOwner4 = (LifecycleOwner) this;
        XesDataBus.with("study_tab_switch").observerSticky(lifecycleOwner4, true, new StudyPageFragment$$ExternalSyntheticLambda4(this));
        XesDataBus.with("study_tab_visible").observerSticky(lifecycleOwner4, true, new StudyPageFragment$$ExternalSyntheticLambda2(this));
        XesDataBus.with("study_tab_live_update").observerSticky(lifecycleOwner4, true, new StudyPageFragment$$ExternalSyntheticLambda3(this));
        if (UserInfoBll.Companion.getInstance().isGuest()) {
            showLogin();
        } else {
            setFragments();
            setLogSchoolCode();
            getMViewModel().initEntryInfo();
        }
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvLogin;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvLogin");
        rxUnDoubleUtil.setOnUnDoubleClickListener(textView, 500, StudyPageFragment$onViewCreated$7.INSTANCE);
        initTimeZone();
        getMViewModel().getLoginData().observe(lifecycleOwner4, new StudyPageFragment$onViewCreated$$inlined$observe$4(this));
        getMViewModel().getTimeZoneCheck().observe(lifecycleOwner4, new StudyPageFragment$$ExternalSyntheticLambda1(this));
        getMViewModel().getCurrentSchool().observe(lifecycleOwner4, new StudyPageFragment$$ExternalSyntheticLambda0(this));
        RxUnDoubleUtil rxUnDoubleUtil2 = RxUnDoubleUtil.INSTANCE;
        RelativeLayout relativeLayout = getBinding().rlLive;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.rlLive");
        rxUnDoubleUtil2.setOnUnDoubleClickListener(relativeLayout, 500, new StudyPageFragment$onViewCreated$11(this));
        RxUnDoubleUtil rxUnDoubleUtil3 = RxUnDoubleUtil.INSTANCE;
        RelativeLayout relativeLayout2 = getBinding().rlRecorded;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.rlRecorded");
        rxUnDoubleUtil3.setOnUnDoubleClickListener(relativeLayout2, 500, new StudyPageFragment$onViewCreated$12(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m382onViewCreated$lambda3(StudyPageFragment studyPageFragment, String str) {
        Intrinsics.checkNotNullParameter(studyPageFragment, "this$0");
        studyPageFragment.isBuyClassSwitch = true;
        StudyTrack.INSTANCE.hw_my_courses_pv("购课成功页");
        if (Intrinsics.areEqual((Object) str, (Object) "live")) {
            LiveCoursesFragment liveCoursesFragment = studyPageFragment.mLiveCoursesFragment;
            if (liveCoursesFragment != null) {
                liveCoursesFragment.requestDataLoading();
            }
            studyPageFragment.showLive();
        } else if (Intrinsics.areEqual((Object) str, (Object) "recorded")) {
            RecordedCoursesFragment recordedCoursesFragment = studyPageFragment.mRecordedCoursesFragment;
            if (recordedCoursesFragment != null) {
                recordedCoursesFragment.requestDataLoading();
            }
            studyPageFragment.showRecorded();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m383onViewCreated$lambda4(StudyPageFragment studyPageFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(studyPageFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        studyPageFragment.isShowStudyPage = bool.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m384onViewCreated$lambda5(StudyPageFragment studyPageFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(studyPageFragment, "this$0");
        LiveCoursesFragment liveCoursesFragment = studyPageFragment.mLiveCoursesFragment;
        if (liveCoursesFragment != null) {
            LiveCoursesFragment.requestData$default(liveCoursesFragment, 0, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m385onViewCreated$lambda7(StudyPageFragment studyPageFragment, StateData stateData) {
        Intrinsics.checkNotNullParameter(studyPageFragment, "this$0");
        if (stateData.getStatus() == StateData.DataStatus.SUCCESS) {
            TimeZoneCheckEntity timeZoneCheckEntity = (TimeZoneCheckEntity) stateData.getData();
            if (timeZoneCheckEntity != null && timeZoneCheckEntity.getInvalid() == 1) {
                ToastUtils.setGravity(17, 0, 0);
                ToastUtils.showShort(R.string.the_time_zone_has_been_switched_to, new Object[]{TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone()});
            }
            ShareDataManager instance = ShareDataManager.getInstance();
            TimeZoneCheckEntity timeZoneCheckEntity2 = (TimeZoneCheckEntity) stateData.getData();
            instance.put("real_show_time_zone", timeZoneCheckEntity2 != null && timeZoneCheckEntity2.getInvalid() == 0 ? TimeZone.getDefault().getID() : TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone(), ShareDataManager.SHAREDATA_NOT_CLEAR);
            String timeZone = TimeZoneUtil.INSTANCE.getTimeZone();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = studyPageFragment.getBinding().tvTimeZone;
            String string = studyPageFragment.getString(R.string.time_zone_tip, new Object[]{timeZone});
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.time_zone_tip, timeZone)");
            Context context = studyPageFragment.getContext();
            textHighLightUtil.setTextHighLightColorSize(textView, string, timeZone, context == null ? -1 : context.getColor(R.color.color_3370FF), SizeUtils.dp2px(14.0f));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m386onViewCreated$lambda8(StudyPageFragment studyPageFragment, StateData stateData) {
        Intrinsics.checkNotNullParameter(studyPageFragment, "this$0");
        studyPageFragment.getBinding().loadStatusView.restoreView();
        boolean z = false;
        if (studyPageFragment.isBuyClassSwitch) {
            studyPageFragment.isBuyClassSwitch = false;
        } else if (studyPageFragment.isGetSchoolsTimeout) {
            studyPageFragment.isGetSchoolsTimeout = false;
        } else {
            Handler handler = studyPageFragment.mHandler;
            if (handler != null) {
                handler.removeMessages(studyPageFragment.KTabSwitch);
            }
            if (stateData.getData() != null) {
                CurrentSchool currentSchool = (CurrentSchool) stateData.getData();
                if (currentSchool == null ? false : Intrinsics.areEqual((Object) currentSchool.getRecord(), (Object) true)) {
                    CurrentSchool currentSchool2 = (CurrentSchool) stateData.getData();
                    if (currentSchool2 != null) {
                        z = Intrinsics.areEqual((Object) currentSchool2.getLive(), (Object) false);
                    }
                    if (z) {
                        studyPageFragment.showRecorded();
                        return;
                    }
                }
            }
            studyPageFragment.showLive();
        }
    }

    public void onResume() {
        StudyPageFragment.super.onResume();
        if (isVisible()) {
            StudyTrack.hw_my_courses_pv$default(StudyTrack.INSTANCE, (String) null, 1, (Object) null);
            this.isShowStudyPage = true;
            if (!Intrinsics.areEqual((Object) this.mSchoolCode, (Object) ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR))) {
                timeZoneTipShow();
            }
        }
    }

    public void onPause() {
        StudyPageFragment.super.onPause();
        this.isShowStudyPage = false;
    }

    public void onHiddenChanged(boolean z) {
        XesLog.i(Tag.StudyPageFragment, new Object[]{"课程首页>>>onHiddenChanged,isHidden=" + z + "，isViewCreated=" + getMIsViewCreated()});
        if (getMIsViewCreated()) {
            StudyPageFragment.super.onHiddenChanged(z);
            this.isShowStudyPage = !z;
            if (!z) {
                StudyTrack.hw_my_courses_pv$default(StudyTrack.INSTANCE, (String) null, 1, (Object) null);
                if (!Intrinsics.areEqual((Object) this.mSchoolCode, (Object) ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR))) {
                    timeZoneTipShow();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setFragments() {
        if (this.mLiveCoursesFragment == null) {
            Fragment liveCoursesFragment = new LiveCoursesFragment();
            this.fragList.add(0, liveCoursesFragment);
            add(liveCoursesFragment);
            liveCoursesFragment.setISwitchAccount(this);
            this.mLiveCoursesFragment = liveCoursesFragment;
        }
        Fragment recordedCoursesFragment = new RecordedCoursesFragment();
        this.fragList.add(1, recordedCoursesFragment);
        add(recordedCoursesFragment);
        recordedCoursesFragment.setISwitchAccount(this);
        this.mRecordedCoursesFragment = recordedCoursesFragment;
        int i = WhenMappings.$EnumSwitchMapping$1[this.mShowTab.ordinal()];
        if (i == 1) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(this.KTabSwitch, 2500);
            }
            getBinding().loadStatusView.showFullLoadingView(R.color.color_f4f6fa);
            getBinding().loadStatusView.setContentBg(R.color.color_f4f6fa);
            if (isViewModelInitialized()) {
                getMViewModel().getCurrentSchoolData();
            }
        } else if (i != 2) {
            showLive();
        } else {
            showRecorded();
        }
    }

    /* access modifiers changed from: private */
    public final void showLogin() {
        getBinding().layoutLogin.setVisibility(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r1 = (r1 = r1.getApplication()).getExternalCacheDir();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setLogSchoolCode() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r1 = r7.getActivity()
            r2 = 0
            if (r1 != 0) goto L_0x000e
        L_0x000c:
            r1 = r2
            goto L_0x0020
        L_0x000e:
            android.app.Application r1 = r1.getApplication()
            if (r1 != 0) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            java.io.File r1 = r1.getExternalCacheDir()
            if (r1 != 0) goto L_0x001c
            goto L_0x000c
        L_0x001c:
            java.lang.String r1 = r1.getAbsolutePath()
        L_0x0020:
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "xesxeslog"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tal.app.thinkacademy.lib.logger.XesUploadPrinter r0 = com.tal.app.thinkacademy.lib.logger.XesUploadPrinter.getInstance(r0)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r1 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r1 = r1.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r1 = r1.getUserInfoEntity()
            if (r1 != 0) goto L_0x0043
            r1 = r2
            goto L_0x0047
        L_0x0043:
            java.lang.String r1 = r1.getUid()
        L_0x0047:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "school_code"
            java.lang.String r6 = ""
            java.lang.String r3 = r3.getString(r5, r6, r4)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r4 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r4 = r4.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r4 = r4.getUserInfoEntity()
            if (r4 != 0) goto L_0x0062
            goto L_0x0066
        L_0x0062:
            java.lang.String r2 = r4.getUnifiedAccessToken()
        L_0x0066:
            r0.setUserInfo(r1, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.StudyPageFragment.setLogSchoolCode():void");
    }

    public void showSwitchDialog(SwitchOptionsList switchOptionsList, SwitchType switchType, ShowTab showTab, boolean z, boolean z2) {
        List<SwitchOptionsEntity> accountList;
        List<SwitchOptionsEntity> schoolList;
        List<SwitchOptionsEntity> accountList2;
        List<SwitchOptionsEntity> schoolList2;
        Intrinsics.checkNotNullParameter(switchType, "switchType");
        Intrinsics.checkNotNullParameter(showTab, "showTab");
        Context context = getContext();
        if (context != null) {
            int i = 1;
            XesLog.i(Tag.StudyPageFragment, new Object[]{"showSwitchDialog--->switchType=" + switchType.name() + "---isShowStudyPage=" + this.isShowStudyPage + "---mShowTab=" + this.mShowTab.name() + "---showTab=" + showTab.name() + "---isSwitchDirectly=" + z2});
            if (this.isShowStudyPage && this.mShowTab == showTab) {
                SwitchOptionsEntity switchOptionsEntity = null;
                if (z2) {
                    int i2 = WhenMappings.$EnumSwitchMapping$2[switchType.ordinal()];
                    if (i2 == 1) {
                        if (!(switchOptionsList == null || (accountList2 = switchOptionsList.getAccountList()) == null)) {
                            switchOptionsEntity = accountList2.get(0);
                        }
                        switchAccount(switchOptionsEntity);
                    } else if (i2 == 2) {
                        if (!(switchOptionsList == null || (schoolList2 = switchOptionsList.getSchoolList()) == null)) {
                            switchOptionsEntity = schoolList2.get(0);
                        }
                        switchSchool(context, switchOptionsEntity);
                    }
                } else {
                    if (this.mSwitchDialog == null) {
                        SwitchDialog switchDialog = new SwitchDialog(context, (SwitchOptionsList) null, switchType, new StudyPageFragment$showSwitchDialog$1$1(this, z, showTab, context));
                        this.mSwitchDialog = switchDialog;
                        switchDialog.setDismissListener(new StudyPageFragment$$ExternalSyntheticLambda5(this, z, showTab));
                    }
                    SwitchDialog switchDialog2 = this.mSwitchDialog;
                    if (switchDialog2 != null) {
                        switchDialog2.setSwitchOptionsList(switchOptionsList, switchType);
                    }
                    SwitchDialog switchDialog3 = this.mSwitchDialog;
                    if (switchDialog3 != null) {
                        switchDialog3.show();
                    }
                    StudyTrack studyTrack = StudyTrack.INSTANCE;
                    String aliasName = switchType.getAliasName();
                    int i3 = WhenMappings.$EnumSwitchMapping$2[switchType.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new NoWhenBranchMatchedException();
                        } else if (!(switchOptionsList == null || (schoolList = switchOptionsList.getSchoolList()) == null)) {
                            i = schoolList.size();
                        }
                    } else if (!(switchOptionsList == null || (accountList = switchOptionsList.getAccountList()) == null)) {
                        i = accountList.size();
                    }
                    studyTrack.hw_user_switcher_pop_show(aliasName, i, z ? "有班级" : "无班级", showTab.getAliasName());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSwitchDialog$lambda-12$lambda-11  reason: not valid java name */
    public static final void m387showSwitchDialog$lambda12$lambda11(StudyPageFragment studyPageFragment, boolean z, ShowTab showTab) {
        SwitchOptionsList mSwitchOptions;
        List<SwitchOptionsEntity> accountList;
        SwitchOptionsList mSwitchOptions2;
        List<SwitchOptionsEntity> schoolList;
        SwitchType switchType;
        String aliasName;
        Intrinsics.checkNotNullParameter(studyPageFragment, "this$0");
        Intrinsics.checkNotNullParameter(showTab, "$showTab");
        StudyTrack studyTrack = StudyTrack.INSTANCE;
        SwitchDialog switchDialog = studyPageFragment.mSwitchDialog;
        String str = "";
        if (!(switchDialog == null || (switchType = switchDialog.getSwitchType()) == null || (aliasName = switchType.getAliasName()) == null)) {
            str = aliasName;
        }
        SwitchDialog switchDialog2 = studyPageFragment.mSwitchDialog;
        SwitchType switchType2 = switchDialog2 == null ? null : switchDialog2.getSwitchType();
        int i = switchType2 == null ? -1 : WhenMappings.$EnumSwitchMapping$2[switchType2.ordinal()];
        int i2 = 1;
        if (i == 1) {
            SwitchDialog switchDialog3 = studyPageFragment.mSwitchDialog;
            if (!(switchDialog3 == null || (mSwitchOptions = switchDialog3.getMSwitchOptions()) == null || (accountList = mSwitchOptions.getAccountList()) == null)) {
                i2 = accountList.size();
            }
        } else if (i != 2) {
            i2 = 0;
        } else {
            SwitchDialog switchDialog4 = studyPageFragment.mSwitchDialog;
            if (!(switchDialog4 == null || (mSwitchOptions2 = switchDialog4.getMSwitchOptions()) == null || (schoolList = mSwitchOptions2.getSchoolList()) == null)) {
                i2 = schoolList.size();
            }
        }
        studyTrack.hw_user_switcher_pop_close_click(str, i2, z ? "有班级" : "无班级", showTab.getAliasName());
    }

    /* access modifiers changed from: private */
    public final void switchAccount(SwitchOptionsEntity switchOptionsEntity) {
        if (!UserInfoBll.Companion.getInstance().isGuest() && switchOptionsEntity != null) {
            XesLog.i(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("切换账号--", switchOptionsEntity.getUid())});
            showLoading();
            getMViewModel().switchAccountLogin(switchOptionsEntity.getUid());
        }
    }

    /* access modifiers changed from: private */
    public final void switchSchool(Context context, SwitchOptionsEntity switchOptionsEntity) {
        if (switchOptionsEntity != null) {
            XesLog.i(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("准备切换分校--", switchOptionsEntity.getUid())});
            ShareDataManager instance = ShareDataManager.getInstance();
            int i = ShareDataManager.SHAREDATA_NOT_CLEAR;
            String str = LiveUrls.SCHOOL_CODE_US;
            if (!Intrinsics.areEqual((Object) instance.getString("school_code", str, i), (Object) switchOptionsEntity.getCode())) {
                XesLog.i(Tag.StudyPageFragment, new Object[]{Intrinsics.stringPlus("开始切换分校--", switchOptionsEntity.getCode())});
                ChooseSchoolUtil chooseSchoolUtil = ChooseSchoolUtil.INSTANCE;
                String code = switchOptionsEntity.getCode();
                if (code == null) {
                    code = str;
                }
                chooseSchoolUtil.updateSchoolInfo(Integer.parseInt(code));
                ChooseSchoolUtil chooseSchoolUtil2 = ChooseSchoolUtil.INSTANCE;
                String code2 = switchOptionsEntity.getCode();
                if (code2 != null) {
                    str = code2;
                }
                chooseSchoolUtil2.changeSchool(Integer.parseInt(str), context);
            }
        }
    }

    private final void initTimeZone() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = getBinding().ivTimeZoneClose;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTimeZoneClose");
        rxUnDoubleUtil.setOnUnDoubleClickListener(imageView, 500, new StudyPageFragment$initTimeZone$1(this));
        timeZoneTipShow();
    }

    private final void timeZoneTipShow() {
        boolean z = true;
        if (!PadUtils.isPad(Utils.getApp()) || !TimeZoneUtil.INSTANCE.isShowTimeZoneBranchSchool()) {
            getBinding().llTimeZoneTip.setVisibility(8);
        } else {
            String timeZone = TimeZoneUtil.INSTANCE.getTimeZone();
            TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
            TextView textView = getBinding().tvTimeZone;
            String string = getString(R.string.time_zone_tip, new Object[]{timeZone});
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.time_zone_tip, timeZone)");
            Context context = getContext();
            textHighLightUtil.setTextHighLightColorSize(textView, string, timeZone, context == null ? -1 : context.getColor(R.color.color_3370FF), SizeUtils.dp2px(14.0f));
            CharSequence appTimeZone = TimeZoneUtil.INSTANCE.getAppTimeZone();
            if (appTimeZone == null || StringsKt.isBlank(appTimeZone)) {
                if (TimeZoneUtil.INSTANCE.setTimeZoneEqualsBranchSchool()) {
                    getBinding().llTimeZoneTip.setVisibility(8);
                } else {
                    if (getBinding().llTimeZoneTip.getVisibility() == 8) {
                        StudyTrack.INSTANCE.hw_time_zone_show();
                    }
                    getBinding().llTimeZoneTip.setVisibility(0);
                }
            } else if (!TimeZoneUtil.INSTANCE.appTimeZoneEqualsSetting()) {
                if (getBinding().llTimeZoneTip.getVisibility() == 8) {
                    StudyTrack.INSTANCE.hw_time_zone_show();
                }
                getBinding().llTimeZoneTip.setVisibility(0);
            } else if (TimeZoneUtil.INSTANCE.setTimeZoneEqualsBranchSchool()) {
                getBinding().llTimeZoneTip.setVisibility(8);
            } else {
                if (getBinding().llTimeZoneTip.getVisibility() == 8) {
                    StudyTrack.INSTANCE.hw_time_zone_show();
                }
                getBinding().llTimeZoneTip.setVisibility(0);
            }
        }
        CharSequence string2 = ShareDataManager.getInstance().getString("time_zone", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (string2 == null || StringsKt.isBlank(string2)) {
            CharSequence id = TimeZone.getDefault().getID();
            if (!(id == null || id.length() == 0)) {
                z = false;
            }
            if (z) {
                ShareDataManager.getInstance().put("real_show_time_zone", TimeZoneUtil.INSTANCE.getBranchSchoolTimeZone(), ShareDataManager.SHAREDATA_NOT_CLEAR);
            } else if (isViewModelInitialized()) {
                String id2 = TimeZone.getDefault().getID();
                Intrinsics.checkNotNullExpressionValue(id2, "getDefault().id");
                getMViewModel().timeZoneCheck(id2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showLive() {
        show(this.mLiveCoursesFragment);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(this.KTabSwitch);
        }
        getBinding().loadStatusView.restoreView();
        getBinding().tvLive.setSelected(true);
        getBinding().tvRecorded.setSelected(false);
        this.isCanSwitchTab = true;
        this.mShowTab = ShowTab.Live;
        XesLog.i(Tag.StudyPageFragment, new Object[]{"展示直播页"});
    }

    /* access modifiers changed from: private */
    public final void showRecorded() {
        show(this.mRecordedCoursesFragment);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(this.KTabSwitch);
        }
        getBinding().loadStatusView.restoreView();
        getBinding().tvLive.setSelected(false);
        getBinding().tvRecorded.setSelected(true);
        this.isCanSwitchTab = true;
        this.mShowTab = ShowTab.Recorded;
        XesLog.i(Tag.StudyPageFragment, new Object[]{"展示录播页"});
    }

    public void onDestroy() {
        StudyPageFragment.super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }
}
