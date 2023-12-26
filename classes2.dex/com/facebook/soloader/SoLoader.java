package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    static final String TAG = "SoLoader";
    private static boolean isSystemApp;
    @Nullable
    private static ApplicationSoSource sApplicationSoSource;
    @Nullable
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    /* access modifiers changed from: private */
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    @Nullable
    static SoFileLoader sSoFileLoader;
    /* access modifiers changed from: private */
    @Nullable
    public static SoSource[] sSoSources = null;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    private static volatile int sSoSourcesVersion = 0;
    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    static /* synthetic */ int access$208() {
        int i = sSoSourcesVersion;
        sSoSourcesVersion = i + 1;
        return i;
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, (SoFileLoader) null);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            isSystemApp = checkIfSystemApp(context, i);
            initSoLoader(soFileLoader);
            initSoSources(context, i, soFileLoader);
            NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initSoSources(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        int i2;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                Log.d(TAG, "init start");
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = SysUtil.is64Bit() ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str2 : str.split(":")) {
                    Log.d(TAG, "adding system library source: " + str2);
                    arrayList.add(new DirectorySoSource(new File(str2), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        Log.d(TAG, "adding exo package source: lib-main");
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        if (isSystemApp) {
                            i2 = 0;
                        } else {
                            sApplicationSoSource = new ApplicationSoSource(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            Log.d(TAG, "adding application source: " + sApplicationSoSource.toString());
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i2);
                            arrayList2.add(apkSoSource);
                            Log.d(TAG, "adding backup source from : " + apkSoSource.toString());
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d(TAG, "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    File file2 = new File(strArr[i3]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(SO_STORE_NAME_SPLIT);
                                    sb.append(i4);
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, file2, sb.toString(), i2);
                                    Log.d(TAG, "adding backup source: " + apkSoSource2.toString());
                                    arrayList2.add(apkSoSource2);
                                    i3++;
                                    i4++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length2 = soSourceArr.length;
                while (true) {
                    int i5 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d(TAG, "Preparing SO source: " + soSourceArr[i5]);
                    soSourceArr[i5].prepare(makePrepareFlags);
                    length2 = i5;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                Log.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
            }
        } finally {
            Log.d(TAG, "init exiting");
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int makePrepareFlags() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i = (sFlags & 2) != 0 ? 1 : 0;
            reentrantReadWriteLock.writeLock().unlock();
            return i;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                /* JADX WARNING: type inference failed for: r1v0 */
                /* JADX WARNING: type inference failed for: r1v10 */
                /* JADX WARNING: type inference failed for: r1v12 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    android.util.Log.e(com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x009e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r9, int r10) {
                    /*
                        r8 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00c9
                        r0 = 4
                        r10 = r10 & r0
                        r1 = 1
                        r2 = 0
                        if (r10 != r0) goto L_0x000c
                        r10 = r1
                        goto L_0x000d
                    L_0x000c:
                        r10 = r2
                    L_0x000d:
                        if (r10 == 0) goto L_0x0012
                        java.lang.String r10 = r3
                        goto L_0x0014
                    L_0x0012:
                        java.lang.String r10 = r4
                    L_0x0014:
                        r0 = 0
                        java.lang.Runtime r3 = r5     // Catch:{ IllegalAccessException -> 0x0080, IllegalArgumentException -> 0x007e, InvocationTargetException -> 0x007c, all -> 0x0077 }
                        monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0080, IllegalArgumentException -> 0x007e, InvocationTargetException -> 0x007c, all -> 0x0077 }
                        java.lang.reflect.Method r4 = r6     // Catch:{ all -> 0x0069 }
                        java.lang.Runtime r5 = r5     // Catch:{ all -> 0x0069 }
                        r6 = 3
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0069 }
                        r6[r2] = r9     // Catch:{ all -> 0x0069 }
                        java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x0069 }
                        r6[r1] = r2     // Catch:{ all -> 0x0069 }
                        r1 = 2
                        r6[r1] = r10     // Catch:{ all -> 0x0069 }
                        java.lang.Object r1 = r4.invoke(r5, r6)     // Catch:{ all -> 0x0069 }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0069 }
                        if (r1 != 0) goto L_0x0063
                        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
                        if (r1 == 0) goto L_0x00cc
                        java.lang.String r0 = "SoLoader"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Error when loading lib: "
                        r2.append(r3)
                        r2.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r2.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r2.append(r9)
                        java.lang.String r9 = " search path is "
                        r2.append(r9)
                        r2.append(r10)
                        java.lang.String r9 = r2.toString()
                        android.util.Log.e(r0, r9)
                        goto L_0x00cc
                    L_0x0063:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0075 }
                        r0.<init>(r1)     // Catch:{ all -> 0x0075 }
                        throw r0     // Catch:{ all -> 0x0075 }
                    L_0x0069:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x006d:
                        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
                        throw r0     // Catch:{ IllegalAccessException -> 0x0073, IllegalArgumentException -> 0x0071, InvocationTargetException -> 0x006f }
                    L_0x006f:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0071:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0073:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0075:
                        r0 = move-exception
                        goto L_0x006d
                    L_0x0077:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                        goto L_0x009c
                    L_0x007c:
                        r1 = move-exception
                        goto L_0x0081
                    L_0x007e:
                        r1 = move-exception
                        goto L_0x0081
                    L_0x0080:
                        r1 = move-exception
                    L_0x0081:
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x0084:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
                        r2.<init>()     // Catch:{ all -> 0x009b }
                        java.lang.String r3 = "Error: Cannot load "
                        r2.append(r3)     // Catch:{ all -> 0x009b }
                        r2.append(r9)     // Catch:{ all -> 0x009b }
                        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x009b }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x009b }
                        r2.<init>(r1, r0)     // Catch:{ all -> 0x009b }
                        throw r2     // Catch:{ all -> 0x009b }
                    L_0x009b:
                        r0 = move-exception
                    L_0x009c:
                        if (r1 == 0) goto L_0x00c8
                        java.lang.String r2 = "SoLoader"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r4 = "Error when loading lib: "
                        r3.append(r4)
                        r3.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r3.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r3.append(r9)
                        java.lang.String r9 = " search path is "
                        r3.append(r9)
                        r3.append(r10)
                        java.lang.String r9 = r3.toString()
                        android.util.Log.e(r2, r9)
                    L_0x00c8:
                        throw r0
                    L_0x00c9:
                        java.lang.System.load(r9)
                    L_0x00cc:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.load(java.lang.String, int):void");
                }

                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
                    throw r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private java.lang.String getLibHash(java.lang.String r7) {
                    /*
                        r6 = this;
                        java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        r0.<init>(r7)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        java.lang.String r7 = "MD5"
                        java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        r1.<init>(r0)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        r0 = 4096(0x1000, float:5.74E-42)
                        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0037 }
                    L_0x0014:
                        int r2 = r1.read(r0)     // Catch:{ all -> 0x0037 }
                        r3 = 0
                        if (r2 <= 0) goto L_0x001f
                        r7.update(r0, r3, r2)     // Catch:{ all -> 0x0037 }
                        goto L_0x0014
                    L_0x001f:
                        java.lang.String r0 = "%32x"
                        r2 = 1
                        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0037 }
                        java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ all -> 0x0037 }
                        byte[] r7 = r7.digest()     // Catch:{ all -> 0x0037 }
                        r5.<init>(r2, r7)     // Catch:{ all -> 0x0037 }
                        r4[r3] = r5     // Catch:{ all -> 0x0037 }
                        java.lang.String r7 = java.lang.String.format(r0, r4)     // Catch:{ all -> 0x0037 }
                        r1.close()     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        goto L_0x0054
                    L_0x0037:
                        r7 = move-exception
                        throw r7     // Catch:{ all -> 0x0039 }
                    L_0x0039:
                        r0 = move-exception
                        r1.close()     // Catch:{ all -> 0x003e }
                        goto L_0x0042
                    L_0x003e:
                        r1 = move-exception
                        r7.addSuppressed(r1)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                    L_0x0042:
                        throw r0     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                    L_0x0043:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                        goto L_0x0054
                    L_0x0049:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                        goto L_0x0054
                    L_0x004f:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                    L_0x0054:
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.getLibHash(java.lang.String):java.lang.String");
                }
            };
        }
    }

    @Nullable
    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e) {
                Log.w(TAG, "Cannot get nativeLoad method", e);
            }
        }
        return null;
    }

    private static boolean checkIfSystemApp(Context context, int i) {
        return ((i & 32) != 0 || context == null || (context.getApplicationInfo().flags & 129) == 0) ? false : true;
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources((SoSource[]) null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.access$208();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
            }
            setSoSources((SoSource[]) null);
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i = 0;
                while (str2 == null) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i >= soSourceArr.length) {
                        break;
                    }
                    str2 = soSourceArr[i].getLibraryPath(str);
                    i++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] strArr = null;
            if (sSoSources != null) {
                int i = 0;
                while (strArr == null) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i >= soSourceArr.length) {
                        break;
                    }
                    strArr = soSourceArr[i].getLibraryDependencies(str);
                    i++;
                }
            }
            return strArr;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z = !sLoadedLibraries.contains(str);
                        if (z) {
                            SystemLoadLibraryWrapper systemLoadLibraryWrapper2 = sSystemLoadLibraryWrapper;
                            if (systemLoadLibraryWrapper2 != null) {
                                systemLoadLibraryWrapper2.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            if (!isSystemApp || (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) == null) {
                String mapLibName = MergedSoMapping.mapLibName(str);
                return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i, (StrictMode.ThreadPolicy) null);
            }
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, (String) null, (String) null, i, threadPolicy);
    }

    private static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        boolean z2 = false;
        do {
            try {
                z2 = loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
                z = false;
                continue;
            } catch (UnsatisfiedLinkError e) {
                int i2 = sSoSourcesVersion;
                sSoSourcesLock.writeLock().lock();
                try {
                    z = true;
                    if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                        z = false;
                    } else {
                        Log.w(TAG, "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                        sSoSourcesVersion = sSoSourcesVersion + 1;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    if (sSoSourcesVersion == i2) {
                        throw e;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
        } while (z);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0143, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0144, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x014d, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r6 = sSoSourcesLock;
        r6.readLock().lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r3 != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        if (r1.contains(r10) == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
        if (r12 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
        r6.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0058, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0059, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
        if (r3 != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        android.util.Log.d(TAG, "About to load: " + r10);
        doLoadLibraryBySoName(r10, r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        android.util.Log.d(TAG, "Loaded: " + r10);
        r1.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0090, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0095, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0096, code lost:
        r11 = r10.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009a, code lost:
        if (r11 == null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b3, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r10, r11.substring(r11.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b4, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ba, code lost:
        if ((r13 & 16) != 0) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c0, code lost:
        if (android.text.TextUtils.isEmpty(r11) != false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c8, code lost:
        if (sLoadedAndMergedLibraries.contains(r11) == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ca, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00cb, code lost:
        if (r12 == null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00cd, code lost:
        if (r2 != false) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00cf, code lost:
        r12 = SYSTRACE_LIBRARY_LOADING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00d1, code lost:
        if (r12 == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d3, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r11, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        android.util.Log.d(TAG, "About to merge: " + r11 + " / " + r10);
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r11);
        sLoadedAndMergedLibraries.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0100, code lost:
        if (r12 == false) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0106, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0108, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x012c, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r11 + "', which has been merged into '" + r10 + "'.  See comment for details.", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x012f, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0131, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0134, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0135, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0136, code lost:
        r6.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x013f, code lost:
        return !r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoNameImpl(java.lang.String r10, @javax.annotation.Nullable java.lang.String r11, @javax.annotation.Nullable java.lang.String r12, int r13, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r14) {
        /*
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            r2 = 0
            if (r1 != 0) goto L_0x0012
            java.util.Set<java.lang.String> r1 = sLoadedAndMergedLibraries
            boolean r1 = r1.contains(r11)
            if (r1 == 0) goto L_0x0012
            return r2
        L_0x0012:
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r1 = sLoadedLibraries     // Catch:{ all -> 0x014e }
            boolean r3 = r1.contains(r10)     // Catch:{ all -> 0x014e }
            r4 = 1
            if (r3 == 0) goto L_0x0022
            if (r12 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x014e }
            return r2
        L_0x0020:
            r3 = r4
            goto L_0x0023
        L_0x0022:
            r3 = r2
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r5 = sLoadingLibraries     // Catch:{ all -> 0x014e }
            boolean r6 = r5.containsKey(r10)     // Catch:{ all -> 0x014e }
            if (r6 == 0) goto L_0x0030
            java.lang.Object r5 = r5.get(r10)     // Catch:{ all -> 0x014e }
            goto L_0x0039
        L_0x0030:
            java.lang.Object r6 = new java.lang.Object     // Catch:{ all -> 0x014e }
            r6.<init>()     // Catch:{ all -> 0x014e }
            r5.put(r10, r6)     // Catch:{ all -> 0x014e }
            r5 = r6
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x014e }
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r7 = r6.readLock()
            r7.lock()
            monitor-enter(r5)     // Catch:{ all -> 0x0143 }
            if (r3 != 0) goto L_0x00b8
            monitor-enter(r0)     // Catch:{ all -> 0x0140 }
            boolean r7 = r1.contains(r10)     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x005a
            if (r12 != 0) goto L_0x0059
            monitor-exit(r0)     // Catch:{ all -> 0x00b5 }
            monitor-exit(r5)     // Catch:{ all -> 0x0140 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r6.readLock()
            r10.unlock()
            return r2
        L_0x0059:
            r3 = r4
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x00b5 }
            if (r3 != 0) goto L_0x00b8
            java.lang.String r7 = "SoLoader"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            r8.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            java.lang.String r9 = "About to load: "
            r8.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            r8.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            java.lang.String r8 = r8.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            android.util.Log.d(r7, r8)     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            doLoadLibraryBySoName(r10, r13, r14)     // Catch:{ UnsatisfiedLinkError -> 0x0095 }
            monitor-enter(r0)     // Catch:{ all -> 0x0140 }
            java.lang.String r14 = "SoLoader"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r7.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = "Loaded: "
            r7.append(r8)     // Catch:{ all -> 0x0092 }
            r7.append(r10)     // Catch:{ all -> 0x0092 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0092 }
            android.util.Log.d(r14, r7)     // Catch:{ all -> 0x0092 }
            r1.add(r10)     // Catch:{ all -> 0x0092 }
            monitor-exit(r0)     // Catch:{ all -> 0x0092 }
            goto L_0x00b8
        L_0x0092:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0092 }
            throw r10     // Catch:{ all -> 0x0140 }
        L_0x0095:
            r10 = move-exception
            java.lang.String r11 = r10.getMessage()     // Catch:{ all -> 0x0140 }
            if (r11 == 0) goto L_0x00b4
            java.lang.String r12 = "unexpected e_machine:"
            boolean r12 = r11.contains(r12)     // Catch:{ all -> 0x0140 }
            if (r12 == 0) goto L_0x00b4
            java.lang.String r12 = "unexpected e_machine:"
            int r12 = r11.lastIndexOf(r12)     // Catch:{ all -> 0x0140 }
            java.lang.String r11 = r11.substring(r12)     // Catch:{ all -> 0x0140 }
            com.facebook.soloader.SoLoader$WrongAbiError r12 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x0140 }
            r12.<init>(r10, r11)     // Catch:{ all -> 0x0140 }
            throw r12     // Catch:{ all -> 0x0140 }
        L_0x00b4:
            throw r10     // Catch:{ all -> 0x0140 }
        L_0x00b5:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b5 }
            throw r10     // Catch:{ all -> 0x0140 }
        L_0x00b8:
            r13 = r13 & 16
            if (r13 != 0) goto L_0x0135
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0140 }
            if (r13 != 0) goto L_0x00cb
            java.util.Set<java.lang.String> r13 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x0140 }
            boolean r13 = r13.contains(r11)     // Catch:{ all -> 0x0140 }
            if (r13 == 0) goto L_0x00cb
            r2 = r4
        L_0x00cb:
            if (r12 == 0) goto L_0x0135
            if (r2 != 0) goto L_0x0135
            boolean r12 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0140 }
            if (r12 == 0) goto L_0x00da
            java.lang.String r13 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r14 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r13, r11, r14)     // Catch:{ all -> 0x0140 }
        L_0x00da:
            java.lang.String r13 = "SoLoader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            r14.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            java.lang.String r0 = "About to merge: "
            r14.append(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            r14.append(r11)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            java.lang.String r0 = " / "
            r14.append(r0)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            r14.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            java.lang.String r14 = r14.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            android.util.Log.d(r13, r14)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r11)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            java.util.Set<java.lang.String> r13 = sLoadedAndMergedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            r13.add(r11)     // Catch:{ UnsatisfiedLinkError -> 0x0108 }
            if (r12 == 0) goto L_0x0135
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0140 }
            goto L_0x0135
        L_0x0106:
            r10 = move-exception
            goto L_0x012d
        L_0x0108:
            r12 = move-exception
            java.lang.RuntimeException r13 = new java.lang.RuntimeException     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r14.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = "Failed to call JNI_OnLoad from '"
            r14.append(r0)     // Catch:{ all -> 0x0106 }
            r14.append(r11)     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = "', which has been merged into '"
            r14.append(r11)     // Catch:{ all -> 0x0106 }
            r14.append(r10)     // Catch:{ all -> 0x0106 }
            java.lang.String r10 = "'.  See comment for details."
            r14.append(r10)     // Catch:{ all -> 0x0106 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x0106 }
            r13.<init>(r10, r12)     // Catch:{ all -> 0x0106 }
            throw r13     // Catch:{ all -> 0x0106 }
        L_0x012d:
            boolean r11 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0140 }
            if (r11 == 0) goto L_0x0134
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0140 }
        L_0x0134:
            throw r10     // Catch:{ all -> 0x0140 }
        L_0x0135:
            monitor-exit(r5)     // Catch:{ all -> 0x0140 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r6.readLock()
            r10.unlock()
            r10 = r3 ^ 1
            return r10
        L_0x0140:
            r10 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0140 }
            throw r10     // Catch:{ all -> 0x0143 }
        L_0x0143:
            r10 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r11 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r11 = r11.readLock()
            r11.unlock()
            throw r10
        L_0x014e:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x014e }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doLoadLibraryBySoName(java.lang.String r12, int r13, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r14) throws java.lang.UnsatisfiedLinkError {
        /*
            java.lang.String r0 = " result: "
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.readLock()
            r2.lock()
            com.facebook.soloader.SoSource[] r2 = sSoSources     // Catch:{ all -> 0x0184 }
            java.lang.String r3 = "couldn't find DSO to load: "
            java.lang.String r4 = "SoLoader"
            if (r2 == 0) goto L_0x0156
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.readLock()
            r2.unlock()
            r2 = 1
            r5 = 0
            if (r14 != 0) goto L_0x0024
            android.os.StrictMode$ThreadPolicy r14 = android.os.StrictMode.allowThreadDiskReads()
            r6 = r2
            goto L_0x0025
        L_0x0024:
            r6 = r5
        L_0x0025:
            boolean r7 = SYSTRACE_LIBRARY_LOADING
            if (r7 == 0) goto L_0x0030
            java.lang.String r7 = "SoLoader.loadLibrary["
            java.lang.String r8 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r7, r12, r8)
        L_0x0030:
            r7 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch:{ all -> 0x010d }
            r1.lock()     // Catch:{ all -> 0x010d }
            r1 = r5
            r8 = r1
        L_0x003a:
            if (r1 != 0) goto L_0x0086
            com.facebook.soloader.SoSource[] r9 = sSoSources     // Catch:{ all -> 0x007a }
            int r10 = r9.length     // Catch:{ all -> 0x007a }
            if (r8 >= r10) goto L_0x0086
            r9 = r9[r8]     // Catch:{ all -> 0x007a }
            int r1 = r9.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x007a }
            if (r1 != r7) goto L_0x0077
            com.facebook.soloader.UnpackingSoSource[] r9 = sBackupSoSources     // Catch:{ all -> 0x007a }
            if (r9 == 0) goto L_0x0077
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r8.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r9 = "Trying backup SoSource for "
            r8.append(r9)     // Catch:{ all -> 0x007a }
            r8.append(r12)     // Catch:{ all -> 0x007a }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x007a }
            android.util.Log.d(r4, r8)     // Catch:{ all -> 0x007a }
            com.facebook.soloader.UnpackingSoSource[] r8 = sBackupSoSources     // Catch:{ all -> 0x007a }
            int r9 = r8.length     // Catch:{ all -> 0x007a }
            r10 = r5
        L_0x0065:
            if (r10 >= r9) goto L_0x0086
            r11 = r8[r10]     // Catch:{ all -> 0x007a }
            r11.prepare((java.lang.String) r12)     // Catch:{ all -> 0x007a }
            int r11 = r11.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x007a }
            if (r11 != r2) goto L_0x0074
            r1 = r11
            goto L_0x0086
        L_0x0074:
            int r10 = r10 + 1
            goto L_0x0065
        L_0x0077:
            int r8 = r8 + 1
            goto L_0x003a
        L_0x007a:
            r13 = move-exception
            r5 = r1
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock     // Catch:{ all -> 0x010d }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch:{ all -> 0x010d }
            r1.unlock()     // Catch:{ all -> 0x010d }
            throw r13     // Catch:{ all -> 0x010d }
        L_0x0086:
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock     // Catch:{ all -> 0x010a }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r13.readLock()     // Catch:{ all -> 0x010a }
            r2.unlock()     // Catch:{ all -> 0x010a }
            boolean r2 = SYSTRACE_LIBRARY_LOADING
            if (r2 == 0) goto L_0x0096
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x0096:
            if (r6 == 0) goto L_0x009b
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x009b:
            if (r1 == 0) goto L_0x009f
            if (r1 != r7) goto L_0x011f
        L_0x009f:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r3)
            r14.append(r12)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r13.readLock()
            r12.lock()
        L_0x00b1:
            com.facebook.soloader.SoSource[] r12 = sSoSources
            int r12 = r12.length
            if (r5 >= r12) goto L_0x00d1
            java.lang.String r12 = "\n\tSoSource "
            r14.append(r12)
            r14.append(r5)
            java.lang.String r12 = ": "
            r14.append(r12)
            com.facebook.soloader.SoSource[] r12 = sSoSources
            r12 = r12[r5]
            java.lang.String r12 = r12.toString()
            r14.append(r12)
            int r5 = r5 + 1
            goto L_0x00b1
        L_0x00d1:
            com.facebook.soloader.ApplicationSoSource r12 = sApplicationSoSource
            if (r12 == 0) goto L_0x00ee
            android.content.Context r12 = r12.getUpdatedContext()
            java.io.File r12 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r12)
            java.lang.String r13 = "\n\tNative lib dir: "
            r14.append(r13)
            java.lang.String r12 = r12.getAbsolutePath()
            r14.append(r12)
            java.lang.String r12 = "\n"
            r14.append(r12)
        L_0x00ee:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.unlock()
            r14.append(r0)
            r14.append(r1)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r4, r12)
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError
            r13.<init>(r12)
            throw r13
        L_0x010a:
            r13 = move-exception
            r5 = r1
            goto L_0x010e
        L_0x010d:
            r13 = move-exception
        L_0x010e:
            boolean r1 = SYSTRACE_LIBRARY_LOADING
            if (r1 == 0) goto L_0x0115
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x0115:
            if (r6 == 0) goto L_0x011a
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x011a:
            if (r5 == 0) goto L_0x0120
            if (r5 != r7) goto L_0x011f
            goto L_0x0120
        L_0x011f:
            return
        L_0x0120:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r3)
            r14.append(r12)
            java.lang.String r12 = r13.getMessage()
            if (r12 != 0) goto L_0x0135
            java.lang.String r12 = r13.toString()
        L_0x0135:
            java.lang.String r1 = " caused by: "
            r14.append(r1)
            r14.append(r12)
            r13.printStackTrace()
            r14.append(r0)
            r14.append(r5)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r4, r12)
            java.lang.UnsatisfiedLinkError r14 = new java.lang.UnsatisfiedLinkError
            r14.<init>(r12)
            r14.initCause(r13)
            throw r14
        L_0x0156:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
            r13.<init>()     // Catch:{ all -> 0x0184 }
            java.lang.String r14 = "Could not load: "
            r13.append(r14)     // Catch:{ all -> 0x0184 }
            r13.append(r12)     // Catch:{ all -> 0x0184 }
            java.lang.String r14 = " because no SO source exists"
            r13.append(r14)     // Catch:{ all -> 0x0184 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0184 }
            android.util.Log.e(r4, r13)     // Catch:{ all -> 0x0184 }
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0184 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0184 }
            r14.<init>()     // Catch:{ all -> 0x0184 }
            r14.append(r3)     // Catch:{ all -> 0x0184 }
            r14.append(r12)     // Catch:{ all -> 0x0184 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x0184 }
            r13.<init>(r12)     // Catch:{ all -> 0x0184 }
            throw r13     // Catch:{ all -> 0x0184 }
        L_0x0184:
            r12 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r13.readLock()
            r13.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            boolean z = sSoSources != null;
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion;
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            Log.d(TAG, "Prepending to SO sources: " + soSource);
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = sSoSources;
            SoSource[] soSourceArr2 = new SoSource[(soSourceArr.length + 1)];
            soSourceArr2[0] = soSource;
            System.arraycopy(soSourceArr, 0, soSourceArr2, 1, soSourceArr.length);
            sSoSources = soSourceArr2;
            sSoSourcesVersion++;
            Log.d(TAG, "Prepended to SO sources: " + soSource);
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            Log.d(TAG, "makeLdLibraryPath");
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource addToLdLibraryPath : soSourceArr) {
                    addToLdLibraryPath.addToLdLibraryPath(arrayList);
                }
            }
            String join = TextUtils.join(":", arrayList);
            Log.d(TAG, "makeLdLibraryPath final path: " + join);
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int length = soSourceAbis2.length;
                    int i = 0;
                    while (i < length) {
                        String str = soSourceAbis2[i];
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = str.equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            Log.e(TAG, "abi not supported: " + str);
                            reentrantReadWriteLock = sSoSourcesLock;
                        } else {
                            i++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    private static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
        }
    }
}
