package com.didi.hummer.component.scroller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bumptech.glide.request.target.Target;

public class ScrollViewStateObserver {
    private static final int CHECK_SCROLL_STOP_DELAY_MILLIS = 40;
    private static final int MSG_SCROLL = 1;
    /* access modifiers changed from: private */
    public int mCurScroll = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        private int mLastScroll = Target.SIZE_ORIGINAL;

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            int access$000 = ScrollViewStateObserver.this.mCurScroll;
            if (ScrollViewStateObserver.this.mIsTouched || this.mLastScroll != access$000) {
                this.mLastScroll = access$000;
                ScrollViewStateObserver.this.restartCheckStopTiming();
            } else {
                this.mLastScroll = Target.SIZE_ORIGINAL;
                ScrollViewStateObserver.this.setScrollState(4);
            }
            return true;
        }
    });
    private boolean mIsScrollStarted = false;
    /* access modifiers changed from: private */
    public boolean mIsTouched = false;
    private OnScrollStateListener mOnScrollStateListener;
    private int mScrollState = 0;

    public interface OnScrollStateListener {
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_SCROLLING = 2;
        public static final int SCROLL_STATE_SCROLL_FINISH = 4;
        public static final int SCROLL_STATE_SCROLL_START = 1;
        public static final int SCROLL_STATE_SCROLL_TOUCH_UP = 3;

        void onScrollStateChanged(int i);
    }

    /* access modifiers changed from: private */
    public void restartCheckStopTiming() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 40);
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void setOnScrollStateListener(OnScrollStateListener onScrollStateListener) {
        this.mOnScrollStateListener = onScrollStateListener;
    }

    public void onInterceptTouchEvent(MotionEvent motionEvent) {
        handleDownEvent(motionEvent);
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        handleUpEvent(motionEvent);
    }

    public void onScrollChanged(int i, int i2) {
        this.mCurScroll = i;
        if (!this.mIsScrollStarted) {
            this.mIsScrollStarted = true;
            setScrollState(1);
        }
        if (this.mIsTouched) {
            setScrollState(2);
        } else {
            setScrollState(3);
        }
    }

    private void handleDownEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mIsScrollStarted = false;
            this.mIsTouched = true;
        }
    }

    private void handleUpEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.mIsTouched = false;
            restartCheckStopTiming();
        }
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            OnScrollStateListener onScrollStateListener = this.mOnScrollStateListener;
            if (onScrollStateListener != null) {
                onScrollStateListener.onScrollStateChanged(i);
            }
        }
    }
}
