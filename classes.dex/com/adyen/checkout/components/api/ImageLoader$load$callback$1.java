package com.adyen.checkout.components.api;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.adyen.checkout.components.api.LogoConnectionTask;
import com.adyen.checkout.core.log.Logger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/adyen/checkout/components/api/ImageLoader$load$callback$1", "Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "onLogoReceived", "", "drawable", "Landroid/graphics/drawable/BitmapDrawable;", "onReceiveFailed", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageLoader.kt */
public final class ImageLoader$load$callback$1 implements LogoConnectionTask.LogoCallback {
    final /* synthetic */ int $errorFallback;
    final /* synthetic */ String $id;
    final /* synthetic */ ImageLoader this$0;

    ImageLoader$load$callback$1(ImageLoader imageLoader, String str, int i) {
        this.this$0 = imageLoader;
        this.$id = str;
        this.$errorFallback = i;
    }

    public void onLogoReceived(BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(bitmapDrawable, "drawable");
        WeakReference weakReference = (WeakReference) this.this$0.imageViews.get(this.$id);
        ImageView imageView = weakReference == null ? null : (ImageView) weakReference.get();
        if (imageView != null) {
            imageView.setImageDrawable(bitmapDrawable);
        } else {
            Logger.e(ImageLoader.TAG, Intrinsics.stringPlus("ImageView is null for received Logo - ", this.$id));
        }
        this.this$0.callbacks.remove(this.$id);
        this.this$0.imageViews.remove(this.$id);
    }

    public void onReceiveFailed() {
        WeakReference weakReference = (WeakReference) this.this$0.imageViews.get(this.$id);
        ImageView imageView = weakReference == null ? null : (ImageView) weakReference.get();
        if (imageView != null) {
            imageView.setImageResource(this.$errorFallback);
        } else {
            Logger.e(ImageLoader.TAG, Intrinsics.stringPlus("ImageView is null for failed Logo - ", this.$id));
        }
        this.this$0.callbacks.remove(this.$id);
        this.this$0.imageViews.remove(this.$id);
    }
}
