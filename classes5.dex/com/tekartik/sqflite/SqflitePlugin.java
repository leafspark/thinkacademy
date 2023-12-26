package com.tekartik.sqflite;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tekartik.sqflite.DatabaseWorkerPool;
import com.tekartik.sqflite.dev.Debug;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SqflitePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static int THREAD_COUNT = 1;
    private static int THREAD_PRIORITY = 0;
    static final Map<String, Integer> _singleInstancesByPath = new HashMap();
    /* access modifiers changed from: private */
    public static int databaseId = 0;
    static final Map<Integer, Database> databaseMap = new HashMap();
    private static final Object databaseMapLocker = new Object();
    private static DatabaseWorkerPool databaseWorkerPool;
    static String databasesPath;
    static int logLevel = 0;
    /* access modifiers changed from: private */
    public static final Object openCloseLocker = new Object();
    private Context context;
    private MethodChannel methodChannel;

    public SqflitePlugin() {
    }

    public SqflitePlugin(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SqflitePlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    private static Map<String, Object> fixMap(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = fixMap((Map) value);
            } else {
                obj = toString(value);
            }
            hashMap.put(toString(next.getKey()), obj);
        }
        return hashMap;
    }

    private static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return fixMap((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    static boolean isInMemoryPath(String str) {
        return str == null || str.equals(":memory:");
    }

    static Map makeOpenResult(int i, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i));
        if (z) {
            hashMap.put(Constant.PARAM_RECOVERED, true);
        }
        if (z2) {
            hashMap.put(Constant.PARAM_RECOVERED_IN_TRANSACTION, true);
        }
        return hashMap;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    private void onAttachedToEngine(Context context2, BinaryMessenger binaryMessenger) {
        this.context = context2;
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "com.tekartik.sqflite", StandardMethodCodec.INSTANCE, binaryMessenger.makeBackgroundTaskQueue());
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.context = null;
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
    }

    private Context getContext() {
        return this.context;
    }

    private Database getDatabase(int i) {
        return databaseMap.get(Integer.valueOf(i));
    }

    private Database getDatabaseOrError(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        Database database = getDatabase(intValue);
        if (database != null) {
            return database;
        }
        result.error("sqlite_error", "database_closed " + intValue, (Object) null);
        return null;
    }

    private void onQueryCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda4(methodCall, result, databaseOrError));
        }
    }

    private void onQueryCursorNextCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda5(methodCall, result, databaseOrError));
        }
    }

    private void onBatchCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda0(databaseOrError, methodCall, result));
        }
    }

    private void onInsertCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda3(methodCall, result, databaseOrError));
        }
    }

    private void onExecuteCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda2(methodCall, result, databaseOrError));
        }
    }

    private void onSetLocaleCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda1(methodCall, databaseOrError, result));
        }
    }

    static /* synthetic */ void lambda$onSetLocaleCall$5(MethodCall methodCall, Database database, MethodChannel.Result result) {
        try {
            database.sqliteDatabase.setLocale(Utils.localeForLanguateTag((String) methodCall.argument("locale")));
            result.success((Object) null);
        } catch (Exception e) {
            result.error("sqlite_error", "Error calling setLocale: " + e.getMessage(), (Object) null);
        }
    }

    private void onUpdateCall(MethodCall methodCall, MethodChannel.Result result) {
        Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            databaseWorkerPool.post(databaseOrError, new SqflitePlugin$$ExternalSyntheticLambda6(methodCall, result, databaseOrError));
        }
    }

    private void onDebugCall(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        if ("get".equals((String) methodCall.argument("cmd"))) {
            int i = logLevel;
            if (i > 0) {
                hashMap.put("logLevel", Integer.valueOf(i));
            }
            Map<Integer, Database> map = databaseMap;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    Database database = (Database) next.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", database.path);
                    hashMap3.put("singleInstance", Boolean.valueOf(database.singleInstance));
                    if (database.logLevel > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(database.logLevel));
                    }
                    hashMap2.put(((Integer) next.getKey()).toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        result.success(hashMap);
    }

    private void onDebugModeCall(MethodCall methodCall, MethodChannel.Result result) {
        Debug.LOGV = Boolean.TRUE.equals(methodCall.arguments());
        Debug.EXTRA_LOGV = Debug._EXTRA_LOGV && Debug.LOGV;
        if (!Debug.LOGV) {
            logLevel = 0;
        } else if (Debug.EXTRA_LOGV) {
            logLevel = 2;
        } else if (Debug.LOGV) {
            logLevel = 1;
        }
        result.success((Object) null);
    }

    private void onOpenDatabaseCall(MethodCall methodCall, MethodChannel.Result result) {
        int i;
        Database database;
        MethodCall methodCall2 = methodCall;
        String str = (String) methodCall2.argument("path");
        Boolean bool = (Boolean) methodCall2.argument("readOnly");
        boolean isInMemoryPath = isInMemoryPath(str);
        boolean z = !Boolean.FALSE.equals(methodCall2.argument("singleInstance")) && !isInMemoryPath;
        if (z) {
            synchronized (databaseMapLocker) {
                if (LogLevel.hasVerboseLevel(logLevel)) {
                    Log.d(Constant.TAG, "Look for " + str + " in " + _singleInstancesByPath.keySet());
                }
                Integer num = _singleInstancesByPath.get(str);
                if (!(num == null || (database = databaseMap.get(num)) == null)) {
                    if (database.sqliteDatabase.isOpen()) {
                        if (LogLevel.hasVerboseLevel(logLevel)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(database.getThreadLogPrefix());
                            sb.append("re-opened single instance ");
                            sb.append(database.isInTransaction() ? "(in transaction) " : "");
                            sb.append(num);
                            sb.append(" ");
                            sb.append(str);
                            Log.d(Constant.TAG, sb.toString());
                        }
                        result.success(makeOpenResult(num.intValue(), true, database.isInTransaction()));
                        return;
                    } else if (LogLevel.hasVerboseLevel(logLevel)) {
                        Log.d(Constant.TAG, database.getThreadLogPrefix() + "single instance database of " + str + " not opened");
                    }
                }
                MethodChannel.Result result2 = result;
            }
        } else {
            MethodChannel.Result result3 = result;
        }
        Object obj = databaseMapLocker;
        synchronized (obj) {
            i = databaseId + 1;
            databaseId = i;
        }
        Database database2 = new Database(this.context, str, i, z, logLevel);
        synchronized (obj) {
            if (databaseWorkerPool == null) {
                DatabaseWorkerPool create = DatabaseWorkerPool.CC.create(Constant.TAG, THREAD_COUNT, THREAD_PRIORITY);
                databaseWorkerPool = create;
                create.start();
                if (LogLevel.hasSqlLevel(database2.logLevel)) {
                    Log.d(Constant.TAG, database2.getThreadLogPrefix() + "starting worker pool with priority " + THREAD_PRIORITY);
                }
            }
            database2.databaseWorkerPool = databaseWorkerPool;
            if (LogLevel.hasSqlLevel(database2.logLevel)) {
                Log.d(Constant.TAG, database2.getThreadLogPrefix() + "opened " + i + " " + str);
            }
            SqflitePlugin$$ExternalSyntheticLambda7 sqflitePlugin$$ExternalSyntheticLambda7 = r1;
            DatabaseWorkerPool databaseWorkerPool2 = databaseWorkerPool;
            SqflitePlugin$$ExternalSyntheticLambda7 sqflitePlugin$$ExternalSyntheticLambda72 = new SqflitePlugin$$ExternalSyntheticLambda7(isInMemoryPath, str, result, bool, database2, methodCall, z, i);
            databaseWorkerPool2.post(database2, sqflitePlugin$$ExternalSyntheticLambda7);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r4.success(makeOpenResult(r9, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a2, code lost:
        r6.handleException(r2, new com.tekartik.sqflite.operation.MethodCallOperation(r7, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void lambda$onOpenDatabaseCall$7(boolean r2, java.lang.String r3, io.flutter.plugin.common.MethodChannel.Result r4, java.lang.Boolean r5, com.tekartik.sqflite.Database r6, io.flutter.plugin.common.MethodCall r7, boolean r8, int r9) {
        /*
            java.lang.Object r0 = openCloseLocker
            monitor-enter(r0)
            if (r2 != 0) goto L_0x003e
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x009f }
            r2.<init>(r3)     // Catch:{ all -> 0x009f }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x009f }
            java.lang.String r2 = r2.getParent()     // Catch:{ all -> 0x009f }
            r1.<init>(r2)     // Catch:{ all -> 0x009f }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x009f }
            if (r2 != 0) goto L_0x003e
            boolean r2 = r1.mkdirs()     // Catch:{ all -> 0x009f }
            if (r2 != 0) goto L_0x003e
            boolean r2 = r1.exists()     // Catch:{ all -> 0x009f }
            if (r2 != 0) goto L_0x003e
            java.lang.String r2 = "sqlite_error"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r5.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "open_failed "
            r5.append(r6)     // Catch:{ all -> 0x009f }
            r5.append(r3)     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x009f }
            r5 = 0
            r4.error(r2, r3, r5)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            return
        L_0x003e:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00a1 }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x00a1 }
            if (r2 == 0) goto L_0x004a
            r6.openReadOnly()     // Catch:{ Exception -> 0x00a1 }
            goto L_0x004d
        L_0x004a:
            r6.open()     // Catch:{ Exception -> 0x00a1 }
        L_0x004d:
            java.lang.Object r2 = databaseMapLocker     // Catch:{ all -> 0x009f }
            monitor-enter(r2)     // Catch:{ all -> 0x009f }
            if (r8 == 0) goto L_0x005b
            java.util.Map<java.lang.String, java.lang.Integer> r5 = _singleInstancesByPath     // Catch:{ all -> 0x009c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x009c }
            r5.put(r3, r7)     // Catch:{ all -> 0x009c }
        L_0x005b:
            java.util.Map<java.lang.Integer, com.tekartik.sqflite.Database> r5 = databaseMap     // Catch:{ all -> 0x009c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x009c }
            r5.put(r7, r6)     // Catch:{ all -> 0x009c }
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            int r2 = r6.logLevel     // Catch:{ all -> 0x009f }
            boolean r2 = com.tekartik.sqflite.LogLevel.hasSqlLevel(r2)     // Catch:{ all -> 0x009f }
            if (r2 == 0) goto L_0x0092
            java.lang.String r2 = "Sqflite"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r5.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r6 = r6.getThreadLogPrefix()     // Catch:{ all -> 0x009f }
            r5.append(r6)     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "opened "
            r5.append(r6)     // Catch:{ all -> 0x009f }
            r5.append(r9)     // Catch:{ all -> 0x009f }
            java.lang.String r6 = " "
            r5.append(r6)     // Catch:{ all -> 0x009f }
            r5.append(r3)     // Catch:{ all -> 0x009f }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x009f }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x009f }
        L_0x0092:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            r2 = 0
            java.util.Map r2 = makeOpenResult(r9, r2, r2)
            r4.success(r2)
            return
        L_0x009c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009c }
            throw r3     // Catch:{ all -> 0x009f }
        L_0x009f:
            r2 = move-exception
            goto L_0x00ac
        L_0x00a1:
            r2 = move-exception
            com.tekartik.sqflite.operation.MethodCallOperation r3 = new com.tekartik.sqflite.operation.MethodCallOperation     // Catch:{ all -> 0x009f }
            r3.<init>(r7, r4)     // Catch:{ all -> 0x009f }
            r6.handleException(r2, r3)     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            return
        L_0x00ac:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.lambda$onOpenDatabaseCall$7(boolean, java.lang.String, io.flutter.plugin.common.MethodChannel$Result, java.lang.Boolean, com.tekartik.sqflite.Database, io.flutter.plugin.common.MethodCall, boolean, int):void");
    }

    private void onCloseDatabaseCall(MethodCall methodCall, final MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        final Database databaseOrError = getDatabaseOrError(methodCall, result);
        if (databaseOrError != null) {
            if (LogLevel.hasSqlLevel(databaseOrError.logLevel)) {
                Log.d(Constant.TAG, databaseOrError.getThreadLogPrefix() + "closing " + intValue + " " + databaseOrError.path);
            }
            String str = databaseOrError.path;
            synchronized (databaseMapLocker) {
                databaseMap.remove(Integer.valueOf(intValue));
                if (databaseOrError.singleInstance) {
                    _singleInstancesByPath.remove(str);
                }
            }
            databaseWorkerPool.post(databaseOrError, new Runnable() {
                public void run() {
                    synchronized (SqflitePlugin.openCloseLocker) {
                        SqflitePlugin.this.closeDatabase(databaseOrError);
                    }
                    result.success((Object) null);
                }
            });
        }
    }

    private void onDeleteDatabaseCall(MethodCall methodCall, final MethodChannel.Result result) {
        final Database database;
        Map<Integer, Database> map;
        final String str = (String) methodCall.argument("path");
        synchronized (databaseMapLocker) {
            if (LogLevel.hasVerboseLevel(logLevel)) {
                Log.d(Constant.TAG, "Look for " + str + " in " + _singleInstancesByPath.keySet());
            }
            Map<String, Integer> map2 = _singleInstancesByPath;
            Integer num = map2.get(str);
            if (num == null || (database = map.get(num)) == null || !database.sqliteDatabase.isOpen()) {
                database = null;
            } else {
                if (LogLevel.hasVerboseLevel(logLevel)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(database.getThreadLogPrefix());
                    sb.append("found single instance ");
                    sb.append(database.isInTransaction() ? "(in transaction) " : "");
                    sb.append(num);
                    sb.append(" ");
                    sb.append(str);
                    Log.d(Constant.TAG, sb.toString());
                }
                (map = databaseMap).remove(num);
                map2.remove(str);
            }
        }
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                synchronized (SqflitePlugin.openCloseLocker) {
                    Database database = database;
                    if (database != null) {
                        SqflitePlugin.this.closeDatabase(database);
                    }
                    try {
                        if (LogLevel.hasVerboseLevel(SqflitePlugin.logLevel)) {
                            Log.d(Constant.TAG, "delete database " + str);
                        }
                        Database.deleteDatabase(str);
                    } catch (Exception e) {
                        Log.e(Constant.TAG, "error " + e + " while closing database " + SqflitePlugin.databaseId);
                    }
                }
                result.success((Object) null);
            }
        };
        DatabaseWorkerPool databaseWorkerPool2 = databaseWorkerPool;
        if (databaseWorkerPool2 != null) {
            databaseWorkerPool2.post(database, r0);
        } else {
            r0.run();
        }
    }

    private void onDatabaseExistsCall(MethodCall methodCall, MethodChannel.Result result) {
        result.success(Boolean.valueOf(Database.existsDatabase((String) methodCall.argument("path"))));
    }

    /* access modifiers changed from: private */
    public void closeDatabase(Database database) {
        try {
            if (LogLevel.hasSqlLevel(database.logLevel)) {
                Log.d(Constant.TAG, database.getThreadLogPrefix() + "closing database ");
            }
            database.close();
        } catch (Exception e) {
            Log.e(Constant.TAG, "error " + e + " while closing database " + databaseId);
        }
        synchronized (databaseMapLocker) {
            if (databaseMap.isEmpty() && databaseWorkerPool != null) {
                if (LogLevel.hasSqlLevel(database.logLevel)) {
                    Log.d(Constant.TAG, database.getThreadLogPrefix() + "stopping thread");
                }
                databaseWorkerPool.quit();
                databaseWorkerPool = null;
            }
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1319569547:
                if (str.equals(Constant.METHOD_EXECUTE)) {
                    c = 0;
                    break;
                }
                break;
            case -1253581933:
                if (str.equals(Constant.METHOD_CLOSE_DATABASE)) {
                    c = 1;
                    break;
                }
                break;
            case -1249474914:
                if (str.equals(Constant.METHOD_OPTIONS)) {
                    c = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals(Constant.METHOD_INSERT)) {
                    c = 3;
                    break;
                }
                break;
            case -838846263:
                if (str.equals(Constant.METHOD_UPDATE)) {
                    c = 4;
                    break;
                }
                break;
            case -396289107:
                if (str.equals(Constant.METHOD_ANDROID_SET_LOCALE)) {
                    c = 5;
                    break;
                }
                break;
            case -263511994:
                if (str.equals(Constant.METHOD_DELETE_DATABASE)) {
                    c = 6;
                    break;
                }
                break;
            case -198450538:
                if (str.equals(Constant.METHOD_DEBUG_MODE)) {
                    c = 7;
                    break;
                }
                break;
            case -17190427:
                if (str.equals(Constant.METHOD_OPEN_DATABASE)) {
                    c = 8;
                    break;
                }
                break;
            case 93509434:
                if (str.equals(Constant.METHOD_BATCH)) {
                    c = 9;
                    break;
                }
                break;
            case 95458899:
                if (str.equals(Constant.METHOD_DEBUG)) {
                    c = 10;
                    break;
                }
                break;
            case 107944136:
                if (str.equals(Constant.METHOD_QUERY)) {
                    c = 11;
                    break;
                }
                break;
            case 956410295:
                if (str.equals(Constant.METHOD_DATABASE_EXISTS)) {
                    c = 12;
                    break;
                }
                break;
            case 1193546321:
                if (str.equals(Constant.METHOD_QUERY_CURSOR_NEXT)) {
                    c = 13;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals(Constant.METHOD_GET_PLATFORM_VERSION)) {
                    c = 14;
                    break;
                }
                break;
            case 1863829223:
                if (str.equals(Constant.METHOD_GET_DATABASES_PATH)) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                onExecuteCall(methodCall, result);
                return;
            case 1:
                onCloseDatabaseCall(methodCall, result);
                return;
            case 2:
                onOptionsCall(methodCall, result);
                return;
            case 3:
                onInsertCall(methodCall, result);
                return;
            case 4:
                onUpdateCall(methodCall, result);
                return;
            case 5:
                onSetLocaleCall(methodCall, result);
                return;
            case 6:
                onDeleteDatabaseCall(methodCall, result);
                return;
            case 7:
                onDebugModeCall(methodCall, result);
                return;
            case 8:
                onOpenDatabaseCall(methodCall, result);
                return;
            case 9:
                onBatchCall(methodCall, result);
                return;
            case 10:
                onDebugCall(methodCall, result);
                return;
            case 11:
                onQueryCall(methodCall, result);
                return;
            case 12:
                onDatabaseExistsCall(methodCall, result);
                return;
            case 13:
                onQueryCursorNextCall(methodCall, result);
                return;
            case 14:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 15:
                onGetDatabasesPathCall(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void onOptionsCall(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("androidThreadPriority");
        if (argument != null) {
            THREAD_PRIORITY = ((Integer) argument).intValue();
        }
        Object argument2 = methodCall.argument("androidThreadCount");
        if (argument2 != null && !argument2.equals(Integer.valueOf(THREAD_COUNT))) {
            THREAD_COUNT = ((Integer) argument2).intValue();
            DatabaseWorkerPool databaseWorkerPool2 = databaseWorkerPool;
            if (databaseWorkerPool2 != null) {
                databaseWorkerPool2.quit();
                databaseWorkerPool = null;
            }
        }
        Integer logLevel2 = LogLevel.getLogLevel(methodCall);
        if (logLevel2 != null) {
            logLevel = logLevel2.intValue();
        }
        result.success((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void onGetDatabasesPathCall(MethodCall methodCall, MethodChannel.Result result) {
        if (databasesPath == null) {
            databasesPath = this.context.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(databasesPath);
    }
}
