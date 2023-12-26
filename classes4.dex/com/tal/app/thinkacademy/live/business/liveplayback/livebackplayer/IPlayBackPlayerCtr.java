package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import com.tal.app.thinkacademy.common.entity.AddressBean;
import java.util.List;

public interface IPlayBackPlayerCtr {
    void changeMode(String str, int i, float f);

    long getCurrentPosition();

    long getDuration();

    float getSpeed();

    boolean isPlaying();

    void pausePlay();

    void reStartPlay();

    void reTryPlay();

    void seekTo(long j, boolean z);

    void setContentMode(int i);

    void setSpeed(float f);

    void setVolume(float f);

    void startPlay(String str, int i, float f, String str2, List<AddressBean> list);

    void stopPlay();
}
