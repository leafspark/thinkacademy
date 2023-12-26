package com.tal.app.thinkacademy.live.business.gift.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.gift.bean.GiftBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/gift/adapter/GiftAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/gift/bean/GiftBean$GiftListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "changeSelectIndexState", "", "preSelectIndex", "", "selectedIndex", "convert", "holder", "item", "getDefItemCount", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GiftAdapter.kt */
public final class GiftAdapter extends BaseQuickAdapter<GiftBean.GiftListBean, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GiftAdapter(Context context, List<GiftBean.GiftListBean> list) {
        super(R.layout.item_live_business_gift, list);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, GiftBean.GiftListBean giftListBean) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(giftListBean, "item");
        ImageLoaderJ.loadCenterInside(getContext(), giftListBean.getIconApp(), (ImageView) baseViewHolder.getView(R.id.iv_live_business_gift), 0);
        baseViewHolder.setText(R.id.tv_live_business_gift_name, giftListBean.getGiftName());
        baseViewHolder.setText(R.id.tv_live_business_gift_coin, String.valueOf(giftListBean.getCoin()));
        baseViewHolder.itemView.setSelected(giftListBean.isSelect());
    }

    /* access modifiers changed from: protected */
    public int getDefItemCount() {
        return getData().size();
    }

    public final void changeSelectIndexState(int i, int i2) {
        if (i != -1) {
            ((GiftBean.GiftListBean) getData().get(i)).setSelect(false);
        }
        ((GiftBean.GiftListBean) getData().get(i2)).setSelect(true);
    }
}
