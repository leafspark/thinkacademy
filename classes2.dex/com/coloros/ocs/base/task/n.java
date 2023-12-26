package com.coloros.ocs.base.task;

final class n implements Runnable {
    private m a;
    private Task b;

    n(m mVar, Task task) {
        this.a = mVar;
        this.b = task;
    }

    public final void run() {
        try {
            Task<TContinuationResult> then = this.a.a.then(this.b.getResult());
            if (then == null) {
                this.a.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            then.addOnSuccessListener(TaskExecutors.CURRENT_THREAD, this.a);
            then.addOnFailureListener(TaskExecutors.CURRENT_THREAD, this.a);
            then.addOnCanceledListener(TaskExecutors.CURRENT_THREAD, this.a);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof Exception) {
                this.a.onFailure((Exception) e.getCause());
            } else {
                this.a.onFailure(e);
            }
        } catch (Exception e2) {
            this.a.onFailure(e2);
        }
    }
}
