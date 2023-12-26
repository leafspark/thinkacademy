package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistrySeparatingFunnel extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistrySeparatingFunnel() {
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
        drawSeparatingFunnel2(canvas);
    }

    private void drawSeparatingFunnel2(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.rect.width();
        int height = this.rect.height();
        int i = this.rect.left;
        int i2 = this.rect.top;
        this.mPath.reset();
        float f = (float) i;
        float f2 = (float) width;
        float f3 = f + (0.5f * f2);
        float f4 = (float) i2;
        this.mPath.moveTo(f3, f4);
        float f5 = f + (0.6f * f2);
        float f6 = (float) height;
        float f7 = (0.024f * f6) + f4;
        float f8 = (0.053f * f6) + f4;
        this.mPath.cubicTo(f + (0.555f * f2), f4, f5, f7, f5, f8);
        float f9 = (0.4f * f2) + f;
        this.mPath.moveTo(f9, f8);
        this.mPath.cubicTo(f9, f7, f + (0.445f * f2), f4, f3, f4);
        float f10 = f + (0.873f * f2);
        float f11 = f4 + (0.173f * f6);
        this.mPath.moveTo(f10, f11);
        float f12 = (0.151f * f6) + f4;
        float f13 = f10;
        float f14 = f + (0.667f * f2);
        float f15 = f3;
        float f16 = f4 + (0.124f * f6);
        this.mPath.cubicTo(f + (0.817f * f2), f12, f + (0.747f * f2), f4 + (0.134f * f6), f14, f16);
        this.mPath.lineTo(f14, f8);
        float f17 = (0.333f * f2) + f;
        this.mPath.lineTo(f17, f8);
        this.mPath.lineTo(f17, f16);
        this.mPath.cubicTo(f + (0.253f * f2), f4 + (0.135f * f6), f + (0.183f * f2), f12, f + (0.127f * f2), f11);
        float f18 = f4 + (0.159f * f6);
        this.mPath.moveTo((0.167f * f2) + f, f18);
        float f19 = f4 + (0.192f * f6);
        float f20 = f4 + (0.24f * f6);
        float f21 = f4 + (0.293f * f6);
        float f22 = f6;
        float f23 = f4;
        float f24 = f18;
        this.mPath.cubicTo(f + (0.0645f * f2), f19, f, f20, f, f21);
        float f25 = f23 + (f22 * 0.383f);
        float f26 = f23 + (f22 * 0.457f);
        float f27 = f23 + (f22 * 0.471f);
        this.mPath.cubicTo(f, f25, f + (0.18f * f2), f26, f + (0.417f * f2), f27);
        this.mPath.moveTo((0.584f * f2) + f, f27);
        float f28 = (float) (i + width);
        this.mPath.cubicTo(f + (0.82f * f2), f26, f28, f25, f28, f21);
        this.mPath.cubicTo(f28, f20, f + (0.935f * f2), f19, f + (0.833f * f2), f24);
        this.mPath.moveTo(f, f23 + (f22 * 0.283f));
        this.mPath.cubicTo(f + (0.165f * f2), f23 + (f22 * 0.281f), f + (0.29f * f2), f23 + (f22 * 0.212f), f15, f23 + (f22 * 0.225f));
        Path path = this.mPath;
        path.cubicTo(f + (0.723f * f2), f23 + (f22 * 0.238f), f + (0.843f * f2), f23 + (f22 * 0.182f), f13, f11);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas2.drawCircle((0.442f * f2) + f, f23 + (f22 * 0.355f), ((float) Math.min(width, height)) * 0.05f, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas2.drawCircle((0.881f * f2) + f, f23 + (f22 * 0.322f), ((float) Math.min(width, height)) * 0.099f, this.mPaint);
        float f29 = (0.416f * f2) + f;
        float f30 = f23 + (f22 * 0.474f);
        this.mPath.moveTo(f29, f30);
        this.mPath.lineTo(f29, (float) (i2 + height));
        float f31 = (0.581f * f2) + f;
        this.mPath.lineTo(f31, f23 + (f22 * 0.972f));
        this.mPath.lineTo(f31, f30);
        float f32 = (0.244f * f2) + f;
        this.mPath.moveTo(f32, f23 + (f22 * 0.504f));
        this.mPath.lineTo(f32, f23 + (f22 * 0.662f));
        float f33 = f23 + (f22 * 0.583f);
        this.mPath.moveTo(f32, f33);
        this.mPath.lineTo(f + (f2 * 0.756f), f33);
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    private void drawSeparatingFunnel(Canvas canvas) {
        Canvas canvas2 = canvas;
        int centerX = this.rect.centerX();
        this.rect.centerY();
        float min = ((float) Math.min(this.rect.width(), this.rect.height())) * 0.22f;
        float f = (float) centerX;
        float f2 = ((float) this.rect.top) + (1.4f * min);
        float f3 = min / 2.0f;
        float f4 = f - min;
        float f5 = f2 - min;
        float f6 = f + min;
        float f7 = f2 + min;
        this.mPath.reset();
        float f8 = f4;
        float f9 = f5;
        float f10 = f6;
        float f11 = f7;
        this.mPath.addArc(f8, f9, f10, f11, 300.0f, 135.0f);
        this.mPath.addArc(f8, f9, f10, f11, 105.0f, 135.0f);
        this.mPaint.setStyle(Paint.Style.FILL);
        float f12 = 0.2f * min;
        float f13 = min * 0.1f;
        canvas2.drawCircle(f - (min * 0.15f), (0.5f * min) + f2, f13, this.mPaint);
        float f14 = f6 - f12;
        canvas2.drawCircle(f14, f2 + f12, f12, this.mPaint);
        float f15 = f3 * 0.33f;
        Canvas canvas3 = canvas;
        float f16 = f13;
        canvas3.drawArc(f - f15, (float) this.rect.top, f + f15, (f15 * 2.0f) + ((float) this.rect.top), 180.0f, 180.0f, false, this.mPaint);
        float f17 = f - f3;
        float f18 = f5 + f16;
        this.mPath.moveTo(f17, f18);
        this.mPath.lineTo(f17, ((float) this.rect.top) + f15);
        float f19 = f + f3;
        this.mPath.lineTo(f19, ((float) this.rect.top) + f15);
        this.mPath.lineTo(f19, f18);
        float f20 = f3 / 2.0f;
        float f21 = f - f20;
        float f22 = f7;
        this.mPath.moveTo(f21, f22);
        this.mPath.lineTo(f21, (float) this.rect.bottom);
        float f23 = f + f20;
        this.mPath.lineTo(f23, ((float) this.rect.bottom) - f20);
        this.mPath.lineTo(f23, f22);
        float f24 = f22 - f5;
        float f25 = f + f16;
        float f26 = f2 + f16;
        this.mPath.moveTo(f4 + (min * 0.05f), (0.12f * f24) + f2);
        this.mPath.cubicTo(f - f16, f18, f25, f26, f14, f2 - (f24 * 0.3f));
        float f27 = 0.55f * min;
        float f28 = f - f27;
        this.mPath.moveTo(f28, f22 + (((((float) this.rect.bottom) - f2) + min) * 0.05f));
        this.mPath.lineTo(f28, f22 + (((((float) this.rect.bottom) - f2) + min) * 0.15f));
        this.mPath.moveTo(f28, f22 + (((((float) this.rect.bottom) - f2) + min) * 0.1f));
        this.mPath.lineTo(f + f27, f22 + (((((float) this.rect.bottom) - f2) + min) * 0.1f));
        this.mPaint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistrySeparatingFunnel();
        }
    }
}
