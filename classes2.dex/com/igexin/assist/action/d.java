package com.igexin.assist.action;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.b.a;
import java.util.UUID;
import org.json.JSONObject;

class d {
    private byte[] a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    d() {
    }

    private void a(Context context) {
        try {
            String str = com.igexin.push.core.d.a;
            this.d = str;
            if (!TextUtils.isEmpty(str)) {
                return;
            }
            if (context != null) {
                String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(AssistPushConsts.GETUI_APPID);
                this.d = string;
                if (TextUtils.isEmpty(string)) {
                    this.d = a.a(context);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public void a(MessageBean messageBean) {
        try {
            Context context = messageBean.getContext();
            String stringMessage = messageBean.getStringMessage();
            if (TextUtils.isEmpty(stringMessage)) {
                return;
            }
            if (context != null) {
                a(context);
                if (!TextUtils.isEmpty(this.d)) {
                    this.e = context.getPackageName();
                    String messageSource = TextUtils.isEmpty(messageBean.getMessageSource()) ? "" : messageBean.getMessageSource();
                    this.c = messageSource + UUID.randomUUID().toString();
                    String a2 = com.igexin.assist.util.a.a(stringMessage, this.d);
                    if (!TextUtils.isEmpty(a2)) {
                        JSONObject jSONObject = new JSONObject(a2);
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_TASKID)) {
                            this.b = jSONObject.getString(AssistPushConsts.MSG_KEY_TASKID);
                        }
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_ACTION)) {
                            this.f = jSONObject.getString(AssistPushConsts.MSG_KEY_ACTION);
                        }
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_CONTENT) && !TextUtils.isEmpty(jSONObject.getString(AssistPushConsts.MSG_KEY_CONTENT))) {
                            this.a = jSONObject.getString(AssistPushConsts.MSG_KEY_CONTENT).getBytes();
                        }
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_ACTION_CHAINS)) {
                            String string = jSONObject.getString(AssistPushConsts.MSG_KEY_ACTION_CHAINS);
                            this.g = string;
                            if (!TextUtils.isEmpty(string)) {
                                JSONObject jSONObject2 = new JSONObject(this.g);
                                jSONObject2.put("extra_actionid", "40550");
                                this.g = !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(boolean z) {
        return (this.a != null || (this.g != null && z)) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.c);
    }

    public byte[] a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.g;
    }
}
