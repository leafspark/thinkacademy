package com.tal.app.thinkacademy.business.shop.classdetail;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$initScrollListen$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
public final class ShopClassDetailActivity$initScrollListen$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ShopClassDetailActivity this$0;

    ShopClassDetailActivity$initScrollListen$2(ShopClassDetailActivity shopClassDetailActivity) {
        this.this$0 = shopClassDetailActivity;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ShopClassDetailActivity$initScrollListen$2.super.onScrolled(recyclerView, i, i2);
        this.this$0.checkAndUpdateIndication();
        if (!this.this$0.mIsHasReportScrollItem) {
            this.this$0.reportScrollItem();
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ShopClassDetailActivity$initScrollListen$2.super.onScrollStateChanged(recyclerView, i);
        this.this$0.reportScrollItem();
    }
}
