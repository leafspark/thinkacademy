package com.tal.app.thinkacademy.lib.imageloader;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/tal/app/thinkacademy/lib/imageloader/XesImageLoader$loadRoundCornerImageAutoHeight$1", "Lcom/bumptech/glide/request/RequestListener;", "Ljava/io/File;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesImageLoader.kt */
public final class XesImageLoader$loadRoundCornerImageAutoHeight$1 implements RequestListener<File> {
    final /* synthetic */ Context $context;
    final /* synthetic */ RoundedCornersTransformation.CornerType $cornerType;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ int $margin;
    final /* synthetic */ int $placeHolder;
    final /* synthetic */ int $radius;
    final /* synthetic */ ImageView $this_loadRoundCornerImageAutoHeight;
    final /* synthetic */ String $url;
    final /* synthetic */ int $width;

    XesImageLoader$loadRoundCornerImageAutoHeight$1(ImageView imageView, Context context, String str, int i, int i2, int i3, RoundedCornersTransformation.CornerType cornerType, ImageView imageView2, int i4) {
        this.$this_loadRoundCornerImageAutoHeight = imageView;
        this.$context = context;
        this.$url = str;
        this.$radius = i;
        this.$margin = i2;
        this.$placeHolder = i3;
        this.$cornerType = cornerType;
        this.$imageView = imageView2;
        this.$width = i4;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<File> target, boolean z) {
        XesLog.dt("测试glide", Intrinsics.stringPlus("loadRoundCornerImageAutoHeight onLoadFailed ", glideException));
        XesImageLoader.INSTANCE.loadRoundCornerImage(this.$this_loadRoundCornerImageAutoHeight, this.$context, this.$url, this.$radius, this.$margin, this.$placeHolder, this.$cornerType);
        return false;
    }

    public boolean onResourceReady(File file, Object obj, Target<File> target, DataSource dataSource, boolean z) {
        String str;
        XesLog.dt("测试glide", "loadRoundCornerImageAutoHeight imageview width = " + this.$imageView.getWidth() + ",height=" + this.$imageView.getHeight());
        long currentTimeMillis = System.currentTimeMillis();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (file == null) {
            str = null;
        } else {
            try {
                str = file.getAbsolutePath();
            } catch (Exception e) {
                XesLog.dt("测试glide", Intrinsics.stringPlus("loadRoundCornerImageAutoHeight 2 error=", e));
            }
        }
        BitmapFactoryInstrumentation.decodeFile(str, options);
        if (options.outWidth > 0) {
            this.$imageView.getLayoutParams().height = (this.$width * options.outHeight) / options.outWidth;
            XesLog.dt("测试glide", "loadRoundCornerImageAutoHeight pic width = " + options.outWidth + ",height=" + options.outHeight);
        }
        XesLog.dt("测试glide", Intrinsics.stringPlus("loadRoundCornerImageAutoHeight 图片宽高耗时 = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        XesImageLoader.INSTANCE.loadRoundCornerImage(this.$this_loadRoundCornerImageAutoHeight, this.$context, file, this.$radius, this.$margin, this.$placeHolder, this.$cornerType);
        return false;
    }
}
