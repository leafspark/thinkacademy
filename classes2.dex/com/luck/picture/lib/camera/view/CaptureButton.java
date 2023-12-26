package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.camera.CheckPermission;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.tools.DoubleUtils;

public class CaptureButton extends View {
    public static final int STATE_BAN = 5;
    public static final int STATE_CLICK_RECORD_END = 7;
    public static final int STATE_CLICK_RECORD_START = 6;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    /* access modifiers changed from: private */
    public float button_inside_radius;
    /* access modifiers changed from: private */
    public float button_outside_radius;
    private float button_radius;
    private int button_size;
    private int button_state;
    /* access modifiers changed from: private */
    public CaptureListener captureLisenter;
    private float center_X;
    private float center_Y;
    private int duration;
    private float event_Y;
    private int inside_color = -1;
    /* access modifiers changed from: private */
    public int inside_reduce_size;
    private boolean isTakeCamera = true;
    private LongPressRunnable longPressRunnable;
    private Paint mPaint;
    private int min_duration;
    /* access modifiers changed from: private */
    public int outside_add_size;
    private int outside_color = -287515428;
    private float progress;
    private int progress_color = -300503530;
    private int recorded_time;
    private RectF rectF;
    /* access modifiers changed from: private */
    public int state;
    private float strokeWidth;
    /* access modifiers changed from: private */
    public RecordCountDownTimer timer;

    public CaptureButton(Context context) {
        super(context);
    }

    public CaptureButton(Context context, int i) {
        super(context);
        this.button_size = i;
        float f = ((float) i) / 2.0f;
        this.button_radius = f;
        this.button_outside_radius = f;
        this.button_inside_radius = f * 0.75f;
        this.strokeWidth = (float) (i / 15);
        int i2 = i / 8;
        this.outside_add_size = i2;
        this.inside_reduce_size = i2;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new LongPressRunnable();
        this.state = 1;
        this.button_state = CustomCameraView.BUTTON_STATE_BOTH;
        this.duration = 10000;
        this.min_duration = 1500;
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        this.center_X = (float) (((i4 * 2) + i3) / 2);
        this.center_Y = (float) ((i3 + (i4 * 2)) / 2);
        float f2 = this.center_X;
        float f3 = this.button_radius;
        int i5 = this.outside_add_size;
        float f4 = this.strokeWidth;
        float f5 = this.center_Y;
        this.rectF = new RectF(f2 - ((((float) i5) + f3) - (f4 / 2.0f)), f5 - ((((float) i5) + f3) - (f4 / 2.0f)), f2 + ((((float) i5) + f3) - (f4 / 2.0f)), f5 + ((f3 + ((float) i5)) - (f4 / 2.0f)));
        this.timer = new RecordCountDownTimer((long) this.duration, 500);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        setMeasuredDimension((i4 * 2) + i3, i3 + (i4 * 2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.outside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(this.inside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state == 4) {
            this.mPaint.setColor(this.progress_color);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        CaptureListener captureListener;
        int i;
        if (this.isTakeCamera) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && (captureListener = this.captureLisenter) != null && this.state == 4 && ((i = this.button_state) == 258 || i == 259)) {
                        captureListener.recordZoom(this.event_Y - motionEvent.getY());
                    }
                } else if (this.button_state != 258) {
                    handlerPressByState();
                } else if (this.state == 6) {
                    this.longPressRunnable.run();
                } else {
                    handlerPressByState();
                }
            } else if (motionEvent.getPointerCount() <= 1 && this.state == 1) {
                this.event_Y = motionEvent.getY();
                int i2 = this.button_state;
                if (i2 != 258) {
                    this.state = 2;
                    if (i2 == 258 || i2 == 259) {
                        postDelayed(this.longPressRunnable, 500);
                    }
                } else if (this.state != 3) {
                    this.state = 6;
                }
            }
        }
        return true;
    }

    private void handlerPressByState() {
        int i;
        removeCallbacks(this.longPressRunnable);
        int i2 = this.state;
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                this.timer.cancel();
                recordEnd();
            }
        } else if (this.captureLisenter == null || !((i = this.button_state) == 257 || i == 259)) {
            this.state = 1;
        } else {
            startCaptureAnimation(this.button_inside_radius);
        }
        this.state = 1;
    }

    public void recordEnd() {
        CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            int i = this.recorded_time;
            if (i < this.min_duration) {
                captureListener.recordShort((long) i);
            } else {
                captureListener.recordEnd((long) i);
            }
        }
        resetRecordAnim();
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        invalidate();
        float f = this.button_outside_radius;
        float f2 = this.button_radius;
        startRecordAnimation(f, f2, this.button_inside_radius, 0.75f * f2);
    }

    private void startCaptureAnimation(float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, 0.75f * f, f});
        ofFloat.addUpdateListener(new CaptureButton$$ExternalSyntheticLambda0(this));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }

            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (CaptureButton.this.captureLisenter != null) {
                    CaptureButton.this.captureLisenter.takePictures();
                }
                int unused = CaptureButton.this.state = 5;
            }
        });
        ofFloat.setDuration(50);
        ofFloat.start();
    }

    public /* synthetic */ void lambda$startCaptureAnimation$0$CaptureButton(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* access modifiers changed from: private */
    public void startRecordAnimation(float f, float f2, float f3, float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{f3, f4});
        ofFloat.addUpdateListener(new CaptureButton$$ExternalSyntheticLambda1(this));
        ofFloat2.addUpdateListener(new CaptureButton$$ExternalSyntheticLambda2(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!DoubleUtils.isFastDoubleClick()) {
                    if (CaptureButton.this.state == 3) {
                        if (CaptureButton.this.captureLisenter != null) {
                            CaptureButton.this.captureLisenter.recordStart();
                        }
                        int unused = CaptureButton.this.state = 4;
                        CaptureButton.this.timer.start();
                        return;
                    }
                    int unused2 = CaptureButton.this.state = 1;
                }
            }
        });
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(100);
        animatorSet.start();
    }

    public /* synthetic */ void lambda$startRecordAnimation$1$CaptureButton(ValueAnimator valueAnimator) {
        this.button_outside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public /* synthetic */ void lambda$startRecordAnimation$2$CaptureButton(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* access modifiers changed from: private */
    public void updateProgress(long j) {
        int i = this.duration;
        this.recorded_time = (int) (((long) i) - j);
        this.progress = 360.0f - ((((float) j) / ((float) i)) * 360.0f);
        invalidate();
        CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            captureListener.recordUpdateTime(j);
        }
    }

    private class RecordCountDownTimer extends CountDownTimer {
        RecordCountDownTimer(long j, long j2) {
            super(j, j2);
        }

        public void onTick(long j) {
            CaptureButton.this.updateProgress(j);
        }

        public void onFinish() {
            CaptureButton.this.recordEnd();
        }
    }

    private class LongPressRunnable implements Runnable {
        private LongPressRunnable() {
        }

        public void run() {
            int unused = CaptureButton.this.state = 3;
            if (CheckPermission.getRecordState() != 1) {
                int unused2 = CaptureButton.this.state = 1;
                if (CaptureButton.this.captureLisenter != null) {
                    CaptureButton.this.captureLisenter.recordError();
                    return;
                }
            }
            CaptureButton captureButton = CaptureButton.this;
            captureButton.startRecordAnimation(captureButton.button_outside_radius, CaptureButton.this.button_outside_radius + ((float) CaptureButton.this.outside_add_size), CaptureButton.this.button_inside_radius, CaptureButton.this.button_inside_radius - ((float) CaptureButton.this.inside_reduce_size));
        }
    }

    public void setDuration(int i) {
        int i2 = i + ResultCode.KARAOKE_SUCCESS;
        this.duration = i2;
        this.timer = new RecordCountDownTimer((long) i2, (long) (i2 / 360));
    }

    public void setMinDuration(int i) {
        this.min_duration = i;
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setButtonFeatures(int i) {
        this.button_state = i;
    }

    public int getButtonFeatures() {
        return this.button_state;
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.isTakeCamera = z;
    }

    public void resetState() {
        this.state = 1;
    }
}
