package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzjx;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
public abstract class zzjx<MessageType extends zzjx<MessageType, BuilderType>, BuilderType extends zzjt<MessageType, BuilderType>> extends zzih<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmc zzc = zzmc.zzc();
    protected int zzd = -1;

    static Object zzbC(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzbD(zzlc zzlc, String str, Object[] objArr) {
        return new zzlm(zzlc, str, objArr);
    }

    protected static void zzbE(Class cls, zzjx zzjx) {
        zza.put(cls, zzjx);
    }

    static zzjx zzbu(Class cls) {
        Map map = zza;
        zzjx zzjx = (zzjx) map.get(cls);
        if (zzjx == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzjx = (zzjx) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzjx == null) {
            zzjx = (zzjx) ((zzjx) zzml.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzjx != null) {
                map.put(cls, zzjx);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzjx;
    }

    protected static zzkc zzbv() {
        return zzjy.zzf();
    }

    protected static zzkd zzbw() {
        return zzkr.zzf();
    }

    protected static zzkd zzbx(zzkd zzkd) {
        int size = zzkd.size();
        return zzkd.zze(size == 0 ? 10 : size + size);
    }

    protected static zzke zzby() {
        return zzll.zze();
    }

    protected static zzke zzbz(zzke zzke) {
        int size = zzke.size();
        return zzke.zzd(size == 0 ? 10 : size + size);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlk.zza().zzb(getClass()).zzi(this, (zzjx) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzb = zzlk.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzle.zza(this, super.toString());
    }

    public final /* synthetic */ zzlb zzbA() {
        return (zzjt) zzl(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzlb zzbB() {
        zzjt zzjt = (zzjt) zzl(5, (Object) null, (Object) null);
        zzjt.zzaw(this);
        return zzjt;
    }

    public final void zzbF(zzje zzje) throws IOException {
        zzlk.zza().zzb(getClass()).zzm(this, zzjf.zza(zzje));
    }

    public final /* synthetic */ zzlc zzbJ() {
        return (zzjx) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbm() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzbp(int i) {
        this.zzd = i;
    }

    public final int zzbr() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zza2 = zzlk.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    /* access modifiers changed from: protected */
    public final zzjt zzbs() {
        return (zzjt) zzl(5, (Object) null, (Object) null);
    }

    public final zzjt zzbt() {
        zzjt zzjt = (zzjt) zzl(5, (Object) null, (Object) null);
        zzjt.zzaw(this);
        return zzjt;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i, Object obj, Object obj2);
}
