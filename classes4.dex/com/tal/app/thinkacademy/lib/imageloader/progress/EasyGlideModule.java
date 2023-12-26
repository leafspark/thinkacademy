package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.tal.app.thinkacademy.lib.imageloader.http.OkHttpUrlLoader;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/EasyGlideModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "applyOptions", "", "context", "Landroid/content/Context;", "builder", "Lcom/bumptech/glide/GlideBuilder;", "isManifestParsingEnabled", "", "registerComponents", "glide", "Lcom/bumptech/glide/Glide;", "registry", "Lcom/bumptech/glide/Registry;", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EasyGlideModule.kt */
public final class EasyGlideModule extends AppGlideModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int IMAGE_DISK_CACHE_MAX_SIZE = 104857600;

    public boolean isManifestParsingEnabled() {
        return false;
    }

    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glideBuilder, "builder");
        glideBuilder.setDiskCache(new InternalCacheDiskCacheFactory(context, "Glide", 104857600));
        MemorySizeCalculator build = new MemorySizeCalculator.Builder(context).build();
        glideBuilder.setMemoryCache(new LruResourceCache((long) ((int) (((double) build.getMemoryCacheSize()) * 1.2d))));
        glideBuilder.setBitmapPool(new LruBitmapPool((long) ((int) (((double) build.getBitmapPoolSize()) * 1.2d))));
    }

    public void registerComponents(Context context, Glide glide, Registry registry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glide, "glide");
        Intrinsics.checkNotNullParameter(registry, "registry");
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(ProgressManager.INSTANCE.getOkHttpClient()));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/EasyGlideModule$Companion;", "", "()V", "IMAGE_DISK_CACHE_MAX_SIZE", "", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EasyGlideModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
