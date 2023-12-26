package com.idlefish.flutterboost;

public interface FlutterBoostDelegate {

    /* renamed from: com.idlefish.flutterboost.FlutterBoostDelegate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$popRoute(FlutterBoostDelegate flutterBoostDelegate, FlutterBoostRouteOptions flutterBoostRouteOptions) {
            return false;
        }
    }

    boolean popRoute(FlutterBoostRouteOptions flutterBoostRouteOptions);

    void pushFlutterRoute(FlutterBoostRouteOptions flutterBoostRouteOptions);

    void pushNativeRoute(FlutterBoostRouteOptions flutterBoostRouteOptions);
}
