package com.tal.app.thinkacademy.live.business.direction;

import android.content.Context;
import android.widget.TextView;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/direction/UsersBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "context", "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/util/List;)V", "convert", "", "holder", "item", "getDefItemCount", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionGoldAdapter.kt */
public final class DirectionGoldAdapter extends BaseQuickAdapter<UsersBean, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DirectionGoldAdapter(Context context, List<UsersBean> list) {
        super(R.layout.live_business_item_direction_gold_layout, list);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, UsersBean usersBean) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(usersBean, "item");
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (StringsKt.equals$default(userInfoEntity == null ? null : userInfoEntity.getUid(), String.valueOf(usersBean.getUserId()), false, 2, (Object) null)) {
            ((TextView) baseViewHolder.getView(R.id.tv_direction_gold_name)).setTextSize(1, 18.0f);
            baseViewHolder.setTextColor(R.id.tv_direction_gold_name, ContextCompat.getColor(getContext(), R.color.COLOR_FF850A));
            baseViewHolder.setVisible(R.id.iv_direction_gold_underline, true);
            baseViewHolder.setVisible(R.id.iv_direction_gold_wow, true);
        } else {
            ((TextView) baseViewHolder.getView(R.id.tv_direction_gold_name)).setTextSize(1, 16.0f);
            baseViewHolder.setTextColor(R.id.tv_direction_gold_name, ContextCompat.getColor(getContext(), R.color.COLOR_02CA8A));
            baseViewHolder.setVisible(R.id.iv_direction_gold_underline, false);
            baseViewHolder.setVisible(R.id.iv_direction_gold_wow, false);
        }
        baseViewHolder.setText(R.id.tv_direction_gold_name, usersBean.getNickName());
    }

    /* access modifiers changed from: protected */
    public int getDefItemCount() {
        if (getData().size() > 10) {
            return 10;
        }
        return getData().size();
    }
}
