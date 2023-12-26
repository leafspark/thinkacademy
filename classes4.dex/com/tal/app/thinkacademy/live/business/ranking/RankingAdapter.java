package com.tal.app.thinkacademy.live.business.ranking;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.live.business.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/ranking/RankingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/ranking/RankingBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "convert", "", "holder", "item", "getDefItemCount", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RankingAdapter.kt */
public final class RankingAdapter extends BaseQuickAdapter<RankingBean, BaseViewHolder> {
    public RankingAdapter(Context context, List<RankingBean> list) {
        super(R.layout.live_business_item_ranking_list_layout, list);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, RankingBean rankingBean) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(rankingBean, "item");
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (StringsKt.equals$default(userInfoEntity == null ? null : userInfoEntity.getUid(), String.valueOf(rankingBean.getId()), false, 2, (Object) null)) {
            baseViewHolder.setVisible(R.id.iv_ranking_list_wow, true);
            baseViewHolder.setTextColor(R.id.ranking_list_name, ContextCompat.getColor(getContext(), R.color.COLOR_FF850A));
            baseViewHolder.setBackgroundResource(R.id.ranking_list_layout, R.drawable.bg_live_business_ranking_list_item_self);
        } else {
            baseViewHolder.setVisible(R.id.iv_ranking_list_wow, false);
            baseViewHolder.setTextColor(R.id.ranking_list_name, ContextCompat.getColor(getContext(), R.color.COLOR_172B4D));
            baseViewHolder.setBackgroundResource(R.id.ranking_list_layout, R.drawable.bg_live_business_ranking_list_item);
        }
        baseViewHolder.setText(R.id.ranking_list_name, rankingBean.getName());
        Integer coin = rankingBean.getCoin();
        if (coin != null) {
            baseViewHolder.setText(R.id.ranking_list_coins, String.valueOf(coin.intValue()));
        }
        Integer level = rankingBean.getLevel();
        int code = LevelState.LevelOne.getCode();
        if (level != null && level.intValue() == code) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelOne.getLevelBadge());
            return;
        }
        int code2 = LevelState.LevelTwo.getCode();
        if (level != null && level.intValue() == code2) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelTwo.getLevelBadge());
            return;
        }
        int code3 = LevelState.LevelThree.getCode();
        if (level != null && level.intValue() == code3) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelThree.getLevelBadge());
            return;
        }
        int code4 = LevelState.LevelFour.getCode();
        if (level != null && level.intValue() == code4) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelFour.getLevelBadge());
            return;
        }
        int code5 = LevelState.LevelFive.getCode();
        if (level != null && level.intValue() == code5) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelFive.getLevelBadge());
            return;
        }
        int code6 = LevelState.LevelSix.getCode();
        if (level != null && level.intValue() == code6) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelSix.getLevelBadge());
            return;
        }
        int code7 = LevelState.LevelSeven.getCode();
        if (level != null && level.intValue() == code7) {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelSeven.getLevelBadge());
        } else {
            baseViewHolder.setImageDrawable(R.id.ranking_list_badge, LevelState.LevelZero.getLevelBadge());
        }
    }

    /* access modifiers changed from: protected */
    public int getDefItemCount() {
        if (getData().size() > 5) {
            return 5;
        }
        return getData().size();
    }
}
