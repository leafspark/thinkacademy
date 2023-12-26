package com.coloros.ocs.base.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.coloros.ocs.base.IServiceBroker;
import com.coloros.ocs.base.a.b;
import com.coloros.ocs.base.common.AuthResult;
import com.coloros.ocs.base.common.CapabilityInfo;
import com.coloros.ocs.base.common.ConnectionResult;
import com.coloros.ocs.base.common.api.Api;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public abstract class BaseClient<T extends IBinder> implements Api.Client {
    /* access modifiers changed from: package-private */
    public static final String a = "BaseClient";
    /* access modifiers changed from: package-private */
    public volatile int b = 4;
    Context c;
    /* access modifiers changed from: package-private */
    public CapabilityInfo d;
    /* access modifiers changed from: package-private */
    public BaseClient<T>.a e = null;
    e f;
    b g = null;
    /* access modifiers changed from: package-private */
    public IServiceBroker h;
    private Looper i;
    private Queue<TaskListenerHolder> j = new LinkedList();
    /* access modifiers changed from: private */
    public a k;
    private int l = 3;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient n = new IBinder.DeathRecipient() {
        public final void binderDied() {
            b.d(BaseClient.a, "binderDied()");
            a unused = BaseClient.this.e = null;
            if (!(BaseClient.this.h == null || BaseClient.this.h.asBinder() == null || !BaseClient.this.h.asBinder().isBinderAlive())) {
                BaseClient.this.h.asBinder().unlinkToDeath(BaseClient.this.n, 0);
                IServiceBroker unused2 = BaseClient.this.h = null;
            }
            if (BaseClient.this.m && BaseClient.this.d != null) {
                int unused3 = BaseClient.this.b = 13;
                BaseClient.this.connect();
            }
        }
    };

    public abstract String getClientName();

    protected BaseClient(Context context, Looper looper) {
        Objects.requireNonNull(context, "null reference");
        this.c = context;
        Objects.requireNonNull(looper, "Looper must not be null");
        this.i = looper;
        this.k = a.a(this);
        String str = a;
        StringBuilder sb = new StringBuilder("build client, ");
        sb.append(getClientName() == null ? "" : getClientName());
        b.b(str, sb.toString());
    }

    private static Intent e() {
        Intent intent = new Intent("com.coloros.opencapabilityservice");
        b.a(a, "packageName = ".concat("com.coloros.ocs.opencapabilityservice"));
        intent.setComponent(new ComponentName("com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"));
        return intent;
    }

    public void connect() {
        a(true);
    }

    private void a(boolean z) {
        if (z) {
            this.l = 3;
        }
        String str = a;
        b.b(str, "connect");
        this.b = 2;
        this.e = new a(this, (byte) 0);
        boolean bindService = this.c.getApplicationContext().bindService(e(), this.e, 1);
        b.c(str, "connect state ".concat(String.valueOf(bindService)));
        if (!bindService) {
            f();
        }
    }

    private void f() {
        b.c(a, "retry");
        int i2 = this.l;
        if (i2 != 0) {
            this.l = i2 - 1;
            a(false);
            return;
        }
        this.d = b(3);
        a(3);
        e eVar = this.f;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        BaseClient<T>.a aVar;
        if (!this.m && (aVar = this.e) != null && aVar != null) {
            b.b(a, "disconnect service.");
            this.c.getApplicationContext().unbindService(this.e);
            this.b = 5;
            if (!this.m) {
                this.h = null;
            }
        }
    }

    public void disconnect() {
        if (this.e != null) {
            b.c(a, "disconnect service.");
            this.d = null;
            this.c.getApplicationContext().unbindService(this.e);
            this.b = 4;
        }
    }

    private void g() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public T getRemoteService() {
        g();
        return this.d.getBinder();
    }

    public int getMinApkVersion() {
        g();
        return this.d.getVersion();
    }

    public AuthResult getAuthResult() {
        return this.d.getAuthResult();
    }

    public String getTargetPackageName() {
        return this.c.getPackageName();
    }

    /* access modifiers changed from: package-private */
    public final void a(Handler handler) {
        b bVar = this.g;
        if (bVar == null) {
            if (handler == null) {
                this.g = new b(this.i, this.k);
            } else {
                this.g = new b(handler.getLooper(), this.k);
            }
        } else if (handler != null && bVar.getLooper() != handler.getLooper()) {
            b.b(a, "the new handler looper is not the same as the old one.");
        }
    }

    public void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        CapabilityInfo capabilityInfo = this.d;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.d.getAuthResult().getErrrorCode() != 1001) {
            a(handler);
            this.g.a = onConnectionSucceedListener;
        } else if (onConnectionSucceedListener != null) {
            onConnectionSucceedListener.onConnectionSucceed();
        }
    }

    public void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        CapabilityInfo capabilityInfo = this.d;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.d.getAuthResult().getErrrorCode() == 1001) {
            a(handler);
            this.g.b = onConnectionFailedListener;
        } else if (onConnectionFailedListener != null) {
            onConnectionFailedListener.onConnectionFailed(new ConnectionResult(this.d.getAuthResult().getErrrorCode()));
        }
    }

    public void setOnClearListener(e eVar) {
        this.f = eVar;
    }

    public Looper getLooper() {
        return this.i;
    }

    public boolean isConnected() {
        return this.b == 1 || this.b == 5;
    }

    public boolean isConnecting() {
        return this.b == 2;
    }

    public <T> void addQueue(TaskListenerHolder<T> taskListenerHolder) {
        if (!isConnected()) {
            if (this.b == 13) {
                a((TaskListenerHolder) taskListenerHolder, true);
            } else {
                a((TaskListenerHolder) taskListenerHolder, false);
            }
        } else if (this.m) {
            IServiceBroker iServiceBroker = this.h;
            if (iServiceBroker == null || iServiceBroker.asBinder() == null || !this.h.asBinder().isBinderAlive()) {
                a((TaskListenerHolder) taskListenerHolder, true);
            } else {
                a((TaskListenerHolder) taskListenerHolder);
            }
        } else {
            a((TaskListenerHolder) taskListenerHolder);
        }
    }

    private void a(TaskListenerHolder taskListenerHolder, boolean z) {
        b.b(a, "add taskListenerHolder to queue,but whether is connect ".concat(String.valueOf(z)));
        this.j.add(taskListenerHolder);
        if (z) {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        while (this.j.size() > 0) {
            b.b(a, "handleQue");
            a(this.j.poll());
        }
        b.b(a, "task queue is end");
    }

    private void a(TaskListenerHolder taskListenerHolder) {
        CapabilityInfo capabilityInfo = this.d;
        if (capabilityInfo != null && capabilityInfo.getAuthResult() != null) {
            if (this.d.getAuthResult().getErrrorCode() == 1001) {
                taskListenerHolder.setErrorCode(0);
            } else {
                taskListenerHolder.setErrorCode(this.d.getAuthResult().getErrrorCode());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        b.b(a, "handleAuthenticateFailure");
        if (this.g == null) {
            a((Handler) null);
        }
        Message obtain = Message.obtain();
        obtain.what = 101;
        obtain.arg1 = i2;
        this.g.sendMessage(obtain);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        b.b(a, "onReconnectSucceed");
        this.b = 1;
        try {
            this.d.setBinder(this.h.getBinder(getClientName(), "1.0.1"));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        b();
        a();
    }

    static CapabilityInfo b(int i2) {
        return new CapabilityInfo(new ArrayList(), 1, new AuthResult("", 0, 0, i2, new byte[0]));
    }

    class a implements ServiceConnection {
        private a() {
        }

        /* synthetic */ a(BaseClient baseClient, byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.b(BaseClient.a, "onServiceConnected");
            IServiceBroker unused = BaseClient.this.h = IServiceBroker.Stub.asInterface(iBinder);
            try {
                BaseClient.this.h.asBinder().linkToDeath(BaseClient.this.n, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (BaseClient.this.d == null) {
                b.b(BaseClient.a, "handle authenticate");
                BaseClient.this.k.sendEmptyMessage(3);
                return;
            }
            b.b(BaseClient.a, "handle reconnect");
            Message obtain = Message.obtain();
            obtain.what = 4;
            BaseClient.this.k.sendMessage(obtain);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            b.d(BaseClient.a, "onServiceDisconnected()");
            int unused = BaseClient.this.b = 13;
            a unused2 = BaseClient.this.e = null;
            IServiceBroker unused3 = BaseClient.this.h = null;
        }
    }
}
