package com.kwai.koom.base.loop;

import android.os.Handler;
import com.kwai.koom.base.Monitor;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\t\b&\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J&\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/kwai/koom/base/loop/LoopMonitor;", "C", "Lcom/kwai/koom/base/Monitor;", "Ljava/util/concurrent/Callable;", "Lcom/kwai/koom/base/loop/LoopMonitor$LoopState;", "()V", "mIsLoopStopped", "", "mLoopRunnable", "com/kwai/koom/base/loop/LoopMonitor$mLoopRunnable$1", "Lcom/kwai/koom/base/loop/LoopMonitor$mLoopRunnable$1;", "getLoopHandler", "Landroid/os/Handler;", "getLoopInterval", "", "startLoop", "", "clearQueue", "postAtFront", "delayMillis", "stopLoop", "Companion", "LoopState", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: LoopMonitor.kt */
public abstract class LoopMonitor<C> extends Monitor<C> implements Callable<LoopState> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DEFAULT_LOOP_INTERVAL = 1000;
    /* access modifiers changed from: private */
    public volatile boolean mIsLoopStopped = true;
    private final LoopMonitor$mLoopRunnable$1 mLoopRunnable = new LoopMonitor$mLoopRunnable$1(this);

    /* access modifiers changed from: protected */
    public long getLoopInterval() {
        return DEFAULT_LOOP_INTERVAL;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kwai/koom/base/loop/LoopMonitor$Companion;", "", "()V", "DEFAULT_LOOP_INTERVAL", "", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
    /* compiled from: LoopMonitor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void startLoop$default(LoopMonitor loopMonitor, boolean z, boolean z2, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            if ((i & 4) != 0) {
                j = 0;
            }
            loopMonitor.startLoop(z, z2, j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startLoop");
    }

    public void startLoop(boolean z, boolean z2, long j) {
        if (z) {
            getLoopHandler().removeCallbacks(this.mLoopRunnable);
        }
        if (z2) {
            getLoopHandler().postAtFrontOfQueue(this.mLoopRunnable);
        } else {
            getLoopHandler().postDelayed(this.mLoopRunnable, j);
        }
        this.mIsLoopStopped = false;
    }

    public void stopLoop() {
        this.mIsLoopStopped = true;
        getLoopHandler().removeCallbacks(this.mLoopRunnable);
    }

    /* access modifiers changed from: protected */
    public Handler getLoopHandler() {
        return (Handler) getCommonConfig().getLoopHandlerInvoker$koom_monitor_base_SharedCppRelease().invoke();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/base/loop/LoopMonitor$LoopState;", "", "()V", "Continue", "Terminate", "Lcom/kwai/koom/base/loop/LoopMonitor$LoopState$Continue;", "Lcom/kwai/koom/base/loop/LoopMonitor$LoopState$Terminate;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
    /* compiled from: LoopMonitor.kt */
    public static abstract class LoopState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kwai/koom/base/loop/LoopMonitor$LoopState$Continue;", "Lcom/kwai/koom/base/loop/LoopMonitor$LoopState;", "()V", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
        /* compiled from: LoopMonitor.kt */
        public static final class Continue extends LoopState {
            public static final Continue INSTANCE = new Continue();

            private Continue() {
                super((DefaultConstructorMarker) null);
            }
        }

        private LoopState() {
        }

        public /* synthetic */ LoopState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kwai/koom/base/loop/LoopMonitor$LoopState$Terminate;", "Lcom/kwai/koom/base/loop/LoopMonitor$LoopState;", "()V", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
        /* compiled from: LoopMonitor.kt */
        public static final class Terminate extends LoopState {
            public static final Terminate INSTANCE = new Terminate();

            private Terminate() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
