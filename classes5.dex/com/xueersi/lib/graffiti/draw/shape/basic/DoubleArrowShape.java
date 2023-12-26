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

public class DoubleArrowShape extends BaseShape {
    private float mEndArrowX;
    private float mEndArrowY;
    protected Path mEndPath = new Path();
    private float mEndX;
    private float mEndY;
    protected Path mLinePath = new Path();
    protected Paint mPaint;
    private float mStartArrowX;
    private float mStartArrowY;
    protected Path mStartPath = new Path();
    private float mStartX;
    private float mStartY;
    private Matrix matrix = new Matrix();

    public DoubleArrowShape() {
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
        canvas.drawPath(this.mStartPath, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        canvas.drawPath(this.mStartPath, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.strokeColor);
        disableLineEffect(this.mPaint);
        canvas.drawPath(this.mEndPath, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        canvas.drawPath(this.mEndPath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public int[] tryGetCtrlPointPosWhenOffset(List<WXWBAction.PointData> list) {
        return new int[]{2, 3};
    }

    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList == null || pointList.size() <= 3) {
            XesLog.d("DoubleArrowGraphicsPainter-缺少点数据");
            return;
        }
        WXWBAction.PointData pointData = pointList.get(0);
        this.mStartX = relativeX(pointData.getX());
        this.mStartY = relativeY(pointData.getY());
        WXWBAction.PointData pointData2 = pointList.get(1);
        this.mEndX = relativeX(pointData2.getX());
        this.mEndY = relativeY(pointData2.getY());
        WXWBAction.PointData pointData3 = pointList.get(2);
        this.mStartArrowX = relativeX(pointData3.getX());
        this.mStartArrowY = relativeY(pointData3.getY());
        this.mLinePath.reset();
        float f = this.mStartX;
        if (f != this.mEndX || this.mStartY != this.mEndY) {
            this.mLinePath.moveTo(f, this.mStartY);
            this.mLinePath.lineTo(this.mEndX, this.mEndY);
            WXWBAction.PointData pointData4 = pointList.get(3);
            this.mEndArrowX = relativeX(pointData4.getX());
            this.mEndArrowY = relativeY(pointData4.getY());
            createStartArrow();
            createEndArrow();
        }
    }

    private void createStartArrow() {
        createArrow(this.mStartX, this.mStartY, this.mEndX, this.mEndY, this.mStartArrowX, this.mStartArrowY, this.mStartPath);
    }

    private void createEndArrow() {
        createArrow(this.mEndX, this.mEndY, this.mStartX, this.mStartY, this.mEndArrowX, this.mEndArrowY, this.mEndPath);
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
            return new DoubleArrowShape();
        }
    }
}
