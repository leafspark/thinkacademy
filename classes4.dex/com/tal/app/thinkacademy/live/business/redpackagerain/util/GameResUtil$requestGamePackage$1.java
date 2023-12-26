package com.tal.app.thinkacademy.live.business.redpackagerain.util;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.GameResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.GameResRequestListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/redpackagerain/util/GameResUtil$requestGamePackage$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/GameResBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameResUtil.kt */
public final class GameResUtil$requestGamePackage$1 extends OmyCallback<HiResponse<GameResBean>> {
    final /* synthetic */ GameResRequestListener $listener;
    final /* synthetic */ GameResUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GameResUtil$requestGamePackage$1(GameResUtil gameResUtil, GameResRequestListener gameResRequestListener, GameResUtil$requestGamePackage$2 gameResUtil$requestGamePackage$2) {
        super(gameResUtil$requestGamePackage$2);
        this.this$0 = gameResUtil;
        this.$listener = gameResRequestListener;
    }

    public void onSuccess(HiResponse<GameResBean> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        XesLog.i(GameResUtil.TAG, Intrinsics.stringPlus("获取游戏资源包成功=", GsonUtil.getInstance().objToJson(hiResponse)));
        GameResBean data = hiResponse.getData();
        if (data != null) {
            GameResUtil gameResUtil = this.this$0;
            GameResRequestListener gameResRequestListener = this.$listener;
            gameResUtil.saveGamePackageData(data);
            gameResUtil.downGamePackageRes(data);
            RedPackageRainResBean redbagrainPackage = data.getRedbagrainPackage();
            if (redbagrainPackage != null && gameResRequestListener != null) {
                gameResRequestListener.onRedPackageRainResRequestSuccess(redbagrainPackage);
            }
        }
    }
}
