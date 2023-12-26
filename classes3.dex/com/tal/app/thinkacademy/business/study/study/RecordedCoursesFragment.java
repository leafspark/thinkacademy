package com.tal.app.thinkacademy.business.study.study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tal.app.thinkacademy.business.study.study.ISwitchAccount;
import com.tal.app.thinkacademy.business.study.study.adapter.RecordedListAdapter;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedClassList;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCourse;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.vm.StudyCenterVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.LayoutRecordedCoursesFragmentBinding;
import com.tal.app.thinkacademy.common.base.BaseVmFragment;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
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

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\tH\u0016J(\u0010\u001e\u001a\u00020\u00132\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00132\b\b\u0002\u0010)\u001a\u00020\u000bJ\u0006\u0010*\u001a\u00020\u0013J\u0010\u0010+\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020\u0013H\u0002J\u0012\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00101\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/RecordedCoursesFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseVmFragment;", "Lcom/tal/app/thinkacademy/business/study/study/vm/StudyCenterVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/LayoutRecordedCoursesFragmentBinding;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/adapter/RecordedListAdapter;", "mHaveCourse", "", "mPageNum", "", "mSwitchOptions", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "mSwitchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "switchListener", "Lcom/tal/app/thinkacademy/business/study/study/ISwitchAccount;", "addFootView", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "gotoSeletedCourse", "onDestroy", "onHiddenChanged", "hidden", "onItemClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "onResume", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "requestData", "pageNum", "requestDataLoading", "setISwitchAccount", "setViewValues", "showEmptyData", "showError", "msg", "", "startObserve", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCoursesFragment.kt */
public final class RecordedCoursesFragment extends BaseVmFragment<StudyCenterVM, LayoutRecordedCoursesFragmentBinding> implements OnItemClickListener {
    private RecordedListAdapter mAdapter;
    /* access modifiers changed from: private */
    public boolean mHaveCourse;
    /* access modifiers changed from: private */
    public int mPageNum = 1;
    /* access modifiers changed from: private */
    public SwitchOptionsList mSwitchOptions;
    /* access modifiers changed from: private */
    public SwitchType mSwitchType = SwitchType.Account;
    /* access modifiers changed from: private */
    public ISwitchAccount switchListener;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedCoursesFragment.kt */
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
    public LayoutRecordedCoursesFragmentBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutRecordedCoursesFragmentBinding inflate = LayoutRecordedCoursesFragmentBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecordedCoursesFragment.super.onViewCreated(view, bundle);
        setViewValues();
    }

    public void onResume() {
        RecordedCoursesFragment.super.onResume();
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            requestDataLoading();
            if (isVisible()) {
                StudyTrack.INSTANCE.hw_class_pv("录播课");
            }
        }
    }

    public void onHiddenChanged(boolean z) {
        RecordedCoursesFragment.super.onHiddenChanged(z);
        if (!z) {
            StudyTrack.INSTANCE.hw_class_pv("录播课");
        }
    }

    private final void setViewValues() {
        getBinding().srLayout.setOnRefreshLoadMoreListener(new RecordedCoursesFragment$setViewValues$1(this));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        View view = getBinding().tvClickSwitchAccountOrSchool;
        Intrinsics.checkNotNullExpressionValue(view, "binding.tvClickSwitchAccountOrSchool");
        rxUnDoubleUtil.setOnUnDoubleClickListener(view, 500, new RecordedCoursesFragment$setViewValues$2(this));
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

    public static /* synthetic */ void requestData$default(RecordedCoursesFragment recordedCoursesFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        recordedCoursesFragment.requestData(i);
    }

    public final void requestData(int i) {
        if (!UserInfoBll.Companion.getInstance().isGuest() && isViewModelInitialized()) {
            this.mPageNum = i;
            getMViewModel().getRecordedClassList();
        }
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getRecordedClassList().observe(lifecycleOwner, new RecordedCoursesFragment$$ExternalSyntheticLambda1(this));
        getMViewModel().getSwitchOptions().observe(lifecycleOwner, new RecordedCoursesFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-2  reason: not valid java name */
    public static final void m379startObserve$lambda2(RecordedCoursesFragment recordedCoursesFragment, StateData stateData) {
        List<RecordedCourse> list;
        RecordedClassList recordedClassList;
        Intrinsics.checkNotNullParameter(recordedCoursesFragment, "this$0");
        recordedCoursesFragment.getBinding().srLayout.finishRefresh();
        recordedCoursesFragment.getBinding().srLayout.finishLoadMore();
        recordedCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            recordedCoursesFragment.showError(stateData.getMsg());
        } else if (stateData.getData() == null) {
            XesLog.i(Tag.RecordedCoursesFragment, new Object[]{"classList is null"});
            recordedCoursesFragment.showError(stateData.getMsg());
        } else {
            XesLog.i(Tag.RecordedCoursesFragment, new Object[]{Intrinsics.stringPlus("录播列表数据：", GsonUtil.getInstance().objToJson(stateData.getData()))});
            recordedCoursesFragment.getBinding().srLayout.setEnableLoadMore(false);
            recordedCoursesFragment.getBinding().srLayout.setNoMoreData(false);
            Unit unit = null;
            if (stateData == null || (recordedClassList = (RecordedClassList) stateData.getData()) == null) {
                list = null;
            } else {
                list = recordedClassList.getCourseList();
            }
            Collection collection = list;
            recordedCoursesFragment.mHaveCourse = !(collection == null || collection.isEmpty());
            XesLog.i(Tag.RecordedCoursesFragment, new Object[]{Intrinsics.stringPlus("是否有录播课--", Boolean.valueOf(recordedCoursesFragment.mHaveCourse))});
            if (recordedCoursesFragment.mHaveCourse) {
                recordedCoursesFragment.getBinding().loadStatusView.restoreView();
            } else {
                recordedCoursesFragment.showEmptyData();
            }
            RecordedListAdapter recordedListAdapter = recordedCoursesFragment.mAdapter;
            if (recordedListAdapter != null) {
                recordedListAdapter.setList(collection);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                recordedCoursesFragment.mAdapter = new RecordedListAdapter(list);
                recordedCoursesFragment.getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(recordedCoursesFragment.getActivity()));
                recordedCoursesFragment.getBinding().recyclerView.setAdapter(recordedCoursesFragment.mAdapter);
                RecordedListAdapter recordedListAdapter2 = recordedCoursesFragment.mAdapter;
                if (recordedListAdapter2 != null) {
                    recordedListAdapter2.setOnItemClickListener((OnItemClickListener) recordedCoursesFragment);
                }
            }
            if (!UserInfoBll.Companion.getInstance().isGuest() && recordedCoursesFragment.isViewModelInitialized()) {
                recordedCoursesFragment.getMViewModel().getSwitchOptionsData("RECORD", recordedCoursesFragment.mHaveCourse);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-5  reason: not valid java name */
    public static final void m380startObserve$lambda5(RecordedCoursesFragment recordedCoursesFragment, StateData stateData) {
        boolean z;
        String str;
        boolean z2;
        String str2;
        RecordedCoursesFragment recordedCoursesFragment2 = recordedCoursesFragment;
        Intrinsics.checkNotNullParameter(recordedCoursesFragment2, "this$0");
        recordedCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
        int i = 1;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            recordedCoursesFragment2.mSwitchOptions = (SwitchOptionsList) stateData.getData();
            XesLog.i(Tag.RecordedCoursesFragment, new Object[]{Intrinsics.stringPlus("录播切换数据：", GsonUtil.getInstance().objToJson(recordedCoursesFragment2.mSwitchOptions))});
            SwitchOptionsList switchOptionsList = recordedCoursesFragment2.mSwitchOptions;
            List<SwitchOptionsEntity> list = null;
            List<SwitchOptionsEntity> accountList = switchOptionsList == null ? null : switchOptionsList.getAccountList();
            SwitchOptionsList switchOptionsList2 = recordedCoursesFragment2.mSwitchOptions;
            if (switchOptionsList2 != null) {
                list = switchOptionsList2.getSchoolList();
            }
            Collection collection = accountList;
            String str3 = "有班级";
            if (!(collection == null || collection.isEmpty())) {
                XesLog.i(Tag.RecordedCoursesFragment, new Object[]{Intrinsics.stringPlus("展示切换子账号---", Boolean.valueOf(recordedCoursesFragment2.mHaveCourse))});
                if (accountList != null && accountList.size() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    str2 = recordedCoursesFragment2.getString(R.string.switch_one_student_accounts, new Object[]{accountList.get(0).getNickName()});
                } else {
                    str2 = recordedCoursesFragment2.getString(R.string.switch_multiple_student_accounts);
                }
                Intrinsics.checkNotNullExpressionValue(str2, "if (accountList?.size ==…ultiple_student_accounts)");
                String string = recordedCoursesFragment2.getString(R.string.switch_student_account);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.switch_student_account)");
                recordedCoursesFragment2.mSwitchType = SwitchType.Account;
                if (recordedCoursesFragment2.mHaveCourse) {
                    recordedCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
                    RecordedListAdapter recordedListAdapter = recordedCoursesFragment2.mAdapter;
                    if (recordedListAdapter != null) {
                        RecordedCourse recordedCourse = new RecordedCourse((String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Long) null, (String) null, (List) null, 0, (String) null, (String) null, (SwitchType) null, 16383, (DefaultConstructorMarker) null);
                        recordedCourse.setItemType(2);
                        recordedCourse.setSwitchTip(str2);
                        recordedCourse.setSwitchBtn(string);
                        recordedCourse.setSwitchType(SwitchType.Account);
                        recordedListAdapter.addData(recordedCourse);
                    }
                    recordedCoursesFragment.addFootView();
                } else {
                    recordedCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(0);
                    recordedCoursesFragment.getBinding().includeView.tvSwitchTip.setText(str2);
                    recordedCoursesFragment.getBinding().includeView.tvSwitchBtn.setText(string);
                    ISwitchAccount iSwitchAccount = recordedCoursesFragment2.switchListener;
                    if (iSwitchAccount != null) {
                        ISwitchAccount.DefaultImpls.showSwitchDialog$default(iSwitchAccount, recordedCoursesFragment2.mSwitchOptions, SwitchType.Account, ShowTab.Recorded, recordedCoursesFragment2.mHaveCourse, false, 16, (Object) null);
                    }
                }
                StudyTrack studyTrack = StudyTrack.INSTANCE;
                String aliasName = recordedCoursesFragment2.mSwitchType.getAliasName();
                if (accountList != null) {
                    i = accountList.size();
                }
                if (!recordedCoursesFragment2.mHaveCourse) {
                    str3 = "无班级";
                }
                studyTrack.hw_user_switcher_tips_show(aliasName, i, str3, ShowTab.Recorded.getAliasName());
                return;
            }
            Collection collection2 = list;
            if (!(collection2 == null || collection2.isEmpty())) {
                XesLog.i(Tag.RecordedCoursesFragment, new Object[]{Intrinsics.stringPlus("展示切换分校---", Boolean.valueOf(recordedCoursesFragment2.mHaveCourse))});
                if (list != null && list.size() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = recordedCoursesFragment2.getString(R.string.switch_one_school, new Object[]{list.get(0).getSchoolName()});
                } else {
                    str = recordedCoursesFragment2.getString(R.string.switch_multiple_schools);
                }
                Intrinsics.checkNotNullExpressionValue(str, "if (schoolList?.size == ….switch_multiple_schools)");
                String string2 = recordedCoursesFragment2.getString(R.string.switch_school);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.switch_school)");
                recordedCoursesFragment2.mSwitchType = SwitchType.School;
                if (recordedCoursesFragment2.mHaveCourse) {
                    recordedCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(8);
                    RecordedListAdapter recordedListAdapter2 = recordedCoursesFragment2.mAdapter;
                    if (recordedListAdapter2 != null) {
                        RecordedCourse recordedCourse2 = new RecordedCourse((String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Long) null, (String) null, (List) null, 0, (String) null, (String) null, (SwitchType) null, 16383, (DefaultConstructorMarker) null);
                        recordedCourse2.setItemType(2);
                        recordedCourse2.setSwitchTip(str);
                        recordedCourse2.setSwitchBtn(string2);
                        recordedCourse2.setSwitchType(SwitchType.School);
                        recordedListAdapter2.addData(recordedCourse2);
                    }
                    recordedCoursesFragment.addFootView();
                } else {
                    recordedCoursesFragment.getBinding().tvClickSwitchAccountOrSchool.setVisibility(0);
                    recordedCoursesFragment.getBinding().includeView.tvSwitchTip.setText(str);
                    recordedCoursesFragment.getBinding().includeView.tvSwitchBtn.setText(string2);
                    ISwitchAccount iSwitchAccount2 = recordedCoursesFragment2.switchListener;
                    if (iSwitchAccount2 != null) {
                        ISwitchAccount.DefaultImpls.showSwitchDialog$default(iSwitchAccount2, recordedCoursesFragment2.mSwitchOptions, SwitchType.School, ShowTab.Recorded, recordedCoursesFragment2.mHaveCourse, false, 16, (Object) null);
                    }
                }
                StudyTrack studyTrack2 = StudyTrack.INSTANCE;
                String aliasName2 = recordedCoursesFragment2.mSwitchType.getAliasName();
                if (accountList != null) {
                    i = accountList.size();
                }
                if (!recordedCoursesFragment2.mHaveCourse) {
                    str3 = "无班级";
                }
                studyTrack2.hw_user_switcher_tips_show(aliasName2, i, str3, ShowTab.Recorded.getAliasName());
                return;
            }
            boolean z3 = recordedCoursesFragment2.mHaveCourse;
            if (!z3) {
                recordedCoursesFragment.gotoSeletedCourse();
            } else if (z3) {
                recordedCoursesFragment.addFootView();
            }
        } else if (!recordedCoursesFragment2.mHaveCourse) {
            recordedCoursesFragment.gotoSeletedCourse();
        } else {
            recordedCoursesFragment.addFootView();
        }
    }

    private final void showError(String str) {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        if (str == null) {
            str = getString(R.string.study_center_data_error);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.study_center_data_error)");
        }
        LoadStatusView.showErrorView$default(loadStatusView, 0, str, (String) null, (String) null, new RecordedCoursesFragment$showError$1(this), 13, (Object) null);
    }

    private final void showEmptyData() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        LoadStatusView.showEmptyView$default(loadStatusView, R.drawable.no_current_courses, "", false, (String) null, (Function0) null, 28, (Object) null);
    }

    private final void gotoSeletedCourse() {
        int i;
        String str;
        XesLog.i(Tag.RecordedCoursesFragment, new Object[]{"展示去选课"});
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
        loadStatusView.showEmptyView(i2, string, !PadUtils.isPad(getContext()), str, new RecordedCoursesFragment$gotoSeletedCourse$1(this));
        StudyTrack.INSTANCE.hw_buy_class_show(ShowTab.Recorded.getAliasName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b2, code lost:
        if (r11.intValue() == 1) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002c, code lost:
        r11 = r11.getAccountList();
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(com.chad.library.adapter.base.BaseQuickAdapter<?, ?> r10, android.view.View r11, int r12) {
        /*
            r9 = this;
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.List r10 = r10.getData()
            java.util.List r10 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r10)
            java.lang.Object r10 = r10.get(r12)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCourse r10 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedCourse) r10
            int r11 = r10.getItemType()
            r12 = 0
            r0 = 1
            if (r11 == 0) goto L_0x00db
            r1 = 2
            if (r11 == r1) goto L_0x0025
            goto L_0x011a
        L_0x0025:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r11 = r9.mSwitchOptions
            r2 = 0
            if (r11 != 0) goto L_0x002c
        L_0x002a:
            r11 = r2
            goto L_0x003b
        L_0x002c:
            java.util.List r11 = r11.getAccountList()
            if (r11 != 0) goto L_0x0033
            goto L_0x002a
        L_0x0033:
            int r11 = r11.size()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        L_0x003b:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r3 = r9.mSwitchOptions
            if (r3 != 0) goto L_0x0040
            goto L_0x004f
        L_0x0040:
            java.util.List r3 = r3.getSchoolList()
            if (r3 != 0) goto L_0x0047
            goto L_0x004f
        L_0x0047:
            int r2 = r3.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x004f:
            com.tal.app.thinkacademy.business.study.study.StudyTrack r3 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.SwitchType r4 = r9.mSwitchType
            java.lang.String r4 = r4.getAliasName()
            com.tal.app.thinkacademy.business.study.study.SwitchType r5 = r9.mSwitchType
            int[] r6 = com.tal.app.thinkacademy.business.study.study.RecordedCoursesFragment.WhenMappings.$EnumSwitchMapping$1
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r0) goto L_0x0073
            if (r5 != r1) goto L_0x006d
            if (r2 != 0) goto L_0x0068
            goto L_0x0075
        L_0x0068:
            int r5 = r2.intValue()
            goto L_0x007b
        L_0x006d:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x0073:
            if (r11 != 0) goto L_0x0077
        L_0x0075:
            r5 = r0
            goto L_0x007b
        L_0x0077:
            int r5 = r11.intValue()
        L_0x007b:
            com.tal.app.thinkacademy.business.study.study.ShowTab r6 = com.tal.app.thinkacademy.business.study.study.ShowTab.Recorded
            java.lang.String r6 = r6.getAliasName()
            java.lang.String r7 = "有班级"
            r3.hw_user_switcher_tips_click(r4, r5, r7, r6)
            com.tal.app.thinkacademy.business.study.study.SwitchType r3 = r10.getSwitchType()
            if (r3 != 0) goto L_0x008e
            r3 = -1
            goto L_0x0096
        L_0x008e:
            int[] r4 = com.tal.app.thinkacademy.business.study.study.RecordedCoursesFragment.WhenMappings.$EnumSwitchMapping$1
            int r3 = r3.ordinal()
            r3 = r4[r3]
        L_0x0096:
            if (r3 == r0) goto L_0x00ab
            if (r3 == r1) goto L_0x009c
        L_0x009a:
            r0 = r12
            goto L_0x00b4
        L_0x009c:
            if (r2 != 0) goto L_0x009f
            goto L_0x00a6
        L_0x009f:
            int r11 = r2.intValue()
            if (r11 != r0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            r0 = r12
        L_0x00a7:
            r8 = r0
            r0 = r12
            r12 = r8
            goto L_0x00b4
        L_0x00ab:
            if (r11 != 0) goto L_0x00ae
            goto L_0x009a
        L_0x00ae:
            int r11 = r11.intValue()
            if (r11 != r0) goto L_0x009a
        L_0x00b4:
            com.tal.app.thinkacademy.business.study.study.ISwitchAccount r1 = r9.switchListener
            if (r1 != 0) goto L_0x00b9
            goto L_0x011a
        L_0x00b9:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r2 = r9.mSwitchOptions
            com.tal.app.thinkacademy.business.study.study.SwitchType r11 = r10.getSwitchType()
            if (r11 != 0) goto L_0x00c3
            com.tal.app.thinkacademy.business.study.study.SwitchType r11 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
        L_0x00c3:
            r3 = r11
            com.tal.app.thinkacademy.business.study.study.ShowTab r4 = com.tal.app.thinkacademy.business.study.study.ShowTab.Recorded
            boolean r5 = r9.mHaveCourse
            com.tal.app.thinkacademy.business.study.study.SwitchType r10 = r10.getSwitchType()
            if (r10 != 0) goto L_0x00d0
            com.tal.app.thinkacademy.business.study.study.SwitchType r10 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
        L_0x00d0:
            com.tal.app.thinkacademy.business.study.study.SwitchType r11 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
            if (r10 != r11) goto L_0x00d6
            r6 = r0
            goto L_0x00d7
        L_0x00d6:
            r6 = r12
        L_0x00d7:
            r1.showSwitchDialog(r2, r3, r4, r5, r6)
            goto L_0x011a
        L_0x00db:
            com.tal.app.thinkacademy.business.study.study.Tag r11 = com.tal.app.thinkacademy.business.study.study.Tag.RecordedCoursesFragment
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "点击录播卡片"
            r1[r12] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r1)
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity$Companion r11 = com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity.Companion
            androidx.fragment.app.FragmentActivity r12 = r9.getmActivity()
            android.content.Context r12 = (android.content.Context) r12
            java.lang.Long r1 = r10.getStudentCourseId()
            r11.startActivity(r12, r1)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r11 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            java.lang.Boolean r12 = r10.getExpired()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r1)
            r12 = r12 ^ r0
            java.lang.String r0 = r10.getSkuId()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x010f
            r0 = r1
        L_0x010f:
            java.lang.String r10 = r10.getName()
            if (r10 != 0) goto L_0x0116
            goto L_0x0117
        L_0x0116:
            r1 = r10
        L_0x0117:
            r11.hw_my_courses_recorded_card_click(r12, r0, r1)
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.RecordedCoursesFragment.onItemClick(com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    public void onDestroy() {
        RecordedCoursesFragment.super.onDestroy();
        this.switchListener = null;
    }

    public final void setISwitchAccount(ISwitchAccount iSwitchAccount) {
        this.switchListener = iSwitchAccount;
    }

    private final void addFootView() {
        RecordedListAdapter recordedListAdapter = this.mAdapter;
        if (recordedListAdapter != null) {
            RecordedCourse recordedCourse = r2;
            RecordedCourse recordedCourse2 = new RecordedCourse((String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Long) null, (String) null, (List) null, 0, (String) null, (String) null, (SwitchType) null, 16383, (DefaultConstructorMarker) null);
            RecordedCourse recordedCourse3 = recordedCourse;
            recordedCourse3.setItemType(4);
            recordedListAdapter.addData(recordedCourse3);
        }
    }
}
