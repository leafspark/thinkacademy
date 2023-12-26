package com.tal.app.thinkacademy.live.core.plugin;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginconfige.PluginConfData;

public abstract class BaseLivePluginDriver implements LifecycleObserver, ILivePluginDriver, LifecycleOwner {
    protected String mInitModuleJsonStr;
    protected ILiveRoomProvider mLiveRoomProvider;
    protected PluginConfData mPluginConfData;

    public abstract void onDestroy();

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onLifecycleCreate(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onLifecyclePause(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onLifecycleResume(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onLifecycleStart(LifecycleOwner lifecycleOwner) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onLifecycleStop(LifecycleOwner lifecycleOwner) {
    }

    private BaseLivePluginDriver() {
    }

    public BaseLivePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        this.mLiveRoomProvider = iLiveRoomProvider;
        iLiveRoomProvider.addObserver(this);
        this.mInitModuleJsonStr = bundle.getString("initModuleData");
        this.mPluginConfData = (PluginConfData) bundle.getSerializable("pluginConfData");
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        destroy();
    }

    public void destroy() {
        this.mLiveRoomProvider.destroyPlugin(this);
        getLifecycle().removeObserver(this);
        onDestroy();
    }

    public Lifecycle getLifecycle() {
        return this.mLiveRoomProvider.getLifecycleOwner();
    }
}
