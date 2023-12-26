package com.coloros.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.coloros.ocs.base.a.b;
import com.coloros.ocs.base.common.AuthResult;
import com.coloros.ocs.base.common.api.Api;
import com.coloros.ocs.base.internal.ClientSettings;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class d implements ColorApiClient {
    private static final String a = "d";
    private Lock b = new ReentrantLock();
    private Api c;
    private Api.Client d;

    public d(Context context, Api api, Api.ApiOptions apiOptions, ClientSettings clientSettings) {
        b.d(a, "init color client impl");
        this.c = api;
        this.d = api.getClientBuilder().buildClient(context, Looper.getMainLooper(), clientSettings, apiOptions);
    }

    public Api getApi() {
        return this.c;
    }

    public void connect() {
        b.a(a, "connect()");
        this.b.lock();
        try {
            Api.Client client = this.d;
            if (client != null) {
                client.connect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
        this.b.unlock();
    }

    public void disconnect() {
        this.b.lock();
        try {
            Api.Client client = this.d;
            if (client != null && client.isConnected()) {
                this.d.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
        this.b.unlock();
    }

    public Looper getLooper() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getLooper();
        }
        return null;
    }

    public boolean isConnected() {
        Api.Client client = this.d;
        if (client != null) {
            return client.isConnected();
        }
        return false;
    }

    public boolean isConnecting() {
        Api.Client client = this.d;
        if (client != null) {
            return client.isConnecting();
        }
        return false;
    }

    public IBinder getRemoteService() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getRemoteService();
        }
        return null;
    }

    public <T> void addQueue(TaskListenerHolder<T> taskListenerHolder) {
        Api.Client client = this.d;
        if (client != null) {
            client.addQueue(taskListenerHolder);
        }
    }

    public int getRemoteVersion() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getMinApkVersion();
        }
        return 0;
    }

    public AuthResult getAuthResult() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getAuthResult();
        }
        return null;
    }

    public void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnConnectionSucceedListener(onConnectionSucceedListener, handler);
        }
    }

    public void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnConnectionFailedListener(onConnectionFailedListener, handler);
        }
    }

    public void setOnClearListener(e eVar) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnClearListener(eVar);
        }
    }
}
