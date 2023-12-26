package com.kwai.koom.javaoom;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/kwai/koom/javaoom/OOMReportInfo;", "", "onHitTracker", "", "reasons", "", "", "onLoopReport", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMReportInfo.kt */
public interface OOMReportInfo {
    void onHitTracker(List<String> list);

    void onLoopReport();
}