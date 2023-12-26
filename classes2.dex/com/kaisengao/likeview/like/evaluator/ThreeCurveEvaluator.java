package com.kaisengao.likeview.like.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class ThreeCurveEvaluator implements TypeEvaluator<PointF> {
    private final PointF mControlP1;
    private final PointF mControlP2;

    public ThreeCurveEvaluator(PointF pointF, PointF pointF2) {
        this.mControlP1 = pointF;
        this.mControlP2 = pointF2;
    }

    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = f;
        PointF pointF3 = pointF;
        PointF pointF4 = pointF2;
        PointF pointF5 = new PointF();
        float f3 = 1.0f - f2;
        double d = (double) f3;
        float f4 = f3 * 3.0f;
        double d2 = (double) f2;
        pointF5.x = (((float) Math.pow(d, 3.0d)) * pointF3.x) + (((float) Math.pow(d, 2.0d)) * 3.0f * f2 * this.mControlP1.x) + (((float) Math.pow(d2, 2.0d)) * f4 * this.mControlP2.x) + (((float) Math.pow(d2, 3.0d)) * pointF4.x);
        pointF5.y = (((float) Math.pow(d, 3.0d)) * pointF3.y) + (((float) Math.pow(d, 2.0d)) * 3.0f * f2 * this.mControlP1.y) + (f4 * f2 * f2 * this.mControlP2.y) + (((float) Math.pow(d2, 3.0d)) * pointF4.y);
        return pointF5;
    }
}
