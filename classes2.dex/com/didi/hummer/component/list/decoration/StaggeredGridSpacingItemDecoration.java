package com.didi.hummer.component.list.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.hummer.component.list.ListUtil;

public class StaggeredGridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int itemSpacing;
    private int lineSpacing;
    private int spanCount;

    public StaggeredGridSpacingItemDecoration(int i, int i2, boolean z) {
        this(i, i2, i2, z);
    }

    public StaggeredGridSpacingItemDecoration(int i, int i2, int i3, boolean z) {
        this.spanCount = i;
        this.lineSpacing = i2;
        this.itemSpacing = i3;
        this.includeEdge = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int spanIndex = view.getLayoutParams().getSpanIndex();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (ListUtil.isVertical(recyclerView.getLayoutManager())) {
            if (this.includeEdge) {
                int i = this.itemSpacing;
                rect.left = i - ((spanIndex * i) / this.spanCount);
                rect.right = ((spanIndex + 1) * this.itemSpacing) / this.spanCount;
                if (childAdapterPosition < this.spanCount) {
                    rect.top = this.lineSpacing;
                }
                rect.bottom = this.lineSpacing;
                return;
            }
            rect.left = (this.itemSpacing * spanIndex) / this.spanCount;
            int i2 = this.itemSpacing;
            rect.right = i2 - (((spanIndex + 1) * i2) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                rect.top = this.lineSpacing;
            }
        } else if (this.includeEdge) {
            int i3 = this.itemSpacing;
            rect.top = i3 - ((spanIndex * i3) / this.spanCount);
            rect.bottom = ((spanIndex + 1) * this.itemSpacing) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                rect.left = this.lineSpacing;
            }
            rect.right = this.lineSpacing;
        } else {
            rect.top = (this.itemSpacing * spanIndex) / this.spanCount;
            int i4 = this.itemSpacing;
            rect.bottom = i4 - (((spanIndex + 1) * i4) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                rect.left = this.lineSpacing;
            }
        }
    }
}
