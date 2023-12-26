package com.tal.app.thinkacademy.business.home.main.dialog;

import android.content.Context;
import com.tal.app.thinkacademy.business.home.main.LaunchTrack;
import com.tal.app.thinkacademy.business.home.main.dialog.PaymentRemindManager;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "buttonName", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentRemindManager.kt */
final class PaymentRemindManager$PaymentRemindDialog$positiveAction$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PaymentRemindManager.PaymentRemindDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentRemindManager$PaymentRemindDialog$positiveAction$1(PaymentRemindManager.PaymentRemindDialog paymentRemindDialog) {
        super(1);
        this.this$0 = paymentRemindDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "buttonName");
        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_UNPAID_COURSES, (Context) null, 2, (Object) null);
        ShareDataManager.getInstance().put("shopping_unpay_red_point_time", System.currentTimeMillis() / ((long) 1000), ShareDataManager.SHAREDATA_USER);
        XesDataBus.with("home_tab_red_point").postStickyData(new Pair("TAB_ME", false));
        XesDataBus.with("me_page_unpay_num").postStickyData(0);
        LaunchTrack.INSTANCE.clickDialog(this.this$0.mode, str);
    }
}
