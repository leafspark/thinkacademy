package com.xueersi.lib.graffiti.draw.shape.physics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;

public class PhysicsRheostat extends RectBoundShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public PhysicsRheostat() {
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
        createRheostatPath();
    }

    private void createRheostatPath() {
        this.rect.centerX();
        int centerY = this.rect.centerY();
        this.mPath.reset();
        this.mPath.moveTo((float) this.rect.left, ((float) this.rect.top) + (((float) this.rect.height()) * 0.75f));
        this.mPath.lineTo((float) this.rect.left, (float) this.rect.top);
        float width = ((float) this.rect.width()) * 0.33f;
        this.mPath.lineTo(((float) this.rect.right) - width, (float) this.rect.top);
        float f = (float) centerY;
        this.mPath.lineTo(((float) this.rect.right) - width, f);
        this.mPath.addRect(((float) this.rect.left) + (((float) this.rect.width()) * 0.33f), f, (float) this.rect.right, (float) this.rect.bottom, Path.Direction.CW);
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new PhysicsRheostat();
        }
    }
}
