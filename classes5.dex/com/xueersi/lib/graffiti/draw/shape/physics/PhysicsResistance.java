package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class PhysicsResistance extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public PhysicsResistance() {
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
        canvas.drawPath(this.mPath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        createResistancePath();
    }

    private void createResistancePath() {
        this.rect.centerX();
        int centerY = this.rect.centerY();
        int width = (int) (((float) this.rect.width()) * 0.25f);
        int height = this.rect.height() / 2;
        this.mPath.reset();
        Math.min(((float) Math.min(height, width)) / 2.0f, (float) height);
        float f = (float) (this.rect.left + width);
        float f2 = (float) (this.rect.right - width);
        this.mPath.addRect(f, (float) this.rect.top, f2, (float) this.rect.bottom, Path.Direction.CW);
        float f3 = (float) centerY;
        this.mPath.moveTo((float) this.rect.left, f3);
        this.mPath.lineTo(f, f3);
        this.mPath.moveTo((float) this.rect.right, f3);
        this.mPath.lineTo(f2, f3);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsResistance();
        }
    }
}
