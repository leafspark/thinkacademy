package com.tal.app.thinkacademy.business.study.study.ready;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.utils.ServeTime;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0004J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBaseVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "TAG", "Lcom/tal/app/thinkacademy/business/study/study/Tag;", "isTickerRuning", "", "mServerTime", "Lcom/tal/app/thinkacademy/common/utils/ServeTime;", "showFloatFormat", "Ljava/text/DecimalFormat;", "defer", "", "timeMillis", "", "call", "Lkotlin/Function0;", "getServerTime", "log", "contents", "", "logE", "setupServerTime", "serverNewTime", "requestDuration", "showSpeed", "speed", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassBaseVM.kt */
public class ReadyClassBaseVM extends BaseViewModel {
    private final Tag TAG;
    private boolean isTickerRuning;
    private ServeTime mServerTime;
    private DecimalFormat showFloatFormat = new DecimalFormat("0.00");

    public ReadyClassBaseVM() {
        Tag tag;
        if (this instanceof ReadyClassLiveVM) {
            tag = Tag.BEFORE_CLASS_READY_LIVE;
        } else {
            tag = Tag.BEFORE_CLASS_READY_BACK;
        }
        this.TAG = tag;
    }

    public final void log(String str) {
        XesLog.i(this.TAG, new Object[]{str});
    }

    public final void logE(String str) {
        XesLog.e(this.TAG, new Object[]{str});
    }

    public final void defer(long j, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "call");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new ReadyClassBaseVM$defer$1(j, function0, (Continuation<? super ReadyClassBaseVM$defer$1>) null), 3, (Object) null);
    }

    public final String showSpeed(long j) {
        if (j >= 1048576) {
            return Intrinsics.stringPlus(this.showFloatFormat.format(((double) j) / 1048576.0d), " MB/s");
        }
        return Intrinsics.stringPlus(this.showFloatFormat.format(((double) j) / 1024.0d), " KB/s");
    }

    /* access modifiers changed from: protected */
    public final void setupServerTime(long j, long j2) {
        ServeTime serveTime = new ServeTime(j);
        serveTime.setRequestTimeOffset(j2);
        this.mServerTime = serveTime;
    }

    public final long getServerTime() {
        ServeTime serveTime = this.mServerTime;
        Long valueOf = serveTime == null ? null : Long.valueOf(serveTime.getServeNowTime());
        return valueOf == null ? System.currentTimeMillis() / ((long) 1000) : valueOf.longValue();
    }
}
