package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.interactivegames.view.GamePluginView;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/interactivegames/driver/GamePluginDriver$submitGameData$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginDriver.kt */
public final class GamePluginDriver$submitGameData$1 extends OmyCallback<HiResponse<AnswerBean>> {
    final /* synthetic */ GamePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GamePluginDriver$submitGameData$1(GamePluginDriver gamePluginDriver, GamePluginDriver$submitGameData$2 gamePluginDriver$submitGameData$2) {
        super(gamePluginDriver$submitGameData$2);
        this.this$0 = gamePluginDriver;
    }

    public void onSuccess(HiResponse<AnswerBean> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        XesLogTag access$getTAG$p = this.this$0.TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("游戏数据提交成功：rightCoin = ");
        AnswerBean data = hiResponse.getData();
        Integer num = null;
        sb.append(data == null ? null : Integer.valueOf(data.getRightCoin()));
        sb.append(" --- userLatestCoin = ");
        AnswerBean data2 = hiResponse.getData();
        if (data2 != null) {
            num = Integer.valueOf(data2.getUserLatestCoin());
        }
        sb.append(num);
        objArr[0] = sb.toString();
        XesLog.s(access$getTAG$p, objArr);
        AnswerBean data3 = hiResponse.getData();
        if (data3 != null) {
            GamePluginDriver gamePluginDriver = this.this$0;
            gamePluginDriver.updateUserLevel(data3.getLevel());
            gamePluginDriver.updateUserCoins(data3.getUserLatestCoin(), data3.getRightCoin());
            InteractReportKt.XesLogReport$default("submit", "Game", gamePluginDriver.mInteractId, 1, (String) null, 16, (Object) null);
            GamePluginView access$getMGamePluginView$p = gamePluginDriver.mGamePluginView;
            if (access$getMGamePluginView$p != null) {
                access$getMGamePluginView$p.drawResultView(data3);
            }
        }
    }
}
