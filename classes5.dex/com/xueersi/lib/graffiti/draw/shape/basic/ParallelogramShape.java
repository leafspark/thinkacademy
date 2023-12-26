package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.BaseShape;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class ParallelogramShape extends BaseShape {
    protected Paint mPaint;
    protected Path path;

    public ParallelogramShape() {
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
        drawShape(canvas, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        enableLineEffect(this.mPaint);
        drawShape(canvas, this.mPaint);
    }

    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList != null && pointList.size() >= 3) {
            WXWBAction.PointData pointData = pointList.get(0);
            float relativeX = relativeX(pointData.getX());
            float relativeY = relativeY(pointData.getY());
            WXWBAction.PointData pointData2 = pointList.get(1);
            float relativeX2 = relativeX(pointData2.getX());
            float relativeY2 = relativeY(pointData2.getY());
            float relativePixel = relativePixel(pointList.get(2).getX());
            if (XesLog.isEnabled()) {
                XesLog.d("DiamondGraphicsPainter=" + relativeX + "," + relativeY + "," + relativeX2 + "," + relativeY2 + " ," + this.mLineWidth);
            }
            createShape(Math.min(relativeX, relativeX2), Math.min(relativeY, relativeY2), Math.max(relativeX, relativeX2), Math.max(relativeY, relativeY2), relativePixel);
            setRotateCenter((relativeX + relativeX2) / 2.0f, (relativeY + relativeY2) / 2.0f);
        }
    }

    private void createShape(float f, float f2, float f3, float f4, float f5) {
        Path path2 = new Path();
        this.path = path2;
        path2.setFillType(Path.FillType.EVEN_ODD);
        if (f5 >= CropImageView.DEFAULT_ASPECT_RATIO) {
            this.path.moveTo(f + f5, f2);
            this.path.lineTo(f3, f2);
            this.path.lineTo(f3 - f5, f4);
            this.path.lineTo(f, f4);
        } else {
            this.path.moveTo(f, f2);
            this.path.lineTo(f3 + f5, f2);
            this.path.lineTo(f3, f4);
            this.path.lineTo(f - f5, f4);
        }
        this.path.close();
    }

    /* access modifiers changed from: package-private */
    public void drawShape(Canvas canvas, Paint paint) {
        Path path2 = this.path;
        if (path2 != null) {
            canvas.drawPath(path2, paint);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ParallelogramShape();
        }
    }
}
