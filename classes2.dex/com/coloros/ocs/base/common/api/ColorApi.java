package com.coloros.ocs.base.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.coloros.ocs.base.a.b;
import com.coloros.ocs.base.a.c;
import com.coloros.ocs.base.a.d;
import com.coloros.ocs.base.common.AuthResult;
import com.coloros.ocs.base.common.api.Api;
import com.coloros.ocs.base.common.api.Api.ApiOptions;
import com.coloros.ocs.base.common.api.ColorApi;
import com.coloros.ocs.base.common.api.TaskListenerHolder;
import com.coloros.ocs.base.internal.ClientSettings;
import com.coloros.ocs.base.task.Task;
import com.coloros.ocs.base.task.TaskImpl;

public abstract class ColorApi<O extends Api.ApiOptions, R extends ColorApi> {
    O a;
    private Context b;
    private Api<O> c;
    private c d;
    private ClientSettings e;

    public abstract int getVersion();

    public abstract boolean hasFeature(String str);

    /* access modifiers changed from: protected */
    public abstract void init();

    protected ColorApi(Context context, Api<O> api, ClientSettings clientSettings) {
        c.a(context, (Object) "Null context is not permitted.");
        c.a(api, (Object) "Api must not be null.");
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        b.a(applicationContext);
        this.c = api;
        this.e = clientSettings;
        c a2 = c.a(this.b);
        this.d = a2;
        a2.a(this, this.e);
    }

    public ColorApi(Activity activity, Api<O> api, O o, ClientSettings clientSettings) {
        c.a(activity, (Object) "Null activity is not permitted.");
        c.a(api, (Object) "Api must not be null.");
        Context applicationContext = activity.getApplicationContext();
        this.b = applicationContext;
        b.a(applicationContext);
        this.c = api;
        this.a = o;
        this.e = clientSettings;
        c a2 = c.a(this.b);
        this.d = a2;
        a2.a(this, this.e);
    }

    public ColorApi(Context context, Api<O> api, O o, ClientSettings clientSettings) {
        c.a(context, (Object) "Null context is not permitted.");
        c.a(api, (Object) "Api must not be null.");
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        b.a(applicationContext);
        this.c = api;
        this.a = o;
        this.e = clientSettings;
        c a2 = c.a(this.b);
        this.d = a2;
        a2.a(this, this.e);
    }

    /* access modifiers changed from: protected */
    public Api<O> getApi() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public IBinder getRemoteService() {
        b.a("getRemoteService");
        return c.a(this);
    }

    /* access modifiers changed from: protected */
    public boolean isConnected() {
        return c.d(this);
    }

    /* access modifiers changed from: protected */
    public void releaseClientKey() {
        c.a((Api.ClientKey) this.c.getClientKey());
        c.b((Api.ClientKey) this.c.getClientKey());
    }

    /* access modifiers changed from: protected */
    public int getRemoteVersion() {
        return c.b(this);
    }

    /* access modifiers changed from: protected */
    public void addThis2Cache() {
        b.a("color api add to cache");
        this.d.a(this, this.e);
    }

    /* access modifiers changed from: protected */
    public void disconnect() {
        b.a("color api disconnect");
        c cVar = this.d;
        b.b("ColorApiManager", "handleDisconnect");
        Message obtainMessage = cVar.a.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = this;
        cVar.a.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public boolean checkExist() {
        return d.a(this.b, "com.coloros.ocs.opencapabilityservice");
    }

    /* access modifiers changed from: protected */
    public AuthResult getAuthResult() {
        return c.c(this);
    }

    public R addOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener) {
        return addOnConnectionSucceedListener(onConnectionSucceedListener, new Handler(Looper.getMainLooper()));
    }

    public R addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        return addOnConnectionFailedListener(onConnectionFailedListener, new Handler(Looper.getMainLooper()));
    }

    public R addOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        this.d.a(this, onConnectionSucceedListener, handler);
        return this;
    }

    public R addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        c.a(this, onConnectionFailedListener, handler);
        return this;
    }

    /* access modifiers changed from: protected */
    public <TResult> Task<TResult> doRegisterListener(TaskListenerHolder.SuccessNotifier<TResult> successNotifier, TaskListenerHolder.FailureNotifier<TResult> failureNotifier) {
        return doRegisterListener(Looper.getMainLooper(), successNotifier, failureNotifier);
    }

    /* access modifiers changed from: protected */
    public <TResult> Task<TResult> doRegisterListener(Looper looper, TaskListenerHolder.SuccessNotifier<TResult> successNotifier, TaskListenerHolder.FailureNotifier<TResult> failureNotifier) {
        b.a("color doRegisterListener");
        TaskImpl taskImpl = new TaskImpl();
        c.a(this, new TaskListenerHolder(looper, taskImpl, successNotifier, failureNotifier));
        return taskImpl;
    }
}
