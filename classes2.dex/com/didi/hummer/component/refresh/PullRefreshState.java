package com.didi.hummer.component.refresh;

public @interface PullRefreshState {
    public static final int IDLE = 0;
    public static final int REFRESHING = 2;
    public static final int START_PULL_DOWN = 1;
}
