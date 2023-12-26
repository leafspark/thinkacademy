package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import android.content.Context;
import android.view.Surface;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.AddressBean;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.player.view.PlayerTextureView;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.liveplayback.event.PlayerEventBus;
import com.tal.app.thinkacademy.live.business.liveplayback.loadingcontroller.BaseLoadingView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.HashMap;
import java.util.List;

public abstract class BaseLivePlayBackPlayerViewCtr implements IPlayBackPlayerCtr {
    private static final String SCHOOL_CODE_US = "415";
    private static final String SP_PLAY_PROGRESS_KEY = "play_progress";
    protected final Tag TAG;
    protected Context mContext;
    protected IJKPlayListener mListener;
    protected int mLiveTypeId;
    private long mLoadingTipsMin = 5000;
    private BaseLoadingView mLoadingView = null;
    protected boolean mNeedReplay = true;
    protected IJKPlayer mPlayer;
    protected LivePlayBackPlayerView mPlayerView;
    protected int mProtocol;
    protected float mStartPos;
    protected String mStreamId;
    protected String mStreamUrl;
    protected List<AddressBean> mStreamUrlList;
    protected Surface mSurface;
    private HashMap<Integer, String> mSwitchedUrlMap = new HashMap<>();
    private int mUrlNum = 0;
    private VideoPlayerSceneType mVideoPlayerSceneType;

    public abstract void initView(BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider, String str);

    public BaseLivePlayBackPlayerViewCtr(Context context, String str, String str2, String str3, int i, VideoPlayerSceneType videoPlayerSceneType) {
        Tag tag = Tag.LIVE_PLAY_BACK;
        this.TAG = tag;
        this.mContext = context;
        this.mLiveTypeId = i;
        this.mVideoPlayerSceneType = videoPlayerSceneType;
        String string = ShareDataManager.getInstance().getString("school_code", SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        long tryParseLong = ParseUtils.tryParseLong(HwCloudControlHelper.get().getCloudKeyValue("playback_loading_tips_timeout"), 5000);
        this.mLoadingTipsMin = tryParseLong;
        if (tryParseLong < 5000) {
            this.mLoadingTipsMin = 5000;
        }
        XesLog.i(tag, "卡顿提醒触发时间为=" + this.mLoadingTipsMin);
        this.mPlayer = new IJKPlayer(this.mContext, str, str2, str3, str3, string);
    }

    public void initPlayer(IJKPlayListener iJKPlayListener) {
        IJKPlayer iJKPlayer;
        this.mListener = iJKPlayListener;
        IJKPlayer iJKPlayer2 = this.mPlayer;
        if (iJKPlayer2 != null) {
            iJKPlayer2.initPlayer(iJKPlayListener);
        }
        Surface surface = this.mSurface;
        if (surface != null && (iJKPlayer = this.mPlayer) != null) {
            iJKPlayer.setSurface(surface);
        }
    }

    public void setUserInfo(String str, String str2) {
        this.mPlayer.setUserInfo(str, str2);
    }

    public void startPlay(String str, int i, float f, String str2, List<AddressBean> list) {
        this.mStartPos = f;
        this.mStreamId = str;
        this.mStreamUrl = str2;
        this.mStreamUrlList = list;
        this.mProtocol = i;
        PlayerEventBus.playerOnStartToPlay(getClass());
        this.mSwitchedUrlMap.put(Integer.valueOf(this.mUrlNum), this.mStreamUrl);
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null && str != null) {
            iJKPlayer.seekToAccurate();
            this.mPlayer.playFile(this.mStreamUrl, f, 0, this.mVideoPlayerSceneType);
        }
    }

    public void reTryPlay() {
        ShareDataManager instance = ShareDataManager.getInstance();
        reTryPlay(this.mStreamUrl, instance.getFloat(SP_PLAY_PROGRESS_KEY + this.mStreamId, this.mStartPos, ShareDataManager.SHAREDATA_USER));
    }

    public void reTryPlay(String str, float f) {
        stopPlay();
        initPlayer(this.mListener);
        startPlay(this.mStreamId, this.mProtocol, f, str, this.mStreamUrlList);
        PlayerEventBus.playerOnStart(BaseLivePlayBackPlayerViewCtr.class);
    }

    public void switchPlayUrl(int i, float f) {
        reTryPlay(getSwitchUrl(i), f);
    }

    public String getSwitchUrl(int i) {
        if (this.mStreamUrlList.isEmpty()) {
            XesLog.i(this.TAG, "无法切换,url列表是空的");
            return this.mStreamUrl;
        } else if (this.mStreamUrlList.size() == 1) {
            XesLog.i(this.TAG, "无法切换,url列表中只有一个数据");
            return this.mStreamUrl;
        } else if (i < this.mStreamUrlList.size()) {
            this.mUrlNum = i;
            IJKPlayer iJKPlayer = this.mPlayer;
            if (iJKPlayer != null) {
                iJKPlayer.setIsOtherLine(i != 0);
            }
            XesLog.i(this.TAG, String.format("切换成功，当前播放的是第%s个", new Object[]{Integer.valueOf(this.mUrlNum)}));
            return this.mStreamUrlList.get(this.mUrlNum).address;
        } else {
            XesLog.i(this.TAG, "无法切换,没有可用的index");
            return this.mStreamUrl;
        }
    }

    public void pausePlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.pausePlay();
            this.mNeedReplay = false;
        }
    }

    public void reStartPlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.seekTo(getCurrentPosition(), false);
            this.mPlayer.startPlay();
            PlayerEventBus.playerOnStart(BaseLivePlayBackPlayerViewCtr.class);
            this.mNeedReplay = true;
        }
    }

    public void stopPlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.stopPlay();
        }
    }

    public void changeMode(String str, int i, float f) {
        this.mStartPos = f;
        this.mStreamId = str;
        this.mProtocol = i;
        stopPlay();
        initPlayer(this.mListener);
        startPlay(str, i, f, this.mStreamUrl, this.mStreamUrlList);
    }

    public void seekTo(long j, boolean z) {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.seekTo(j, z);
        }
    }

    public void setSpeed(float f) {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.setSpeed(f);
        }
    }

    public void setVolume(float f) {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.setVolume(f);
        }
    }

    public float getSpeed() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            return iJKPlayer.getSpeed();
        }
        return 0.0f;
    }

    public long getDuration() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            return iJKPlayer.getDuration().longValue();
        }
        return 0;
    }

    public long getCurrentPosition() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            return iJKPlayer.getCurrentPosition().longValue();
        }
        return 0;
    }

    public long getCurrentSeiTimetamp() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            return iJKPlayer.getCurrentSeiTimetamp().longValue();
        }
        return 0;
    }

    public boolean isPlaying() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            return iJKPlayer.isPlaying();
        }
        return false;
    }

    public IJKPlayer getPlayer() {
        return this.mPlayer;
    }

    public PlayerTextureView getTextureView() {
        LivePlayBackPlayerView livePlayBackPlayerView = this.mPlayerView;
        if (livePlayBackPlayerView != null) {
            return livePlayBackPlayerView.getTextureView();
        }
        return null;
    }

    public void onResume() {
        IJKPlayer iJKPlayer;
        if (this.mNeedReplay && (iJKPlayer = this.mPlayer) != null && iJKPlayer.needResume()) {
            reStartPlay();
        }
    }

    public void onPause(boolean z) {
        IJKPlayer iJKPlayer;
        if (z && (iJKPlayer = this.mPlayer) != null) {
            iJKPlayer.pausePlay();
        }
    }

    public void onDestroy() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.destroyPlayer();
            this.mPlayer = null;
        }
    }

    public void setContentMode(int i) {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.setContentMode(i);
        }
    }

    public void showHelpTitle(boolean z) {
        LivePlayBackPlayerView livePlayBackPlayerView = this.mPlayerView;
        if (livePlayBackPlayerView != null) {
            livePlayBackPlayerView.showHelpTitle(z);
        }
    }

    public int getCurrentUrlIndex() {
        return this.mUrlNum;
    }

    public long getHasBufferingTime() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer == null || !iJKPlayer.isPlaying()) {
            return 0;
        }
        return this.mPlayer.getHasBufferingTime();
    }

    public long getTipsTimeoutMax() {
        return this.mLoadingTipsMin;
    }

    public boolean isCanShowLoadingTips() {
        List<AddressBean> list = this.mStreamUrlList;
        if (list == null || (list.size() > 1 && this.mStreamUrlList.size() != this.mSwitchedUrlMap.size())) {
            return true;
        }
        return false;
    }

    public void setLoadingView(BaseLoadingView baseLoadingView) {
        this.mLoadingView = baseLoadingView;
    }
}
