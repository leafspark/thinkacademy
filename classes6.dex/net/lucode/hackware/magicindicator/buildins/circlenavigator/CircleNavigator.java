package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.abs.IPagerNavigator;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class CircleNavigator extends View implements IPagerNavigator {
    private OnCircleClickListener mCircleClickListener;
    private int mCircleColor;
    private List<PointF> mCirclePoints = new ArrayList();
    private int mCircleSpacing;
    private int mCurrentIndex;
    private float mDownX;
    private float mDownY;
    private boolean mFollowTouch = true;
    private float mIndicatorX;
    private Paint mPaint = new Paint(1);
    private int mRadius;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private int mStrokeWidth;
    private int mTotalCount;
    private int mTouchSlop;
    private boolean mTouchable;

    public interface OnCircleClickListener {
        void onClick(int i);
    }

    public void onAttachToMagicIndicator() {
    }

    public void onDetachFromMagicIndicator() {
    }

    public void onPageScrollStateChanged(int i) {
    }

    public CircleNavigator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mRadius = UIUtil.dip2px(context, 3.0d);
        this.mCircleSpacing = UIUtil.dip2px(context, 8.0d);
        this.mStrokeWidth = UIUtil.dip2px(context, 1.0d);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i2 = this.mTotalCount;
            return (this.mStrokeWidth * 2) + (this.mRadius * i2 * 2) + ((i2 - 1) * this.mCircleSpacing) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            return 0;
        } else {
            return size;
        }
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.mRadius * 2) + (this.mStrokeWidth * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mCircleColor);
        drawCircles(canvas);
        drawIndicator(canvas);
    }

    private void drawCircles(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
        int size = this.mCirclePoints.size();
        for (int i = 0; i < size; i++) {
            PointF pointF = this.mCirclePoints.get(i);
            canvas.drawCircle(pointF.x, pointF.y, (float) this.mRadius, this.mPaint);
        }
    }

    private void drawIndicator(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        if (this.mCirclePoints.size() > 0) {
            canvas.drawCircle(this.mIndicatorX, (float) ((int) ((((float) getHeight()) / 2.0f) + 0.5f)), (float) this.mRadius, this.mPaint);
        }
    }

    private void prepareCirclePoints() {
        this.mCirclePoints.clear();
        if (this.mTotalCount > 0) {
            int height = (int) ((((float) getHeight()) / 2.0f) + 0.5f);
            int i = this.mRadius;
            int i2 = (i * 2) + this.mCircleSpacing;
            int paddingLeft = i + ((int) ((((float) this.mStrokeWidth) / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i3 = 0; i3 < this.mTotalCount; i3++) {
                this.mCirclePoints.add(new PointF((float) paddingLeft, (float) height));
                paddingLeft += i2;
            }
            this.mIndicatorX = this.mCirclePoints.get(this.mCurrentIndex).x;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.mFollowTouch && !this.mCirclePoints.isEmpty()) {
            int min = Math.min(this.mCirclePoints.size() - 1, i);
            int min2 = Math.min(this.mCirclePoints.size() - 1, i + 1);
            PointF pointF = this.mCirclePoints.get(min);
            this.mIndicatorX = pointF.x + ((this.mCirclePoints.get(min2).x - pointF.x) * this.mStartInterpolator.getInterpolation(f));
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.mCircleClickListener != null && Math.abs(x - this.mDownX) <= ((float) this.mTouchSlop) && Math.abs(y - this.mDownY) <= ((float) this.mTouchSlop)) {
                float f = Float.MAX_VALUE;
                int i = 0;
                for (int i2 = 0; i2 < this.mCirclePoints.size(); i2++) {
                    float abs = Math.abs(this.mCirclePoints.get(i2).x - x);
                    if (abs < f) {
                        i = i2;
                        f = abs;
                    }
                }
                this.mCircleClickListener.onClick(i);
            }
        } else if (this.mTouchable) {
            this.mDownX = x;
            this.mDownY = y;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onPageSelected(int i) {
        this.mCurrentIndex = i;
        if (!this.mFollowTouch) {
            this.mIndicatorX = this.mCirclePoints.get(i).x;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        prepareCirclePoints();
    }

    public void notifyDataSetChanged() {
        prepareCirclePoints();
        invalidate();
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRadius(int i) {
        this.mRadius = i;
        prepareCirclePoints();
        invalidate();
    }

    public int getCircleColor() {
        return this.mCircleColor;
    }

    public void setCircleColor(int i) {
        this.mCircleColor = i;
        invalidate();
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        invalidate();
    }

    public int getCircleSpacing() {
        return this.mCircleSpacing;
    }

    public void setCircleSpacing(int i) {
        this.mCircleSpacing = i;
        prepareCirclePoints();
        invalidate();
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public int getCircleCount() {
        return this.mTotalCount;
    }

    public void setCircleCount(int i) {
        this.mTotalCount = i;
    }

    public boolean isTouchable() {
        return this.mTouchable;
    }

    public void setTouchable(boolean z) {
        this.mTouchable = z;
    }

    public boolean isFollowTouch() {
        return this.mFollowTouch;
    }

    public void setFollowTouch(boolean z) {
        this.mFollowTouch = z;
    }

    public OnCircleClickListener getCircleClickListener() {
        return this.mCircleClickListener;
    }

    public void setCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (!this.mTouchable) {
            this.mTouchable = true;
        }
        this.mCircleClickListener = onCircleClickListener;
    }
}
