package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.AppUtils;

public class Coordinate extends RectBoundShape {
    protected Path mArrowPath = new Path();
    protected float mDensity = AppUtils.getDisplayMetrics().density;
    protected Paint mPaint;
    protected Path mPath = new Path();

    public Coordinate() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        disableLineEffect(this.mPaint);
        int centerY = this.rect.centerY();
        int centerX = this.rect.centerX();
        this.mArrowPath.reset();
        float f = (float) centerY;
        this.mArrowPath.moveTo((float) this.rect.right, f);
        float f2 = (this.mDensity * 10.0f) + (this.mLineWidth / 2.0f);
        float f3 = ((float) this.rect.right) - f2;
        this.mArrowPath.lineTo(f3, f + f2);
        this.mArrowPath.lineTo(f3, f - f2);
        this.mArrowPath.close();
        float f4 = (float) centerX;
        this.mArrowPath.moveTo(f4, (float) this.rect.top);
        this.mArrowPath.lineTo(f4 - f2, ((float) this.rect.top) + f2);
        this.mArrowPath.lineTo(f4 + f2, ((float) this.rect.top) + f2);
        this.mArrowPath.close();
        canvas.drawPath(this.mArrowPath, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPath.reset();
        this.mPath.moveTo((float) this.rect.left, f);
        this.mPath.lineTo(f3, f);
        this.mPath.moveTo(f4, (float) this.rect.bottom);
        this.mPath.lineTo(f4, ((float) this.rect.top) + f2);
        enableLineEffect(this.mPaint);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Coordinate();
        }
    }
}
