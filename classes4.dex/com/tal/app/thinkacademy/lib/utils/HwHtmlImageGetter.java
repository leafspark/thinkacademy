package com.tal.app.thinkacademy.lib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.text.Html;
import android.widget.TextView;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.tal.app.thinkacademy.lib.imageloader.progress.EasyGlideApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/HwHtmlImageGetter;", "Landroid/text/Html$ImageGetter;", "context", "Landroid/content/Context;", "textView", "Landroid/widget/TextView;", "resId", "", "baseWidth", "radius", "(Landroid/content/Context;Landroid/widget/TextView;III)V", "mBaseWidth", "mContext", "mDefaultResId", "mRadius", "mTextView", "getDrawable", "Landroid/graphics/drawable/Drawable;", "source", "", "scaleBitmapToFitWidth", "Landroid/graphics/Bitmap;", "bitmap", "maxWidth", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwHtmlImageGetter.kt */
public final class HwHtmlImageGetter implements Html.ImageGetter {
    /* access modifiers changed from: private */
    public int mBaseWidth;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mDefaultResId;
    private int mRadius;
    /* access modifiers changed from: private */
    public TextView mTextView;

    public HwHtmlImageGetter(Context context, TextView textView, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.mContext = context;
        this.mTextView = textView;
        this.mDefaultResId = i;
        this.mBaseWidth = i2;
        this.mRadius = i3;
    }

    /* access modifiers changed from: private */
    public final Bitmap scaleBitmapToFitWidth(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) ((i * height) / width)) / ((float) height);
        if (((double) width) < ((double) i) * 0.2d) {
            return bitmap;
        }
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public Drawable getDrawable(String str) {
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        BaseRequestOptions fallback = new RequestOptions().placeholder(this.mDefaultResId).error(this.mDefaultResId).fallback(this.mDefaultResId);
        Intrinsics.checkNotNullExpressionValue(fallback, "RequestOptions()\n       … .fallback(mDefaultResId)");
        EasyGlideApp.with(this.mContext).asBitmap().load(str).apply((RequestOptions) fallback).into((SimpleTarget) new HwHtmlImageGetter$getDrawable$simpleTarget$1(this, levelListDrawable));
        return levelListDrawable;
    }
}
