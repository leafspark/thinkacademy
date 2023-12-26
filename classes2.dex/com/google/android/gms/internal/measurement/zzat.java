package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzat implements Iterable, zzap {
    /* access modifiers changed from: private */
    public final String zza;

    public zzat(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.zza.equals(((zzat) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x017e, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0193, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01aa, code lost:
        r13 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh(r18, 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01b6, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLowerCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01cd, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLocaleLowerCase", 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e2, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r5, 0, r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f7, code lost:
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("substring", 2, r1);
        r0 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0206, code lost:
        if (r25.size() <= 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0208, code lost:
        r4 = r24;
        r2 = (int) com.google.android.gms.internal.measurement.zzh.zza(r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0222, code lost:
        r4 = r24;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x022a, code lost:
        if (r25.size() <= 1) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x022c, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0244, code lost:
        r1 = r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0248, code lost:
        r2 = java.lang.Math.min(java.lang.Math.max(r2, 0), r0.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r0.length());
        r3 = new com.google.android.gms.internal.measurement.zzat(r0.substring(java.lang.Math.min(r2, r1), java.lang.Math.max(r2, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0275, code lost:
        r13 = r22;
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("split", 2, r1);
        r2 = r13.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0285, code lost:
        if (r2.length() != 0) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0298, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02a2, code lost:
        if (r25.size() != 0) goto L_0x02a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02a4, code lost:
        r5.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02a9, code lost:
        r3 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02bc, code lost:
        if (r25.size() <= 1) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02be, code lost:
        r6 = com.google.android.gms.internal.measurement.zzh.zzd(r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02d5, code lost:
        r6 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02dc, code lost:
        if (r6 != 0) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02e5, code lost:
        r1 = r2.split(java.util.regex.Pattern.quote(r3), ((int) r6) + 1);
        r2 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02f5, code lost:
        if (r3.equals(r0) == false) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02f7, code lost:
        if (r2 <= 0) goto L_0x030e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f9, code lost:
        r3 = r1[0].equals(r0);
        r4 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0308, code lost:
        if (r1[r4].equals(r0) != false) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x030a, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x030b, code lost:
        r17 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x030e, code lost:
        r4 = r2;
        r17 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0314, code lost:
        if (((long) r2) <= r6) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0316, code lost:
        r4 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0318, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x031a, code lost:
        if (r0 >= r4) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x031c, code lost:
        r5.add(new com.google.android.gms.internal.measurement.zzat(r1[r0]));
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0330, code lost:
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r1);
        r0 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0340, code lost:
        if (r25.size() <= 0) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0342, code lost:
        r2 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0356, code lost:
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0358, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zza(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0360, code lost:
        if (r2 >= 0.0d) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0362, code lost:
        r2 = java.lang.Math.max(((double) r0.length()) + r2, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x036d, code lost:
        r2 = java.lang.Math.min(r2, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0376, code lost:
        r2 = (int) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x037c, code lost:
        if (r25.size() <= 1) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x037e, code lost:
        r3 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0391, code lost:
        r3 = (double) r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0396, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x039e, code lost:
        if (r3 >= 0.0d) goto L_0x03ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a0, code lost:
        r3 = java.lang.Math.max(((double) r0.length()) + r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03ab, code lost:
        r3 = java.lang.Math.min(r3, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b4, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzat(r0.substring(r2, java.lang.Math.max(0, ((int) r3) - r2) + r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c7, code lost:
        r13 = r22;
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("search", 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03d6, code lost:
        if (r25.size() <= 0) goto L_0x03e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03d8, code lost:
        r19 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03e6, code lost:
        r0 = java.util.regex.Pattern.compile(r19).matcher(r13.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03f4, code lost:
        if (r0.find() == false) goto L_0x0406;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0413, code lost:
        r13 = r22;
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("replace", 2, r1);
        r0 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0423, code lost:
        if (r25.size() <= 0) goto L_0x0445;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0425, code lost:
        r19 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0439, code lost:
        if (r25.size() <= 1) goto L_0x0445;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x043b, code lost:
        r0 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0445, code lost:
        r1 = r19;
        r2 = r13.zza;
        r3 = r2.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x044d, code lost:
        if (r3 < 0) goto L_0x0642;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0451, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0478;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0453, code lost:
        r0 = ((com.google.android.gms.internal.measurement.zzai) r0).zza(r4, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r1), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r3)), r13}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0478, code lost:
        r5 = r2.substring(0, r3);
        r0 = r0.zzi();
        r1 = r2.substring(r3 + r1.length());
        r7 = new java.lang.StringBuilder((java.lang.String.valueOf(r5).length() + java.lang.String.valueOf(r0).length()) + java.lang.String.valueOf(r1).length());
        r7.append(r5);
        r7.append(r0);
        r7.append(r1);
        r4 = new com.google.android.gms.internal.measurement.zzat(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04bd, code lost:
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("match", 1, r1);
        r2 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x04cd, code lost:
        if (r25.size() > 0) goto L_0x04d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x04d0, code lost:
        r0 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04df, code lost:
        r0 = java.util.regex.Pattern.compile(r0).matcher(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04eb, code lost:
        if (r0.find() == false) goto L_0x0507;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x050b, code lost:
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj(r20, 2, r1);
        r2 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x051e, code lost:
        if (r25.size() > 0) goto L_0x0521;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0521, code lost:
        r19 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x052f, code lost:
        r0 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0535, code lost:
        if (r25.size() >= 2) goto L_0x053a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0537, code lost:
        r3 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x053a, code lost:
        r3 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0551, code lost:
        if (java.lang.Double.isNaN(r3) == false) goto L_0x0556;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0553, code lost:
        r3 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0556, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x056b, code lost:
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r1);
        r2 = r22.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x057d, code lost:
        if (r25.size() > 0) goto L_0x0580;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0580, code lost:
        r19 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x058f, code lost:
        r3 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0595, code lost:
        if (r25.size() >= 2) goto L_0x0599;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0597, code lost:
        r0 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0599, code lost:
        r0 = r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x05ac, code lost:
        r4 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2.indexOf(r3, (int) com.google.android.gms.internal.measurement.zzh.zza(r0))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x05c2, code lost:
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzh(r3, 1, r1);
        r0 = r22.zza;
        r1 = r24.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x05e3, code lost:
        if ("length".equals(r1.zzi()) == false) goto L_0x05e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05e9, code lost:
        r1 = r1.zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05f7, code lost:
        if (r1 != java.lang.Math.floor(r1)) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05f9, code lost:
        r1 = (int) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x05fa, code lost:
        if (r1 < 0) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0600, code lost:
        if (r1 >= r0.length()) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x060a, code lost:
        r13 = r22;
        r4 = r24;
        r1 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0614, code lost:
        if (r25.size() == 0) goto L_0x0642;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0616, code lost:
        r0 = new java.lang.StringBuilder(r13.zza);
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0622, code lost:
        if (r2 >= r25.size()) goto L_0x0638;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0624, code lost:
        r0.append(r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(r2)).zzi());
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0644, code lost:
        r13 = r22;
        r4 = r24;
        r1 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj(r21, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0654, code lost:
        if (r25.size() <= 0) goto L_0x066f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0656, code lost:
        r0 = (int) com.google.android.gms.internal.measurement.zzh.zza(r4.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x066f, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0670, code lost:
        r1 = r13.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0672, code lost:
        if (r0 < 0) goto L_0x068a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0678, code lost:
        if (r0 < r1.length()) goto L_0x067b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r13}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r0.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2.lastIndexOf(r0, (int) r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:?, code lost:
        return com.google.android.gms.internal.measurement.zzaf.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
        return com.google.android.gms.internal.measurement.zzaf.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:?, code lost:
        return com.google.android.gms.internal.measurement.zzaf.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:?, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(java.lang.String.valueOf(r1.charAt(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        r13 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0123, code lost:
        r13 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0155, code lost:
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0166, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0167, code lost:
        r18 = "toString";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0169, code lost:
        r0 = "";
        r19 = "undefined";
        r20 = "lastIndexOf";
        r21 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0171, code lost:
        switch(r1) {
            case 0: goto L_0x0644;
            case 1: goto L_0x060a;
            case 2: goto L_0x05c2;
            case 3: goto L_0x056b;
            case 4: goto L_0x050b;
            case 5: goto L_0x04bd;
            case 6: goto L_0x0413;
            case 7: goto L_0x03c7;
            case 8: goto L_0x0330;
            case 9: goto L_0x0275;
            case 10: goto L_0x01f7;
            case 11: goto L_0x01e2;
            case 12: goto L_0x01cd;
            case 13: goto L_0x01b6;
            case 14: goto L_0x01aa;
            case 15: goto L_0x0193;
            case 16: goto L_0x017e;
            default: goto L_0x0174;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0174, code lost:
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x017d, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zzbI(java.lang.String r23, com.google.android.gms.internal.measurement.zzg r24, java.util.List r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "indexOf"
            java.lang.String r7 = "replace"
            java.lang.String r8 = "substring"
            java.lang.String r9 = "split"
            java.lang.String r10 = "slice"
            java.lang.String r11 = "match"
            java.lang.String r12 = "lastIndexOf"
            java.lang.String r13 = "toLocaleUpperCase"
            java.lang.String r14 = "search"
            java.lang.String r15 = "toLowerCase"
            java.lang.String r2 = "toLocaleLowerCase"
            java.lang.String r0 = "toString"
            java.lang.String r3 = "hasOwnProperty"
            r16 = r4
            java.lang.String r4 = "toUpperCase"
            r17 = r13
            if (r5 != 0) goto L_0x00a9
            java.lang.String r5 = "concat"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r3.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r12.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r11.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r7.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r14.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r10.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r9.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r8.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r15.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r2.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r0.equals(r1)
            if (r5 != 0) goto L_0x00a9
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x00a9
            r5 = r17
            boolean r17 = r5.equals(r1)
            if (r17 != 0) goto L_0x00ab
            java.lang.String r13 = "trim"
            boolean r13 = r13.equals(r1)
            if (r13 == 0) goto L_0x0097
            goto L_0x00ab
        L_0x0097:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00a9:
            r5 = r17
        L_0x00ab:
            int r13 = r23.hashCode()
            r18 = r3
            switch(r13) {
                case -1789698943: goto L_0x0158;
                case -1776922004: goto L_0x014b;
                case -1464939364: goto L_0x0140;
                case -1361633751: goto L_0x0134;
                case -1354795244: goto L_0x0126;
                case -1137582698: goto L_0x011b;
                case -906336856: goto L_0x0113;
                case -726908483: goto L_0x010a;
                case -467511597: goto L_0x0102;
                case -399551817: goto L_0x00f9;
                case 3568674: goto L_0x00ee;
                case 103668165: goto L_0x00e6;
                case 109526418: goto L_0x00dd;
                case 109648666: goto L_0x00d4;
                case 530542161: goto L_0x00cb;
                case 1094496948: goto L_0x00c3;
                case 1943291465: goto L_0x00ba;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            r13 = r16
        L_0x00b6:
            r3 = r18
            goto L_0x0166
        L_0x00ba:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00b4
            r1 = 3
            goto L_0x0123
        L_0x00c3:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00b4
            r1 = 6
            goto L_0x0123
        L_0x00cb:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00b4
            r1 = 10
            goto L_0x0123
        L_0x00d4:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00b4
            r1 = 9
            goto L_0x0123
        L_0x00dd:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00b4
            r1 = 8
            goto L_0x0123
        L_0x00e6:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00b4
            r1 = 5
            goto L_0x0123
        L_0x00ee:
            java.lang.String r13 = "trim"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00b4
            r1 = 16
            goto L_0x0123
        L_0x00f9:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00b4
            r1 = 15
            goto L_0x0123
        L_0x0102:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00b4
            r1 = 4
            goto L_0x0123
        L_0x010a:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00b4
            r1 = 11
            goto L_0x0123
        L_0x0113:
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00b4
            r1 = 7
            goto L_0x0123
        L_0x011b:
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00b4
            r1 = 13
        L_0x0123:
            r13 = r16
            goto L_0x0155
        L_0x0126:
            java.lang.String r13 = "concat"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00b4
            r13 = r16
            r3 = r18
            r1 = 1
            goto L_0x0167
        L_0x0134:
            r13 = r16
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00b6
            r3 = r18
            r1 = 0
            goto L_0x0167
        L_0x0140:
            r13 = r16
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00b6
            r1 = 12
            goto L_0x0155
        L_0x014b:
            r13 = r16
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b6
            r1 = 14
        L_0x0155:
            r3 = r18
            goto L_0x0167
        L_0x0158:
            r13 = r16
            r3 = r18
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0166
            r18 = r0
            r1 = 2
            goto L_0x0169
        L_0x0166:
            r1 = -1
        L_0x0167:
            r18 = r0
        L_0x0169:
            java.lang.String r0 = ""
            java.lang.String r19 = "undefined"
            r20 = r12
            r21 = r13
            switch(r1) {
                case 0: goto L_0x0644;
                case 1: goto L_0x060a;
                case 2: goto L_0x05c2;
                case 3: goto L_0x056b;
                case 4: goto L_0x050b;
                case 5: goto L_0x04bd;
                case 6: goto L_0x0413;
                case 7: goto L_0x03c7;
                case 8: goto L_0x0330;
                case 9: goto L_0x0275;
                case 10: goto L_0x01f7;
                case 11: goto L_0x01e2;
                case 12: goto L_0x01cd;
                case 13: goto L_0x01b6;
                case 14: goto L_0x01aa;
                case 15: goto L_0x0193;
                case 16: goto L_0x017e;
                default: goto L_0x0174;
            }
        L_0x0174:
            r13 = r22
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x017e:
            r1 = r25
            r12 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r4, r12, r1)
            r13 = r22
            java.lang.String r0 = r13.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
            goto L_0x068c
        L_0x0193:
            r12 = 0
            r13 = r22
            r1 = r25
            com.google.android.gms.internal.measurement.zzh.zzh(r4, r12, r1)
            java.lang.String r0 = r13.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            goto L_0x068c
        L_0x01aa:
            r12 = 0
            r13 = r22
            r1 = r25
            r0 = r18
            com.google.android.gms.internal.measurement.zzh.zzh(r0, r12, r1)
            goto L_0x0642
        L_0x01b6:
            r12 = 0
            r13 = r22
            r1 = r25
            com.google.android.gms.internal.measurement.zzh.zzh(r15, r12, r1)
            java.lang.String r0 = r13.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            goto L_0x068c
        L_0x01cd:
            r12 = 0
            r13 = r22
            r1 = r25
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r12, r1)
            java.lang.String r0 = r13.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            goto L_0x068c
        L_0x01e2:
            r12 = 0
            r13 = r22
            r1 = r25
            com.google.android.gms.internal.measurement.zzh.zzh(r5, r12, r1)
            java.lang.String r0 = r13.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            goto L_0x068c
        L_0x01f7:
            r13 = r22
            r1 = r25
            r0 = 2
            r12 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r8, r0, r1)
            java.lang.String r0 = r13.zza
            int r2 = r25.size()
            if (r2 <= 0) goto L_0x0222
            java.lang.Object r2 = r1.get(r12)
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            r4 = r24
            com.google.android.gms.internal.measurement.zzap r2 = r4.zzb(r2)
            java.lang.Double r2 = r2.zzh()
            double r2 = r2.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zza(r2)
            int r2 = (int) r2
            goto L_0x0225
        L_0x0222:
            r4 = r24
            r2 = 0
        L_0x0225:
            int r3 = r25.size()
            r5 = 1
            if (r3 <= r5) goto L_0x0244
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r4.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            int r1 = (int) r3
            goto L_0x0248
        L_0x0244:
            int r1 = r0.length()
        L_0x0248:
            r3 = 0
            int r2 = java.lang.Math.max(r2, r3)
            int r4 = r0.length()
            int r2 = java.lang.Math.min(r2, r4)
            int r1 = java.lang.Math.max(r1, r3)
            int r3 = r0.length()
            int r1 = java.lang.Math.min(r1, r3)
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            int r4 = java.lang.Math.min(r2, r1)
            int r1 = java.lang.Math.max(r2, r1)
            java.lang.String r0 = r0.substring(r4, r1)
            r3.<init>(r0)
        L_0x0272:
            r1 = r3
            goto L_0x068c
        L_0x0275:
            r13 = r22
            r4 = r24
            r1 = r25
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r9, r2, r1)
            java.lang.String r2 = r13.zza
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0298
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r0 = 1
            com.google.android.gms.internal.measurement.zzap[] r0 = new com.google.android.gms.internal.measurement.zzap[r0]
            r3 = 0
            r0[r3] = r13
            java.util.List r0 = java.util.Arrays.asList(r0)
            r1.<init>(r0)
            goto L_0x068c
        L_0x0298:
            r3 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r25.size()
            if (r6 != 0) goto L_0x02a9
            r5.add(r13)
            goto L_0x0329
        L_0x02a9:
            java.lang.Object r6 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r6 = (com.google.android.gms.internal.measurement.zzap) r6
            com.google.android.gms.internal.measurement.zzap r3 = r4.zzb(r6)
            java.lang.String r3 = r3.zzi()
            int r6 = r25.size()
            r7 = 1
            if (r6 <= r7) goto L_0x02d5
            java.lang.Object r1 = r1.get(r7)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r4.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r6 = r1.doubleValue()
            long r6 = com.google.android.gms.internal.measurement.zzh.zzd(r6)
            goto L_0x02d8
        L_0x02d5:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02d8:
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x02e5
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r1.<init>()
            goto L_0x068c
        L_0x02e5:
            java.lang.String r1 = java.util.regex.Pattern.quote(r3)
            int r4 = (int) r6
            r8 = 1
            int r4 = r4 + r8
            java.lang.String[] r1 = r2.split(r1, r4)
            int r2 = r1.length
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x030e
            if (r2 <= 0) goto L_0x030e
            r3 = 0
            r3 = r1[r3]
            boolean r3 = r3.equals(r0)
            int r4 = r2 + -1
            r8 = r1[r4]
            boolean r0 = r8.equals(r0)
            if (r0 != 0) goto L_0x030b
            r4 = r2
        L_0x030b:
            r17 = r3
            goto L_0x0311
        L_0x030e:
            r4 = r2
            r17 = 0
        L_0x0311:
            long r2 = (long) r2
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0318
            int r4 = r4 + -1
        L_0x0318:
            r0 = r17
        L_0x031a:
            if (r0 >= r4) goto L_0x0329
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            r3 = r1[r0]
            r2.<init>(r3)
            r5.add(r2)
            int r0 = r0 + 1
            goto L_0x031a
        L_0x0329:
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r1.<init>(r5)
            goto L_0x068c
        L_0x0330:
            r13 = r22
            r4 = r24
            r1 = r25
            r0 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r0, r1)
            java.lang.String r0 = r13.zza
            int r2 = r25.size()
            if (r2 <= 0) goto L_0x0356
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r2 = r4.zzb(r3)
            java.lang.Double r2 = r2.zzh()
            double r2 = r2.doubleValue()
            goto L_0x0358
        L_0x0356:
            r2 = 0
        L_0x0358:
            double r2 = com.google.android.gms.internal.measurement.zzh.zza(r2)
            r5 = 0
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x036d
            int r7 = r0.length()
            double r7 = (double) r7
            double r7 = r7 + r2
            double r2 = java.lang.Math.max(r7, r5)
            goto L_0x0376
        L_0x036d:
            int r5 = r0.length()
            double r5 = (double) r5
            double r2 = java.lang.Math.min(r2, r5)
        L_0x0376:
            int r2 = (int) r2
            int r3 = r25.size()
            r5 = 1
            if (r3 <= r5) goto L_0x0391
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r4.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            goto L_0x0396
        L_0x0391:
            int r1 = r0.length()
            double r3 = (double) r1
        L_0x0396:
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x03ab
            int r1 = r0.length()
            double r5 = (double) r1
            double r5 = r5 + r3
            double r3 = java.lang.Math.max(r5, r7)
            goto L_0x03b4
        L_0x03ab:
            int r1 = r0.length()
            double r5 = (double) r1
            double r3 = java.lang.Math.min(r3, r5)
        L_0x03b4:
            int r1 = (int) r3
            int r1 = r1 - r2
            r3 = 0
            int r1 = java.lang.Math.max(r3, r1)
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            int r1 = r1 + r2
            java.lang.String r0 = r0.substring(r2, r1)
            r3.<init>(r0)
            goto L_0x0272
        L_0x03c7:
            r13 = r22
            r4 = r24
            r1 = r25
            r0 = 1
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r14, r0, r1)
            int r0 = r25.size()
            if (r0 <= 0) goto L_0x03e6
            java.lang.Object r0 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r4.zzb(r0)
            java.lang.String r19 = r0.zzi()
        L_0x03e6:
            java.lang.String r0 = r13.zza
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r19)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0406
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r0 = r0.start()
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x068c
        L_0x0406:
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x068c
        L_0x0413:
            r0 = 2
            r13 = r22
            r4 = r24
            r1 = r25
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r0, r1)
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            int r2 = r25.size()
            if (r2 <= 0) goto L_0x0445
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r2 = r4.zzb(r3)
            java.lang.String r19 = r2.zzi()
            int r2 = r25.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0445
            java.lang.Object r0 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r4.zzb(r0)
        L_0x0445:
            r1 = r19
            java.lang.String r2 = r13.zza
            int r3 = r2.indexOf(r1)
            if (r3 < 0) goto L_0x0642
            boolean r5 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r5 == 0) goto L_0x0478
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            r5 = 3
            com.google.android.gms.internal.measurement.zzap[] r5 = new com.google.android.gms.internal.measurement.zzap[r5]
            com.google.android.gms.internal.measurement.zzat r6 = new com.google.android.gms.internal.measurement.zzat
            r6.<init>(r1)
            r7 = 0
            r5[r7] = r6
            com.google.android.gms.internal.measurement.zzah r6 = new com.google.android.gms.internal.measurement.zzah
            double r7 = (double) r3
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r6.<init>(r7)
            r7 = 1
            r5[r7] = r6
            r6 = 2
            r5[r6] = r13
            java.util.List r5 = java.util.Arrays.asList(r5)
            com.google.android.gms.internal.measurement.zzap r0 = r0.zza(r4, r5)
        L_0x0478:
            com.google.android.gms.internal.measurement.zzat r4 = new com.google.android.gms.internal.measurement.zzat
            r5 = 0
            java.lang.String r5 = r2.substring(r5, r3)
            java.lang.String r0 = r0.zzi()
            int r1 = r1.length()
            int r3 = r3 + r1
            java.lang.String r1 = r2.substring(r3)
            java.lang.String r2 = java.lang.String.valueOf(r5)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.String r6 = java.lang.String.valueOf(r1)
            int r6 = r6.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r2 = r2 + r3
            int r2 = r2 + r6
            r7.<init>(r2)
            r7.append(r5)
            r7.append(r0)
            r7.append(r1)
            java.lang.String r0 = r7.toString()
            r4.<init>(r0)
            goto L_0x05bf
        L_0x04bd:
            r13 = r22
            r4 = r24
            r1 = r25
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r11, r2, r1)
            java.lang.String r2 = r13.zza
            int r3 = r25.size()
            if (r3 > 0) goto L_0x04d0
            goto L_0x04df
        L_0x04d0:
            r0 = 0
            java.lang.Object r1 = r1.get(r0)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r0 = r4.zzb(r1)
            java.lang.String r0 = r0.zzi()
        L_0x04df:
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r2)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0507
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r2 = 1
            com.google.android.gms.internal.measurement.zzap[] r2 = new com.google.android.gms.internal.measurement.zzap[r2]
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.group()
            r3.<init>(r0)
            r0 = 0
            r2[r0] = r3
            java.util.List r0 = java.util.Arrays.asList(r2)
            r1.<init>(r0)
            goto L_0x068c
        L_0x0507:
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzg
            goto L_0x068c
        L_0x050b:
            r13 = r22
            r4 = r24
            r1 = r25
            r2 = r20
            r0 = 0
            r3 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r2, r3, r1)
            java.lang.String r2 = r13.zza
            int r5 = r25.size()
            if (r5 > 0) goto L_0x0521
            goto L_0x052f
        L_0x0521:
            java.lang.Object r0 = r1.get(r0)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r4.zzb(r0)
            java.lang.String r19 = r0.zzi()
        L_0x052f:
            r0 = r19
            int r5 = r25.size()
            if (r5 >= r3) goto L_0x053a
            r3 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x054d
        L_0x053a:
            r3 = 1
            java.lang.Object r1 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r4.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
        L_0x054d:
            boolean r1 = java.lang.Double.isNaN(r3)
            if (r1 == 0) goto L_0x0556
            r3 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x055a
        L_0x0556:
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
        L_0x055a:
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r3 = (int) r3
            int r0 = r2.lastIndexOf(r0, r3)
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x068c
        L_0x056b:
            r13 = r22
            r4 = r24
            r1 = r25
            r0 = 2
            r7 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r6, r0, r1)
            java.lang.String r2 = r13.zza
            int r3 = r25.size()
            if (r3 > 0) goto L_0x0580
            goto L_0x058f
        L_0x0580:
            r3 = 0
            java.lang.Object r3 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r4.zzb(r3)
            java.lang.String r19 = r3.zzi()
        L_0x058f:
            r3 = r19
            int r5 = r25.size()
            if (r5 >= r0) goto L_0x0599
            r0 = r7
            goto L_0x05ac
        L_0x0599:
            r0 = 1
            java.lang.Object r0 = r1.get(r0)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r4.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
        L_0x05ac:
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r0)
            com.google.android.gms.internal.measurement.zzah r4 = new com.google.android.gms.internal.measurement.zzah
            int r0 = (int) r0
            int r0 = r2.indexOf(r3, r0)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r4.<init>(r0)
        L_0x05bf:
            r1 = r4
            goto L_0x068c
        L_0x05c2:
            r13 = r22
            r4 = r24
            r1 = r25
            r0 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r3, r0, r1)
            java.lang.String r0 = r13.zza
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r4.zzb(r1)
            java.lang.String r2 = r1.zzi()
            java.lang.String r3 = "length"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x05e9
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzaf.zzk
            goto L_0x068c
        L_0x05e9:
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
            double r3 = java.lang.Math.floor(r1)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0606
            int r1 = (int) r1
            if (r1 < 0) goto L_0x0606
            int r0 = r0.length()
            if (r1 >= r0) goto L_0x0606
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzaf.zzk
            goto L_0x068c
        L_0x0606:
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzaf.zzl
            goto L_0x068c
        L_0x060a:
            r13 = r22
            r4 = r24
            r1 = r25
            int r0 = r25.size()
            if (r0 == 0) goto L_0x0642
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = r13.zza
            r0.<init>(r2)
            r2 = 0
        L_0x061e:
            int r3 = r25.size()
            if (r2 >= r3) goto L_0x0638
            java.lang.Object r3 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r4.zzb(r3)
            java.lang.String r3 = r3.zzi()
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x061e
        L_0x0638:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            goto L_0x068c
        L_0x0642:
            r1 = r13
            goto L_0x068c
        L_0x0644:
            r13 = r22
            r4 = r24
            r1 = r25
            r0 = r21
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r0, r2, r1)
            int r0 = r25.size()
            if (r0 <= 0) goto L_0x066f
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r4.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r0)
            int r0 = (int) r0
            goto L_0x0670
        L_0x066f:
            r0 = 0
        L_0x0670:
            java.lang.String r1 = r13.zza
            if (r0 < 0) goto L_0x068a
            int r2 = r1.length()
            if (r0 < r2) goto L_0x067b
            goto L_0x068a
        L_0x067b:
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            char r0 = r1.charAt(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.<init>(r0)
            r1 = r2
            goto L_0x068c
        L_0x068a:
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzm
        L_0x068c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbI(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public final zzap zzd() {
        return new zzat(this.zza);
    }

    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzi() {
        return this.zza;
    }

    public final Iterator zzl() {
        return new zzar(this);
    }
}
