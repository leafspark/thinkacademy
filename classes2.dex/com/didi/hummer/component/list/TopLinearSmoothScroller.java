package com.didi.hummer.component.list;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;

public class TopLinearSmoothScroller extends LinearSmoothScroller {
    /* access modifiers changed from: protected */
    public int getHorizontalSnapPreference() {
        return -1;
    }

    public int getVerticalSnapPreference() {
        return -1;
    }

    public TopLinearSmoothScroller(Context context) {
        super(context);
    }
}
