package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;

public class ChemistryBenzeneRing extends RectBoundShape {
    protected Path mInPath = new Path();
    protected Rect mInRect = new Rect();
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryBenzeneRing() {
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
        DrawUtil.drawPolygon(this.mPath, this.rect, 6, false);
        int centerX = this.rect.centerX();
        int centerY = this.rect.centerY();
        float min = ((float) Math.min(this.rect.width(), this.rect.height())) * 0.39f;
        float f = (float) centerX;
        this.mInRect.left = (int) (f - min);
        float f2 = (float) centerY;
        this.mInRect.top = (int) (f2 - min);
        this.mInRect.right = (int) (f + min);
        this.mInRect.bottom = (int) (f2 + min);
        DrawUtil.drawPolygon(this.mInPath, this.mInRect, 6, true);
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.drawPath(this.mInPath, this.mPaint);
    }

    private void drawBenzeneRing(Canvas canvas) {
        int i;
        double d;
        this.rect.centerX();
        this.rect.centerY();
        int width = this.rect.width();
        this.rect.height();
        int i2 = this.rect.left;
        int i3 = this.rect.top;
        float f = (float) width;
        float f2 = 0.5f * f;
        this.mPath.reset();
        float f3 = 0.11f * f;
        float f4 = -1.0471976f;
        int i4 = 0;
        while (true) {
            d = 1.0d;
            if (i4 > 6) {
                break;
            }
            double d2 = (double) f2;
            double d3 = (double) f4;
            float f5 = f4;
            int cos = (int) (d2 * (Math.cos(d3) + 1.0d));
            int sin = (int) (d2 * (Math.sin(d3) + 1.0d));
            if (i4 == 0) {
                this.mPath.moveTo((float) (cos + i2), (float) (sin + i3));
            } else {
                this.mPath.lineTo((float) (cos + i2), (float) (sin + i3));
            }
            f4 = f5 + 1.0471976f;
            i4++;
        }
        float f6 = f4;
        float f7 = f * 0.39f;
        int i5 = 0;
        for (i = 6; i5 <= i; i = 6) {
            double d4 = (double) f7;
            double d5 = (double) f4;
            double d6 = (double) f3;
            float f8 = f3;
            int cos2 = (int) (((Math.cos(d5) + d) * d4) + d6);
            int sin2 = (int) ((d4 * (Math.sin(d5) + 1.0d)) + d6);
            if (i5 == 0) {
                this.mPath.moveTo((float) (cos2 + i2), (float) (sin2 + i3));
            } else if (i5 % 2 != 0) {
                this.mPath.moveTo((float) (cos2 + i2), (float) (sin2 + i3));
            } else {
                this.mPath.lineTo((float) (cos2 + i2), (float) (sin2 + i3));
            }
            f4 += 1.0471976f;
            i5++;
            f3 = f8;
            d = 1.0d;
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryBenzeneRing();
        }
    }
}
