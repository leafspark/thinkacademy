package com.coloros.ocs.base.task;

final class l implements Runnable {
    private Task a;
    private c b;

    l(c cVar, Task task) {
        this.b = cVar;
        this.a = task;
    }

    public final void run() {
        if (this.a.isCanceled()) {
            this.b.b.tryCancel();
            return;
        }
        TContinuationResult tcontinuationresult = null;
        try {
            tcontinuationresult = this.b.a.then(this.a);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof Exception) {
                this.b.b.setException((Exception) e.getCause());
            } else {
                this.b.b.setException(e);
            }
        } catch (Exception e2) {
            this.b.b.setException(e2);
        }
        this.b.b.setResult(tcontinuationresult);
    }
}
