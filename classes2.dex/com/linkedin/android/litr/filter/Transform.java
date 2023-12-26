package com.linkedin.android.litr.filter;

import android.graphics.PointF;

public class Transform {
    public final PointF position;
    public final float rotation;
    public final PointF size;

    public Transform(PointF pointF, PointF pointF2, float f) {
        this.size = pointF;
        this.position = pointF2;
        this.rotation = f;
    }
}
