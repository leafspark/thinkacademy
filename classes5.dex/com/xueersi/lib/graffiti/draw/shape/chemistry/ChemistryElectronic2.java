package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryElectronic2 extends RectBoundShape {
    protected Paint mPaint;

    public ChemistryElectronic2() {
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
        int width = this.rect.width();
        int height = this.rect.height();
        float f = ((float) width) * 0.25f;
        float f2 = ((float) height) * 0.5f;
        Canvas canvas2 = canvas;
        canvas2.drawCircle(((float) this.rect.left) + f, ((float) this.rect.top) + f2, ((float) Math.min(width, height)) * 0.25f, this.mPaint);
        float min = ((float) Math.min(width, height)) * 0.5f;
        float f3 = (((float) this.rect.left) + f) - min;
        float f4 = (((float) this.rect.top) + f2) - min;
        float f5 = ((float) this.rect.left) + f + min;
        Canvas canvas3 = canvas;
        float f6 = f3;
        float f7 = f4;
        float f8 = f5;
        float f9 = min + ((float) this.rect.top) + f2;
        canvas3.drawArc(f6, f7, f8, f9, -12.0f, -32.0f, false, this.mPaint);
        canvas3.drawArc(f6, f7, f8, f9, 12.0f, 32.0f, false, this.mPaint);
        float min2 = ((float) Math.min(width, height)) * 0.75f;
        float f10 = (((float) this.rect.left) + f) - min2;
        float f11 = (((float) this.rect.top) + f2) - min2;
        float f12 = f10;
        float f13 = f11;
        float f14 = ((float) this.rect.left) + f + min2;
        float f15 = min2 + ((float) this.rect.top) + f2;
        canvas3.drawArc(f12, f13, f14, f15, -8.0f, -35.0f, false, this.mPaint);
        canvas3.drawArc(f12, f13, f14, f15, 8.0f, 35.0f, false, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryElectronic2();
        }
    }
}
