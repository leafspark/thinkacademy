package com.xueersi.lib.graffiti.db;

import android.database.sqlite.SQLiteDatabase;
import com.bonree.sdk.agent.engine.external.SQLiteInstrumentation;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ActionDataDao {
    private static final String TAG = "ActionDataDao";
    private final SQLiteDatabase database;
    private HashSet<String> tableCreated = new HashSet<>();
    private HashMap<String, String> tableNameCached = new HashMap<>();

    public ActionDataDao(SQLiteDatabase sQLiteDatabase) {
        this.database = sQLiteDatabase;
    }

    private String getTableName(String str) {
        String str2 = this.tableNameCached.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = DatabaseHelper.TABLE_NAME_PREFIX + str;
        this.tableNameCached.put(str, str3);
        return str3;
    }

    private String getTableNameCreated(String str) {
        String tableName = getTableName(str);
        if (!this.tableCreated.contains(tableName)) {
            if (XesLog.isEnabled()) {
                XesLog.d("创建表名:" + tableName);
            }
            SQLiteDatabase sQLiteDatabase = this.database;
            String str2 = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (`uniqueKey` TEXT NOT NULL UNIQUE, `msgId` INTEGER NOT NULL, `pageId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `originData` BLOB NOT NULL,`uid` TEXT)";
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(str2);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
            }
            this.tableCreated.add(tableName);
        }
        return tableName;
    }

    public List<ActionDataEntity> queryAll(String str) {
        String tableName = getTableName(str);
        return queryBySql(("SELECT * FROM " + tableName + " ORDER BY timestamp ASC").intern(), (String[]) null);
    }

    public List<ActionDataEntity> queryByUid(String str, String str2) {
        String tableName = getTableName(str);
        return queryBySql(("SELECT * FROM " + tableName + " WHERE uid = ? ORDER BY timestamp ASC").intern(), new String[]{str2});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008d, code lost:
        if (r2 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cb, code lost:
        if (r2 != null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        r12 = android.os.SystemClock.uptimeMillis() - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d9, code lost:
        if (com.xueersi.lib.graffiti.utils.XesLog.isEnabled() == false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00db, code lost:
        com.xueersi.lib.graffiti.utils.XesLog.d("查询结束uid,条数:" + r3.size() + "耗时:" + r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fb, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.xueersi.lib.graffiti.db.ActionDataEntity> queryBySql(java.lang.String r12, java.lang.String[] r13) {
        /*
            r11 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            boolean r2 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()
            if (r2 == 0) goto L_0x001e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "查询开始 "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            com.xueersi.lib.graffiti.utils.XesLog.d(r2)
        L_0x001e:
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.database.sqlite.SQLiteDatabase r4 = r11.database     // Catch:{ Exception -> 0x0092 }
            boolean r5 = r4 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0092 }
            if (r5 != 0) goto L_0x002f
            android.database.Cursor r12 = r4.rawQuery(r12, r13)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0035
        L_0x002f:
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x0092 }
            android.database.Cursor r12 = com.bonree.sdk.agent.engine.external.SQLiteInstrumentation.rawQuery(r4, r12, r13)     // Catch:{ Exception -> 0x0092 }
        L_0x0035:
            r2 = r12
            java.lang.String r12 = "uniqueKey"
            int r12 = r2.getColumnIndex(r12)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r13 = "msgId"
            int r13 = r2.getColumnIndex(r13)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r4 = "pageId"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "timestamp"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r6 = "originData"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r7 = "uid"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ Exception -> 0x0092 }
        L_0x005a:
            boolean r8 = r2.moveToNext()     // Catch:{ Exception -> 0x0092 }
            if (r8 == 0) goto L_0x008d
            com.xueersi.lib.graffiti.db.ActionDataEntity r8 = new com.xueersi.lib.graffiti.db.ActionDataEntity     // Catch:{ Exception -> 0x0092 }
            r8.<init>()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r9 = r2.getString(r12)     // Catch:{ Exception -> 0x0092 }
            r8.uniqueKey = r9     // Catch:{ Exception -> 0x0092 }
            long r9 = r2.getLong(r13)     // Catch:{ Exception -> 0x0092 }
            r8.msgId = r9     // Catch:{ Exception -> 0x0092 }
            java.lang.String r9 = r2.getString(r4)     // Catch:{ Exception -> 0x0092 }
            r8.pageId = r9     // Catch:{ Exception -> 0x0092 }
            long r9 = r2.getLong(r5)     // Catch:{ Exception -> 0x0092 }
            r8.timestamp = r9     // Catch:{ Exception -> 0x0092 }
            byte[] r9 = r2.getBlob(r6)     // Catch:{ Exception -> 0x0092 }
            r8.originData = r9     // Catch:{ Exception -> 0x0092 }
            java.lang.String r9 = r2.getString(r7)     // Catch:{ Exception -> 0x0092 }
            r8.uid = r9     // Catch:{ Exception -> 0x0092 }
            r3.add(r8)     // Catch:{ Exception -> 0x0092 }
            goto L_0x005a
        L_0x008d:
            if (r2 == 0) goto L_0x00d0
            goto L_0x00cd
        L_0x0090:
            r12 = move-exception
            goto L_0x00fc
        L_0x0092:
            r12 = move-exception
            java.lang.String r13 = r12.getMessage()     // Catch:{ all -> 0x0090 }
            if (r13 == 0) goto L_0x00ad
            java.lang.String r4 = "no such table"
            boolean r13 = r13.startsWith(r4)     // Catch:{ all -> 0x0090 }
            if (r13 == 0) goto L_0x00ad
            boolean r12 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()     // Catch:{ all -> 0x0090 }
            if (r12 == 0) goto L_0x00cb
            java.lang.String r12 = "查询没有找到表，懒创建"
            com.xueersi.lib.graffiti.utils.XesLog.d(r12)     // Catch:{ all -> 0x0090 }
            goto L_0x00cb
        L_0x00ad:
            boolean r13 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()     // Catch:{ all -> 0x0090 }
            if (r13 == 0) goto L_0x00cb
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r13.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = "查询异常"
            r13.append(r4)     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x0090 }
            r13.append(r12)     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x0090 }
            com.xueersi.lib.graffiti.utils.XesLog.d(r12)     // Catch:{ all -> 0x0090 }
        L_0x00cb:
            if (r2 == 0) goto L_0x00d0
        L_0x00cd:
            r2.close()
        L_0x00d0:
            long r12 = android.os.SystemClock.uptimeMillis()
            long r12 = r12 - r0
            boolean r0 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()
            if (r0 == 0) goto L_0x00fb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "查询结束uid,条数:"
            r0.append(r1)
            int r1 = r3.size()
            r0.append(r1)
            java.lang.String r1 = "耗时:"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.xueersi.lib.graffiti.utils.XesLog.d(r12)
        L_0x00fb:
            return r3
        L_0x00fc:
            if (r2 == 0) goto L_0x0101
            r2.close()
        L_0x0101:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.db.ActionDataDao.queryBySql(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (r2 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b5, code lost:
        if (r2 == null) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b7, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ba, code lost:
        r2 = android.os.SystemClock.uptimeMillis() - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c3, code lost:
        if (com.xueersi.lib.graffiti.utils.XesLog.isEnabled() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c5, code lost:
        com.xueersi.lib.graffiti.utils.XesLog.d("插入结束:条数" + r10.length + " 耗时:" + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insert(com.xueersi.lib.graffiti.db.ActionDataEntity... r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x00ee
            int r0 = r10.length
            if (r0 != 0) goto L_0x0007
            goto L_0x00ee
        L_0x0007:
            long r0 = android.os.SystemClock.uptimeMillis()
            boolean r2 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()
            if (r2 == 0) goto L_0x0016
            java.lang.String r2 = "插入开始"
            com.xueersi.lib.graffiti.utils.XesLog.d(r2)
        L_0x0016:
            r2 = 0
            r3 = 0
            r4 = r10[r3]     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = r4.pageId     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = r9.getTableNameCreated(r4)     // Catch:{ Exception -> 0x0091 }
            android.database.sqlite.SQLiteDatabase r5 = r9.database     // Catch:{ Exception -> 0x0091 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091 }
            r6.<init>()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = "INSERT OR REPLACE INTO "
            r6.append(r7)     // Catch:{ Exception -> 0x0091 }
            r6.append(r4)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = "(`uniqueKey`,`msgId`,`pageId`,`timestamp`,`originData`,`uid`) VALUES (?,?,?,?,?,?)"
            r6.append(r4)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = r4.intern()     // Catch:{ Exception -> 0x0091 }
            android.database.sqlite.SQLiteStatement r2 = r5.compileStatement(r4)     // Catch:{ Exception -> 0x0091 }
            android.database.sqlite.SQLiteDatabase r4 = r9.database     // Catch:{ Exception -> 0x0091 }
            r4.beginTransaction()     // Catch:{ Exception -> 0x0091 }
            int r4 = r10.length     // Catch:{ Exception -> 0x0091 }
        L_0x0046:
            if (r3 >= r4) goto L_0x0082
            r5 = r10[r3]     // Catch:{ Exception -> 0x0091 }
            if (r5 != 0) goto L_0x004d
            goto L_0x007f
        L_0x004d:
            r2.clearBindings()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r6 = r5.uniqueKey     // Catch:{ Exception -> 0x0091 }
            r7 = 1
            r2.bindString(r7, r6)     // Catch:{ Exception -> 0x0091 }
            r6 = 2
            long r7 = r5.msgId     // Catch:{ Exception -> 0x0091 }
            r2.bindLong(r6, r7)     // Catch:{ Exception -> 0x0091 }
            r6 = 3
            java.lang.String r7 = r5.pageId     // Catch:{ Exception -> 0x0091 }
            r2.bindString(r6, r7)     // Catch:{ Exception -> 0x0091 }
            r6 = 4
            long r7 = r5.timestamp     // Catch:{ Exception -> 0x0091 }
            r2.bindLong(r6, r7)     // Catch:{ Exception -> 0x0091 }
            r6 = 5
            byte[] r7 = r5.originData     // Catch:{ Exception -> 0x0091 }
            r2.bindBlob(r6, r7)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r6 = r5.uid     // Catch:{ Exception -> 0x0091 }
            r7 = 6
            if (r6 != 0) goto L_0x0077
            r2.bindNull(r7)     // Catch:{ Exception -> 0x0091 }
            goto L_0x007c
        L_0x0077:
            java.lang.String r5 = r5.uid     // Catch:{ Exception -> 0x0091 }
            r2.bindString(r7, r5)     // Catch:{ Exception -> 0x0091 }
        L_0x007c:
            r2.executeInsert()     // Catch:{ Exception -> 0x0091 }
        L_0x007f:
            int r3 = r3 + 1
            goto L_0x0046
        L_0x0082:
            android.database.sqlite.SQLiteDatabase r3 = r9.database     // Catch:{ Exception -> 0x0091 }
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0091 }
            android.database.sqlite.SQLiteDatabase r3 = r9.database
            r3.endTransaction()
            if (r2 == 0) goto L_0x00ba
            goto L_0x00b7
        L_0x008f:
            r10 = move-exception
            goto L_0x00e3
        L_0x0091:
            r3 = move-exception
            boolean r4 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()     // Catch:{ all -> 0x008f }
            if (r4 == 0) goto L_0x00b0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r4.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r5 = "插入异常"
            r4.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x008f }
            r4.append(r3)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x008f }
            com.xueersi.lib.graffiti.utils.XesLog.d(r3)     // Catch:{ all -> 0x008f }
        L_0x00b0:
            android.database.sqlite.SQLiteDatabase r3 = r9.database
            r3.endTransaction()
            if (r2 == 0) goto L_0x00ba
        L_0x00b7:
            r2.close()
        L_0x00ba:
            long r2 = android.os.SystemClock.uptimeMillis()
            long r2 = r2 - r0
            boolean r0 = com.xueersi.lib.graffiti.utils.XesLog.isEnabled()
            if (r0 == 0) goto L_0x00e2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "插入结束:条数"
            r0.append(r1)
            int r10 = r10.length
            r0.append(r10)
            java.lang.String r10 = " 耗时:"
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
            com.xueersi.lib.graffiti.utils.XesLog.d(r10)
        L_0x00e2:
            return
        L_0x00e3:
            android.database.sqlite.SQLiteDatabase r0 = r9.database
            r0.endTransaction()
            if (r2 == 0) goto L_0x00ed
            r2.close()
        L_0x00ed:
            throw r10
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.db.ActionDataDao.insert(com.xueersi.lib.graffiti.db.ActionDataEntity[]):void");
    }
}
