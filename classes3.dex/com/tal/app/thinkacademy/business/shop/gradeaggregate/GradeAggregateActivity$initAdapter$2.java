package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity$initAdapter$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateActivity.kt */
public final class GradeAggregateActivity$initAdapter$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ GradeAggregateActivity this$0;

    GradeAggregateActivity$initAdapter$2(GradeAggregateActivity gradeAggregateActivity) {
        this.this$0 = gradeAggregateActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r6 = r6.getData();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity$initAdapter$2.super.onScrollStateChanged(r6, r7)
            if (r7 != 0) goto L_0x00f6
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r6 = r5.this$0
            com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter r6 = r6.mGradeAggregateAdapter
            r7 = 0
            if (r6 != 0) goto L_0x0015
        L_0x0013:
            r6 = r7
            goto L_0x0020
        L_0x0015:
            java.util.List r6 = r6.getData()
            if (r6 != 0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            int r6 = r6.size()
        L_0x0020:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r0 = r5.this$0
            androidx.recyclerview.widget.LinearLayoutManager r0 = r0.mLinearLayoutManager
            if (r0 != 0) goto L_0x002a
            r0 = r7
            goto L_0x002e
        L_0x002a:
            int r0 = r0.findFirstVisibleItemPosition()
        L_0x002e:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r1 = r5.this$0
            androidx.recyclerview.widget.LinearLayoutManager r1 = r1.mLinearLayoutManager
            if (r1 != 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            int r7 = r1.findLastVisibleItemPosition()
        L_0x003b:
            int r6 = r6 + -1
            if (r7 <= r6) goto L_0x0057
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r7 = r5.this$0
            boolean r7 = r7.isNeedSubmitInfor
            if (r7 == 0) goto L_0x0056
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r7 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r1 = r5.this$0
            int r1 = r1.mPageId
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r7.hw_shop_aggregate_collect_show(r1)
        L_0x0056:
            r7 = r6
        L_0x0057:
            if (r0 > r7) goto L_0x00f6
        L_0x0059:
            int r6 = r0 + 1
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r1 = r5.this$0
            com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter r1 = r1.mGradeAggregateAdapter
            r2 = 0
            if (r1 != 0) goto L_0x0066
        L_0x0064:
            r1 = r2
            goto L_0x0073
        L_0x0066:
            java.util.List r1 = r1.getData()
            if (r1 != 0) goto L_0x006d
            goto L_0x0064
        L_0x006d:
            java.lang.Object r1 = r1.get(r0)
            com.chad.library.adapter.base.entity.node.BaseNode r1 = (com.chad.library.adapter.base.entity.node.BaseNode) r1
        L_0x0073:
            boolean r3 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode
            if (r3 == 0) goto L_0x0094
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r4 = r5.this$0
            int r4 = r4.mPageId
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode r1 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode) r1
            java.lang.Integer r1 = r1.getId()
            if (r1 != 0) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            java.lang.String r2 = r1.toString()
        L_0x0090:
            r3.hw_shop_aggregate_teacher_show(r4, r2)
            goto L_0x00f0
        L_0x0094:
            boolean r3 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode
            if (r3 == 0) goto L_0x00ae
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r2 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r3 = r5.this$0
            int r3 = r3.mPageId
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode r1 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode) r1
            java.lang.String r1 = r1.getExamId()
            r2.hw_shop_aggregate_test_show(r3, r1)
            goto L_0x00f0
        L_0x00ae:
            boolean r3 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData
            if (r3 == 0) goto L_0x00d3
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r4 = r5.this$0
            int r4 = r4.mPageId
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData r1 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData) r1
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r1 = r1.getSpec()
            if (r1 != 0) goto L_0x00c7
            goto L_0x00cf
        L_0x00c7:
            int r1 = r1.getClazzId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x00cf:
            r3.hw_shop_aggregate_class_show(r4, r2)
            goto L_0x00f0
        L_0x00d3:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml
            if (r2 == 0) goto L_0x00f0
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r2 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r3 = r5.this$0
            int r3 = r3.mPageId
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml r1 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHtml) r1
            java.lang.String r4 = r1.getMLocalComponentType()
            java.lang.String r1 = r1.getMLocalComponentID()
            r2.hw_shop_aggregate_detail_show(r3, r4, r1)
        L_0x00f0:
            if (r0 != r7) goto L_0x00f3
            goto L_0x00f6
        L_0x00f3:
            r0 = r6
            goto L_0x0059
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity$initAdapter$2.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
    }
}
