package com.tal.app.thinkacademy.common.location.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a*\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"getAddress", "", "Landroid/location/Address;", "cxt", "Landroid/content/Context;", "loation", "Landroid/location/Location;", "locale", "Ljava/util/Locale;", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationAddress.kt */
public final class LocationAddressKt {
    public static final List<Address> getAddress(Context context, Location location) {
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "ENGLISH");
        return getAddress(context, location, locale);
    }

    public static final List<Address> getAddress(Context context, Location location, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (location == null || context == null) {
            return null;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return null;
            }
            return new Geocoder(applicationContext, locale).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (Exception unused) {
            return null;
        }
    }
}
