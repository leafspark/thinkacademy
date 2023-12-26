package com.idlefish.flutterboost.containers;

import android.app.Activity;
import java.util.Map;

public interface FlutterViewContainer {

    /* renamed from: com.idlefish.flutterboost.containers.FlutterViewContainer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$detachFromEngineIfNeeded(FlutterViewContainer flutterViewContainer) {
        }

        public static boolean $default$isOpaque(FlutterViewContainer flutterViewContainer) {
            return true;
        }

        public static boolean $default$isPausing(FlutterViewContainer flutterViewContainer) {
            return false;
        }
    }

    void detachFromEngineIfNeeded();

    void finishContainer(Map<String, Object> map);

    Activity getContextActivity();

    String getUniqueId();

    String getUrl();

    Map<String, Object> getUrlParams();

    boolean isOpaque();

    boolean isPausing();
}
