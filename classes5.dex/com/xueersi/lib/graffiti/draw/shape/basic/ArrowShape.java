package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.BaseShape;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.List;

public class ArrowShape extends BaseShape {
    private float mEndArrowX;
    private float mEndArrowY;
    private float mEndX;
    private float mEndY;
    protected Path mLinePath = new Path();
    protected Paint mPaint;
    protected Path mPath = new Path();
    private float mStartX;
    private float mStartY;
    private Matrix matrix = new Matrix();

    /* access modifiers changed from: protected */
    public int[] tryGetCtrlPointPosWhenOffset(List<WXWBAction.PointData> list) {
        return new int[]{2};
    }

    public ArrowShape() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void onDraw(Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        canvas.drawPath(this.mLinePath, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.strokeColor);
        disableLineEffect(this.mPaint);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList == null || pointList.size() <= 1) {
            XesLog.d("ArrowGraphicsPainter-缺少点数据");
            return;
        }
        WXWBAction.PointData pointData = pointList.get(0);
        this.mStartX = relativeX(pointData.getX());
        this.mStartY = relativeY(pointData.getY());
        WXWBAction.PointData pointData2 = pointList.get(1);
        this.mEndX = relativeX(pointData2.getX());
        this.mEndY = relativeY(pointData2.getY());
        this.mLinePath.reset();
        float f = this.mStartX;
        if (f != this.mEndX || this.mStartY != this.mEndY) {
            this.mLinePath.moveTo(f, this.mStartY);
            this.mLinePath.lineTo(this.mEndX, this.mEndY);
            if (pointList.size() > 2) {
                WXWBAction.PointData pointData3 = pointList.get(2);
                this.mEndArrowX = relativeX(pointData3.getX());
                this.mEndArrowY = relativeY(pointData3.getY());
            } else {
                calculateArrowLocation();
            }
            createEndArrow();
            float f2 = this.mStartX;
            float f3 = f2 + ((this.mEndX - f2) / 2.0f);
            float f4 = this.mStartY;
            setRotateCenter(f3, Math.abs(f4 + ((this.mEndY - f4) / 2.0f)));
        }
    }

    private void calculateArrowLocation() {
        double atan2 = ((((Math.atan2((double) (this.mStartY - this.mEndY), (double) (this.mStartX - this.mEndX)) * 180.0d) / 3.141592653589793d) + ((double) 45)) * 3.141592653589793d) / 180.0d;
        double relativeX = (double) ((int) relativeX(0.016f));
        this.mEndArrowX = this.mEndX + ((float) (Math.cos(atan2) * relativeX));
        this.mEndArrowY = this.mEndY + ((float) (relativeX * Math.sin(atan2)));
    }

    private void createEndArrow() {
        createArrow(this.mEndX, this.mEndY, this.mStartX, this.mStartY, this.mEndArrowX, this.mEndArrowY, this.mPath);
    }

    private void createArrow(float f, float f2, float f3, float f4, float f5, float f6, Path path) {
        float calculateDegrees = calculateDegrees(new PointF(f5 - f, f6 - f2), new PointF(f3 - f, f4 - f2));
        this.matrix.reset();
        this.matrix.postRotate(calculateDegrees * 2.0f, f, f2);
        float[] fArr = new float[2];
        this.matrix.mapPoints(fArr, new float[]{f5, f6});
        path.reset();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(f, f2);
        path.lineTo(f5, f6);
        path.lineTo(fArr[0], fArr[1]);
        path.close();
    }

    private float calculateDegrees(PointF pointF, PointF pointF2) {
        return (float) Math.toDegrees((double) (((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) - ((float) Math.atan2((double) pointF.y, (double) pointF.x))));
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ArrowShape();
        }
    }
}
