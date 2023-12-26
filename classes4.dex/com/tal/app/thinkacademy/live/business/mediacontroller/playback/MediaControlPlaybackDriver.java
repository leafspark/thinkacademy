package com.tal.app.thinkacademy.live.business.mediacontroller.playback;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.common.bridges.PlayerActionBridge;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlDriver;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.BaseMediaControlView;
import com.tal.app.thinkacademy.live.business.mediacontroller.base.IMediaCtrListener;
import com.tal.app.thinkacademy.live.business.mediacontroller.event.MediaControllerPublicKeys;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotEventKey;
import com.tal.app.thinkacademy.live.business.screenshot.ScreenShotToken;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

@PluginAnnotation(desc = "导航栏，媒体控制器 + 手势控制", launchType = "enter", liveType = 1, moduleId = "-103")
@ViewLevels({@ViewLevel(level = 130, name = "base"), @ViewLevel(level = 2, name = "gesture")})
public class MediaControlPlaybackDriver extends BaseMediaControlDriver implements PlayerTimeCallBack, Observer<PluginEventData> {
    protected final Tag TAG;
    long dragProgress;
    boolean inited = false;
    boolean isDragging = false;
    boolean isPlaying = false;
    IMediaCtrListener mediaCtrListener;
    /* access modifiers changed from: private */
    public MediaControlPlaybackViewPad mediaViewPad;
    /* access modifiers changed from: private */
    public MediaControlPlaybackViewPhone mediaViewPhone;

    public void onMessage(String str, String str2) {
    }

    public void onSeiCurrent(long j) {
    }

    private void initMediaControllerListener() {
        this.mediaCtrListener = new IMediaCtrListener() {
            public void onForwardClickListener(View view) {
            }

            public void onKeyTipClickListener() {
            }

            public void onModeChangeListener(String str) {
            }

            public void onNextClickListener(View view) {
            }

            public void onSeekProcessListener() {
            }

            public void onPlayClickListener() {
                PlayerActionBridge.play(getClass());
            }

            public void onPauseClickListener() {
                PlayerActionBridge.pause(getClass());
            }

            public void onScreenshotClickListener(View view) {
                PluginEventBus.onEvent(ScreenShotEventKey.SCREEN_SHOT_EVENT, PluginEventData.obtainData(getClass(), ScreenShotEventKey.SCREEN_SHOT_OPERATION_KEY, "screenShot"));
            }

            public void onSpeedChangeListener(float f) {
                PlayerActionBridge.changeSpeed(getClass(), f);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaControlPlaybackDriver.this.isDragging = true;
                if (MediaControlPlaybackDriver.this.isPad) {
                    MediaControlPlaybackDriver.this.mediaViewPad.showLong();
                } else {
                    MediaControlPlaybackDriver.this.mediaViewPhone.showLong();
                }
            }

            public void onProgressChanged(SeekBar seekBar, long j) {
                MediaControlPlaybackDriver.this.isDragging = true;
                MediaControlPlaybackDriver.this.dragProgress = j;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaControlPlaybackDriver.this.isDragging = false;
                PlayerActionBridge.seekTo(getClass(), MediaControlPlaybackDriver.this.dragProgress);
                if (MediaControlPlaybackDriver.this.isPad) {
                    if (!MediaControlPlaybackDriver.this.isPlaying) {
                        MediaControlPlaybackDriver.this.mediaViewPad.setProgress(MediaControlPlaybackDriver.this.dragProgress);
                    }
                } else if (!MediaControlPlaybackDriver.this.isPlaying) {
                    MediaControlPlaybackDriver.this.mediaViewPhone.setProgress(MediaControlPlaybackDriver.this.dragProgress);
                }
                MediaControlPlaybackDriver.this.show();
                MediaControlPlaybackDriver.this.dragProgress = 0;
            }
        };
    }

    /* access modifiers changed from: protected */
    public BaseMediaControlView getMediaView() {
        if (this.isPad) {
            if (this.mediaViewPad == null) {
                initMediaControllerListener();
                MediaControlPlaybackViewPad mediaControlPlaybackViewPad = new MediaControlPlaybackViewPad(this.mContext);
                this.mediaViewPad = mediaControlPlaybackViewPad;
                mediaControlPlaybackViewPad.setMediaCtrListener(this.mediaCtrListener);
                this.mediaViewPad.setDriver(this);
                if (!(this.mLiveRoomProvider == null || this.mLiveRoomProvider.getDataStorage().getPlanInfo() == null || TextUtils.isEmpty(this.mLiveRoomProvider.getDataStorage().getPlanInfo().getName()))) {
                    this.mediaViewPad.setTitle(this.mLiveRoomProvider.getDataStorage().getPlanInfo().getName());
                }
            }
            return this.mediaViewPad;
        }
        if (this.mediaViewPhone == null) {
            initMediaControllerListener();
            MediaControlPlaybackViewPhone mediaControlPlaybackViewPhone = new MediaControlPlaybackViewPhone(this.mContext);
            this.mediaViewPhone = mediaControlPlaybackViewPhone;
            mediaControlPlaybackViewPhone.setMediaCtrListener(this.mediaCtrListener);
            this.mediaViewPhone.setDriver(this);
            if (!(this.mLiveRoomProvider == null || this.mLiveRoomProvider.getDataStorage().getPlanInfo() == null || TextUtils.isEmpty(this.mLiveRoomProvider.getDataStorage().getPlanInfo().getName()))) {
                this.mediaViewPhone.setTitle(this.mLiveRoomProvider.getDataStorage().getPlanInfo().getName());
            }
        }
        return this.mediaViewPhone;
    }

    public MediaControlPlaybackDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Tag tag = Tag.LIVE_PLAY_BACK;
        this.TAG = tag;
        XesLog.i(tag, "回放导航栏插件开始初始化");
        initViews();
        registerEvent();
    }

    /* access modifiers changed from: protected */
    public void dispatchScreenshotFilePath(String str, ScreenShotToken screenShotToken) {
        getMediaView().setScreenShotFilePath(str);
    }

    private FrameLayout.LayoutParams getMediaControlLayout() {
        LiveAreaLayoutParams screenLp = LiveAreaContext.get().getScreenLp();
        FrameLayout.LayoutParams newLp = screenLp.newLp();
        if (this.isPad && BarUtils.isNavBarVisible((Activity) this.mContext)) {
            newLp.height = screenLp.height - BarUtils.getNavBarHeight();
        }
        return newLp;
    }

    private void initViews() {
        this.mLiveRoomProvider.registerPlayerTimeCallback(this);
        LiveAreaContext.get().layoutObserver.observe(this, new MediaControlPlaybackDriver$$ExternalSyntheticLambda0(this));
        this.gestureView.setCanSeek(true);
    }

    public /* synthetic */ void lambda$initViews$0$MediaControlPlaybackDriver(LiveAreaContext liveAreaContext) {
        XesLog.i(this.TAG, "回放导航栏,收到屏幕变化回调");
        if (getMediaView() != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getMediaView().getLayoutParams();
            if (layoutParams != null) {
                liveAreaContext.getScreenLp().mergeLp(layoutParams);
                if (this.isPad && BarUtils.isNavBarVisible((Activity) this.mContext)) {
                    layoutParams.height -= BarUtils.getNavBarHeight();
                }
                XesLog.i(this.TAG, "回放导航栏,收到屏幕变化回调,开始设置参数");
                getMediaView().setLayoutParams(layoutParams);
                getMediaView().setContentLayoutParams();
                return;
            }
            XesLog.e(this.TAG, "回放导航栏,收到屏幕变化回调,但是当前参数为空，无法设置");
        }
    }

    private void registerEvent() {
        PluginEventBus.register(this, MediaControllerPublicKeys.KEY_ABILITY, this);
        PluginEventBus.register(this, "player_status", this);
        PluginEventBus.register(this, DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.observerScreenShot);
    }

    public void onPlaying(long j, long j2) {
        if (!this.inited) {
            this.inited = true;
            XesLog.i(this.TAG, "回放导航栏,视图未添加，开始添加");
            this.mLiveRoomProvider.addView(this, getMediaView(), "base", getMediaControlLayout());
            BaseMediaControlView mediaView = getMediaView();
            if (mediaView != null) {
                mediaView.setContentLayoutParams();
            }
        }
        BaseMediaControlView mediaView2 = getMediaView();
        if (mediaView2 != null && (mediaView2 instanceof MediaControlBasePlaybackView)) {
            ((MediaControlBasePlaybackView) mediaView2).setupPageIndexView(j2);
        }
        this.isPlaying = true;
        if (!this.isDragging) {
            Handler mainHandler = ThreadUtils.getMainHandler();
            final long j3 = j;
            final long j4 = j2;
            AnonymousClass2 r1 = new Runnable() {
                public void run() {
                    if (MediaControlPlaybackDriver.this.isPad) {
                        MediaControlPlaybackDriver.this.mediaViewPad.setProgress(j3, j4);
                    } else {
                        MediaControlPlaybackDriver.this.mediaViewPhone.setProgress(j3, j4);
                    }
                    MediaControlPlaybackDriver.this.gestureView.updatePosition(j3, j4);
                }
            };
            if (!(mainHandler instanceof Handler)) {
                mainHandler.post(r1);
            } else {
                AsynchronousInstrumentation.handlerPost(mainHandler, r1);
            }
        }
    }

    public void seekSeekBarTo(long j) {
        super.seekSeekBarTo(j);
        if (this.isPad) {
            if (!this.isPlaying) {
                this.mediaViewPad.setProgress(j);
            }
        } else if (!this.isPlaying) {
            this.mediaViewPhone.setProgress(j);
        }
    }

    /* access modifiers changed from: protected */
    public Boolean isLive() {
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0097, code lost:
        if (r15.equals("player_status_pause") == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002b, code lost:
        if (r15.equals("player_status_pause") == false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onChanged(com.tal.app.thinkacademy.live.core.plugin.PluginEventData r15) {
        /*
            r14 = this;
            boolean r0 = r14.isPad
            r1 = 5
            java.lang.String r2 = "player_status_pause"
            r3 = 4
            java.lang.String r4 = "player_status_error"
            r5 = 3
            java.lang.String r6 = "player_status_stop"
            r7 = 2
            java.lang.String r8 = "player_status_play"
            java.lang.String r9 = "player_status_start_to_play"
            java.lang.String r10 = "player_status_complete"
            r11 = -1
            r12 = 1
            r13 = 0
            if (r0 == 0) goto L_0x0083
            java.lang.String r15 = r15.getOperation()
            r15.hashCode()
            int r0 = r15.hashCode()
            switch(r0) {
                case -1868926584: goto L_0x0052;
                case -1053389652: goto L_0x0049;
                case -249804029: goto L_0x0040;
                case -249706543: goto L_0x0037;
                case 836045849: goto L_0x002e;
                case 845701127: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            r1 = r11
            goto L_0x005a
        L_0x0027:
            boolean r15 = r15.equals(r2)
            if (r15 != 0) goto L_0x005a
            goto L_0x0025
        L_0x002e:
            boolean r15 = r15.equals(r4)
            if (r15 != 0) goto L_0x0035
            goto L_0x0025
        L_0x0035:
            r1 = r3
            goto L_0x005a
        L_0x0037:
            boolean r15 = r15.equals(r6)
            if (r15 != 0) goto L_0x003e
            goto L_0x0025
        L_0x003e:
            r1 = r5
            goto L_0x005a
        L_0x0040:
            boolean r15 = r15.equals(r8)
            if (r15 != 0) goto L_0x0047
            goto L_0x0025
        L_0x0047:
            r1 = r7
            goto L_0x005a
        L_0x0049:
            boolean r15 = r15.equals(r9)
            if (r15 != 0) goto L_0x0050
            goto L_0x0025
        L_0x0050:
            r1 = r12
            goto L_0x005a
        L_0x0052:
            boolean r15 = r15.equals(r10)
            if (r15 != 0) goto L_0x0059
            goto L_0x0025
        L_0x0059:
            r1 = r13
        L_0x005a:
            switch(r1) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0071;
                case 2: goto L_0x0068;
                case 3: goto L_0x007a;
                case 4: goto L_0x005f;
                case 5: goto L_0x007a;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x00e9
        L_0x005f:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPad r15 = r14.mediaViewPad
            if (r15 == 0) goto L_0x00e9
            r15.setBottomControlVisible(r13)
            goto L_0x00e9
        L_0x0068:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPad r15 = r14.mediaViewPad
            r15.updatePauseIcon(r12)
            r14.isPlaying = r12
            goto L_0x00e9
        L_0x0071:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPad r15 = r14.mediaViewPad
            if (r15 == 0) goto L_0x00e9
            r15.setBottomControlVisible(r12)
            goto L_0x00e9
        L_0x007a:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPad r15 = r14.mediaViewPad
            r15.updatePauseIcon(r13)
            r14.isPlaying = r13
            goto L_0x00e9
        L_0x0083:
            java.lang.String r15 = r15.getOperation()
            r15.hashCode()
            int r0 = r15.hashCode()
            switch(r0) {
                case -1868926584: goto L_0x00be;
                case -1053389652: goto L_0x00b5;
                case -249804029: goto L_0x00ac;
                case -249706543: goto L_0x00a3;
                case 836045849: goto L_0x009a;
                case 845701127: goto L_0x0093;
                default: goto L_0x0091;
            }
        L_0x0091:
            r1 = r11
            goto L_0x00c6
        L_0x0093:
            boolean r15 = r15.equals(r2)
            if (r15 != 0) goto L_0x00c6
            goto L_0x0091
        L_0x009a:
            boolean r15 = r15.equals(r4)
            if (r15 != 0) goto L_0x00a1
            goto L_0x0091
        L_0x00a1:
            r1 = r3
            goto L_0x00c6
        L_0x00a3:
            boolean r15 = r15.equals(r6)
            if (r15 != 0) goto L_0x00aa
            goto L_0x0091
        L_0x00aa:
            r1 = r5
            goto L_0x00c6
        L_0x00ac:
            boolean r15 = r15.equals(r8)
            if (r15 != 0) goto L_0x00b3
            goto L_0x0091
        L_0x00b3:
            r1 = r7
            goto L_0x00c6
        L_0x00b5:
            boolean r15 = r15.equals(r9)
            if (r15 != 0) goto L_0x00bc
            goto L_0x0091
        L_0x00bc:
            r1 = r12
            goto L_0x00c6
        L_0x00be:
            boolean r15 = r15.equals(r10)
            if (r15 != 0) goto L_0x00c5
            goto L_0x0091
        L_0x00c5:
            r1 = r13
        L_0x00c6:
            switch(r1) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00da;
                case 2: goto L_0x00d2;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00ca;
                case 5: goto L_0x00e2;
                default: goto L_0x00c9;
            }
        L_0x00c9:
            goto L_0x00e9
        L_0x00ca:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPhone r15 = r14.mediaViewPhone
            if (r15 == 0) goto L_0x00e9
            r15.setBottomControlVisible(r13)
            goto L_0x00e9
        L_0x00d2:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPhone r15 = r14.mediaViewPhone
            r15.updatePauseIcon(r12)
            r14.isPlaying = r12
            goto L_0x00e9
        L_0x00da:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPhone r15 = r14.mediaViewPhone
            if (r15 == 0) goto L_0x00e9
            r15.setBottomControlVisible(r12)
            goto L_0x00e9
        L_0x00e2:
            com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackViewPhone r15 = r14.mediaViewPhone
            r15.updatePauseIcon(r13)
            r14.isPlaying = r13
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.mediacontroller.playback.MediaControlPlaybackDriver.onChanged(com.tal.app.thinkacademy.live.core.plugin.PluginEventData):void");
    }

    public void onDestroy() {
        PluginEventBus.unregister(MediaControllerPublicKeys.KEY_ABILITY, this);
        PluginEventBus.unregister("player_status", this);
        PluginEventBus.unregister(DataBusKey.LIVE_MEDIA_SCREEN_SHOT, this.observerScreenShot);
    }
}
