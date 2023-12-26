package com.tal.app.thinkacademy.live.business.liveplayback.loadingcontroller;

import android.content.Context;
import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import com.tal.app.thinkacademy.lib.player.ijkplayer.config.AvformatOpenInputError;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.IPlayBackPlayerCtr;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;

public class LivePlayBackLoadingViewCtr implements IPlayBackLoading, IOnClickListener {
    Context mContext;
    BaseLoadingView mLoadingView;
    IPlayBackPlayerCtr mPlayBackPlayerCtr;
    private PlaybackLoadingListen mPlaybackLoadingListen;

    public interface PlaybackLoadingListen {
        void onSwitchListen();
    }

    public void onPlayError() {
    }

    public void setPlaybackLoadingListen(PlaybackLoadingListen playbackLoadingListen) {
        this.mPlaybackLoadingListen = playbackLoadingListen;
    }

    public LivePlayBackLoadingViewCtr(Context context) {
        this.mContext = context;
    }

    public void initView(BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider, String str) {
        TripleScreenPlayBackLoadingView tripleScreenPlayBackLoadingView = new TripleScreenPlayBackLoadingView(this.mContext);
        this.mLoadingView = tripleScreenPlayBackLoadingView;
        tripleScreenPlayBackLoadingView.setClickListener(this);
        iLiveRoomProvider.addView(baseLivePluginDriver, this.mLoadingView, str, LiveAreaContext.get().getScreenLp().newLp());
    }

    public void setPlayBackPlayerCtr(IPlayBackPlayerCtr iPlayBackPlayerCtr) {
        this.mPlayBackPlayerCtr = iPlayBackPlayerCtr;
    }

    public void onOpenStart() {
        this.mLoadingView.showLoading();
    }

    public void onPlaySuccess() {
        this.mLoadingView.hideView();
    }

    public void onBufferStart() {
        this.mLoadingView.showBufferLoad();
    }

    public void onBufferComplete() {
        this.mLoadingView.hideView();
    }

    public void onPlayFail(MediaErrorInfo mediaErrorInfo) {
        String str;
        String str2;
        if (NetworkUtils.NetworkType.NETWORK_NO == NetworkUtils.getNetworkType()) {
            str = this.mContext.getResources().getString(R.string.no_network);
        } else {
            if (AvformatOpenInputError.StaticFun.getError(mediaErrorInfo.getMPlayerErrorCode()) == null) {
                str2 = (mediaErrorInfo.getMErrorMsg() == null || StringUtils.isEmpty(mediaErrorInfo.getMErrorMsg())) ? "" : mediaErrorInfo.getMErrorMsg();
            } else {
                str2 = AvformatOpenInputError.StaticFun.getError(mediaErrorInfo.getMPlayerErrorCode()).getStr();
                if (StringUtils.isEmpty(str2)) {
                    str2 = AvformatOpenInputError.StaticFun.getError(mediaErrorInfo.getMPlayerErrorCode()).getTag();
                }
            }
            str = str2 + "(" + mediaErrorInfo.getMPlayerErrorCode() + ")";
        }
        this.mLoadingView.showError(true, str);
    }

    public void onComplete() {
        this.mLoadingView.showReplay();
    }

    public void onSwitchLine() {
        PlaybackLoadingListen playbackLoadingListen = this.mPlaybackLoadingListen;
        if (playbackLoadingListen != null) {
            playbackLoadingListen.onSwitchListen();
        }
    }

    public void onRetryClickListener() {
        this.mPlayBackPlayerCtr.reTryPlay();
    }

    public void onReplayClickListener() {
        this.mLoadingView.hideView();
        this.mPlayBackPlayerCtr.seekTo(0, false);
        this.mPlayBackPlayerCtr.reStartPlay();
    }
}
