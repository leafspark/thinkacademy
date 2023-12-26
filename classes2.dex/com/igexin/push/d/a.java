package com.igexin.push.d;

import android.content.Context;
import com.igexin.b.a.b.a.a.m;
import com.igexin.b.a.b.b;
import com.igexin.b.a.b.d;

public class a implements com.igexin.b.a.d.a.a<String, Integer, b, d> {
    public Context a;

    public a(Context context) {
        this.a = context;
    }

    public d a(String str, Integer num, b bVar) {
        if (!str.startsWith("socket") || !com.igexin.push.core.d.i) {
            return null;
        }
        return new m(str, bVar);
    }
}
