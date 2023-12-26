package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.b.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.core.x;

public class PushReceiver extends BroadcastReceiver {
    private static final String a = "com.igexin.sdk.PushReceiver";

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            try {
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action) || PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(action)) {
                    Intent intent2 = new Intent(context.getApplicationContext(), e.a().a(context));
                    intent2.putExtra("action", action);
                    x.a().a(context, intent2);
                }
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
            }
        }
    }
}
