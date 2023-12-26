package com.igexin.push.core;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.didi.hummer.render.event.base.TraceEvent;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class r extends Handler implements ServiceConnection {
    private static volatile r b;
    private final ConcurrentLinkedQueue<Intent> a;
    /* access modifiers changed from: private */
    public final t c;
    private boolean d;
    private volatile Messenger e;
    private final IBinder.DeathRecipient f = new s(this);

    private r() {
        super(Looper.getMainLooper());
        t tVar = new t(this);
        this.c = tVar;
        this.a = new ConcurrentLinkedQueue<>();
        Message.obtain(tVar.a(), 3, 1, 0).sendToTarget();
    }

    public static r a() {
        if (b == null) {
            synchronized (r.class) {
                if (b == null) {
                    b = new r();
                }
            }
        }
        return b;
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + str3);
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10001);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("appid", str3);
        bundle.putString("payloadid", str2 + ":" + str);
        bundle.putString("packagename", d.e);
        bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        intent.putExtras(bundle);
        intent.setPackage(d.g.getPackageName());
        d.g.sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z && this.e != null) {
            try {
                this.e.getBinder().unlinkToDeath(this.f, 0);
            } catch (Throwable unused) {
            }
            this.d = false;
            this.e = null;
        }
        if (!this.d) {
            e();
            this.d = true;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(IBinder iBinder) {
        if (iBinder == null) {
            return false;
        }
        this.e = new Messenger(iBinder);
        try {
            iBinder.linkToDeath(this.f, 0);
            return true;
        } catch (Exception e2) {
            b.a("MsgServerSender|linkToDeath to iservice ex = " + e2.toString(), new Object[0]);
            return true;
        }
    }

    private void b(Intent intent) {
        if (intent != null) {
            if (this.e == null) {
                b.a("MsgServerSender|realSend, remoteMessenger is null", new Object[0]);
            }
            Bundle extras = intent.getExtras();
            if (extras != null && extras.get("action") != null && (extras.get("action") instanceof Integer)) {
                int i = extras.getInt("action");
                b.a("MsgServerSender|realSend action = " + i, new Object[0]);
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = intent;
                try {
                    this.e.send(obtain);
                } catch (Exception e2) {
                    b.a("MsgServerSender|realSend iservice error = " + e2.toString(), new Object[0]);
                    if (e2 instanceof DeadObjectException) {
                        Message.obtain(this.c.a(), 2, 0, 0).sendToTarget();
                    }
                }
            }
        }
    }

    private void e() {
        b.a("MsgServerSender|try to bind iservice", new Object[0]);
        try {
            Intent intent = new Intent(d.g, d());
            intent.setType(d.g.getPackageName());
            d.g.bindService(intent, this, 1);
        } catch (Exception e2) {
            Log.e("MsgServerSender", "bind iservice error = " + e2.toString());
            b.a("MsgServerSender|bind iservice error = " + e2.toString(), new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        while (!this.a.isEmpty()) {
            Intent poll = this.a.poll();
            if (poll != null) {
                b(poll);
            }
        }
    }

    private Intent g() {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + d.a);
        intent.setPackage(d.g.getPackageName());
        return intent;
    }

    public void a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_SDKSERVICEPID);
        bundle.putInt(PushConsts.KEY_SERVICE_PIT, i);
        a(bundle);
    }

    public void a(Intent intent) {
        if (this.e != null) {
            b(intent);
        } else {
            this.a.add(intent);
        }
    }

    public void a(Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(intent);
    }

    public void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_DEVICETOKEN);
        bundle.putString(PushConsts.KEY_DEVICE_TOKEN, str);
        a(bundle);
    }

    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
        a(bundle);
    }

    public void a(String str, String str2, String str3, String str4) {
        byte[] bArr;
        b.a("startapp|broadcastPayload", new Object[0]);
        if (str4 != null) {
            bArr = str4.getBytes();
        } else {
            PushTaskBean pushTaskBean = d.ae.get(e.a().a(str, str2));
            bArr = pushTaskBean != null ? pushTaskBean.getMsgExtra() : null;
        }
        if (bArr != null) {
            b.a("startapp|broadcast|payload = " + new String(bArr), new Object[0]);
            if (d.a != null && d.a.equals(str3)) {
                Bundle bundle = new Bundle();
                bundle.putInt("action", 10001);
                bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, str2 + ":" + str, bArr));
                a(bundle);
            }
            a(str, str2, str3, bArr);
            return;
        }
        b.a("startapp|broadcast|payload is empty!", new Object[0]);
    }

    public void a(String str, String str2, String str3, String str4, long j) {
        String str5 = str;
        if (d.a != null && d.a.equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(str2, str3, str4, j, PushConsts.THIRDPART_FEEDBACK));
            a(bundle);
        }
        Intent g = g();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", PushConsts.THIRDPART_FEEDBACK);
        bundle2.putString("appid", str);
        String str6 = str2;
        bundle2.putString("taskid", str2);
        String str7 = str3;
        bundle2.putString("actionid", str3);
        String str8 = str4;
        bundle2.putString("result", str4);
        bundle2.putLong(TraceEvent.TIMESTAMP, j);
        g.putExtras(bundle2);
        d.g.sendBroadcast(g);
    }

    public void b() {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.GET_SDKONLINESTATE);
        bundle.putBoolean(PushConsts.KEY_ONLINE_STATE, d.n);
        a(bundle);
        Intent g = g();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", PushConsts.GET_SDKONLINESTATE);
        bundle2.putBoolean(PushConsts.KEY_ONLINE_STATE, d.n);
        g.putExtras(bundle2);
        d.g.sendBroadcast(g);
    }

    public void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new BindAliasCmdMessage(str, str2, 10010));
        a(bundle);
    }

    public void b(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10011);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_ARRIVED, new GTNotificationMessage(str, str2, str3, str4));
        a(bundle);
    }

    public void c() {
        Log.d("PushService", "clientid is " + d.u);
        b.a("broadcastClientId|" + d.u, new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10002);
        bundle.putString(PushConsts.KEY_CLIENT_ID, d.u);
        a(bundle);
        Intent g = g();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("action", 10002);
        bundle2.putString(PushConsts.KEY_CLIENT_ID, d.u);
        g.putExtras(bundle2);
        d.g.sendBroadcast(g);
    }

    public void c(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(PushConsts.KEY_CMD_MSG, new UnBindAliasCmdMessage(str, str2, 10011));
        a(bundle);
    }

    public void c(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", PushConsts.ACTION_NOTIFICATION_CLICKED);
        bundle.putSerializable(PushConsts.KEY_NOTIFICATION_CLICKED, new GTNotificationMessage(str, str2, str3, str4));
        a(bundle);
    }

    public Class d() {
        return x.a().c(d.g);
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        int i = message.what;
        super.handleMessage(message);
        AsynchronousInstrumentation.handlerMessageEnd();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.a("MsgServerSender|remote iservice connected ", new Object[0]);
        Message.obtain(this.c.a(), 1, iBinder).sendToTarget();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        b.a("MsgServerSender|remote iservice disConnected ~~~", new Object[0]);
        Message.obtain(this.c.a(), 2, 0, 0).sendToTarget();
    }
}
