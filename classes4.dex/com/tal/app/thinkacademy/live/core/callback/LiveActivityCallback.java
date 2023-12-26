package com.tal.app.thinkacademy.live.core.callback;

import android.view.KeyEvent;
import android.view.MotionEvent;

public interface LiveActivityCallback {
    boolean onActivityDispatchKeyEvent(KeyEvent keyEvent);

    boolean onActivityDispatchTouchEvent(MotionEvent motionEvent);
}
