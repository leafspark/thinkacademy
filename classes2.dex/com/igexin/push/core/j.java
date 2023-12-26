package com.igexin.push.core;

public enum j {
    HEARTBEAT_OK,
    HEARTBEAT_TIMEOUT,
    NETWORK_ERROR,
    NETWORK_SWITCH;

    public static j[] a() {
        return (j[]) e.clone();
    }
}
