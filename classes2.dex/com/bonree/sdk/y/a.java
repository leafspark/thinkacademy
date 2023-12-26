package com.bonree.sdk.y;

import com.bonree.sdk.g.b;

public final class a extends b {
    public static String l = "onStart";
    public static String m = "onStop";
    public static String n = "onActive";
    public static String o = "onForeground";
    public static String p = "onInactive";
    private int q;
    private boolean r;
    private boolean s;

    public final int q() {
        return this.q;
    }

    public final void d(int i) {
        this.q = i;
    }

    private boolean r() {
        return this.r;
    }

    public final void c(boolean z) {
        this.r = z;
    }

    private boolean s() {
        return this.s;
    }

    public final void d(boolean z) {
        this.s = z;
    }

    public final String o() {
        return super.o() + this.q;
    }

    public final String toString() {
        return "FragmentData{hashCode=" + this.q + ", isVisibleToUser=" + this.r + ", isHiddenChanged=" + this.s + ", abilityName='" + this.a + '\'' + ", fragmentName='" + this.b + '\'' + ", methodName='" + this.c + '\'' + ", methodType=" + this.d + ", methodStatus=" + this.e + ", methodTime=" + this.f + ", methodTimeStamp=" + this.g + ", threadId=" + this.h + ", threadName='" + this.i + '\'' + ", isMain=" + this.j + '}';
    }
}
