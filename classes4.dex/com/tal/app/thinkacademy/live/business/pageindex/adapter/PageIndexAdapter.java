package com.tal.app.thinkacademy.live.business.pageindex.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import com.tal.app.thinkacademy.live.business.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/pageindex/adapter/PageIndexAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mSelectedPosition", "", "convert", "", "holder", "item", "setSelectedIndex", "index", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageIndexAdapter.kt */
public final class PageIndexAdapter extends BaseQuickAdapter<PageIndexData, BaseViewHolder> {
    private int mSelectedPosition = -1;

    public PageIndexAdapter() {
        super(R.layout.item_playback_page_index, (List) null);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, PageIndexData pageIndexData) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(pageIndexData, "item");
        int itemPosition = getItemPosition(pageIndexData);
        XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ItemImage), getContext(), pageIndexData.getImgUrl(), SizeUtils.dp2px(4.0f), 0, R.drawable.ic_live_business_playback_page_index_holder, (RoundedCornersTransformation.CornerType) null, 32, (Object) null);
        baseViewHolder.setVisible(R.id.ItemSelectedTag, this.mSelectedPosition == itemPosition);
    }

    public final void setSelectedIndex(int i) {
        if (this.mSelectedPosition != i) {
            this.mSelectedPosition = i;
            notifyDataSetChanged();
        }
    }
}
