package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public abstract class zzhu {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzhs zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzhw zzh = new zzhw(zzhl.zza, (byte[]) null);
    private static final AtomicInteger zzi = new AtomicInteger();
    final zzhr zza;
    final String zzb;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;

    /* synthetic */ zzhu(zzhr zzhr, String str, Object obj, boolean z, zzht zzht) {
        if (zzhr.zzb != null) {
            this.zza = zzhr;
            this.zzb = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    static void zzd() {
        zzi.incrementAndGet();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void zze(android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.zzhs r0 = zze
            if (r0 != 0) goto L_0x0045
            java.lang.Object r0 = zzd
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzhs r1 = zze     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0040
            monitor-enter(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.measurement.zzhs r1 = zze     // Catch:{ all -> 0x003d }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0015
            r3 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x001d
            android.content.Context r1 = r1.zza()     // Catch:{ all -> 0x003d }
            if (r1 == r3) goto L_0x003b
        L_0x001d:
            com.google.android.gms.internal.measurement.zzha.zze()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzhv.zzc()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzhh.zze()     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzhm r1 = new com.google.android.gms.internal.measurement.zzhm     // Catch:{ all -> 0x003d }
            r1.<init>(r3)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzib r1 = com.google.android.gms.internal.measurement.zzif.zza(r1)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.measurement.zzgx r2 = new com.google.android.gms.internal.measurement.zzgx     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            zze = r2     // Catch:{ all -> 0x003d }
            java.util.concurrent.atomic.AtomicInteger r3 = zzi     // Catch:{ all -> 0x003d }
            r3.incrementAndGet()     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r3     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r3
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhu.zze(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb() {
        /*
            r7 = this;
            boolean r0 = r7.zzm
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = r7.zzb
            java.lang.String r1 = "flagName must not be null"
            java.util.Objects.requireNonNull(r0, r1)
        L_0x000b:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r7.zzk
            if (r1 >= r0) goto L_0x0121
            monitor-enter(r7)
            int r1 = r7.zzk     // Catch:{ all -> 0x011e }
            if (r1 >= r0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzhs r1 = zze     // Catch:{ all -> 0x011e }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x0116
            com.google.android.gms.internal.measurement.zzhr r2 = r7.zza     // Catch:{ all -> 0x011e }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x011e }
            boolean r2 = r2.zzg     // Catch:{ all -> 0x011e }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhh r2 = com.google.android.gms.internal.measurement.zzhh.zza(r2)     // Catch:{ all -> 0x011e }
            java.lang.String r3 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zzb(r3)     // Catch:{ all -> 0x011e }
            r3 = 0
            if (r2 == 0) goto L_0x006e
            java.util.regex.Pattern r4 = com.google.android.gms.internal.measurement.zzgv.zzc     // Catch:{ all -> 0x011e }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x011e }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x006c
            java.lang.String r2 = "PhenotypeFlag"
            java.lang.String r4 = "Bypass reading Phenotype values for flag: "
            java.lang.String r5 = r7.zzc()     // Catch:{ all -> 0x011e }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x011e }
            int r6 = r5.length()     // Catch:{ all -> 0x011e }
            if (r6 == 0) goto L_0x0063
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x011e }
            goto L_0x0069
        L_0x0063:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x011e }
            r5.<init>(r4)     // Catch:{ all -> 0x011e }
            r4 = r5
        L_0x0069:
            android.util.Log.d(r2, r4)     // Catch:{ all -> 0x011e }
        L_0x006c:
            r2 = r3
            goto L_0x00b5
        L_0x006e:
            com.google.android.gms.internal.measurement.zzhr r2 = r7.zza     // Catch:{ all -> 0x011e }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0099
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhr r4 = r7.zza     // Catch:{ all -> 0x011e }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.measurement.zzhj.zza(r2, r4)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0097
            com.google.android.gms.internal.measurement.zzhr r2 = r7.zza     // Catch:{ all -> 0x011e }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x011e }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x011e }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhr r4 = r7.zza     // Catch:{ all -> 0x011e }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzha r2 = com.google.android.gms.internal.measurement.zzha.zza(r2, r4)     // Catch:{ all -> 0x011e }
            goto L_0x00a5
        L_0x0097:
            r2 = r3
            goto L_0x00a5
        L_0x0099:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhr r4 = r7.zza     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhv r2 = com.google.android.gms.internal.measurement.zzhv.zza(r2, r3)     // Catch:{ all -> 0x011e }
        L_0x00a5:
            if (r2 == 0) goto L_0x006c
            java.lang.String r4 = r7.zzc()     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x006c
            java.lang.Object r2 = r7.zza(r2)     // Catch:{ all -> 0x011e }
        L_0x00b5:
            if (r2 == 0) goto L_0x00b8
            goto L_0x00e4
        L_0x00b8:
            com.google.android.gms.internal.measurement.zzhr r2 = r7.zza     // Catch:{ all -> 0x011e }
            boolean r4 = r2.zze     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x00df
            com.google.android.gms.internal.measurement.zzhy r2 = r2.zzi     // Catch:{ all -> 0x011e }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhh r2 = com.google.android.gms.internal.measurement.zzhh.zza(r2)     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhr r4 = r7.zza     // Catch:{ all -> 0x011e }
            boolean r5 = r4.zze     // Catch:{ all -> 0x011e }
            if (r5 == 0) goto L_0x00d0
            r4 = r3
            goto L_0x00d4
        L_0x00d0:
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r7.zzb     // Catch:{ all -> 0x011e }
        L_0x00d4:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00df
            java.lang.Object r2 = r7.zza(r2)     // Catch:{ all -> 0x011e }
            goto L_0x00e0
        L_0x00df:
            r2 = r3
        L_0x00e0:
            if (r2 != 0) goto L_0x00e4
            java.lang.Object r2 = r7.zzj     // Catch:{ all -> 0x011e }
        L_0x00e4:
            com.google.android.gms.internal.measurement.zzib r1 = r1.zzb()     // Catch:{ all -> 0x011e }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhz r1 = (com.google.android.gms.internal.measurement.zzhz) r1     // Catch:{ all -> 0x011e }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x0111
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhi r1 = (com.google.android.gms.internal.measurement.zzhi) r1     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.measurement.zzhr r2 = r7.zza     // Catch:{ all -> 0x011e }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x011e }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x011e }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x011e }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x011e }
            if (r1 != 0) goto L_0x010d
            java.lang.Object r2 = r7.zzj     // Catch:{ all -> 0x011e }
            goto L_0x0111
        L_0x010d:
            java.lang.Object r2 = r7.zza(r1)     // Catch:{ all -> 0x011e }
        L_0x0111:
            r7.zzl = r2     // Catch:{ all -> 0x011e }
            r7.zzk = r0     // Catch:{ all -> 0x011e }
            goto L_0x011c
        L_0x0116:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011e }
            r0.<init>(r2)     // Catch:{ all -> 0x011e }
            throw r0     // Catch:{ all -> 0x011e }
        L_0x011c:
            monitor-exit(r7)     // Catch:{ all -> 0x011e }
            goto L_0x0121
        L_0x011e:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x011e }
            throw r0
        L_0x0121:
            java.lang.Object r0 = r7.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhu.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
