package com.didi.hummer.component.list.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.hummer.component.list.ListUtil;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int itemSpacing;
    private int lineSpacing;
    private int spanCount;

    public GridSpacingItemDecoration(int i, int i2, boolean z) {
        this(i, i2, i2, z);
    }

    public GridSpacingItemDecoration(int i, int i2, int i3, boolean z) {
        this.spanCount = i;
        this.lineSpacing = i2;
        this.itemSpacing = i3;
        this.includeEdge = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.spanCount;
        if (ListUtil.isVertical(recyclerView.getLayoutManager())) {
            if (this.includeEdge) {
                int i2 = this.itemSpacing;
                rect.left = i2 - ((i * i2) / this.spanCount);
                rect.right = ((i + 1) * this.itemSpacing) / this.spanCount;
                if (childAdapterPosition < this.spanCount) {
                    rect.top = this.lineSpacing;
                }
                rect.bottom = this.lineSpacing;
                return;
            }
            rect.left = (this.itemSpacing * i) / this.spanCount;
            int i3 = this.itemSpacing;
            rect.right = i3 - (((i + 1) * i3) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                rect.top = this.lineSpacing;
            }
        } else if (this.includeEdge) {
            int i4 = this.itemSpacing;
            rect.top = i4 - ((i * i4) / this.spanCount);
            rect.bottom = ((i + 1) * this.itemSpacing) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                rect.left = this.lineSpacing;
            }
            rect.right = this.lineSpacing;
        } else {
            rect.top = (this.itemSpacing * i) / this.spanCount;
            int i5 = this.itemSpacing;
            rect.bottom = i5 - (((i + 1) * i5) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                rect.left = this.lineSpacing;
            }
        }
    }
}
