package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/CourseHighLightsDialogAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailHighlight;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseHighLightsDialogAdapter.kt */
public final class CourseHighLightsDialogAdapter extends BaseQuickAdapter<ShopClassDetailHighlight, BaseViewHolder> {
    public CourseHighLightsDialogAdapter() {
        super(R.layout.shop_course_highlights_dialog_item, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, ShopClassDetailHighlight shopClassDetailHighlight) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(shopClassDetailHighlight, "item");
        baseViewHolder.setText(R.id.title_text, shopClassDetailHighlight.getTitle());
        baseViewHolder.setText(R.id.title_description, shopClassDetailHighlight.getContent());
    }
}
