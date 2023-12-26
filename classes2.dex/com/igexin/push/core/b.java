package com.igexin.push.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.config.l;
import com.igexin.push.core.a.e;
import com.igexin.push.core.a.j;
import com.igexin.push.core.b.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.d.c.m;
import com.igexin.push.f.b.f;
import com.igexin.sdk.PushConsts;

public class b extends Handler {
    private static String a = "com.igexin.push.core.b";

    public b(Looper looper) {
        super(looper);
    }

    private void a() {
        if (!d.n && d.F > 10000) {
            int random = (int) ((Math.random() * 100.0d) + 150.0d);
            com.igexin.b.a.c.b.a(a + "|userPresent, reConnectDelayTime = " + d.F + ", resetDelay = " + random, new Object[0]);
            d.F = (long) random;
            f.i().j();
        }
    }

    private void a(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("action");
        com.igexin.b.a.c.b.a(a + "|processIntentMsgService action：" + stringExtra, new Object[0]);
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
            e.a().a(intent);
        } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_ONRESUME)) {
            com.igexin.b.a.c.b.a(a + "|handle onresume ~~~", new Object[0]);
            e.a().c("onResume");
        } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
            e.a().b(intent);
            AssistPushManager.getInstance().turnOnPush(d.g);
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
            String stringExtra2 = intent.getStringExtra("sc");
            if (TextUtils.isEmpty(d.f) || d.f.equals(stringExtra2)) {
                e.a().a(intent.getBundleExtra("bundle"));
                return;
            }
            com.igexin.b.a.c.b.a("safeCode not match!!" + d.f + "," + stringExtra2, new Object[0]);
            com.igexin.b.a.c.a.f.a().a("safeCode not match!!" + d.f + "," + stringExtra2);
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
            a();
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK)) {
            Intent intent2 = (Intent) intent.getParcelableExtra("broadcast_intent");
            if (intent2 != null) {
                String action = intent2.getAction();
                if (!TextUtils.isEmpty(action) && action.startsWith("pre_doaction.")) {
                    str = CoreConsts.b;
                } else if (TextUtils.isEmpty(action) || !action.startsWith("pre_burypoint.")) {
                    d.g.sendBroadcast(intent2);
                    return;
                } else {
                    str = CoreConsts.a;
                }
                intent2.setAction(str);
                e.a().c(intent2);
            }
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_NOTIFICATION_DELETE)) {
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.setAppid(intent.getStringExtra("appid"));
            pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
            pushTaskBean.setTaskId(intent.getStringExtra("taskid"));
            pushTaskBean.setId(intent.getStringExtra("id"));
            pushTaskBean.setAppKey(intent.getStringExtra("appkey"));
            try {
                int parseInt = Integer.parseInt(intent.getStringExtra("feedbackid")) + 30040;
                pushTaskBean.setCurrentActionid(parseInt);
                e a2 = e.a();
                a2.a(pushTaskBean, parseInt + "", "notifyStyle:" + intent.getStringExtra("notifyStyle"));
            } catch (Exception unused) {
                e.a().b(pushTaskBean, "30040");
            }
            String a3 = e.a().a(intent.getStringExtra("taskid"), intent.getStringExtra("messageid"));
            com.igexin.b.a.c.b.a(a + "|notification delete = " + a3, new Object[0]);
            try {
                d.ae.remove(a3);
                com.igexin.b.a.c.b.a(a + "|del notification, pushMessageMap remove = " + a3, new Object[0]);
            } catch (Exception e) {
                com.igexin.b.a.c.b.a("EndAction|" + e.toString(), new Object[0]);
            }
        }
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        try {
            if (message.what == CoreConsts.j) {
                w.a().f();
                AsynchronousInstrumentation.handlerMessageEnd();
            } else if (message.obj == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
            } else {
                if (message.what == CoreConsts.f) {
                    Intent intent = (Intent) message.obj;
                    if (intent.hasExtra("action")) {
                        a(intent);
                    }
                } else if (message.what == CoreConsts.g) {
                    e.a().c((Intent) message.obj);
                } else if (message.what == CoreConsts.h) {
                    Bundle bundle = (Bundle) message.obj;
                    w.a().b(bundle.getString("taskid"), bundle.getString("messageid"));
                } else if (message.what == CoreConsts.i) {
                    Bundle bundle2 = (Bundle) message.obj;
                    String string = bundle2.getString("taskid");
                    String string2 = bundle2.getString("messageid");
                    String string3 = bundle2.getString("actionid");
                    com.igexin.b.a.c.b.a(a + "|hand execute_action taskid = " + string + ", actionid = " + string3, new Object[0]);
                    w.a().b(string, string2, string3);
                } else if (message.what == CoreConsts.k) {
                    i.a().c((String) message.obj);
                    if (d.n) {
                        e.a().e();
                    }
                } else if (message.what == CoreConsts.l) {
                    if (l.H) {
                        if (!"false".equals(d.B)) {
                            m mVar = new m();
                            mVar.d();
                            mVar.e = message.obj;
                            mVar.f = message.getData().getByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD);
                            new j().a((Object) mVar);
                        }
                    }
                    AsynchronousInstrumentation.handlerMessageEnd();
                    return;
                }
                AsynchronousInstrumentation.handlerMessageEnd();
            }
        } catch (Throwable th) {
            com.igexin.b.a.c.b.a(a + "|" + th.toString(), new Object[0]);
        }
    }
}
