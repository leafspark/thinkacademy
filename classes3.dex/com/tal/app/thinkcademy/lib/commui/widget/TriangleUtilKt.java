package com.tal.app.thinkcademy.lib.commui.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"getTriangle", "Landroid/graphics/Bitmap;", "width", "", "height", "color", "reverse", "", "lib_commui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TriangleUtil.kt */
public final class TriangleUtilKt {
    public static final Bitmap getTriangle(int i, int i2, int i3, boolean z) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        paint.setAntiAlias(true);
        Path path = new Path();
        if (!z) {
            float f = (float) i;
            float f2 = f / 2.0f;
            path.moveTo(f2, 0.0f);
            float f3 = (float) i2;
            path.lineTo(f, f3);
            path.lineTo(0.0f, f3);
            path.lineTo(f2, 0.0f);
        } else {
            float f4 = (float) i;
            float f5 = f4 / 2.0f;
            float f6 = (float) i2;
            path.moveTo(f5, f6);
            path.lineTo(f4, 0.0f);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(f5, f6);
        }
        canvas.drawPath(path, paint);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }
}
