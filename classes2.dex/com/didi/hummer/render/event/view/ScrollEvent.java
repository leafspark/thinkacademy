package com.didi.hummer.render.event.view;

import com.didi.hummer.render.event.base.Event;

public class ScrollEvent extends Event {
    public static final String HM_EVENT_TYPE_SCROLL = "scroll";
    public static final int HM_SCROLL_STATE_BEGAN = 1;
    public static final int HM_SCROLL_STATE_ENDED = 3;
    public static final int HM_SCROLL_STATE_NORMAL = 0;
    public static final int HM_SCROLL_STATE_SCROLL = 2;
    public static final int HM_SCROLL_STATE_SCROLL_UP = 4;
    private float dx;
    private float dy;
    private float offsetX;
    private float offsetY;

    public void setDx(float f) {
        this.dx = f;
    }

    public void setDy(float f) {
        this.dy = f;
    }

    public void setOffsetX(float f) {
        this.offsetX = f;
    }

    public void setOffsetY(float f) {
        this.offsetY = f;
    }
}
