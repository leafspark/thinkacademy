package com.tal.app.thinkacademy.business.shop;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/shop/TeacherDetailsActivity$initAdapter$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDetailsActivity.kt */
public final class TeacherDetailsActivity$initAdapter$4 extends RecyclerView.OnScrollListener {
    final /* synthetic */ TeacherDetailsActivity this$0;

    TeacherDetailsActivity$initAdapter$4(TeacherDetailsActivity teacherDetailsActivity) {
        this.this$0 = teacherDetailsActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r6 = r6.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity$initAdapter$4.super.onScrollStateChanged(r6, r7)
            if (r7 != 0) goto L_0x00b4
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r6 = r5.this$0
            com.tal.app.thinkacademy.business.shop.adapter.TeacherDeatilsAdapter r6 = r6.mTeacherDeatilsAdapter
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
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r0 = r5.this$0
            androidx.recyclerview.widget.LinearLayoutManager r0 = r0.mLinearLayoutManager
            if (r0 != 0) goto L_0x002a
            r0 = r7
            goto L_0x002e
        L_0x002a:
            int r0 = r0.findFirstVisibleItemPosition()
        L_0x002e:
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r1 = r5.this$0
            androidx.recyclerview.widget.LinearLayoutManager r1 = r1.mLinearLayoutManager
            if (r1 != 0) goto L_0x0037
            goto L_0x003b
        L_0x0037:
            int r7 = r1.findLastVisibleItemPosition()
        L_0x003b:
            int r6 = r6 + -1
            if (r7 <= r6) goto L_0x0040
            r7 = r6
        L_0x0040:
            if (r0 > r7) goto L_0x00b4
        L_0x0042:
            int r6 = r0 + 1
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r1 = r5.this$0
            com.tal.app.thinkacademy.business.shop.adapter.TeacherDeatilsAdapter r1 = r1.mTeacherDeatilsAdapter
            if (r1 != 0) goto L_0x004e
            r1 = 0
            goto L_0x0054
        L_0x004e:
            java.lang.Object r1 = r1.getItem(r0)
            com.chad.library.adapter.base.entity.node.BaseNode r1 = (com.chad.library.adapter.base.entity.node.BaseNode) r1
        L_0x0054:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData
            if (r2 == 0) goto L_0x007c
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r2 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r3 = r5.this$0
            int r3 = r3.mTeacherId
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r4 = r5.this$0
            java.lang.String r4 = r4.mTeacherName
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData r1 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData) r1
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r1 = r1.getSpec()
            if (r1 != 0) goto L_0x0074
            r1 = -1
            goto L_0x0078
        L_0x0074:
            int r1 = r1.getClazzId()
        L_0x0078:
            r2.hw_shop_teacher_classes_show(r3, r4, r1)
            goto L_0x00af
        L_0x007c:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherIngachievemNode
            if (r2 == 0) goto L_0x0096
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r1 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r2 = r5.this$0
            int r2 = r2.mTeacherId
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r3 = r5.this$0
            java.lang.String r3 = r3.mTeacherName
            r1.hw_shop_teacher_achievements_show(r2, r3)
            goto L_0x00af
        L_0x0096:
            boolean r1 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherVideoNode
            if (r1 == 0) goto L_0x00af
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r1 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r2 = r5.this$0
            int r2 = r2.mTeacherId
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity r3 = r5.this$0
            java.lang.String r3 = r3.mTeacherName
            r1.hw_shop_teacher_video_show(r2, r3)
        L_0x00af:
            if (r0 != r7) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r0 = r6
            goto L_0x0042
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.TeacherDetailsActivity$initAdapter$4.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
    }
}
