package com.tal.app.thinkacademy.lib.ktx;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"throwInDebug", "", "", "lib_library_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExceptionKtx.kt */
public final class ExceptionKtxKt {
    public static final void throwInDebug(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (!AppConfig.DEBUG) {
            th.printStackTrace();
            XesLog.et("代码错误", th);
            return;
        }
        throw th;
    }
}
