package com.tal.app.thinkacademy.common.business.browser.server;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.server.IServerConnectListener;
import com.tal.app.thinkacademy.common.server.IService;
import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class CoreService extends Service {
    private static final int id = 1;
    private static String rootPath;
    /* access modifiers changed from: private */
    public IServerConnectListener iServerConnectListener;
    IService.Stub iService = new IService.Stub() {
        public boolean isServerRunning() throws RemoteException {
            if (CoreService.this.mServer != null) {
                return CoreService.this.mServer.isRunning();
            }
            return false;
        }

        public void setCallback(IServerConnectListener iServerConnectListener) throws RemoteException {
            IServerConnectListener unused = CoreService.this.iServerConnectListener = iServerConnectListener;
            if (isServerRunning() && CoreService.this.iServerConnectListener != null) {
                CoreService.this.iServerConnectListener.onStarted(CoreService.this.getRootUrl());
            }
        }
    };
    private boolean isCreate;
    /* access modifiers changed from: private */
    public Server mServer;
    private String noticeContent;
    private int noticeIcon;
    private String noticeTitle;
    private String notificationId = "serviceid";
    private NotificationManager notificationManager;
    private String notificationName = "servicename";
    private int port;

    public void onCreate() {
        this.notificationManager = (NotificationManager) getSystemService("notification");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        this.port = intent.getIntExtra("port", 8080);
        rootPath = intent.getStringExtra("rootPath");
        this.noticeIcon = intent.getIntExtra("noticeIcon", 0);
        this.noticeTitle = intent.getStringExtra("noticeTitle");
        this.noticeContent = intent.getStringExtra("noticeContent");
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.createNotificationChannel(new NotificationChannel(this.notificationId, this.notificationName, 4));
        }
        startForeground(1, getNotification());
        if (!this.isCreate) {
            initServer();
            this.isCreate = true;
        }
        startServer();
        return 3;
    }

    public void onDestroy() {
        stopServer();
        stopForeground(true);
        this.isCreate = false;
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return this.iService;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void initServer() {
        this.mServer = AndServer.webServer(this).port(this.port).timeout(10, TimeUnit.SECONDS).listener(new Server.ServerListener() {
            public void onStarted() {
                if (CoreService.this.iServerConnectListener != null) {
                    try {
                        CoreService.this.iServerConnectListener.onStarted(CoreService.this.getRootUrl());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onStopped() {
                if (CoreService.this.iServerConnectListener != null) {
                    try {
                        CoreService.this.iServerConnectListener.onStopped();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onException(Exception exc) {
                if (CoreService.this.iServerConnectListener != null) {
                    try {
                        CoreService.this.iServerConnectListener.onException(exc.getMessage());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                CoreService.this.stopForeground(true);
            }

            public void onRequestError(int i, HttpRequest httpRequest, HttpResponse httpResponse) {
                if (CoreService.this.iServerConnectListener != null) {
                    try {
                        CoreService.this.iServerConnectListener.onRequestError(i, httpRequest.getPath());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).build();
    }

    private void startServer() {
        if (this.mServer.isRunning()) {
            IServerConnectListener iServerConnectListener2 = this.iServerConnectListener;
            if (iServerConnectListener2 != null) {
                try {
                    iServerConnectListener2.onStarted(getRootUrl());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.mServer.startup();
        }
    }

    private void stopServer() {
        Server server = this.mServer;
        if (server != null && server.isRunning()) {
            this.mServer.shutdown();
        }
    }

    /* access modifiers changed from: private */
    public String getRootUrl() {
        return "http://localhost:" + this.port + "/";
    }

    private Notification getNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        int i = this.noticeIcon;
        if (i == 0) {
            i = R.drawable.icon_think_launch;
        }
        Notification.Builder contentText = builder.setSmallIcon(i).setContentTitle(TextUtils.isEmpty(this.noticeTitle) ? getString(R.string.loacal_server_notification_title) : this.noticeTitle).setContentText(TextUtils.isEmpty(this.noticeContent) ? getString(R.string.loacal_server_notification_content) : this.noticeContent);
        if (Build.VERSION.SDK_INT >= 26) {
            contentText.setChannelId(this.notificationId);
        }
        return contentText.build();
    }

    public static String getRootPath() {
        return rootPath;
    }
}
