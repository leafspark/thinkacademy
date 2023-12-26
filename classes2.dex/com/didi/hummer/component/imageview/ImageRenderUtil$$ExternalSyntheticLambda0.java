package com.didi.hummer.component.imageview;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.didi.hummer.adapter.imageloader.DrawableCallback;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class ImageRenderUtil$$ExternalSyntheticLambda0 implements DrawableCallback {
    public final /* synthetic */ HummerContext f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Drawable f$2;
    public final /* synthetic */ ImageView f$3;
    public final /* synthetic */ JSCallback f$4;

    public /* synthetic */ ImageRenderUtil$$ExternalSyntheticLambda0(HummerContext hummerContext, String str, Drawable drawable, ImageView imageView, JSCallback jSCallback) {
        this.f$0 = hummerContext;
        this.f$1 = str;
        this.f$2 = drawable;
        this.f$3 = imageView;
        this.f$4 = jSCallback;
    }

    public final void onDrawableLoaded(Drawable drawable) {
        ImageRenderUtil.getImageLoader(this.f$0).setImage(ImageRenderUtil.fitRemoteUrl(this.f$1), this.f$2, drawable, this.f$3, this.f$4);
    }
}
