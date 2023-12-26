package com.igexin.push.extension.distribution.basic.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.b.b;

class f implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ PushTaskBean b;
    final /* synthetic */ e c;

    f(e eVar, b bVar, PushTaskBean pushTaskBean) {
        this.c = eVar;
        this.a = bVar;
        this.b = pushTaskBean;
    }

    public void run() {
        Context context = d.g;
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            context.startActivity(intent);
            if (!TextUtils.isEmpty(this.a.getDoActionId())) {
                e.a().a(this.b.getTaskId(), this.b.getMessageId(), this.a.getDoActionId());
            }
        } catch (Throwable th) {
            com.igexin.b.a.c.b.a("StartHomeAction | " + th.toString(), new Object[0]);
        }
    }
}
