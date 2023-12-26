package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.igexin.push.b.d;

class f extends d {
    final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(e eVar, ContentValues contentValues) {
        super(contentValues);
        this.a = eVar;
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = this.d;
        ContentValues contentValues = this.f;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.replace("ral", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.replace(sQLiteDatabase, "ral", (String) null, contentValues);
        }
    }
}
