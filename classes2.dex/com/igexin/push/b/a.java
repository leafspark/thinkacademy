package com.igexin.push.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.b.a.d.e;
import com.igexin.push.core.b.b;
import com.igexin.push.core.c;
import java.util.LinkedList;
import java.util.List;

public class a extends e {
    private static final String e = "com.igexin.push.b.a";
    protected SQLiteDatabase a;
    protected Cursor b;
    List<b> c = new LinkedList();
    boolean d;

    public a() {
        super(1);
    }

    public void a(b bVar) {
        this.c.add(bVar);
    }

    public void b() {
        super.b();
        SQLiteDatabase writableDatabase = c.a().k().getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.setVersion(4);
        for (b a2 : this.c) {
            a2.a(this.a);
        }
        for (b next : this.c) {
            if (this.d) {
                next.c(this.a);
            } else {
                next.b(this.a);
            }
        }
        com.igexin.b.a.b.c.b().a((Object) new c(-980948));
        com.igexin.b.a.b.c.b().c();
    }

    public final int b_() {
        return -2147483639;
    }

    public void c() {
        super.c();
        Cursor cursor = this.b;
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public void d() {
        super.d();
        this.m = true;
        this.H = true;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }
}
