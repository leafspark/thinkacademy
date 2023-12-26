package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateLeaveInfoItemInput$convert$3", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "onFocusChange", "", "v", "Landroid/view/View;", "hasFocus", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemInput.kt */
public final class GradeAggregateLeaveInfoItemInput$convert$3 implements ClearEditText.OnFocusListener {
    final /* synthetic */ BaseViewHolder $helper;
    final /* synthetic */ GradeAggregateLeaveInfoItemInput this$0;

    GradeAggregateLeaveInfoItemInput$convert$3(BaseViewHolder baseViewHolder, GradeAggregateLeaveInfoItemInput gradeAggregateLeaveInfoItemInput) {
        this.$helper = baseViewHolder;
        this.this$0 = gradeAggregateLeaveInfoItemInput;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.$helper.getView(R.id.inputTextGroup).getDelegate().setBackgroundColor(this.this$0.getContext().getColor(R.color.color_fff9ec));
            ((ClearEditText) this.$helper.getView(R.id.inputTextView)).setTextColor(this.this$0.getContext().getColor(R.color.color_ffaa0a));
            return;
        }
        this.$helper.getView(R.id.inputTextGroup).getDelegate().setBackgroundColor(this.this$0.getContext().getColor(R.color.color_f8f9fa));
        ((ClearEditText) this.$helper.getView(R.id.inputTextView)).setTextColor(this.this$0.getContext().getColor(R.color.color_172b4d));
    }
}
