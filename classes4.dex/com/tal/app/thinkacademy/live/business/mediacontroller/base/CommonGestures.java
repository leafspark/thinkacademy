package com.tal.app.thinkacademy.live.business.mediacontroller.base;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.core.view.GestureDetectorCompat;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import java.lang.ref.WeakReference;

public class CommonGestures {
    public static final int SCALE_STATE_BEGIN = 0;
    public static final int SCALE_STATE_END = 2;
    public static final int SCALE_STATE_SCALEING = 1;
    private WeakReference<Context> mContext;
    private GestureDetectorCompat mDoubleTapGestureDetector;
    /* access modifiers changed from: private */
    public boolean mDown = false;
    /* access modifiers changed from: private */
    public boolean mGestureEnabled;
    /* access modifiers changed from: private */
    public boolean mIsMoving = false;
    /* access modifiers changed from: private */
    public boolean mIsSeekTo = false;
    /* access modifiers changed from: private */
    public boolean mIsYmoving = false;
    /* access modifiers changed from: private */
    public GestureTouchListener mListener;
    private ScaleGestureDetector mScaleDetector;
    private GestureDetectorCompat mTapGestureDetector;
    /* access modifiers changed from: private */
    public int mWindowHeight;
    /* access modifiers changed from: private */
    public int mWindowWidth;

    public interface GestureTouchListener {
        boolean canSeek();

        void onDoubleTap();

        void onGestureBegin();

        void onGestureEnd();

        void onLeftSlide(float f);

        void onRightSlide(float f);

        void onScale(float f, int i);

        void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onSeekControl(float f);

        void onSeekTo();

        void onSingleTap();
    }

    public CommonGestures(WeakReference<Context> weakReference) {
        this.mContext = weakReference;
        this.mDoubleTapGestureDetector = new GestureDetectorCompat((Context) this.mContext.get(), new DoubleTapGestureListener());
        this.mTapGestureDetector = new GestureDetectorCompat((Context) this.mContext.get(), new TapGestureListener());
        this.mScaleDetector = new ScaleGestureDetector((Context) this.mContext.get(), new ScaleDetectorListener());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mListener == null) {
            return false;
        }
        if (this.mTapGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1) {
            try {
                ScaleGestureDetector scaleGestureDetector = this.mScaleDetector;
                if (scaleGestureDetector != null && scaleGestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mDoubleTapGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            this.mListener.onGestureEnd();
            this.mIsMoving = false;
            if (this.mIsSeekTo) {
                this.mIsSeekTo = false;
                if (this.mListener.canSeek()) {
                    this.mListener.onSeekTo();
                }
            }
        }
        return false;
    }

    private class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
        private TapGestureListener() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (CommonGestures.this.mListener == null) {
                return true;
            }
            CommonGestures.this.mListener.onSingleTap();
            return true;
        }
    }

    private class ScaleDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
        private ScaleDetectorListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (CommonGestures.this.mListener != null && CommonGestures.this.mGestureEnabled) {
                CommonGestures.this.mListener.onScale(scaleGestureDetector.getScaleFactor(), 1);
            }
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (CommonGestures.this.mListener != null && CommonGestures.this.mGestureEnabled) {
                CommonGestures.this.mListener.onScale(0.0f, 2);
            }
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (CommonGestures.this.mListener == null || !CommonGestures.this.mGestureEnabled) {
                return true;
            }
            CommonGestures.this.mListener.onScale(0.0f, 0);
            return true;
        }
    }

    private class DoubleTapGestureListener extends GestureDetector.SimpleOnGestureListener {
        private float disX;
        private float disY;
        private float xOld;
        private float yOld;

        private DoubleTapGestureListener() {
            this.disY = 0.0f;
            this.disX = 0.0f;
            this.yOld = 0.0f;
            this.xOld = 0.0f;
        }

        public boolean onDown(MotionEvent motionEvent) {
            boolean unused = CommonGestures.this.mDown = true;
            this.xOld = motionEvent.getX();
            int unused2 = CommonGestures.this.mWindowWidth = ScreenUtils.getScreenWidth();
            int unused3 = CommonGestures.this.mWindowHeight = ScreenUtils.getScreenHeight();
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawX2 = motionEvent2.getRawX();
            float rawY = motionEvent.getRawY();
            float rawY2 = motionEvent2.getRawY();
            float abs = Math.abs(rawX - rawX2);
            float abs2 = Math.abs(rawY - rawY2);
            if (!(CommonGestures.this.mListener == null || !CommonGestures.this.mGestureEnabled || motionEvent == null || motionEvent2 == null)) {
                if (CommonGestures.this.mDown) {
                    CommonGestures.this.mListener.onGestureBegin();
                    boolean unused = CommonGestures.this.mDown = false;
                }
                if (abs <= 20.0f || abs2 >= 30.0f) {
                    if (!CommonGestures.this.mIsMoving) {
                        boolean unused2 = CommonGestures.this.mIsYmoving = true;
                    }
                } else if (!CommonGestures.this.mIsMoving) {
                    boolean unused3 = CommonGestures.this.mIsYmoving = false;
                }
                if (!CommonGestures.this.mIsMoving) {
                    boolean unused4 = CommonGestures.this.mIsMoving = true;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(motionEvent2.getY(0) - y) * 2.0f > Math.abs(motionEvent2.getX(0) - x) && CommonGestures.this.mIsYmoving) {
                    double d = (double) x;
                    if (d > ((double) CommonGestures.this.mWindowWidth) / 2.0d) {
                        CommonGestures.this.mListener.onRightSlide((y - motionEvent2.getY(0)) / ((float) CommonGestures.this.mWindowHeight));
                    } else if (d < ((double) CommonGestures.this.mWindowWidth) / 2.0d) {
                        CommonGestures.this.mListener.onLeftSlide((y - motionEvent2.getY(0)) / ((float) CommonGestures.this.mWindowHeight));
                    }
                    CommonGestures.this.mListener.onScroll(motionEvent, motionEvent2, f, f2);
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                } else if (!CommonGestures.this.mIsYmoving) {
                    boolean unused5 = CommonGestures.this.mIsSeekTo = true;
                    if (CommonGestures.this.mListener.canSeek()) {
                        CommonGestures.this.mListener.onSeekControl((motionEvent2.getX(0) - x) / ((float) CommonGestures.this.mWindowWidth));
                    }
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (CommonGestures.this.mListener != null && CommonGestures.this.mGestureEnabled) {
                CommonGestures.this.mListener.onDoubleTap();
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setTouchListener(GestureTouchListener gestureTouchListener, boolean z) {
        this.mListener = gestureTouchListener;
        this.mGestureEnabled = z;
    }
}
