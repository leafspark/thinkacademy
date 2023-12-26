package com.xueersi.lib.graffiti.draw.shape.chemistry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.xueersi.lib.graffiti.draw.shape.math.VectorPath;
import com.yalantis.ucrop.view.CropImageView;

public class ChemistryCoordinate extends SketchSVGShape {
    private volatile Path mArrowPath = new Path();

    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        vectorPath.lineTo(1.0f, 1.0f);
        vectorPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        vectorPath.lineTo(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.strokeColor);
        disableLineEffect(this.mPaint);
        canvas.drawPath(this.mArrowPath, this.mPaint);
        this.mPaint.setStrokeWidth(this.mLineWidth);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(this.strokeColor);
        canvas.drawPath(this.mArrowPath, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        super.updateActionData(wXWBAction);
        this.mArrowPath.reset();
        this.mArrowPath.setFillType(Path.FillType.EVEN_ODD);
        Point point = new Point(this.rect.left, this.rect.top);
        this.mArrowPath.moveTo((float) point.x, (float) point.y);
        point.offset(((int) (-this.mLineWidth)) * 2, ((int) this.mLineWidth) * 4);
        this.mArrowPath.lineTo((float) point.x, (float) point.y);
        point.offset(((int) this.mLineWidth) * 4, 0);
        this.mArrowPath.lineTo((float) point.x, (float) point.y);
        this.mArrowPath.close();
        point.set(this.rect.right, this.rect.bottom);
        this.mArrowPath.moveTo((float) point.x, (float) point.y);
        point.offset(((int) (-this.mLineWidth)) * 4, ((int) (-this.mLineWidth)) * 2);
        this.mArrowPath.lineTo((float) point.x, (float) point.y);
        point.offset(0, ((int) this.mLineWidth) * 4);
        this.mArrowPath.lineTo((float) point.x, (float) point.y);
        this.mArrowPath.close();
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new ChemistryCoordinate();
        }
    }
}
