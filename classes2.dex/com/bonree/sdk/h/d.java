package com.bonree.sdk.h;

public enum d {
    WAKELOCK(1),
    ALARM(2),
    LOCATION(3),
    BLUETOOTH(9),
    WiFi(10);
    
    private final int a;

    private d(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }
}
