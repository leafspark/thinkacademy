package com.tal.app.thinkacademy.lib.commui.wheel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter;
import com.tal.app.thinkacademy.lib.commui.wheel.interfaces.IPickerViewData;
import com.tal.app.thinkacademy.lib.commui.wheel.listener.LoopViewGestureListener;
import com.tal.app.thinkacademy.lib.commui.wheel.listener.OnItemSelectedListener;
import com.tal.app.thinkacademy.lib.commui.wheel.timer.InertiaTimerTask;
import com.tal.app.thinkacademy.lib.commui.wheel.timer.MessageHandler;
import com.tal.app.thinkacademy.lib.commui.wheel.timer.SmoothScrollTimerTask;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView extends View {
    private static final float SCALE_CONTENT = 0.8f;
    private static final String[] TIME_NUM = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private static final int VELOCITY_FLING = 5;
    private float CENTER_CONTENT_OFFSET;
    private WheelAdapter adapter;
    private float centerY;
    private Context context;
    private int dividerColor;
    private DividerType dividerType;
    private int dividerWidth;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private Handler handler;
    private int initPosition;
    private boolean isAlphaGradient;
    private boolean isCenterLabel;
    private boolean isLoop;
    private boolean isOptions;
    private float itemHeight;
    private int itemsVisible;
    private String label;
    private float lineSpacingMultiplier;
    private ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mGravity;
    private int mOffset;
    private int mRoundRadius;
    private RectF mRoundRectF;
    private final Object mSync;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    /* access modifiers changed from: private */
    public OnItemSelectedListener onItemSelectedListener;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private float secondLineY;
    private int selectedItem;
    private long startTime;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private int textXOffset;
    private float totalScrollY;
    private Typeface typeface;
    private int widthMeasureSpec;

    public enum ACTION {
        CLICK,
        FLING,
        DRAG
    }

    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE,
        ROUND_RECT
    }

    public WheelView(Context context2) {
        this(context2, (AttributeSet) null);
    }

    public WheelView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 11;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.isAlphaGradient = false;
        this.mSync = new Object();
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.CENTER_CONTENT_OFFSET = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.CENTER_CONTENT_OFFSET = 6.0f;
        } else if (f >= 3.0f) {
            this.CENTER_CONTENT_OFFSET = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.textColorOut = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.textColorCenter = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.dividerColor = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.dividerWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.pickerview_wheelview_dividerWidth, 2);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.textSize);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
        judgeLineSpace();
        initLoopView(context2);
    }

    private void judgeLineSpace() {
        float f = this.lineSpacingMultiplier;
        if (f < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else if (f > 4.0f) {
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    private void initLoopView(Context context2) {
        this.context = context2;
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector2 = new GestureDetector(context2, new LoopViewGestureListener(this));
        this.gestureDetector = gestureDetector2;
        gestureDetector2.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize((float) this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize((float) this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        setLayerType(1, (Paint) null);
    }

    private void reMeasure() {
        if (this.adapter != null) {
            measureTextWidthHeight();
            int i = (int) (this.itemHeight * ((float) (this.itemsVisible - 1)));
            this.measuredHeight = (int) (((double) (i * 2)) / 3.141592653589793d);
            this.radius = (int) (((double) i) / 3.141592653589793d);
            this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
            int i2 = this.measuredHeight;
            float f = this.itemHeight;
            this.firstLineY = (((float) i2) - f) / 2.0f;
            float f2 = (((float) i2) + f) / 2.0f;
            this.secondLineY = f2;
            this.centerY = (f2 - ((f - ((float) this.maxTextHeight)) / 2.0f)) - this.CENTER_CONTENT_OFFSET;
            if (this.initPosition == -1) {
                if (this.isLoop) {
                    this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
                } else {
                    this.initPosition = 0;
                }
            }
            this.preCurrentIndex = this.initPosition;
        }
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i = 0; i < this.adapter.getItemsCount(); i++) {
            String contentText = getContentText(this.adapter.getItem(i));
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
            int width = rect.width();
            if (width > this.maxTextWidth) {
                this.maxTextWidth = width;
            }
        }
        this.paintCenterText.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.maxTextHeight = height;
        if (this.itemHeight == 0.0f) {
            this.itemHeight = this.lineSpacingMultiplier * ((float) height);
        }
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DRAG) {
            float f = this.totalScrollY;
            float f2 = this.itemHeight;
            int i = (int) (((f % f2) + f2) % f2);
            this.mOffset = i;
            if (((float) i) > f2 / 2.0f) {
                this.mOffset = (int) (f2 - ((float) i));
            } else {
                this.mOffset = -i;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0, 10, TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0, 5, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            synchronized (this.mSync) {
                ScheduledFuture<?> scheduledFuture2 = this.mFuture;
                if (scheduledFuture2 != null && !scheduledFuture2.isCancelled()) {
                    this.mFuture.cancel(true);
                    this.mFuture = null;
                }
            }
        }
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public final void setItemHeight(int i) {
        this.itemHeight = (float) i;
    }

    public final void setRoundRadius(int i) {
        this.mRoundRadius = i;
    }

    public final void setTypeface(Typeface typeface2) {
        this.typeface = typeface2;
        this.paintOuterText.setTypeface(typeface2);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.textSize = i;
            this.paintOuterText.setTextSize((float) i);
            this.paintCenterText.setTextSize((float) this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.selectedItem = i;
        this.initPosition = i;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener2) {
        this.onItemSelectedListener = onItemSelectedListener2;
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        reMeasure();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.itemsVisible = i + 2;
    }

    public void setAlphaGradient(boolean z) {
        this.isAlphaGradient = z;
    }

    public final WheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        int i;
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter == null) {
            return 0;
        }
        if (!this.isLoop || ((i = this.selectedItem) >= 0 && i < wheelAdapter.getItemsCount())) {
            return Math.max(0, Math.min(this.selectedItem, this.adapter.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(Math.abs(Math.abs(this.selectedItem) - this.adapter.getItemsCount()), this.adapter.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new Runnable() {
                public void run() {
                    WheelView.this.onItemSelectedListener.onItemSelected(WheelView.this.getCurrentItem());
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        boolean z;
        String str;
        float f2;
        int i;
        Canvas canvas2 = canvas;
        if (this.adapter != null) {
            boolean z2 = false;
            int min = Math.min(Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
            this.initPosition = min;
            try {
                this.preCurrentIndex = min + (((int) (this.totalScrollY / this.itemHeight)) % this.adapter.getItemsCount());
            } catch (ArithmeticException unused) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.isLoop) {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = 0;
                }
                if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                    this.preCurrentIndex = this.adapter.getItemsCount() - 1;
                }
            } else {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
                }
                if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                    this.preCurrentIndex -= this.adapter.getItemsCount();
                }
            }
            float f3 = this.totalScrollY % this.itemHeight;
            float f4 = 10.0f;
            if (this.dividerType == DividerType.WRAP) {
                if (TextUtils.isEmpty(this.label)) {
                    i = (this.measuredWidth - this.maxTextWidth) / 2;
                } else {
                    i = (this.measuredWidth - this.maxTextWidth) / 4;
                }
                float f5 = (float) (i - 12);
                float f6 = f5 <= 0.0f ? 10.0f : f5;
                float f7 = ((float) this.measuredWidth) - f6;
                float f8 = this.firstLineY;
                Canvas canvas3 = canvas;
                float f9 = f6;
                float f10 = f7;
                canvas3.drawLine(f9, f8, f10, f8, this.paintIndicator);
                float f11 = this.secondLineY;
                canvas3.drawLine(f9, f11, f10, f11, this.paintIndicator);
            } else if (this.dividerType == DividerType.CIRCLE) {
                this.paintIndicator.setStyle(Paint.Style.STROKE);
                this.paintIndicator.setStrokeWidth((float) this.dividerWidth);
                if (TextUtils.isEmpty(this.label)) {
                    f2 = ((float) (this.measuredWidth - this.maxTextWidth)) / 2.0f;
                } else {
                    f2 = ((float) (this.measuredWidth - this.maxTextWidth)) / 4.0f;
                }
                float f12 = f2 - 12.0f;
                if (f12 > 0.0f) {
                    f4 = f12;
                }
                canvas2.drawCircle(((float) this.measuredWidth) / 2.0f, ((float) this.measuredHeight) / 2.0f, Math.max((((float) this.measuredWidth) - f4) - f4, this.itemHeight) / 1.8f, this.paintIndicator);
            } else if (this.dividerType == DividerType.ROUND_RECT) {
                if (this.mRoundRectF == null) {
                    this.mRoundRectF = new RectF((float) SizeUtils.dp2px(16.0f), this.firstLineY, (float) (this.measuredWidth - SizeUtils.dp2px(16.0f)), this.secondLineY);
                }
                RectF rectF = this.mRoundRectF;
                int i2 = this.mRoundRadius;
                canvas2.drawRoundRect(rectF, (float) i2, (float) i2, this.paintIndicator);
            } else {
                float f13 = this.firstLineY;
                canvas.drawLine(0.0f, f13, (float) this.measuredWidth, f13, this.paintIndicator);
                float f14 = this.secondLineY;
                canvas.drawLine(0.0f, f14, (float) this.measuredWidth, f14, this.paintIndicator);
            }
            if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
                canvas2.drawText(this.label, ((float) (this.measuredWidth - getTextWidth(this.paintCenterText, this.label))) - this.CENTER_CONTENT_OFFSET, this.centerY, this.paintCenterText);
            }
            int i3 = 0;
            while (true) {
                int i4 = this.itemsVisible;
                if (i3 < i4) {
                    int i5 = this.preCurrentIndex - ((i4 / 2) - i3);
                    Object obj = "";
                    if (this.isLoop) {
                        obj = this.adapter.getItem(getLoopMappingIndex(i5));
                    } else if (i5 >= 0 && i5 <= this.adapter.getItemsCount() - 1) {
                        obj = this.adapter.getItem(i5);
                    }
                    canvas.save();
                    double d = (double) (((this.itemHeight * ((float) i3)) - f3) / ((float) this.radius));
                    float f15 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                    if (f15 > 90.0f || f15 < -90.0f) {
                        z = z2;
                        f = f3;
                        canvas.restore();
                    } else {
                        if (this.isCenterLabel || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(getContentText(obj))) {
                            str = getContentText(obj);
                        } else {
                            str = getContentText(obj) + this.label;
                        }
                        float pow = (float) Math.pow((double) (Math.abs(f15) / 90.0f), 2.2d);
                        reMeasureTextSize(str);
                        measuredCenterContentStart(str);
                        measuredOutContentStart(str);
                        f = f3;
                        float cos = (float) ((((double) this.radius) - (Math.cos(d) * ((double) this.radius))) - ((Math.sin(d) * ((double) this.maxTextHeight)) / 2.0d));
                        canvas2.translate(0.0f, cos);
                        float f16 = this.firstLineY;
                        if (cos > f16 || ((float) this.maxTextHeight) + cos < f16) {
                            float f17 = this.secondLineY;
                            if (cos > f17 || ((float) this.maxTextHeight) + cos < f17) {
                                if (cos >= f16) {
                                    int i6 = this.maxTextHeight;
                                    if (((float) i6) + cos <= f17) {
                                        canvas2.drawText(str, (float) this.drawCenterContentStart, ((float) i6) - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                                        this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - i3);
                                    }
                                }
                                canvas.save();
                                z = false;
                                canvas2.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * SCALE_CONTENT);
                                setOutPaintStyle(pow, f15);
                                canvas2.drawText(str, ((float) this.drawOutContentStart) + (((float) this.textXOffset) * pow), (float) this.maxTextHeight, this.paintOuterText);
                                canvas.restore();
                                canvas.restore();
                                this.paintCenterText.setTextSize((float) this.textSize);
                            } else {
                                canvas.save();
                                canvas2.clipRect(0.0f, 0.0f, (float) this.measuredWidth, this.secondLineY - cos);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                                canvas2.drawText(str, (float) this.drawCenterContentStart, ((float) this.maxTextHeight) - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                                canvas.restore();
                                canvas.save();
                                canvas2.clipRect(0.0f, this.secondLineY - cos, (float) this.measuredWidth, (float) ((int) this.itemHeight));
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * SCALE_CONTENT);
                                setOutPaintStyle(pow, f15);
                                canvas2.drawText(str, (float) this.drawOutContentStart, (float) this.maxTextHeight, this.paintOuterText);
                                canvas.restore();
                            }
                        } else {
                            canvas.save();
                            canvas2.clipRect(0.0f, 0.0f, (float) this.measuredWidth, this.firstLineY - cos);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * SCALE_CONTENT);
                            setOutPaintStyle(pow, f15);
                            canvas2.drawText(str, (float) this.drawOutContentStart, (float) this.maxTextHeight, this.paintOuterText);
                            canvas.restore();
                            canvas.save();
                            canvas2.clipRect(0.0f, this.firstLineY - cos, (float) this.measuredWidth, (float) ((int) this.itemHeight));
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas2.drawText(str, (float) this.drawCenterContentStart, ((float) this.maxTextHeight) - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                            canvas.restore();
                        }
                        z = false;
                        canvas.restore();
                        this.paintCenterText.setTextSize((float) this.textSize);
                    }
                    i3++;
                    z2 = z;
                    f3 = f;
                } else {
                    return;
                }
            }
        }
    }

    private void setOutPaintStyle(float f, float f2) {
        int i = this.textXOffset;
        int i2 = -1;
        int i3 = i > 0 ? 1 : i < 0 ? -1 : 0;
        Paint paint = this.paintOuterText;
        if (f2 <= 0.0f) {
            i2 = 1;
        }
        paint.setTextSkewX(((float) (i3 * i2)) * 0.5f * f);
        this.paintOuterText.setAlpha(this.isAlphaGradient ? (int) (((90.0f - Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    private void reMeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            i--;
            this.paintCenterText.setTextSize((float) i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize((float) i);
    }

    private int getLoopMappingIndex(int i) {
        if (i < 0) {
            return getLoopMappingIndex(i + this.adapter.getItemsCount());
        }
        return i > this.adapter.getItemsCount() + -1 ? getLoopMappingIndex(i - this.adapter.getItemsCount()) : i;
    }

    private String getContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof Integer) {
            return getFixNum(((Integer) obj).intValue());
        }
        return obj.toString();
    }

    private String getFixNum(int i) {
        return (i < 0 || i >= 10) ? String.valueOf(i) : TIME_NUM[i];
    }

    private void measuredCenterContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawCenterContentStart = 0;
        } else if (i == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET);
        } else if (i == 17) {
            if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
                this.drawCenterContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.5d);
            } else {
                this.drawCenterContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.25d);
            }
        }
    }

    private void measuredOutContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i == 3) {
            this.drawOutContentStart = 0;
        } else if (i == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.CENTER_CONTENT_OFFSET);
        } else if (i == 17) {
            if (this.isOptions || (str2 = this.label) == null || str2.equals("") || !this.isCenterLabel) {
                this.drawOutContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.5d);
            } else {
                this.drawOutContentStart = (int) (((double) (this.measuredWidth - rect.width())) * 0.25d);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        reMeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = ((float) (-this.initPosition)) * this.itemHeight;
        float itemsCount = ((float) ((this.adapter.getItemsCount() - 1) - this.initPosition)) * this.itemHeight;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.previousY - motionEvent.getRawY();
            this.previousY = motionEvent.getRawY();
            float f2 = this.totalScrollY + rawY;
            this.totalScrollY = f2;
            if (!this.isLoop) {
                float f3 = this.itemHeight;
                if ((f2 - (f3 * 0.25f) < f && rawY < 0.0f) || ((f3 * 0.25f) + f2 > itemsCount && rawY > 0.0f)) {
                    this.totalScrollY = f2 - rawY;
                    z = true;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.radius;
            float f4 = this.itemHeight;
            this.mOffset = (int) ((((float) (((int) (((Math.acos((double) ((((float) i) - y) / ((float) i))) * ((double) this.radius)) + ((double) (f4 / 2.0f))) / ((double) f4))) - (this.itemsVisible / 2))) * f4) - (((this.totalScrollY % f4) + f4) % f4));
            if (System.currentTimeMillis() - this.startTime > 120) {
                smoothScroll(ACTION.DRAG);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void isCenterLabel(boolean z) {
        this.isCenterLabel = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil((double) fArr[i2]);
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.isOptions = z;
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        this.paintOuterText.setColor(i);
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        this.paintCenterText.setColor(i);
    }

    public void setTextXOffset(int i) {
        this.textXOffset = i;
        if (i != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public void setDividerWidth(int i) {
        this.dividerWidth = i;
        this.paintIndicator.setStrokeWidth((float) i);
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        this.paintIndicator.setColor(i);
    }

    public void setDividerType(DividerType dividerType2) {
        this.dividerType = dividerType2;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.lineSpacingMultiplier = f;
            judgeLineSpace();
        }
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public float getTotalScrollY() {
        return this.totalScrollY;
    }

    public void setTotalScrollY(float f) {
        this.totalScrollY = f;
    }

    public float getItemHeight() {
        return this.itemHeight;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    public Handler getHandler() {
        return this.handler;
    }
}
