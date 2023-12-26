package com.tal.app.thinkacademy.common.oom;

import com.kwai.koom.javaoom.monitor.OOMHprofUploader;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/common/oom/OOMMonitorInitTask$init$config$2", "Lcom/kwai/koom/javaoom/monitor/OOMHprofUploader;", "upload", "", "file", "Ljava/io/File;", "type", "Lcom/kwai/koom/javaoom/monitor/OOMHprofUploader$HprofType;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorInitTask.kt */
public final class OOMMonitorInitTask$init$config$2 implements OOMHprofUploader {
    OOMMonitorInitTask$init$config$2() {
    }

    public void upload(File file, OOMHprofUploader.HprofType hprofType) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(hprofType, "type");
        XesLog.e(OOMMonitorInitTask.TAG, "todo, upload hprof " + file.getName() + " if necessary");
    }
}
