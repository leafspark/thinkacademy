package com.bonree.sdk.agent.engine.webview.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class WebviewPerformanceTimingEvent {
    @SerializedName("pt")
    private PagePerformanceTiming pt;
    @SerializedName("rt")
    private List<ResourcePerformanceTiming> rt;

    public PagePerformanceTiming getPt() {
        return this.pt;
    }

    public void setPt(PagePerformanceTiming pagePerformanceTiming) {
        this.pt = pagePerformanceTiming;
    }

    public List<ResourcePerformanceTiming> getRt() {
        return this.rt;
    }

    public void setRt(List<ResourcePerformanceTiming> list) {
        this.rt = list;
    }
}
