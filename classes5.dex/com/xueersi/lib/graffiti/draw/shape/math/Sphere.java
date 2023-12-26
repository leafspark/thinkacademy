package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.xueersi.lib.graffiti.utils.DrawUtil;
import com.yalantis.ucrop.view.CropImageView;

public class Sphere extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        RectF rectF2 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, 0.28f, 1.0f, 0.72f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.addOval(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        float width = rectF2.width() / 2.0f;
        float height = rectF2.height() / 2.0f;
        DrawUtil.drawHalfOval(vectorPath, rectF2.centerX(), rectF2.centerY(), width, height, false);
        DrawUtil.drawHalfOval(getVectorPath(SketchSVGShape.Style.STROKE_DASHED), rectF2.centerX(), rectF2.centerY() + 0.02f, width, height, true);
        if (arrowCircleCenter()) {
            getVectorPath(SketchSVGShape.Style.FILL).addCircle(rectF2.centerX(), rectF2.centerY(), this.mLineWidth);
        }
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Sphere();
        }
    }
}
