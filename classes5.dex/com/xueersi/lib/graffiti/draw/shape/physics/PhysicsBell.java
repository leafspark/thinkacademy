package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;

public class PhysicsBell extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public PhysicsBell() {
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
        canvas.drawPath(this.mPath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        createBellPath();
    }

    private void createBellPath() {
        float min = ((float) Math.min(this.rect.width(), this.rect.height())) * 0.25f;
        int centerX = this.rect.centerX();
        int centerY = this.rect.centerY();
        this.mPath.reset();
        int i = centerX;
        int i2 = centerY;
        DrawUtil.drawHalfOval(this.mPath, i, i2, (int) min, (int) (0.75f * min), true);
        float f = (float) centerX;
        float f2 = (float) centerY;
        this.mPath.moveTo(f - min, f2);
        this.mPath.lineTo(f + min, f2);
        float f3 = min / 2.0f;
        float f4 = f - f3;
        this.mPath.moveTo(f4, f2);
        float f5 = f2 + f3;
        this.mPath.lineTo(f4, f5);
        this.mPath.lineTo((float) this.rect.left, f5);
        float f6 = f + f3;
        this.mPath.moveTo(f6, f2);
        this.mPath.lineTo(f6, f5);
        this.mPath.lineTo((float) this.rect.right, f5);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsBell();
        }
    }
}
