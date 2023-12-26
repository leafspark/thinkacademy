package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainStatusListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$checkRedPackageRainStatus$2", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainViewModel.kt */
public final class RedPackageRainViewModel$checkRedPackageRainStatus$2 implements IError {
    final /* synthetic */ RedPackageRainStatusListener $listener;

    RedPackageRainViewModel$checkRedPackageRainStatus$2(RedPackageRainStatusListener redPackageRainStatusListener) {
        this.$listener = redPackageRainStatusListener;
    }

    public void onFail(int i, String str) {
        XesLog.i(RedPackageRainViewModel.TAG, "获取红包雨学生端状态Fail，错误码=" + i + "，错误描述=" + str);
        RedPackageRainStatusListener redPackageRainStatusListener = this.$listener;
        if (redPackageRainStatusListener != null) {
            redPackageRainStatusListener.onUnReportCoin();
        }
    }

    public void onError(int i, String str) {
        XesLog.i(RedPackageRainViewModel.TAG, "获取红包雨学生端状态Error，错误码=" + i + "，错误描述=" + str);
        RedPackageRainStatusListener redPackageRainStatusListener = this.$listener;
        if (redPackageRainStatusListener != null) {
            redPackageRainStatusListener.onUnReportCoin();
        }
    }
}
