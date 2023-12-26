package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;
import com.igexin.push.core.d.e;

class h implements e {
    final /* synthetic */ Object a;
    final /* synthetic */ g b;

    h(g gVar, Object obj) {
        this.b = gVar;
        this.a = obj;
    }

    public void a(boolean z, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(d.ax)) {
            i.a().g(str);
        }
        synchronized (this.a) {
            boolean unused = this.b.b = false;
            this.a.notifyAll();
        }
    }
}
