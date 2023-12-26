package io.flutter.util;

import androidx.tracing.Trace;

public final class TraceSection {
    private static String cropSectionName(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void begin(String str) {
        Trace.beginSection(cropSectionName(str));
    }

    public static void end() throws RuntimeException {
        Trace.endSection();
    }

    public static void beginAsyncSection(String str, int i) {
        Trace.beginAsyncSection(cropSectionName(str), i);
    }

    public static void endAsyncSection(String str, int i) {
        Trace.endAsyncSection(cropSectionName(str), i);
    }
}
