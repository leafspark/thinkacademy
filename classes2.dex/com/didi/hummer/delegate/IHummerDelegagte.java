package com.didi.hummer.delegate;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;

public interface IHummerDelegagte extends LifecycleObserver {
    Intent getJsPageResultIntent();

    void initSDK();

    View initViewAndRender();

    boolean onBackPressed();
}
