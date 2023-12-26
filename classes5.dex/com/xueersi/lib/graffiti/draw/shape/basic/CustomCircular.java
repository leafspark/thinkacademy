package com.xueersi.lib.graffiti.draw.shape.basic;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.RectBoundShape;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class CustomCircular extends RectBoundShape {
    public static DrawableObject.Factory FACTORY = new DrawableObject.Factory() {
        public DrawableObject create() {
            return new CustomCircular();
        }
    };
    protected float endAngle;
    protected Paint mPaint;
    protected RectF oval = new RectF();
    protected float startAngle;

    public CustomCircular() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        if (wXWBAction.getPointList() != null && wXWBAction.getPointList().size() > 2) {
            List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
            WXWBAction.PointData pointData = pointList.get(0);
            WXWBAction.PointData pointData2 = pointList.get(1);
            float max = (Math.max(pointData.getX(), pointData2.getX()) - Math.min(pointData.getX(), pointData2.getX())) / 2.0f;
            float max2 = (Math.max(pointData.getY(), pointData2.getY()) - Math.min(pointData.getY(), pointData2.getY())) / 2.0f;
            if (max > CropImageView.DEFAULT_ASPECT_RATIO && max2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                this.startAngle = wXWBAction.getPointList().get(2).getX() / max;
                this.endAngle = wXWBAction.getPointList().get(2).getY() / max2;
                this.oval.set(this.rect);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.oval.isEmpty()) {
            this.mPaint.setColor(this.strokeColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mLineWidth);
            enableLineEffect(this.mPaint);
            float degrees = (float) Math.toDegrees((double) this.startAngle);
            float degrees2 = (float) Math.toDegrees((double) this.endAngle);
            float f = ((double) degrees) > 359.8d ? 360.0f : degrees;
            float f2 = degrees2 - f;
            while (f2 < CropImageView.DEFAULT_ASPECT_RATIO && f2 > -360.0f) {
                f2 += 360.0f;
            }
            XesLog.i("CustomCircular:" + f + "     " + f2 + "    " + degrees2);
            canvas.drawArc(this.oval, f, f2, false, this.mPaint);
        }
    }
}
