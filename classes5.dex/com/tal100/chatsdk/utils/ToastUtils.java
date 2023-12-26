package com.tal100.chatsdk.utils;

import android.content.Context;
import android.widget.Toast;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ToastUtils {
    public static String jsonPrettyShow(Object obj) {
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        return !(create instanceof Gson) ? create.toJson(obj) : GsonInstrumentation.toJson(create, obj);
    }

    public static void toastJsonPrettyShow(Context context, Object obj) {
        Toast.makeText(context, jsonPrettyShow(obj), 0).show();
    }

    public static void toastShowStr(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }
}
