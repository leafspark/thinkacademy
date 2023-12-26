package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.flyco.roundview.RoundRelativeLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import com.tal.app.thinkacademy.live.view.HandUpPadView;
import org.json.JSONObject;

public class MediaControlLiveViewPad extends MediaControllerBaseLiveView {
    private static final int BOTTOM_HEIGHT = 61;
    private RoundRelativeLayout handUpDisable;
    boolean interceptBtmMediaCtrHide;
    private ImageView mIvScreenShot;
    private RelativeLayout mRlHandUp;
    /* access modifiers changed from: private */
    public HandUpPadView mRlHandUpView;
    private ImageButton mTeacherOnlyControl;
    /* access modifiers changed from: private */
    public final Runnable tickedRefreshRunnable;

    public MediaControlLiveViewPad(Context context, DataStorage dataStorage) {
        super(context);
        AnonymousClass3 r1 = new Runnable() {
            public void run() {
                MediaControlLiveViewPad.this.mHandler.postDelayed(MediaControlLiveViewPad.this.tickedRefreshRunnable, 1000);
                MediaControlLiveViewPad.this.updateShowPlayTime();
            }
        };
        this.tickedRefreshRunnable = r1;
        initListener();
        initTitle(dataStorage);
        initPlayTime(r1);
    }

    public int getLayoutId() {
        return R.layout.live_business_view_media_controller_live_pad;
    }

    public void initViews() {
        super.initViews();
        this.interceptBtmMediaCtrHide = false;
        this.mIvScreenShot = (ImageView) findViewById(R.id.img_live_business_live_screenshot);
        this.mRlHandUp = (RelativeLayout) findViewById(R.id.rl_live_business_live_raise_your_hand);
        this.mRlHandUpView = findViewById(R.id.rl_live_business_live_handuppadview);
        this.handUpDisable = findViewById(R.id.handUpDisable);
        setContentLayoutParams();
    }

    public void setContentLayoutParams() {
        LiveAreaContext.get().getVisibleLp();
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bottomRoot.getLayoutParams();
        pptLp.mergeLp(layoutParams);
        layoutParams.bottomMargin = pptLp.bottom;
        layoutParams.height = SizeUtils.dp2px(61.0f);
        this.bottomRoot.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivPreview.getLayoutParams();
        layoutParams2.setMarginStart((pptLp.left + pptLp.width) - SizeUtils.dp2px(180.0f));
        layoutParams2.bottomMargin = SizeUtils.dp2px(90.0f);
        layoutParams2.gravity = 80;
        this.ivPreview.setLayoutParams(layoutParams2);
    }

    public void initListener() {
        super.initListener();
        this.mIvScreenShot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPad.class);
                MediaControlLiveViewPad.this.driver.screenShot(ScreenShotToken.SCREENSHOT);
                DriverTrack.INSTANCE.classroomToolbarClick("截屏");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mRlHandUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPad.class);
                if (!MediaControlLiveViewPad.this.mRlHandUpView.isHandUp()) {
                    MediaControlLiveViewPad.this.mRlHandUpView.startHandUp();
                    MediaControlLiveViewPad.this.sendFeedback(new JSONObject());
                    InteractReportKt.XesLogReport("", "stu_handsup", "", (Integer) null);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setRaiseHand(boolean z) {
        super.setRaiseHand(z);
        if (z) {
            this.mRlHandUp.setVisibility(0);
        } else {
            this.mRlHandUp.setVisibility(8);
        }
    }

    public void setGrouoVideoCall(boolean z) {
        if (z) {
            this.handUpDisable.setVisibility(0);
            this.mRlHandUpView.endHandUp();
            return;
        }
        this.handUpDisable.setVisibility(8);
    }

    public void sendFeedback(JSONObject jSONObject) {
        PluginEventBus.onEvent(DataBusKey.CLASS_HANDUP, new PluginEventData(getClass(), DataBusKey.CLASS_HANDUP, "", jSONObject));
    }

    /* access modifiers changed from: protected */
    public void buildStudentWindow() {
        super.buildStudentWindow();
        ((TextView) this.studentWindow.getContentView().findViewById(R.id.tv_live_business_student_window)).setText(R.string.group_video);
        TextView textView = (TextView) this.studentWindow.getContentView().findViewById(R.id.tv_live_business_student_teacher_only);
        textView.setText(R.string.teacher_only);
        textView.setVisibility(0);
        this.studentWindow.getContentView().findViewById(R.id.v_live_business_student_teacher_only_divider).setVisibility(0);
        if (this.mTeacherOnlyControl == null) {
            ImageButton imageButton = (ImageButton) this.studentWindow.getContentView().findViewById(R.id.sw_live_business_teacheronly_controller);
            this.mTeacherOnlyControl = imageButton;
            imageButton.setVisibility(0);
            this.mTeacherOnlyControl.setSelected(false);
            this.mTeacherOnlyControl.setOnClickListener(new MediaControlLiveViewPad$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ void lambda$buildStudentWindow$0$MediaControlLiveViewPad(View view) {
        ImageButton imageButton = this.mTeacherOnlyControl;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.driver != null) {
            this.driver.chatTeacherOnly(this.mTeacherOnlyControl.isSelected() ? "1" : EnterRoomMuteData.STATUS_UN_MUTE);
        }
        DriverTrack.INSTANCE.classRoomInteractOnlySwitch(this.mTeacherOnlyControl.isSelected() ? 1 : 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void show() {
        if (!this.interceptBtmMediaCtrHide) {
            super.show();
        }
        this.mShow = true;
        updateShowPlayTime();
    }

    public void hide() {
        if (!this.interceptBtmMediaCtrHide) {
            super.hide();
        }
        this.mShow = false;
        lambda$new$1$BaseMediaControlView();
        dismissNoHomeworkPopup();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public void interceptHideBtmMediaCtr(boolean z) {
        this.interceptBtmMediaCtrHide = z;
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

    public void onDestroy() {
        super.onDestroy();
        this.mRlHandUpView.destroy();
    }
}
