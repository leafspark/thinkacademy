package com.tal.app.thinkacademy.business.home.main.shop.view;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/business/home/main/shop/view/GridSectionAverageGapItemDecoration$mDataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GridSectionAverageGapItemDecoration.kt */
public final class GridSectionAverageGapItemDecoration$mDataObserver$1 extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ GridSectionAverageGapItemDecoration this$0;

    GridSectionAverageGapItemDecoration$mDataObserver$1(GridSectionAverageGapItemDecoration gridSectionAverageGapItemDecoration) {
        this.this$0 = gridSectionAverageGapItemDecoration;
    }

    public void onChanged() {
        this.this$0.markSections();
    }

    public void onItemRangeChanged(int i, int i2) {
        this.this$0.markSections();
    }

    public void onItemRangeChanged(int i, int i2, Object obj) {
        this.this$0.markSections();
    }

    public void onItemRangeInserted(int i, int i2) {
        this.this$0.markSections();
    }

    public void onItemRangeRemoved(int i, int i2) {
        this.this$0.markSections();
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
        this.this$0.markSections();
    }
}
