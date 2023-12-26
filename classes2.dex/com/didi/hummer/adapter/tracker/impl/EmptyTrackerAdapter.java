package com.didi.hummer.adapter.tracker.impl;

import com.didi.hummer.adapter.tracker.BundleInfo;
import com.didi.hummer.adapter.tracker.ITrackerAdapter;
import com.didi.hummer.adapter.tracker.PerfCustomInfo;
import com.didi.hummer.adapter.tracker.PerfInfo;
import com.didi.hummer.adapter.tracker.SDKCustomInfo;
import com.didi.hummer.adapter.tracker.SDKInfo;
import java.util.List;
import java.util.Map;

public class EmptyTrackerAdapter implements ITrackerAdapter {
    public void storeBundleInfo(BundleInfo bundleInfo) {
    }

    public void storeBundleInfo(String str, String str2, String str3) {
    }

    public void trackEvent(String str, Map<String, Object> map) {
    }

    public void trackException(String str, Exception exc) {
    }

    public void trackPageSuccess(String str) {
    }

    public void trackPageView(String str) {
    }

    public void trackPerfCustomInfo(String str, PerfCustomInfo perfCustomInfo) {
    }

    public void trackPerfCustomInfo(String str, List<PerfCustomInfo> list) {
    }

    public void trackPerfInfo(String str, PerfInfo perfInfo) {
    }

    public void trackSDKCustomInfo(SDKCustomInfo sDKCustomInfo) {
    }

    public void trackSDKInfo(SDKInfo sDKInfo) {
    }
}
