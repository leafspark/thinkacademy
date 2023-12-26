package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzht implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhv zze;

    zzht(zzhv zzhv, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhv;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[SYNTHETIC, Splitter:B:32:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fe A[Catch:{ RuntimeException -> 0x0193 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0100 A[Catch:{ RuntimeException -> 0x0193 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzhv r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzkw r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.internal.measurement.zznl.zzc()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzhw r7 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzf()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzav     // Catch:{ RuntimeException -> 0x0193 }
            r9 = 0
            boolean r7 = r7.zzs(r9, r8)     // Catch:{ RuntimeException -> 0x0193 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0193 }
            java.lang.String r10 = "Activity created with data 'referrer' without required params"
            java.lang.String r11 = "_cis"
            java.lang.String r12 = "utm_medium"
            java.lang.String r13 = "utm_source"
            java.lang.String r14 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r8 == 0) goto L_0x003f
        L_0x003d:
            r6 = r9
            goto L_0x00a0
        L_0x003f:
            boolean r8 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0193 }
            if (r8 != 0) goto L_0x007a
            boolean r8 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0193 }
            if (r8 != 0) goto L_0x007a
            boolean r8 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x0193 }
            if (r8 != 0) goto L_0x007a
            boolean r8 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0193 }
            if (r8 != 0) goto L_0x007a
            if (r7 == 0) goto L_0x006c
            java.lang.String r7 = "utm_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0193 }
            if (r7 != 0) goto L_0x006a
            java.lang.String r7 = "dclid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0193 }
            if (r7 != 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            r7 = 1
            goto L_0x007a
        L_0x006c:
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x0193 }
            r6.zza(r10)     // Catch:{ RuntimeException -> 0x0193 }
            goto L_0x003d
        L_0x007a:
            java.lang.String r8 = "https://google.com/search?"
            java.lang.String r9 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x0193 }
            int r16 = r9.length()     // Catch:{ RuntimeException -> 0x0193 }
            if (r16 == 0) goto L_0x008b
            java.lang.String r8 = r8.concat(r9)     // Catch:{ RuntimeException -> 0x0193 }
            goto L_0x0091
        L_0x008b:
            java.lang.String r9 = new java.lang.String     // Catch:{ RuntimeException -> 0x0193 }
            r9.<init>(r8)     // Catch:{ RuntimeException -> 0x0193 }
            r8 = r9
        L_0x0091:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ RuntimeException -> 0x0193 }
            android.os.Bundle r6 = r6.zzs(r8, r7)     // Catch:{ RuntimeException -> 0x0193 }
            if (r6 == 0) goto L_0x00a0
            java.lang.String r7 = "referrer"
            r6.putString(r11, r7)     // Catch:{ RuntimeException -> 0x0193 }
        L_0x00a0:
            java.lang.String r7 = "_cmp"
            if (r0 == 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzkw r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.internal.measurement.zznl.zzc()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzhw r8 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzaf r8 = r8.zzf()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzav     // Catch:{ RuntimeException -> 0x0193 }
            r1 = 0
            boolean r8 = r8.zzs(r1, r9)     // Catch:{ RuntimeException -> 0x0193 }
            android.os.Bundle r0 = r0.zzs(r3, r8)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 == 0) goto L_0x00f8
            java.lang.String r1 = "intent"
            r0.putString(r11, r1)     // Catch:{ RuntimeException -> 0x0193 }
            boolean r1 = r0.containsKey(r15)     // Catch:{ RuntimeException -> 0x0193 }
            if (r1 != 0) goto L_0x00ec
            if (r6 == 0) goto L_0x00ec
            boolean r1 = r6.containsKey(r15)     // Catch:{ RuntimeException -> 0x0193 }
            if (r1 == 0) goto L_0x00ec
            r1 = 1
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ RuntimeException -> 0x0193 }
            r1 = 0
            java.lang.String r8 = r6.getString(r15)     // Catch:{ RuntimeException -> 0x0193 }
            r3[r1] = r8     // Catch:{ RuntimeException -> 0x0193 }
            java.lang.String r1 = "_cer"
            java.lang.String r8 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r8, r3)     // Catch:{ RuntimeException -> 0x0193 }
            r0.putString(r1, r3)     // Catch:{ RuntimeException -> 0x0193 }
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzhw r1 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            r1.zzG(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzhw r1 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzr r1 = r1.zzb     // Catch:{ RuntimeException -> 0x0193 }
            r1.zza(r4, r0)     // Catch:{ RuntimeException -> 0x0193 }
        L_0x00f8:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 == 0) goto L_0x0100
            goto L_0x0182
        L_0x0100:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0193 }
            java.lang.String r1 = "Activity created with referrer"
            r0.zzb(r1, r5)     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzdt r1 = com.google.android.gms.measurement.internal.zzdu.zzY     // Catch:{ RuntimeException -> 0x0193 }
            r3 = 0
            boolean r0 = r0.zzs(r3, r1)     // Catch:{ RuntimeException -> 0x0193 }
            java.lang.String r1 = "_ldl"
            java.lang.String r3 = "auto"
            if (r0 == 0) goto L_0x014e
            if (r6 == 0) goto L_0x0135
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            r0.zzG(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ RuntimeException -> 0x0193 }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x0193 }
            goto L_0x0146
        L_0x0135:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0193 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x0193 }
        L_0x0146:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            r4 = 1
            r5 = 0
            r0.zzX(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0193 }
            return
        L_0x014e:
            boolean r0 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 == 0) goto L_0x0183
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 != 0) goto L_0x0176
            boolean r0 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 != 0) goto L_0x0176
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 != 0) goto L_0x0176
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 != 0) goto L_0x0176
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 == 0) goto L_0x0183
        L_0x0176:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0193 }
            if (r0 != 0) goto L_0x0182
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            r4 = 1
            r0.zzX(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0193 }
        L_0x0182:
            return
        L_0x0183:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0193 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0193 }
            r0.zza(r10)     // Catch:{ RuntimeException -> 0x0193 }
            return
        L_0x0193:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhw r1 = r2.zza
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzd()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzht.run():void");
    }
}
