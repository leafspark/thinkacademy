package com.tal.app.thinkacademy.live.business.allonstage.adapter;

import com.tal.app.thinkacademy.live.business.allonstage.adapter.AllOnstagePadAdapter;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnstagePadAdapter.kt */
final class AllOnstagePadAdapter$onBindViewHolder$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StudentVideoBean.ListBean $bean;
    final /* synthetic */ AllOnstagePadAdapter.MyViewHolder $holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnstagePadAdapter$onBindViewHolder$2(AllOnstagePadAdapter.MyViewHolder myViewHolder, StudentVideoBean.ListBean listBean) {
        super(0);
        this.$holder = myViewHolder;
        this.$bean = listBean;
    }

    public final void invoke() {
        this.$holder.getEmoji_view_bg().setVisibility(8);
        this.$holder.getEmoji_view().setVisibility(8);
        this.$bean.setShowEmoji(false);
    }
}
