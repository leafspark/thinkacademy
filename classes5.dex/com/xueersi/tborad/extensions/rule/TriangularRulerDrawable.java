package com.xueersi.tborad.extensions.rule;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import com.xueersi.lib.graffiti.utils.Utils;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.tborad.extensions.rule.TriangularRulerProtoBean;
import com.yalantis.ucrop.view.CropImageView;

public class TriangularRulerDrawable extends BaseDrawable {
    private static final String TAG = "TriangularRulerDrawable";
    private String fileText;
    private Path mTempPath;
    private float originalAx;
    private float originalAy;
    private float originalBx;
    private float originalBy;
    private float originalCx;
    private float originalCy;
    private final Paint paint;
    private final Path path = new Path();
    private final PointF pointA;
    private final PointF pointA1;
    private final PointF pointB;
    private final PointF pointB1;
    private final PointF pointC;
    private final PointF pointC1;
    private final PointF[] pointList;
    private final PointF[] pointList1;
    private float rotate;
    private final Paint textPaint;

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void updateConfig(Object obj) {
        super.updateConfig(obj);
    }

    public TriangularRulerDrawable() {
        PointF pointF = new PointF();
        this.pointA = pointF;
        PointF pointF2 = new PointF();
        this.pointB = pointF2;
        PointF pointF3 = new PointF();
        this.pointC = pointF3;
        PointF pointF4 = new PointF();
        this.pointA1 = pointF4;
        PointF pointF5 = new PointF();
        this.pointB1 = pointF5;
        PointF pointF6 = new PointF();
        this.pointC1 = pointF6;
        this.pointList = new PointF[]{pointF, pointF2, pointF3};
        this.pointList1 = new PointF[]{pointF4, pointF5, pointF6};
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(10.0f);
        Paint paint3 = new Paint();
        this.textPaint = paint3;
        paint3.setAntiAlias(true);
        paint3.setTypeface(TriangularRulerExtension.FILL_TEXT_TYPEFACE);
        paint3.setStrokeWidth(4.0f);
        paint3.setColor(TriangularRulerExtension.RULER_TEXT_COLOR);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setTextSize(getX(TriangularRulerExtension.TEXT_SIZE));
    }

    public void draw(Canvas canvas) {
        canvas.save();
        float f = this.rotate;
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            canvas.rotate((float) Math.toDegrees((double) f), this.pointA.x, this.pointA.y);
        }
        calculatePoints();
        drawBackgroundTriangular(canvas, true);
        drawForegroundTriangular(canvas);
        drawRulers(canvas);
        if (TriangularRulerExtension.DEBUG) {
            canvas.drawText("A", this.pointA.x, this.pointA.y, this.textPaint);
            canvas.drawText("B", this.pointB.x, this.pointB.y, this.textPaint);
            canvas.drawText("C", this.pointC.x, this.pointC.y, this.textPaint);
            canvas.drawText("A1", this.pointA1.x, this.pointA1.y, this.textPaint);
            canvas.drawText("B1", this.pointB1.x, this.pointB1.y, this.textPaint);
            canvas.drawText("C1", this.pointC1.x, this.pointC1.y, this.textPaint);
        }
        canvas.restore();
    }

    private void drawBackgroundTriangular(Canvas canvas, boolean z) {
        this.paint.setColor(TriangularRulerExtension.BG_FILL_COLOR);
        this.path.reset();
        this.path.moveTo(this.pointA.x, this.pointA.y);
        this.path.lineTo(this.pointB.x, this.pointB.y);
        this.path.lineTo(this.pointC.x, this.pointC.y);
        this.path.close();
        if (!TriangularRulerExtension.CENTER_COLOR_OVERLAY && z) {
            Path path2 = this.mTempPath;
            if (path2 == null) {
                this.mTempPath = new Path();
            } else {
                path2.reset();
            }
            this.mTempPath.moveTo(this.pointA1.x, this.pointA1.y);
            this.mTempPath.lineTo(this.pointB1.x, this.pointB1.y);
            this.mTempPath.lineTo(this.pointC1.x, this.pointC1.y);
            this.mTempPath.close();
            this.path.op(this.mTempPath, Path.Op.XOR);
        }
        canvas.drawPath(this.path, this.paint);
    }

    private void drawForegroundTriangular(Canvas canvas) {
        this.paint.setColor(TriangularRulerExtension.CENTER_COLOR);
        this.path.reset();
        this.path.moveTo(this.pointA1.x, this.pointA1.y);
        this.path.lineTo(this.pointB1.x, this.pointB1.y);
        this.path.lineTo(this.pointC1.x, this.pointC1.y);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    private boolean calculatePoints() {
        this.pointA.set(getX(this.originalAx), getY(this.originalAy));
        this.pointB.set(getX(this.originalBx), getY(this.originalBy));
        this.pointC.set(getX(this.originalCx), getY(this.originalCy));
        return Utils.calculate(this.pointList, getX(TriangularRulerExtension.SIDES_WIDTH), this.pointList1);
    }

    private void drawText(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, int i) {
        float f;
        if (i != 0) {
            if (i > 0) {
                f = Utils.calculateDegrees(pointF3, pointF);
                canvas.rotate(f, pointF.x, pointF.y);
            } else {
                f = Utils.calculateDegrees(pointF2, pointF);
                canvas.rotate(f, pointF.x, pointF.y);
            }
            this.textPaint.setTextSize(getX(TriangularRulerExtension.TEXT_SIZE));
            this.textPaint.setColor(TriangularRulerExtension.RULER_TEXT_COLOR);
            canvas.drawText(this.fileText, pointF.x + getValue(TriangularRulerExtension.TEXT_MARGIN_LEFT), pointF.y - getValue(TriangularRulerExtension.TEXT_MARGIN_BOTTOM), this.textPaint);
            canvas.rotate(-f, pointF.x, pointF.y);
        }
    }

    private void drawRuler(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, int i) {
        Canvas canvas2 = canvas;
        PointF pointF4 = pointF;
        PointF pointF5 = pointF2;
        PointF pointF6 = pointF3;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(TriangularRulerExtension.RULER_COLOR);
        this.paint.setTextSize(getX(TriangularRulerExtension.TEXT_SIZE));
        this.paint.setStrokeWidth(getX(TriangularRulerExtension.RULER_STORE_WIDTH));
        this.paint.setAntiAlias(true);
        float calculateDegrees = Utils.calculateDegrees(pointF5, pointF4);
        canvas.rotate(calculateDegrees, pointF4.x, pointF4.y);
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append("canvas.rotate = ");
        sb.append(calculateDegrees);
        XesLog.i(sb.toString());
        float accurancyDistance = Utils.getAccurancyDistance(pointF5, pointF4);
        int x = (int) (accurancyDistance / getX(TriangularRulerExtension.RULER_INTERVAL));
        if (i > 0) {
            XesLog.i(str + "顺时针绘制");
            canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, -getX(TriangularRulerExtension.SIDES_WIDTH));
            if (pointF6 == pointF5) {
                for (int i2 = 0; i2 < x; i2++) {
                    canvas.drawLine(pointF4.x + accurancyDistance, pointF4.y, pointF4.x + accurancyDistance, pointF4.y + getX(TriangularRulerExtension.RULER_HEIGHT_LIST[i2 % 10]), this.paint);
                    canvas.translate(-getX(TriangularRulerExtension.RULER_INTERVAL), CropImageView.DEFAULT_ASPECT_RATIO);
                }
                canvas.translate(getX(TriangularRulerExtension.RULER_INTERVAL) * ((float) x), CropImageView.DEFAULT_ASPECT_RATIO);
            } else {
                for (int i3 = 0; i3 < x; i3++) {
                    canvas.drawLine(pointF4.x, pointF4.y, pointF4.x, pointF4.y + getX(TriangularRulerExtension.RULER_HEIGHT_LIST[i3 % 10]), this.paint);
                    canvas.translate(getX(TriangularRulerExtension.RULER_INTERVAL), CropImageView.DEFAULT_ASPECT_RATIO);
                }
                canvas.translate((-getX(TriangularRulerExtension.RULER_INTERVAL)) * ((float) x), CropImageView.DEFAULT_ASPECT_RATIO);
            }
            canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, getX(TriangularRulerExtension.SIDES_WIDTH));
        } else {
            XesLog.i(str + "逆时针绘制");
            if (pointF6 == pointF5) {
                for (int i4 = 0; i4 < x; i4++) {
                    canvas.drawLine(pointF4.x + accurancyDistance, pointF4.y + (getX(TriangularRulerExtension.SIDES_WIDTH) - getX(TriangularRulerExtension.RULER_HEIGHT_LIST[i4 % 10])), pointF4.x + accurancyDistance, getX(TriangularRulerExtension.SIDES_WIDTH) + pointF4.y, this.paint);
                    canvas.translate(-getX(TriangularRulerExtension.RULER_INTERVAL), CropImageView.DEFAULT_ASPECT_RATIO);
                }
                canvas.translate(getX(TriangularRulerExtension.RULER_INTERVAL) * ((float) x), CropImageView.DEFAULT_ASPECT_RATIO);
            } else {
                for (int i5 = 0; i5 < x; i5++) {
                    canvas.drawLine(pointF4.x, pointF4.y + (getX(TriangularRulerExtension.SIDES_WIDTH) - getX(TriangularRulerExtension.RULER_HEIGHT_LIST[i5 % 10])), pointF4.x, getX(TriangularRulerExtension.SIDES_WIDTH) + pointF4.y, this.paint);
                    canvas.translate(getX(TriangularRulerExtension.RULER_INTERVAL), CropImageView.DEFAULT_ASPECT_RATIO);
                }
                canvas.translate((-getX(TriangularRulerExtension.RULER_INTERVAL)) * ((float) x), CropImageView.DEFAULT_ASPECT_RATIO);
            }
        }
        canvas.rotate(-calculateDegrees, pointF4.x, pointF4.y);
    }

    private void drawRulers(Canvas canvas) {
        int i = (int) (((this.pointB.x - this.pointA.x) * (this.pointC.y - this.pointA.y)) - ((this.pointC.x - this.pointA.x) * (this.pointB.y - this.pointA.y)));
        if (i != 0) {
            canvas.save();
            PointF pointF = this.pointA1;
            Canvas canvas2 = canvas;
            int i2 = i;
            drawRuler(canvas2, pointF, this.pointB1, pointF, i2);
            PointF pointF2 = this.pointB1;
            drawRuler(canvas2, pointF2, this.pointC1, pointF2, i2);
            PointF pointF3 = this.pointC1;
            PointF pointF4 = this.pointA1;
            drawRuler(canvas2, pointF3, pointF4, pointF4, i2);
            if (TriangularRulerExtension.DEBUG) {
                this.fileText = TextUtils.isEmpty(this.fileText) ? "5.5cm" : this.fileText;
            }
            if (!TextUtils.isEmpty(this.fileText)) {
                drawText(canvas, this.pointA1, this.pointB1, this.pointC1, i);
            }
            canvas.restore();
        } else if (TriangularRulerExtension.DEBUG) {
            XesLog.i(TAG + "共线，无法绘制");
            canvas.drawText("共线，无法绘制", this.pointA.x, this.pointA.y, this.textPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    public void updateConfig(TriangularRulerProtoBean.TriangularRulerConfig triangularRulerConfig) {
        TriangularRulerProtoBean.Vector v1 = triangularRulerConfig.getV1();
        TriangularRulerProtoBean.Vector v2 = triangularRulerConfig.getV2();
        TriangularRulerProtoBean.Vector v3 = triangularRulerConfig.getV3();
        this.fileText = triangularRulerConfig.getFillText();
        this.rotate = triangularRulerConfig.getRotate();
        if (!(v1 == null || v2 == null || v3 == null)) {
            this.originalAx = v1.getX();
            this.originalAy = v1.getY();
            this.originalBx = v2.getX();
            this.originalBy = v2.getY();
            this.originalCx = v3.getX();
            this.originalCy = v3.getY();
        }
        if (XesLog.isEnabled()) {
            XesLog.i("三角板接收数据:" + triangularRulerConfig.toString());
        }
    }
}
