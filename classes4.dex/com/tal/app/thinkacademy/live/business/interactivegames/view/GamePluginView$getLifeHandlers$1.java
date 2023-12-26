package com.tal.app.thinkacademy.live.business.interactivegames.view;

import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.interactivegames.callback.OnGameLifecycleCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/tal/app/thinkacademy/live/business/interactivegames/view/GamePluginView$getLifeHandlers$1", "Lcom/tal/app/thinkacademy/common/business/browser/handler/WebViewLifeHandler;", "onConsoleMessage", "", "msg", "Landroid/webkit/ConsoleMessage;", "onPageFinish", "url", "", "onPageStart", "onReceivedError", "failingUrl", "webResourceError", "Landroid/webkit/WebResourceError;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginView.kt */
public final class GamePluginView$getLifeHandlers$1 extends WebViewLifeHandler {
    final /* synthetic */ GamePluginView this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GamePluginView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            iArr[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 1;
            iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    GamePluginView$getLifeHandlers$1(GamePluginView gamePluginView) {
        this.this$0 = gamePluginView;
    }

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
        Intrinsics.checkNotNullParameter(consoleMessage, "msg");
        super.onConsoleMessage(consoleMessage);
        ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
        int i = messageLevel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[messageLevel.ordinal()];
        if (i == 1 || i == 2) {
            XesLog.e(GamePluginView.TAG, "onConsoleMessage ====> \n message : " + consoleMessage.message() + " \n sourceId : " + consoleMessage.sourceId() + " \n lineNumber : " + consoleMessage.lineNumber() + " \n level : " + consoleMessage.messageLevel().name());
            return;
        }
        XesLog.i(GamePluginView.TAG, "onConsoleMessage ====> \n message : " + consoleMessage.message() + " \n sourceId : " + consoleMessage.sourceId() + " \n lineNumber : " + consoleMessage.lineNumber() + " \n level : " + consoleMessage.messageLevel().name());
    }

    public void onReceivedError(String str, WebResourceError webResourceError) {
        super.onReceivedError(str, webResourceError);
        StringBuilder sb = new StringBuilder();
        sb.append("code: ");
        sb.append(webResourceError == null ? null : Integer.valueOf(webResourceError.getErrorCode()));
        sb.append(", desc: ");
        sb.append(webResourceError == null ? null : webResourceError.getDescription());
        sb.append(", url: ");
        sb.append(str);
        String sb2 = sb.toString();
        boolean z = false;
        XesLog.e(GamePluginView.TAG, Intrinsics.stringPlus("游戏异常 : ", sb2));
        if (str != null) {
            z = StringsKt.startsWith$default(str, "http://localhost:8080/", false, 2, (Object) null);
        }
        OnGameLifecycleCall gameLifecycleCall = this.this$0.getGameLifecycleCall();
        if (gameLifecycleCall != null) {
            gameLifecycleCall.onGameFail(sb2, z);
        }
        this.this$0.showErrorDialog();
    }

    public void onPageStart(String str) {
        super.onPageStart(str);
        XesLog.s(GamePluginView.TAG, Intrinsics.stringPlus("onPageStart 游戏开始加载 : ", str));
    }

    public void onPageFinish(String str) {
        super.onPageFinish(str);
        boolean z = false;
        XesLog.s(GamePluginView.TAG, Intrinsics.stringPlus("onPageFinish 游戏加载完成 : ", str));
        this.this$0.mHandler.removeCallbacksAndMessages((Object) null);
        this.this$0.mBinding.bgLoading.setVisibility(8);
        if (this.this$0.mStartLoadTime > 0) {
            if (str != null) {
                z = StringsKt.startsWith$default(str, "http://localhost:8080/", false, 2, (Object) null);
            }
            OnGameLifecycleCall gameLifecycleCall = this.this$0.getGameLifecycleCall();
            if (gameLifecycleCall != null) {
                gameLifecycleCall.onGameLoaded(System.currentTimeMillis() - this.this$0.mStartLoadTime, z);
            }
            this.this$0.mStartLoadTime = 0;
        }
        this.this$0.loadJs();
    }
}
