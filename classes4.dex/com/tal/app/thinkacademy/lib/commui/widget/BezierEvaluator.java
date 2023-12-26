package com.tal.app.thinkacademy.lib.commui.widget;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import java.util.Objects;

public class BezierEvaluator implements TypeEvaluator<PointF> {
    private PointF mControlPoint;

    public BezierEvaluator(PointF pointF, PointF pointF2, BezierDirection bezierDirection, int i) {
        Objects.requireNonNull(pointF, "起点不可为空");
        Objects.requireNonNull(pointF2, "终点不可为空");
        float f = pointF.y + ((pointF2.y - pointF.y) / 2.0f);
        if (bezierDirection == BezierDirection.UP) {
            f += (float) i;
        } else if (bezierDirection == BezierDirection.DOWN) {
            f -= (float) i;
        }
        this.mControlPoint = new PointF(pointF.x + ((pointF2.x - pointF.x) / 2.0f), f);
    }

    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = 1.0f - f;
        float f3 = f2 * f2;
        float f4 = 2.0f * f * f2;
        float f5 = f * f;
        return new PointF((float) ((int) ((pointF.x * f3) + (this.mControlPoint.x * f4) + (pointF2.x * f5))), (float) ((int) ((f3 * pointF.y) + (f4 * this.mControlPoint.y) + (f5 * pointF2.y))));
    }
}
