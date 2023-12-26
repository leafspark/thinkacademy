package com.tal.app.thinkacademy.live.business.redpackagerain.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainCoinSettlementBinding;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainCoinSettlementListener;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0006\u0010\u001c\u001a\u00020\u0014J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0003J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0010J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainCoinSettlementPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessLayoutRedPackageRainCoinSettlementBinding;", "context", "Landroid/content/Context;", "coin", "", "(Landroid/content/Context;I)V", "getCoin", "()I", "countdownRunnable", "Ljava/lang/Runnable;", "mCountdown", "mHandler", "Landroid/os/Handler;", "mListener", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainCoinSettlementListener;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel;", "countdownEnd", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroy", "initEvent", "initView", "initializeData", "setListener", "listener", "startAnimation", "startCountdown", "unInitEvent", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainCoinSettlementPluginView.kt */
public final class RedPackageRainCoinSettlementPluginView extends BaseInteractBoxPluginView<LiveBusinessLayoutRedPackageRainCoinSettlementBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.RED_PACKAGE_RAIN;
    private final int coin;
    private final Runnable countdownRunnable;
    private int mCountdown = 3;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public RedPackageRainCoinSettlementListener mListener;
    private RedPackageRainViewModel mViewModel = AbilityPackKt.getAbilityPack().getViewModel(RedPackageRainViewModel.class);

    private final void initEvent() {
    }

    private final void unInitEvent() {
    }

    public final int getCoin() {
        return this.coin;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPackageRainCoinSettlementPluginView(Context context, int i) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.coin = i;
        initEvent();
        initView();
        initializeData();
        startAnimation();
        this.countdownRunnable = new RedPackageRainCoinSettlementPluginView$$ExternalSyntheticLambda1(this);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/view/RedPackageRainCoinSettlementPluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainCoinSettlementPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setListener(RedPackageRainCoinSettlementListener redPackageRainCoinSettlementListener) {
        Intrinsics.checkNotNullParameter(redPackageRainCoinSettlementListener, "listener");
        this.mListener = redPackageRainCoinSettlementListener;
    }

    private final void initView() {
        FrameLayout.LayoutParams newLp = LiveAreaCompat.pptCenterLp().newLp();
        ConstraintLayout.LayoutParams layoutParams = this.mBinding.ivCoinSettlementBg.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = null;
        ConstraintLayout.LayoutParams layoutParams3 = layoutParams instanceof ConstraintLayout.LayoutParams ? layoutParams : null;
        if (layoutParams3 != null) {
            layoutParams3.width = newLp.width;
        }
        if (layoutParams3 != null) {
            layoutParams3.height = newLp.height;
        }
        int i = newLp.height;
        int dimensionPixelOffset = i - getResources().getDimensionPixelOffset(R.dimen.size_10dp);
        int dimensionPixelOffset2 = ((i - getResources().getDimensionPixelOffset(R.dimen.size_10dp)) * 594) / 509;
        float f = PadUtils.isPad(getContext()) ? 0.8f : 0.9f;
        ConstraintLayout.LayoutParams layoutParams4 = this.mBinding.clCoinSettlement.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams5 = layoutParams4 instanceof ConstraintLayout.LayoutParams ? layoutParams4 : null;
        if (layoutParams5 != null) {
            layoutParams5.width = (int) (((float) dimensionPixelOffset2) * f);
        }
        if (layoutParams5 != null) {
            layoutParams5.height = (int) (((float) dimensionPixelOffset) * f);
        }
        ConstraintLayout.LayoutParams layoutParams6 = this.mBinding.rlCoin.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams7 = layoutParams6 instanceof ConstraintLayout.LayoutParams ? layoutParams6 : null;
        if (layoutParams7 != null) {
            layoutParams7.height = (int) ((((float) (dimensionPixelOffset * 78)) * f) / ((float) 509));
        }
        if (layoutParams7 != null) {
            layoutParams7.topMargin = (int) ((((float) (dimensionPixelOffset * 195)) * f) / ((float) 509));
        }
        ViewGroup.LayoutParams layoutParams8 = this.mBinding.ivCoin.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams9 = layoutParams8 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams8 : null;
        if (layoutParams9 != null) {
            layoutParams9.height = (int) ((((float) (dimensionPixelOffset * 68)) * f) / ((float) 509));
        }
        if (layoutParams9 != null) {
            layoutParams9.width = (int) ((((float) (dimensionPixelOffset * 68)) * f) / ((float) 509));
        }
        float f2 = (float) dimensionPixelOffset;
        float f3 = (float) 509;
        this.mBinding.tvCoin.setTextSize(0, ((44.0f * f2) * f) / f3);
        TextView textView = this.mBinding.tvCollectCoin;
        ConstraintLayout.LayoutParams layoutParams10 = textView.getLayoutParams();
        if (layoutParams10 instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = layoutParams10;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = (int) ((((float) (dimensionPixelOffset * 61)) * f) / f3);
        }
        if (layoutParams2 != null) {
            layoutParams2.width = (int) ((((float) (dimensionPixelOffset * 164)) * f) / f3);
        }
        if (layoutParams2 != null) {
            layoutParams2.topMargin = (int) ((((float) (dimensionPixelOffset * 301)) * f) / f3);
        }
        textView.setTextSize(0, ((f2 * 18.0f) * f) / f3);
        textView.setPadding(textView.getPaddingLeft(), (int) ((((float) (dimensionPixelOffset * 14)) * f) / f3), textView.getPaddingRight(), textView.getPaddingBottom());
        this.mBinding.tvCollectCoin.setOnTouchListener(new RedPackageRainCoinSettlementPluginView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-7  reason: not valid java name */
    public static final boolean m409initView$lambda7(RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(redPackageRainCoinSettlementPluginView, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            SoundPoolUtils.play(redPackageRainCoinSettlementPluginView.getContext(), R.raw.live_business_red_package_rain_click_collect_btn, 0);
            view.setScaleX(0.9f);
            view.setScaleY(0.9f);
            Handler handler = redPackageRainCoinSettlementPluginView.mHandler;
            if (handler != null) {
                handler.removeCallbacks(redPackageRainCoinSettlementPluginView.countdownRunnable);
            }
            redPackageRainCoinSettlementPluginView.countdownEnd();
        } else if (action == 1 || action == 3) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
        return true;
    }

    private final void initializeData() {
        TextView textView = this.mBinding.tvCollectCoin;
        StringBuilder sb = new StringBuilder();
        Resources resources = getResources();
        sb.append(resources == null ? null : resources.getString(R.string.red_package_rain_collect));
        sb.append(" (");
        sb.append(this.mCountdown);
        sb.append("S)");
        textView.setText(sb.toString());
        this.mBinding.tvCoin.setText(Intrinsics.stringPlus("+", Integer.valueOf(this.coin)));
    }

    private final void startAnimation() {
        SoundPoolUtils.play(getContext(), R.raw.live_business_red_package_rain, 0);
        this.mBinding.clCoinSettlement.post(new RedPackageRainCoinSettlementPluginView$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startAnimation$lambda-8  reason: not valid java name */
    public static final void m410startAnimation$lambda8(RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView) {
        Intrinsics.checkNotNullParameter(redPackageRainCoinSettlementPluginView, "this$0");
        ObjectAnimator duration = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "alpha", new float[]{0.0f, 1.0f}).setDuration(40);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(mBinding.clCoinS…, 0f, 1f).setDuration(40)");
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "scaleX", new float[]{0.6f, 1.1f}).setDuration(160);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(mBinding.clCoinS…        .setDuration(160)");
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "scaleY", new float[]{0.6f, 1.1f}).setDuration(160);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(mBinding.clCoinS…        .setDuration(160)");
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "scaleX", new float[]{1.1f, 0.94f}).setDuration(80);
        Intrinsics.checkNotNullExpressionValue(duration4, "ofFloat(mBinding.clCoinS…         .setDuration(80)");
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "scaleY", new float[]{1.1f, 0.94f}).setDuration(80);
        Intrinsics.checkNotNullExpressionValue(duration5, "ofFloat(mBinding.clCoinS…         .setDuration(80)");
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "scaleX", new float[]{0.94f, 1.0f}).setDuration(80);
        Intrinsics.checkNotNullExpressionValue(duration6, "ofFloat(mBinding.clCoinS…         .setDuration(80)");
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(redPackageRainCoinSettlementPluginView.mBinding.clCoinSettlement, "scaleY", new float[]{0.94f, 1.0f}).setDuration(80);
        Intrinsics.checkNotNullExpressionValue(duration7, "ofFloat(mBinding.clCoinS…         .setDuration(80)");
        AnimatorSet animatorSet = new AnimatorSet();
        Animator animator = duration2;
        animatorSet.play(duration).with(animator).with(duration3);
        Animator animator2 = duration4;
        animatorSet.play(animator2).with(duration5).after(animator);
        animatorSet.play(duration6).with(duration7).after(animator2);
        animatorSet.addListener(new RedPackageRainCoinSettlementPluginView$startAnimation$1$1(redPackageRainCoinSettlementPluginView));
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public final void startCountdown() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(this.countdownRunnable, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: countdownRunnable$lambda-10  reason: not valid java name */
    public static final void m408countdownRunnable$lambda10(RedPackageRainCoinSettlementPluginView redPackageRainCoinSettlementPluginView) {
        Intrinsics.checkNotNullParameter(redPackageRainCoinSettlementPluginView, "this$0");
        redPackageRainCoinSettlementPluginView.mCountdown--;
        TextView textView = redPackageRainCoinSettlementPluginView.mBinding.tvCollectCoin;
        StringBuilder sb = new StringBuilder();
        Resources resources = redPackageRainCoinSettlementPluginView.getResources();
        sb.append(resources == null ? null : resources.getString(R.string.red_package_rain_collect));
        sb.append(" (");
        sb.append(redPackageRainCoinSettlementPluginView.mCountdown);
        sb.append("S)");
        textView.setText(sb.toString());
        if (redPackageRainCoinSettlementPluginView.mCountdown > 0) {
            redPackageRainCoinSettlementPluginView.startCountdown();
        } else {
            redPackageRainCoinSettlementPluginView.countdownEnd();
        }
    }

    private final void countdownEnd() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mBinding.clCoinSettlement, "alpha", new float[]{1.0f, 0.0f}).setDuration(120);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(mBinding.clCoinS… 1f, 0f).setDuration(120)");
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mBinding.clCoinSettlement, "scaleX", new float[]{1.0f, 0.6f}).setDuration(120);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(mBinding.clCoinS…f, 0.6f).setDuration(120)");
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mBinding.clCoinSettlement, "scaleY", new float[]{1.0f, 0.6f}).setDuration(120);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(mBinding.clCoinS…f, 0.6f).setDuration(120)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).with(duration3);
        animatorSet.addListener(new RedPackageRainCoinSettlementPluginView$countdownEnd$1(this));
        animatorSet.start();
    }

    public final void destroy() {
        unInitEvent();
    }

    /* access modifiers changed from: protected */
    public LiveBusinessLayoutRedPackageRainCoinSettlementBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessLayoutRedPackageRainCoinSettlementBinding inflate = LiveBusinessLayoutRedPackageRainCoinSettlementBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            inf…         attach\n        )");
        return inflate;
    }
}
