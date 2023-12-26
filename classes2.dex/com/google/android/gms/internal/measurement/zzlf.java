package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zzlf<T> implements zzln<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzml.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkq zzm;
    private final zzmb zzn;
    private final zzjk zzo;
    private final zzlh zzp;
    private final zzkx zzq;

    private zzlf(int[] iArr, Object[] objArr, int i, int i2, zzlc zzlc, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlh zzlh, zzkq zzkq, zzmb zzmb, zzjk zzjk, zzkx zzkx, byte[] bArr) {
        zzlc zzlc2 = zzlc;
        zzjk zzjk2 = zzjk;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzjk2 != null && zzjk2.zzc(zzlc)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlh;
        this.zzm = zzkq;
        this.zzn = zzmb;
        this.zzo = zzjk2;
        this.zzg = zzlc2;
        this.zzq = zzkx;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzml.zzf(obj, j)).longValue();
    }

    private final zzkb zzD(int i) {
        int i2 = i / 3;
        return (zzkb) this.zzd[i2 + i2 + 1];
    }

    private final zzln zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzln zzln = (zzln) this.zzd[i3];
        if (zzln != null) {
            return zzln;
        }
        zzln zzb2 = zzlk.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long zzB = (long) (zzB(i) & 1048575);
        if (zzM(obj2, i)) {
            Object zzf2 = zzml.zzf(obj, zzB);
            Object zzf3 = zzml.zzf(obj2, zzB);
            if (zzf2 != null && zzf3 != null) {
                zzml.zzs(obj, zzB, zzkf.zzg(zzf2, zzf3));
                zzJ(obj, i);
            } else if (zzf3 != null) {
                zzml.zzs(obj, zzB, zzf3);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int zzB = zzB(i);
        int i2 = this.zzc[i];
        long j = (long) (zzB & 1048575);
        if (zzP(obj2, i2, i)) {
            Object zzf2 = zzP(obj, i2, i) ? zzml.zzf(obj, j) : null;
            Object zzf3 = zzml.zzf(obj2, j);
            if (zzf2 != null && zzf3 != null) {
                zzml.zzs(obj, j, zzkf.zzg(zzf2, zzf3));
                zzK(obj, i2, i);
            } else if (zzf3 != null) {
                zzml.zzs(obj, j, zzf3);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (1048575 & zzy);
        if (j != 1048575) {
            zzml.zzq(obj, j, (1 << (zzy >>> 20)) | zzml.zzc(obj, j));
        }
    }

    private final void zzK(Object obj, int i, int i2) {
        zzml.zzq(obj, (long) (zzy(i2) & 1048575), i);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzM(obj, i) == zzM(obj2, i);
    }

    private final boolean zzM(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (zzy & 1048575);
        if (j != 1048575) {
            return (zzml.zzc(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = (long) (zzB & 1048575);
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzml.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzml.zzb(obj, j2)) != 0;
            case 2:
                return zzml.zzd(obj, j2) != 0;
            case 3:
                return zzml.zzd(obj, j2) != 0;
            case 4:
                return zzml.zzc(obj, j2) != 0;
            case 5:
                return zzml.zzd(obj, j2) != 0;
            case 6:
                return zzml.zzc(obj, j2) != 0;
            case 7:
                return zzml.zzw(obj, j2);
            case 8:
                Object zzf2 = zzml.zzf(obj, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzix) {
                    return !zzix.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzml.zzf(obj, j2) != null;
            case 10:
                return !zzix.zzb.equals(zzml.zzf(obj, j2));
            case 11:
                return zzml.zzc(obj, j2) != 0;
            case 12:
                return zzml.zzc(obj, j2) != 0;
            case 13:
                return zzml.zzc(obj, j2) != 0;
            case 14:
                return zzml.zzd(obj, j2) != 0;
            case 15:
                return zzml.zzc(obj, j2) != 0;
            case 16:
                return zzml.zzd(obj, j2) != 0;
            case 17:
                return zzml.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzN(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzM(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzO(Object obj, int i, zzln zzln) {
        return zzln.zzj(zzml.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzP(Object obj, int i, int i2) {
        return zzml.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzQ(Object obj, long j) {
        return ((Boolean) zzml.zzf(obj, j)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044c, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029b, code lost:
        r13 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzR(java.lang.Object r17, com.google.android.gms.internal.measurement.zzjf r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045d
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0453
            int r10 = r0.zzB(r7)
            int[] r11 = r0.zzc
            r12 = r11[r7]
            int r13 = zzA(r10)
            r14 = 17
            r15 = 1
            if (r13 > r14) goto L_0x003b
            int r14 = r7 + 2
            r11 = r11[r14]
            r14 = r11 & r5
            if (r14 == r9) goto L_0x0036
            long r8 = (long) r14
            int r8 = r4.getInt(r1, r8)
            r9 = r14
        L_0x0036:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x003c
        L_0x003b:
            r11 = 0
        L_0x003c:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r13) {
                case 0: goto L_0x0440;
                case 1: goto L_0x0433;
                case 2: goto L_0x0426;
                case 3: goto L_0x0419;
                case 4: goto L_0x040c;
                case 5: goto L_0x03ff;
                case 6: goto L_0x03f2;
                case 7: goto L_0x03e5;
                case 8: goto L_0x03d7;
                case 9: goto L_0x03c5;
                case 10: goto L_0x03b5;
                case 11: goto L_0x03a7;
                case 12: goto L_0x0399;
                case 13: goto L_0x038b;
                case 14: goto L_0x037d;
                case 15: goto L_0x036f;
                case 16: goto L_0x0361;
                case 17: goto L_0x034f;
                case 18: goto L_0x033f;
                case 19: goto L_0x032f;
                case 20: goto L_0x031f;
                case 21: goto L_0x030f;
                case 22: goto L_0x02ff;
                case 23: goto L_0x02ef;
                case 24: goto L_0x02df;
                case 25: goto L_0x02cf;
                case 26: goto L_0x02c0;
                case 27: goto L_0x02ad;
                case 28: goto L_0x029e;
                case 29: goto L_0x028d;
                case 30: goto L_0x027e;
                case 31: goto L_0x026f;
                case 32: goto L_0x0260;
                case 33: goto L_0x0251;
                case 34: goto L_0x0242;
                case 35: goto L_0x0233;
                case 36: goto L_0x0224;
                case 37: goto L_0x0215;
                case 38: goto L_0x0206;
                case 39: goto L_0x01f7;
                case 40: goto L_0x01e8;
                case 41: goto L_0x01d9;
                case 42: goto L_0x01ca;
                case 43: goto L_0x01bb;
                case 44: goto L_0x01ac;
                case 45: goto L_0x019d;
                case 46: goto L_0x018e;
                case 47: goto L_0x017f;
                case 48: goto L_0x0170;
                case 49: goto L_0x015d;
                case 50: goto L_0x0154;
                case 51: goto L_0x0145;
                case 52: goto L_0x0136;
                case 53: goto L_0x0127;
                case 54: goto L_0x0118;
                case 55: goto L_0x0109;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00eb;
                case 58: goto L_0x00dc;
                case 59: goto L_0x00cd;
                case 60: goto L_0x00ba;
                case 61: goto L_0x00aa;
                case 62: goto L_0x009c;
                case 63: goto L_0x008e;
                case 64: goto L_0x0080;
                case 65: goto L_0x0072;
                case 66: goto L_0x0064;
                case 67: goto L_0x0056;
                case 68: goto L_0x0044;
                default: goto L_0x0041;
            }
        L_0x0041:
            r13 = 0
            goto L_0x044c
        L_0x0044:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzq(r12, r5, r6)
            goto L_0x0041
        L_0x0056:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzC(r12, r5)
            goto L_0x0041
        L_0x0064:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzA(r12, r5)
            goto L_0x0041
        L_0x0072:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzy(r12, r5)
            goto L_0x0041
        L_0x0080:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzw(r12, r5)
            goto L_0x0041
        L_0x008e:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzi(r12, r5)
            goto L_0x0041
        L_0x009c:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzH(r12, r5)
            goto L_0x0041
        L_0x00aa:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzix r5 = (com.google.android.gms.internal.measurement.zzix) r5
            r2.zzd(r12, r5)
            goto L_0x0041
        L_0x00ba:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzv(r12, r5, r6)
            goto L_0x0041
        L_0x00cd:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r12, r5, r2)
            goto L_0x0041
        L_0x00dc:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            boolean r5 = zzQ(r1, r5)
            r2.zzb(r12, r5)
            goto L_0x0041
        L_0x00eb:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzk(r12, r5)
            goto L_0x0041
        L_0x00fa:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzm(r12, r5)
            goto L_0x0041
        L_0x0109:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            int r5 = zzr(r1, r5)
            r2.zzr(r12, r5)
            goto L_0x0041
        L_0x0118:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzJ(r12, r5)
            goto L_0x0041
        L_0x0127:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            long r5 = zzC(r1, r5)
            r2.zzt(r12, r5)
            goto L_0x0041
        L_0x0136:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            float r5 = zzo(r1, r5)
            r2.zzo(r12, r5)
            goto L_0x0041
        L_0x0145:
            boolean r10 = r0.zzP(r1, r12, r7)
            if (r10 == 0) goto L_0x0041
            double r5 = zzn(r1, r5)
            r2.zzf(r12, r5)
            goto L_0x0041
        L_0x0154:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzS(r2, r12, r5, r7)
            goto L_0x0041
        L_0x015d:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlp.zzQ(r10, r5, r2, r6)
            goto L_0x0041
        L_0x0170:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzX(r10, r5, r2, r15)
            goto L_0x0041
        L_0x017f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzW(r10, r5, r2, r15)
            goto L_0x0041
        L_0x018e:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzV(r10, r5, r2, r15)
            goto L_0x0041
        L_0x019d:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzU(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ac:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzM(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01bb:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzZ(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01ca:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzJ(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01d9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzN(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01e8:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzO(r10, r5, r2, r15)
            goto L_0x0041
        L_0x01f7:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzR(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0206:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzaa(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0215:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzS(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0224:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzP(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0233:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzL(r10, r5, r2, r15)
            goto L_0x0041
        L_0x0242:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.measurement.zzlp.zzX(r10, r5, r2, r11)
            goto L_0x029b
        L_0x0251:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzW(r10, r5, r2, r11)
            goto L_0x029b
        L_0x0260:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzV(r10, r5, r2, r11)
            goto L_0x029b
        L_0x026f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzU(r10, r5, r2, r11)
            goto L_0x029b
        L_0x027e:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzM(r10, r5, r2, r11)
            goto L_0x029b
        L_0x028d:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzZ(r10, r5, r2, r11)
        L_0x029b:
            r13 = r11
            goto L_0x044c
        L_0x029e:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzK(r10, r5, r2)
            goto L_0x0041
        L_0x02ad:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            com.google.android.gms.internal.measurement.zzlp.zzT(r10, r5, r2, r6)
            goto L_0x0041
        L_0x02c0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzY(r10, r5, r2)
            goto L_0x0041
        L_0x02cf:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r13 = 0
            com.google.android.gms.internal.measurement.zzlp.zzJ(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02df:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzN(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ef:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzO(r10, r5, r2, r13)
            goto L_0x044c
        L_0x02ff:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzR(r10, r5, r2, r13)
            goto L_0x044c
        L_0x030f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzaa(r10, r5, r2, r13)
            goto L_0x044c
        L_0x031f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzS(r10, r5, r2, r13)
            goto L_0x044c
        L_0x032f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzP(r10, r5, r2, r13)
            goto L_0x044c
        L_0x033f:
            r13 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.zzlp.zzL(r10, r5, r2, r13)
            goto L_0x044c
        L_0x034f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzq(r12, r5, r6)
            goto L_0x044c
        L_0x0361:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzC(r12, r5)
            goto L_0x044c
        L_0x036f:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzA(r12, r5)
            goto L_0x044c
        L_0x037d:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzy(r12, r5)
            goto L_0x044c
        L_0x038b:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzw(r12, r5)
            goto L_0x044c
        L_0x0399:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r12, r5)
            goto L_0x044c
        L_0x03a7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzH(r12, r5)
            goto L_0x044c
        L_0x03b5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzix r5 = (com.google.android.gms.internal.measurement.zzix) r5
            r2.zzd(r12, r5)
            goto L_0x044c
        L_0x03c5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.measurement.zzln r6 = r0.zzE(r7)
            r2.zzv(r12, r5, r6)
            goto L_0x044c
        L_0x03d7:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzT(r12, r5, r2)
            goto L_0x044c
        L_0x03e5:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            boolean r5 = com.google.android.gms.internal.measurement.zzml.zzw(r1, r5)
            r2.zzb(r12, r5)
            goto L_0x044c
        L_0x03f2:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r12, r5)
            goto L_0x044c
        L_0x03ff:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzm(r12, r5)
            goto L_0x044c
        L_0x040c:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            int r5 = r4.getInt(r1, r5)
            r2.zzr(r12, r5)
            goto L_0x044c
        L_0x0419:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzJ(r12, r5)
            goto L_0x044c
        L_0x0426:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            long r5 = r4.getLong(r1, r5)
            r2.zzt(r12, r5)
            goto L_0x044c
        L_0x0433:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            float r5 = com.google.android.gms.internal.measurement.zzml.zzb(r1, r5)
            r2.zzo(r12, r5)
            goto L_0x044c
        L_0x0440:
            r13 = 0
            r10 = r8 & r11
            if (r10 == 0) goto L_0x044c
            double r5 = com.google.android.gms.internal.measurement.zzml.zza(r1, r5)
            r2.zzf(r12, r5)
        L_0x044c:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0453:
            com.google.android.gms.internal.measurement.zzmb r3 = r0.zzn
            java.lang.Object r1 = r3.zzc(r1)
            r3.zzi(r1, r2)
            return
        L_0x045d:
            com.google.android.gms.internal.measurement.zzjk r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzR(java.lang.Object, com.google.android.gms.internal.measurement.zzjf):void");
    }

    private final void zzS(zzjf zzjf, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzkv zzkv = (zzkv) zzF(i2);
            throw null;
        }
    }

    private static final void zzT(int i, Object obj, zzjf zzjf) throws IOException {
        if (obj instanceof String) {
            zzjf.zzF(i, (String) obj);
        } else {
            zzjf.zzd(i, (zzix) obj);
        }
    }

    static zzmc zzd(Object obj) {
        zzjx zzjx = (zzjx) obj;
        zzmc zzmc = zzjx.zzc;
        if (zzmc != zzmc.zzc()) {
            return zzmc;
        }
        zzmc zze2 = zzmc.zze();
        zzjx.zzc = zze2;
        return zze2;
    }

    static zzlf zzk(Class cls, zzkz zzkz, zzlh zzlh, zzkq zzkq, zzmb zzmb, zzjk zzjk, zzkx zzkx) {
        if (zzkz instanceof zzlm) {
            return zzl((zzlm) zzkz, zzlh, zzkq, zzmb, zzjk, zzkx);
        }
        zzly zzly = (zzly) zzkz;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0379  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzlf zzl(com.google.android.gms.internal.measurement.zzlm r34, com.google.android.gms.internal.measurement.zzlh r35, com.google.android.gms.internal.measurement.zzkq r36, com.google.android.gms.internal.measurement.zzmb r37, com.google.android.gms.internal.measurement.zzjk r38, com.google.android.gms.internal.measurement.zzkx r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r1
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r1
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.measurement.zzlc r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0194:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a6
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0194
        L_0x01a6:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ae
        L_0x01ac:
            r2 = r24
        L_0x01ae:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01db
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d5
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bc
        L_0x01d5:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r3
            r3 = r24
        L_0x01df:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x0296
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0223
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzG(r1, r12)
            r17[r3] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r3 = r3 + 1
            r8 = r17[r3]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r1, r8)
            r17[r3] = r8
        L_0x0284:
            r3 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r8 = r1
            r0 = r7
            r29 = r11
            r25 = 1
            r7 = r3
            r3 = 0
            goto L_0x0391
        L_0x0296:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzG(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030e
            r12 = 17
            if (r5 != r12) goto L_0x02ae
            goto L_0x030e
        L_0x02ae:
            r12 = 27
            if (r5 == r12) goto L_0x02fe
            r12 = 49
            if (r5 != r12) goto L_0x02b7
            goto L_0x02fe
        L_0x02b7:
            r12 = 12
            if (r5 == r12) goto L_0x02ee
            r12 = 30
            if (r5 == r12) goto L_0x02ee
            r12 = 44
            if (r5 != r12) goto L_0x02c4
            goto L_0x02ee
        L_0x02c4:
            r12 = 50
            if (r5 != r12) goto L_0x02e4
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e7
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e4:
            r25 = 1
            goto L_0x031b
        L_0x02e7:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031c
        L_0x02ee:
            if (r10 != 0) goto L_0x02e4
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030b
        L_0x02fe:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030b:
            r12 = r27
            goto L_0x031c
        L_0x030e:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031b:
            r12 = r7
        L_0x031c:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0379
            r8 = 17
            if (r5 > r8) goto L_0x0379
            int r8 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0355
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033f:
            int r27 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0351
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r26
            r3 = r3 | r8
            int r26 = r26 + 13
            r8 = r27
            goto L_0x033f
        L_0x0351:
            int r8 = r8 << r26
            r3 = r3 | r8
            goto L_0x0357
        L_0x0355:
            r27 = r8
        L_0x0357:
            int r8 = r6 + r6
            int r26 = r3 / 32
            int r8 = r8 + r26
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0368
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x0370
        L_0x0368:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzG(r1, r11)
            r17[r8] = r11
        L_0x0370:
            r8 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r0 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0379:
            r30 = r0
            r8 = r1
            r0 = r27
            r27 = r3
            r3 = 0
        L_0x0381:
            r1 = 18
            if (r5 < r1) goto L_0x038f
            r1 = 49
            if (r5 > r1) goto L_0x038f
            int r1 = r23 + 1
            r13[r23] = r7
            r23 = r1
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r1 = r9 + 1
            r31[r9] = r4
            int r4 = r1 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r7
            r31[r1] = r2
            int r9 = r4 + 1
            int r1 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r8
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.measurement.zzlf r0 = new com.google.android.gms.internal.measurement.zzlf
            r4 = r0
            com.google.android.gms.internal.measurement.zzlc r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzl(com.google.android.gms.internal.measurement.zzlm, com.google.android.gms.internal.measurement.zzlh, com.google.android.gms.internal.measurement.zzkq, com.google.android.gms.internal.measurement.zzmb, com.google.android.gms.internal.measurement.zzjk, com.google.android.gms.internal.measurement.zzkx):com.google.android.gms.internal.measurement.zzlf");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzml.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzml.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x030a, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030b, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030c, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x034a, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037e, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0489, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0504, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0505, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x052e, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x053c, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x054b, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x054f, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ef, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019c, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ac, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bc, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = zzb
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r3
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000d:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0556
            int r9 = r0.zzB(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzA(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0036
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r3
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0037
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0037
        L_0x0036:
            r10 = 0
        L_0x0037:
            r9 = r9 & r3
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0540;
                case 1: goto L_0x0531;
                case 2: goto L_0x051b;
                case 3: goto L_0x0507;
                case 4: goto L_0x04f1;
                case 5: goto L_0x04e5;
                case 6: goto L_0x04d9;
                case 7: goto L_0x04cb;
                case 8: goto L_0x04a0;
                case 9: goto L_0x048d;
                case 10: goto L_0x0470;
                case 11: goto L_0x045b;
                case 12: goto L_0x0446;
                case 13: goto L_0x0439;
                case 14: goto L_0x042c;
                case 15: goto L_0x0412;
                case 16: goto L_0x03f8;
                case 17: goto L_0x03e4;
                case 18: goto L_0x03d6;
                case 19: goto L_0x03ca;
                case 20: goto L_0x03be;
                case 21: goto L_0x03b2;
                case 22: goto L_0x03a6;
                case 23: goto L_0x039a;
                case 24: goto L_0x038e;
                case 25: goto L_0x0382;
                case 26: goto L_0x0374;
                case 27: goto L_0x0365;
                case 28: goto L_0x035a;
                case 29: goto L_0x034e;
                case 30: goto L_0x033f;
                case 31: goto L_0x0333;
                case 32: goto L_0x0327;
                case 33: goto L_0x031b;
                case 34: goto L_0x030f;
                case 35: goto L_0x02f6;
                case 36: goto L_0x02e1;
                case 37: goto L_0x02cc;
                case 38: goto L_0x02b7;
                case 39: goto L_0x02a2;
                case 40: goto L_0x028d;
                case 41: goto L_0x0277;
                case 42: goto L_0x0261;
                case 43: goto L_0x024b;
                case 44: goto L_0x0235;
                case 45: goto L_0x021f;
                case 46: goto L_0x0209;
                case 47: goto L_0x01f3;
                case 48: goto L_0x01dd;
                case 49: goto L_0x01cd;
                case 50: goto L_0x01c0;
                case 51: goto L_0x01b0;
                case 52: goto L_0x01a0;
                case 53: goto L_0x0188;
                case 54: goto L_0x0173;
                case 55: goto L_0x015d;
                case 56: goto L_0x0150;
                case 57: goto L_0x0143;
                case 58: goto L_0x0134;
                case 59: goto L_0x0107;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00d5;
                case 62: goto L_0x00bf;
                case 63: goto L_0x00a9;
                case 64: goto L_0x009b;
                case 65: goto L_0x008d;
                case 66: goto L_0x0072;
                case 67: goto L_0x0056;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x037f
        L_0x0040:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlc r3 = (com.google.android.gms.internal.measurement.zzlc) r3
            com.google.android.gms.internal.measurement.zzln r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzu(r11, r3, r4)
            goto L_0x037e
        L_0x0056:
            boolean r10 = r0.zzP(r1, r11, r5)
            if (r10 == 0) goto L_0x037f
            long r3 = zzC(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzje.zzA(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzje.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x037f
        L_0x0072:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030b
        L_0x008d:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x01bc
        L_0x009b:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x01ac
        L_0x00a9:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzv(r3)
            goto L_0x030b
        L_0x00bf:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030b
        L_0x00d5:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzix r3 = (com.google.android.gms.internal.measurement.zzix) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x00ef:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x030c
        L_0x00f3:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzln r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzo(r11, r3, r4)
            goto L_0x037e
        L_0x0107:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzix
            if (r4 == 0) goto L_0x0126
            com.google.android.gms.internal.measurement.zzix r3 = (com.google.android.gms.internal.measurement.zzix) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x00ef
        L_0x0126:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzy(r3)
            goto L_0x030b
        L_0x0134:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            int r3 = r3 + r14
            goto L_0x037e
        L_0x0143:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x01ac
        L_0x0150:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x01bc
        L_0x015d:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzv(r3)
            goto L_0x030b
        L_0x0173:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzB(r3)
            goto L_0x019c
        L_0x0188:
            boolean r9 = r0.zzP(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzB(r3)
        L_0x019c:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x037f
        L_0x01a0:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x01ac:
            int r3 = r3 + 4
            goto L_0x037e
        L_0x01b0:
            boolean r3 = r0.zzP(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x01bc:
            int r3 = r3 + 8
            goto L_0x037e
        L_0x01c0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.zzF(r5)
            com.google.android.gms.internal.measurement.zzkx.zza(r11, r3, r4)
            goto L_0x037f
        L_0x01cd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzln r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzj(r11, r3, r4)
            goto L_0x037e
        L_0x01dd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzt(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x01f3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzr(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x0209:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzi(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x021f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzg(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x0235:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zze(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x024b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzw(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x0261:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzb(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x0277:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzg(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x028d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzi(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x02a2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzl(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x02b7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzy(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x02cc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzn(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x02e1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzg(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x030a
        L_0x02f6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzi(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzje.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x030a:
            int r4 = r4 + r9
        L_0x030b:
            int r4 = r4 + r3
        L_0x030c:
            int r6 = r6 + r4
            goto L_0x037f
        L_0x030f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzs(r11, r3, r9)
            goto L_0x034a
        L_0x031b:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzq(r11, r3, r9)
            goto L_0x034a
        L_0x0327:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzh(r11, r3, r9)
            goto L_0x034a
        L_0x0333:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzf(r11, r3, r9)
            goto L_0x034a
        L_0x033f:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzd(r11, r3, r9)
        L_0x034a:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x054f
        L_0x034e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzv(r11, r3, r9)
            goto L_0x037e
        L_0x035a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzc(r11, r3)
            goto L_0x037e
        L_0x0365:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzln r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzp(r11, r3, r4)
            goto L_0x037e
        L_0x0374:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzu(r11, r3)
        L_0x037e:
            int r6 = r6 + r3
        L_0x037f:
            r12 = 0
            goto L_0x054f
        L_0x0382:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlp.zza(r11, r3, r12)
            goto L_0x03e1
        L_0x038e:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzf(r11, r3, r12)
            goto L_0x03e1
        L_0x039a:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzh(r11, r3, r12)
            goto L_0x03e1
        L_0x03a6:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzk(r11, r3, r12)
            goto L_0x03e1
        L_0x03b2:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzx(r11, r3, r12)
            goto L_0x03e1
        L_0x03be:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzm(r11, r3, r12)
            goto L_0x03e1
        L_0x03ca:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzf(r11, r3, r12)
            goto L_0x03e1
        L_0x03d6:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzh(r11, r3, r12)
        L_0x03e1:
            int r6 = r6 + r3
            goto L_0x054f
        L_0x03e4:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlc r3 = (com.google.android.gms.internal.measurement.zzlc) r3
            com.google.android.gms.internal.measurement.zzln r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzu(r11, r3, r4)
            goto L_0x03e1
        L_0x03f8:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054f
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzje.zzA(r10)
            long r14 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r14
            int r3 = com.google.android.gms.internal.measurement.zzje.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054f
        L_0x0412:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x0504
        L_0x042c:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x054b
        L_0x0439:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x053c
        L_0x0446:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzv(r3)
            goto L_0x0504
        L_0x045b:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x0504
        L_0x0470:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzix r3 = (com.google.android.gms.internal.measurement.zzix) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x0489:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0505
        L_0x048d:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzln r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlp.zzo(r11, r3, r4)
            goto L_0x03e1
        L_0x04a0:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzix
            if (r4 == 0) goto L_0x04be
            com.google.android.gms.internal.measurement.zzix r3 = (com.google.android.gms.internal.measurement.zzix) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x0489
        L_0x04be:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzy(r3)
            goto L_0x0504
        L_0x04cb:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            int r3 = r3 + r14
            goto L_0x03e1
        L_0x04d9:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x053c
        L_0x04e5:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
            goto L_0x054b
        L_0x04f1:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzv(r3)
        L_0x0504:
            int r4 = r4 + r3
        L_0x0505:
            int r6 = r6 + r4
            goto L_0x054f
        L_0x0507:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzB(r3)
            goto L_0x052e
        L_0x051b:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzje.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzje.zzB(r3)
        L_0x052e:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054f
        L_0x0531:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x053c:
            int r3 = r3 + 4
            goto L_0x03e1
        L_0x0540:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzje.zzA(r3)
        L_0x054b:
            int r3 = r3 + 8
            goto L_0x03e1
        L_0x054f:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000d
        L_0x0556:
            com.google.android.gms.internal.measurement.zzmb r2 = r0.zzn
            java.lang.Object r3 = r2.zzc(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x0566
            return r6
        L_0x0566:
            com.google.android.gms.internal.measurement.zzjk r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzp(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzB(r2)
            int r5 = zzA(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzjp r4 = com.google.android.gms.internal.measurement.zzjp.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzjp r4 = com.google.android.gms.internal.measurement.zzjp.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlc r4 = (com.google.android.gms.internal.measurement.zzlc) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzP(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzC(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzix
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzP(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.lang.Object r5 = r11.zzF(r2)
            com.google.android.gms.internal.measurement.zzkx.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzje.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlc r4 = (com.google.android.gms.internal.measurement.zzlc) r4
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzM(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzml.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzln r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlp.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzix
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzix r4 = (com.google.android.gms.internal.measurement.zzix) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzml.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzje.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzml.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzml.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzje.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzje.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzM(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzje.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzmb r0 = r11.zzn
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzq(java.lang.Object):int");
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzml.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzik zzik) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzkw) object).zze()) {
            zzkw zzb2 = zzkw.zza().zzb();
            zzkx.zzb(zzb2, object);
            unsafe.putObject(obj, j, zzb2);
        }
        zzkv zzkv = (zzkv) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzik zzik) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzik zzik2 = zzik;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzil.zzn(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzil.zzb(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzil.zzm(bArr2, i9, zzik2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzik2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzil.zzj(bArr2, i9, zzik2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzik2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzil.zzn(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzil.zzb(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzil.zzm(bArr2, i9, zzik2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzik2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzil.zzj(bArr2, i9, zzik2);
                    int i14 = zzik2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzmq.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i14, zzkf.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzkh.zzc();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzil.zzd(zzE(i13), bArr2, i9, i2, zzik2);
                    Object object = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j2, zzik2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkf.zzg(object, zzik2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzd2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzil.zza(bArr2, i9, zzik2);
                    unsafe.putObject(obj2, j2, zzik2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzil.zzj(bArr2, i9, zzik2);
                    int i15 = zzik2.zza;
                    zzkb zzD = zzD(i13);
                    if (zzD == null || zzD.zza(i15)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i15));
                        unsafe.putInt(obj2, j3, i11);
                    } else {
                        zzd(obj).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzil.zzj(bArr2, i9, zzik2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzja.zzb(zzik2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzil.zzm(bArr2, i9, zzik2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzja.zzc(zzik2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzil.zzc(zzE(i13), bArr, i, i2, (i10 & -8) | 4, zzik);
                    Object object2 = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j2, zzik2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkf.zzg(object2, zzik2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02f1, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0322, code lost:
        if (r0 != r15) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0345, code lost:
        if (r0 != r15) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0225, code lost:
        r6 = r6 | r23;
        r9 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0229, code lost:
        r7 = r19;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x022f, code lost:
        r2 = r5;
        r28 = r7;
        r23 = r10;
        r7 = r19;
        r19 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02d9, code lost:
        if (r0 != r15) goto L_0x02db;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(java.lang.Object r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.measurement.zzik r36) throws java.io.IOException {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r34
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x036f
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzx(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzw(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r10) goto L_0x004d
            r2 = r4
            r20 = r5
            r28 = r9
            r19 = r10
            r23 = r16
            goto L_0x0348
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r10 = zzA(r1)
            r34 = r5
            r5 = r1 & r8
            r19 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x023a
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x008a
            r20 = r2
            if (r7 == r5) goto L_0x007e
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0080
        L_0x007e:
            r7 = r19
        L_0x0080:
            if (r0 == r5) goto L_0x0087
            long r1 = (long) r0
            int r6 = r7.getInt(r14, r1)
        L_0x0087:
            r2 = r7
            r7 = r0
            goto L_0x008e
        L_0x008a:
            r20 = r2
            r2 = r19
        L_0x008e:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x020b;
                case 1: goto L_0x01f1;
                case 2: goto L_0x01d1;
                case 3: goto L_0x01d1;
                case 4: goto L_0x01ba;
                case 5: goto L_0x019c;
                case 6: goto L_0x0186;
                case 7: goto L_0x0166;
                case 8: goto L_0x0144;
                case 9: goto L_0x0118;
                case 10: goto L_0x0101;
                case 11: goto L_0x01ba;
                case 12: goto L_0x00eb;
                case 13: goto L_0x0186;
                case 14: goto L_0x019c;
                case 15: goto L_0x00d1;
                case 16: goto L_0x009e;
                default: goto L_0x0092;
            }
        L_0x0092:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
        L_0x009b:
            r5 = r4
            goto L_0x022f
        L_0x009e:
            if (r3 != 0) goto L_0x00c4
            int r10 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r21 = com.google.android.gms.internal.measurement.zzja.zzc(r0)
            r0 = r2
            r1 = r32
            r19 = r7
            r4 = r20
            r7 = r2
            r2 = r8
            r20 = r34
            r8 = r4
            r25 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r8
            r0 = r10
            goto L_0x0229
        L_0x00c4:
            r25 = r5
            r19 = r7
            r8 = r20
            r20 = r34
            r7 = r2
            r5 = r4
            r10 = r8
            goto L_0x022f
        L_0x00d1:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            if (r3 != 0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzja.zzb(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0225
        L_0x00eb:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            if (r3 != 0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0225
        L_0x0101:
            r25 = r5
            r19 = r7
            r10 = r20
            r0 = 2
            r20 = r34
            r7 = r2
            if (r3 != r0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzil.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0225
        L_0x0118:
            r25 = r5
            r19 = r7
            r10 = r20
            r0 = 2
            r20 = r34
            r7 = r2
            if (r3 != r0) goto L_0x009b
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r10)
            int r0 = com.google.android.gms.internal.measurement.zzil.zzd(r0, r12, r4, r13, r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x0139
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0225
        L_0x0139:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkf.zzg(r1, r2)
            r7.putObject(r14, r8, r1)
            goto L_0x0225
        L_0x0144:
            r25 = r5
            r19 = r7
            r10 = r20
            r0 = 2
            r20 = r34
            r7 = r2
            if (r3 != r0) goto L_0x009b
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x015b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzg(r12, r4, r11)
            goto L_0x015f
        L_0x015b:
            int r0 = com.google.android.gms.internal.measurement.zzil.zzh(r12, r4, r11)
        L_0x015f:
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0225
        L_0x0166:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            if (r3 != 0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x017f
            r1 = 1
            goto L_0x0181
        L_0x017f:
            r1 = r16
        L_0x0181:
            com.google.android.gms.internal.measurement.zzml.zzm(r14, r8, r1)
            goto L_0x0225
        L_0x0186:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            if (r3 != r0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r4)
            r7.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0225
        L_0x019c:
            r25 = r5
            r19 = r7
            r10 = r20
            r0 = 1
            r20 = r34
            r7 = r2
            if (r3 != r0) goto L_0x009b
            long r21 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r4)
            r0 = r7
            r1 = r32
            r2 = r8
            r8 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0225
        L_0x01ba:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            r5 = r4
            if (r3 != 0) goto L_0x022f
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r5, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0225
        L_0x01d1:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            r5 = r4
            if (r3 != 0) goto L_0x022f
            int r17 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r32
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            r0 = r17
            goto L_0x0229
        L_0x01f1:
            r25 = r5
            r19 = r7
            r10 = r20
            r20 = r34
            r7 = r2
            r5 = r4
            if (r3 != r0) goto L_0x022f
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r5)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzml.zzp(r14, r8, r0)
            int r0 = r5 + 4
            goto L_0x0225
        L_0x020b:
            r25 = r5
            r19 = r7
            r10 = r20
            r0 = 1
            r20 = r34
            r7 = r2
            r5 = r4
            if (r3 != r0) goto L_0x022f
            long r0 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r5)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzml.zzo(r14, r8, r0)
            int r0 = r5 + 8
        L_0x0225:
            r6 = r6 | r23
            r9 = r7
            r2 = r10
        L_0x0229:
            r7 = r19
            r1 = r20
            goto L_0x0289
        L_0x022f:
            r2 = r5
            r28 = r7
            r23 = r10
            r7 = r19
            r19 = -1
            goto L_0x0348
        L_0x023a:
            r20 = r34
            r5 = r4
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r29 = r19
            r19 = r7
            r7 = r29
            r0 = 27
            if (r10 != r0) goto L_0x029b
            r0 = 2
            if (r3 != r0) goto L_0x028e
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzke r0 = (com.google.android.gms.internal.measurement.zzke) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x026b
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0263
            r1 = 10
            goto L_0x0264
        L_0x0263:
            int r1 = r1 + r1
        L_0x0264:
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzd(r1)
            r7.putObject(r14, r8, r0)
        L_0x026b:
            r8 = r0
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r4)
            r1 = r17
            r2 = r33
            r3 = r5
            r23 = r4
            r4 = r35
            r5 = r8
            r8 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.measurement.zzil.zze(r0, r1, r2, r3, r4, r5, r6)
            r9 = r7
            r6 = r8
            r7 = r19
            r1 = r20
            r2 = r23
        L_0x0289:
            r8 = r25
            r10 = -1
            goto L_0x0019
        L_0x028e:
            r23 = r4
            r15 = r5
            r26 = r6
            r28 = r7
            r27 = r19
            r19 = -1
            goto L_0x0325
        L_0x029b:
            r23 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02f3
            r1 = r21
            long r1 = (long) r1
            r0 = r31
            r21 = r1
            r1 = r32
            r2 = r33
            r4 = r3
            r3 = r5
            r34 = r4
            r4 = r35
            r15 = r5
            r5 = r17
            r26 = r6
            r6 = r20
            r27 = r19
            r19 = r7
            r7 = r34
            r29 = r8
            r9 = r25
            r24 = r29
            r8 = r23
            r18 = r10
            r28 = r19
            r19 = -1
            r9 = r21
            r11 = r18
            r12 = r24
            r14 = r36
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02f1
        L_0x02db:
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r10 = r19
            r1 = r20
            r2 = r23
            r6 = r26
            r7 = r27
            goto L_0x0368
        L_0x02f1:
            r2 = r0
            goto L_0x0326
        L_0x02f3:
            r34 = r3
            r15 = r5
            r26 = r6
            r28 = r7
            r24 = r8
            r18 = r10
            r27 = r19
            r1 = r21
            r19 = -1
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x032b
            r7 = r34
            r0 = 2
            if (r7 != r0) goto L_0x0325
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r23
            r6 = r24
            r8 = r36
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02f1
            goto L_0x02db
        L_0x0325:
            r2 = r15
        L_0x0326:
            r6 = r26
            r7 = r27
            goto L_0x0348
        L_0x032b:
            r7 = r34
            r0 = r31
            r8 = r1
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r17
            r6 = r20
            r10 = r24
            r12 = r23
            r13 = r36
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02f1
            goto L_0x02db
        L_0x0348:
            com.google.android.gms.internal.measurement.zzmc r4 = zzd(r32)
            r0 = r17
            r1 = r33
            r3 = r35
            r5 = r36
            int r0 = com.google.android.gms.internal.measurement.zzil.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r10 = r19
            r1 = r20
            r2 = r23
        L_0x0368:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x036f:
            r26 = r6
            r1 = r8
            r28 = r9
            if (r7 == r1) goto L_0x0380
            long r1 = (long) r7
            r3 = r32
            r6 = r26
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0380:
            r1 = r35
            if (r0 != r1) goto L_0x0385
            return r0
        L_0x0385:
            com.google.android.gms.internal.measurement.zzkh r0 = com.google.android.gms.internal.measurement.zzkh.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzik):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzik r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzke r12 = (com.google.android.gms.internal.measurement.zzke) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.measurement.zzke r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.measurement.zzln r1 = r15.zzE(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzil.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzja.zzc(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzja.zzc(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzja.zzc(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzja.zzb(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzja.zzb(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzja.zzb(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.measurement.zzil.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzil.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.measurement.zzjx r1 = (com.google.android.gms.internal.measurement.zzjx) r1
            com.google.android.gms.internal.measurement.zzmc r3 = r1.zzc
            com.google.android.gms.internal.measurement.zzmc r4 = com.google.android.gms.internal.measurement.zzmc.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.measurement.zzkb r4 = r15.zzD(r8)
            com.google.android.gms.internal.measurement.zzmb r5 = r0.zzn
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzlp.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.measurement.zzmc r3 = (com.google.android.gms.internal.measurement.zzmc) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.measurement.zzix r4 = com.google.android.gms.internal.measurement.zzix.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.measurement.zzix r6 = com.google.android.gms.internal.measurement.zzix.zzl(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.measurement.zzix r4 = com.google.android.gms.internal.measurement.zzix.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.measurement.zzix r6 = com.google.android.gms.internal.measurement.zzix.zzl(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.measurement.zzln r1 = r15.zzE(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.measurement.zzil.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkf.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkf.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzmq.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkf.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzmq.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkf.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzc()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzc()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzd()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.measurement.zzim r12 = (com.google.android.gms.internal.measurement.zzim) r12
            int r2 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzim r12 = (com.google.android.gms.internal.measurement.zzim) r12
            int r4 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjy r12 = (com.google.android.gms.internal.measurement.zzjy) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.measurement.zzil.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.measurement.zzil.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.measurement.zzkr r12 = (com.google.android.gms.internal.measurement.zzkr) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.measurement.zzjq r12 = (com.google.android.gms.internal.measurement.zzjq) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjq r12 = (com.google.android.gms.internal.measurement.zzjq) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.measurement.zzil.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.measurement.zzjg r12 = (com.google.android.gms.internal.measurement.zzjg) r12
            int r1 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.measurement.zzkh r1 = com.google.android.gms.internal.measurement.zzkh.zzf()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.measurement.zzjg r12 = (com.google.android.gms.internal.measurement.zzjg) r12
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.measurement.zzil.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.measurement.zzil.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzil.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzik):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzB(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzA(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzQ(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzo(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzP(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzml.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzml.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzml.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzml.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzml.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzml.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkf.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzmb r0 = r8.zzn
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjk r0 = r8.zzo
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x037e, code lost:
        if (r0 != r15) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x039a, code lost:
        r7 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03c6, code lost:
        if (r0 != r15) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03e8, code lost:
        if (r0 != r15) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0164, code lost:
        r5 = r6 | r25;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0168, code lost:
        r3 = r8;
        r1 = r11;
        r6 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x019f, code lost:
        r21 = r3;
        r13 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0202, code lost:
        r5 = r6 | r25;
        r3 = r2;
        r1 = r11;
        r6 = r27;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x020a, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x020e, code lost:
        r13 = r2;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0211, code lost:
        r18 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b2, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b4, code lost:
        r5 = r6 | r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b6, code lost:
        r2 = r32;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02ba, code lost:
        r3 = r13;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02bf, code lost:
        r21 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02d4, code lost:
        r7 = r34;
        r22 = r6;
        r28 = r10;
        r8 = r18;
        r2 = r21;
        r6 = r27;
        r21 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzik r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            r17 = 0
            if (r0 >= r13) goto L_0x0459
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.android.gms.internal.measurement.zzil.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002e
        L_0x002d:
            r4 = r0
        L_0x002e:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r2) goto L_0x003b
            int r3 = r3 / r8
            int r2 = r15.zzx(r0, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzw(r0)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r32 = r0
            r2 = r1
            r19 = r3
            r8 = r4
            r22 = r5
            r28 = r10
            r7 = r11
            r21 = r16
            goto L_0x03eb
        L_0x0051:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r8 = r3[r20]
            int r11 = zzA(r8)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r8 & r18
            r21 = r1
            long r0 = (long) r0
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02e4
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r25 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x008a
            r18 = r4
            if (r6 == r3) goto L_0x0082
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0082:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r27 = r0
            goto L_0x008e
        L_0x008a:
            r18 = r4
            r27 = r6
        L_0x008e:
            r6 = r5
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0299;
                case 1: goto L_0x027d;
                case 2: goto L_0x0256;
                case 3: goto L_0x0256;
                case 4: goto L_0x023d;
                case 5: goto L_0x0215;
                case 6: goto L_0x01ea;
                case 7: goto L_0x01c8;
                case 8: goto L_0x01a4;
                case 9: goto L_0x016e;
                case 10: goto L_0x014a;
                case 11: goto L_0x023d;
                case 12: goto L_0x0113;
                case 13: goto L_0x01ea;
                case 14: goto L_0x0215;
                case 15: goto L_0x00f5;
                case 16: goto L_0x00c2;
                default: goto L_0x0093;
            }
        L_0x0093:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r0 = 3
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x02bf
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r13)
            int r1 = r32 << 3
            r7 = r1 | 4
            r1 = r31
            r2 = r11
            r3 = r33
            r11 = r4
            r4 = r7
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzil.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r25
            if (r1 != 0) goto L_0x02c2
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r11, r1)
            goto L_0x02cf
        L_0x00c2:
            if (r7 != 0) goto L_0x00eb
            r3 = r21
            int r7 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.measurement.zzja.zzc(r0)
            r11 = r20
            r0 = r10
            r1 = r30
            r8 = r2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r22
            r32 = r11
            r11 = r18
            r0.putLong(r1, r2, r4)
            r5 = r6 | r25
            r2 = r32
            r0 = r7
            goto L_0x0168
        L_0x00eb:
            r32 = r20
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            goto L_0x02d4
        L_0x00f5:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x019f
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzja.zzb(r1)
            r4 = r22
            r10.putInt(r14, r4, r1)
            goto L_0x0164
        L_0x0113:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x019f
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r3, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzkb r2 = r15.zzD(r8)
            if (r2 == 0) goto L_0x0146
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0136
            goto L_0x0146
        L_0x0136:
            com.google.android.gms.internal.measurement.zzmc r2 = zzd(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r2 = r32
            r5 = r6
            goto L_0x0168
        L_0x0146:
            r10.putInt(r14, r4, r1)
            goto L_0x0164
        L_0x014a:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x019f
            int r0 = com.google.android.gms.internal.measurement.zzil.zza(r12, r3, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
        L_0x0164:
            r5 = r6 | r25
            r2 = r32
        L_0x0168:
            r3 = r8
            r1 = r11
            r6 = r27
            goto L_0x020a
        L_0x016e:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x019f
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r8)
            int r0 = com.google.android.gms.internal.measurement.zzil.zzd(r0, r12, r3, r13, r9)
            r1 = r6 & r25
            if (r1 != 0) goto L_0x0191
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0164
        L_0x0191:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkf.zzg(r1, r2)
            r10.putObject(r14, r4, r1)
            goto L_0x0164
        L_0x019f:
            r21 = r3
            r13 = r8
            goto L_0x0211
        L_0x01a4:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x020e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r8
            if (r0 != 0) goto L_0x01be
            int r0 = com.google.android.gms.internal.measurement.zzil.zzg(r12, r3, r9)
            goto L_0x01c2
        L_0x01be:
            int r0 = com.google.android.gms.internal.measurement.zzil.zzh(r12, r3, r9)
        L_0x01c2:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0202
        L_0x01c8:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x020e
            int r0 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r3, r9)
            long r7 = r9.zzb
            r17 = 0
            int r3 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x01e4
            goto L_0x01e6
        L_0x01e4:
            r1 = r16
        L_0x01e6:
            com.google.android.gms.internal.measurement.zzml.zzm(r14, r4, r1)
            goto L_0x0202
        L_0x01ea:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x020e
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x0202:
            r5 = r6 | r25
            r3 = r2
            r1 = r11
            r6 = r27
            r2 = r32
        L_0x020a:
            r11 = r34
            goto L_0x001a
        L_0x020e:
            r13 = r2
            r21 = r3
        L_0x0211:
            r18 = r11
            goto L_0x02d4
        L_0x0215:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x0236
            long r7 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r3)
            r0 = r10
            r1 = r30
            r13 = r2
            r18 = r11
            r11 = r3
            r2 = r4
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x02b2
        L_0x0236:
            r13 = r2
            r18 = r11
            r21 = r3
            goto L_0x02d4
        L_0x023d:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x02bf
            int r0 = com.google.android.gms.internal.measurement.zzil.zzj(r12, r11, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x02b4
        L_0x0256:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x02bf
            int r7 = com.google.android.gms.internal.measurement.zzil.zzm(r12, r11, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r30
            r21 = r2
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            r5 = r6 | r25
            r2 = r32
            r11 = r34
            r0 = r7
            goto L_0x02ba
        L_0x027d:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x02bf
            int r0 = com.google.android.gms.internal.measurement.zzil.zzb(r12, r11)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzml.zzp(r14, r4, r0)
            int r0 = r11 + 4
            goto L_0x02b4
        L_0x0299:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x02bf
            long r0 = com.google.android.gms.internal.measurement.zzil.zzn(r12, r11)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzml.zzo(r14, r4, r0)
        L_0x02b2:
            int r0 = r11 + 8
        L_0x02b4:
            r5 = r6 | r25
        L_0x02b6:
            r2 = r32
            r11 = r34
        L_0x02ba:
            r3 = r13
            r1 = r18
            goto L_0x0336
        L_0x02bf:
            r21 = r11
            goto L_0x02d4
        L_0x02c2:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkf.zzg(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x02cf:
            r5 = r6 | r25
            r12 = r31
            goto L_0x02b6
        L_0x02d4:
            r7 = r34
            r22 = r6
            r28 = r10
            r8 = r18
            r2 = r21
            r6 = r27
            r21 = r13
            goto L_0x03eb
        L_0x02e4:
            r13 = r2
            r18 = r4
            r3 = r11
            r4 = r20
            r11 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r0 = 27
            if (r3 != r0) goto L_0x034a
            r0 = 2
            if (r7 != r0) goto L_0x033c
            java.lang.Object r0 = r10.getObject(r14, r11)
            com.google.android.gms.internal.measurement.zzke r0 = (com.google.android.gms.internal.measurement.zzke) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0315
            int r1 = r0.size()
            if (r1 != 0) goto L_0x030d
            r1 = 10
            goto L_0x030e
        L_0x030d:
            int r1 = r1 + r1
        L_0x030e:
            com.google.android.gms.internal.measurement.zzke r0 = r0.zzd(r1)
            r10.putObject(r14, r11, r0)
        L_0x0315:
            r7 = r0
            com.google.android.gms.internal.measurement.zzln r0 = r15.zzE(r13)
            r1 = r18
            r2 = r31
            r3 = r21
            r8 = r4
            r4 = r33
            r22 = r5
            r5 = r7
            r27 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzil.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r31
            r11 = r34
            r2 = r8
            r3 = r13
            r5 = r22
        L_0x0336:
            r6 = r27
            r13 = r33
            goto L_0x001a
        L_0x033c:
            r22 = r5
            r27 = r6
            r32 = r4
            r28 = r10
            r15 = r21
            r21 = r13
            goto L_0x03c9
        L_0x034a:
            r22 = r5
            r27 = r6
            r6 = r4
            r0 = 49
            if (r3 > r0) goto L_0x039e
            long r4 = (long) r8
            r0 = r29
            r1 = r30
            r2 = r31
            r8 = r3
            r3 = r21
            r23 = r4
            r4 = r33
            r5 = r18
            r32 = r6
            r20 = r8
            r8 = r13
            r28 = r10
            r9 = r23
            r25 = r11
            r15 = r21
            r12 = r34
            r11 = r20
            r21 = r13
            r12 = r25
            r14 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x039a
        L_0x0380:
            r15 = r29
            r14 = r30
            r12 = r31
            r2 = r32
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r18
            r3 = r21
            r5 = r22
            r6 = r27
            r10 = r28
            goto L_0x001a
        L_0x039a:
            r7 = r34
            r2 = r0
            goto L_0x03cc
        L_0x039e:
            r20 = r3
            r32 = r6
            r28 = r10
            r25 = r11
            r15 = r21
            r21 = r13
            r0 = 50
            r9 = r20
            if (r9 != r0) goto L_0x03d1
            r0 = 2
            if (r7 != r0) goto L_0x03c9
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r21
            r6 = r25
            r8 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x039a
            goto L_0x0380
        L_0x03c9:
            r7 = r34
            r2 = r15
        L_0x03cc:
            r8 = r18
            r6 = r27
            goto L_0x03eb
        L_0x03d1:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r32
            r10 = r25
            r12 = r21
            r13 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x039a
            goto L_0x0380
        L_0x03eb:
            if (r8 != r7) goto L_0x03f9
            if (r7 == 0) goto L_0x03f9
            r9 = r29
            r12 = r30
            r0 = r2
            r1 = r8
            r5 = r22
            goto L_0x0462
        L_0x03f9:
            r9 = r29
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x0432
            r10 = r35
            com.google.android.gms.internal.measurement.zzjj r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzjj r1 = com.google.android.gms.internal.measurement.zzjj.zza()
            if (r0 == r1) goto L_0x042d
            com.google.android.gms.internal.measurement.zzlc r0 = r9.zzg
            com.google.android.gms.internal.measurement.zzjj r1 = r10.zzd
            r11 = r32
            com.google.android.gms.internal.measurement.zzjv r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x0427
            com.google.android.gms.internal.measurement.zzmc r4 = zzd(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzil.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r30
            goto L_0x0447
        L_0x0427:
            r12 = r30
            r0 = r12
            com.google.android.gms.internal.measurement.zzju r0 = (com.google.android.gms.internal.measurement.zzju) r0
            throw r17
        L_0x042d:
            r12 = r30
            r11 = r32
            goto L_0x0438
        L_0x0432:
            r12 = r30
            r11 = r32
            r10 = r35
        L_0x0438:
            com.google.android.gms.internal.measurement.zzmc r4 = zzd(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzil.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0447:
            r13 = r33
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r3 = r21
            r5 = r22
            r10 = r28
            r12 = r31
            r11 = r7
            goto L_0x001a
        L_0x0459:
            r22 = r5
            r27 = r6
            r28 = r10
            r7 = r11
            r12 = r14
            r9 = r15
        L_0x0462:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x046d
            long r3 = (long) r6
            r6 = r28
            r6.putInt(r12, r3, r5)
        L_0x046d:
            int r3 = r9.zzk
        L_0x046f:
            int r4 = r9.zzl
            if (r3 >= r4) goto L_0x049a
            int[] r4 = r9.zzj
            r4 = r4[r3]
            int[] r5 = r9.zzc
            r5 = r5[r4]
            int r5 = r9.zzB(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzml.zzf(r12, r5)
            if (r5 != 0) goto L_0x0488
            goto L_0x048e
        L_0x0488:
            com.google.android.gms.internal.measurement.zzkb r6 = r9.zzD(r4)
            if (r6 != 0) goto L_0x0491
        L_0x048e:
            int r3 = r3 + 1
            goto L_0x046f
        L_0x0491:
            com.google.android.gms.internal.measurement.zzkw r5 = (com.google.android.gms.internal.measurement.zzkw) r5
            java.lang.Object r0 = r9.zzF(r4)
            com.google.android.gms.internal.measurement.zzkv r0 = (com.google.android.gms.internal.measurement.zzkv) r0
            throw r17
        L_0x049a:
            if (r7 != 0) goto L_0x04a6
            r2 = r33
            if (r0 != r2) goto L_0x04a1
            goto L_0x04ac
        L_0x04a1:
            com.google.android.gms.internal.measurement.zzkh r0 = com.google.android.gms.internal.measurement.zzkh.zze()
            throw r0
        L_0x04a6:
            r2 = r33
            if (r0 > r2) goto L_0x04ad
            if (r1 != r7) goto L_0x04ad
        L_0x04ac:
            return r0
        L_0x04ad:
            com.google.android.gms.internal.measurement.zzkh r0 = com.google.android.gms.internal.measurement.zzkh.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlf.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzik):int");
    }

    public final Object zze() {
        return ((zzjx) this.zzg).zzl(4, (Object) null, (Object) null);
    }

    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzB = (long) (zzB(this.zzj[i2]) & 1048575);
            Object zzf2 = zzml.zzf(obj, zzB);
            if (zzf2 != null) {
                ((zzkw) zzf2).zzc();
                zzml.zzs(obj, zzB, zzf2);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, (long) this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzik zzik) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zzik);
        } else {
            zzc(obj, bArr, i, i2, 0, zzik);
        }
    }

    public final boolean zzi(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (zzB & 1048575);
            switch (zzA(zzB)) {
                case 0:
                    if (zzL(obj, obj2, i) && Double.doubleToLongBits(zzml.zza(obj, j)) == Double.doubleToLongBits(zzml.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzL(obj, obj2, i) && Float.floatToIntBits(zzml.zzb(obj, j)) == Float.floatToIntBits(zzml.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzL(obj, obj2, i) && zzml.zzd(obj, j) == zzml.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzL(obj, obj2, i) && zzml.zzd(obj, j) == zzml.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzL(obj, obj2, i) && zzml.zzc(obj, j) == zzml.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzL(obj, obj2, i) && zzml.zzd(obj, j) == zzml.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzL(obj, obj2, i) && zzml.zzc(obj, j) == zzml.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzL(obj, obj2, i) && zzml.zzw(obj, j) == zzml.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzL(obj, obj2, i) && zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzL(obj, obj2, i) && zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzL(obj, obj2, i) && zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzL(obj, obj2, i) && zzml.zzc(obj, j) == zzml.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzL(obj, obj2, i) && zzml.zzc(obj, j) == zzml.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzL(obj, obj2, i) && zzml.zzc(obj, j) == zzml.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzL(obj, obj2, i) && zzml.zzd(obj, j) == zzml.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzL(obj, obj2, i) && zzml.zzc(obj, j) == zzml.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzL(obj, obj2, i) && zzml.zzd(obj, j) == zzml.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzL(obj, obj2, i) && zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j));
                    break;
                case 50:
                    z = zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = (long) (zzy(i) & 1048575);
                    if (zzml.zzc(obj, zzy) == zzml.zzc(obj2, zzy) && zzlp.zzH(zzml.zzf(obj, j), zzml.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzj(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(obj2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzB) != 0 && !zzN(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzP(obj2, i7, i6) && !zzO(obj2, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzkw) zzml.zzf(obj2, (long) (zzB & 1048575))).isEmpty()) {
                            zzkv zzkv = (zzkv) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzml.zzf(obj2, (long) (zzB & 1048575));
                if (!list.isEmpty()) {
                    zzln zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzj(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzN(obj, i6, i2, i, i10) && !zzO(obj2, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzm(Object obj, zzjf zzjf) throws IOException {
        if (!this.zzi) {
            zzR(obj, zzjf);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzf(i2, zzml.zza(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzo(i2, zzml.zzb(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzt(i2, zzml.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzJ(i2, zzml.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzr(i2, zzml.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzm(i2, zzml.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzk(i2, zzml.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzb(i2, zzml.zzw(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzT(i2, zzml.zzf(obj, (long) (zzB & 1048575)), zzjf);
                            break;
                        }
                    case 9:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzv(i2, zzml.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 10:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzd(i2, (zzix) zzml.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzH(i2, zzml.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzi(i2, zzml.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzw(i2, zzml.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzy(i2, zzml.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzA(i2, zzml.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzC(i2, zzml.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzM(obj, i)) {
                            break;
                        } else {
                            zzjf.zzq(i2, zzml.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 18:
                        zzlp.zzL(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 19:
                        zzlp.zzP(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 20:
                        zzlp.zzS(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 21:
                        zzlp.zzaa(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 22:
                        zzlp.zzR(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 23:
                        zzlp.zzO(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 24:
                        zzlp.zzN(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 25:
                        zzlp.zzJ(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 26:
                        zzlp.zzY(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf);
                        break;
                    case 27:
                        zzlp.zzT(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, zzE(i));
                        break;
                    case 28:
                        zzlp.zzK(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf);
                        break;
                    case 29:
                        zzlp.zzZ(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 30:
                        zzlp.zzM(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 31:
                        zzlp.zzU(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 32:
                        zzlp.zzV(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 33:
                        zzlp.zzW(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 34:
                        zzlp.zzX(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, false);
                        break;
                    case 35:
                        zzlp.zzL(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 36:
                        zzlp.zzP(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 37:
                        zzlp.zzS(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 38:
                        zzlp.zzaa(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 39:
                        zzlp.zzR(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 40:
                        zzlp.zzO(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 41:
                        zzlp.zzN(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 42:
                        zzlp.zzJ(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 43:
                        zzlp.zzZ(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 44:
                        zzlp.zzM(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 45:
                        zzlp.zzU(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 46:
                        zzlp.zzV(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 47:
                        zzlp.zzW(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 48:
                        zzlp.zzX(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, true);
                        break;
                    case 49:
                        zzlp.zzQ(i2, (List) zzml.zzf(obj, (long) (zzB & 1048575)), zzjf, zzE(i));
                        break;
                    case 50:
                        zzS(zzjf, i2, zzml.zzf(obj, (long) (zzB & 1048575)), i);
                        break;
                    case 51:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzf(i2, zzn(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzo(i2, zzo(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzt(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzJ(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzr(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzm(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzk(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzb(i2, zzQ(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzT(i2, zzml.zzf(obj, (long) (zzB & 1048575)), zzjf);
                            break;
                        }
                    case 60:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzv(i2, zzml.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 61:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzd(i2, (zzix) zzml.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzH(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzi(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzw(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzy(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzA(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzC(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzP(obj, i2, i)) {
                            break;
                        } else {
                            zzjf.zzq(i2, zzml.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                }
            }
            zzmb zzmb = this.zzn;
            zzmb.zzi(zzmb.zzc(obj), zzjf);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    public final void zzg(Object obj, Object obj2) {
        Objects.requireNonNull(obj2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (1048575 & zzB);
            int i2 = this.zzc[i];
            switch (zzA(zzB)) {
                case 0:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzo(obj, j, zzml.zza(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 1:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzp(obj, j, zzml.zzb(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 2:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzr(obj, j, zzml.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 3:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzr(obj, j, zzml.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 4:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzq(obj, j, zzml.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 5:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzr(obj, j, zzml.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 6:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzq(obj, j, zzml.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 7:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzm(obj, j, zzml.zzw(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 8:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzs(obj, j, zzml.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzs(obj, j, zzml.zzf(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 11:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzq(obj, j, zzml.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 12:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzq(obj, j, zzml.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 13:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzq(obj, j, zzml.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 14:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzr(obj, j, zzml.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 15:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzq(obj, j, zzml.zzc(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 16:
                    if (!zzM(obj2, i)) {
                        break;
                    } else {
                        zzml.zzr(obj, j, zzml.zzd(obj2, j));
                        zzJ(obj, i);
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzlp.zzI(this.zzq, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzP(obj2, i2, i)) {
                        break;
                    } else {
                        zzml.zzs(obj, j, zzml.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzP(obj2, i2, i)) {
                        break;
                    } else {
                        zzml.zzs(obj, j, zzml.zzf(obj2, j));
                        zzK(obj, i2, i);
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzlp.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzlp.zzE(this.zzo, obj, obj2);
        }
    }
}
