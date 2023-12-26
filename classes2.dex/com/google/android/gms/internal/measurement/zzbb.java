package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzbb {
    /* JADX WARNING: type inference failed for: r0v124, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020d, code lost:
        if (r1 <= r24.zzc()) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020f, code lost:
        r1 = r24.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0213, code lost:
        r2 = r24.zzc();
        r3 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0221, code lost:
        if (r26.size() <= 1) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0223, code lost:
        r4 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.zzh.zza(r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x023f, code lost:
        if (r4 <= 0) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0241, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0248, code lost:
        if (r5 >= java.lang.Math.min(r2, r1 + r4)) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x024a, code lost:
        r3.zzq(r3.zzc(), r9.zze(r1));
        r9.zzp(r1);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0260, code lost:
        if (r26.size() <= 2) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0262, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0267, code lost:
        if (r2 >= r26.size()) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0269, code lost:
        r4 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0275, code lost:
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0281;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0277, code lost:
        r9.zzo((r1 + r2) - 2, r4);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0288, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0289, code lost:
        if (r1 >= r2) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x028b, code lost:
        r3.zzq(r3.zzc(), r9.zze(r1));
        r9.zzq(r1, (com.google.android.gms.internal.measurement.zzap) null);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x029f, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ae, code lost:
        if (r24.zzc() >= 2) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02b1, code lost:
        r1 = r24.zzm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02b9, code lost:
        if (r26.isEmpty() != false) goto L_0x02d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02bb, code lost:
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02c8, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ca, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02d5, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d6, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d7, code lost:
        java.util.Collections.sort(r1, new com.google.android.gms.internal.measurement.zzba(r3, r6));
        r24.zzn();
        r0 = r1.iterator();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02eb, code lost:
        if (r0.hasNext() == false) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02ed, code lost:
        r9.zzq(r2, (com.google.android.gms.internal.measurement.zzap) r0.next());
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02fa, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02fb, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("some", 1, r0);
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0312, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x036b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0318, code lost:
        if (r24.zzc() != 0) goto L_0x031d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x031d, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
        r1 = r24.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0327, code lost:
        if (r1.hasNext() == false) goto L_0x0368;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0329, code lost:
        r2 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0337, code lost:
        if (r9.zzs(r2) == false) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0363, code lost:
        if (r0.zza(r6, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r9.zze(r2), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2)), r9})).zzg().booleanValue() == false) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0370, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0371, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x037f, code lost:
        if (r26.isEmpty() == false) goto L_0x0386;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0386, code lost:
        r1 = (double) r24.zzc();
        r7 = com.google.android.gms.internal.measurement.zzh.zza(r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a4, code lost:
        if (r7 >= 0.0d) goto L_0x03ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03a6, code lost:
        r7 = java.lang.Math.max(r7 + r1, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ac, code lost:
        r7 = java.lang.Math.min(r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03b5, code lost:
        if (r26.size() != 2) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03b7, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03d0, code lost:
        if (r5 >= 0.0d) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03d2, code lost:
        r1 = java.lang.Math.max(r1 + r5, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03d8, code lost:
        r1 = java.lang.Math.min(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03dc, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r3 = (int) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03e5, code lost:
        if (((double) r3) >= r1) goto L_0x03f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03e7, code lost:
        r0.zzq(r0.zzc(), r9.zze(r3));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03f6, code lost:
        r9 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("shift", 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0402, code lost:
        if (r24.zzc() != 0) goto L_0x0407;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0407, code lost:
        r0 = r9.zze(0);
        r9.zzp(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x040f, code lost:
        r9 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("reverse", 0, r26);
        r0 = r24.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x041b, code lost:
        if (r0 == 0) goto L_0x0446;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x041d, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0420, code lost:
        if (r2 >= (r0 / 2)) goto L_0x0446;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0426, code lost:
        if (r9.zzs(r2) == false) goto L_0x0443;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0428, code lost:
        r1 = r9.zze(r2);
        r9.zzq(r2, (com.google.android.gms.internal.measurement.zzap) null);
        r3 = (r0 - 1) - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0437, code lost:
        if (r9.zzs(r3) == false) goto L_0x0440;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0439, code lost:
        r9.zzq(r2, r9.zze(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0440, code lost:
        r9.zzq(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0443, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0446, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0452, code lost:
        return zzc(r24, r25, r26, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x045e, code lost:
        return zzc(r24, r25, r26, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x045f, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0469, code lost:
        if (r26.isEmpty() != false) goto L_0x0487;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x046b, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0473, code lost:
        if (r0.hasNext() == false) goto L_0x0487;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0475, code lost:
        r9.zzq(r24.zzc(), r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0495, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0496, code lost:
        r9 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("pop", 0, r26);
        r0 = r24.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04a2, code lost:
        if (r0 != 0) goto L_0x04a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04a7, code lost:
        r0 = r0 - 1;
        r1 = r9.zze(r0);
        r9.zzp(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04b2, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("map", 1, r0);
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04c9, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04cf, code lost:
        if (r24.zzc() != 0) goto L_0x04d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04e4, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04e5, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04f5, code lost:
        if (r26.isEmpty() != false) goto L_0x0502;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04f7, code lost:
        r1 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0502, code lost:
        r7 = (double) (r24.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x050e, code lost:
        if (r26.size() <= 1) goto L_0x0547;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0510, code lost:
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0526, code lost:
        if (java.lang.Double.isNaN(r0.zzh().doubleValue()) == false) goto L_0x0530;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0528, code lost:
        r5 = (double) (r24.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0530, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r0.zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x053c, code lost:
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x053f, code lost:
        if (r7 >= 0.0d) goto L_0x0547;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0541, code lost:
        r7 = r7 + ((double) r24.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0549, code lost:
        if (r7 >= 0.0d) goto L_0x0555;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0555, code lost:
        r0 = (int) java.lang.Math.min((double) r24.zzc(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x055f, code lost:
        if (r0 < 0) goto L_0x0580;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0565, code lost:
        if (r9.zzs(r0) == false) goto L_0x057d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x056f, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r9.zze(r0), r1) == false) goto L_0x057d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x057d, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x058a, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0598, code lost:
        if (r24.zzc() != 0) goto L_0x059d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x05a1, code lost:
        if (r26.size() <= 0) goto L_0x05bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05a3, code lost:
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05b0, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) != false) goto L_0x05bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05b4, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzau) == false) goto L_0x05b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05b7, code lost:
        r0 = r0.zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05bc, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x05bf, code lost:
        r0 = ",";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05cc, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x05dc, code lost:
        if (r26.isEmpty() != false) goto L_0x05e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x05de, code lost:
        r1 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05ee, code lost:
        if (r26.size() <= 1) goto L_0x0626;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05f0, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x060d, code lost:
        if (r5 < ((double) r24.zzc())) goto L_0x0619;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x061b, code lost:
        if (r5 >= 0.0d) goto L_0x0625;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x061d, code lost:
        r3 = ((double) r24.zzc()) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0625, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0626, code lost:
        r0 = r24.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x062e, code lost:
        if (r0.hasNext() == false) goto L_0x0653;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0630, code lost:
        r2 = ((java.lang.Integer) r0.next()).intValue();
        r5 = (double) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x063d, code lost:
        if (r5 < r3) goto L_0x062a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0647, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r9.zze(r2), r1) == false) goto L_0x062a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x065d, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh(r21, 1, r0);
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0676, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x068a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x067c, code lost:
        if (r24.zzb() != 0) goto L_0x0681;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0681, code lost:
        zzb(r9, r6, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x068f, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0690, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh(r22, 1, r0);
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x06a9, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x06ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06af, code lost:
        if (r24.zzb() != 0) goto L_0x06b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06b7, code lost:
        r2 = r24.zzd();
        r0 = zzb(r9, r6, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, true);
        r1 = new com.google.android.gms.internal.measurement.zzae();
        r0 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x06cf, code lost:
        if (r0.hasNext() == false) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x06d1, code lost:
        r1.zzq(r1.zzc(), ((com.google.android.gms.internal.measurement.zzae) r2).zze(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06f1, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06f2, code lost:
        r3 = r24;
        r6 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("every", 1, r0);
        r0 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0709, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x072e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x070f, code lost:
        if (r24.zzc() != 0) goto L_0x0714;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0726, code lost:
        if (zzb(r3, r6, (com.google.android.gms.internal.measurement.zzao) r0, false, true).zzc() == r24.zzc()) goto L_0x072b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0036, code lost:
        r2 = r17;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0733, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0734, code lost:
        r3 = r24;
        r6 = r25;
        r0 = r26;
        r1 = r24.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0742, code lost:
        if (r26.isEmpty() != false) goto L_0x0796;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0744, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x074c, code lost:
        if (r0.hasNext() == false) goto L_0x0796;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x074e, code lost:
        r2 = r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x075a, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x078e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x075c, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzae) r1;
        r4 = r3.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0765, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzae) == false) goto L_0x078a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0767, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r2;
        r5 = r2.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0771, code lost:
        if (r5.hasNext() == false) goto L_0x0748;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0773, code lost:
        r7 = (java.lang.Integer) r5.next();
        r3.zzq(r7.intValue() + r4, r2.zze(r7.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x078a, code lost:
        r3.zzq(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0795, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0796, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:?, code lost:
        return r24.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:?, code lost:
        return zzb(r9, r6, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r9.zzj(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e2, code lost:
        r2 = r17;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0101, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0111, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0113, code lost:
        r17 = r2;
        r21 = "forEach";
        r22 = r4;
        r3 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011f, code lost:
        switch(r0) {
            case 0: goto L_0x0734;
            case 1: goto L_0x06f2;
            case 2: goto L_0x0690;
            case 3: goto L_0x065d;
            case 4: goto L_0x05cc;
            case 5: goto L_0x058a;
            case 6: goto L_0x04e5;
            case 7: goto L_0x04b2;
            case 8: goto L_0x0496;
            case 9: goto L_0x045f;
            case 10: goto L_0x0453;
            case 11: goto L_0x0447;
            case 12: goto L_0x040f;
            case 13: goto L_0x03f6;
            case 14: goto L_0x0371;
            case 15: goto L_0x02fb;
            case 16: goto L_0x029f;
            case 17: goto L_0x01d2;
            case 18: goto L_0x01bc;
            case 19: goto L_0x012a;
            default: goto L_0x0122;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0129, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012e, code lost:
        if (r26.isEmpty() != false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0130, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013d, code lost:
        if (r1.hasNext() == false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013f, code lost:
        r2 = r25.zzb((com.google.android.gms.internal.measurement.zzap) r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014d, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x014f, code lost:
        r0.zzq(r0.zzc(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015e, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x015f, code lost:
        r1 = r0.zzc();
        r2 = r24.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x016b, code lost:
        if (r2.hasNext() == false) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016d, code lost:
        r3 = (java.lang.Integer) r2.next();
        r0.zzq(r3.intValue() + r1, r24.zze(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0186, code lost:
        r9 = r24;
        r24.zzn();
        r1 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0193, code lost:
        if (r1.hasNext() == false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0195, code lost:
        r2 = (java.lang.Integer) r1.next();
        r9.zzq(r2.intValue(), r0.zze(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ab, code lost:
        r9 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01bb, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01bc, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r17, 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d1, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r24.zzj(","));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d2, code lost:
        r9 = r24;
        r6 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01dd, code lost:
        if (r26.isEmpty() == false) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e6, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r6.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01fd, code lost:
        if (r1 >= 0) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ff, code lost:
        r1 = java.lang.Math.max(0, r1 + r24.zzc());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzap zza(java.lang.String r23, com.google.android.gms.internal.measurement.zzae r24, com.google.android.gms.internal.measurement.zzg r25, java.util.List r26) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            int r4 = r23.hashCode()
            java.lang.String r5 = "indexOf"
            java.lang.String r6 = "reverse"
            java.lang.String r7 = "slice"
            java.lang.String r8 = "shift"
            java.lang.String r9 = "every"
            java.lang.String r10 = "sort"
            java.lang.String r11 = "some"
            java.lang.String r12 = "join"
            java.lang.String r13 = "pop"
            java.lang.String r14 = "map"
            java.lang.String r15 = "lastIndexOf"
            java.lang.String r3 = "forEach"
            java.lang.String r1 = "filter"
            java.lang.String r2 = "toString"
            r16 = -1
            r17 = r2
            r2 = 1
            r18 = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            switch(r4) {
                case -1776922004: goto L_0x0104;
                case -1354795244: goto L_0x00f3;
                case -1274492040: goto L_0x00e7;
                case -934873754: goto L_0x00d8;
                case -895859076: goto L_0x00cd;
                case -678635926: goto L_0x00c5;
                case -467511597: goto L_0x00bd;
                case -277637751: goto L_0x00b2;
                case 107868: goto L_0x00aa;
                case 111185: goto L_0x00a1;
                case 3267882: goto L_0x0099;
                case 3452698: goto L_0x008e;
                case 3536116: goto L_0x0085;
                case 3536286: goto L_0x007c;
                case 96891675: goto L_0x006f;
                case 109407362: goto L_0x0065;
                case 109526418: goto L_0x005b;
                case 965561430: goto L_0x004f;
                case 1099846370: goto L_0x0045;
                case 1943291465: goto L_0x003c;
                default: goto L_0x0036;
            }
        L_0x0036:
            r2 = r17
            r4 = r18
            goto L_0x0111
        L_0x003c:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0036
            r0 = 4
            goto L_0x00e2
        L_0x0045:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0036
            r0 = 12
            goto L_0x00e2
        L_0x004f:
            java.lang.String r4 = "reduceRight"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0036
            r0 = 11
            goto L_0x00e2
        L_0x005b:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0036
            r0 = 14
            goto L_0x00e2
        L_0x0065:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0036
            r0 = 13
            goto L_0x00e2
        L_0x006f:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0036
            r2 = r17
            r4 = r18
            r0 = 1
            goto L_0x0113
        L_0x007c:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0036
            r0 = 16
            goto L_0x00e2
        L_0x0085:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0036
            r0 = 15
            goto L_0x00e2
        L_0x008e:
            java.lang.String r4 = "push"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0036
            r0 = 9
            goto L_0x00e2
        L_0x0099:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0036
            r0 = 5
            goto L_0x00e2
        L_0x00a1:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0036
            r0 = 8
            goto L_0x00e2
        L_0x00aa:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0036
            r0 = 7
            goto L_0x00e2
        L_0x00b2:
            java.lang.String r4 = "unshift"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0036
            r0 = 19
            goto L_0x00e2
        L_0x00bd:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0036
            r0 = 6
            goto L_0x00e2
        L_0x00c5:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0036
            r0 = 3
            goto L_0x00e2
        L_0x00cd:
            java.lang.String r4 = "splice"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0036
            r0 = 17
            goto L_0x00e2
        L_0x00d8:
            java.lang.String r4 = "reduce"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0036
            r0 = 10
        L_0x00e2:
            r2 = r17
            r4 = r18
            goto L_0x0113
        L_0x00e7:
            r4 = r18
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0101
            r2 = r17
            r0 = 2
            goto L_0x0113
        L_0x00f3:
            r4 = r18
            java.lang.String r2 = "concat"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0101
            r2 = r17
            r0 = 0
            goto L_0x0113
        L_0x0101:
            r2 = r17
            goto L_0x0111
        L_0x0104:
            r2 = r17
            r4 = r18
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0111
            r0 = 18
            goto L_0x0113
        L_0x0111:
            r0 = r16
        L_0x0113:
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r17 = r2
            java.lang.String r2 = "Callback should be a method"
            r21 = r3
            r22 = r4
            r3 = 0
            switch(r0) {
                case 0: goto L_0x0734;
                case 1: goto L_0x06f2;
                case 2: goto L_0x0690;
                case 3: goto L_0x065d;
                case 4: goto L_0x05cc;
                case 5: goto L_0x058a;
                case 6: goto L_0x04e5;
                case 7: goto L_0x04b2;
                case 8: goto L_0x0496;
                case 9: goto L_0x045f;
                case 10: goto L_0x0453;
                case 11: goto L_0x0447;
                case 12: goto L_0x040f;
                case 13: goto L_0x03f6;
                case 14: goto L_0x0371;
                case 15: goto L_0x02fb;
                case 16: goto L_0x029f;
                case 17: goto L_0x01d2;
                case 18: goto L_0x01bc;
                case 19: goto L_0x012a;
                default: goto L_0x0122;
            }
        L_0x0122:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x012a:
            boolean r0 = r26.isEmpty()
            if (r0 != 0) goto L_0x01ab
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            java.util.Iterator r1 = r26.iterator()
        L_0x0139:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x015f
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            r6 = r25
            com.google.android.gms.internal.measurement.zzap r2 = r6.zzb(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r3 != 0) goto L_0x0157
            int r3 = r0.zzc()
            r0.zzq(r3, r2)
            goto L_0x0139
        L_0x0157:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x015f:
            int r1 = r0.zzc()
            java.util.Iterator r2 = r24.zzk()
        L_0x0167:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0186
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r9 = r24
            com.google.android.gms.internal.measurement.zzap r3 = r9.zze(r3)
            r0.zzq(r4, r3)
            goto L_0x0167
        L_0x0186:
            r9 = r24
            r24.zzn()
            java.util.Iterator r1 = r0.zzk()
        L_0x018f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01ad
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzap r2 = r0.zze(r2)
            r9.zzq(r3, r2)
            goto L_0x018f
        L_0x01ab:
            r9 = r24
        L_0x01ad:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x01bc:
            r9 = r24
            r0 = r26
            r1 = r17
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r1, r2, r0)
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = ","
            java.lang.String r1 = r9.zzj(r1)
            r0.<init>(r1)
            return r0
        L_0x01d2:
            r9 = r24
            r6 = r25
            r0 = r26
            r2 = 0
            boolean r1 = r26.isEmpty()
            if (r1 == 0) goto L_0x01e6
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x029e
        L_0x01e6:
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r6.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            int r1 = (int) r3
            if (r1 >= 0) goto L_0x0209
            int r3 = r24.zzc()
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r2, r1)
            goto L_0x0213
        L_0x0209:
            int r2 = r24.zzc()
            if (r1 <= r2) goto L_0x0213
            int r1 = r24.zzc()
        L_0x0213:
            int r2 = r24.zzc()
            com.google.android.gms.internal.measurement.zzae r3 = new com.google.android.gms.internal.measurement.zzae
            r3.<init>()
            int r4 = r26.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0289
            java.lang.Object r4 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r6.zzb(r4)
            java.lang.Double r4 = r4.zzh()
            double r4 = r4.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            int r4 = (int) r4
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            if (r4 <= 0) goto L_0x025b
            r5 = r1
        L_0x0242:
            int r7 = r1 + r4
            int r7 = java.lang.Math.min(r2, r7)
            if (r5 >= r7) goto L_0x025b
            com.google.android.gms.internal.measurement.zzap r7 = r9.zze(r1)
            int r8 = r3.zzc()
            r3.zzq(r8, r7)
            r9.zzp(r1)
            int r5 = r5 + 1
            goto L_0x0242
        L_0x025b:
            int r2 = r26.size()
            r4 = 2
            if (r2 <= r4) goto L_0x029d
            r2 = 2
        L_0x0263:
            int r4 = r26.size()
            if (r2 >= r4) goto L_0x029d
            java.lang.Object r4 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r6.zzb(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzag
            if (r5 != 0) goto L_0x0281
            int r5 = r1 + r2
            int r5 = r5 + -2
            r9.zzo(r5, r4)
            int r2 = r2 + 1
            goto L_0x0263
        L_0x0281:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0289:
            if (r1 >= r2) goto L_0x029d
            com.google.android.gms.internal.measurement.zzap r0 = r9.zze(r1)
            int r4 = r3.zzc()
            r3.zzq(r4, r0)
            r0 = 0
            r9.zzq(r1, r0)
            int r1 = r1 + 1
            goto L_0x0289
        L_0x029d:
            r0 = r3
        L_0x029e:
            return r0
        L_0x029f:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r1, r0)
            int r1 = r24.zzc()
            r2 = 2
            if (r1 >= r2) goto L_0x02b1
            goto L_0x02fa
        L_0x02b1:
            java.util.List r1 = r24.zzm()
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x02d6
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r2 == 0) goto L_0x02ce
            r3 = r0
            com.google.android.gms.internal.measurement.zzai r3 = (com.google.android.gms.internal.measurement.zzai) r3
            goto L_0x02d7
        L_0x02ce:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02d6:
            r3 = 0
        L_0x02d7:
            com.google.android.gms.internal.measurement.zzba r0 = new com.google.android.gms.internal.measurement.zzba
            r0.<init>(r3, r6)
            java.util.Collections.sort(r1, r0)
            r24.zzn()
            java.util.Iterator r0 = r1.iterator()
            r2 = 0
        L_0x02e7:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02fa
            int r1 = r2 + 1
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            r9.zzq(r2, r3)
            r2 = r1
            goto L_0x02e7
        L_0x02fa:
            return r9
        L_0x02fb:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r11, r1, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x036b
            int r1 = r24.zzc()
            if (r1 != 0) goto L_0x031d
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x036a
        L_0x031d:
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            java.util.Iterator r1 = r24.zzk()
        L_0x0323:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0368
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r3 = r9.zzs(r2)
            if (r3 == 0) goto L_0x0323
            r3 = 3
            com.google.android.gms.internal.measurement.zzap[] r3 = new com.google.android.gms.internal.measurement.zzap[r3]
            com.google.android.gms.internal.measurement.zzap r4 = r9.zze(r2)
            r5 = 0
            r3[r5] = r4
            com.google.android.gms.internal.measurement.zzah r4 = new com.google.android.gms.internal.measurement.zzah
            double r7 = (double) r2
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            r4.<init>(r2)
            r2 = 1
            r3[r2] = r4
            r2 = 2
            r3[r2] = r9
            java.util.List r2 = java.util.Arrays.asList(r3)
            com.google.android.gms.internal.measurement.zzap r2 = r0.zza(r6, r2)
            java.lang.Boolean r2 = r2.zzg()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0323
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x036a
        L_0x0368:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
        L_0x036a:
            return r0
        L_0x036b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x0371:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r1, r0)
            boolean r1 = r26.isEmpty()
            if (r1 == 0) goto L_0x0386
            com.google.android.gms.internal.measurement.zzap r0 = r24.zzd()
            goto L_0x03f5
        L_0x0386:
            int r1 = r24.zzc()
            double r1 = (double) r1
            r5 = 0
            java.lang.Object r5 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r6.zzb(r5)
            java.lang.Double r5 = r5.zzh()
            double r7 = r5.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.zzh.zza(r7)
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x03ac
            double r7 = r7 + r1
            double r7 = java.lang.Math.max(r7, r3)
            goto L_0x03b0
        L_0x03ac:
            double r7 = java.lang.Math.min(r7, r1)
        L_0x03b0:
            int r5 = r26.size()
            r10 = 2
            if (r5 != r10) goto L_0x03dc
            r5 = 1
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x03d8
            double r1 = r1 + r5
            double r1 = java.lang.Math.max(r1, r3)
            goto L_0x03dc
        L_0x03d8:
            double r1 = java.lang.Math.min(r1, r5)
        L_0x03dc:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            int r3 = (int) r7
        L_0x03e2:
            double r4 = (double) r3
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x03f5
            com.google.android.gms.internal.measurement.zzap r4 = r9.zze(r3)
            int r5 = r0.zzc()
            r0.zzq(r5, r4)
            int r3 = r3 + 1
            goto L_0x03e2
        L_0x03f5:
            return r0
        L_0x03f6:
            r9 = r24
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r1, r0)
            int r0 = r24.zzc()
            if (r0 != 0) goto L_0x0407
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x040e
        L_0x0407:
            com.google.android.gms.internal.measurement.zzap r0 = r9.zze(r1)
            r9.zzp(r1)
        L_0x040e:
            return r0
        L_0x040f:
            r9 = r24
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r1, r0)
            int r0 = r24.zzc()
            if (r0 == 0) goto L_0x0446
            r2 = 0
        L_0x041e:
            int r1 = r0 / 2
            if (r2 >= r1) goto L_0x0446
            boolean r1 = r9.zzs(r2)
            if (r1 == 0) goto L_0x0443
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r2)
            r3 = 0
            r9.zzq(r2, r3)
            int r3 = r0 + -1
            int r3 = r3 - r2
            boolean r4 = r9.zzs(r3)
            if (r4 == 0) goto L_0x0440
            com.google.android.gms.internal.measurement.zzap r4 = r9.zze(r3)
            r9.zzq(r2, r4)
        L_0x0440:
            r9.zzq(r3, r1)
        L_0x0443:
            int r2 = r2 + 1
            goto L_0x041e
        L_0x0446:
            return r9
        L_0x0447:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r9, r6, r0, r1)
            return r0
        L_0x0453:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 1
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r9, r6, r0, r1)
            return r0
        L_0x045f:
            r9 = r24
            r6 = r25
            r0 = r26
            boolean r1 = r26.isEmpty()
            if (r1 != 0) goto L_0x0487
            java.util.Iterator r0 = r26.iterator()
        L_0x046f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0487
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r6.zzb(r1)
            int r2 = r24.zzc()
            r9.zzq(r2, r1)
            goto L_0x046f
        L_0x0487:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0496:
            r9 = r24
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r13, r1, r0)
            int r0 = r24.zzc()
            if (r0 != 0) goto L_0x04a7
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x04b1
        L_0x04a7:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r0)
            r9.zzp(r0)
            r0 = r1
        L_0x04b1:
            return r0
        L_0x04b2:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 0
            r3 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r3, r0)
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r1 == 0) goto L_0x04df
            int r1 = r24.zzc()
            if (r1 != 0) goto L_0x04d7
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x04de
        L_0x04d7:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r1 = 0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r9, r6, r0, r1, r1)
        L_0x04de:
            return r0
        L_0x04df:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x04e5:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r1, r0)
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x0502
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r6.zzb(r1)
        L_0x0502:
            int r2 = r24.zzc()
            int r2 = r2 + -1
            double r7 = (double) r2
            int r2 = r26.size()
            r5 = 1
            if (r2 <= r5) goto L_0x0547
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            java.lang.Double r2 = r0.zzh()
            double r5 = r2.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r5)
            if (r2 == 0) goto L_0x0530
            int r0 = r24.zzc()
            int r0 = r0 + -1
            double r5 = (double) r0
            goto L_0x053c
        L_0x0530:
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
        L_0x053c:
            r7 = r5
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0547
            int r0 = r24.zzc()
            double r5 = (double) r0
            double r7 = r7 + r5
        L_0x0547:
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0555
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x0589
        L_0x0555:
            int r0 = r24.zzc()
            double r2 = (double) r0
            double r2 = java.lang.Math.min(r2, r7)
            int r0 = (int) r2
        L_0x055f:
            if (r0 < 0) goto L_0x0580
            boolean r2 = r9.zzs(r0)
            if (r2 == 0) goto L_0x057d
            com.google.android.gms.internal.measurement.zzap r2 = r9.zze(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzh.zzl(r2, r1)
            if (r2 == 0) goto L_0x057d
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            r0 = r1
            goto L_0x0589
        L_0x057d:
            int r0 = r0 + -1
            goto L_0x055f
        L_0x0580:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
        L_0x0589:
            return r0
        L_0x058a:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r12, r1, r0)
            int r1 = r24.zzc()
            if (r1 != 0) goto L_0x059d
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzm
            goto L_0x05cb
        L_0x059d:
            int r1 = r26.size()
            if (r1 <= 0) goto L_0x05bf
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r1 != 0) goto L_0x05bc
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzau
            if (r1 == 0) goto L_0x05b7
            goto L_0x05bc
        L_0x05b7:
            java.lang.String r0 = r0.zzi()
            goto L_0x05c1
        L_0x05bc:
            java.lang.String r0 = ""
            goto L_0x05c1
        L_0x05bf:
            java.lang.String r0 = ","
        L_0x05c1:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r9.zzj(r0)
            r1.<init>(r0)
            r0 = r1
        L_0x05cb:
            return r0
        L_0x05cc:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r5, r1, r0)
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05e9
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r6.zzb(r1)
        L_0x05e9:
            int r2 = r26.size()
            r5 = 1
            if (r2 <= r5) goto L_0x0626
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r0 = r24.zzc()
            double r7 = (double) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0619
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x065c
        L_0x0619:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0625
            int r0 = r24.zzc()
            double r2 = (double) r0
            double r3 = r2 + r5
            goto L_0x0626
        L_0x0625:
            r3 = r5
        L_0x0626:
            java.util.Iterator r0 = r24.zzk()
        L_0x062a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0653
            java.lang.Object r2 = r0.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            double r5 = (double) r2
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x062a
            com.google.android.gms.internal.measurement.zzap r2 = r9.zze(r2)
            boolean r2 = com.google.android.gms.internal.measurement.zzh.zzl(r2, r1)
            if (r2 == 0) goto L_0x062a
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            r0.<init>(r1)
            goto L_0x065c
        L_0x0653:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
        L_0x065c:
            return r0
        L_0x065d:
            r9 = r24
            r6 = r25
            r0 = r26
            r1 = r21
            r3 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r1, r3, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r1 == 0) goto L_0x068a
            int r1 = r24.zzb()
            if (r1 != 0) goto L_0x0681
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0689
        L_0x0681:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r1 = 0
            zzb(r9, r6, r0, r1, r1)
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0689:
            return r0
        L_0x068a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x0690:
            r9 = r24
            r6 = r25
            r0 = r26
            r3 = r22
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r3, r4, r0)
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r3 == 0) goto L_0x06ec
            int r2 = r24.zzb()
            if (r2 != 0) goto L_0x06b7
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x06eb
        L_0x06b7:
            com.google.android.gms.internal.measurement.zzap r2 = r24.zzd()
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r3 = 0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r9, r6, r0, r3, r1)
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r1.<init>()
            java.util.Iterator r0 = r0.zzk()
        L_0x06cb:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x06ea
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r2
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            com.google.android.gms.internal.measurement.zzap r3 = r4.zze(r3)
            int r4 = r1.zzc()
            r1.zzq(r4, r3)
            goto L_0x06cb
        L_0x06ea:
            r0 = r1
        L_0x06eb:
            return r0
        L_0x06ec:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x06f2:
            r3 = r24
            r6 = r25
            r0 = r26
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r9, r4, r0)
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r6.zzb(r0)
            boolean r5 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r5 == 0) goto L_0x072e
            int r2 = r24.zzc()
            if (r2 != 0) goto L_0x0714
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x072d
        L_0x0714:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r3, r6, r0, r2, r1)
            int r0 = r0.zzc()
            int r1 = r24.zzc()
            if (r0 == r1) goto L_0x072b
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x072d
        L_0x072b:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
        L_0x072d:
            return r0
        L_0x072e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r2)
            throw r0
        L_0x0734:
            r3 = r24
            r6 = r25
            r0 = r26
            com.google.android.gms.internal.measurement.zzap r1 = r24.zzd()
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x0796
            java.util.Iterator r0 = r26.iterator()
        L_0x0748:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0796
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            com.google.android.gms.internal.measurement.zzap r2 = r6.zzb(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r3 != 0) goto L_0x078e
            r3 = r1
            com.google.android.gms.internal.measurement.zzae r3 = (com.google.android.gms.internal.measurement.zzae) r3
            int r4 = r3.zzc()
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r5 == 0) goto L_0x078a
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            java.util.Iterator r5 = r2.zzk()
        L_0x076d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0748
            java.lang.Object r7 = r5.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r8 = r7.intValue()
            int r7 = r7.intValue()
            com.google.android.gms.internal.measurement.zzap r7 = r2.zze(r7)
            int r8 = r8 + r4
            r3.zzq(r8, r7)
            goto L_0x076d
        L_0x078a:
            r3.zzq(r4, r2)
            goto L_0x0748
        L_0x078e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x0796:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    private static zzae zzb(zzae zzae, zzg zzg, zzai zzai, Boolean bool, Boolean bool2) {
        zzae zzae2 = new zzae();
        Iterator zzk = zzae.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzae.zzs(intValue)) {
                zzap zza = zzai.zza(zzg, Arrays.asList(new zzap[]{zzae.zze(intValue), new zzah(Double.valueOf((double) intValue)), zzae}));
                if (zza.zzg().equals(bool)) {
                    return zzae2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzae2.zzq(intValue, zza);
                }
            }
        }
        return zzae2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzap zzc(com.google.android.gms.internal.measurement.zzae r9, com.google.android.gms.internal.measurement.zzg r10, java.util.List r11, boolean r12) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzi(r0, r1, r11)
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r0, r2, r11)
            r0 = 0
            java.lang.Object r3 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r10.zzb(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzai
            if (r4 == 0) goto L_0x009f
            int r4 = r11.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r11 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzap r11 = (com.google.android.gms.internal.measurement.zzap) r11
            com.google.android.gms.internal.measurement.zzap r11 = r10.zzb(r11)
            boolean r4 = r11 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed to parse initial value"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            int r11 = r9.zzc()
            if (r11 == 0) goto L_0x0097
            r11 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.zzai r3 = (com.google.android.gms.internal.measurement.zzai) r3
            int r4 = r9.zzc()
            if (r12 == 0) goto L_0x0047
            r5 = r0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            r6 = -1
            if (r12 == 0) goto L_0x004e
            int r4 = r4 + r6
            goto L_0x004f
        L_0x004e:
            r4 = r0
        L_0x004f:
            if (r1 == r12) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r6 = r1
        L_0x0053:
            if (r11 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzap r11 = r9.zze(r5)
            goto L_0x0094
        L_0x005a:
            int r12 = r4 - r5
            int r12 = r12 * r6
            if (r12 < 0) goto L_0x0096
            boolean r12 = r9.zzs(r5)
            if (r12 == 0) goto L_0x0094
            r12 = 4
            com.google.android.gms.internal.measurement.zzap[] r12 = new com.google.android.gms.internal.measurement.zzap[r12]
            r12[r0] = r11
            com.google.android.gms.internal.measurement.zzap r11 = r9.zze(r5)
            r12[r1] = r11
            com.google.android.gms.internal.measurement.zzah r11 = new com.google.android.gms.internal.measurement.zzah
            double r7 = (double) r5
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r11.<init>(r7)
            r12[r2] = r11
            r11 = 3
            r12[r11] = r9
            java.util.List r11 = java.util.Arrays.asList(r12)
            com.google.android.gms.internal.measurement.zzap r11 = r3.zza(r10, r11)
            boolean r12 = r11 instanceof com.google.android.gms.internal.measurement.zzag
            if (r12 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Reduce operation failed"
            r9.<init>(r10)
            throw r9
        L_0x0094:
            int r5 = r5 + r6
            goto L_0x005a
        L_0x0096:
            return r11
        L_0x0097:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Empty array with no initial value error"
            r9.<init>(r10)
            throw r9
        L_0x009f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Callback should be a method"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zzc(com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List, boolean):com.google.android.gms.internal.measurement.zzap");
    }
}
