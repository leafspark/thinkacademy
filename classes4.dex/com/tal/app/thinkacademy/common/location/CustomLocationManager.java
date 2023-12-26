package com.tal.app.thinkacademy.common.location;

import android.content.Context;
import android.location.LocationManager;
import com.tal.app.thinkacademy.common.location.listener.SimpleLocation;
import com.tal.app.thinkacademy.common.location.listener.SimpleLocationListener;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0014J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0016J\u001c\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010$\u001a\u00020\u001aR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/common/location/CustomLocationManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "isForcedLocation", "", "isGpsEnabled", "isNetworkEnabled", "locationManager", "Landroid/location/LocationManager;", "mContext", "Ljava/lang/ref/WeakReference;", "mLocateType", "mMinDistance", "", "mMinTime", "", "mSimpleLocation", "Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocation;", "clear", "", "initLocateType", "onDestroy", "setMinDistance", "minDistance", "setScanSpan", "minTime", "start", "simpleLocationListener", "Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocationListener;", "stop", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomLocationManager.kt */
public final class CustomLocationManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile CustomLocationManager instance;
    private String TAG;
    private final Context context;
    private boolean isForcedLocation;
    private boolean isGpsEnabled;
    private boolean isNetworkEnabled;
    private LocationManager locationManager;
    private WeakReference<Context> mContext;
    private String mLocateType;
    private float mMinDistance;
    private long mMinTime;
    private SimpleLocation mSimpleLocation;

    public /* synthetic */ CustomLocationManager(Context context2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2);
    }

    public final boolean start(SimpleLocationListener simpleLocationListener) {
        return start$default(this, simpleLocationListener, false, 2, (Object) null);
    }

    private CustomLocationManager(Context context2) {
        this.context = context2;
        this.TAG = "CustomLocationManager";
        this.mLocateType = "";
        this.mContext = new WeakReference<>(context2);
        this.isForcedLocation = false;
        this.mMinTime = 1000;
        this.mMinDistance = 0.0f;
    }

    public final Context getContext() {
        return this.context;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/location/CustomLocationManager$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/location/CustomLocationManager;", "getInstance", "context", "Landroid/content/Context;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomLocationManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomLocationManager getInstance(Context context) {
            if (CustomLocationManager.instance == null) {
                synchronized (Reflection.getOrCreateKotlinClass(CustomLocationManager.class)) {
                    if (CustomLocationManager.instance == null) {
                        Companion companion = CustomLocationManager.Companion;
                        CustomLocationManager.instance = new CustomLocationManager(context == null ? null : context.getApplicationContext(), (DefaultConstructorMarker) null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            CustomLocationManager access$getInstance$cp = CustomLocationManager.instance;
            Intrinsics.checkNotNull(access$getInstance$cp);
            return access$getInstance$cp;
        }
    }

    public final void setScanSpan(long j) {
        this.mMinTime = j;
    }

    public final void setMinDistance(float f) {
        this.mMinDistance = f;
    }

    public static /* synthetic */ boolean start$default(CustomLocationManager customLocationManager, SimpleLocationListener simpleLocationListener, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return customLocationManager.start(simpleLocationListener, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00de A[SYNTHETIC, Splitter:B:52:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7 A[SYNTHETIC, Splitter:B:65:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean start(com.tal.app.thinkacademy.common.location.listener.SimpleLocationListener r11, boolean r12) {
        /*
            r10 = this;
            r10.clear()
            java.lang.ref.WeakReference<android.content.Context> r0 = r10.mContext
            r1 = 0
            if (r0 != 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 != 0) goto L_0x001a
        L_0x0011:
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r11 = r10.mSimpleLocation
            if (r11 != 0) goto L_0x0016
            goto L_0x0019
        L_0x0016:
            r11.locationResult(r1)
        L_0x0019:
            return r1
        L_0x001a:
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r2)
            r3 = 1
            if (r2 == 0) goto L_0x003f
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r0, r2)
            if (r2 == 0) goto L_0x003f
            java.lang.String r11 = r10.TAG
            java.lang.Object[] r12 = new java.lang.Object[r3]
            java.lang.String r0 = "权限缺失"
            r12[r1] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r11, r12)
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r11 = r10.mSimpleLocation
            if (r11 != 0) goto L_0x003b
            goto L_0x003e
        L_0x003b:
            r11.locationResult(r1)
        L_0x003e:
            return r1
        L_0x003f:
            r10.isForcedLocation = r12
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r2 = new com.tal.app.thinkacademy.common.location.listener.SimpleLocation
            r2.<init>(r11)
            r10.mSimpleLocation = r2
            java.lang.String r11 = "location"
            java.lang.Object r11 = r0.getSystemService(r11)
            boolean r2 = r11 instanceof android.location.LocationManager
            r4 = 0
            if (r2 == 0) goto L_0x0056
            android.location.LocationManager r11 = (android.location.LocationManager) r11
            goto L_0x0057
        L_0x0056:
            r11 = r4
        L_0x0057:
            r10.locationManager = r11
            if (r11 != 0) goto L_0x005d
            r11 = r1
            goto L_0x0063
        L_0x005d:
            java.lang.String r2 = "gps"
            boolean r11 = r11.isProviderEnabled(r2)
        L_0x0063:
            r10.isGpsEnabled = r11
            android.location.LocationManager r11 = r10.locationManager
            java.lang.String r2 = "network"
            if (r11 != 0) goto L_0x006d
            r11 = r1
            goto L_0x0071
        L_0x006d:
            boolean r11 = r11.isProviderEnabled(r2)
        L_0x0071:
            r10.isNetworkEnabled = r11
            java.lang.String r11 = r10.TAG
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isForcedLocation="
            r6.append(r7)
            boolean r7 = r10.isForcedLocation
            r6.append(r7)
            java.lang.String r7 = " --- isGpsEnabled="
            r6.append(r7)
            boolean r7 = r10.isGpsEnabled
            r6.append(r7)
            java.lang.String r7 = " --- isNetworkEnabled="
            r6.append(r7)
            boolean r7 = r10.isNetworkEnabled
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5[r1] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r11, r5)
            if (r12 == 0) goto L_0x00b9
            boolean r11 = r10.isGpsEnabled
            if (r11 != 0) goto L_0x00b9
            boolean r11 = r10.isNetworkEnabled
            if (r11 != 0) goto L_0x00b9
            com.tal.app.thinkacademy.common.location.util.GPSUtilKt.openGPS(r0)
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r11 = r10.mSimpleLocation
            if (r11 != 0) goto L_0x00b5
            goto L_0x00b8
        L_0x00b5:
            r11.locationResult(r1)
        L_0x00b8:
            return r1
        L_0x00b9:
            r10.initLocateType()
            java.lang.String r11 = r10.mLocateType
            java.lang.String r12 = "unknown"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r12)
            if (r11 == 0) goto L_0x00cf
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r11 = r10.mSimpleLocation
            if (r11 != 0) goto L_0x00cb
            goto L_0x00ce
        L_0x00cb:
            r11.locationResult(r1)
        L_0x00ce:
            return r1
        L_0x00cf:
            android.location.LocationManager r11 = r10.locationManager     // Catch:{ Exception -> 0x00db }
            if (r11 != 0) goto L_0x00d4
            goto L_0x00db
        L_0x00d4:
            java.lang.String r12 = r10.mLocateType     // Catch:{ Exception -> 0x00db }
            android.location.Location r11 = r11.getLastKnownLocation(r12)     // Catch:{ Exception -> 0x00db }
            goto L_0x00dc
        L_0x00db:
            r11 = r4
        L_0x00dc:
            if (r11 != 0) goto L_0x00e8
            android.location.LocationManager r12 = r10.locationManager     // Catch:{ Exception -> 0x00e8 }
            if (r12 != 0) goto L_0x00e3
            goto L_0x00e7
        L_0x00e3:
            android.location.Location r4 = r12.getLastKnownLocation(r2)     // Catch:{ Exception -> 0x00e8 }
        L_0x00e7:
            r11 = r4
        L_0x00e8:
            if (r11 == 0) goto L_0x00f2
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r12 = r10.mSimpleLocation
            if (r12 != 0) goto L_0x00ef
            goto L_0x00f2
        L_0x00ef:
            r12.onLocationChanged(r11)
        L_0x00f2:
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r11 = r10.mSimpleLocation
            if (r11 != 0) goto L_0x00f7
            goto L_0x010d
        L_0x00f7:
            android.location.LocationManager r4 = r10.locationManager     // Catch:{ Exception -> 0x010b }
            if (r4 != 0) goto L_0x00fc
            goto L_0x010d
        L_0x00fc:
            java.lang.String r5 = r10.mLocateType     // Catch:{ Exception -> 0x010b }
            long r6 = r10.mMinTime     // Catch:{ Exception -> 0x010b }
            float r8 = r10.mMinDistance     // Catch:{ Exception -> 0x010b }
            r9 = r11
            android.location.LocationListener r9 = (android.location.LocationListener) r9     // Catch:{ Exception -> 0x010b }
            r4.requestLocationUpdates(r5, r6, r8, r9)     // Catch:{ Exception -> 0x010b }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x010b }
            goto L_0x010d
        L_0x010b:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L_0x010d:
            com.tal.app.thinkacademy.common.location.listener.SimpleLocation r11 = r10.mSimpleLocation
            if (r11 != 0) goto L_0x0112
            goto L_0x0115
        L_0x0112:
            r11.locationResult(r3)
        L_0x0115:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.location.CustomLocationManager.start(com.tal.app.thinkacademy.common.location.listener.SimpleLocationListener, boolean):boolean");
    }

    public final void stop() {
        try {
            SimpleLocation simpleLocation = this.mSimpleLocation;
            if (simpleLocation != null) {
                LocationManager locationManager2 = this.locationManager;
                if (locationManager2 != null) {
                    locationManager2.removeUpdates(simpleLocation);
                }
            }
        } catch (Exception e) {
            XesLog.et(this.TAG, Intrinsics.stringPlus("errormsg = ", e.getMessage()));
        }
    }

    private final void clear() {
        stop();
        SimpleLocation simpleLocation = this.mSimpleLocation;
        if (simpleLocation != null) {
            simpleLocation.onDestroy();
        }
        this.mSimpleLocation = null;
        this.locationManager = null;
    }

    public final void onDestroy() {
        stop();
        SimpleLocation simpleLocation = this.mSimpleLocation;
        if (simpleLocation != null) {
            simpleLocation.onDestroy();
        }
        this.mSimpleLocation = null;
        this.locationManager = null;
        this.mContext = null;
        instance = null;
    }

    private final void initLocateType() {
        boolean z;
        boolean z2;
        boolean z3;
        LocationManager locationManager2 = this.locationManager;
        List<String> providers = locationManager2 == null ? null : locationManager2.getProviders(true);
        String str = CustomLocationManagerKt.GPS_LOCATION_NAME;
        if (providers != null && providers.contains(str)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (providers != null && providers.contains(CustomLocationManagerKt.NETWORK_LOCATION_NAME)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = CustomLocationManagerKt.NETWORK_LOCATION_NAME;
            } else {
                if (providers != null && providers.contains(CustomLocationManagerKt.PASSIVE_PROVIDER)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                str = z3 ? CustomLocationManagerKt.PASSIVE_PROVIDER : CustomLocationManagerKt.KUnKnown;
            }
        }
        this.mLocateType = str;
        XesLog.vt(this.TAG, Intrinsics.stringPlus("mLocateType = ", str));
    }
}
