package com.tal.app.thinkacademy.common.flutter.event;

import com.tal.app.thinkacademy.common.flutter.event.FlutterEventDispatcher;
import com.tal.app.thinkacademy.common.flutter.event.impl.LoginExpireEventReceiver;
import com.tal.app.thinkacademy.common.flutter.event.impl.ShowClassTypeEventReceiver;
import com.tal.app.thinkacademy.common.flutter.event.impl.SwitchAccountEventReceiver;
import com.tal.app.thinkacademy.common.flutter.event.impl.SwitchSchoolEventReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"init", "", "Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventDispatcher$Companion;", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlutterEventDispatcher.kt */
public final class FlutterEventDispatcherKt {
    public static final void init(FlutterEventDispatcher.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        companion.get().clean$common_release();
        companion.get().register(new SwitchAccountEventReceiver());
        companion.get().register(new SwitchSchoolEventReceiver());
        companion.get().register(new ShowClassTypeEventReceiver());
        companion.get().register(new LoginExpireEventReceiver());
    }
}
