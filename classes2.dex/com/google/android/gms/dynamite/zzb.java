package com.google.android.gms.dynamite;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzb {
    private static volatile ClassLoader zza;
    private static volatile Thread zzb;

    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            if (zza == null) {
                zza = zzb();
            }
            classLoader = zza;
        }
        return classLoader;
    }

    private static synchronized ClassLoader zzb() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (zzb == null) {
                zzb = zzc();
                if (zzb == null) {
                    return null;
                }
            }
            synchronized (zzb) {
                try {
                    classLoader = zzb.getContextClassLoader();
                } catch (SecurityException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.w("DynamiteLoaderV2CL", valueOf.length() != 0 ? "Failed to get thread context classloader ".concat(valueOf) : new String("Failed to get thread context classloader "));
                }
            }
            return classLoader;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.Thread zzc() {
        /*
            java.lang.Class<com.google.android.gms.dynamite.zzb> r0 = com.google.android.gms.dynamite.zzb.class
            monitor-enter(r0)
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x009f }
            java.lang.Thread r1 = r1.getThread()     // Catch:{ all -> 0x009f }
            java.lang.ThreadGroup r1 = r1.getThreadGroup()     // Catch:{ all -> 0x009f }
            r2 = 0
            if (r1 != 0) goto L_0x0014
            monitor-exit(r0)
            return r2
        L_0x0014:
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            monitor-enter(r3)     // Catch:{ all -> 0x009f }
            int r4 = r1.activeGroupCount()     // Catch:{ SecurityException -> 0x0076 }
            java.lang.ThreadGroup[] r5 = new java.lang.ThreadGroup[r4]     // Catch:{ SecurityException -> 0x0076 }
            r1.enumerate(r5)     // Catch:{ SecurityException -> 0x0076 }
            r6 = 0
            r7 = r6
        L_0x0022:
            if (r7 >= r4) goto L_0x0036
            r8 = r5[r7]     // Catch:{ SecurityException -> 0x0076 }
            java.lang.String r9 = "dynamiteLoader"
            java.lang.String r10 = r8.getName()     // Catch:{ SecurityException -> 0x0076 }
            boolean r9 = r9.equals(r10)     // Catch:{ SecurityException -> 0x0076 }
            if (r9 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            int r7 = r7 + 1
            goto L_0x0022
        L_0x0036:
            r8 = r2
        L_0x0037:
            if (r8 != 0) goto L_0x0040
            java.lang.ThreadGroup r8 = new java.lang.ThreadGroup     // Catch:{ SecurityException -> 0x0076 }
            java.lang.String r4 = "dynamiteLoader"
            r8.<init>(r1, r4)     // Catch:{ SecurityException -> 0x0076 }
        L_0x0040:
            int r1 = r8.activeCount()     // Catch:{ SecurityException -> 0x0076 }
            java.lang.Thread[] r4 = new java.lang.Thread[r1]     // Catch:{ SecurityException -> 0x0076 }
            r8.enumerate(r4)     // Catch:{ SecurityException -> 0x0076 }
        L_0x0049:
            if (r6 >= r1) goto L_0x005d
            r5 = r4[r6]     // Catch:{ SecurityException -> 0x0076 }
            java.lang.String r7 = "GmsDynamite"
            java.lang.String r9 = r5.getName()     // Catch:{ SecurityException -> 0x0076 }
            boolean r7 = r7.equals(r9)     // Catch:{ SecurityException -> 0x0076 }
            if (r7 == 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            int r6 = r6 + 1
            goto L_0x0049
        L_0x005d:
            r5 = r2
        L_0x005e:
            if (r5 != 0) goto L_0x009a
            com.google.android.gms.dynamite.zza r1 = new com.google.android.gms.dynamite.zza     // Catch:{ SecurityException -> 0x0070 }
            java.lang.String r4 = "GmsDynamite"
            r1.<init>(r8, r4)     // Catch:{ SecurityException -> 0x0070 }
            r1.setContextClassLoader(r2)     // Catch:{ SecurityException -> 0x006e }
            r1.start()     // Catch:{ SecurityException -> 0x006e }
            goto L_0x0099
        L_0x006e:
            r2 = move-exception
            goto L_0x007a
        L_0x0070:
            r1 = move-exception
            r2 = r1
            r1 = r5
            goto L_0x007a
        L_0x0074:
            r1 = move-exception
            goto L_0x009d
        L_0x0076:
            r1 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
        L_0x007a:
            java.lang.String r4 = "DynamiteLoaderV2CL"
            java.lang.String r5 = "Failed to enumerate thread/threadgroup "
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0074 }
            int r6 = r2.length()     // Catch:{ all -> 0x0074 }
            if (r6 == 0) goto L_0x0091
            java.lang.String r2 = r5.concat(r2)     // Catch:{ all -> 0x0074 }
            goto L_0x0096
        L_0x0091:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0074 }
            r2.<init>(r5)     // Catch:{ all -> 0x0074 }
        L_0x0096:
            android.util.Log.w(r4, r2)     // Catch:{ all -> 0x0074 }
        L_0x0099:
            r5 = r1
        L_0x009a:
            monitor-exit(r3)     // Catch:{ all -> 0x0074 }
            monitor-exit(r0)
            return r5
        L_0x009d:
            monitor-exit(r3)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ all -> 0x009f }
        L_0x009f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zzb.zzc():java.lang.Thread");
    }
}
