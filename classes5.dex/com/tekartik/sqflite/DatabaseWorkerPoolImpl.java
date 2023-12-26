package com.tekartik.sqflite;

import com.tekartik.sqflite.DatabaseWorkerPool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: DatabaseWorkerPool */
class DatabaseWorkerPoolImpl implements DatabaseWorkerPool {
    private final Set<DatabaseWorker> busyWorkers = new HashSet();
    private final Set<DatabaseWorker> idleWorkers = new HashSet();
    final String name;
    final int numberOfWorkers;
    private final Map<Integer, DatabaseWorker> onlyEligibleWorkers = new HashMap();
    final int priority;
    private final LinkedList<DatabaseTask> waitingList = new LinkedList<>();

    public /* synthetic */ void post(Database database, Runnable runnable) {
        DatabaseWorkerPool.CC.$default$post(this, database, runnable);
    }

    DatabaseWorkerPoolImpl(String str, int i, int i2) {
        this.name = str;
        this.numberOfWorkers = i;
        this.priority = i2;
    }

    public synchronized void start() {
        for (int i = 0; i < this.numberOfWorkers; i++) {
            DatabaseWorker createWorker = createWorker(this.name + i, this.priority);
            createWorker.start(new DatabaseWorkerPoolImpl$$ExternalSyntheticLambda0(this, createWorker));
            this.idleWorkers.add(createWorker);
        }
    }

    /* access modifiers changed from: protected */
    public DatabaseWorker createWorker(String str, int i) {
        return new DatabaseWorker(str, i);
    }

    public synchronized void quit() {
        for (DatabaseWorker quit : this.idleWorkers) {
            quit.quit();
        }
        for (DatabaseWorker quit2 : this.busyWorkers) {
            quit2.quit();
        }
    }

    public synchronized void post(DatabaseTask databaseTask) {
        this.waitingList.add(databaseTask);
        for (DatabaseWorker tryPostingTaskToWorker : new HashSet(this.idleWorkers)) {
            tryPostingTaskToWorker(tryPostingTaskToWorker);
        }
    }

    private synchronized void tryPostingTaskToWorker(DatabaseWorker databaseWorker) {
        DatabaseTask findTaskForWorker = findTaskForWorker(databaseWorker);
        if (findTaskForWorker != null) {
            this.busyWorkers.add(databaseWorker);
            this.idleWorkers.remove(databaseWorker);
            if (findTaskForWorker.getDatabaseId() != null) {
                this.onlyEligibleWorkers.put(findTaskForWorker.getDatabaseId(), databaseWorker);
            }
            databaseWorker.postTask(findTaskForWorker);
        }
    }

    private synchronized DatabaseTask findTaskForWorker(DatabaseWorker databaseWorker) {
        DatabaseTask databaseTask;
        ListIterator listIterator = this.waitingList.listIterator();
        while (true) {
            DatabaseWorker databaseWorker2 = null;
            if (!listIterator.hasNext()) {
                return null;
            }
            databaseTask = (DatabaseTask) listIterator.next();
            if (databaseTask.getDatabaseId() != null) {
                databaseWorker2 = this.onlyEligibleWorkers.get(databaseTask.getDatabaseId());
            }
            if (databaseWorker2 == null || databaseWorker2 == databaseWorker) {
                listIterator.remove();
            }
        }
        listIterator.remove();
        return databaseTask;
    }

    /* access modifiers changed from: private */
    /* renamed from: onWorkerIdle */
    public synchronized void lambda$start$0$DatabaseWorkerPoolImpl(DatabaseWorker databaseWorker) {
        HashSet<DatabaseWorker> hashSet = new HashSet<>(this.idleWorkers);
        this.busyWorkers.remove(databaseWorker);
        this.idleWorkers.add(databaseWorker);
        if (!databaseWorker.isLastTaskInTransaction() && databaseWorker.lastTaskDatabaseId() != null) {
            this.onlyEligibleWorkers.remove(databaseWorker.lastTaskDatabaseId());
        }
        tryPostingTaskToWorker(databaseWorker);
        for (DatabaseWorker tryPostingTaskToWorker : hashSet) {
            tryPostingTaskToWorker(tryPostingTaskToWorker);
        }
    }
}
