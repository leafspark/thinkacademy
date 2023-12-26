package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flyco.roundview.RoundViewDelegate;
import com.tal.app.thinkacademy.lib.util.constant.MemoryConstants;

public class RoundConstraintLayout extends ConstraintLayout {
    private final RoundViewDelegate delegate;

    public RoundConstraintLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout, android.view.View] */
    public RoundConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.delegate = new RoundViewDelegate(this, context, attributeSet);
    }

    public RoundViewDelegate getDelegate() {
        return this.delegate;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.delegate.isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            RoundConstraintLayout.super.onMeasure(i, i2);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), MemoryConstants.GB);
        RoundConstraintLayout.super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        RoundConstraintLayout.super.onLayout(z, i, i2, i3, i4);
        if (this.delegate.isRadiusHalfHeight()) {
            this.delegate.setCornerRadius(getHeight() / 2);
        } else {
            this.delegate.setBgSelector();
        }
    }
}
