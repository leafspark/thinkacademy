package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryWildMouthBottle extends RectBoundShape {
    public static final String TAG = "test";
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected float[] mRadii = new float[8];

    public ChemistryWildMouthBottle() {
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
        Canvas canvas2 = canvas;
        int width = this.rect.width();
        int height = this.rect.height();
        int centerX = this.rect.centerX();
        this.rect.centerY();
        int i = this.rect.top;
        float f = (float) width;
        float f2 = f * 0.5f;
        canvas2.clipRect(((float) this.rect.left) - this.mLineWidth, ((float) this.rect.top) - this.mLineWidth, ((float) this.rect.right) + this.mLineWidth, ((float) this.rect.bottom) + this.mLineWidth);
        float f3 = (float) centerX;
        float f4 = f2 / 2.0f;
        float f5 = f3 - f4;
        float f6 = (float) i;
        float f7 = f6 + (((float) height) * 0.12f);
        float f8 = f3 + f4;
        canvas.clipRect((this.mLineWidth / 2.0f) + f5, f7 - this.mLineWidth, f8 - (this.mLineWidth / 2.0f), f7 + this.mLineWidth, Region.Op.DIFFERENCE);
        this.mPath.reset();
        float f9 = f3 - f2;
        this.mPath.moveTo(f9, (float) this.rect.bottom);
        float[] fArr = this.mRadii;
        float f10 = 0.66f * f2;
        fArr[0] = f10;
        fArr[1] = f10;
        fArr[2] = f10;
        fArr[3] = f10;
        float[] fArr2 = this.mRadii;
        float f11 = f8;
        float f12 = f9;
        float f13 = f7;
        this.mPath.addRoundRect(f12, f7, f3 + f2, (float) this.rect.bottom, fArr2, Path.Direction.CCW);
        this.mPath.moveTo(f5, f6);
        this.mPath.lineTo(f5, f13);
        this.mPath.moveTo(f11, f6);
        this.mPath.lineTo(f11, f13);
        this.mPath.moveTo(((float) this.rect.left) + (0.08f * f), (float) this.rect.top);
        this.mPath.lineTo(((float) this.rect.left) + (f * 0.92f), (float) this.rect.top);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryWildMouthBottle();
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
