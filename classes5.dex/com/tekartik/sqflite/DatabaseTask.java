package com.tekartik.sqflite;

final class DatabaseTask {
    private final DatabaseDelegate database;
    final Runnable runnable;

    DatabaseTask(DatabaseDelegate databaseDelegate, Runnable runnable2) {
        this.database = databaseDelegate;
        this.runnable = runnable2;
    }

    public boolean isInTransaction() {
        DatabaseDelegate databaseDelegate = this.database;
        return databaseDelegate != null && databaseDelegate.isInTransaction();
    }

    public Integer getDatabaseId() {
        DatabaseDelegate databaseDelegate = this.database;
        if (databaseDelegate != null) {
            return Integer.valueOf(databaseDelegate.getDatabaseId());
        }
        return null;
    }
}
