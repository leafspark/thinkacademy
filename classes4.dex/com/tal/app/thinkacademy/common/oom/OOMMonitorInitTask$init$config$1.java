package com.tal.app.thinkacademy.common.oom;

import com.kwai.koom.javaoom.OOMReportInfo;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/common/oom/OOMMonitorInitTask$init$config$1", "Lcom/kwai/koom/javaoom/OOMReportInfo;", "onHitTracker", "", "reasons", "", "", "onLoopReport", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorInitTask.kt */
public final class OOMMonitorInitTask$init$config$1 implements OOMReportInfo {
    OOMMonitorInitTask$init$config$1() {
    }

    public void onLoopReport() {
        boolean z = OOMMonitorInitTask.reportCount < 0;
        OOMMonitorInitTask oOMMonitorInitTask = OOMMonitorInitTask.INSTANCE;
        OOMMonitorInitTask.reportCount = OOMMonitorInitTask.reportCount + 1;
        if (OOMMonitorInitTask.reportCount >= 3) {
            OOMMonitorInitTask oOMMonitorInitTask2 = OOMMonitorInitTask.INSTANCE;
            OOMMonitorInitTask.reportCount = -1;
        }
        OOMMonitorInitTask.reportMemInfo$default(OOMMonitorInitTask.INSTANCE, false, (String) null, z, 3, (Object) null);
    }

    public void onHitTracker(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "reasons");
        String valueOf = String.valueOf(list);
        XesLog.e(OOMMonitorInitTask.TAG, Intrinsics.stringPlus("命中了OOM规则 ", valueOf));
        OOMMonitorInitTask.reportMemInfo$default(OOMMonitorInitTask.INSTANCE, true, valueOf, false, 4, (Object) null);
    }
}
