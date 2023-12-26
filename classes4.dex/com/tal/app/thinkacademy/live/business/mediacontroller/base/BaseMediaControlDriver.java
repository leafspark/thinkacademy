package com.tal.app.thinkacademy.live.business.mediacontroller.base;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.eaydu.omni.RTCEngine;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineCreateListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.common.bridges.PlayerActionBridge;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotEventKey;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.interfaces.ExitLiveRoom;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.IrcController;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.HashMap;

public abstract class BaseMediaControlDriver extends BaseLivePluginDriver implements IMediaControl, IPlayerControl, RTCEngineCreateListener {
    protected final String TAG = getClass().getSimpleName();
    protected BaseMediaControlView baseMediaControlView;
    protected BaseGestureView gestureView;
    protected boolean isAuditor;
    protected boolean isPad;
    private boolean isPause;
    protected AudioManager mAM;
    protected Handler mBaseHandler;
    protected Context mContext;
    private IircControllerProvider mIrcControllerProvider;
    protected int mMaxVolume;
    private RtcPlayer mPlayer = null;
    protected RTCEngine mRtcEngine;
    protected RTCEngine.RtcEngineEventObserver mRtcEngineEventObserver;
    protected boolean mShowing;
    private IrcController.SimpleIrcChatListener mSimpleIrcChatListener;
    public Observer<Object> observerFinishActivity = new Observer<Object>() {
        public void onChanged(Object obj) {
            if (BaseMediaControlDriver.this.mLiveRoomProvider != null) {
                BaseMediaControlDriver.this.mLiveRoomProvider.backLiveRoom(ExitLiveRoom.KICK_OUT);
            }
        }
    };
    public Observer<PluginEventData> observerScreenShot = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            Object object = pluginEventData.getObject();
            BaseMediaControlDriver.this.dispatchScreenshotFilePath(pluginEventData.getData(), object instanceof ScreenShotToken ? (ScreenShotToken) object : null);
        }
    };
    private View.OnClickListener onBackClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            MethodInfo.onClickEventEnter(view, BaseMediaControlDriver.class);
            XesLog.it("标题控制栏，触发退出教室", new Object[0]);
            if (BaseMediaControlDriver.this.mLiveRoomProvider != null) {
                BaseMediaControlDriver.this.mLiveRoomProvider.backLiveRoom(ExitLiveRoom.NORMAL_EXIT);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    };
    protected Window window;

    /* access modifiers changed from: protected */
    public abstract void dispatchScreenshotFilePath(String str, ScreenShotToken screenShotToken);

    /* access modifiers changed from: protected */
    public abstract BaseMediaControlView getMediaView();

    /* access modifiers changed from: protected */
    public abstract Boolean isLive();

    public void onMessage(String str, String str2) {
    }

    public void seekSeekBarTo(long j) {
    }

    public void refresh() {
        PluginEventBus.onEvent(DataBusKey.CLASS_REFRESH_KEY, new PluginEventData(getClass(), DataBusKey.CLASS_REFRESH_KEY, "refresh"));
    }

    public void screenShot(ScreenShotToken screenShotToken) {
        PluginEventBus.onEvent(ScreenShotEventKey.SCREEN_SHOT_EVENT, PluginEventData.obtainData(getClass(), ScreenShotEventKey.SCREEN_SHOT_OPERATION_KEY, screenShotToken));
    }

    public BaseMediaControlDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        if (!(iLiveRoomProvider.getDataStorage() == null || iLiveRoomProvider.getDataStorage().getCourseInfo() == null)) {
            this.isAuditor = iLiveRoomProvider.getDataStorage().getCourseInfo().getIsAudition() == CourseInfo.ROLE_AUDITION;
        }
        this.isPad = LiveAreaContext.get().isPad();
        BaseMediaControlView mediaView = getMediaView();
        this.baseMediaControlView = mediaView;
        mediaView.setILiveRoomProvider(iLiveRoomProvider);
        this.baseMediaControlView.setBackClickListener(this.onBackClickListener);
        this.window = ((Activity) this.mContext).getWindow();
        init();
    }

    public ILiveRoomProvider getLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.mAM = (AudioManager) this.mContext.getSystemService("audio");
        BaseGestureView baseGestureView = new BaseGestureView(this.mContext);
        this.gestureView = baseGestureView;
        baseGestureView.bindMediaControl(this);
        this.gestureView.bindPlayerControl(this);
        this.gestureView.setLiveRoomProvider(this.mLiveRoomProvider);
        LayoutInflater from = LayoutInflater.from(this.mContext);
        int i = R.layout.live_business_layout_gesture_pop;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.baseMediaControlView.addView(inflate, layoutParams);
        this.gestureView.bindPopview(inflate);
        this.mLiveRoomProvider.addView(this, this.gestureView, "gesture", new ViewGroup.LayoutParams(-1, -1));
        if (isLive().booleanValue()) {
            initEngine();
        }
        addIRCListener();
        XesDataBus.with(DataBusKey.FINISH_ACTIVITY).observe(this.mContext, this.observerFinishActivity);
    }

    private void initEngine() {
        RtcPlayer rtcPlayer = RtcPlayerUtil.getInstance().get("Live");
        this.mPlayer = rtcPlayer;
        if (rtcPlayer == null) {
            this.mPlayer = new RtcPlayer(this.mContext);
            RtcPlayerUtil.getInstance().put("Live", this.mPlayer);
            XesLog.dt("BaseMediaControlDriver进入直播间创建mPlayer：", "mPlayer is" + this.mPlayer);
        }
        this.mRtcEngineEventObserver = new RTCEngine.RtcEngineEventObserver() {
            public void onNetworkQuality(long j, int i, int i2) {
                BaseMediaControlDriver.super.onNetworkQuality(j, i, i2);
                if (BaseMediaControlDriver.this.baseMediaControlView != null) {
                    BaseMediaControlDriver.this.baseMediaControlView.onNetworkQuality(j, i, i2);
                }
            }
        };
        this.mPlayer.addRtcEngineCreateListener(this.TAG, this);
        this.mPlayer.addRtcEngineEventObserver(this.TAG, this.mRtcEngineEventObserver);
    }

    private void addIRCListener() {
        this.mSimpleIrcChatListener = new IrcController.SimpleIrcChatListener() {
            public void onNetStatusChanged(int i) {
                BaseMediaControlDriver.super.onNetStatusChanged(i);
                if (BaseMediaControlDriver.this.baseMediaControlView != null) {
                    BaseMediaControlDriver.this.baseMediaControlView.onNetStatusChanged(i);
                }
            }
        };
        if (isLive().booleanValue()) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.mBaseHandler = handler;
            handler.postDelayed(new BaseMediaControlDriver$$ExternalSyntheticLambda0(this), 2000);
        }
    }

    public /* synthetic */ void lambda$addIRCListener$0$BaseMediaControlDriver() {
        IircControllerProvider ircControllerProvider = this.mLiveRoomProvider.getIrcControllerProvider();
        this.mIrcControllerProvider = ircControllerProvider;
        if (ircControllerProvider != null) {
            ircControllerProvider.addIrcChatListener(this.mSimpleIrcChatListener);
        }
    }

    public void createRtcPlayerEngine(RTCEngine rTCEngine) {
        this.mRtcEngine = rTCEngine;
    }

    public void onDestroy() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.removeRtcEngineCreateListener(this.TAG);
        }
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            iircControllerProvider.removeIrcChatListener(this.mSimpleIrcChatListener);
            this.mIrcControllerProvider = null;
            this.mSimpleIrcChatListener = null;
        }
        Handler handler = this.mBaseHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mBaseHandler = null;
        }
        XesDataBus.with(DataBusKey.FINISH_ACTIVITY).removeObserver(this.observerFinishActivity);
    }

    /* access modifiers changed from: protected */
    public void getSystemMaxVolume() {
        this.mMaxVolume = this.mAM.getStreamMaxVolume(3);
    }

    /* access modifiers changed from: protected */
    public void setVolume(int i) {
        int i2 = this.mMaxVolume;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.mAM.setStreamVolume(3, i, 0);
    }

    private void setBrightness(float f) {
        Context context = this.mContext;
        if (context != null && (context instanceof Activity)) {
            WindowManager.LayoutParams attributes = this.window.getAttributes();
            attributes.screenBrightness = f;
            if (attributes.screenBrightness > 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if (attributes.screenBrightness < 0.01f) {
                attributes.screenBrightness = 0.01f;
            }
            this.window.setAttributes(attributes);
        }
    }

    public boolean isShow() {
        return this.mShowing;
    }

    public void togglePlayer() {
        PlayerActionBridge.toggle(getClass());
    }

    public void play() {
        PlayerActionBridge.play(getClass());
    }

    public void pause() {
        PlayerActionBridge.pause(getClass());
    }

    public void stop() {
        PlayerActionBridge.stop(getClass());
    }

    public void seekTo(long j) {
        PlayerActionBridge.seekTo(getClass(), j);
    }

    public void toggleMediaVisible() {
        BaseMediaControlView baseMediaControlView2 = this.baseMediaControlView;
        if (baseMediaControlView2 != null) {
            baseMediaControlView2.toggle();
        }
    }

    public void show() {
        BaseMediaControlView baseMediaControlView2 = this.baseMediaControlView;
        if (baseMediaControlView2 != null) {
            baseMediaControlView2.show();
        }
    }

    public void showLong() {
        BaseMediaControlView baseMediaControlView2 = this.baseMediaControlView;
        if (baseMediaControlView2 != null) {
            baseMediaControlView2.showLong();
        }
    }

    public void hide() {
        BaseMediaControlView baseMediaControlView2 = this.baseMediaControlView;
        if (baseMediaControlView2 != null) {
            baseMediaControlView2.hide();
        }
    }

    public void track_click_feedback(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void track_click_feedback_send(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }
}
