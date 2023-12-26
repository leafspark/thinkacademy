package com.kwai.koom.base;

import android.app.Application;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.kwai.koom.base.Logger;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u000f\u001a\u00020\u0000\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0007J)\u0010\u0016\u001a\u0002H\u0010\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0005H\u0007¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0007J$\u0010\u001a\u001a\u00020\u001b\"\f\b\u0000\u0010\u0010*\u0006\u0012\u0002\b\u00030\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0005H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010\u001f\u001a\u00020\u001d\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0\u0006H\u0002R(\u0010\u0003\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/kwai/koom/base/MonitorManager;", "", "()V", "MONITOR_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/kwai/koom/base/Monitor;", "getMONITOR_MAP$koom_monitor_base_SharedCppRelease", "()Ljava/util/concurrent/ConcurrentHashMap;", "commonConfig", "Lcom/kwai/koom/base/CommonConfig;", "getCommonConfig$koom_monitor_base_SharedCppRelease", "()Lcom/kwai/koom/base/CommonConfig;", "setCommonConfig$koom_monitor_base_SharedCppRelease", "(Lcom/kwai/koom/base/CommonConfig;)V", "addMonitorConfig", "M", "Lcom/kwai/koom/base/MonitorConfig;", "config", "(Lcom/kwai/koom/base/MonitorConfig;)Lcom/kwai/koom/base/MonitorManager;", "getApplication", "Landroid/app/Application;", "getMonitor", "clazz", "(Ljava/lang/Class;)Lcom/kwai/koom/base/Monitor;", "initCommonConfig", "isInitialized", "", "onApplicationCreate", "", "registerMonitorEventObserver", "logMonitorEvent", "C", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorManager.kt */
public final class MonitorManager {
    public static final MonitorManager INSTANCE = new MonitorManager();
    private static final ConcurrentHashMap<Class<?>, Monitor<?>> MONITOR_MAP = new ConcurrentHashMap<>();
    public static CommonConfig commonConfig;

    private MonitorManager() {
    }

    public final ConcurrentHashMap<Class<?>, Monitor<?>> getMONITOR_MAP$koom_monitor_base_SharedCppRelease() {
        return MONITOR_MAP;
    }

    public final CommonConfig getCommonConfig$koom_monitor_base_SharedCppRelease() {
        CommonConfig commonConfig2 = commonConfig;
        if (commonConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonConfig");
        }
        return commonConfig2;
    }

    public final void setCommonConfig$koom_monitor_base_SharedCppRelease(CommonConfig commonConfig2) {
        Intrinsics.checkNotNullParameter(commonConfig2, "<set-?>");
        commonConfig = commonConfig2;
    }

    @JvmStatic
    public static final MonitorManager initCommonConfig(CommonConfig commonConfig2) {
        Intrinsics.checkNotNullParameter(commonConfig2, "commonConfig");
        MonitorManager monitorManager = INSTANCE;
        commonConfig = commonConfig2;
        return monitorManager;
    }

    @JvmStatic
    public static final <M extends MonitorConfig<?>> MonitorManager addMonitorConfig(M m) {
        Monitor monitor;
        Intrinsics.checkNotNullParameter(m, "config");
        MonitorManager monitorManager = INSTANCE;
        Type genericSuperclass = m.getClass().getGenericSuperclass();
        while (genericSuperclass instanceof Class) {
            genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
        }
        if (genericSuperclass instanceof ParameterizedType) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<com.kwai.koom.base.Monitor<M>>");
            Class cls = (Class) type;
            if (!MONITOR_MAP.containsKey(cls)) {
                try {
                    Object obj = cls.getDeclaredField("INSTANCE").get((Object) null);
                    if (obj != null) {
                        monitor = (Monitor) obj;
                        MONITOR_MAP.put(cls, monitor);
                        CommonConfig commonConfig2 = commonConfig;
                        if (commonConfig2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("commonConfig");
                        }
                        monitor.init(commonConfig2, m);
                        monitorManager.logMonitorEvent(monitor);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.kwai.koom.base.Monitor<M>");
                    }
                } catch (Throwable unused) {
                    Object newInstance = cls.newInstance();
                    Objects.requireNonNull(newInstance, "null cannot be cast to non-null type com.kwai.koom.base.Monitor<M>");
                    monitor = (Monitor) newInstance;
                }
            }
            return monitorManager;
        }
        throw new RuntimeException("config must be parameterized");
    }

    @JvmStatic
    public static final Application getApplication() {
        CommonConfig commonConfig2 = commonConfig;
        if (commonConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonConfig");
        }
        return commonConfig2.getApplication();
    }

    @JvmStatic
    @Deprecated(message = "Use Monitor Directly")
    public static final <M extends Monitor<?>> M getMonitor(Class<M> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        M m = MONITOR_MAP.get(cls);
        Objects.requireNonNull(m, "null cannot be cast to non-null type M");
        return (Monitor) m;
    }

    @JvmStatic
    @Deprecated(message = "Use Monitor#isInitialized Directly")
    public static final <M extends Monitor<?>> boolean isInitialized(Class<M> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return MONITOR_MAP.get(cls) != null;
    }

    @JvmStatic
    public static final void onApplicationCreate() {
        Monitor_ApplicationKt.registerApplicationExtension();
        INSTANCE.registerMonitorEventObserver();
    }

    private final void registerMonitorEventObserver() {
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(new MonitorManager$registerMonitorEventObserver$1());
    }

    private final <C> void logMonitorEvent(Monitor<C> monitor) {
        if (Monitor_ApplicationKt.isForeground(getApplication())) {
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(monitor.getLogParams());
            Logger logger = MonitorLogger.INSTANCE;
            JSONObject jSONObject = new JSONObject(linkedHashMap);
            Logger.DefaultImpls.addCustomStatEvent$default(logger, "switch-stat", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), false, 4, (Object) null);
        }
    }
}
