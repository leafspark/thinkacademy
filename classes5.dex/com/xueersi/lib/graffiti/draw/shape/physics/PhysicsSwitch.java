package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class PhysicsSwitch extends RectBoundShape {
    protected Path mCirclePath = new Path();
    protected int mCircleRadius;
    protected Paint mPaint;

    public PhysicsSwitch() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        drawSwitchPath(canvas);
    }

    private void drawCircle(Canvas canvas) {
        int width = this.rect.width();
        int height = this.rect.height();
        int centerX = this.rect.centerX();
        int centerY = this.rect.centerY();
        int min = (int) Math.min(this.mLineWidth * 2.0f, ((float) Math.min(width, height)) * 0.5f);
        this.mCircleRadius = min;
        canvas.drawCircle((float) centerX, (float) centerY, (float) min, this.mPaint);
    }

    private void drawSwitchPath(Canvas canvas) {
        drawCircle(canvas);
        int centerX = this.rect.centerX();
        int centerY = this.rect.centerY();
        this.mCirclePath.reset();
        float f = (float) centerY;
        this.mCirclePath.moveTo((float) this.rect.left, f);
        this.mCirclePath.lineTo((float) (centerX - this.mCircleRadius), f);
        float sqrt = (float) (Math.sqrt(0.5d) * ((double) this.mCircleRadius));
        float f2 = ((float) centerX) + sqrt;
        float f3 = f - sqrt;
        this.mCirclePath.moveTo(f2, f3);
        float min = (float) ((int) (((float) Math.min(this.rect.width(), this.rect.height())) * 0.14f));
        this.mCirclePath.lineTo((((float) this.rect.width()) * 0.14f) + f2, f3 - min);
        this.mCirclePath.moveTo(f2 + min, f);
        this.mCirclePath.lineTo((float) this.rect.right, f);
        canvas.drawPath(this.mCirclePath, this.mPaint);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsSwitch();
        }
    }
}
