package com.xueersi.tborad.extensions.rule;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.xueersi.lib.graffiti.utils.XesLog;

abstract class BaseDrawable<T> extends Drawable {
    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    BaseDrawable() {
    }

    /* access modifiers changed from: protected */
    public float getX(float f) {
        return ((float) getBounds().width()) * f;
    }

    /* access modifiers changed from: protected */
    public float getValue(float f) {
        return ((float) getBounds().width()) * f;
    }

    /* access modifiers changed from: protected */
    public float getY(float f) {
        return ((float) getBounds().height()) * f;
    }

    public void updateConfig(T t) {
        if (t != null) {
            XesLog.i(getClass() + " : " + t.toString());
        }
    }
}
