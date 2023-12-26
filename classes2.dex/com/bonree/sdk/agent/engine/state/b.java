package com.bonree.sdk.agent.engine.state;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.igexin.sdk.PushConsts;

public final class b extends m {
    private static final String a = "StateEngine-";
    private ConnectivityManager d;
    private ConnectivityManager.NetworkCallback e;
    /* access modifiers changed from: private */
    public volatile boolean f;
    private BroadcastReceiver g;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.f = true;
        this.g = new d(this);
    }

    public final synchronized String a() {
        if (ad.a(this.c) || "NaN".equals(this.c)) {
            this.c = ad.a.a();
        }
        return this.c;
    }

    public final void b() {
        this.d = (ConnectivityManager) com.bonree.sdk.bs.a.a().getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 24) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            com.bonree.sdk.bs.a.a().registerReceiver(this.g, intentFilter);
        } else if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
            c cVar = new c(this);
            this.e = cVar;
            this.d.registerDefaultNetworkCallback(cVar);
            a(this.d.getActiveNetwork());
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(Network network) {
        f a2 = com.bonree.sdk.be.a.a();
        a2.c("StateEngine- netStateChange " + network, new Object[0]);
        this.b = new k();
        if (network == null) {
            try {
                f();
            } catch (Exception e2) {
                com.bonree.sdk.be.a.a().a("StateEngine- netStateChange is error : %s", (Throwable) e2);
            }
        } else if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.READ_PHONE_STATE")) {
            int b = ad.a.b();
            if (b == -1) {
                f();
            } else if (b == 0) {
                a(b);
            } else if (b == -2) {
                a(false);
            } else {
                a(b, ad.a.a(b));
            }
        } else {
            a(false);
            return;
        }
        f a3 = com.bonree.sdk.be.a.a();
        a3.c(a + this.b.toString() + ".  tName=" + Thread.currentThread().getName() + "tId=" + Thread.currentThread().getId(), new Object[0]);
        notifyService(this.b);
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z) {
        if (z) {
            this.b = new k();
        }
        NetworkInfo networkInfo = null;
        if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
            networkInfo = this.d.getActiveNetworkInfo();
        }
        if (networkInfo == null) {
            f();
        } else {
            this.b.a(networkInfo);
            if (networkInfo.getType() != 1) {
                a(networkInfo.getType(), networkInfo.getSubtypeName());
            } else if (networkInfo.getState() == NetworkInfo.State.DISCONNECTED) {
                this.b.a(-1);
                this.b.a("NaN");
                this.c = "NaN";
            } else {
                a(networkInfo.getType());
            }
        }
        com.bonree.sdk.be.a.a().c("StateEngine- netState:%s, tName:%s, tId:%s", this.b, Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
        notifyService(this.b);
    }

    public final void c() {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                com.bonree.sdk.bs.a.a().unregisterReceiver(this.g);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback = this.e;
            if (networkCallback != null) {
                this.d.unregisterNetworkCallback(networkCallback);
                this.e = null;
            }
        } catch (Throwable th) {
            f a2 = com.bonree.sdk.be.a.a();
            a2.e("StateEngine-e=" + th.getMessage(), new Object[0]);
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);

        private a() {
        }
    }

    public static b d() {
        return a.a;
    }
}
