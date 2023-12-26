package com.tal100.chatsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal100.chatsdk.PMDefs;
import com.tal100.chatsdk.utils.GsonUtils;

public abstract class TMPushReceiver extends BroadcastReceiver {
    public static final String CMD_RECV_REGISTER_ID = "com.tal100.push.RECV_REGISTER_ID";
    public static final String CMD_RECV_TAL_CUSTOM_MSG = "com.tal100.push.RECV_TAL_CUSTOM_MSG";
    public static final String CMD_RECV_TAL_NOTIFY_MSG = "com.tal100.push.RECV_TAL_NOTIFY_MSG";
    public static final String KEY_PUSH_MSG = "com.tal100.push.DATA_PUSH_MSG";
    public static final String KEY_REGISTER_ID = "com.tal100.push.DATA_REGISTER_ID";
    public static final String TAG = "TMPushReceiver";

    public abstract void onReceivedCustomMessage(Context context, PMDefs.TMPushMsgEntity tMPushMsgEntity);

    public abstract void onReceivedNotificationMessage(Context context, PMDefs.TMPushMsgEntity tMPushMsgEntity);

    public abstract void onReceivedRegisterId(Context context, String str);

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (intent == null) {
            Log.e(TAG, "TMPushReceiver: intent is null!");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e(TAG, "TMPushReceiver: data is null!");
        } else if (CMD_RECV_REGISTER_ID.equals(intent.getAction())) {
            String str = (String) extras.get(KEY_REGISTER_ID);
            String str2 = TAG;
            Log.i(str2, "receive register id: " + str);
            onReceivedRegisterId(context, str);
        } else if (CMD_RECV_TAL_CUSTOM_MSG.equals(intent.getAction())) {
            onReceivedCustomMessage(context, (PMDefs.TMPushMsgEntity) GsonUtils.fromJsonToObject((String) extras.get(KEY_PUSH_MSG), PMDefs.TMPushMsgEntity.class));
        } else if (CMD_RECV_TAL_NOTIFY_MSG.equals(intent.getAction())) {
            onReceivedNotificationMessage(context, (PMDefs.TMPushMsgEntity) GsonUtils.fromJsonToObject((String) extras.get(KEY_PUSH_MSG), PMDefs.TMPushMsgEntity.class));
        }
    }
}
