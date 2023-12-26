package com.didi.hummer.component.text;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class TypefaceSpanEx extends MetricAffectingSpan {
    private final Typeface typeface;

    public TypefaceSpanEx(Typeface typeface2) {
        this.typeface = typeface2;
    }

    public void updateDrawState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.typeface);
    }

    public void updateMeasureState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.typeface);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface typeface2) {
        int i;
        if (typeface2 != null) {
            Typeface typeface3 = paint.getTypeface();
            if (typeface3 == null) {
                i = 0;
            } else {
                i = typeface3.getStyle();
            }
            int i2 = i & (~typeface2.getStyle());
            if ((i2 & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((i2 & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface2);
        }
    }
}
