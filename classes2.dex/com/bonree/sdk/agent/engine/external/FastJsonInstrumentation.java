package com.bonree.sdk.agent.engine.external;

import com.alibaba.fastjson.JSON;

public class FastJsonInstrumentation {
    private static final String FASTJSON_PARSEOBJECT = "FastJson/parseObject";
    private static final String FASTJSON_TOJSONSTRING = "FastJson/toJSONString";
    private String interact;

    public static String toJSONString(Object obj) {
        beforeMethod(FASTJSON_TOJSONSTRING);
        try {
            return JSON.toJSONString(obj);
        } finally {
            afterMethod(FASTJSON_TOJSONSTRING);
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        beforeMethod(FASTJSON_PARSEOBJECT);
        try {
            return JSON.parseObject(str, cls);
        } finally {
            afterMethod(FASTJSON_PARSEOBJECT);
        }
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 3);
    }

    private static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 3);
    }
}
