package com.tal.app.thinkacademy.common.util;

import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.lib.logger.XesLog;

public class LiveStabilityUtils {
    public static void live_stability_track(String str, String str2, String str3, int i, String str4) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("interactType", str);
        jsonObject.addProperty("interactId", str2);
        jsonObject.addProperty("interactStage", str3);
        jsonObject.addProperty("status", Integer.valueOf(i));
        jsonObject.addProperty("failureReason", str4);
        XesLog.ut("student.Interact", jsonObject);
    }
}
