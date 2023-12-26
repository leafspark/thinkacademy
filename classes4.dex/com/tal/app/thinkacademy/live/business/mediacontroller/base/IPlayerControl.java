package com.tal.app.thinkacademy.live.business.mediacontroller.base;

public interface IPlayerControl {
    void pause();

    void play();

    void seekTo(long j);

    void stop();

    void togglePlayer();
}
