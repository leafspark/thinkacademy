package com.tal.app.thinkacademy.business.study.study.speaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundTextView;
import com.gyf.immersionbar.ImmersionBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.entity.Question;
import com.tal.app.thinkacademy.business.study.study.entity.RecordHomework;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedPaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.ExamQuestionAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.ExamNoteVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityRecordedExamNoteBinding;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001$B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedExamNoteActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/ExamNoteVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityRecordedExamNoteBinding;", "Landroid/view/View$OnClickListener;", "()V", "headBinding", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityExamNoteHeaderBinding;", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/ExamQuestionAdapter;", "mExpirationTime", "", "mJumpParams", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;", "mUrl", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "getData", "", "init", "initImmersionBar", "jumpToWeb", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setBackParams", "startObserve", "updateValues", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedPaperDetailEntity;", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedExamNoteActivity.kt */
public final class RecordedExamNoteActivity extends BaseVmActivity<ExamNoteVM, ActivityRecordedExamNoteBinding> implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityExamNoteHeaderBinding headBinding;
    private ExamQuestionAdapter mAdapter;
    private String mExpirationTime = "";
    private RecordHomework mJumpParams;
    private String mUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedExamNoteActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RecordedExamNoteActivity() {
        XesDataBus.with("sync_homework_success").observe((LifecycleOwner) this, new RecordedExamNoteActivity$special$$inlined$observe$1(this));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedExamNoteActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "expirationTime", "", "homework", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordHomework;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedExamNoteActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, String str, RecordHomework recordHomework) {
            Intrinsics.checkNotNullParameter(str, ClassParamsKt.EXPIRATION_TIME);
            if (context != null) {
                Intent intent = new Intent(context, RecordedExamNoteActivity.class);
                intent.putExtra(ClassParamsKt.EXPIRATION_TIME, str);
                intent.putExtra(ClassParamsKt.JUMP_PARAMS, recordHomework);
                context.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ActivityRecordedExamNoteBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityRecordedExamNoteBinding inflate = ActivityRecordedExamNoteBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        RecordedExamNoteActivity.super.onCreate(bundle);
        init();
    }

    private final void init() {
        String stringExtra;
        initImmersionBar();
        setBackParams();
        View.OnClickListener onClickListener = this;
        getBinding().ivBack.setOnClickListener(onClickListener);
        getBinding().tvStart.setOnClickListener(onClickListener);
        Intent intent = getIntent();
        String str = "";
        if (!(intent == null || (stringExtra = intent.getStringExtra(ClassParamsKt.EXPIRATION_TIME)) == null)) {
            str = stringExtra;
        }
        this.mExpirationTime = str;
        this.mJumpParams = (RecordHomework) getIntent().getSerializableExtra(ClassParamsKt.JUMP_PARAMS);
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
            int i = 0;
            String str = null;
            LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
            ExamNoteVM mViewModel = getMViewModel();
            RecordHomework recordHomework = this.mJumpParams;
            if (recordHomework != null) {
                str = recordHomework.getEntityId();
            }
            String str2 = PadUtils.isPad((Context) this) ? "4" : DbParams.GZIP_DATA_EVENT;
            RecordHomework recordHomework2 = this.mJumpParams;
            if (recordHomework2 != null) {
                i = recordHomework2.getType();
            }
            mViewModel.getRecordedPaperOverview(str, str2, 1, i);
        }
    }

    public void startObserve() {
        getMViewModel().getRecordedPaperDetail().observe((LifecycleOwner) this, new RecordedExamNoteActivity$startObserve$$inlined$observe$1(this));
    }

    /* access modifiers changed from: private */
    public final void updateValues(RecordedPaperDetailEntity recordedPaperDetailEntity) {
        BaseQuickAdapter baseQuickAdapter;
        if (recordedPaperDetailEntity != null) {
            if (this.headBinding == null) {
                this.headBinding = ActivityExamNoteHeaderBinding.inflate(getLayoutInflater());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding = this.headBinding;
            Unit unit = null;
            TextView textView = activityExamNoteHeaderBinding == null ? null : activityExamNoteHeaderBinding.tvTitle;
            if (textView != null) {
                textView.setText(recordedPaperDetailEntity.getTitle());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding2 = this.headBinding;
            TextView textView2 = activityExamNoteHeaderBinding2 == null ? null : activityExamNoteHeaderBinding2.tvDeadline;
            if (textView2 != null) {
                textView2.setText(this.mExpirationTime);
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding3 = this.headBinding;
            TextView textView3 = activityExamNoteHeaderBinding3 == null ? null : activityExamNoteHeaderBinding3.tvDuration;
            if (textView3 != null) {
                textView3.setText(recordedPaperDetailEntity.getDuration());
            }
            ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding4 = this.headBinding;
            RoundTextView roundTextView = activityExamNoteHeaderBinding4 == null ? null : activityExamNoteHeaderBinding4.tvTotalScore;
            if (roundTextView != null) {
                roundTextView.setText(getString(R.string.total_points, new Object[]{recordedPaperDetailEntity.getTotalScore()}));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(recordedPaperDetailEntity.getHomeworkUrl());
            sb.append("&token=");
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            sb.append(userInfoEntity == null ? null : userInfoEntity.getUnifiedAccessToken());
            this.mUrl = sb.toString();
            List<Question> questions = recordedPaperDetailEntity.getQuestions();
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
                ActivityExamNoteHeaderBinding activityExamNoteHeaderBinding5 = this.headBinding;
                if (!(activityExamNoteHeaderBinding5 == null || (baseQuickAdapter = this.mAdapter) == null)) {
                    LinearLayout root = activityExamNoteHeaderBinding5.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "it.root");
                    BaseQuickAdapter.setHeaderView$default(baseQuickAdapter, root, 0, 0, 6, (Object) null);
                }
                getBinding().recyclerView.setAdapter(this.mAdapter);
            }
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, RecordedExamNoteActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.iv_back;
        if (valueOf != null && valueOf.intValue() == i) {
            finish();
        } else {
            int i2 = R.id.tv_start;
            if (valueOf != null && valueOf.intValue() == i2) {
                jumpToWeb();
                finish();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    private final void jumpToWeb() {
        Bundle bundle = new Bundle();
        bundle.putString("jump_key", this.mUrl);
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(getApplicationContext())).build());
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
    }
}
