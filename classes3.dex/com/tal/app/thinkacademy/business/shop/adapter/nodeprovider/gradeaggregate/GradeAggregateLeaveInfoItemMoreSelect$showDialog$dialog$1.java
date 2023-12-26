package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "select", "", "postString", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateLeaveInfoItemMoreSelect.kt */
final class GradeAggregateLeaveInfoItemMoreSelect$showDialog$dialog$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ BaseViewHolder $helper;
    final /* synthetic */ UserLeaveComponentData $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateLeaveInfoItemMoreSelect$showDialog$dialog$1(UserLeaveComponentData userLeaveComponentData, BaseViewHolder baseViewHolder) {
        super(2);
        this.$item = userLeaveComponentData;
        this.$helper = baseViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        this.$item.setMLocalSelectText(str2);
        this.$item.setMLocalDisplaySelectText(str);
        XesLog.dt("留资组件", new Object[]{"选中的为：post=" + this.$item.getMLocalSelectText() + ",显示为：" + this.$item.getMLocalDisplaySelectText()});
        ((TextView) this.$helper.getView(R.id.moreSelectText)).setText(this.$item.getMLocalDisplaySelectText());
    }
}
