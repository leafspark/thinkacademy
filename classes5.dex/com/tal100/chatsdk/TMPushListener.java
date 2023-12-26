package com.tal100.chatsdk;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal100.chatsdk.PMDefs;
import com.tal100.chatsdk.utils.GsonUtils;
import java.util.Iterator;
import java.util.Random;

public class TMPushListener {
    private static final String TAG = "TMPushListener";
    private static Random random = new Random();

    public void onReceivedRegisterId(Context context, String str) {
        String str2 = TAG;
        Log.i(str2, "onReceivedRegisterId: " + str);
        Intent intent = new Intent(TMPushReceiver.CMD_RECV_REGISTER_ID);
        Bundle bundle = new Bundle();
        bundle.putString(TMPushReceiver.KEY_REGISTER_ID, str);
        intent.putExtras(bundle);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public void onReceivedPushMessage(Context context, PMDefs.TMPushMsgEntity tMPushMsgEntity) {
        if (context == null || tMPushMsgEntity == null) {
            Log.e(TAG, "onReceivedPushMessage: context is null or pushMsg is null!");
        } else if (tMPushMsgEntity.getMsgType() == 1) {
            sendBroadcastMessage(context, tMPushMsgEntity);
        } else if (tMPushMsgEntity.getMsgType() == 0) {
            showNotificationAndBroadcast(context, tMPushMsgEntity);
        }
    }

    private void sendBroadcastMessage(Context context, PMDefs.TMPushMsgEntity tMPushMsgEntity) {
        String str = TAG;
        Log.i(str, "sendBroadcastMessage: " + tMPushMsgEntity.toString());
        String json = GsonUtils.toJson(tMPushMsgEntity);
        Intent intent = new Intent(TMPushReceiver.CMD_RECV_TAL_CUSTOM_MSG);
        Bundle bundle = new Bundle();
        bundle.putString(TMPushReceiver.KEY_PUSH_MSG, json);
        intent.putExtras(bundle);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    private void showNotificationAndBroadcast(Context context, PMDefs.TMPushMsgEntity tMPushMsgEntity) {
        boolean z;
        Log.i(TAG, "showNotificationAndBroadcast: " + tMPushMsgEntity.toString());
        String json = GsonUtils.toJson(tMPushMsgEntity);
        Intent intent = new Intent(TMPushReceiver.CMD_RECV_TAL_NOTIFY_MSG);
        Bundle bundle = new Bundle();
        bundle.putString(TMPushReceiver.KEY_PUSH_MSG, json);
        intent.putExtras(bundle);
        intent.setPackage(context.getPackageName());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            String channelId = tMPushMsgEntity.getChannelId();
            if (TextUtils.isEmpty(channelId)) {
                channelId = "channel_default";
                Iterator<NotificationChannel> it = notificationManager.getNotificationChannels().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getId().equalsIgnoreCase(channelId)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    notificationManager.createNotificationChannel(new NotificationChannel(channelId, "默认channel", 2));
                }
            }
            builder.setChannelId(channelId);
        }
        PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, 134217728);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, 134217728);
        builder.setAutoCancel(true).setContentIntent(broadcast).setTicker("来消息了").setSmallIcon(TMPushManager.getInstance().getmSmallIconResId()).setContentTitle(tMPushMsgEntity.getTitle()).setContentText(tMPushMsgEntity.getDescription()).setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        int nextInt = random.nextInt();
        Notification build = builder.build();
        notificationManager.notify(nextInt, build);
        PushAutoTrackHelper.onNotify(notificationManager, nextInt, build);
    }
}
