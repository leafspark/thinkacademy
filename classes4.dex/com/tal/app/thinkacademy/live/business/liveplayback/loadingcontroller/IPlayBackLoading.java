package com.tal.app.thinkacademy.live.business.liveplayback.loadingcontroller;

import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;

interface IPlayBackLoading {
    void onBufferComplete();

    void onBufferStart();

    void onComplete();

    void onOpenStart();

    void onPlayError();

    void onPlayFail(MediaErrorInfo mediaErrorInfo);

    void onPlaySuccess();
}
