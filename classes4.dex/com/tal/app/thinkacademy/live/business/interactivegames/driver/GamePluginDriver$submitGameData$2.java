package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/interactivegames/driver/GamePluginDriver$submitGameData$2", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginDriver.kt */
public final class GamePluginDriver$submitGameData$2 implements IError {
    final /* synthetic */ GamePluginDriver this$0;

    GamePluginDriver$submitGameData$2(GamePluginDriver gamePluginDriver) {
        this.this$0 = gamePluginDriver;
    }

    public void onFail(int i, String str) {
        XesLog.e(this.this$0.TAG, "提交游戏数据失败onFail, code:" + i + ", msg:" + str);
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(str, new Object[0]);
        InteractReportKt.XesLogReport$default("submit", "Game", this.this$0.mInteractId, 0, (String) null, 16, (Object) null);
    }

    public void onError(int i, String str) {
        XesLog.e(this.this$0.TAG, "提交游戏数据失败onError, code:" + i + ", msg:" + str);
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(str, new Object[0]);
        InteractReportKt.XesLogReport$default("submit", "Game", this.this$0.mInteractId, 0, (String) null, 16, (Object) null);
    }
}
