package com.didi.hummer.render.utility;

import android.graphics.drawable.Drawable;
import com.didi.hummer.adapter.imageloader.DrawableCallback;
import com.didi.hummer.render.component.view.BackgroundDrawable;

public final /* synthetic */ class YogaDrawableUtil$$ExternalSyntheticLambda0 implements DrawableCallback {
    public final /* synthetic */ BackgroundDrawable f$0;

    public /* synthetic */ YogaDrawableUtil$$ExternalSyntheticLambda0(BackgroundDrawable backgroundDrawable) {
        this.f$0 = backgroundDrawable;
    }

    public final void onDrawableLoaded(Drawable drawable) {
        this.f$0.setDrawable(drawable);
    }
}
