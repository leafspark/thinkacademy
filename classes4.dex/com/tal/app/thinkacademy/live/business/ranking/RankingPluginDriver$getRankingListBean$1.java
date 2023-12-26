package com.tal.app.thinkacademy.live.business.ranking;

import com.tal.app.thinkacademy.lib.network.exception.IError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/ranking/RankingPluginDriver$getRankingListBean$1", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RankingPluginDriver.kt */
public final class RankingPluginDriver$getRankingListBean$1 implements IError {
    final /* synthetic */ RankingPluginDriver this$0;

    RankingPluginDriver$getRankingListBean$1(RankingPluginDriver rankingPluginDriver) {
        this.this$0 = rankingPluginDriver;
    }

    public void onFail(int i, String str) {
        this.this$0.trackInteractiveLog("Rank", "showBoard", 0, "接口数据失败");
    }

    public void onError(int i, String str) {
        this.this$0.trackInteractiveLog("Rank", "showBoard", 0, "接口返回错误");
    }
}
