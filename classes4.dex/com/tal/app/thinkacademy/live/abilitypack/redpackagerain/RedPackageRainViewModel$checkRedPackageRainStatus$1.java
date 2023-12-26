package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainStatusBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainStatusListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$checkRedPackageRainStatus$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainStatusBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainViewModel.kt */
public final class RedPackageRainViewModel$checkRedPackageRainStatus$1 extends OmyCallback<HiResponse<RedPackageRainStatusBean>> {
    final /* synthetic */ RedPackageRainStatusListener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RedPackageRainViewModel$checkRedPackageRainStatus$1(RedPackageRainStatusListener redPackageRainStatusListener, RedPackageRainViewModel$checkRedPackageRainStatus$2 redPackageRainViewModel$checkRedPackageRainStatus$2) {
        super(redPackageRainViewModel$checkRedPackageRainStatus$2);
        this.$listener = redPackageRainStatusListener;
    }

    public void onSuccess(HiResponse<RedPackageRainStatusBean> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        XesLog.i(RedPackageRainViewModel.TAG, Intrinsics.stringPlus("获取红包雨学生端状态成功=", GsonUtil.getInstance().objToJson(hiResponse)));
        RedPackageRainStatusBean data = hiResponse.getData();
        if (data != null) {
            RedPackageRainStatusListener redPackageRainStatusListener = this.$listener;
            Integer attendStatus = data.getAttendStatus();
            if ((attendStatus == null || attendStatus.intValue() != 1) && redPackageRainStatusListener != null) {
                redPackageRainStatusListener.onUnReportCoin();
            }
        }
    }
}
