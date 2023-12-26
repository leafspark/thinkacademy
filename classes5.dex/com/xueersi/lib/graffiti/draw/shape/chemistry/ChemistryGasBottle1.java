package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryGasBottle1 extends RectBoundShape {
    public static final String TAG = "test";
    protected Path mLinePath = new Path();
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected float[] mRadii = new float[8];

    public ChemistryGasBottle1() {
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
        drawBentPipe(canvas);
    }

    private void drawBentPipe(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.rect.width();
        int height = this.rect.height();
        int i = this.rect.left;
        int i2 = this.rect.top;
        int i3 = this.rect.right;
        int i4 = this.rect.bottom;
        int centerX = this.rect.centerX();
        int centerY = this.rect.centerY();
        float f = (float) width;
        float f2 = (float) height;
        float f3 = 0.267f * f2;
        float min = ((float) Math.min(width, height)) * 0.042f;
        float f4 = f * 0.5f;
        this.mPaint.setStyle(Paint.Style.FILL);
        float f5 = (float) i;
        float f6 = (float) i2;
        int i5 = centerX;
        canvas2.drawCircle((0.292f * f) + f5, (0.795f * f2) + f6, min, this.mPaint);
        float f7 = (0.765f * f2) + f6;
        canvas2.drawCircle((0.667f * f) + f5, f7, min * 2.0f, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mLinePath.reset();
        this.mLinePath.moveTo(f5, (float) this.rect.top);
        float f8 = 0.375f * f;
        float f9 = f5 + f8;
        int i6 = width;
        this.mLinePath.lineTo(f9, (float) this.rect.top);
        this.mLinePath.lineTo(f9, f7);
        float f10 = (float) i3;
        this.mLinePath.moveTo(f10, (float) this.rect.top);
        float f11 = f10 - f8;
        this.mLinePath.lineTo(f11, (float) this.rect.top);
        this.mLinePath.lineTo(f11, (0.706f * f2) + f6);
        float f12 = (0.619f * f2) + f6;
        this.mLinePath.moveTo(f5, f12);
        this.mLinePath.lineTo(f10, f12);
        canvas2.drawPath(this.mLinePath, this.mPaint);
        canvas2.clipRect(((float) this.rect.left) - this.mLineWidth, ((float) this.rect.top) - this.mLineWidth, ((float) this.rect.right) + this.mLineWidth, ((float) this.rect.bottom) + this.mLineWidth);
        float f13 = f * 0.209f;
        float f14 = f5 + f13;
        float f15 = (float) centerY;
        float f16 = f10 - f13;
        canvas.clipRect(f14 + (this.mLineWidth / 2.0f), (f15 - f3) - ((0.1f * f2) / 2.0f), f16 - (this.mLineWidth / 2.0f), f3 + f15, Region.Op.DIFFERENCE);
        float min2 = ((float) Math.min(i6, height)) * 0.209f;
        this.mPath.reset();
        float f17 = (float) i5;
        float f18 = f17 - f4;
        this.mPath.moveTo(f18, (float) this.rect.bottom);
        float[] fArr = this.mRadii;
        fArr[0] = min2;
        fArr[1] = min2;
        fArr[2] = min2;
        fArr[3] = min2;
        Path path = this.mPath;
        float f19 = (0.247f * f2) + f6;
        float[] fArr2 = this.mRadii;
        Path path2 = path;
        float f20 = f18;
        float f21 = f19;
        path2.addRoundRect(f20, f21, f17 + f4, (float) this.rect.bottom, fArr2, Path.Direction.CCW);
        this.mPath.moveTo(f14, f19);
        float f22 = f6 + (f2 * 0.147f);
        this.mPath.lineTo(f14, f22);
        this.mPath.moveTo(f16, f19);
        this.mPath.lineTo(f16, f22);
        this.mPath.moveTo(f14, f22);
        this.mPath.lineTo(f16, f22);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryGasBottle1();
        }
    }
}
