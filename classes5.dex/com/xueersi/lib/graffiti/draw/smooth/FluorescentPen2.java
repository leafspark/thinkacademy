package com.xueersi.lib.graffiti.draw.smooth;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class FluorescentPen2 extends DrawableObject {
    protected volatile RectF bounds = new RectF();
    protected volatile Rect boundsInt = new Rect();
    boolean hasEnd = false;
    protected Paint mDebugPaint;
    protected float mLineWidth;
    protected Paint mPaint;
    protected volatile Path mPath = new Path();
    protected float mX = -2.14748365E9f;
    protected float mY = -2.14748365E9f;
    protected int strokeColor;

    private int sign(double d) {
        if (d > 0.0d) {
            return 1;
        }
        return d < 0.0d ? -1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
    }

    public FluorescentPen2() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
    }

    public synchronized RectF getBounds() {
        return this.bounds;
    }

    public synchronized Rect getBoundsInt() {
        return this.boundsInt;
    }

    private void quadToAction(Canvas canvas, WXWBAction.PointData pointData) {
        float round = (float) Math.round(relativeX(pointData.getX()));
        float round2 = (float) Math.round(relativeY(pointData.getY()));
        float f = this.mX;
        if (f != -2.14748365E9f) {
            float f2 = this.mY;
            if (f2 != -2.14748365E9f) {
                float f3 = round - f;
                float f4 = round2 - f2;
                if (Math.abs(f3) <= CropImageView.DEFAULT_ASPECT_RATIO && Math.abs(f4) <= CropImageView.DEFAULT_ASPECT_RATIO) {
                    drawItem(canvas, round, round2);
                } else if (Math.abs(f3) > Math.abs(f4)) {
                    float f5 = 3.0f;
                    while (f5 <= Math.abs(f3)) {
                        float abs = (f5 / Math.abs(f3)) * Math.abs(f4);
                        float sign = this.mX + (((float) sign((double) f3)) * f5);
                        float sign2 = (abs * ((float) sign((double) f4))) + this.mY;
                        drawItem(canvas, sign, sign2);
                        f5 += 3.0f;
                        float f6 = sign;
                        round2 = sign2;
                        round = f6;
                    }
                } else {
                    for (float f7 = 3.0f; f7 <= Math.abs(f4); f7 += 3.0f) {
                        round = ((f7 / Math.abs(f4)) * Math.abs(f3) * ((float) sign((double) f3))) + this.mX;
                        round2 = this.mY + (((float) sign((double) f4)) * f7);
                        drawItem(canvas, round, round2);
                    }
                }
                this.mX = round;
                this.mY = round2;
                return;
            }
        }
        onActionDown(pointData);
    }

    private void drawItem(Canvas canvas, float f, float f2) {
        if (this.bounds != null && canvas != null) {
            RectF rectF = this.bounds;
            float f3 = this.mLineWidth;
            rectF.set(f - (f3 / 4.0f), f2 - (f3 / 2.0f), (f3 / 4.0f) + f, (f3 / 2.0f) + f2);
            float f4 = this.bounds.left;
            float f5 = this.bounds.top;
            float f6 = this.bounds.right;
            float f7 = this.bounds.bottom;
            float f8 = this.mLineWidth;
            canvas.drawRoundRect(f4, f5, f6, f7, f8 / 2.0f, f8 / 2.0f, this.mPaint);
        }
    }

    private void computePathBounds(Path path, RectF rectF, Rect rect, float f) {
        if (path != null && rectF != null) {
            rectF.setEmpty();
            path.computeBounds(rectF, false);
            float f2 = -f;
            rectF.inset(f2, f2);
            rectF.roundOut(rect);
        }
    }

    private void onActionDown(WXWBAction.PointData pointData) {
        if (pointData != null) {
            float round = (float) Math.round(relativeX(pointData.getX()));
            float round2 = (float) Math.round(relativeY(pointData.getY()));
            this.mPath.reset();
            this.mPath.moveTo(round, round2);
            this.mX = round;
            this.mY = round2;
        }
    }

    public void onIncrementDraw(Canvas canvas, WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList;
        if (wXWBAction != null && (pointList = wXWBAction.getPointList()) != null && pointList.size() != 0) {
            if (this.mLineWidth == CropImageView.DEFAULT_ASPECT_RATIO) {
                float relativePixel = relativePixel(wXWBAction.getLineWidth());
                this.mLineWidth = relativePixel;
                this.mPaint.setStrokeWidth(relativePixel);
            }
            if (this.strokeColor == 0) {
                int strokeColor2 = wXWBAction.getStrokeColor();
                this.strokeColor = strokeColor2;
                this.mPaint.setColor(strokeColor2);
            }
            for (WXWBAction.PointData next : pointList) {
                int pointAction = next.getPointAction();
                if (pointAction == 0) {
                    onActionDown(next);
                } else if (pointAction == 1) {
                    onActionMove(canvas, next);
                } else if (pointAction == 2) {
                    onActionUp(canvas, next);
                }
            }
        }
    }

    private void onActionMove(Canvas canvas, WXWBAction.PointData pointData) {
        quadToAction(canvas, pointData);
    }

    private void onActionUp(Canvas canvas, WXWBAction.PointData pointData) {
        quadToAction(canvas, pointData);
    }

    public synchronized boolean hasEnd() {
        return this.hasEnd;
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new FluorescentPen2();
        }
    }
}
