package com.tal.app.thinkacademy.business.shop.classdetail;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
final class ShopClassDetailActivity$showLinkEmailDialog$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ShopClassDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailActivity$showLinkEmailDialog$1(ShopClassDetailActivity shopClassDetailActivity) {
        super(1);
        this.this$0 = shopClassDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.this$0.showLoading();
        ShopClassDetailViewModel.requestMailVerify$default(this.this$0.getMViewModel(), str, (String) null, 2, (Object) null);
    }
}
