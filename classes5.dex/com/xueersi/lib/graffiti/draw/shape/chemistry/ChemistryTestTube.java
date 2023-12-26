package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryTestTube extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected float[] mRadii = new float[8];

    public ChemistryTestTube() {
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
        drawTestTube(canvas);
    }

    private void drawTestTube(Canvas canvas) {
        int centerX = this.rect.centerX();
        float width = ((float) this.rect.width()) * 0.2f;
        float f = (float) centerX;
        float f2 = f - width;
        float f3 = (float) this.rect.top;
        float f4 = f + width;
        float f5 = (float) this.rect.bottom;
        float[] fArr = this.mRadii;
        fArr[4] = width;
        fArr[5] = width;
        fArr[6] = width;
        fArr[7] = width;
        this.mPath.reset();
        this.mPath.addRoundRect(f2, f3, f4, f5, this.mRadii, Path.Direction.CW);
        this.mPath.moveTo((float) this.rect.left, f3);
        this.mPath.lineTo((float) this.rect.right, f3);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryTestTube();
        }
    }
}
