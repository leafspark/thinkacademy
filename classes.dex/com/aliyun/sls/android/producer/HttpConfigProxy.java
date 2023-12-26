package com.aliyun.sls.android.producer;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import java.util.LinkedHashMap;
import java.util.Map;

public final class HttpConfigProxy {
    private static final Map<String, String> PLUGIN_USER_AGENTS = new LinkedHashMap();

    static {
        addPluginUserAgent("sls-android-sdk", "2.5.25");
    }

    private HttpConfigProxy() {
    }

    public static void addPluginUserAgent(String str, String str2) {
        PLUGIN_USER_AGENTS.put(str, str2);
    }

    public static String getUserAgent() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : PLUGIN_USER_AGENTS.entrySet()) {
            sb.append((String) next.getKey());
            sb.append(ExpiryDateInput.SEPARATOR);
            sb.append((String) next.getValue());
            sb.append(";");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
