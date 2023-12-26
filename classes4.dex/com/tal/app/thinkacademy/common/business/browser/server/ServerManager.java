package com.tal.app.thinkacademy.common.business.browser.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.server.IServerConnectListener;
import com.tal.app.thinkacademy.common.server.IService;
import com.tal.app.thinkacademy.lib.logger.XesLog;

public class ServerManager {
    public static final int CMD_VALUE_ERROR = 2;
    public static final int CMD_VALUE_START = 1;
    public static final int CMD_VALUE_STOP = 3;
    public static final Tag TAG = Tag.LOCAL_SERVER;
    private static volatile ServerManager mInstance;
    private ServiceConnection connection;
    private int currServerState;
    /* access modifiers changed from: private */
    public String errMsg;
    /* access modifiers changed from: private */
    public IService iService;
    private Intent intentService;
    /* access modifiers changed from: private */
    public boolean isConnected = false;
    /* access modifiers changed from: private */
    public boolean isConnecting = false;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public String mServerUrl;
    private String noticeContent;
    private int noticeIcon;
    private String noticeTitle;
    /* access modifiers changed from: private */
    public OnServerConnectionListener onServerConnectionListener;
    private int port;
    private String rootPath;

    public static ServerManager getInstance() {
        if (mInstance == null) {
            synchronized (ServerManager.class) {
                if (mInstance == null) {
                    mInstance = new ServerManager();
                }
            }
        }
        return mInstance;
    }

    private ServerManager() {
    }

    public void init(int i, String str, int i2, String str2, String str3) {
        this.rootPath = str;
        this.port = ServerPort.getPort(i);
        this.noticeIcon = i2;
        this.noticeTitle = str2;
        this.noticeContent = str3;
    }

    public void startService(Context context) {
        if (!this.isConnecting) {
            this.isConnecting = true;
            XesLog.s(TAG, "启动服务");
            Intent intent = new Intent(context, CoreService.class);
            this.intentService = intent;
            intent.putExtra("port", this.port);
            this.intentService.putExtra("rootPath", this.rootPath);
            this.intentService.putExtra("noticeIcon", this.noticeIcon);
            this.intentService.putExtra("noticeTitle", this.noticeTitle);
            this.intentService.putExtra("noticeContent", this.noticeContent);
            if (this.connection == null) {
                this.connection = new ServerConnection();
            }
            this.isConnected = context.bindService(this.intentService, this.connection, 1);
            this.currServerState = 0;
            this.errMsg = null;
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(this.intentService);
            } else {
                context.startService(this.intentService);
            }
        }
    }

    public void stopService(Context context) {
        if (this.intentService != null && context != null) {
            if (!(!this.isConnected || this.iService == null || this.connection == null)) {
                XesLog.s(TAG, "关闭服务");
                try {
                    context.unbindService(this.connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.isConnected = false;
            }
            this.isConnecting = false;
            context.stopService(this.intentService);
            this.onServerConnectionListener = null;
            this.iService = null;
            this.connection = null;
            this.currServerState = 0;
            this.errMsg = null;
            this.mServerUrl = null;
        }
    }

    public void setOnServerConnectionListener(OnServerConnectionListener onServerConnectionListener2) {
        this.onServerConnectionListener = onServerConnectionListener2;
        if (onServerConnectionListener2 != null) {
            int i = this.currServerState;
            if (1 == i) {
                onServerConnectionListener2.onServerStart(this.mServerUrl);
            } else if (3 == i) {
                onServerConnectionListener2.onServerStop();
            } else if (2 == i) {
                onServerConnectionListener2.onServerError(this.errMsg);
            }
        }
    }

    public boolean isServerRunning() {
        IService iService2 = this.iService;
        if (iService2 == null) {
            return false;
        }
        try {
            return iService2.isServerRunning();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    private class ServerConnection implements ServiceConnection {
        private ServerConnection() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XesLog.s(ServerManager.TAG, "服务连接成功");
            boolean unused = ServerManager.this.isConnecting = false;
            boolean unused2 = ServerManager.this.isConnected = true;
            IService unused3 = ServerManager.this.iService = IService.Stub.asInterface(iBinder);
            try {
                ServerManager.this.iService.setCallback(new IServerConnectListener.Stub() {
                    public void onStarted(String str) throws RemoteException {
                        Handler access$400 = ServerManager.this.mHandler;
                        ServerManager$ServerConnection$1$$ExternalSyntheticLambda3 serverManager$ServerConnection$1$$ExternalSyntheticLambda3 = new ServerManager$ServerConnection$1$$ExternalSyntheticLambda3(this, str);
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(serverManager$ServerConnection$1$$ExternalSyntheticLambda3);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, serverManager$ServerConnection$1$$ExternalSyntheticLambda3);
                        }
                    }

                    public /* synthetic */ void lambda$onStarted$0$ServerManager$ServerConnection$1(String str) {
                        XesLog.s(ServerManager.TAG, "回调，服务启动成功");
                        ServerManager.this.setServerState(1);
                        String unused = ServerManager.this.mServerUrl = str;
                        if (ServerManager.this.onServerConnectionListener != null) {
                            ServerManager.this.onServerConnectionListener.onServerStart(str);
                        }
                    }

                    public void onStopped() throws RemoteException {
                        Handler access$400 = ServerManager.this.mHandler;
                        ServerManager$ServerConnection$1$$ExternalSyntheticLambda0 serverManager$ServerConnection$1$$ExternalSyntheticLambda0 = new ServerManager$ServerConnection$1$$ExternalSyntheticLambda0(this);
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(serverManager$ServerConnection$1$$ExternalSyntheticLambda0);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, serverManager$ServerConnection$1$$ExternalSyntheticLambda0);
                        }
                    }

                    public /* synthetic */ void lambda$onStopped$1$ServerManager$ServerConnection$1() {
                        XesLog.i(ServerManager.TAG, "回调，服务停止");
                        ServerManager.this.setServerState(3);
                        if (ServerManager.this.onServerConnectionListener != null) {
                            ServerManager.this.onServerConnectionListener.onServerStop();
                        }
                    }

                    public void onException(String str) throws RemoteException {
                        Handler access$400 = ServerManager.this.mHandler;
                        ServerManager$ServerConnection$1$$ExternalSyntheticLambda2 serverManager$ServerConnection$1$$ExternalSyntheticLambda2 = new ServerManager$ServerConnection$1$$ExternalSyntheticLambda2(this, str);
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(serverManager$ServerConnection$1$$ExternalSyntheticLambda2);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, serverManager$ServerConnection$1$$ExternalSyntheticLambda2);
                        }
                    }

                    public /* synthetic */ void lambda$onException$2$ServerManager$ServerConnection$1(String str) {
                        Tag tag = ServerManager.TAG;
                        XesLog.e(tag, "回调，服务异常: " + str);
                        ServerManager.this.setServerState(2);
                        String unused = ServerManager.this.errMsg = str;
                        if (ServerManager.this.onServerConnectionListener != null) {
                            ServerManager.this.onServerConnectionListener.onServerError(str);
                        }
                    }

                    public void onRequestError(int i, String str) throws RemoteException {
                        Handler access$400 = ServerManager.this.mHandler;
                        ServerManager$ServerConnection$1$$ExternalSyntheticLambda1 serverManager$ServerConnection$1$$ExternalSyntheticLambda1 = new ServerManager$ServerConnection$1$$ExternalSyntheticLambda1(this, i, str);
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(serverManager$ServerConnection$1$$ExternalSyntheticLambda1);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, serverManager$ServerConnection$1$$ExternalSyntheticLambda1);
                        }
                    }

                    public /* synthetic */ void lambda$onRequestError$3$ServerManager$ServerConnection$1(int i, String str) {
                        Tag tag = ServerManager.TAG;
                        XesLog.e(tag, "回调，服务资源异常: code=" + i + ", msg=" + str);
                        if (ServerManager.this.onServerConnectionListener != null) {
                            ServerManager.this.onServerConnectionListener.onServerRequestError(i, str);
                        }
                    }
                });
            } catch (RemoteException e) {
                Tag tag = ServerManager.TAG;
                XesLog.e(tag, "服务连接异常: " + e.getMessage());
                IService unused4 = ServerManager.this.iService = null;
                boolean unused5 = ServerManager.this.isConnecting = false;
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            XesLog.i(ServerManager.TAG, "服务连接断开");
            boolean unused = ServerManager.this.isConnected = false;
            boolean unused2 = ServerManager.this.isConnecting = false;
            IService unused3 = ServerManager.this.iService = null;
        }
    }

    /* access modifiers changed from: private */
    public void setServerState(int i) {
        this.currServerState = i;
    }
}
