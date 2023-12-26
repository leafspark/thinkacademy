package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class DiamondShape extends RectBoundShape {
    protected Paint mPaint;
    protected Path path = new Path();

    public DiamondShape() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onDraw(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fillColor);
        disableLineEffect(this.mPaint);
        drawDiamond(canvas, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        drawDiamond(canvas, this.mPaint);
    }

    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        createDiamond();
    }

    private void createDiamond() {
        this.path.reset();
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.path.moveTo((float) this.rect.centerX(), (float) this.rect.top);
        this.path.lineTo((float) this.rect.right, (float) this.rect.centerY());
        this.path.lineTo((float) this.rect.centerX(), (float) this.rect.bottom);
        this.path.lineTo((float) this.rect.left, (float) this.rect.centerY());
        this.path.close();
    }

    /* access modifiers changed from: package-private */
    public void drawDiamond(Canvas canvas, Paint paint) {
        Path path2 = this.path;
        if (path2 != null) {
            canvas.drawPath(path2, paint);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new DiamondShape();
        }
    }
}
