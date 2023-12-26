package com.didi.hummer;

import com.didi.hummer.context.HummerContext;
import com.didi.hummer.utils.NetworkUtil;

public class HummerDebugger {
    public static void init(HummerContext hummerContext, String str) {
        if (HummerSDK.getHermesDebugger() != null) {
            Hummer.getHermesDebugger().enableDebugging(hummerContext.getJsContext().getIdentify(), str);
        }
        if (HummerSDK.getV8Debugger() != null) {
            NetworkUtil.httpGet(str, new HummerDebugger$$ExternalSyntheticLambda0(str));
        }
    }

    public static void release(HummerContext hummerContext) {
        if (HummerSDK.getHermesDebugger() != null) {
            Hummer.getHermesDebugger().disableDebugging(hummerContext.getJsContext().getIdentify());
        }
    }
}
