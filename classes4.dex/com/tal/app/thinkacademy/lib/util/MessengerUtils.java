package com.tal.app.thinkacademy.lib.util;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessengerUtils {
    private static final String KEY_STRING = "MESSENGER_UTILS";
    private static final int WHAT_SEND = 2;
    private static final int WHAT_SUBSCRIBE = 0;
    private static final int WHAT_UNSUBSCRIBE = 1;
    private static Map<String, Client> sClientMap = new HashMap();
    private static Client sLocalClient;
    /* access modifiers changed from: private */
    public static ConcurrentHashMap<String, MessageCallback> subscribers = new ConcurrentHashMap<>();

    public interface MessageCallback {
        void messageCall(Bundle bundle);
    }

    public static void register() {
        if (UtilsBridge.isMainProcess()) {
            if (UtilsBridge.isServiceRunning(ServerService.class.getName())) {
                Log.i("MessengerUtils", "Server service is running.");
                return;
            }
            Utils.getApp().startService(new Intent(Utils.getApp(), ServerService.class));
        } else if (sLocalClient == null) {
            Client client = new Client((String) null);
            if (client.bind()) {
                sLocalClient = client;
            } else {
                Log.e("MessengerUtils", "Bind service failed.");
            }
        } else {
            Log.i("MessengerUtils", "The client have been bind.");
        }
    }

    public static void unregister() {
        if (UtilsBridge.isMainProcess()) {
            if (!UtilsBridge.isServiceRunning(ServerService.class.getName())) {
                Log.i("MessengerUtils", "Server service isn't running.");
                return;
            } else {
                Utils.getApp().stopService(new Intent(Utils.getApp(), ServerService.class));
            }
        }
        Client client = sLocalClient;
        if (client != null) {
            client.unbind();
        }
    }

    public static void register(String str) {
        if (sClientMap.containsKey(str)) {
            Log.i("MessengerUtils", "register: client registered: " + str);
            return;
        }
        Client client = new Client(str);
        if (client.bind()) {
            sClientMap.put(str, client);
            return;
        }
        Log.e("MessengerUtils", "register: client bind failed: " + str);
    }

    public static void unregister(String str) {
        if (sClientMap.containsKey(str)) {
            sClientMap.remove(str);
            sClientMap.get(str).unbind();
            return;
        }
        Log.i("MessengerUtils", "unregister: client didn't register: " + str);
    }

    public static void subscribe(String str, MessageCallback messageCallback) {
        subscribers.put(str, messageCallback);
    }

    public static void unsubscribe(String str) {
        subscribers.remove(str);
    }

    public static void post(String str, Bundle bundle) {
        bundle.putString(KEY_STRING, str);
        Client client = sLocalClient;
        if (client != null) {
            client.sendMsg2Server(bundle);
        } else {
            Intent intent = new Intent(Utils.getApp(), ServerService.class);
            intent.putExtras(bundle);
            Utils.getApp().startService(intent);
        }
        for (Client sendMsg2Server : sClientMap.values()) {
            sendMsg2Server.sendMsg2Server(bundle);
        }
    }

    static class Client {
        LinkedList<Bundle> mCached = new LinkedList<>();
        Messenger mClient = new Messenger(this.mReceiveServeMsgHandler);
        ServiceConnection mConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("MessengerUtils", "client service connected " + componentName);
                Client.this.mServer = new Messenger(iBinder);
                Message obtain = Message.obtain(Client.this.mReceiveServeMsgHandler, 0, UtilsBridge.getCurrentProcessName().hashCode(), 0);
                obtain.replyTo = Client.this.mClient;
                try {
                    Client.this.mServer.send(obtain);
                } catch (RemoteException e) {
                    Log.e("MessengerUtils", "onServiceConnected: ", e);
                }
                Client.this.sendCachedMsg2Server();
            }

            public void onServiceDisconnected(ComponentName componentName) {
                Log.w("MessengerUtils", "client service disconnected:" + componentName);
                Client.this.mServer = null;
                if (!Client.this.bind()) {
                    Log.e("MessengerUtils", "client service rebind failed: " + componentName);
                }
            }
        };
        String mPkgName;
        Handler mReceiveServeMsgHandler = new Handler() {
            public void handleMessage(Message message) {
                String string;
                MessageCallback messageCallback;
                AsynchronousInstrumentation.handlerMessageBegin(this, message);
                Bundle data = message.getData();
                if (!(data == null || (string = data.getString(MessengerUtils.KEY_STRING)) == null || (messageCallback = (MessageCallback) MessengerUtils.subscribers.get(string)) == null)) {
                    messageCallback.messageCall(data);
                }
                AsynchronousInstrumentation.handlerMessageEnd();
            }
        };
        Messenger mServer;

        Client(String str) {
            this.mPkgName = str;
        }

        /* access modifiers changed from: package-private */
        public boolean bind() {
            if (TextUtils.isEmpty(this.mPkgName)) {
                return Utils.getApp().bindService(new Intent(Utils.getApp(), ServerService.class), this.mConn, 1);
            } else if (!UtilsBridge.isAppInstalled(this.mPkgName)) {
                Log.e("MessengerUtils", "bind: the app is not installed -> " + this.mPkgName);
                return false;
            } else if (UtilsBridge.isAppRunning(this.mPkgName)) {
                Intent intent = new Intent(this.mPkgName + ".messenger");
                intent.setPackage(this.mPkgName);
                return Utils.getApp().bindService(intent, this.mConn, 1);
            } else {
                Log.e("MessengerUtils", "bind: the app is not running -> " + this.mPkgName);
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void unbind() {
            Message obtain = Message.obtain(this.mReceiveServeMsgHandler, 1, UtilsBridge.getCurrentProcessName().hashCode(), 0);
            obtain.replyTo = this.mClient;
            try {
                this.mServer.send(obtain);
            } catch (RemoteException e) {
                Log.e("MessengerUtils", "unbind: ", e);
            }
            try {
                Utils.getApp().unbindService(this.mConn);
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public void sendMsg2Server(Bundle bundle) {
            if (this.mServer == null) {
                this.mCached.addFirst(bundle);
                Log.i("MessengerUtils", "save the bundle " + bundle);
                return;
            }
            sendCachedMsg2Server();
            if (!send2Server(bundle)) {
                this.mCached.addFirst(bundle);
            }
        }

        /* access modifiers changed from: private */
        public void sendCachedMsg2Server() {
            if (!this.mCached.isEmpty()) {
                for (int size = this.mCached.size() - 1; size >= 0; size--) {
                    if (send2Server(this.mCached.get(size))) {
                        this.mCached.remove(size);
                    }
                }
            }
        }

        private boolean send2Server(Bundle bundle) {
            Message obtain = Message.obtain(this.mReceiveServeMsgHandler, 2);
            obtain.setData(bundle);
            obtain.replyTo = this.mClient;
            try {
                this.mServer.send(obtain);
                return true;
            } catch (RemoteException e) {
                Log.e("MessengerUtils", "send2Server: ", e);
                return false;
            }
        }
    }

    public static class ServerService extends Service {
        /* access modifiers changed from: private */
        public final ConcurrentHashMap<Integer, Messenger> mClientMap = new ConcurrentHashMap<>();
        private final Handler mReceiveClientMsgHandler;
        private final Messenger messenger;

        public ServerService() {
            AnonymousClass1 r0 = new Handler() {
                public void handleMessage(Message message) {
                    AsynchronousInstrumentation.handlerMessageBegin(this, message);
                    int i = message.what;
                    if (i == 0) {
                        ServerService.this.mClientMap.put(Integer.valueOf(message.arg1), message.replyTo);
                    } else if (i == 1) {
                        ServerService.this.mClientMap.remove(Integer.valueOf(message.arg1));
                    } else if (i != 2) {
                        super.handleMessage(message);
                    } else {
                        ServerService.this.sendMsg2Client(message);
                        ServerService.this.consumeServerProcessCallback(message);
                    }
                    AsynchronousInstrumentation.handlerMessageEnd();
                }
            };
            this.mReceiveClientMsgHandler = r0;
            this.messenger = new Messenger(r0);
        }

        public IBinder onBind(Intent intent) {
            return this.messenger.getBinder();
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            Bundle extras;
            PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
            if (!(intent == null || (extras = intent.getExtras()) == null)) {
                Message obtain = Message.obtain(this.mReceiveClientMsgHandler, 2);
                obtain.replyTo = this.messenger;
                obtain.setData(extras);
                sendMsg2Client(obtain);
                consumeServerProcessCallback(obtain);
            }
            return 2;
        }

        /* access modifiers changed from: private */
        public void sendMsg2Client(Message message) {
            for (Messenger next : this.mClientMap.values()) {
                if (next != null) {
                    try {
                        next.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void consumeServerProcessCallback(Message message) {
            String string;
            MessageCallback messageCallback;
            Bundle data = message.getData();
            if (data != null && (string = data.getString(MessengerUtils.KEY_STRING)) != null && (messageCallback = (MessageCallback) MessengerUtils.subscribers.get(string)) != null) {
                messageCallback.messageCall(data);
            }
        }
    }
}
