package com.linkedin.android.litr.utils;

class TimeUtils {
    public static float microsToSeconds(long j) {
        return ((float) j) / 1000000.0f;
    }

    public static float millisToSeconds(long j) {
        return ((float) j) / 1000.0f;
    }

    TimeUtils() {
    }
}
