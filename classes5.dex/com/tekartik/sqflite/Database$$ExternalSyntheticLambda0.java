package com.tekartik.sqflite;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

public final /* synthetic */ class Database$$ExternalSyntheticLambda0 implements SQLiteDatabase.CursorFactory {
    public final /* synthetic */ SqlCommand f$0;

    public /* synthetic */ Database$$ExternalSyntheticLambda0(SqlCommand sqlCommand) {
        this.f$0 = sqlCommand;
    }

    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return this.f$0.bindTo(sQLiteQuery);
    }
}
