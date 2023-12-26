package com.tal.app.thinkacademy.live.business.schulte.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTablePluginBinding;
import com.tal.app.thinkacademy.live.business.schulte.api.ISceneChange;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableShowRankListBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStartBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0006\u0010 \u001a\u00020\u0016J\u001a\u0010!\u001a\u00020\u00162\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010#H\u0002J\u0006\u0010$\u001a\u00020\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u001e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u001fJC\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010)\u001a\u00020\u001f2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00160/J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\u00020\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160#H\u0002J\u000e\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\tJ\u0012\u0010=\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010>\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010@J\u001a\u0010A\u001a\u00020\u00162\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010#H\u0002J)\u0010B\u001a\u00020\u00162!\u0010C\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00160/R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTablePluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LayoutSchulteTablePluginBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBgTransition", "Landroid/graphics/drawable/TransitionDrawable;", "mCountDownSoundId", "", "Ljava/lang/Integer;", "mDialogSubmitError", "Landroid/widget/FrameLayout;", "mGameView", "Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableGameView;", "mPlayerBgm", "Landroid/media/MediaPlayer;", "mRankView", "Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableRankView;", "mResultView", "Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableResultView;", "addSceneView", "", "child", "Landroid/view/View;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroyView", "hideBaseView", "end", "Lkotlin/Function0;", "hideSubmitError", "initData", "loadBaseView", "difficultLevel", "sequenceType", "random", "loadGameView", "level", "category", "", "complete", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "score", "loadRankView", "rankList", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableShowRankListBean;", "loadResultView", "userData", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "playCountDown", "countDownEnd", "refreshLayout", "height", "removeSceneView", "setBaseView", "game", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "showBaseView", "showSubmitError", "click", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginView.kt */
public final class SchulteTablePluginView extends BaseInteractBoxPluginView<LayoutSchulteTablePluginBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "插件视图";
    private static final Tag TAG = Tag.SCHULTE_TABLE;
    /* access modifiers changed from: private */
    public TransitionDrawable mBgTransition;
    private Integer mCountDownSoundId;
    private FrameLayout mDialogSubmitError;
    /* access modifiers changed from: private */
    public SchulteTableGameView mGameView;
    /* access modifiers changed from: private */
    public MediaPlayer mPlayerBgm;
    private SchulteTableRankView mRankView;
    /* access modifiers changed from: private */
    public SchulteTableResultView mResultView;

    public final void loadBaseView(int i, int i2, boolean z) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTablePluginView(Context context) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTablePluginView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTablePluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void initData() {
        SchulteTablePluginView.super.initData();
        MediaPlayer create = MediaPlayer.create(this.mContext, R.raw.live_business_schulte_bg);
        this.mPlayerBgm = create;
        if (create != null) {
            create.setLooping(true);
        }
        this.mBgTransition = new TransitionDrawable(new Drawable[]{ContextCompat.getDrawable(this.mContext, R.drawable.bg_schulte_table), ContextCompat.getDrawable(this.mContext, R.drawable.bg_schulte_table_blur)});
        this.mBinding.ivSchulteTableBg.setImageDrawable(this.mBgTransition);
    }

    public final void setBaseView(SchulteTableStartBean schulteTableStartBean) {
        int i;
        Context context;
        int i2;
        Context context2;
        if ((schulteTableStartBean == null ? null : schulteTableStartBean.getLevel()) != null && schulteTableStartBean.getCategory() != null && schulteTableStartBean.getRandom() != null) {
            this.mBinding.tvShculteTitle.setText(R.string.schulte_table);
            this.mBinding.tvShculteLevel.setText(R.string.schulte_table);
            if (Intrinsics.areEqual(schulteTableStartBean.getCategory(), "1")) {
                context = getContext();
                i = R.string.schulte_table_number_natural;
            } else {
                context = getContext();
                i = R.string.schulte_table_number_prime;
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "if (game.category == \"1\"…umber_prime\n            )");
            if (schulteTableStartBean.getRandom().booleanValue()) {
                context2 = getContext();
                i2 = R.string.schulte_table_mode_random;
            } else {
                context2 = getContext();
                i2 = R.string.schulte_table_mode_normall;
            }
            String string2 = context2.getString(i2);
            Intrinsics.checkNotNullExpressionValue(string2, "if (game.random) context…ode_normall\n            )");
            this.mBinding.tvShculteLevel.setText(getContext().getString(R.string.schulte_table_level_description, new Object[]{schulteTableStartBean.getLevel().toString(), schulteTableStartBean.getLevel().toString(), string, string2}));
        }
    }

    public final void loadGameView(int i, String str, boolean z, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "complete");
        XesLog.i(TAG, SUB_TAG, "加载游戏视图 level = " + i + " , category = " + str + " , random = " + z);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mGameView = new SchulteTableGameView(context, (ViewGroup) this, i, str, z, function1);
        playCountDown(new SchulteTablePluginView$loadGameView$1(this));
    }

    public final void loadResultView(SchulteTableUserDataBean schulteTableUserDataBean) {
        Unit unit;
        Intrinsics.checkNotNullParameter(schulteTableUserDataBean, "userData");
        XesLog.i(TAG, SUB_TAG, Intrinsics.stringPlus("加载结果展示视图 userData = ", schulteTableUserDataBean));
        MediaPlayer mediaPlayer = this.mPlayerBgm;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        Function0 schulteTablePluginView$loadResultView$next$1 = new SchulteTablePluginView$loadResultView$next$1(this, schulteTableUserDataBean);
        SchulteTableGameView schulteTableGameView = this.mGameView;
        if (schulteTableGameView == null) {
            unit = null;
        } else {
            schulteTableGameView.hide(new SchulteTablePluginView$loadResultView$1(this, schulteTablePluginView$loadResultView$next$1));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SchulteTablePluginView schulteTablePluginView = this;
            schulteTablePluginView$loadResultView$next$1.invoke();
        }
        this.mBinding.tvShculteDesc.setText(R.string.schulte_table_result_hint);
    }

    public final void loadRankView(SchulteTableShowRankListBean schulteTableShowRankListBean) {
        Intrinsics.checkNotNullParameter(schulteTableShowRankListBean, "rankList");
        XesLog.i(TAG, SUB_TAG, Intrinsics.stringPlus("加载准备调起排行榜，rankList = ", schulteTableShowRankListBean));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SchulteTableRankView schulteTableRankView = new SchulteTableRankView(context, schulteTableShowRankListBean);
        this.mRankView = schulteTableRankView;
        addSceneView((View) schulteTableRankView);
        SchulteTableRankView schulteTableRankView2 = this.mRankView;
        if (schulteTableRankView2 != null) {
            ISceneChange.DefaultImpls.show$default(schulteTableRankView2, (Function0) null, 1, (Object) null);
        }
        SchulteTableGameView schulteTableGameView = this.mGameView;
        if (schulteTableGameView != null) {
            schulteTableGameView.destroy();
            removeSceneView(schulteTableGameView.getMRootView());
        }
        if (this.mBinding.lottieResultRibbon.getVisibility() != 0) {
            this.mBinding.lottieResultRibbon.setVisibility(0);
        }
        if (!this.mBinding.lottieResultRibbon.isAnimating()) {
            this.mBinding.lottieResultRibbon.playAnimation();
        }
    }

    public final void showSubmitError(Function1<? super String, Unit> function1) {
        TextView textView;
        Intrinsics.checkNotNullParameter(function1, "click");
        XesLog.i(TAG, SUB_TAG, "显示提交异常弹窗");
        if (this.mDialogSubmitError == null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            int i = R.layout.layout_schulte_table_game_submit_error;
            ViewGroup viewGroup = (ViewGroup) this;
            FrameLayout frameLayout = (FrameLayout) (!(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false));
            this.mDialogSubmitError = frameLayout;
            if (!(frameLayout == null || (textView = (TextView) frameLayout.findViewById(R.id.dialog_common_btn_confirm)) == null)) {
                textView.setOnClickListener(new SchulteTablePluginView$$ExternalSyntheticLambda0(function1));
            }
            addView(this.mDialogSubmitError);
        }
        FrameLayout frameLayout2 = this.mDialogSubmitError;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showSubmitError$lambda-2  reason: not valid java name */
    public static final void m432showSubmitError$lambda2(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$click");
        function1.invoke("手动");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void hideSubmitError() {
        XesLog.i(TAG, SUB_TAG, "隐藏提交异常弹窗");
        FrameLayout frameLayout = this.mDialogSubmitError;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    static /* synthetic */ void hideBaseView$default(SchulteTablePluginView schulteTablePluginView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        schulteTablePluginView.hideBaseView(function0);
    }

    private final void hideBaseView(Function0<Unit> function0) {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator animate2 = this.mBinding.layoutBaseView.animate();
        if (animate2 != null) {
            animate2.cancel();
        }
        if (!(function0 == null || (animate = this.mBinding.layoutBaseView.animate()) == null)) {
            animate.setListener(new SchulteTablePluginView$hideBaseView$1$1(this, function0));
        }
        ViewPropertyAnimator animate3 = this.mBinding.layoutBaseView.animate();
        if (animate3 != null && (alpha = animate3.alpha(0.0f)) != null && (duration = alpha.setDuration(200)) != null) {
            duration.start();
        }
    }

    static /* synthetic */ void showBaseView$default(SchulteTablePluginView schulteTablePluginView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        schulteTablePluginView.showBaseView(function0);
    }

    private final void showBaseView(Function0<Unit> function0) {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator animate2 = this.mBinding.layoutBaseView.animate();
        if (animate2 != null) {
            animate2.cancel();
        }
        if (!(function0 == null || (animate = this.mBinding.layoutBaseView.animate()) == null)) {
            animate.setListener(new SchulteTablePluginView$showBaseView$1$1(this, function0));
        }
        ViewPropertyAnimator animate3 = this.mBinding.layoutBaseView.animate();
        if (animate3 != null && (alpha = animate3.alpha(1.0f)) != null && (duration = alpha.setDuration(200)) != null) {
            duration.start();
        }
    }

    private final void playCountDown(Function0<Unit> function0) {
        this.mBinding.lottieLoading.removeAllAnimatorListeners();
        this.mBinding.lottieLoading.addAnimatorListener(new SchulteTablePluginView$playCountDown$1(this, function0));
        this.mCountDownSoundId = Integer.valueOf(SoundPoolUtils.play(this.mContext, R.raw.live_business_schulte_countdown, 0));
        this.mBinding.lottieLoading.playAnimation();
    }

    public final void refreshLayout(int i) {
        int dp2px = SizeUtils.dp2px(323.0f);
        float f = (((float) i) * 1.0f) / ((float) dp2px);
        ViewScaleUtil.scale(this.mBinding.getRoot(), f, 0, 0);
        XesLog.i(TAG, SUB_TAG, "ppt高 = " + i + " , 设计稿宽 = " + dp2px + " , 缩放" + f + 20493);
    }

    public final void destroyView() {
        XesLog.i(TAG, SUB_TAG, "销毁");
        Integer num = this.mCountDownSoundId;
        if (num != null) {
            SoundPoolUtils.stop(num.intValue());
        }
        MediaPlayer mediaPlayer = this.mPlayerBgm;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mPlayerBgm = null;
        this.mBinding.lottieResultRibbon.cancelAnimation();
        SchulteTableGameView schulteTableGameView = this.mGameView;
        if (schulteTableGameView != null) {
            schulteTableGameView.destroy();
        }
        SchulteTableResultView schulteTableResultView = this.mResultView;
        if (schulteTableResultView != null) {
            schulteTableResultView.destroy();
        }
        SchulteTableRankView schulteTableRankView = this.mRankView;
        if (schulteTableRankView != null) {
            schulteTableRankView.destroy();
        }
        removeAllViews();
    }

    /* access modifiers changed from: private */
    public final void addSceneView(View view) {
        if (view != null) {
            this.mBinding.layoutSceneContainer.addView(view);
        }
    }

    /* access modifiers changed from: private */
    public final void removeSceneView(View view) {
        if (view != null) {
            this.mBinding.layoutSceneContainer.removeView(view);
        }
    }

    /* access modifiers changed from: protected */
    public LayoutSchulteTablePluginBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutSchulteTablePluginBinding inflate = LayoutSchulteTablePluginBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
