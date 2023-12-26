package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzjx;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
public class zzjt<MessageType extends zzjx<MessageType, BuilderType>, BuilderType extends zzjt<MessageType, BuilderType>> extends zzig<MessageType, BuilderType> {
    protected zzjx zza;
    protected boolean zzb = false;
    private final zzjx zzc;

    protected zzjt(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzjx) messagetype.zzl(4, (Object) null, (Object) null);
    }

    private static final void zza(zzjx zzjx, zzjx zzjx2) {
        zzlk.zza().zzb(zzjx.getClass()).zzg(zzjx, zzjx2);
    }

    /* access modifiers changed from: protected */
    public void zzaC() {
        zzjx zzjx = (zzjx) this.zza.zzl(4, (Object) null, (Object) null);
        zza(zzjx, this.zza);
        this.zza = zzjx;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzig zzap(zzih zzih) {
        zzaw((zzjx) zzih);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzig zzaq(byte[] bArr, int i, int i2) throws zzkh {
        zzax(bArr, 0, i2, zzjj.zza());
        return this;
    }

    public final /* bridge */ /* synthetic */ zzig zzar(byte[] bArr, int i, int i2, zzjj zzjj) throws zzkh {
        zzax(bArr, 0, i2, zzjj);
        return this;
    }

    /* renamed from: zzav */
    public final zzjt zzao() {
        zzjt zzjt = (zzjt) this.zzc.zzl(5, (Object) null, (Object) null);
        zzjt.zzaw(zzaA());
        return zzjt;
    }

    public final zzjt zzaw(zzjx zzjx) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zza(this.zza, zzjx);
        return this;
    }

    public final zzjt zzax(byte[] bArr, int i, int i2, zzjj zzjj) throws zzkh {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        try {
            zzlk.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zzik(zzjj));
            return this;
        } catch (zzkh e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzkh.zzf();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r3 != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType zzay() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzjx r0 = r5.zzaA()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0015
            goto L_0x0032
        L_0x0015:
            if (r3 == 0) goto L_0x0033
            com.google.android.gms.internal.measurement.zzlk r3 = com.google.android.gms.internal.measurement.zzlk.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.zzln r3 = r3.zzb(r4)
            boolean r3 = r3.zzj(r0)
            if (r1 == r3) goto L_0x002b
            r1 = r2
            goto L_0x002c
        L_0x002b:
            r1 = r0
        L_0x002c:
            r4 = 2
            r0.zzl(r4, r1, r2)
            if (r3 == 0) goto L_0x0033
        L_0x0032:
            return r0
        L_0x0033:
            com.google.android.gms.internal.measurement.zzma r1 = new com.google.android.gms.internal.measurement.zzma
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjt.zzay():com.google.android.gms.internal.measurement.zzjx");
    }

    /* renamed from: zzaz */
    public MessageType zzaA() {
        if (this.zzb) {
            return this.zza;
        }
        zzjx zzjx = this.zza;
        zzlk.zza().zzb(zzjx.getClass()).zzf(zzjx);
        this.zzb = true;
        return this.zza;
    }

    public final /* synthetic */ zzlc zzbJ() {
        return this.zzc;
    }
}
