package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zzml {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd = zzij.zza();
    private static final boolean zze;
    private static final zzmk zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0152  */
    static {
        /*
            java.lang.Class<double[]> r0 = double[].class
            java.lang.Class<float[]> r1 = float[].class
            java.lang.Class<long[]> r2 = long[].class
            java.lang.Class<int[]> r3 = int[].class
            java.lang.Class<boolean[]> r4 = boolean[].class
            sun.misc.Unsafe r5 = zzg()
            zzc = r5
            java.lang.Class r6 = com.google.android.gms.internal.measurement.zzij.zza()
            zzd = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzv(r6)
            zze = r6
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzv(r7)
            r8 = 0
            if (r5 != 0) goto L_0x0028
            goto L_0x0037
        L_0x0028:
            if (r6 == 0) goto L_0x0030
            com.google.android.gms.internal.measurement.zzmj r8 = new com.google.android.gms.internal.measurement.zzmj
            r8.<init>(r5)
            goto L_0x0037
        L_0x0030:
            if (r7 == 0) goto L_0x0037
            com.google.android.gms.internal.measurement.zzmi r8 = new com.google.android.gms.internal.measurement.zzmi
            r8.<init>(r5)
        L_0x0037:
            zzf = r8
            java.lang.String r5 = "getLong"
            java.lang.String r6 = "objectFieldOffset"
            r7 = 2
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0044
        L_0x0042:
            r8 = r10
            goto L_0x006e
        L_0x0044:
            sun.misc.Unsafe r8 = r8.zza
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x0069 }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x0069 }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x0069 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0069 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0069 }
            r11[r9] = r12     // Catch:{ all -> 0x0069 }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x0069 }
            java.lang.reflect.Field r8 = zzB()     // Catch:{ all -> 0x0069 }
            if (r8 != 0) goto L_0x0067
            goto L_0x0042
        L_0x0067:
            r8 = r9
            goto L_0x006e
        L_0x0069:
            r8 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzml.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r8.toString()))
            goto L_0x0042
        L_0x006e:
            zzg = r8
            com.google.android.gms.internal.measurement.zzmk r8 = zzf
            if (r8 != 0) goto L_0x0077
        L_0x0074:
            r5 = r10
            goto L_0x0109
        L_0x0077:
            sun.misc.Unsafe r8 = r8.zza
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.reflect.Field> r12 = java.lang.reflect.Field.class
            r11[r10] = r12     // Catch:{ all -> 0x0103 }
            r8.getMethod(r6, r11)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r6 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r6[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r6 = new java.lang.Class[r7]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r6[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r6[r9] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "getInt"
            r8.getMethod(r11, r6)     // Catch:{ all -> 0x0103 }
            r6 = 3
            java.lang.Class[] r11 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0103 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r11[r9] = r12     // Catch:{ all -> 0x0103 }
            java.lang.Class r12 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0103 }
            r11[r7] = r12     // Catch:{ all -> 0x0103 }
            java.lang.String r12 = "putInt"
            r8.getMethod(r12, r11)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r12 = java.lang.Object.class
            r11[r10] = r12     // Catch:{ all -> 0x0103 }
            java.lang.Class r12 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r11[r9] = r12     // Catch:{ all -> 0x0103 }
            r8.getMethod(r5, r11)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r9] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r7] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "putLong"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r5[r10] = r11     // Catch:{ all -> 0x0103 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r9] = r11     // Catch:{ all -> 0x0103 }
            java.lang.String r11 = "getObject"
            r8.getMethod(r11, r5)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r10] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r5[r9] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            r5[r7] = r6     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r5)     // Catch:{ all -> 0x0103 }
            r5 = r9
            goto L_0x0109
        L_0x0103:
            r5 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzml.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r5.toString()))
            goto L_0x0074
        L_0x0109:
            zzh = r5
            java.lang.Class<byte[]> r5 = byte[].class
            int r5 = zzz(r5)
            long r5 = (long) r5
            zza = r5
            zzz(r4)
            zzA(r4)
            zzz(r3)
            zzA(r3)
            zzz(r2)
            zzA(r2)
            zzz(r1)
            zzA(r1)
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x0149
            com.google.android.gms.internal.measurement.zzmk r1 = zzf
            if (r1 == 0) goto L_0x0149
            r1.zzl(r0)
        L_0x0149:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0152
            goto L_0x0153
        L_0x0152:
            r9 = r10
        L_0x0153:
            zzb = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.<clinit>():void");
    }

    private zzml() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzij.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzmk zzmk = zzf;
        int zzj = zzmk.zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzmk.zzn(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j, byte b) {
        long j2 = -4 & j;
        zzmk zzmk = zzf;
        int i = (((int) j) & 3) << 3;
        zzmk.zzn(obj, j2, ((255 & b) << i) | (zzmk.zzj(obj, j2) & (~(255 << i))));
    }

    static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    static int zzc(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    static long zzd(Object obj, long j) {
        return zzf.zzk(obj, j);
    }

    static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    static Object zzf(Object obj, long j) {
        return zzf.zzm(obj, j);
    }

    static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmh());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void zzm(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    static void zzn(byte[] bArr, long j, byte b) {
        zzf.zzd(bArr, zza + j, b);
    }

    static void zzo(Object obj, long j, double d) {
        zzf.zze(obj, j, d);
    }

    static void zzp(Object obj, long j, float f) {
        zzf.zzf(obj, j, f);
    }

    static void zzq(Object obj, long j, int i) {
        zzf.zzn(obj, j, i);
    }

    static void zzr(Object obj, long j, long j2) {
        zzf.zzo(obj, j, j2);
    }

    static void zzs(Object obj, long j, Object obj2) {
        zzf.zzp(obj, j, obj2);
    }

    static /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    static boolean zzv(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzij.zza;
        try {
            Class cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzw(Object obj, long j) {
        return zzf.zzg(obj, j);
    }

    static boolean zzx() {
        return zzh;
    }

    static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }
}
