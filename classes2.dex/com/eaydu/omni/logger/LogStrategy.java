package com.eaydu.omni.logger;

public interface LogStrategy {
    void log(int i, String str, String str2);

    void stop();
}
