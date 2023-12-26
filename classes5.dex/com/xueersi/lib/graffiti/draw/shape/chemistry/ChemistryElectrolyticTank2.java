package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryElectrolyticTank2 extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryElectrolyticTank2() {
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
        float width2 = ((float) this.rect.width()) * 0.42f;
        float height2 = ((float) this.rect.height()) * 0.42f;
        this.mPath.reset();
        float f = (float) i;
        float f2 = (float) i3;
        float f3 = f2 - height2;
        float f4 = f + width2;
        float f5 = f4;
        this.mPath.addRect(f, f3, f4, f2, Path.Direction.CW);
        float f6 = (float) i4;
        float f7 = f6 - width2;
        this.mPath.addRect(f7, f3, f6, f2, Path.Direction.CW);
        float f8 = f2 - (height2 * 0.6f);
        this.mPath.moveTo(f, f8);
        this.mPath.lineTo(f5, f8);
        this.mPath.moveTo(f6, f8);
        this.mPath.lineTo(f7, f8);
        float min = ((float) Math.min(width, height)) * 0.083f;
        float f9 = (float) centerX;
        float f10 = (float) i2;
        float f11 = f10 + min;
        this.mPath.addCircle(f9, f11, min, Path.Direction.CW);
        float f12 = (float) width;
        float f13 = (0.165f * f12) + f;
        float f14 = (0.835f * f12) + f;
        float f15 = (float) height;
        float f16 = (0.798f * f15) + f10;
        this.mPath.moveTo(f13, f16);
        this.mPath.lineTo(f13, f11);
        this.mPath.lineTo(f9 - min, f11);
        this.mPath.moveTo(f9 + min, f11);
        this.mPath.lineTo(f14, f11);
        this.mPath.lineTo(f14, f16);
        float f17 = (0.304f * f12) + f;
        float f18 = (0.688f * f15) + f10;
        this.mPath.moveTo(f17, f18);
        this.mPath.lineTo(f17, (0.389f * f15) + f10);
        float f19 = (0.275f * f15) + f10;
        float f20 = f19;
        this.mPath.cubicTo(f + (0.306f * f12), f10 + (0.366f * f15), f + (0.348f * f12), f19, f + (0.496f * f12), f20);
        this.mPath.cubicTo(f + (0.644f * f12), f20, f + (0.686f * f12), f10 + (0.382f * f15), f + (0.689f * f12), f10 + (0.395f * f15));
        this.mPath.lineTo((0.696f * f12) + f, f18);
        this.mPaint.setStyle(Paint.Style.FILL);
        float min2 = ((float) Math.min(width, height)) * 0.028f;
        float f21 = (0.973f * f15) + f10;
        canvas2.drawCircle((0.138f * f12) + f, f21, min2, this.mPaint);
        float f22 = f10 + (f15 * 0.853f);
        canvas2.drawCircle((0.303f * f12) + f, f22, min2, this.mPaint);
        canvas2.drawCircle((0.693f * f12) + f, f21, min2, this.mPaint);
        canvas2.drawCircle(f + (f12 * 0.863f), f22, min2, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryElectrolyticTank2();
        }
    }
}
