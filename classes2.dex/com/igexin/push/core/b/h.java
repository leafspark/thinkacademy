package com.igexin.push.core.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.igexin.push.b.d;

class h extends d {
    final /* synthetic */ long a;
    final /* synthetic */ e b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h(e eVar, ContentValues contentValues, long j) {
        super(contentValues);
        this.b = eVar;
        this.a = j;
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = this.d;
        ContentValues contentValues = this.f;
        String[] strArr = {String.valueOf(this.a)};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.update("ral", contentValues, "id=?", strArr);
        } else {
            SQLiteInstrumentation.update(sQLiteDatabase, "ral", contentValues, "id=?", strArr);
        }
    }
}
