package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;
import com.yalantis.ucrop.view.CropImageView;

public class Cylinder extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        RectF rectF2 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 0.32f);
        RectF rectF3 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, 0.68f, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(rectF2.left, rectF2.centerY());
        vectorPath.lineTo(rectF3.left, rectF3.centerY());
        vectorPath.moveTo(rectF2.right, rectF2.centerY());
        vectorPath.lineTo(rectF3.right, rectF3.centerY());
        float height = rectF2.height() / 2.0f;
        VectorPath vectorPath2 = vectorPath;
        float width = rectF2.width() / 2.0f;
        float f = height;
        DrawUtil.drawHalfOval(vectorPath2, rectF2.centerX(), rectF2.centerY(), width, f, false);
        DrawUtil.drawHalfOval(vectorPath2, rectF2.centerX(), rectF2.centerY(), width, f, true);
        if (arrowCircleCenter()) {
            getVectorPath(SketchSVGShape.Style.FILL).addCircle(rectF2.centerX(), rectF2.centerY(), this.mLineWidth);
        }
        float width2 = rectF3.width() / 2.0f;
        float height2 = rectF3.height() / 2.0f;
        DrawUtil.drawHalfOval(vectorPath, rectF3.centerX(), rectF3.centerY(), width2, height2, false);
        DrawUtil.drawHalfOval(getVectorPath(SketchSVGShape.Style.STROKE_DASHED), rectF3.centerX(), 0.02f + rectF3.centerY(), width2, height2, true);
        if (arrowCircleCenter()) {
            getVectorPath(SketchSVGShape.Style.FILL).addCircle(rectF3.centerX(), rectF3.centerY(), this.mLineWidth);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Cylinder();
        }
    }
}
