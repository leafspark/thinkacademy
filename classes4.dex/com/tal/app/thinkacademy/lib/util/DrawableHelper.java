package com.tal.app.thinkacademy.lib.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;

public class DrawableHelper {
    public static Bitmap bitmapFromResource(Resources resources, int i) {
        return BitmapFactoryInstrumentation.decodeResource(resources, i);
    }

    public static Bitmap drawable2bitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect();
        rect.left = 0;
        rect.right = intrinsicWidth;
        rect.top = 0;
        rect.bottom = intrinsicHeight;
        drawable.setBounds(rect);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Drawable bitmap2drawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }
}
