package com.tal.user.global.trade.adapter;

import android.view.View;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.user.global.trade.base.TalTradeBaseAdapter;
import com.tal.user.global.trade.base.TalTradeViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: TalTradePayWayAdapter.kt */
final class TalTradePayWayAdapter$convert$1 implements View.OnClickListener {
    final /* synthetic */ TalTradeViewHolder $holder;
    final /* synthetic */ TalTradePayWayAdapter this$0;

    TalTradePayWayAdapter$convert$1(TalTradePayWayAdapter talTradePayWayAdapter, TalTradeViewHolder talTradeViewHolder) {
        this.this$0 = talTradePayWayAdapter;
        this.$holder = talTradeViewHolder;
    }

    public final void onClick(View view) {
        MethodInfo.onClickEventEnter(view, TalTradePayWayAdapter.class);
        if (this.this$0.onItemClickListenerButton != null) {
            TalTradeBaseAdapter.OnItemClickListener access$getOnItemClickListenerButton$p = this.this$0.onItemClickListenerButton;
            Intrinsics.checkNotNull(access$getOnItemClickListenerButton$p);
            TalTradeViewHolder talTradeViewHolder = this.$holder;
            access$getOnItemClickListenerButton$p.onItemClick(talTradeViewHolder, talTradeViewHolder.getAdapterPosition());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
