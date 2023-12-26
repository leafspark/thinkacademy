package com.flyco.roundview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.luck.picture.lib.tools.PictureFileUtils;

public class RoundRelativeLayout extends RelativeLayout {
    private RoundViewDelegate delegate;

    public RoundRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.delegate = new RoundViewDelegate(this, context, attributeSet);
    }

    public RoundViewDelegate getDelegate() {
        return this.delegate;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.delegate.isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), PictureFileUtils.GB);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.delegate.isRadiusHalfHeight()) {
            this.delegate.setCornerRadius(getHeight() / 2);
        } else {
            this.delegate.setBgSelector();
        }
    }
}
