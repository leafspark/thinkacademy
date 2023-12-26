package com.xueersi.lib.graffiti.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.xueersi.lib.graffiti.utils.XesLog;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME_PREFIX = "action_page";
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        XesLog.d("onCreate");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onVersionChanged(sQLiteDatabase, i, i2);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onVersionChanged(sQLiteDatabase, i, i2);
    }

    private void onVersionChanged(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (XesLog.isEnabled()) {
            XesLog.d("onVersionChange oldVersion:" + i + " newVersion:" + i2);
        }
        Cursor cursor = null;
        try {
            cursor = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type ='table' AND name LIKE 'action_page%'", (String[]) null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT name FROM sqlite_master WHERE type ='table' AND name LIKE 'action_page%'", (String[]) null);
            while (cursor.moveToNext()) {
                try {
                    String str = "DROP TABLE IF EXISTS " + cursor.getString(0);
                    if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                        sQLiteDatabase.execSQL(str);
                    } else {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
                    }
                } catch (Exception unused) {
                    XesLog.d("移除表失败");
                }
            }
            sQLiteDatabase.setVersion(i2);
            if (cursor != null) {
                cursor.close();
            }
            if (!XesLog.isEnabled()) {
                return;
            }
        } catch (Exception e) {
            XesLog.d(e.toString());
            if (cursor != null) {
                cursor.close();
            }
            if (!XesLog.isEnabled()) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (XesLog.isEnabled()) {
                XesLog.d("onVersionChange end");
            }
            throw th;
        }
        XesLog.d("onVersionChange end");
    }
}
