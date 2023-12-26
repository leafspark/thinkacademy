package com.tal.app.thinkacademy.live.business.schulte.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.schulte.api.ISceneChange;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableResultView;", "Landroid/widget/FrameLayout;", "Lcom/tal/app/thinkacademy/live/business/schulte/api/ISceneChange;", "context", "Landroid/content/Context;", "userData", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;)V", "layoutBelt", "Landroid/view/View;", "layoutBestDuration", "layoutShade", "lottieCup", "Lcom/airbnb/lottie/LottieAnimationView;", "mFadeRunnable", "Ljava/lang/Runnable;", "tvBelt", "Landroid/widget/TextView;", "tvBestTime", "tvCurTime", "tvNewRecord", "destroy", "", "hide", "end", "Lkotlin/Function0;", "show", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableResultView.kt */
public final class SchulteTableResultView extends FrameLayout implements ISceneChange {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "个人结果页";
    private static final Tag TAG = Tag.SCHULTE_TABLE;
    private final View layoutBelt;
    private final View layoutBestDuration;
    private View layoutShade;
    /* access modifiers changed from: private */
    public final LottieAnimationView lottieCup;
    private Runnable mFadeRunnable;
    private final TextView tvBelt;
    private final TextView tvBestTime;
    private final TextView tvCurTime;
    private final TextView tvNewRecord;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteTableResultView(Context context, SchulteTableUserDataBean schulteTableUserDataBean) {
        super(context);
        float f;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schulteTableUserDataBean, "userData");
        XesLog.i(TAG, SUB_TAG, "初始化布局");
        float f2 = 0.0f;
        setAlpha(0.0f);
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.layout_schulte_table_result;
        ViewGroup viewGroup = this;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i, viewGroup, true);
        } else {
            XMLParseInstrumentation.inflate(from, i, viewGroup, true);
        }
        View findViewById = findViewById(R.id.tv_result_cur_time);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_result_cur_time)");
        TextView textView = (TextView) findViewById;
        this.tvCurTime = textView;
        View findViewById2 = findViewById(R.id.tv_result_best_time);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_result_best_time)");
        TextView textView2 = (TextView) findViewById2;
        this.tvBestTime = textView2;
        View findViewById3 = findViewById(R.id.layout_result_best_time);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.layout_result_best_time)");
        this.layoutBestDuration = findViewById3;
        LottieAnimationView findViewById4 = findViewById(R.id.lottie_result_cup);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.lottie_result_cup)");
        this.lottieCup = findViewById4;
        View findViewById5 = findViewById(R.id.bg_trans_cover);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.bg_trans_cover)");
        this.layoutShade = findViewById5;
        View findViewById6 = findViewById(R.id.tv_result_belt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_result_belt)");
        TextView textView3 = (TextView) findViewById6;
        this.tvBelt = textView3;
        View findViewById7 = findViewById(R.id.layout_result_belt);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.layout_result_belt)");
        this.layoutBelt = findViewById7;
        View findViewById8 = findViewById(R.id.tv_result_new_record);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_result_new_record)");
        TextView textView4 = (TextView) findViewById8;
        this.tvNewRecord = textView4;
        boolean parseBoolean = Boolean.parseBoolean(schulteTableUserDataBean.isFirst());
        String curDuration = schulteTableUserDataBean.getCurDuration();
        Float f3 = null;
        Float floatOrNull = curDuration == null ? null : StringsKt.toFloatOrNull(curDuration);
        if (floatOrNull == null) {
            SchulteTableResultView schulteTableResultView = this;
            f = 0.0f;
        } else {
            f = floatOrNull.floatValue();
        }
        String bestDuration = schulteTableUserDataBean.getBestDuration();
        f3 = bestDuration != null ? StringsKt.toFloatOrNull(bestDuration) : f3;
        if (f3 == null) {
            SchulteTableResultView schulteTableResultView2 = this;
        } else {
            f2 = f3.floatValue();
        }
        textView.setText(f + " s");
        if (parseBoolean) {
            textView3.setText(context.getString(R.string.schulte_table_first_challenge));
            textView4.setText(R.string.schulte_table_first_challenge);
            textView4.setVisibility(0);
            return;
        }
        if (f < f2) {
            textView4.setText(R.string.schulte_table_new_record);
            textView4.setVisibility(0);
            textView3.setText(context.getString(R.string.schulte_table_new_record_s, new Object[]{String.valueOf(f)}));
        } else {
            textView3.setText(context.getString(R.string.schulte_table_game_completed));
        }
        findViewById3.setVisibility(0);
        textView2.setText(f2 + " s");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/view/SchulteTableResultView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SchulteTableResultView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void show(Function0<Unit> function0) {
        XesLog.i(TAG, SUB_TAG, "显示");
        SoundPoolUtils.playSameTime(getContext(), R.raw.live_business_schulte_result, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(200);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.layoutBelt, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat2.setDuration(200);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "beltEnterAnimator");
        Animator animator = ofFloat2;
        animator.addListener(new SchulteTableResultView$show$$inlined$addListener$default$1(this));
        Keyframe ofFloat3 = Keyframe.ofFloat(0.0f, 1.5f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.45f, 0.8f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.81f, 1.05f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[]{ofFloat3, ofFloat4, ofFloat5, ofFloat6});
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{ofFloat3, ofFloat4, ofFloat5, ofFloat6});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.tvBelt, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(tvBelt, scaleX, scaleY)");
        Animator animator2 = ofPropertyValuesHolder;
        animator2.setDuration(440);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.lottieCup, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat7.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator).with(animator2).after(ofFloat).before(ofFloat7);
        animatorSet.start();
        Runnable runnable = this.mFadeRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            return;
        }
        SchulteTableResultView$$ExternalSyntheticLambda0 schulteTableResultView$$ExternalSyntheticLambda0 = new SchulteTableResultView$$ExternalSyntheticLambda0(this);
        this.mFadeRunnable = schulteTableResultView$$ExternalSyntheticLambda0;
        postDelayed(schulteTableResultView$$ExternalSyntheticLambda0, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-3  reason: not valid java name */
    public static final void m435show$lambda3(SchulteTableResultView schulteTableResultView) {
        Intrinsics.checkNotNullParameter(schulteTableResultView, "this$0");
        schulteTableResultView.lottieCup.cancelAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(schulteTableResultView.layoutBelt, FrameLayout.ALPHA, new float[]{1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(layoutBelt, ALPHA, 1f, 0f)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(schulteTableResultView.lottieCup, FrameLayout.ALPHA, new float[]{1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(lottieCup, ALPHA, 1f, 0f)");
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(schulteTableResultView.layoutShade, FrameLayout.ALPHA, new float[]{1.0f, 0.0f});
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(layoutShade, ALPHA, 1f, 0f)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.start();
    }

    public void hide(Function0<Unit> function0) {
        XesLog.i(TAG, SUB_TAG, "隐藏");
    }

    public void destroy() {
        XesLog.i(TAG, SUB_TAG, "销毁");
        Runnable runnable = this.mFadeRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }
}
