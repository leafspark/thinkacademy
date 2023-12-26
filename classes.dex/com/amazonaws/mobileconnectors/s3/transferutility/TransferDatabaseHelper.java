package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class TransferDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "awss3transfertable.db";
    private static final int DATABASE_VERSION = 6;
    private final Context context;
    private int version;

    public TransferDatabaseHelper(Context context2) {
        this(context2, 6);
    }

    public TransferDatabaseHelper(Context context2, int i) {
        super(context2, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, i);
        this.context = context2;
        this.version = i;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TransferTable.onCreate(sQLiteDatabase, this.version);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        TransferTable.onUpgrade(sQLiteDatabase, i, i2);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.context.deleteDatabase(DATABASE_NAME);
        onCreate(sQLiteDatabase);
    }
}
