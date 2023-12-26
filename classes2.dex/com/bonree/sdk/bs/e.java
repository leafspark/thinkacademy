package com.bonree.sdk.bs;

import android.os.HandlerThread;

public final class e extends HandlerThread {
    public e(String str) {
        this(str, 5);
    }

    private e(String str, int i) {
        super("BR-" + str + "-Thread", 5);
    }
}
