package com.tal.app.thinkacademy.business.login.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.entity.UserAccount;
import com.tal.app.thinkacademy.common.utils.TextUtil;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.utils.XesDisplayUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J8\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/AccountAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "setLayoutCorner", "layout", "Lcom/flyco/roundview/RoundLinearLayout;", "tl", "", "tr", "bl", "br", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountAdapter.kt */
public final class AccountAdapter extends BaseQuickAdapter<UserAccount, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountAdapter(List<UserAccount> list) {
        super(R.layout.item_user_account, list);
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, UserAccount userAccount) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(userAccount, "item");
        RoundLinearLayout view = baseViewHolder.getView(R.id.item_layout_content);
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (getData().size() == 1) {
            setLayoutCorner(view, 10.0f, 10.0f, 10.0f, 10.0f);
        } else if (bindingAdapterPosition == 0) {
            setLayoutCorner$default(this, view, 10.0f, 10.0f, 0.0f, 0.0f, 24, (Object) null);
        } else if (bindingAdapterPosition == getData().size() - 1) {
            setLayoutCorner$default(this, view, 0.0f, 0.0f, 10.0f, 10.0f, 6, (Object) null);
        } else {
            setLayoutCorner$default(this, view, 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
        }
        XesImageLoader.loadCircleWithBorderImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.item_iv_avatar), getContext(), userAccount.getAvatar(), 2, getContext().getColor(R.color.color_f4f6fa), R.drawable.self_image_user, false, 32, (Object) null);
        baseViewHolder.setText(R.id.item_tv_nickname, userAccount.getNickName());
        baseViewHolder.setText(R.id.item_tv_card, Intrinsics.stringPlus(getContext().getString(R.string.no_with_dot), TextUtil.addBlankInText$default(TextUtil.INSTANCE, userAccount.getCard(), 0, 2, (Object) null)));
    }

    static /* synthetic */ void setLayoutCorner$default(AccountAdapter accountAdapter, RoundLinearLayout roundLinearLayout, float f, float f2, float f3, float f4, int i, Object obj) {
        accountAdapter.setLayoutCorner(roundLinearLayout, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? 0.0f : f3, (i & 16) != 0 ? 0.0f : f4);
    }

    private final void setLayoutCorner(RoundLinearLayout roundLinearLayout, float f, float f2, float f3, float f4) {
        roundLinearLayout.getDelegate().setCornerRadius_TL(XesDisplayUtil.dp2px(f));
        roundLinearLayout.getDelegate().setCornerRadius_TR(XesDisplayUtil.dp2px(f2));
        roundLinearLayout.getDelegate().setCornerRadius_BL(XesDisplayUtil.dp2px(f3));
        roundLinearLayout.getDelegate().setCornerRadius_BR(XesDisplayUtil.dp2px(f4));
    }
}
