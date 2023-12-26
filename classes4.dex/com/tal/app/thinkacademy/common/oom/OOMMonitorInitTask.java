package com.tal.app.thinkacademy.common.oom;

import android.app.Application;
import com.kwai.koom.base.InitTask;
import com.kwai.koom.base.MonitorManager;
import com.kwai.koom.javaoom.monitor.OOMMonitorConfig;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.track.CommonTrack;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.constant.MemoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/oom/OOMMonitorInitTask;", "Lcom/kwai/koom/base/InitTask;", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "reportCount", "", "init", "", "application", "Landroid/app/Application;", "reportMemInfo", "isHitOomRule", "", "hitReasons", "", "isReportTrack", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorInitTask.kt */
public final class OOMMonitorInitTask implements InitTask {
    public static final OOMMonitorInitTask INSTANCE = new OOMMonitorInitTask();
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.MEM_OOM;
    /* access modifiers changed from: private */
    public static int reportCount = -1;

    private OOMMonitorInitTask() {
    }

    public void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        MonitorManager.addMonitorConfig(new OOMMonitorConfig.Builder().setEnableHprofDumpAnalysis(false).setReportInfo(new OOMMonitorInitTask$init$config$1()).setHprofUploader(new OOMMonitorInitTask$init$config$2()).setReportUploader(new OOMMonitorInitTask$init$config$3()).build());
    }

    static /* synthetic */ void reportMemInfo$default(OOMMonitorInitTask oOMMonitorInitTask, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        oOMMonitorInitTask.reportMemInfo(z, str, z2);
    }

    private final void reportMemInfo(boolean z, String str, boolean z2) {
        float max = (((float) SystemInfo.INSTANCE.getJavaHeap().getMax()) * 1.0f) / ((float) MemoryConstants.MB);
        float f = (float) 100;
        int rate = (int) (SystemInfo.INSTANCE.getJavaHeap().getRate() * f);
        float f2 = (float) 1024;
        float vssInKb = (((float) SystemInfo.INSTANCE.getProcStatus().getVssInKb()) * 1.0f) / f2;
        float rssInKb = (((float) SystemInfo.INSTANCE.getProcStatus().getRssInKb()) * 1.0f) / f2;
        int thread = SystemInfo.INSTANCE.getProcStatus().getThread();
        float totalInKb = (((float) SystemInfo.INSTANCE.getMemInfo().getTotalInKb()) * 1.0f) / f2;
        float freeInKb = (((float) SystemInfo.INSTANCE.getMemInfo().getFreeInKb()) * 1.0f) / f2;
        float availableInKb = (((float) SystemInfo.INSTANCE.getMemInfo().getAvailableInKb()) * 1.0f) / f2;
        int rate2 = (int) (SystemInfo.INSTANCE.getMemInfo().getRate() * f);
        float cmaTotal = (((float) SystemInfo.INSTANCE.getMemInfo().getCmaTotal()) * 1.0f) / f2;
        int fdCount = SystemInfo.INSTANCE.getFdCount();
        Tag tag = TAG;
        StringBuilder sb = new StringBuilder();
        int i = fdCount;
        sb.append("[java] max(Java最大可用堆内存):");
        sb.append(max);
        sb.append("M ，使用率used ratio:");
        sb.append(rate);
        sb.append('%');
        XesLog.i(tag, sb.toString());
        XesLog.i(tag, "[proc/self/status] VmSize(进程虚拟地址空间的大小):" + vssInKb + "M VmRss(应用程序正在使用的物理内存的大小):" + rssInKb + "M Threads:" + thread);
        XesLog.i(tag, "[/proc/meminfo] MemTotal(手机总内存):" + totalInKb + "M MemFree(系统未使用的内存):" + freeInKb + "M MemAvailable(可分配给应用程序的内存):" + availableInKb + 'M');
        XesLog.i(tag, "avaliable ratio(可用内存占有率):" + rate2 + "% CmaTotal:" + cmaTotal + "M ION_heap:" + ((((float) SystemInfo.INSTANCE.getMemInfo().getIONHeap()) * 1.0f) / f2) + 'M');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fdCount(文件句柄数量)= ");
        int i2 = i;
        sb2.append(i2);
        sb2.append(",isHitOomRule=");
        sb2.append(z);
        XesLog.i(tag, sb2.toString());
        if (z2) {
            CommonTrack.INSTANCE.hwReportMemInfo(max, rate, vssInKb, rssInKb, thread, totalInKb, freeInKb, availableInKb, rate2, cmaTotal, i2, z, str);
        }
    }
}
