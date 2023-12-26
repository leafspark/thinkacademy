package com.kwai.koom.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.kwai.koom.base.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"com/kwai/koom/base/MonitorManager$registerMonitorEventObserver$1", "Landroidx/lifecycle/LifecycleEventObserver;", "mHasLogMonitorEvent", "", "logAllMonitorEvent", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorManager.kt */
public final class MonitorManager$registerMonitorEventObserver$1 implements LifecycleEventObserver {
    private boolean mHasLogMonitorEvent;

    MonitorManager$registerMonitorEventObserver$1() {
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            logAllMonitorEvent();
        }
    }

    private final void logAllMonitorEvent() {
        if (!this.mHasLogMonitorEvent) {
            this.mHasLogMonitorEvent = true;
            Map linkedHashMap = new LinkedHashMap();
            for (Map.Entry value : MonitorManager.INSTANCE.getMONITOR_MAP$koom_monitor_base_SharedCppRelease().entrySet()) {
                linkedHashMap.putAll(((Monitor) value.getValue()).getLogParams());
            }
            Logger logger = MonitorLogger.INSTANCE;
            JSONObject jSONObject = new JSONObject(linkedHashMap);
            Logger.DefaultImpls.addCustomStatEvent$default(logger, "switch-stat", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), false, 4, (Object) null);
        }
    }
}
