package com.igexin.push.core.b;

import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public class c implements b {
    private static c b;
    private Map<String, byte[]> a = new HashMap();

    private c() {
    }

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
    }
}
