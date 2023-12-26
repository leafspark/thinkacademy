package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzhv implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhw zza;

    /* synthetic */ zzhv(zzhw zzhw, zzhu zzhu) {
        this.zza = zzhw;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfr zzfr;
        try {
            this.zza.zzs.zzay().zzj().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfr = this.zza.zzs;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzs.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z = false;
                        }
                        this.zza.zzs.zzaz().zzp(new zzht(this, z, data, str, queryParameter));
                        zzfr = this.zza.zzs;
                    }
                }
                zzfr = this.zza.zzs;
            }
        } catch (RuntimeException e) {
            this.zza.zzs.zzay().zzd().zzb("Throwable caught in onActivityCreated", e);
            zzfr = this.zza.zzs;
        } catch (Throwable th) {
            this.zza.zzs.zzs().zzr(activity, bundle);
            throw th;
        }
        zzfr.zzs().zzr(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzs.zzs().zzs(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzs.zzs().zzt(activity);
        zzka zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaz().zzp(new zzjt(zzu, zzu.zzs.zzav().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzka zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaz().zzp(new zzjs(zzu, zzu.zzs.zzav().elapsedRealtime()));
        this.zza.zzs.zzs().zzu(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzs.zzs().zzv(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
