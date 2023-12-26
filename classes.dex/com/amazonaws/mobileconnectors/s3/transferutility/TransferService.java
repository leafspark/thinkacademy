package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

public class TransferService extends Service {
    private static final int ANDROID_OREO = 26;
    public static final String INTENT_KEY_NOTIFICATION = "notification";
    public static final String INTENT_KEY_NOTIFICATION_ID = "ongoing-notification-id";
    public static final String INTENT_KEY_REMOVE_NOTIFICATION = "remove-notification";
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferService.class);
    static TransferNetworkLossHandler transferNetworkLossHandler;
    boolean isReceiverNotRegistered = true;
    private int ongoingNotificationId = 1;
    private boolean removeNotification = true;

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r3 = this;
            super.onCreate()
            com.amazonaws.logging.Log r0 = LOGGER
            java.lang.String r1 = "Starting Transfer Service to listen for network connectivity changes."
            r0.info(r1)
            android.content.Context r1 = r3.getApplicationContext()
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler.getInstance(r1)
            transferNetworkLossHandler = r1
            monitor-enter(r3)
            boolean r1 = r3.isReceiverNotRegistered     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = "Registering the network receiver"
            r0.info(r1)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = transferNetworkLossHandler     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            r3.registerReceiver(r0, r1)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            r0 = 0
            r3.isReceiverNotRegistered = r0     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            goto L_0x003d
        L_0x002e:
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "Ignoring the leak in registering the receiver."
            r0.warn(r1)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0036:
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "Ignoring the exception trying to register the receiver for connectivity change."
            r0.warn(r1)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onCreate():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public int onStartCommand(android.content.Intent r2, int r3, int r4) {
        /*
            r1 = this;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(r1, r2, r3, r4)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            if (r3 < r4) goto L_0x0058
            monitor-enter(r1)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r3 = "notification"
            android.os.Parcelable r3 = r2.getParcelableExtra(r3)     // Catch:{ all -> 0x003e }
            android.app.Notification r3 = (android.app.Notification) r3     // Catch:{ all -> 0x003e }
            if (r3 == 0) goto L_0x0035
            java.lang.String r4 = "ongoing-notification-id"
            int r0 = r1.ongoingNotificationId     // Catch:{ all -> 0x003e }
            int r4 = r2.getIntExtra(r4, r0)     // Catch:{ all -> 0x003e }
            r1.ongoingNotificationId = r4     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "remove-notification"
            boolean r0 = r1.removeNotification     // Catch:{ all -> 0x003e }
            boolean r2 = r2.getBooleanExtra(r4, r0)     // Catch:{ all -> 0x003e }
            r1.removeNotification = r2     // Catch:{ all -> 0x003e }
            com.amazonaws.logging.Log r2 = LOGGER     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Putting the service in Foreground state."
            r2.info(r4)     // Catch:{ all -> 0x003e }
            int r2 = r1.ongoingNotificationId     // Catch:{ all -> 0x003e }
            r1.startForeground(r2, r3)     // Catch:{ all -> 0x003e }
            goto L_0x003c
        L_0x0035:
            com.amazonaws.logging.Log r2 = LOGGER     // Catch:{ all -> 0x003e }
            java.lang.String r3 = "No notification is passed in the intent. Unable to transition to foreground."
            r2.error(r3)     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            goto L_0x0058
        L_0x003e:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            throw r2     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r2 = move-exception
            com.amazonaws.logging.Log r3 = LOGGER
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Error in moving the service to foreground state: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.error(r2)
        L_0x0058:
            monitor-enter(r1)
            boolean r2 = r1.isReceiverNotRegistered     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x0083
            com.amazonaws.logging.Log r2 = LOGGER     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            java.lang.String r3 = "Registering the network receiver"
            r2.info(r3)     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r2 = transferNetworkLossHandler     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            android.content.IntentFilter r3 = new android.content.IntentFilter     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r3.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            r1.registerReceiver(r2, r3)     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            r2 = 0
            r1.isReceiverNotRegistered = r2     // Catch:{ IllegalArgumentException -> 0x007c, IllegalStateException -> 0x0074 }
            goto L_0x0083
        L_0x0074:
            com.amazonaws.logging.Log r2 = LOGGER     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "Ignoring the leak in registering the receiver."
            r2.warn(r3)     // Catch:{ all -> 0x0086 }
            goto L_0x0083
        L_0x007c:
            com.amazonaws.logging.Log r2 = LOGGER     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "Ignoring the exception trying to register the receiver for connectivity change."
            r2.warn(r3)     // Catch:{ all -> 0x0086 }
        L_0x0083:
            monitor-exit(r1)     // Catch:{ all -> 0x0086 }
            r2 = 1
            return r2
        L_0x0086:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0086 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onStartCommand(android.content.Intent, int, int):int");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0018 }
            r1 = 26
            if (r0 < r1) goto L_0x002f
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.info(r1)     // Catch:{ Exception -> 0x0018 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r4.removeNotification     // Catch:{ all -> 0x0015 }
            r4.stopForeground(r0)     // Catch:{ all -> 0x0015 }
            monitor-exit(r4)     // Catch:{ all -> 0x0015 }
            goto L_0x002f
        L_0x0015:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0015 }
            throw r0     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.error(r0)
        L_0x002f:
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ IllegalArgumentException -> 0x004b }
            java.lang.String r1 = "De-registering the network receiver."
            r0.info(r1)     // Catch:{ IllegalArgumentException -> 0x004b }
            monitor-enter(r4)     // Catch:{ IllegalArgumentException -> 0x004b }
            boolean r0 = r4.isReceiverNotRegistered     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0046
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = transferNetworkLossHandler     // Catch:{ all -> 0x0048 }
            r4.unregisterReceiver(r0)     // Catch:{ all -> 0x0048 }
            r0 = 1
            r4.isReceiverNotRegistered = r0     // Catch:{ all -> 0x0048 }
            r0 = 0
            transferNetworkLossHandler = r0     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r4)     // Catch:{ all -> 0x0048 }
            goto L_0x0052
        L_0x0048:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0048 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x004b }
        L_0x004b:
            com.amazonaws.logging.Log r0 = LOGGER
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.warn(r1)
        L_0x0052:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    /* access modifiers changed from: protected */
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) != 0) {
            printWriter.printf("network status: %s\n", new Object[]{Boolean.valueOf(transferNetworkLossHandler.isNetworkConnected())});
            Map<Integer, TransferRecord> transfers = TransferStatusUpdater.getInstance(this).getTransfers();
            printWriter.printf("# of active transfers: %d\n", new Object[]{Integer.valueOf(transfers.size())});
            for (TransferRecord next : transfers.values()) {
                printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", new Object[]{next.bucketName, next.key, next.state, Long.valueOf(next.bytesTotal), Long.valueOf(next.bytesCurrent)});
            }
            printWriter.flush();
        }
    }
}
