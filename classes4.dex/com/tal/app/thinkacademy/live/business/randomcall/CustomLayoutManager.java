package com.tal.app.thinkacademy.live.business.randomcall;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

public class CustomLayoutManager extends LinearLayoutManager {
    /* access modifiers changed from: private */
    public static volatile float speed = 480.0f;
    private Context context;
    private LinearSmoothScroller linearSmoothScroller;

    public CustomLayoutManager(Context context2) {
        super(context2);
        this.context = context2;
    }

    public CustomLayoutManager(Context context2, int i, boolean z) {
        super(context2, i, z);
    }

    public CustomLayoutManager(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        if (this.linearSmoothScroller == null) {
            this.linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
                /* access modifiers changed from: protected */
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return CustomLayoutManager.speed / ((float) displayMetrics.densityDpi);
                }
            };
        }
        this.linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(this.linearSmoothScroller);
    }
}
