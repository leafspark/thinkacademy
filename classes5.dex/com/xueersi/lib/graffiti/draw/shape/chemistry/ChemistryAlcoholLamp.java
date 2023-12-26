package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryAlcoholLamp extends RectBoundShape {
    protected Path mFlamePath = new Path();
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryAlcoholLamp() {
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
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        drawAlcoholLamp(canvas);
    }

    private void drawAlcoholLamp(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.rect.width();
        int height = this.rect.height();
        this.rect.centerX();
        this.rect.centerY();
        float f = (float) this.rect.left;
        float f2 = (float) this.rect.top;
        int i = this.rect.right;
        int i2 = this.rect.bottom;
        float f3 = (float) width;
        float f4 = (float) height;
        this.mPath.reset();
        float f5 = (0.567f * f3) + f;
        float f6 = f2 + (0.04f * f4);
        this.mPath.moveTo(f5, f6);
        this.mPath.lineTo((0.632f * f3) + f, (0.183f * f4) + f2);
        this.mPath.cubicTo(f + (0.648f * f3), f2 + (0.216f * f4), f + (0.631f * f3), f2 + (0.255f * f4), f + (0.594f * f3), f2 + (0.269f * f4));
        float f7 = (0.275f * f4) + f2;
        float f8 = f5;
        this.mPath.cubicTo(f + (0.586f * f3), f2 + (0.272f * f4), f + (0.576f * f3), f7, f8, f7);
        this.mPath.lineTo((0.433f * f3) + f, f7);
        float f9 = (0.362f * f3) + f;
        Path path = this.mPath;
        float f10 = f9;
        path.cubicTo(f + (0.394f * f3), f7, f10, f2 + (0.245f * f4), f9, f2 + (0.209f * f4));
        this.mPath.cubicTo(f10, f2 + (0.199f * f4), f + (0.364f * f3), f2 + (0.19f * f4), f + (0.368f * f3), f2 + (0.182f * f4));
        this.mPath.lineTo((0.436f * f3) + f, (0.039f * f4) + f2);
        this.mPath.cubicTo(f + (0.452f * f3), f2 + (0.006f * f4), f + (0.494f * f3), f2 - (0.009f * f4), f + (0.53f * f3), f2 + (0.005f * f4));
        this.mPath.cubicTo((0.547f * f3) + f, (0.013f * f4) + f2, (0.56f * f3) + f, (0.025f * f4) + f2, f8, f6);
        float f11 = (0.933f * f3) + f;
        float f12 = (0.995f * f4) + f2;
        this.mPath.moveTo(f11, f12);
        this.mPath.lineTo(f + f3, (0.872f * f4) + f2);
        float f13 = (0.598f * f3) + f;
        float f14 = (0.382f * f4) + f2;
        this.mPath.lineTo(f13, f14);
        this.mPath.lineTo(f13, f7);
        float f15 = (0.396f * f3) + f;
        this.mPath.lineTo(f15, f7);
        this.mPath.lineTo(f15, f14);
        this.mPath.lineTo(f, (0.869f * f4) + f2);
        this.mPath.lineTo((0.058f * f3) + f, f2 + f4);
        this.mPath.lineTo(f11, f12);
        this.mPath.moveTo((0.503f * f3) + f, f7);
        this.mPath.cubicTo(f + (0.475f * f3), f2 + (0.406f * f4), f + (0.509f * f3), f2 + (0.518f * f4), f + (0.604f * f3), f2 + (0.611f * f4));
        this.mPath.cubicTo(f + (0.748f * f3), f2 + (0.749f * f4), f + (0.446f * f3), f2 + (0.864f * f4), f + (0.429f * f3), f2 + (0.868f * f4));
        float f16 = 0.055f * f3;
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas2.drawCircle((0.746f * f3) + f, (0.901f * f4) + f2, f16, this.mPaint);
        canvas2.drawCircle((0.282f * f3) + f, (0.835f * f4) + f2, f16, this.mPaint);
        float f17 = f2 + (f4 * 0.692f);
        this.mPath.moveTo((0.15f * f3) + f, f17);
        this.mPath.lineTo(f + (f3 * 0.85f), f17);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryAlcoholLamp();
        }
    }
}
