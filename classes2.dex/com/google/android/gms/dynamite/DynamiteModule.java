package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class DynamiteModule {
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static final ThreadLocal<zzn> zzf = new ThreadLocal<>();
    private static final ThreadLocal<Long> zzg = new zzd();
    private static final VersionPolicy.IVersions zzh = new zze();
    private static zzq zzj;
    private static zzr zzk;
    private final Context zzi;

    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzi = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        int i;
        Boolean bool;
        DynamiteModule dynamiteModule;
        IObjectWrapper iObjectWrapper;
        zzr zzr;
        Boolean valueOf;
        IObjectWrapper iObjectWrapper2;
        Context context2 = context;
        VersionPolicy versionPolicy2 = versionPolicy;
        String str2 = str;
        Class<DynamiteModule> cls = DynamiteModule.class;
        ThreadLocal<zzn> threadLocal = zzf;
        zzn zzn = threadLocal.get();
        zzn zzn2 = new zzn((zzm) null);
        threadLocal.set(zzn2);
        ThreadLocal<Long> threadLocal2 = zzg;
        long longValue = threadLocal2.get().longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectModule = versionPolicy2.selectModule(context2, str2, zzh);
            int i2 = selectModule.localVersion;
            int i3 = selectModule.remoteVersion;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str2);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str2);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = selectModule.selection;
            if (i4 != 0) {
                if (i4 == -1) {
                    if (selectModule.localVersion != 0) {
                        i4 = -1;
                    }
                }
                if (!(i4 == 1 && selectModule.remoteVersion == 0)) {
                    if (i4 == -1) {
                        DynamiteModule zzc2 = zzc(context2, str2);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = zzn2.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(zzn);
                        return zzc2;
                    } else if (i4 == 1) {
                        try {
                            int i5 = selectModule.remoteVersion;
                            try {
                                synchronized (cls) {
                                    bool = zzb;
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
                                        sb2.append("Selected remote version of ");
                                        sb2.append(str2);
                                        sb2.append(", version >= ");
                                        sb2.append(i5);
                                        Log.i("DynamiteModule", sb2.toString());
                                        synchronized (cls) {
                                            zzr = zzk;
                                        }
                                        if (zzr != null) {
                                            zzn zzn3 = threadLocal.get();
                                            if (zzn3 == null || zzn3.zza == null) {
                                                throw new LoadingException("No result cursor", (zzp) null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor2 = zzn3.zza;
                                            ObjectWrapper.wrap(null);
                                            synchronized (cls) {
                                                valueOf = Boolean.valueOf(zze >= 2);
                                            }
                                            if (valueOf.booleanValue()) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                iObjectWrapper2 = zzr.zzf(ObjectWrapper.wrap(applicationContext), str2, i5, ObjectWrapper.wrap(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                iObjectWrapper2 = zzr.zze(ObjectWrapper.wrap(applicationContext), str2, i5, ObjectWrapper.wrap(cursor2));
                                            }
                                            Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                                            if (context3 != null) {
                                                dynamiteModule = new DynamiteModule(context3);
                                            } else {
                                                throw new LoadingException("Failed to get module context", (zzp) null);
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzp) null);
                                        }
                                    } else {
                                        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 51);
                                        sb3.append("Selected remote version of ");
                                        sb3.append(str2);
                                        sb3.append(", version >= ");
                                        sb3.append(i5);
                                        Log.i("DynamiteModule", sb3.toString());
                                        zzq zzf2 = zzf(context);
                                        if (zzf2 != null) {
                                            int zze2 = zzf2.zze();
                                            if (zze2 >= 3) {
                                                zzn zzn4 = threadLocal.get();
                                                if (zzn4 != null) {
                                                    iObjectWrapper = zzf2.zzi(ObjectWrapper.wrap(context), str2, i5, ObjectWrapper.wrap(zzn4.zza));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder", (zzp) null);
                                                }
                                            } else if (zze2 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                iObjectWrapper = zzf2.zzj(ObjectWrapper.wrap(context), str2, i5);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                iObjectWrapper = zzf2.zzh(ObjectWrapper.wrap(context), str2, i5);
                                            }
                                            if (ObjectWrapper.unwrap(iObjectWrapper) != null) {
                                                dynamiteModule = new DynamiteModule((Context) ObjectWrapper.unwrap(iObjectWrapper));
                                            } else {
                                                throw new LoadingException("Failed to load remote module.", (zzp) null);
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", (zzp) null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = zzn2.zza;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(zzn);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", (zzp) null);
                            } catch (RemoteException e) {
                                throw new LoadingException("Failed to load remote module.", e, (zzp) null);
                            } catch (LoadingException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                CrashUtils.addDynamiteErrorToDropBox(context2, th);
                                throw new LoadingException("Failed to load remote module.", th, (zzp) null);
                            }
                        } catch (LoadingException e3) {
                            String valueOf2 = String.valueOf(e3.getMessage());
                            Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to load remote module: ".concat(valueOf2) : new String("Failed to load remote module: "));
                            int i6 = selectModule.localVersion;
                            if (i6 != 0) {
                                if (versionPolicy.selectModule(context2, str2, new zzo(i6, 0)).selection == -1) {
                                    DynamiteModule zzc3 = zzc(context2, str2);
                                    if (i != 0) {
                                        zzg.set(Long.valueOf(longValue));
                                    }
                                    return zzc3;
                                }
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e3, (zzp) null);
                        }
                    } else {
                        StringBuilder sb4 = new StringBuilder(47);
                        sb4.append("VersionPolicy returned invalid code:");
                        sb4.append(i4);
                        throw new LoadingException(sb4.toString(), (zzp) null);
                    }
                }
            }
            int i7 = selectModule.localVersion;
            int i8 = selectModule.remoteVersion;
            StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 92);
            sb5.append("No acceptable module ");
            sb5.append(str2);
            sb5.append(" found. Local version is ");
            sb5.append(i7);
            sb5.append(" and remote version is ");
            sb5.append(i8);
            sb5.append(".");
            throw new LoadingException(sb5.toString(), (zzp) null);
        } finally {
            if (longValue == 0) {
                zzg.remove();
            } else {
                zzg.set(Long.valueOf(longValue));
            }
            Cursor cursor4 = zzn2.zza;
            if (cursor4 != null) {
                cursor4.close();
            }
            zzf.set(zzn);
        }
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
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0090=Splitter:B:43:0x0090, B:18:0x003a=Splitter:B:18:0x003a, B:24:0x004a=Splitter:B:24:0x004a} */
    public static int zza(android.content.Context r9, java.lang.String r10, boolean r11) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c9 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01c6 }
            r2 = 0
            if (r1 != 0) goto L_0x00d4
            android.content.Context r1 = r9.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r3 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r3 = r3.getName()     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            java.lang.Class r1 = r1.loadClass(r3)     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            java.lang.String r3 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            java.lang.Class r3 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            monitor-enter(r3)     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
            java.lang.Object r4 = r1.get(r2)     // Catch:{ all -> 0x00a8 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x003d
            java.lang.ClassLoader r1 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a8 }
            if (r4 != r1) goto L_0x0037
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a8 }
            goto L_0x00a6
        L_0x0037:
            zzd(r4)     // Catch:{ LoadingException -> 0x003a }
        L_0x003a:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a8 }
            goto L_0x00a6
        L_0x003d:
            boolean r4 = zzd     // Catch:{ all -> 0x00a8 }
            if (r4 != 0) goto L_0x009d
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x004a
            goto L_0x009d
        L_0x004a:
            int r4 = zzb(r9, r10, r11)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.String r5 = zzc     // Catch:{ LoadingException -> 0x0093 }
            if (r5 == 0) goto L_0x0090
            boolean r5 = r5.isEmpty()     // Catch:{ LoadingException -> 0x0093 }
            if (r5 == 0) goto L_0x0059
            goto L_0x0090
        L_0x0059:
            java.lang.ClassLoader r5 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x0093 }
            if (r5 == 0) goto L_0x0060
            goto L_0x0083
        L_0x0060:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x0093 }
            r6 = 29
            if (r5 < r6) goto L_0x0075
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x0093 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x0093 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0093 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0093 }
            goto L_0x0083
        L_0x0075:
            com.google.android.gms.dynamite.zzc r5 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x0093 }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x0093 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x0093 }
            r5.<init>(r6, r7)     // Catch:{ LoadingException -> 0x0093 }
        L_0x0083:
            zzd(r5)     // Catch:{ LoadingException -> 0x0093 }
            r1.set(r2, r5)     // Catch:{ LoadingException -> 0x0093 }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x0093 }
            zzb = r5     // Catch:{ LoadingException -> 0x0093 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c6 }
            return r4
        L_0x0090:
            monitor-exit(r3)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c6 }
            return r4
        L_0x0093:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a8 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a8 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a8 }
            goto L_0x00a6
        L_0x009d:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00a8 }
            r1.set(r2, r4)     // Catch:{ all -> 0x00a8 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00a8 }
        L_0x00a6:
            monitor-exit(r3)     // Catch:{ all -> 0x00a8 }
            goto L_0x00d2
        L_0x00a8:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a8 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00af, IllegalAccessException -> 0x00ad, NoSuchFieldException -> 0x00ab }
        L_0x00ab:
            r1 = move-exception
            goto L_0x00b0
        L_0x00ad:
            r1 = move-exception
            goto L_0x00b0
        L_0x00af:
            r1 = move-exception
        L_0x00b0:
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c6 }
            int r4 = r1.length()     // Catch:{ all -> 0x01c6 }
            int r4 = r4 + 30
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r5.<init>(r4)     // Catch:{ all -> 0x01c6 }
            java.lang.String r4 = "Failed to load module via V2: "
            r5.append(r4)     // Catch:{ all -> 0x01c6 }
            r5.append(r1)     // Catch:{ all -> 0x01c6 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01c6 }
            android.util.Log.w(r3, r1)     // Catch:{ all -> 0x01c6 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01c6 }
        L_0x00d2:
            zzb = r1     // Catch:{ all -> 0x01c6 }
        L_0x00d4:
            monitor-exit(r0)     // Catch:{ all -> 0x01c6 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c9 }
            r1 = 0
            if (r0 == 0) goto L_0x0102
            int r9 = zzb(r9, r10, r11)     // Catch:{ LoadingException -> 0x00e1 }
            return r9
        L_0x00e1:
            r10 = move-exception
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x01c9 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x01c9 }
            int r2 = r10.length()     // Catch:{ all -> 0x01c9 }
            if (r2 == 0) goto L_0x00f9
            java.lang.String r10 = r0.concat(r10)     // Catch:{ all -> 0x01c9 }
            goto L_0x00fe
        L_0x00f9:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x01c9 }
            r10.<init>(r0)     // Catch:{ all -> 0x01c9 }
        L_0x00fe:
            android.util.Log.w(r11, r10)     // Catch:{ all -> 0x01c9 }
            return r1
        L_0x0102:
            com.google.android.gms.dynamite.zzq r3 = zzf(r9)     // Catch:{ all -> 0x01c9 }
            if (r3 != 0) goto L_0x010a
            goto L_0x01bd
        L_0x010a:
            int r0 = r3.zze()     // Catch:{ RemoteException -> 0x0197 }
            r4 = 3
            if (r0 < r4) goto L_0x0172
            java.lang.ThreadLocal<com.google.android.gms.dynamite.zzn> r0 = zzf     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0197 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0197 }
            if (r0 == 0) goto L_0x0125
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0197 }
            if (r0 == 0) goto L_0x0125
            int r1 = r0.getInt(r1)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01bd
        L_0x0125:
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0197 }
            java.lang.ThreadLocal<java.lang.Long> r0 = zzg     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0197 }
            long r7 = r0.longValue()     // Catch:{ RemoteException -> 0x0197 }
            r5 = r10
            r6 = r11
            com.google.android.gms.dynamic.IObjectWrapper r10 = r3.zzk(r4, r5, r6, r7)     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)     // Catch:{ RemoteException -> 0x0197 }
            android.database.Cursor r10 = (android.database.Cursor) r10     // Catch:{ RemoteException -> 0x0197 }
            if (r10 == 0) goto L_0x015f
            boolean r11 = r10.moveToFirst()     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r11 != 0) goto L_0x014a
            goto L_0x015f
        L_0x014a:
            int r11 = r10.getInt(r1)     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r11 <= 0) goto L_0x0157
            boolean r0 = zze(r10)     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r0 == 0) goto L_0x0157
            goto L_0x0158
        L_0x0157:
            r2 = r10
        L_0x0158:
            if (r2 == 0) goto L_0x015d
            r2.close()     // Catch:{ all -> 0x01c9 }
        L_0x015d:
            r1 = r11
            goto L_0x01bd
        L_0x015f:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r0)     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r10 == 0) goto L_0x01bd
            r10.close()     // Catch:{ all -> 0x01c9 }
            goto L_0x01bd
        L_0x016c:
            r11 = move-exception
            r2 = r10
            goto L_0x01c0
        L_0x016f:
            r11 = move-exception
            r2 = r10
            goto L_0x0199
        L_0x0172:
            r4 = 2
            if (r0 != r4) goto L_0x0185
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0197 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0197 }
            int r1 = r3.zzg(r0, r10, r11)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01bd
        L_0x0185:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r4 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r4)     // Catch:{ RemoteException -> 0x0197 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r9)     // Catch:{ RemoteException -> 0x0197 }
            int r1 = r3.zzf(r0, r10, r11)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01bd
        L_0x0195:
            r11 = r10
            goto L_0x01c0
        L_0x0197:
            r10 = move-exception
            r11 = r10
        L_0x0199:
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01be }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x01be }
            int r3 = r11.length()     // Catch:{ all -> 0x01be }
            if (r3 == 0) goto L_0x01b0
            java.lang.String r11 = r0.concat(r11)     // Catch:{ all -> 0x01be }
            goto L_0x01b5
        L_0x01b0:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x01be }
            r11.<init>(r0)     // Catch:{ all -> 0x01be }
        L_0x01b5:
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x01be }
            if (r2 == 0) goto L_0x01bd
            r2.close()     // Catch:{ all -> 0x01c9 }
        L_0x01bd:
            return r1
        L_0x01be:
            r10 = move-exception
            goto L_0x0195
        L_0x01c0:
            if (r2 == 0) goto L_0x01c5
            r2.close()     // Catch:{ all -> 0x01c9 }
        L_0x01c5:
            throw r11     // Catch:{ all -> 0x01c9 }
        L_0x01c6:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c6 }
            throw r10     // Catch:{ all -> 0x01c9 }
        L_0x01c9:
            r10 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r9, r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal<java.lang.Long> r1 = zzg     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r12.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00af }
            if (r10 == 0) goto L_0x00a0
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009e }
            if (r11 == 0) goto L_0x00a0
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009e }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009e }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = r11
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009e }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009e }
        L_0x008e:
            if (r11 != 0) goto L_0x0096
            if (r10 == 0) goto L_0x0095
            r10.close()
        L_0x0095:
            return r12
        L_0x0096:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009e }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009e }
            throw r11     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            r11 = move-exception
            goto L_0x00b5
        L_0x00a0:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009e }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009e }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009e }
            throw r11     // Catch:{ Exception -> 0x009e }
        L_0x00af:
            r10 = move-exception
            r11 = r10
            goto L_0x00c4
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b5:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00c2 }
            if (r12 == 0) goto L_0x00ba
            throw r11     // Catch:{ all -> 0x00c2 }
        L_0x00ba:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = "V2 version check failed"
            r12.<init>(r1, r11, r0)     // Catch:{ all -> 0x00c2 }
            throw r12     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r11 = move-exception
            r0 = r10
        L_0x00c4:
            if (r0 == 0) goto L_0x00c9
            r0.close()
        L_0x00c9:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzk = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = zzf.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static zzq zzf(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzj;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzj = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    public Context getModuleContext() {
        return this.zzi;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzi.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (zzp) null);
        }
    }
}
