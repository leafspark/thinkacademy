package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateEnum;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.HwHtmlImageGetter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateHtmlProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateHtmlProvider.kt */
public final class GradeAggregateHtmlProvider extends BaseNodeProvider {
    public int getItemViewType() {
        return GradeAggregateEnum.HTML.getValue();
    }

    public int getLayoutId() {
        return R.layout.bus_shop_aggregate_detail_html;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof GradeAggregateHtml) {
            ((TextView) baseViewHolder.getView(R.id.rich_title)).setText(((GradeAggregateHtml) baseNode).getTitle());
            try {
                TextView textView = (TextView) baseViewHolder.getView(R.id.rich_content);
                textView.setOutlineProvider(new GradeAggregateHtmlProvider$convert$1());
                textView.setClipToOutline(true);
                int dp2px = getContext().getResources().getDisplayMetrics().widthPixels - SizeUtils.dp2px(64.0f);
                XesLog.dt("GradeAggregateHtmlProvider", new Object[]{Intrinsics.stringPlus("convert baseWidth=", Integer.valueOf(dp2px))});
                String description = ((GradeAggregateHtml) baseNode).getDescription();
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "textView.context");
                textView.setText(Html.fromHtml(description, new HwHtmlImageGetter(context, textView, R.drawable.bg_default_image, dp2px, SizeUtils.dp2px(6.0f)), (Html.TagHandler) null));
            } catch (Exception unused) {
            }
        }
    }
}
