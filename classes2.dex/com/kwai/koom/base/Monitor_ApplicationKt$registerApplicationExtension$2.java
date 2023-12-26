package com.kwai.koom.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.kwai.koom.base.Monitor_ApplicationKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/kwai/koom/base/Monitor_ApplicationKt$registerApplicationExtension$2", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: Monitor_Application.kt */
public final class Monitor_ApplicationKt$registerApplicationExtension$2 implements LifecycleEventObserver {
    Monitor_ApplicationKt$registerApplicationExtension$2() {
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = Monitor_ApplicationKt.WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            Monitor_ApplicationKt._isForeground = true;
        } else if (i == 2) {
            Monitor_ApplicationKt._isForeground = false;
        }
        Iterator it = Monitor_ApplicationKt._lifecycleEventObservers.iterator();
        while (it.hasNext()) {
            ((LifecycleEventObserver) it.next()).onStateChanged(lifecycleOwner, event);
        }
    }
}
