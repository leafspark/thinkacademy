package com.bonree.sdk.common.onlineTools;

import com.bonree.sdk.bs.s;

public class PingInstructionTool {
    public native PingResultBean nativePing(String str, int i, int i2, boolean z);

    public PingInstructionTool() {
        if (!s.a().c()) {
            s.a().e();
        }
    }

    public PingResultBean ping(String str, int i, int i2, boolean z) {
        if (!s.a().c()) {
            return null;
        }
        return nativePing(str, i, i2, z);
    }
}
