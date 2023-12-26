package com.kwai.koom.base.loop;

import com.kwai.koom.base.loop.LoopMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/kwai/koom/base/loop/LoopMonitor$mLoopRunnable$1", "Ljava/lang/Runnable;", "run", "", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: LoopMonitor.kt */
public final class LoopMonitor$mLoopRunnable$1 implements Runnable {
    final /* synthetic */ LoopMonitor this$0;

    LoopMonitor$mLoopRunnable$1(LoopMonitor loopMonitor) {
        this.this$0 = loopMonitor;
    }

    public void run() {
        if (!Intrinsics.areEqual((LoopMonitor.LoopState) this.this$0.call(), LoopMonitor.LoopState.Terminate.INSTANCE) && !this.this$0.mIsLoopStopped) {
            Runnable runnable = this;
            this.this$0.getLoopHandler().removeCallbacks(runnable);
            this.this$0.getLoopHandler().postDelayed(runnable, this.this$0.getLoopInterval());
        }
    }
}
