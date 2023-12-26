package com.didi.hummer.component.list.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.hummer.component.list.ListUtil;

public class LinearSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int space;

    public LinearSpacingItemDecoration(int i, boolean z) {
        this.space = i;
        this.includeEdge = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (ListUtil.isVertical(recyclerView.getLayoutManager())) {
            if (this.includeEdge) {
                rect.left = this.space;
                rect.right = this.space;
                rect.bottom = this.space;
                if (recyclerView.getChildLayoutPosition(view) == 0) {
                    rect.top = this.space;
                } else {
                    rect.top = 0;
                }
            } else if (recyclerView.getChildLayoutPosition(view) > 0) {
                rect.top = this.space;
            }
        } else if (this.includeEdge) {
            rect.top = this.space;
            rect.bottom = this.space;
            rect.right = this.space;
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.left = this.space;
            } else {
                rect.left = 0;
            }
        } else if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.left = this.space;
        }
    }
}
