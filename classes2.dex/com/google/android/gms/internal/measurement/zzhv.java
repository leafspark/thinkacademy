package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzhv implements zzhe {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzhv zza(Context context, String str) {
        zzhv zzhv;
        if (!zzgw.zza()) {
            synchronized (zzhv.class) {
                zzhv = (zzhv) zza.get((Object) null);
                if (zzhv == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzhv;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzhv.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                zzhv zzhv = (zzhv) it.next();
                SharedPreferences sharedPreferences = zzhv.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = zzhv.zzc;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
