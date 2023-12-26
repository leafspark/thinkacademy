package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public abstract class PhysicsCenterCircle extends RectBoundShape {
    protected int mCenterX;
    protected int mCenterY;
    protected float mCirclePadding;
    protected Paint mPaint;
    protected float mRadius;

    /* access modifiers changed from: package-private */
    public abstract void drawText(Canvas canvas, float f, float f2, float f3, float f4);

    public PhysicsCenterCircle() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas);
        drawLine(canvas);
        int i = this.mCenterX;
        float f = this.mRadius;
        int i2 = this.mCenterY;
        Canvas canvas2 = canvas;
        drawText(canvas2, ((float) i) - f, ((float) i2) - f, ((float) i) + f, ((float) i2) + f);
    }

    /* access modifiers changed from: protected */
    public void drawCircle(Canvas canvas) {
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        canvas.drawCircle((float) this.mCenterX, (float) this.mCenterY, this.mRadius, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void drawLine(Canvas canvas) {
        int i = this.mCenterX;
        float f = (float) i;
        float f2 = (float) this.mCenterY;
        float f3 = f2;
        canvas.drawLine(f - this.mRadius, f2, (float) this.rect.left, f3, this.mPaint);
        canvas.drawLine(f + this.mRadius, f3, (float) this.rect.right, f2, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        this.mRadius = ((float) Math.min(this.rect.width(), this.rect.height())) / 5.0f;
        this.mCenterX = this.rect.centerX();
        this.mCenterY = this.rect.centerY();
        this.mCirclePadding = this.mRadius / 1.8f;
    }
}
