package com.didi.hummer.adapter.tracker;

import java.util.List;
import java.util.Map;

public interface ITrackerAdapter {

    public static class EventName {
        public static final String CONTEXT_CREATE = "tech_hummer_context_create";
        public static final String CONTEXT_DESTROY = "tech_hummer_context_destroy";
        public static final String JS_EVAL_FINISH = "tech_hummer_js_eval_finish";
        public static final String JS_EVAL_START = "tech_hummer_js_eval_start";
        public static final String RENDER_FINISH = "tech_hummer_render_finish";
        public static final String RENDER_START = "tech_hummer_render_start";
        public static final String SDK_INIT = "tech_hummer_sdk_init";
    }

    public static class ParamKey {
        public static final String IS_RENDER_SUCCESS = "is_render_success";
        public static final String JS_SIZE = "js_size";
        public static final String PAGE_URL = "page_url";
        public static final String RENDER_TIME_COST = "render_time_cost";
        public static final String SDK_VERSION = "sdk_version";
    }

    void storeBundleInfo(BundleInfo bundleInfo);

    void storeBundleInfo(String str, String str2, String str3);

    void trackEvent(String str, Map<String, Object> map);

    void trackException(String str, Exception exc);

    void trackPageSuccess(String str);

    void trackPageView(String str);

    void trackPerfCustomInfo(String str, PerfCustomInfo perfCustomInfo);

    void trackPerfCustomInfo(String str, List<PerfCustomInfo> list);

    void trackPerfInfo(String str, PerfInfo perfInfo);

    void trackSDKCustomInfo(SDKCustomInfo sDKCustomInfo);

    void trackSDKInfo(SDKInfo sDKInfo);
}
