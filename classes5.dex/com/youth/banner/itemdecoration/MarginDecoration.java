package com.youth.banner.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MarginDecoration extends RecyclerView.ItemDecoration {
    private int mMarginPx;

    public MarginDecoration(int i) {
        this.mMarginPx = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (requireLinearLayoutManager(recyclerView).getOrientation() == 1) {
            rect.top = this.mMarginPx;
            rect.bottom = this.mMarginPx;
            return;
        }
        rect.left = this.mMarginPx;
        rect.right = this.mMarginPx;
    }

    private LinearLayoutManager requireLinearLayoutManager(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }
}
