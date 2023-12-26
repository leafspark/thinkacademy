package com.tal.app.thinkacademy.live.business.redpackage.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.constants.MediaControlConstants;
import com.tal.app.thinkacademy.live.business.redpackage.IActionListener;
import com.tal.app.thinkacademy.live.business.redpackage.bean.RedPacketBean;
import com.tal.app.thinkacademy.live.business.redpackage.driver.BaseRedPacketPluginDriver;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class RedPacketPluginView extends BaseLivePluginView {
    /* access modifiers changed from: private */
    public static Tag TAG = Tag.RED_PACKAGE;
    /* access modifiers changed from: private */
    public IActionListener actionListener;
    private ConstraintLayout clReceive;
    /* access modifiers changed from: private */
    public BaseRedPacketPluginDriver driver;
    /* access modifiers changed from: private */
    public Handler handler;
    private boolean isAlsoFly;
    /* access modifiers changed from: private */
    public boolean isHome;
    /* access modifiers changed from: private */
    public ImageView ivSmall;
    private ImageView ivWindowClose;
    /* access modifiers changed from: private */
    public LottieAnimationView lavRedPackage;
    /* access modifiers changed from: private */
    public LottieAnimationView lottieReceive;
    private ValueAnimator mAlphaAnimator;
    /* access modifiers changed from: private */
    public RedPacketBean mRedPacketBean;
    private RedPackageRainViewModel mViewModel;
    /* access modifiers changed from: private */
    public boolean needAnimation;
    /* access modifiers changed from: private */
    public TextView tvOopsDesc;
    /* access modifiers changed from: private */
    public TextView tvOopsTitle;
    /* access modifiers changed from: private */
    public TextView tvReceiveCoins;
    /* access modifiers changed from: private */
    public View vBg;

    public RedPacketPluginView(Context context) {
        super(context);
    }

    public RedPacketPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedPacketPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        if (PadUtils.isPad(this.mContext)) {
            return R.layout.live_business_redpacket_view_pad;
        }
        return R.layout.live_business_redpacket_view;
    }

    public void setDriver(BaseRedPacketPluginDriver baseRedPacketPluginDriver) {
        this.driver = baseRedPacketPluginDriver;
    }

    public void initViews() {
        this.vBg = findViewById(R.id.v_live_business_redpacket_bg);
        this.lavRedPackage = findViewById(R.id.lav_live_business_redpacket);
        this.clReceive = findViewById(R.id.cl_live_business_redpacket_oops);
        this.tvOopsTitle = (TextView) findViewById(R.id.tv_live_business_redpacket_oops_title);
        this.tvOopsDesc = (TextView) findViewById(R.id.tv_live_business_redpacket_oops_desc);
        this.lottieReceive = findViewById(R.id.lottie_redpacket_oops);
        this.ivWindowClose = (ImageView) findViewById(R.id.iv_live_business_redpacket_window_close);
        this.tvReceiveCoins = (TextView) findViewById(R.id.tv_live_business_redpacket_oops_coins);
        this.ivSmall = (ImageView) findViewById(R.id.iv_live_business_redpacket_small);
        this.mViewModel = RedPackageRainViewModelKt.getRedPackageRainViewModel(AbilityPack.get());
        initAnim();
        openRedPacket();
        closeRedPackageWindow();
    }

    public void initData() {
        this.handler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                AsynchronousInstrumentation.handlerMessageBegin(this, message);
                super.handleMessage(message);
                AsynchronousInstrumentation.handlerMessageEnd();
            }
        };
        startTimeToAnimationSet();
    }

    public void layoutView(LiveAreaContext liveAreaContext) {
        LiveAreaLayoutParams pptLp = liveAreaContext.getPptLp();
        ConstraintLayout.LayoutParams layoutParams = this.vBg.getLayoutParams();
        pptLp.mergeLp(layoutParams);
        this.vBg.setLayoutParams(layoutParams);
        if (LiveAreaCompat.isSmallPad()) {
            ConstraintLayout.LayoutParams layoutParams2 = this.ivSmall.getLayoutParams();
            layoutParams2.setMarginEnd(liveAreaContext.getFuncLp().width + SizeUtils.dp2px(20.0f));
            this.ivSmall.setLayoutParams(layoutParams2);
        }
    }

    private void startTimeToAnimationSet() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                if (!RedPacketPluginView.this.isHome) {
                    RedPacketPluginView redPacketPluginView = RedPacketPluginView.this;
                    redPacketPluginView.redPackage2IconAnimationSet(redPacketPluginView.lavRedPackage, MediaControlConstants.DURATION_MEDIA_CONTROL_ANIM);
                    return;
                }
                boolean unused = RedPacketPluginView.this.needAnimation = true;
                RedPacketPluginView.this.startTimeToCloseRedPacket();
            }
        }, 5000);
    }

    public void setActionListener(IActionListener iActionListener) {
        this.actionListener = iActionListener;
    }

    /* access modifiers changed from: private */
    public void redPackage2IconAnimationSet(View view, final int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{SizeUtils.dp2px(222.0f), SizeUtils.dp2px(80.0f)});
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{SizeUtils.dp2px(264.0f), SizeUtils.dp2px(100.0f)});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConstraintLayout.LayoutParams layoutParams = RedPacketPluginView.this.lavRedPackage.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RedPacketPluginView.this.lavRedPackage.setLayoutParams(layoutParams);
            }
        });
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConstraintLayout.LayoutParams layoutParams = RedPacketPluginView.this.lavRedPackage.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RedPacketPluginView.this.lavRedPackage.setLayoutParams(layoutParams);
            }
        });
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        int dp2px = ((pptLp.width / 2) - SizeUtils.dp2px(40.0f)) - this.ivSmall.getLayoutParams().getMarginEnd();
        int dp2px2 = ((pptLp.height / 2) - SizeUtils.dp2px(40.0f)) - SizeUtils.dp2px(40.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{0.0f, (float) dp2px});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f, (float) dp2px2});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration((long) i);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofInt).with(ofInt2);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                RedPacketPluginView.this.lavRedPackage.cancelAnimation();
                RedPacketPluginView.this.lavRedPackage.setVisibility(8);
                RedPacketPluginView.this.vBg.setVisibility(4);
                RedPacketPluginView.this.ivSmall.setVisibility(0);
                if (i > 1) {
                    RedPacketPluginView.this.startTimeToCloseRedPacket();
                }
            }
        });
    }

    private void initAnim() {
        this.lottieReceive.setImageAssetsFolder("redpacket/images");
        this.lottieReceive.setAnimation("redpacket/dakaihou.json");
        this.lavRedPackage.setImageAssetsFolder("redpacket/images");
        this.lavRedPackage.setAnimation("redpacket/weidakai.json");
        this.lavRedPackage.playAnimation();
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(500);
        this.mAlphaAnimator = duration;
        duration.addUpdateListener(new RedPacketPluginView$$ExternalSyntheticLambda0(this));
        this.mAlphaAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                RedPacketPluginView.this.tvOopsTitle.setAlpha(1.0f);
                RedPacketPluginView.this.tvReceiveCoins.setAlpha(1.0f);
                RedPacketPluginView.this.tvOopsDesc.setAlpha(1.0f);
            }
        });
    }

    public /* synthetic */ void lambda$initAnim$0$RedPacketPluginView(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.tvOopsTitle.setAlpha(floatValue);
        if (this.tvReceiveCoins.getVisibility() == 0) {
            this.tvReceiveCoins.setAlpha(floatValue);
        }
        if (this.tvOopsDesc.getVisibility() == 0) {
            this.tvOopsDesc.setAlpha(floatValue);
        }
    }

    private void initRedPacketFlowLottie() {
        this.lavRedPackage.setImageAssetsFolder("redpacket_flow/images");
        this.lavRedPackage.setAnimation("redpacket_flow/data.json");
        this.lavRedPackage.setRepeatCount(-1);
        this.lavRedPackage.playAnimation();
    }

    private void openRedPacket() {
        RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(this.lavRedPackage, new Function0<Unit>() {
            public Unit invoke() {
                XesLog.a(RedPacketPluginView.TAG, "打开红包");
                if (RedPacketPluginView.this.actionListener != null) {
                    RedPacketPluginView.this.driver.track_click_redPacket(1);
                    RedPacketPluginView.this.actionListener.openIt();
                }
                if (RedPacketPluginView.this.handler != null) {
                    RedPacketPluginView.this.handler.removeCallbacksAndMessages((Object) null);
                }
                return null;
            }
        });
        RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(this.ivSmall, new Function0<Unit>() {
            public Unit invoke() {
                XesLog.a(RedPacketPluginView.TAG, "打开缩小红包");
                if (RedPacketPluginView.this.actionListener != null) {
                    RedPacketPluginView.this.driver.track_click_redPacket(1);
                    RedPacketPluginView.this.actionListener.openIt();
                }
                if (RedPacketPluginView.this.handler != null) {
                    RedPacketPluginView.this.handler.removeCallbacksAndMessages((Object) null);
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void startTimeToCloseRedPacket() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() {
                public void run() {
                    XesLog.i(RedPacketPluginView.TAG, "红包30秒倒计时结束，关闭互动");
                    if (RedPacketPluginView.this.actionListener != null) {
                        RedPacketPluginView.this.actionListener.closePlugin();
                    }
                    boolean unused = RedPacketPluginView.this.needAnimation = false;
                }
            }, 30000);
        }
    }

    private void receiveItToCloseRedPacket() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() {
                public void run() {
                    if (RedPacketPluginView.this.actionListener != null) {
                        RedPacketPluginView.this.actionListener.closePlugin();
                    }
                    boolean unused = RedPacketPluginView.this.needAnimation = false;
                }
            }, 5000);
        }
    }

    public void receiveIt(final RedPacketBean redPacketBean) {
        XesLog.i(TAG, "渲染抢到红包动画");
        this.mRedPacketBean = redPacketBean;
        this.lavRedPackage.setVisibility(8);
        this.ivSmall.setVisibility(8);
        this.vBg.setVisibility(0);
        this.clReceive.setVisibility(0);
        this.tvOopsTitle.setText(R.string.red_package_get_coins);
        this.tvReceiveCoins.setVisibility(0);
        this.tvOopsDesc.setVisibility(8);
        this.lottieReceive.playAnimation();
        this.lottieReceive.addAnimatorListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                RedPacketPluginView.this.notifyCoinChange(redPacketBean);
            }
        });
        this.ivWindowClose.setVisibility(0);
        this.tvReceiveCoins.setText(getContext().getString(R.string.add_coins, new Object[]{Integer.valueOf(redPacketBean.getCoin())}));
        ValueAnimator valueAnimator = this.mAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public void notifyCoinChange(RedPacketBean redPacketBean) {
        this.clReceive.setVisibility(8);
        this.ivWindowClose.setVisibility(8);
        this.driver.updateUserCoins(redPacketBean.getCoin());
        IActionListener iActionListener = this.actionListener;
        if (iActionListener != null) {
            iActionListener.closePlugin();
        }
        this.needAnimation = false;
    }

    public void ooPs() {
        this.lavRedPackage.setVisibility(8);
        this.ivSmall.setVisibility(8);
        this.vBg.setVisibility(0);
        this.clReceive.setVisibility(0);
        this.tvOopsTitle.setText(R.string.oops);
        this.tvReceiveCoins.setVisibility(8);
        this.tvOopsDesc.setVisibility(0);
        this.ivWindowClose.setVisibility(0);
        ValueAnimator valueAnimator = this.mAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        receiveItToCloseRedPacket();
    }

    private void closeRedPackageWindow() {
        this.ivWindowClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, RedPacketPluginView.class);
                XesLog.a(RedPacketPluginView.TAG, "点击红包关闭按钮");
                if (RedPacketPluginView.this.lottieReceive.isAnimating() && RedPacketPluginView.this.mRedPacketBean != null) {
                    RedPacketPluginView.this.lottieReceive.cancelAnimation();
                    RedPacketPluginView redPacketPluginView = RedPacketPluginView.this;
                    redPacketPluginView.notifyCoinChange(redPacketPluginView.mRedPacketBean);
                } else if (RedPacketPluginView.this.actionListener != null) {
                    RedPacketPluginView.this.actionListener.onFlyFinish();
                    RedPacketPluginView.this.actionListener.closePlugin();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void destroy() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
        ValueAnimator valueAnimator = this.mAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAlphaAnimator = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        RedPacketPluginView.super.onAttachedToWindow();
        this.driver.track_show_redPacket();
    }

    public void onWindowFocusChanged(boolean z) {
        RedPacketPluginView.super.onWindowFocusChanged(z);
        if (z) {
            this.isHome = false;
            if (this.needAnimation) {
                redPackage2IconAnimationSet(this.lavRedPackage, 1);
                this.needAnimation = false;
                return;
            }
            return;
        }
        this.isHome = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        RedPacketPluginView.super.onDetachedFromWindow();
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
    }
}
