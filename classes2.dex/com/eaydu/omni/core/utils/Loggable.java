package com.eaydu.omni.core.utils;

import com.eaydu.omni.core.utils.Logging;

public interface Loggable {
    void onLogMessage(String str, Logging.Severity severity, String str2);
}
