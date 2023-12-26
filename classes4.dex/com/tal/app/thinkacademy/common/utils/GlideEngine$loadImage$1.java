package com.tal.app.thinkacademy.common.utils;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/common/utils/GlideEngine$loadImage$1", "Lcom/bumptech/glide/request/target/ImageViewTarget;", "Landroid/graphics/Bitmap;", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onLoadStarted", "placeholder", "setResource", "resource", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlideEngine.kt */
public final class GlideEngine$loadImage$1 extends ImageViewTarget<Bitmap> {
    final /* synthetic */ OnImageCompleteCallback $callback;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ SubsamplingScaleImageView $longImageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlideEngine$loadImage$1(ImageView imageView, OnImageCompleteCallback onImageCompleteCallback, SubsamplingScaleImageView subsamplingScaleImageView) {
        super(imageView);
        this.$imageView = imageView;
        this.$callback = onImageCompleteCallback;
        this.$longImageView = subsamplingScaleImageView;
    }

    public void onLoadStarted(Drawable drawable) {
        GlideEngine$loadImage$1.super.onLoadStarted(drawable);
        OnImageCompleteCallback onImageCompleteCallback = this.$callback;
        if (onImageCompleteCallback != null) {
            onImageCompleteCallback.onShowLoading();
        }
    }

    public void onLoadFailed(Drawable drawable) {
        GlideEngine$loadImage$1.super.onLoadFailed(drawable);
        OnImageCompleteCallback onImageCompleteCallback = this.$callback;
        if (onImageCompleteCallback != null) {
            onImageCompleteCallback.onHideLoading();
        }
    }

    /* access modifiers changed from: protected */
    public void setResource(Bitmap bitmap) {
        OnImageCompleteCallback onImageCompleteCallback = this.$callback;
        if (onImageCompleteCallback != null) {
            onImageCompleteCallback.onHideLoading();
        }
        if (bitmap != null) {
            boolean isLongImg = MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
            int i = 8;
            this.$longImageView.setVisibility(isLongImg ? 0 : 8);
            ImageView imageView = this.$imageView;
            if (!isLongImg) {
                i = 0;
            }
            imageView.setVisibility(i);
            if (isLongImg) {
                this.$longImageView.setQuickScaleEnabled(true);
                this.$longImageView.setZoomEnabled(true);
                this.$longImageView.setDoubleTapZoomDuration(100);
                this.$longImageView.setMinimumScaleType(2);
                this.$longImageView.setDoubleTapZoomDpi(2);
                this.$longImageView.setImage(ImageSource.bitmap(bitmap), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
                return;
            }
            this.$imageView.setImageBitmap(bitmap);
        }
    }
}
