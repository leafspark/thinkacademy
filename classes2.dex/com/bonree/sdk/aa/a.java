package com.bonree.sdk.aa;

import com.bonree.sdk.g.b;

public final class a extends b {
    public static String l = "onCreate";
    public static String m = "onViewCreated";
    public static String n = "onActivityCreated";
    public static String o = "onStart";
    public static String p = "onResume";
    public static String q = "setUserVisibleHint";
    public static String r = "onHiddenChanged";
    public static String s = "onPause";
    private int t;
    private boolean u;
    private boolean v;

    public final int q() {
        return this.t;
    }

    public final void d(int i) {
        this.t = i;
    }

    private boolean r() {
        return this.u;
    }

    public final void c(boolean z) {
        this.u = z;
    }

    private boolean s() {
        return this.v;
    }

    public final void d(boolean z) {
        this.v = z;
    }

    public a() {
        this.h = String.valueOf(Thread.currentThread().getId());
    }

    public final String o() {
        return super.o() + this.t;
    }

    public final String toString() {
        return "FragmentData{hashCode=" + this.t + ", isVisibleToUser=" + this.u + ", isHiddenChanged=" + this.v + ", activityName='" + this.a + '\'' + ", fragmentName='" + this.b + '\'' + ", methodName='" + this.c + '\'' + ", methodType=" + this.d + ", methodStatus=" + this.e + ", methodTime=" + this.f + ", methodTimeStamp=" + this.g + ", threadId=" + this.h + ", threadName='" + this.i + '\'' + ", isMain=" + this.j + '}';
    }
}
