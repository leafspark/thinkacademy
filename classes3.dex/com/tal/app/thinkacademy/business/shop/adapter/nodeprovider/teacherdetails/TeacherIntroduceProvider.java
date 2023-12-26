package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails;

import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.TeacherDeatilsEnum;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherIntroduceNode;
import com.tal.app.thinkacademy.business.shop.widget.view.AutoLineFeedLayout;
import com.tal.app.thinkacademy.business.shop.widget.view.TeacherLabelView;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/teacherdetails/TeacherIntroduceProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "itemViewType", "", "layoutId", "(II)V", "getItemViewType", "()I", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherIntroduceProvider.kt */
public final class TeacherIntroduceProvider extends BaseNodeProvider {
    private final int itemViewType;
    private final int layoutId;

    public TeacherIntroduceProvider() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TeacherIntroduceProvider(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TeacherDeatilsEnum.TEACHERINTRODUCE.getValue() : i, (i3 & 2) != 0 ? R.layout.bus_shop_teacher_details_item_introduce : i2);
    }

    public int getItemViewType() {
        return this.itemViewType;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public TeacherIntroduceProvider(int i, int i2) {
        this.itemViewType = i;
        this.layoutId = i2;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof TeacherIntroduceNode) {
            TeacherIntroduceNode teacherIntroduceNode = (TeacherIntroduceNode) baseNode;
            ((TextView) baseViewHolder.getView(R.id.tvIntroduce)).setText(teacherIntroduceNode.getExperience());
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ivTeacher), getContext(), teacherIntroduceNode.getAvatar(), SizeUtils.dp2px(35.0f), 0, R.drawable.icon_think_launch, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
            ((TextView) baseViewHolder.getView(R.id.tvTeacherName)).setText(teacherIntroduceNode.getName());
            CharSequence education = teacherIntroduceNode.getEducation();
            boolean z = true;
            if (education == null || StringsKt.isBlank(education)) {
                ((TextView) baseViewHolder.getView(R.id.tvTeacherUni)).setVisibility(8);
            } else {
                ((TextView) baseViewHolder.getView(R.id.tvTeacherUni)).setText(teacherIntroduceNode.getEducation());
                ((TextView) baseViewHolder.getView(R.id.tvTeacherUni)).setVisibility(0);
            }
            View view = baseViewHolder.getView(R.id.autoLineFeedLayout);
            Collection highlightList = teacherIntroduceNode.getHighlightList();
            if (highlightList != null && !highlightList.isEmpty()) {
                z = false;
            }
            if (z) {
                ((AutoLineFeedLayout) view).setVisibility(8);
                return;
            }
            List<String> highlightList2 = teacherIntroduceNode.getHighlightList();
            if (highlightList2 != null) {
                for (String text : highlightList2) {
                    TeacherLabelView teacherLabelView = new TeacherLabelView(getContext(), (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                    teacherLabelView.setText(text);
                    ((AutoLineFeedLayout) view).addView(teacherLabelView);
                }
            }
            ((AutoLineFeedLayout) view).setVisibility(0);
        }
    }
}
