package com.kwai.koom.javaoom.monitor.analysis;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/analysis/AnalysisReceiver;", "Landroid/os/ResultReceiver;", "()V", "mResultCallBack", "Lcom/kwai/koom/javaoom/monitor/analysis/AnalysisReceiver$ResultCallBack;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "setResultCallBack", "resultCallBack", "Companion", "ResultCallBack", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalysisReceiver.kt */
public final class AnalysisReceiver extends ResultReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RESULT_CODE_FAIL = 1002;
    public static final int RESULT_CODE_OK = 1001;
    private ResultCallBack mResultCallBack;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/analysis/AnalysisReceiver$ResultCallBack;", "", "onError", "", "onSuccess", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnalysisReceiver.kt */
    public interface ResultCallBack {
        void onError();

        void onSuccess();
    }

    public AnalysisReceiver() {
        super((Handler) null);
    }

    public final void setResultCallBack(ResultCallBack resultCallBack) {
        this.mResultCallBack = resultCallBack;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        ResultCallBack resultCallBack = this.mResultCallBack;
        if (resultCallBack == null) {
            return;
        }
        if (i == 1001) {
            Intrinsics.checkNotNull(resultCallBack);
            resultCallBack.onSuccess();
            return;
        }
        Intrinsics.checkNotNull(resultCallBack);
        resultCallBack.onError();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/analysis/AnalysisReceiver$Companion;", "", "()V", "RESULT_CODE_FAIL", "", "RESULT_CODE_OK", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnalysisReceiver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
