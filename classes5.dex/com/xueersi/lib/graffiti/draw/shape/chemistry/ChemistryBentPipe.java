package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryBentPipe extends RectBoundShape {
    public static final String TAG = "test";
    protected Path mLinePath = new Path();
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected float[] mRadii = new float[8];
    protected Path mRectPath = new Path();

    public ChemistryBentPipe() {
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
        this.mPath.reset();
        float f = (float) i;
        float f2 = (float) width;
        float f3 = f + (0.48f * f2);
        float f4 = (float) i2;
        float f5 = (float) height;
        float f6 = f4 + (0.148f * f5);
        this.mPath.moveTo(f3, f6);
        float f7 = f + (0.134f * f2);
        this.mPath.lineTo(f7, f6);
        float f8 = f4 + (0.198f * f5);
        this.mPath.lineTo(f7, f8);
        this.mPath.lineTo(f3, f8);
        this.mPath.lineTo((0.486f * f2) + f, f8);
        float f9 = (0.547f * f2) + f;
        float f10 = f8;
        float f11 = f4 + (0.263f * f5);
        this.mPath.cubicTo(f + (0.517f * f2), f4 + (0.201f * f5), f + (0.54f * f2), f4 + (0.229f * f5), f9, f11);
        this.mPath.lineTo(f9, f11);
        this.mPath.lineTo((0.694f * f2) + f, (0.913f * f5) + f4);
        this.mPath.lineTo((0.696f * f2) + f, (0.921f * f5) + f4);
        this.mPath.cubicTo(f + (0.715f * f2), f4 + (0.982f * f5), f + (0.775f * f2), f4 + (1.016f * f5), f + (0.833f * f2), (float) (i2 + height));
        this.mPath.lineTo((float) (i + width), (0.968f * f5) + f4);
        this.mPath.lineTo((0.989f * f2) + f, (0.92f * f5) + f4);
        this.mPath.lineTo((0.821f * f2) + f, (0.952f * f5) + f4);
        this.mPath.lineTo((0.814f * f2) + f, (0.954f * f5) + f4);
        float f12 = (0.738f * f2) + f;
        Path path = this.mPath;
        path.cubicTo(f + (0.78f * f2), f4 + (0.96f * f5), f + (0.747f * f2), f4 + (0.937f * f5), f12, f4 + (0.9f * f5));
        this.mPath.moveTo(f12, (0.905f * f5) + f4);
        this.mPath.lineTo((0.592f * f2) + f, (0.253f * f5) + f4);
        float f13 = f10;
        float f14 = f7;
        float f15 = f6;
        this.mPath.cubicTo(f + (0.573f * f2), (0.18f * f5) + f4, (0.537f * f2) + f, f15, f3, f15);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(this.mPath, this.mPaint);
        this.mRectPath.reset();
        this.mRectPath.moveTo(f14, f13);
        float f16 = (f2 * 0.407f) + f;
        this.mRectPath.moveTo(f16, f13);
        float f17 = (f5 * 0.346f) + f4;
        this.mRectPath.lineTo(f16, f17);
        this.mRectPath.lineTo(f, f17);
        this.mRectPath.lineTo(f, f4);
        this.mRectPath.lineTo(f16, f4);
        this.mRectPath.lineTo(f16, f15);
        this.mRectPath.lineTo(f14, f15);
        this.mRectPath.lineTo(f14, f13);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas2.drawPath(this.mRectPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryBentPipe();
        }
    }
}
