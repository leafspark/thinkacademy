package com.tal.app.thinkacademy.common.flutter.event;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventDispatcher;", "", "()V", "mEventMap", "Ljava/util/HashMap;", "", "Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventReceiver;", "Lkotlin/collections/HashMap;", "clean", "", "clean$common_release", "dispatch", "", "key", "args", "register", "receiver", "unregister", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlutterEventDispatcher.kt */
public final class FlutterEventDispatcher {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<FlutterEventDispatcher> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FlutterEventDispatcher$Companion$instance$2.INSTANCE);
    private final HashMap<String, FlutterEventReceiver> mEventMap = new HashMap<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventDispatcher$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventDispatcher;", "getInstance", "()Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "get", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlutterEventDispatcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final FlutterEventDispatcher getInstance() {
            return (FlutterEventDispatcher) FlutterEventDispatcher.instance$delegate.getValue();
        }

        public final FlutterEventDispatcher get() {
            return getInstance();
        }
    }

    public static /* synthetic */ boolean dispatch$default(FlutterEventDispatcher flutterEventDispatcher, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return flutterEventDispatcher.dispatch(str, obj);
    }

    public final boolean dispatch(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        FlutterEventReceiver flutterEventReceiver = this.mEventMap.get(str);
        if (flutterEventReceiver == null) {
            return false;
        }
        flutterEventReceiver.onEventReceive(obj);
        return true;
    }

    public final void register(FlutterEventReceiver flutterEventReceiver) {
        Intrinsics.checkNotNullParameter(flutterEventReceiver, "receiver");
        if (this.mEventMap.containsKey(flutterEventReceiver.getEventKey())) {
            XesLog.et("FlutterEventDispatcher", "register: " + flutterEventReceiver.getEventKey() + " is already registered");
            return;
        }
        this.mEventMap.put(flutterEventReceiver.getEventKey(), flutterEventReceiver);
    }

    public final void unregister(FlutterEventReceiver flutterEventReceiver) {
        Intrinsics.checkNotNullParameter(flutterEventReceiver, "receiver");
        this.mEventMap.remove(flutterEventReceiver.getEventKey());
    }

    public final void clean$common_release() {
        this.mEventMap.clear();
    }
}
