package com.tal.app.thinkcademy.lib.commui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.commui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/CustomLoadMoreView;", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "()V", "getLoadComplete", "Landroid/view/View;", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "getLoadEndView", "getLoadFailView", "getLoadingView", "getRootView", "parent", "Landroid/view/ViewGroup;", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomLoadMoreView.kt */
public class CustomLoadMoreView extends BaseLoadMoreView {
    public View getLoadComplete(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.spaceComplete);
    }

    public View getLoadEndView(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.llLoadMoreEnd);
    }

    public View getLoadFailView(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.llLoadMmoreFail);
    }

    public View getLoadingView(BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.llLoadMoreLoading);
    }

    public View getRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i = R.layout.layout_loadmore_view;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…more_view, parent, false)");
        return inflate;
    }
}
