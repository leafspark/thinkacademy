package com.kwai.koom.base;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u00020\u00172\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001bH\bø\u0001\u0000J\f\u0010\u001d\u001a\u00020\f*\u00020\fH\u0004R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"Lcom/kwai/koom/base/Monitor;", "C", "", "()V", "_commonConfig", "Lcom/kwai/koom/base/CommonConfig;", "_monitorConfig", "Ljava/lang/Object;", "commonConfig", "getCommonConfig", "()Lcom/kwai/koom/base/CommonConfig;", "isInitialized", "", "()Z", "setInitialized", "(Z)V", "monitorConfig", "getMonitorConfig", "()Ljava/lang/Object;", "getLogParams", "", "", "init", "", "(Lcom/kwai/koom/base/CommonConfig;Ljava/lang/Object;)V", "throwIfNotInitialized", "onDebug", "Lkotlin/Function0;", "onRelease", "syncToInitialized", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: Monitor.kt */
public abstract class Monitor<C> {
    private CommonConfig _commonConfig;
    private C _monitorConfig;
    private boolean isInitialized;

    /* access modifiers changed from: protected */
    public final CommonConfig getCommonConfig() {
        CommonConfig commonConfig = this._commonConfig;
        Intrinsics.checkNotNull(commonConfig);
        return commonConfig;
    }

    /* access modifiers changed from: protected */
    public final C getMonitorConfig() {
        C c = this._monitorConfig;
        Intrinsics.checkNotNull(c);
        return c;
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public void setInitialized(boolean z) {
        this.isInitialized = z;
    }

    public static /* synthetic */ void throwIfNotInitialized$default(Monitor monitor, Function0 function0, Function0 function02, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function0 = (Function0) Monitor$throwIfNotInitialized$1.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(function0, "onDebug");
            Intrinsics.checkNotNullParameter(function02, "onRelease");
            if (!monitor.isInitialized()) {
                if (MonitorBuildConfig.getDEBUG()) {
                    function0.invoke();
                } else {
                    function02.invoke();
                }
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: throwIfNotInitialized");
        }
    }

    /* access modifiers changed from: protected */
    public final void throwIfNotInitialized(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onDebug");
        Intrinsics.checkNotNullParameter(function02, "onRelease");
        if (!isInitialized()) {
            if (MonitorBuildConfig.getDEBUG()) {
                function0.invoke();
            } else {
                function02.invoke();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean syncToInitialized(boolean z) {
        setInitialized(z && isInitialized());
        return z;
    }

    public void init(CommonConfig commonConfig, C c) {
        Intrinsics.checkNotNullParameter(commonConfig, "commonConfig");
        this._commonConfig = commonConfig;
        this._monitorConfig = c;
        setInitialized(true);
    }

    public Map<String, Object> getLogParams() {
        StringBuilder sb = new StringBuilder();
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        sb.append(StringsKt.decapitalize(simpleName));
        sb.append("ingEnabled");
        return MapsKt.mapOf(TuplesKt.to(sb.toString(), Boolean.valueOf(isInitialized())));
    }
}
