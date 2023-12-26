package com.igexin.assist.util;

import android.content.Context;
import com.igexin.sdk.PushManager;

public class AssistUtils {
    public static void startGetuiService(Context context) {
        if (context != null) {
            try {
                PushManager.getInstance().initialize(context);
            } catch (Throwable unused) {
            }
        }
    }
}
