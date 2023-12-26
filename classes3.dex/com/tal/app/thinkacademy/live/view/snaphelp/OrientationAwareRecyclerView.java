package com.tal.app.thinkacademy.live.view.snaphelp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class OrientationAwareRecyclerView extends RecyclerView {
    private float lastX;
    private float lastY;
    /* access modifiers changed from: private */
    public boolean scrolling;

    public OrientationAwareRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OrientationAwareRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrientationAwareRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastX = 0.0f;
        this.lastY = 0.0f;
        this.scrolling = false;
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                OrientationAwareRecyclerView.super.onScrollStateChanged(recyclerView, i);
                boolean unused = OrientationAwareRecyclerView.this.scrolling = i != 0;
            }
        });
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return OrientationAwareRecyclerView.super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = true;
        if (actionMasked == 0) {
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
            if (this.scrolling) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(1);
                return OrientationAwareRecyclerView.super.onInterceptTouchEvent(obtain);
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (Math.abs(y - this.lastY) > Math.abs(x - this.lastX)) {
                z = layoutManager.canScrollVertically();
            } else {
                z = layoutManager.canScrollHorizontally();
            }
            z2 = z;
        }
        if (!z2) {
            return false;
        }
        return OrientationAwareRecyclerView.super.onInterceptTouchEvent(motionEvent);
    }
}
