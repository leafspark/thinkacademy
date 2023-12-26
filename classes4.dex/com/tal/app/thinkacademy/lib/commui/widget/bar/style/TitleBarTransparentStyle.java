package com.tal.app.thinkacademy.lib.commui.widget.bar.style;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.SelectorDrawable;

public class TitleBarTransparentStyle extends BaseTitleBarStyle {
    public int getLeftColor() {
        return -1;
    }

    public int getLineSize() {
        return 0;
    }

    public int getRightColor() {
        return -1;
    }

    public int getTitleColor() {
        return -1;
    }

    public boolean isLineVisible() {
        return false;
    }

    public TitleBarTransparentStyle(Context context) {
        super(context);
    }

    public Drawable getBackground() {
        return new ColorDrawable(0);
    }

    public Drawable getBackIcon() {
        return getDrawable(R.drawable.bar_icon_back_white);
    }

    public Drawable getLineDrawable() {
        return new ColorDrawable(0);
    }

    public Drawable getLeftBackground() {
        return new SelectorDrawable.Builder().setDefault(new ColorDrawable(0)).setFocused(new ColorDrawable(570425344)).setPressed(new ColorDrawable(570425344)).build();
    }

    public Drawable getRightBackground() {
        return getLeftBackground();
    }
}
