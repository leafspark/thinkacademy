package com.tal.app.thinkacademy.lib.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.util.ShadowUtils;

public class ClickUtils {
    private static final long DEBOUNCING_DEFAULT_VALUE = 200;
    private static final int DEBOUNCING_TAG = -7;
    private static final float PRESSED_BG_ALPHA_DEFAULT_VALUE = 0.9f;
    private static final int PRESSED_BG_ALPHA_STYLE = 4;
    private static final float PRESSED_BG_DARK_DEFAULT_VALUE = 0.9f;
    private static final int PRESSED_BG_DARK_STYLE = 5;
    private static final float PRESSED_VIEW_ALPHA_DEFAULT_VALUE = 0.8f;
    private static final int PRESSED_VIEW_ALPHA_SRC_TAG = -3;
    private static final int PRESSED_VIEW_ALPHA_TAG = -2;
    private static final float PRESSED_VIEW_SCALE_DEFAULT_VALUE = -0.06f;
    private static final int PRESSED_VIEW_SCALE_TAG = -1;
    private static final long TIP_DURATION = 2000;
    private static int sClickCount;
    private static long sLastClickMillis;

    public interface Back2HomeFriendlyListener {
        public static final Back2HomeFriendlyListener DEFAULT = new Back2HomeFriendlyListener() {
            public void show(CharSequence charSequence, long j) {
                UtilsBridge.toastShowShort(charSequence);
            }

            public void dismiss() {
                UtilsBridge.toastCancel();
            }
        };

        void dismiss();

        void show(CharSequence charSequence, long j);
    }

    private ClickUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void applyPressedViewScale(View... viewArr) {
        applyPressedViewScale(viewArr, (float[]) null);
    }

    public static void applyPressedViewScale(View[] viewArr, float[] fArr) {
        if (viewArr != null && viewArr.length != 0) {
            for (int i = 0; i < viewArr.length; i++) {
                if (fArr == null || i >= fArr.length) {
                    applyPressedViewScale(viewArr[i], (float) PRESSED_VIEW_SCALE_DEFAULT_VALUE);
                } else {
                    applyPressedViewScale(viewArr[i], fArr[i]);
                }
            }
        }
    }

    public static void applyPressedViewScale(View view, float f) {
        if (view != null) {
            view.setTag(-1, Float.valueOf(f));
            view.setClickable(true);
            view.setOnTouchListener(OnUtilsTouchListener.getInstance());
        }
    }

    public static void applyPressedViewAlpha(View... viewArr) {
        applyPressedViewAlpha(viewArr, (float[]) null);
    }

    public static void applyPressedViewAlpha(View[] viewArr, float[] fArr) {
        if (viewArr != null && viewArr.length != 0) {
            for (int i = 0; i < viewArr.length; i++) {
                if (fArr == null || i >= fArr.length) {
                    applyPressedViewAlpha(viewArr[i], (float) PRESSED_VIEW_ALPHA_DEFAULT_VALUE);
                } else {
                    applyPressedViewAlpha(viewArr[i], fArr[i]);
                }
            }
        }
    }

    public static void applyPressedViewAlpha(View view, float f) {
        if (view != null) {
            view.setTag(-2, Float.valueOf(f));
            view.setTag(PRESSED_VIEW_ALPHA_SRC_TAG, Float.valueOf(view.getAlpha()));
            view.setClickable(true);
            view.setOnTouchListener(OnUtilsTouchListener.getInstance());
        }
    }

    public static void applyPressedBgAlpha(View view) {
        applyPressedBgAlpha(view, 0.9f);
    }

    public static void applyPressedBgAlpha(View view, float f) {
        applyPressedBgStyle(view, 4, f);
    }

    public static void applyPressedBgDark(View view) {
        applyPressedBgDark(view, 0.9f);
    }

    public static void applyPressedBgDark(View view, float f) {
        applyPressedBgStyle(view, 5, f);
    }

    private static void applyPressedBgStyle(View view, int i, float f) {
        if (view != null) {
            Drawable background = view.getBackground();
            int i2 = -i;
            Object tag = view.getTag(i2);
            if (tag instanceof Drawable) {
                ViewCompat.setBackground(view, (Drawable) tag);
                return;
            }
            Drawable createStyleDrawable = createStyleDrawable(background, i, f);
            ViewCompat.setBackground(view, createStyleDrawable);
            view.setTag(i2, createStyleDrawable);
        }
    }

    private static Drawable createStyleDrawable(Drawable drawable, int i, float f) {
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        if (drawable.getConstantState() == null) {
            return drawable;
        }
        Drawable mutate = drawable.getConstantState().newDrawable().mutate();
        if (i == 4) {
            mutate = createAlphaDrawable(mutate, f);
        } else if (i == 5) {
            mutate = createDarkDrawable(mutate, f);
        }
        Drawable createAlphaDrawable = createAlphaDrawable(drawable.getConstantState().newDrawable().mutate(), 0.5f);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, mutate);
        stateListDrawable.addState(new int[]{-16842910}, createAlphaDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, drawable);
        return stateListDrawable;
    }

    private static Drawable createAlphaDrawable(Drawable drawable, float f) {
        DrawableWrapperBefore21 drawableWrapperBefore21 = new DrawableWrapperBefore21(drawable);
        drawableWrapperBefore21.setAlphaFix((int) (f * 255.0f));
        return drawableWrapperBefore21;
    }

    private static Drawable createDarkDrawable(Drawable drawable, float f) {
        DrawableWrapperBefore21 drawableWrapperBefore21 = new DrawableWrapperBefore21(drawable);
        drawableWrapperBefore21.setColorFilterFix(getDarkColorFilter(f));
        return drawableWrapperBefore21;
    }

    private static ColorMatrixColorFilter getDarkColorFilter(float f) {
        return new ColorMatrixColorFilter(new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f}));
    }

    public static void applySingleDebouncing(View view, View.OnClickListener onClickListener) {
        applySingleDebouncing(new View[]{view}, onClickListener);
    }

    public static void applySingleDebouncing(View view, long j, View.OnClickListener onClickListener) {
        applySingleDebouncing(new View[]{view}, j, onClickListener);
    }

    public static void applySingleDebouncing(View[] viewArr, View.OnClickListener onClickListener) {
        applySingleDebouncing(viewArr, (long) DEBOUNCING_DEFAULT_VALUE, onClickListener);
    }

    public static void applySingleDebouncing(View[] viewArr, long j, View.OnClickListener onClickListener) {
        applyDebouncing(viewArr, false, j, onClickListener);
    }

    public static void applyGlobalDebouncing(View view, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(new View[]{view}, onClickListener);
    }

    public static void applyGlobalDebouncing(View view, long j, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(new View[]{view}, j, onClickListener);
    }

    public static void applyGlobalDebouncing(View[] viewArr, View.OnClickListener onClickListener) {
        applyGlobalDebouncing(viewArr, (long) DEBOUNCING_DEFAULT_VALUE, onClickListener);
    }

    public static void applyGlobalDebouncing(View[] viewArr, long j, View.OnClickListener onClickListener) {
        applyDebouncing(viewArr, true, j, onClickListener);
    }

    private static void applyDebouncing(View[] viewArr, boolean z, long j, final View.OnClickListener onClickListener) {
        if (viewArr != null && viewArr.length != 0 && onClickListener != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setOnClickListener(new OnDebouncingClickListener(z, j) {
                        public void onDebouncingClick(View view) {
                            onClickListener.onClick(view);
                        }
                    });
                }
            }
        }
    }

    public static void expandClickArea(View view, int i) {
        expandClickArea(view, i, i, i, i);
    }

    public static void expandClickArea(View view, int i, int i2, int i3, int i4) {
        View view2 = (View) view.getParent();
        if (view2 == null) {
            Log.e("ClickUtils", "expandClickArea must have parent view.");
            return;
        }
        final View view3 = view;
        final int i5 = i;
        final int i6 = i4;
        final int i7 = i2;
        final int i8 = i3;
        final View view4 = view2;
        view2.post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                view3.getHitRect(rect);
                rect.top -= i5;
                rect.bottom += i6;
                rect.left -= i7;
                rect.right += i8;
                view4.setTouchDelegate(new TouchDelegate(rect, view3));
            }
        });
    }

    public static void back2HomeFriendly(CharSequence charSequence) {
        back2HomeFriendly(charSequence, TIP_DURATION, Back2HomeFriendlyListener.DEFAULT);
    }

    public static void back2HomeFriendly(CharSequence charSequence, long j, Back2HomeFriendlyListener back2HomeFriendlyListener) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastClickMillis < j) {
            int i = sClickCount + 1;
            sClickCount = i;
            if (i == 2) {
                UtilsBridge.startHomeActivity();
                back2HomeFriendlyListener.dismiss();
                sLastClickMillis = 0;
                return;
            }
            return;
        }
        sClickCount = 1;
        back2HomeFriendlyListener.show(charSequence, j);
        sLastClickMillis = currentTimeMillis;
    }

    public static abstract class OnDebouncingClickListener implements View.OnClickListener {
        private static final Runnable ENABLE_AGAIN = new Runnable() {
            public void run() {
                boolean unused = OnDebouncingClickListener.mEnabled = true;
            }
        };
        /* access modifiers changed from: private */
        public static boolean mEnabled = true;
        private long mDuration;
        private boolean mIsGlobal;

        public abstract void onDebouncingClick(View view);

        private static boolean isValid(View view, long j) {
            long currentTimeMillis = System.currentTimeMillis();
            Object tag = view.getTag(-7);
            if (!(tag instanceof Long)) {
                view.setTag(-7, Long.valueOf(currentTimeMillis));
                return true;
            }
            long longValue = currentTimeMillis - ((Long) tag).longValue();
            if (longValue < 0) {
                view.setTag(-7, Long.valueOf(currentTimeMillis));
                return false;
            } else if (longValue <= j) {
                return false;
            } else {
                view.setTag(-7, Long.valueOf(currentTimeMillis));
                return true;
            }
        }

        public OnDebouncingClickListener() {
            this(true, ClickUtils.DEBOUNCING_DEFAULT_VALUE);
        }

        public OnDebouncingClickListener(boolean z) {
            this(z, ClickUtils.DEBOUNCING_DEFAULT_VALUE);
        }

        public OnDebouncingClickListener(long j) {
            this(true, j);
        }

        public OnDebouncingClickListener(boolean z, long j) {
            this.mIsGlobal = z;
            this.mDuration = j;
        }

        public final void onClick(View view) {
            MethodInfo.onClickEventEnter(view, ClickUtils.class);
            if (this.mIsGlobal) {
                if (mEnabled) {
                    mEnabled = false;
                    view.postDelayed(ENABLE_AGAIN, this.mDuration);
                    onDebouncingClick(view);
                }
            } else if (isValid(view, this.mDuration)) {
                onDebouncingClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    }

    public static abstract class OnMultiClickListener implements View.OnClickListener {
        private static final long INTERVAL_DEFAULT_VALUE = 666;
        private int mClickCount;
        private final long mClickInterval;
        private long mLastClickTime;
        private final int mTriggerClickCount;

        public abstract void onBeforeTriggerClick(View view, int i);

        public abstract void onTriggerClick(View view);

        public OnMultiClickListener(int i) {
            this(i, INTERVAL_DEFAULT_VALUE);
        }

        public OnMultiClickListener(int i, long j) {
            this.mTriggerClickCount = i;
            this.mClickInterval = j;
        }

        public void onClick(View view) {
            MethodInfo.onClickEventEnter(view, ClickUtils.class);
            if (this.mTriggerClickCount <= 1) {
                onTriggerClick(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime < this.mClickInterval) {
                int i = this.mClickCount + 1;
                this.mClickCount = i;
                int i2 = this.mTriggerClickCount;
                if (i == i2) {
                    onTriggerClick(view);
                } else if (i < i2) {
                    onBeforeTriggerClick(view, i);
                } else {
                    this.mClickCount = 1;
                    onBeforeTriggerClick(view, 1);
                }
            } else {
                this.mClickCount = 1;
                onBeforeTriggerClick(view, 1);
            }
            this.mLastClickTime = currentTimeMillis;
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    }

    private static class OnUtilsTouchListener implements View.OnTouchListener {
        public static OnUtilsTouchListener getInstance() {
            return LazyHolder.INSTANCE;
        }

        private OnUtilsTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                processScale(view, true);
                processAlpha(view, true);
            } else if (action == 1 || action == 3) {
                processScale(view, false);
                processAlpha(view, false);
            }
            return false;
        }

        private void processScale(View view, boolean z) {
            Object tag = view.getTag(-1);
            if (tag instanceof Float) {
                float f = 1.0f;
                if (z) {
                    f = 1.0f + ((Float) tag).floatValue();
                }
                view.animate().scaleX(f).scaleY(f).setDuration(ClickUtils.DEBOUNCING_DEFAULT_VALUE).start();
            }
        }

        private void processAlpha(View view, boolean z) {
            Object tag = view.getTag(z ? -2 : ClickUtils.PRESSED_VIEW_ALPHA_SRC_TAG);
            if (tag instanceof Float) {
                view.setAlpha(((Float) tag).floatValue());
            }
        }

        private static class LazyHolder {
            /* access modifiers changed from: private */
            public static final OnUtilsTouchListener INSTANCE = new OnUtilsTouchListener();

            private LazyHolder() {
            }
        }
    }

    static class DrawableWrapperBefore21 extends ShadowUtils.DrawableWrapper {
        private BitmapDrawable mBitmapDrawable = null;
        private Paint mColorPaint = null;

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        public DrawableWrapperBefore21(Drawable drawable) {
            super(drawable);
            if (drawable instanceof ColorDrawable) {
                Paint paint = new Paint(5);
                this.mColorPaint = paint;
                paint.setColor(((ColorDrawable) drawable).getColor());
            }
        }

        public void setColorFilterFix(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
            Paint paint = this.mColorPaint;
            if (paint != null) {
                paint.setColorFilter(colorFilter);
            }
        }

        public void setAlphaFix(int i) {
            super.setAlpha(i);
            Paint paint = this.mColorPaint;
            if (paint != null) {
                paint.setColor(((ColorDrawable) getWrappedDrawable()).getColor());
            }
        }

        public void draw(Canvas canvas) {
            if (this.mBitmapDrawable == null) {
                Bitmap createBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                if (this.mColorPaint != null) {
                    canvas2.drawRect(getBounds(), this.mColorPaint);
                } else {
                    super.draw(canvas2);
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), createBitmap);
                this.mBitmapDrawable = bitmapDrawable;
                bitmapDrawable.setBounds(getBounds());
            }
            this.mBitmapDrawable.draw(canvas);
        }
    }
}
