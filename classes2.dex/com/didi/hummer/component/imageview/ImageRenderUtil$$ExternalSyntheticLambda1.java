package com.didi.hummer.component.imageview;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.didi.hummer.adapter.imageloader.DrawableCallback;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.render.utility.YogaDrawableUtil;

public final /* synthetic */ class ImageRenderUtil$$ExternalSyntheticLambda1 implements DrawableCallback {
    public final /* synthetic */ HummerContext f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ ImageView f$3;
    public final /* synthetic */ JSCallback f$4;

    public /* synthetic */ ImageRenderUtil$$ExternalSyntheticLambda1(HummerContext hummerContext, String str, String str2, ImageView imageView, JSCallback jSCallback) {
        this.f$0 = hummerContext;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = imageView;
        this.f$4 = jSCallback;
    }

    public final void onDrawableLoaded(Drawable drawable) {
        YogaDrawableUtil.loadDrawable(this.f$0, this.f$1, new ImageRenderUtil$$ExternalSyntheticLambda0(this.f$0, this.f$2, drawable, this.f$3, this.f$4));
    }
}
