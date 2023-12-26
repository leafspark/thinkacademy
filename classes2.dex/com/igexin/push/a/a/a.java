package com.igexin.push.a.a;

import android.os.Message;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.f.b.c;

public class a implements c {
    private long a = 0;

    public void a() {
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.j;
        com.igexin.push.core.c.a().a(obtain);
    }

    public void a(long j) {
        this.a = j;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.a > 360000;
    }
}
