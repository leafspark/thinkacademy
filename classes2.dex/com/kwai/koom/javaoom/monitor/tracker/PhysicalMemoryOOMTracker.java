package com.kwai.koom.javaoom.monitor.tracker;

import com.kwai.koom.base.MonitorLog;
import com.kwai.koom.javaoom.monitor.OOMMonitorConfig;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/PhysicalMemoryOOMTracker;", "Lcom/kwai/koom/javaoom/monitor/tracker/OOMTracker;", "()V", "reason", "", "reset", "", "track", "", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhysicalMemoryOOMTracker.kt */
public final class PhysicalMemoryOOMTracker extends OOMTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "OOMMonitor_PhysicalMemoryTracker";

    public String reason() {
        return "reason_lmk_oom";
    }

    public void reset() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/PhysicalMemoryOOMTracker$Companion;", "", "()V", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhysicalMemoryOOMTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean track() {
        SystemInfo.MemInfo memInfo = SystemInfo.INSTANCE.getMemInfo();
        if (memInfo.getRate() < ((OOMMonitorConfig) getMonitorConfig()).getDeviceMemoryThreshold()) {
            MonitorLog.e(TAG, "oom meminfo.rate < " + (((OOMMonitorConfig) getMonitorConfig()).getDeviceMemoryThreshold() * ((float) 100)) + '%');
            return false;
        } else if (memInfo.getRate() < 0.1f) {
            MonitorLog.i(TAG, "oom meminfo.rate < 10.0%");
            return false;
        } else if (memInfo.getRate() < 0.15f) {
            MonitorLog.i(TAG, "oom meminfo.rate < 15.0%");
            return false;
        } else if (memInfo.getRate() < 0.2f) {
            MonitorLog.i(TAG, "oom meminfo.rate < 20.0%");
            return false;
        } else if (memInfo.getRate() >= 0.3f) {
            return false;
        } else {
            MonitorLog.i(TAG, "oom meminfo.rate < 30.0%");
            return false;
        }
    }
}
