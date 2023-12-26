package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryFunnel extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryFunnel() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        drawConicalFlask(canvas);
    }

    private void drawConicalFlask(Canvas canvas) {
        int width = this.rect.width();
        int height = this.rect.height();
        int centerX = this.rect.centerX();
        float width2 = ((float) this.rect.width()) * 0.5f;
        float f = (float) centerX;
        float f2 = (float) this.rect.top;
        float f3 = (float) this.rect.bottom;
        float f4 = ((float) width) * 0.1f;
        float f5 = ((float) height) * 0.25f;
        this.mPath.reset();
        this.mPath.moveTo(f, f2);
        this.mPath.lineTo(width2 + f, f2);
        float f6 = f + f4;
        float f7 = f2 + f5;
        this.mPath.lineTo(f6, f7);
        this.mPath.lineTo(f6, f3 - (f5 / 2.0f));
        float f8 = f3 - (f5 / 4.0f);
        this.mPath.lineTo(f, f8);
        this.mPath.moveTo(f, f2);
        this.mPath.lineTo(f - width2, f2);
        float f9 = f - f4;
        this.mPath.lineTo(f9, f7);
        this.mPath.lineTo(f9, f3);
        this.mPath.lineTo(f, f8);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryFunnel();
        }
    }
}
