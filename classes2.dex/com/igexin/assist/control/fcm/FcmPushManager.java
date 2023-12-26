package com.igexin.assist.control.fcm;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.sdk.FcmIntentService;

public class FcmPushManager implements AbstractPushManager {
    public static final String TAG = "Assist_FCM";

    public FcmPushManager(Context context) {
    }

    public static boolean checkFcmDevice(Context context) {
        try {
            if (AssistPushManager.getToken() != null && AssistPushManager.getToken().startsWith(AssistPushConsts.FCM_PREFIX)) {
                return true;
            }
            int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
            Log.e("Assist_FCM", "checkFcmDevice result = ".concat(String.valueOf(isGooglePlayServicesAvailable)));
            return isGooglePlayServicesAvailable == 0;
        } catch (Throwable th) {
            Log.e("Assist_FCM", "checkFcmDevice error =" + th.getMessage());
            return false;
        }
    }

    public String getBrandCode() {
        return null;
    }

    public String getToken(Context context) {
        return null;
    }

    public boolean isSupport() {
        return false;
    }

    public void register(final Context context) {
        Log.d("Assist_FCM", "Register fcm push, and fcm is initialized when app launch");
        try {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                public void onComplete(Task<String> task) {
                    if (!task.isSuccessful()) {
                        Log.d("Assist_FCM", "Fetching FCM registration token failed", task.getException());
                        return;
                    }
                    String result = task.getResult();
                    if (!TextUtils.isEmpty(result)) {
                        MessageManger.getInstance().addMessage(new MessageBean(context, AssistPushConsts.MSG_TYPE_TOKEN, AssistPushConsts.FCM_PREFIX.concat(String.valueOf(result))));
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSilentTime(Context context, int i, int i2) {
    }

    public void turnOffPush(Context context) {
        try {
            Intent intent = new Intent(context, FcmIntentService.class);
            intent.putExtra("action", "turnOffPush");
            ServiceUtils.startService(context, intent);
            AssistPushManager.getInstance().saveToken("false");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void turnOnPush(Context context) {
        try {
            Intent intent = new Intent(context, FcmIntentService.class);
            intent.putExtra("action", "turnOnPush");
            ServiceUtils.startService(context, intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void unregister(Context context) {
        turnOffPush(context);
    }
}
