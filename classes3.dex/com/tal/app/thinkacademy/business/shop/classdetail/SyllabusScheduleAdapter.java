package com.tal.app.thinkacademy.business.shop.classdetail;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/SyllabusScheduleAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSyllabu;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SyllabusScheduleAdapter.kt */
public final class SyllabusScheduleAdapter extends BaseQuickAdapter<ShopClassDetailSyllabu, BaseViewHolder> {
    public SyllabusScheduleAdapter() {
        super(R.layout.syllabus_schedule_activity_list_item, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r11, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu r12) {
        /*
            r10 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            int r0 = r11.getLayoutPosition()
            java.util.List r1 = r10.getData()
            int r1 = r1.size()
            boolean r2 = r10.hasHeaderLayout()
            if (r2 == 0) goto L_0x001e
            int r0 = r0 + -1
        L_0x001e:
            int r2 = com.tal.app.thinkacademy.business.shop.R.color.color_ffffff
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x0027
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_top_radius_10
            goto L_0x0036
        L_0x0027:
            java.util.List r5 = r10.getData()
            int r5 = r5.size()
            int r5 = r5 - r4
            if (r0 != r5) goto L_0x0036
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_bottom_radius_10
            r5 = r3
            goto L_0x0037
        L_0x0036:
            r5 = r4
        L_0x0037:
            if (r1 != r4) goto L_0x003c
            int r2 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_class_ffffff_radius10
            r5 = r3
        L_0x003c:
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.schedule_name
            android.view.View r1 = r11.getView(r1)
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r1 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r1
            java.lang.String r6 = r12.getName()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            int r0 = r0 + r4
            int r7 = r12.isStarted()
            r8 = 10
            java.lang.String r9 = "format(format, *args)"
            if (r7 != 0) goto L_0x00aa
            r7 = 2
            if (r0 >= r8) goto L_0x0086
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r8 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8[r3] = r0
            android.content.Context r0 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.shop_course_started
            java.lang.String r0 = r0.getString(r3)
            r8[r4] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r8, r7)
            java.lang.String r3 = "0%s %s"
            java.lang.String r0 = java.lang.String.format(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
            goto L_0x00db
        L_0x0086:
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r8 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8[r3] = r0
            android.content.Context r0 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.string.shop_course_started
            java.lang.String r0 = r0.getString(r3)
            r8[r4] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r8, r7)
            java.lang.String r3 = "%s %s"
            java.lang.String r0 = java.lang.String.format(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
            goto L_0x00db
        L_0x00aa:
            if (r0 >= r8) goto L_0x00c4
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7[r3] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r4)
            java.lang.String r3 = "0%s"
            java.lang.String r0 = java.lang.String.format(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
            goto L_0x00db
        L_0x00c4:
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7[r3] = r0
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r4)
            java.lang.String r3 = "%s"
            java.lang.String r0 = java.lang.String.format(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
        L_0x00db:
            r6.add(r0)
            android.graphics.Rect r0 = new android.graphics.Rect
            r3 = 1084227584(0x40a00000, float:5.0)
            int r4 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r7 = 1077936128(0x40400000, float:3.0)
            int r8 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r7)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            int r7 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r7)
            r0.<init>(r4, r8, r3, r7)
            r1.setTagPadding(r0)
            int r0 = r12.isStarted()
            if (r0 != 0) goto L_0x0120
            android.content.Context r0 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r0 = r0.getColor(r3)
            r1.setTextColor(r0)
            android.content.Context r0 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_a2aab8
            int r0 = r0.getColor(r3)
            r1.setTagTextColor(r0)
            int r0 = com.tal.app.thinkacademy.business.shop.R.drawable.bg_f4f6fa_11_corners
            r1.setTagBackgroundStyle(r0)
            goto L_0x013f
        L_0x0120:
            android.content.Context r0 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_172b4d
            int r0 = r0.getColor(r3)
            r1.setTextColor(r0)
            android.content.Context r0 = r10.getContext()
            int r3 = com.tal.app.thinkacademy.business.shop.R.color.color_ff850a
            int r0 = r0.getColor(r3)
            r1.setTagTextColor(r0)
            int r0 = com.tal.app.thinkacademy.business.shop.R.drawable.bg_fff3dc_11_corners
            r1.setTagBackgroundStyle(r0)
        L_0x013f:
            java.lang.String r0 = r12.getName()
            r1.setTagStart(r6, r0)
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.bottom_line
            r11.setVisible(r0, r5)
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.schedule_date_desc
            java.lang.String r12 = r12.getTimeDesc()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r0, r12)
            int r12 = com.tal.app.thinkacademy.business.shop.R.id.schedule_root_layout
            r11.setBackgroundResource(r12, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.SyllabusScheduleAdapter.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu):void");
    }
}
