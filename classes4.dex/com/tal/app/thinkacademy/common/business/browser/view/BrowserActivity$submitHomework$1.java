package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import com.tal.app.thinkacademy.common.entity.SubmitHomeworkResult;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/view/BrowserActivity$submitHomework$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkResult;", "onSuccess", "", "t", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserActivity.kt */
public final class BrowserActivity$submitHomework$1 extends OmyCallback<HiResponse<SubmitHomeworkResult>> {
    final /* synthetic */ BrowserActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrowserActivity$submitHomework$1(BrowserActivity browserActivity, BrowserActivity$submitHomework$2 browserActivity$submitHomework$2) {
        super(browserActivity$submitHomework$2);
        this.this$0 = browserActivity;
    }

    public void onSuccess(HiResponse<SubmitHomeworkResult> hiResponse) {
        boolean z;
        Intrinsics.checkNotNullParameter(hiResponse, "t");
        XesDataBus.with(DataBusKey.SYNC_HOMEWORK_SUCCESS).postStickyData("");
        if (!this.this$0.isDestroy) {
            SubmitHomeworkResult data = hiResponse.getData();
            int i = 0;
            if (data == null) {
                z = false;
            } else {
                z = Intrinsics.areEqual(data.isShow(), true);
            }
            if (z) {
                if (this.this$0.mGoldCoinDialog == null) {
                    this.this$0.mGoldCoinDialog = new GoldCoinDialog((Context) this.this$0);
                }
                GoldCoinDialog access$getMGoldCoinDialog$p = this.this$0.mGoldCoinDialog;
                if (access$getMGoldCoinDialog$p != null) {
                    Integer submitCoin = data.getSubmitCoin();
                    int intValue = submitCoin == null ? 0 : submitCoin.intValue();
                    Integer earlySubmitCoin = data.getEarlySubmitCoin();
                    if (earlySubmitCoin != null) {
                        i = earlySubmitCoin.intValue();
                    }
                    access$getMGoldCoinDialog$p.updateGoldCoin(intValue, i);
                }
                GoldCoinDialog access$getMGoldCoinDialog$p2 = this.this$0.mGoldCoinDialog;
                if (access$getMGoldCoinDialog$p2 != null) {
                    access$getMGoldCoinDialog$p2.show();
                }
            }
        }
    }
}
