package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener;

public class RecyclerPreloadView extends RecyclerView {
    private static final int BOTTOM_DEFAULT = 1;
    public static final int BOTTOM_PRELOAD = 2;
    private static final String TAG = "RecyclerPreloadView";
    public boolean isEnabledLoadMore = false;
    public boolean isInTheBottom = false;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;
    private OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadListener;
    private int reachBottomRow = 1;

    public RecyclerPreloadView(Context context) {
        super(context);
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setReachBottomRow(int i) {
        if (i < 1) {
            i = 1;
        }
        this.reachBottomRow = i;
    }

    public void setEnabledLoadMore(boolean z) {
        this.isEnabledLoadMore = z;
    }

    public boolean isEnabledLoadMore() {
        return this.isEnabledLoadMore;
    }

    public void onScrollStateChanged(int i) {
        RecyclerPreloadView.super.onScrollStateChanged(i);
        if (i == 0 || i == 1) {
            GridLayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = layoutManager;
                this.mFirstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
                this.mLastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();
            }
        }
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(int r5, int r6) {
        /*
            r4 = this;
            com.luck.picture.lib.widget.RecyclerPreloadView.super.onScrolled(r5, r6)
            com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener r5 = r4.onRecyclerViewPreloadListener
            if (r5 == 0) goto L_0x0061
            boolean r5 = r4.isEnabledLoadMore
            if (r5 == 0) goto L_0x0061
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r4.getLayoutManager()
            if (r5 == 0) goto L_0x0059
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r4.getAdapter()
            if (r0 == 0) goto L_0x0051
            boolean r1 = r5 instanceof androidx.recyclerview.widget.GridLayoutManager
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0038
            androidx.recyclerview.widget.GridLayoutManager r5 = (androidx.recyclerview.widget.GridLayoutManager) r5
            int r0 = r0.getItemCount()
            int r1 = r5.getSpanCount()
            int r0 = r0 / r1
            int r1 = r5.findLastVisibleItemPosition()
            int r5 = r5.getSpanCount()
            int r1 = r1 / r5
            int r5 = r4.reachBottomRow
            int r0 = r0 - r5
            if (r1 < r0) goto L_0x0038
            r5 = r2
            goto L_0x0039
        L_0x0038:
            r5 = r3
        L_0x0039:
            if (r5 != 0) goto L_0x003e
            r4.isInTheBottom = r3
            goto L_0x0061
        L_0x003e:
            boolean r5 = r4.isInTheBottom
            if (r5 != 0) goto L_0x004c
            com.luck.picture.lib.listener.OnRecyclerViewPreloadMoreListener r5 = r4.onRecyclerViewPreloadListener
            r5.onRecyclerViewPreloadMore()
            if (r6 <= 0) goto L_0x0061
            r4.isInTheBottom = r2
            goto L_0x0061
        L_0x004c:
            if (r6 != 0) goto L_0x0061
            r4.isInTheBottom = r3
            goto L_0x0061
        L_0x0051:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Adapter is null,Please check it!"
            r5.<init>(r6)
            throw r5
        L_0x0059:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "LayoutManager is null,Please check it!"
            r5.<init>(r6)
            throw r5
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.RecyclerPreloadView.onScrolled(int, int):void");
    }

    public void setOnRecyclerViewPreloadListener(OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.onRecyclerViewPreloadListener = onRecyclerViewPreloadMoreListener;
    }
}
