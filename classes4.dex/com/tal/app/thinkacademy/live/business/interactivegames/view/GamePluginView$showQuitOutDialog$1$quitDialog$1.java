package com.tal.app.thinkacademy.live.business.interactivegames.view;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginView.kt */
final class GamePluginView$showQuitOutDialog$1$quitDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GamePluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GamePluginView$showQuitOutDialog$1$quitDialog$1(GamePluginView gamePluginView) {
        super(0);
        this.this$0 = gamePluginView;
    }

    public final void invoke() {
        XesLog.a(GamePluginView.TAG, "用户主动退出游戏");
        OnGameLifecycleCall gameLifecycleCall = this.this$0.getGameLifecycleCall();
        if (gameLifecycleCall != null) {
            gameLifecycleCall.onGameExit("主动退出");
        }
    }
}
