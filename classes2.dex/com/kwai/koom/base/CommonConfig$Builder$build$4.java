package com.kwai.koom.base;

import com.kwai.koom.base.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/kwai/koom/base/CommonConfig$Builder$build$4", "Lcom/kwai/koom/base/Logger;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
public final class CommonConfig$Builder$build$4 implements Logger {
    CommonConfig$Builder$build$4() {
    }

    public void addCustomStatEvent(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Logger.DefaultImpls.addCustomStatEvent(this, str, str2, z);
    }

    public void addExceptionEvent(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        Logger.DefaultImpls.addExceptionEvent(this, str, i);
    }
}
