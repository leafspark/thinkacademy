package com.igexin.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.igexin.assist.control.fcm.ServiceUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import java.util.Map;

public class FcmPushService extends FirebaseMessagingService {
    public static final String PAYLOAD_KEY = "GT";
    public static final String TAG = "Assist_FCM";

    private boolean checkSupportDevice(Context context) {
        return AssistPushManager.checkSupportDevice(context);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            Log.d("Assist_FCM", "onMessageReceived receive meaasge ...");
            Log.d("Assist_FCM", "onMessageReceived receive meaasge:".concat(String.valueOf(remoteMessage)));
            if (remoteMessage != null && remoteMessage.getData() != null && remoteMessage.getData().size() > 0) {
                Map<String, String> data = remoteMessage.getData();
                if (data.containsKey(PAYLOAD_KEY)) {
                    String str = data.get(PAYLOAD_KEY);
                    Log.d("Assist_FCM", "onMessageReceived actions = ".concat(String.valueOf(str)));
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent(this, FcmPushIntentService.class);
                        intent.putExtra("action", AssistPushConsts.MSG_TYPE_ACTIONS);
                        intent.putExtra(AssistPushConsts.MSG_TYPE_ACTIONS, str);
                        ServiceUtils.startService(getApplicationContext(), intent);
                    }
                }
            }
        } catch (Throwable th) {
            Log.d("Assist_FCM", th.getMessage());
        }
    }

    public void onNewToken(String str) {
        Log.d("Assist_FCM", "onNewToken = ".concat(String.valueOf(str)));
        try {
            if (checkSupportDevice(getApplicationContext())) {
                Log.e("Assist_FCM", "already support other assist sdk!");
            } else if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent(getApplicationContext(), FcmPushIntentService.class);
                intent.putExtra("action", AssistPushConsts.MSG_TYPE_TOKEN);
                intent.putExtra(AssistPushConsts.MSG_TYPE_TOKEN, AssistPushConsts.FCM_PREFIX.concat(String.valueOf(str)));
                ServiceUtils.startService(getApplicationContext(), intent);
            }
        } catch (Throwable th) {
            Log.e("Assist_FCM", th.getMessage());
        }
    }
}
