package com.tal.app.thinkacademy.common.flutter.event.impl;

import com.tal.app.thinkacademy.common.flutter.event.FlutterEventReceiver;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.route.FlutterToModuleService;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/event/impl/SwitchSchoolEventReceiver;", "Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventReceiver;", "()V", "getEventKey", "", "onEventReceive", "", "data", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchSchoolEventReceiver.kt */
public final class SwitchSchoolEventReceiver implements FlutterEventReceiver {
    public String getEventKey() {
        return "dialogSwitchSchool";
    }

    public void onEventReceive(Object obj) {
        FlutterToModuleService flutterToModuleService = (FlutterToModuleService) XesRoute.getInstance().get(RouteMap.ROUTE_STUDY_SERVICE);
        if (flutterToModuleService != null) {
            flutterToModuleService.onEvent("dialogSwitchSchool", obj);
        }
    }
}
