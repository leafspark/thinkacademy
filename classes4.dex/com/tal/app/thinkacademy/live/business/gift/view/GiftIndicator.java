package com.tal.app.thinkacademy.live.business.gift.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tal.app.thinkacademy.lib.util.SizeUtils;

public class GiftIndicator extends View {
    private Paint currPaint;
    private RectF currRectF;
    private int currWidth;
    private int radio = SizeUtils.dp2px(2.0f);
    private Paint totalPaint;
    private RectF totalRectF;
    private int totalWidth;

    public GiftIndicator(Context context) {
        super(context);
        initPaint();
    }

    public GiftIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    public GiftIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initPaint();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.totalPaint = paint;
        paint.setAntiAlias(true);
        this.totalPaint.setStyle(Paint.Style.FILL);
        this.totalPaint.setColor(Color.parseColor("#283140"));
        Paint paint2 = new Paint();
        this.currPaint = paint2;
        paint2.setAntiAlias(true);
        this.currPaint.setStyle(Paint.Style.FILL);
        this.currPaint.setColor(Color.parseColor("#FFAA0A"));
    }

    private void initTotalRect() {
        this.totalRectF = new RectF(0.0f, 0.0f, (float) this.totalWidth, (float) SizeUtils.dp2px(2.0f));
    }

    private void initCurrRect() {
        this.currRectF = new RectF(0.0f, 0.0f, (float) this.currWidth, (float) SizeUtils.dp2px(2.0f));
    }

    public void setTotalWidth(int i) {
        this.totalWidth = i;
        initTotalRect();
    }

    public void setCurrWidth(int i) {
        this.currWidth = i;
        initCurrRect();
    }

    private void drawTotal(Canvas canvas) {
        RectF rectF = this.totalRectF;
        int i = this.radio;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.totalPaint);
    }

    private void drawCurr(Canvas canvas) {
        RectF rectF = this.currRectF;
        int i = this.radio;
        canvas.drawRoundRect(rectF, (float) i, (float) i, this.currPaint);
    }

    public void setDx(int i) {
        RectF rectF = this.currRectF;
        if (rectF != null) {
            rectF.offset((float) (((double) i) * 0.05d), 0.0f);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.totalRectF != null) {
            drawTotal(canvas);
        }
        if (this.currRectF != null) {
            drawCurr(canvas);
        }
    }
}
