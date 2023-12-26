package com.tal.app.thinkacademy.live.business.liveplay.liveplayer;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCMediaVideoProcess;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayPrePlayEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerUtil;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class LivePlayController {
    private Context mContext;
    private boolean mIsAuditor = false;
    private boolean mIsSmallClass = false;
    private long mPcTeacherUid = -1;
    private RtcPlayEventListener mPlayEventListener;
    private LivePlayView mPlayRootView;
    private RtcPlayer mPlayer;
    private RtcPlayPrePlayEventListener mPrePlayEventListener;
    private RTCEngine mRTCEngine;
    private RtcPlayerEngineEventListener mRtcPlayerEngineEventListener;
    private RTCEngineProvider provider;

    public LivePlayController(Context context, boolean z) {
        XesLog.it("当前线程 : " + Thread.currentThread().getName() + "  >>>> " + getClass().getSimpleName(), new Object[0]);
        this.mIsAuditor = z;
        this.mPlayRootView = new LivePlayView(context);
        this.mContext = context;
        RtcPlayer rtcPlayer = RtcPlayerUtil.getInstance().get("Live");
        this.mPlayer = rtcPlayer;
        if (rtcPlayer == null) {
            this.mPlayer = new RtcPlayer(context);
            RtcPlayerUtil.getInstance().put("Live", this.mPlayer);
            XesLog.dt("LivePlayController进入直播间创建mPlayer：", "mPlayer is" + this.mPlayer);
        }
        RTCEngineProvider rTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.provider = rTCEngineProvider;
        if (rTCEngineProvider == null) {
            this.provider = new RTCEngineProvider(this.mPlayer);
            RTCEngineProviderUtils.getInstance().put("Live", this.provider);
            XesLog.dt("LivePlayController进入直播间创建provider：", "provider is" + this.provider);
        }
    }

    public void setSmallClass(boolean z) {
        this.mIsSmallClass = z;
    }

    public void setPcTeacherUid(long j) {
        this.mPcTeacherUid = j;
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.setMPcTeacherUid(j);
        }
    }

    public SurfaceView getTeacherSurfaceView() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            return rtcPlayer.createSurfaceView();
        }
        return null;
    }

    public void setTutorUid(long j) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.setMTutorUid(j);
        }
    }

    public void switchPcTeacherModel(SurfaceView surfaceView) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            RTCEngine rTCEngine = rtcPlayer.getRTCEngine();
            this.mRTCEngine = rTCEngine;
            if (!(rTCEngine == null || surfaceView == null)) {
                rTCEngine.setupRemoteVideo(surfaceView, this.mPcTeacherUid);
            }
            this.mPlayer.switchTeacherModel(true);
        }
    }

    public void switchIpadTeacherModel() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.switchTeacherModel(false);
        }
    }

    public BaseLivePluginView getPlayRootView() {
        return this.mPlayRootView;
    }

    public void addView(View view, FrameLayout.LayoutParams layoutParams) {
        this.mPlayRootView.addView(view, layoutParams);
        if (!this.mIsSmallClass) {
            ImageView imageView = new ImageView(this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(72, 90);
            layoutParams2.setMargins(15, 15, 15, 15);
            imageView.setLayoutParams(layoutParams2);
            imageView.setImageResource(R.drawable.bg_live_business_videa_logo);
            this.mPlayRootView.addView(imageView);
        }
    }

    public void removeView(View view) {
        this.mPlayRootView.removeView(view);
    }

    public void setPlayEventListener(RtcPlayEventListener rtcPlayEventListener) {
        this.mPlayEventListener = rtcPlayEventListener;
    }

    public void setRtcPlayerEngineEventListener(RtcPlayerEngineEventListener rtcPlayerEngineEventListener) {
        this.mRtcPlayerEngineEventListener = rtcPlayerEngineEventListener;
    }

    public void setPrePlayEventListener(RtcPlayPrePlayEventListener rtcPlayPrePlayEventListener) {
        this.mPrePlayEventListener = rtcPlayPrePlayEventListener;
    }

    public void prePlay(String str, String str2, String str3, String str4, boolean z) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null && !rtcPlayer.videoTeacherIsJoined() && !this.mPlayer.audioTeacherIsJoined()) {
            if (!this.mPlayer.isInit()) {
                this.mPlayer.initPlay(str, str4, z);
            }
            this.mPlayer.prePlay(ParseUtils.tryParseLong(str2, -1), ParseUtils.tryParseLong(str3, -1), this.mPrePlayEventListener, this.mIsAuditor);
            this.mPlayer.setPlayEventListener(this.mPlayEventListener);
            this.mPlayer.addEtcEngineEventListener("LivePlayController", this.mRtcPlayerEngineEventListener);
        }
    }

    public void changeMode(String str, String str2, String str3, String str4, boolean z) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.destroyPlayer();
            prePlay(str, str2, str3, str4, z);
        }
    }

    public void startPlay() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.startPlay();
        }
    }

    public void pausePlayer() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null && rtcPlayer.isInit()) {
            this.mPlayer.pausePlay();
        }
    }

    public void reStartPlayer() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.reStart();
        }
    }

    public boolean isPause() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            return rtcPlayer.isPause();
        }
        return true;
    }

    public boolean audioTeacherIsJoined() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            return rtcPlayer.audioTeacherIsJoined();
        }
        return false;
    }

    public boolean videoTeacherIsJoined() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            return rtcPlayer.videoTeacherIsJoined();
        }
        return false;
    }

    public boolean isTargeVideoUser(Long l) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            return rtcPlayer.isTargeVideotUser(l.longValue());
        }
        return false;
    }

    public void addVideoFrameObserver(IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.addVideoProcessObserver(iRTCMediaVideoProcess);
        }
    }

    public void removeVideoFrameObserver(IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.removeVideoProcessObserver(iRTCMediaVideoProcess);
        }
    }

    public void onDestroy() {
        RTCEngineProviderUtils.getInstance().clear();
        RtcPlayerUtil.getInstance().clear();
        if (this.provider != null) {
            this.provider = null;
        }
        RtcPlayer rtcPlayer = this.mPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.destroyPlayer();
            this.mPlayer.removeAllVideoProcessObserver();
            this.mPlayer.removeAllAudioProcessObserver();
            this.mPlayer = null;
        }
    }
}
