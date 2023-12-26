package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.luck.picture.lib.tools.PictureFileUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzee implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeh zzf;

    zzee(zzeh zzeh, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeh;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzew zzm = this.zzf.zzs.zzm();
        if (zzm.zzx()) {
            zzeh zzeh = this.zzf;
            if (zzeh.zza == 0) {
                if (zzeh.zzs.zzf().zzy()) {
                    zzeh zzeh2 = this.zzf;
                    zzeh2.zzs.zzaw();
                    zzeh2.zza = 'C';
                } else {
                    zzeh zzeh3 = this.zzf;
                    zzeh3.zzs.zzaw();
                    zzeh3.zza = 'c';
                }
            }
            zzeh zzeh4 = this.zzf;
            if (zzeh4.zzb < 0) {
                zzeh4.zzs.zzf().zzh();
                zzeh4.zzb = 55005;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzeh zzeh5 = this.zzf;
            char zza2 = zzeh5.zza;
            long zzb2 = zzeh5.zzb;
            String zzo = zzeh.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(zzo.length() + 24);
            sb.append(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW);
            sb.append(charAt);
            sb.append(zza2);
            sb.append(zzb2);
            sb.append(":");
            sb.append(zzo);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, PictureFileUtils.KB);
            }
            zzeu zzeu = zzm.zzb;
            if (zzeu != null) {
                zzeu.zzb(sb2, 1);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
