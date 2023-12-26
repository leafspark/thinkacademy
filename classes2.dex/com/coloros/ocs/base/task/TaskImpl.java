package com.coloros.ocs.base.task;

import com.coloros.ocs.base.a.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public class TaskImpl<TResult> extends Task<TResult> {
    private final Object a = new Object();
    private TResult b;
    private Exception c;
    private q<TResult> d = new q<>();
    private volatile boolean e;
    private volatile boolean f;

    public boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.e;
        }
        return z;
    }

    public boolean isCanceled() {
        return this.f;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.e && !this.f && this.c == null;
        }
        return z;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            a();
            c();
            if (this.c == null) {
                tresult = this.b;
            } else {
                throw new RuntimeException(this.c);
            }
        }
        return tresult;
    }

    public <X extends Throwable> TResult getResult(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            a();
            c();
            if (cls.isInstance(this.c)) {
                throw ((Throwable) cls.cast(this.c));
            } else if (this.c == null) {
                tresult = this.b;
            } else {
                throw new RuntimeException(this.c);
            }
        }
        return tresult;
    }

    public Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.c;
        }
        return exc;
    }

    public Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    public Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.d.a(new j(executor, onSuccessListener));
        d();
        return this;
    }

    public Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    public Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.d.a(new h(executor, onFailureListener));
        d();
        return this;
    }

    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    public Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.d.a(new f(executor, onCompleteListener));
        d();
        return this;
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        TaskImpl taskImpl = new TaskImpl();
        this.d.a(new c(executor, continuation, taskImpl));
        d();
        return taskImpl;
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    public Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.d.a(new d(executor, onCanceledListener));
        d();
        return this;
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        TaskImpl taskImpl = new TaskImpl();
        this.d.a(new c(executor, continuation, taskImpl));
        d();
        return taskImpl;
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        TaskImpl taskImpl = new TaskImpl();
        this.d.a(new m(executor, successContinuation, taskImpl));
        d();
        return taskImpl;
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    public void setResult(TResult tresult) {
        synchronized (this.a) {
            b();
            this.e = true;
            this.b = tresult;
        }
        this.d.a(this);
    }

    public boolean trySetResult(TResult tresult) {
        boolean z;
        synchronized (this.a) {
            z = true;
            if (this.e) {
                z = false;
            } else {
                this.e = true;
                this.b = tresult;
                this.d.a(this);
            }
        }
        return z;
    }

    public void setException(Exception exc) {
        c.a(exc, (Object) "Exception must not be null");
        synchronized (this.a) {
            b();
            this.e = true;
            this.c = exc;
        }
        this.d.a(this);
    }

    public boolean trySetException(Exception exc) {
        boolean z;
        c.a(exc, (Object) "Exception must not be null");
        synchronized (this.a) {
            z = true;
            if (this.e) {
                z = false;
            } else {
                this.e = true;
                this.c = exc;
                this.d.a(this);
            }
        }
        return z;
    }

    public boolean tryCancel() {
        boolean z;
        synchronized (this.a) {
            z = true;
            if (this.e) {
                z = false;
            } else {
                this.e = true;
                this.f = true;
                this.d.a(this);
            }
        }
        return z;
    }

    private void a() {
        synchronized (this.a) {
            c.a(this.e, (Object) "Task is not yet complete");
        }
    }

    private void b() {
        synchronized (this.a) {
            c.a(!this.e, (Object) "Task is already complete");
        }
    }

    private void c() {
        if (this.f) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private void d() {
        synchronized (this.a) {
            if (this.e) {
                this.d.a(this);
            }
        }
    }
}
