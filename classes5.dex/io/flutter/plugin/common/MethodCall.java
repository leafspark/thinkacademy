package io.flutter.plugin.common;

import java.util.Map;
import org.json.JSONObject;

public final class MethodCall {
    public final Object arguments;
    public final String method;

    public MethodCall(String str, Object obj) {
        this.method = str;
        this.arguments = obj;
    }

    public <T> T arguments() {
        return this.arguments;
    }

    public <T> T argument(String str) {
        Object obj = this.arguments;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public boolean hasArgument(String str) {
        Object obj = this.arguments;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
