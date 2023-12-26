package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;

public class ThreeCoordinateSystem extends SketchSVGShape {
    private float OFFSET_X = 0.36f;
    private float OFFSET_Y = 0.63f;
    private Path arrowPath = new Path();
    private Matrix matrix = new Matrix();

    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(this.OFFSET_X, this.OFFSET_Y);
        vectorPath.lineTo(this.OFFSET_X, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.moveTo(this.OFFSET_X, this.OFFSET_Y);
        vectorPath.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        vectorPath.moveTo(this.OFFSET_X, this.OFFSET_Y);
        vectorPath.lineTo(1.0f, this.OFFSET_Y);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.strokeColor);
        disableLineEffect(this.mPaint);
        canvas.drawPath(this.arrowPath, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        canvas.drawPath(this.arrowPath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        this.arrowPath.reset();
        this.arrowPath.setFillType(Path.FillType.EVEN_ODD);
        Point point = new Point((int) (((float) this.rect.left) + (((float) this.rect.width()) * this.OFFSET_X)), (int) (((float) this.rect.top) + (((float) this.rect.height()) * this.OFFSET_Y)));
        Point point2 = new Point(point.x, this.rect.top);
        this.arrowPath.moveTo((float) point2.x, (float) point2.y);
        point2.offset(((int) (-this.mLineWidth)) * 2, ((int) this.mLineWidth) * 4);
        this.arrowPath.lineTo((float) point2.x, (float) point2.y);
        point2.offset(((int) this.mLineWidth) * 4, 0);
        this.arrowPath.lineTo((float) point2.x, (float) point2.y);
        this.arrowPath.close();
        point2.set(this.rect.right, point.y);
        this.arrowPath.moveTo((float) point2.x, (float) point2.y);
        point2.offset(((int) (-this.mLineWidth)) * 4, ((int) (-this.mLineWidth)) * 2);
        this.arrowPath.lineTo((float) point2.x, (float) point2.y);
        point2.offset(0, ((int) this.mLineWidth) * 4);
        this.arrowPath.lineTo((float) point2.x, (float) point2.y);
        this.arrowPath.close();
        float[] fArr = {(float) this.rect.left, (float) this.rect.bottom};
        float[] fArr2 = new float[2];
        float[] fArr3 = new float[2];
        this.arrowPath.moveTo(fArr[0], fArr[1]);
        this.matrix.reset();
        float calculateDegrees = calculateDegrees(new PointF((float) (this.rect.left - point.x), (float) (this.rect.bottom - point.y)), new PointF(CropImageView.DEFAULT_ASPECT_RATIO, (float) this.rect.height()));
        this.matrix.postRotate(calculateDegrees, (float) point.x, (float) point.y);
        this.matrix.mapPoints(fArr);
        fArr[0] = fArr[0] - (this.mLineWidth * 2.0f);
        fArr[1] = fArr[1] - (this.mLineWidth * 4.0f);
        this.matrix.reset();
        float f = -calculateDegrees;
        this.matrix.postRotate(f, (float) point.x, (float) point.y);
        this.matrix.mapPoints(fArr2, fArr);
        this.arrowPath.lineTo(fArr2[0], fArr2[1]);
        fArr[0] = fArr[0] + (this.mLineWidth * 4.0f);
        this.matrix.reset();
        this.matrix.postRotate(f, (float) point.x, (float) point.y);
        this.matrix.mapPoints(fArr3, fArr);
        this.arrowPath.lineTo(fArr3[0], fArr3[1]);
        this.arrowPath.close();
    }

    private float calculateDegrees(PointF pointF, PointF pointF2) {
        return (float) Math.toDegrees((double) (((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) - ((float) Math.atan2((double) pointF.y, (double) pointF.x))));
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ThreeCoordinateSystem();
        }
    }
}
