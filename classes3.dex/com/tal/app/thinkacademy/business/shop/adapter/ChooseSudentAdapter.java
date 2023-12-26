package com.tal.app.thinkacademy.business.shop.adapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.login.entity.UserAccount;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.common.utils.TextUtil;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/ChooseSudentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseSudentAdapter.kt */
public final class ChooseSudentAdapter extends BaseQuickAdapter<UserAccount, BaseViewHolder> {
    public ChooseSudentAdapter(List<UserAccount> list) {
        super(R.layout.bus_shop_choose_student_item, list);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, UserAccount userAccount) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(userAccount, "item");
        XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ivAvatar), getContext(), userAccount.getAvatar(), SizeUtils.dp2px(48.0f), 0, R.drawable.icon_think_launch, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvName);
        textView.setText(userAccount.getNickName());
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tvId);
        textView2.setText(Intrinsics.stringPlus(getContext().getString(R.string.no_with_dot), TextUtil.addBlankInText$default(TextUtil.INSTANCE, userAccount.getCard(), 0, 2, (Object) null)));
        if (Intrinsics.areEqual((Object) userAccount.isSeleted(), (Object) true)) {
            ((LinearLayout) baseViewHolder.getView(R.id.llBg)).setBackgroundResource(R.drawable.bug_shop_choose_student_item_bg_seleted);
            textView.setSelected(true);
            textView2.setSelected(true);
            ((ImageView) baseViewHolder.getView(R.id.ivSeleted)).setVisibility(0);
            return;
        }
        ((LinearLayout) baseViewHolder.getView(R.id.llBg)).setBackgroundResource(R.drawable.bug_shop_choose_student_item_bg_normal);
        textView.setSelected(false);
        textView2.setSelected(false);
        ((ImageView) baseViewHolder.getView(R.id.ivSeleted)).setVisibility(8);
    }
}
