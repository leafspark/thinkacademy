package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate.BaseClassRoomTitleBarDelegate;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate.DriverDelegateFactory;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import org.json.JSONObject;

@PluginAnnotation(desc = "导航栏，媒体控制器 + 手势控制", ircType = {"mode", "local_userCount", "auto_feedback"}, launchType = "enter", moduleId = "-103")
@ViewLevels({@ViewLevel(level = 130, name = "base"), @ViewLevel(level = 2, name = "gesture")})
public class MediaControlLiveDriver extends BaseMediaControlDriver {
    private BaseClassRoomTitleBarDelegate mDriverDelegate;

    public void sendFeedback(JSONObject jSONObject) {
        PluginEventBus.onEvent(DataBusKey.CLASS_FEEDBACK, new PluginEventData(getClass(), DataBusKey.CLASS_FEEDBACK, "", jSONObject));
    }

    public void hotWord() {
        PluginEventBus.onEvent(DataBusKey.LIVE_MSG_HOT_WORD, new PluginEventData(getClass(), DataBusKey.LIVE_MSG_HOT_WORD, "hot word"));
    }

    public void showInputKeyboardView() {
        PluginEventBus.onEvent(DataBusKey.LIVE_MSG_INPUT, new PluginEventData(getClass(), DataBusKey.LIVE_MSG_INPUT, "input"));
    }

    public void chatTeacherOnly(String str) {
        PluginEventBus.onEvent(DataBusKey.LIVE_MSG_TEACHER_ONLY, new PluginEventData(getClass(), DataBusKey.LIVE_MSG_TEACHER_ONLY, str));
    }

    public void updateStudentVideo(String str) {
        PluginEventBus.onEvent(DataBusKey.LIVE_MESSAGE_ANIMATION_KEY, new PluginEventData(MediaControlLiveDriver.class, DataBusKey.LIVE_MESSAGE_ANIMATION_KEY, str));
    }

    public void updateStudentVideoSmallClass(String str) {
        String str2 = this.TAG;
        XesLog.dt(str2, "controlLocalVideo，cameraState = " + str);
        PluginEventBus.onEvent(DataBusKey.USER_MUTE_VIDEO_KEY, new PluginEventData(getClass(), DataBusKey.USER_MUTE_VIDEO_KEY, str, "fromFunction"));
    }

    public MediaControlLiveDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        initViews();
    }

    /* access modifiers changed from: protected */
    public void dispatchScreenshotFilePath(String str, ScreenShotToken screenShotToken) {
        if (ScreenShotToken.TEACH_FEEDBACK.equals(screenShotToken)) {
            getDelegate().getPcFeedbackHelper().receiveScreenshotFilePath(str, screenShotToken);
        } else {
            getMediaView().setScreenShotFilePath(str);
        }
    }

    public BaseClassRoomTitleBarDelegate getDelegate() {
        if (this.mDriverDelegate == null) {
            BaseClassRoomTitleBarDelegate create = DriverDelegateFactory.create(LiveAreaContext.get().getCurrentType(), this.isAuditor);
            this.mDriverDelegate = create;
            create.init(this.mContext, this, this.mLiveRoomProvider.getDataStorage(), this.isPad);
        }
        return this.mDriverDelegate;
    }

    private void initViews() {
        LiveAreaLayoutParams screenLp = LiveAreaContext.get().getScreenLp();
        FrameLayout.LayoutParams newLp = screenLp.newLp();
        if (LiveAreaContext.get().isPad() && BarUtils.isNavBarVisible((Activity) this.mContext) && !this.mLiveRoomProvider.isSmallClass()) {
            newLp.height = screenLp.height - BarUtils.getNavBarHeight();
        }
        this.mLiveRoomProvider.addView(this, getMediaView(), "base", newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new MediaControlLiveDriver$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$initViews$0$MediaControlLiveDriver(LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getMediaView().getLayoutParams();
        LiveAreaLayoutParams screenLp = LiveAreaContext.get().getScreenLp();
        screenLp.mergeLp(layoutParams);
        if (LiveAreaContext.get().isPad() && BarUtils.isNavBarVisible((Activity) this.mContext)) {
            layoutParams.height = screenLp.height - BarUtils.getNavBarHeight();
        }
        getMediaView().setLayoutParams(layoutParams);
        getMediaView().setContentLayoutParams();
    }

    /* access modifiers changed from: protected */
    public BaseMediaControlView getMediaView() {
        return getDelegate().getMediaView();
    }

    public void onMessage(String str, String str2) {
        String str3 = this.TAG;
        XesLog.dt(str3, "ircTypeKey = " + str + " message = " + str2);
        getDelegate().onMessage(str, str2);
    }

    /* access modifiers changed from: protected */
    public Boolean isLive() {
        return true;
    }

    public void requestExamReport(boolean z) {
        getDelegate().requestExamReport(z);
    }

    public void onDestroy() {
        getDelegate().destroy();
    }
}
