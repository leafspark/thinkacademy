package com.tal.app.thinkacademy.business.login.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.item.MyPageRecyclerItem;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B3\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/MeItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/view/item/MyPageRecyclerItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "listener", "Lkotlin/Function2;", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "convert", "holder", "item", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MeItemAdapter.kt */
public final class MeItemAdapter extends BaseQuickAdapter<MyPageRecyclerItem, BaseViewHolder> {
    /* access modifiers changed from: private */
    public Function2<? super MyPageRecyclerItem, ? super Integer, Unit> listener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MeItemAdapter(List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function2);
    }

    public MeItemAdapter(List<MyPageRecyclerItem> list, Function2<? super MyPageRecyclerItem, ? super Integer, Unit> function2) {
        super(R.layout.layout_item_view, list);
        this.listener = function2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, MyPageRecyclerItem myPageRecyclerItem) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(myPageRecyclerItem, "item");
        RoundRelativeLayout view = baseViewHolder.getView(R.id.rl_item);
        int local_round_type = myPageRecyclerItem.getLocal_round_type();
        if (local_round_type == 1) {
            int dp2px = SizeUtils.dp2px(10.0f);
            view.getDelegate().setCornerRadius_TL(dp2px);
            view.getDelegate().setCornerRadius_TR(dp2px);
            view.getDelegate().setCornerRadius_BL(0);
            view.getDelegate().setCornerRadius_BR(0);
        } else if (local_round_type == 2) {
            int dp2px2 = SizeUtils.dp2px(10.0f);
            view.getDelegate().setCornerRadius_TL(0);
            view.getDelegate().setCornerRadius_TR(0);
            view.getDelegate().setCornerRadius_BL(dp2px2);
            view.getDelegate().setCornerRadius_BR(dp2px2);
        } else if (local_round_type != 3) {
            view.getDelegate().setCornerRadius_TL(0);
            view.getDelegate().setCornerRadius_TR(0);
            view.getDelegate().setCornerRadius_BL(0);
            view.getDelegate().setCornerRadius_BR(0);
        } else {
            int dp2px3 = SizeUtils.dp2px(10.0f);
            view.getDelegate().setCornerRadius_TL(dp2px3);
            view.getDelegate().setCornerRadius_TR(dp2px3);
            view.getDelegate().setCornerRadius_BL(dp2px3);
            view.getDelegate().setCornerRadius_BR(dp2px3);
        }
        baseViewHolder.setImageResource(R.id.iv_icon, myPageRecyclerItem.getResId());
        baseViewHolder.setText(R.id.tv_detail, myPageRecyclerItem.getDetail());
        if (myPageRecyclerItem.getRightResId() != -1) {
            baseViewHolder.setImageResource(R.id.iv_right, myPageRecyclerItem.getRightResId());
        }
        baseViewHolder.setVisible(R.id.rl_right, myPageRecyclerItem.getRightResId() != -1);
        CharSequence tvRightContent = myPageRecyclerItem.getTvRightContent();
        if (!(tvRightContent == null || StringsKt.isBlank(tvRightContent))) {
            baseViewHolder.setVisible(R.id.tv_right_content, true);
            baseViewHolder.setText(R.id.tv_right_content, myPageRecyclerItem.getTvRightContent());
        } else {
            baseViewHolder.setVisible(R.id.tv_right_content, false);
        }
        RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(baseViewHolder.getView(R.id.rl_item), 800, new MeItemAdapter$convert$1(this, myPageRecyclerItem));
    }
}
