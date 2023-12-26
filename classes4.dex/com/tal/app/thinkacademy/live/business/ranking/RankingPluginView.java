package com.tal.app.thinkacademy.live.business.ranking;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/ranking/RankingPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tal/app/thinkacademy/live/business/ranking/RankingAdapter;", "iv_ranking_list_close", "Landroid/widget/ImageView;", "mRankingBean", "", "Lcom/tal/app/thinkacademy/live/business/ranking/RankingBean;", "rv_ranking_list_user", "Landroidx/recyclerview/widget/RecyclerView;", "getLayoutId", "", "initViews", "", "setCloseClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "setRankingListData", "rankingList", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RankingPluginView.kt */
public final class RankingPluginView extends BaseLivePluginView {
    private RankingAdapter adapter;
    private ImageView iv_ranking_list_close;
    private List<RankingBean> mRankingBean;
    private RecyclerView rv_ranking_list_user;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RankingPluginView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public int getLayoutId() {
        return R.layout.live_business_ranking_list_view;
    }

    public final void setRankingListData(List<RankingBean> list) {
        this.mRankingBean = list;
        RecyclerView.Adapter rankingAdapter = new RankingAdapter(getContext(), this.mRankingBean);
        this.adapter = rankingAdapter;
        RecyclerView recyclerView = this.rv_ranking_list_user;
        if (recyclerView != null) {
            recyclerView.setAdapter(rankingAdapter);
        }
    }

    public final void setCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.iv_ranking_list_close;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void initViews() {
        RankingPluginView.super.initViews();
        this.iv_ranking_list_close = (ImageView) findViewById(R.id.iv_ranking_list_close);
        RecyclerView findViewById = findViewById(R.id.rv_ranking_list_user);
        this.rv_ranking_list_user = findViewById;
        if (findViewById != null) {
            findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        if (PadUtils.isPad(this.mContext)) {
            ViewScaleUtil.scale(getRootView(), 1.5f);
        }
    }
}
