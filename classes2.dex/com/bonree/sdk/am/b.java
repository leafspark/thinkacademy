package com.bonree.sdk.am;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.location.LocationManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.a;
import com.bonree.sdk.bs.ad;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;

public final class b extends i {
    private static final String j = "AndroidDeviceStateInfo";
    private Context k = a.a();
    private volatile boolean l = false;
    private BroadcastReceiver m;
    private ContentResolver n;
    /* access modifiers changed from: private */
    public LocationManager o;
    private ContentObserver p;
    private ActivityManager q;
    private ActivityManager.MemoryInfo r;
    private volatile boolean s = false;
    private final f t = com.bonree.sdk.be.a.a();

    public b() {
        if (!this.l) {
            d dVar = new d(this);
            this.m = dVar;
            this.k.registerReceiver(dVar, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.l = true;
        }
        if (ad.a(a.a(), "android.permission.ACCESS_FINE_LOCATION")) {
            v();
        }
        h();
        j();
    }

    public final void a() {
        if (ad.a(a.a(), "android.permission.ACCESS_FINE_LOCATION")) {
            t();
            this.f = this.o.isProviderEnabled("gps");
            return;
        }
        this.t.c("gps permission Manifest.permission.ACCESS_FINE_LOCATION is no !", new Object[0]);
    }

    public final void b() {
        if (ad.a(this.k, "android.permission.BLUETOOTH")) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                this.t.e("BluetoothAdapter is null while getting Bluetooth switch", new Object[0]);
            } else {
                this.e = defaultAdapter.isEnabled();
            }
        }
    }

    public final void c() {
        try {
            if (this.q == null) {
                this.q = (ActivityManager) a.a().getSystemService("activity");
            }
            if (this.q != null) {
                if (this.r == null) {
                    this.r = new ActivityManager.MemoryInfo();
                }
                this.q.getMemoryInfo(this.r);
                this.d = (int) ((((double) this.r.availMem) / 1024.0d) / 1024.0d);
            }
        } catch (Throwable unused) {
        }
    }

    public final void d() {
        int i = a.a().getResources().getConfiguration().orientation;
        if (i == 2) {
            this.h = 2;
        } else if (i == 1) {
            this.h = 1;
        }
        String b = ad.b();
        if (b != null) {
            try {
                this.c = (int) ((((double) new File(b).getFreeSpace()) / 1024.0d) / 1024.0d);
            } catch (Throwable unused) {
            }
        }
    }

    private void t() {
        if (this.o == null) {
            this.o = (LocationManager) a.a().getSystemService(FirebaseAnalytics.Param.LOCATION);
        }
        if (this.o != null && this.p == null) {
            this.p = new c(this, (Handler) null);
        }
    }

    public final void e() {
        u();
        if (ad.a(a.a(), "android.permission.ACCESS_FINE_LOCATION")) {
            v();
        }
    }

    private void u() {
        if (!this.l) {
            d dVar = new d(this);
            this.m = dVar;
            this.k.registerReceiver(dVar, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.l = true;
        }
    }

    private void v() {
        try {
            if (this.n == null) {
                this.n = a.a().getContentResolver();
            }
            t();
            ContentResolver contentResolver = this.n;
            if (contentResolver != null && this.p != null) {
                contentResolver.registerContentObserver(Settings.Secure.getUriFor("location_providers_allowed"), false, this.p);
                this.s = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        try {
            if (!(this.k == null || this.m == null || !this.l)) {
                this.k.unregisterReceiver(this.m);
                this.l = false;
            }
            if (this.k != null && this.n != null && this.p != null && this.s) {
                this.n.unregisterContentObserver(this.p);
                this.s = false;
            }
        } catch (Throwable th) {
            f fVar = this.t;
            fVar.e("DeviceStateInfo e=" + th.getMessage(), new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final int g() {
        int intProperty;
        try {
            if (this.b > 0) {
                return this.b;
            }
            if (Build.VERSION.SDK_INT < 21 || (intProperty = ((BatteryManager) a.a().getSystemService("batterymanager")).getIntProperty(4)) == 0) {
                return 1;
            }
            this.b = intProperty;
            return this.b;
        } catch (Throwable unused) {
            return 1;
        }
    }
}
