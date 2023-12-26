package com.kwai.koom.javaoom.monitor;

import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMReportUploader;", "", "upload", "", "file", "Ljava/io/File;", "content", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMReportUploader.kt */
public interface OOMReportUploader {
    void upload(File file, String str);
}
