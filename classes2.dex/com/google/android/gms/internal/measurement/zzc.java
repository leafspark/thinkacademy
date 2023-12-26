package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzc {
    final zzf zza;
    zzg zzb;
    final zzab zzc = new zzab();
    private final zzz zzd = new zzz();

    public zzc() {
        zzf zzf = new zzf();
        this.zza = zzf;
        this.zzb = zzf.zzb.zza();
        zzf.zzd.zza("internal.registerCallback", new zza(this));
        zzf.zzd.zza("internal.eventLogger", new zzb(this));
    }

    public final zzab zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzai zzb() throws Exception {
        return new zzv(this.zzd);
    }

    public final void zzc(zzgo zzgo) throws zzd {
        zzai zzai;
        try {
            this.zzb = this.zza.zzb.zza();
            if (!(this.zza.zza(this.zzb, (zzgt[]) zzgo.zzc().toArray(new zzgt[0])) instanceof zzag)) {
                for (zzgm zzgm : zzgo.zza().zzd()) {
                    List zzc2 = zzgm.zzc();
                    String zzb2 = zzgm.zzb();
                    Iterator it = zzc2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            zzap zza2 = this.zza.zza(this.zzb, (zzgt) it.next());
                            if (zza2 instanceof zzam) {
                                zzg zzg = this.zzb;
                                if (!zzg.zzh(zzb2)) {
                                    zzai = null;
                                } else {
                                    zzap zzd2 = zzg.zzd(zzb2);
                                    if (!(zzd2 instanceof zzai)) {
                                        String valueOf = String.valueOf(zzb2);
                                        throw new IllegalStateException(valueOf.length() != 0 ? "Invalid function name: ".concat(valueOf) : new String("Invalid function name: "));
                                    }
                                    zzai = (zzai) zzd2;
                                }
                                if (zzai == null) {
                                    String valueOf2 = String.valueOf(zzb2);
                                    throw new IllegalStateException(valueOf2.length() != 0 ? "Rule function is undefined: ".concat(valueOf2) : new String("Rule function is undefined: "));
                                }
                                zzai.zza(this.zzb, Collections.singletonList(zza2));
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void zzd(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zze(zzaa zzaa) throws zzd {
        try {
            this.zzc.zzd(zzaa);
            this.zza.zzc.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.zzd.zzb(this.zzb.zza(), this.zzc);
            return zzg() || zzf();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzf() {
        return !this.zzc.zzc().isEmpty();
    }

    public final boolean zzg() {
        zzab zzab = this.zzc;
        return !zzab.zzb().equals(zzab.zza());
    }
}
