package com.tal.app.thinkacademy.lib.logger;

public class XesThreadFormatter implements XesLogFormatter<Thread> {
    public String format(Thread thread) {
        return "Thread:" + thread.getName();
    }
}
