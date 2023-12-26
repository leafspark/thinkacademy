package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AutohListview extends RecyclerView {
    public AutohListview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutohListview(Context context) {
        super(context);
    }

    public AutohListview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        AutohListview.super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
