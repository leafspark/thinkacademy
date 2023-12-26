package com.tal.app.thinkacademy.lib.imageloader;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/tal/app/thinkacademy/lib/imageloader/XesImageLoader$loadImageAutoHeight$1", "Lcom/bumptech/glide/request/RequestListener;", "Ljava/io/File;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesImageLoader.kt */
public final class XesImageLoader$loadImageAutoHeight$1 implements RequestListener<File> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ int $placeHolder;
    final /* synthetic */ ImageView $this_loadImageAutoHeight;
    final /* synthetic */ String $url;
    final /* synthetic */ int $width;

    XesImageLoader$loadImageAutoHeight$1(ImageView imageView, Context context, String str, int i, ImageView imageView2, int i2) {
        this.$this_loadImageAutoHeight = imageView;
        this.$context = context;
        this.$url = str;
        this.$placeHolder = i;
        this.$imageView = imageView2;
        this.$width = i2;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<File> target, boolean z) {
        XesLog.dt("测试glide", Intrinsics.stringPlus("loadImageAutoHeight onLoadFailed ", glideException));
        XesImageLoader.loadImage$default(XesImageLoader.INSTANCE, this.$this_loadImageAutoHeight, this.$context, this.$url, this.$placeHolder, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
        return false;
    }

    public boolean onResourceReady(File file, Object obj, Target<File> target, DataSource dataSource, boolean z) {
        String str;
        XesLog.dt("测试glide", "loadImageAutoHeight imageview width = " + this.$imageView.getWidth() + ",height=" + this.$imageView.getHeight());
        long currentTimeMillis = System.currentTimeMillis();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (file == null) {
            str = null;
        } else {
            try {
                str = file.getAbsolutePath();
            } catch (Exception e) {
                XesLog.dt("测试glide", Intrinsics.stringPlus("loadImageAutoHeight 2 error=", e));
            }
        }
        BitmapFactoryInstrumentation.decodeFile(str, options);
        if (options.outWidth > 0) {
            this.$imageView.getLayoutParams().height = (this.$width * options.outHeight) / options.outWidth;
            XesLog.dt("测试glide", "loadImageAutoHeight pic width = " + options.outWidth + ",height=" + options.outHeight);
        }
        XesLog.dt("测试glide", Intrinsics.stringPlus("loadImageAutoHeight 图片宽高耗时 = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        XesImageLoader.loadImage$default(XesImageLoader.INSTANCE, this.$this_loadImageAutoHeight, this.$context, file, this.$placeHolder, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
        return false;
    }
}
