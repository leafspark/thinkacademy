package com.tal.app.thinkacademy.live.core.interfaces;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

public interface ILifecycle {
    void addObserver(LifecycleObserver lifecycleObserver);

    Lifecycle getLifecycleOwner();
}
