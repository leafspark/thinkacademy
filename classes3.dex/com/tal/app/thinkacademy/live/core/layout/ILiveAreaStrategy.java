package com.tal.app.thinkacademy.live.core.layout;

public interface ILiveAreaStrategy {
    void destroy();

    LiveAreaLayoutParams getFuncLp();

    LiveAreaLayoutParams getHeadLp();

    LiveAreaLayoutParams getMsgLp();

    LiveAreaLayoutParams getPptLp();

    LiveAreaLayoutParams getScreenLp();

    LiveAreaLayoutParams getTitleLp();

    LiveAreaLayoutParams getVisibleLp();
}
