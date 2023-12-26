package com.luck.picture.lib.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class MScroller extends Scroller {
    private static final Interpolator sInterpolator = MScroller$$ExternalSyntheticLambda0.INSTANCE;
    public boolean noDuration;

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    public MScroller(Context context) {
        this(context, sInterpolator);
    }

    public MScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public void setNoDuration(boolean z) {
        this.noDuration = z;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        if (this.noDuration) {
            super.startScroll(i, i2, i3, i4, 0);
        } else {
            super.startScroll(i, i2, i3, i4, i5);
        }
    }
}
