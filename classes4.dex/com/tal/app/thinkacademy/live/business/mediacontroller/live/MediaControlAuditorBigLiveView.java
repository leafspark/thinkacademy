package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.wheel.timer.MessageHandler;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;

public class MediaControlAuditorBigLiveView extends BaseMediaControlView {
    private ImageView mIvScreenShot;

    public MediaControlAuditorBigLiveView(Context context, DataStorage dataStorage) {
        super(context);
        initListener();
        setTitle(dataStorage.getPlanInfo().getName());
    }

    public void initViews() {
        super.initViews();
        this.topRoot = findViewById(R.id.rl_media_controller_root_top);
        this.mIvScreenShot = (ImageView) findViewById(R.id.iv_live_business_screenshot);
        this.mTimeout = MessageHandler.WHAT_ITEM_SELECTED;
        setContentLayoutParams();
        this.mIvScreenShot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlAuditorBigLiveView.class);
                MediaControlAuditorBigLiveView.this.driver.screenShot(ScreenShotToken.FEEDBACK);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void hide() {
        super.hide();
        lambda$new$1$BaseMediaControlView();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_view_media_controller_auditor_big_live;
    }

    public void setContentLayoutParams() {
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topRoot.getLayoutParams();
        LiveAreaLayoutParams screenLp = LiveAreaContext.get().getScreenLp();
        layoutParams.width = screenLp.width;
        layoutParams.setMarginStart(screenLp.left);
        this.topRoot.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivPreview.getLayoutParams();
        layoutParams2.setMarginStart((pptLp.left + pptLp.width) - SizeUtils.dp2px(180.0f));
        layoutParams2.bottomMargin = SizeUtils.dp2px(90.0f);
        layoutParams2.gravity = 80;
        this.ivPreview.setLayoutParams(layoutParams2);
    }

    public void startAnim(boolean z) {
        int i;
        if (this.topRoot != null) {
            this.topRoot.clearAnimation();
            if (z) {
                i = 0;
            } else {
                i = -this.topRoot.getHeight();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.topRoot, "translationY", new float[]{this.topRoot.getTranslationY(), (float) i});
            ofFloat.setDuration(300);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                }
            });
            ofFloat.start();
        }
    }
}
