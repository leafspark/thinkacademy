package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModel;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinCenterViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.yy.mobile.rollingtextview.RollingTextView;

public class MediaControlSmallLiveViewPad extends MediaControllerBaseLiveView {
    private ImageView ivScreenShot;
    private View layoutStar;
    private final ChatBoxViewModel mChatBoxViewModel = ChatBoxViewModelKt.getChatBoxAbility(AbilityPack.get());
    private ImageView starIcon;
    private View starLine;
    private RollingTextView tvStarCount;

    public void startAnim(boolean z) {
    }

    public MediaControlSmallLiveViewPad(Context context, DataStorage dataStorage) {
        super(context);
        initListener();
        setTitle(dataStorage.getPlanInfo().getName());
        this.mWifiStateIcons = new int[]{R.drawable.icon_wifi_navigation_good_new, R.drawable.icon_wifi_navigation_normal_new, R.drawable.icon_wifi_navigation_weak_new};
    }

    public void initViews() {
        super.initViews();
        this.ivScreenShot = (ImageView) findViewById(R.id.iv_live_business_screenshot);
        this.starLine = findViewById(R.id.v_media_controller_star_line);
        this.layoutStar = findViewById(R.id.ll_media_controller_star);
        this.tvStarCount = findViewById(R.id.tv_media_controller_star_count);
        this.starIcon = (ImageView) findViewById(R.id.iv_media_controller_star);
        setContentLayoutParams();
    }

    public void initListener() {
        super.initListener();
        this.ivMore.setOnClickListener(new MediaControlSmallLiveViewPad$$ExternalSyntheticLambda2(this));
        this.ivScreenShot.setOnClickListener(new MediaControlSmallLiveViewPad$$ExternalSyntheticLambda3(this));
        this.ivNetwork.setOnClickListener((View.OnClickListener) null);
    }

    public /* synthetic */ void lambda$initListener$0$MediaControlSmallLiveViewPad(View view) {
        if (!this.studentWindow.isShowing()) {
            this.isShowStudentWindow = true;
            this.studentWindow.showAtAnchorView(view, 2, 3, (-SizeUtils.dp2px(150.0f)) + view.getMeasuredWidth() + SizeUtils.dp2px(8.0f), SizeUtils.dp2px(7.0f));
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.closeChatBox();
            this.mChatBoxViewModel.syncChatBoxViewClosed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$initListener$1$MediaControlSmallLiveViewPad(View view) {
        this.driver.screenShot(ScreenShotToken.SCREENSHOT);
        DriverTrack.INSTANCE.classroomToolbarClick("截屏");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void hide() {
        super.hide();
        lambda$new$1$BaseMediaControlView();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_view_media_controller_small_live_pad;
    }

    public void setContentLayoutParams() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topRoot.getLayoutParams();
        LiveAreaLayoutParams titleLp = LiveAreaContext.get().getTitleLp();
        layoutParams.width = titleLp.width;
        layoutParams.height = titleLp.height;
        layoutParams.topMargin = titleLp.top;
        layoutParams.setMarginStart(titleLp.left);
        this.topRoot.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ivPreview.getLayoutParams();
        LiveAreaLayoutParams funcLp = LiveAreaContext.get().getFuncLp();
        layoutParams2.setMarginStart((funcLp.left - layoutParams2.width) - SizeUtils.dp2px(20.0f));
        layoutParams2.topMargin = ((funcLp.top + funcLp.height) - layoutParams2.height) - SizeUtils.dp2px(20.0f);
        this.ivPreview.setLayoutParams(layoutParams2);
    }

    public void setIsAudition(boolean z) {
        if (z) {
            this.ivMore.setVisibility(8);
            this.layoutStar.setVisibility(8);
            this.starLine.setVisibility(8);
            return;
        }
        buildStudentWindow();
        CoinCenterViewModel coinCenterViewModel = CoinCenterViewModelKt.getCoinCenterViewModel(AbilityPack.get());
        if (coinCenterViewModel != null) {
            coinCenterViewModel.bindingCoinView(this.starIcon, this.tvStarCount, this.layoutStar);
        }
    }

    public void setCameraState(boolean z) {
        this.isCompatStudent = z;
        if (this.switchCompatStudent != null) {
            this.switchCompatStudent.setSelected(z);
        }
    }

    /* access modifiers changed from: protected */
    public void buildStudentWindow() {
        if (this.studentWindow == null) {
            this.studentWindow = new EasyPopup(getContext());
            this.studentWindow.setContentView(R.layout.live_business_popupwindow_small_pad_controller).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setOnDismissListener(new MediaControlSmallLiveViewPad$$ExternalSyntheticLambda4(this)).createPopup();
            this.switchCompatStudent = (ImageButton) this.studentWindow.getContentView().findViewById(R.id.sw_live_business_student_camera);
            this.switchCompatStudent.setSelected(true);
            this.switchCompatStudent.setOnClickListener(new MediaControlSmallLiveViewPad$$ExternalSyntheticLambda0(this));
            ((TextView) this.studentWindow.getContentView().findViewById(R.id.tv_live_business_feedback)).setOnClickListener(new MediaControlSmallLiveViewPad$$ExternalSyntheticLambda1(this));
        }
    }

    public /* synthetic */ void lambda$buildStudentWindow$2$MediaControlSmallLiveViewPad() {
        this.studentWindow.dismiss();
        this.isShowStudentWindow = false;
        hide();
    }

    public /* synthetic */ void lambda$buildStudentWindow$3$MediaControlSmallLiveViewPad(View view) {
        if (!PermissionUtils.isGranted("android.permission.CAMERA")) {
            PluginEventBus.onEvent(DataBusKey.FUNCTION_SHOW_PERMISSION_DIALOG, new PluginEventData(getClass(), "", "camera"));
            if (this.studentWindow != null) {
                this.studentWindow.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!this.isEnableSwitch) {
            if (this.state == EnableState.TEACHER_LINK || this.state == EnableState.TUTOR_LINK || this.state == EnableState.RANGE_LINK) {
                ToastUtils.showShort((CharSequence) "Please try again after the Video Link.");
            } else if (this.state == EnableState.CAMERA) {
                ToastUtils.showShort((CharSequence) "Please try again after the Photopost.");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            setCameraState(!this.isCompatStudent);
            String str = "1";
            this.driver.updateStudentVideoSmallClass(this.isCompatStudent ? str : EnterRoomMuteData.STATUS_UN_MUTE);
            DriverTrack driverTrack = DriverTrack.INSTANCE;
            if (!this.isCompatStudent) {
                str = EnterRoomMuteData.STATUS_UN_MUTE;
            }
            driverTrack.classroomToolbarVideo(str);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public /* synthetic */ void lambda$buildStudentWindow$4$MediaControlSmallLiveViewPad(View view) {
        showFeedbackPop();
        this.driver.track_click_feedback(LeanplumUtil.click_feedback);
        DriverTrack.INSTANCE.classroomToolbarClick("反馈");
        if (this.studentWindow != null) {
            this.studentWindow.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
