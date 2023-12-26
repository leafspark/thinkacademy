package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.gradeaggregate;

import android.widget.ImageView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateEnum;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.utils.XesDisplayUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/gradeaggregate/GradeAggregateTeacherItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "itemViewType", "", "layoutId", "(II)V", "getItemViewType", "()I", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateTeacherItemProvider.kt */
public final class GradeAggregateTeacherItemProvider extends BaseNodeProvider {
    private final int itemViewType;
    private final int layoutId;

    public GradeAggregateTeacherItemProvider() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GradeAggregateTeacherItemProvider(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? GradeAggregateEnum.TEACHERLIST.getValue() : i, (i3 & 2) != 0 ? R.layout.bus_shop_grade_aggregate_item_teacher : i2);
    }

    public int getItemViewType() {
        return this.itemViewType;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public GradeAggregateTeacherItemProvider(int i, int i2) {
        this.itemViewType = i;
        this.layoutId = i2;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof GradeAggregateTeacherNode) {
            GradeAggregateTeacherNode gradeAggregateTeacherNode = (GradeAggregateTeacherNode) baseNode;
            XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder.getView(R.id.teacher_icon), getContext(), gradeAggregateTeacherNode.getAvatar(), 1, getContext().getColor(R.color.color_e3e5e9), R.drawable.circle_user_default_image, false);
            baseViewHolder.setText(R.id.teacher_name, gradeAggregateTeacherNode.getName());
            baseViewHolder.setText(R.id.teacher_desc, gradeAggregateTeacherNode.getEducation());
            RoundLinearLayout view = baseViewHolder.getView(R.id.rlBg);
            if (Intrinsics.areEqual((Object) gradeAggregateTeacherNode.isTop(), (Object) true)) {
                view.getDelegate().setCornerRadius_TL(XesDisplayUtil.dp2px(10.0f));
                view.getDelegate().setCornerRadius_TR(XesDisplayUtil.dp2px(10.0f));
            } else {
                view.getDelegate().setCornerRadius_TL(XesDisplayUtil.dp2px(0.0f));
                view.getDelegate().setCornerRadius_TR(XesDisplayUtil.dp2px(0.0f));
            }
            if (Intrinsics.areEqual((Object) gradeAggregateTeacherNode.isBottom(), (Object) true)) {
                view.getDelegate().setCornerRadius_BL(XesDisplayUtil.dp2px(10.0f));
                view.getDelegate().setCornerRadius_BR(XesDisplayUtil.dp2px(10.0f));
                return;
            }
            view.getDelegate().setCornerRadius_BL(XesDisplayUtil.dp2px(0.0f));
            view.getDelegate().setCornerRadius_BR(XesDisplayUtil.dp2px(0.0f));
        }
    }
}
