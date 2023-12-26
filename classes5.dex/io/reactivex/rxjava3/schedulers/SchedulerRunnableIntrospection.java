package io.reactivex.rxjava3.schedulers;

public interface SchedulerRunnableIntrospection {
    Runnable getWrappedRunnable();
}
