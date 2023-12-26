package com.tal.app.thinkacademy.lib.commui.widget.bar.style;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import com.tal.app.thinkacademy.lib.commui.widget.bar.ITitleBarStyle;

public abstract class BaseTitleBarStyle implements ITitleBarStyle {
    private Context mContext;

    public int getLineSize() {
        return 1;
    }

    public int getTitleGravity() {
        return 17;
    }

    public BaseTitleBarStyle(Context context) {
        this.mContext = context;
    }

    public int getDrawablePadding() {
        return dp2px(2.0f);
    }

    public int getChildPadding() {
        return dp2px(12.0f);
    }

    public int getTitleBarHeight() {
        if (Build.VERSION.SDK_INT < 11) {
            return dp2px(56.0f);
        }
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(new int[]{16843499});
        int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        return dimension;
    }

    public float getLeftSize() {
        return (float) sp2px(14.0f);
    }

    public float getTitleSize() {
        return (float) sp2px(16.0f);
    }

    public float getRightSize() {
        return (float) sp2px(14.0f);
    }

    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: protected */
    public Drawable getDrawable(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getContext().getResources().getDrawable(i, getContext().getTheme());
        }
        return getContext().getResources().getDrawable(i);
    }

    /* access modifiers changed from: protected */
    public int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    public int sp2px(float f) {
        return (int) TypedValue.applyDimension(2, f, getContext().getResources().getDisplayMetrics());
    }
}
