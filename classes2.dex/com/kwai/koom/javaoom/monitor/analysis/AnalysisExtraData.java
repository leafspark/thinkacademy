package com.kwai.koom.javaoom.monitor.analysis;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/analysis/AnalysisExtraData;", "", "()V", "currentPage", "", "getCurrentPage", "()Ljava/lang/String;", "setCurrentPage", "(Ljava/lang/String;)V", "reason", "getReason", "setReason", "usageSeconds", "getUsageSeconds", "setUsageSeconds", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalysisExtraData.kt */
public final class AnalysisExtraData {
    private String currentPage;
    private String reason;
    private String usageSeconds;

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(String str) {
        this.reason = str;
    }

    public final String getUsageSeconds() {
        return this.usageSeconds;
    }

    public final void setUsageSeconds(String str) {
        this.usageSeconds = str;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final void setCurrentPage(String str) {
        this.currentPage = str;
    }
}
