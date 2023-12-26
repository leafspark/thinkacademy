package com.didi.hummer.tools;

import com.didi.hummer.HummerSDK;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.HMLog;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
public class EventTracer {
    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static class EventName {
        public static final String HUMMER_SDK_TRACE_EVENT = "hummer_sdk_trace_event";
    }

    public interface Trace {
        void onEvent(String str, Map<String, Object> map);
    }

    private static void safeExecute(ExecutorService executorService, Runnable runnable) {
        executorService.submit(new EventTracer$$ExternalSyntheticLambda0(runnable));
    }

    static /* synthetic */ void lambda$safeExecute$0(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public static void traceEvent(String str, String str2) {
        traceEvent(str, str2, (Map<String, Object>) null);
    }

    @Deprecated
    public static void traceEvent(String str, String str2, Map<String, Object> map) {
        safeExecute(executor, new EventTracer$$ExternalSyntheticLambda1(str, str2, map));
    }

    static /* synthetic */ void lambda$traceEvent$1(String str, String str2, Map map) {
        Trace eventTracer = HummerSDK.getEventTracer(str);
        if (eventTracer != null) {
            eventTracer.onEvent(str2, map);
            if (DebugUtil.isDebuggable()) {
                HMLog.i("HummerEvent", "event: " + str2 + ", params: " + map);
            }
        }
    }
}
