package com.igexin.assist.control.fcm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServiceUtils {
    public static final int FCM_JOB_ID = 1903051536;
    public static final String TAG = "Assist_FCM";

    public static boolean startService(Context context, Intent intent) {
        try {
            context.getApplicationContext().startService(intent);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            if (!(th instanceof IllegalStateException)) {
                return false;
            }
            Log.d("Assist_FCM", "startService in background, use job service");
            return JobSender.getInstance().runJob(context, intent, FCM_JOB_ID);
        }
    }
}
