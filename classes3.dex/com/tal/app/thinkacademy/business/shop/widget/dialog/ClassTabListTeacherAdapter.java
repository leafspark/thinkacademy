package com.tal.app.thinkacademy.business.shop.widget.dialog;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassTabListTeacherAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mSelectedId", "", "convert", "", "holder", "item", "setSelectedId", "", "id", "reset", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterAdapter.kt */
final class ClassTabListTeacherAdapter extends BaseQuickAdapter<ShopClassTeacherData, BaseViewHolder> {
    private String mSelectedId;

    public ClassTabListTeacherAdapter() {
        super(R.layout.item_shop_class_filter_teacher, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, ShopClassTeacherData shopClassTeacherData) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(shopClassTeacherData, "item");
        XesImageLoader.loadCircleWithBorderImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.iv_teacher_avatar), getContext(), shopClassTeacherData.getAvatar(), SizeUtils.dp2px(1.0f), getContext().getColor(R.color.color_DEE2E7), 0, true, 16, (Object) null);
        StateTextView stateTextView = (StateTextView) baseViewHolder.getView(R.id.tv_teacher_name);
        stateTextView.setText(shopClassTeacherData.getSysName());
        StateTextView stateTextView2 = (StateTextView) baseViewHolder.getView(R.id.tv_teacher_school);
        stateTextView2.setText(shopClassTeacherData.getEducation());
        boolean areEqual = Intrinsics.areEqual((Object) this.mSelectedId, (Object) String.valueOf(shopClassTeacherData.getTeacherId()));
        ((StateTextView) baseViewHolder.getView(R.id.bg_teacher_item)).setHasData(areEqual);
        stateTextView.setHasData(areEqual);
        stateTextView2.setHasData(areEqual);
    }

    public static /* synthetic */ boolean setSelectedId$default(ClassTabListTeacherAdapter classTabListTeacherAdapter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return classTabListTeacherAdapter.setSelectedId(str, z);
    }

    public final boolean setSelectedId(String str, boolean z) {
        if (!z && Intrinsics.areEqual((Object) this.mSelectedId, (Object) str)) {
            str = null;
        }
        this.mSelectedId = str;
        CharSequence charSequence = str;
        return !(charSequence == null || charSequence.length() == 0);
    }
}
