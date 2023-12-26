package com.igexin.push.extension.distribution.basic.a;

import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.b.a;
import com.igexin.push.extension.distribution.basic.f.e;

class b implements e {
    final /* synthetic */ BaseAction a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ a f;

    b(a aVar, BaseAction baseAction, String str, String str2, String str3, int i) {
        this.f = aVar;
        this.a = baseAction;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i;
    }

    public void a(BaseAction baseAction) {
        int i = this.e;
        if (i == 2) {
            ((a) this.a).d(true);
        } else if (i == 8) {
            ((a) this.a).c(true);
        }
        a aVar = (a) baseAction;
        if (aVar.s() && aVar.k() && d.a(this.b, true) == 0) {
            com.igexin.push.core.a.e.a().a(this.b, this.c, "1");
        }
    }

    public void a(Exception exc) {
        if (((a) this.a).t() >= 3) {
            ((a) this.a).d(true);
        }
        if (((a) this.a).l() >= 3) {
            ((a) this.a).c(true);
        }
        if (!((a) this.a).s() || !((a) this.a).k()) {
            this.f.a(this.d, this.b, this.c, this.a, this.e);
        } else if (d.a(this.b, true) == 0) {
            com.igexin.push.core.a.e.a().a(this.b, this.c, "1");
        }
    }
}
