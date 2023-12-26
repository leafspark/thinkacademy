package com.kwai.koom.javaoom.monitor.tracker;

import com.kwai.koom.base.MonitorLog;
import com.kwai.koom.javaoom.monitor.OOMMonitorConfig;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/ThreadOOMTracker;", "Lcom/kwai/koom/javaoom/monitor/tracker/OOMTracker;", "()V", "mLastThreadCount", "", "mOverThresholdCount", "dumpThreadIfNeed", "", "getThreadCount", "reason", "", "reset", "track", "", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThreadOOMTracker.kt */
public final class ThreadOOMTracker extends OOMTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "OOMMonitor_ThreadOOMTracker";
    private static final int THREAD_COUNT_THRESHOLD_GAP = 50;
    private int mLastThreadCount;
    private int mOverThresholdCount;

    public String reason() {
        return "reason_thread_oom";
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/ThreadOOMTracker$Companion;", "", "()V", "TAG", "", "THREAD_COUNT_THRESHOLD_GAP", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ThreadOOMTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean track() {
        int threadCount = getThreadCount();
        if (threadCount <= ((OOMMonitorConfig) getMonitorConfig()).getThreadThreshold() || threadCount < this.mLastThreadCount - 50) {
            reset();
        } else {
            this.mOverThresholdCount++;
            MonitorLog.i(TAG, "[meet condition] overThresholdCount:" + this.mOverThresholdCount + ", threadCount: " + threadCount);
            dumpThreadIfNeed();
        }
        this.mLastThreadCount = threadCount;
        if (this.mOverThresholdCount >= ((OOMMonitorConfig) getMonitorConfig()).getMaxOverThresholdCount()) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mLastThreadCount = 0;
        this.mOverThresholdCount = 0;
    }

    private final int getThreadCount() {
        return SystemInfo.INSTANCE.getProcStatus().getThread();
    }

    private final void dumpThreadIfNeed() {
        MonitorLog.i(TAG, "over threshold dumpThreadIfNeed");
        ((OOMMonitorConfig) getMonitorConfig()).getMaxOverThresholdCount();
    }
}
