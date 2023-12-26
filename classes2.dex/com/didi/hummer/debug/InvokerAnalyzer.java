package com.didi.hummer.debug;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.core.util.DebugUtil;
import java.util.ArrayList;
import java.util.List;

public class InvokerAnalyzer {
    private final Handler analyzeHandler = new Handler();
    private PerformanceTracker curPerfTracker;
    private InvokeTracker curTracker;
    private final List<InvokeTracker> invokeTrackerList = new ArrayList();
    private boolean isPerformanceTracking;
    private final List<PerformanceTracker> perfTrackerList = new ArrayList();

    public static InvokerAnalyzer init() {
        if (!DebugUtil.isDebuggable()) {
            return null;
        }
        return new InvokerAnalyzer();
    }

    public static void release(InvokerAnalyzer invokerAnalyzer) {
        if (DebugUtil.isDebuggable() && invokerAnalyzer != null) {
            invokerAnalyzer.release();
        }
    }

    public static void startTrack(InvokerAnalyzer invokerAnalyzer, String str, long j, String str2, Object[] objArr) {
        if (DebugUtil.isDebuggable() && invokerAnalyzer != null) {
            invokerAnalyzer.startTrack(str, j, str2, objArr);
        }
    }

    public static void stopTrack(InvokerAnalyzer invokerAnalyzer) {
        if (DebugUtil.isDebuggable() && invokerAnalyzer != null) {
            invokerAnalyzer.stopTrack();
        }
    }

    private InvokerAnalyzer() {
    }

    private void release() {
        this.analyzeHandler.removeCallbacksAndMessages((Object) null);
    }

    private void startTrack(String str, long j, String str2, Object[] objArr) {
        postAnalyzePerformance();
        InvokeTracker start = new InvokeTracker().start(str, j, str2, objArr);
        this.curTracker = start;
        this.invokeTrackerList.add(start);
    }

    private void stopTrack() {
        InvokeTracker invokeTracker = this.curTracker;
        if (invokeTracker != null) {
            invokeTracker.stop();
            PerformanceTracker performanceTracker = this.curPerfTracker;
            if (performanceTracker != null) {
                performanceTracker.track(this.curTracker);
            }
            this.curTracker = null;
        }
    }

    private void postAnalyzePerformance() {
        if (!this.isPerformanceTracking) {
            this.isPerformanceTracking = true;
            this.curPerfTracker = new PerformanceTracker().start();
            Handler handler = this.analyzeHandler;
            InvokerAnalyzer$$ExternalSyntheticLambda0 invokerAnalyzer$$ExternalSyntheticLambda0 = new InvokerAnalyzer$$ExternalSyntheticLambda0(this);
            if (!(handler instanceof Handler)) {
                handler.post(invokerAnalyzer$$ExternalSyntheticLambda0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, invokerAnalyzer$$ExternalSyntheticLambda0);
            }
        }
    }

    public /* synthetic */ void lambda$postAnalyzePerformance$0$InvokerAnalyzer() {
        this.perfTrackerList.add(this.curPerfTracker.stop());
        this.isPerformanceTracking = false;
    }

    public List<InvokeTracker> getInvokeTrackerList() {
        return this.invokeTrackerList;
    }

    public List<PerformanceTracker> getPerfTrackerList() {
        return this.perfTrackerList;
    }
}
