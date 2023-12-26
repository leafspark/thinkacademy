package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class EllipsesShape2 extends RectBoundShape {
    protected Paint mPaint;

    public EllipsesShape2() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fillColor);
        disableLineEffect(this.mPaint);
        canvas.drawOval((float) this.rect.left, (float) this.rect.top, (float) this.rect.right, (float) this.rect.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        canvas.drawOval((float) this.rect.left, (float) this.rect.top, (float) this.rect.right, (float) this.rect.bottom, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new EllipsesShape2();
        }
    }
}
