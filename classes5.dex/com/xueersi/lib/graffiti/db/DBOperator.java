package com.xueersi.lib.graffiti.db;

import android.content.Context;
import android.text.TextUtils;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.WorkExecutor;
import java.util.ArrayList;
import java.util.List;

public class DBOperator {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public volatile ActionDatabase database;
    private String dbName;
    /* access modifiers changed from: private */
    public WXTGraffitiEngine engine;
    private WorkExecutor mDBWorkExecutor;
    private List<ActionDataEntity> mInsertTempList = new ArrayList();

    public interface QueryCallback {
        void onResult(String str, List<WXWBAction> list);
    }

    public DBOperator(WXTGraffitiEngine wXTGraffitiEngine, Context context2) {
        this.engine = wXTGraffitiEngine;
        this.context = context2;
        this.mDBWorkExecutor = new WorkExecutor("WXTGraffitiDBThread");
    }

    public void setDBSpecifKey(String str) {
        this.dbName = DBFileManager.getDBFilePath(this.context, str);
    }

    private ActionDatabase getDatabase() {
        if (TextUtils.isEmpty(this.dbName)) {
            return null;
        }
        if (this.database == null) {
            synchronized (this) {
                if (this.database == null) {
                    this.database = new ActionDatabase(this.context, this.dbName);
                }
            }
        }
        return this.database;
    }

    public void insertToDb(final WXWBAction wXWBAction) {
        this.mDBWorkExecutor.execute(new Runnable() {
            public void run() {
                DBOperator.this.onInsert(wXWBAction);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onInsert(WXWBAction wXWBAction) {
        ActionDatabase database2;
        ActionDataEntity entryCovert;
        if (wXWBAction != null && !(wXWBAction instanceof DBAction) && (database2 = getDatabase()) != null && (entryCovert = entryCovert(wXWBAction)) != null) {
            database2.actionDataDao().insert(entryCovert);
        }
    }

    public void insertToDb(final List<WXWBAction> list) {
        this.mDBWorkExecutor.execute(new Runnable() {
            public void run() {
                DBOperator.this.onInsertAll(list);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onInsertAll(List<WXWBAction> list) {
        ActionDataEntity entryCovert;
        ActionDatabase database2 = getDatabase();
        if (database2 != null && list != null && list.size() > 0) {
            this.mInsertTempList.clear();
            for (int i = 0; i < list.size(); i++) {
                WXWBAction wXWBAction = list.get(i);
                if (!(wXWBAction instanceof DBAction) && (entryCovert = entryCovert(wXWBAction)) != null) {
                    this.mInsertTempList.add(entryCovert);
                }
            }
            if (this.mInsertTempList.size() > 0) {
                database2.actionDataDao().insert((ActionDataEntity[]) this.mInsertTempList.toArray(new ActionDataEntity[list.size()]));
            }
        }
    }

    private ActionDataEntity entryCovert(WXWBAction wXWBAction) {
        if (wXWBAction == null) {
            return null;
        }
        ActionDataEntity actionDataEntity = new ActionDataEntity();
        actionDataEntity.msgId = wXWBAction.getMsgId();
        actionDataEntity.pageId = wXWBAction.getPageKey();
        actionDataEntity.uid = wXWBAction.getUid();
        actionDataEntity.timestamp = wXWBAction.getTimestamp();
        actionDataEntity.originData = wXWBAction.getOriginData();
        actionDataEntity.uniqueKey = wXWBAction.getUniqueKey();
        return actionDataEntity;
    }

    /* access modifiers changed from: private */
    public List<ActionDataEntity> queryOrigin(String str) {
        ActionDatabase database2 = getDatabase();
        if (database2 != null) {
            return database2.actionDataDao().queryAll(str);
        }
        return null;
    }

    public void close() {
        this.mDBWorkExecutor.execute(new Runnable() {
            public void run() {
                if (DBOperator.this.database != null) {
                    try {
                        DBOperator.this.database.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.mDBWorkExecutor.destroy();
    }

    public void clearAndClose() {
        this.mDBWorkExecutor.execute(new Runnable() {
            public void run() {
                if (DBOperator.this.database != null) {
                    try {
                        DBOperator.this.database.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (DBOperator.this.context != null) {
                    try {
                        DBFileManager.clearDBCacheIfNeed(DBOperator.this.context, DBOperator.this.engine.getSetting().getDbExpireTime() * 1000);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        this.mDBWorkExecutor.destroy();
    }

    public void query(final String str, final QueryCallback queryCallback) {
        if (queryCallback != null) {
            this.mDBWorkExecutor.execute(new Runnable() {
                public void run() {
                    DBAction dBAction;
                    List<ActionDataEntity> access$500 = DBOperator.this.queryOrigin(str);
                    ArrayList arrayList = null;
                    if (access$500 != null && access$500.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (ActionDataEntity actionDataEntity : access$500) {
                            byte[] bArr = actionDataEntity.originData;
                            if (bArr != null) {
                                try {
                                    dBAction = new DBAction(bArr, str);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    dBAction = null;
                                }
                                if (dBAction != null) {
                                    arrayList2.add(dBAction);
                                }
                            }
                        }
                        arrayList = arrayList2;
                    }
                    queryCallback.onResult(str, arrayList);
                }
            });
        }
    }

    private static class DBAction extends WXWBAction.ReceiveImpl {
        public DBAction(byte[] bArr) throws Exception {
            super(bArr);
        }

        public DBAction(byte[] bArr, String str) throws Exception {
            super(bArr, str);
        }
    }
}
