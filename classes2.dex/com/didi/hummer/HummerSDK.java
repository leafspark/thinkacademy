package com.didi.hummer;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.didi.hummer.HummerConfig;
import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.navigator.impl.ActivityStackManager;
import com.didi.hummer.adapter.tracker.ITrackerAdapter;
import com.didi.hummer.adapter.tracker.SDKInfo;
import com.didi.hummer.core.engine.jsc.jni.HummerException;
import com.didi.hummer.core.engine.napi.jni.JSException;
import com.didi.hummer.core.exception.ExceptionCallback;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.debug.plugin.IHermesDebugger;
import com.didi.hummer.debug.plugin.IV8Debugger;
import com.didi.hummer.tools.EventTracer;
import com.didi.hummer.tools.JSLogger;
import com.didi.hummer.utils.EnvUtil;
import com.didi.hummer.utils.blankj.Utils;
import com.facebook.soloader.SoLoader;
import com.getkeepsafe.relinker.ReLinker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class HummerSDK {
    public static final String NAMESPACE_DEFAULT = "_HUMMER_SDK_NAMESPACE_DEFAULT_";
    public static Context appContext = null;
    private static Map<String, HummerConfig> configs = new HashMap();
    private static IHermesDebugger hermesDebugger = null;
    private static volatile boolean isInited = false;
    private static volatile boolean isSdkInfoTracked = false;
    private static int jsEngine = 5;
    private static SDKInfo sdkInfo = new SDKInfo();
    private static IV8Debugger v8Debugger;

    @Retention(RetentionPolicy.SOURCE)
    public @interface JsEngine {
        public static final int HERMES = 4;
        public static final int JSC = 1;
        public static final int NAPI_HERMES = 6;
        public static final int NAPI_QJS = 5;
        public static final int QUICK_JS = 2;
        public static final int V8 = 3;
    }

    public static boolean isSupport(Context context, int i) {
        return loadJSEngine(context, i);
    }

    public static void setJsEngine(int i) {
        jsEngine = i;
    }

    public static int getJsEngine() {
        return jsEngine;
    }

    public static void init(Context context) {
        init(context, (HummerConfig) null);
    }

    public static void init(Context context, HummerConfig hummerConfig) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!isInited) {
            Context applicationContext = context.getApplicationContext();
            appContext = applicationContext;
            parseAppDebuggable(applicationContext);
            Utils.init((Application) appContext);
            ActivityStackManager.getInstance().register((Application) appContext);
            loadYogaEngine();
            loadJSEngine(appContext, jsEngine);
            int i = jsEngine;
            if (i == 5 || i == 6) {
                JSException.init();
            } else {
                HummerException.init();
            }
            EnvUtil.initHummerEnv(appContext);
            isInited = true;
            sdkInfo.jsEngine = jsEngine;
            sdkInfo.isSdkInitSuccess = true;
            sdkInfo.sdkInitTimeCost = System.currentTimeMillis() - currentTimeMillis;
        }
        addHummerConfig(hummerConfig);
        ITrackerAdapter trackerAdapter = HummerAdapter.getTrackerAdapter(hummerConfig != null ? hummerConfig.getNamespace() : null);
        if (!isSdkInfoTracked && trackerAdapter != null) {
            trackerAdapter.trackSDKInfo(sdkInfo);
            trackerAdapter.trackEvent(ITrackerAdapter.EventName.SDK_INIT, (Map<String, Object>) null);
            isSdkInfoTracked = true;
        }
    }

    public static void release() {
        ActivityStackManager.getInstance().unRegister((Application) appContext);
        configs.clear();
        isInited = false;
    }

    public static void initV8Debugger(IV8Debugger iV8Debugger) {
        if (v8Debugger == null) {
            v8Debugger = iV8Debugger;
        }
    }

    public static IV8Debugger getV8Debugger() {
        return v8Debugger;
    }

    public static void initHermesDebugger(IHermesDebugger iHermesDebugger) {
        initHermesDebugger(iHermesDebugger, 6);
    }

    public static void initHermesDebugger(IHermesDebugger iHermesDebugger, int i) {
        if (hermesDebugger == null) {
            setJsEngine(i);
            hermesDebugger = iHermesDebugger;
        }
    }

    public static IHermesDebugger getHermesDebugger() {
        return hermesDebugger;
    }

    private static void addHummerConfig(HummerConfig hummerConfig) {
        if (hummerConfig != null) {
            String namespace = hummerConfig.getNamespace();
            HummerConfig hummerConfig2 = configs.get(namespace);
            if (hummerConfig2 == null || TextUtils.isEmpty(hummerConfig2.getNamespace())) {
                configs.put(namespace, hummerConfig);
            } else if (DebugUtil.isDebuggable()) {
                Context context = appContext;
                Toast.makeText(context, "There is already a duplicate namespace: " + namespace, 0).show();
            }
        }
        if (!configs.containsKey(NAMESPACE_DEFAULT)) {
            configs.put(NAMESPACE_DEFAULT, new HummerConfig.Builder().setNamespace((String) null).builder());
        }
    }

    public static HummerConfig getHummerConfig(String str) {
        if (TextUtils.isEmpty(str) || !configs.containsKey(str)) {
            str = NAMESPACE_DEFAULT;
        }
        if (!configs.containsKey(NAMESPACE_DEFAULT)) {
            configs.put(NAMESPACE_DEFAULT, new HummerConfig.Builder().setNamespace((String) null).builder());
        }
        return configs.get(str);
    }

    private static void loadYogaEngine() {
        try {
            SoLoader.init(appContext, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean loadJSEngine(Context context, int i) {
        if (i == 1) {
            ReLinker.loadLibrary(context, "hummer-jsc");
        } else if (i == 4) {
            ReLinker.loadLibrary(context, "hummer-hermes");
        } else if (i != 5 && i != 6) {
            try {
                ReLinker.loadLibrary(context, "hummer-qjs");
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        } else if (getHermesDebugger() != null) {
            ReLinker.loadLibrary(context, "hummer-napi-debugger");
        } else {
            ReLinker.loadLibrary(context, "hummer-napi");
        }
        return true;
    }

    private static void parseAppDebuggable(Context context) {
        try {
            DebugUtil.setDebuggable((context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSLogger.Logger getJSLogger(String str) {
        return getHummerConfig(str).getJsLogger();
    }

    public static EventTracer.Trace getEventTracer(String str) {
        return getHummerConfig(str).getEventTracer();
    }

    public static ExceptionCallback getException(String str) {
        return getHummerConfig(str).getExceptionCallback();
    }

    public static boolean isSupportRTL(String str) {
        return getHummerConfig(str).isSupportRTL();
    }

    public static boolean isSupportBytecode(String str) {
        return getHummerConfig(str).isSupportBytecode();
    }

    public static String getFontsAssetsPath(String str) {
        return getHummerConfig(str).getFontsAssetsPath();
    }
}
