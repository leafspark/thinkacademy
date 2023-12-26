package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryGasBottle2 extends RectBoundShape {
    public static final String TAG = "test";
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected float[] mRadii = new float[8];

    public ChemistryGasBottle2() {
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
        drawBottlePath(canvas);
    }

    private void drawBottlePath(Canvas canvas) {
        int width = this.rect.width();
        int height = this.rect.height();
        int centerX = this.rect.centerX();
        int centerY = this.rect.centerY();
        int i = this.rect.left;
        int i2 = this.rect.top;
        float f = (float) width;
        float f2 = (float) height;
        float f3 = f2 * 0.1f;
        float f4 = (float) i;
        float f5 = 0.25f * f;
        float f6 = f4 + f5;
        float f7 = (float) this.rect.right;
        float f8 = f7 - f5;
        float f9 = f7;
        float f10 = f4;
        float f11 = f2;
        int i3 = i2;
        canvas.clipRect(((float) this.rect.left) - this.mLineWidth, ((float) this.rect.top) - this.mLineWidth, ((float) this.rect.right) + this.mLineWidth, ((float) this.rect.bottom) + this.mLineWidth);
        float f12 = ((float) centerY) - (0.24f * f2);
        float f13 = f3 / 3.0f;
        float f14 = f8 - (this.mLineWidth / 2.0f);
        float f15 = f8;
        float f16 = (this.mLineWidth / 2.0f) + f6;
        float f17 = f9;
        float f18 = f12 - f13;
        float f19 = f14;
        float f20 = f6;
        float f21 = f12 + f13;
        float f22 = f10;
        float f23 = f20;
        canvas.clipRect(f16, f18, f19, f21, Region.Op.DIFFERENCE);
        float min = ((float) Math.min(width, height)) * 0.2f;
        this.mPath.reset();
        this.mPath.moveTo(((float) centerX) - (f * 0.24f), (float) this.rect.bottom);
        float[] fArr = this.mRadii;
        fArr[0] = min;
        fArr[1] = min;
        fArr[2] = min;
        fArr[3] = min;
        Path path = this.mPath;
        float[] fArr2 = this.mRadii;
        Path path2 = path;
        path2.addRoundRect(f23 - min, f12, f15 + min, (float) this.rect.bottom, fArr2, Path.Direction.CCW);
        float f24 = (float) i3;
        float f25 = (0.26f * f11) + f24;
        this.mPath.moveTo(f23, f25);
        float f26 = f24 + f3;
        this.mPath.lineTo(f23, f26);
        this.mPath.moveTo(f15, f25);
        this.mPath.lineTo(f15, f26);
        float f27 = f * 0.11f;
        this.mPath.moveTo(f22 + f27, f26);
        this.mPath.lineTo(f9 - f27, f26);
        this.mPath.moveTo(f22, (float) this.rect.top);
        this.mPath.lineTo(f9, (float) this.rect.top);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryGasBottle2();
        }
    }

    private float round(float f) {
        return ((float) Math.round((f / 31.0f) * 100.0f)) / 100.0f;
    }

    private void logRectF(RectF rectF) {
        rectF.left = round(rectF.left);
        rectF.top = round(rectF.top);
        rectF.right = round(rectF.right);
        rectF.bottom = round(rectF.bottom);
        Log.d("test", rectF.toString());
    }

    private void logPath(float f, float f2) {
        Log.d("test", round(f) + "f, " + round(f2) + "f");
    }

    private void logPath(float f, float f2, float f3, float f4, float f5, float f6) {
        Log.d("test", round(f) + "f, " + round(f2) + "f, " + round(f3) + "f, " + round(f4) + "f, " + round(f5) + "f, " + round(f6) + "f");
    }
}
