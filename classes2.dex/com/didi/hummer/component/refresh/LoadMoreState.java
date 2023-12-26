package com.didi.hummer.component.refresh;

public @interface LoadMoreState {
    public static final int IDLE = 0;
    public static final int LOADING = 1;
    public static final int NO_MORE_DATA = 2;
}
