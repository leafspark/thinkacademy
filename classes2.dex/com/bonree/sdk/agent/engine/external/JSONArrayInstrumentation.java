package com.bonree.sdk.agent.engine.external;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONArrayInstrumentation {
    private static final String JSONARRAY_INIT = "JSONArray/<init>";
    private static final String JSONARRAY_TOSTRING = "JSONArray/toString";

    public static JSONArray init(String str) throws JSONException {
        beforeMethod(JSONARRAY_INIT);
        try {
            return new JSONArray(str);
        } finally {
            afterMethod(JSONARRAY_INIT);
        }
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 3);
    }

    private static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 3);
    }

    public static String toString(JSONArray jSONArray) {
        beforeMethod(JSONARRAY_TOSTRING);
        try {
            return jSONArray.toString();
        } finally {
            afterMethod(JSONARRAY_TOSTRING);
        }
    }

    public static String toString(JSONArray jSONArray, int i) throws JSONException {
        beforeMethod(JSONARRAY_TOSTRING);
        try {
            return jSONArray.toString(i);
        } finally {
            afterMethod(JSONARRAY_TOSTRING);
        }
    }
}
