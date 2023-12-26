package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;

public class ChemistryLongNeckFunnel extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryLongNeckFunnel() {
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
        DrawUtil.drawCircleFunnel(this.mPath, this.rect);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void drawLongNeckFunnel(Canvas canvas) {
        int centerX = this.rect.centerX();
        this.rect.centerY();
        float min = ((float) Math.min(this.rect.width(), this.rect.height())) * 0.25f;
        float f = (float) centerX;
        float f2 = ((float) this.rect.top) + (1.2f * min);
        float f3 = min / 2.0f;
        float f4 = f2 - min;
        float f5 = f2 + min;
        this.mPath.reset();
        float f6 = f - min;
        float f7 = f4;
        float f8 = f + min;
        float f9 = f5;
        this.mPath.addArc(f6, f7, f8, f9, 300.0f, 135.0f);
        this.mPath.addArc(f6, f7, f8, f9, 105.0f, 135.0f);
        float f10 = f - f3;
        float f11 = f4 + (min * 0.1f);
        this.mPath.moveTo(f10, f11);
        this.mPath.lineTo(f10, (float) this.rect.top);
        float f12 = f + f3;
        this.mPath.lineTo(f12, (float) this.rect.top);
        this.mPath.lineTo(f12, f11);
        float f13 = f3 / 2.0f;
        float f14 = f - f13;
        this.mPath.moveTo(f14, f5);
        this.mPath.lineTo(f14, (float) this.rect.bottom);
        float f15 = f + f13;
        this.mPath.lineTo(f15, ((float) this.rect.bottom) - f13);
        this.mPath.lineTo(f15, f5);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryLongNeckFunnel();
        }
    }
}
