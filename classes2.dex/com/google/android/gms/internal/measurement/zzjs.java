package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zzjs implements zzla {
    private static final zzjs zza = new zzjs();

    private zzjs() {
    }

    public static zzjs zza() {
        return zza;
    }

    public final zzkz zzb(Class cls) {
        if (!zzjx.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzkz) zzjx.zzbu(cls.asSubclass(zzjx.class)).zzl(3, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }

    public final boolean zzc(Class cls) {
        return zzjx.class.isAssignableFrom(cls);
    }
}
