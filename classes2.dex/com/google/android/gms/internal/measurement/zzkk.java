package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
public class zzkk {
    private static final zzjj zzb = zzjj.zza();
    protected volatile zzlc zza;
    private volatile zzix zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkk)) {
            return false;
        }
        zzkk zzkk = (zzkk) obj;
        zzlc zzlc = this.zza;
        zzlc zzlc2 = zzkk.zza;
        if (zzlc == null && zzlc2 == null) {
            return zzb().equals(zzkk.zzb());
        }
        if (zzlc != null && zzlc2 != null) {
            return zzlc.equals(zzlc2);
        }
        if (zzlc != null) {
            zzkk.zzc(zzlc.zzbJ());
            return zzlc.equals(zzkk.zza);
        }
        zzc(zzlc2.zzbJ());
        return this.zza.equals(zzlc2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zziv) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbr();
        }
        return 0;
    }

    public final zzix zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzix zzix = this.zzc;
                return zzix;
            }
            if (this.zza == null) {
                this.zzc = zzix.zzb;
            } else {
                this.zzc = this.zza.zzbn();
            }
            zzix zzix2 = this.zzc;
            return zzix2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.measurement.zzlc r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzlc r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzlc r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzkh -> 0x0011 }
            com.google.android.gms.internal.measurement.zzix r0 = com.google.android.gms.internal.measurement.zzix.zzb     // Catch:{ zzkh -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzkh -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.measurement.zzix r2 = com.google.android.gms.internal.measurement.zzix.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkk.zzc(com.google.android.gms.internal.measurement.zzlc):void");
    }
}
