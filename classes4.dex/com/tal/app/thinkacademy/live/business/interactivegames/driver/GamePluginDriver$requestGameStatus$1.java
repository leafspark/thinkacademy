package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/interactivegames/driver/GamePluginDriver$requestGameStatus$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginDriver.kt */
public final class GamePluginDriver$requestGameStatus$1 extends OmyCallback<HiResponse<GameStatus>> {
    final /* synthetic */ GamePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GamePluginDriver$requestGameStatus$1(GamePluginDriver gamePluginDriver, GamePluginDriver$requestGameStatus$2 gamePluginDriver$requestGameStatus$2) {
        super(gamePluginDriver$requestGameStatus$2);
        this.this$0 = gamePluginDriver;
    }

    public void onSuccess(HiResponse<GameStatus> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        if (!this.this$0.isOnDestroy) {
            this.this$0.mGameStatus = hiResponse.getData();
            XesLogTag access$getTAG$p = this.this$0.TAG;
            Object[] objArr = new Object[1];
            GameStatus access$getMGameStatus$p = this.this$0.mGameStatus;
            objArr[0] = Intrinsics.stringPlus("学生答题状态 获取成功, studentInteractStatus=", access$getMGameStatus$p == null ? null : access$getMGameStatus$p.getStudentInteractStatus());
            XesLog.s(access$getTAG$p, objArr);
            GameStatus access$getMGameStatus$p2 = this.this$0.mGameStatus;
            if (access$getMGameStatus$p2 != null) {
                GamePluginDriver gamePluginDriver = this.this$0;
                if (!Intrinsics.areEqual(access$getMGameStatus$p2.getStudentInteractStatus(), "2")) {
                    gamePluginDriver.loadPlugin(gamePluginDriver.mGameStatus);
                }
            }
        }
    }
}
