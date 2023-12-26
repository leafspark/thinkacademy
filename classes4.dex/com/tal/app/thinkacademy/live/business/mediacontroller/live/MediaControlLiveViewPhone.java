package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate.BigClassTitleBarBarDelegate;
import com.tal.app.thinkacademy.live.business.raisehand.RaiseHandUtil;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import com.tal.app.thinkacademy.live.view.HandUpPhoneView;
import kotlin.Pair;
import org.json.JSONObject;

public class MediaControlLiveViewPhone extends MediaControllerBaseLiveView {
    private TextView closeTV;
    private RoundLinearLayout handUpDisable;
    private Handler handler;
    boolean interceptBtmMediaCtrHide;
    private TextView ircConnectingTV;
    /* access modifiers changed from: private */
    public boolean isShowTeacherOnlyWindow;
    /* access modifiers changed from: private */
    public boolean isTeacherOnly;
    /* access modifiers changed from: private */
    public ImageView ivHotWord;
    private ImageView ivScreenShot;
    private ImageView ivTeacherOnly;
    /* access modifiers changed from: private */
    public LinearLayout llMsgInput;
    /* access modifiers changed from: private */
    public HandUpPhoneView mHandUp;
    /* access modifiers changed from: private */
    public IircControllerProvider mIircControllerProvider;
    /* access modifiers changed from: private */
    public boolean mShow;
    private RelativeLayout msgGroupInputRL;
    /* access modifiers changed from: private */
    public TextView msgPrivateInputTV;
    /* access modifiers changed from: private */
    public ImageButton switchTeacherOnly;
    /* access modifiers changed from: private */
    public EasyPopup teacherOnlyWindow;
    /* access modifiers changed from: private */
    public final Runnable tickedRefreshRunnable;
    /* access modifiers changed from: private */
    public TextView tvSaySomething;

    public MediaControlLiveViewPhone(Context context, DataStorage dataStorage) {
        super(context);
        AnonymousClass11 r1 = new Runnable() {
            public void run() {
                MediaControlLiveViewPhone.this.mHandler.postDelayed(MediaControlLiveViewPhone.this.tickedRefreshRunnable, 1000);
                if (MediaControlLiveViewPhone.this.mShow) {
                    MediaControlLiveViewPhone.this.updateShowPlayTime();
                }
            }
        };
        this.tickedRefreshRunnable = r1;
        initListener();
        initTitle(dataStorage);
        initPlayTime(r1);
    }

    public int getLayoutId() {
        return R.layout.live_business_view_media_controller_live_phone;
    }

    public void initViews() {
        super.initViews();
        this.interceptBtmMediaCtrHide = false;
        this.ivScreenShot = (ImageView) findViewById(R.id.iv_live_business_screenshot);
        this.msgGroupInputRL = (RelativeLayout) findViewById(R.id.rl_live_business_live_msg_input_group);
        this.llMsgInput = (LinearLayout) findViewById(R.id.ll_live_business_live_msg_input);
        this.ivHotWord = (ImageView) findViewById(R.id.iv_live_business_live_msg_reply);
        this.tvSaySomething = (TextView) findViewById(R.id.tv_say_something);
        this.ivTeacherOnly = (ImageView) findViewById(R.id.iv_live_business_live_msg_teacher_only);
        this.closeTV = (TextView) findViewById(R.id.tv_close);
        this.ircConnectingTV = (TextView) findViewById(R.id.tv_irc_connecting);
        this.msgPrivateInputTV = (TextView) findViewById(R.id.tv_live_business_live_msg_input_private);
        this.mHandUp = findViewById(R.id.rl_live_business_live_raise_your_hand);
        this.handUpDisable = findViewById(R.id.handUpDisable);
        setContentLayoutParams();
        setTeacherOnlyButton();
    }

    public void setContentLayoutParams() {
        LiveAreaLayoutParams visibleLp = LiveAreaContext.get().getVisibleLp();
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        LiveAreaLayoutParams headLp = LiveAreaContext.get().getHeadLp();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topRoot.getLayoutParams();
        layoutParams.width = visibleLp.width;
        layoutParams.setMarginStart(visibleLp.left);
        this.topRoot.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bottomRoot.getLayoutParams();
        pptLp.mergeLp(layoutParams2);
        layoutParams2.height = SizeUtils.dp2px(85.0f);
        this.bottomRoot.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ivPreview.getLayoutParams();
        layoutParams3.gravity = 8388693;
        layoutParams3.setMarginEnd(headLp.width + SizeUtils.dp2px(20.0f) + visibleLp.left);
        layoutParams3.bottomMargin = SizeUtils.dp2px(90.0f);
        this.ivPreview.setLayoutParams(layoutParams3);
    }

    public void initListener() {
        super.initListener();
        this.ivScreenShot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                MediaControlLiveViewPhone.this.driver.screenShot(ScreenShotToken.SCREENSHOT);
                DriverTrack.INSTANCE.classroomToolbarClick("截屏");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.ivHotWord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Pair<Boolean, Long> isFrequently;
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                if (MediaControlLiveViewPhone.this.driver == null || !(MediaControlLiveViewPhone.this.driver.getDelegate() instanceof BigClassTitleBarBarDelegate) || (isFrequently = ((BigClassTitleBarBarDelegate) MediaControlLiveViewPhone.this.driver.getDelegate()).isFrequently()) == null || !((Boolean) isFrequently.getFirst()).booleanValue()) {
                    MediaControlLiveViewPhone.this.driver.hotWord();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                    return;
                }
                MediaControlLiveViewPhone.this.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.llMsgInput.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Pair<Boolean, Long> isFrequently;
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                if (MediaControlLiveViewPhone.this.driver == null || !(MediaControlLiveViewPhone.this.driver.getDelegate() instanceof BigClassTitleBarBarDelegate) || (isFrequently = ((BigClassTitleBarBarDelegate) MediaControlLiveViewPhone.this.driver.getDelegate()).isFrequently()) == null || !((Boolean) isFrequently.getFirst()).booleanValue()) {
                    MediaControlLiveViewPhone.this.driver.showInputKeyboardView();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                    return;
                }
                MediaControlLiveViewPhone.this.showSendFrequently(((Long) isFrequently.getSecond()).longValue());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.msgPrivateInputTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Pair<Boolean, Long> isFrequently;
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                if (MediaControlLiveViewPhone.this.driver == null || !(MediaControlLiveViewPhone.this.driver.getDelegate() instanceof BigClassTitleBarBarDelegate) || (isFrequently = ((BigClassTitleBarBarDelegate) MediaControlLiveViewPhone.this.driver.getDelegate()).isFrequently()) == null || !((Boolean) isFrequently.getFirst()).booleanValue()) {
                    MediaControlLiveViewPhone.this.driver.showInputKeyboardView();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                    return;
                }
                MediaControlLiveViewPhone.this.showPrivateSendFrequently(((Long) isFrequently.getSecond()).longValue());
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.ivTeacherOnly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                if (!MediaControlLiveViewPhone.this.teacherOnlyWindow.isShowing()) {
                    boolean unused = MediaControlLiveViewPhone.this.isShowTeacherOnlyWindow = true;
                    MediaControlLiveViewPhone.this.teacherOnlyWindow.showAtAnchorView(view, 1, 4, (-SizeUtils.dp2px(147.0f)) + view.getMeasuredWidth(), -SizeUtils.dp2px(10.0f));
                    DriverTrack.INSTANCE.classRoomInteractOnlyShow();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mHandUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                if (!MediaControlLiveViewPhone.this.mHandUp.isHandUp()) {
                    MediaControlLiveViewPhone.this.mHandUp.startHandUp();
                    MediaControlLiveViewPhone.this.sendFeedback(new JSONObject());
                    InteractReportKt.XesLogReport("", "stu_handsup", "", (Integer) null);
                    if (MediaControlLiveViewPhone.this.mIircControllerProvider == null) {
                        MediaControlLiveViewPhone mediaControlLiveViewPhone = MediaControlLiveViewPhone.this;
                        IircControllerProvider unused = mediaControlLiveViewPhone.mIircControllerProvider = mediaControlLiveViewPhone.mILiveRoomProvider.getIrcControllerProvider();
                    }
                    RaiseHandUtil.sendRaiseHandMsg(MediaControlLiveViewPhone.this.mIircControllerProvider);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void showSendFrequently(long j) {
        this.tvSaySomething.setTextColor(getResources().getColor(R.color.COLOR_FFAA0A));
        this.tvSaySomething.setText(R.string.sending_too_often);
        this.tvSaySomething.setTextSize(0, (float) getResources().getDimensionPixelOffset(R.dimen.size_13dp));
        this.llMsgInput.setEnabled(false);
        this.ivHotWord.setEnabled(false);
        this.ivHotWord.setImageResource(R.drawable.live_business_icon_live_msg_hot_word_unable);
        if (this.handler == null) {
            this.handler = new Handler(Looper.myLooper());
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                MediaControlLiveViewPhone.this.tvSaySomething.setTextColor(MediaControlLiveViewPhone.this.getResources().getColor(R.color.COLOR_DEE2E7));
                MediaControlLiveViewPhone.this.tvSaySomething.setText(R.string.say_something);
                MediaControlLiveViewPhone.this.tvSaySomething.setTextSize(0, (float) MediaControlLiveViewPhone.this.getResources().getDimensionPixelOffset(R.dimen.size_14dp));
                MediaControlLiveViewPhone.this.llMsgInput.setEnabled(true);
                MediaControlLiveViewPhone.this.ivHotWord.setEnabled(true);
                MediaControlLiveViewPhone.this.ivHotWord.setImageResource(R.drawable.live_business_icon_live_msg_revicer_src);
            }
        }, j);
    }

    public void showPrivateSendFrequently(long j) {
        this.msgPrivateInputTV.setEnabled(false);
        this.msgPrivateInputTV.setTextColor(getResources().getColor(R.color.COLOR_FFAA0A));
        this.msgPrivateInputTV.setText(R.string.sending_too_often);
        this.msgPrivateInputTV.setTextSize(0, (float) getResources().getDimensionPixelOffset(R.dimen.size_13dp));
        if (this.handler == null) {
            this.handler = new Handler(Looper.myLooper());
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                MediaControlLiveViewPhone.this.msgPrivateInputTV.setTextColor(MediaControlLiveViewPhone.this.getResources().getColor(R.color.COLOR_DEE2E7));
                MediaControlLiveViewPhone.this.msgPrivateInputTV.setText(R.string.say_something);
                MediaControlLiveViewPhone.this.msgPrivateInputTV.setEnabled(true);
                MediaControlLiveViewPhone.this.msgPrivateInputTV.setTextSize(0, (float) MediaControlLiveViewPhone.this.getResources().getDimensionPixelOffset(R.dimen.size_14dp));
            }
        }, j);
    }

    public void setRaiseHand(boolean z) {
        super.setRaiseHand(z);
        if (z) {
            this.mHandUp.setVisibility(0);
        } else {
            this.mHandUp.setVisibility(8);
        }
    }

    public void setGrouoVideoCall(boolean z) {
        if (z) {
            this.mHandUp.setVisibility(8);
            this.handUpDisable.setVisibility(0);
            this.mHandUp.endHandUp();
            return;
        }
        this.mHandUp.setVisibility(0);
        this.handUpDisable.setVisibility(8);
    }

    public void sendFeedback(JSONObject jSONObject) {
        PluginEventBus.onEvent(DataBusKey.CLASS_HANDUP, new PluginEventData(getClass(), DataBusKey.CLASS_HANDUP, "", jSONObject));
    }

    /* access modifiers changed from: protected */
    public void buildStudentWindow() {
        super.buildStudentWindow();
        ((TextView) this.studentWindow.getContentView().findViewById(R.id.tv_live_business_student_window)).setText(R.string.my_video);
    }

    public void setTeacherOnlyButton() {
        if (this.teacherOnlyWindow == null) {
            buildTeacherOnlyWindow();
        }
    }

    private void buildTeacherOnlyWindow() {
        if (this.teacherOnlyWindow == null) {
            EasyPopup easyPopup = new EasyPopup(getContext());
            this.teacherOnlyWindow = easyPopup;
            easyPopup.setContentView(R.layout.live_business_popupwindow_teacheronly_controller, -2, SizeUtils.dp2px(36.0f)).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setOnDismissListener(new PopupWindow.OnDismissListener() {
                public void onDismiss() {
                    MediaControlLiveViewPhone.this.teacherOnlyWindow.dismiss();
                    boolean unused = MediaControlLiveViewPhone.this.isShowTeacherOnlyWindow = false;
                    MediaControlLiveViewPhone.this.hide();
                }
            }).createPopup();
            ImageButton imageButton = (ImageButton) this.teacherOnlyWindow.getContentView().findViewById(R.id.sw_live_business_teacheronly_controller);
            this.switchTeacherOnly = imageButton;
            imageButton.setSelected(false);
            this.switchTeacherOnly.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, MediaControlLiveViewPhone.class);
                    MediaControlLiveViewPhone mediaControlLiveViewPhone = MediaControlLiveViewPhone.this;
                    boolean unused = mediaControlLiveViewPhone.isTeacherOnly = !mediaControlLiveViewPhone.isTeacherOnly;
                    MediaControlLiveViewPhone.this.switchTeacherOnly.setSelected(MediaControlLiveViewPhone.this.isTeacherOnly);
                    MediaControlLiveViewPhone.this.driver.chatTeacherOnly(MediaControlLiveViewPhone.this.isTeacherOnly ? "1" : EnterRoomMuteData.STATUS_UN_MUTE);
                    DriverTrack.INSTANCE.classRoomInteractOnlySwitch(MediaControlLiveViewPhone.this.isTeacherOnly ? 1 : 0);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
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
        int i2;
        if (!this.isShowStudentWindow && !this.isShowTeacherOnlyWindow) {
            if (this.topRoot != null) {
                this.topRoot.clearAnimation();
                if (z) {
                    i2 = 0;
                } else {
                    i2 = -this.topRoot.getHeight();
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.topRoot, "translationY", new float[]{this.topRoot.getTranslationY(), (float) i2});
                ofFloat.setDuration(300);
                ofFloat.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                    }
                });
                ofFloat.start();
            }
            if (this.bottomRoot != null) {
                this.bottomRoot.clearAnimation();
                if (z) {
                    i = 0;
                } else {
                    i = this.bottomRoot.getHeight();
                }
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bottomRoot, "translationY", new float[]{this.bottomRoot.getTranslationY(), (float) i});
                ofFloat2.setDuration(300);
                ofFloat2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                    }
                });
                ofFloat2.start();
            }
        }
    }

    public void setInputMsgEnable(boolean z) {
        if (z) {
            this.llMsgInput.setVisibility(4);
            this.ivTeacherOnly.setVisibility(4);
            this.closeTV.setVisibility(0);
            return;
        }
        this.llMsgInput.setVisibility(0);
        this.ivTeacherOnly.setVisibility(0);
        this.closeTV.setVisibility(8);
    }

    public void setPrivateMsgState(boolean z) {
        if (z) {
            this.msgPrivateInputTV.setVisibility(0);
            this.msgGroupInputRL.setVisibility(8);
            return;
        }
        this.msgPrivateInputTV.setVisibility(8);
        this.msgGroupInputRL.setVisibility(0);
    }

    public void ircConnectSuccess() {
        if (this.ircConnectingTV.getVisibility() == 0) {
            this.ircConnectingTV.setVisibility(8);
            this.msgGroupInputRL.setVisibility(0);
        }
    }

    public void dismissNoHomeworkPopup() {
        if (this.mNoHomeworkPopup != null && this.mNoHomeworkPopup.isShowing()) {
            this.mNoHomeworkPopup.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandUp.destroy();
    }
}
