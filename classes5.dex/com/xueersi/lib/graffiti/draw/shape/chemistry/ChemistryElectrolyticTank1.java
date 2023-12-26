package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryElectrolyticTank1 extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryElectrolyticTank1() {
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
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        drawElectrolyticTank(canvas);
    }

    private void drawElectrolyticTank(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.rect.width();
        int height = this.rect.height();
        int centerX = this.rect.centerX();
        this.rect.centerY();
        int i = this.rect.left;
        int i2 = this.rect.top;
        int i3 = this.rect.bottom;
        int i4 = this.rect.right;
        float f = (float) width;
        float f2 = (float) height;
        this.mPath.reset();
        float f3 = (float) i;
        float f4 = (float) i3;
        float f5 = (float) i4;
        this.mPath.addRect(f3, f4 - (0.629f * f2), f5, f4, Path.Direction.CW);
        float f6 = f4 - (0.371f * f2);
        this.mPath.moveTo(f3, f6);
        this.mPath.lineTo(f5, f6);
        float min = ((float) Math.min(width, height)) * 0.071f;
        float f7 = (float) centerX;
        float f8 = (float) i2;
        float f9 = f8 + min;
        this.mPath.addCircle(f7, f9, min, Path.Direction.CW);
        float f10 = 0.286f * f;
        float f11 = f3 + f10;
        float f12 = (0.771f * f2) + f8;
        this.mPath.moveTo(f11, f12);
        this.mPath.lineTo(f11, f9);
        this.mPath.lineTo(f7 - min, f9);
        this.mPath.moveTo(f7 + min, f9);
        float f13 = f5 - f10;
        this.mPath.lineTo(f13, f9);
        this.mPath.lineTo(f13, f12);
        this.mPaint.setStyle(Paint.Style.FILL);
        float min2 = ((float) Math.min(width, height)) * 0.036f;
        canvas2.drawCircle((0.428f * f) + f3, (0.802f * f2) + f8, min, this.mPaint);
        canvas2.drawCircle((0.607f * f) + f3, (0.715f * f2) + f8, min2, this.mPaint);
        canvas2.drawCircle(f3 + (f * 0.75f), f8 + (f2 * 0.829f), min2, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryElectrolyticTank1();
        }
    }
}
