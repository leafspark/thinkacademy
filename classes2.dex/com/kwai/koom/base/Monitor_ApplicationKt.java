package com.kwai.koom.base;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0006\u0010\u0010\u001a\u00020\u0004\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007\u001a\u0012\u0010\u0013\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007\"\u0016\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\b\u001a\u0004\u0018\u00010\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\u0004*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"_currentActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "_isForeground", "", "_lifecycleEventObservers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/LifecycleEventObserver;", "currentActivity", "Landroid/app/Application;", "getCurrentActivity", "(Landroid/app/Application;)Landroid/app/Activity;", "isForeground", "(Landroid/app/Application;)Z", "registerApplicationExtension", "", "sdkVersionMatch", "registerProcessLifecycleObserver", "observer", "unregisterProcessLifecycleObserver", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_Application.kt */
public final class Monitor_ApplicationKt {
    /* access modifiers changed from: private */
    public static WeakReference<Activity> _currentActivity;
    /* access modifiers changed from: private */
    public static boolean _isForeground;
    /* access modifiers changed from: private */
    public static final CopyOnWriteArrayList<LifecycleEventObserver> _lifecycleEventObservers = new CopyOnWriteArrayList<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        }
    }

    public static final Activity getCurrentActivity(Application application) {
        Intrinsics.checkNotNullParameter(application, "$this$currentActivity");
        WeakReference<Activity> weakReference = _currentActivity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public static final boolean isForeground(Application application) {
        Intrinsics.checkNotNullParameter(application, "$this$isForeground");
        return _isForeground;
    }

    public static final boolean registerProcessLifecycleObserver(Application application, LifecycleEventObserver lifecycleEventObserver) {
        Intrinsics.checkNotNullParameter(application, "$this$registerProcessLifecycleObserver");
        Intrinsics.checkNotNullParameter(lifecycleEventObserver, "observer");
        return _lifecycleEventObservers.add(lifecycleEventObserver);
    }

    public static final boolean unregisterProcessLifecycleObserver(Application application, LifecycleEventObserver lifecycleEventObserver) {
        Intrinsics.checkNotNullParameter(application, "$this$unregisterProcessLifecycleObserver");
        Intrinsics.checkNotNullParameter(lifecycleEventObserver, "observer");
        return _lifecycleEventObservers.remove(lifecycleEventObserver);
    }

    public static final boolean sdkVersionMatch() {
        return MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getSdkVersionMatch$koom_monitor_base_SharedCppRelease();
    }

    public static final void registerApplicationExtension() {
        MonitorManager.getApplication().registerActivityLifecycleCallbacks(new Monitor_ApplicationKt$registerApplicationExtension$1());
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(new Monitor_ApplicationKt$registerApplicationExtension$2());
    }
}
