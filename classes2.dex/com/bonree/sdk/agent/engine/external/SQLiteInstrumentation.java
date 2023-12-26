package com.bonree.sdk.agent.engine.external;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import ohos.aafwk.ability.DataAbilityHelper;
import ohos.aafwk.ability.DataAbilityRemoteException;
import ohos.data.dataability.DataAbilityPredicates;
import ohos.data.rdb.ValuesBucket;
import ohos.data.resultset.ResultSet;
import ohos.utils.net.Uri;

public class SQLiteInstrumentation {
    private static final String DATA_ABILITY_HELPER_DELETE = "DataAbilityHelper/delete";
    private static final String DATA_ABILITY_HELPER_INSERT = "DataAbilityHelper/insert";
    private static final String DATA_ABILITY_HELPER_QUERY = "DataAbilityHelper/query";
    private static final String DATA_ABILITY_HELPER_UPDATE = "DataAbilityHelper/update";
    private static final String HMOS_RDBSTORE_QUERY = "RdbStore/query";
    private static final String HMOS_RDBSTORE_RAWQUERY = "RdbStore/rawquery";
    private static final String SQLITEDATABASE_DELETE = "SQLiteDatabase/delete";
    private static final String SQLITEDATABASE_EXECSQL = "SQLiteDatabase/execSQL";
    private static final String SQLITEDATABASE_INSERT = "SQLiteDatabase/insert";
    private static final String SQLITEDATABASE_INSERTORTHROW = "SQLiteDatabase/insertOrThrow";
    private static final String SQLITEDATABASE_INSERTWITHONCONFLICT = "SQLiteDatabase/insertWithOnConflict";
    private static final String SQLITEDATABASE_QUERY = "SQLiteDatabase/query";
    private static final String SQLITEDATABASE_QUERYWITHFACTORY = "SQLiteDatabase/queryWithFactory";
    private static final String SQLITEDATABASE_RAWQUERY = "SQLiteDatabase/rawQuery";
    private static final String SQLITEDATABASE_RAWQUERYWITHFACTORY = "SQLiteDatabase/queryWithFactory";
    private static final String SQLITEDATABASE_REPLACE = "SQLiteDatabase/replace";
    private static final String SQLITEDATABASE_REPLACEORTHROW = "SQLiteDatabase/replaceOrThrow";
    private static final String SQLITEDATABASE_UPDATE = "SQLiteDatabase/update";
    private static final String SQLITEDATABASE_UPDATEWITHONCONFLICT = "SQLiteDatabase/updateWithOnConflict";

    public static Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        beforeMethod(SQLITEDATABASE_QUERY);
        try {
            return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5);
        } finally {
            afterMethod(SQLITEDATABASE_QUERY);
        }
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        beforeMethod(SQLITEDATABASE_QUERY);
        try {
            return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } finally {
            afterMethod(SQLITEDATABASE_QUERY);
        }
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        beforeMethod(SQLITEDATABASE_QUERY);
        try {
            return sQLiteDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        } finally {
            afterMethod(SQLITEDATABASE_QUERY);
        }
    }

    public static Cursor query(SQLiteDatabase sQLiteDatabase, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        beforeMethod(SQLITEDATABASE_QUERY);
        try {
            return sQLiteDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
        } finally {
            afterMethod(SQLITEDATABASE_QUERY);
        }
    }

    public static Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        beforeMethod(SQLITEDATABASE_RAWQUERY);
        try {
            return sQLiteDatabase.rawQuery(str, strArr);
        } finally {
            afterMethod(SQLITEDATABASE_RAWQUERY);
        }
    }

    public static Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationSignal cancellationSignal) {
        beforeMethod(SQLITEDATABASE_RAWQUERY);
        try {
            return sQLiteDatabase.rawQuery(str, strArr, cancellationSignal);
        } finally {
            afterMethod(SQLITEDATABASE_RAWQUERY);
        }
    }

    public static Cursor queryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        beforeMethod("SQLiteDatabase/queryWithFactory");
        try {
            return sQLiteDatabase.queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6, cancellationSignal);
        } finally {
            afterMethod("SQLiteDatabase/queryWithFactory");
        }
    }

    public static Cursor queryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        beforeMethod("SQLiteDatabase/queryWithFactory");
        try {
            return sQLiteDatabase.queryWithFactory(cursorFactory, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        } finally {
            afterMethod("SQLiteDatabase/queryWithFactory");
        }
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        beforeMethod("SQLiteDatabase/queryWithFactory");
        try {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2);
        } finally {
            afterMethod("SQLiteDatabase/queryWithFactory");
        }
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sQLiteDatabase, SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2, CancellationSignal cancellationSignal) {
        beforeMethod("SQLiteDatabase/queryWithFactory");
        try {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        } finally {
            afterMethod("SQLiteDatabase/queryWithFactory");
        }
    }

    public static long insert(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) {
        beforeMethod(SQLITEDATABASE_INSERT);
        try {
            return sQLiteDatabase.insert(str, str2, contentValues);
        } finally {
            afterMethod(SQLITEDATABASE_INSERT);
        }
    }

    public static long insertOrThrow(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) throws SQLException {
        beforeMethod(SQLITEDATABASE_INSERTORTHROW);
        try {
            return sQLiteDatabase.insertOrThrow(str, str2, contentValues);
        } finally {
            afterMethod(SQLITEDATABASE_INSERTORTHROW);
        }
    }

    public static long insertWithOnConflict(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues, int i) {
        beforeMethod(SQLITEDATABASE_INSERTWITHONCONFLICT);
        try {
            return sQLiteDatabase.insertWithOnConflict(str, str2, contentValues, i);
        } finally {
            afterMethod(SQLITEDATABASE_INSERTWITHONCONFLICT);
        }
    }

    public static long replace(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) {
        beforeMethod(SQLITEDATABASE_REPLACE);
        try {
            return sQLiteDatabase.replace(str, str2, contentValues);
        } finally {
            afterMethod(SQLITEDATABASE_REPLACE);
        }
    }

    public static long replaceOrThrow(SQLiteDatabase sQLiteDatabase, String str, String str2, ContentValues contentValues) throws SQLException {
        beforeMethod(SQLITEDATABASE_REPLACEORTHROW);
        try {
            long replaceOrThrow = sQLiteDatabase.replaceOrThrow(str, str2, contentValues);
            afterMethod(SQLITEDATABASE_REPLACEORTHROW);
            return replaceOrThrow;
        } catch (SQLException e) {
            afterMethod(SQLITEDATABASE_REPLACEORTHROW);
            throw e;
        }
    }

    public static int delete(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        beforeMethod(SQLITEDATABASE_DELETE);
        try {
            return sQLiteDatabase.delete(str, str2, strArr);
        } finally {
            afterMethod(SQLITEDATABASE_DELETE);
        }
    }

    public static int update(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr) {
        beforeMethod(SQLITEDATABASE_UPDATE);
        try {
            return sQLiteDatabase.update(str, contentValues, str2, strArr);
        } finally {
            afterMethod(SQLITEDATABASE_UPDATE);
        }
    }

    public static int updateWithOnConflict(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        beforeMethod(SQLITEDATABASE_UPDATEWITHONCONFLICT);
        try {
            return sQLiteDatabase.updateWithOnConflict(str, contentValues, str2, strArr, i);
        } finally {
            afterMethod(SQLITEDATABASE_UPDATEWITHONCONFLICT);
        }
    }

    public static void execSQL(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        beforeMethod(SQLITEDATABASE_EXECSQL);
        try {
            sQLiteDatabase.execSQL(str);
        } finally {
            afterMethod(SQLITEDATABASE_EXECSQL);
        }
    }

    public static void execSQL(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) throws SQLException {
        beforeMethod(SQLITEDATABASE_EXECSQL);
        try {
            sQLiteDatabase.execSQL(str, objArr);
        } finally {
            afterMethod(SQLITEDATABASE_EXECSQL);
        }
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 4);
    }

    private static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 4);
    }

    public static int insertOfDataAbilityHelper(DataAbilityHelper dataAbilityHelper, Uri uri, ValuesBucket valuesBucket) throws DataAbilityRemoteException {
        beforeMethod(DATA_ABILITY_HELPER_INSERT);
        try {
            return dataAbilityHelper.insert(uri, valuesBucket);
        } finally {
            afterMethod(DATA_ABILITY_HELPER_INSERT);
        }
    }

    public static int updateOfDataAbilityHelper(DataAbilityHelper dataAbilityHelper, Uri uri, ValuesBucket valuesBucket, DataAbilityPredicates dataAbilityPredicates) throws DataAbilityRemoteException {
        beforeMethod(DATA_ABILITY_HELPER_UPDATE);
        try {
            return dataAbilityHelper.update(uri, valuesBucket, dataAbilityPredicates);
        } finally {
            afterMethod(DATA_ABILITY_HELPER_UPDATE);
        }
    }

    public static int deleteOfDataAbilityHelper(DataAbilityHelper dataAbilityHelper, Uri uri, DataAbilityPredicates dataAbilityPredicates) throws DataAbilityRemoteException {
        beforeMethod(DATA_ABILITY_HELPER_DELETE);
        try {
            int delete = dataAbilityHelper.delete(uri, dataAbilityPredicates);
            afterMethod(DATA_ABILITY_HELPER_DELETE);
            return delete;
        } catch (Exception e) {
            afterMethod(DATA_ABILITY_HELPER_DELETE);
            throw e;
        }
    }

    public static ResultSet queryOfDataAbilityHelper(DataAbilityHelper dataAbilityHelper, Uri uri, String[] strArr, DataAbilityPredicates dataAbilityPredicates) throws DataAbilityRemoteException {
        beforeMethod(DATA_ABILITY_HELPER_QUERY);
        try {
            ResultSet query = dataAbilityHelper.query(uri, strArr, dataAbilityPredicates);
            afterMethod(DATA_ABILITY_HELPER_QUERY);
            return query;
        } catch (Exception e) {
            afterMethod(DATA_ABILITY_HELPER_QUERY);
            throw e;
        }
    }
}
