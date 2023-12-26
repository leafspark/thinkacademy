package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;

public class MediaControlSmallLiveViewPhone extends MediaControllerBaseLiveView {
    public void setStudentWindowButton(boolean z) {
    }

    public MediaControlSmallLiveViewPhone(Context context, DataStorage dataStorage) {
        super(context);
        initListener();
        initTitle(dataStorage);
    }

    public void initViews() {
        this.ivBack = (ImageView) findViewById(R.id.iv_media_controller_back);
        this.tvTitle = (TextView) findViewById(R.id.tv_media_controller_title);
        this.ivRefresh = (ImageView) findViewById(R.id.iv_media_controller_refresh);
        this.ivNetwork = (ImageView) findViewById(R.id.iv_media_controller_network);
        this.topRoot = findViewById(R.id.rl_media_controller_root_top);
        this.layoutHomework = (RelativeLayout) findViewById(R.id.layout_media_controller_homework);
        this.tvHomeworkDot = (TextView) findViewById(R.id.tv_media_controller_homework_dot);
        this.ivMore = (ImageView) findViewById(R.id.iv_media_controller_more);
        this.ivFeedback = (ImageView) findViewById(R.id.iv_media_controller_feedback);
        this.ivExamReport = (ImageView) findViewById(R.id.iv_media_controller_exam_report);
        this.ivPreview = (ImageView) findViewById(R.id.iv_live_business_media_controller_controls_preview);
        this.ivFeedback.setVisibility(0);
        this.ivMore.setVisibility(8);
        findViewById(R.id.iv_live_business_screenshot).setVisibility(8);
        setContentLayoutParams();
    }

    public void hide() {
        super.hide();
        lambda$new$1$BaseMediaControlView();
        dismissNoHomeworkPopup();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_view_media_controller_small_live_phone;
    }

    public void setContentLayoutParams() {
        LiveAreaLayoutParams visibleLp = LiveAreaContext.get().getVisibleLp();
        LiveAreaLayoutParams headLp = LiveAreaContext.get().getHeadLp();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topRoot.getLayoutParams();
        layoutParams.width = visibleLp.width;
        layoutParams.setMarginStart(visibleLp.left);
        this.topRoot.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivPreview.getLayoutParams();
        layoutParams2.gravity = 8388693;
        layoutParams2.setMarginEnd(headLp.width + SizeUtils.dp2px(20.0f) + visibleLp.left);
        layoutParams2.bottomMargin = SizeUtils.dp2px(90.0f);
        this.ivPreview.setLayoutParams(layoutParams2);
    }

    public void startAnim(boolean z) {
        int i;
        if (!this.isShowStudentWindow && this.topRoot != null) {
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

    public void dismissNoHomeworkPopup() {
        if (this.mNoHomeworkPopup != null && this.mNoHomeworkPopup.isShowing()) {
            this.mNoHomeworkPopup.dismiss();
        }
    }
}
