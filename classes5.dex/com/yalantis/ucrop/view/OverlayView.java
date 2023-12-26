package com.yalantis.ucrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.luck.picture.lib.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView extends View {
    private static final long CROP_SIZE_CHANGE_DURATION = 260;
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final boolean DEFAULT_DRAG_FRAME = true;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private static final long SMOOTH_CENTER_DURATION = 1000;
    private ValueAnimator cropSizeChangeAnimator;
    private boolean isDragCenter;
    private boolean isDragFrame;
    /* access modifiers changed from: private */
    public OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private final Path mCircularPath;
    private final Paint mCropFrameCornersPaint;
    private final Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private final Paint mCropGridPaint;
    private int mCropGridRowCount;
    private final int mCropRectCornerTouchAreaLineLength;
    private final int mCropRectMinSize;
    /* access modifiers changed from: private */
    public final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedBorderColor;
    private int mDimmedColor;
    private final Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private int mStrokeWidth;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private final int mTouchPointThreshold;
    private ValueAnimator smoothAnimator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mStrokeWidth = 1;
        this.isDragFrame = true;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.mFreestyleCropMode = z ? 1 : 0;
    }

    public void setDragFrame(boolean z) {
        this.isDragFrame = z;
    }

    public void setDragSmoothToCenter(boolean z) {
        this.isDragCenter = z;
    }

    public void setDimmedStrokeWidth(int i) {
        this.mStrokeWidth = i;
        Paint paint = this.mDimmedStrokePaint;
        if (paint != null) {
            paint.setStrokeWidth((float) i);
        }
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public void setFreestyleCropMode(int i) {
        this.mFreestyleCropMode = i;
        postInvalidate();
    }

    public void setCircleDimmedLayer(boolean z) {
        this.mCircleDimmedLayer = z;
    }

    public void setCropGridRowCount(int i) {
        this.mCropGridRowCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridColumnCount(int i) {
        this.mCropGridColumnCount = i;
        this.mGridPoints = null;
    }

    public void setShowCropFrame(boolean z) {
        this.mShowCropFrame = z;
    }

    public void setShowCropGrid(boolean z) {
        this.mShowCropGrid = z;
    }

    public void setDimmedColor(int i) {
        this.mDimmedColor = i;
    }

    public void setCropFrameStrokeWidth(int i) {
        this.mCropFramePaint.setStrokeWidth((float) i);
    }

    public void setCropGridStrokeWidth(int i) {
        this.mCropGridPaint.setStrokeWidth((float) i);
    }

    public void setDimmedBorderColor(int i) {
        this.mDimmedBorderColor = i;
        Paint paint = this.mDimmedStrokePaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setCropFrameColor(int i) {
        this.mCropFramePaint.setColor(i);
    }

    public void setCropGridColor(int i) {
        this.mCropGridPaint.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        boolean z = this.mTargetAspectRatio != CropImageView.DEFAULT_ASPECT_RATIO;
        this.mTargetAspectRatio = f;
        if (this.mThisWidth > 0) {
            RectF rectF = new RectF(getCropViewRect());
            setupCropBounds();
            postInvalidate();
            if (z) {
                cropSizeChangedAnim(rectF);
                return;
            }
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int i = this.mThisWidth;
        float f = this.mTargetAspectRatio;
        int i2 = (int) (((float) i) / f);
        int i3 = this.mThisHeight;
        if (i2 > i3) {
            int i4 = (int) (((float) i3) * f);
            int i5 = (i - i4) / 2;
            this.mCropViewRect.set((float) (getPaddingLeft() + i5), (float) getPaddingTop(), (float) (getPaddingLeft() + i4 + i5), (float) (getPaddingTop() + this.mThisHeight));
        } else {
            int i6 = (i3 - i2) / 2;
            this.mCropViewRect.set((float) getPaddingLeft(), (float) (getPaddingTop() + i6), (float) (getPaddingLeft() + this.mThisWidth), (float) (getPaddingTop() + i2 + i6));
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    /* access modifiers changed from: private */
    public void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void init() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    private void cropSizeChangedAnim(final RectF rectF) {
        final float f = this.mCropViewRect.left - rectF.left;
        final float f2 = this.mCropViewRect.top - rectF.top;
        ValueAnimator valueAnimator = this.cropSizeChangeAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.cropSizeChangeAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(new LinearInterpolator());
            this.cropSizeChangeAnimator.setDuration(CROP_SIZE_CHANGE_DURATION);
            this.cropSizeChangeAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (OverlayView.this.mCallback != null) {
                        OverlayView.this.mCallback.onCropRectUpdated(OverlayView.this.mCropViewRect);
                    }
                }
            });
        }
        this.cropSizeChangeAnimator.setFloatValues(new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f});
        this.cropSizeChangeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f = f * floatValue;
                float f2 = floatValue * f2;
                OverlayView.this.mCropViewRect.set(new RectF(rectF.left + f, rectF.top + f2, rectF.right - f, rectF.bottom - f2));
                OverlayView.this.updateGridPoints();
                OverlayView.this.postInvalidate();
            }
        });
        this.cropSizeChangeAnimator.start();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                ValueAnimator valueAnimator = this.smoothAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                int currentTouchIndex = getCurrentTouchIndex(x, y);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                if (!(currentTouchIndex == -1 || currentTouchIndex == 4)) {
                    z = true;
                }
                if (!z) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < CropImageView.DEFAULT_ASPECT_RATIO) {
                    this.mPreviousTouchX = x;
                    this.mPreviousTouchY = y;
                }
                return z;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float min = Math.min(Math.max(x, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
                float min2 = Math.min(Math.max(y, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
                updateCropViewRect(min, min2);
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
                if (this.isDragCenter) {
                    smoothToCenter();
                }
            }
        }
        return false;
    }

    private void updateCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        int i = this.mCurrentTouchCornerIndex;
        boolean z = true;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.mTempRect.offset(f - this.mPreviousTouchX, f2 - this.mPreviousTouchY);
                            if (this.mTempRect.left > ((float) getLeft()) && this.mTempRect.top > ((float) getTop()) && this.mTempRect.right < ((float) getRight()) && this.mTempRect.bottom < ((float) getBottom())) {
                                this.mCropViewRect.set(this.mTempRect);
                                updateGridPoints();
                                postInvalidate();
                                return;
                            }
                            return;
                        }
                    } else if (this.isDragFrame) {
                        this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                    }
                } else if (this.isDragFrame) {
                    this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                }
            } else if (this.isDragFrame) {
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
            }
        } else if (this.isDragFrame) {
            this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
        }
        boolean z2 = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        if (this.mTempRect.width() < ((float) this.mCropRectMinSize)) {
            z = false;
        }
        RectF rectF = this.mCropViewRect;
        rectF.set(z ? this.mTempRect.left : rectF.left, (z2 ? this.mTempRect : this.mCropViewRect).top, (z ? this.mTempRect : this.mCropViewRect).right, (z2 ? this.mTempRect : this.mCropViewRect).bottom);
        if (z2 || z) {
            updateGridPoints();
            postInvalidate();
        }
    }

    private int getCurrentTouchIndex(float f, float f2) {
        double d = (double) this.mTouchPointThreshold;
        int i = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f - this.mCropGridCorners[i2]), 2.0d) + Math.pow((double) (f2 - this.mCropGridCorners[i2 + 1]), 2.0d));
            if (sqrt < d) {
                i = i2 / 2;
                d = sqrt;
            }
        }
        if (this.mFreestyleCropMode != 1 || i >= 0 || !this.mCropViewRect.contains(f, f2)) {
            return i;
        }
        return 4;
    }

    /* access modifiers changed from: protected */
    public void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[((this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4))];
                int i = 0;
                int i2 = 0;
                while (i < this.mCropGridRowCount) {
                    int i3 = i2 + 1;
                    this.mGridPoints[i2] = this.mCropViewRect.left;
                    int i4 = i3 + 1;
                    float f = ((float) i) + 1.0f;
                    this.mGridPoints[i3] = (this.mCropViewRect.height() * (f / ((float) (this.mCropGridRowCount + 1)))) + this.mCropViewRect.top;
                    int i5 = i4 + 1;
                    this.mGridPoints[i4] = this.mCropViewRect.right;
                    this.mGridPoints[i5] = (this.mCropViewRect.height() * (f / ((float) (this.mCropGridRowCount + 1)))) + this.mCropViewRect.top;
                    i++;
                    i2 = i5 + 1;
                }
                for (int i6 = 0; i6 < this.mCropGridColumnCount; i6++) {
                    int i7 = i2 + 1;
                    float f2 = ((float) i6) + 1.0f;
                    this.mGridPoints[i2] = (this.mCropViewRect.width() * (f2 / ((float) (this.mCropGridColumnCount + 1)))) + this.mCropViewRect.left;
                    int i8 = i7 + 1;
                    this.mGridPoints[i7] = this.mCropViewRect.top;
                    int i9 = i8 + 1;
                    this.mGridPoints[i8] = (this.mCropViewRect.width() * (f2 / ((float) (this.mCropGridColumnCount + 1)))) + this.mCropViewRect.left;
                    i2 = i9 + 1;
                    this.mGridPoints[i9] = this.mCropViewRect.bottom;
                }
            }
            float[] fArr = this.mGridPoints;
            if (fArr != null) {
                canvas.drawLines(fArr, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF = this.mTempRect;
            int i10 = this.mCropRectCornerTouchAreaLineLength;
            rectF.inset((float) i10, (float) (-i10));
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF2 = this.mTempRect;
            int i11 = this.mCropRectCornerTouchAreaLineLength;
            rectF2.inset((float) (-i11), (float) i11);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void processStyledAttributes(TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedBorderColor);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth((float) this.mStrokeWidth);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void smoothToCenter() {
        Point point = new Point((getRight() + getLeft()) / 2, (getTop() + getBottom()) / 2);
        final int centerY = (int) (((float) point.y) - this.mCropViewRect.centerY());
        final int centerX = (int) (((float) point.x) - this.mCropViewRect.centerX());
        final RectF rectF = new RectF(this.mCropViewRect);
        new RectF(this.mCropViewRect).offset((float) centerX, (float) centerY);
        ValueAnimator valueAnimator = this.smoothAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f});
        this.smoothAnimator = ofFloat;
        ofFloat.setDuration(SMOOTH_CENTER_DURATION);
        this.smoothAnimator.setInterpolator(new OvershootInterpolator(1.0f));
        this.smoothAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (OverlayView.this.mCallback != null) {
                    OverlayView.this.mCallback.onCropRectUpdated(OverlayView.this.mCropViewRect);
                }
            }
        });
        this.smoothAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float lastAnimationValue = CropImageView.DEFAULT_ASPECT_RATIO;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((float) centerX) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float floatValue2 = ((float) centerY) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OverlayView.this.mCropViewRect.set(new RectF(rectF.left + floatValue, rectF.top + floatValue2, rectF.right + floatValue, rectF.bottom + floatValue2));
                OverlayView.this.updateGridPoints();
                OverlayView.this.postInvalidate();
                if (OverlayView.this.mCallback != null) {
                    OverlayView.this.mCallback.postTranslate(((float) centerX) * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.lastAnimationValue), ((float) centerY) * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.lastAnimationValue));
                }
                this.lastAnimationValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.smoothAnimator.start();
    }
}
