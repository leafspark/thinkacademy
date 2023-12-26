package com.didi.hummer.core.util;

import com.didi.hummer.core.engine.JSContext;
import java.util.ArrayList;
import java.util.Arrays;

public class ExceptionUtil {
    public static void addStackTrace(Exception exc, StackTraceElement stackTraceElement) {
        addStackTrace(0, exc, stackTraceElement);
    }

    public static void addStackTrace(int i, Exception exc, StackTraceElement stackTraceElement) {
        ArrayList arrayList = new ArrayList(Arrays.asList(exc.getStackTrace()));
        arrayList.add(i, stackTraceElement);
        exc.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
    }

    public static String getJSErrorStack(JSContext jSContext) {
        jSContext.evaluateJavaScript("var __CUR_ERROR__ = new Error()");
        return jSContext.getJSValue("__CUR_ERROR__").getString("stack");
    }
}
