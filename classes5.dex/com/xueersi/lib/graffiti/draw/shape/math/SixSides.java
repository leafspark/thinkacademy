package com.xueersi.lib.graffiti.draw.shape.math;

import android.graphics.PointF;
import android.graphics.RectF;
import com.xueersi.lib.graffiti.draw.shape.SketchSVGShape;

public abstract class SixSides extends SketchSVGShape {
    private PointF a = new PointF();
    private PointF a1 = new PointF();
    private PointF b = new PointF();
    private PointF b1 = new PointF();
    private PointF c = new PointF();
    private PointF c1 = new PointF();
    private PointF d = new PointF();
    private PointF d1 = new PointF();

    /* access modifiers changed from: protected */
    public abstract void pointConfig(RectF rectF, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, PointF pointF6, PointF pointF7, PointF pointF8);

    /* access modifiers changed from: protected */
    public final void buildPath(RectF rectF) {
        pointConfig(rectF, this.a, this.b, this.c, this.d, this.a1, this.b1, this.c1, this.d1);
        VectorPath vectorPath = getVectorPath(SketchSVGShape.Style.STROKE);
        vectorPath.reset();
        vectorPath.moveTo(this.a.x, this.a.y);
        vectorPath.lineTo(this.b.x, this.b.y);
        vectorPath.lineTo(this.b1.x, this.b1.y);
        vectorPath.lineTo(this.c1.x, this.c1.y);
        vectorPath.lineTo(this.d1.x, this.d1.y);
        vectorPath.lineTo(this.d.x, this.d.y);
        vectorPath.close();
        vectorPath.moveTo(this.d.x, this.d.y);
        vectorPath.lineTo(this.c.x, this.c.y);
        vectorPath.lineTo(this.b.x, this.b.y);
        vectorPath.moveTo(this.c.x, this.c.y);
        vectorPath.lineTo(this.c1.x, this.c1.y);
        VectorPath vectorPath2 = getVectorPath(SketchSVGShape.Style.STROKE_DASHED);
        vectorPath2.reset();
        vectorPath2.moveTo(this.a.x, this.a.y);
        vectorPath2.lineTo(this.a1.x, this.a1.y);
        vectorPath2.lineTo(this.b1.x, this.b1.y);
        vectorPath2.moveTo(this.a1.x, this.a1.y);
        vectorPath2.lineTo(this.d1.x, this.d1.y);
    }
}
