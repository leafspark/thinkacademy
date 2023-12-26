package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "select", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemSelect.kt */
final class GradeAggregateLeaveInfoItemSelect$showGradeDialog$dialog$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ BaseViewHolder $helper;
    final /* synthetic */ UserLeaveComponentData $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateLeaveInfoItemSelect$showGradeDialog$dialog$1(UserLeaveComponentData userLeaveComponentData, BaseViewHolder baseViewHolder) {
        super(2);
        this.$item = userLeaveComponentData;
        this.$helper = baseViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str) {
        this.$item.setMLocalSelectText(str);
        ((TextView) this.$helper.getView(R.id.singleSelectText)).setText(str);
    }
}
