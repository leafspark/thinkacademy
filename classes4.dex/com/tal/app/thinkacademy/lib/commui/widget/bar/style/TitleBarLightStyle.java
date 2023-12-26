package com.tal.app.thinkacademy.lib.commui.widget.bar.style;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.SelectorDrawable;

public class TitleBarLightStyle extends BaseTitleBarStyle {
    public int getLeftColor() {
        return -10066330;
    }

    public int getRightColor() {
        return -5987164;
    }

    public int getTitleColor() {
        return -14540254;
    }

    public boolean isLineVisible() {
        return true;
    }

    public TitleBarLightStyle(Context context) {
        super(context);
    }

    public Drawable getBackground() {
        return new ColorDrawable(-1);
    }

    public Drawable getBackIcon() {
        return getDrawable(R.drawable.bar_icon_back_black);
    }

    public Drawable getLineDrawable() {
        return new ColorDrawable(-1250068);
    }

    public Drawable getLeftBackground() {
        return new SelectorDrawable.Builder().setDefault(new ColorDrawable(0)).setFocused(new ColorDrawable(201326592)).setPressed(new ColorDrawable(201326592)).build();
    }

    public Drawable getRightBackground() {
        return getLeftBackground();
    }
}
