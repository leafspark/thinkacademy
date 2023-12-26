package com.tal.app.thinkacademy.live.business.function;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/function/FunctionPluginDriver$getEnterRoomMuteData$1", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginDriver.kt */
public final class FunctionPluginDriver$getEnterRoomMuteData$1 implements IError {
    final /* synthetic */ FunctionPluginDriver this$0;

    FunctionPluginDriver$getEnterRoomMuteData$1(FunctionPluginDriver functionPluginDriver) {
        this.this$0 = functionPluginDriver;
    }

    public void onError(int i, String str) {
        XesLog.it(this.this$0.TAG, Intrinsics.stringPlus("获取进入教室麦克风默认设置Error=", str));
        this.this$0.isRequestEnterRoomMuteDataEnd = true;
        this.this$0.initMicStatus();
    }

    public void onFail(int i, String str) {
        XesLog.it(this.this$0.TAG, Intrinsics.stringPlus("获取进入教室麦克风默认设置Fail=", str));
        this.this$0.isRequestEnterRoomMuteDataEnd = true;
        this.this$0.initMicStatus();
    }
}
