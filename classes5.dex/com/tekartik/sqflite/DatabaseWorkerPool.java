package com.tekartik.sqflite;

public interface DatabaseWorkerPool {
    void post(Database database, Runnable runnable);

    void post(DatabaseTask databaseTask);

    void quit();

    void start();

    /* renamed from: com.tekartik.sqflite.DatabaseWorkerPool$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$post(DatabaseWorkerPool _this, Database database, Runnable runnable) {
            AnonymousClass1 r2;
            if (database == null) {
                r2 = null;
            } else {
                r2 = new DatabaseDelegate(database) {
                    final /* synthetic */ Database val$database;

                    {
                        this.val$database = r2;
                    }

                    public int getDatabaseId() {
                        return this.val$database.id;
                    }

                    public boolean isInTransaction() {
                        return this.val$database.isInTransaction();
                    }
                };
            }
            _this.post(new DatabaseTask(r2, runnable));
        }

        public static DatabaseWorkerPool create(String str, int i, int i2) {
            if (i == 1) {
                return new SingleDatabaseWorkerPoolImpl(str, i2);
            }
            return new DatabaseWorkerPoolImpl(str, i, i2);
        }
    }
}
