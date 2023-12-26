package com.tal.app.thinkacademy.lib.imageloader.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.Util;
import com.tal.app.thinkacademy.lib.imageloader.util.BlurUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0015J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/transformation/BlurTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "context", "Landroid/content/Context;", "radius", "", "sampling", "(Landroid/content/Context;II)V", "ID", "", "kotlin.jvm.PlatformType", "equals", "", "obj", "", "hashCode", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BlurTransformation.kt */
public final class BlurTransformation extends BitmapTransformation {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_SAMPLING = 1;
    private static final int MAX_RADIUS = 25;
    private final String ID;
    private final Context context;
    private final int radius;
    private final int sampling;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BlurTransformation(Context context2) {
        this(context2, 0, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BlurTransformation(Context context2, int i) {
        this(context2, i, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    public BlurTransformation(Context context2, int i, int i2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.ID = getClass().getName();
        this.radius = i > 25 ? 25 : i;
        this.sampling = i2 > 25 ? 25 : i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlurTransformation(Context context2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i3 & 2) != 0 ? 25 : i, (i3 & 4) != 0 ? 1 : i2);
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = this.sampling;
        Bitmap bitmap2 = bitmapPool.get(width / i3, height / i3, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap2, "pool[scaledWidth, scaled… Bitmap.Config.ARGB_8888]");
        Canvas canvas = new Canvas(bitmap2);
        float f = (float) 1;
        int i4 = this.sampling;
        canvas.scale(f / ((float) i4), f / ((float) i4));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 17) {
            return BlurUtils.INSTANCE.rsBlur(this.context, bitmap2, this.radius);
        }
        Bitmap blur = BlurUtils.INSTANCE.blur(bitmap2, this.radius);
        Intrinsics.checkNotNull(blur);
        return blur;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BlurTransformation)) {
            return false;
        }
        BlurTransformation blurTransformation = (BlurTransformation) obj;
        if (this.radius == blurTransformation.radius && this.sampling == blurTransformation.sampling) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Util.hashCode(this.ID.hashCode(), Util.hashCode(this.radius, Util.hashCode(this.sampling)));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "CHARSET");
        byte[] bytes = (this.ID + (this.radius * 10) + this.sampling).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/transformation/BlurTransformation$Companion;", "", "()V", "DEFAULT_SAMPLING", "", "MAX_RADIUS", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BlurTransformation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
