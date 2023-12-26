package com.tal.app.thinkacademy.lib.utils;

import android.app.Application;
import android.os.SystemClock;

public class LaunchUtil {
    public static long sAppStartTime;

    public static void init(Application application) {
        if (ProcessUtils.isMainProcess(application)) {
            sAppStartTime = SystemClock.elapsedRealtime();
        }
    }
}
