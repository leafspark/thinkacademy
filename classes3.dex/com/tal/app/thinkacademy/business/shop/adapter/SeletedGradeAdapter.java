package com.tal.app.thinkacademy.business.shop.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.common.user.Grade;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/SeletedGradeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/common/user/Grade;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "gradePosition", "", "(Ljava/util/List;I)V", "getGradePosition", "()I", "setGradePosition", "(I)V", "convert", "", "holder", "item", "updatePosition", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SeletedGradeAdapter.kt */
public final class SeletedGradeAdapter extends BaseQuickAdapter<Grade, BaseViewHolder> {
    private int gradePosition;

    public final int getGradePosition() {
        return this.gradePosition;
    }

    public final void setGradePosition(int i) {
        this.gradePosition = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeletedGradeAdapter(List<Grade> list, int i) {
        super(R.layout.bus_shop_item_seleted_grade, list);
        Intrinsics.checkNotNullParameter(list, "list");
        this.gradePosition = i;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, Grade grade) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(grade, "item");
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvName);
        textView.setText(grade.getName());
        textView.setSelected(getGradePosition() == getItemPosition(grade));
    }

    public final void updatePosition(int i) {
        this.gradePosition = i;
    }
}
