package com.igexin.assist.action;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.didi.hummer.render.event.base.TraceEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.a;
import com.igexin.assist.util.AssistUtils;
import com.igexin.b.a.c.a.f;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.a.e;
import com.igexin.push.core.b.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.util.b;
import com.igexin.push.util.n;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.GTTransmitMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class MessageManger {
    private final ExecutorService a;
    private String b;
    private Class c;

    private MessageManger() {
        this.a = Executors.newSingleThreadExecutor();
    }

    /* synthetic */ MessageManger(a aVar) {
        this();
    }

    private PushTaskBean a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(dVar.d());
        pushTaskBean.setMessageId(dVar.c());
        pushTaskBean.setTaskId(dVar.b());
        pushTaskBean.setId(String.valueOf(currentTimeMillis));
        pushTaskBean.setAppKey(d.b);
        pushTaskBean.setCurrentActionid(1);
        return pushTaskBean;
    }

    private Class a(Context context) {
        try {
            String str = (String) n.c(context, "uis", "", new String[0]);
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, d dVar) {
        if (!d.h.get()) {
            AssistUtils.startGetuiService(context);
        }
        if (dVar != null) {
            Message obtain = Message.obtain();
            obtain.what = CoreConsts.l;
            obtain.obj = dVar.g();
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.Param.CONTENT, dVar.g());
            if (dVar.a() != null) {
                bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, dVar.a());
            }
            obtain.setData(bundle);
            c.a().a(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            new com.igexin.push.core.b.d(context).c(str);
            if (d.h.get()) {
                a(str, z);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new a(this, str, z), 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(d dVar, Context context) {
        StringBuilder sb;
        if (dVar != null && context != null) {
            try {
                com.igexin.push.core.b.d dVar2 = new com.igexin.push.core.b.d(context);
                if (!dVar2.a(dVar.b())) {
                    dVar2.b(dVar.b());
                    if (this.c == null) {
                        Class a2 = a(context);
                        this.c = a2;
                        if (a2 == null) {
                            this.c = (Class) b.a(context, GTIntentService.class).second;
                        }
                    }
                    if (this.c != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("action", 10001);
                        String b2 = dVar.b();
                        String c2 = dVar.c();
                        bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(b2, c2, dVar.c() + ":" + dVar.b(), dVar.a()));
                        r.a().a(bundle);
                    } else {
                        Intent intent = new Intent();
                        if (Build.VERSION.SDK_INT >= 12) {
                            intent.addFlags(32);
                        }
                        intent.setAction("com.igexin.sdk.action." + dVar.d());
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("action", 10001);
                        bundle2.putString("taskid", dVar.b());
                        bundle2.putString("messageid", dVar.c());
                        bundle2.putString("appid", dVar.d());
                        bundle2.putString("payloadid", dVar.c() + ":" + dVar.b());
                        bundle2.putString("packagename", dVar.f());
                        bundle2.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, dVar.a());
                        intent.putExtras(bundle2);
                        context.sendBroadcast(intent);
                    }
                    sb = new StringBuilder();
                    sb.append(getBrandCode(context));
                    sb.append(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
                } else {
                    sb = new StringBuilder();
                    sb.append(getBrandCode(context));
                    sb.append("1");
                }
                feedbackPushMessage(context, dVar, sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str) {
        try {
            r.a().a(str);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        Log.e("Assist_MessageManger", "other token = " + str);
        a(str);
        if (!z) {
            try {
                if (str.equals(d.B)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        i.a().c(str);
        if (d.n) {
            e.a().e();
        } else if (z) {
            i.a().d("");
        }
    }

    public static MessageManger getInstance() {
        return c.a;
    }

    public void addMessage(MessageBean messageBean) {
        ExecutorService executorService = this.a;
        if (executorService != null) {
            executorService.execute(new b(this, messageBean));
        }
    }

    public void feedbackPushMessage(Context context, d dVar, String str) {
        try {
            if (d.h.get()) {
                e.a().a(a(dVar), str);
                return;
            }
            com.igexin.push.core.b.d dVar2 = new com.igexin.push.core.b.d(context);
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(currentTimeMillis));
            jSONObject.put("messageid", dVar.c());
            jSONObject.put("taskid", dVar.b());
            jSONObject.put("multaid", str);
            jSONObject.put(TraceEvent.TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            dVar2.a(dVar.b(), jSONObject);
        } catch (Throwable unused) {
        }
    }

    public String getBrandCode(Context context) {
        String str;
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (a.d(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW;
        } else if (a.b(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM;
        } else if (a.c(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ;
        } else if (a.e(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO;
        } else if (a.f(context)) {
            str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO;
        } else {
            if (a.g(context)) {
                str = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST;
            }
            return this.b;
        }
        this.b = str;
        return this.b;
    }

    public void log(String str) {
        f.a().a(str);
    }
}
