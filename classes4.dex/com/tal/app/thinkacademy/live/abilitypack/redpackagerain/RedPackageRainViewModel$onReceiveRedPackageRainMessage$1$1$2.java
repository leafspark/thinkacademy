package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainStatusListener;
import com.tal.app.thinkacademy.live.business.redpackagerain.util.GameResUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$2", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainStatusListener;", "onUnReportCoin", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainViewModel.kt */
public final class RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$2 implements RedPackageRainStatusListener {
    final /* synthetic */ RedPackageRainMsgBean $msg;
    final /* synthetic */ RedPackageRainViewModel this$0;

    RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$2(RedPackageRainViewModel redPackageRainViewModel, RedPackageRainMsgBean redPackageRainMsgBean) {
        this.this$0 = redPackageRainViewModel;
        this.$msg = redPackageRainMsgBean;
    }

    public void onUnReportCoin() {
        XesLog.i(RedPackageRainViewModel.TAG, "未上报过金币，判断本地游戏包数据缓存");
        RedPackageRainResBean access$checkRedPackageRainData = this.this$0.checkRedPackageRainData(this.$msg.getName());
        if (access$checkRedPackageRainData != null) {
            XesLog.i(RedPackageRainViewModel.TAG, Intrinsics.stringPlus("游戏包信息=", GsonUtil.getInstance().objToJson(access$checkRedPackageRainData)));
            XesLog.i(RedPackageRainViewModel.TAG, "有本地缓存游戏包数据，加载游戏");
            this.this$0.sendLoadGameEvent(this.$msg, access$checkRedPackageRainData);
            XesLog.i(RedPackageRainViewModel.TAG, "显示降级view loading效果");
            this.this$0.sendLoadDowngradeEvent(this.$msg, RedPackageRainDowngradeStatus.STATUS_LOADING);
            return;
        }
        XesLog.i(RedPackageRainViewModel.TAG, "无本地缓存游戏包数据，请求游戏包数据接口");
        GameResUtil.Companion.get().requestGamePackage(new RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$2$onUnReportCoin$1(access$checkRedPackageRainData, this.this$0, this.$msg));
    }
}
