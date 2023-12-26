package com.bonree.sdk.agent.engine.webview;

import com.bonree.sdk.agent.engine.webview.a;
import com.bonree.sdk.common.gson.JsonElement;
import com.bonree.sdk.common.gson.JsonObject;
import com.bonree.sdk.common.gson.JsonParser;
import ohos.agp.components.webengine.JsCallback;

public class BonreeJsCallbackOhos implements JsCallback {
    /* synthetic */ BonreeJsCallbackOhos(byte b) {
        this();
    }

    public String onCallback(String str) {
        try {
            com.bonree.sdk.be.a.a().a("js origin data: %s", str);
            JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
            if (asJsonObject.has("webviewPerformanceTimingEvent")) {
                BonreeJavaScriptBridge.getInstance().webviewPerformanceTimingEvent(a(asJsonObject, "webviewPerformanceTimingEvent"), -1);
                return "";
            } else if (asJsonObject.has("ajaxPerformanceTimingEvent")) {
                BonreeJavaScriptBridge.getInstance().ajaxPerformanceTimingEvent(a(asJsonObject, "ajaxPerformanceTimingEvent"));
                return "";
            } else if (asJsonObject.has("webviewJSErrorEvent")) {
                BonreeJavaScriptBridge.getInstance().webviewJSErrorEvent(a(asJsonObject, "webviewJSErrorEvent"), -1);
                return "";
            } else if (asJsonObject.has("webviewPageEvent")) {
                BonreeJavaScriptBridge.getInstance().webviewPageEvent(a(asJsonObject, "webviewPageEvent"));
                return "";
            } else if (asJsonObject.has("webviewActionEvent")) {
                BonreeJavaScriptBridge.getInstance().webviewActionEvent(a(asJsonObject, "webviewActionEvent"));
                return "";
            } else if (asJsonObject.has("routeChangeData")) {
                BonreeJavaScriptBridge.getInstance().routeChangeData(a(asJsonObject, "routeChangeData"));
                return "";
            } else {
                a.C0005a.a.a(asJsonObject);
                return "";
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("js origin data is  format error: ", th);
            return "";
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

    static class a {
        /* access modifiers changed from: private */
        public static final BonreeJsCallbackOhos a = new BonreeJsCallbackOhos((byte) 0);

        private a() {
        }
    }

    private BonreeJsCallbackOhos() {
    }

    public static BonreeJsCallbackOhos getInstance() {
        return a.a;
    }
}
