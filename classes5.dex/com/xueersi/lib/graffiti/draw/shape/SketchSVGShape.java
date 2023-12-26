package com.xueersi.lib.graffiti.draw.shape;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.shape.math.VectorPath;
import com.yalantis.ucrop.view.CropImageView;

public abstract class SketchSVGShape extends RectBoundShape {
    protected volatile VectorPath fillPath;
    private RectF frameRectF = new RectF();
    protected Paint mPaint;
    protected volatile VectorPath strokeDashedPath;
    protected volatile VectorPath strokePath;

    protected enum Style {
        STROKE,
        FILL,
        STROKE_DASHED
    }

    /* access modifiers changed from: protected */
    public abstract void buildPath(RectF rectF);

    public SketchSVGShape() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    /* access modifiers changed from: protected */
    public VectorPath getVectorPath(Style style) {
        if (this.frameRectF.isEmpty()) {
            throw new IllegalArgumentException("frameRectF is empty");
        } else if (style == Style.STROKE) {
            if (this.strokePath == null) {
                this.strokePath = new VectorPath(this.frameRectF, this.rect);
            }
            return this.strokePath;
        } else if (style == Style.FILL) {
            if (this.fillPath == null) {
                this.fillPath = new VectorPath(this.frameRectF, this.rect);
            }
            return this.fillPath;
        } else if (style != Style.STROKE_DASHED) {
            return new VectorPath(this.frameRectF, this.rect);
        } else {
            if (this.strokeDashedPath == null) {
                this.strokeDashedPath = new VectorPath(this.frameRectF, this.rect);
            }
            return this.strokeDashedPath;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.strokeDashedPath != null) {
            this.mPaint.setColor(this.strokeColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mLineWidth);
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{1.0f, this.mLineWidth * 2.0f}, CropImageView.DEFAULT_ASPECT_RATIO));
            this.strokeDashedPath.draw(canvas, this.mPaint);
        }
        if (this.fillPath != null) {
            this.mPaint.setColor(this.strokeColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setPathEffect((PathEffect) null);
            this.fillPath.draw(canvas, this.mPaint);
        }
        if (this.strokePath != null) {
            this.mPaint.setColor(this.strokeColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setPathEffect((PathEffect) null);
            this.mPaint.setStrokeWidth(this.mLineWidth);
            this.strokePath.draw(canvas, this.mPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        if (this.fillPath != null) {
            this.fillPath.resetLocalFrame(this.rect);
        }
        if (this.strokePath != null) {
            this.strokePath.resetLocalFrame(this.rect);
        }
        if (this.strokeDashedPath != null) {
            this.strokeDashedPath.resetLocalFrame(this.rect);
        }
        buildPath(this.frameRectF);
    }
}
