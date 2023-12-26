package com.tal.app.thinkacademy.common.location;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/location/GPSProviderStatus;", "", "()V", "GPS_AVAILABLE", "", "getGPS_AVAILABLE", "()I", "GPS_DISABLED", "getGPS_DISABLED", "GPS_ENABLED", "getGPS_ENABLED", "GPS_OUT_OF_SERVICE", "getGPS_OUT_OF_SERVICE", "GPS_TEMPORARILY_UNAVAILABLE", "getGPS_TEMPORARILY_UNAVAILABLE", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GPSProviderStatus.kt */
public final class GPSProviderStatus {
    private static final int GPS_AVAILABLE = 4;
    private static final int GPS_DISABLED = 1;
    private static final int GPS_ENABLED = 0;
    private static final int GPS_OUT_OF_SERVICE = 2;
    private static final int GPS_TEMPORARILY_UNAVAILABLE = 3;
    public static final GPSProviderStatus INSTANCE = new GPSProviderStatus();

    private GPSProviderStatus() {
    }

    public final int getGPS_ENABLED() {
        return GPS_ENABLED;
    }

    public final int getGPS_DISABLED() {
        return GPS_DISABLED;
    }

    public final int getGPS_OUT_OF_SERVICE() {
        return GPS_OUT_OF_SERVICE;
    }

    public final int getGPS_TEMPORARILY_UNAVAILABLE() {
        return GPS_TEMPORARILY_UNAVAILABLE;
    }

    public final int getGPS_AVAILABLE() {
        return GPS_AVAILABLE;
    }
}
