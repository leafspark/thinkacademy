package com.tal.app.thinkacademy.live.business.nps.dialog;

import android.content.Context;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/nps/dialog/NpsDelegate$saveNps$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "", "onSuccess", "", "t", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsDelegate.kt */
public final class NpsDelegate$saveNps$1 extends OmyCallback<HiResponse<Object>> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NpsDelegate$saveNps$1(Context context, NpsDelegate$saveNps$2 npsDelegate$saveNps$2) {
        super(npsDelegate$saveNps$2);
        this.$context = context;
    }

    public void onSuccess(HiResponse<Object> hiResponse) {
        XesLog.s(Tag.NPS, "nps提交成功");
        ToastUtils.showShort(this.$context.getText(R.string.submit_feedback_successfully));
    }
}
