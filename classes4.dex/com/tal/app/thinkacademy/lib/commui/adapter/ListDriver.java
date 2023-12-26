package com.tal.app.thinkacademy.lib.commui.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B'\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/lib/commui/adapter/ListDriver;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spaceDp", "", "(F)V", "horSpaceDp", "verSpaceDp", "(FF)V", "left", "", "top", "right", "bottom", "(IIII)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListDriver.kt */
public final class ListDriver extends RecyclerView.ItemDecoration {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    private ListDriver(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public ListDriver(float f) {
        this(f, f);
    }

    public ListDriver(float f, float f2) {
        this(SizeUtils.dp2px(f), SizeUtils.dp2px(f2), SizeUtils.dp2px(f), SizeUtils.dp2px(f2));
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i4 = this.left;
        int i5 = this.right;
        int i6 = this.top;
        int i7 = this.bottom;
        GridLayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = layoutManager;
            if (gridLayoutManager.getOrientation() == 0) {
                int spanCount = childAdapterPosition % gridLayoutManager.getSpanCount();
                i2 = childAdapterPosition < gridLayoutManager.getSpanCount() ? this.left : 0;
                if (spanCount == 0) {
                    i3 = this.top;
                }
                i6 = 0;
                i4 = i2;
                rect.set(i4, i6, i5, i7);
            }
            i4 = childAdapterPosition % gridLayoutManager.getSpanCount() == 0 ? this.left : 0;
            if (childAdapterPosition < gridLayoutManager.getSpanCount()) {
                i = this.top;
                i6 = i;
                rect.set(i4, i6, i5, i7);
            }
            i6 = 0;
            rect.set(i4, i6, i5, i7);
        } else if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 1) {
                if (childAdapterPosition == 0) {
                    i = this.top;
                    i6 = i;
                    rect.set(i4, i6, i5, i7);
                }
                i6 = 0;
                rect.set(i4, i6, i5, i7);
            } else if (childAdapterPosition == 0) {
                i2 = this.left;
                i4 = i2;
                rect.set(i4, i6, i5, i7);
            } else {
                i4 = 0;
                rect.set(i4, i6, i5, i7);
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            if (staggeredGridLayoutManager.getOrientation() == 0) {
                int spanCount2 = childAdapterPosition % staggeredGridLayoutManager.getSpanCount();
                i2 = childAdapterPosition < staggeredGridLayoutManager.getSpanCount() ? this.left : 0;
                if (spanCount2 == 0) {
                    i3 = this.top;
                }
                i6 = 0;
                i4 = i2;
                rect.set(i4, i6, i5, i7);
            }
            i4 = childAdapterPosition % staggeredGridLayoutManager.getSpanCount() == 0 ? this.left : 0;
            if (childAdapterPosition < staggeredGridLayoutManager.getSpanCount()) {
                i = this.top;
                i6 = i;
                rect.set(i4, i6, i5, i7);
            }
            i6 = 0;
            rect.set(i4, i6, i5, i7);
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            rect.set(i4, i6, i5, i7);
        }
        i6 = i3;
        i4 = i2;
        rect.set(i4, i6, i5, i7);
    }
}
