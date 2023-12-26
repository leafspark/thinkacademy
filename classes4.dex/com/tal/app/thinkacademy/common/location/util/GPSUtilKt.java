package com.tal.app.thinkacademy.common.location.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"openGPS", "", "cxt", "Landroid/content/Context;", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GPSUtil.kt */
public final class GPSUtilKt {
    public static final void openGPS(Context context) {
        if (context != null && Build.VERSION.SDK_INT > 15) {
            try {
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }
}
