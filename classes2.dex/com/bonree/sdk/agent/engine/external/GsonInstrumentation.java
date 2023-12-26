package com.bonree.sdk.agent.engine.external;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.lang.reflect.Type;

public class GsonInstrumentation {
    private static final String GSON_FROMJSON = "Gson/fromJson";
    private static final String GSON_TOJSON = "Gson/toJson";

    public static String toJson(Gson gson, Object obj) {
        String methodName = getMethodName(GSON_TOJSON, getObjectName(obj));
        beforeMethod(methodName);
        try {
            return gson.toJson(obj);
        } finally {
            afterMethod(methodName);
        }
    }

    public static String toJson(Gson gson, Object obj, Type type) {
        String methodName = getMethodName(GSON_TOJSON, getObjectName(obj), "Type");
        beforeMethod(methodName);
        try {
            return gson.toJson(obj, type);
        } finally {
            afterMethod(methodName);
        }
    }

    public static void toJson(Gson gson, Object obj, Appendable appendable) throws JsonIOException {
        String methodName = getMethodName(GSON_TOJSON, getObjectName(obj), "Appendable");
        beforeMethod(methodName);
        try {
            gson.toJson(obj, appendable);
        } finally {
            afterMethod(methodName);
        }
    }

    public static void toJson(Gson gson, Object obj, Type type, Appendable appendable) throws JsonIOException {
        String methodName = getMethodName(GSON_TOJSON, getObjectName(obj), "Type,Appendable");
        beforeMethod(methodName);
        try {
            gson.toJson(obj, type, appendable);
        } finally {
            afterMethod(methodName);
        }
    }

    public static void toJson(Gson gson, Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        String methodName = getMethodName(GSON_TOJSON, getObjectName(obj), "Type,JsonWriter");
        beforeMethod(methodName);
        try {
            gson.toJson(obj, type, jsonWriter);
        } finally {
            afterMethod(methodName);
        }
    }

    public static String toJson(Gson gson, JsonElement jsonElement) {
        String methodName = getMethodName(GSON_TOJSON, "JsonElement");
        beforeMethod(methodName);
        try {
            return gson.toJson(jsonElement);
        } finally {
            afterMethod(methodName);
        }
    }

    public static void toJson(Gson gson, JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        String methodName = getMethodName(GSON_TOJSON, "JsonElement,Appendable");
        beforeMethod(methodName);
        try {
            gson.toJson(jsonElement, appendable);
        } finally {
            afterMethod(methodName);
        }
    }

    public static void toJson(Gson gson, JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        String methodName = getMethodName(GSON_TOJSON, "JsonElement,JsonWriter");
        beforeMethod(methodName);
        try {
            gson.toJson(jsonElement, jsonWriter);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, String str, Class<T> cls) throws JsonSyntaxException {
        String methodName = getMethodName(GSON_FROMJSON, "String", getClassName(cls));
        beforeMethod(methodName);
        try {
            return gson.fromJson(str, cls);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, String str, Type type) throws JsonSyntaxException {
        String methodName = getMethodName(GSON_FROMJSON, "String,Type");
        beforeMethod(methodName);
        try {
            return gson.fromJson(str, type);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        String methodName = getMethodName(GSON_FROMJSON, "Reader", getClassName(cls));
        beforeMethod(methodName);
        try {
            return gson.fromJson(reader, cls);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        String methodName = getMethodName(GSON_FROMJSON, "Reader,Type");
        beforeMethod(methodName);
        try {
            return gson.fromJson(reader, type);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        String methodName = getMethodName(GSON_FROMJSON, "JsonReader,Type");
        beforeMethod(methodName);
        try {
            return gson.fromJson(jsonReader, type);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        String methodName = getMethodName(GSON_FROMJSON, "JsonElement", getClassName(cls));
        beforeMethod(methodName);
        try {
            return gson.fromJson(jsonElement, cls);
        } finally {
            afterMethod(methodName);
        }
    }

    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Type type) throws JsonSyntaxException {
        String methodName = getMethodName(GSON_FROMJSON, "JsonElement,Type");
        beforeMethod(methodName);
        try {
            return gson.fromJson(jsonElement, type);
        } finally {
            afterMethod(methodName);
        }
    }

    private static String getClassName(Class cls) {
        return cls != null ? cls.getSimpleName() : "Class";
    }

    private static String getObjectName(Object obj) {
        return obj != null ? obj.getClass().getSimpleName() : "Object";
    }

    private static String getMethodName(String str, String str2, String str3) {
        return String.format("%s(%s,%s)", new Object[]{str, str2, str3});
    }

    private static String getMethodName(String str, String str2) {
        return String.format("%s(%s)", new Object[]{str, str2});
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 3);
    }

    private static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 3);
    }
}
