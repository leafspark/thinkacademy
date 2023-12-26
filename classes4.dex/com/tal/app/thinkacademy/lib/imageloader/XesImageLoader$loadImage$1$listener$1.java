package com.tal.app.thinkacademy.lib.imageloader;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.track.LibCommonTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J@\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/tal/app/thinkacademy/lib/imageloader/XesImageLoader$loadImage$1$listener$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesImageLoader.kt */
public final class XesImageLoader$loadImage$1$listener$1 implements RequestListener<Drawable> {
    final /* synthetic */ GlideConfigImpl $config;

    XesImageLoader$loadImage$1$listener$1(GlideConfigImpl glideConfigImpl) {
        this.$config = glideConfigImpl;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        Intrinsics.checkNotNullParameter(target, "target");
        ImageRequestListener<Drawable> requestListener = this.$config.getRequestListener();
        if (requestListener != null) {
            requestListener.onLoadFailed(glideException, obj, target, z);
        }
        String valueOf = String.valueOf(glideException);
        XesLog.e(XesImageLoader.TAG, Intrinsics.stringPlus("图片加载失败 = ", valueOf));
        LibCommonTrack.INSTANCE.glideLoadFailed(this.$config.getUrl(), valueOf);
        return false;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        ImageRequestListener<Drawable> requestListener = this.$config.getRequestListener();
        if (requestListener == null) {
            return false;
        }
        requestListener.onResourceReady(drawable, obj, target, dataSource, z);
        return false;
    }
}
