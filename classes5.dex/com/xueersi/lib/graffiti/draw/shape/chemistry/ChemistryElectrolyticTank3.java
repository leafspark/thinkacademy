package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;

public class ChemistryElectrolyticTank3 extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();
    protected Rect mPipeRect = new Rect();

    public ChemistryElectrolyticTank3() {
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
        drawElectrolyticTank(canvas);
    }

    private void drawElectrolyticTank(Canvas canvas) {
        int width = this.rect.width();
        int height = this.rect.height();
        float f = (float) width;
        float f2 = 0.3f * f;
        float centerX = (float) this.rect.centerX();
        float f3 = centerX - f2;
        float f4 = (float) height;
        float f5 = ((float) this.rect.top) + (0.4f * f4);
        float f6 = centerX + f2;
        this.mPath.reset();
        this.mPipeRect.left = (int) f3;
        this.mPipeRect.right = (int) f6;
        this.mPipeRect.top = (int) f5;
        this.mPipeRect.bottom = this.rect.bottom;
        DrawUtil.drawUShapePipe(this.mPath, this.mPipeRect, 0.33f);
        float min = ((float) Math.min(width, height)) * 0.1f;
        float f7 = (f2 - (f * 0.1f)) * 0.5f;
        float f8 = f3 + f7;
        float f9 = ((float) this.rect.top) + min;
        this.mPath.addCircle(f8, f9, min, Path.Direction.CW);
        float f10 = 0.615f * f4;
        this.mPath.moveTo(f8, ((float) this.rect.top) + f10);
        float f11 = f4 * 0.282f;
        this.mPath.lineTo(f8, ((float) this.rect.top) + f11);
        this.mPath.lineTo((float) this.rect.left, ((float) this.rect.top) + f11);
        this.mPath.lineTo((float) this.rect.left, f9);
        this.mPath.lineTo(f8 - min, f9);
        this.mPath.moveTo(f8 + min, f9);
        this.mPath.lineTo((float) this.rect.right, f9);
        this.mPath.lineTo((float) this.rect.right, ((float) this.rect.top) + f11);
        float f12 = f6 - f7;
        this.mPath.lineTo(f12, ((float) this.rect.top) + f11);
        this.mPath.lineTo(f12, ((float) this.rect.top) + f10);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryElectrolyticTank3();
        }
    }
}
