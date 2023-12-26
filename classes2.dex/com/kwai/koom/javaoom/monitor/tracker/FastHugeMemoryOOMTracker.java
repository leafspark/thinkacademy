package com.kwai.koom.javaoom.monitor.tracker;

import com.kwai.koom.base.MonitorLog;
import com.kwai.koom.javaoom.monitor.OOMMonitorConfig;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import com.kwai.koom.javaoom.monitor.utils.SizeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/FastHugeMemoryOOMTracker;", "Lcom/kwai/koom/javaoom/monitor/tracker/OOMTracker;", "()V", "mDumpReason", "", "reason", "reset", "", "track", "", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FastHugeMemoryOOMTracker.kt */
public final class FastHugeMemoryOOMTracker extends OOMTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String REASON_HIGH_WATERMARK = "high_watermark";
    private static final String REASON_HUGE_DELTA = "delta";
    private static final String TAG = "OOMMonitor_FastHugeMemoryTracker";
    private String mDumpReason = "";

    public void reset() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/FastHugeMemoryOOMTracker$Companion;", "", "()V", "REASON_HIGH_WATERMARK", "", "REASON_HUGE_DELTA", "TAG", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FastHugeMemoryOOMTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean track() {
        SystemInfo.JavaHeap javaHeap = SystemInfo.INSTANCE.getJavaHeap();
        if (javaHeap.getRate() > ((OOMMonitorConfig) getMonitorConfig()).getForceDumpJavaHeapMaxThreshold()) {
            this.mDumpReason = REASON_HIGH_WATERMARK;
            MonitorLog.i(TAG, "[meet condition] fast huge memory allocated detected, high memory watermark, force dump analysis!");
            return true;
        }
        SystemInfo.JavaHeap lastJavaHeap = SystemInfo.INSTANCE.getLastJavaHeap();
        if (lastJavaHeap.getMax() == 0 || ((float) (javaHeap.getUsed() - lastJavaHeap.getUsed())) <= SizeUnit.KB.INSTANCE.toByte(((OOMMonitorConfig) getMonitorConfig()).getForceDumpJavaHeapDeltaThreshold())) {
            return false;
        }
        this.mDumpReason = REASON_HUGE_DELTA;
        MonitorLog.i(TAG, "[meet condition] fast huge memory allocated detected, over the delta threshold!");
        return true;
    }

    public String reason() {
        return Intrinsics.stringPlus("reason_fast_huge_", this.mDumpReason);
    }
}
