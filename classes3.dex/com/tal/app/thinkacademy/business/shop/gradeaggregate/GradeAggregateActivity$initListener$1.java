package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.view.View;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.lib.commui.widget.bar.OnTitleBarListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity$initListener$1", "Lcom/tal/app/thinkacademy/lib/commui/widget/bar/OnTitleBarListener;", "onLeftClick", "", "v", "Landroid/view/View;", "onRightClick", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateActivity.kt */
public final class GradeAggregateActivity$initListener$1 extends OnTitleBarListener {
    final /* synthetic */ GradeAggregateActivity this$0;

    GradeAggregateActivity$initListener$1(GradeAggregateActivity gradeAggregateActivity) {
        this.this$0 = gradeAggregateActivity;
    }

    public void onLeftClick(View view) {
        this.this$0.finish();
    }

    public void onRightClick(View view) {
        GradeAggregateActivity$initListener$1.super.onRightClick(view);
        this.this$0.goToShare();
        ShopTrack.INSTANCE.hw_shop_aggregate_share_click(String.valueOf(this.this$0.mPageId));
    }
}
