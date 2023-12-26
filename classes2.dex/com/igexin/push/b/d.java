package com.igexin.push.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.b.a.d.e;
import com.igexin.push.config.k;
import com.igexin.push.core.c;

public abstract class d extends e {
    private static final String a = k.a;
    protected SQLiteDatabase d;
    protected Cursor e;
    protected ContentValues f;
    public c g;

    public d() {
        super(1);
    }

    public d(ContentValues contentValues) {
        super(1);
        this.f = contentValues;
    }

    public abstract void a();

    public void b() {
        super.b();
        this.d = c.a().k().getWritableDatabase();
        a();
        if (this.g != null) {
            com.igexin.b.a.b.c.b().a((Object) this.g);
            com.igexin.b.a.b.c.b().c();
        }
    }

    public final int b_() {
        return -2147483640;
    }

    public void c() {
        super.c();
        Cursor cursor = this.e;
        if (cursor != null && !cursor.isClosed()) {
            try {
                this.e.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        this.m = true;
        this.H = true;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }
}
