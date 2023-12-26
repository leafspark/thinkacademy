package com.xueersi.tborad.extensions.rule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashSet;
import java.util.Set;

public class RulerAndCompassesView extends View {
    public static int ID = View.generateViewId();
    private final Set<Drawable> drawableList;

    public RulerAndCompassesView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RulerAndCompassesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RulerAndCompassesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawableList = new LinkedHashSet();
        setId(ID);
    }

    public void clear() {
        this.drawableList.clear();
        postInvalidate();
    }

    public void updateDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.drawableList.add(drawable);
            if (getMeasuredWidth() > 0 || getMeasuredHeight() > 0) {
                postInvalidate();
            }
        }
    }

    public void removeDrawable(Drawable drawable) {
        if (drawable != null) {
            this.drawableList.remove(drawable);
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        for (Drawable bounds : this.drawableList) {
            bounds.setBounds(0, 0, i, i2);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Drawable draw : this.drawableList) {
            draw.draw(canvas);
        }
    }
}
