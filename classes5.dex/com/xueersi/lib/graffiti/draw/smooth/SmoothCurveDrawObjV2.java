package com.xueersi.lib.graffiti.draw.smooth;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class SmoothCurveDrawObjV2 extends DrawableObject {
    protected volatile RectF bounds = new RectF();
    private float mLastDrawLineWidth = 2.0f;
    protected float mNormalLineWidth;
    protected Paint mPaint;
    protected volatile Path mSegmentPath = new Path();
    protected float mSegmentStartX = -2.14748365E9f;
    protected float mSegmentStartY = -2.14748365E9f;
    protected float mX = -2.14748365E9f;
    protected float mY = -2.14748365E9f;
    protected int strokeColor;

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
    }

    public SmoothCurveDrawObjV2() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onIncrementDraw(Canvas canvas, WXWBAction wXWBAction) {
        if (wXWBAction != null && canvas != null) {
            List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
            if (pointList == null || pointList.size() == 0) {
                XesLog.d("涂鸦画笔绘制pointList为空");
                return;
            }
            float lineWidth = getLineWidth(wXWBAction.getLineWidth());
            this.mNormalLineWidth = lineWidth;
            if (this.mLastDrawLineWidth <= CropImageView.DEFAULT_ASPECT_RATIO && lineWidth > CropImageView.DEFAULT_ASPECT_RATIO) {
                this.mLastDrawLineWidth = lineWidth;
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

    private void onActionDown(WXWBAction.PointData pointData) {
        if (pointData != null) {
            float relativeX = relativeX(pointData.getX());
            float relativeY = relativeY(pointData.getY());
            this.mX = relativeX;
            this.mY = relativeY;
            this.mSegmentStartX = relativeX;
            this.mSegmentStartY = relativeY;
            this.mLastDrawLineWidth = getLineWidth(pointData.getLineWidth());
        }
    }

    private void onActionMove(Canvas canvas, WXWBAction.PointData pointData) {
        quadToAction(canvas, pointData);
    }

    private void onActionUp(Canvas canvas, WXWBAction.PointData pointData) {
        quadToAction(canvas, pointData);
        if (this.mX == relativeX(pointData.getX()) && this.mY == relativeY(pointData.getY())) {
            this.mSegmentPath.reset();
            this.mSegmentPath.moveTo(this.mSegmentStartX, this.mSegmentStartY);
            this.mSegmentPath.lineTo(this.mX, this.mY);
            float lineWidth = pointData.getLineWidth();
            if (lineWidth > CropImageView.DEFAULT_ASPECT_RATIO) {
                this.mPaint.setStrokeWidth(getLineWidth(lineWidth));
            } else {
                this.mPaint.setStrokeWidth(this.mNormalLineWidth);
            }
            float strokeWidth = this.mPaint.getStrokeWidth();
            canvas.drawPath(this.mSegmentPath, this.mPaint);
            this.mLastDrawLineWidth = strokeWidth;
        }
    }

    private void quadToAction(Canvas canvas, WXWBAction.PointData pointData) {
        float relativeX = relativeX(pointData.getX());
        float relativeY = relativeY(pointData.getY());
        float f = this.mX;
        if (f == -2.14748365E9f || this.mY == -2.14748365E9f) {
            onActionDown(pointData);
            return;
        }
        float abs = Math.abs(relativeX - f);
        float abs2 = Math.abs(relativeY - this.mY);
        if (abs > CropImageView.DEFAULT_ASPECT_RATIO || abs2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mSegmentPath.reset();
            this.mSegmentPath.moveTo(this.mSegmentStartX, this.mSegmentStartY);
            Path path = this.mSegmentPath;
            float f2 = this.mX;
            float f3 = this.mY;
            path.quadTo(f2, f3, (relativeX + f2) / 2.0f, (relativeY + f3) / 2.0f);
            float lineWidth = pointData.getLineWidth();
            if (lineWidth > CropImageView.DEFAULT_ASPECT_RATIO) {
                this.mPaint.setStrokeWidth(getLineWidth(lineWidth));
            } else {
                this.mPaint.setStrokeWidth(this.mNormalLineWidth);
            }
            float strokeWidth = this.mPaint.getStrokeWidth();
            canvas.drawPath(this.mSegmentPath, this.mPaint);
            this.mSegmentStartX = (this.mX + relativeX) / 2.0f;
            this.mSegmentStartY = (this.mY + relativeY) / 2.0f;
            this.mLastDrawLineWidth = strokeWidth;
            if (XesLog.isEnabled()) {
                XesLog.d("涂鸦画笔绘制信息:线宽:" + strokeWidth + " 线色:" + this.mPaint.getColor());
            }
        }
        this.mX = relativeX;
        this.mY = relativeY;
    }

    /* access modifiers changed from: protected */
    public float getLineWidth(float f) {
        float relativePixel = relativePixel(f);
        if (f > 0.1f || relativePixel < 1.0f) {
            relativePixel = Math.max(this.mLastDrawLineWidth, 2.0f);
        }
        XesLog.d("上次最后一笔宽度：" + this.mLastDrawLineWidth);
        return relativePixel;
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new SmoothCurveDrawObjV2();
        }
    }
}
