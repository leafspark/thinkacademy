package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.GameResRequestListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$1", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/GameResRequestListener;", "onRedPackageRainResRequestSuccess", "", "redPackageRainResBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainViewModel.kt */
public final class RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$1 implements GameResRequestListener {
    final /* synthetic */ RedPackageRainMsgBean $msg;
    final /* synthetic */ RedPackageRainResBean $redPackageRainData;
    final /* synthetic */ RedPackageRainViewModel this$0;

    RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$1(RedPackageRainResBean redPackageRainResBean, RedPackageRainViewModel redPackageRainViewModel, RedPackageRainMsgBean redPackageRainMsgBean) {
        this.$redPackageRainData = redPackageRainResBean;
        this.this$0 = redPackageRainViewModel;
        this.$msg = redPackageRainMsgBean;
    }

    public void onRedPackageRainResRequestSuccess(RedPackageRainResBean redPackageRainResBean) {
        Intrinsics.checkNotNullParameter(redPackageRainResBean, "redPackageRainResBean");
        XesLog.i(RedPackageRainViewModel.TAG, Intrinsics.stringPlus("游戏包信息=", GsonUtil.getInstance().objToJson(this.$redPackageRainData)));
        XesLog.i(RedPackageRainViewModel.TAG, "游戏包数据接口请求成功，加载游戏");
        this.this$0.sendLoadGameEvent(this.$msg, redPackageRainResBean);
        XesLog.i(RedPackageRainViewModel.TAG, "显示降级view loading效果");
        this.this$0.sendLoadDowngradeEvent(this.$msg, RedPackageRainDowngradeStatus.STATUS_LOADING);
    }
}
