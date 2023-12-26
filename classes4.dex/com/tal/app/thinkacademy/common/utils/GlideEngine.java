package com.tal.app.thinkacademy.common.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.listener.OnImageCompleteCallback;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.tal.app.thinkacademy.common.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/GlideEngine;", "Lcom/luck/picture/lib/engine/ImageEngine;", "()V", "loadAsGifImage", "", "context", "Landroid/content/Context;", "url", "", "imageView", "Landroid/widget/ImageView;", "loadFolderImage", "loadGridImage", "loadImage", "longImageView", "Lcom/luck/picture/lib/widget/longimage/SubsamplingScaleImageView;", "callback", "Lcom/luck/picture/lib/listener/OnImageCompleteCallback;", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GlideEngine.kt */
public final class GlideEngine implements ImageEngine {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static GlideEngine instance;

    public /* synthetic */ GlideEngine(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GlideEngine() {
    }

    public void loadImage(Context context, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Glide.with(context).load(str).into(imageView);
    }

    public void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, OnImageCompleteCallback onImageCompleteCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(subsamplingScaleImageView, "longImageView");
        Intrinsics.checkNotNullParameter(onImageCompleteCallback, "callback");
        Glide.with(context).asBitmap().load(str).into(new GlideEngine$loadImage$1(imageView, onImageCompleteCallback, subsamplingScaleImageView));
    }

    public void loadImage(Context context, String str, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(subsamplingScaleImageView, "longImageView");
        Glide.with(context).asBitmap().load(str).into(new GlideEngine$loadImage$2(imageView, subsamplingScaleImageView));
    }

    public void loadFolderImage(Context context, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Glide.with(context).asBitmap().load(str).apply(new RequestOptions().placeholder(R.drawable.picture_image_placeholder)).into(new GlideEngine$loadFolderImage$1(imageView, context));
    }

    public void loadAsGifImage(Context context, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Glide.with(context).asGif().load(str).into(imageView);
    }

    public void loadGridImage(Context context, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Glide.with(context).load(str).apply(new RequestOptions().placeholder(R.drawable.picture_image_placeholder)).into(imageView);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/GlideEngine$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/utils/GlideEngine;", "createGlideEngine", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GlideEngine.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlideEngine createGlideEngine() {
            if (GlideEngine.instance == null) {
                synchronized (GlideEngine.class) {
                    if (GlideEngine.instance == null) {
                        Companion companion = GlideEngine.Companion;
                        GlideEngine.instance = new GlideEngine((DefaultConstructorMarker) null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return GlideEngine.instance;
        }
    }
}
