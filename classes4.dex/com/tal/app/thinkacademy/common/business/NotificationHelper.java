package com.tal.app.thinkacademy.common.business;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;

public class NotificationHelper {
    public static final String PUSH_TICKER = "学而思网校";
    public static int mIpenChatMessageSound = 0;
    public static int mNotificationAppUpdateType = 2;
    public static int mNotificationAtType = 4;
    public static int mNotificationMessageType = 0;
    public static int mNotificationPointMessageType = 5;
    public static int mNotificationRoomNoticeType = 3;
    private NotificationCompat.Builder mAppUpdateDownloadNotification;
    private NotificationCompat.Builder mAtNotification;
    private NotificationCompat.Builder mMessageNotification;
    public NotificationManager mNotificationManager;
    private NotificationCompat.Builder mPointMessageNotification;
    private NotificationCompat.Builder mRoomNoticeNotification;

    private static boolean isOpenChatMessageSound() {
        return false;
    }

    public NotificationHelper(Context context) {
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }

    public void messageNotificationDisplay(Context context, Intent intent, String str, String str2, String str3, String str4) {
        PendingIntent pendingIntent;
        if (this.mMessageNotification == null) {
            this.mMessageNotification = new NotificationCompat.Builder(context);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 33554432);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 33554432);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 33554432);
        } else {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 134217728);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 134217728);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel("channel_001", "name", 2);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
            this.mMessageNotification.setChannelId("channel_001");
        }
        NotificationCompat.Builder contentIntent = this.mMessageNotification.setSmallIcon(R.drawable.icon_think_launch).setAutoCancel(true).setContentIntent(pendingIntent);
        contentIntent.setTicker(str3 + ":" + str4).setContentTitle(str3).setContentText(str4);
        this.mMessageNotification.setWhen(System.currentTimeMillis()).setShowWhen(true);
        NotificationManager notificationManager2 = this.mNotificationManager;
        int i = mNotificationMessageType;
        Notification build = this.mMessageNotification.build();
        notificationManager2.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager2, i, build);
    }

    public void appUpdateDownloadNotificationDisplay(Context context, Intent intent, String str, String str2, boolean z) {
        PendingIntent pendingIntent;
        if (this.mAppUpdateDownloadNotification == null) {
            this.mAppUpdateDownloadNotification = new NotificationCompat.Builder(context);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 33554432);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 33554432);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 33554432);
        } else {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 134217728);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 134217728);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel("channel_001", "name", 2);
            if (notificationManager != null) {
                try {
                    notificationManager.createNotificationChannel(notificationChannel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mAppUpdateDownloadNotification.setChannelId("channel_001");
        }
        this.mAppUpdateDownloadNotification.setSmallIcon(R.drawable.icon_think_launch).setContentIntent(pendingIntent).setTicker("应用后台更新中").setContentTitle(str).setContentText(str2);
        if (z) {
            this.mAppUpdateDownloadNotification.setAutoCancel(true);
        } else {
            this.mAppUpdateDownloadNotification.setAutoCancel(false);
        }
        NotificationManager notificationManager2 = this.mNotificationManager;
        int i = mNotificationAppUpdateType;
        Notification build = this.mAppUpdateDownloadNotification.build();
        notificationManager2.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager2, i, build);
    }

    public void roomNoticeNotificationDisplay(Context context, Intent intent, String str, String str2) {
        if (this.mRoomNoticeNotification == null) {
            this.mRoomNoticeNotification = new NotificationCompat.Builder(context);
        }
        NotificationCompat.Builder verifyNotificationDisplay = verifyNotificationDisplay(this.mRoomNoticeNotification, context, intent, str, str2);
        this.mRoomNoticeNotification = verifyNotificationDisplay;
        NotificationManager notificationManager = this.mNotificationManager;
        int i = mNotificationRoomNoticeType;
        Notification build = verifyNotificationDisplay.build();
        notificationManager.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager, i, build);
    }

    public void atNotificationDisplay(Context context, Intent intent, String str, String str2) {
        if (this.mAtNotification == null) {
            this.mAtNotification = new NotificationCompat.Builder(context);
        }
        NotificationCompat.Builder verifyNotificationDisplay = verifyNotificationDisplay(this.mAtNotification, context, intent, str, str2);
        this.mAtNotification = verifyNotificationDisplay;
        NotificationManager notificationManager = this.mNotificationManager;
        int i = mNotificationAtType;
        Notification build = verifyNotificationDisplay.build();
        notificationManager.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager, i, build);
    }

    public void noticeByRoomId(Context context, Intent intent, String str, String str2, int i) {
        if (this.mAtNotification == null) {
            this.mAtNotification = new NotificationCompat.Builder(context);
        }
        NotificationCompat.Builder verifyNotificationDisplay = verifyNotificationDisplay(this.mAtNotification, context, intent, str, str2);
        this.mAtNotification = verifyNotificationDisplay;
        NotificationManager notificationManager = this.mNotificationManager;
        Notification build = verifyNotificationDisplay.build();
        notificationManager.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager, i, build);
    }

    public void pointMessageNotificationDisplay(Context context, Intent intent, String str, String str2) {
        if (this.mPointMessageNotification == null) {
            this.mPointMessageNotification = new NotificationCompat.Builder(context);
        }
        NotificationCompat.Builder verifyNotificationDisplay = verifyNotificationDisplay(this.mPointMessageNotification, context, intent, str, str2);
        this.mPointMessageNotification = verifyNotificationDisplay;
        NotificationManager notificationManager = this.mNotificationManager;
        int i = mNotificationPointMessageType;
        Notification build = verifyNotificationDisplay.build();
        notificationManager.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager, i, build);
    }

    private NotificationCompat.Builder verifyNotificationDisplay(NotificationCompat.Builder builder, Context context, Intent intent, String str, String str2) {
        PendingIntent pendingIntent;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 31) {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 33554432);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 33554432);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 33554432);
        } else {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 134217728);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 134217728);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel("channel_001", "name", 2);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
            builder.setChannelId("channel_001");
        }
        NotificationCompat.Builder contentIntent = builder.setSmallIcon(R.drawable.icon_think_launch).setAutoCancel(true).setContentIntent(pendingIntent);
        contentIntent.setTicker(str + ":" + str2).setContentTitle(str).setContentText(str2).setWhen(System.currentTimeMillis()).setShowWhen(true);
        if (!isOpenChatMessageSound()) {
            builder.setSound((Uri) null);
        }
        return builder;
    }

    public void pushTextNotificationDisplay(Context context, Intent intent, String str, String str2, int i) {
        PendingIntent pendingIntent;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("channel_001", "name", 2);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
            builder.setChannelId("channel_001");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 33554432);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 33554432);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 33554432);
        } else {
            PushAutoTrackHelper.hookIntentGetActivity(context, 0, intent, 134217728);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, context, 0, intent, 134217728);
        }
        builder.setSmallIcon(R.drawable.icon_think_launch).setAutoCancel(true).setContentIntent(pendingIntent).setTicker(PUSH_TICKER).setContentTitle(str).setContentText(str2);
        if (!isOpenChatMessageSound()) {
            builder.setSound((Uri) null);
        }
        NotificationManager notificationManager2 = this.mNotificationManager;
        Notification build = builder.build();
        notificationManager2.notify(i, build);
        PushAutoTrackHelper.onNotify(notificationManager2, i, build);
        if (intent != null) {
            intent.hasExtra("pushActionIntent");
        }
    }

    /* access modifiers changed from: package-private */
    public void appUpdateDownloadNotificationCancel() {
        this.mNotificationManager.cancel(mNotificationAppUpdateType);
    }

    public void cancleAllNotification() {
        try {
            this.mNotificationManager.cancelAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
