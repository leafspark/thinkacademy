package com.tal.app.thinkacademy.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/common/utils/GlideEngine$loadFolderImage$1", "Lcom/bumptech/glide/request/target/BitmapImageViewTarget;", "setResource", "", "resource", "Landroid/graphics/Bitmap;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlideEngine.kt */
public final class GlideEngine$loadFolderImage$1 extends BitmapImageViewTarget {
    final /* synthetic */ Context $context;
    final /* synthetic */ ImageView $imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlideEngine$loadFolderImage$1(ImageView imageView, Context context) {
        super(imageView);
        this.$imageView = imageView;
        this.$context = context;
    }

    /* access modifiers changed from: protected */
    public void setResource(Bitmap bitmap) {
        Drawable create = RoundedBitmapDrawableFactory.create(this.$context.getResources(), bitmap);
        Intrinsics.checkNotNullExpressionValue(create, "create(context.resources, resource)");
        create.setCornerRadius(8.0f);
        this.$imageView.setImageDrawable(create);
    }
}
