package com.didi.hummer.module;

import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.tracker.PerfCustomInfo;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.exception.JSException;
import java.io.Serializable;

@Component("Tracker")
public class Tracker {

    public static class JSErrorInfo implements Serializable {
        public String column;
        public String line;
        public String message;
        public String name;
        public String stack;
    }

    public static class JSPerfCustomInfo implements Serializable {
        public String label;
        public String localizableLabel;
        public String unit;
        public String value;
    }

    @JsMethod("trackPerformance")
    public static void trackPerformance(HummerContext hummerContext, JSPerfCustomInfo jSPerfCustomInfo) {
        if (jSPerfCustomInfo != null) {
            HummerAdapter.getTrackerAdapter(hummerContext.getNamespace()).trackPerfCustomInfo(hummerContext.getPageUrl(), new PerfCustomInfo(jSPerfCustomInfo.label, jSPerfCustomInfo.localizableLabel, jSPerfCustomInfo.unit, jSPerfCustomInfo.value));
        }
    }

    @JsMethod("trackException")
    public static void trackException(HummerContext hummerContext, JSErrorInfo jSErrorInfo) {
        if (jSErrorInfo != null) {
            HummerAdapter.getTrackerAdapter(hummerContext.getNamespace()).trackException(hummerContext.getPageUrl(), new JSException(jSErrorInfo.name + ": " + jSErrorInfo.message + "\n" + jSErrorInfo.stack));
        }
    }
}
