package com.tal.app.thinkacademy.lib.imageloader.config;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002JKB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010I\u001a\u00020 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010#\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010%\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010'\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010(\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u000107¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R$\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\bR\u0011\u0010B\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\bR\u001d\u0010D\u001a\f\u0012\u0006\b\u0001\u0012\u00020E\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010G¨\u0006L"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl;", "Lcom/tal/app/thinkacademy/lib/imageloader/config/ImageConfig;", "builder", "Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Builder;", "(Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Builder;)V", "blurValue", "", "getBlurValue", "()I", "cacheStrategy", "getCacheStrategy", "fallback", "getFallback", "fileResource", "Ljava/io/File;", "getFileResource", "()Ljava/io/File;", "setFileResource", "(Ljava/io/File;)V", "formatType", "Lcom/bumptech/glide/load/DecodeFormat;", "getFormatType", "()Lcom/bumptech/glide/load/DecodeFormat;", "imageRadius", "getImageRadius", "imageViews", "", "Landroid/widget/ImageView;", "getImageViews", "()[Landroid/widget/ImageView;", "[Landroid/widget/ImageView;", "isBlurImage", "", "()Z", "isCenterInside", "isClearDiskCache", "isClearMemory", "isCropCenter", "isCropCircle", "isCrossFade", "isFitCenter", "multiTransformation", "Lcom/bumptech/glide/load/MultiTransformation;", "Landroid/graphics/Bitmap;", "getMultiTransformation", "()Lcom/bumptech/glide/load/MultiTransformation;", "setMultiTransformation", "(Lcom/bumptech/glide/load/MultiTransformation;)V", "onProgressListener", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;", "getOnProgressListener", "()Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;", "setOnProgressListener", "(Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;)V", "placeHolderDrawable", "Landroid/graphics/drawable/Drawable;", "getPlaceHolderDrawable", "()Landroid/graphics/drawable/Drawable;", "requestListener", "Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;", "getRequestListener", "()Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;", "setRequestListener", "(Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;)V", "resizeX", "getResizeX", "resizeY", "getResizeY", "transformation", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "getTransformation", "()[Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "[Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "isImageRadius", "Builder", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlideConfigImpl.kt */
public final class GlideConfigImpl extends ImageConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DISKCACHESTRATEGY_ALL = 0;
    /* access modifiers changed from: private */
    public static final int DISKCACHESTRATEGY_AUTOMATIC = 4;
    /* access modifiers changed from: private */
    public static final int DISKCACHESTRATEGY_DATA = 3;
    /* access modifiers changed from: private */
    public static final int DISKCACHESTRATEGY_NONE = 1;
    /* access modifiers changed from: private */
    public static final int DISKCACHESTRATEGY_RESOURCE = 2;
    private final int blurValue;
    private final int cacheStrategy;
    private final int fallback;
    private File fileResource;
    private final DecodeFormat formatType;
    private final int imageRadius;
    private final ImageView[] imageViews;
    private final boolean isCenterInside;
    private final boolean isClearDiskCache;
    private final boolean isClearMemory;
    private final boolean isCropCenter;
    private final boolean isCropCircle;
    private final boolean isCrossFade;
    private final boolean isFitCenter;
    private MultiTransformation<Bitmap> multiTransformation;
    private OnProgressListener onProgressListener;
    private final Drawable placeHolderDrawable;
    private ImageRequestListener<Drawable> requestListener;
    private final int resizeX;
    private final int resizeY;
    private final BitmapTransformation[] transformation;

    public /* synthetic */ GlideConfigImpl(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GlideConfigImpl(Builder builder) {
        setUrl(builder.getUrl());
        this.fileResource = builder.getFileResource();
        setDrawableId(builder.getDrawableId());
        setImageView(builder.getImageView());
        setPlaceholder(builder.getPlaceholder());
        this.placeHolderDrawable = builder.getPlaceholderDrawable();
        setErrorPic(builder.getErrorPic());
        this.fallback = builder.getFallback();
        this.cacheStrategy = builder.getCacheStrategy();
        this.transformation = builder.getTransformation();
        this.multiTransformation = builder.getMultiTransformation();
        this.imageViews = builder.getImageViews();
        this.isClearMemory = builder.isClearMemory();
        this.isClearDiskCache = builder.isClearDiskCache();
        this.resizeX = builder.getResizeX();
        this.resizeY = builder.getResizeY();
        this.isCropCenter = builder.isCropCenter();
        this.isCropCircle = builder.isCropCircle();
        this.formatType = builder.getFormatType();
        this.isFitCenter = builder.isFitCenter();
        this.isCenterInside = builder.isCenterInside();
        this.isCrossFade = builder.isCrossFade();
        this.imageRadius = builder.getImageRadius();
        this.blurValue = builder.getBlurValue();
        this.onProgressListener = builder.getOnProgressListener();
        this.requestListener = builder.getRequestListener();
    }

    public final int getCacheStrategy() {
        return this.cacheStrategy;
    }

    public final int getFallback() {
        return this.fallback;
    }

    public final BitmapTransformation[] getTransformation() {
        return this.transformation;
    }

    public final MultiTransformation<Bitmap> getMultiTransformation() {
        return this.multiTransformation;
    }

    public final void setMultiTransformation(MultiTransformation<Bitmap> multiTransformation2) {
        this.multiTransformation = multiTransformation2;
    }

    public final ImageView[] getImageViews() {
        return this.imageViews;
    }

    public final boolean isClearMemory() {
        return this.isClearMemory;
    }

    public final boolean isClearDiskCache() {
        return this.isClearDiskCache;
    }

    public final Drawable getPlaceHolderDrawable() {
        return this.placeHolderDrawable;
    }

    public final int getResizeX() {
        return this.resizeX;
    }

    public final boolean isCropCenter() {
        return this.isCropCenter;
    }

    public final boolean isCropCircle() {
        return this.isCropCircle;
    }

    public final boolean isFitCenter() {
        return this.isFitCenter;
    }

    public final boolean isCenterInside() {
        return this.isCenterInside;
    }

    public final DecodeFormat getFormatType() {
        return this.formatType;
    }

    public final int getResizeY() {
        return this.resizeY;
    }

    public final int getImageRadius() {
        return this.imageRadius;
    }

    public final int getBlurValue() {
        return this.blurValue;
    }

    public final boolean isCrossFade() {
        return this.isCrossFade;
    }

    public final OnProgressListener getOnProgressListener() {
        return this.onProgressListener;
    }

    public final void setOnProgressListener(OnProgressListener onProgressListener2) {
        this.onProgressListener = onProgressListener2;
    }

    public final ImageRequestListener<Drawable> getRequestListener() {
        return this.requestListener;
    }

    public final void setRequestListener(ImageRequestListener<Drawable> imageRequestListener) {
        this.requestListener = imageRequestListener;
    }

    public final File getFileResource() {
        return this.fileResource;
    }

    public final void setFileResource(File file) {
        this.fileResource = file;
    }

    public final boolean isBlurImage() {
        return this.blurValue > 0;
    }

    public final boolean isImageRadius() {
        return this.imageRadius > 0;
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010q\u001a\u00020rJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010s\u001a\u0004\u0018\u00010\u0016J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u001f\u0010*\u001a\u00020\u00002\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0+\"\u00020%¢\u0006\u0002\u0010tJ\u000e\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u000202J\u000e\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u000202J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000202J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u000202J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u000202J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u000202J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u000202J\u0014\u0010B\u001a\u00020\u00002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0004J\u0010\u0010R\u001a\u00020\u00002\b\u0010R\u001a\u0004\u0018\u00010SJ\u0010\u0010u\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010JJ\u0018\u0010X\u001a\u00020\u00002\u0010\u0010X\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010YJ\u0016\u0010v\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u0004J\u0010\u0010w\u001a\u00020\u00002\b\u0010x\u001a\u0004\u0018\u00010\u001cJ\u001f\u0010d\u001a\u00020\u00002\u0012\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020e0+\"\u00020e¢\u0006\u0002\u0010yJ\u0010\u0010k\u001a\u00020\u00002\b\u0010k\u001a\u0004\u0018\u00010lR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010*\u001a\f\u0012\u0006\b\u0001\u0012\u00020%\u0018\u00010+X\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u00108\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\u001a\u0010:\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u001a\u0010<\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105R\u001a\u0010>\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\u001a\u0010@\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\"\u0010B\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010S\u0018\u00010YX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001a\u0010a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR&\u0010d\u001a\f\u0012\u0006\b\u0001\u0012\u00020e\u0018\u00010+X\u000e¢\u0006\u0010\n\u0002\u0010j\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006z"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Builder;", "", "()V", "blurValue", "", "getBlurValue", "()I", "setBlurValue", "(I)V", "cacheStrategy", "getCacheStrategy", "setCacheStrategy", "drawableId", "getDrawableId", "setDrawableId", "errorPic", "getErrorPic", "setErrorPic", "fallback", "getFallback", "setFallback", "fileResource", "Ljava/io/File;", "getFileResource", "()Ljava/io/File;", "setFileResource", "(Ljava/io/File;)V", "formatType", "Lcom/bumptech/glide/load/DecodeFormat;", "getFormatType", "()Lcom/bumptech/glide/load/DecodeFormat;", "setFormatType", "(Lcom/bumptech/glide/load/DecodeFormat;)V", "imageRadius", "getImageRadius", "setImageRadius", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "imageViews", "", "getImageViews", "()[Landroid/widget/ImageView;", "setImageViews", "([Landroid/widget/ImageView;)V", "[Landroid/widget/ImageView;", "isCenterInside", "", "()Z", "setCenterInside", "(Z)V", "isClearDiskCache", "setClearDiskCache", "isClearMemory", "setClearMemory", "isCropCenter", "setCropCenter", "isCropCircle", "setCropCircle", "isCrossFade", "setCrossFade", "isFitCenter", "setFitCenter", "multiTransformation", "Lcom/bumptech/glide/load/MultiTransformation;", "Landroid/graphics/Bitmap;", "getMultiTransformation", "()Lcom/bumptech/glide/load/MultiTransformation;", "setMultiTransformation", "(Lcom/bumptech/glide/load/MultiTransformation;)V", "onProgressListener", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;", "getOnProgressListener", "()Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;", "setOnProgressListener", "(Lcom/tal/app/thinkacademy/lib/imageloader/progress/OnProgressListener;)V", "placeholder", "getPlaceholder", "setPlaceholder", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "getPlaceholderDrawable", "()Landroid/graphics/drawable/Drawable;", "setPlaceholderDrawable", "(Landroid/graphics/drawable/Drawable;)V", "requestListener", "Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;", "getRequestListener", "()Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;", "setRequestListener", "(Lcom/tal/app/thinkacademy/lib/imageloader/ImageRequestListener;)V", "resizeX", "getResizeX", "setResizeX", "resizeY", "getResizeY", "setResizeY", "transformation", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "getTransformation", "()[Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "setTransformation", "([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)V", "[Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "build", "Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl;", "file", "([Landroid/widget/ImageView;)Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Builder;", "progressListener", "resize", "setDecodeFormat", "decodeFormat", "([Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;)Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Builder;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GlideConfigImpl.kt */
    public static final class Builder {
        private int blurValue;
        private int cacheStrategy;
        private int drawableId;
        private int errorPic;
        private int fallback;
        private File fileResource;
        private DecodeFormat formatType;
        private int imageRadius;
        private ImageView imageView;
        private ImageView[] imageViews;
        private boolean isCenterInside;
        private boolean isClearDiskCache;
        private boolean isClearMemory;
        private boolean isCropCenter;
        private boolean isCropCircle;
        private boolean isCrossFade;
        private boolean isFitCenter;
        private MultiTransformation<Bitmap> multiTransformation;
        private OnProgressListener onProgressListener;
        private int placeholder;
        private Drawable placeholderDrawable;
        private ImageRequestListener<Drawable> requestListener;
        private int resizeX;
        private int resizeY;
        private BitmapTransformation[] transformation;
        private String url;

        public final File getFileResource() {
            return this.fileResource;
        }

        public final void setFileResource(File file) {
            this.fileResource = file;
        }

        public final int getResizeX() {
            return this.resizeX;
        }

        public final void setResizeX(int i) {
            this.resizeX = i;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final int getDrawableId() {
            return this.drawableId;
        }

        public final void setDrawableId(int i) {
            this.drawableId = i;
        }

        public final ImageView getImageView() {
            return this.imageView;
        }

        public final void setImageView(ImageView imageView2) {
            this.imageView = imageView2;
        }

        public final int getPlaceholder() {
            return this.placeholder;
        }

        public final void setPlaceholder(int i) {
            this.placeholder = i;
        }

        public final Drawable getPlaceholderDrawable() {
            return this.placeholderDrawable;
        }

        public final void setPlaceholderDrawable(Drawable drawable) {
            this.placeholderDrawable = drawable;
        }

        public final int getErrorPic() {
            return this.errorPic;
        }

        public final void setErrorPic(int i) {
            this.errorPic = i;
        }

        public final int getFallback() {
            return this.fallback;
        }

        public final void setFallback(int i) {
            this.fallback = i;
        }

        public final int getCacheStrategy() {
            return this.cacheStrategy;
        }

        public final void setCacheStrategy(int i) {
            this.cacheStrategy = i;
        }

        public final int getImageRadius() {
            return this.imageRadius;
        }

        public final void setImageRadius(int i) {
            this.imageRadius = i;
        }

        public final int getBlurValue() {
            return this.blurValue;
        }

        public final void setBlurValue(int i) {
            this.blurValue = i;
        }

        public final BitmapTransformation[] getTransformation() {
            return this.transformation;
        }

        public final void setTransformation(BitmapTransformation[] bitmapTransformationArr) {
            this.transformation = bitmapTransformationArr;
        }

        public final MultiTransformation<Bitmap> getMultiTransformation() {
            return this.multiTransformation;
        }

        public final void setMultiTransformation(MultiTransformation<Bitmap> multiTransformation2) {
            this.multiTransformation = multiTransformation2;
        }

        public final ImageView[] getImageViews() {
            return this.imageViews;
        }

        public final void setImageViews(ImageView[] imageViewArr) {
            this.imageViews = imageViewArr;
        }

        public final boolean isClearMemory() {
            return this.isClearMemory;
        }

        public final void setClearMemory(boolean z) {
            this.isClearMemory = z;
        }

        public final boolean isClearDiskCache() {
            return this.isClearDiskCache;
        }

        public final void setClearDiskCache(boolean z) {
            this.isClearDiskCache = z;
        }

        public final boolean isCropCenter() {
            return this.isCropCenter;
        }

        public final void setCropCenter(boolean z) {
            this.isCropCenter = z;
        }

        public final boolean isCropCircle() {
            return this.isCropCircle;
        }

        public final void setCropCircle(boolean z) {
            this.isCropCircle = z;
        }

        public final boolean isCrossFade() {
            return this.isCrossFade;
        }

        public final void setCrossFade(boolean z) {
            this.isCrossFade = z;
        }

        public final DecodeFormat getFormatType() {
            return this.formatType;
        }

        public final void setFormatType(DecodeFormat decodeFormat) {
            this.formatType = decodeFormat;
        }

        public final boolean isFitCenter() {
            return this.isFitCenter;
        }

        public final void setFitCenter(boolean z) {
            this.isFitCenter = z;
        }

        public final boolean isCenterInside() {
            return this.isCenterInside;
        }

        public final void setCenterInside(boolean z) {
            this.isCenterInside = z;
        }

        public final int getResizeY() {
            return this.resizeY;
        }

        public final void setResizeY(int i) {
            this.resizeY = i;
        }

        public final OnProgressListener getOnProgressListener() {
            return this.onProgressListener;
        }

        public final void setOnProgressListener(OnProgressListener onProgressListener2) {
            this.onProgressListener = onProgressListener2;
        }

        public final ImageRequestListener<Drawable> getRequestListener() {
            return this.requestListener;
        }

        public final void setRequestListener(ImageRequestListener<Drawable> imageRequestListener) {
            this.requestListener = imageRequestListener;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder drawableId(int i) {
            this.drawableId = i;
            return this;
        }

        public final Builder fileResource(File file) {
            this.fileResource = file;
            return this;
        }

        public final Builder placeholder(int i) {
            this.placeholder = i;
            return this;
        }

        public final Builder errorPic(int i) {
            this.errorPic = i;
            return this;
        }

        public final Builder fallback(int i) {
            this.fallback = i;
            return this;
        }

        public final Builder imageView(ImageView imageView2) {
            this.imageView = imageView2;
            return this;
        }

        public final Builder cacheStrategy(int i) {
            this.cacheStrategy = i;
            return this;
        }

        public final Builder imageRadius(int i) {
            this.imageRadius = i;
            return this;
        }

        public final Builder blurValue(int i) {
            this.blurValue = i;
            return this;
        }

        public final Builder isCrossFade(boolean z) {
            this.isCrossFade = z;
            return this;
        }

        public final Builder transformation(BitmapTransformation... bitmapTransformationArr) {
            Intrinsics.checkNotNullParameter(bitmapTransformationArr, "transformation");
            this.transformation = bitmapTransformationArr;
            return this;
        }

        public final Builder multiTransformation(MultiTransformation<Bitmap> multiTransformation2) {
            Intrinsics.checkNotNullParameter(multiTransformation2, "multiTransformation");
            this.multiTransformation = multiTransformation2;
            return this;
        }

        public final Builder imageViews(ImageView... imageViewArr) {
            Intrinsics.checkNotNullParameter(imageViewArr, "imageViews");
            this.imageViews = imageViewArr;
            return this;
        }

        public final Builder isClearMemory(boolean z) {
            this.isClearMemory = z;
            return this;
        }

        public final Builder isClearDiskCache(boolean z) {
            this.isClearDiskCache = z;
            return this;
        }

        public final Builder placeholderDrawable(Drawable drawable) {
            this.placeholderDrawable = drawable;
            return this;
        }

        public final Builder resize(int i, int i2) {
            this.resizeX = i;
            this.resizeY = i2;
            return this;
        }

        public final Builder isCropCenter(boolean z) {
            this.isCropCenter = z;
            return this;
        }

        public final Builder isCropCircle(boolean z) {
            this.isCropCircle = z;
            return this;
        }

        public final Builder setDecodeFormat(DecodeFormat decodeFormat) {
            this.formatType = decodeFormat;
            return this;
        }

        public final Builder isFitCenter(boolean z) {
            this.isFitCenter = z;
            return this;
        }

        public final Builder isCenterInside(boolean z) {
            this.isCenterInside = z;
            return this;
        }

        public final Builder progressListener(OnProgressListener onProgressListener2) {
            this.onProgressListener = onProgressListener2;
            return this;
        }

        public final Builder requestListener(ImageRequestListener<Drawable> imageRequestListener) {
            this.requestListener = imageRequestListener;
            return this;
        }

        public final GlideConfigImpl build() {
            return new GlideConfigImpl(this, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Companion;", "", "()V", "DISKCACHESTRATEGY_ALL", "", "getDISKCACHESTRATEGY_ALL", "()I", "DISKCACHESTRATEGY_AUTOMATIC", "getDISKCACHESTRATEGY_AUTOMATIC", "DISKCACHESTRATEGY_DATA", "getDISKCACHESTRATEGY_DATA", "DISKCACHESTRATEGY_NONE", "getDISKCACHESTRATEGY_NONE", "DISKCACHESTRATEGY_RESOURCE", "getDISKCACHESTRATEGY_RESOURCE", "builder", "Lcom/tal/app/thinkacademy/lib/imageloader/config/GlideConfigImpl$Builder;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GlideConfigImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Builder builder() {
            return new Builder();
        }

        public final int getDISKCACHESTRATEGY_ALL() {
            return GlideConfigImpl.DISKCACHESTRATEGY_ALL;
        }

        public final int getDISKCACHESTRATEGY_NONE() {
            return GlideConfigImpl.DISKCACHESTRATEGY_NONE;
        }

        public final int getDISKCACHESTRATEGY_RESOURCE() {
            return GlideConfigImpl.DISKCACHESTRATEGY_RESOURCE;
        }

        public final int getDISKCACHESTRATEGY_DATA() {
            return GlideConfigImpl.DISKCACHESTRATEGY_DATA;
        }

        public final int getDISKCACHESTRATEGY_AUTOMATIC() {
            return GlideConfigImpl.DISKCACHESTRATEGY_AUTOMATIC;
        }
    }
}
