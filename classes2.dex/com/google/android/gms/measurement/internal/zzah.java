package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzah {
    public static final zzah zza = new zzah((Boolean) null, (Boolean) null);
    private final EnumMap zzb;

    public zzah(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(zzag.class);
        this.zzb = enumMap;
        enumMap.put(zzag.AD_STORAGE, bool);
        enumMap.put(zzag.ANALYTICS_STORAGE, bool2);
    }

    public static zzah zza(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        EnumMap enumMap = new EnumMap(zzag.class);
        for (zzag zzag : zzag.values()) {
            enumMap.put(zzag, zzm(bundle.getString(zzag.zzd)));
        }
        return new zzah(enumMap);
    }

    public static zzah zzb(String str) {
        EnumMap enumMap = new EnumMap(zzag.class);
        if (str != null) {
            int i = 0;
            while (true) {
                int length = zzag.zzc.length;
                if (i >= 2) {
                    break;
                }
                zzag zzag = zzag.zzc[i];
                int i2 = i + 2;
                if (i2 < str.length()) {
                    char charAt = str.charAt(i2);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (charAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(zzag, bool);
                }
                i++;
            }
        }
        return new zzah(enumMap);
    }

    public static String zzg(Bundle bundle) {
        String string;
        for (zzag zzag : zzag.values()) {
            if (bundle.containsKey(zzag.zzd) && (string = bundle.getString(zzag.zzd)) != null && zzm(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean zzj(int i, int i2) {
        return i <= i2;
    }

    static final int zzl(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean zzm(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzah = (zzah) obj;
        for (zzag zzag : zzag.values()) {
            if (zzl((Boolean) this.zzb.get(zzag)) != zzl((Boolean) zzah.zzb.get(zzag))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        for (Boolean zzl : this.zzb.values()) {
            i = (i * 31) + zzl(zzl);
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("settings: ");
        zzag[] values = zzag.values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            zzag zzag = values[i];
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(zzag.name());
            sb.append("=");
            Boolean bool = (Boolean) this.zzb.get(zzag);
            if (this.zzb.containsKey(zzag) || bool == null) {
                sb.append("uninitialized");
            } else {
                sb.append(true != bool.booleanValue() ? "denied" : "granted");
            }
        }
        return sb.toString();
    }

    public final zzah zzc(zzah zzah) {
        EnumMap enumMap = new EnumMap(zzag.class);
        for (zzag zzag : zzag.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzag);
            Boolean bool2 = (Boolean) zzah.zzb.get(zzag);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                bool = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
            enumMap.put(zzag, bool);
        }
        return new zzah(enumMap);
    }

    public final zzah zzd(zzah zzah) {
        EnumMap enumMap = new EnumMap(zzag.class);
        for (zzag zzag : zzag.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzag);
            if (bool == null) {
                bool = (Boolean) zzah.zzb.get(zzag);
            }
            enumMap.put(zzag, bool);
        }
        return new zzah(enumMap);
    }

    public final Boolean zze() {
        return (Boolean) this.zzb.get(zzag.AD_STORAGE);
    }

    public final Boolean zzf() {
        return (Boolean) this.zzb.get(zzag.ANALYTICS_STORAGE);
    }

    public final String zzh() {
        char c;
        StringBuilder sb = new StringBuilder("G1");
        zzag[] zzagArr = zzag.zzc;
        int length = zzagArr.length;
        for (int i = 0; i < 2; i++) {
            Boolean bool = (Boolean) this.zzb.get(zzagArr[i]);
            if (bool == null) {
                c = '-';
            } else {
                c = bool.booleanValue() ? '1' : '0';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final boolean zzi(zzag zzag) {
        Boolean bool = (Boolean) this.zzb.get(zzag);
        return bool == null || bool.booleanValue();
    }

    public final boolean zzk(zzah zzah) {
        for (zzag zzag : (zzag[]) this.zzb.keySet().toArray(new zzag[0])) {
            Boolean bool = (Boolean) this.zzb.get(zzag);
            Boolean bool2 = (Boolean) zzah.zzb.get(zzag);
            if (bool == Boolean.FALSE && bool2 != Boolean.FALSE) {
                return true;
            }
        }
        return false;
    }

    public zzah(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzag.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
