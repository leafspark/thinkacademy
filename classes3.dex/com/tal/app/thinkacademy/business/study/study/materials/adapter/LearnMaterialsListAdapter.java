package com.tal.app.thinkacademy.business.study.study.materials.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.study.study.entity.Material;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.utils.XesDisplayUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014R\u001e\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/materials/adapter/LearnMaterialsListAdapter;", "Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/Material;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "listData", "", "listener", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "convert", "holder", "item", "convertHeader", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LearnMaterialsListAdapter.kt */
public final class LearnMaterialsListAdapter extends BaseSectionQuickAdapter<Material, BaseViewHolder> {
    private final Function1<Material, Unit> listener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LearnMaterialsListAdapter(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function1);
    }

    public LearnMaterialsListAdapter(List<Material> list, Function1<? super Material, Unit> function1) {
        super(R.layout.item_material_list_header, list);
        this.listener = function1;
        setNormalLayout(R.layout.item_material_list);
    }

    /* access modifiers changed from: protected */
    public void convertHeader(BaseViewHolder baseViewHolder, Material material) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(material, "item");
        baseViewHolder.setText(R.id.tvMaterialItemHeader, material.getHeaderTitle());
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, Material material) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(material, "item");
        XesImageLoader.loadImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ivMaterialsType), getContext(), material.getFileIcon(), R.drawable.icon_file_type_default, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
        ((TextView) baseViewHolder.getView(R.id.tvMaterialsTitle)).setText(material.getName());
        ((TextView) baseViewHolder.getView(R.id.tvMaterialsTime)).setText(material.getUploadTime());
        ((TextView) baseViewHolder.getView(R.id.tvMaterialsSize)).setText(material.getSize());
        RoundLinearLayout view = baseViewHolder.getView(R.id.llMaterialItem);
        if (Intrinsics.areEqual((Object) material.isTop(), (Object) true)) {
            view.getDelegate().setCornerRadius_TL(XesDisplayUtil.dp2px(10.0f));
            view.getDelegate().setCornerRadius_TR(XesDisplayUtil.dp2px(10.0f));
        } else {
            view.getDelegate().setCornerRadius_TL(XesDisplayUtil.dp2px(0.0f));
            view.getDelegate().setCornerRadius_TR(XesDisplayUtil.dp2px(0.0f));
        }
        if (Intrinsics.areEqual((Object) material.isBottom(), (Object) true)) {
            view.getDelegate().setCornerRadius_BL(XesDisplayUtil.dp2px(10.0f));
            view.getDelegate().setCornerRadius_BR(XesDisplayUtil.dp2px(10.0f));
            return;
        }
        view.getDelegate().setCornerRadius_BL(XesDisplayUtil.dp2px(0.0f));
        view.getDelegate().setCornerRadius_BR(XesDisplayUtil.dp2px(0.0f));
    }
}
