package com.igexin.push.core;

import android.os.IBinder;
import android.os.Message;
import com.igexin.b.a.c.b;

class s implements IBinder.DeathRecipient {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void binderDied() {
        b.a("MsgServerSender|remote iservice binderDied and reconnect !!!", new Object[0]);
        Message.obtain(this.a.c.a(), 2, 0, 0).sendToTarget();
    }
}
