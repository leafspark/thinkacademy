package com.chad.library.adapter.base;

import android.view.View;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/chad/library/adapter/base/BaseQuickAdapter$bindViewClickListener$1$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: BaseQuickAdapter.kt */
final class BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ BaseViewHolder $viewHolder$inlined;
    final /* synthetic */ BaseQuickAdapter this$0;

    BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.this$0 = baseQuickAdapter;
        this.$viewHolder$inlined = baseViewHolder;
    }

    public final void onClick(View view) {
        MethodInfo.onClickEventEnter(view, BaseQuickAdapter.class);
        int adapterPosition = this.$viewHolder$inlined.getAdapterPosition();
        if (adapterPosition == -1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
            return;
        }
        int headerLayoutCount = adapterPosition - this.this$0.getHeaderLayoutCount();
        BaseQuickAdapter baseQuickAdapter = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(view, "v");
        baseQuickAdapter.setOnItemClick(view, headerLayoutCount);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
