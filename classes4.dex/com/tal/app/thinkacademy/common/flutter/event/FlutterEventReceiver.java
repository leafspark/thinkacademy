package com.tal.app.thinkacademy.common.flutter.event;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventReceiver;", "", "getEventKey", "", "onEventReceive", "", "data", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlutterEventDispatcher.kt */
public interface FlutterEventReceiver {
    String getEventKey();

    void onEventReceive(Object obj);
}
