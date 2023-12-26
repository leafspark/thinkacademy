package com.tal.app.thinkacademy.lib.imageloader.transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/transformation/BorderTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "borderWidth", "", "borderColor", "(II)V", "ID", "", "kotlin.jvm.PlatformType", "mBorderPaint", "Landroid/graphics/Paint;", "mBorderWidth", "", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BorderTransformation.kt */
public final class BorderTransformation extends BitmapTransformation {
    private final String ID = getClass().getName();
    private final Paint mBorderPaint;
    private final float mBorderWidth;

    public BorderTransformation(int i, int i2) {
        float f = Utils.getApp().getResources().getDisplayMetrics().density * ((float) i);
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
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmap2, "pool[width, height, Bitmap.Config.ARGB_8888]");
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.mBorderPaint;
        if (paint2 != null) {
            float f = (float) 0;
            float f2 = this.mBorderWidth;
            float f3 = (float) 2;
            float f4 = (f2 / f3) + f;
            float f5 = f + (f2 / f3);
            canvas.drawRect(f4, f5, ((float) width) - (f2 / f3), ((float) height) - (f2 / f3), paint2);
        }
        return bitmap2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String stringPlus = Intrinsics.stringPlus(this.ID, Float.valueOf(this.mBorderWidth * ((float) 10)));
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "CHARSET");
        byte[] bytes = stringPlus.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
    }
}
