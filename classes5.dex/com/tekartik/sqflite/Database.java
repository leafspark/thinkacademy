package com.tekartik.sqflite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.tekartik.sqflite.operation.BatchOperation;
import com.tekartik.sqflite.operation.MethodCallOperation;
import com.tekartik.sqflite.operation.Operation;
import com.tekartik.sqflite.operation.QueuedOperation;
import com.tekartik.sqflite.operation.SqlErrorInfo;
import io.agora.rtc.Constants;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Database {
    static final boolean WAL_ENABLED_BY_DEFAULT = false;
    private static final String WAL_ENABLED_META_NAME = "com.tekartik.sqflite.wal_enabled";
    private static Boolean walGloballyEnabled;
    final Context context;
    private Integer currentTransactionId;
    final Map<Integer, SqfliteCursor> cursors = new HashMap();
    public DatabaseWorkerPool databaseWorkerPool;
    final int id;
    private int lastCursorId = 0;
    private int lastTransactionId = 0;
    final int logLevel;
    final List<QueuedOperation> noTransactionOperationQueue = new ArrayList();
    final String path;
    final boolean singleInstance;
    SQLiteDatabase sqliteDatabase;
    private int transactionDepth = 0;

    Database(Context context2, String str, int i, boolean z, int i2) {
        this.context = context2;
        this.path = str;
        this.singleInstance = z;
        this.id = i;
        this.logLevel = i2;
    }

    protected static boolean checkWalEnabled(Context context2) {
        return checkMetaBoolean(context2, WAL_ENABLED_META_NAME, false);
    }

    static ApplicationInfo getApplicationInfoWithMeta32(Context context2, String str, int i) throws PackageManager.NameNotFoundException {
        return context2.getPackageManager().getApplicationInfo(str, i);
    }

    protected static boolean checkMetaBoolean(Context context2, String str, boolean z) {
        ApplicationInfo applicationInfo;
        try {
            String packageName = context2.getPackageName();
            if (Build.VERSION.SDK_INT >= 33) {
                applicationInfo = context2.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128));
            } else {
                applicationInfo = getApplicationInfoWithMeta32(context2, packageName, Constants.ERR_WATERMARK_ARGB);
            }
            if (applicationInfo.metaData.getBoolean(str, z)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static void deleteDatabase(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public static boolean existsDatabase(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public void open() {
        if (walGloballyEnabled == null) {
            Boolean valueOf = Boolean.valueOf(checkWalEnabled(this.context));
            walGloballyEnabled = valueOf;
            if (valueOf.booleanValue() && LogLevel.hasVerboseLevel(this.logLevel)) {
                Log.d(Constant.TAG, getThreadLogPrefix() + "[sqflite] WAL enabled");
            }
        }
        this.sqliteDatabase = SQLiteDatabase.openDatabase(this.path, (SQLiteDatabase.CursorFactory) null, walGloballyEnabled.booleanValue() ? 805306368 : 268435456);
    }

    public void openReadOnly() {
        this.sqliteDatabase = SQLiteDatabase.openDatabase(this.path, (SQLiteDatabase.CursorFactory) null, 1, new DatabaseErrorHandler() {
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            }
        });
    }

    public void close() {
        if (!this.cursors.isEmpty() && LogLevel.hasSqlLevel(this.logLevel)) {
            Log.d(Constant.TAG, getThreadLogPrefix() + this.cursors.size() + " cursor(s) are left opened");
        }
        this.sqliteDatabase.close();
    }

    public SQLiteDatabase getWritableDatabase() {
        return this.sqliteDatabase;
    }

    public SQLiteDatabase getReadableDatabase() {
        return this.sqliteDatabase;
    }

    public boolean enableWriteAheadLogging() {
        try {
            return this.sqliteDatabase.enableWriteAheadLogging();
        } catch (Exception e) {
            Log.e(Constant.TAG, getThreadLogPrefix() + "enable WAL error: " + e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String getThreadLogTag() {
        Thread currentThread = Thread.currentThread();
        return "" + this.id + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    /* access modifiers changed from: package-private */
    public String getThreadLogPrefix() {
        return "[" + getThreadLogTag() + "] ";
    }

    private Map<String, Object> cursorToResults(Cursor cursor, Integer num) {
        HashMap hashMap = null;
        int i = 0;
        ArrayList arrayList = null;
        while (cursor.moveToNext()) {
            if (hashMap == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                i = cursor.getColumnCount();
                hashMap2.put(Constant.PARAM_COLUMNS, Arrays.asList(cursor.getColumnNames()));
                hashMap2.put(Constant.PARAM_ROWS, arrayList2);
                HashMap hashMap3 = hashMap2;
                arrayList = arrayList2;
                hashMap = hashMap3;
            }
            arrayList.add(Utils.cursorRowToList(cursor, i));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return hashMap == null ? new HashMap() : hashMap;
    }

    /* access modifiers changed from: private */
    public void runQueuedOperations() {
        while (!this.noTransactionOperationQueue.isEmpty() && this.currentTransactionId == null) {
            this.noTransactionOperationQueue.get(0).run();
            this.noTransactionOperationQueue.remove(0);
        }
    }

    private void wrapSqlOperationHandler(Operation operation, Runnable runnable) {
        Integer transactionId = operation.getTransactionId();
        Integer num = this.currentTransactionId;
        if (num == null) {
            runnable.run();
        } else if (transactionId == null || (!transactionId.equals(num) && transactionId.intValue() != -1)) {
            this.noTransactionOperationQueue.add(new QueuedOperation(operation, runnable));
        } else {
            runnable.run();
            if (this.currentTransactionId == null && !this.noTransactionOperationQueue.isEmpty()) {
                this.databaseWorkerPool.post(this, new Database$$ExternalSyntheticLambda1(this));
            }
        }
    }

    public void query(Operation operation) {
        wrapSqlOperationHandler(operation, new Database$$ExternalSyntheticLambda4(this, operation));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a3 A[Catch:{ all -> 0x00ae }] */
    /* renamed from: doQuery */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean lambda$query$0$Database(com.tekartik.sqflite.operation.Operation r10) {
        /*
            r9 = this;
            java.lang.String r0 = "cursorPageSize"
            java.lang.Object r0 = r10.getArgument(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            com.tekartik.sqflite.SqlCommand r1 = r10.getSqlCommand()
            int r2 = r9.logLevel
            boolean r2 = com.tekartik.sqflite.LogLevel.hasSqlLevel(r2)
            if (r2 == 0) goto L_0x002c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r9.getThreadLogPrefix()
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Sqflite"
            android.util.Log.d(r3, r2)
        L_0x002c:
            r2 = 0
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r9.getReadableDatabase()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            com.tekartik.sqflite.Database$$ExternalSyntheticLambda0 r5 = new com.tekartik.sqflite.Database$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r1 = r1.getSql()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String[] r6 = com.tekartik.sqflite.Constant.EMPTY_STRING_ARRAY     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            boolean r7 = r4 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r7 != 0) goto L_0x0046
            android.database.Cursor r1 = r4.rawQueryWithFactory(r5, r1, r6, r2)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            goto L_0x004c
        L_0x0046:
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            android.database.Cursor r1 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.rawQueryWithFactory(r4, r5, r1, r6, r2)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
        L_0x004c:
            java.util.Map r4 = r9.cursorToResults(r1, r0)     // Catch:{ Exception -> 0x0097 }
            r5 = 1
            if (r0 == 0) goto L_0x0061
            boolean r6 = r1.isLast()     // Catch:{ Exception -> 0x0097 }
            if (r6 != 0) goto L_0x0061
            boolean r6 = r1.isAfterLast()     // Catch:{ Exception -> 0x0097 }
            if (r6 != 0) goto L_0x0061
            r6 = r5
            goto L_0x0062
        L_0x0061:
            r6 = r3
        L_0x0062:
            if (r6 == 0) goto L_0x008c
            int r6 = r9.lastCursorId     // Catch:{ Exception -> 0x0097 }
            int r6 = r6 + r5
            r9.lastCursorId = r6     // Catch:{ Exception -> 0x0097 }
            java.lang.String r7 = "cursorId"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0097 }
            r4.put(r7, r8)     // Catch:{ Exception -> 0x0097 }
            com.tekartik.sqflite.SqfliteCursor r7 = new com.tekartik.sqflite.SqfliteCursor     // Catch:{ Exception -> 0x0097 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0097 }
            r7.<init>(r6, r0, r1)     // Catch:{ Exception -> 0x0097 }
            java.util.Map<java.lang.Integer, com.tekartik.sqflite.SqfliteCursor> r0 = r9.cursors     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r0.put(r2, r7)     // Catch:{ Exception -> 0x0089, all -> 0x0086 }
            r2 = r7
            goto L_0x008c
        L_0x0086:
            r10 = move-exception
            r2 = r7
            goto L_0x00af
        L_0x0089:
            r0 = move-exception
            r2 = r7
            goto L_0x009e
        L_0x008c:
            r10.success(r4)     // Catch:{ Exception -> 0x0097 }
            if (r2 != 0) goto L_0x0096
            if (r1 == 0) goto L_0x0096
            r1.close()
        L_0x0096:
            return r5
        L_0x0097:
            r0 = move-exception
            goto L_0x009e
        L_0x0099:
            r10 = move-exception
            r1 = r2
            goto L_0x00af
        L_0x009c:
            r0 = move-exception
            r1 = r2
        L_0x009e:
            r9.handleException(r0, r10)     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x00a6
            r9.closeCursor((com.tekartik.sqflite.SqfliteCursor) r2)     // Catch:{ all -> 0x00ae }
        L_0x00a6:
            if (r2 != 0) goto L_0x00ad
            if (r1 == 0) goto L_0x00ad
            r1.close()
        L_0x00ad:
            return r3
        L_0x00ae:
            r10 = move-exception
        L_0x00af:
            if (r2 != 0) goto L_0x00b6
            if (r1 == 0) goto L_0x00b6
            r1.close()
        L_0x00b6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.lambda$query$0$Database(com.tekartik.sqflite.operation.Operation):boolean");
    }

    public void queryCursorNext(Operation operation) {
        wrapSqlOperationHandler(operation, new Database$$ExternalSyntheticLambda5(this, operation));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b8 A[Catch:{ all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc  */
    /* renamed from: doQueryCursorNext */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean lambda$queryCursorNext$2$Database(com.tekartik.sqflite.operation.Operation r10) {
        /*
            r9 = this;
            java.lang.String r0 = "cursorId"
            java.lang.Object r1 = r10.getArgument(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = "cancel"
            java.lang.Object r3 = r10.getArgument(r3)
            boolean r2 = r2.equals(r3)
            int r3 = r9.logLevel
            boolean r3 = com.tekartik.sqflite.LogLevel.hasVerboseLevel(r3)
            if (r3 == 0) goto L_0x0047
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.getThreadLogPrefix()
            r3.append(r4)
            java.lang.String r4 = "cursor "
            r3.append(r4)
            r3.append(r1)
            if (r2 == 0) goto L_0x0039
            java.lang.String r4 = " cancel"
            goto L_0x003b
        L_0x0039:
            java.lang.String r4 = " next"
        L_0x003b:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "Sqflite"
            android.util.Log.d(r4, r3)
        L_0x0047:
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0052
            r9.closeCursor((int) r1)
            r10.success(r3)
            return r4
        L_0x0052:
            java.util.Map<java.lang.Integer, com.tekartik.sqflite.SqfliteCursor> r2 = r9.cursors
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            java.lang.Object r2 = r2.get(r5)
            com.tekartik.sqflite.SqfliteCursor r2 = (com.tekartik.sqflite.SqfliteCursor) r2
            r5 = 0
            if (r2 == 0) goto L_0x0097
            android.database.Cursor r6 = r2.cursor     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            int r7 = r2.pageSize     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.util.Map r7 = r9.cursorToResults(r6, r7)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            boolean r8 = r6.isLast()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            if (r8 != 0) goto L_0x007b
            boolean r6 = r6.isAfterLast()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            if (r6 != 0) goto L_0x007b
            r6 = r4
            goto L_0x007c
        L_0x007b:
            r6 = r5
        L_0x007c:
            if (r6 == 0) goto L_0x0085
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0090 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x0090 }
        L_0x0085:
            r10.success(r7)     // Catch:{ Exception -> 0x0090 }
            if (r6 != 0) goto L_0x008f
            if (r2 == 0) goto L_0x008f
            r9.closeCursor((com.tekartik.sqflite.SqfliteCursor) r2)
        L_0x008f:
            return r4
        L_0x0090:
            r0 = move-exception
            goto L_0x00b3
        L_0x0092:
            r10 = move-exception
            goto L_0x00c7
        L_0x0094:
            r0 = move-exception
            r6 = r5
            goto L_0x00b3
        L_0x0097:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r4.<init>()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r6 = "Cursor "
            r4.append(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r4.append(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r1 = " not found"
            r4.append(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
            throw r0     // Catch:{ Exception -> 0x0094, all -> 0x0092 }
        L_0x00b3:
            r9.handleException(r0, r10)     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x00bc
            r9.closeCursor((com.tekartik.sqflite.SqfliteCursor) r2)     // Catch:{ all -> 0x00c5 }
            goto L_0x00bd
        L_0x00bc:
            r3 = r2
        L_0x00bd:
            if (r6 != 0) goto L_0x00c4
            if (r3 == 0) goto L_0x00c4
            r9.closeCursor((com.tekartik.sqflite.SqfliteCursor) r3)
        L_0x00c4:
            return r5
        L_0x00c5:
            r10 = move-exception
            r5 = r6
        L_0x00c7:
            if (r5 != 0) goto L_0x00ce
            if (r2 == 0) goto L_0x00ce
            r9.closeCursor((com.tekartik.sqflite.SqfliteCursor) r2)
        L_0x00ce:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.lambda$queryCursorNext$2$Database(com.tekartik.sqflite.operation.Operation):boolean");
    }

    private void closeCursor(SqfliteCursor sqfliteCursor) {
        try {
            int i = sqfliteCursor.cursorId;
            if (LogLevel.hasVerboseLevel(this.logLevel)) {
                Log.d(Constant.TAG, getThreadLogPrefix() + "closing cursor " + i);
            }
            this.cursors.remove(Integer.valueOf(i));
            sqfliteCursor.cursor.close();
        } catch (Exception unused) {
        }
    }

    private void closeCursor(int i) {
        SqfliteCursor sqfliteCursor = this.cursors.get(Integer.valueOf(i));
        if (sqfliteCursor != null) {
            closeCursor(sqfliteCursor);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleException(Exception exc, Operation operation) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            operation.error("sqlite_error", "open_failed " + this.path, (Object) null);
        } else if (exc instanceof SQLException) {
            operation.error("sqlite_error", exc.getMessage(), SqlErrorInfo.getMap(operation));
        } else {
            operation.error("sqlite_error", exc.getMessage(), SqlErrorInfo.getMap(operation));
        }
    }

    private boolean executeOrError(Operation operation) {
        SqlCommand sqlCommand = operation.getSqlCommand();
        if (LogLevel.hasSqlLevel(this.logLevel)) {
            Log.d(Constant.TAG, getThreadLogPrefix() + sqlCommand);
        }
        Boolean inTransactionChange = operation.getInTransactionChange();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String sql = sqlCommand.getSql();
            Object[] sqlArguments = sqlCommand.getSqlArguments();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL(sql, sqlArguments);
            } else {
                SQLiteInstrumentation.execSQL(writableDatabase, sql, sqlArguments);
            }
            enterOrLeaveInTransaction(inTransactionChange);
            return true;
        } catch (Exception e) {
            handleException(e, operation);
            return false;
        }
    }

    public void execute(Operation operation) {
        wrapSqlOperationHandler(operation, new Database$$ExternalSyntheticLambda2(this, operation));
    }

    public /* synthetic */ void lambda$execute$3$Database(Operation operation) {
        Boolean inTransactionChange = operation.getInTransactionChange();
        boolean z = Boolean.TRUE.equals(inTransactionChange) && operation.hasNullTransactionId();
        if (z) {
            int i = this.lastTransactionId + 1;
            this.lastTransactionId = i;
            this.currentTransactionId = Integer.valueOf(i);
        }
        if (!executeOrError(operation)) {
            if (z) {
                this.currentTransactionId = null;
            }
        } else if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constant.PARAM_TRANSACTION_ID, this.currentTransactionId);
            operation.success(hashMap);
        } else {
            if (Boolean.FALSE.equals(inTransactionChange)) {
                this.currentTransactionId = null;
            }
            operation.success((Object) null);
        }
    }

    private boolean doExecute(Operation operation) {
        if (!executeOrError(operation)) {
            return false;
        }
        operation.success((Object) null);
        return true;
    }

    public void insert(Operation operation) {
        wrapSqlOperationHandler(operation, new Database$$ExternalSyntheticLambda3(this, operation));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00df  */
    /* renamed from: doInsert */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean lambda$insert$4$Database(com.tekartik.sqflite.operation.Operation r10) {
        /*
            r9 = this;
            boolean r0 = r9.executeOrError(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r10.getNoResult()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            r10.success(r2)
            return r3
        L_0x0014:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r9.getWritableDatabase()     // Catch:{ Exception -> 0x00d3 }
            boolean r5 = r4 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00d3 }
            if (r5 != 0) goto L_0x0023
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch:{ Exception -> 0x00d3 }
            goto L_0x0029
        L_0x0023:
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x00d3 }
            android.database.Cursor r0 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.rawQuery(r4, r0, r2)     // Catch:{ Exception -> 0x00d3 }
        L_0x0029:
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x00b0
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r5 <= 0) goto L_0x00b0
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r5 == 0) goto L_0x00b0
            int r5 = r0.getInt(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r5 != 0) goto L_0x0074
            int r5 = r9.logLevel     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            boolean r5 = com.tekartik.sqflite.LogLevel.hasSqlLevel(r5)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r5 == 0) goto L_0x006b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r5.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r6 = r9.getThreadLogPrefix()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r5.append(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r6 = "no changes (id was "
            r5.append(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            long r6 = r0.getLong(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r5.append(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
        L_0x006b:
            r10.success(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r0 == 0) goto L_0x0073
            r0.close()
        L_0x0073:
            return r3
        L_0x0074:
            long r5 = r0.getLong(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            int r2 = r9.logLevel     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            boolean r2 = com.tekartik.sqflite.LogLevel.hasSqlLevel(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r2 == 0) goto L_0x009b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r2.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r7 = r9.getThreadLogPrefix()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r2.append(r7)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r7 = "inserted "
            r2.append(r7)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r2.append(r5)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            android.util.Log.d(r4, r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
        L_0x009b:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r10.success(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r0 == 0) goto L_0x00a7
            r0.close()
        L_0x00a7:
            return r3
        L_0x00a8:
            r10 = move-exception
            r2 = r0
            goto L_0x00dd
        L_0x00ab:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L_0x00d4
        L_0x00b0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r5.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r6 = r9.getThreadLogPrefix()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r5.append(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r10.success(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            if (r0 == 0) goto L_0x00d0
            r0.close()
        L_0x00d0:
            return r3
        L_0x00d1:
            r10 = move-exception
            goto L_0x00dd
        L_0x00d3:
            r0 = move-exception
        L_0x00d4:
            r9.handleException(r0, r10)     // Catch:{ all -> 0x00d1 }
            if (r2 == 0) goto L_0x00dc
            r2.close()
        L_0x00dc:
            return r1
        L_0x00dd:
            if (r2 == 0) goto L_0x00e2
            r2.close()
        L_0x00e2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.lambda$insert$4$Database(com.tekartik.sqflite.operation.Operation):boolean");
    }

    public void update(Operation operation) {
        wrapSqlOperationHandler(operation, new Database$$ExternalSyntheticLambda6(this, operation));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* renamed from: doUpdate */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean lambda$update$5$Database(com.tekartik.sqflite.operation.Operation r8) {
        /*
            r7 = this;
            boolean r0 = r7.executeOrError(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r8.getNoResult()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r8.success(r3)
            return r2
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r7.getWritableDatabase()     // Catch:{ Exception -> 0x0097 }
            java.lang.String r4 = "SELECT changes()"
            boolean r5 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0097 }
            if (r5 != 0) goto L_0x0023
            android.database.Cursor r0 = r0.rawQuery(r4, r3)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0029
        L_0x0023:
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0     // Catch:{ Exception -> 0x0097 }
            android.database.Cursor r0 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.rawQuery(r0, r4, r3)     // Catch:{ Exception -> 0x0097 }
        L_0x0029:
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x0074
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            if (r5 <= 0) goto L_0x0074
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            if (r5 == 0) goto L_0x0074
            int r3 = r0.getInt(r1)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            int r5 = r7.logLevel     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            boolean r5 = com.tekartik.sqflite.LogLevel.hasSqlLevel(r5)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            if (r5 == 0) goto L_0x0060
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r5.<init>()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r6 = r7.getThreadLogPrefix()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r5.append(r6)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r6 = "changed "
            r5.append(r6)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r5.append(r3)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
        L_0x0060:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r8.success(r3)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            if (r0 == 0) goto L_0x006c
            r0.close()
        L_0x006c:
            return r2
        L_0x006d:
            r8 = move-exception
            r3 = r0
            goto L_0x00a1
        L_0x0070:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x0098
        L_0x0074:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r5.<init>()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r6 = r7.getThreadLogPrefix()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r5.append(r6)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r6 = "fail to read changes for Update/Delete"
            r5.append(r6)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            r8.success(r3)     // Catch:{ Exception -> 0x0070, all -> 0x006d }
            if (r0 == 0) goto L_0x0094
            r0.close()
        L_0x0094:
            return r2
        L_0x0095:
            r8 = move-exception
            goto L_0x00a1
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            r7.handleException(r0, r8)     // Catch:{ all -> 0x0095 }
            if (r3 == 0) goto L_0x00a0
            r3.close()
        L_0x00a0:
            return r1
        L_0x00a1:
            if (r3 == 0) goto L_0x00a6
            r3.close()
        L_0x00a6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.Database.lambda$update$5$Database(com.tekartik.sqflite.operation.Operation):boolean");
    }

    /* access modifiers changed from: package-private */
    public void batch(MethodCall methodCall, MethodChannel.Result result) {
        MethodCallOperation methodCallOperation = new MethodCallOperation(methodCall, result);
        boolean noResult = methodCallOperation.getNoResult();
        boolean continueOnError = methodCallOperation.getContinueOnError();
        ArrayList arrayList = new ArrayList();
        for (Map batchOperation : (List) methodCallOperation.getArgument("operations")) {
            BatchOperation batchOperation2 = new BatchOperation(batchOperation, noResult);
            String method = batchOperation2.getMethod();
            method.hashCode();
            char c = 65535;
            switch (method.hashCode()) {
                case -1319569547:
                    if (method.equals(Constant.METHOD_EXECUTE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1183792455:
                    if (method.equals(Constant.METHOD_INSERT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -838846263:
                    if (method.equals(Constant.METHOD_UPDATE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 107944136:
                    if (method.equals(Constant.METHOD_QUERY)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (doExecute(batchOperation2)) {
                        batchOperation2.handleSuccess(arrayList);
                        break;
                    } else if (continueOnError) {
                        batchOperation2.handleErrorContinue(arrayList);
                        break;
                    } else {
                        batchOperation2.handleError(result);
                        return;
                    }
                case 1:
                    if (lambda$insert$4$Database(batchOperation2)) {
                        batchOperation2.handleSuccess(arrayList);
                        break;
                    } else if (continueOnError) {
                        batchOperation2.handleErrorContinue(arrayList);
                        break;
                    } else {
                        batchOperation2.handleError(result);
                        return;
                    }
                case 2:
                    if (lambda$update$5$Database(batchOperation2)) {
                        batchOperation2.handleSuccess(arrayList);
                        break;
                    } else if (continueOnError) {
                        batchOperation2.handleErrorContinue(arrayList);
                        break;
                    } else {
                        batchOperation2.handleError(result);
                        return;
                    }
                case 3:
                    if (lambda$query$0$Database(batchOperation2)) {
                        batchOperation2.handleSuccess(arrayList);
                        break;
                    } else if (continueOnError) {
                        batchOperation2.handleErrorContinue(arrayList);
                        break;
                    } else {
                        batchOperation2.handleError(result);
                        return;
                    }
                default:
                    result.error("bad_param", "Batch method '" + method + "' not supported", (Object) null);
                    return;
            }
        }
        if (noResult) {
            result.success((Object) null);
        } else {
            result.success(arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isInTransaction() {
        return this.transactionDepth > 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized void enterOrLeaveInTransaction(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            this.transactionDepth++;
        } else if (Boolean.FALSE.equals(bool)) {
            this.transactionDepth--;
        }
    }
}
