package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.yalantis.ucrop.view.CropImageView;

public class VectorPath {
    private RectF localFrame;
    private Path realPath;
    private RectF svgFrame;
    private float xScale;
    private float yScale;

    public VectorPath(RectF rectF, RectF rectF2) {
        this.realPath = new Path();
        this.svgFrame = new RectF();
        this.localFrame = new RectF();
        this.xScale = 1.0f;
        this.yScale = 1.0f;
        this.svgFrame.set(rectF);
        this.localFrame.set(rectF2);
        if (!rectF.isEmpty()) {
            this.xScale = rectF2.width() / rectF.width();
            this.yScale = rectF2.height() / rectF.height();
        }
    }

    public VectorPath(RectF rectF, Rect rect) {
        this.realPath = new Path();
        this.svgFrame = new RectF();
        this.localFrame = new RectF();
        this.xScale = 1.0f;
        this.yScale = 1.0f;
        this.svgFrame.set(rectF);
        this.localFrame.set(rect);
        if (!rectF.isEmpty()) {
            this.xScale = ((float) rect.width()) / rectF.width();
            this.yScale = ((float) rect.height()) / rectF.height();
        }
    }

    public VectorPath(float f, float f2, Rect rect) {
        this(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, f2), rect);
    }

    public void reset() {
        this.realPath.reset();
    }

    public void resetLocalFrame(Rect rect) {
        this.localFrame.set(rect);
        if (!this.svgFrame.isEmpty()) {
            this.xScale = ((float) rect.width()) / this.svgFrame.width();
            this.yScale = ((float) rect.height()) / this.svgFrame.height();
        }
        this.realPath.reset();
    }

    public void moveTo(float f, float f2) {
        this.realPath.moveTo(getX(f), getY(f2));
    }

    public void lineTo(float f, float f2) {
        this.realPath.lineTo(getX(f), getY(f2));
    }

    public void addOval(float f, float f2, float f3, float f4) {
        this.realPath.addOval(new RectF(getX(f), getY(f2), getX(f3), getY(f4)), Path.Direction.CCW);
    }

    public void addCircle(float f, float f2, float f3) {
        this.realPath.addCircle(getX(f), getY(f2), f3, Path.Direction.CCW);
    }

    public void close() {
        this.realPath.close();
    }

    public void setFillType(Path.FillType fillType) {
        this.realPath.setFillType(fillType);
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(this.realPath, paint);
    }

    private float getX(float f) {
        return this.localFrame.left + (f * this.xScale);
    }

    private float getY(float f) {
        return this.localFrame.top + (f * this.yScale);
    }

    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.realPath.cubicTo(getX(f), getY(f2), getX(f3), getY(f4), getX(f5), getY(f6));
    }

    public Path getRealPath() {
        return this.realPath;
    }
}
