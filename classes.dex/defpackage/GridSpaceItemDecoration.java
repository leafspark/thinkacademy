package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"LGridSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mSpanCount", "", "mRowSpacing", "mColumnSpacing", "(III)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: GridSpaceItemDecoration  reason: default package */
/* compiled from: GridSpaceItemDecoration.kt */
public final class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int mColumnSpacing;
    private final int mRowSpacing;
    private final int mSpanCount;

    public GridSpaceItemDecoration(int i, int i2, int i3) {
        this.mSpanCount = i;
        this.mRowSpacing = i2;
        this.mColumnSpacing = i3;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, TransferTable.COLUMN_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.mSpanCount;
        int i2 = childAdapterPosition % i;
        rect.left = (this.mColumnSpacing * i2) / i;
        int i3 = this.mColumnSpacing;
        rect.right = i3 - (((i2 + 1) * i3) / this.mSpanCount);
        if (childAdapterPosition >= this.mSpanCount) {
            rect.top = this.mRowSpacing;
        }
    }
}
