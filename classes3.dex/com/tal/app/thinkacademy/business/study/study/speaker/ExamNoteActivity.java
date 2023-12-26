package com.tal.app.thinkacademy.business.study.study.speaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundTextView;
import com.gyf.immersionbar.ImmersionBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Question;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.ExamQuestionAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.ExamNoteVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteBinding;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding;
import com.tal.app.thinkacademy.business.studycenter.databinding.DialogStartExamBinding;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00014B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\b\u0010.\u001a\u00020\u001fH\u0002J\b\u0010/\u001a\u00020\u001fH\u0002J\b\u00100\u001a\u00020\u001fH\u0016J\u0012\u00101\u001a\u00020\u001f2\b\u00102\u001a\u0004\u0018\u000103H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ExamNoteActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/ExamNoteVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityExamNoteBinding;", "Landroid/view/View$OnClickListener;", "()V", "headBinding", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityExamNoteHeaderBinding;", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/ExamQuestionAdapter;", "mDuration", "", "mExamStatus", "", "Ljava/lang/Integer;", "mHandler", "Landroid/os/Handler;", "mJumpParams", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "mLimitTime", "", "Ljava/lang/Boolean;", "mStartDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/DialogStartExamBinding;", "mUrl", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getData", "", "getLanguage", "init", "initImmersionBar", "isRecyclerScrollable", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "jumpToWeb", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setBackParams", "showDialog", "startObserve", "updateValues", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExamNoteActivity.kt */
public final class ExamNoteActivity extends BaseVmActivity<ExamNoteVM, ActivityExamNoteBinding> implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityExamNoteHeaderBinding headBinding;
    private ExamQuestionAdapter mAdapter;
    private String mDuration = "";
    private Integer mExamStatus;
    private Handler mHandler;
    private JumpParamsEntity mJumpParams;
    private Boolean mLimitTime = false;
    private BaseBindDialog<DialogStartExamBinding> mStartDialog;
    private String mUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExamNoteActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HwLanguageUtil.HwLanguageInfo.values().length];
            iArr2[HwLanguageUtil.HwLanguageInfo.ENGLISH.ordinal()] = 1;
            iArr2[HwLanguageUtil.HwLanguageInfo.CHINESE.ordinal()] = 2;
            iArr2[HwLanguageUtil.HwLanguageInfo.CHINESE_HK.ordinal()] = 3;
            iArr2[HwLanguageUtil.HwLanguageInfo.ENGLISH_UK.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ExamNoteActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExamNoteActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, JumpParamsEntity jumpParamsEntity) {
            if (context != null) {
                Intent intent = new Intent(context, ExamNoteActivity.class);
                intent.putExtra(ClassParamsKt.JUMP_PARAMS, jumpParamsEntity);
                context.startActivity(intent);
            }
        }
    }

    public ExamNoteActivity() {
        XesDataBus.with("sync_homework_success").observe((LifecycleOwner) this, new ExamNoteActivity$special$$inlined$observe$1(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ExamNoteActivity.super.onCreate(bundle);
        init();
    }

    /* access modifiers changed from: protected */
    public ActivityExamNoteBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityExamNoteBinding inflate = ActivityExamNoteBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    public void startObserve() {
        getMViewModel().getPaperDetailData().observe((LifecycleOwner) this, new ExamNoteActivity$startObserve$$inlined$observe$1(this));
    }

    private final void init() {
        initImmersionBar();
        setBackParams();
        View.OnClickListener onClickListener = this;
        getBinding().ivBack.setOnClickListener(onClickListener);
        getBinding().tvStart.setOnClickListener(onClickListener);
        this.mJumpParams = (JumpParamsEntity) getIntent().getSerializableExtra(ClassParamsKt.JUMP_PARAMS);
        getData();
    }

    private final void initImmersionBar() {
        ImmersionBar.with((Activity) this).keyboardEnable(false).statusBarDarkFont(true).navigationBarColor(R.color.color_EFF1F5).navigationBarDarkIcon(true).init();
    }

    private final void setBackParams() {
        int statusBarHeight = ImmersionBar.getStatusBarHeight((Activity) this);
        ConstraintLayout.LayoutParams layoutParams = getBinding().ivBack.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
        layoutParams2.setMargins(layoutParams2.getMarginStart(), statusBarHeight + SizeUtils.dp2px(6.0f), 0, 0);
    }

    /* access modifiers changed from: private */
    public final void getData() {
        if (this.mJumpParams != null) {
            LoadStatusView loadStatusView = getBinding().loadStatusView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
            Integer num = null;
            LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
            ExamNoteVM mViewModel = getMViewModel();
            JumpParamsEntity jumpParamsEntity = this.mJumpParams;
            String paperId = jumpParamsEntity == null ? null : jumpParamsEntity.getPaperId();
            JumpParamsEntity jumpParamsEntity2 = this.mJumpParams;
            Integer planId = jumpParamsEntity2 == null ? null : jumpParamsEntity2.getPlanId();
            JumpParamsEntity jumpParamsEntity3 = this.mJumpParams;
            Integer homeworkType = jumpParamsEntity3 == null ? null : jumpParamsEntity3.getHomeworkType();
            JumpParamsEntity jumpParamsEntity4 = this.mJumpParams;
            if (jumpParamsEntity4 != null) {
                num = jumpParamsEntity4.getClassId();
            }
            mViewModel.getPaperOverview(paperId, planId, homeworkType, num, PadUtils.isPad((Context) this) ? "4" : DbParams.GZIP_DATA_EVENT);
        }
    }

    private final String getLanguage() {
        int i = WhenMappings.$EnumSwitchMapping$1[HwLanguageUtil.INSTANCE.getCurrentLanguage().ordinal()];
        if (i == 2) {
            return "zh-CN";
        }
        if (i != 3) {
            return i != 4 ? "en" : "en-GB";
        }
        return "zh-HK";
    }

    /* access modifiers changed from: private */
    public final void updateValues(PaperDetailEntity paperDetailEntity) {
        Handler handler;
        BaseQuickAdapter baseQuickAdapter;
        String str;
        if (paperDetailEntity != null) {
            if (this.headBinding == null) {
                this.headBinding = ActivityExamNoteHeaderBinding.inflate(getLayoutInflater());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding = this.headBinding;
            Unit unit = null;
            TextView textView = activityExamNoteHeaderBinding == null ? null : activityExamNoteHeaderBinding.tvTitle;
            if (textView != null) {
                textView.setText(paperDetailEntity.getTitle());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding2 = this.headBinding;
            TextView textView2 = activityExamNoteHeaderBinding2 == null ? null : activityExamNoteHeaderBinding2.tvDeadline;
            if (textView2 != null) {
                textView2.setText(paperDetailEntity.getDeadline());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding3 = this.headBinding;
            TextView textView3 = activityExamNoteHeaderBinding3 == null ? null : activityExamNoteHeaderBinding3.tvDuration;
            if (textView3 != null) {
                textView3.setText(paperDetailEntity.getDuration());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding4 = this.headBinding;
            RoundTextView roundTextView = activityExamNoteHeaderBinding4 == null ? null : activityExamNoteHeaderBinding4.tvTotalScore;
            boolean z = true;
            if (roundTextView != null) {
                roundTextView.setText(getString(R.string.total_points, new Object[]{paperDetailEntity.getTotalScore()}));
            }
            Integer homeworkStatus = paperDetailEntity.getHomeworkStatus();
            if (homeworkStatus != null && homeworkStatus.intValue() == 5) {
                ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding5 = this.headBinding;
                ConstraintLayout constraintLayout = activityExamNoteHeaderBinding5 == null ? null : activityExamNoteHeaderBinding5.layoutExpired;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
            } else {
                ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding6 = this.headBinding;
                ConstraintLayout constraintLayout2 = activityExamNoteHeaderBinding6 == null ? null : activityExamNoteHeaderBinding6.layoutExpired;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }
            this.mExamStatus = paperDetailEntity.getHomeworkStatus();
            this.mLimitTime = paperDetailEntity.getLimitTime();
            Integer homeworkStatus2 = paperDetailEntity.getHomeworkStatus();
            boolean z2 = homeworkStatus2 != null && homeworkStatus2.intValue() == 2 && Intrinsics.areEqual((Object) paperDetailEntity.isReward(), (Object) true);
            if (z2) {
                getBinding().llTip.setVisibility(0);
            } else {
                getBinding().llTip.setVisibility(8);
            }
            Integer homeworkStatus3 = paperDetailEntity.getHomeworkStatus();
            if (homeworkStatus3 != null && homeworkStatus3.intValue() == 2) {
                getBinding().tvStart.setText(getString(R.string.start_test));
            } else if (homeworkStatus3 != null && homeworkStatus3.intValue() == 5) {
                getBinding().tvStart.setText(getString(R.string.check_solutions));
            } else {
                getBinding().tvStart.setText(getString(R.string.check_results));
            }
            this.mDuration = String.valueOf(paperDetailEntity.getDuration());
            this.mUrl = paperDetailEntity.getHomeworkUrl();
            if (paperDetailEntity.getReportType() == 2) {
                int i = PadUtils.isPad(Utils.getApp()) ? 4 : 1;
                String homeworkUrl = paperDetailEntity.getHomeworkUrl();
                if (homeworkUrl == null || !StringsKt.contains$default(homeworkUrl, "?", false, 2, (Object) null)) {
                    z = false;
                }
                if (z) {
                    str = paperDetailEntity.getHomeworkUrl() + "&platform=" + i + "&language=" + getLanguage() + "&reportType=2";
                } else {
                    str = paperDetailEntity.getHomeworkUrl() + "?platform=" + i + "&language=" + getLanguage() + "&reportType=2";
                }
                this.mUrl = str;
            }
            List<Question> questions = paperDetailEntity.getQuestions();
            Objects.requireNonNull(questions, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tal.app.thinkacademy.business.study.study.entity.Question>");
            List asMutableList = TypeIntrinsics.asMutableList(questions);
            ExamQuestionAdapter examQuestionAdapter = this.mAdapter;
            if (!(examQuestionAdapter == null || examQuestionAdapter == null)) {
                examQuestionAdapter.setList(asMutableList);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.mAdapter = new ExamQuestionAdapter(asMutableList);
                getBinding().recyclerView.setLayoutManager(new LinearLayoutManager((Context) this));
                ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding7 = this.headBinding;
                if (!(activityExamNoteHeaderBinding7 == null || (baseQuickAdapter = this.mAdapter) == null)) {
                    LinearLayout root = activityExamNoteHeaderBinding7.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "it.root");
                    BaseQuickAdapter.setHeaderView$default(baseQuickAdapter, root, 0, 0, 6, (Object) null);
                }
                getBinding().recyclerView.setAdapter(this.mAdapter);
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            if (z2 && (handler = this.mHandler) != null) {
                handler.postDelayed(new ExamNoteActivity$$ExternalSyntheticLambda2(this), 500);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateValues$lambda-9$lambda-8  reason: not valid java name */
    public static final void m474updateValues$lambda9$lambda8(ExamNoteActivity examNoteActivity) {
        Intrinsics.checkNotNullParameter(examNoteActivity, "this$0");
        ExamQuestionAdapter examQuestionAdapter = examNoteActivity.mAdapter;
        if (examQuestionAdapter != null) {
            RecyclerView recyclerView = examNoteActivity.getBinding().recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            examQuestionAdapter.setShowBottom(examNoteActivity.isRecyclerScrollable(recyclerView));
        }
    }

    private final boolean isRecyclerScrollable(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = layoutManager;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() < adapter.getItemCount() - 1) {
            return true;
        }
        return false;
    }

    private final void showDialog() {
        DialogStartExamBinding dialogStartExamBinding;
        if (this.mStartDialog == null) {
            ExamNoteActivity examNoteActivity = this;
            BaseBindDialog<DialogStartExamBinding> examNoteActivity$showDialog$1$1 = new ExamNoteActivity$showDialog$1$1(this);
            examNoteActivity$showDialog$1$1.gravity(17).layoutParams(new LinearLayout.LayoutParams(-1, -2)).canceledOnTouchOutside(true);
            examNoteActivity$showDialog$1$1.binding.tvConfirm.setOnClickListener(new ExamNoteActivity$$ExternalSyntheticLambda1(this, examNoteActivity$showDialog$1$1));
            examNoteActivity$showDialog$1$1.binding.tvCancel.setOnClickListener(new ExamNoteActivity$$ExternalSyntheticLambda0(examNoteActivity$showDialog$1$1));
            this.mStartDialog = (BaseBindDialog) examNoteActivity$showDialog$1$1;
        }
        BaseBindDialog<DialogStartExamBinding> baseBindDialog = this.mStartDialog;
        TextView textView = null;
        if (!(baseBindDialog == null || (dialogStartExamBinding = baseBindDialog.binding) == null)) {
            textView = dialogStartExamBinding.tvDialogSubtitle;
        }
        if (textView != null) {
            textView.setText(getString(R.string.start_exam_subtitle, new Object[]{this.mDuration}));
        }
        BaseBindDialog<DialogStartExamBinding> baseBindDialog2 = this.mStartDialog;
        if (baseBindDialog2 != null) {
            baseBindDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-13$lambda-12$lambda-10  reason: not valid java name */
    public static final void m472showDialog$lambda13$lambda12$lambda10(ExamNoteActivity examNoteActivity, ExamNoteActivity$showDialog$1$1 examNoteActivity$showDialog$1$1, View view) {
        Intrinsics.checkNotNullParameter(examNoteActivity, "this$0");
        Intrinsics.checkNotNullParameter(examNoteActivity$showDialog$1$1, "$this_apply");
        examNoteActivity.jumpToWeb();
        examNoteActivity$showDialog$1$1.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-13$lambda-12$lambda-11  reason: not valid java name */
    public static final void m473showDialog$lambda13$lambda12$lambda11(ExamNoteActivity$showDialog$1$1 examNoteActivity$showDialog$1$1, View view) {
        Intrinsics.checkNotNullParameter(examNoteActivity$showDialog$1$1, "$this_apply");
        examNoteActivity$showDialog$1$1.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void jumpToWeb() {
        Bundle bundle = new Bundle();
        bundle.putString("jump_key", this.mUrl);
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(getApplicationContext())).build());
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
        finish();
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ExamNoteActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.iv_back;
        if (valueOf != null && valueOf.intValue() == i) {
            finish();
        } else {
            int i2 = R.id.tv_start;
            if (valueOf != null && valueOf.intValue() == i2) {
                Integer num = this.mExamStatus;
                if (num != null && num.intValue() == 2 && Intrinsics.areEqual((Object) this.mLimitTime, (Object) true)) {
                    showDialog();
                } else {
                    jumpToWeb();
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ExamNoteActivity.super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }
}
