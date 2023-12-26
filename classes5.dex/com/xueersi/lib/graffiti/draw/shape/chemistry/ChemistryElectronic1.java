package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryElectronic1 extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryElectronic1() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        drawElectronic(canvas);
    }

    private void drawElectronic(Canvas canvas) {
        this.mPath.reset();
        int width = this.rect.width();
        int height = this.rect.height();
        float f = ((float) width) * 0.33f;
        float f2 = ((float) height) * 0.5f;
        this.mPath.addCircle(((float) this.rect.left) + f, ((float) this.rect.top) + f2, ((float) Math.min(width, height)) * 0.33f, Path.Direction.CW);
        float min = ((float) Math.min(width, height)) * 0.67f;
        float f3 = (((float) this.rect.left) + f) - min;
        float f4 = (((float) this.rect.top) + f2) - min;
        float f5 = ((float) this.rect.left) + f + min;
        Canvas canvas2 = canvas;
        float f6 = f3;
        float f7 = f4;
        float f8 = f5;
        float f9 = min + ((float) this.rect.top) + f2;
        canvas2.drawArc(f6, f7, f8, f9, -8.0f, -40.0f, false, this.mPaint);
        canvas2.drawArc(f6, f7, f8, f9, 8.0f, 40.0f, false, this.mPaint);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryElectronic1();
        }
    }
}
