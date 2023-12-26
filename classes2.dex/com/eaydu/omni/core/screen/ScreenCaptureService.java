package com.eaydu.omni.core.screen;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.wushuangtech.utils.OmniLog;

public class ScreenCaptureService extends Service {
    private static final String TAG = "ScreenCaptureService";

    public void onCreate() {
        OmniLog.screen_d(TAG, "onCreate...");
        super.onCreate();
    }

    public IBinder onBind(Intent intent) {
        OmniLog.screen_d(TAG, "onBind... " + intent);
        return new Binder();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        createNotificationChannel();
        OmniLog.screen_d(TAG, "onStartCommand... " + intent + " | flags : " + i + " | startId : " + i2);
        return super.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        OmniLog.screen_d(TAG, "onUnbind... " + intent);
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        OmniLog.screen_d(TAG, "onDestroy... ");
        super.onDestroy();
    }

    private void createNotificationChannel() {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("notification_id");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
            } else {
                return;
            }
        }
        Notification build = builder.build();
        build.defaults = 1;
        startForeground(110, build);
    }
}
