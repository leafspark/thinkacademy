package com.tal.app.thinkacademy.live.business.speedyhand.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeedyHandBinding;
import com.tal.app.thinkacademy.live.business.speedyhand.bean.StudentInfo;
import com.tal.app.thinkacademy.live.business.speedyhand.driver.SpeedyHandPluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J \u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\u0006\u0010+\u001a\u00020\u0019J\b\u0010,\u001a\u00020\u0019H\u0016J\u0006\u0010-\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0013J\u0006\u00102\u001a\u00020\u0019J\u000e\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u000205R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0010j\b\u0012\u0004\u0012\u00020\b`\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/view/SpeedyHandView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessSpeedyHandBinding;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "endAnimation", "Landroid/view/animation/AlphaAnimation;", "endBgAnimation", "mBackClickListener", "Landroid/view/View$OnClickListener;", "mSoundIDList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mSpeedyHandPluginDriver", "Lcom/tal/app/thinkacademy/live/business/speedyhand/driver/SpeedyHandPluginDriver;", "mSpeedyHandState", "Lcom/tal/app/thinkacademy/live/business/speedyhand/view/SpeedyHandState;", "startAnimation", "startBgAnimation", "animationEight", "", "animationFive", "animationFour", "animationOne", "animationSeven", "animationSix", "animationThree", "animationTwo", "animatorBgShow", "animatorGone", "animatorShow", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "goneSpeedyHand", "initViews", "noBodySpeedyHand", "onDestroy", "openSpeedyHand", "setDriver", "driver", "showResultAnimator", "showSpeedyHandResult", "studentInfo", "Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/StudentInfo;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandView.kt */
public final class SpeedyHandView extends BaseVBLivePluginView<LiveBusinessSpeedyHandBinding> {
    private AlphaAnimation endAnimation;
    private AlphaAnimation endBgAnimation;
    private View.OnClickListener mBackClickListener;
    private ArrayList<Integer> mSoundIDList;
    private SpeedyHandPluginDriver mSpeedyHandPluginDriver;
    /* access modifiers changed from: private */
    public SpeedyHandState mSpeedyHandState;
    private AlphaAnimation startAnimation;
    private AlphaAnimation startBgAnimation;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SpeedyHandView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SpeedyHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeedyHandView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeedyHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSoundIDList = new ArrayList<>();
        this.mSpeedyHandState = SpeedyHandState.ONE;
        this.mBackClickListener = new SpeedyHandView$$ExternalSyntheticLambda0(this, context);
    }

    /* access modifiers changed from: private */
    /* renamed from: mBackClickListener$lambda-0  reason: not valid java name */
    public static final void m438mBackClickListener$lambda0(SpeedyHandView speedyHandView, Context context, View view) {
        Intrinsics.checkNotNullParameter(speedyHandView, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        speedyHandView.mSoundIDList.add(Integer.valueOf(SoundPoolUtils.playSameTime(context, R.raw.live_business_dianji1, 0)));
        speedyHandView.animationFour();
        SpeedyHandPluginDriver speedyHandPluginDriver = speedyHandView.mSpeedyHandPluginDriver;
        if (speedyHandPluginDriver != null) {
            speedyHandPluginDriver.answerRob();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void initViews() {
        this.mBinding.lottie.setIgnoreDisabledSystemAnimations(true);
        this.mBinding.lottiePreload.setIgnoreDisabledSystemAnimations(true);
        this.mBinding.lottie.addAnimatorListener(new SpeedyHandView$initViews$1(this));
        this.mBinding.lottiePreload.addAnimatorListener(new SpeedyHandView$initViews$2(this));
    }

    public final void setDriver(SpeedyHandPluginDriver speedyHandPluginDriver) {
        Intrinsics.checkNotNullParameter(speedyHandPluginDriver, "driver");
        this.mSpeedyHandPluginDriver = speedyHandPluginDriver;
    }

    public final void openSpeedyHand() {
        animatorBgShow();
        this.mSoundIDList.add(Integer.valueOf(SoundPoolUtils.playSameTime(getContext(), R.raw.live_business_beijingyin1, -1)));
        this.mSoundIDList.add(Integer.valueOf(SoundPoolUtils.playSameTime(getContext(), R.raw.live_business_readygo1, 0)));
        this.mBinding.avator.setVisibility(8);
        this.mBinding.tvName.setVisibility(8);
        this.mBinding.tvNoBody.setVisibility(8);
        animationOne();
        ConstraintLayout constraintLayout = this.mBinding.speedyHandBg;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(getContext().getColor(R.color.color_black_70));
        }
        LottieAnimationView lottieAnimationView = this.mBinding.lottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
        }
    }

    public final void showSpeedyHandResult(StudentInfo studentInfo) {
        Intrinsics.checkNotNullParameter(studentInfo, "studentInfo");
        this.mSoundIDList.add(Integer.valueOf(SoundPoolUtils.playSameTime(getContext(), R.raw.live_business_qaingdao, 0)));
        animationSix();
        this.mBinding.tvName.setText(studentInfo.getNickName());
        this.mBinding.tvName.setVisibility(0);
        ImageView imageView = this.mBinding.avator;
        if (imageView != null) {
            XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            XesImageLoader.loadRoundCornerImage$default(xesImageLoader, imageView, context, studentInfo.getAvatar(), SizeUtils.dp2px(112.0f), 0, R.drawable.live_business_icon_speedyhand_avator_normal, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        }
        this.mBinding.avator.setVisibility(0);
        this.mBinding.tvNoBody.setVisibility(8);
    }

    public final void noBodySpeedyHand() {
        for (Number intValue : this.mSoundIDList) {
            SoundPoolUtils.stopSameTime(intValue.intValue());
        }
        this.mSoundIDList.add(Integer.valueOf(SoundPoolUtils.playSameTime(getContext(), R.raw.live_business_shibai, 0)));
        animationEight();
        this.mBinding.tvName.setVisibility(8);
        this.mBinding.avator.setVisibility(8);
        this.mBinding.tvNoBody.setVisibility(0);
    }

    public final void showResultAnimator() {
        animatorShow();
    }

    public final void goneSpeedyHand() {
        animatorGone();
    }

    private final void animationOne() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottiePreload;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottie;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setAnimation("speedyhand/01ready.json");
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottiePreload;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setAnimation("speedyhand/02go.json");
        }
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottie;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView6 = this.mBinding.lottiePreload;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.ONE;
        LottieAnimationView lottieAnimationView7 = this.mBinding.lottie;
        if (lottieAnimationView7 != null) {
            lottieAnimationView7.playAnimation();
        }
        LottieAnimationView lottieAnimationView8 = this.mBinding.lottie;
        if (lottieAnimationView8 != null) {
            lottieAnimationView8.setRepeatCount(0);
        }
        LottieAnimationView lottieAnimationView9 = this.mBinding.lottie;
        if (lottieAnimationView9 != null) {
            lottieAnimationView9.setOnClickListener((View.OnClickListener) null);
        }
        LottieAnimationView lottieAnimationView10 = this.mBinding.lottiePreload;
        if (lottieAnimationView10 != null) {
            lottieAnimationView10.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public final void animationTwo() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("speedyhand/03dianjixunhuan.json");
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottiePreload;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottie;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.Two;
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottiePreload;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.playAnimation();
        }
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottiePreload;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.setRepeatCount(0);
        }
        LottieAnimationView lottieAnimationView6 = this.mBinding.lottiePreload;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setOnClickListener(this.mBackClickListener);
        }
    }

    /* access modifiers changed from: private */
    public final void animationThree() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottiePreload;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("speedyhand/04anxia.json");
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottie;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottiePreload;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.THREE;
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottie;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.playAnimation();
        }
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottie;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView6 = this.mBinding.lottie;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setOnClickListener(this.mBackClickListener);
        }
    }

    private final void animationFour() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottiePreload;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("speedyhand/04anxia.json");
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottie;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setAnimation("speedyhand/05jiazaig.json");
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottiePreload;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottie;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.FOUR;
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottiePreload;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.playAnimation();
        }
        LottieAnimationView lottieAnimationView6 = this.mBinding.lottiePreload;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setRepeatCount(0);
        }
        LottieAnimationView lottieAnimationView7 = this.mBinding.lottie;
        if (lottieAnimationView7 != null) {
            lottieAnimationView7.setOnClickListener((View.OnClickListener) null);
        }
        LottieAnimationView lottieAnimationView8 = this.mBinding.lottiePreload;
        if (lottieAnimationView8 != null) {
            lottieAnimationView8.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public final void animationFive() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottiePreload;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("speedyhand/06qiangdao.json");
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottie;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottiePreload;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.FIVE;
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottie;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.playAnimation();
        }
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottie;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.setRepeatCount(-1);
        }
    }

    private final void animationSix() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottiePreload;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("speedyhand/06qiangdao.json");
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottie;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setAnimation("speedyhand/07qiangdaoxunhuan.json");
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottiePreload;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottie;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.SIX;
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottiePreload;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.playAnimation();
        }
        LottieAnimationView lottieAnimationView6 = this.mBinding.lottiePreload;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setRepeatCount(0);
        }
        LottieAnimationView lottieAnimationView7 = this.mBinding.lottie;
        if (lottieAnimationView7 != null) {
            lottieAnimationView7.setOnClickListener((View.OnClickListener) null);
        }
        LottieAnimationView lottieAnimationView8 = this.mBinding.lottiePreload;
        if (lottieAnimationView8 != null) {
            lottieAnimationView8.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public final void animationSeven() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottiePreload;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.SEVEN;
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottie;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.playAnimation();
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottie;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setRepeatCount(-1);
        }
    }

    private final void animationEight() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottiePreload;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("speedyhand/08wurenqiang.json");
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottiePreload;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottie;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        this.mSpeedyHandState = SpeedyHandState.EIGHT;
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottiePreload;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.playAnimation();
        }
        LottieAnimationView lottieAnimationView5 = this.mBinding.lottiePreload;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.setRepeatCount(0);
        }
        LottieAnimationView lottieAnimationView6 = this.mBinding.lottie;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setOnClickListener((View.OnClickListener) null);
        }
        LottieAnimationView lottieAnimationView7 = this.mBinding.lottiePreload;
        if (lottieAnimationView7 != null) {
            lottieAnimationView7.setOnClickListener((View.OnClickListener) null);
        }
    }

    private final void animatorShow() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(120);
        this.startAnimation = alphaAnimation;
        ImageView imageView = this.mBinding.avator;
        if (imageView != null) {
            imageView.startAnimation(this.startAnimation);
        }
        TextView textView = this.mBinding.tvName;
        if (textView != null) {
            textView.startAnimation(this.startAnimation);
        }
    }

    private final void animatorBgShow() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        alphaAnimation.setDuration(200);
        this.startBgAnimation = alphaAnimation;
        ConstraintLayout constraintLayout = this.mBinding.speedyHandBg;
        if (constraintLayout != null) {
            constraintLayout.startAnimation(this.startBgAnimation);
        }
    }

    private final void animatorGone() {
        AlphaAnimation alphaAnimation = this.startAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = this.startBgAnimation;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
        }
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation3.setDuration(120);
        this.endAnimation = alphaAnimation3;
        LottieAnimationView lottieAnimationView = this.mBinding.lottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.startAnimation(this.endAnimation);
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottiePreload;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.startAnimation(this.endAnimation);
        }
        ImageView imageView = this.mBinding.avator;
        if (imageView != null) {
            imageView.startAnimation(this.endAnimation);
        }
        TextView textView = this.mBinding.tvName;
        if (textView != null) {
            textView.startAnimation(this.endAnimation);
        }
        TextView textView2 = this.mBinding.tvNoBody;
        if (textView2 != null) {
            textView2.startAnimation(this.endAnimation);
        }
        AlphaAnimation alphaAnimation4 = new AlphaAnimation(0.7f, 0.0f);
        alphaAnimation4.setDuration(120);
        this.endBgAnimation = alphaAnimation4;
        ConstraintLayout constraintLayout = this.mBinding.speedyHandBg;
        if (constraintLayout != null) {
            constraintLayout.startAnimation(this.endBgAnimation);
        }
    }

    public final void onDestroy() {
        LottieAnimationView lottieAnimationView = this.mBinding.lottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.setOnClickListener((View.OnClickListener) null);
        }
        LottieAnimationView lottieAnimationView2 = this.mBinding.lottiePreload;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setOnClickListener((View.OnClickListener) null);
        }
        this.mBackClickListener = null;
        this.mSpeedyHandPluginDriver = null;
        LottieAnimationView lottieAnimationView3 = this.mBinding.lottie;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView4 = this.mBinding.lottiePreload;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.cancelAnimation();
        }
        for (Number intValue : this.mSoundIDList) {
            SoundPoolUtils.stopSameTime(intValue.intValue());
        }
        AlphaAnimation alphaAnimation = this.startAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        this.startAnimation = null;
        AlphaAnimation alphaAnimation2 = this.endAnimation;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
        }
        this.endAnimation = null;
        AlphaAnimation alphaAnimation3 = this.startBgAnimation;
        if (alphaAnimation3 != null) {
            alphaAnimation3.cancel();
        }
        this.startBgAnimation = null;
        AlphaAnimation alphaAnimation4 = this.endBgAnimation;
        if (alphaAnimation4 != null) {
            alphaAnimation4.cancel();
        }
        this.endBgAnimation = null;
    }

    /* access modifiers changed from: protected */
    public LiveBusinessSpeedyHandBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessSpeedyHandBinding inflate = LiveBusinessSpeedyHandBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
