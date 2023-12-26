package com.tal.app.thinkacademy.live.business.randomcall;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class LooperLayoutManager extends RecyclerView.LayoutManager {
    private static final String TAG = "LooperLayoutManager";
    private boolean looperEnable = true;

    public boolean canScrollVertically() {
        return true;
    }

    public void setLooperEnable(boolean z) {
        this.looperEnable = z;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() > 0 && !state.isPreLayout()) {
            detachAndScrapAttachedViews(recycler);
            int i = 0;
            int i2 = 0;
            while (i < getItemCount()) {
                View viewForPosition = recycler.getViewForPosition(i);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = i2 + getDecoratedMeasuredHeight(viewForPosition);
                layoutDecorated(viewForPosition, 0, i2, decoratedMeasuredWidth, decoratedMeasuredHeight);
                if (decoratedMeasuredHeight <= getHeight()) {
                    i++;
                    i2 = decoratedMeasuredHeight;
                } else {
                    return;
                }
            }
        }
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int fill = fill(i, recycler, state);
        if (fill == 0) {
            return 0;
        }
        offsetChildrenVertical(-fill);
        recyclerHideView(i, recycler, state);
        return fill;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int fill(int r9, androidx.recyclerview.widget.RecyclerView.Recycler r10, androidx.recyclerview.widget.RecyclerView.State r11) {
        /*
            r8 = this;
            r11 = 0
            r0 = 0
            if (r9 <= 0) goto L_0x005b
            int r1 = r8.getChildCount()
            int r1 = r1 + -1
            android.view.View r1 = r8.getChildAt(r1)
            if (r1 != 0) goto L_0x0011
            return r0
        L_0x0011:
            int r2 = r8.getPosition(r1)
            int r3 = r1.getBottom()
            int r4 = r8.getHeight()
            if (r3 >= r4) goto L_0x00a7
            int r3 = r8.getItemCount()
            int r3 = r3 + -1
            if (r2 != r3) goto L_0x0033
            boolean r2 = r8.looperEnable
            if (r2 == 0) goto L_0x0030
            android.view.View r11 = r10.getViewForPosition(r0)
            goto L_0x0039
        L_0x0030:
            r3 = r11
            r9 = r0
            goto L_0x003a
        L_0x0033:
            int r2 = r2 + 1
            android.view.View r11 = r10.getViewForPosition(r2)
        L_0x0039:
            r3 = r11
        L_0x003a:
            if (r3 != 0) goto L_0x003d
            return r9
        L_0x003d:
            r8.addView(r3)
            r8.measureChildWithMargins(r3, r0, r0)
            int r6 = r8.getDecoratedMeasuredWidth(r3)
            int r10 = r8.getDecoratedMeasuredHeight(r3)
            r4 = 0
            int r5 = r1.getBottom()
            int r11 = r1.getBottom()
            int r7 = r11 + r10
            r2 = r8
            r2.layoutDecorated(r3, r4, r5, r6, r7)
            return r9
        L_0x005b:
            android.view.View r1 = r8.getChildAt(r0)
            if (r1 != 0) goto L_0x0062
            return r0
        L_0x0062:
            int r2 = r8.getPosition(r1)
            int r3 = r1.getTop()
            if (r3 < 0) goto L_0x00a7
            if (r2 != 0) goto L_0x0080
            boolean r2 = r8.looperEnable
            if (r2 == 0) goto L_0x007d
            int r11 = r8.getItemCount()
            int r11 = r11 + -1
            android.view.View r11 = r10.getViewForPosition(r11)
            goto L_0x0086
        L_0x007d:
            r3 = r11
            r9 = r0
            goto L_0x0087
        L_0x0080:
            int r2 = r2 + -1
            android.view.View r11 = r10.getViewForPosition(r2)
        L_0x0086:
            r3 = r11
        L_0x0087:
            if (r3 != 0) goto L_0x008a
            return r0
        L_0x008a:
            r8.addView(r3, r0)
            r8.measureChildWithMargins(r3, r0, r0)
            int r6 = r8.getDecoratedMeasuredWidth(r3)
            int r10 = r8.getDecoratedMeasuredHeight(r3)
            r4 = 0
            int r11 = r1.getTop()
            int r5 = r11 - r10
            int r7 = r1.getTop()
            r2 = r8
            r2.layoutDecorated(r3, r4, r5, r6, r7)
        L_0x00a7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.randomcall.LooperLayoutManager.fill(int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):int");
    }

    private void recyclerHideView(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (i > 0) {
                    if (childAt.getBottom() < 0) {
                        removeAndRecycleView(childAt, recycler);
                    }
                } else if (childAt.getTop() > getHeight()) {
                    removeAndRecycleView(childAt, recycler);
                }
            }
        }
    }
}
