package com.tal.app.thinkacademy.business.login.adapter;

import com.tal.app.thinkacademy.business.login.view.item.MyPageRecyclerItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MeItemAdapter.kt */
final class MeItemAdapter$convert$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MyPageRecyclerItem $item;
    final /* synthetic */ MeItemAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeItemAdapter$convert$1(MeItemAdapter meItemAdapter, MyPageRecyclerItem myPageRecyclerItem) {
        super(0);
        this.this$0 = meItemAdapter;
        this.$item = myPageRecyclerItem;
    }

    public final void invoke() {
        Function2 access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            MyPageRecyclerItem myPageRecyclerItem = this.$item;
            access$getListener$p.invoke(myPageRecyclerItem, Integer.valueOf(this.this$0.getItemPosition(myPageRecyclerItem)));
        }
    }
}
