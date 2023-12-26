package com.kwai.koom.base;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/kwai/koom/base/Logger;", "", "addCustomStatEvent", "", "key", "", "value", "realtimeReport", "", "addExceptionEvent", "message", "crashType", "", "ExceptionType", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorLogger.kt */
public interface Logger {
    void addCustomStatEvent(String str, String str2, boolean z);

    void addExceptionEvent(String str, int i);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* compiled from: MonitorLogger.kt */
    public static final class DefaultImpls {
        public static void addCustomStatEvent(Logger logger, String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "key");
        }

        public static void addExceptionEvent(Logger logger, String str, int i) {
            Intrinsics.checkNotNullParameter(str, "message");
        }

        public static /* synthetic */ void addCustomStatEvent$default(Logger logger, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                logger.addCustomStatEvent(str, str2, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCustomStatEvent");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/kwai/koom/base/Logger$ExceptionType;", "", "Companion", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: MonitorLogger.kt */
    public @interface ExceptionType {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int NATIVE_LEAK = 3;
        public static final int OOM = 1;
        public static final int OOM_STACKS = 2;
        public static final int THREAD_STACKS = 4;
        public static final int UNKNOWN_TYPE = 0;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/kwai/koom/base/Logger$ExceptionType$Companion;", "", "()V", "NATIVE_LEAK", "", "OOM", "OOM_STACKS", "THREAD_STACKS", "UNKNOWN_TYPE", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
        /* compiled from: MonitorLogger.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int NATIVE_LEAK = 3;
            public static final int OOM = 1;
            public static final int OOM_STACKS = 2;
            public static final int THREAD_STACKS = 4;
            public static final int UNKNOWN_TYPE = 0;

            private Companion() {
            }
        }
    }
}
