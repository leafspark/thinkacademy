package com.kwai.koom.javaoom.monitor.tracker;

import android.os.Build;
import com.kwai.koom.base.MonitorLog;
import com.kwai.koom.javaoom.monitor.OOMMonitorConfig;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/FdOOMTracker;", "Lcom/kwai/koom/javaoom/monitor/tracker/OOMTracker;", "()V", "mLastFdCount", "", "mOverThresholdCount", "dumpFdIfNeed", "", "getFdCount", "reason", "", "reset", "track", "", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FdOOMTracker.kt */
public final class FdOOMTracker extends OOMTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FD_COUNT_THRESHOLD_GAP = 50;
    private static final String TAG = "OOMMonitor_FdOOMTracker";
    private int mLastFdCount;
    private int mOverThresholdCount;

    public String reason() {
        return "reason_fd_oom";
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/FdOOMTracker$Companion;", "", "()V", "FD_COUNT_THRESHOLD_GAP", "", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FdOOMTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean track() {
        int fdCount = getFdCount();
        SystemInfo.INSTANCE.setFdCount(fdCount);
        if (fdCount <= ((OOMMonitorConfig) getMonitorConfig()).getFdThreshold() || fdCount < this.mLastFdCount - 50) {
            reset();
        } else {
            this.mOverThresholdCount++;
            MonitorLog.i(TAG, "[meet condition] overThresholdCount: " + this.mOverThresholdCount + ", fdCount: " + fdCount);
            dumpFdIfNeed();
        }
        this.mLastFdCount = fdCount;
        if (this.mOverThresholdCount >= ((OOMMonitorConfig) getMonitorConfig()).getMaxOverThresholdCount()) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mLastFdCount = 0;
        this.mOverThresholdCount = 0;
    }

    private final int getFdCount() {
        File[] listFiles = new File("/proc/self/fd").listFiles();
        if (listFiles == null) {
            return 0;
        }
        return listFiles.length;
    }

    private final void dumpFdIfNeed() {
        MonitorLog.i(TAG, "over threshold dumpFdIfNeed");
        if (this.mOverThresholdCount <= ((OOMMonitorConfig) getMonitorConfig()).getMaxOverThresholdCount()) {
            int i = Build.VERSION.SDK_INT;
        }
    }
}
