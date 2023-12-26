package com.kwai.koom.javaoom.monitor.tracker.model;

import android.os.Build;
import android.text.TextUtils;
import com.kwai.koom.base.MonitorLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003ABCB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b04¢\u0006\u0002\u00105J9\u00106\u001a\u000202*\u0002072\b\b\u0002\u00108\u001a\u0002092!\u0010:\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002020;H\u0002J\u0014\u0010?\u001a\u00020\u000f*\u00020\u00042\u0006\u0010@\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001a\u0010,\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(¨\u0006D"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo;", "", "()V", "MEM_AVA_REGEX", "Lkotlin/text/Regex;", "MEM_CMA_REGEX", "MEM_FREE_REGEX", "MEM_ION_REGEX", "MEM_TOTAL_REGEX", "RSS_REGEX", "TAG", "", "THREADS_REGEX", "VSS_REGEX", "fdCount", "", "getFdCount", "()I", "setFdCount", "(I)V", "javaHeap", "Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$JavaHeap;", "getJavaHeap", "()Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$JavaHeap;", "setJavaHeap", "(Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$JavaHeap;)V", "lastJavaHeap", "getLastJavaHeap", "setLastJavaHeap", "lastMemInfo", "Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$MemInfo;", "getLastMemInfo", "()Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$MemInfo;", "setLastMemInfo", "(Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$MemInfo;)V", "lastProcStatus", "Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$ProcStatus;", "getLastProcStatus", "()Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$ProcStatus;", "setLastProcStatus", "(Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$ProcStatus;)V", "memInfo", "getMemInfo", "setMemInfo", "procStatus", "getProcStatus", "setProcStatus", "isSupportArm64", "", "refresh", "", "supportedAbis", "", "()[Ljava/lang/String;", "forEachLineQuietly", "Ljava/io/File;", "charset", "Ljava/nio/charset/Charset;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "matchValue", "s", "JavaHeap", "MemInfo", "ProcStatus", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SystemInfo.kt */
public final class SystemInfo {
    public static final SystemInfo INSTANCE = new SystemInfo();
    /* access modifiers changed from: private */
    public static final Regex MEM_AVA_REGEX = new Regex("MemAvailable:\\s*(\\d+)\\s*kB");
    /* access modifiers changed from: private */
    public static final Regex MEM_CMA_REGEX = new Regex("CmaTotal:\\s*(\\d+)\\s*kB");
    /* access modifiers changed from: private */
    public static final Regex MEM_FREE_REGEX = new Regex("MemFree:\\s*(\\d+)\\s*kB");
    /* access modifiers changed from: private */
    public static final Regex MEM_ION_REGEX = new Regex("ION_heap:\\s*(\\d+)\\s*kB");
    /* access modifiers changed from: private */
    public static final Regex MEM_TOTAL_REGEX = new Regex("MemTotal:\\s*(\\d+)\\s*kB");
    /* access modifiers changed from: private */
    public static final Regex RSS_REGEX = new Regex("VmRSS:\\s*(\\d+)\\s*kB");
    private static final String TAG = "OOMMonitor_SystemInfo";
    /* access modifiers changed from: private */
    public static final Regex THREADS_REGEX = new Regex("Threads:\\s*(\\d+)\\s*");
    /* access modifiers changed from: private */
    public static final Regex VSS_REGEX = new Regex("VmSize:\\s*(\\d+)\\s*kB");
    private static int fdCount;
    private static JavaHeap javaHeap = new JavaHeap(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
    private static JavaHeap lastJavaHeap = new JavaHeap(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
    private static MemInfo lastMemInfo = new MemInfo(0, 0, 0, 0, 0, 0.0f, 63, (DefaultConstructorMarker) null);
    private static ProcStatus lastProcStatus = new ProcStatus(0, 0, 0, 7, (DefaultConstructorMarker) null);
    private static MemInfo memInfo = new MemInfo(0, 0, 0, 0, 0, 0.0f, 63, (DefaultConstructorMarker) null);
    private static ProcStatus procStatus = new ProcStatus(0, 0, 0, 7, (DefaultConstructorMarker) null);

    private SystemInfo() {
    }

    public final ProcStatus getProcStatus() {
        return procStatus;
    }

    public final void setProcStatus(ProcStatus procStatus2) {
        Intrinsics.checkNotNullParameter(procStatus2, "<set-?>");
        procStatus = procStatus2;
    }

    public final ProcStatus getLastProcStatus() {
        return lastProcStatus;
    }

    public final void setLastProcStatus(ProcStatus procStatus2) {
        Intrinsics.checkNotNullParameter(procStatus2, "<set-?>");
        lastProcStatus = procStatus2;
    }

    public final MemInfo getMemInfo() {
        return memInfo;
    }

    public final void setMemInfo(MemInfo memInfo2) {
        Intrinsics.checkNotNullParameter(memInfo2, "<set-?>");
        memInfo = memInfo2;
    }

    public final MemInfo getLastMemInfo() {
        return lastMemInfo;
    }

    public final void setLastMemInfo(MemInfo memInfo2) {
        Intrinsics.checkNotNullParameter(memInfo2, "<set-?>");
        lastMemInfo = memInfo2;
    }

    public final JavaHeap getJavaHeap() {
        return javaHeap;
    }

    public final void setJavaHeap(JavaHeap javaHeap2) {
        Intrinsics.checkNotNullParameter(javaHeap2, "<set-?>");
        javaHeap = javaHeap2;
    }

    public final JavaHeap getLastJavaHeap() {
        return lastJavaHeap;
    }

    public final void setLastJavaHeap(JavaHeap javaHeap2) {
        Intrinsics.checkNotNullParameter(javaHeap2, "<set-?>");
        lastJavaHeap = javaHeap2;
    }

    public final int getFdCount() {
        return fdCount;
    }

    public final void setFdCount(int i) {
        fdCount = i;
    }

    public final void refresh() {
        lastJavaHeap = javaHeap;
        lastMemInfo = memInfo;
        lastProcStatus = procStatus;
        javaHeap = new JavaHeap(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
        procStatus = new ProcStatus(0, 0, 0, 7, (DefaultConstructorMarker) null);
        memInfo = new MemInfo(0, 0, 0, 0, 0, 0.0f, 63, (DefaultConstructorMarker) null);
        javaHeap.setMax(Runtime.getRuntime().maxMemory());
        javaHeap.setTotal(Runtime.getRuntime().totalMemory());
        javaHeap.setFree(Runtime.getRuntime().freeMemory());
        JavaHeap javaHeap2 = javaHeap;
        javaHeap2.setUsed(javaHeap2.getTotal() - javaHeap.getFree());
        JavaHeap javaHeap3 = javaHeap;
        javaHeap3.setRate((((float) javaHeap3.getUsed()) * 1.0f) / ((float) javaHeap.getMax()));
        forEachLineQuietly$default(this, new File("/proc/self/status"), (Charset) null, SystemInfo$refresh$1.INSTANCE, 1, (Object) null);
        forEachLineQuietly$default(this, new File("/proc/meminfo"), (Charset) null, SystemInfo$refresh$2.INSTANCE, 1, (Object) null);
        MemInfo memInfo2 = memInfo;
        memInfo2.setRate((((float) memInfo2.getAvailableInKb()) * 1.0f) / ((float) memInfo.getTotalInKb()));
        MonitorLog.i(TAG, "----OOM Monitor Memory----");
        StringBuilder sb = new StringBuilder();
        sb.append("[java] max:");
        sb.append(javaHeap.getMax());
        sb.append(" used ratio:");
        float f = (float) 100;
        sb.append((int) (javaHeap.getRate() * f));
        sb.append('%');
        MonitorLog.i(TAG, sb.toString());
        MonitorLog.i(TAG, "[proc] VmSize:" + procStatus.getVssInKb() + "kB VmRss:" + procStatus.getRssInKb() + "kB Threads:" + procStatus.getThread());
        MonitorLog.i(TAG, "[meminfo] MemTotal:" + memInfo.getTotalInKb() + "kB MemFree:" + memInfo.getFreeInKb() + "kB MemAvailable:" + memInfo.getAvailableInKb() + "kB");
        MonitorLog.i(TAG, "avaliable ratio:" + ((int) (memInfo.getRate() * f)) + "% CmaTotal:" + memInfo.getCmaTotal() + "kB ION_heap:" + memInfo.getIONHeap() + "kB");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$ProcStatus;", "", "thread", "", "vssInKb", "rssInKb", "(III)V", "getRssInKb", "()I", "setRssInKb", "(I)V", "getThread", "setThread", "getVssInKb", "setVssInKb", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SystemInfo.kt */
    public static final class ProcStatus {
        private int rssInKb;
        private int thread;
        private int vssInKb;

        public ProcStatus() {
            this(0, 0, 0, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ProcStatus copy$default(ProcStatus procStatus, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = procStatus.thread;
            }
            if ((i4 & 2) != 0) {
                i2 = procStatus.vssInKb;
            }
            if ((i4 & 4) != 0) {
                i3 = procStatus.rssInKb;
            }
            return procStatus.copy(i, i2, i3);
        }

        public final int component1() {
            return this.thread;
        }

        public final int component2() {
            return this.vssInKb;
        }

        public final int component3() {
            return this.rssInKb;
        }

        public final ProcStatus copy(int i, int i2, int i3) {
            return new ProcStatus(i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProcStatus)) {
                return false;
            }
            ProcStatus procStatus = (ProcStatus) obj;
            return this.thread == procStatus.thread && this.vssInKb == procStatus.vssInKb && this.rssInKb == procStatus.rssInKb;
        }

        public int hashCode() {
            return (((this.thread * 31) + this.vssInKb) * 31) + this.rssInKb;
        }

        public String toString() {
            return "ProcStatus(thread=" + this.thread + ", vssInKb=" + this.vssInKb + ", rssInKb=" + this.rssInKb + ')';
        }

        public ProcStatus(int i, int i2, int i3) {
            this.thread = i;
            this.vssInKb = i2;
            this.rssInKb = i3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ProcStatus(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
        }

        public final int getRssInKb() {
            return this.rssInKb;
        }

        public final int getThread() {
            return this.thread;
        }

        public final int getVssInKb() {
            return this.vssInKb;
        }

        public final void setRssInKb(int i) {
            this.rssInKb = i;
        }

        public final void setThread(int i) {
            this.thread = i;
        }

        public final void setVssInKb(int i) {
            this.vssInKb = i;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$MemInfo;", "", "totalInKb", "", "freeInKb", "availableInKb", "IONHeap", "cmaTotal", "rate", "", "(IIIIIF)V", "getIONHeap", "()I", "setIONHeap", "(I)V", "getAvailableInKb", "setAvailableInKb", "getCmaTotal", "setCmaTotal", "getFreeInKb", "setFreeInKb", "getRate", "()F", "setRate", "(F)V", "getTotalInKb", "setTotalInKb", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SystemInfo.kt */
    public static final class MemInfo {
        private int IONHeap;
        private int availableInKb;
        private int cmaTotal;
        private int freeInKb;
        private float rate;
        private int totalInKb;

        public MemInfo() {
            this(0, 0, 0, 0, 0, 0.0f, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ MemInfo copy$default(MemInfo memInfo, int i, int i2, int i3, int i4, int i5, float f, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = memInfo.totalInKb;
            }
            if ((i6 & 2) != 0) {
                i2 = memInfo.freeInKb;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = memInfo.availableInKb;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = memInfo.IONHeap;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = memInfo.cmaTotal;
            }
            int i10 = i5;
            if ((i6 & 32) != 0) {
                f = memInfo.rate;
            }
            return memInfo.copy(i, i7, i8, i9, i10, f);
        }

        public final int component1() {
            return this.totalInKb;
        }

        public final int component2() {
            return this.freeInKb;
        }

        public final int component3() {
            return this.availableInKb;
        }

        public final int component4() {
            return this.IONHeap;
        }

        public final int component5() {
            return this.cmaTotal;
        }

        public final float component6() {
            return this.rate;
        }

        public final MemInfo copy(int i, int i2, int i3, int i4, int i5, float f) {
            return new MemInfo(i, i2, i3, i4, i5, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MemInfo)) {
                return false;
            }
            MemInfo memInfo = (MemInfo) obj;
            return this.totalInKb == memInfo.totalInKb && this.freeInKb == memInfo.freeInKb && this.availableInKb == memInfo.availableInKb && this.IONHeap == memInfo.IONHeap && this.cmaTotal == memInfo.cmaTotal && Intrinsics.areEqual(Float.valueOf(this.rate), Float.valueOf(memInfo.rate));
        }

        public int hashCode() {
            return (((((((((this.totalInKb * 31) + this.freeInKb) * 31) + this.availableInKb) * 31) + this.IONHeap) * 31) + this.cmaTotal) * 31) + Float.floatToIntBits(this.rate);
        }

        public String toString() {
            return "MemInfo(totalInKb=" + this.totalInKb + ", freeInKb=" + this.freeInKb + ", availableInKb=" + this.availableInKb + ", IONHeap=" + this.IONHeap + ", cmaTotal=" + this.cmaTotal + ", rate=" + this.rate + ')';
        }

        public MemInfo(int i, int i2, int i3, int i4, int i5, float f) {
            this.totalInKb = i;
            this.freeInKb = i2;
            this.availableInKb = i3;
            this.IONHeap = i4;
            this.cmaTotal = i5;
            this.rate = f;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ MemInfo(int r5, int r6, int r7, int r8, int r9, float r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
            /*
                r4 = this;
                r12 = r11 & 1
                r0 = 0
                if (r12 == 0) goto L_0x0007
                r12 = r0
                goto L_0x0008
            L_0x0007:
                r12 = r5
            L_0x0008:
                r5 = r11 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r11 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r11 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r11 & 16
                if (r5 == 0) goto L_0x0022
                goto L_0x0023
            L_0x0022:
                r0 = r9
            L_0x0023:
                r5 = r11 & 32
                if (r5 == 0) goto L_0x0028
                r10 = 0
            L_0x0028:
                r11 = r10
                r5 = r4
                r6 = r12
                r7 = r1
                r8 = r2
                r9 = r3
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo.MemInfo.<init>(int, int, int, int, int, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final int getAvailableInKb() {
            return this.availableInKb;
        }

        public final int getFreeInKb() {
            return this.freeInKb;
        }

        public final int getTotalInKb() {
            return this.totalInKb;
        }

        public final void setAvailableInKb(int i) {
            this.availableInKb = i;
        }

        public final void setFreeInKb(int i) {
            this.freeInKb = i;
        }

        public final void setTotalInKb(int i) {
            this.totalInKb = i;
        }

        public final int getCmaTotal() {
            return this.cmaTotal;
        }

        public final int getIONHeap() {
            return this.IONHeap;
        }

        public final float getRate() {
            return this.rate;
        }

        public final void setCmaTotal(int i) {
            this.cmaTotal = i;
        }

        public final void setIONHeap(int i) {
            this.IONHeap = i;
        }

        public final void setRate(float f) {
            this.rate = f;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/tracker/model/SystemInfo$JavaHeap;", "", "max", "", "total", "free", "used", "rate", "", "(JJJJF)V", "getFree", "()J", "setFree", "(J)V", "getMax", "setMax", "getRate", "()F", "setRate", "(F)V", "getTotal", "setTotal", "getUsed", "setUsed", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SystemInfo.kt */
    public static final class JavaHeap {
        private long free;
        private long max;
        private float rate;
        private long total;
        private long used;

        public JavaHeap() {
            this(0, 0, 0, 0, 0.0f, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ JavaHeap copy$default(JavaHeap javaHeap, long j, long j2, long j3, long j4, float f, int i, Object obj) {
            JavaHeap javaHeap2 = javaHeap;
            return javaHeap.copy((i & 1) != 0 ? javaHeap2.max : j, (i & 2) != 0 ? javaHeap2.total : j2, (i & 4) != 0 ? javaHeap2.free : j3, (i & 8) != 0 ? javaHeap2.used : j4, (i & 16) != 0 ? javaHeap2.rate : f);
        }

        public final long component1() {
            return this.max;
        }

        public final long component2() {
            return this.total;
        }

        public final long component3() {
            return this.free;
        }

        public final long component4() {
            return this.used;
        }

        public final float component5() {
            return this.rate;
        }

        public final JavaHeap copy(long j, long j2, long j3, long j4, float f) {
            return new JavaHeap(j, j2, j3, j4, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JavaHeap)) {
                return false;
            }
            JavaHeap javaHeap = (JavaHeap) obj;
            return this.max == javaHeap.max && this.total == javaHeap.total && this.free == javaHeap.free && this.used == javaHeap.used && Intrinsics.areEqual(Float.valueOf(this.rate), Float.valueOf(javaHeap.rate));
        }

        public int hashCode() {
            return (((((((SystemInfo$JavaHeap$$ExternalSyntheticBackport0.m(this.max) * 31) + SystemInfo$JavaHeap$$ExternalSyntheticBackport0.m(this.total)) * 31) + SystemInfo$JavaHeap$$ExternalSyntheticBackport0.m(this.free)) * 31) + SystemInfo$JavaHeap$$ExternalSyntheticBackport0.m(this.used)) * 31) + Float.floatToIntBits(this.rate);
        }

        public String toString() {
            return "JavaHeap(max=" + this.max + ", total=" + this.total + ", free=" + this.free + ", used=" + this.used + ", rate=" + this.rate + ')';
        }

        public JavaHeap(long j, long j2, long j3, long j4, float f) {
            this.max = j;
            this.total = j2;
            this.free = j3;
            this.used = j4;
            this.rate = f;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ JavaHeap(long r10, long r12, long r14, long r16, float r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
            /*
                r9 = this;
                r0 = r19 & 1
                r1 = 0
                if (r0 == 0) goto L_0x0008
                r3 = r1
                goto L_0x0009
            L_0x0008:
                r3 = r10
            L_0x0009:
                r0 = r19 & 2
                if (r0 == 0) goto L_0x000f
                r5 = r1
                goto L_0x0010
            L_0x000f:
                r5 = r12
            L_0x0010:
                r0 = r19 & 4
                if (r0 == 0) goto L_0x0016
                r7 = r1
                goto L_0x0017
            L_0x0016:
                r7 = r14
            L_0x0017:
                r0 = r19 & 8
                if (r0 == 0) goto L_0x001c
                goto L_0x001e
            L_0x001c:
                r1 = r16
            L_0x001e:
                r0 = r19 & 16
                if (r0 == 0) goto L_0x0024
                r0 = 0
                goto L_0x0026
            L_0x0024:
                r0 = r18
            L_0x0026:
                r10 = r9
                r11 = r3
                r13 = r5
                r15 = r7
                r17 = r1
                r19 = r0
                r10.<init>(r11, r13, r15, r17, r19)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo.JavaHeap.<init>(long, long, long, long, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final long getFree() {
            return this.free;
        }

        public final long getMax() {
            return this.max;
        }

        public final long getTotal() {
            return this.total;
        }

        public final void setFree(long j) {
            this.free = j;
        }

        public final void setMax(long j) {
            this.max = j;
        }

        public final void setTotal(long j) {
            this.total = j;
        }

        public final float getRate() {
            return this.rate;
        }

        public final long getUsed() {
            return this.used;
        }

        public final void setRate(float f) {
            this.rate = f;
        }

        public final void setUsed(long j) {
            this.used = j;
        }
    }

    /* access modifiers changed from: private */
    public final int matchValue(Regex regex, String str) {
        List groupValues;
        String str2;
        MatchResult matchEntire = regex.matchEntire(StringsKt.trim(str).toString());
        if (matchEntire == null || (groupValues = matchEntire.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    static /* synthetic */ void forEachLineQuietly$default(SystemInfo systemInfo, File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        systemInfo.forEachLineQuietly(file, charset, function1);
    }

    private final void forEachLineQuietly(File file, Charset charset, Function1<? super String, Unit> function1) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable r4 = Result.exceptionOrNull-impl(obj);
        if (r4 != null) {
            r4.printStackTrace();
        }
    }

    public final boolean isSupportArm64() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return ArraysKt.contains(supportedAbis(), "arm64-v8a");
    }

    public final String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
            if (!(((Object[]) strArr).length == 0)) {
                String[] strArr2 = Build.SUPPORTED_ABIS;
                Intrinsics.checkNotNullExpressionValue(strArr2, "{\n      Build.SUPPORTED_ABIS\n    }");
                return strArr2;
            }
        }
        if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }
}
