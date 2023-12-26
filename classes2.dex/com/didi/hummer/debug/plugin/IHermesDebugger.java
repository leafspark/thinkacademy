package com.didi.hummer.debug.plugin;

public interface IHermesDebugger {
    void disableDebugging(long j);

    void enableDebugging(long j, String str);
}
