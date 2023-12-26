package com.tal.user.global.trade.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tal.user.global.trade.util.TalTradeLogger;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;

public class TalTradeLoadingView extends View {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private static final String TAG = "AVLoadingIndicatorView";
    private final Runnable mDelayedHide = new Runnable() {
        public void run() {
            boolean unused = TalTradeLoadingView.this.mPostedHide = false;
            long unused2 = TalTradeLoadingView.this.mStartTime = -1;
            TalTradeLoadingView.this.setVisibility(8);
        }
    };
    private final Runnable mDelayedShow = new Runnable() {
        public void run() {
            boolean unused = TalTradeLoadingView.this.mPostedShow = false;
            if (!TalTradeLoadingView.this.mDismissed) {
                long unused2 = TalTradeLoadingView.this.mStartTime = System.currentTimeMillis();
                TalTradeLoadingView.this.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mDismissed = false;
    private Indicator mIndicator;
    private int mIndicatorColor = Color.parseColor("#ffffff");
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    /* access modifiers changed from: private */
    public boolean mPostedHide = false;
    /* access modifiers changed from: private */
    public boolean mPostedShow = false;
    private boolean mShouldStartAnimationDrawable;
    /* access modifiers changed from: private */
    public long mStartTime = -1;

    public TalTradeLoadingView(Context context) {
        super(context);
        init();
    }

    public TalTradeLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TalTradeLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
        setIndicator((Indicator) new BallSpinFadeLoaderIndicator());
    }

    public Indicator getIndicator() {
        return this.mIndicator;
    }

    public void setIndicator(Indicator indicator) {
        Indicator indicator2 = this.mIndicator;
        if (indicator2 != indicator) {
            if (indicator2 != null) {
                indicator2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.mIndicator);
            }
            this.mIndicator = indicator;
            setIndicatorColor(this.mIndicatorColor);
            if (indicator != null) {
                indicator.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        this.mIndicator.setColor(i);
    }

    public void setIndicator(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            if (!str.contains(".")) {
                sb.append(getClass().getPackage().getName());
                sb.append(".indicators");
                sb.append(".");
            }
            sb.append(str);
            try {
                setIndicator((Indicator) Class.forName(sb.toString()).newInstance());
            } catch (ClassNotFoundException unused) {
                Log.e(TAG, "Didn't find your class , check the name again !");
            } catch (InstantiationException e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            } catch (IllegalAccessException e2) {
                TalTradeLogger logger2 = TalTradeLoggerFactory.getLogger("");
                logger2.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e2);
            }
        }
    }

    public void smoothToShow() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        setVisibility(0);
    }

    public void smoothToHide() {
        startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
        setVisibility(8);
    }

    public void hide() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mStartTime;
        long j2 = currentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            setVisibility(8);
        } else if (!this.mPostedHide) {
            postDelayed(this.mDelayedHide, 500 - j2);
            this.mPostedHide = true;
        }
    }

    public void show() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mIndicator || super.verifyDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void startAnimation() {
        if (getVisibility() == 0) {
            if (this.mIndicator instanceof Animatable) {
                this.mShouldStartAnimationDrawable = true;
            }
            postInvalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopAnimation() {
        Indicator indicator = this.mIndicator;
        if (indicator instanceof Animatable) {
            indicator.stop();
            this.mShouldStartAnimationDrawable = false;
        }
        postInvalidate();
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                stopAnimation();
            } else {
                startAnimation();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8 || i == 4) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        updateDrawableBounds(i, i2);
    }

    private void updateDrawableBounds(int i, int i2) {
        int i3;
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            float intrinsicWidth = ((float) indicator.getIntrinsicWidth()) / ((float) this.mIndicator.getIntrinsicHeight());
            float f = (float) paddingRight;
            float f2 = (float) paddingTop;
            float f3 = f / f2;
            int i4 = 0;
            if (intrinsicWidth == f3) {
                i3 = 0;
            } else if (f3 > intrinsicWidth) {
                int i5 = (int) (f2 * intrinsicWidth);
                int i6 = (paddingRight - i5) / 2;
                i4 = i6;
                paddingRight = i5 + i6;
                i3 = 0;
            } else {
                int i7 = (int) (f * (1.0f / intrinsicWidth));
                int i8 = (paddingTop - i7) / 2;
                int i9 = i7 + i8;
                i3 = i8;
                paddingTop = i9;
            }
            this.mIndicator.setBounds(i4, i3, paddingRight, paddingTop);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTrack(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawTrack(Canvas canvas) {
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            int save = canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            indicator.draw(canvas);
            canvas.restoreToCount(save);
            if (this.mShouldStartAnimationDrawable && (indicator instanceof Animatable)) {
                indicator.start();
                this.mShouldStartAnimationDrawable = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            i3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, indicator.getIntrinsicWidth()));
            i4 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, indicator.getIntrinsicHeight()));
        } else {
            i4 = 0;
            i3 = 0;
        }
        updateDrawableState();
        setMeasuredDimension(resolveSizeAndState(i3 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i4 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    private void updateDrawableState() {
        int[] drawableState = getDrawableState();
        Indicator indicator = this.mIndicator;
        if (indicator != null && indicator.isStateful()) {
            this.mIndicator.setState(drawableState);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Indicator indicator = this.mIndicator;
        if (indicator != null) {
            indicator.setHotspot(f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
        removeCallbacks();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }
}
