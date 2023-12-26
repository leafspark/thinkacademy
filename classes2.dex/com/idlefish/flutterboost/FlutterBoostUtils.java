package com.idlefish.flutterboost;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FlutterBoostUtils {
    public static String createUniqueId(String str) {
        return UUID.randomUUID().toString() + "_" + str;
    }

    public static FlutterBoostPlugin getPlugin(FlutterEngine flutterEngine) {
        if (flutterEngine == null) {
            return null;
        }
        try {
            return flutterEngine.getPlugins().get(Class.forName("com.idlefish.flutterboost.FlutterBoostPlugin"));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> bundleToMap(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && !bundle.keySet().isEmpty()) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    hashMap.put(str, bundleToMap(bundle.getBundle(str)));
                } else if (obj != null) {
                    hashMap.put(str, obj);
                }
            }
        }
        return hashMap;
    }

    public static FlutterView findFlutterView(View view) {
        if (view instanceof FlutterView) {
            return (FlutterView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            FlutterView findFlutterView = findFlutterView(viewGroup.getChildAt(i));
            if (findFlutterView != null) {
                return findFlutterView;
            }
        }
        return null;
    }
}
