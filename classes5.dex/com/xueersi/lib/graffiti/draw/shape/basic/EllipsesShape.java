package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class EllipsesShape extends RectBoundShape {
    protected Paint mPaint;

    public EllipsesShape() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onDraw(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fillColor);
        disableLineEffect(this.mPaint);
        canvas.drawOval((float) this.rect.left, (float) this.rect.top, (float) this.rect.right, (float) this.rect.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        canvas.drawOval((float) this.rect.left, (float) this.rect.top, (float) this.rect.right, (float) this.rect.bottom, this.mPaint);
        if (arrowCircleCenter()) {
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((float) this.rect.centerX(), (float) this.rect.centerY(), this.mLineWidth, this.mPaint);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new EllipsesShape();
        }
    }
}
