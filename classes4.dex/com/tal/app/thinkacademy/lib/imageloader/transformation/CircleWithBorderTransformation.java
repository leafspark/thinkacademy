package com.tal.app.thinkacademy.lib.imageloader.transformation;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/transformation/CircleWithBorderTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "borderWidth", "", "borderColor", "isPixelBorder", "", "(IIZ)V", "id", "", "kotlin.jvm.PlatformType", "mBorderPaint", "Landroid/graphics/Paint;", "mBorderWidth", "", "circleCrop", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "source", "transform", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CircleWithBorderTransformation.kt */
public final class CircleWithBorderTransformation extends BitmapTransformation {
    private final String id = getClass().getName();
    private final Paint mBorderPaint;
    private final float mBorderWidth;

    public CircleWithBorderTransformation(int i, int i2, boolean z) {
        float f;
        if (z) {
            f = (float) i;
        } else {
            f = ((float) i) * Utils.getApp().getResources().getDisplayMetrics().density;
        }
        this.mBorderWidth = f;
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        Bitmap circleCrop = circleCrop(bitmapPool, bitmap);
        Intrinsics.checkNotNull(circleCrop);
        return circleCrop;
    }

    private final Bitmap circleCrop(BitmapPool bitmapPool, Bitmap bitmap) {
        Canvas canvas = null;
        if (bitmap == null) {
            return null;
        }
        float f = (float) 2;
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) - (this.mBorderWidth / f));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap bitmap2 = bitmapPool.get(min, min, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        if (bitmap2 != null) {
            canvas = new Canvas(bitmap2);
        }
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f2 = ((float) min) / 2.0f;
        if (canvas != null) {
            canvas.drawCircle(f2, f2, f2, paint);
        }
        Paint paint2 = this.mBorderPaint;
        if (paint2 != null) {
            float f3 = f2 - (this.mBorderWidth / f);
            if (canvas != null) {
                canvas.drawCircle(f2, f2, f3, paint2);
            }
        }
        return bitmap2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String stringPlus = Intrinsics.stringPlus(this.id, Float.valueOf(this.mBorderWidth * ((float) 10)));
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "CHARSET");
        byte[] bytes = stringPlus.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
    }
}
