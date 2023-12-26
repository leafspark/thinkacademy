package io.flutter.plugins;

import com.bonree.sdk.bonree_flutter_plugin.BonreeFlutterPlugin;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.sameer.flutterstatusbarcolor.flutterstatusbarcolor.FlutterStatusbarcolorPlugin;
import com.tekartik.sqflite.SqflitePlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin;

public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new BonreeFlutterPlugin());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin bonree_flutter_plugin, com.bonree.sdk.bonree_flutter_plugin.BonreeFlutterPlugin", e);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterBoostPlugin());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin flutter_boost, com.idlefish.flutterboost.FlutterBoostPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterStatusbarcolorPlugin());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin flutter_statusbarcolor_ns, com.sameer.flutterstatusbarcolor.flutterstatusbarcolor.FlutterStatusbarcolorPlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterToastPlugin());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharedPreferencesPlugin());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SqflitePlugin());
        } catch (Exception e7) {
            Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e7);
        }
    }
}
