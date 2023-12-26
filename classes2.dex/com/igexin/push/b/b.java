package com.igexin.push.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.igexin.push.core.b.i;

public class b extends SQLiteOpenHelper {
    private SQLiteDatabase a = null;

    public b(Context context) {
        super(context, "pushsdk.db", (SQLiteDatabase.CursorFactory) null, 4);
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

    private String b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r4.a.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044 A[ExcHandler: all (r5v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x000a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.getWritableDatabase()
            r4.a = r0
            r0.beginTransaction()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.a     // Catch:{ Exception -> 0x004b, all -> 0x0044 }
            r2 = 0
            boolean r3 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x004b, all -> 0x0044 }
            if (r3 != 0) goto L_0x0016
            int r5 = r1.delete(r5, r6, r2)     // Catch:{ Exception -> 0x004b, all -> 0x0044 }
            goto L_0x001c
        L_0x0016:
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch:{ Exception -> 0x004b, all -> 0x0044 }
            int r5 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.delete(r1, r5, r6, r2)     // Catch:{ Exception -> 0x004b, all -> 0x0044 }
        L_0x001c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            r6.<init>()     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            java.lang.String r1 = "DBHelper|del "
            r6.append(r1)     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            r6.append(r5)     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            java.lang.String r1 = " msg"
            r6.append(r1)     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            com.igexin.b.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r0)     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            android.database.sqlite.SQLiteDatabase r6 = r4.a     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            r6.setTransactionSuccessful()     // Catch:{ Exception -> 0x0042, all -> 0x0044 }
            android.database.sqlite.SQLiteDatabase r6 = r4.a
            r6.endTransaction()
            goto L_0x0051
        L_0x0042:
            r0 = r5
            goto L_0x004b
        L_0x0044:
            r5 = move-exception
            android.database.sqlite.SQLiteDatabase r6 = r4.a
            r6.endTransaction()
            throw r5
        L_0x004b:
            android.database.sqlite.SQLiteDatabase r5 = r4.a
            r5.endTransaction()
            r5 = r0
        L_0x0051:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.b.b.a(java.lang.String, java.lang.String):int");
    }

    public Cursor a(String str, String[] strArr, String str2) {
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            this.a = readableDatabase;
            return !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.query(str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(readableDatabase, str, strArr, str2, (String[]) null, (String) null, (String) null, (String) null);
        } catch (Throwable unused) {
            return null;
        }
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
            String str3 = strArr4[0] + "= ?";
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

    public void a(String str, ContentValues contentValues, String[] strArr, String[] strArr2) {
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
                    sQLiteDatabase3.update(str, contentValues, (String) null, (String[]) null);
                } else {
                    SQLiteInstrumentation.update(sQLiteDatabase3, str, contentValues, (String) null, (String[]) null);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        } else {
            if (strArr.length != 1) {
                sQLiteDatabase = this.a;
                a2 = a(strArr, strArr2, strArr.length);
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.update(sQLiteDatabase2, str, contentValues, a2, (String[]) null);
                }
            } else if (strArr2.length == 1) {
                sQLiteDatabase = this.a;
                a2 = strArr[0] + "='" + strArr2[0] + "'";
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.update(sQLiteDatabase2, str, contentValues, a2, (String[]) null);
                }
            } else {
                sQLiteDatabase = this.a;
                a2 = a(strArr, strArr2, strArr2.length);
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.update(sQLiteDatabase2, str, contentValues, a2, (String[]) null);
                }
            }
            sQLiteDatabase.update(str, contentValues, a2, (String[]) null);
        }
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
    }

    public void a(String str, String[] strArr, String[] strArr2) {
        SQLiteDatabase sQLiteDatabase;
        String b;
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
                b = b(str, a(strArr, strArr2, strArr.length));
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.execSQL(sQLiteDatabase2, b);
                }
            } else if (strArr2.length == 1) {
                SQLiteDatabase sQLiteDatabase4 = this.a;
                String str2 = strArr[0] + " = ?";
                com.igexin.b.a.c.b.a("DBHelper|del " + str + " cnt = " + (!(sQLiteDatabase4 instanceof SQLiteDatabase) ? sQLiteDatabase4.delete(str, str2, strArr2) : SQLiteInstrumentation.delete(sQLiteDatabase4, str, str2, strArr2)), new Object[0]);
            } else {
                sQLiteDatabase = this.a;
                b = b(str, a(strArr, strArr2, strArr2.length));
                if (sQLiteDatabase instanceof SQLiteDatabase) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    SQLiteInstrumentation.execSQL(sQLiteDatabase2, b);
                }
            }
            sQLiteDatabase.execSQL(b);
        }
        this.a.setTransactionSuccessful();
        this.a.endTransaction();
    }

    public boolean a(String str, ContentValues contentValues) {
        boolean z;
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
            z = true;
        } catch (Exception unused) {
            z = false;
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
        this.a.endTransaction();
        return z;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists config (id integer primary key,value text)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists config (id integer primary key,value text)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists runtime (id integer primary key,value text)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists runtime (id integer primary key,value text)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists ral (id integer primary key,data text,type integer,time integer)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists ral (id integer primary key,data text,type integer,time integer)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists ca (pkgname text primary key,signature text,permissions text, accesstoken blob, expire integer)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists ca (pkgname text primary key,signature text,permissions text, accesstoken blob, expire integer)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists bi(id integer primary key autoincrement, start_service_count integer, login_count integer, loginerror_nonetwork_count integer, loginerror_timeout_count integer, loginerror_connecterror_count integer, loginerror_other_count integer, online_time long, network_time long, running_time long, create_time text, type integer)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists bi(id integer primary key autoincrement, start_service_count integer, login_count integer, loginerror_nonetwork_count integer, loginerror_timeout_count integer, loginerror_connecterror_count integer, loginerror_other_count integer, online_time long, network_time long, running_time long, create_time text, type integer)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists st(id integer primary key autoincrement,type integer,value blob,time integer)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists st(id integer primary key autoincrement,type integer,value blob,time integer)");
            }
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists at (id integer primary key autoincrement,from_page text,page text,enterTime text,exitTime text,is_exist text,create_time long)");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "create table if not exists at (id integer primary key autoincrement,from_page text,page text,enterTime text,exitTime text,is_exist text,create_time long)");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        i.a().d(sQLiteDatabase);
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists config");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists config");
            }
        } catch (Exception unused) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists runtime");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists runtime");
            }
        } catch (Exception unused2) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists message");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists message");
            }
        } catch (Exception unused3) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists ral");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists ral");
            }
        } catch (Exception unused4) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists ca");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists ca");
            }
        } catch (Exception unused5) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists bi");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists bi");
            }
        } catch (Exception unused6) {
        }
        try {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists st");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "drop table if exists st");
            }
        } catch (Exception unused7) {
        }
        onCreate(sQLiteDatabase);
    }
}
