package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000e2\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u000e\u0018\u00010\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/GlideImageViewTarget;", "Lcom/bumptech/glide/request/target/DrawableImageViewTarget;", "view", "Landroid/widget/ImageView;", "url", "", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlideImageViewTarget.kt */
public final class GlideImageViewTarget extends DrawableImageViewTarget {
    private String url;

    public GlideImageViewTarget(ImageView imageView, String str) {
        super(imageView);
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public void onLoadFailed(Drawable drawable) {
        OnProgressListener progressListener;
        String str = this.url;
        if (!(str == null || (progressListener = ProgressManager.INSTANCE.getProgressListener(str)) == null)) {
            progressListener.onProgress(false, 100, 0, 0);
            ProgressManager.INSTANCE.removeListener(str);
        }
        GlideImageViewTarget.super.onLoadFailed(drawable);
    }

    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
        OnProgressListener progressListener;
        Intrinsics.checkNotNullParameter(drawable, "resource");
        String str = this.url;
        if (!(str == null || (progressListener = ProgressManager.INSTANCE.getProgressListener(str)) == null)) {
            progressListener.onProgress(true, 100, 0, 0);
            ProgressManager.INSTANCE.removeListener(str);
        }
        GlideImageViewTarget.super.onResourceReady(drawable, transition);
    }
}
