package com.tal.app.thinkacademy.business.shop.widget.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkcademy.lib.commui.widget.CustomLoadMoreView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/list/ShopClassBottomView;", "Lcom/tal/app/thinkcademy/lib/commui/widget/CustomLoadMoreView;", "()V", "getRootView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassBottomView.kt */
public final class ShopClassBottomView extends CustomLoadMoreView {
    public View getRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i = R.layout.layout_shop_class_loadmore;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …_loadmore, parent, false)");
        return inflate;
    }
}
