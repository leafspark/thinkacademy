package com.tal.app.thinkacademy.business.shop.classdetail;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/SuitableForAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailItemCommon;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuitableForAdapter.kt */
public final class SuitableForAdapter extends BaseMultiItemQuickAdapter<ShopClassDetailItemCommon, BaseViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ITEM_TYPE_HEAD_DESC = 1;
    public static final int ITEM_TYPE_PIC = 3;
    public static final int ITEM_TYPE_TITLE_CARD = 2;

    public SuitableForAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addItemType(1, R.layout.item_shop_suitable_head_describle);
        addItemType(2, R.layout.item_shop_suitable_title_card);
        addItemType(3, R.layout.item_shop_suitable_pic_card);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/SuitableForAdapter$Companion;", "", "()V", "ITEM_TYPE_HEAD_DESC", "", "ITEM_TYPE_PIC", "ITEM_TYPE_TITLE_CARD", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SuitableForAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r28, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon r29) {
        /*
            r27 = this;
            r0 = r28
            java.lang.String r1 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "item"
            r2 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            int r1 = r29.getItemType()
            r3 = 1
            r4 = 0
            if (r1 == r3) goto L_0x010d
            r3 = 2
            if (r1 == r3) goto L_0x00ed
            r3 = 3
            if (r1 == r3) goto L_0x001e
            goto L_0x0145
        L_0x001e:
            java.lang.Object r1 = r29.getData()
            boolean r1 = r1 instanceof java.lang.String
            if (r1 == 0) goto L_0x0145
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r1 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.ALL
            int r3 = r29.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r5 = r5.getType()
            r6 = 1090519040(0x41000000, float:8.0)
            r7 = 1092616192(0x41200000, float:10.0)
            if (r3 != r5) goto L_0x0045
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r7)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r5 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.TOP
        L_0x0042:
            r16 = r5
            goto L_0x006e
        L_0x0045:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Last
            int r5 = r5.getType()
            if (r3 != r5) goto L_0x0057
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r7)
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r3 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.BOTTOM
            r16 = r3
            r3 = r4
            goto L_0x006e
        L_0x0057:
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r5 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.ONLY_ONE
            int r5 = r5.getType()
            if (r3 != r5) goto L_0x006a
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r7)
            com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation$CornerType r5 = com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation.CornerType.ALL
            goto L_0x0042
        L_0x006a:
            r16 = r1
            r1 = r4
            r3 = r1
        L_0x006e:
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.suitable_pic_item_root
            android.view.View r5 = r0.getView(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r5.setPadding(r4, r3, r4, r4)
            r3 = 1107296256(0x42000000, float:32.0)
            if (r1 != 0) goto L_0x00b8
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r17 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.pic_view
            android.view.View r0 = r0.getView(r1)
            r18 = r0
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            android.content.Context r0 = r27.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            int r19 = r0 - r1
            android.content.Context r20 = r27.getContext()
            java.lang.Object r0 = r29.getData()
            r21 = r0
            java.lang.String r21 = (java.lang.String) r21
            int r22 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_default_course_info_image
            r23 = 0
            r24 = 0
            r25 = 48
            r26 = 0
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.loadImageAutoHeight$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0145
        L_0x00b8:
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r8 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.pic_view
            android.view.View r0 = r0.getView(r1)
            r9 = r0
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            android.content.Context r0 = r27.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.widthPixels
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            int r10 = r0 - r1
            android.content.Context r11 = r27.getContext()
            java.lang.Object r0 = r29.getData()
            r12 = r0
            java.lang.String r12 = (java.lang.String) r12
            int r13 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r7)
            r14 = 0
            int r15 = com.tal.app.thinkacademy.business.shop.R.drawable.bus_shop_default_course_info_image
            r8.loadRoundCornerImageAutoHeight(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0145
        L_0x00ed:
            java.lang.Object r1 = r29.getData()
            boolean r1 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlacement
            if (r1 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.title_txt
            android.view.View r0 = r0.getView(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.Object r1 = r29.getData()
            com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlacement r1 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailPlacement) r1
            java.lang.String r1 = r1.getDescribe()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x0145
        L_0x010d:
            java.lang.Object r1 = r29.getData()
            boolean r1 = r1 instanceof java.lang.String
            if (r1 == 0) goto L_0x0126
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.title_description
            android.view.View r1 = r0.getView(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.Object r3 = r29.getData()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x0126:
            int r1 = r29.getLocal_position_type()
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r2 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.First
            int r2 = r2.getType()
            if (r1 != r2) goto L_0x0139
            r1 = 1098907648(0x41800000, float:16.0)
            int r1 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r1)
            goto L_0x013a
        L_0x0139:
            r1 = r4
        L_0x013a:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.head_desc_root
            android.view.View r0 = r0.getView(r2)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r0.setPadding(r4, r1, r4, r4)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.SuitableForAdapter.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailItemCommon):void");
    }
}
