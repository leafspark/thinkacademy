package com.tal100.chatsdk.utils;

import java.util.Timer;
import java.util.TimerTask;

public class TaskUtils {
    private static Timer timer = new Timer();

    public static void excute(final Runnable runnable, long j) {
        timer.schedule(new TimerTask() {
            public void run() {
                runnable.run();
            }
        }, j);
    }
}
