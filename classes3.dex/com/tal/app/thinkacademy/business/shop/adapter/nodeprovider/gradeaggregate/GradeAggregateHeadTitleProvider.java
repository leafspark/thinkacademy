package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.widget.TextView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateEnum;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHeadDescription;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateHeadTitleProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateHeadTitleProvider.kt */
public final class GradeAggregateHeadTitleProvider extends BaseNodeProvider {
    public int getItemViewType() {
        return GradeAggregateEnum.HEAD_TITLE.getValue();
    }

    public int getLayoutId() {
        return R.layout.bus_shop_aggregate_detail_head_title;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof GradeAggregateHeadDescription) {
            GradeAggregateHeadDescription gradeAggregateHeadDescription = (GradeAggregateHeadDescription) baseNode;
            ((TextView) baseViewHolder.getView(R.id.main_title)).setText(gradeAggregateHeadDescription.getMainTitle());
            ((TextView) baseViewHolder.getView(R.id.sub_title)).setText(gradeAggregateHeadDescription.getSubTitle());
            baseViewHolder.getView(R.id.title_root_view).setPadding(0, 0, 0, gradeAggregateHeadDescription.getMLocalIsLast() ? SizeUtils.dp2px(20.0f) : 0);
        }
    }
}
