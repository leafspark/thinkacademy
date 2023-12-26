package com.tal.app.thinkacademy.common.oom;

import com.kwai.koom.javaoom.monitor.OOMReportUploader;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/common/oom/OOMMonitorInitTask$init$config$3", "Lcom/kwai/koom/javaoom/monitor/OOMReportUploader;", "upload", "", "file", "Ljava/io/File;", "content", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorInitTask.kt */
public final class OOMMonitorInitTask$init$config$3 implements OOMReportUploader {
    OOMMonitorInitTask$init$config$3() {
    }

    public void upload(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(str, "content");
        XesLog.i(OOMMonitorInitTask.TAG, str);
        XesLog.e(OOMMonitorInitTask.TAG, "todo, upload report " + file.getName() + " if necessary");
    }
}
