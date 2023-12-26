package com.bonree.sdk.agent.engine.webview;

import com.bonree.sdk.common.gson.JsonElement;
import com.bonree.sdk.common.gson.JsonObject;
import com.bonree.sdk.common.gson.JsonParser;
import ohos.agp.components.webengine.JsCallback;

public final class a implements JsCallback {
    /* synthetic */ a(byte b) {
        this();
    }

    public final String onCallback(String str) {
        try {
            com.bonree.sdk.be.a.a().a("js origin custom data: %s", str);
            a(JsonParser.parseString(str).getAsJsonObject());
            return "";
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("js origin data is  format error: ", th);
            return "";
        }
    }

    public final void a(JsonObject jsonObject) {
        if (jsonObject != null) {
            if (jsonObject.has("setCustomRouteChangeData")) {
                BonreeCustomInterfaceBridge.getInstance().setCustomRouteChangeData(a(jsonObject, "setCustomRouteChangeData"));
            } else if (jsonObject.has("setCustomH5performanceData")) {
                BonreeCustomInterfaceBridge.getInstance().setCustomH5performanceData(a(jsonObject, "setCustomH5performanceData"));
            } else if (jsonObject.has("setUserID")) {
                BonreeCustomInterfaceBridge.getInstance().setUserID(a(jsonObject, "setUserID"));
            } else if (jsonObject.has("setExtraInfo")) {
                BonreeCustomInterfaceBridge.getInstance().setExtraInfo(a(jsonObject, "setExtraInfo"));
            } else if (jsonObject.has("setCustomEvent")) {
                JsonObject asJsonObject = jsonObject.get("setCustomEvent").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomEvent(a(asJsonObject, "eventId"), a(asJsonObject, "eventName"), a(asJsonObject, "eventParam"));
            } else if (jsonObject.has("setCustomEventWithLabel")) {
                JsonObject asJsonObject2 = jsonObject.get("setCustomEventWithLabel").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomEventWithLabel(a(asJsonObject2, "eventId"), a(asJsonObject2, "eventName"), a(asJsonObject2, "eventLabel"), a(asJsonObject2, "eventParam"));
            } else if (jsonObject.has("setCustomEventStart")) {
                JsonObject asJsonObject3 = jsonObject.get("setCustomEventStart").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomEventStart(a(asJsonObject3, "eventId"), a(asJsonObject3, "eventName"), a(asJsonObject3, "eventLabel"), a(asJsonObject3, "eventParam"));
            } else if (jsonObject.has("setCustomEventEnd")) {
                JsonObject asJsonObject4 = jsonObject.get("setCustomEventEnd").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomEventEnd(a(asJsonObject4, "eventId"), a(asJsonObject4, "eventName"), a(asJsonObject4, "eventLabel"), a(asJsonObject4, "eventParam"));
            } else if (jsonObject.has("setCustomLog")) {
                JsonObject asJsonObject5 = jsonObject.get("setCustomLog").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomLog(a(asJsonObject5, "logInfo"), a(asJsonObject5, "logParam"));
            } else if (jsonObject.has("setCustomMetric")) {
                JsonObject asJsonObject6 = jsonObject.get("setCustomMetric").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomMetric(a(asJsonObject6, "metricName"), a(asJsonObject6, "metricValue"), a(asJsonObject6, "metricParam"));
            } else if (jsonObject.has("setCustomPageStart")) {
                JsonObject asJsonObject7 = jsonObject.get("setCustomPageStart").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomPageStart(a(asJsonObject7, "pageName"), a(asJsonObject7, "param"));
            } else if (jsonObject.has("setCustomPageEnd")) {
                JsonObject asJsonObject8 = jsonObject.get("setCustomPageEnd").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomPageEnd(a(asJsonObject8, "pageName"), a(asJsonObject8, "param"));
            } else if (jsonObject.has("setCustomException")) {
                JsonObject asJsonObject9 = jsonObject.get("setCustomException").getAsJsonObject();
                BonreeCustomInterfaceBridge.getInstance().setCustomException(a(asJsonObject9, "exceptionType"), a(asJsonObject9, "causedBy"), a(asJsonObject9, "errorDump"));
            }
        }
    }

    private static String a(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return "";
        }
        if (jsonElement.isJsonObject()) {
            return jsonElement.toString();
        }
        return jsonElement.getAsString();
    }

    /* renamed from: com.bonree.sdk.agent.engine.webview.a$a  reason: collision with other inner class name */
    static class C0005a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);

        private C0005a() {
        }
    }

    private a() {
    }

    public static a a() {
        return C0005a.a;
    }
}
