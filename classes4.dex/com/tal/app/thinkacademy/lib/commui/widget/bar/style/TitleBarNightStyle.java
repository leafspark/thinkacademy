package com.tal.app.thinkacademy.lib.commui.widget.bar.style;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.SelectorDrawable;

public class TitleBarNightStyle extends BaseTitleBarStyle {
    public int getLeftColor() {
        return -855638017;
    }

    public int getRightColor() {
        return -855638017;
    }

    public int getTitleColor() {
        return -285212673;
    }

    public boolean isLineVisible() {
        return true;
    }

    public TitleBarNightStyle(Context context) {
        super(context);
    }

    public Drawable getBackground() {
        return new ColorDrawable(-16777216);
    }

    public Drawable getBackIcon() {
        return getDrawable(R.drawable.bar_icon_back_white);
    }

    public Drawable getLineDrawable() {
        return new ColorDrawable(-1);
    }

    public Drawable getLeftBackground() {
        return new SelectorDrawable.Builder().setDefault(new ColorDrawable(0)).setFocused(new ColorDrawable(1728053247)).setPressed(new ColorDrawable(1728053247)).build();
    }

    public Drawable getRightBackground() {
        return getLeftBackground();
    }
}
