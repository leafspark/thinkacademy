package com.didi.hummer.adapter.tracker;

import java.io.Serializable;

public class PerfInfo implements Serializable {
    public long ctxInitTimeCost;
    public float jsBundleSize;
    public long jsEvalTimeCost;
    public long jsFetchTimeCost;
    public long pageRenderTimeCost;

    public String toString() {
        return "PerfInfo{ctxInitTimeCost=" + this.ctxInitTimeCost + "ms, jsFetchTimeCost=" + this.jsFetchTimeCost + "ms, jsEvalTimeCost=" + this.jsEvalTimeCost + "ms, pageRenderTimeCost=" + this.pageRenderTimeCost + "ms, jsBundleSize=" + this.jsBundleSize + "KB" + '}';
    }
}
