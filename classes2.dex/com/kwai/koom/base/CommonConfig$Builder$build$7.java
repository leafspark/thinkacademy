package com.kwai.koom.base;

import android.os.Handler;
import com.kwai.koom.base.loop.LoopThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
final class CommonConfig$Builder$build$7 extends Lambda implements Function0<Handler> {
    public static final CommonConfig$Builder$build$7 INSTANCE = new CommonConfig$Builder$build$7();

    CommonConfig$Builder$build$7() {
        super(0);
    }

    public final Handler invoke() {
        return LoopThread.INSTANCE.getLOOP_HANDLER$koom_monitor_base_SharedCppRelease();
    }
}
