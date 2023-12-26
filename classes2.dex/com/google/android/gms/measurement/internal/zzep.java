package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.igexin.sdk.PushConsts;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzep extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.measurement.internal.zzep";
    /* access modifiers changed from: private */
    public final zzkp zzb;
    private boolean zzc;
    private boolean zzd;

    zzep(zzkp zzkp) {
        Preconditions.checkNotNull(zzkp);
        this.zzb = zzkp;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzB();
        String action = intent.getAction();
        this.zzb.zzay().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
            boolean zza2 = this.zzb.zzl().zza();
            if (this.zzd != zza2) {
                this.zzd = zza2;
                this.zzb.zzaz().zzp(new zzeo(this, zza2));
                return;
            }
            return;
        }
        this.zzb.zzay().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zzb() {
        this.zzb.zzB();
        this.zzb.zzaz().zzg();
        if (!this.zzc) {
            this.zzb.zzau().registerReceiver(this, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
            this.zzd = this.zzb.zzl().zza();
            this.zzb.zzay().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    public final void zzc() {
        this.zzb.zzB();
        this.zzb.zzaz().zzg();
        this.zzb.zzaz().zzg();
        if (this.zzc) {
            this.zzb.zzay().zzj().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzau().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzay().zzd().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
