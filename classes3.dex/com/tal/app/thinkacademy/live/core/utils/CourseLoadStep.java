package com.tal.app.thinkacademy.live.core.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/CourseLoadStep;", "", "step", "", "desc", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getStep", "setStep", "StartCourse", "StartServer", "ServerCallback", "PrepareLoad", "CheckCommon", "CheckResource", "StartLoadUrl", "LoadJsStep", "LoadSuccess", "LoadFail", "ExitCourse", "TurnPage", "RefreshCourse", "Error", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public enum CourseLoadStep {
    StartCourse("startCourse", "进入课堂"),
    StartServer("startServer", "启动本地服务"),
    ServerCallback("serverCallback", "本地服务状态回调"),
    PrepareLoad("prepareLoad", "准备加载课件"),
    CheckCommon("checkCommon", "课件基础资源包（桥阶层）校验"),
    CheckResource("checkResource", "课件包资源校验"),
    StartLoadUrl("startLoadUrl", "加载课件"),
    LoadJsStep("loadJsStep", "课件加载js进度"),
    LoadSuccess("loadSuccess", "课件加载成功"),
    LoadFail("loadFail", "课件加载失败"),
    ExitCourse("exitCourse", "退出教室"),
    TurnPage("turnPage", "课件翻页成功"),
    RefreshCourse("refreshCourse", "课件刷新"),
    Error("error", "异常");
    
    private String desc;
    private String step;

    private CourseLoadStep(String str, String str2) {
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
