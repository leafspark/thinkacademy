package com.tal.app.thinkacademy.live.business.videocall.pager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;

public class VideoCallPager extends BaseVideoCallPager {
    private boolean isTarget = false;
    /* access modifiers changed from: private */
    public LinearLayout lyVideoContainerSmall;
    private Function<Void, Void> mBackPressCallback;
    /* access modifiers changed from: private */
    public String mCameraAvailable;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public TextView mVideoCallJoinTv;
    /* access modifiers changed from: private */
    public final LiveAreaLayoutParams pptLp;
    private int raiseHandState;
    private RelativeLayout rlVideoContainerP;
    private int speakingState;
    private TextView tvAction;
    /* access modifiers changed from: private */
    public TextView tvClassName;
    /* access modifiers changed from: private */
    public ImageView tvNoStream;
    /* access modifiers changed from: private */
    public TextView tvNoStreamBg;
    /* access modifiers changed from: private */
    public TextView tvOnCallUserState;
    private TextView tvRaiseHand;
    /* access modifiers changed from: private */
    public ImageView tvSpeakerIcon;
    /* access modifiers changed from: private */
    public ImageView tvSpeakerIconSmall;
    /* access modifiers changed from: private */
    public TextView tvSpeakerName;
    /* access modifiers changed from: private */
    public TextView tvSpeakerNameSmall;
    /* access modifiers changed from: private */
    public ImageView tvToBigIcon;
    /* access modifiers changed from: private */
    public ImageView tvToSmallIcon;

    public void setHandNumVisible(boolean z) {
    }

    public void setToSmallIconVisibility(boolean z) {
    }

    public void updateHandNum(int i) {
    }

    public VideoCallPager(Context context, boolean z) {
        super(context, z);
        this.mContext = context;
        this.pptLp = LiveAreaContext.get().getPptLp();
    }

    public int getLayoutId() {
        return R.layout.live_business_videocall_layout;
    }

    public void initView() {
        this.mVideoCallJoinTv = (TextView) findViewById(R.id.live_business_video_call_join);
        this.tvSpeakerName = (TextView) findViewById(R.id.live_business_video_call_name);
        this.tvSpeakerIcon = (ImageView) findViewById(R.id.live_business_video_call_icon);
        this.tvClassName = (TextView) findViewById(R.id.live_business_video_call_course_name);
        this.tvRaiseHand = (TextView) findViewById(R.id.live_business_video_call_bt);
        this.flVideoContainer = (FrameLayout) findViewById(R.id.rl_live_business_videocall_video_2);
        this.rlVideoContainerP = (RelativeLayout) findViewById(R.id.rl_live_business_videocall_video_1);
        this.tvOnCallUserState = (TextView) findViewById(R.id.live_business_video_call_wait);
        this.tvToSmallIcon = (ImageView) findViewById(R.id.live_business_video_tosmall);
        this.tvNoStream = (ImageView) findViewById(R.id.live_business_video_call_photo);
        this.tvNoStreamBg = (TextView) findViewById(R.id.live_business_video_call_photo_bg);
        this.tvAction = (TextView) findViewById(R.id.tv_live_business_video_call_action);
        this.tvToSmallIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, VideoCallPager.class);
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{SizeUtils.dp2px(340.0f), SizeUtils.dp2px(145.0f)});
                ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{SizeUtils.dp2px(270.0f), SizeUtils.dp2px(54.0f)});
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoCallPager.this.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.gravity = 80;
                        layoutParams.setMarginStart(((VideoCallPager.this.pptLp.left + VideoCallPager.this.pptLp.width) - layoutParams.width) - SizeUtils.dp2px(20.0f));
                        VideoCallPager.this.flVideoContainer.setForeground(VideoCallPager.this.mContext.getDrawable(R.drawable.live_business_video_small));
                        VideoCallPager.this.setLayoutParams(layoutParams);
                    }
                });
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoCallPager.this.getLayoutParams();
                        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.bottomMargin = SizeUtils.dp2px(20.0f);
                        if (PadUtils.isPad(VideoCallPager.this.mContext)) {
                            layoutParams.bottomMargin = SizeUtils.dp2px(61.0f) + SizeUtils.dp2px(20.0f);
                        }
                        VideoCallPager.this.setLayoutParams(layoutParams);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300);
                animatorSet.play(ofInt).with(ofInt2);
                animatorSet.start();
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        VideoCallPager.this.lyVideoContainerSmall.setVisibility(0);
                        if (VideoCallPager.this.tvSpeakerIcon != null) {
                            VideoCallPager.this.tvSpeakerIconSmall.setVisibility(VideoCallPager.this.tvSpeakerIcon.getVisibility());
                        }
                        if (VideoCallPager.this.tvSpeakerName != null) {
                            VideoCallPager.this.tvSpeakerNameSmall.setText(VideoCallPager.this.tvSpeakerName.getText());
                            if ("Me".equals(VideoCallPager.this.tvSpeakerName.getText())) {
                                VideoCallPager.this.tvSpeakerNameSmall.setBackground(VideoCallPager.this.mContext.getDrawable(R.drawable.live_business_shape_video_call_name));
                                VideoCallPager.this.tvSpeakerNameSmall.setTextColor(VideoCallPager.this.mContext.getColor(R.color.color_ffaa0a));
                            } else {
                                VideoCallPager.this.tvSpeakerNameSmall.setBackground(VideoCallPager.this.mContext.getDrawable(R.drawable.live_business_shape_video_call_other_name));
                                VideoCallPager.this.tvSpeakerNameSmall.setTextColor(VideoCallPager.this.mContext.getColor(R.color.color_172B4D));
                            }
                        }
                        VideoCallPager.this.tvToSmallIcon.setClickable(false);
                        VideoCallPager.this.tvToBigIcon.setClickable(true);
                    }
                });
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.live_business_video_tobig);
        this.tvToBigIcon = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, VideoCallPager.class);
                VideoCallPager.this.lyVideoContainerSmall.setVisibility(8);
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{SizeUtils.dp2px(145.0f), SizeUtils.dp2px(340.0f)});
                ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{SizeUtils.dp2px(54.0f), SizeUtils.dp2px(270.0f)});
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoCallPager.this.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.gravity = 80;
                        layoutParams.setMarginStart((VideoCallPager.this.pptLp.left + VideoCallPager.this.pptLp.width) - layoutParams.width);
                        VideoCallPager.this.flVideoContainer.setForeground((Drawable) null);
                        VideoCallPager.this.setLayoutParams(layoutParams);
                    }
                });
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) VideoCallPager.this.getLayoutParams();
                        layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.bottomMargin = 0;
                        if (PadUtils.isPad(VideoCallPager.this.mContext)) {
                            layoutParams.bottomMargin = SizeUtils.dp2px(61.0f);
                        }
                        VideoCallPager.this.setLayoutParams(layoutParams);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300);
                animatorSet.play(ofInt).with(ofInt2);
                animatorSet.start();
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        VideoCallPager.this.tvToSmallIcon.setClickable(true);
                    }
                });
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.lyVideoContainerSmall = (LinearLayout) findViewById(R.id.live_business_video_small_layout);
        this.tvSpeakerNameSmall = (TextView) findViewById(R.id.live_business_video_call_name_small);
        this.tvSpeakerIconSmall = (ImageView) findViewById(R.id.live_business_video_call_icon_small);
        this.rlVideoContainerP.getLayoutParams().width = SizeUtils.dp2px(276.0f);
        this.rlVideoContainerP.getLayoutParams().height = SizeUtils.dp2px(155.0f);
    }

    /* access modifiers changed from: protected */
    public void initVideoViewSize() {
        this.videoViewWidth = SizeUtils.dp2px(340.0f);
        this.videoViewHeight = SizeUtils.dp2px(270.0f);
    }

    public void setRaiseHandClickListener(View.OnClickListener onClickListener) {
        this.tvRaiseHand.setOnClickListener(onClickListener);
        this.tvRaiseHand.setClickable(true);
        this.tvAction.setOnClickListener(onClickListener);
    }

    public void setOnBackPressListener(Function<Void, Void> function) {
        this.mBackPressCallback = function;
    }

    public void showVideoMask(final boolean z, final int i) {
        this.tvOnCallUserState.post(new Runnable() {
            public void run() {
                VideoCallPager.this.mVideoCallJoinTv.setVisibility(z ? 0 : 8);
                int i = i;
                if (i == 1 || i == 2) {
                    if (!z) {
                        VideoCallPager.this.tvToSmallIcon.setVisibility(0);
                    } else {
                        VideoCallPager.this.tvToSmallIcon.setVisibility(8);
                    }
                    if (!"2".equals(VideoCallPager.this.mCameraAvailable)) {
                        VideoCallPager.this.tvNoStream.setVisibility(8);
                        VideoCallPager.this.tvNoStreamBg.setVisibility(8);
                        VideoCallPager.this.tvOnCallUserState.setVisibility(4);
                        VideoCallPager.this.tvOnCallUserState.setText("");
                        return;
                    }
                    VideoCallPager.this.tvOnCallUserState.setVisibility(8);
                    VideoCallPager.this.tvNoStream.setVisibility(0);
                    VideoCallPager.this.tvNoStreamBg.setVisibility(0);
                } else if (i == 3) {
                    VideoCallPager.this.tvToSmallIcon.setVisibility(0);
                    VideoCallPager.this.tvNoStream.setVisibility(8);
                    VideoCallPager.this.tvNoStreamBg.setVisibility(8);
                    VideoCallPager.this.tvOnCallUserState.setVisibility(0);
                    VideoCallPager.this.tvOnCallUserState.setText(R.string.video_call_wrong);
                }
            }
        });
    }

    public void setSpeaker(final String str, final String str2, final String str3, boolean z) {
        this.isTarget = z;
        ((Activity) this.mContext).runOnUiThread(new Runnable() {
            public void run() {
                VideoCallPager.this.tvSpeakerName.setText(str);
                VideoCallPager.this.tvClassName.setText(str2);
                String unused = VideoCallPager.this.mCameraAvailable = str3;
                if (VideoCallPager.this.lyVideoContainerSmall.getVisibility() == 0 && VideoCallPager.this.tvSpeakerName != null && VideoCallPager.this.tvSpeakerNameSmall != null) {
                    VideoCallPager.this.tvSpeakerNameSmall.setText(VideoCallPager.this.tvSpeakerName.getText());
                    if ("Me".equals(VideoCallPager.this.tvSpeakerName.getText())) {
                        VideoCallPager.this.tvSpeakerNameSmall.setBackground(VideoCallPager.this.mContext.getDrawable(R.drawable.live_business_shape_video_call_name));
                        VideoCallPager.this.tvSpeakerNameSmall.setTextColor(VideoCallPager.this.mContext.getColor(R.color.color_ffaa0a));
                        VideoCallPager.this.tvSpeakerIconSmall.setVisibility(0);
                        VideoCallPager.this.setActionSpeaking();
                        return;
                    }
                    VideoCallPager.this.tvSpeakerNameSmall.setBackground(VideoCallPager.this.mContext.getDrawable(R.drawable.live_business_shape_video_call_other_name));
                    VideoCallPager.this.tvSpeakerNameSmall.setTextColor(VideoCallPager.this.mContext.getColor(R.color.color_172B4D));
                    VideoCallPager.this.tvSpeakerIconSmall.setVisibility(8);
                    VideoCallPager.this.setActionRaiseHand();
                }
            }
        });
    }

    public void setSpeakingStateView(int i, boolean z) {
        if (i == 0) {
            this.mVideoCallJoinTv.setVisibility(0);
            this.tvOnCallUserState.setVisibility(8);
            if (z) {
                this.tvRaiseHand.setVisibility(0);
                this.tvSpeakerName.setVisibility(8);
                this.tvSpeakerIcon.setVisibility(8);
                this.tvClassName.setVisibility(8);
                return;
            }
            this.tvRaiseHand.setVisibility(8);
            this.tvSpeakerName.setVisibility(0);
            this.tvSpeakerIcon.setVisibility(0);
            this.tvClassName.setVisibility(8);
        } else if (i == 1) {
            this.mVideoCallJoinTv.setVisibility(8);
            this.tvOnCallUserState.setVisibility(8);
            this.tvRaiseHand.setVisibility(8);
            this.tvSpeakerName.setBackground(this.mContext.getDrawable(R.drawable.live_business_shape_video_call_name));
            this.tvSpeakerName.setTextColor(this.mContext.getColor(R.color.color_ffaa0a));
            this.tvSpeakerName.setVisibility(0);
            this.tvSpeakerIcon.setVisibility(0);
            this.tvClassName.setVisibility(8);
            setActionSpeaking();
        } else {
            this.mVideoCallJoinTv.setVisibility(8);
            this.tvOnCallUserState.setVisibility(8);
            this.tvRaiseHand.setVisibility(8);
            this.tvSpeakerName.setBackground(this.mContext.getDrawable(R.drawable.live_business_shape_video_call_other_name));
            this.tvSpeakerName.setTextColor(this.mContext.getColor(R.color.color_172B4D));
            this.tvSpeakerName.setVisibility(0);
            this.tvSpeakerIcon.setVisibility(8);
            this.tvClassName.setVisibility(8);
            if (this.raiseHandState == 0) {
                setActionRaiseHand();
            } else {
                setActionCancel();
            }
        }
    }

    public void setRaiseHandStateView(int i, boolean z) {
        if (!z) {
            if (i == 0) {
                this.tvRaiseHand.setBackground(this.mContext.getResources().getDrawable(R.drawable.live_business_shape_video_call_join));
                this.tvRaiseHand.setTextColor(-1);
                this.tvRaiseHand.setText(this.mContext.getResources().getString(R.string.video_call_join));
            } else if (i == 1) {
                this.tvRaiseHand.setBackground(this.mContext.getResources().getDrawable(R.drawable.live_business_shape_video_call_cancel));
                this.tvRaiseHand.setTextColor(-22006);
                this.tvRaiseHand.setText(this.mContext.getResources().getString(R.string.video_call_join_cancel));
                this.mVideoCallJoinTv.setVisibility(8);
                if (!"2".equals(this.mCameraAvailable) && this.tvOnCallUserState.getVisibility() == 8) {
                    this.tvOnCallUserState.setVisibility(0);
                    this.tvToSmallIcon.setVisibility(8);
                    this.tvNoStream.setVisibility(8);
                    this.tvNoStreamBg.setVisibility(8);
                }
                this.tvOnCallUserState.setText(R.string.video_call_wait);
            } else if (i == 2) {
                this.tvRaiseHand.setClickable(false);
                this.tvRaiseHand.setBackgroundColor(-1);
                this.tvRaiseHand.setTextColor(-7628367);
                this.tvRaiseHand.setText(this.mContext.getResources().getString(R.string.video_call_has_cancel));
                this.mVideoCallJoinTv.setVisibility(8);
                if (this.tvOnCallUserState.getVisibility() == 8) {
                    this.tvOnCallUserState.setVisibility(0);
                    this.tvToSmallIcon.setVisibility(8);
                    this.tvNoStream.setVisibility(8);
                    this.tvNoStreamBg.setVisibility(8);
                }
                this.tvOnCallUserState.setText(R.string.video_call_wait);
            }
        } else if (i == 0) {
            setActionRaiseHand();
        } else {
            setActionCancel();
        }
    }

    public void updateUIisSpeaking(int i, int i2, boolean z) {
        XesLog.dt("speakingState=" + i + ", raiseHandState=" + i2 + ", joinedRTC=" + z, new Object[0]);
        this.speakingState = i;
        this.raiseHandState = i2;
        setSpeakingStateView(i, z);
        setRaiseHandStateView(i2, true);
    }

    public void updateUI(int i, int i2, boolean z, boolean z2) {
        XesLog.dt("speakingState=" + i + ", raiseHandState=" + i2 + ", joinedRTC=" + z, new Object[0]);
        this.isTarget = z2;
        this.speakingState = i;
        this.raiseHandState = i2;
        setSpeakingStateView(i, z);
        setRaiseHandStateView(i2, false);
    }

    public void setActionRaiseHand() {
        if (!this.isTarget) {
            this.tvAction.setVisibility(0);
            this.tvAction.setSelected(false);
            this.tvAction.setText(R.string.video_call_join);
            return;
        }
        this.tvAction.setVisibility(4);
    }

    public void setActionCancel() {
        if (!this.isTarget) {
            this.tvAction.setVisibility(0);
            this.tvAction.setSelected(true);
            this.tvAction.setText(R.string.video_call_join_cancel);
            return;
        }
        this.tvAction.setVisibility(4);
    }

    public void setActionSpeaking() {
        if (!this.isTarget) {
            this.tvAction.setVisibility(0);
            this.tvAction.setSelected(true);
            this.tvAction.setText(R.string.speaking);
            return;
        }
        this.tvAction.setVisibility(4);
    }
}
