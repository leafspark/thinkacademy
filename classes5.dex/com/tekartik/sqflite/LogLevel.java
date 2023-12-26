package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;

public class LogLevel {
    static final int none = 0;
    static final int sql = 1;
    static final int verbose = 2;

    static boolean hasSqlLevel(int i) {
        return i >= 1;
    }

    static boolean hasVerboseLevel(int i) {
        return i >= 2;
    }

    static Integer getLogLevel(MethodCall methodCall) {
        return (Integer) methodCall.argument("logLevel");
    }
}
