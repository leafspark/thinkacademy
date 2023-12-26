package com.tal.app.thinkacademy.common.location.listener;

import android.location.Location;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J$\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/location/listener/SimpleLocationListener;", "", "locationResult", "", "result", "", "updateGPSProviderStatus", "gpsStatus", "", "updateLocation", "location", "Landroid/location/Location;", "updateStatus", "provider", "", "status", "extras", "Landroid/os/Bundle;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleLocationListener.kt */
public interface SimpleLocationListener {
    void locationResult(boolean z);

    void updateGPSProviderStatus(int i);

    void updateLocation(Location location);

    void updateStatus(String str, int i, Bundle bundle);
}
