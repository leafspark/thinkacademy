package com.didi.hummer.render.component.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.render.component.view.BackgroundDrawable;
import com.didi.hummer.render.utility.RTLUtil;
import com.didi.hummer.render.utility.YogaDrawableUtil;

public class BackgroundHelper {
    private BackgroundDrawable backgroundDrawable;
    private Context context;
    private View view;

    public BackgroundHelper(Context context2, View view2) {
        this.context = context2;
        this.view = view2;
    }

    private BackgroundDrawable getBgDrawable() {
        if (this.backgroundDrawable == null) {
            Context context2 = this.context;
            boolean z = true;
            if (!((context2 instanceof HummerContext) && HummerSDK.isSupportRTL(((HummerContext) context2).getNamespace())) || !RTLUtil.isRTL(this.context)) {
                z = false;
            }
            BackgroundDrawable backgroundDrawable2 = new BackgroundDrawable(z);
            this.backgroundDrawable = backgroundDrawable2;
            View view2 = this.view;
            if (view2 != null) {
                view2.setBackground(backgroundDrawable2);
            }
        }
        return this.backgroundDrawable;
    }

    public void setBackgroundColor(int i) {
        getBgDrawable().setColor(i);
    }

    public int getBackgroundColor() {
        return getBgDrawable().getColor();
    }

    public void setBackgroundColor(Object obj) {
        getBgDrawable().setColor(obj);
    }

    public void setBackgroundImage(String str) {
        YogaDrawableUtil.renderDrawable((HummerContext) this.context, getBgDrawable(), str);
    }

    public void setBorderStyle(String str) {
        getBgDrawable().setBorderStyle(str);
    }

    public void setBorderLeftStyle(String str) {
        getBgDrawable().setBorderLeftStyle(str);
    }

    public void setBorderTopStyle(String str) {
        getBgDrawable().setBorderTopStyle(str);
    }

    public void setBorderRightStyle(String str) {
        getBgDrawable().setBorderRightStyle(str);
    }

    public void setBorderBottomStyle(String str) {
        getBgDrawable().setBorderBottomStyle(str);
    }

    public void setBorderWidth(float f) {
        getBgDrawable().setBorderWidth(f);
    }

    public void setBorderLeftWidth(float f) {
        getBgDrawable().setBorderLeftWidth(f);
    }

    public void setBorderTopWidth(float f) {
        getBgDrawable().setBorderTopWidth(f);
    }

    public void setBorderRightWidth(float f) {
        getBgDrawable().setBorderRightWidth(f);
    }

    public void setBorderBottomWidth(float f) {
        getBgDrawable().setBorderBottomWidth(f);
    }

    public void setBorderColor(int i) {
        getBgDrawable().setBorderColor(i);
    }

    public void setBorderLeftColor(int i) {
        getBgDrawable().setBorderLeftColor(i);
    }

    public void setBorderTopColor(int i) {
        getBgDrawable().setBorderTopColor(i);
    }

    public void setBorderRightColor(int i) {
        getBgDrawable().setBorderRightColor(i);
    }

    public void setBorderBottomColor(int i) {
        getBgDrawable().setBorderBottomColor(i);
    }

    public void setBorderRadius(float f) {
        getBgDrawable().setBorderRadius(f);
    }

    public void setBorderTopLeftRadius(float f) {
        getBgDrawable().setBorderTopLeftRadius(f);
    }

    public void setBorderTopRightRadius(float f) {
        getBgDrawable().setBorderTopRightRadius(f);
    }

    public void setBorderBottomRightRadius(float f) {
        getBgDrawable().setBorderBottomRightRadius(f);
    }

    public void setBorderBottomLeftRadius(float f) {
        getBgDrawable().setBorderBottomLeftRadius(f);
    }

    public void setBorderRadiusPercent(float f) {
        getBgDrawable().setBorderRadiusPercent(f);
    }

    public void setBorderTopLeftRadiusPercent(float f) {
        getBgDrawable().setBorderTopLeftRadiusPercent(f);
    }

    public void setBorderTopRightRadiusPercent(float f) {
        getBgDrawable().setBorderTopRightRadiusPercent(f);
    }

    public void setBorderBottomRightRadiusPercent(float f) {
        getBgDrawable().setBorderBottomRightRadiusPercent(f);
    }

    public void setBorderBottomLeftRadiusPercent(float f) {
        getBgDrawable().setBorderBottomLeftRadiusPercent(f);
    }

    /* access modifiers changed from: package-private */
    public BackgroundDrawable.Border getBorder() {
        return getBgDrawable().getBorder();
    }

    public float[] getBorderRadii() {
        return getBgDrawable().getBorderRadii();
    }

    public void setShadow(float f, float f2, float f3, int i) {
        getBgDrawable().setShadow(f, f2, f3, i);
    }

    public Drawable getBackgroundDrawable() {
        View view2 = this.view;
        if (view2 == null) {
            return null;
        }
        return view2.getBackground();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        View view2 = this.view;
        if (view2 != null) {
            view2.setBackground(drawable);
        }
    }
}
