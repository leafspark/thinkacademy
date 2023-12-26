package com.chad.library.adapter.base;

import android.view.View;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: BaseBinderAdapter.kt */
final class BaseBinderAdapter$bindClick$1 implements View.OnClickListener {
    final /* synthetic */ BaseViewHolder $viewHolder;
    final /* synthetic */ BaseBinderAdapter this$0;

    BaseBinderAdapter$bindClick$1(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder) {
        this.this$0 = baseBinderAdapter;
        this.$viewHolder = baseViewHolder;
    }

    public final void onClick(View view) {
        MethodInfo.onClickEventEnter(view, BaseBinderAdapter.class);
        int adapterPosition = this.$viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
            return;
        }
        int headerLayoutCount = adapterPosition - this.this$0.getHeaderLayoutCount();
        BaseItemBinder<Object, BaseViewHolder> itemBinder = this.this$0.getItemBinder(this.$viewHolder.getItemViewType());
        BaseViewHolder baseViewHolder = this.$viewHolder;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        itemBinder.onClick(baseViewHolder, view, this.this$0.getData().get(headerLayoutCount), headerLayoutCount);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
