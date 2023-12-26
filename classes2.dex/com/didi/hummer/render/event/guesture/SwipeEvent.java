package com.didi.hummer.render.event.guesture;

import com.didi.hummer.render.event.base.Event;

public class SwipeEvent extends Event {
    public static final int DIRECTION_DOWN = 8;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 4;
    private int direction;

    public void setDirection(int i) {
        this.direction = i;
    }
}
