package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzz extends zzkf {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzz(zzkp zzkp) {
        super(zzkp);
    }

    private final zzt zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzt) this.zzc.get(num);
        }
        zzt zzt = new zzt(this, this.zza, (zzs) null);
        this.zzc.put(num, zzt);
        return zzt;
    }

    private final boolean zzf(int i, int i2) {
        zzt zzt = (zzt) this.zzc.get(Integer.valueOf(i));
        if (zzt == null) {
            return false;
        }
        return zzt.zze.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02df, code lost:
        if (r5 != null) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02e1, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02e9, code lost:
        if (r5 != null) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x030e, code lost:
        if (r5 != null) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0311, code lost:
        r1 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x031d, code lost:
        if (r1.hasNext() == false) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x031f, code lost:
        r4 = ((java.lang.Integer) r1.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (com.google.android.gms.internal.measurement.zzgd) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0339, code lost:
        if (r7 == null) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x033f, code lost:
        if (r7.isEmpty() == false) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0343, code lost:
        r17 = r0;
        r0 = r10.zzf.zzu().zzq(r6.zzk(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0357, code lost:
        if (r0.isEmpty() != false) goto L_0x03c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0359, code lost:
        r5 = (com.google.android.gms.internal.measurement.zzgc) r6.zzbt();
        r5.zze();
        r5.zzb(r0);
        r20 = r1;
        r0 = r10.zzf.zzu().zzq(r6.zzn(), r7);
        r5.zzf();
        r5.zzd(r0);
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0380, code lost:
        if (r0 >= r6.zza()) goto L_0x039a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0392, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zze(r0).zza())) == false) goto L_0x0397;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0394, code lost:
        r5.zzg(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0397, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x039a, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x039f, code lost:
        if (r0 >= r6.zzc()) goto L_0x03b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03b1, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.zzi(r0).zzb())) == false) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03b3, code lost:
        r5.zzh(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b6, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b9, code lost:
        r3.put(java.lang.Integer.valueOf(r4), (com.google.android.gms.internal.measurement.zzgd) r5.zzay());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c7, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03cb, code lost:
        r17 = r0;
        r20 = r1;
        r3.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03d2, code lost:
        r0 = r17;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0728, code lost:
        if (r11 != null) goto L_0x072a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x072a, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x073e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x073f, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0741, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0742, code lost:
        r29 = r2;
        r28 = r4;
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0760, code lost:
        if (r11 != null) goto L_0x072a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x076b, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x08f6, code lost:
        if (r13 != null) goto L_0x08f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x08f8, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x091e, code lost:
        if (r13 == null) goto L_0x0921;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0a32, code lost:
        if (r7.zzj() == false) goto L_0x0a3d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0a34, code lost:
        r7 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0a3d, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0a3e, code lost:
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0151, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0153, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0175, code lost:
        if (r5 != null) goto L_0x0153;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x059f  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x073e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:248:0x0687] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x082d  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0929  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0a7b  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0b0f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b4 A[Catch:{ SQLiteException -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c4 A[SYNTHETIC, Splitter:B:70:0x01c4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r66, java.util.List r67, java.util.List r68, java.lang.Long r69, java.lang.Long r70) {
        /*
            r65 = this;
            r10 = r65
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r68)
            r0 = r66
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r69
            r10.zzd = r0
            r0 = r70
            r10.zze = r0
            java.util.Iterator r0 = r67.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzfo r1 = (com.google.android.gms.internal.measurement.zzfo) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = r13
            goto L_0x0048
        L_0x0047:
            r1 = r12
        L_0x0048:
            com.google.android.gms.internal.measurement.zzoa.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzW
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzoa.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzV
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017e
            if (r14 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015e, all -> 0x015b }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 == 0) goto L_0x014d
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.internal.measurement.zzei r13 = com.google.android.gms.internal.measurement.zzej.zzc()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzlb r0 = com.google.android.gms.measurement.internal.zzkr.zzl(r13, r0)     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzjx r0 = r0.zzay()     // Catch:{ IOException -> 0x012b }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012b }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0159 }
            if (r13 != 0) goto L_0x010c
            goto L_0x013d
        L_0x010c:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0159 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0159 }
            if (r16 != 0) goto L_0x0125
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0159 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0159 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x0127
        L_0x0125:
            r12 = r16
        L_0x0127:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0159 }
            goto L_0x013d
        L_0x012b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r12 = r2.zzs     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0159 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0159 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0159 }
        L_0x013d:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0159 }
            if (r0 != 0) goto L_0x014a
            if (r5 == 0) goto L_0x0148
            r5.close()
        L_0x0148:
            r12 = r4
            goto L_0x017f
        L_0x014a:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014d:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0159 }
            if (r5 == 0) goto L_0x017e
        L_0x0153:
            r5.close()
            goto L_0x017e
        L_0x0157:
            r0 = move-exception
            goto L_0x0178
        L_0x0159:
            r0 = move-exception
            goto L_0x0160
        L_0x015b:
            r0 = move-exception
            r5 = 0
            goto L_0x0178
        L_0x015e:
            r0 = move-exception
            r5 = 0
        L_0x0160:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0157 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0157 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0157 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0157 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0157 }
            if (r5 == 0) goto L_0x017e
            goto L_0x0153
        L_0x0178:
            if (r5 == 0) goto L_0x017d
            r5.close()
        L_0x017d:
            throw r0
        L_0x017e:
            r12 = r0
        L_0x017f:
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022e }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 != 0) goto L_0x01c4
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0228 }
            if (r4 == 0) goto L_0x01bd
            r4.close()
        L_0x01bd:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0255
        L_0x01c4:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0228 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0228 }
        L_0x01c9:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0228 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzgc r13 = com.google.android.gms.internal.measurement.zzgd.zzf()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzlb r0 = com.google.android.gms.measurement.internal.zzkr.zzl(r13, r0)     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgc r0 = (com.google.android.gms.internal.measurement.zzgc) r0     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzjx r0 = r0.zzay()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ IOException -> 0x01f1 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0228 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0228 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x020f
        L_0x01f1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r13 = r2.zzs     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ SQLiteException -> 0x0228 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0228 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0226 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0224 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0224 }
        L_0x020f:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0224 }
            if (r0 != 0) goto L_0x021d
            if (r4 == 0) goto L_0x021a
            r4.close()
        L_0x021a:
            r13 = r17
            goto L_0x0255
        L_0x021d:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c9
        L_0x0224:
            r0 = move-exception
            goto L_0x0238
        L_0x0226:
            r0 = move-exception
            goto L_0x022b
        L_0x0228:
            r0 = move-exception
            r18 = r6
        L_0x022b:
            r19 = r7
            goto L_0x0238
        L_0x022e:
            r0 = move-exception
            r5 = 0
            goto L_0x0b0d
        L_0x0232:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0238:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0b0b }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0b0b }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0b0b }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0b0b }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b0b }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b0b }
            if (r4 == 0) goto L_0x0254
            r4.close()
        L_0x0254:
            r13 = r0
        L_0x0255:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x0266
        L_0x025c:
            r12 = r8
            r30 = r9
            r28 = r18
            r29 = r19
            r13 = 0
            goto L_0x0593
        L_0x0266:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x03e0
            java.lang.String r1 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x0286
            goto L_0x03d8
        L_0x0286:
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r4 = r0.zzi()
            r4.zzW()
            r4.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r4.zzh()
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02f5, all -> 0x02f1 }
            r16 = 0
            r6[r16] = r1     // Catch:{ SQLiteException -> 0x02f5, all -> 0x02f1 }
            r16 = 1
            r6[r16] = r1     // Catch:{ SQLiteException -> 0x02f5, all -> 0x02f1 }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02f5, all -> 0x02f1 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02ef }
            if (r6 == 0) goto L_0x02e5
        L_0x02b4:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02ef }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02ef }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02ef }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02ef }
            if (r7 != 0) goto L_0x02cd
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02ef }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02ef }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02ef }
        L_0x02cd:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02ef }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02ef }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02ef }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02ef }
            if (r6 != 0) goto L_0x02b4
            if (r5 == 0) goto L_0x0311
        L_0x02e1:
            r5.close()
            goto L_0x0311
        L_0x02e5:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02ef }
            if (r5 == 0) goto L_0x0311
            goto L_0x02e1
        L_0x02ec:
            r0 = move-exception
            goto L_0x03da
        L_0x02ef:
            r0 = move-exception
            goto L_0x02f7
        L_0x02f1:
            r0 = move-exception
            r5 = 0
            goto L_0x03da
        L_0x02f5:
            r0 = move-exception
            r5 = 0
        L_0x02f7:
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzs     // Catch:{ all -> 0x02ec }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x02ec }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x02ec }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzeh.zzn(r1)     // Catch:{ all -> 0x02ec }
            r4.zzc(r6, r1, r0)     // Catch:{ all -> 0x02ec }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02ec }
            if (r5 == 0) goto L_0x0311
            goto L_0x02e1
        L_0x0311:
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0319:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x03d8
            java.lang.Object r4 = r1.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgd r6 = (com.google.android.gms.internal.measurement.zzgd) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x03cb
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x0343
            goto L_0x03cb
        L_0x0343:
            com.google.android.gms.measurement.internal.zzkp r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzkr r5 = r5.zzu()
            r17 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzq(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x03c7
            com.google.android.gms.internal.measurement.zzjt r5 = r6.zzbt()
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5
            r5.zze()
            r5.zzb(r0)
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzkr r0 = r0.zzu()
            r20 = r1
            java.util.List r1 = r6.zzn()
            java.util.List r0 = r0.zzq(r1, r7)
            r5.zzf()
            r5.zzd(r0)
            r0 = 0
        L_0x037c:
            int r1 = r6.zza()
            if (r0 >= r1) goto L_0x039a
            com.google.android.gms.internal.measurement.zzfm r1 = r6.zze(r0)
            int r1 = r1.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x0397
            r5.zzg(r0)
        L_0x0397:
            int r0 = r0 + 1
            goto L_0x037c
        L_0x039a:
            r0 = 0
        L_0x039b:
            int r1 = r6.zzc()
            if (r0 >= r1) goto L_0x03b9
            com.google.android.gms.internal.measurement.zzgf r1 = r6.zzi(r0)
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r7.contains(r1)
            if (r1 == 0) goto L_0x03b6
            r5.zzh(r0)
        L_0x03b6:
            int r0 = r0 + 1
            goto L_0x039b
        L_0x03b9:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzjx r1 = r5.zzay()
            com.google.android.gms.internal.measurement.zzgd r1 = (com.google.android.gms.internal.measurement.zzgd) r1
            r3.put(r0, r1)
            goto L_0x03d2
        L_0x03c7:
            r0 = r17
            goto L_0x0319
        L_0x03cb:
            r17 = r0
            r20 = r1
            r3.put(r5, r6)
        L_0x03d2:
            r0 = r17
            r1 = r20
            goto L_0x0319
        L_0x03d8:
            r0 = r3
            goto L_0x03e1
        L_0x03da:
            if (r5 == 0) goto L_0x03df
            r5.close()
        L_0x03df:
            throw r0
        L_0x03e0:
            r0 = r13
        L_0x03e1:
            java.util.Iterator r17 = r2.iterator()
        L_0x03e5:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x025c
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r20 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgd r1 = (com.google.android.gms.internal.measurement.zzgd) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x044d
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x0417
            goto L_0x044d
        L_0x0417:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x041f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x044d
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfm r3 = (com.google.android.gms.internal.measurement.zzfm) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x041f
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r21 = r3.zzg()
            if (r21 == 0) goto L_0x0448
            long r21 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r21)
            goto L_0x0449
        L_0x0448:
            r3 = 0
        L_0x0449:
            r7.put(r4, r3)
            goto L_0x041f
        L_0x044d:
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            if (r1 == 0) goto L_0x049d
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x045b
            goto L_0x049d
        L_0x045b:
            java.util.List r2 = r1.zzm()
            java.util.Iterator r2 = r2.iterator()
        L_0x0463:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x049d
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgf r3 = (com.google.android.gms.internal.measurement.zzgf) r3
            boolean r21 = r3.zzi()
            if (r21 == 0) goto L_0x0463
            int r21 = r3.zza()
            if (r21 <= 0) goto L_0x0463
            int r21 = r3.zzb()
            r22 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            int r21 = r3.zza()
            r23 = r2
            int r2 = r21 + -1
            long r2 = r3.zzc(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r0, r2)
            r0 = r22
            r2 = r23
            goto L_0x0463
        L_0x049d:
            r22 = r0
            if (r1 == 0) goto L_0x04f2
            r0 = 0
        L_0x04a2:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x04f2
            java.util.List r2 = r1.zzn()
            boolean r2 = com.google.android.gms.measurement.internal.zzkr.zzv(r2, r0)
            if (r2 == 0) goto L_0x04e0
            com.google.android.gms.measurement.internal.zzfr r2 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            r21 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r23 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r8)
            r6.set(r0)
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzkr.zzv(r2, r0)
            if (r2 == 0) goto L_0x04e4
            r5.set(r0)
            goto L_0x04eb
        L_0x04e0:
            r21 = r8
            r23 = r9
        L_0x04e4:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x04eb:
            int r0 = r0 + 1
            r8 = r21
            r9 = r23
            goto L_0x04a2
        L_0x04f2:
            r21 = r8
            r23 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r13.get(r0)
            r8 = r1
            com.google.android.gms.internal.measurement.zzgd r8 = (com.google.android.gms.internal.measurement.zzgd) r8
            if (r15 == 0) goto L_0x0561
            if (r14 == 0) goto L_0x0561
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0561
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x0561
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x0516
            goto L_0x0561
        L_0x0516:
            java.util.Iterator r0 = r0.iterator()
        L_0x051a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0561
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzej r1 = (com.google.android.gms.internal.measurement.zzej) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x0542
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x0542:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x0553
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x0553:
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x051a
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r4.put(r1, r2)
            goto L_0x051a
        L_0x0561:
            com.google.android.gms.measurement.internal.zzt r0 = new com.google.android.gms.measurement.internal.zzt
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r65
            r24 = r4
            r4 = r8
            r8 = 0
            r28 = r18
            r29 = r19
            r16 = r12
            r66 = r13
            r12 = r21
            r13 = r8
            r8 = r24
            r30 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r1.put(r2, r0)
            r13 = r66
            r8 = r12
            r12 = r16
            r0 = r22
            r9 = r30
            goto L_0x03e5
        L_0x0593:
            boolean r0 = r67.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x059f
        L_0x059b:
            r25 = r11
            goto L_0x0823
        L_0x059f:
            com.google.android.gms.measurement.internal.zzv r2 = new com.google.android.gms.measurement.internal.zzv
            r2.<init>(r10, r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r67.iterator()
        L_0x05ad:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x059b
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.measurement.zzfo r0 = (com.google.android.gms.internal.measurement.zzfo) r0
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzfo r5 = r2.zza(r5, r0)
            if (r5 == 0) goto L_0x0820
            com.google.android.gms.measurement.internal.zzkp r6 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r6 = r6.zzi()
            java.lang.String r7 = r10.zza
            java.lang.String r8 = r5.zzh()
            java.lang.String r9 = r0.zzh()
            com.google.android.gms.measurement.internal.zzaq r9 = r6.zzn(r7, r9)
            if (r9 != 0) goto L_0x0616
            com.google.android.gms.measurement.internal.zzfr r9 = r6.zzs
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzk()
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzec r6 = r6.zzj()
            java.lang.String r6 = r6.zzd(r8)
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            r9.zzc(r8, r14, r6)
            com.google.android.gms.measurement.internal.zzaq r6 = new com.google.android.gms.measurement.internal.zzaq
            r31 = r6
            java.lang.String r33 = r0.zzh()
            r34 = 1
            r36 = 1
            r38 = 1
            long r40 = r0.zzd()
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r32 = r7
            r31.<init>(r32, r33, r34, r36, r38, r40, r42, r44, r45, r46, r47)
            goto L_0x064b
        L_0x0616:
            com.google.android.gms.measurement.internal.zzaq r6 = new com.google.android.gms.measurement.internal.zzaq
            r48 = r6
            java.lang.String r0 = r9.zza
            r49 = r0
            java.lang.String r0 = r9.zzb
            r50 = r0
            long r7 = r9.zzc
            r14 = 1
            long r51 = r7 + r14
            long r7 = r9.zzd
            long r53 = r7 + r14
            long r7 = r9.zze
            long r55 = r7 + r14
            long r7 = r9.zzf
            r57 = r7
            long r7 = r9.zzg
            r59 = r7
            java.lang.Long r0 = r9.zzh
            r61 = r0
            java.lang.Long r0 = r9.zzi
            r62 = r0
            java.lang.Long r0 = r9.zzj
            r63 = r0
            java.lang.Boolean r0 = r9.zzk
            r64 = r0
            r48.<init>(r49, r50, r51, r53, r55, r57, r59, r61, r62, r63, r64)
        L_0x064b:
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r0 = r0.zzi()
            r0.zzE(r6)
            long r7 = r6.zzc
            java.lang.String r9 = r5.zzh()
            java.lang.Object r0 = r3.get(r9)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x076f
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r14 = r0.zzi()
            java.lang.String r15 = r10.zza
            r14.zzW()
            r14.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r14.zzh()
            r24 = r2
            r67 = r4
            r4 = r28
            r2 = r29
            java.lang.String[] r18 = new java.lang.String[]{r4, r2}     // Catch:{ SQLiteException -> 0x0741, all -> 0x073e }
            r25 = r11
            r11 = 2
            java.lang.String[] r0 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0738, all -> 0x073e }
            r17 = 0
            r0[r17] = r15     // Catch:{ SQLiteException -> 0x0738, all -> 0x073e }
            r17 = 1
            r0[r17] = r9     // Catch:{ SQLiteException -> 0x0738, all -> 0x073e }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r11 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0738, all -> 0x073e }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0730 }
            if (r0 == 0) goto L_0x071e
            r29 = r2
        L_0x06b0:
            r2 = 1
            byte[] r0 = r11.getBlob(r2)     // Catch:{ SQLiteException -> 0x071c }
            com.google.android.gms.internal.measurement.zzei r2 = com.google.android.gms.internal.measurement.zzej.zzc()     // Catch:{ IOException -> 0x06ed }
            com.google.android.gms.internal.measurement.zzlb r0 = com.google.android.gms.measurement.internal.zzkr.zzl(r2, r0)     // Catch:{ IOException -> 0x06ed }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x06ed }
            com.google.android.gms.internal.measurement.zzjx r0 = r0.zzay()     // Catch:{ IOException -> 0x06ed }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x06ed }
            r2 = 0
            int r16 = r11.getInt(r2)     // Catch:{ SQLiteException -> 0x071c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x071c }
            java.lang.Object r16 = r13.get(r2)     // Catch:{ SQLiteException -> 0x071c }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x071c }
            if (r16 != 0) goto L_0x06e1
            r28 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x071a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x071a }
            r13.put(r2, r4)     // Catch:{ SQLiteException -> 0x071a }
            goto L_0x06e5
        L_0x06e1:
            r28 = r4
            r4 = r16
        L_0x06e5:
            r4.add(r0)     // Catch:{ SQLiteException -> 0x071a }
            r16 = r13
            r13 = r30
            goto L_0x0705
        L_0x06ed:
            r0 = move-exception
            r28 = r4
            com.google.android.gms.measurement.internal.zzfr r2 = r14.zzs     // Catch:{ SQLiteException -> 0x071a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x071a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x071a }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r15)     // Catch:{ SQLiteException -> 0x071a }
            r16 = r13
            r13 = r30
            r2.zzc(r13, r4, r0)     // Catch:{ SQLiteException -> 0x072e }
        L_0x0705:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x072e }
            if (r0 != 0) goto L_0x0713
            if (r11 == 0) goto L_0x0710
            r11.close()
        L_0x0710:
            r0 = r16
            goto L_0x0763
        L_0x0713:
            r30 = r13
            r13 = r16
            r4 = r28
            goto L_0x06b0
        L_0x071a:
            r0 = move-exception
            goto L_0x0735
        L_0x071c:
            r0 = move-exception
            goto L_0x0733
        L_0x071e:
            r29 = r2
            r28 = r4
            r13 = r30
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x072e }
            if (r11 == 0) goto L_0x0763
        L_0x072a:
            r11.close()
            goto L_0x0763
        L_0x072e:
            r0 = move-exception
            goto L_0x074b
        L_0x0730:
            r0 = move-exception
            r29 = r2
        L_0x0733:
            r28 = r4
        L_0x0735:
            r13 = r30
            goto L_0x074b
        L_0x0738:
            r0 = move-exception
            r29 = r2
            r28 = r4
            goto L_0x0748
        L_0x073e:
            r0 = move-exception
            r5 = 0
            goto L_0x0769
        L_0x0741:
            r0 = move-exception
            r29 = r2
            r28 = r4
            r25 = r11
        L_0x0748:
            r13 = r30
            r11 = 0
        L_0x074b:
            com.google.android.gms.measurement.internal.zzfr r2 = r14.zzs     // Catch:{ all -> 0x0767 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0767 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0767 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r15)     // Catch:{ all -> 0x0767 }
            r2.zzc(r12, r4, r0)     // Catch:{ all -> 0x0767 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0767 }
            if (r11 == 0) goto L_0x0763
            goto L_0x072a
        L_0x0763:
            r3.put(r9, r0)
            goto L_0x0777
        L_0x0767:
            r0 = move-exception
            r5 = r11
        L_0x0769:
            if (r5 == 0) goto L_0x076e
            r5.close()
        L_0x076e:
            throw r0
        L_0x076f:
            r24 = r2
            r67 = r4
            r25 = r11
            r13 = r30
        L_0x0777:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x077f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0818
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.util.Set r9 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            boolean r9 = r9.contains(r11)
            if (r9 == 0) goto L_0x07a9
            com.google.android.gms.measurement.internal.zzfr r4 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzj()
            r4.zzb(r1, r11)
            goto L_0x077f
        L_0x07a9:
            java.lang.Object r9 = r0.get(r11)
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
            r11 = 1
        L_0x07b4:
            boolean r14 = r9.hasNext()
            if (r14 == 0) goto L_0x0803
            java.lang.Object r11 = r9.next()
            com.google.android.gms.internal.measurement.zzej r11 = (com.google.android.gms.internal.measurement.zzej) r11
            com.google.android.gms.measurement.internal.zzw r15 = new com.google.android.gms.measurement.internal.zzw
            java.lang.String r14 = r10.zza
            r15.<init>(r10, r14, r4, r11)
            java.lang.Long r14 = r10.zzd
            r22 = r0
            java.lang.Long r0 = r10.zze
            int r11 = r11.zzb()
            boolean r21 = r10.zzf(r4, r11)
            r11 = r14
            r14 = r15
            r23 = r2
            r2 = r15
            r15 = r11
            r16 = r0
            r17 = r5
            r18 = r7
            r20 = r6
            boolean r11 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r11 == 0) goto L_0x07f9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.measurement.internal.zzt r0 = r10.zzd(r0)
            r0.zzc(r2)
            r0 = r22
            r2 = r23
            goto L_0x07b4
        L_0x07f9:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.add(r2)
            goto L_0x0807
        L_0x0803:
            r22 = r0
            r23 = r2
        L_0x0807:
            if (r11 != 0) goto L_0x0812
            java.util.Set r0 = r10.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.add(r2)
        L_0x0812:
            r0 = r22
            r2 = r23
            goto L_0x077f
        L_0x0818:
            r4 = r67
            r30 = r13
            r2 = r24
            r11 = r25
        L_0x0820:
            r13 = 0
            goto L_0x05ad
        L_0x0823:
            boolean r0 = r68.isEmpty()
            if (r0 == 0) goto L_0x082d
        L_0x0829:
            r11 = r28
            goto L_0x0a61
        L_0x082d:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r68.iterator()
        L_0x0836:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0829
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgh r4 = (com.google.android.gms.internal.measurement.zzgh) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x092d
            com.google.android.gms.measurement.internal.zzkp r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x0905, all -> 0x0902 }
            r14 = 2
            java.lang.String[] r0 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0905, all -> 0x0902 }
            r14 = 0
            r0[r14] = r7     // Catch:{ SQLiteException -> 0x0905, all -> 0x0902 }
            r14 = 1
            r0[r14] = r5     // Catch:{ SQLiteException -> 0x0905, all -> 0x0902 }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0905, all -> 0x0902 }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x08fe }
            if (r0 == 0) goto L_0x08f0
        L_0x0893:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x08fe }
            com.google.android.gms.internal.measurement.zzer r15 = com.google.android.gms.internal.measurement.zzes.zzc()     // Catch:{ IOException -> 0x08ca }
            com.google.android.gms.internal.measurement.zzlb r0 = com.google.android.gms.measurement.internal.zzkr.zzl(r15, r0)     // Catch:{ IOException -> 0x08ca }
            com.google.android.gms.internal.measurement.zzer r0 = (com.google.android.gms.internal.measurement.zzer) r0     // Catch:{ IOException -> 0x08ca }
            com.google.android.gms.internal.measurement.zzjx r0 = r0.zzay()     // Catch:{ IOException -> 0x08ca }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x08ca }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x08fe }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x08fe }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x08fe }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x08fe }
            if (r16 != 0) goto L_0x08c2
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x08fe }
            r15.<init>()     // Catch:{ SQLiteException -> 0x08fe }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x08fe }
            goto L_0x08c4
        L_0x08c2:
            r15 = r16
        L_0x08c4:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x08fe }
            r67 = r3
            goto L_0x08e0
        L_0x08ca:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r14 = r6.zzs     // Catch:{ SQLiteException -> 0x08fe }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()     // Catch:{ SQLiteException -> 0x08fe }
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzd()     // Catch:{ SQLiteException -> 0x08fe }
            java.lang.String r15 = "Failed to merge filter"
            r67 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ SQLiteException -> 0x08fc }
            r14.zzc(r15, r3, r0)     // Catch:{ SQLiteException -> 0x08fc }
        L_0x08e0:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x08fc }
            if (r0 != 0) goto L_0x08ed
            if (r13 == 0) goto L_0x08eb
            r13.close()
        L_0x08eb:
            r0 = r8
            goto L_0x0921
        L_0x08ed:
            r3 = r67
            goto L_0x0893
        L_0x08f0:
            r67 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x08fc }
            if (r13 == 0) goto L_0x0921
        L_0x08f8:
            r13.close()
            goto L_0x0921
        L_0x08fc:
            r0 = move-exception
            goto L_0x0909
        L_0x08fe:
            r0 = move-exception
            r67 = r3
            goto L_0x0909
        L_0x0902:
            r0 = move-exception
            r5 = 0
            goto L_0x0927
        L_0x0905:
            r0 = move-exception
            r67 = r3
            r13 = 0
        L_0x0909:
            com.google.android.gms.measurement.internal.zzfr r3 = r6.zzs     // Catch:{ all -> 0x0925 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0925 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0925 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0925 }
            r3.zzc(r12, r6, r0)     // Catch:{ all -> 0x0925 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0925 }
            if (r13 == 0) goto L_0x0921
            goto L_0x08f8
        L_0x0921:
            r2.put(r5, r0)
            goto L_0x0933
        L_0x0925:
            r0 = move-exception
            r5 = r13
        L_0x0927:
            if (r5 == 0) goto L_0x092c
            r5.close()
        L_0x092c:
            throw r0
        L_0x092d:
            r67 = r3
            r11 = r28
            r9 = r29
        L_0x0933:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x093b:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0a59
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x0966
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            r0.zzb(r1, r7)
            goto L_0x0a59
        L_0x0966:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x0971:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a48
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            com.google.android.gms.measurement.internal.zzfr r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()
            java.lang.String r8 = r8.zzq()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x09db
            com.google.android.gms.measurement.internal.zzfr r8 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zzj()
            if (r15 == 0) goto L_0x09ab
            int r15 = r7.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09ac
        L_0x09ab:
            r15 = 0
        L_0x09ac:
            com.google.android.gms.measurement.internal.zzfr r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzec r13 = r13.zzj()
            r68 = r0
            java.lang.String r0 = r7.zze()
            java.lang.String r0 = r13.zzf(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzkp r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzkr r8 = r8.zzu()
            java.lang.String r8 = r8.zzp(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x09dd
        L_0x09db:
            r68 = r0
        L_0x09dd:
            boolean r0 = r7.zzj()
            if (r0 == 0) goto L_0x0a1e
            int r0 = r7.zza()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x09ec
            goto L_0x0a1e
        L_0x09ec:
            com.google.android.gms.measurement.internal.zzy r0 = new com.google.android.gms.measurement.internal.zzy
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zza()
            boolean r7 = r10.zzf(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a14
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzt r8 = r10.zzd(r8)
            r8.zzc(r0)
            r0 = r68
            goto L_0x0971
        L_0x0a14:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a4a
        L_0x0a1e:
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)
            boolean r8 = r7.zzj()
            if (r8 == 0) goto L_0x0a3d
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a3e
        L_0x0a3d:
            r7 = 0
        L_0x0a3e:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a4c
        L_0x0a48:
            r68 = r0
        L_0x0a4a:
            if (r7 != 0) goto L_0x0a55
        L_0x0a4c:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0a55:
            r0 = r68
            goto L_0x093b
        L_0x0a59:
            r3 = r67
            r29 = r9
            r28 = r11
            goto L_0x0836
        L_0x0a61:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a75:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b0a
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzt r3 = (com.google.android.gms.measurement.internal.zzt) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfk r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzkp r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgd r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbq()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r25
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0af1 }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0aef }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b06
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzs     // Catch:{ SQLiteException -> 0x0aef }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0aef }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0aef }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ SQLiteException -> 0x0aef }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0aef }
            goto L_0x0b06
        L_0x0aef:
            r0 = move-exception
            goto L_0x0af3
        L_0x0af1:
            r0 = move-exception
            r9 = 0
        L_0x0af3:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.zzc(r6, r5, r0)
        L_0x0b06:
            r25 = r4
            goto L_0x0a75
        L_0x0b0a:
            return r1
        L_0x0b0b:
            r0 = move-exception
            r5 = r4
        L_0x0b0d:
            if (r5 == 0) goto L_0x0b12
            r5.close()
        L_0x0b12:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzz.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
