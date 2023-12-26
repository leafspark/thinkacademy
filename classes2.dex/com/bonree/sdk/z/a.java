package com.bonree.sdk.z;

import com.bonree.sdk.g.b;

public final class a extends b {
    public static String l = "onCreate";
    public static String m = "onStart";
    public static String n = "onResume";
    public static String o = "onReStart";
    public static String p = "onPause";
    public static String q = "finish";

    public a() {
        this.h = String.valueOf(Thread.currentThread().getId());
    }

    public final String toString() {
        return "ActivityData{activityName='" + this.a + '\'' + ", fragmentName='" + this.b + '\'' + ", methodName='" + this.c + '\'' + ", methodType=" + this.d + ", methodStatus=" + this.e + ", methodTime=" + this.f + ", methodTimeStamp=" + this.g + ", threadId=" + this.h + ", threadName='" + this.i + '\'' + ", isMain=" + this.j + '}';
    }
}
