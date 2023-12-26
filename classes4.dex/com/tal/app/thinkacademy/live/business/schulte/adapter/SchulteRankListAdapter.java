package com.tal.app.thinkacademy.live.business.schulte.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableRankListUserDataBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/adapter/SchulteRankListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableRankListUserDataBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteRankListAdapter.kt */
public final class SchulteRankListAdapter extends BaseQuickAdapter<SchulteTableRankListUserDataBean, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SchulteRankListAdapter(List<SchulteTableRankListUserDataBean> list) {
        super(R.layout.item_schulte_table_rank_normall, list);
        Intrinsics.checkNotNullParameter(list, "data");
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, SchulteTableRankListUserDataBean schulteTableRankListUserDataBean) {
        BaseViewHolder baseViewHolder2;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(schulteTableRankListUserDataBean, "item");
        int i = R.id.rank_number;
        StringBuilder sb = new StringBuilder();
        sb.append(getItemPosition(schulteTableRankListUserDataBean) + 4);
        sb.append('.');
        baseViewHolder.setText(i, sb.toString());
        String nickName = schulteTableRankListUserDataBean.getNickName();
        if (nickName != null) {
            baseViewHolder.setText(R.id.rank_name, nickName);
        }
        String duration = schulteTableRankListUserDataBean.getDuration();
        if (duration != null) {
            baseViewHolder.setText(R.id.rank_score, Intrinsics.stringPlus(duration, "s"));
        }
        String coin = schulteTableRankListUserDataBean.getCoin();
        if (coin == null) {
            baseViewHolder2 = null;
        } else {
            baseViewHolder2 = baseViewHolder.setText(R.id.rank_coins, Intrinsics.stringPlus("+", coin));
        }
        if (baseViewHolder2 == null) {
            SchulteRankListAdapter schulteRankListAdapter = this;
            baseViewHolder.setVisible(R.id.rank_coins, false);
        }
        String avatar = schulteTableRankListUserDataBean.getAvatar();
        if (avatar != null) {
            ImageLoaderJ.loadCircle(getContext(), avatar, (ImageView) baseViewHolder.getView(R.id.rank_head), R.drawable.icon_default_user);
        }
    }
}
