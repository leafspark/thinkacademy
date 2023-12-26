package com.igexin.push.extension.distribution.basic.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;

public class a extends SQLiteOpenHelper {
    SQLiteDatabase a = null;

    public a(Context context) {
        super(context, "pushext.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    private String a(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    private String a(String[] strArr, String[] strArr2, int i) {
        StringBuilder sb = new StringBuilder(" ");
        if (strArr.length == 1) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(strArr[0]);
                sb.append(" = '");
                sb.append(strArr2[i2]);
                sb.append("'");
                if (i2 < i - 1) {
                    sb.append(" or ");
                }
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(strArr[i3]);
                sb.append(" = '");
                sb.append(strArr2[i3]);
                sb.append("'");
                if (i3 < i - 1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }

    public Cursor a(String str, String[] strArr) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        try {
            return !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.rawQuery(str, strArr) : SQLiteInstrumentation.rawQuery(readableDatabase, str, strArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public Cursor a(String str, String[] strArr, String str2) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        return !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.query(str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(readableDatabase, str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null);
    }

    public Cursor a(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        Cursor query;
        String[] strArr4 = strArr;
        String[] strArr5 = strArr2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        readableDatabase.beginTransaction();
        Cursor cursor = null;
        if (strArr4 == null) {
            try {
                SQLiteDatabase sQLiteDatabase = this.a;
                query = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query(str, strArr3, (String) null, (String[]) null, (String) null, (String) null, str2) : SQLiteInstrumentation.query(sQLiteDatabase, str, strArr3, (String) null, (String[]) null, (String) null, (String) null, str2);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } else if (strArr4.length != 1) {
            SQLiteDatabase sQLiteDatabase2 = this.a;
            String a2 = a(strArr4, strArr5, strArr4.length);
            query = !(sQLiteDatabase2 instanceof SQLiteDatabase) ? sQLiteDatabase2.query(str, strArr3, a2, (String[]) null, (String) null, (String) null, str2) : SQLiteInstrumentation.query(sQLiteDatabase2, str, strArr3, a2, (String[]) null, (String) null, (String) null, str2);
        } else if (strArr5.length == 1) {
            SQLiteDatabase sQLiteDatabase3 = this.a;
            String str3 = strArr4[0] + " = ? ";
            query = !(sQLiteDatabase3 instanceof SQLiteDatabase) ? sQLiteDatabase3.query(str, strArr3, str3, strArr2, (String) null, (String) null, str2) : SQLiteInstrumentation.query(sQLiteDatabase3, str, strArr3, str3, strArr2, (String) null, (String) null, str2);
        } else {
            SQLiteDatabase sQLiteDatabase4 = this.a;
            String a3 = a(strArr4, strArr5, strArr5.length);
            query = !(sQLiteDatabase4 instanceof SQLiteDatabase) ? sQLiteDatabase4.query(str, strArr3, a3, (String[]) null, (String) null, (String) null, str2) : SQLiteInstrumentation.query(sQLiteDatabase4, str, strArr3, a3, (String[]) null, (String) null, (String) null, str2);
        }
        cursor = query;
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
        return cursor;
    }

    public void a(String str, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.insert(str, (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert(sQLiteDatabase, str, (String) null, contentValues);
            }
            this.a.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
        this.a.endTransaction();
    }

    public void a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        try {
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.replace(str, str2, contentValues);
            } else {
                SQLiteInstrumentation.replace(writableDatabase, str, str2, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void a(String str, String[] strArr, String[] strArr2) {
        SQLiteDatabase sQLiteDatabase;
        String a2;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        if (strArr == null) {
            try {
                SQLiteDatabase sQLiteDatabase3 = this.a;
                if (!(sQLiteDatabase3 instanceof SQLiteDatabase)) {
                    sQLiteDatabase3.delete(str, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.delete(sQLiteDatabase3, str, (String) null, (String[]) null);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } else {
            if (strArr.length != 1) {
                sQLiteDatabase = this.a;
                a2 = a(str, a(strArr, strArr2, strArr.length));
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.execSQL(sQLiteDatabase2, a2);
                }
            } else if (strArr2.length == 1) {
                SQLiteDatabase sQLiteDatabase4 = this.a;
                String str2 = strArr[0] + " = ?";
                if (!(sQLiteDatabase4 instanceof SQLiteDatabase)) {
                    sQLiteDatabase4.delete(str, str2, strArr2);
                } else {
                    SQLiteInstrumentation.delete(sQLiteDatabase4, str, str2, strArr2);
                }
            } else {
                sQLiteDatabase = this.a;
                a2 = a(str, a(strArr, strArr2, strArr2.length));
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.execSQL(sQLiteDatabase2, a2);
                }
            }
            sQLiteDatabase.execSQL(a2);
        }
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
    }

    public void close() {
        try {
            this.a.close();
        } catch (Exception unused) {
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists image(id integer primary key autoincrement, imageurl text, imagesrc text, taskid text, createtime bigint)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists image(id integer primary key autoincrement, imageurl text, imagesrc text, taskid text, createtime bigint)");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists message(id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,createtime integer)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists message(id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,createtime integer)");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            sQLiteDatabase.endTransaction();
            throw th2;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists sc(id integer primary key autoincrement, title text, value text)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists sc(id integer primary key autoincrement, title text, value text)");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused3) {
        } catch (Throwable th3) {
            sQLiteDatabase.endTransaction();
            throw th3;
        }
        sQLiteDatabase.endTransaction();
        try {
            sQLiteDatabase.beginTransaction();
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists extconfig (key integer primary key, value text)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists extconfig (key integer primary key, value text)");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused4) {
        } catch (Throwable th4) {
            sQLiteDatabase.endTransaction();
            throw th4;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists image");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists image");
            }
        } catch (Exception unused) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists message");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists message");
            }
        } catch (Exception unused2) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists sc");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists sc");
            }
        } catch (Exception unused3) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists extconfig");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists extconfig");
            }
        } catch (Exception unused4) {
        }
        onCreate(sQLiteDatabase);
    }
}
