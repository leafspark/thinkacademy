package com.coloros.ocs.base.common.api;

import android.os.Looper;
import android.os.Message;
import com.coloros.ocs.base.a.b;
import com.coloros.ocs.base.common.a;
import com.coloros.ocs.base.common.constant.CommonStatusCodes;
import com.coloros.ocs.base.task.TaskImpl;

public class TaskListenerHolder<T> {
    private final String a = "TaskListenerHolder";
    private Looper b;
    private TaskImpl<T> c;
    private int d;
    private SuccessNotifier<T> e;
    private FailureNotifier<T> f;
    private TaskListenerHolder<T>.TaskListenerHandler g;

    public interface FailureNotifier<T> {
        void onNotifyListenerFailed(TaskImpl<T> taskImpl, int i, String str);
    }

    public interface SuccessNotifier<T> {
        void notifyListener(TaskImpl<T> taskImpl);
    }

    public TaskListenerHolder(Looper looper, TaskImpl<T> taskImpl, SuccessNotifier<T> successNotifier, FailureNotifier<T> failureNotifier) {
        this.b = looper;
        this.c = taskImpl;
        this.e = successNotifier;
        this.f = failureNotifier;
        this.g = new TaskListenerHandler(this.b);
    }

    public TaskImpl<T> getTask() {
        return this.c;
    }

    public SuccessNotifier getOnTaskSuccessListener() {
        return this.e;
    }

    public FailureNotifier<T> getFailureNotifier() {
        return this.f;
    }

    public Looper getLooper() {
        return this.b;
    }

    public void setErrorCode(int i) {
        this.d = i;
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = this.d;
        this.g.sendMessage(obtain);
    }

    class TaskListenerHandler extends a {
        public TaskListenerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            if (z) {
                TaskListenerHolder.a(TaskListenerHolder.this, message.arg1);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    static /* synthetic */ void a(TaskListenerHolder taskListenerHolder, int i) {
        b.c(taskListenerHolder.a, "errorCode ".concat(String.valueOf(i)));
        if (i != 0) {
            FailureNotifier<T> failureNotifier = taskListenerHolder.f;
            if (failureNotifier != null) {
                failureNotifier.onNotifyListenerFailed(taskListenerHolder.c, i, CommonStatusCodes.getStatusCodeString(i));
            }
        } else if (taskListenerHolder.e != null) {
            b.b(taskListenerHolder.a, "notifier is not null ");
            taskListenerHolder.e.notifyListener(taskListenerHolder.c);
        }
    }
}
