package com.bonree.sdk.bonree_flutter_plugin;

import com.bonree.sdk.agent.Bonree;
import com.bonree.sdk.agent.engine.external.BonreeFlutterBridge;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;

public class BonreeFlutterPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static MethodChannel channel;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "bonree_flutter_plugin");
        channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        MethodChannel methodChannel = new MethodChannel(registrar.messenger(), "bonree_flutter_plugin");
        channel = methodChannel;
        methodChannel.setMethodCallHandler(new BonreeFlutterPlugin());
    }

    public static void setNetworkTraceConfig(Map map) {
        MethodChannel methodChannel;
        if (map != null && (methodChannel = channel) != null) {
            try {
                methodChannel.invokeMethod("setNetworkTraceConfig", map);
            } catch (Throwable unused) {
            }
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        try {
            if ("bonree_reportCrash".equals(methodCall2.method)) {
                BonreeFlutterBridge.reportCrash(((Long) methodCall2.argument("time")).longValue(), (String) methodCall2.argument("errorValue"), (String) methodCall2.argument("reason"), (String) methodCall2.argument("stacktrace"));
            } else if ("bonree_reportView".equals(methodCall2.method)) {
                BonreeFlutterBridge.reportFlutterView(((Long) methodCall2.argument("time")).longValue(), (String) methodCall2.argument("viewId"), ((Integer) methodCall2.argument("loadTime")).intValue(), ((Integer) methodCall2.argument("model")).intValue(), (String) methodCall2.argument(AppMeasurementSdk.ConditionalUserProperty.NAME), (String) methodCall2.argument(FirebaseAnalytics.Param.METHOD));
            } else if ("bonree_setCustomException".equals(methodCall2.method)) {
                Bonree.setCustomException((String) methodCall2.argument("exceptionType"), (String) methodCall2.argument("causedBy"), (String) methodCall2.argument("errorDump"));
            } else if ("bonree_setCustomPageStart".equals(methodCall2.method)) {
                Bonree.setCustomPageStart((String) methodCall2.argument("pageName"), (String) methodCall2.argument("pageAlias"));
            } else if ("bonree_setCustomPageEnd".equals(methodCall2.method)) {
                Bonree.setCustomPageEnd((String) methodCall2.argument("pageName"), (String) methodCall2.argument("pageAlias"));
            } else if ("bonree_setCustomEvent".equals(methodCall2.method)) {
                Bonree.setCustomEvent((String) methodCall2.argument("eventID"), (String) methodCall2.argument("eventName"), (String) methodCall2.argument("param"));
            } else if ("bonree_setCustomLog".equals(methodCall2.method)) {
                Bonree.setCustomLog((String) methodCall2.argument("logInfo"), (String) methodCall2.argument("param"));
            } else if ("bonree_setCustomMetric".equals(methodCall2.method)) {
                Object argument = methodCall2.argument("metricValue");
                if (argument instanceof Integer) {
                    Bonree.setCustomMetric((String) methodCall2.argument("metricName"), ((Integer) argument).longValue(), (String) methodCall2.argument("param"));
                } else if (argument instanceof Long) {
                    Bonree.setCustomMetric((String) methodCall2.argument("metricName"), ((Long) argument).longValue(), (String) methodCall2.argument("param"));
                }
            } else if ("bonree_setCustomMethodStart".equals(methodCall2.method)) {
                Bonree.setCustomMethodStart((String) methodCall2.argument("methodName"), (String) methodCall2.argument("param"));
            } else if ("bonree_setCustomMethodEnd".equals(methodCall2.method)) {
                Bonree.setCustomMethodEnd((String) methodCall2.argument("methodName"), (String) methodCall2.argument("param"));
            } else if ("bonree_setUserID".equals(methodCall2.method)) {
                Bonree.setUserID((String) methodCall2.argument("userID"));
            } else if ("bonree_setExtraInfo".equals(methodCall2.method)) {
                Bonree.setExtraInfo((Map) methodCall.arguments());
            } else if ("bonree_recordCustomLaunchEnd".equals(methodCall2.method)) {
                Bonree.recordCustomLaunchEnd();
            } else if ("bonree_reportNetwork".equals(methodCall2.method)) {
                BonreeFlutterBridge.reportNetwork((String) methodCall2.argument("requestUrl"), ((Long) methodCall2.argument("startTimeMs")).longValue(), ((Integer) methodCall2.argument("responseDataSize")).intValue(), (String) methodCall2.argument(FirebaseAnalytics.Param.METHOD), (String) methodCall2.argument("resourceType"), ((Integer) methodCall2.argument("connectTimeMs")).intValue(), ((Integer) methodCall2.argument("errorCode")).intValue(), ((Integer) methodCall2.argument("responseTimeMs")).intValue(), (String) methodCall2.argument("errorMessage"), (Map) methodCall2.argument("httpRequestHeader"), (Map) methodCall2.argument("httpResponseHeader"));
            } else if ("bonree_getNetworkTraceConfig".equals(methodCall2.method)) {
                result.success(BonreeFlutterBridge.getNetworkTraceConfig());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
