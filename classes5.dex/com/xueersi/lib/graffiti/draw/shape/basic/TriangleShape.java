package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.BaseShape;
import java.util.List;

public class TriangleShape extends BaseShape {
    float Ax;
    float Ay;
    float Bx;
    float By;
    float Cx;
    float Cy;
    protected Paint mPaint;
    protected Path path = new Path();

    /* access modifiers changed from: protected */
    public int[] tryGetCtrlPointPosWhenOffset(List<WXWBAction.PointData> list) {
        return new int[]{2};
    }

    public TriangleShape() {
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
        drawTriangle(canvas, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        drawTriangle(canvas, this.mPaint);
    }

    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList != null && pointList.size() > 2) {
            WXWBAction.PointData pointData = pointList.get(0);
            this.Bx = relativeX(pointData.getX());
            this.By = relativeY(pointData.getY());
            WXWBAction.PointData pointData2 = pointList.get(1);
            this.Ax = relativeX(pointData2.getX());
            this.Ay = relativeY(pointData2.getY());
            WXWBAction.PointData pointData3 = pointList.get(2);
            this.Cx = relativeX(pointData3.getX());
            float relativeY = relativeY(pointData3.getY());
            this.Cy = relativeY;
            createTriangle(this.Bx, this.By, this.Ax, this.Ay, this.Cx, relativeY);
        } else if (pointList != null && pointList.size() == 2) {
            WXWBAction.PointData pointData4 = pointList.get(0);
            this.Ax = relativeX(pointData4.getX());
            this.Ay = relativeY(pointData4.getY());
            WXWBAction.PointData pointData5 = pointList.get(1);
            this.Bx = relativeX(pointData5.getX());
            this.By = relativeY(pointData5.getY());
            this.path.reset();
            this.path.setFillType(Path.FillType.EVEN_ODD);
            this.path.moveTo(this.Ax, this.Ay);
            this.path.lineTo(this.Bx, this.By);
            this.path.lineTo(this.Ax, this.By);
            this.path.close();
        }
    }

    private void createTriangle(float f, float f2, float f3, float f4, float f5, float f6) {
        this.path.reset();
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.path.moveTo(f, f2);
        this.path.lineTo(f3, f4);
        this.path.lineTo(f5, f6);
        this.path.close();
    }

    /* access modifiers changed from: package-private */
    public void drawTriangle(Canvas canvas, Paint paint) {
        Path path2 = this.path;
        if (path2 != null) {
            canvas.drawPath(path2, paint);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new TriangleShape();
        }
    }
}
