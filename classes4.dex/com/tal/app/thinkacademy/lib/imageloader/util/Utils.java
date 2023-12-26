package com.tal.app.thinkacademy.lib.imageloader.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Collection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0014\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014JB\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u0006JB\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\"\u001a\u00020#2\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0010J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020\nJ\u0016\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020\nJ\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010*\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/util/Utils;", "", "()V", "windowManager", "Landroid/view/WindowManager;", "dp2px", "", "context", "Landroid/content/Context;", "dp", "", "getDensity", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "getFontDensity", "getPathFormat", "", "path", "getSize", "collection", "", "getTextBitmap", "Landroid/graphics/Bitmap;", "width", "height", "radius", "text", "textSize", "bgColor", "getTextDrawable", "Landroid/graphics/drawable/Drawable;", "getWindowHeight", "getWindowManager", "getWindowWidth", "isEmpty", "", "isGif", "url", "px2dp", "px", "px2sp", "sp2px", "sp", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
public final class Utils {
    public static final Utils INSTANCE = new Utils();
    private static WindowManager windowManager;

    private Utils() {
    }

    private final WindowManager getWindowManager(Context context) {
        if (windowManager == null) {
            Object systemService = context.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService;
        }
        return windowManager;
    }

    public final float getDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().density;
    }

    public final float getFontDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public final DisplayMetrics getDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager2 = getWindowManager(context);
        Intrinsics.checkNotNull(windowManager2);
        windowManager2.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    @JvmStatic
    public static final int dp2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((INSTANCE.getDensity(context) * f) + 0.5f);
    }

    public final int px2dp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((f / getDensity(context)) + 0.5f);
    }

    @JvmStatic
    public static final int sp2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((INSTANCE.getFontDensity(context) * f) + 0.5f);
    }

    public final int px2sp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((f / getFontDensity(context)) + 0.5f);
    }

    public final int getWindowWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getDisplayMetrics(context).widthPixels;
    }

    public final int getWindowHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getDisplayMetrics(context).heightPixels;
    }

    public final String getPathFormat(String str) {
        int lastIndexOf$default;
        int i;
        Intrinsics.checkNotNullParameter(str, "path");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence) || (lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, '.', 0, false, 6, (Object) null)) <= 0 || (i = lastIndexOf$default + 1) >= str.length()) {
            return "";
        }
        String substring = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        if (TextUtils.isEmpty(substring)) {
            return "";
        }
        String lowerCase = substring.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public final boolean isGif(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return Intrinsics.areEqual("gif", getPathFormat(str));
    }

    public final Bitmap getTextBitmap(Context context, int i, int i2, int i3, String str, int i4, int i5) {
        Intrinsics.checkNotNullParameter(context, "context");
        int dp2px = dp2px(context, (float) i3);
        Bitmap createBitmap = Bitmap.createBitmap(dp2px(context, (float) i), dp2px(context, (float) i2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        Paint paint = new Paint(1);
        paint.setColor(context.getResources().getColor(i5));
        float f = (float) dp2px;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, rectF.width(), rectF.height()), f, f, paint);
        paint.setColor(-1);
        paint.setTextSize((float) dp2px(context, (float) i4));
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        float f2 = (((rectF.bottom + rectF.top) - ((float) fontMetricsInt.bottom)) - ((float) fontMetricsInt.top)) / ((float) 2);
        if (str != null) {
            canvas.drawText(str, rectF.centerX(), f2, paint);
        }
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
        return createBitmap;
    }

    public final Drawable getTextDrawable(Context context, int i, int i2, int i3, String str, int i4, int i5) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new BitmapDrawable(getTextBitmap(context, i, i2, i3, str, i4, i5));
    }

    public final boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public final int getSize(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
