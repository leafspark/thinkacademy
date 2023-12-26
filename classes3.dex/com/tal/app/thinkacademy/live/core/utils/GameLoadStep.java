package com.tal.app.thinkacademy.live.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/GameLoadStep;", "", "step", "", "desc", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getStep", "setStep", "StartLoad", "LoadSuccess", "LoadFail", "Reload", "Submit", "Exit", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public enum GameLoadStep {
    StartLoad("start_load", "开始加载"),
    LoadSuccess("load_success", "加载成功"),
    LoadFail("load_fail", "加载失败"),
    Reload("reload", "重新加载"),
    Submit("submit", "作答结果"),
    Exit("exit", "退出游戏");
    
    private String desc;
    private String step;

    private GameLoadStep(String str, String str2) {
        this.step = str;
        this.desc = str2;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getStep() {
        return this.step;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setStep(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.step = str;
    }
}
