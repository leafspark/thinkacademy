package com.didi.hummer;

import android.content.Context;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.context.HummerContextFactory;
import com.didi.hummer.core.util.HMLog;
import com.didi.hummer.debug.plugin.IHermesDebugger;
import com.didi.hummer.debug.plugin.IV8Debugger;
import com.didi.hummer.register.HummerRegister$$hummer_component;
import com.didi.hummer.render.style.HummerLayout;

public class Hummer {
    public static boolean isSupport(Context context, int i) {
        return HummerSDK.isSupport(context, i);
    }

    public static void setJsEngine(int i) {
        HummerSDK.setJsEngine(i);
    }

    public static void init(Context context) {
        init(context, (HummerConfig) null);
    }

    public static void init(Context context, HummerConfig hummerConfig) {
        HummerSDK.init(context, hummerConfig);
    }

    public static void release() {
        HummerSDK.release();
    }

    public static void initV8Debugger(IV8Debugger iV8Debugger) {
        HummerSDK.initV8Debugger(iV8Debugger);
    }

    public static IV8Debugger getV8Debugger() {
        return HummerSDK.getV8Debugger();
    }

    public static void initHermesDebugger(IHermesDebugger iHermesDebugger) {
        HummerSDK.initHermesDebugger(iHermesDebugger);
    }

    public static void initHermesDebugger(IHermesDebugger iHermesDebugger, int i) {
        HummerSDK.initHermesDebugger(iHermesDebugger, i);
    }

    public static IHermesDebugger getHermesDebugger() {
        return HummerSDK.getHermesDebugger();
    }

    public static HummerContext createContext(HummerLayout hummerLayout) {
        return createContext(hummerLayout, (String) null);
    }

    public static HummerContext createContext(HummerLayout hummerLayout, String str) {
        HMLog.d("HummerNative", "HummerContext.createContext");
        HummerContext createContext = HummerContextFactory.createContext(hummerLayout, str);
        HummerRegister$$hummer_component.init(createContext);
        return createContext;
    }
}
