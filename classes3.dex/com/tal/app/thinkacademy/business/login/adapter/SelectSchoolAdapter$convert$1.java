package com.tal.app.thinkacademy.business.login.adapter;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.login.adapter.SelectSchoolAdapter;
import com.tal.app.thinkacademy.business.login.view.item.SchoolItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectSchoolAdapter.kt */
final class SelectSchoolAdapter$convert$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseViewHolder $holder;
    final /* synthetic */ SchoolItem $item;
    final /* synthetic */ SelectSchoolAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectSchoolAdapter$convert$1(SelectSchoolAdapter selectSchoolAdapter, BaseViewHolder baseViewHolder, SchoolItem schoolItem) {
        super(0);
        this.this$0 = selectSchoolAdapter;
        this.$holder = baseViewHolder;
        this.$item = schoolItem;
    }

    public final void invoke() {
        int layoutPosition;
        if (this.this$0.getMItemClickListener() != null && this.this$0.mCheckedPosition != (layoutPosition = this.$holder.getLayoutPosition())) {
            if (this.this$0.mCheckedPosition != -1) {
                ((SchoolItem) this.this$0.getData().get(this.this$0.mCheckedPosition)).setChecked(false);
            }
            this.this$0.mCheckedPosition = layoutPosition;
            SchoolItem schoolItem = this.$item;
            schoolItem.setChecked(!schoolItem.isChecked());
            SelectSchoolAdapter.OnItemCheckedListener mItemClickListener = this.this$0.getMItemClickListener();
            if (mItemClickListener != null) {
                mItemClickListener.onChecked(layoutPosition);
            }
        }
    }
}
