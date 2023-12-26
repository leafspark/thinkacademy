package com.didi.hummer.component.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class ImageSpanEx extends ImageSpan {
    public static final int ALIGN_CENTER = 3;
    public static final int ALIGN_TOP = 2;
    private WeakReference<Drawable> mDrawableRef;

    public ImageSpanEx(Drawable drawable) {
        super(drawable, 1);
    }

    public ImageSpanEx(Drawable drawable, int i) {
        super(drawable, i);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mVerticalAlignment == 1 || this.mVerticalAlignment == 0) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        Rect bounds = getCachedDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int height = bounds.height();
            if (this.mVerticalAlignment == 2) {
                fontMetricsInt.top = -height;
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = i3 - height;
                fontMetricsInt.bottom = fontMetricsInt.descent;
            } else {
                int i4 = height / 2;
                int i5 = i3 / 2;
                int i6 = i4 - i5;
                int i7 = -(i4 + i5);
                fontMetricsInt.top = i7;
                fontMetricsInt.ascent = i7;
                fontMetricsInt.descent = i6;
                fontMetricsInt.bottom = i6;
            }
        }
        return bounds.right;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.mVerticalAlignment == 1 || this.mVerticalAlignment == 0) {
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
            return;
        }
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        if (this.mVerticalAlignment != 2) {
            i3 = this.mVerticalAlignment == 3 ? i3 + (((i5 - i3) - cachedDrawable.getBounds().height()) / 2) : 0;
        }
        canvas.translate(f, (float) i3);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.mDrawableRef = new WeakReference<>(drawable2);
        return drawable2;
    }
}
