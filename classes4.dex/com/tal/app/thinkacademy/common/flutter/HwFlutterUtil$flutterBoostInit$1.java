package com.tal.app.thinkacademy.common.flutter;

import android.app.Activity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/flutter/HwFlutterUtil$flutterBoostInit$1", "Lcom/idlefish/flutterboost/FlutterBoostDelegate;", "pushFlutterRoute", "", "options", "Lcom/idlefish/flutterboost/FlutterBoostRouteOptions;", "pushNativeRoute", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwFlutterUtil.kt */
public final class HwFlutterUtil$flutterBoostInit$1 implements FlutterBoostDelegate {
    public /* synthetic */ boolean popRoute(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        return FlutterBoostDelegate.-CC.$default$popRoute(this, flutterBoostRouteOptions);
    }

    HwFlutterUtil$flutterBoostInit$1() {
    }

    public void pushNativeRoute(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        Intrinsics.checkNotNullParameter(flutterBoostRouteOptions, "options");
        XesLog.i(HwFlutterUtil.TAG, Intrinsics.stringPlus("收到flutter传来的跳转原生页面的消息,pageName=", flutterBoostRouteOptions.pageName()));
        HwFlutterUtil.INSTANCE.goToNativePage(flutterBoostRouteOptions);
    }

    public void pushFlutterRoute(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(flutterBoostRouteOptions, "options");
        if (flutterBoostRouteOptions.arguments() != null) {
            Map arguments = flutterBoostRouteOptions.arguments();
            Objects.requireNonNull(arguments, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            hashMap = (HashMap) arguments;
        } else {
            hashMap = new HashMap();
        }
        HwFlutterUtil hwFlutterUtil = HwFlutterUtil.INSTANCE;
        Activity currentActivity = FlutterBoost.instance().currentActivity();
        Intrinsics.checkNotNullExpressionValue(currentActivity, "instance().currentActivity()");
        String pageName = flutterBoostRouteOptions.pageName();
        Intrinsics.checkNotNullExpressionValue(pageName, "options.pageName()");
        hwFlutterUtil.startFlutterActivity(currentActivity, pageName, hashMap, flutterBoostRouteOptions.uniqueId());
    }
}
