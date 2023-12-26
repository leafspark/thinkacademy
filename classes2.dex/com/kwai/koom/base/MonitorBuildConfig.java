package com.kwai.koom.base;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\u00020\u000b8FX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/kwai/koom/base/MonitorBuildConfig;", "", "()V", "DEBUG", "", "getDEBUG$annotations", "getDEBUG", "()Z", "DEBUG$delegate", "Lkotlin/Lazy;", "ROM", "", "getROM$annotations", "getROM", "()Ljava/lang/String;", "ROM$delegate", "VERSION_NAME", "getVERSION_NAME$annotations", "getVERSION_NAME", "VERSION_NAME$delegate", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorBuildConfig.kt */
public final class MonitorBuildConfig {
    private static final Lazy DEBUG$delegate = LazyKt.lazy(MonitorBuildConfig$DEBUG$2.INSTANCE);
    public static final MonitorBuildConfig INSTANCE = new MonitorBuildConfig();
    private static final Lazy ROM$delegate = LazyKt.lazy(MonitorBuildConfig$ROM$2.INSTANCE);
    private static final Lazy VERSION_NAME$delegate = LazyKt.lazy(MonitorBuildConfig$VERSION_NAME$2.INSTANCE);

    public static final boolean getDEBUG() {
        return ((Boolean) DEBUG$delegate.getValue()).booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void getDEBUG$annotations() {
    }

    public static final String getROM() {
        return (String) ROM$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getROM$annotations() {
    }

    public static final String getVERSION_NAME() {
        return (String) VERSION_NAME$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getVERSION_NAME$annotations() {
    }

    private MonitorBuildConfig() {
    }
}
