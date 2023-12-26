package com.igexin.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.igexin.assist.control.fcm.GTJobService;
import com.igexin.assist.control.fcm.ServiceUtils;
import com.igexin.assist.sdk.AssistPushConsts;

public class FcmIntentService extends GTJobService {
    public static final String TAG = "Assist_FCM";

    private void turnOffPush() {
        try {
            FirebaseMessaging.getInstance().deleteToken().addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d("Assist_FCM", "fcm turnoff successful");
                    }
                }
            });
        } catch (Throwable th) {
            Log.e("Assist_FCM", "fcm turnoff error = " + th.getMessage());
        }
    }

    private void turnOnPush() {
        try {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                public void onComplete(Task<String> task) {
                    if (!task.isSuccessful()) {
                        Log.d("Assist_FCM", "Fetching FCM registration token failed", task.getException());
                        return;
                    }
                    String result = task.getResult();
                    Log.d("Assist_FCM", "turnOnPush token = ".concat(String.valueOf(result)));
                    if (!TextUtils.isEmpty(result)) {
                        Intent intent = new Intent(FcmIntentService.this.getApplicationContext(), FcmPushIntentService.class);
                        intent.putExtra("action", AssistPushConsts.MSG_TYPE_TOKEN);
                        intent.putExtra(AssistPushConsts.MSG_TYPE_TOKEN, AssistPushConsts.FCM_PREFIX.concat(String.valueOf(result)));
                        ServiceUtils.startService(FcmIntentService.this.getApplicationContext(), intent);
                    }
                }
            });
        } catch (Throwable th) {
            Log.e("Assist_FCM", "fcm turnoff error = " + th.getMessage());
        }
    }

    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                processOnHandleIntent(intent);
            } catch (Throwable th) {
                Log.d("Assist_FCM", th.getMessage());
            }
        }
    }

    public void processOnHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.get("action") != null) {
            Log.d("Assist_FCM", "onHandleIntent() action = " + extras.getString("action"));
            String string = extras.getString("action");
            if (string.equals("turnOnPush")) {
                turnOnPush();
            } else if (string.equals("turnOffPush")) {
                turnOffPush();
            }
        }
    }
}
