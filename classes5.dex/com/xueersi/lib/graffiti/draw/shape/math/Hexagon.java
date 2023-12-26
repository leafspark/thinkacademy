package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.PointData;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

public class Hexagon extends SketchSVGShape {
    /* access modifiers changed from: protected */
    public void buildPath(RectF rectF) {
        rectF.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        List<PointData.Point> polygonPoint = polygonPoint(6, 1.0f, 1.0f);
        for (int i = 0; i < polygonPoint.size(); i++) {
            PointData.Point point = polygonPoint.get(i);
            if (i == 0) {
                vectorPath.moveTo(point.getX(), point.getY());
            } else {
                vectorPath.lineTo(point.getX(), point.getY());
            }
        }
        vectorPath.close();
    }

    public static class Factory extends DrawableObject.Factory {
        public DrawableObject create() {
            return new Hexagon();
        }
    }

    private List<PointData.Point> polygonPoint(int i, float f, float f2) {
        ArrayList arrayList = new ArrayList();
        double min = ((double) Math.min(f, f2)) * 0.5d;
        double d = 6.283185307179586d / ((double) i);
        double d2 = i % 2 == 0 ? -d : -1.5707963267948966d;
        for (int i2 = 0; i2 <= i; i2++) {
            arrayList.add(new PointData.Point(1, (float) ((Math.cos(d2) + 1.0d) * min), (float) ((Math.sin(d2) + 1.0d) * min), 1.0f));
            d2 += d;
        }
        return arrayList;
    }
}
