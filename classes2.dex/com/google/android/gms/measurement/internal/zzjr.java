package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzjr {
    private final Context zza;

    public zzjr(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    private final zzeh zzk() {
        return zzfr.zzp(this.zza, (zzcl) null, (Long) null).zzay();
    }

    public final int zza(Intent intent, int i, int i2) {
        zzfr zzp = zzfr.zzp(this.zza, (zzcl) null, (Long) null);
        zzeh zzay = zzp.zzay();
        if (intent == null) {
            zzay.zzk().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzp.zzaw();
        zzay.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzh(new zzjn(this, i2, zzay, intent));
        }
        return 2;
    }

    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgj(zzkp.zzt(this.zza), (String) null);
        }
        zzk().zzk().zzb("onBind received unknown action", action);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(int i, zzeh zzeh, Intent intent) {
        if (((zzjq) this.zza).zzc(i)) {
            zzeh.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzk().zzj().zza("Completed wakeful intent.");
            ((zzjq) this.zza).zza(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzeh zzeh, JobParameters jobParameters) {
        zzeh.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzjq) this.zza).zzb(jobParameters, false);
    }

    public final void zze() {
        zzfr zzp = zzfr.zzp(this.zza, (zzcl) null, (Long) null);
        zzeh zzay = zzp.zzay();
        zzp.zzaw();
        zzay.zzj().zza("Local AppMeasurementService is starting up");
    }

    public final void zzf() {
        zzfr zzp = zzfr.zzp(this.zza, (zzcl) null, (Long) null);
        zzeh zzay = zzp.zzay();
        zzp.zzaw();
        zzay.zzj().zza("Local AppMeasurementService is shutting down");
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onRebind called with null intent");
            return;
        }
        zzk().zzj().zzb("onRebind called. action", intent.getAction());
    }

    public final void zzh(Runnable runnable) {
        zzkp zzt = zzkp.zzt(this.zza);
        zzt.zzaz().zzp(new zzjp(this, zzt, runnable));
    }

    public final boolean zzi(JobParameters jobParameters) {
        zzfr zzp = zzfr.zzp(this.zza, (zzcl) null, (Long) null);
        zzeh zzay = zzp.zzay();
        String string = jobParameters.getExtras().getString("action");
        zzp.zzaw();
        zzay.zzj().zzb("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzh(new zzjo(this, zzay, jobParameters));
        return true;
    }

    public final boolean zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzj().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
