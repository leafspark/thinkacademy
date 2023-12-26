package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class ChemistryBeaker extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryBeaker() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.BEVEL);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        drawBeaker(canvas);
    }

    private void drawBeaker(Canvas canvas) {
        float f = (float) this.rect.top;
        float f2 = (float) this.rect.bottom;
        float width = ((float) this.rect.width()) * 0.2f;
        this.mPath.reset();
        this.mPath.moveTo((float) this.rect.right, f);
        this.mPath.lineTo((float) this.rect.right, f2);
        this.mPath.lineTo(((float) this.rect.left) + width, f2);
        this.mPath.lineTo(((float) this.rect.left) + width, (((float) this.rect.height()) * 0.19f) + f);
        this.mPath.lineTo((float) this.rect.left, f);
        this.mPath.lineTo((float) this.rect.right, f);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryBeaker();
        }
    }
}
