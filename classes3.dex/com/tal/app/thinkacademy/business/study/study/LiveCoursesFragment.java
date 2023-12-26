package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tal.app.thinkacademy.business.study.study.ISwitchAccount;
import com.tal.app.thinkacademy.business.study.study.adapter.ClassAdapter;
import com.tal.app.thinkacademy.business.study.study.entity.ClassListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Course;
import com.tal.app.thinkacademy.business.study.study.entity.Record;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.vm.StudyCenterVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.LayoutCourseListFragmentBinding;
import com.tal.app.thinkacademy.common.CommonStateKt;
import com.tal.app.thinkacademy.common.base.BaseVmFragment;
import com.tal.app.thinkacademy.common.courseware.ImCousesWare;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.widget.DeviceTesting;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0014J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\fH\u0016J(\u0010$\u001a\u00020\u00182\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016J\u001a\u0010+\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0018J\u0010\u00101\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\b\u00102\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u0018H\u0002J\u0012\u00104\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/LiveCoursesFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "Lcom/tal/app/thinkacademy/business/study/study/vm/StudyCenterVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/LayoutCourseListFragmentBinding;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "()V", "accountListSize", "", "deviceTestingIndex", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/adapter/ClassAdapter;", "mHaveCourse", "", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mPageNum", "mSwitchOptions", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "mSwitchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "schoolListSize", "switchListener", "Lcom/tal/app/thinkacademy/business/study/study/ISwitchAccount;", "addFootView", "", "checkAndReport", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "gotoSeletedCourse", "onDestroy", "onHiddenChanged", "hidden", "onItemClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "onResume", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "requestData", "pageNum", "requestDataLoading", "setISwitchAccount", "setViewValues", "showEmptyData", "showError", "msg", "", "startObserve", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveCoursesFragment.kt */
public final class LiveCoursesFragment extends BaseVmFragment<StudyCenterVM, LayoutCourseListFragmentBinding> implements OnItemClickListener {
    private int accountListSize;
    /* access modifiers changed from: private */
    public int deviceTestingIndex;
    /* access modifiers changed from: private */
    public ClassAdapter mAdapter;
    /* access modifiers changed from: private */
    public boolean mHaveCourse;
    private LinearLayoutManager mLayoutManager;
    /* access modifiers changed from: private */
    public int mPageNum = 1;
    /* access modifiers changed from: private */
    public SwitchOptionsList mSwitchOptions;
    /* access modifiers changed from: private */
    public SwitchType mSwitchType = SwitchType.Account;
    private int schoolListSize;
    /* access modifiers changed from: private */
    public ISwitchAccount switchListener;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveCoursesFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SwitchType.values().length];
            iArr2[SwitchType.Account.ordinal()] = 1;
            iArr2[SwitchType.School.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* access modifiers changed from: protected */
    public LayoutCourseListFragmentBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutCourseListFragmentBinding inflate = LayoutCourseListFragmentBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, attach)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        LiveCoursesFragment.super.onViewCreated(view, bundle);
        setViewValues();
    }

    public void onResume() {
        LiveCoursesFragment.super.onResume();
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            requestDataLoading();
            if (isVisible()) {
                StudyTrack.hw_class_pv$default(StudyTrack.INSTANCE, (String) null, 1, (Object) null);
                checkAndReport();
            }
        }
    }

    public void onHiddenChanged(boolean z) {
        LiveCoursesFragment.super.onHiddenChanged(z);
        if (!z) {
            StudyTrack.hw_class_pv$default(StudyTrack.INSTANCE, (String) null, 1, (Object) null);
            checkAndReport();
        }
    }

    private final void setViewValues() {
        getBinding().srLayout.setOnRefreshLoadMoreListener(new LiveCoursesFragment$setViewValues$1(this));
        getBinding().recyclerView.addOnScrollListener(new LiveCoursesFragment$setViewValues$2(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        View view = getBinding().tvClickSwitchAccountOrSchool;
        Intrinsics.checkNotNullExpressionValue(view, "binding.tvClickSwitchAccountOrSchool");
        rxUnDoubleUtil.setOnUnDoubleClickListener(view, 500, new LiveCoursesFragment$setViewValues$3(this));
    }

    public final void requestDataLoading() {
        if (!UserInfoBll.Companion.getInstance().isGuest() && isViewModelInitialized()) {
            getBinding().loadStatusView.restoreView();
            getBinding().loadStatusView.showFullLoadingView(R.color.color_f4f6fa);
            getBinding().loadStatusView.setContentBg(R.color.color_f4f6fa);
            getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
            requestData$default(this, 0, 1, (Object) null);
        }
    }

    public static /* synthetic */ void requestData$default(LiveCoursesFragment liveCoursesFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        liveCoursesFragment.requestData(i);
    }

    public final void requestData(int i) {
        Context context = getContext();
        if (context != null && !UserInfoBll.Companion.getInstance().isGuest() && isViewModelInitialized()) {
            if (i == 1) {
                ImCousesWare.INSTANCE.getCourseWarePreList();
                ImConfig.INSTANCE.getConfigInfo();
            }
            this.mPageNum = i;
            getMViewModel().getClassListData(context);
        }
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getClassList().observe(lifecycleOwner, new LiveCoursesFragment$$ExternalSyntheticLambda1(this));
        getMViewModel().getSwitchOptions().observe(lifecycleOwner, new LiveCoursesFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-4  reason: not valid java name */
    public static final void m373startObserve$lambda4(LiveCoursesFragment liveCoursesFragment, StateData stateData) {
        List<Record> list;
        ClassListEntity classListEntity;
        LiveCoursesFragment liveCoursesFragment2 = liveCoursesFragment;
        Intrinsics.checkNotNullParameter(liveCoursesFragment2, "this$0");
        liveCoursesFragment.getBinding().srLayout.finishRefresh();
        liveCoursesFragment.getBinding().srLayout.finishLoadMore();
        liveCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            liveCoursesFragment2.showError(stateData.getMsg());
            XesLog.it(liveCoursesFragment2.TAG, new Object[]{stateData.getCode() + "  " + stateData.getMsg()});
        } else if (stateData.getData() == null) {
            XesLog.i(Tag.LiveCoursesFragment, new Object[]{"classList is null"});
            liveCoursesFragment2.showError(stateData.getMsg());
        } else {
            XesLog.i(Tag.LiveCoursesFragment, new Object[]{Intrinsics.stringPlus("直播列表数据：", GsonUtil.getInstance().objToJson(stateData.getData()))});
            liveCoursesFragment.getBinding().srLayout.setEnableLoadMore(false);
            liveCoursesFragment.getBinding().srLayout.setNoMoreData(false);
            Unit unit = null;
            if (stateData == null || (classListEntity = (ClassListEntity) stateData.getData()) == null) {
                list = null;
            } else {
                list = classListEntity.getClassList();
            }
            Collection collection = list;
            liveCoursesFragment2.mHaveCourse = !(collection == null || collection.isEmpty());
            XesLog.i(Tag.LiveCoursesFragment, new Object[]{Intrinsics.stringPlus("是否有直播课--", Boolean.valueOf(liveCoursesFragment2.mHaveCourse))});
            if (liveCoursesFragment2.mHaveCourse) {
                liveCoursesFragment.getBinding().loadStatusView.restoreView();
            } else {
                liveCoursesFragment.showEmptyData();
            }
            XesLog.i(Tag.LiveCoursesFragment, new Object[]{Intrinsics.stringPlus("isCloseDeviceTesting---", Boolean.valueOf(CommonStateKt.isCloseDeviceTesting()))});
            if (!DeviceTesting.INSTANCE.isTestFinished() && !UserInfoBll.Companion.getInstance().isGuest() && liveCoursesFragment2.mHaveCourse && !CommonStateKt.isCloseDeviceTesting()) {
                XesLog.i(Tag.LiveCoursesFragment, new Object[]{"展示设备检测"});
                Record record = new Record((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Course) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (SwitchType) null, 262143, (DefaultConstructorMarker) null);
                record.setItemType(1);
                if (list != null) {
                    list.add(liveCoursesFragment2.deviceTestingIndex, record);
                }
                StudyTrack.INSTANCE.hw_device_test_show();
            }
            ClassAdapter classAdapter = liveCoursesFragment2.mAdapter;
            if (classAdapter != null) {
                classAdapter.setList(collection);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                liveCoursesFragment2.mAdapter = new ClassAdapter(list, new LiveCoursesFragment$startObserve$1$3$1(liveCoursesFragment2));
                liveCoursesFragment2.mLayoutManager = new LinearLayoutManager(liveCoursesFragment.getActivity());
                liveCoursesFragment.getBinding().recyclerView.setLayoutManager(liveCoursesFragment2.mLayoutManager);
                liveCoursesFragment.getBinding().recyclerView.setAdapter(liveCoursesFragment2.mAdapter);
                ClassAdapter classAdapter2 = liveCoursesFragment2.mAdapter;
                if (classAdapter2 != null) {
                    classAdapter2.setOnItemClickListener((OnItemClickListener) liveCoursesFragment2);
                }
            }
            if (!UserInfoBll.Companion.getInstance().isGuest() && liveCoursesFragment.isViewModelInitialized()) {
                liveCoursesFragment.getMViewModel().getSwitchOptionsData("LIVE", liveCoursesFragment2.mHaveCourse);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-7  reason: not valid java name */
    public static final void m374startObserve$lambda7(LiveCoursesFragment liveCoursesFragment, StateData stateData) {
        int i;
        int i2;
        boolean z;
        String str;
        boolean z2;
        String str2;
        LiveCoursesFragment liveCoursesFragment2 = liveCoursesFragment;
        Intrinsics.checkNotNullParameter(liveCoursesFragment2, "this$0");
        liveCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
        int i3 = 1;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            liveCoursesFragment2.mSwitchOptions = (SwitchOptionsList) stateData.getData();
            XesLog.i(Tag.LiveCoursesFragment, new Object[]{Intrinsics.stringPlus("直播切换数据：", GsonUtil.getInstance().objToJson(liveCoursesFragment2.mSwitchOptions))});
            SwitchOptionsList switchOptionsList = liveCoursesFragment2.mSwitchOptions;
            List<SwitchOptionsEntity> list = null;
            List<SwitchOptionsEntity> accountList = switchOptionsList == null ? null : switchOptionsList.getAccountList();
            SwitchOptionsList switchOptionsList2 = liveCoursesFragment2.mSwitchOptions;
            if (switchOptionsList2 != null) {
                list = switchOptionsList2.getSchoolList();
            }
            if (accountList == null) {
                i = 0;
            } else {
                i = accountList.size();
            }
            liveCoursesFragment2.accountListSize = i;
            if (list == null) {
                i2 = 0;
            } else {
                i2 = list.size();
            }
            liveCoursesFragment2.schoolListSize = i2;
            Collection collection = accountList;
            String str3 = "有班级";
            if (!(collection == null || collection.isEmpty())) {
                XesLog.i(Tag.LiveCoursesFragment, new Object[]{Intrinsics.stringPlus("展示切换子账号---", Boolean.valueOf(liveCoursesFragment2.mHaveCourse))});
                if (accountList != null && accountList.size() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    str2 = liveCoursesFragment2.getString(R.string.switch_one_student_accounts, new Object[]{accountList.get(0).getNickName()});
                } else {
                    str2 = liveCoursesFragment2.getString(R.string.switch_multiple_student_accounts);
                }
                Intrinsics.checkNotNullExpressionValue(str2, "if (accountList?.size ==…ultiple_student_accounts)");
                String string = liveCoursesFragment2.getString(R.string.switch_student_account);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.switch_student_account)");
                liveCoursesFragment2.mSwitchType = SwitchType.Account;
                if (liveCoursesFragment2.mHaveCourse) {
                    liveCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
                    ClassAdapter classAdapter = liveCoursesFragment2.mAdapter;
                    if (classAdapter != null) {
                        Record record = new Record((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Course) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (SwitchType) null, 262143, (DefaultConstructorMarker) null);
                        record.setItemType(2);
                        record.setSwitchTip(str2);
                        record.setSwitchBtn(string);
                        record.setSwitchType(SwitchType.Account);
                        classAdapter.addData(record);
                    }
                    liveCoursesFragment.addFootView();
                } else {
                    liveCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(0);
                    liveCoursesFragment.getBinding().includeView.tvSwitchTip.setText(str2);
                    liveCoursesFragment.getBinding().includeView.tvSwitchBtn.setText(string);
                    ISwitchAccount iSwitchAccount = liveCoursesFragment2.switchListener;
                    if (iSwitchAccount != null) {
                        ISwitchAccount.DefaultImpls.showSwitchDialog$default(iSwitchAccount, liveCoursesFragment2.mSwitchOptions, SwitchType.Account, ShowTab.Live, liveCoursesFragment2.mHaveCourse, false, 16, (Object) null);
                    }
                }
                StudyTrack studyTrack = StudyTrack.INSTANCE;
                String aliasName = liveCoursesFragment2.mSwitchType.getAliasName();
                if (accountList != null) {
                    i3 = accountList.size();
                }
                if (!liveCoursesFragment2.mHaveCourse) {
                    str3 = "无班级";
                }
                studyTrack.hw_user_switcher_tips_show(aliasName, i3, str3, ShowTab.Live.getAliasName());
                return;
            }
            Collection collection2 = list;
            if (!(collection2 == null || collection2.isEmpty())) {
                XesLog.i(Tag.LiveCoursesFragment, new Object[]{Intrinsics.stringPlus("展示切换分校---", Boolean.valueOf(liveCoursesFragment2.mHaveCourse))});
                if (list != null && list.size() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = liveCoursesFragment2.getString(R.string.switch_one_school, new Object[]{list.get(0).getSchoolName()});
                } else {
                    str = liveCoursesFragment2.getString(R.string.switch_multiple_schools);
                }
                Intrinsics.checkNotNullExpressionValue(str, "if (schoolList?.size == ….switch_multiple_schools)");
                String string2 = liveCoursesFragment2.getString(R.string.switch_school);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.switch_school)");
                liveCoursesFragment2.mSwitchType = SwitchType.School;
                if (liveCoursesFragment2.mHaveCourse) {
                    liveCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
                    ClassAdapter classAdapter2 = liveCoursesFragment2.mAdapter;
                    if (classAdapter2 != null) {
                        Record record2 = new Record((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Course) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (SwitchType) null, 262143, (DefaultConstructorMarker) null);
                        record2.setItemType(2);
                        record2.setSwitchTip(str);
                        record2.setSwitchBtn(string2);
                        record2.setSwitchType(SwitchType.School);
                        classAdapter2.addData(record2);
                    }
                    liveCoursesFragment.addFootView();
                } else {
                    liveCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(0);
                    liveCoursesFragment.getBinding().includeView.tvSwitchTip.setText(str);
                    liveCoursesFragment.getBinding().includeView.tvSwitchBtn.setText(string2);
                    ISwitchAccount iSwitchAccount2 = liveCoursesFragment2.switchListener;
                    if (iSwitchAccount2 != null) {
                        ISwitchAccount.DefaultImpls.showSwitchDialog$default(iSwitchAccount2, liveCoursesFragment2.mSwitchOptions, SwitchType.School, ShowTab.Live, liveCoursesFragment2.mHaveCourse, false, 16, (Object) null);
                    }
                }
                StudyTrack studyTrack2 = StudyTrack.INSTANCE;
                String aliasName2 = liveCoursesFragment2.mSwitchType.getAliasName();
                if (accountList != null) {
                    i3 = accountList.size();
                }
                if (!liveCoursesFragment2.mHaveCourse) {
                    str3 = "无班级";
                }
                studyTrack2.hw_user_switcher_tips_show(aliasName2, i3, str3, ShowTab.Live.getAliasName());
                return;
            }
            boolean z3 = liveCoursesFragment2.mHaveCourse;
            if (!z3) {
                liveCoursesFragment.gotoSeletedCourse();
            } else if (z3) {
                liveCoursesFragment.addFootView();
            }
        } else if (!liveCoursesFragment2.mHaveCourse) {
            liveCoursesFragment.gotoSeletedCourse();
        } else {
            liveCoursesFragment.addFootView();
        }
    }

    private final void showError(String str) {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        if (str == null) {
            str = getString(R.string.study_center_data_error);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.study_center_data_error)");
        }
        LoadStatusView.showErrorView$default(loadStatusView, 0, str, (String) null, (String) null, new LiveCoursesFragment$showError$1(this), 13, (Object) null);
    }

    private final void showEmptyData() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        LoadStatusView.showEmptyView$default(loadStatusView, R.drawable.no_current_courses, "", false, (String) null, (Function0) null, 28, (Object) null);
    }

    private final void gotoSeletedCourse() {
        int i;
        String str;
        XesLog.i(Tag.LiveCoursesFragment, new Object[]{"展示去选课"});
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        int i2 = R.drawable.no_current_courses;
        if (PadUtils.isPad(getContext())) {
            i = R.string.there_is_no_course_under_your_account;
        } else {
            i = R.string.select_a_course_tip;
        }
        String string = getString(i);
        if (PadUtils.isPad(getContext())) {
            str = "";
        } else {
            str = getString(R.string.select_a_course);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.select_a_course)");
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (PadUtils.isPad(conte…_course_tip\n            )");
        loadStatusView.showEmptyView(i2, string, !PadUtils.isPad(getContext()), str, new LiveCoursesFragment$gotoSeletedCourse$1(this));
        StudyTrack.INSTANCE.hw_buy_class_show(ShowTab.Live.getAliasName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if (r14.intValue() == 1) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r14 = r14.getAccountList();
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(com.chad.library.adapter.base.BaseQuickAdapter<?, ?> r13, android.view.View r14, int r15) {
        /*
            r12 = this;
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.List r13 = r13.getData()
            java.util.List r13 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r13)
            java.lang.Object r13 = r13.get(r15)
            com.tal.app.thinkacademy.business.study.study.entity.Record r13 = (com.tal.app.thinkacademy.business.study.study.entity.Record) r13
            int r14 = r13.getItemType()
            r15 = 2
            r0 = 0
            r1 = 0
            r2 = 1
            if (r14 == 0) goto L_0x00ec
            if (r14 == r2) goto L_0x00dd
            if (r14 == r15) goto L_0x0028
            goto L_0x011c
        L_0x0028:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r14 = r12.mSwitchOptions
            if (r14 != 0) goto L_0x002e
        L_0x002c:
            r14 = r1
            goto L_0x003d
        L_0x002e:
            java.util.List r14 = r14.getAccountList()
            if (r14 != 0) goto L_0x0035
            goto L_0x002c
        L_0x0035:
            int r14 = r14.size()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
        L_0x003d:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r3 = r12.mSwitchOptions
            if (r3 != 0) goto L_0x0042
            goto L_0x0051
        L_0x0042:
            java.util.List r3 = r3.getSchoolList()
            if (r3 != 0) goto L_0x0049
            goto L_0x0051
        L_0x0049:
            int r1 = r3.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0051:
            com.tal.app.thinkacademy.business.study.study.StudyTrack r3 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.SwitchType r4 = r12.mSwitchType
            java.lang.String r4 = r4.getAliasName()
            com.tal.app.thinkacademy.business.study.study.SwitchType r5 = r12.mSwitchType
            int[] r6 = com.tal.app.thinkacademy.business.study.study.LiveCoursesFragment.WhenMappings.$EnumSwitchMapping$1
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r2) goto L_0x0075
            if (r5 != r15) goto L_0x006f
            if (r1 != 0) goto L_0x006a
            goto L_0x0077
        L_0x006a:
            int r5 = r1.intValue()
            goto L_0x007d
        L_0x006f:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        L_0x0075:
            if (r14 != 0) goto L_0x0079
        L_0x0077:
            r5 = r2
            goto L_0x007d
        L_0x0079:
            int r5 = r14.intValue()
        L_0x007d:
            com.tal.app.thinkacademy.business.study.study.ShowTab r6 = com.tal.app.thinkacademy.business.study.study.ShowTab.Live
            java.lang.String r6 = r6.getAliasName()
            java.lang.String r7 = "有班级"
            r3.hw_user_switcher_tips_click(r4, r5, r7, r6)
            com.tal.app.thinkacademy.business.study.study.SwitchType r3 = r13.getSwitchType()
            if (r3 != 0) goto L_0x0090
            r3 = -1
            goto L_0x0098
        L_0x0090:
            int[] r4 = com.tal.app.thinkacademy.business.study.study.LiveCoursesFragment.WhenMappings.$EnumSwitchMapping$1
            int r3 = r3.ordinal()
            r3 = r4[r3]
        L_0x0098:
            if (r3 == r2) goto L_0x00ad
            if (r3 == r15) goto L_0x009e
        L_0x009c:
            r2 = r0
            goto L_0x00b6
        L_0x009e:
            if (r1 != 0) goto L_0x00a1
            goto L_0x00a8
        L_0x00a1:
            int r14 = r1.intValue()
            if (r14 != r2) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r2 = r0
        L_0x00a9:
            r11 = r2
            r2 = r0
            r0 = r11
            goto L_0x00b6
        L_0x00ad:
            if (r14 != 0) goto L_0x00b0
            goto L_0x009c
        L_0x00b0:
            int r14 = r14.intValue()
            if (r14 != r2) goto L_0x009c
        L_0x00b6:
            com.tal.app.thinkacademy.business.study.study.ISwitchAccount r3 = r12.switchListener
            if (r3 != 0) goto L_0x00bb
            goto L_0x011c
        L_0x00bb:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r4 = r12.mSwitchOptions
            com.tal.app.thinkacademy.business.study.study.SwitchType r14 = r13.getSwitchType()
            if (r14 != 0) goto L_0x00c5
            com.tal.app.thinkacademy.business.study.study.SwitchType r14 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
        L_0x00c5:
            r5 = r14
            com.tal.app.thinkacademy.business.study.study.ShowTab r6 = com.tal.app.thinkacademy.business.study.study.ShowTab.Live
            boolean r7 = r12.mHaveCourse
            com.tal.app.thinkacademy.business.study.study.SwitchType r13 = r13.getSwitchType()
            if (r13 != 0) goto L_0x00d2
            com.tal.app.thinkacademy.business.study.study.SwitchType r13 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
        L_0x00d2:
            com.tal.app.thinkacademy.business.study.study.SwitchType r14 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
            if (r13 != r14) goto L_0x00d8
            r8 = r2
            goto L_0x00d9
        L_0x00d8:
            r8 = r0
        L_0x00d9:
            r3.showSwitchDialog(r4, r5, r6, r7, r8)
            goto L_0x011c
        L_0x00dd:
            com.tal.app.thinkacademy.lib.route.XesRoute r13 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            java.lang.String r14 = "/login/device_test_activity"
            r13.navigation(r14)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r13 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            r13.hw_device_test_click()
            goto L_0x011c
        L_0x00ec:
            com.tal.app.thinkacademy.business.study.study.Tag r14 = com.tal.app.thinkacademy.business.study.study.Tag.LiveCoursesFragment
            com.tal.app.thinkacademy.lib.logger.XesLogTag r14 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r14
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "点击直播卡片"
            r3[r0] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r14, r3)
            com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity$Companion r5 = com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity.Companion
            androidx.fragment.app.FragmentActivity r14 = r12.getmActivity()
            r6 = r14
            android.content.Context r6 = (android.content.Context) r6
            java.lang.String r7 = r13.getClassId()
            r8 = 0
            r9 = 4
            r10 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity.Companion.startActivity$default(r5, r6, r7, r8, r9, r10)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r14 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            int r13 = r13.getCardStyle()
            if (r13 != r2) goto L_0x0117
            java.lang.String r13 = "有"
            goto L_0x0119
        L_0x0117:
            java.lang.String r13 = "无"
        L_0x0119:
            com.tal.app.thinkacademy.business.study.study.StudyTrack.hw_class_card_click$default(r14, r13, r1, r15, r1)
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.LiveCoursesFragment.onItemClick(com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    public void onDestroy() {
        LiveCoursesFragment.super.onDestroy();
        this.switchListener = null;
    }

    public final void setISwitchAccount(ISwitchAccount iSwitchAccount) {
        this.switchListener = iSwitchAccount;
    }

    private final void addFootView() {
        ClassAdapter classAdapter = this.mAdapter;
        if (classAdapter != null) {
            Record record = r2;
            Record record2 = new Record((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Course) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (SwitchType) null, 262143, (DefaultConstructorMarker) null);
            Record record3 = record;
            record3.setItemType(4);
            classAdapter.addData(record3);
        }
    }

    /* access modifiers changed from: private */
    public final void checkAndReport() {
        ClassAdapter classAdapter;
        List data;
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        if (linearLayoutManager != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0 && (classAdapter = this.mAdapter) != null && (data = classAdapter.getData()) != null) {
                if (!(data.size() > 0)) {
                    data = null;
                }
                if (data != null) {
                    int size = data.size();
                    if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                        while (true) {
                            int i = findFirstVisibleItemPosition + 1;
                            ClassAdapter classAdapter2 = this.mAdapter;
                            int i2 = classAdapter2 != null && classAdapter2.hasHeaderLayout() ? findFirstVisibleItemPosition - 1 : findFirstVisibleItemPosition;
                            if (i2 >= 0 && i2 < size) {
                                Record record = (Record) data.get(i2);
                                int itemType = record.getItemType();
                                if (itemType == 1) {
                                    StudyTrack.INSTANCE.hw_device_test_show();
                                } else if (itemType == 2) {
                                    StudyTrack.INSTANCE.hw_user_switcher_tips_show(this.mSwitchType.getAliasName(), record.getSwitchType() == SwitchType.Account ? this.accountListSize : this.schoolListSize, this.mHaveCourse ? "有班级" : "无班级", ShowTab.Live.getAliasName());
                                }
                            }
                            if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                                findFirstVisibleItemPosition = i;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
