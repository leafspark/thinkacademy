package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzih;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
public abstract class zzig<MessageType extends zzih<MessageType, BuilderType>, BuilderType extends zzig<MessageType, BuilderType>> implements zzlb {
    /* renamed from: zzao */
    public abstract zzig clone();

    /* access modifiers changed from: protected */
    public abstract zzig zzap(zzih zzih);

    public zzig zzaq(byte[] bArr, int i, int i2) throws zzkh {
        throw null;
    }

    public zzig zzar(byte[] bArr, int i, int i2, zzjj zzjj) throws zzkh {
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzlb zzas(zzlc zzlc) {
        if (zzbJ().getClass().isInstance(zzlc)) {
            return zzap((zzih) zzlc);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzlb zzat(byte[] bArr) throws zzkh {
        return zzaq(bArr, 0, bArr.length);
    }

    public final /* synthetic */ zzlb zzau(byte[] bArr, zzjj zzjj) throws zzkh {
        return zzar(bArr, 0, bArr.length, zzjj);
    }
}
