package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzem implements Runnable {
    final /* synthetic */ zzen zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzej zzd;
    private final String zze;
    private final Map zzf;

    public zzem(zzen zzen, String str, URL url, byte[] bArr, Map map, zzej zzej) {
        this.zza = zzen;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzej);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzej;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f9 A[SYNTHETIC, Splitter:B:46:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012c A[SYNTHETIC, Splitter:B:67:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x016c A[SYNTHETIC, Splitter:B:79:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0188  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzen r1 = r14.zza
            r1.zzax()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.zzen r3 = r14.zza     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            java.net.URL r4 = r14.zzb     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            if (r5 == 0) goto L_0x011d
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r4.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            com.google.android.gms.measurement.internal.zzfr r5 = r3.zzs     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r5.zzf()     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r5 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzs     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r3.zzf()     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r3 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r3)     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r4.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            r3 = 1
            r4.setDoInput(r3)     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            java.util.Map r5 = r14.zzf     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            if (r5 == 0) goto L_0x005f
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
        L_0x0043:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            if (r6 == 0) goto L_0x005f
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            r4.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            goto L_0x0043
        L_0x005f:
            byte[] r5 = r14.zzc     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            if (r5 == 0) goto L_0x00ae
            com.google.android.gms.measurement.internal.zzen r5 = r14.zza     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzkp r5 = r5.zzf     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzkr r5 = r5.zzu()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            byte[] r6 = r14.zzc     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            byte[] r5 = r5.zzy(r6)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzen r6 = r14.zza     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzs     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            int r7 = r5.length     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.lang.String r8 = "Uploading data. size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            r6.zzb(r8, r9)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            r4.setDoOutput(r3)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r3, r6)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            r4.setFixedLengthStreamingMode(r7)     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            r4.connect()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.io.OutputStream r3 = r4.getOutputStream()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            r3.write(r5)     // Catch:{ IOException -> 0x00a8, all -> 0x00a2 }
            r3.close()     // Catch:{ IOException -> 0x00a8, all -> 0x00a2 }
            goto L_0x00ae
        L_0x00a2:
            r5 = move-exception
            r9 = r1
            r12 = r2
            r2 = r3
            goto L_0x012a
        L_0x00a8:
            r5 = move-exception
            r9 = r1
            r12 = r2
            r2 = r3
            goto L_0x0169
        L_0x00ae:
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x0118, all -> 0x0113 }
            java.util.Map r11 = r4.getHeaderFields()     // Catch:{ IOException -> 0x010d, all -> 0x0109 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00f5 }
            r3.<init>()     // Catch:{ all -> 0x00f5 }
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x00f5 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00f3 }
        L_0x00c3:
            int r7 = r5.read(r6)     // Catch:{ all -> 0x00f3 }
            if (r7 <= 0) goto L_0x00cd
            r3.write(r6, r1, r7)     // Catch:{ all -> 0x00f3 }
            goto L_0x00c3
        L_0x00cd:
            byte[] r10 = r3.toByteArray()     // Catch:{ all -> 0x00f3 }
            if (r5 == 0) goto L_0x00d6
            r5.close()     // Catch:{ IOException -> 0x0102, all -> 0x00fd }
        L_0x00d6:
            if (r4 == 0) goto L_0x00db
            r4.disconnect()
        L_0x00db:
            com.google.android.gms.measurement.internal.zzen r0 = r14.zza
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzel r1 = new com.google.android.gms.measurement.internal.zzel
            java.lang.String r6 = r14.zze
            com.google.android.gms.measurement.internal.zzej r7 = r14.zzd
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x00ef:
            r0.zzp(r1)
            return
        L_0x00f3:
            r1 = move-exception
            goto L_0x00f7
        L_0x00f5:
            r1 = move-exception
            r5 = r2
        L_0x00f7:
            if (r5 == 0) goto L_0x00fc
            r5.close()     // Catch:{ IOException -> 0x0102, all -> 0x00fd }
        L_0x00fc:
            throw r1     // Catch:{ IOException -> 0x0102, all -> 0x00fd }
        L_0x00fd:
            r1 = move-exception
            r5 = r1
            r9 = r8
            r12 = r11
            goto L_0x012a
        L_0x0102:
            r1 = move-exception
            r5 = r1
            r10 = r5
            r9 = r8
            r12 = r11
            goto L_0x016a
        L_0x0109:
            r5 = move-exception
            r12 = r2
            r9 = r8
            goto L_0x012a
        L_0x010d:
            r5 = move-exception
            r12 = r2
            r10 = r5
            r9 = r8
            goto L_0x016a
        L_0x0113:
            r3 = move-exception
            r9 = r1
            r12 = r2
            r5 = r3
            goto L_0x012a
        L_0x0118:
            r3 = move-exception
            r9 = r1
            r12 = r2
            r10 = r3
            goto L_0x016a
        L_0x011d:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
            throw r3     // Catch:{ IOException -> 0x0164, all -> 0x0125 }
        L_0x0125:
            r3 = move-exception
            r5 = r3
            r9 = r1
            r4 = r2
            r12 = r4
        L_0x012a:
            if (r2 == 0) goto L_0x0146
            r2.close()     // Catch:{ IOException -> 0x0130 }
            goto L_0x0146
        L_0x0130:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzen r2 = r14.zza
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r3 = r14.zze
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)
            r2.zzc(r0, r3, r1)
        L_0x0146:
            if (r4 == 0) goto L_0x014b
            r4.disconnect()
        L_0x014b:
            com.google.android.gms.measurement.internal.zzen r0 = r14.zza
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzel r1 = new com.google.android.gms.measurement.internal.zzel
            java.lang.String r7 = r14.zze
            com.google.android.gms.measurement.internal.zzej r8 = r14.zzd
            r10 = 0
            r11 = 0
            r13 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r0.zzp(r1)
            throw r5
        L_0x0164:
            r3 = move-exception
            r5 = r3
            r9 = r1
            r4 = r2
            r12 = r4
        L_0x0169:
            r10 = r5
        L_0x016a:
            if (r2 == 0) goto L_0x0186
            r2.close()     // Catch:{ IOException -> 0x0170 }
            goto L_0x0186
        L_0x0170:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzen r2 = r14.zza
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r3 = r14.zze
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)
            r2.zzc(r0, r3, r1)
        L_0x0186:
            if (r4 == 0) goto L_0x018b
            r4.disconnect()
        L_0x018b:
            com.google.android.gms.measurement.internal.zzen r0 = r14.zza
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzel r1 = new com.google.android.gms.measurement.internal.zzel
            java.lang.String r7 = r14.zze
            com.google.android.gms.measurement.internal.zzej r8 = r14.zzd
            r11 = 0
            r13 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x00ef
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.run():void");
    }
}
