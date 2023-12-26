package com.sensorsdata.analytics.android.sdk.visual.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface;
import java.util.Timer;
import java.util.TimerTask;

class PairingCodeEditText extends EditText implements IPairingCodeInterface, TextWatcher {
    private static final int DEFAULT_CURSOR_DURATION = 400;
    /* access modifiers changed from: private */
    public boolean isCursorShowing;
    private float mBottomLineHeight;
    private int mBottomNormalColor;
    private Paint mBottomNormalPaint;
    private int mBottomSelectedColor;
    private Paint mBottomSelectedPaint;
    private int mCurrentPosition;
    private int mCursorColor;
    private int mCursorDuration;
    private Paint mCursorPaint;
    private Timer mCursorTimer;
    private TimerTask mCursorTimerTask;
    private int mCursorWidth;
    private int mEachRectLength;
    private int mFigures;
    private Paint mNormalBackgroundPaint;
    private int mPairingCodeMargin;
    private int mSelectedBackgroundColor;
    private Paint mSelectedBackgroundPaint;
    private IPairingCodeInterface.OnPairingCodeChangedListener onCodeChangedListener;

    public PairingCodeEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public PairingCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PairingCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.mEachRectLength = 0;
        initAttrs();
        setBackgroundColor(getColor(17170445));
        initPaint();
        initCursorTimer();
        setFocusableInTouchMode(true);
        setSelection(getText().length());
        requestFocus();
        super.addTextChangedListener(this);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mSelectedBackgroundPaint = paint;
        paint.setColor(this.mSelectedBackgroundColor);
        Paint paint2 = new Paint();
        this.mNormalBackgroundPaint = paint2;
        paint2.setColor(getColor(17170445));
        this.mBottomSelectedPaint = new Paint();
        this.mBottomNormalPaint = new Paint();
        this.mBottomSelectedPaint.setColor(this.mBottomSelectedColor);
        this.mBottomNormalPaint.setColor(this.mBottomNormalColor);
        this.mBottomSelectedPaint.setStrokeWidth(this.mBottomLineHeight);
        this.mBottomNormalPaint.setStrokeWidth(this.mBottomLineHeight);
        Paint paint3 = new Paint();
        this.mCursorPaint = paint3;
        paint3.setAntiAlias(true);
        this.mCursorPaint.setColor(this.mCursorColor);
        this.mCursorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mCursorPaint.setStrokeWidth((float) this.mCursorWidth);
    }

    private void initAttrs() {
        this.mFigures = 4;
        this.mPairingCodeMargin = dp2px(10);
        this.mBottomSelectedColor = Color.parseColor("#00c48e");
        this.mBottomNormalColor = getColor(17170432);
        this.mBottomLineHeight = (float) dp2px(2);
        this.mSelectedBackgroundColor = getColor(17170445);
        this.mCursorWidth = dp2px(1);
        this.mCursorColor = Color.parseColor("#00c48e");
        this.mCursorDuration = 400;
        if (Build.VERSION.SDK_INT >= 17) {
            setLayoutDirection(0);
        }
    }

    private void initCursorTimer() {
        this.mCursorTimerTask = new TimerTask() {
            public void run() {
                PairingCodeEditText pairingCodeEditText = PairingCodeEditText.this;
                boolean unused = pairingCodeEditText.isCursorShowing = !pairingCodeEditText.isCursorShowing;
                PairingCodeEditText.this.postInvalidate();
            }
        };
        this.mCursorTimer = new Timer();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mCursorTimer.scheduleAtFixedRate(this.mCursorTimerTask, 0, (long) this.mCursorDuration);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCursorTimer.cancel();
    }

    public final void setCursorVisible(boolean z) {
        super.setCursorVisible(z);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = getScreenWidth(getContext());
        }
        int i3 = this.mPairingCodeMargin;
        int i4 = this.mFigures;
        this.mEachRectLength = (size - (i3 * (i4 - 1))) / i4;
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            size2 = this.mEachRectLength;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.mCurrentPosition = getText().length();
        int paddingLeft = (this.mEachRectLength - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i = 0; i < this.mFigures; i++) {
            canvas.save();
            int i2 = (paddingLeft * i) + (this.mPairingCodeMargin * i);
            int i3 = paddingLeft + i2;
            if (i == this.mCurrentPosition) {
                canvas.drawRect((float) i2, 0.0f, (float) i3, (float) measuredHeight, this.mSelectedBackgroundPaint);
            } else {
                canvas.drawRect((float) i2, 0.0f, (float) i3, (float) measuredHeight, this.mNormalBackgroundPaint);
            }
            canvas.restore();
        }
        String obj = getText().toString();
        for (int i4 = 0; i4 < obj.length(); i4++) {
            canvas.save();
            TextPaint paint = getPaint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            canvas.drawText(String.valueOf(obj.charAt(i4)), (float) ((paddingLeft * i4) + (this.mPairingCodeMargin * i4) + (paddingLeft / 2)), (((((float) measuredHeight) - fontMetrics.bottom) + fontMetrics.top) / 2.0f) - fontMetrics.top, paint);
            canvas.restore();
        }
        Canvas canvas2 = canvas;
        for (int i5 = 0; i5 < this.mFigures; i5++) {
            canvas.save();
            float f = ((float) measuredHeight) - (this.mBottomLineHeight / 2.0f);
            int i6 = (paddingLeft * i5) + (this.mPairingCodeMargin * i5);
            int i7 = paddingLeft + i6;
            if (i5 < this.mCurrentPosition) {
                canvas.drawLine((float) i6, f, (float) i7, f, this.mBottomSelectedPaint);
            } else {
                canvas.drawLine((float) i6, f, (float) i7, f, this.mBottomNormalPaint);
            }
            canvas.restore();
        }
        boolean isCursorVisible = Build.VERSION.SDK_INT >= 16 ? isCursorVisible() : true;
        if (!this.isCursorShowing && isCursorVisible && this.mCurrentPosition < this.mFigures && hasFocus()) {
            canvas.save();
            int i8 = (this.mCurrentPosition * (this.mPairingCodeMargin + paddingLeft)) + (paddingLeft / 2);
            int i9 = measuredHeight / 4;
            float f2 = (float) i8;
            canvas.drawLine(f2, (float) i9, f2, (float) (measuredHeight - i9), this.mCursorPaint);
            canvas.restore();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
        IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener = this.onCodeChangedListener;
        if (onPairingCodeChangedListener != null) {
            onPairingCodeChangedListener.onPairingCodeChanged(getText(), i, i2, i3);
        }
    }

    public void afterTextChanged(Editable editable) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
        if (getText().length() == this.mFigures) {
            IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener = this.onCodeChangedListener;
            if (onPairingCodeChangedListener != null) {
                onPairingCodeChangedListener.onInputCompleted(getText());
            }
        } else if (getText().length() > this.mFigures) {
            getText().delete(this.mFigures, getText().length());
        }
    }

    public void setFigures(int i) {
        this.mFigures = i;
        postInvalidate();
    }

    public void setPairingCodeMargin(int i) {
        this.mPairingCodeMargin = i;
        postInvalidate();
    }

    public void setBottomSelectedColor(int i) {
        this.mBottomSelectedColor = getColor(i);
        postInvalidate();
    }

    public void setBottomNormalColor(int i) {
        this.mBottomSelectedColor = getColor(i);
        postInvalidate();
    }

    public void setSelectedBackgroundColor(int i) {
        this.mSelectedBackgroundColor = getColor(i);
        postInvalidate();
    }

    public void setBottomLineHeight(int i) {
        this.mBottomLineHeight = (float) i;
        postInvalidate();
    }

    public void setOnPairingCodeChangedListener(IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener) {
        this.onCodeChangedListener = onPairingCodeChangedListener;
    }

    private int getColor(int i) {
        return getContext().getResources().getColor(i);
    }

    private int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* access modifiers changed from: package-private */
    public void showKeyBoard(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public void hiddenKeyBord() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void clearText() {
        getText().delete(0, getText().length());
    }
}
