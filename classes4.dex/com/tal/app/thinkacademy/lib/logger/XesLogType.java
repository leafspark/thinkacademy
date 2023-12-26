package com.tal.app.thinkacademy.lib.logger;

public enum XesLogType {
    I(1, 4),
    W(2, 5),
    E(3, 6),
    S(4, 4),
    A(5, 4);
    
    private final int logType;
    private final int loganType;

    private XesLogType(int i, int i2) {
        this.loganType = i;
        this.logType = i2;
    }

    public int getLoganType() {
        return this.loganType;
    }

    public int getLogType() {
        return this.logType;
    }
}
