package com.tal.app.thinkacademy.business.study.study.speaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.study.study.dialog.ClassinDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.EnterTipsDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.OfflineClassFaceRoomDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.OfflineClassRoomDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.PhoneSecondaryConfirmationDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ThinkLiveDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ThinkhubDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.ZoomDialog;
import com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity;
import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import com.tal.app.thinkacademy.business.study.study.entity.ClassCalendarEntity;
import com.tal.app.thinkacademy.business.study.study.entity.ClassIn;
import com.tal.app.thinkacademy.business.study.study.entity.ClassInfo;
import com.tal.app.thinkacademy.business.study.study.entity.ExamDetails;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;
import com.tal.app.thinkacademy.business.study.study.entity.Offline;
import com.tal.app.thinkacademy.business.study.study.entity.Schedule;
import com.tal.app.thinkacademy.business.study.study.entity.TeachMethodEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Teacher;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.study.study.entity.ThinkHub;
import com.tal.app.thinkacademy.business.study.study.entity.ThinkLive;
import com.tal.app.thinkacademy.business.study.study.entity.Zoom;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity;
import com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.PreviewQuestionActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.TeacherListAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PlanListVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPlanListBinding;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogNotifacationTipBinding;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.util.TimeTransformationUtil;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.IntentUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.CustomLoadMoreView;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import com.tbruyelle.rxpermissions3.Permission;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\u0018\u0000 c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001cB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0006H\u0002J \u00104\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001052\u000e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010705H\u0002J\u0018\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\bH\u0014J\u001a\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010@\u001a\u000202H\u0002J\b\u0010A\u001a\u000202H\u0016J\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\u001a\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020G2\b\u0010?\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010H\u001a\u0002022\b\u00106\u001a\u0004\u0018\u00010IH\u0002J\u0012\u0010J\u001a\u0002022\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J\b\u0010M\u001a\u000202H\u0014J\b\u0010N\u001a\u000202H\u0014J\u0010\u0010O\u001a\u0002022\u0006\u00103\u001a\u00020\u0006H\u0003J\b\u0010P\u001a\u000202H\u0002J\u001c\u0010Q\u001a\u0002022\b\u0010R\u001a\u0004\u0018\u00010\u00062\b\u0010S\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010T\u001a\u0002022\f\u0010U\u001a\b\u0012\u0004\u0012\u0002020VH\u0002J\b\u0010W\u001a\u000202H\u0002J#\u0010X\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u000b2\f\u0010U\u001a\b\u0012\u0004\u0012\u0002020V¢\u0006\u0002\u0010ZJ\u0012\u0010[\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\b\u0010^\u001a\u000202H\u0016J\b\u0010_\u001a\u000202H\u0002J\u0018\u0010`\u001a\u0002022\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ClassCalendarActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PlanListVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityPlanListBinding;", "()V", "incomingClassId", "", "isAuditor", "", "isFinished", "jumpIndex", "", "mCalendarAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/CalendarAdapter;", "mClassInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;", "getMClassInfo", "()Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;", "setMClassInfo", "(Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;)V", "mClickLesson", "Lcom/tal/app/thinkacademy/business/study/study/entity/CalendarItem;", "mEndTime", "", "getMEndTime", "()J", "setMEndTime", "(J)V", "mEnterTipsDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/EnterTipsDialog;", "getMEnterTipsDialog", "()Lcom/tal/app/thinkacademy/business/study/study/dialog/EnterTipsDialog;", "setMEnterTipsDialog", "(Lcom/tal/app/thinkacademy/business/study/study/dialog/EnterTipsDialog;)V", "mHomeworkType", "mJumpParams", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "mNotificationDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/DialogNotifacationTipBinding;", "mOpenApp", "mPlanId", "Ljava/lang/Long;", "mTeacherLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mTeacherListAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/TeacherListAdapter;", "mType", "previousSource", "callPhone", "", "phoneNumber", "convertNewData", "", "data", "Lcom/tal/app/thinkacademy/business/study/study/entity/Schedule;", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "enterTrack", "planState", "Lcom/tal/app/thinkacademy/business/study/study/speaker/PlanState;", "item", "exposureTraceTeacher", "finish", "initData", "initSpeakerListAdapter", "initTeacherListAdapter", "itemClick", "clickType", "Lcom/tal/app/thinkacademy/business/study/study/speaker/ClickType;", "jumpHomework", "Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "requestCallPhonePermission", "requestNewListData", "requestTeachMethod", "currentClassId", "orderNum", "showEnterTipsDialog", "listen", "Lkotlin/Function0;", "showNotificationDialog", "startCheckStudentInClass", "planId", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "startContactInfoActivity", "teacherInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "startObserve", "trackPv", "updateTeacherList", "list", "", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarActivity.kt */
public final class ClassCalendarActivity extends BaseVmActivity<PlanListVM, ActivityPlanListBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public String incomingClassId = "";
    private boolean isAuditor;
    /* access modifiers changed from: private */
    public boolean isFinished;
    private int jumpIndex;
    private CalendarAdapter mCalendarAdapter;
    private ClassInfo mClassInfo;
    private CalendarItem mClickLesson;
    private long mEndTime;
    private EnterTipsDialog mEnterTipsDialog;
    /* access modifiers changed from: private */
    public int mHomeworkType;
    /* access modifiers changed from: private */
    public JumpParamsEntity mJumpParams;
    private BaseBindDialog<DialogNotifacationTipBinding> mNotificationDialog;
    private boolean mOpenApp;
    private Long mPlanId;
    private LinearLayoutManager mTeacherLayoutManager;
    private TeacherListAdapter mTeacherListAdapter;
    private int mType;
    private final String previousSource;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClassCalendarActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PlanState.values().length];
            iArr2[PlanState.Live.ordinal()] = 1;
            iArr2[PlanState.Playback.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ClickType.values().length];
            iArr3[ClickType.Homework.ordinal()] = 1;
            iArr3[ClickType.Common.ordinal()] = 2;
            iArr3[ClickType.ParentAudit.ordinal()] = 3;
            iArr3[ClickType.PreviewQuestion.ordinal()] = 4;
            iArr3[ClickType.Exam.ordinal()] = 5;
            iArr3[ClickType.ExamNew.ordinal()] = 6;
            iArr3[ClickType.LessonExam.ordinal()] = 7;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initSpeakerListAdapter$lambda-17  reason: not valid java name */
    public static final void m463initSpeakerListAdapter$lambda17() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ClassCalendarActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "classId", "", "openApp", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClassCalendarActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.startActivity(context, str, z);
        }

        public final void startActivity(Context context, String str, boolean z) {
            if (context != null) {
                Intent intent = new Intent(context, ClassCalendarActivity.class);
                intent.putExtra(ClassParamsKt.CLASS_ID, str);
                intent.putExtra(ClassParamsKt.OPEN_APP, z);
                context.startActivity(intent);
            }
        }
    }

    public ClassCalendarActivity() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        linearLayoutManager.setOrientation(0);
        this.mTeacherLayoutManager = linearLayoutManager;
        this.previousSource = "学习中心二级页";
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("syc_homework").observe(lifecycleOwner, new ClassCalendarActivity$special$$inlined$observe$1(this));
        XesDataBus.with("sync_homework_success").observe(lifecycleOwner, new ClassCalendarActivity$special$$inlined$observe$2(this));
        XesDataBus.with("request_homework_out_time").observe(lifecycleOwner, new ClassCalendarActivity$special$$inlined$observe$3());
    }

    public final long getMEndTime() {
        return this.mEndTime;
    }

    public final void setMEndTime(long j) {
        this.mEndTime = j;
    }

    public final EnterTipsDialog getMEnterTipsDialog() {
        return this.mEnterTipsDialog;
    }

    public final void setMEnterTipsDialog(EnterTipsDialog enterTipsDialog) {
        this.mEnterTipsDialog = enterTipsDialog;
    }

    public final ClassInfo getMClassInfo() {
        return this.mClassInfo;
    }

    public final void setMClassInfo(ClassInfo classInfo) {
        this.mClassInfo = classInfo;
    }

    /* access modifiers changed from: protected */
    public ActivityPlanListBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityPlanListBinding inflate = ActivityPlanListBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ClassCalendarActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, getColor(R.color.color_f4f6fa), false);
        TitleBar titleBar = getBinding().tbActivitySpeakerList;
        if (titleBar != null) {
            titleBar.setLineVisible(false);
        }
        TitleBar titleBar2 = getBinding().tbActivitySpeakerList;
        if (titleBar2 != null) {
            titleBar2.setOnTitleBarListener(new ClassCalendarActivity$onCreate$1(this));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.incomingClassId = intent.getStringExtra(ClassParamsKt.CLASS_ID);
            this.mOpenApp = intent.getBooleanExtra(ClassParamsKt.OPEN_APP, false);
            this.mType = intent.getIntExtra(ClassParamsKt.TYPE, 0);
            initData();
            trackPv();
        }
        TitleBar titleBar3 = getBinding().tbActivitySpeakerList;
        if (titleBar3 != null) {
            titleBar3.setTitle(getString(R.string.study_plan_list_title));
        }
    }

    private final void trackPv() {
        LeanplumUtil.longTrack$default("learning_detail_pv", this.incomingClassId, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16380, (Object) null);
    }

    private final void initData() {
        if (ShareDataManager.getInstance().getBoolean("plan_list_need_user_prompts", true, ShareDataManager.SHAREDATA_NOT_CLEAR)) {
            ConstraintLayout constraintLayout = getBinding().rlBgUserPrompts;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            ShareDataManager.getInstance().put("plan_list_need_user_prompts", false, ShareDataManager.SHAREDATA_NOT_CLEAR);
        } else {
            ConstraintLayout constraintLayout2 = getBinding().rlBgUserPrompts;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
        }
        ConstraintLayout constraintLayout3 = getBinding().rlBgUserPrompts;
        if (constraintLayout3 != null) {
            constraintLayout3.setOnClickListener(new ClassCalendarActivity$$ExternalSyntheticLambda0(this));
        }
        initTeacherListAdapter();
        initSpeakerListAdapter();
        requestNewListData();
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-5  reason: not valid java name */
    public static final void m462initData$lambda5(ClassCalendarActivity classCalendarActivity, View view) {
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        ConstraintLayout constraintLayout = classCalendarActivity.getBinding().rlBgUserPrompts;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getClassCalendar().observe(lifecycleOwner, new ClassCalendarActivity$$ExternalSyntheticLambda3(this));
        getMViewModel().getTeachMethodData().observe(lifecycleOwner, new ClassCalendarActivity$$ExternalSyntheticLambda4(this));
        getMViewModel().getHomeWorkJumpUrl().observe(lifecycleOwner, new ClassCalendarActivity$startObserve$$inlined$observe$1(this));
        getMViewModel().getHomeWorkSyc().observe(lifecycleOwner, new ClassCalendarActivity$startObserve$$inlined$observe$2(this));
        getMViewModel().getPreviewQuestionJumpUrl().observe(lifecycleOwner, new ClassCalendarActivity$startObserve$$inlined$observe$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-8  reason: not valid java name */
    public static final void m469startObserve$lambda8(ClassCalendarActivity classCalendarActivity, StateData stateData) {
        ArrayList arrayList;
        BaseLoadMoreModule loadMoreModule;
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        LoadStatusView loadStatusView = classCalendarActivity.getBinding().loadviewSpeakerList;
        if (loadStatusView != null) {
            loadStatusView.restoreView();
        }
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            if (stateData.getData() != null) {
                ClassCalendarEntity classCalendarEntity = (ClassCalendarEntity) stateData.getData();
                if ((classCalendarEntity == null ? null : classCalendarEntity.getSchedule()) != null) {
                    Object data = stateData.getData();
                    Intrinsics.checkNotNull(data);
                    List<Schedule> schedule = ((ClassCalendarEntity) data).getSchedule();
                    Intrinsics.checkNotNull(schedule);
                    if (!schedule.isEmpty()) {
                        ClassCalendarEntity classCalendarEntity2 = (ClassCalendarEntity) stateData.getData();
                        if (classCalendarEntity2 != null) {
                            classCalendarActivity.setMClassInfo(classCalendarEntity2.getClassInfo());
                            StudyTrack studyTrack = StudyTrack.INSTANCE;
                            ClassInfo mClassInfo2 = classCalendarActivity.getMClassInfo();
                            studyTrack.hw_class_detail_pv(mClassInfo2 == null ? 0 : mClassInfo2.getCourseType());
                            TagTextView tagTextView = classCalendarActivity.getBinding().tvActivitySpeakerStudyCourseName;
                            ClassInfo classInfo = classCalendarEntity2.getClassInfo();
                            CharSequence tag = classInfo == null ? null : classInfo.getTag();
                            if (tag == null || StringsKt.isBlank(tag)) {
                                arrayList = new ArrayList();
                            } else {
                                String[] strArr = new String[1];
                                ClassInfo classInfo2 = classCalendarEntity2.getClassInfo();
                                String tag2 = classInfo2 == null ? null : classInfo2.getTag();
                                Intrinsics.checkNotNull(tag2);
                                strArr[0] = tag2;
                                arrayList = CollectionsKt.arrayListOf(strArr);
                            }
                            List list = arrayList;
                            ClassInfo classInfo3 = classCalendarEntity2.getClassInfo();
                            tagTextView.setTagStart(list, classInfo3 == null ? null : classInfo3.getClassName());
                            TextView textView = classCalendarActivity.getBinding().tvActivitySpeakerStudyCourseDuration;
                            ClassInfo classInfo4 = classCalendarEntity2.getClassInfo();
                            textView.setText(classInfo4 == null ? null : classInfo4.getTimeDesc());
                            ClassInfo classInfo5 = classCalendarEntity2.getClassInfo();
                            CharSequence timeDesc2 = classInfo5 == null ? null : classInfo5.getTimeDesc2();
                            if (timeDesc2 == null || timeDesc2.length() == 0) {
                                classCalendarActivity.getBinding().tvActivitySpeakerStudyCourseTime.setVisibility(8);
                            } else {
                                TextView textView2 = classCalendarActivity.getBinding().tvActivitySpeakerStudyCourseTime;
                                ClassInfo classInfo6 = classCalendarEntity2.getClassInfo();
                                textView2.setText(classInfo6 == null ? null : classInfo6.getTimeDesc2());
                                classCalendarActivity.getBinding().tvActivitySpeakerStudyCourseTime.setVisibility(0);
                            }
                            ClassInfo classInfo7 = classCalendarEntity2.getClassInfo();
                            classCalendarActivity.updateTeacherList(classInfo7 == null ? null : classInfo7.getTeachers());
                            CalendarAdapter calendarAdapter = classCalendarActivity.mCalendarAdapter;
                            if (calendarAdapter != null) {
                                List<Schedule> schedule2 = classCalendarEntity2.getSchedule();
                                Intrinsics.checkNotNull(schedule2);
                                calendarAdapter.setList(classCalendarActivity.convertNewData(schedule2));
                            }
                            classCalendarActivity.getBinding().rvSpeakerList.scrollToPosition(classCalendarActivity.jumpIndex);
                            CalendarAdapter calendarAdapter2 = classCalendarActivity.mCalendarAdapter;
                            if (calendarAdapter2 != null && (loadMoreModule = calendarAdapter2.getLoadMoreModule()) != null) {
                                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, (Object) null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            LoadStatusView loadStatusView2 = classCalendarActivity.getBinding().loadviewSpeakerList;
            Intrinsics.checkNotNullExpressionValue(loadStatusView2, "binding.loadviewSpeakerList");
            String string = classCalendarActivity.getString(R.string.study_plan_hint_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.study_plan_hint_empty)");
            LoadStatusView.showEmptyView$default(loadStatusView2, 0, string, false, (String) null, (Function0) null, 29, (Object) null);
            return;
        }
        LoadStatusView loadStatusView3 = classCalendarActivity.getBinding().loadviewSpeakerList;
        Intrinsics.checkNotNullExpressionValue(loadStatusView3, "binding.loadviewSpeakerList");
        String msg = stateData.getMsg();
        if (msg == null) {
            msg = classCalendarActivity.getString(R.string.study_center_data_error);
            Intrinsics.checkNotNullExpressionValue(msg, "getString(R.string.study_center_data_error)");
        }
        LoadStatusView.showErrorView$default(loadStatusView3, 0, msg, (String) null, (String) null, new ClassCalendarActivity$startObserve$1$1$2(classCalendarActivity), 13, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-10  reason: not valid java name */
    public static final void m468startObserve$lambda10(ClassCalendarActivity classCalendarActivity, StateData stateData) {
        TeachMethodEntity teachMethodEntity;
        ClassCalendarActivity classCalendarActivity2 = classCalendarActivity;
        Intrinsics.checkNotNullParameter(classCalendarActivity2, "this$0");
        classCalendarActivity.getBinding().loadviewSpeakerList.restoreView();
        if (stateData != null && (teachMethodEntity = (TeachMethodEntity) stateData.getData()) != null) {
            String platformType = teachMethodEntity.getPlatformType();
            String str = null;
            if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.ONLINE.getAliasName())) {
                Context context = (Context) classCalendarActivity2;
                ThinkHub thinkHub = teachMethodEntity.getThinkHub();
                if (thinkHub != null) {
                    str = thinkHub.getPhone();
                }
                String str2 = str;
                TheOutsideEntity theOutsideEntity = r5;
                TheOutsideEntity theOutsideEntity2 = new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, (String) null, str2, (String) null, (String) null, 223, (DefaultConstructorMarker) null);
                new ThinkhubDialog(context, theOutsideEntity, new ClassCalendarActivity$startObserve$2$1$1(classCalendarActivity2)).show();
            } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.OFFLINE.getAliasName())) {
                Context context2 = (Context) classCalendarActivity2;
                Offline offline = teachMethodEntity.getOffline();
                String venueAddress = offline == null ? null : offline.getVenueAddress();
                Offline offline2 = teachMethodEntity.getOffline();
                if (offline2 != null) {
                    str = offline2.getVenuePhone();
                }
                new OfflineClassFaceRoomDialog(context2, new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, (String) null, str, venueAddress, (String) null, 159, (DefaultConstructorMarker) null)).show();
            } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.ZOOM.getAliasName())) {
                Context context3 = (Context) classCalendarActivity2;
                Zoom zoom = teachMethodEntity.getZoom();
                String id = zoom == null ? null : zoom.getId();
                Zoom zoom2 = teachMethodEntity.getZoom();
                String password = zoom2 == null ? null : zoom2.getPassword();
                Zoom zoom3 = teachMethodEntity.getZoom();
                if (zoom3 != null) {
                    str = zoom3.getDownloadHref();
                }
                String str3 = str;
                TheOutsideEntity theOutsideEntity3 = r5;
                TheOutsideEntity theOutsideEntity4 = new TheOutsideEntity(id, password, str3, (String) null, (String) null, (String) null, (String) null, (String) null, 248, (DefaultConstructorMarker) null);
                new ZoomDialog(context3, theOutsideEntity3, new ClassCalendarActivity$startObserve$2$1$2(classCalendarActivity2)).show();
            } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.CLASS_IN.getAliasName())) {
                Context context4 = (Context) classCalendarActivity2;
                ClassIn classIn = teachMethodEntity.getClassIn();
                String downloadHref = classIn == null ? null : classIn.getDownloadHref();
                ClassIn classIn2 = teachMethodEntity.getClassIn();
                if (classIn2 != null) {
                    str = classIn2.getHref();
                }
                String str4 = str;
                TheOutsideEntity theOutsideEntity5 = r5;
                TheOutsideEntity theOutsideEntity6 = new TheOutsideEntity((String) null, (String) null, downloadHref, str4, (String) null, (String) null, (String) null, (String) null, 243, (DefaultConstructorMarker) null);
                new ClassinDialog(context4, theOutsideEntity5, new ClassCalendarActivity$startObserve$2$1$3(classCalendarActivity2)).show();
            } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.THINK_LIVE.getAliasName())) {
                Context context5 = (Context) classCalendarActivity2;
                ThinkLive thinkLive = teachMethodEntity.getThinkLive();
                if (thinkLive != null) {
                    str = thinkLive.getClassroomLink();
                }
                new ThinkLiveDialog(context5, new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, 239, (DefaultConstructorMarker) null), (Function2) null, 4, (DefaultConstructorMarker) null).show();
            } else if (Intrinsics.areEqual((Object) platformType, (Object) OutsideOfClassType.DUAL.getAliasName())) {
                Context context6 = (Context) classCalendarActivity2;
                Offline offline3 = teachMethodEntity.getOffline();
                String classRoomName = offline3 == null ? null : offline3.getClassRoomName();
                Offline offline4 = teachMethodEntity.getOffline();
                if (offline4 != null) {
                    str = offline4.getClassCenterName();
                }
                new OfflineClassRoomDialog(context6, new TheOutsideEntity((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, classRoomName, str, 63, (DefaultConstructorMarker) null)).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void jumpHomework(AssignmentEntity assignmentEntity) {
        String str;
        String str2;
        JumpParamsEntity jumpParams;
        Integer planId;
        JumpParamsEntity jumpParams2;
        JumpParamsEntity jumpParams3;
        JumpParamsEntity jumpParams4;
        Integer planId2;
        String num;
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String str3 = "";
        if (!(assignmentEntity == null || (jumpParams4 = assignmentEntity.getJumpParams()) == null || (planId2 = jumpParams4.getPlanId()) == null || (num = planId2.toString()) == null)) {
            str3 = num;
        }
        hWEventTracking.ostaDoHomework(str3);
        Bundle bundle = new Bundle();
        Integer num2 = null;
        if (assignmentEntity == null) {
            str = null;
        } else {
            str = assignmentEntity.getUrl();
        }
        bundle.putString("jump_key", str);
        int i = 0;
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(getApplicationContext())).build());
        if (assignmentEntity == null || (jumpParams3 = assignmentEntity.getJumpParams()) == null) {
            str2 = null;
        } else {
            str2 = jumpParams3.getHomeworkId();
        }
        bundle.putString("homework_id", str2);
        if (!(assignmentEntity == null || (jumpParams2 = assignmentEntity.getJumpParams()) == null)) {
            num2 = jumpParams2.getClassId();
        }
        bundle.putString(ClassParamsKt.CLASS_ID, String.valueOf(num2));
        if (!(assignmentEntity == null || (jumpParams = assignmentEntity.getJumpParams()) == null || (planId = jumpParams.getPlanId()) == null)) {
            i = planId.intValue();
        }
        bundle.putInt("plan_id", i);
        bundle.putInt("homework_type", this.mHomeworkType);
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
        bundle.clear();
    }

    private final void updateTeacherList(Collection<Teacher> collection) {
        TeacherListAdapter teacherListAdapter = this.mTeacherListAdapter;
        if (teacherListAdapter != null) {
            teacherListAdapter.setList(collection);
        }
        getBinding().rvSpeakerTeaceherList.postDelayed(new ClassCalendarActivity$$ExternalSyntheticLambda8(this), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateTeacherList$lambda-14  reason: not valid java name */
    public static final void m470updateTeacherList$lambda14(ClassCalendarActivity classCalendarActivity) {
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        classCalendarActivity.exposureTraceTeacher();
    }

    private final void initTeacherListAdapter() {
        this.mTeacherListAdapter = new TeacherListAdapter((List<Teacher>) null);
        getBinding().rvSpeakerTeaceherList.setLayoutManager(this.mTeacherLayoutManager);
        getBinding().rvSpeakerTeaceherList.setAdapter(this.mTeacherListAdapter);
        TeacherListAdapter teacherListAdapter = this.mTeacherListAdapter;
        if (teacherListAdapter != null) {
            teacherListAdapter.setOnItemClickListener(new ClassCalendarActivity$$ExternalSyntheticLambda5(this));
        }
        getBinding().rvSpeakerTeaceherList.addOnScrollListener(new ClassCalendarActivity$initTeacherListAdapter$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initTeacherListAdapter$lambda-15  reason: not valid java name */
    public static final void m464initTeacherListAdapter$lambda15(ClassCalendarActivity classCalendarActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        if (item instanceof Teacher) {
            Teacher teacher = (Teacher) item;
            Collection contactInfoListV2 = teacher.getContactInfoListV2();
            if (!(contactInfoListV2 == null || contactInfoListV2.isEmpty())) {
                classCalendarActivity.startContactInfoActivity(teacher);
                StudyTrack studyTrack = StudyTrack.INSTANCE;
                String identityType = teacher.getIdentityType();
                if (identityType == null) {
                    identityType = DbParams.GZIP_DATA_EVENT;
                }
                studyTrack.hw_contact_teacher_icon_click(ParseUtils.tryParseInt(identityType, 1));
            }
        }
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

    private final void startContactInfoActivity(Teacher teacher) {
        if (teacher != null) {
            ContactInformationActivity.Companion.startActivity((Context) this, teacher);
        }
    }

    private final void initSpeakerListAdapter() {
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule baseLoadMoreModule = null;
        this.mCalendarAdapter = new CalendarAdapter((List<CalendarItem>) null, new ClassCalendarActivity$initSpeakerListAdapter$1(this));
        getBinding().rvSpeakerList.setLayoutManager(new LinearLayoutManager((Context) this));
        getBinding().rvSpeakerList.setAdapter(this.mCalendarAdapter);
        CalendarAdapter calendarAdapter = this.mCalendarAdapter;
        if (calendarAdapter != null) {
            baseLoadMoreModule = calendarAdapter.getLoadMoreModule();
        }
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.setLoadMoreView(new CustomLoadMoreView());
        }
        CalendarAdapter calendarAdapter2 = this.mCalendarAdapter;
        if (calendarAdapter2 != null && (loadMoreModule = calendarAdapter2.getLoadMoreModule()) != null) {
            loadMoreModule.setOnLoadMoreListener(ClassCalendarActivity$$ExternalSyntheticLambda6.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void showEnterTipsDialog(Function0<Unit> function0) {
        EnterTipsDialog enterTipsDialog = this.mEnterTipsDialog;
        if (enterTipsDialog != null) {
            enterTipsDialog.dismiss();
        }
        EnterTipsDialog enterTipsDialog2 = new EnterTipsDialog((Context) this, new ClassCalendarActivity$showEnterTipsDialog$1(function0));
        this.mEnterTipsDialog = enterTipsDialog2;
        enterTipsDialog2.show();
    }

    public final void startCheckStudentInClass(Integer num, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "listen");
        XesLog.dt("ClassCalendarActivity", new Object[]{"checkStudentInClass..."});
        showLoading();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new ClassCalendarActivity$startCheckStudentInClass$1(this, function0)), (CoroutineStart) null, new ClassCalendarActivity$startCheckStudentInClass$2(num, this, function0, (Continuation<? super ClassCalendarActivity$startCheckStudentInClass$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void requestNewListData() {
        LoadStatusView loadStatusView = getBinding().loadviewSpeakerList;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadviewSpeakerList");
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        getMViewModel().getClassCalendarInfo(this.incomingClassId);
    }

    private final void requestTeachMethod(String str, String str2) {
        getBinding().loadviewSpeakerList.showFullLoadingView(R.color.transparent_50);
        getMViewModel().requestTeachMethod(str, str2);
    }

    private final List<CalendarItem> convertNewData(List<Schedule> list) {
        ArrayList arrayList = new ArrayList();
        for (Schedule next : list) {
            if (next != null) {
                arrayList.add(new CalendarItem((ExamDetails) null, (LessonDetails) null, (String) null, (String) null, true, next.getDate(), 15, (DefaultConstructorMarker) null));
                List<CalendarItem> list2 = next.getList();
                if (list2 != null) {
                    int i = 0;
                    for (Object next2 : list2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        CalendarItem calendarItem = (CalendarItem) next2;
                        LessonDetails lessonDetails = calendarItem.getLessonDetails();
                        if ((lessonDetails != null && lessonDetails.isShow()) && this.jumpIndex <= 0) {
                            this.jumpIndex = (arrayList.size() - i) - 1;
                        }
                        arrayList.add(calendarItem);
                        i = i2;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void enterTrack(com.tal.app.thinkacademy.business.study.study.speaker.PlanState r11, com.tal.app.thinkacademy.business.study.study.entity.CalendarItem r12) {
        /*
            r10 = this;
            int[] r0 = com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity.WhenMappings.$EnumSwitchMapping$1
            int r11 = r11.ordinal()
            r11 = r0[r11]
            r0 = 1
            r1 = 0
            if (r11 == r0) goto L_0x0014
            r2 = 2
            if (r11 == r2) goto L_0x0011
            r8 = r1
            goto L_0x0017
        L_0x0011:
            java.lang.String r11 = "回放"
            goto L_0x0016
        L_0x0014:
            java.lang.String r11 = "直播"
        L_0x0016:
            r8 = r11
        L_0x0017:
            r11 = r8
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x0024
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            if (r0 != 0) goto L_0x0086
            com.tal.app.thinkacademy.business.study.study.StudyTrack r2 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            if (r12 != 0) goto L_0x002c
        L_0x002a:
            r3 = r1
            goto L_0x0038
        L_0x002c:
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r11 = r12.getLessonDetails()
            if (r11 != 0) goto L_0x0033
            goto L_0x002a
        L_0x0033:
            java.lang.Integer r11 = r11.getPackageId()
            r3 = r11
        L_0x0038:
            if (r12 != 0) goto L_0x003c
        L_0x003a:
            r4 = r1
            goto L_0x004f
        L_0x003c:
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r11 = r12.getLessonDetails()
            if (r11 != 0) goto L_0x0043
            goto L_0x003a
        L_0x0043:
            java.lang.String r11 = r11.getClassId()
            if (r11 != 0) goto L_0x004a
            goto L_0x003a
        L_0x004a:
            java.lang.Integer r11 = kotlin.text.StringsKt.toIntOrNull(r11)
            r4 = r11
        L_0x004f:
            com.tal.app.thinkacademy.business.study.study.entity.ClassInfo r11 = r10.mClassInfo
            if (r11 != 0) goto L_0x0055
            r5 = r1
            goto L_0x005a
        L_0x0055:
            java.lang.Integer r11 = r11.getCourseId()
            r5 = r11
        L_0x005a:
            if (r12 != 0) goto L_0x005e
        L_0x005c:
            r7 = r1
            goto L_0x0071
        L_0x005e:
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r11 = r12.getLessonDetails()
            if (r11 != 0) goto L_0x0065
            goto L_0x005c
        L_0x0065:
            java.lang.String r11 = r11.getPlanId()
            if (r11 != 0) goto L_0x006c
            goto L_0x005c
        L_0x006c:
            java.lang.Integer r11 = kotlin.text.StringsKt.toIntOrNull(r11)
            r7 = r11
        L_0x0071:
            if (r12 != 0) goto L_0x0075
        L_0x0073:
            r9 = r1
            goto L_0x0081
        L_0x0075:
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r11 = r12.getLessonDetails()
            if (r11 != 0) goto L_0x007c
            goto L_0x0073
        L_0x007c:
            java.lang.Integer r1 = r11.getSubPlatformType()
            goto L_0x0073
        L_0x0081:
            java.lang.String r6 = "学习中心二级页"
            r2.stuClassListClick(r3, r4, r5, r6, r7, r8, r9)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity.enterTrack(com.tal.app.thinkacademy.business.study.study.speaker.PlanState, com.tal.app.thinkacademy.business.study.study.entity.CalendarItem):void");
    }

    /* access modifiers changed from: private */
    public final void itemClick(ClickType clickType, CalendarItem calendarItem) {
        Long l;
        AssignmentEntity assignmentEntity;
        JumpParamsEntity jumpParamsEntity;
        boolean z;
        LessonDetails lessonDetails;
        HashMap hashMap;
        String str;
        String str2;
        LessonDetails lessonDetails2;
        Integer packageId;
        String str3;
        String str4;
        LessonDetails lessonDetails3;
        Integer packageId2;
        String str5;
        Integer num;
        String str6;
        Integer num2;
        String planId;
        ExamDetails exam;
        ExamDetails exam2;
        String planId2;
        CalendarItem calendarItem2 = calendarItem;
        if (CommonUtilsKt.isFastClick()) {
            XesLog.dt("ClassCalendarActivity", new Object[]{"点击太快了。"});
        } else if (calendarItem2 != null) {
            LessonDetails lessonDetails4 = calendarItem.getLessonDetails();
            if (lessonDetails4 == null || (planId2 = lessonDetails4.getPlanId()) == null) {
                l = null;
            } else {
                l = Long.valueOf(Long.parseLong(planId2));
            }
            this.mPlanId = l;
            switch (WhenMappings.$EnumSwitchMapping$2[clickType.ordinal()]) {
                case 1:
                    boolean z2 = true;
                    this.mHomeworkType = 0;
                    if (lessonDetails4 == null) {
                        assignmentEntity = null;
                    } else {
                        assignmentEntity = lessonDetails4.getAssignment();
                    }
                    if (assignmentEntity == null) {
                        jumpParamsEntity = null;
                    } else {
                        jumpParamsEntity = assignmentEntity.getJumpParams();
                    }
                    if (jumpParamsEntity != null) {
                        Integer status = assignmentEntity.getStatus();
                        int code = AssignmentType.UnPub.getCode();
                        if (status == null || status.intValue() != code) {
                            showLoading();
                            Integer status2 = assignmentEntity.getStatus();
                            if (status2 == null || status2.intValue() != 6) {
                                z2 = false;
                            }
                            this.isFinished = z2;
                            getMViewModel().requestHomeWorkJumpUrl(assignmentEntity.getJumpParams());
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                case 3:
                    if (clickType == ClickType.ParentAudit) {
                        StudyTrack studyTrack = StudyTrack.INSTANCE;
                        if (lessonDetails4 == null) {
                            str5 = null;
                        } else {
                            str5 = lessonDetails4.getPlanId();
                        }
                        if (lessonDetails4 == null) {
                            num = null;
                        } else {
                            num = lessonDetails4.getPackageId();
                        }
                        if (lessonDetails4 == null) {
                            str6 = null;
                        } else {
                            str6 = lessonDetails4.getClassId();
                        }
                        if (lessonDetails4 == null) {
                            num2 = null;
                        } else {
                            num2 = lessonDetails4.getSubPlatformType();
                        }
                        studyTrack.parentClassEnterClick(str5, num, str6, num2);
                        z = true;
                    } else {
                        z = false;
                    }
                    CalendarItem calendarItem3 = calendarItem.isHeader() ^ true ? calendarItem2 : null;
                    if (calendarItem3 != null && (lessonDetails = calendarItem3.getLessonDetails()) != null) {
                        HashMap hashMap2 = new HashMap();
                        Map map = hashMap2;
                        map.put("lesson_id", lessonDetails.getPlanId());
                        map.put("class_attend_type", lessonDetails.getPlatformType());
                        this.isAuditor = lessonDetails.isAudition();
                        if (Intrinsics.areEqual((Object) lessonDetails.getPlatformType(), (Object) OutsideOfClassType.BIG_ONLINE.getAliasName())) {
                            Integer status3 = lessonDetails.getStatus();
                            int code2 = PlanState.ToStart.getCode();
                            if (status3 != null && status3.intValue() == code2) {
                                hashMap = hashMap2;
                            } else {
                                int code3 = PlanState.Live.getCode();
                                hashMap = hashMap2;
                                if (status3 == null) {
                                    CalendarItem calendarItem4 = calendarItem;
                                    str = "bizId";
                                    str2 = "packageId";
                                } else {
                                    String str7 = "packageId";
                                    if (status3.intValue() == code3) {
                                        map.put("lesson_button_type", "enter");
                                        CharSequence overseaApi = ImConfig.INSTANCE.getOverseaApi();
                                        if (!(overseaApi == null || StringsKt.isBlank(overseaApi))) {
                                            setMEndTime(TimeTransformationUtil.Companion.dateToStamp$default(TimeTransformationUtil.Companion, lessonDetails.getClassDate() + ' ' + lessonDetails.getEndTime() + ":00", (String) null, 2, (Object) null));
                                            XesLog.i(Tag.ClassCalendarActivity, new Object[]{"直播跳转下载页"});
                                            Intent intent = new Intent((Context) this, BeforeClassLiveActivity.class);
                                            intent.putExtra("bizId", lessonDetails.getBizId());
                                            intent.putExtra(LearnMaterialsListActivityKt.PLANID, lessonDetails.getPlanId());
                                            intent.putExtra("courseId", lessonDetails.getClassId());
                                            intent.putExtra("editSuccess", "0");
                                            intent.putExtra("subPlatformType", lessonDetails.getSubPlatformType());
                                            intent.putExtra("isParentAudit", z);
                                            intent.putExtra("lessonType", lessonDetails.getLessonType());
                                            intent.putExtra("previousSource", this.previousSource);
                                            intent.putExtra("isAuditor", this.isAuditor);
                                            CalendarItem calendarItem5 = this.mClickLesson;
                                            if (calendarItem5 == null || (lessonDetails3 = calendarItem5.getLessonDetails()) == null || (packageId2 = lessonDetails3.getPackageId()) == null) {
                                                str4 = str7;
                                                str3 = null;
                                            } else {
                                                str3 = packageId2.toString();
                                                str4 = str7;
                                            }
                                            intent.putExtra(str4, str3);
                                            Unit unit2 = Unit.INSTANCE;
                                            startActivity(intent);
                                        } else {
                                            ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
                                        }
                                        enterTrack(PlanState.Live, calendarItem);
                                    } else {
                                        CalendarItem calendarItem6 = calendarItem;
                                        str = "bizId";
                                        str2 = str7;
                                    }
                                }
                                int code4 = PlanState.PlaybackGenerating.getCode();
                                if (status3 != null && status3.intValue() == code4) {
                                    map.put("lesson_button_type", "generating");
                                    ToastUtils.showShort(R.string.playback_to_generate_Chinese_case);
                                } else {
                                    int code5 = PlanState.Playback.getCode();
                                    if (status3 != null && status3.intValue() == code5) {
                                        map.put("lesson_button_type", "playback");
                                        CharSequence overseaApi2 = ImConfig.INSTANCE.getOverseaApi();
                                        if (!(overseaApi2 == null || StringsKt.isBlank(overseaApi2))) {
                                            XesLog.i(Tag.ClassCalendarActivity, new Object[]{"回放跳转下载页"});
                                            Intent intent2 = new Intent((Context) this, BeforeClassBackActivity.class);
                                            intent2.putExtra(str, lessonDetails.getBizId());
                                            intent2.putExtra(LearnMaterialsListActivityKt.PLANID, lessonDetails.getPlanId());
                                            intent2.putExtra("courseId", lessonDetails.getClassId());
                                            intent2.putExtra("editSuccess", "0");
                                            intent2.putExtra("isLive", false);
                                            intent2.putExtra("subPlatformType", lessonDetails.getSubPlatformType());
                                            intent2.putExtra("lessonType", lessonDetails.getLessonType());
                                            intent2.putExtra("previousSource", this.previousSource);
                                            CalendarItem calendarItem7 = this.mClickLesson;
                                            intent2.putExtra(str2, (calendarItem7 == null || (lessonDetails2 = calendarItem7.getLessonDetails()) == null || (packageId = lessonDetails2.getPackageId()) == null) ? null : packageId.toString());
                                            Unit unit3 = Unit.INSTANCE;
                                            startActivity(intent2);
                                        } else {
                                            ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
                                        }
                                        enterTrack(PlanState.Playback, calendarItem);
                                    } else {
                                        int code6 = PlanState.PlaybackExpired.getCode();
                                        if (status3 == null || status3.intValue() != code6) {
                                            PlanState.Unpaid.getCode();
                                            if (status3 != null) {
                                                status3.intValue();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            hashMap = hashMap2;
                            map.put("lesson_button_type", "attend_method");
                            requestTeachMethod(lessonDetails.getClassId(), lessonDetails.getOrderNum());
                        }
                        LeanplumUtil.commonTrack("click_learning_detail_active_button", hashMap);
                        Unit unit4 = Unit.INSTANCE;
                        Unit unit5 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 4:
                    LessonDetails lessonDetails5 = calendarItem.getLessonDetails();
                    if (lessonDetails5 != null) {
                        AssignmentEntity previewQuestion = lessonDetails5.getPreviewQuestion();
                        if ((previewQuestion == null ? null : previewQuestion.getJumpParams()) != null) {
                            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
                            String str8 = "";
                            if (!(lessonDetails4 == null || (planId = lessonDetails4.getPlanId()) == null)) {
                                str8 = planId;
                            }
                            hWEventTracking.ostaDoPreTest(str8);
                            this.mHomeworkType = 1;
                            this.mJumpParams = lessonDetails5.getPreviewQuestion().getJumpParams();
                            Integer status4 = lessonDetails5.getPreviewQuestion().getStatus();
                            if (status4 != null && status4.intValue() == 3) {
                                PreviewQuestionActivity.Companion.startActivity$default(PreviewQuestionActivity.Companion, (Context) this, lessonDetails5.getPreviewQuestion().getJumpParams(), false, 4, (Object) null);
                            } else if (status4 != null && status4.intValue() == 4) {
                                showLoading();
                                getMViewModel().getPreQuestionJumpUrl(lessonDetails5.getPreviewQuestion().getJumpParams());
                            } else if (status4 != null && status4.intValue() == 5) {
                                showLoading();
                                getMViewModel().getPreQuestionJumpUrl(lessonDetails5.getPreviewQuestion().getJumpParams());
                            } else if (status4 != null && status4.intValue() == 6) {
                                PreviewQuestionActivity.Companion.startActivity((Context) this, lessonDetails5.getPreviewQuestion().getJumpParams(), true);
                            }
                            Unit unit6 = Unit.INSTANCE;
                            Unit unit7 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    ExamDetails examDetails = calendarItem.getExamDetails();
                    if (examDetails != null) {
                        Integer examStatus = examDetails.getExamStatus();
                        if (examStatus != null && examStatus.intValue() == 1) {
                            showToast(getString(R.string.exam_not_released_tip));
                        } else {
                            ExamNoteActivity.Companion.startActivity((Context) this, examDetails.getJumpParams());
                        }
                        Unit unit8 = Unit.INSTANCE;
                        Unit unit9 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 6:
                    LessonDetails lessonDetails6 = calendarItem.getLessonDetails();
                    if (lessonDetails6 != null && (exam = lessonDetails6.getExam()) != null) {
                        Integer examStatus2 = exam.getExamStatus();
                        if (examStatus2 != null && examStatus2.intValue() == 1) {
                            showToast(getString(R.string.exam_not_released_tip));
                        } else {
                            ExamNoteActivity.Companion.startActivity((Context) this, exam.getJumpParams());
                        }
                        Unit unit10 = Unit.INSTANCE;
                        Unit unit11 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 7:
                    LessonDetails lessonDetails7 = calendarItem.getLessonDetails();
                    if (lessonDetails7 != null && (exam2 = lessonDetails7.getExam()) != null) {
                        Bundle bundle = new Bundle();
                        boolean isPad = PadUtils.isPad((Context) this);
                        String str9 = isPad ? "4" : DbParams.GZIP_DATA_EVENT;
                        CharSequence[] charSequenceArr = new CharSequence[5];
                        charSequenceArr[0] = exam2.getReportURI();
                        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                        charSequenceArr[1] = Intrinsics.stringPlus("&token=", userInfoEntity == null ? null : userInfoEntity.getUnifiedAccessToken());
                        charSequenceArr[2] = Intrinsics.stringPlus("&platform=", str9);
                        UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                        charSequenceArr[3] = Intrinsics.stringPlus("&studentId=", userInfoEntity2 == null ? null : userInfoEntity2.getUid());
                        charSequenceArr[4] = Intrinsics.stringPlus("&platform=", calendarItem.getLessonDetails().getClassId());
                        bundle.putString("jump_key", TextUtils.concat(charSequenceArr).toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(isPad).build());
                        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                        Unit unit12 = Unit.INSTANCE;
                        Unit unit13 = Unit.INSTANCE;
                        return;
                    }
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
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
                BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog = (BaseBindDialog) new ClassCalendarActivity$showNotificationDialog$1(this);
                this.mNotificationDialog = baseBindDialog;
                BaseDialog gravity = baseBindDialog.gravity(80);
                if (!(gravity == null || (dimAmount = gravity.dimAmount(0.2f)) == null || (offset = dimAmount.offset(0, SizeUtils.dp2px(40.0f))) == null || (layoutParams = offset.layoutParams(new LinearLayout.LayoutParams(-1, -2))) == null)) {
                    layoutParams.canceledOnTouchOutside(true);
                }
                BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog2 = this.mNotificationDialog;
                if (!(baseBindDialog2 == null || (dialogNotifacationTipBinding2 = baseBindDialog2.binding) == null || (textView2 = dialogNotifacationTipBinding2.tvCancel) == null)) {
                    textView2.setOnClickListener(new ClassCalendarActivity$$ExternalSyntheticLambda2(this));
                }
                BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog3 = this.mNotificationDialog;
                if (!(baseBindDialog3 == null || (dialogNotifacationTipBinding = baseBindDialog3.binding) == null || (textView = dialogNotifacationTipBinding.tvConfirm) == null)) {
                    textView.setOnClickListener(new ClassCalendarActivity$$ExternalSyntheticLambda1(this));
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
    /* renamed from: showNotificationDialog$lambda-29  reason: not valid java name */
    public static final void m466showNotificationDialog$lambda29(ClassCalendarActivity classCalendarActivity, View view) {
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog = classCalendarActivity.mNotificationDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNotificationDialog$lambda-30  reason: not valid java name */
    public static final void m467showNotificationDialog$lambda30(ClassCalendarActivity classCalendarActivity, View view) {
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        IntentUtils.startAppSettings((Context) classCalendarActivity);
        BaseBindDialog<DialogNotifacationTipBinding> baseBindDialog = classCalendarActivity.mNotificationDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ClassCalendarActivity.super.onResume();
        TeacherListAdapter teacherListAdapter = this.mTeacherListAdapter;
        if (teacherListAdapter != null) {
            teacherListAdapter.resetExposure();
        }
        exposureTraceTeacher();
        if (this.mEndTime > 0) {
            if (TimeTransformationUtil.Companion.dateToStamp$default(TimeTransformationUtil.Companion, (String) null, 1, (Object) null) >= this.mEndTime) {
                requestNewListData();
            }
            this.mEndTime = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ClassCalendarActivity.super.onDestroy();
        getMViewModel().cancelAll();
    }

    /* access modifiers changed from: private */
    public final void callPhone(String str) {
        if (isGranted("android.permission.CALL_PHONE")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.CALL");
            intent.setData(Uri.parse(Intrinsics.stringPlus("tel:", str)));
            startActivity(intent);
            return;
        }
        requestCallPhonePermission(str);
    }

    private final void requestCallPhonePermission(String str) {
        Observable requestEachCombined;
        String[] strArr = {"android.permission.CALL_PHONE"};
        RxPermissions mRxPermissions = getMRxPermissions();
        if (mRxPermissions != null && (requestEachCombined = mRxPermissions.requestEachCombined((String[]) Arrays.copyOf(strArr, 1))) != null) {
            requestEachCombined.subscribe(new ClassCalendarActivity$$ExternalSyntheticLambda7(this, str));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: requestCallPhonePermission$lambda-33  reason: not valid java name */
    public static final void m465requestCallPhonePermission$lambda33(ClassCalendarActivity classCalendarActivity, String str, Permission permission) {
        Intrinsics.checkNotNullParameter(classCalendarActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$phoneNumber");
        if (permission.granted) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.CALL");
            intent.setData(Uri.parse(Intrinsics.stringPlus("tel:", str)));
            classCalendarActivity.startActivity(intent);
            return;
        }
        new PhoneSecondaryConfirmationDialog((Context) classCalendarActivity).show();
    }

    public void finish() {
        ClassCalendarActivity.super.finish();
        if (this.mOpenApp) {
            XesRoute.getInstance().navigation("/home/main_activity");
        }
    }
}
