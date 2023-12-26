package com.bonree.sdk.agent.engine.external;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectInstrumentation {
    private static final String JSONOBJECT_INIT = "JSONObject/<init>";
    private static final String JSONOBJECT_TOSTRING = "JSONObject/toString";

    public static JSONObject init(String str) throws JSONException {
        beforeMethod(JSONOBJECT_INIT);
        try {
            return new JSONObject(str);
        } finally {
            afterMethod(JSONOBJECT_INIT);
        }
    }

    public static String toString(JSONObject jSONObject) {
        beforeMethod(JSONOBJECT_TOSTRING);
        try {
            return jSONObject.toString();
        } finally {
            afterMethod(JSONOBJECT_TOSTRING);
        }
    }

    public static String toString(JSONObject jSONObject, int i) throws JSONException {
        beforeMethod(JSONOBJECT_TOSTRING);
        try {
            return jSONObject.toString(i);
        } finally {
            afterMethod(JSONOBJECT_TOSTRING);
        }
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 3);
    }

    private static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 3);
    }
}
