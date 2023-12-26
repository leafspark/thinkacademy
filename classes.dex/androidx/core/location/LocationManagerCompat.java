package androidx.core.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

    public static boolean isLocationEnabled(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                if (sContextField == null) {
                    Field declaredField = LocationManager.class.getDeclaredField("mContext");
                    sContextField = declaredField;
                    declaredField.setAccessible(true);
                }
                Context context = (Context) sContextField.get(locationManager);
                if (context != null) {
                    if (Build.VERSION.SDK_INT != 19) {
                        return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
                    }
                    if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0) {
                        return true;
                    }
                    return false;
                }
            } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
            }
        }
        if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    public static void getCurrentLocation(LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, final Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        final Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null || SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) >= MAX_CURRENT_LOCATION_AGE_MS) {
            final CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0, 0.0f, cancellableLocationListener, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                    public void onCancel() {
                        CancellableLocationListener.this.cancel();
                    }
                });
            }
            cancellableLocationListener.startTimeout(GET_CURRENT_LOCATION_TIMEOUT_MS);
            return;
        }
        executor.execute(new Runnable() {
            public void run() {
                Consumer.this.accept(lastKnownLocation);
            }
        });
    }

    public static String getGnssHardwareModelName(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback, Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, (Executor) new InlineHandlerExecutor(handler), callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c5, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d0, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00da */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x012b A[SYNTHETIC, Splitter:B:103:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x010c A[Catch:{ ExecutionException -> 0x0102, TimeoutException -> 0x00e9, all -> 0x00e6, all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0121 A[Catch:{ ExecutionException -> 0x0102, TimeoutException -> 0x00e9, all -> 0x00e6, all -> 0x0128 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean registerGnssStatusCallback(final android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 0
            r3 = 30
            if (r0 < r3) goto L_0x0028
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r0 = sGnssStatusListeners
            monitor-enter(r0)
            java.lang.Object r10 = r0.get(r12)     // Catch:{ all -> 0x0025 }
            androidx.core.location.LocationManagerCompat$GnssStatusTransport r10 = (androidx.core.location.LocationManagerCompat.GnssStatusTransport) r10     // Catch:{ all -> 0x0025 }
            if (r10 != 0) goto L_0x0018
            androidx.core.location.LocationManagerCompat$GnssStatusTransport r10 = new androidx.core.location.LocationManagerCompat$GnssStatusTransport     // Catch:{ all -> 0x0025 }
            r10.<init>(r12)     // Catch:{ all -> 0x0025 }
        L_0x0018:
            boolean r9 = r9.registerGnssStatusCallback(r11, r10)     // Catch:{ all -> 0x0025 }
            if (r9 == 0) goto L_0x0023
            r0.put(r12, r10)     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return r1
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return r2
        L_0x0025:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r9
        L_0x0028:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r0 < r3) goto L_0x005d
            if (r10 == 0) goto L_0x0032
            r0 = r1
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            androidx.core.util.Preconditions.checkArgument(r0)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r0 = sGnssStatusListeners
            monitor-enter(r0)
            java.lang.Object r3 = r0.get(r12)     // Catch:{ all -> 0x005a }
            androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport r3 = (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport) r3     // Catch:{ all -> 0x005a }
            if (r3 != 0) goto L_0x0047
            androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport r3 = new androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport     // Catch:{ all -> 0x005a }
            r3.<init>(r12)     // Catch:{ all -> 0x005a }
            goto L_0x004a
        L_0x0047:
            r3.unregister()     // Catch:{ all -> 0x005a }
        L_0x004a:
            r3.register(r11)     // Catch:{ all -> 0x005a }
            boolean r9 = r9.registerGnssStatusCallback(r3, r10)     // Catch:{ all -> 0x005a }
            if (r9 == 0) goto L_0x0058
            r0.put(r12, r3)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r1
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return r2
        L_0x005a:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r9
        L_0x005d:
            if (r10 == 0) goto L_0x0061
            r0 = r1
            goto L_0x0062
        L_0x0061:
            r0 = r2
        L_0x0062:
            androidx.core.util.Preconditions.checkArgument(r0)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r0 = sGnssStatusListeners
            monitor-enter(r0)
            java.lang.Object r3 = r0.get(r12)     // Catch:{ all -> 0x014a }
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) r3     // Catch:{ all -> 0x014a }
            if (r3 != 0) goto L_0x0076
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = new androidx.core.location.LocationManagerCompat$GpsStatusTransport     // Catch:{ all -> 0x014a }
            r3.<init>(r9, r12)     // Catch:{ all -> 0x014a }
            goto L_0x0079
        L_0x0076:
            r3.unregister()     // Catch:{ all -> 0x014a }
        L_0x0079:
            r3.register(r11)     // Catch:{ all -> 0x014a }
            java.util.concurrent.FutureTask r11 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x014a }
            androidx.core.location.LocationManagerCompat$3 r4 = new androidx.core.location.LocationManagerCompat$3     // Catch:{ all -> 0x014a }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x014a }
            r11.<init>(r4)     // Catch:{ all -> 0x014a }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ all -> 0x014a }
            android.os.Looper r4 = r10.getLooper()     // Catch:{ all -> 0x014a }
            if (r9 != r4) goto L_0x0094
            r11.run()     // Catch:{ all -> 0x014a }
            goto L_0x009a
        L_0x0094:
            boolean r9 = r10.post(r11)     // Catch:{ all -> 0x014a }
            if (r9 == 0) goto L_0x0133
        L_0x009a:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x0102, TimeoutException -> 0x00e9, all -> 0x00e6 }
            r4 = 5
            long r4 = r9.toNanos(r4)     // Catch:{ ExecutionException -> 0x0102, TimeoutException -> 0x00e9, all -> 0x00e6 }
            long r6 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x0102, TimeoutException -> 0x00e9, all -> 0x00e6 }
            long r6 = r6 + r4
            r9 = r2
        L_0x00a8:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x00da, ExecutionException -> 0x00d7, TimeoutException -> 0x00d4, all -> 0x00d1 }
            java.lang.Object r4 = r11.get(r4, r8)     // Catch:{ InterruptedException -> 0x00da, ExecutionException -> 0x00d7, TimeoutException -> 0x00d4, all -> 0x00d1 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InterruptedException -> 0x00da, ExecutionException -> 0x00d7, TimeoutException -> 0x00d4, all -> 0x00d1 }
            boolean r4 = r4.booleanValue()     // Catch:{ InterruptedException -> 0x00da, ExecutionException -> 0x00d7, TimeoutException -> 0x00d4, all -> 0x00d1 }
            if (r4 == 0) goto L_0x00c6
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r4 = sGnssStatusListeners     // Catch:{ InterruptedException -> 0x00da, ExecutionException -> 0x00d7, TimeoutException -> 0x00d4, all -> 0x00d1 }
            r4.put(r12, r3)     // Catch:{ InterruptedException -> 0x00da, ExecutionException -> 0x00d7, TimeoutException -> 0x00d4, all -> 0x00d1 }
            if (r9 == 0) goto L_0x00c4
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x014a }
            r9.interrupt()     // Catch:{ all -> 0x014a }
        L_0x00c4:
            monitor-exit(r0)     // Catch:{ all -> 0x014a }
            return r1
        L_0x00c6:
            if (r9 == 0) goto L_0x00cf
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x014a }
            r9.interrupt()     // Catch:{ all -> 0x014a }
        L_0x00cf:
            monitor-exit(r0)     // Catch:{ all -> 0x014a }
            return r2
        L_0x00d1:
            r10 = move-exception
            r1 = r9
            goto L_0x0129
        L_0x00d4:
            r11 = move-exception
            r1 = r9
            goto L_0x00eb
        L_0x00d7:
            r10 = move-exception
            r1 = r9
            goto L_0x0104
        L_0x00da:
            long r4 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00e4, TimeoutException -> 0x00e2 }
            long r4 = r6 - r4
            r9 = r1
            goto L_0x00a8
        L_0x00e2:
            r11 = move-exception
            goto L_0x00eb
        L_0x00e4:
            r10 = move-exception
            goto L_0x0104
        L_0x00e6:
            r10 = move-exception
            r1 = r2
            goto L_0x0129
        L_0x00e9:
            r11 = move-exception
            r1 = r2
        L_0x00eb:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0128 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r12.<init>()     // Catch:{ all -> 0x0128 }
            r12.append(r10)     // Catch:{ all -> 0x0128 }
            java.lang.String r10 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread"
            r12.append(r10)     // Catch:{ all -> 0x0128 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x0128 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0128 }
            throw r9     // Catch:{ all -> 0x0128 }
        L_0x0102:
            r10 = move-exception
            r1 = r2
        L_0x0104:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0128 }
            boolean r9 = r9 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x0128 }
            if (r9 != 0) goto L_0x0121
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0128 }
            boolean r9 = r9 instanceof java.lang.Error     // Catch:{ all -> 0x0128 }
            if (r9 == 0) goto L_0x011b
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0128 }
            java.lang.Error r9 = (java.lang.Error) r9     // Catch:{ all -> 0x0128 }
            throw r9     // Catch:{ all -> 0x0128 }
        L_0x011b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0128 }
            r9.<init>(r10)     // Catch:{ all -> 0x0128 }
            throw r9     // Catch:{ all -> 0x0128 }
        L_0x0121:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x0128 }
            java.lang.RuntimeException r9 = (java.lang.RuntimeException) r9     // Catch:{ all -> 0x0128 }
            throw r9     // Catch:{ all -> 0x0128 }
        L_0x0128:
            r10 = move-exception
        L_0x0129:
            if (r1 == 0) goto L_0x0132
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x014a }
            r9.interrupt()     // Catch:{ all -> 0x014a }
        L_0x0132:
            throw r10     // Catch:{ all -> 0x014a }
        L_0x0133:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x014a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r11.<init>()     // Catch:{ all -> 0x014a }
            r11.append(r10)     // Catch:{ all -> 0x014a }
            java.lang.String r10 = " is shutting down"
            r11.append(r10)     // Catch:{ all -> 0x014a }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x014a }
            r9.<init>(r10)     // Catch:{ all -> 0x014a }
            throw r9     // Catch:{ all -> 0x014a }
        L_0x014a:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x014a }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.registerGnssStatusCallback(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    public static void unregisterGnssStatusCallback(LocationManager locationManager, GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            SimpleArrayMap<Object, Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.remove(callback);
                if (gnssStatusTransport != null) {
                    locationManager.unregisterGnssStatusCallback(gnssStatusTransport);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap2.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
        } else {
            SimpleArrayMap<Object, Object> simpleArrayMap3 = sGnssStatusListeners;
            synchronized (simpleArrayMap3) {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap3.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.unregister();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            }
        }
    }

    private LocationManagerCompat() {
    }

    private static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void onStarted() {
            this.mCallback.onStarted();
        }

        public void onStopped() {
            this.mCallback.onStopped();
        }

        public void onFirstFix(int i) {
            this.mCallback.onFirstFix(i);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }
    }

    private static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        public void register(Executor executor) {
            boolean z = true;
            Preconditions.checkArgument(executor != null, "invalid null executor");
            if (this.mExecutor != null) {
                z = false;
            }
            Preconditions.checkState(z);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }

        public void onStarted() {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onStarted();
                        }
                    }
                });
            }
        }

        public void onStopped() {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onStopped();
                        }
                    }
                });
            }
        }

        public void onFirstFix(final int i) {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onFirstFix(i);
                        }
                    }
                });
            }
        }

        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new Runnable() {
                    public void run() {
                        if (PreRGnssStatusTransport.this.mExecutor == executor) {
                            PreRGnssStatusTransport.this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
                        }
                    }
                });
            }
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        public void register(Executor executor) {
            Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }

        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            final Executor executor = this.mExecutor;
            if (executor != null) {
                if (i == 1) {
                    executor.execute(new Runnable() {
                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onStarted();
                            }
                        }
                    });
                } else if (i == 2) {
                    executor.execute(new Runnable() {
                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onStopped();
                            }
                        }
                    });
                } else if (i == 3) {
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                        executor.execute(new Runnable() {
                            public void run() {
                                if (GpsStatusTransport.this.mExecutor == executor) {
                                    GpsStatusTransport.this.mCallback.onFirstFix(timeToFirstFix);
                                }
                            }
                        });
                    }
                } else if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus((GpsStatus) null)) != null) {
                    final GnssStatusCompat wrap = GnssStatusCompat.wrap(gpsStatus);
                    executor.execute(new Runnable() {
                        public void run() {
                            if (GpsStatusTransport.this.mExecutor == executor) {
                                GpsStatusTransport.this.mCallback.onSatelliteStatusChanged(wrap);
                            }
                        }
                    });
                }
            }
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static void getCurrentLocation(LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, final Consumer<Location> consumer) {
            locationManager.getCurrentLocation(str, cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, executor, new java.util.function.Consumer<Location>() {
                public void accept(Location location) {
                    Consumer.this.accept(location);
                }
            });
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }

        static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }
    }

    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        public void cancel() {
            synchronized (this) {
                if (!this.mTriggered) {
                    this.mTriggered = true;
                    cleanup();
                }
            }
        }

        public void startTimeout(long j) {
            synchronized (this) {
                if (!this.mTriggered) {
                    AnonymousClass1 r0 = new Runnable() {
                        public void run() {
                            CancellableLocationListener.this.mTimeoutRunnable = null;
                            CancellableLocationListener.this.onLocationChanged((Location) null);
                        }
                    };
                    this.mTimeoutRunnable = r0;
                    this.mTimeoutHandler.postDelayed(r0, j);
                }
            }
        }

        public void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        public void onLocationChanged(final Location location) {
            synchronized (this) {
                if (!this.mTriggered) {
                    this.mTriggered = true;
                    final Consumer<Location> consumer = this.mConsumer;
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            consumer.accept(location);
                        }
                    });
                    cleanup();
                }
            }
        }

        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }
}
