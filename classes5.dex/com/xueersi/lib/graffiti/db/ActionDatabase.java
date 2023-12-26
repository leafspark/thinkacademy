package com.xueersi.lib.graffiti.db;

import android.content.Context;

public class ActionDatabase {
    private ActionDataDao actionDataDao;
    private DatabaseHelper databaseHelper;

    public ActionDatabase(Context context, String str) {
        this.databaseHelper = new DatabaseHelper(context, str);
    }

    public ActionDataDao actionDataDao() {
        if (this.actionDataDao == null) {
            this.actionDataDao = new ActionDataDao(this.databaseHelper.getReadableDatabase());
        }
        return this.actionDataDao;
    }

    public void close() {
        DatabaseHelper databaseHelper2 = this.databaseHelper;
        if (databaseHelper2 != null) {
            databaseHelper2.close();
        }
    }
}
