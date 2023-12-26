package com.tal.app.thinkacademy.business.study.study.speaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Question;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.QuestionAdapter;
import com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PreviewQuestionVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionBinding;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionHeaderBinding;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/PreviewQuestionActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PreviewQuestionVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityPreviewQuestionBinding;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/QuestionAdapter;", "mDuration", "mHeaderViewBinding", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityPreviewQuestionHeaderBinding;", "mJumpParams", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "mStartDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mStatus", "", "mStatusExpired", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "init", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showDialog", "startObserve", "track", "key", "updateValues", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewQuestionActivity.kt */
public final class PreviewQuestionActivity extends BaseVmActivity<PreviewQuestionVM, ActivityPreviewQuestionBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String TAG = "PreviewQuestionActivity";
    private QuestionAdapter mAdapter;
    private String mDuration = "";
    private ActivityPreviewQuestionHeaderBinding mHeaderViewBinding;
    /* access modifiers changed from: private */
    public JumpParamsEntity mJumpParams;
    private BaseDialog mStartDialog;
    /* access modifiers changed from: private */
    public int mStatus;
    private boolean mStatusExpired;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreviewQuestionActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nJ+\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/PreviewQuestionActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "statusExpired", "", "startActivityWithStatus", "status", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;Ljava/lang/Integer;)V", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreviewQuestionActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, JumpParamsEntity jumpParamsEntity, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.startActivity(context, jumpParamsEntity, z);
        }

        public final void startActivity(Context context, JumpParamsEntity jumpParamsEntity, boolean z) {
            if (context != null) {
                Intent intent = new Intent(context, PreviewQuestionActivity.class);
                intent.putExtra("jumpParams", jumpParamsEntity);
                intent.putExtra("statusExpired", z);
                context.startActivity(intent);
            }
        }

        public static /* synthetic */ void startActivityWithStatus$default(Companion companion, Context context, JumpParamsEntity jumpParamsEntity, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = 0;
            }
            companion.startActivityWithStatus(context, jumpParamsEntity, num);
        }

        public final void startActivityWithStatus(Context context, JumpParamsEntity jumpParamsEntity, Integer num) {
            if (context != null) {
                Intent intent = new Intent(context, PreviewQuestionActivity.class);
                intent.putExtra("jumpParams", jumpParamsEntity);
                intent.putExtra("status", num);
                context.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PreviewQuestionActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, getColor(R.color.white), false);
        init();
    }

    /* access modifiers changed from: protected */
    public ActivityPreviewQuestionBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityPreviewQuestionBinding inflate = ActivityPreviewQuestionBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getPaperDetailData().observe(lifecycleOwner, new PreviewQuestionActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().getJumpUrl().observe(lifecycleOwner, new PreviewQuestionActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m479startObserve$lambda0(PreviewQuestionActivity previewQuestionActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(previewQuestionActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            previewQuestionActivity.getBinding().loadStatusView.restoreView();
            previewQuestionActivity.getBinding().llContent.setVisibility(0);
            previewQuestionActivity.updateValues((PaperDetailEntity) stateData.getData());
            return;
        }
        LoadStatusView loadStatusView = previewQuestionActivity.getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        String msg = stateData.getMsg();
        if (msg == null) {
            msg = previewQuestionActivity.getString(R.string.study_center_data_error);
            Intrinsics.checkNotNullExpressionValue(msg, "getString(R.string.study_center_data_error)");
        }
        LoadStatusView.showErrorView$default(loadStatusView, 0, msg, (String) null, (String) null, new PreviewQuestionActivity$startObserve$1$1(previewQuestionActivity), 13, (Object) null);
        ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        String str = previewQuestionActivity.TAG;
        XesLog.it(str, new Object[]{stateData.getCode() + "  " + stateData.getMsg()});
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m480startObserve$lambda1(PreviewQuestionActivity previewQuestionActivity, StateData stateData) {
        Integer planId;
        Intrinsics.checkNotNullParameter(previewQuestionActivity, "this$0");
        previewQuestionActivity.hideLoading();
        int i = 0;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("jump_key", (String) stateData.getData());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(previewQuestionActivity.getApplicationContext())).build());
            JumpParamsEntity jumpParamsEntity = previewQuestionActivity.mJumpParams;
            Integer num = null;
            bundle.putString("homework_id", jumpParamsEntity == null ? null : jumpParamsEntity.getHomeworkId());
            JumpParamsEntity jumpParamsEntity2 = previewQuestionActivity.mJumpParams;
            if (jumpParamsEntity2 != null) {
                num = jumpParamsEntity2.getClassId();
            }
            bundle.putString(ClassParamsKt.CLASS_ID, String.valueOf(num));
            JumpParamsEntity jumpParamsEntity3 = previewQuestionActivity.mJumpParams;
            if (!(jumpParamsEntity3 == null || (planId = jumpParamsEntity3.getPlanId()) == null)) {
                i = planId.intValue();
            }
            bundle.putInt("plan_id", i);
            bundle.putInt("homework_type", 1);
            XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
            previewQuestionActivity.finish();
            return;
        }
        previewQuestionActivity.showToast(previewQuestionActivity.getString(R.string.net_fail));
        String str = previewQuestionActivity.TAG;
        XesLog.it(str, new Object[]{stateData.getCode() + "  " + stateData.getMsg()});
    }

    private final void init() {
        this.mJumpParams = (JumpParamsEntity) getIntent().getSerializableExtra("jumpParams");
        this.mStatusExpired = getIntent().getBooleanExtra("statusExpired", false);
        int intExtra = getIntent().getIntExtra("status", 6);
        this.mStatus = intExtra;
        this.mStatusExpired = intExtra == 6;
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        Integer num = null;
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        PreviewQuestionVM mViewModel = getMViewModel();
        JumpParamsEntity jumpParamsEntity = this.mJumpParams;
        String homeworkId = jumpParamsEntity == null ? null : jumpParamsEntity.getHomeworkId();
        JumpParamsEntity jumpParamsEntity2 = this.mJumpParams;
        if (jumpParamsEntity2 != null) {
            num = jumpParamsEntity2.getPlanId();
        }
        mViewModel.getPaperDetail(homeworkId, num);
        TitleBar titleBar = getBinding().previewTitleBar;
        if (titleBar != null) {
            titleBar.setOnTitleBarListener(new PreviewQuestionActivity$init$1(this));
        }
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvStart;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvStart");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new PreviewQuestionActivity$init$2(this), 1, (Object) null);
    }

    private final void updateValues(PaperDetailEntity paperDetailEntity) {
        BaseQuickAdapter baseQuickAdapter;
        List<Question> list = null;
        this.mDuration = String.valueOf(paperDetailEntity == null ? null : paperDetailEntity.getDuration());
        if (this.mHeaderViewBinding == null) {
            PreviewQuestionActivity previewQuestionActivity = this;
            this.mHeaderViewBinding = ActivityPreviewQuestionHeaderBinding.inflate(getLayoutInflater());
        }
        if (this.mStatusExpired) {
            ActivityPreviewQuestionHeaderBinding activityPreviewQuestionHeaderBinding = this.mHeaderViewBinding;
            ConstraintLayout constraintLayout = activityPreviewQuestionHeaderBinding == null ? null : activityPreviewQuestionHeaderBinding.layoutExpired;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        }
        int i = this.mStatus;
        if (4 <= i && i < 7) {
            getBinding().tvStart.setText(getString(R.string.solutions));
        }
        ActivityPreviewQuestionHeaderBinding activityPreviewQuestionHeaderBinding2 = this.mHeaderViewBinding;
        TagTextView tagTextView = activityPreviewQuestionHeaderBinding2 == null ? null : activityPreviewQuestionHeaderBinding2.tvTitle;
        if (tagTextView != null) {
            tagTextView.setText(paperDetailEntity == null ? null : paperDetailEntity.getTitle());
        }
        ActivityPreviewQuestionHeaderBinding activityPreviewQuestionHeaderBinding3 = this.mHeaderViewBinding;
        TextView textView = activityPreviewQuestionHeaderBinding3 == null ? null : activityPreviewQuestionHeaderBinding3.tvDeadline;
        if (textView != null) {
            textView.setText(paperDetailEntity == null ? null : paperDetailEntity.getDeadline());
        }
        ActivityPreviewQuestionHeaderBinding activityPreviewQuestionHeaderBinding4 = this.mHeaderViewBinding;
        TextView textView2 = activityPreviewQuestionHeaderBinding4 == null ? null : activityPreviewQuestionHeaderBinding4.tvDuration;
        if (textView2 != null) {
            textView2.setText(paperDetailEntity == null ? null : paperDetailEntity.getDuration());
        }
        ActivityPreviewQuestionHeaderBinding activityPreviewQuestionHeaderBinding5 = this.mHeaderViewBinding;
        RoundTextView roundTextView = activityPreviewQuestionHeaderBinding5 == null ? null : activityPreviewQuestionHeaderBinding5.tvTotalScore;
        if (roundTextView != null) {
            int i2 = R.string.total_points;
            Object[] objArr = new Object[1];
            objArr[0] = paperDetailEntity == null ? null : paperDetailEntity.getTotalScore();
            roundTextView.setText(getString(i2, objArr));
        }
        if (this.mAdapter == null) {
            PreviewQuestionActivity previewQuestionActivity2 = this;
            if (paperDetailEntity != null) {
                list = paperDetailEntity.getQuestions();
            }
            if (list != null) {
                List<Question> questions = paperDetailEntity.getQuestions();
                Objects.requireNonNull(questions, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tal.app.thinkacademy.business.study.study.entity.Question>");
                this.mAdapter = new QuestionAdapter(TypeIntrinsics.asMutableList(questions));
                Context context = (Context) this;
                getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(context));
                RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.item_divider_question);
                Intrinsics.checkNotNull(drawable);
                dividerItemDecoration.setDrawable(drawable);
                getBinding().recyclerView.addItemDecoration(dividerItemDecoration);
                ActivityPreviewQuestionHeaderBinding activityPreviewQuestionHeaderBinding6 = this.mHeaderViewBinding;
                if (!(activityPreviewQuestionHeaderBinding6 == null || (baseQuickAdapter = this.mAdapter) == null)) {
                    LinearLayout root = activityPreviewQuestionHeaderBinding6.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "it.root");
                    BaseQuickAdapter.setHeaderView$default(baseQuickAdapter, root, 0, 0, 6, (Object) null);
                }
                getBinding().recyclerView.setAdapter(this.mAdapter);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showDialog() {
        if (this.mStartDialog == null) {
            BaseDialog baseDialog = new BaseDialog((Context) this);
            baseDialog.contentView(R.layout.dialog_start_preview).gravity(17).layoutParams(new LinearLayout.LayoutParams(-2, -2)).canceledOnTouchOutside(true);
            ((TextView) baseDialog.findViewById(R.id.tv_confirm)).setOnClickListener(new PreviewQuestionActivity$$ExternalSyntheticLambda0(this, baseDialog));
            ((TextView) baseDialog.findViewById(R.id.tv_cancel)).setOnClickListener(new PreviewQuestionActivity$$ExternalSyntheticLambda1(this, baseDialog));
            this.mStartDialog = baseDialog;
        }
        BaseDialog baseDialog2 = this.mStartDialog;
        TextView textView = baseDialog2 == null ? null : (TextView) baseDialog2.findViewById(R.id.tv_dialog_subtitle);
        if (textView != null) {
            textView.setText(getString(R.string.start_preview_subtitle, new Object[]{this.mDuration}));
        }
        BaseDialog baseDialog3 = this.mStartDialog;
        if (baseDialog3 != null) {
            baseDialog3.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-7$lambda-5  reason: not valid java name */
    public static final void m477showDialog$lambda7$lambda5(PreviewQuestionActivity previewQuestionActivity, BaseDialog baseDialog, View view) {
        Intrinsics.checkNotNullParameter(previewQuestionActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseDialog, "$this_apply");
        JumpParamsEntity jumpParamsEntity = previewQuestionActivity.mJumpParams;
        Intrinsics.checkNotNull(jumpParamsEntity);
        previewQuestionActivity.getMViewModel().getPreQuestionJumpUrl(jumpParamsEntity);
        previewQuestionActivity.showLoading();
        previewQuestionActivity.track("click_confirm");
        baseDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-7$lambda-6  reason: not valid java name */
    public static final void m478showDialog$lambda7$lambda6(PreviewQuestionActivity previewQuestionActivity, BaseDialog baseDialog, View view) {
        Intrinsics.checkNotNullParameter(previewQuestionActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseDialog, "$this_apply");
        previewQuestionActivity.track("click_cancel");
        baseDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void track(String str) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        JumpParamsEntity jumpParamsEntity = this.mJumpParams;
        Integer num = null;
        map.put(ClassParamsKt.CLASS_ID, String.valueOf(jumpParamsEntity == null ? null : jumpParamsEntity.getClassId()));
        JumpParamsEntity jumpParamsEntity2 = this.mJumpParams;
        if (jumpParamsEntity2 != null) {
            num = jumpParamsEntity2.getPlanId();
        }
        map.put("lesson_id", String.valueOf(num));
        LeanplumUtil.commonTrack(str, hashMap);
    }
}
