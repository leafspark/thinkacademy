package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class LineShape2 extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public LineShape2() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onDraw(Canvas canvas) {
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        disableLineEffect(this.mPaint);
        this.mPath.reset();
        this.mPath.moveTo((float) this.rect.left, (float) this.rect.centerY());
        this.mPath.lineTo((float) this.rect.right, (float) this.rect.centerY());
        enableLineEffect(this.mPaint);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new LineShape2();
        }
    }
}
