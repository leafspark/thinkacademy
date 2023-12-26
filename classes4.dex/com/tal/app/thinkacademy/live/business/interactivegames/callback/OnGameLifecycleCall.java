package com.tal.app.thinkacademy.live.business.interactivegames.callback;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/callback/OnGameLifecycleCall;", "", "onGameExit", "", "msg", "", "onGameFail", "isLocal", "", "onGameLoaded", "duration", "", "onGameReload", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnGameLifecycleCall.kt */
public interface OnGameLifecycleCall {
    void onGameExit(String str);

    void onGameFail(String str, boolean z);

    void onGameLoaded(long j, boolean z);

    void onGameReload();
}
