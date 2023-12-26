package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.BaseShape;
import java.util.List;

public class LineShape extends BaseShape {
    protected Paint mPaint;
    protected Path mPath = new Path();

    public LineShape() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onDraw(Canvas canvas) {
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList != null && pointList.size() > 1) {
            WXWBAction.PointData pointData = pointList.get(0);
            float relativeX = relativeX(pointData.getX());
            float relativeY = relativeY(pointData.getY());
            WXWBAction.PointData pointData2 = pointList.get(1);
            float relativeX2 = relativeX(pointData2.getX());
            float relativeY2 = relativeY(pointData2.getY());
            this.mPath.reset();
            this.mPath.moveTo(relativeX, relativeY);
            this.mPath.lineTo(relativeX2, relativeY2);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new LineShape();
        }
    }
}
