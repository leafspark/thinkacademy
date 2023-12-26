package com.igexin.sdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.control.fcm.GTJobService;
import com.igexin.assist.sdk.AssistPushConsts;

public class FcmPushIntentService extends GTJobService {
    public static final String TAG = "Assist_FCM";

    private void onReceiveFcmActions(String str) {
        if (str != null) {
            Log.e("Assist_FCM", "actions = ".concat(String.valueOf(str)));
            MessageBean messageBean = new MessageBean(getApplicationContext(), AssistPushConsts.MSG_TYPE_ACTIONS, str);
            messageBean.setMessageSource(AssistPushConsts.FCM_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        }
    }

    private void onReceiveFcmToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManger.getInstance().addMessage(new MessageBean(getApplicationContext(), AssistPushConsts.MSG_TYPE_TOKEN, str));
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
            if (string.equals(AssistPushConsts.MSG_TYPE_TOKEN)) {
                onReceiveFcmToken(intent.getStringExtra(AssistPushConsts.MSG_TYPE_TOKEN));
            } else if (string.equals(AssistPushConsts.MSG_TYPE_ACTIONS)) {
                onReceiveFcmActions(intent.getStringExtra(AssistPushConsts.MSG_TYPE_ACTIONS));
            }
        }
    }
}
