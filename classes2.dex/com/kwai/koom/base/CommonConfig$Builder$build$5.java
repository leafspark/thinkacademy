package com.kwai.koom.base;

import com.kwai.koom.base.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/kwai/koom/base/CommonConfig$Builder$build$5", "Lcom/kwai/koom/base/Log;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
public final class CommonConfig$Builder$build$5 implements Log {
    CommonConfig$Builder$build$5() {
    }

    public int d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return Log.DefaultImpls.d(this, str, str2);
    }

    public int e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return Log.DefaultImpls.e(this, str, str2);
    }

    public int i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return Log.DefaultImpls.i(this, str, str2);
    }

    public int v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return Log.DefaultImpls.v(this, str, str2);
    }

    public int w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return Log.DefaultImpls.w(this, str, str2);
    }
}
