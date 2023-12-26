package com.bumptech.glide.manager;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class FirstFrameAndAfterTrimMemoryWaiter implements FrameWaiter, ComponentCallbacks2 {
    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onTrimMemory(int i) {
    }

    public void registerSelf(Activity activity) {
    }

    FirstFrameAndAfterTrimMemoryWaiter() {
    }

    public void onLowMemory() {
        onTrimMemory(20);
    }
}
