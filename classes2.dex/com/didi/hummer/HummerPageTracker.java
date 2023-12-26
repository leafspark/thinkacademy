package com.didi.hummer;

import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.tracker.ITrackerAdapter;
import com.didi.hummer.adapter.tracker.PerfCustomInfo;
import com.didi.hummer.adapter.tracker.PerfInfo;
import com.didi.hummer.core.util.HMLog;
import java.util.HashMap;
import java.util.Map;

class HummerPageTracker {
    private long ctxInitStartTime;
    private long jsEvalStartTime;
    private long jsFetchStartTime;
    private String pageUrl;
    private PerfInfo perfInfo = new PerfInfo();
    private long renderStartTime;
    private String scriptId;
    private long scriptLength;
    private ITrackerAdapter trackerAdapter;

    public HummerPageTracker(String str) {
        this.trackerAdapter = HummerAdapter.getTrackerAdapter(str);
    }

    public void trackContextInitStart() {
        this.ctxInitStartTime = System.currentTimeMillis();
        this.trackerAdapter.trackEvent(ITrackerAdapter.EventName.CONTEXT_CREATE, (Map<String, Object>) null);
    }

    public void trackContextInitEnd() {
        this.perfInfo.ctxInitTimeCost = System.currentTimeMillis() - this.ctxInitStartTime;
        HMLog.v("HummerNative", "HummerContext初始化耗时：" + this.perfInfo.ctxInitTimeCost + " ms");
    }

    public void trackContextDestroy() {
        this.trackerAdapter.trackEvent(ITrackerAdapter.EventName.CONTEXT_DESTROY, (Map<String, Object>) null);
    }

    public void trackJSFetchStart() {
        if (!isHotReload()) {
            this.jsFetchStartTime = System.currentTimeMillis();
        }
    }

    public void trackJSFetchFinish() {
        if (!isHotReload()) {
            this.perfInfo.jsFetchTimeCost = System.currentTimeMillis() - this.jsFetchStartTime;
        }
    }

    public void trackRenderStart(String str) {
        if (!isHotReload()) {
            this.renderStartTime = System.currentTimeMillis();
            this.trackerAdapter.trackEvent(ITrackerAdapter.EventName.RENDER_START, (Map<String, Object>) null);
            this.pageUrl = str;
        }
    }

    public void trackJSEvalStart(long j, String str) {
        if (!isHotReload()) {
            this.jsEvalStartTime = System.currentTimeMillis();
            this.trackerAdapter.trackEvent(ITrackerAdapter.EventName.JS_EVAL_START, (Map<String, Object>) null);
            this.scriptLength = j;
            this.scriptId = str;
        }
    }

    public void trackJSEvalFinish() {
        if (!isHotReload()) {
            this.trackerAdapter.trackEvent(ITrackerAdapter.EventName.JS_EVAL_FINISH, (Map<String, Object>) null);
            this.perfInfo.jsEvalTimeCost = System.currentTimeMillis() - this.jsEvalStartTime;
            HMLog.v("HummerNative", "JS执行耗时：" + this.perfInfo.jsEvalTimeCost + " ms");
        }
    }

    public void trackRenderFinish(boolean z) {
        if (!isHotReload()) {
            float f = ((float) this.scriptLength) / 1024.0f;
            long currentTimeMillis = System.currentTimeMillis() - this.ctxInitStartTime;
            HashMap hashMap = new HashMap();
            hashMap.put(ITrackerAdapter.ParamKey.IS_RENDER_SUCCESS, Boolean.valueOf(z));
            hashMap.put(ITrackerAdapter.ParamKey.SDK_VERSION, "0.4.5");
            hashMap.put(ITrackerAdapter.ParamKey.PAGE_URL, this.scriptId);
            hashMap.put(ITrackerAdapter.ParamKey.RENDER_TIME_COST, Long.valueOf(currentTimeMillis));
            hashMap.put(ITrackerAdapter.ParamKey.JS_SIZE, Float.valueOf(f));
            this.perfInfo.pageRenderTimeCost = currentTimeMillis;
            this.perfInfo.jsBundleSize = f;
            if (z) {
                this.trackerAdapter.trackPageSuccess(this.pageUrl);
            }
            this.trackerAdapter.trackPerfInfo(this.pageUrl, this.perfInfo);
            this.trackerAdapter.trackPerfCustomInfo(this.pageUrl, new PerfCustomInfo("whiteScreenRate", "白屏率", "%", Integer.valueOf(z ? 0 : 100)));
            this.trackerAdapter.trackEvent(ITrackerAdapter.EventName.RENDER_FINISH, hashMap);
            HMLog.v("HummerNative", "页面渲染耗时：" + currentTimeMillis + " ms");
        }
    }

    public void trackPageView(String str) {
        this.trackerAdapter.trackPageView(str);
    }

    public void trackException(String str, Exception exc) {
        this.trackerAdapter.trackException(str, exc);
    }

    private boolean isHotReload() {
        PerfInfo perfInfo2 = this.perfInfo;
        return (perfInfo2 == null || perfInfo2.pageRenderTimeCost == 0) ? false : true;
    }
}
