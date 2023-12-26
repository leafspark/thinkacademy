package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class SingletonConnectivityReceiver {
    private static final String TAG = "ConnectivityMonitor";
    private static volatile SingletonConnectivityReceiver instance;
    private final FrameworkConnectivityMonitor frameworkConnectivityMonitor;
    private boolean isRegistered;
    final Set<ConnectivityMonitor.ConnectivityListener> listeners = new HashSet();

    private interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    static SingletonConnectivityReceiver get(Context context) {
        if (instance == null) {
            synchronized (SingletonConnectivityReceiver.class) {
                if (instance == null) {
                    instance = new SingletonConnectivityReceiver(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    static void reset() {
        instance = null;
    }

    private SingletonConnectivityReceiver(final Context context) {
        FrameworkConnectivityMonitor frameworkConnectivityMonitor2;
        GlideSuppliers.GlideSupplier memorize = GlideSuppliers.memorize(new GlideSuppliers.GlideSupplier<ConnectivityManager>() {
            public ConnectivityManager get() {
                return (ConnectivityManager) context.getSystemService("connectivity");
            }
        });
        AnonymousClass2 r1 = new ConnectivityMonitor.ConnectivityListener() {
            public void onConnectivityChanged(boolean z) {
                ArrayList<ConnectivityMonitor.ConnectivityListener> arrayList;
                synchronized (SingletonConnectivityReceiver.this) {
                    arrayList = new ArrayList<>(SingletonConnectivityReceiver.this.listeners);
                }
                for (ConnectivityMonitor.ConnectivityListener onConnectivityChanged : arrayList) {
                    onConnectivityChanged.onConnectivityChanged(z);
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 24) {
            frameworkConnectivityMonitor2 = new FrameworkConnectivityMonitorPostApi24(memorize, r1);
        } else {
            frameworkConnectivityMonitor2 = new FrameworkConnectivityMonitorPreApi24(context, memorize, r1);
        }
        this.frameworkConnectivityMonitor = frameworkConnectivityMonitor2;
    }

    /* access modifiers changed from: package-private */
    public synchronized void register(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.add(connectivityListener);
        maybeRegisterReceiver();
    }

    /* access modifiers changed from: package-private */
    public synchronized void unregister(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.remove(connectivityListener);
        maybeUnregisterReceiver();
    }

    private void maybeRegisterReceiver() {
        if (!this.isRegistered && !this.listeners.isEmpty()) {
            this.isRegistered = this.frameworkConnectivityMonitor.register();
        }
    }

    private void maybeUnregisterReceiver() {
        if (this.isRegistered && this.listeners.isEmpty()) {
            this.frameworkConnectivityMonitor.unregister();
            this.isRegistered = false;
        }
    }

    private static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        boolean isConnected;
        final ConnectivityMonitor.ConnectivityListener listener;
        private final ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                postOnConnectivityChange(true);
            }

            public void onLost(Network network) {
                postOnConnectivityChange(false);
            }

            private void postOnConnectivityChange(final boolean z) {
                Util.postOnUiThread(new Runnable() {
                    public void run() {
                        AnonymousClass1.this.onConnectivityChange(z);
                    }
                });
            }

            /* access modifiers changed from: package-private */
            public void onConnectivityChange(boolean z) {
                Util.assertMainThread();
                boolean z2 = FrameworkConnectivityMonitorPostApi24.this.isConnected;
                FrameworkConnectivityMonitorPostApi24.this.isConnected = z;
                if (z2 != z) {
                    FrameworkConnectivityMonitorPostApi24.this.listener.onConnectivityChanged(z);
                }
            }
        };

        FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        public boolean register() {
            this.isConnected = this.connectivityManager.get().getActiveNetwork() != null;
            try {
                this.connectivityManager.get().registerDefaultNetworkCallback(this.networkCallback);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to register callback", e);
                }
                return false;
            }
        }

        public void unregister() {
            this.connectivityManager.get().unregisterNetworkCallback(this.networkCallback);
        }
    }

    private static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        private final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                boolean z = FrameworkConnectivityMonitorPreApi24.this.isConnected;
                FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                if (z != FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                    if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 3)) {
                        Log.d(SingletonConnectivityReceiver.TAG, "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.isConnected);
                    }
                    FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(FrameworkConnectivityMonitorPreApi24.this.isConnected);
                }
            }
        };
        private final Context context;
        boolean isConnected;
        final ConnectivityMonitor.ConnectivityListener listener;

        FrameworkConnectivityMonitorPreApi24(Context context2, GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.context = context2.getApplicationContext();
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        public boolean register() {
            this.isConnected = isConnected();
            try {
                this.context.registerReceiver(this.connectivityReceiver, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                return true;
            } catch (SecurityException e) {
                if (!Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    return false;
                }
                Log.w(SingletonConnectivityReceiver.TAG, "Failed to register", e);
                return false;
            }
        }

        public void unregister() {
            this.context.unregisterReceiver(this.connectivityReceiver);
        }

        /* access modifiers changed from: package-private */
        public boolean isConnected() {
            try {
                NetworkInfo activeNetworkInfo = this.connectivityManager.get().getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }
    }
}
