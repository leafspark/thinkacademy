package com.kwai.koom.javaoom.monitor.tracker;

import com.kwai.koom.base.MonitorLog;
import com.kwai.koom.javaoom.monitor.OOMMonitorConfig;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import com.kwai.koom.javaoom.monitor.utils.SizeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/HeapOOMTracker;", "Lcom/kwai/koom/javaoom/monitor/tracker/OOMTracker;", "()V", "mLastHeapRatio", "", "mOverThresholdCount", "", "reason", "", "reset", "", "track", "", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeapOOMTracker.kt */
public final class HeapOOMTracker extends OOMTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float HEAP_RATIO_THRESHOLD_GAP = 0.05f;
    private static final String TAG = "OOMMonitor_HeapOOMTracker";
    private float mLastHeapRatio;
    private int mOverThresholdCount;

    public String reason() {
        return "reason_heap_oom";
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/HeapOOMTracker$Companion;", "", "()V", "HEAP_RATIO_THRESHOLD_GAP", "", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HeapOOMTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean track() {
        float rate = SystemInfo.INSTANCE.getJavaHeap().getRate();
        if (rate <= ((OOMMonitorConfig) getMonitorConfig()).getHeapThreshold() || rate < this.mLastHeapRatio - HEAP_RATIO_THRESHOLD_GAP) {
            reset();
        } else {
            this.mOverThresholdCount++;
            MonitorLog.i(TAG, "[meet condition] overThresholdCount: " + this.mOverThresholdCount + ", heapRatio: " + rate + ", usedMem: " + SizeUnit.BYTE.INSTANCE.toMB(SystemInfo.INSTANCE.getJavaHeap().getUsed()) + "mb, max: " + SizeUnit.BYTE.INSTANCE.toMB(SystemInfo.INSTANCE.getJavaHeap().getMax()) + "mb");
        }
        this.mLastHeapRatio = rate;
        if (this.mOverThresholdCount >= ((OOMMonitorConfig) getMonitorConfig()).getMaxOverThresholdCount()) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.mLastHeapRatio = 0.0f;
        this.mOverThresholdCount = 0;
    }
}
