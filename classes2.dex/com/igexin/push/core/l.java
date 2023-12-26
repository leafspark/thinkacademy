package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.igexin.b.a.c.b;
import com.igexin.sdk.PushConsts;

public class l extends BroadcastReceiver {
    private static l a;

    private l() {
    }

    public static l a() {
        if (a == null) {
            a = new l();
        }
        return a;
    }

    private void a(Intent intent) {
        try {
            b.a("----------------------------------------------------------------------------------", new Object[0]);
            b.a("InternalPublicReceiver|action = " + intent.getAction() + ", component = " + intent.getComponent(), new Object[0]);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    b.a("InternalPublicReceiver|key [" + str + "]: " + extras.get(str), new Object[0]);
                }
                return;
            }
            b.a("InternalPublicReceiver|no extras", new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (!(intent == null || intent.getAction() == null || !intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE))) {
            a(intent);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("InternalPublicReceiver InternalPublicReceiver:");
        sb.append(intent != null ? intent.getAction() : "null");
        b.a(sb.toString(), new Object[0]);
        if (c.a() != null) {
            Message message = new Message();
            message.what = CoreConsts.g;
            message.obj = intent;
            c.a().a(message);
        }
    }
}
