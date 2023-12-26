package com.eaydu.omni.log;

public class LogMessage {
    private int TRYTIMES = 3;
    public int delayTime;
    public Object param;
    public long timestamp;

    public LogMessage(Object obj) {
        this.param = obj;
        this.delayTime = 3;
        this.timestamp = System.currentTimeMillis();
    }
}
