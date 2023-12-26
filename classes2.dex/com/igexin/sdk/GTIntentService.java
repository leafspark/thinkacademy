package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import com.igexin.b.a.c.a.c;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

public class GTIntentService extends Service {
    private static final int REMOTE_CLINET_RECEIVED = 2;
    private static final int REMOTE_MSG_RECEIVED = 1;
    public final String TAG = getClass().getName();
    private final Messenger client = new Messenger(new a(this));

    public final IBinder onBind(Intent intent) {
        c a = c.a();
        a.a("onBind " + this);
        return this.client.getBinder();
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onReceiveClientId(Context context, String str) {
    }

    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
    }

    public void onReceiveDeviceToken(Context context, String str) {
    }

    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
    }

    public void onReceiveOnlineState(Context context, boolean z) {
    }

    public void onReceiveServicePid(Context context, int i) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        processOnHandleIntent(this, intent);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void processOnHandleIntent(Context context, Intent intent) {
        Bundle extras;
        String str;
        c cVar;
        if (intent != null && context != null && (extras = intent.getExtras()) != null && extras.get("action") != null && (extras.get("action") instanceof Integer)) {
            int i = extras.getInt("action");
            Context applicationContext = context.getApplicationContext();
            if (i == 10001) {
                onReceiveMessageData(applicationContext, (GTTransmitMessage) intent.getSerializableExtra(PushConsts.KEY_MESSAGE_DATA));
                cVar = c.a();
                str = "onHandleIntent() = received msg data ";
            } else if (i == 10002) {
                onReceiveClientId(applicationContext, extras.getString(PushConsts.KEY_CLIENT_ID));
                cVar = c.a();
                str = "onHandleIntent() = received client id ";
            } else if (i == 10007) {
                onReceiveOnlineState(applicationContext, extras.getBoolean(PushConsts.KEY_ONLINE_STATE));
                return;
            } else if (i != 10008) {
                switch (i) {
                    case 10010:
                        onReceiveCommandResult(applicationContext, (GTCmdMessage) intent.getSerializableExtra(PushConsts.KEY_CMD_MSG));
                        cVar = c.a();
                        str = "onHandleIntent() = " + intent.getSerializableExtra(PushConsts.KEY_CMD_MSG).getClass().getSimpleName();
                        break;
                    case 10011:
                        onNotificationMessageArrived(applicationContext, (GTNotificationMessage) intent.getSerializableExtra(PushConsts.KEY_NOTIFICATION_ARRIVED));
                        cVar = c.a();
                        str = "onHandleIntent() = notification arrived ";
                        break;
                    case PushConsts.ACTION_NOTIFICATION_CLICKED:
                        onNotificationMessageClicked(applicationContext, (GTNotificationMessage) intent.getSerializableExtra(PushConsts.KEY_NOTIFICATION_CLICKED));
                        cVar = c.a();
                        str = "onHandleIntent() notification clicked ";
                        break;
                    case PushConsts.GET_DEVICETOKEN:
                        onReceiveDeviceToken(applicationContext, extras.getString(PushConsts.KEY_DEVICE_TOKEN));
                        cVar = c.a();
                        str = "onHandleIntent() = received device token ";
                        break;
                    default:
                        return;
                }
            } else {
                onReceiveServicePid(applicationContext, extras.getInt(PushConsts.KEY_SERVICE_PIT));
                cVar = c.a();
                str = "onHandleIntent() = get sdk service pid ";
            }
            cVar.a(str);
        }
    }
}
