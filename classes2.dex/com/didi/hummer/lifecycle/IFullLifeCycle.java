package com.didi.hummer.lifecycle;

public interface IFullLifeCycle extends ILifeCycle {
    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
