package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzhi {
    private final Map zza;

    zzhi(Map map) {
        this.zza = map;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri == null) {
            return null;
        }
        Map map = (Map) this.zza.get(uri.toString());
        if (map == null) {
            return null;
        }
        String valueOf = String.valueOf(str3);
        return (String) map.get(valueOf.length() != 0 ? "".concat(valueOf) : new String(""));
    }
}
