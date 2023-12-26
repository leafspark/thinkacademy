package com.kwai.koom.base;

import android.app.ActivityManager;
import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0018\u001a\u00020\u0010\u001a\u0006\u0010\u0019\u001a\u00020\u0013\u001a\u0006\u0010\u001a\u001a\u00020\n\u001a\u0006\u0010\u001b\u001a\u00020\f\u001a\u0006\u0010\u001c\u001a\u00020\u000e\u001a\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0006\u0010 \u001a\u00020\u0016\u001a\u0014\u0010!\u001a\u00020\u0016*\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000\"\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000\"\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000\"\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011\"\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014\"\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006$"}, d2 = {"MEM_AVA_REGEX", "Lkotlin/text/Regex;", "MEM_CMA_REGEX", "MEM_FREE_REGEX", "MEM_ION_REGEX", "MEM_TOTAL_REGEX", "RSS_REGEX", "THREADS_REGEX", "VSS_REGEX", "lastJavaHeap", "Lcom/kwai/koom/base/JavaHeap;", "lastMemInfo", "Lcom/kwai/koom/base/MemInfo;", "lastProcessStatus", "Lcom/kwai/koom/base/ProcessStatus;", "mCpuCoreCount", "", "Ljava/lang/Integer;", "mCpuMaxFreq", "", "Ljava/lang/Double;", "mRamTotalSize", "", "Ljava/lang/Long;", "getCpuCoreCount", "getCpuMaxFreq", "getJavaHeap", "getMemoryInfo", "getProcessStatus", "getRamAvailableSize", "context", "Landroid/content/Context;", "getRamTotalSize", "matchValue", "s", "", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_System.kt */
public final class Monitor_SystemKt {
    private static final Regex MEM_AVA_REGEX = new Regex("MemAvailable:\\s*(\\d+)\\s*kB");
    private static final Regex MEM_CMA_REGEX = new Regex("CmaTotal:\\s*(\\d+)\\s*kB");
    private static final Regex MEM_FREE_REGEX = new Regex("MemFree:\\s*(\\d+)\\s*kB");
    private static final Regex MEM_ION_REGEX = new Regex("ION_heap:\\s*(\\d+)\\s*kB");
    private static final Regex MEM_TOTAL_REGEX = new Regex("MemTotal:\\s*(\\d+)\\s*kB");
    private static final Regex RSS_REGEX = new Regex("VmRSS:\\s*(\\d+)\\s*kB");
    private static final Regex THREADS_REGEX = new Regex("Threads:\\s*(\\d+)\\s*");
    private static final Regex VSS_REGEX = new Regex("VmSize:\\s*(\\d+)\\s*kB");
    public static JavaHeap lastJavaHeap = new JavaHeap(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
    public static MemInfo lastMemInfo = new MemInfo(0, 0, 0, 0, 0, 0.0f, 63, (DefaultConstructorMarker) null);
    public static ProcessStatus lastProcessStatus = new ProcessStatus();
    private static Integer mCpuCoreCount;
    private static Double mCpuMaxFreq;
    private static Long mRamTotalSize;

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a1, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long getRamTotalSize() {
        /*
            java.lang.Long r0 = mRamTotalSize
            if (r0 == 0) goto L_0x000a
            long r0 = r0.longValue()
            goto L_0x009d
        L_0x000a:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            r2 = 8192(0x2000, float:1.14794E-41)
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r0)
            java.io.InputStream r3 = (java.io.InputStream) r3
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r3, r1)
            java.io.Reader r0 = (java.io.Reader) r0
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x002a
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x0030
        L_0x002a:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r1.<init>(r0, r2)
            r0 = r1
        L_0x0030:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r3 = r0
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x009e }
            kotlin.sequences.Sequence r3 = kotlin.io.TextStreamsKt.lineSequence(r3)     // Catch:{ all -> 0x009e }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x009e }
        L_0x0041:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x0091
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x009e }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x009e }
            java.lang.String r6 = "MemTotal"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x009e }
            r7 = 2
            r8 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r6, r8, r7, r1)     // Catch:{ all -> 0x009e }
            if (r5 == 0) goto L_0x0041
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x009e }
            java.lang.String r1 = "\\s+"
            kotlin.text.Regex r3 = new kotlin.text.Regex     // Catch:{ all -> 0x009e }
            r3.<init>(r1)     // Catch:{ all -> 0x009e }
            java.util.List r1 = r3.split(r4, r8)     // Catch:{ all -> 0x009e }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x009e }
            java.lang.String[] r3 = new java.lang.String[r8]     // Catch:{ all -> 0x009e }
            java.lang.Object[] r1 = r1.toArray(r3)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0089
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x009e }
            r3 = 1
            int r4 = kotlin.collections.ArraysKt.getLastIndex(r1)     // Catch:{ all -> 0x009e }
            if (r3 > r4) goto L_0x007f
            r1 = r1[r3]     // Catch:{ all -> 0x009e }
            goto L_0x0081
        L_0x007f:
            java.lang.String r1 = "0"
        L_0x0081:
            long r3 = java.lang.Long.parseLong(r1)     // Catch:{ all -> 0x009e }
            r1 = 10
            long r3 = r3 << r1
            goto L_0x0093
        L_0x0089:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
            r1.<init>(r2)     // Catch:{ all -> 0x009e }
            throw r1     // Catch:{ all -> 0x009e }
        L_0x0091:
            r3 = 0
        L_0x0093:
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            mRamTotalSize = r0
            r0 = r3
        L_0x009d:
            return r0
        L_0x009e:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_SystemKt.getRamTotalSize():long");
    }

    public static final long getRamAvailableSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static final int getCpuCoreCount() {
        Integer num;
        Integer num2 = mCpuCoreCount;
        if (num2 != null) {
            return num2.intValue();
        }
        try {
            Result.Companion companion = Result.Companion;
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(Monitor_SystemKt$getCpuCoreCount$1$1.INSTANCE);
            num = Result.constructor-impl(Integer.valueOf(listFiles != null ? listFiles.length : 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(Runtime.getRuntime().availableProcessors());
        if (Result.isFailure-impl(num)) {
            num = valueOf;
        }
        Number number = (Number) num;
        mCpuCoreCount = Integer.valueOf(number.intValue());
        return number.intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final double getCpuMaxFreq() {
        /*
            java.lang.Double r0 = mCpuMaxFreq
            if (r0 == 0) goto L_0x0009
            double r0 = r0.doubleValue()
            goto L_0x0069
        L_0x0009:
            r0 = 0
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0043 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            r2.<init>(r3)     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = com.kwai.koom.base.Monitor_FileKt.readFirstLine(r2)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0035
            if (r2 == 0) goto L_0x002d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0043 }
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim(r2)     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0035
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x0036
        L_0x002d:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.CharSequence"
            r2.<init>(r3)     // Catch:{ all -> 0x0043 }
            throw r2     // Catch:{ all -> 0x0043 }
        L_0x0035:
            r2 = r0
        L_0x0036:
            r4 = 1000(0x3e8, float:1.401E-42)
            double r4 = (double) r4     // Catch:{ all -> 0x0043 }
            double r2 = r2 / r4
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0043 }
            java.lang.Object r2 = kotlin.Result.constructor-impl(r2)     // Catch:{ all -> 0x0043 }
            goto L_0x004e
        L_0x0043:
            r2 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
            java.lang.Object r2 = kotlin.Result.constructor-impl(r2)
        L_0x004e:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            boolean r1 = kotlin.Result.isFailure-impl(r2)
            if (r1 == 0) goto L_0x0059
            r2 = r0
        L_0x0059:
            java.lang.Number r2 = (java.lang.Number) r2
            double r0 = r2.doubleValue()
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            mCpuMaxFreq = r0
            double r0 = r2.doubleValue()
        L_0x0069:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_SystemKt.getCpuMaxFreq():double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00aa, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.kwai.koom.base.ProcessStatus getProcessStatus() {
        /*
            com.kwai.koom.base.ProcessStatus r0 = new com.kwai.koom.base.ProcessStatus
            r0.<init>()
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00ab }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = "/proc/self/status"
            r1.<init>(r2)     // Catch:{ all -> 0x00ab }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x00ab }
            r3 = 8192(0x2000, float:1.14794E-41)
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x00ab }
            r4.<init>(r1)     // Catch:{ all -> 0x00ab }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x00ab }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ab }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x00ab }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ all -> 0x00ab }
            boolean r2 = r1 instanceof java.io.BufferedReader     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x0027
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x00ab }
            goto L_0x002d
        L_0x0027:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00ab }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x00ab }
            r1 = r2
        L_0x002d:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x00ab }
            r2 = 0
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x00ab }
            r4 = r1
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x00a4 }
            kotlin.sequences.Sequence r4 = kotlin.io.TextStreamsKt.lineSequence(r4)     // Catch:{ all -> 0x00a4 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00a4 }
        L_0x003e:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x0099
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00a4 }
            long r6 = r0.vssKbSize     // Catch:{ all -> 0x00a4 }
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0064
            long r6 = r0.rssKbSize     // Catch:{ all -> 0x00a4 }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0064
            long r6 = r0.threadsCount     // Catch:{ all -> 0x00a4 }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0064
            lastProcessStatus = r0     // Catch:{ all -> 0x00a4 }
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x00ab }
            return r0
        L_0x0064:
            java.lang.String r6 = "VmSize"
            r7 = 2
            r8 = 0
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r5, r6, r8, r7, r2)     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x0077
            kotlin.text.Regex r6 = VSS_REGEX     // Catch:{ all -> 0x00a4 }
            long r5 = matchValue(r6, r5)     // Catch:{ all -> 0x00a4 }
            r0.vssKbSize = r5     // Catch:{ all -> 0x00a4 }
            goto L_0x003e
        L_0x0077:
            java.lang.String r6 = "VmRSS"
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r5, r6, r8, r7, r2)     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x0088
            kotlin.text.Regex r6 = RSS_REGEX     // Catch:{ all -> 0x00a4 }
            long r5 = matchValue(r6, r5)     // Catch:{ all -> 0x00a4 }
            r0.rssKbSize = r5     // Catch:{ all -> 0x00a4 }
            goto L_0x003e
        L_0x0088:
            java.lang.String r6 = "Threads"
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r5, r6, r8, r7, r2)     // Catch:{ all -> 0x00a4 }
            if (r6 == 0) goto L_0x003e
            kotlin.text.Regex r6 = THREADS_REGEX     // Catch:{ all -> 0x00a4 }
            long r5 = matchValue(r6, r5)     // Catch:{ all -> 0x00a4 }
            r0.threadsCount = r5     // Catch:{ all -> 0x00a4 }
            goto L_0x003e
        L_0x0099:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a4 }
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x00ab }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ab }
            kotlin.Result.constructor-impl(r1)     // Catch:{ all -> 0x00ab }
            goto L_0x00b5
        L_0x00a4:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ all -> 0x00ab }
            throw r3     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            kotlin.Result.constructor-impl(r1)
        L_0x00b5:
            lastProcessStatus = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_SystemKt.getProcessStatus():com.kwai.koom.base.ProcessStatus");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c4, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c5, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c8, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.kwai.koom.base.MemInfo getMemoryInfo() {
        /*
            com.kwai.koom.base.MemInfo r14 = new com.kwai.koom.base.MemInfo
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 63
            r13 = 0
            r0 = r14
            r0.<init>(r1, r3, r5, r7, r9, r11, r12, r13)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r0)
            java.io.InputStream r2 = (java.io.InputStream) r2
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r1)
            java.io.Reader r0 = (java.io.Reader) r0
            boolean r1 = r0 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0032
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x003a
        L_0x0032:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r0, r2)
            r0 = r1
        L_0x003a:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r3 = r0
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x00c2 }
            kotlin.sequences.Sequence r3 = kotlin.io.TextStreamsKt.lineSequence(r3)     // Catch:{ all -> 0x00c2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00c2 }
        L_0x004b:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r4 == 0) goto L_0x00ae
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = "MemTotal"
            r6 = 2
            r7 = 0
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r4, r5, r7, r6, r1)     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x006a
            kotlin.text.Regex r5 = MEM_TOTAL_REGEX     // Catch:{ all -> 0x00c2 }
            long r4 = matchValue(r5, r4)     // Catch:{ all -> 0x00c2 }
            r14.totalInKb = r4     // Catch:{ all -> 0x00c2 }
            goto L_0x004b
        L_0x006a:
            java.lang.String r5 = "MemFree"
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r4, r5, r7, r6, r1)     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x007b
            kotlin.text.Regex r5 = MEM_FREE_REGEX     // Catch:{ all -> 0x00c2 }
            long r4 = matchValue(r5, r4)     // Catch:{ all -> 0x00c2 }
            r14.freeInKb = r4     // Catch:{ all -> 0x00c2 }
            goto L_0x004b
        L_0x007b:
            java.lang.String r5 = "MemAvailable"
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r4, r5, r7, r6, r1)     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x008c
            kotlin.text.Regex r5 = MEM_AVA_REGEX     // Catch:{ all -> 0x00c2 }
            long r4 = matchValue(r5, r4)     // Catch:{ all -> 0x00c2 }
            r14.availableInKb = r4     // Catch:{ all -> 0x00c2 }
            goto L_0x004b
        L_0x008c:
            java.lang.String r5 = "CmaTotal"
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r4, r5, r7, r6, r1)     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x009d
            kotlin.text.Regex r5 = MEM_CMA_REGEX     // Catch:{ all -> 0x00c2 }
            long r4 = matchValue(r5, r4)     // Catch:{ all -> 0x00c2 }
            r14.cmaTotal = r4     // Catch:{ all -> 0x00c2 }
            goto L_0x004b
        L_0x009d:
            java.lang.String r5 = "ION_heap"
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r4, r5, r7, r6, r1)     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x004b
            kotlin.text.Regex r5 = MEM_ION_REGEX     // Catch:{ all -> 0x00c2 }
            long r4 = matchValue(r5, r4)     // Catch:{ all -> 0x00c2 }
            r14.IONHeap = r4     // Catch:{ all -> 0x00c2 }
            goto L_0x004b
        L_0x00ae:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c2 }
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            r0 = 1065353216(0x3f800000, float:1.0)
            long r1 = r14.availableInKb
            float r1 = (float) r1
            float r1 = r1 * r0
            long r2 = r14.totalInKb
            float r0 = (float) r2
            float r1 = r1 / r0
            r14.rate = r1
            lastMemInfo = r14
            return r14
        L_0x00c2:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00c4 }
        L_0x00c4:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_SystemKt.getMemoryInfo():com.kwai.koom.base.MemInfo");
    }

    public static final JavaHeap getJavaHeap() {
        JavaHeap javaHeap = new JavaHeap(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
        javaHeap.max = Runtime.getRuntime().maxMemory();
        javaHeap.total = Runtime.getRuntime().totalMemory();
        javaHeap.free = Runtime.getRuntime().freeMemory();
        javaHeap.used = javaHeap.total - javaHeap.free;
        javaHeap.rate = (((float) javaHeap.used) * 1.0f) / ((float) javaHeap.max);
        lastJavaHeap = javaHeap;
        return javaHeap;
    }

    private static final long matchValue(Regex regex, String str) {
        List groupValues;
        String str2;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        MatchResult matchEntire = regex.matchEntire(StringsKt.trim(str).toString());
        if (matchEntire == null || (groupValues = matchEntire.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
            return 0;
        }
        return Long.parseLong(str2);
    }
}
