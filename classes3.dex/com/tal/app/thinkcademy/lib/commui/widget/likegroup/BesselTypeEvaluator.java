package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J0\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/BesselTypeEvaluator;", "Landroid/animation/TypeEvaluator;", "Landroid/graphics/PointF;", "p0", "p1", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "getP0", "()Landroid/graphics/PointF;", "getP1", "bessel", "", "p2", "p3", "t", "evaluate", "fraction", "startValue", "endValue", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyAnimGroup.kt */
final class BesselTypeEvaluator implements TypeEvaluator<PointF> {
    private final PointF p0;
    private final PointF p1;

    public BesselTypeEvaluator(PointF pointF, PointF pointF2) {
        Intrinsics.checkNotNullParameter(pointF, "p0");
        Intrinsics.checkNotNullParameter(pointF2, "p1");
        this.p0 = pointF;
        this.p1 = pointF2;
    }

    public final PointF getP0() {
        return this.p0;
    }

    public final PointF getP1() {
        return this.p1;
    }

    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        Intrinsics.checkNotNullParameter(pointF, "startValue");
        Intrinsics.checkNotNullParameter(pointF2, "endValue");
        PointF pointF3 = new PointF();
        pointF3.x = bessel(pointF.x, this.p0.x, this.p1.x, pointF2.x, f);
        pointF3.y = bessel(pointF.y, this.p0.y, this.p1.y, pointF2.y, f);
        return pointF3;
    }

    private final float bessel(float f, float f2, float f3, float f4, float f5) {
        float f6 = ((float) 1) - f5;
        double d = (double) f6;
        double d2 = (double) 3;
        float f7 = (float) 3;
        double d3 = (double) 2;
        float pow = (f * ((float) Math.pow(d, d2))) + (f2 * f7 * f5 * ((float) Math.pow(d, d3)));
        double d4 = (double) f5;
        return pow + (f7 * f3 * ((float) Math.pow(d4, d3)) * f6) + (f4 * ((float) Math.pow(d4, d2)));
    }
}
