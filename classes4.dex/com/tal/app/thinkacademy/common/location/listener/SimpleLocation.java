package com.tal.app.thinkacademy.common.location.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.tal.app.thinkacademy.common.location.GPSProviderStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocation;", "Landroid/location/LocationListener;", "mSimpleLocationListener", "Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocationListener;", "(Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocationListener;)V", "locationResult", "", "result", "", "onDestroy", "onLocationChanged", "location", "Landroid/location/Location;", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "Landroid/os/Bundle;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleLocation.kt */
public final class SimpleLocation implements LocationListener {
    private SimpleLocationListener mSimpleLocationListener;

    public SimpleLocation(SimpleLocationListener simpleLocationListener) {
        this.mSimpleLocationListener = simpleLocationListener;
    }

    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        SimpleLocationListener simpleLocationListener = this.mSimpleLocationListener;
        if (simpleLocationListener != null) {
            simpleLocationListener.updateLocation(location);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        SimpleLocationListener simpleLocationListener = this.mSimpleLocationListener;
        if (simpleLocationListener != null) {
            simpleLocationListener.updateStatus(str, i, bundle);
            if (i == 0) {
                simpleLocationListener.updateGPSProviderStatus(GPSProviderStatus.INSTANCE.getGPS_OUT_OF_SERVICE());
            } else if (i == 1) {
                simpleLocationListener.updateGPSProviderStatus(GPSProviderStatus.INSTANCE.getGPS_TEMPORARILY_UNAVAILABLE());
            } else if (i == 2) {
                simpleLocationListener.updateGPSProviderStatus(GPSProviderStatus.INSTANCE.getGPS_AVAILABLE());
            }
        }
    }

    public void onProviderEnabled(String str) {
        Intrinsics.checkNotNullParameter(str, "provider");
        SimpleLocationListener simpleLocationListener = this.mSimpleLocationListener;
        if (simpleLocationListener != null) {
            simpleLocationListener.updateGPSProviderStatus(GPSProviderStatus.INSTANCE.getGPS_ENABLED());
        }
    }

    public void onProviderDisabled(String str) {
        Intrinsics.checkNotNullParameter(str, "provider");
        SimpleLocationListener simpleLocationListener = this.mSimpleLocationListener;
        if (simpleLocationListener != null) {
            simpleLocationListener.updateGPSProviderStatus(GPSProviderStatus.INSTANCE.getGPS_DISABLED());
        }
    }

    public final void locationResult(boolean z) {
        SimpleLocationListener simpleLocationListener = this.mSimpleLocationListener;
        if (simpleLocationListener != null) {
            simpleLocationListener.locationResult(z);
        }
    }

    public final void onDestroy() {
        this.mSimpleLocationListener = null;
    }
}
