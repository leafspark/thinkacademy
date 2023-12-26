package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class PhysicsBattery extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public PhysicsBattery() {
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
        getBatteryPath();
    }

    private void getBatteryPath() {
        int width = this.rect.width();
        int height = this.rect.height();
        this.rect.centerX();
        int centerY = this.rect.centerY();
        int i = this.rect.left;
        int i2 = this.rect.top;
        int i3 = this.rect.right;
        int i4 = this.rect.bottom;
        this.mPath.reset();
        float f = (float) i;
        float f2 = (float) centerY;
        this.mPath.moveTo(f, f2);
        float f3 = (float) width;
        float f4 = (0.4f * f3) + f;
        this.mPath.lineTo(f4, f2);
        float f5 = f + (f3 * 0.6f);
        this.mPath.moveTo(f5, f2);
        this.mPath.lineTo((float) i3, f2);
        float f6 = (float) i2;
        float f7 = (float) height;
        this.mPath.moveTo(f4, (0.32f * f7) + f6);
        this.mPath.lineTo(f4, (f7 * 0.68f) + f6);
        this.mPath.moveTo(f5, f6);
        this.mPath.lineTo(f5, (float) i4);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsBattery();
        }
    }
}
