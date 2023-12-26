package com.tal.app.thinkacademy.business.study.study.speaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule;
import com.tal.app.thinkacademy.business.study.study.entity.Teacher;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.RecordedCalendarAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.TeacherListAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PlanListVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogNotifacationTipBinding;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.IntentUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.CustomLoadMoreView;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0014J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020\u00182\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedCalendarActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PlanListVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityRecordedCalendarListBinding;", "()V", "mListEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "mNotificationDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/DialogNotifacationTipBinding;", "mRecordedAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/RecordedCalendarAdapter;", "mTeacherLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mTeacherListAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/TeacherListAdapter;", "studentCourseId", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "exposureTraceTeacher", "", "initAdapter", "initData", "initTeacherListAdapter", "jumpToWeb", "url", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "requestNewListData", "showNotificationDialog", "startObserve", "updateTeacherList", "list", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarActivity.kt */
public final class RecordedCalendarActivity extends BaseVmActivity<PlanListVM, ActivityRecordedCalendarListBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public RecordedCalendarListEntity mListEntity;
    private BaseBindDialog<DialogNotifacationTipBinding> mNotificationDialog;
    private RecordedCalendarAdapter mRecordedAdapter;
    private LinearLayoutManager mTeacherLayoutManager;
    private TeacherListAdapter mTeacherListAdapter;
    private long studentCourseId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedCalendarActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initAdapter$lambda-7  reason: not valid java name */
    public static final void m483initAdapter$lambda7() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedCalendarActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "studentCourseId", "", "(Landroid/content/Context;Ljava/lang/Long;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedCalendarActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, Long l) {
            if (context != null) {
                Intent intent = new Intent(context, RecordedCalendarActivity.class);
                intent.putExtra(ClassParamsKt.STUDENT_COURSE_ID, l);
                context.startActivity(intent);
            }
        }
    }

    public RecordedCalendarActivity() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        linearLayoutManager.setOrientation(0);
        this.mTeacherLayoutManager = linearLayoutManager;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("syc_homework").observe(lifecycleOwner, new RecordedCalendarActivity$special$$inlined$observe$1(this));
        XesDataBus.with("sync_homework_success").observe(lifecycleOwner, new RecordedCalendarActivity$special$$inlined$observe$2(this));
        XesDataBus.with("request_homework_out_time").observe(lifecycleOwner, new RecordedCalendarActivity$special$$inlined$observe$3());
    }

    /* access modifiers changed from: protected */
    public ActivityRecordedCalendarListBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityRecordedCalendarListBinding inflate = ActivityRecordedCalendarListBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        RecordedCalendarActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, getColor(R.color.color_f4f6fa), false);
        getBinding().recordedCalendarTitle.setLineVisible(false);
        getBinding().recordedCalendarTitle.setTitle(getString(R.string.study_plan_list_title));
        getBinding().recordedCalendarTitle.setOnTitleBarListener(new RecordedCalendarActivity$onCreate$1(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.studentCourseId = intent.getLongExtra(ClassParamsKt.STUDENT_COURSE_ID, 0);
            initData();
        }
    }

    private final void initData() {
        initTeacherListAdapter();
        initAdapter();
        requestNewListData();
    }

    private final void updateTeacherList(Collection<Teacher> collection) {
        TeacherListAdapter teacherListAdapter = this.mTeacherListAdapter;
        if (teacherListAdapter != null) {
            teacherListAdapter.setList(collection);
        }
        getBinding().rvTeacherList.postDelayed(new RecordedCalendarActivity$$ExternalSyntheticLambda5(this), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateTeacherList$lambda-5  reason: not valid java name */
    public static final void m488updateTeacherList$lambda5(RecordedCalendarActivity recordedCalendarActivity) {
        Intrinsics.checkNotNullParameter(recordedCalendarActivity, "this$0");
        recordedCalendarActivity.exposureTraceTeacher();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        RecordedCalendarActivity.super.onResume();
        TeacherListAdapter teacherListAdapter = this.mTeacherListAdapter;
        if (teacherListAdapter != null) {
            teacherListAdapter.resetExposure();
        }
        exposureTraceTeacher();
    }

    /* access modifiers changed from: private */
    public final void exposureTraceTeacher() {
        TeacherListAdapter teacherListAdapter;
        int findFirstVisibleItemPosition = this.mTeacherLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.mTeacherLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && (teacherListAdapter = this.mTeacherListAdapter) != null) {
            teacherListAdapter.exposureTraceTeacher(findFirstVisibleItemPosition, findLastVisibleItemPosition);
        }
    }

    private final void initTeacherListAdapter() {
        this.mTeacherListAdapter = new TeacherListAdapter((List<Teacher>) null);
        getBinding().rvTeacherList.setLayoutManager(this.mTeacherLayoutManager);
        getBinding().rvTeacherList.setAdapter(this.mTeacherListAdapter);
        TeacherListAdapter teacherListAdapter = this.mTeacherListAdapter;
        if (teacherListAdapter != null) {
            teacherListAdapter.setOnItemClickListener(new RecordedCalendarActivity$$ExternalSyntheticLambda3(this));
        }
        getBinding().rvTeacherList.addOnScrollListener(new RecordedCalendarActivity$initTeacherListAdapter$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initTeacherListAdapter$lambda-6  reason: not valid java name */
    public static final void m484initTeacherListAdapter$lambda6(RecordedCalendarActivity recordedCalendarActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(recordedCalendarActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Teacher) {
            Teacher teacher = (Teacher) item;
            Collection contactInfoListV2 = teacher.getContactInfoListV2();
            if (!(contactInfoListV2 == null || contactInfoListV2.isEmpty())) {
                ContactInformationActivity.Companion.startActivity((Context) recordedCalendarActivity, teacher);
                StudyTrack studyTrack = StudyTrack.INSTANCE;
                String identityType = teacher.getIdentityType();
                if (identityType == null) {
                    identityType = DbParams.GZIP_DATA_EVENT;
                }
                studyTrack.hw_contact_teacher_icon_click(ParseUtils.tryParseInt(identityType, 1));
            }
        }
    }

    private final void initAdapter() {
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule baseLoadMoreModule = null;
        this.mRecordedAdapter = new RecordedCalendarAdapter((List<RecordedSchedule>) null, new RecordedCalendarActivity$initAdapter$1(this));
        getBinding().rvSpeakerList.setLayoutManager(new LinearLayoutManager((Context) this));
        getBinding().rvSpeakerList.setAdapter(this.mRecordedAdapter);
        RecordedCalendarAdapter recordedCalendarAdapter = this.mRecordedAdapter;
        if (recordedCalendarAdapter != null) {
            baseLoadMoreModule = recordedCalendarAdapter.getLoadMoreModule();
        }
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.setLoadMoreView(new CustomLoadMoreView());
        }
        RecordedCalendarAdapter recordedCalendarAdapter2 = this.mRecordedAdapter;
        if (recordedCalendarAdapter2 != null && (loadMoreModule = recordedCalendarAdapter2.getLoadMoreModule()) != null) {
            loadMoreModule.setOnLoadMoreListener(RecordedCalendarActivity$$ExternalSyntheticLambda4.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void requestNewListData() {
        LoadStatusView loadStatusView = getBinding().loadviewSpeakerList;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadviewSpeakerList");
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        getMViewModel().getRecordedCalendar(this.studentCourseId);
    }

    public void startObserve() {
        getMViewModel().getRecordedCalendar().observe((LifecycleOwner) this, new RecordedCalendarActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
        r5 = r5.getCourse();
     */
    /* renamed from: startObserve$lambda-10  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m487startObserve$lambda10(com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r16, com.tal.app.thinkacademy.common.entity.StateData r17) {
        /*
            r0 = r16
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            androidx.viewbinding.ViewBinding r1 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r1 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r1 = r1.loadviewSpeakerList
            r1.restoreView()
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r1 = r17.getStatus()
            int[] r2 = com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            java.lang.String r2 = "binding.loadviewSpeakerList"
            r3 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            if (r1 != r3) goto L_0x01bd
            java.lang.Object r1 = r17.getData()
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r1 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity) r1
            r0.mListEntity = r1
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r5 = r0.mListEntity
            r6 = 0
            if (r5 != 0) goto L_0x0038
        L_0x0036:
            r5 = r6
            goto L_0x0047
        L_0x0038:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r5 = r5.getCourse()
            if (r5 != 0) goto L_0x003f
            goto L_0x0036
        L_0x003f:
            java.lang.Boolean r5 = r5.getExpired()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
        L_0x0047:
            r5 = r5 ^ r3
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r7 = r0.mListEntity
            java.lang.String r8 = ""
            if (r7 != 0) goto L_0x0050
        L_0x004e:
            r7 = r8
            goto L_0x005e
        L_0x0050:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r7 = r7.getCourse()
            if (r7 != 0) goto L_0x0057
            goto L_0x004e
        L_0x0057:
            java.lang.String r7 = r7.getSkuId()
            if (r7 != 0) goto L_0x005e
            goto L_0x004e
        L_0x005e:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r9 = r0.mListEntity
            if (r9 != 0) goto L_0x0063
            goto L_0x0072
        L_0x0063:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r9 = r9.getCourse()
            if (r9 != 0) goto L_0x006a
            goto L_0x0072
        L_0x006a:
            java.lang.String r9 = r9.getName()
            if (r9 != 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r8 = r9
        L_0x0072:
            r1.hw_recorded_course_detail_pv(r5, r7, r8)
            java.lang.Object r1 = r17.getData()
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r1 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity) r1
            if (r1 != 0) goto L_0x007f
        L_0x007d:
            r1 = r6
            goto L_0x0090
        L_0x007f:
            java.util.List r1 = r1.getScheduleList()
            if (r1 != 0) goto L_0x0086
            goto L_0x007d
        L_0x0086:
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 != r3) goto L_0x007d
            r1 = r3
        L_0x0090:
            if (r1 == 0) goto L_0x019c
            java.lang.Object r1 = r17.getData()
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r1 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity) r1
            if (r1 != 0) goto L_0x009c
            goto L_0x01eb
        L_0x009c:
            androidx.viewbinding.ViewBinding r2 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r2 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r2
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r2 = r2.tvItemStudyCourseName
            java.lang.String[] r5 = new java.lang.String[r3]
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r7 = r1.getCourse()
            r8 = 0
            if (r7 != 0) goto L_0x00af
            r7 = r8
            goto L_0x00b3
        L_0x00af:
            java.lang.String r7 = r7.getSubjectTag()
        L_0x00b3:
            r5[r6] = r7
            java.util.ArrayList r5 = kotlin.collections.CollectionsKt.arrayListOf(r5)
            java.util.List r5 = (java.util.List) r5
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r7 = r1.getCourse()
            if (r7 != 0) goto L_0x00c3
            r7 = r8
            goto L_0x00c7
        L_0x00c3:
            java.lang.String r7 = r7.getName()
        L_0x00c7:
            r2.setTagStart(r5, r7)
            androidx.viewbinding.ViewBinding r2 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r2 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r2
            android.widget.ImageView r2 = r2.ivStudyItemTagExpired
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r5 = r1.getCourse()
            if (r5 != 0) goto L_0x00da
            r5 = r6
            goto L_0x00e2
        L_0x00da:
            java.lang.Boolean r5 = r5.getExpired()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
        L_0x00e2:
            if (r5 == 0) goto L_0x00e6
            r5 = r6
            goto L_0x00e8
        L_0x00e6:
            r5 = 8
        L_0x00e8:
            r2.setVisibility(r5)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r2 = r1.getCourse()
            if (r2 != 0) goto L_0x00f3
            r2 = r6
            goto L_0x00fb
        L_0x00f3:
            java.lang.Boolean r2 = r2.getPermanent()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
        L_0x00fb:
            if (r2 == 0) goto L_0x0111
            androidx.viewbinding.ViewBinding r2 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r2 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r2
            android.widget.TextView r2 = r2.tvItemStudyCourseDuration
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.string.courses_valid_permanently
            java.lang.String r4 = r0.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            goto L_0x0163
        L_0x0111:
            com.tal.app.thinkacademy.common.utils.TextHighLightUtil r9 = com.tal.app.thinkacademy.common.utils.TextHighLightUtil.INSTANCE
            androidx.viewbinding.ViewBinding r2 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r2 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r2
            android.widget.TextView r10 = r2.tvItemStudyCourseDuration
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.string.expiration_date
            java.lang.String r4 = r0.getString(r4)
            r2.append(r4)
            r4 = 32
            r2.append(r4)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r4 = r1.getCourse()
            if (r4 != 0) goto L_0x0136
            r4 = r8
            goto L_0x013a
        L_0x0136:
            java.lang.String r4 = r4.getExpirationTime()
        L_0x013a:
            r2.append(r4)
            java.lang.String r11 = r2.toString()
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r2 = r1.getCourse()
            if (r2 != 0) goto L_0x0149
            r2 = r8
            goto L_0x014d
        L_0x0149:
            java.lang.String r2 = r2.getExpirationTime()
        L_0x014d:
            java.lang.String r4 = " "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r2)
            int r2 = com.tal.app.thinkacademy.business.studycenter.R.color.color_172b4d
            int r13 = r0.getColor(r2)
            r2 = 1094713344(0x41400000, float:12.0)
            int r14 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r2)
            r15 = 1
            r9.setTextFirstHighLightColorSize(r10, r11, r12, r13, r14, r15)
        L_0x0163:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r1 = r1.getCourse()
            if (r1 != 0) goto L_0x016b
            r1 = r8
            goto L_0x016f
        L_0x016b:
            java.util.List r1 = r1.getTeachers()
        L_0x016f:
            java.util.Collection r1 = (java.util.Collection) r1
            r0.updateTeacherList(r1)
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.RecordedCalendarAdapter r1 = r0.mRecordedAdapter
            if (r1 != 0) goto L_0x0179
            goto L_0x018c
        L_0x0179:
            java.lang.Object r2 = r17.getData()
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r2 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity) r2
            if (r2 != 0) goto L_0x0183
            r2 = r8
            goto L_0x0187
        L_0x0183:
            java.util.List r2 = r2.getScheduleList()
        L_0x0187:
            java.util.Collection r2 = (java.util.Collection) r2
            r1.setList(r2)
        L_0x018c:
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.RecordedCalendarAdapter r0 = r0.mRecordedAdapter
            if (r0 != 0) goto L_0x0191
            goto L_0x01eb
        L_0x0191:
            com.chad.library.adapter.base.module.BaseLoadMoreModule r0 = r0.getLoadMoreModule()
            if (r0 != 0) goto L_0x0198
            goto L_0x01eb
        L_0x0198:
            com.chad.library.adapter.base.module.BaseLoadMoreModule.loadMoreEnd$default(r0, r6, r3, r8)
            goto L_0x01eb
        L_0x019c:
            androidx.viewbinding.ViewBinding r1 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r1 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r3 = r1.loadviewSpeakerList
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r4 = 0
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.string.study_plan_hint_empty
            java.lang.String r5 = r0.getString(r1)
            java.lang.String r0 = "getString(R.string.study_plan_hint_empty)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 29
            r10 = 0
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView.showEmptyView$default(r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x01eb
        L_0x01bd:
            androidx.viewbinding.ViewBinding r1 = r16.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding r1 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedCalendarListBinding) r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r3 = r1.loadviewSpeakerList
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r4 = 0
            java.lang.String r1 = r17.getMsg()
            if (r1 != 0) goto L_0x01da
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.string.study_center_data_error
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "getString(R.string.study_center_data_error)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x01da:
            r5 = r1
            r6 = 0
            r7 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity$startObserve$1$1$2 r1 = new com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity$startObserve$1$1$2
            r1.<init>(r0)
            r8 = r1
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r9 = 13
            r10 = 0
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView.showErrorView$default(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity.m487startObserve$lambda10(com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity, com.tal.app.thinkacademy.common.entity.StateData):void");
    }

    /* access modifiers changed from: private */
    public final void showNotificationDialog() {
        DialogNotifacationTipBinding dialogNotifacationTipBinding;
        TextView textView;
        DialogNotifacationTipBinding dialogNotifacationTipBinding2;
        TextView textView2;
        BaseDialog dimAmount;
        BaseDialog offset;
        BaseDialog layoutParams;
        int i = ShareDataManager.getInstance().getInt("version_code", 0, ShareDataManager.SHAREDATA_NOT_CLEAR);
        int appVersionCode = AppUtils.getAppVersionCode();
        boolean areNotificationsEnabled = NotificationManagerCompat.from((Context) this).areNotificationsEnabled();
        if (appVersionCode > i && !areNotificationsEnabled) {
            if (this.mNotificationDialog == null) {
                BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog = (BaseBindDialog) new RecordedCalendarActivity$showNotificationDialog$1(this);
                this.mNotificationDialog = baseBindDialog;
                BaseDialog gravity = baseBindDialog.gravity(80);
                if (!(gravity == null || (dimAmount = gravity.dimAmount(0.2f)) == null || (offset = dimAmount.offset(0, SizeUtils.dp2px(40.0f))) == null || (layoutParams = offset.layoutParams(new LinearLayout.LayoutParams(-1, -2))) == null)) {
                    layoutParams.canceledOnTouchOutside(true);
                }
                BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog2 = this.mNotificationDialog;
                if (!(baseBindDialog2 == null || (dialogNotifacationTipBinding2 = baseBindDialog2.binding) == null || (textView2 = dialogNotifacationTipBinding2.tvCancel) == null)) {
                    textView2.setOnClickListener(new RecordedCalendarActivity$$ExternalSyntheticLambda0(this));
                }
                BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog3 = this.mNotificationDialog;
                if (!(baseBindDialog3 == null || (dialogNotifacationTipBinding = baseBindDialog3.binding) == null || (textView = dialogNotifacationTipBinding.tvConfirm) == null)) {
                    textView.setOnClickListener(new RecordedCalendarActivity$$ExternalSyntheticLambda1(this));
                }
            }
            BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog4 = this.mNotificationDialog;
            if (baseBindDialog4 != null) {
                baseBindDialog4.show();
            }
            ShareDataManager.getInstance().put("version_code", appVersionCode, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotificationDialog$lambda-11  reason: not valid java name */
    public static final void m485showNotificationDialog$lambda11(RecordedCalendarActivity recordedCalendarActivity, View view) {
        Intrinsics.checkNotNullParameter(recordedCalendarActivity, "this$0");
        BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog = recordedCalendarActivity.mNotificationDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotificationDialog$lambda-12  reason: not valid java name */
    public static final void m486showNotificationDialog$lambda12(RecordedCalendarActivity recordedCalendarActivity, View view) {
        Intrinsics.checkNotNullParameter(recordedCalendarActivity, "this$0");
        IntentUtils.startAppSettings((Context) recordedCalendarActivity);
        BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog = recordedCalendarActivity.mNotificationDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void jumpToWeb(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("jump_key", str);
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(getApplicationContext())).build());
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
    }
}
