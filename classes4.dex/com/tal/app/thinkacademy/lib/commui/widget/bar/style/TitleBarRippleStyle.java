package com.tal.app.thinkacademy.lib.commui.widget.bar.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

public class TitleBarRippleStyle extends TitleBarTransparentStyle {
    public TitleBarRippleStyle(Context context) {
        super(context);
    }

    public Drawable getLeftBackground() {
        if (Build.VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16843534, typedValue, true)) {
                return getDrawable(typedValue.resourceId);
            }
        }
        return super.getLeftBackground();
    }

    public Drawable getRightBackground() {
        return getLeftBackground();
    }
}
