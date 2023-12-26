package com.tal.app.thinkacademy.business.shop.widget.dialog;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassTabListDayAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "type", "", "(I)V", "mSelectedItem", "convert", "", "holder", "item", "setSelectedItem", "", "reset", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterAdapter.kt */
final class ClassTabListDayAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private String mSelectedItem;
    private final int type;

    public ClassTabListDayAdapter() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassTabListDayAdapter(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public ClassTabListDayAdapter(int i) {
        super(R.layout.item_shop_class_filter_day, (List) null, 2, (DefaultConstructorMarker) null);
        this.type = i;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(str, "item");
        StateTextView stateTextView = (StateTextView) baseViewHolder.getView(R.id.tv_item_day);
        if (this.type == 1) {
            charSequence = ClassFilterAdapterKt.transformDay(getContext(), str);
        } else {
            charSequence = str;
        }
        stateTextView.setText(charSequence);
        stateTextView.setHasData(Intrinsics.areEqual((Object) this.mSelectedItem, (Object) str));
    }

    public static /* synthetic */ boolean setSelectedItem$default(ClassTabListDayAdapter classTabListDayAdapter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return classTabListDayAdapter.setSelectedItem(str, z);
    }

    public final boolean setSelectedItem(String str, boolean z) {
        if (!z && Intrinsics.areEqual((Object) this.mSelectedItem, (Object) str)) {
            str = null;
        }
        this.mSelectedItem = str;
        CharSequence charSequence = str;
        return !(charSequence == null || charSequence.length() == 0);
    }
}
