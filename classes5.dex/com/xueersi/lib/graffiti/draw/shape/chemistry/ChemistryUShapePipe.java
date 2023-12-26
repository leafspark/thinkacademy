package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;
import com.yalantis.ucrop.view.CropImageView;

public class ChemistryUShapePipe extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public ChemistryUShapePipe() {
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
        DrawUtil.drawUShapePipe(this.mPath, this.rect, 0.21f);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void drawUShapePipe(Canvas canvas) {
        int centerX = this.rect.centerX();
        float width = ((float) this.rect.width()) * 0.5f;
        float width2 = ((float) this.rect.width()) * 0.29f;
        float f = (float) centerX;
        float f2 = f - width;
        float f3 = (float) this.rect.top;
        float f4 = f + width;
        float f5 = (float) this.rect.bottom;
        float f6 = f5 - width;
        this.mPath.reset();
        this.mPath.addArc(f2, f5 - (2.0f * width), f4, f5, CropImageView.DEFAULT_ASPECT_RATIO, 180.0f);
        this.mPath.addArc(f - width2, f6 - width2, f + width2, f6 + width2, CropImageView.DEFAULT_ASPECT_RATIO, 180.0f);
        this.mPath.moveTo(f2, f6);
        this.mPath.lineTo(f2, f3);
        float f7 = (f2 + width) - width2;
        this.mPath.lineTo(f7, f3);
        this.mPath.lineTo(f7, f6);
        this.mPath.moveTo(f4, f6);
        this.mPath.lineTo(f4, f3);
        float f8 = f4 - (width - width2);
        this.mPath.lineTo(f8, f3);
        this.mPath.lineTo(f8, f6);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryUShapePipe();
        }
    }
}
