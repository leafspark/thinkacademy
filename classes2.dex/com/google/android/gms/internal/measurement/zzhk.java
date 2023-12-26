package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzhk {
    private static final ArrayMap zza = new ArrayMap();

    public static synchronized Uri zza(String str) {
        Uri uri;
        synchronized (zzhk.class) {
            ArrayMap arrayMap = zza;
            uri = (Uri) arrayMap.get("com.google.android.gms.measurement");
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
                uri = Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
                arrayMap.put("com.google.android.gms.measurement", uri);
            }
        }
        return uri;
    }
}
