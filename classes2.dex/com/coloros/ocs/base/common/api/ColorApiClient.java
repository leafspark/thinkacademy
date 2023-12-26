package com.coloros.ocs.base.common.api;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.coloros.ocs.base.common.AuthResult;

public interface ColorApiClient {
    <T> void addQueue(TaskListenerHolder<T> taskListenerHolder);

    void connect();

    void disconnect();

    Api getApi();

    AuthResult getAuthResult();

    Looper getLooper();

    IBinder getRemoteService();

    int getRemoteVersion();

    boolean isConnected();

    boolean isConnecting();

    void setOnClearListener(e eVar);

    void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler);

    void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler);
}
