package com.tal.app.thinkacademy.live.core.callback;

import android.view.KeyEvent;
import android.view.MotionEvent;

public class LiveActivityCallbackAdapter implements LiveActivityCallback {
    public boolean onActivityDispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean onActivityDispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
