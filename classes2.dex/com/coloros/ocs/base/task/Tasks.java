package com.coloros.ocs.base.task;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tasks {

    interface c extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    static class b implements c {
        CountDownLatch a;

        private b() {
            this.a = new CountDownLatch(1);
        }

        public final void onSuccess(Object obj) {
            this.a.countDown();
        }

        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        public final void onCanceled() {
            this.a.countDown();
        }

        b(byte b) {
            this();
        }
    }

    static class a implements c {
        private final Object a = new Object();
        private TaskImpl<Void> b;
        private Exception c;
        private volatile int d;
        private volatile int e;
        private volatile int f;
        private volatile int g;
        private volatile boolean h;

        public a(int i, TaskImpl<Void> taskImpl) {
            this.d = i;
            this.b = taskImpl;
        }

        public final void onFailure(Exception exc) {
            synchronized (this.a) {
                this.f++;
                this.c = exc;
                a();
            }
        }

        public final void onSuccess(Object obj) {
            synchronized (this.a) {
                this.e++;
                a();
            }
        }

        public final void onCanceled() {
            synchronized (this.a) {
                this.g++;
                this.h = true;
                a();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a() {
            /*
                r5 = this;
                java.lang.Object r0 = r5.a
                monitor-enter(r0)
                int r1 = r5.e     // Catch:{ all -> 0x0051 }
                int r2 = r5.f     // Catch:{ all -> 0x0051 }
                int r1 = r1 + r2
                int r2 = r5.g     // Catch:{ all -> 0x0051 }
                int r1 = r1 + r2
                int r2 = r5.d     // Catch:{ all -> 0x0051 }
                if (r1 == r2) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x0051 }
                return
            L_0x0011:
                java.lang.Exception r1 = r5.c     // Catch:{ all -> 0x0051 }
                if (r1 == 0) goto L_0x003f
                com.coloros.ocs.base.task.TaskImpl<java.lang.Void> r1 = r5.b     // Catch:{ all -> 0x0051 }
                int r2 = r5.f     // Catch:{ all -> 0x0051 }
                java.util.concurrent.ExecutionException r3 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x0051 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
                r4.<init>()     // Catch:{ all -> 0x0051 }
                r4.append(r2)     // Catch:{ all -> 0x0051 }
                java.lang.String r2 = " out of "
                r4.append(r2)     // Catch:{ all -> 0x0051 }
                int r2 = r5.d     // Catch:{ all -> 0x0051 }
                r4.append(r2)     // Catch:{ all -> 0x0051 }
                java.lang.String r2 = " underlying tasks failed"
                r4.append(r2)     // Catch:{ all -> 0x0051 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0051 }
                java.lang.Exception r4 = r5.c     // Catch:{ all -> 0x0051 }
                r3.<init>(r2, r4)     // Catch:{ all -> 0x0051 }
                r1.setException(r3)     // Catch:{ all -> 0x0051 }
                goto L_0x004f
            L_0x003f:
                boolean r1 = r5.h     // Catch:{ all -> 0x0051 }
                if (r1 == 0) goto L_0x0049
                com.coloros.ocs.base.task.TaskImpl<java.lang.Void> r1 = r5.b     // Catch:{ all -> 0x0051 }
                r1.tryCancel()     // Catch:{ all -> 0x0051 }
                goto L_0x004f
            L_0x0049:
                com.coloros.ocs.base.task.TaskImpl<java.lang.Void> r1 = r5.b     // Catch:{ all -> 0x0051 }
                r2 = 0
                r1.setResult(r2)     // Catch:{ all -> 0x0051 }
            L_0x004f:
                monitor-exit(r0)     // Catch:{ all -> 0x0051 }
                return
            L_0x0051:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0051 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coloros.ocs.base.task.Tasks.a.a():void");
        }
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        TaskImpl taskImpl = new TaskImpl();
        taskImpl.setResult(tresult);
        return taskImpl;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        TaskImpl taskImpl = new TaskImpl();
        taskImpl.setException(exc);
        return taskImpl;
    }

    public static <TResult> Task<TResult> forCanceled() {
        TaskImpl taskImpl = new TaskImpl();
        taskImpl.tryCancel();
        return taskImpl;
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        com.coloros.ocs.base.a.c.a(executor, (Object) "Executor must not be null");
        com.coloros.ocs.base.a.c.a(callable, (Object) "Callback must not be null");
        TaskImpl taskImpl = new TaskImpl();
        executor.execute(new a(taskImpl, callable));
        return taskImpl;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task requireNonNull : collection) {
            Objects.requireNonNull(requireNonNull, "null tasks are not accepted");
        }
        TaskImpl taskImpl = new TaskImpl();
        a aVar = new a(collection.size(), taskImpl);
        for (Task a2 : collection) {
            a(a2, aVar);
        }
        return taskImpl;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        if (taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWith(new p(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        return whenAllSuccess((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return whenAll(collection).continueWithTask(new o(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    private static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static <TResult> void a(Task<TResult> task, c cVar) {
        task.addOnSuccessListener(TaskExecutors.CURRENT_THREAD, cVar);
        task.addOnFailureListener(TaskExecutors.CURRENT_THREAD, cVar);
        task.addOnCanceledListener(TaskExecutors.CURRENT_THREAD, cVar);
    }

    private Tasks() {
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        com.coloros.ocs.base.a.c.b("Must not be called on the main application thread");
        com.coloros.ocs.base.a.c.a(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return a(task);
        }
        b bVar = new b((byte) 0);
        a(task, bVar);
        bVar.a.await();
        return a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        com.coloros.ocs.base.a.c.b("Must not be called on the main application thread");
        com.coloros.ocs.base.a.c.a(task, (Object) "Task must not be null");
        com.coloros.ocs.base.a.c.a(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return a(task);
        }
        b bVar = new b((byte) 0);
        a(task, bVar);
        if (bVar.a.await(j, timeUnit)) {
            return a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
