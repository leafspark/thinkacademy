package com.tal.app.thinkacademy.lib.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.tal.app.thinkacademy.lib.Tag;
import com.tal.app.thinkacademy.lib.imageloader.config.GlideConfigImpl;
import com.tal.app.thinkacademy.lib.imageloader.progress.EasyGlideApp;
import com.tal.app.thinkacademy.lib.imageloader.progress.GlideImageViewTarget;
import com.tal.app.thinkacademy.lib.imageloader.progress.GlideRequest;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.imageloader.progress.ProgressManager;
import com.tal.app.thinkacademy.lib.imageloader.transformation.BlurTransformation;
import com.tal.app.thinkacademy.lib.imageloader.transformation.BorderTransformation;
import com.tal.app.thinkacademy.lib.imageloader.transformation.CircleWithBorderTransformation;
import com.tal.app.thinkacademy.lib.imageloader.transformation.GrayscaleTransformation;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.library.R;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J2\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0003\u0010\u001e\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ2\u0010#\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u0006H\u0007J<\u0010%\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0003\u0010'\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u0006H\u0007J(\u0010(\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0003\u0010\u001e\u001a\u00020\u0006H\u0007JF\u0010)\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0003\u0010'\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u000fH\u0007J(\u0010+\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0003\u0010\u001e\u001a\u00020\u0006H\u0007JH\u0010\u001f\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0003\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0007J\u001c\u0010\u001f\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u00103\u001a\u00020\u0006JH\u0010\u001f\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0003\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0007JH\u00104\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0003\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0007JP\u00105\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0003\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0007JH\u00106\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0003\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0012\b\u0002\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0007J?\u00107\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020:09\"\u00020:2\b\b\u0003\u0010\u001e\u001a\u00020\u0006¢\u0006\u0002\u0010;J8\u0010<\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u0006H\u0007JF\u0010?\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020BH\u0007JF\u0010?\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020BH\u0007JL\u0010C\u001a\u00020\u0012*\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010A\u001a\u00020BR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006D"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/XesImageLoader;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/lib/Tag;", "circlePlaceholderImageView", "", "getCirclePlaceholderImageView", "()I", "setCirclePlaceholderImageView", "(I)V", "placeHolderImageView", "getPlaceHolderImageView", "setPlaceHolderImageView", "checkContextIsAvailable", "", "object", "clearDiskCache", "", "context", "Landroid/content/Context;", "clearImage", "imageView", "Landroid/widget/ImageView;", "clearMemory", "loadBigPicAutoHeight", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "width", "url", "", "placeHolder", "loadImage", "config", "Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl;", "preloadImage", "loadBlurImage", "radius", "loadBorderImage", "borderWidth", "borderColor", "loadCircleImage", "loadCircleWithBorderImage", "isPixelBorder", "loadGrayImage", "file", "Ljava/io/File;", "onProgressListener", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;", "requestListener", "Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;", "Landroid/graphics/drawable/Drawable;", "drawableId", "loadImage565", "loadImageAutoHeight", "loadImageNormal", "loadImageWithTransformation", "bitmapTransformations", "", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "(Landroid/widget/ImageView;Landroid/content/Context;Ljava/lang/String;[Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;I)V", "loadResizeXYImage", "resizeX", "resizeY", "loadRoundCornerImage", "margin", "cornerType", "Lcom/tal/app/thinkacademy/lib/imageloader/transformation/RoundedCornersTransformation$CornerType;", "loadRoundCornerImageAutoHeight", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesImageLoader.kt */
public final class XesImageLoader {
    public static final XesImageLoader INSTANCE = new XesImageLoader();
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PIC_LOAD;
    private static int circlePlaceholderImageView = R.color.transparent;
    private static int placeHolderImageView = R.color.transparent;

    public final void loadBlurImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadBlurImage$default(this, imageView, context, str, 0, 0, 12, (Object) null);
    }

    public final void loadBlurImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadBlurImage$default(this, imageView, context, str, i, 0, 8, (Object) null);
    }

    public final void loadBorderImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadBorderImage$default(this, imageView, context, str, 0, 0, 0, 28, (Object) null);
    }

    public final void loadBorderImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadBorderImage$default(this, imageView, context, str, i, 0, 0, 24, (Object) null);
    }

    public final void loadBorderImage(ImageView imageView, Context context, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadBorderImage$default(this, imageView, context, str, i, i2, 0, 16, (Object) null);
    }

    public final void loadCircleImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadCircleImage$default(this, imageView, context, str, 0, 4, (Object) null);
    }

    public final void loadCircleWithBorderImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadCircleWithBorderImage$default(this, imageView, context, str, 0, 0, 0, false, 60, (Object) null);
    }

    public final void loadCircleWithBorderImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadCircleWithBorderImage$default(this, imageView, context, str, i, 0, 0, false, 56, (Object) null);
    }

    public final void loadCircleWithBorderImage(ImageView imageView, Context context, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadCircleWithBorderImage$default(this, imageView, context, str, i, i2, 0, false, 48, (Object) null);
    }

    public final void loadCircleWithBorderImage(ImageView imageView, Context context, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadCircleWithBorderImage$default(this, imageView, context, str, i, i2, i3, false, 32, (Object) null);
    }

    public final void loadGrayImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadGrayImage$default(this, imageView, context, str, 0, 4, (Object) null);
    }

    public final void loadImage(ImageView imageView, Context context, File file) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage$default(this, imageView, context, file, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
    }

    public final void loadImage(ImageView imageView, Context context, File file, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage$default(this, imageView, context, file, i, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
    }

    public final void loadImage(ImageView imageView, Context context, File file, int i, OnProgressListener onProgressListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage$default(this, imageView, context, file, i, onProgressListener, (ImageRequestListener) null, 16, (Object) null);
    }

    public final void loadImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage$default(this, imageView, context, str, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
    }

    public final void loadImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage$default(this, imageView, context, str, i, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
    }

    public final void loadImage(ImageView imageView, Context context, String str, int i, OnProgressListener onProgressListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage$default(this, imageView, context, str, i, onProgressListener, (ImageRequestListener) null, 16, (Object) null);
    }

    public final void loadImage565(ImageView imageView, Context context, File file) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage565$default(this, imageView, context, file, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
    }

    public final void loadImage565(ImageView imageView, Context context, File file, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage565$default(this, imageView, context, file, i, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
    }

    public final void loadImage565(ImageView imageView, Context context, File file, int i, OnProgressListener onProgressListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage565$default(this, imageView, context, file, i, onProgressListener, (ImageRequestListener) null, 16, (Object) null);
    }

    public final void loadImageAutoHeight(ImageView imageView, int i, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImageAutoHeight$default(this, imageView, i, context, str, 0, (OnProgressListener) null, (ImageRequestListener) null, 56, (Object) null);
    }

    public final void loadImageAutoHeight(ImageView imageView, int i, Context context, String str, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImageAutoHeight$default(this, imageView, i, context, str, i2, (OnProgressListener) null, (ImageRequestListener) null, 48, (Object) null);
    }

    public final void loadImageAutoHeight(ImageView imageView, int i, Context context, String str, int i2, OnProgressListener onProgressListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImageAutoHeight$default(this, imageView, i, context, str, i2, onProgressListener, (ImageRequestListener) null, 32, (Object) null);
    }

    public final void loadImageNormal(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImageNormal$default(this, imageView, context, str, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
    }

    public final void loadImageNormal(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImageNormal$default(this, imageView, context, str, i, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
    }

    public final void loadImageNormal(ImageView imageView, Context context, String str, int i, OnProgressListener onProgressListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImageNormal$default(this, imageView, context, str, i, onProgressListener, (ImageRequestListener) null, 16, (Object) null);
    }

    public final void loadResizeXYImage(ImageView imageView, Context context, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadResizeXYImage$default(this, imageView, context, str, i, i2, 0, 16, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, File file) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, file, 0, 0, 0, (RoundedCornersTransformation.CornerType) null, 60, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, File file, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, file, i, 0, 0, (RoundedCornersTransformation.CornerType) null, 56, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, File file, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, file, i, i2, 0, (RoundedCornersTransformation.CornerType) null, 48, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, File file, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, file, i, i2, i3, (RoundedCornersTransformation.CornerType) null, 32, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, String str) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, str, 0, 0, 0, (RoundedCornersTransformation.CornerType) null, 60, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, str, i, 0, 0, (RoundedCornersTransformation.CornerType) null, 56, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, str, i, i2, 0, (RoundedCornersTransformation.CornerType) null, 48, (Object) null);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadRoundCornerImage$default(this, imageView, context, str, i, i2, i3, (RoundedCornersTransformation.CornerType) null, 32, (Object) null);
    }

    private XesImageLoader() {
    }

    public final int getPlaceHolderImageView() {
        return placeHolderImageView;
    }

    public final void setPlaceHolderImageView(int i) {
        placeHolderImageView = i;
    }

    public final int getCirclePlaceholderImageView() {
        return circlePlaceholderImageView;
    }

    public final void setCirclePlaceholderImageView(int i) {
        circlePlaceholderImageView = i;
    }

    public final void loadImage(ImageView imageView, Context context, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().drawableId(i).isCropCenter(true).imageView(imageView).build());
    }

    public static /* synthetic */ void loadImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, OnProgressListener onProgressListener, ImageRequestListener imageRequestListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = placeHolderImageView;
        }
        xesImageLoader.loadImage(imageView, context, str, i, (i2 & 8) != 0 ? null : onProgressListener, (ImageRequestListener<Drawable>) (i2 & 16) != 0 ? null : imageRequestListener);
    }

    public final void loadImage(ImageView imageView, Context context, String str, int i, OnProgressListener onProgressListener, ImageRequestListener<Drawable> imageRequestListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).isCropCenter(true).isCrossFade(true).errorPic(i).placeholder(i).imageView(imageView).progressListener(onProgressListener).requestListener(imageRequestListener).build());
    }

    public static /* synthetic */ void loadImageNormal$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, OnProgressListener onProgressListener, ImageRequestListener imageRequestListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = placeHolderImageView;
        }
        xesImageLoader.loadImageNormal(imageView, context, str, i, (i2 & 8) != 0 ? null : onProgressListener, (i2 & 16) != 0 ? null : imageRequestListener);
    }

    public final void loadImageNormal(ImageView imageView, Context context, String str, int i, OnProgressListener onProgressListener, ImageRequestListener<Drawable> imageRequestListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).errorPic(i).placeholder(i).imageView(imageView).progressListener(onProgressListener).requestListener(imageRequestListener).build());
    }

    public static /* synthetic */ void loadImage565$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, File file, int i, OnProgressListener onProgressListener, ImageRequestListener imageRequestListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = placeHolderImageView;
        }
        xesImageLoader.loadImage565(imageView, context, file, i, (i2 & 8) != 0 ? null : onProgressListener, (i2 & 16) != 0 ? null : imageRequestListener);
    }

    public final void loadImage565(ImageView imageView, Context context, File file, int i, OnProgressListener onProgressListener, ImageRequestListener<Drawable> imageRequestListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        BaseRequestOptions placeholder = new RequestOptions().format(DecodeFormat.PREFER_RGB_565).error(i).placeholder(i);
        Intrinsics.checkNotNullExpressionValue(placeholder, "RequestOptions()\n       ….placeholder(placeHolder)");
        EasyGlideApp.with(context).load(file).apply((RequestOptions) placeholder).skipMemoryCache(true).into(imageView);
    }

    public static /* synthetic */ void loadImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, File file, int i, OnProgressListener onProgressListener, ImageRequestListener imageRequestListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = placeHolderImageView;
        }
        xesImageLoader.loadImage(imageView, context, file, i, (i2 & 8) != 0 ? null : onProgressListener, (ImageRequestListener<Drawable>) (i2 & 16) != 0 ? null : imageRequestListener);
    }

    public final void loadImage(ImageView imageView, Context context, File file, int i, OnProgressListener onProgressListener, ImageRequestListener<Drawable> imageRequestListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().fileResource(file).isCropCenter(true).isCrossFade(true).errorPic(i).placeholder(i).imageView(imageView).progressListener(onProgressListener).requestListener(imageRequestListener).build());
    }

    public static /* synthetic */ void loadImageAutoHeight$default(XesImageLoader xesImageLoader, ImageView imageView, int i, Context context, String str, int i2, OnProgressListener onProgressListener, ImageRequestListener imageRequestListener, int i3, Object obj) {
        xesImageLoader.loadImageAutoHeight(imageView, i, context, str, (i3 & 8) != 0 ? placeHolderImageView : i2, (i3 & 16) != 0 ? null : onProgressListener, (i3 & 32) != 0 ? null : imageRequestListener);
    }

    public final void loadImageAutoHeight(ImageView imageView, int i, Context context, String str, int i2, OnProgressListener onProgressListener, ImageRequestListener<Drawable> imageRequestListener) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        EasyGlideApp.with(context).downloadOnly().load(str).listener(new XesImageLoader$loadImageAutoHeight$1(imageView, context, str, i2, imageView, i)).preload();
    }

    public static /* synthetic */ void loadResizeXYImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            i3 = placeHolderImageView;
        }
        xesImageLoader.loadResizeXYImage(imageView, context, str, i, i2, i3);
    }

    public final void loadResizeXYImage(ImageView imageView, Context context, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).isCropCenter(true).isCrossFade(true).resize(i, i2).errorPic(i3).placeholder(i3).imageView(imageView).build());
    }

    public static /* synthetic */ void loadCircleImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = circlePlaceholderImageView;
        }
        xesImageLoader.loadCircleImage(imageView, context, str, i);
    }

    public final void loadCircleImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).isCropCircle(true).isCrossFade(true).errorPic(i).placeholder(i).imageView(imageView).build());
    }

    public static /* synthetic */ void loadGrayImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = placeHolderImageView;
        }
        xesImageLoader.loadGrayImage(imageView, context, str, i);
    }

    public final void loadGrayImage(ImageView imageView, Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).transformation((BitmapTransformation) new CenterCrop(), (BitmapTransformation) new GrayscaleTransformation()).isCrossFade(true).errorPic(i).placeholder(i).imageView(imageView).build());
    }

    public static /* synthetic */ void loadBlurImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 10;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = placeHolderImageView;
        }
        xesImageLoader.loadBlurImage(imageView, context, str, i4, i2);
    }

    public final void loadBlurImage(ImageView imageView, Context context, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).transformation((BitmapTransformation) new CenterCrop(), (BitmapTransformation) new BlurTransformation(context, i, 0, 4, (DefaultConstructorMarker) null)).isCrossFade(true).errorPic(i2).placeholder(i2).imageView(imageView).build());
    }

    public static /* synthetic */ void loadRoundCornerImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, int i3, RoundedCornersTransformation.CornerType cornerType, int i4, Object obj) {
        RoundedCornersTransformation.CornerType cornerType2;
        int i5 = (i4 & 4) != 0 ? 40 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        int i7 = (i4 & 16) != 0 ? placeHolderImageView : i3;
        if ((i4 & 32) != 0) {
            cornerType2 = RoundedCornersTransformation.CornerType.ALL;
        } else {
            cornerType2 = cornerType;
        }
        xesImageLoader.loadRoundCornerImage(imageView, context, str, i5, i6, i7, cornerType2);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, String str, int i, int i2, int i3, RoundedCornersTransformation.CornerType cornerType) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cornerType, "cornerType");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).multiTransformation(new MultiTransformation(new Transformation[]{(Transformation) new CenterCrop(), (Transformation) new RoundedCornersTransformation(i, i2, cornerType)})).isCrossFade(true).errorPic(i3).placeholder(i3).imageView(imageView).build());
    }

    public static /* synthetic */ void loadRoundCornerImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, File file, int i, int i2, int i3, RoundedCornersTransformation.CornerType cornerType, int i4, Object obj) {
        RoundedCornersTransformation.CornerType cornerType2;
        int i5 = (i4 & 4) != 0 ? 40 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        int i7 = (i4 & 16) != 0 ? placeHolderImageView : i3;
        if ((i4 & 32) != 0) {
            cornerType2 = RoundedCornersTransformation.CornerType.ALL;
        } else {
            cornerType2 = cornerType;
        }
        xesImageLoader.loadRoundCornerImage(imageView, context, file, i5, i6, i7, cornerType2);
    }

    public final void loadRoundCornerImage(ImageView imageView, Context context, File file, int i, int i2, int i3, RoundedCornersTransformation.CornerType cornerType) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cornerType, "cornerType");
        loadImage(context, GlideConfigImpl.Companion.builder().fileResource(file).multiTransformation(new MultiTransformation(new Transformation[]{(Transformation) new CenterCrop(), (Transformation) new RoundedCornersTransformation(i, i2, cornerType)})).isCrossFade(true).errorPic(i3).placeholder(i3).imageView(imageView).build());
    }

    public static /* synthetic */ void loadRoundCornerImageAutoHeight$default(XesImageLoader xesImageLoader, ImageView imageView, int i, Context context, String str, int i2, int i3, int i4, RoundedCornersTransformation.CornerType cornerType, int i5, Object obj) {
        RoundedCornersTransformation.CornerType cornerType2;
        int i6 = (i5 & 8) != 0 ? 40 : i2;
        int i7 = (i5 & 16) != 0 ? 0 : i3;
        int i8 = (i5 & 32) != 0 ? placeHolderImageView : i4;
        if ((i5 & 64) != 0) {
            cornerType2 = RoundedCornersTransformation.CornerType.ALL;
        } else {
            cornerType2 = cornerType;
        }
        xesImageLoader.loadRoundCornerImageAutoHeight(imageView, i, context, str, i6, i7, i8, cornerType2);
    }

    public final void loadRoundCornerImageAutoHeight(ImageView imageView, int i, Context context, String str, int i2, int i3, int i4, RoundedCornersTransformation.CornerType cornerType) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        RoundedCornersTransformation.CornerType cornerType2 = cornerType;
        Intrinsics.checkNotNullParameter(cornerType2, "cornerType");
        String str2 = str;
        ImageView imageView2 = imageView;
        EasyGlideApp.with(context).downloadOnly().load(str2).listener(new XesImageLoader$loadRoundCornerImageAutoHeight$1(imageView2, context, str2, i2, i3, i4, cornerType2, imageView, i)).preload();
    }

    public static /* synthetic */ void loadCircleWithBorderImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, int i3, boolean z, int i4, Object obj) {
        int i5;
        int i6 = (i4 & 4) != 0 ? 2 : i;
        int i7 = (i4 & 8) != 0 ? 11316396 : i2;
        if ((i4 & 16) != 0) {
            i5 = placeHolderImageView;
        } else {
            i5 = i3;
        }
        xesImageLoader.loadCircleWithBorderImage(imageView, context, str, i6, i7, i5, (i4 & 32) != 0 ? false : z);
    }

    public final void loadCircleWithBorderImage(ImageView imageView, Context context, String str, int i, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).transformation((BitmapTransformation) new CircleWithBorderTransformation(i, i2, z)).isCrossFade(true).errorPic(i3).placeholder(i3).imageView(imageView).build());
    }

    public static /* synthetic */ void loadBorderImage$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i = 2;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = 11316396;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = placeHolderImageView;
        }
        xesImageLoader.loadBorderImage(imageView, context, str, i5, i6, i3);
    }

    public final void loadBorderImage(ImageView imageView, Context context, String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).transformation((BitmapTransformation) new BorderTransformation(i, i2)).isCrossFade(true).errorPic(i3).placeholder(i3).imageView(imageView).build());
    }

    public static /* synthetic */ void loadImageWithTransformation$default(XesImageLoader xesImageLoader, ImageView imageView, Context context, String str, BitmapTransformation[] bitmapTransformationArr, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = placeHolderImageView;
        }
        xesImageLoader.loadImageWithTransformation(imageView, context, str, bitmapTransformationArr, i);
    }

    public final void loadImageWithTransformation(ImageView imageView, Context context, String str, BitmapTransformation[] bitmapTransformationArr, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmapTransformationArr, "bitmapTransformations");
        loadImage(context, GlideConfigImpl.Companion.builder().url(str).transformation((BitmapTransformation[]) Arrays.copyOf(bitmapTransformationArr, bitmapTransformationArr.length)).isCrossFade(true).errorPic(i).placeholder(i).imageView(imageView).build());
    }

    public final void preloadImage(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (checkContextIsAvailable(context)) {
            Glide.with(context).load(str).preload();
        }
    }

    public final void loadImage(Context context, GlideConfigImpl glideConfigImpl) {
        GlideRequest glideRequest;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glideConfigImpl, "config");
        if (checkContextIsAvailable(context)) {
            Preconditions.checkNotNull(context, "Context is required");
            Preconditions.checkNotNull(glideConfigImpl, "ImageConfigImpl is required");
            Preconditions.checkNotNull(glideConfigImpl.getImageView(), "ImageView is required");
            if (glideConfigImpl.getDrawableId() != 0) {
                glideRequest = EasyGlideApp.with(context).load(Integer.valueOf(glideConfigImpl.getDrawableId()));
            } else if (glideConfigImpl.getFileResource() != null) {
                glideRequest = EasyGlideApp.with(context).load(glideConfigImpl.getFileResource());
            } else {
                glideRequest = EasyGlideApp.with(context).load(glideConfigImpl.getUrl());
            }
            Intrinsics.checkNotNullExpressionValue(glideRequest, "if (config.drawableId !=…oad(config.url)\n        }");
            int cacheStrategy = glideConfigImpl.getCacheStrategy();
            if (cacheStrategy == GlideConfigImpl.Companion.getDISKCACHESTRATEGY_ALL()) {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
            } else if (cacheStrategy == GlideConfigImpl.Companion.getDISKCACHESTRATEGY_NONE()) {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE);
            } else if (cacheStrategy == GlideConfigImpl.Companion.getDISKCACHESTRATEGY_RESOURCE()) {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            } else if (cacheStrategy == GlideConfigImpl.Companion.getDISKCACHESTRATEGY_DATA()) {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.DATA);
            } else if (cacheStrategy == GlideConfigImpl.Companion.getDISKCACHESTRATEGY_AUTOMATIC()) {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
            } else {
                glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
            }
            boolean z = true;
            if (glideConfigImpl.isCrossFade()) {
                glideRequest.transition(DrawableTransitionOptions.withCrossFade(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()));
            }
            if (glideConfigImpl.isCrossFade()) {
                glideRequest.transition(DrawableTransitionOptions.withCrossFade(new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()));
            }
            if (glideConfigImpl.isImageRadius()) {
                glideRequest.transform(new RoundedCorners(glideConfigImpl.getImageRadius()));
            }
            if (glideConfigImpl.isBlurImage()) {
                glideRequest.transform(new BlurTransformation(context, glideConfigImpl.getBlurValue(), 0, 4, (DefaultConstructorMarker) null));
            }
            if (glideConfigImpl.getTransformation() != null) {
                BitmapTransformation[] transformation = glideConfigImpl.getTransformation();
                glideRequest.transforms((Transformation[]) Arrays.copyOf(transformation, transformation.length));
            }
            if (glideConfigImpl.getMultiTransformation() != null) {
                glideRequest.transforms(new Transformation[]{(Transformation) glideConfigImpl.getMultiTransformation()});
            }
            if (glideConfigImpl.getPlaceHolderDrawable() != null) {
                glideRequest.placeholder(glideConfigImpl.getPlaceHolderDrawable());
            }
            if (glideConfigImpl.getPlaceholder() != 0) {
                glideRequest.placeholder(glideConfigImpl.getPlaceholder());
            }
            if (glideConfigImpl.getErrorPic() != 0) {
                glideRequest.error(glideConfigImpl.getErrorPic());
            }
            if (glideConfigImpl.getFallback() != 0) {
                glideRequest.fallback(glideConfigImpl.getFallback());
            }
            if (!(glideConfigImpl.getResizeX() == 0 || glideConfigImpl.getResizeY() == 0)) {
                glideRequest.override(glideConfigImpl.getResizeX(), glideConfigImpl.getResizeY());
            }
            if (glideConfigImpl.isCropCenter()) {
                glideRequest.centerCrop();
            }
            if (glideConfigImpl.isCropCircle()) {
                glideRequest.circleCrop();
            }
            if (glideConfigImpl.isCenterInside()) {
                glideRequest.centerInside();
            }
            if (glideConfigImpl.getFormatType() != null) {
                glideRequest.format(glideConfigImpl.getFormatType());
            }
            if (glideConfigImpl.isFitCenter()) {
                glideRequest.fitCenter();
            }
            glideRequest.addListener(new XesImageLoader$loadImage$1$listener$1(glideConfigImpl));
            glideRequest.into(new GlideImageViewTarget(glideConfigImpl.getImageView(), glideConfigImpl.getUrl()));
            if (glideConfigImpl.getOnProgressListener() != null) {
                CharSequence url = glideConfigImpl.getUrl();
                if (url != null && !StringsKt.isBlank(url)) {
                    z = false;
                }
                if (!z) {
                    ProgressManager progressManager = ProgressManager.INSTANCE;
                    String url2 = glideConfigImpl.getUrl();
                    Intrinsics.checkNotNull(url2);
                    progressManager.addListener(url2, glideConfigImpl.getOnProgressListener());
                }
            }
        }
    }

    public final void clearDiskCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Observable.just(0).observeOn(Schedulers.io()).subscribe(new XesImageLoader$$ExternalSyntheticLambda0(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: clearDiskCache$lambda-1  reason: not valid java name */
    public static final void m86clearDiskCache$lambda1(Context context, Integer num) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Glide.get(context).clearDiskCache();
    }

    public final void clearMemory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Observable.just(0).observeOn(Schedulers.io()).subscribe(new XesImageLoader$$ExternalSyntheticLambda1(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: clearMemory$lambda-2  reason: not valid java name */
    public static final void m87clearMemory$lambda2(Context context, Integer num) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Glide.get(context).clearDiskCache();
    }

    public final void clearImage(Context context, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestManager requestManager = EasyGlideApp.get(context).getRequestManagerRetriever().get(context);
        Intrinsics.checkNotNull(imageView);
        requestManager.clear(imageView);
    }

    private final boolean checkContextIsAvailable(Object obj) {
        if (obj == null) {
            return false;
        }
        if ((obj instanceof Activity) && Util.isOnMainThread()) {
            Activity activity = (Activity) obj;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return false;
            }
            return true;
        } else if (obj instanceof Fragment) {
            if (((Fragment) obj).getContext() != null) {
                return true;
            }
            return false;
        } else if (obj instanceof android.app.Fragment) {
            if (((Fragment) obj).getActivity() != null) {
                return true;
            }
            return false;
        } else if (!(obj instanceof View)) {
            return true;
        } else {
            if (((View) obj).getContext() != null) {
                return true;
            }
            return false;
        }
    }

    public static /* synthetic */ void loadBigPicAutoHeight$default(XesImageLoader xesImageLoader, SubsamplingScaleImageView subsamplingScaleImageView, int i, Context context, String str, int i2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            i2 = placeHolderImageView;
        }
        xesImageLoader.loadBigPicAutoHeight(subsamplingScaleImageView, i, context, str, i2);
    }

    public final void loadBigPicAutoHeight(SubsamplingScaleImageView subsamplingScaleImageView, int i, Context context, String str, int i2) {
        Intrinsics.checkNotNullParameter(subsamplingScaleImageView, "imageView");
        Intrinsics.checkNotNullParameter(context, "context");
        EasyGlideApp.with(context).downloadOnly().load(str).listener(new XesImageLoader$loadBigPicAutoHeight$1(subsamplingScaleImageView, i2, i)).preload();
    }
}
