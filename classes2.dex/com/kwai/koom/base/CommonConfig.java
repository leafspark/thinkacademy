package com.kwai.koom.base;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import com.didi.hummer.devtools.bean.WSMsg;
import java.io.File;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001.B±\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0005\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0002\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0014\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!¨\u0006/"}, d2 = {"Lcom/kwai/koom/base/CommonConfig;", "", "application", "Landroid/app/Application;", "rootFileInvoker", "Lkotlin/Function1;", "", "Ljava/io/File;", "sharedPreferencesInvoker", "Landroid/content/SharedPreferences;", "sharedPreferencesKeysInvoker", "", "debugMode", "", "sdkVersionMatch", "versionNameInvoker", "Lkotlin/Function0;", "logger", "Lcom/kwai/koom/base/Logger;", "log", "Lcom/kwai/koom/base/Log;", "loadSoInvoker", "", "executorServiceInvoker", "Ljava/util/concurrent/ExecutorService;", "loopHandlerInvoker", "Landroid/os/Handler;", "(Landroid/app/Application;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;Lcom/kwai/koom/base/Logger;Lcom/kwai/koom/base/Log;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getApplication", "()Landroid/app/Application;", "getDebugMode$koom_monitor_base_SharedCppRelease", "()Z", "getExecutorServiceInvoker$koom_monitor_base_SharedCppRelease", "()Lkotlin/jvm/functions/Function0;", "getLoadSoInvoker$koom_monitor_base_SharedCppRelease", "()Lkotlin/jvm/functions/Function1;", "getLog$koom_monitor_base_SharedCppRelease", "()Lcom/kwai/koom/base/Log;", "getLogger$koom_monitor_base_SharedCppRelease", "()Lcom/kwai/koom/base/Logger;", "getLoopHandlerInvoker$koom_monitor_base_SharedCppRelease", "getRootFileInvoker", "getSdkVersionMatch$koom_monitor_base_SharedCppRelease", "getSharedPreferencesInvoker", "getSharedPreferencesKeysInvoker", "getVersionNameInvoker$koom_monitor_base_SharedCppRelease", "Builder", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
public final class CommonConfig {
    private final Application application;
    private final boolean debugMode;
    private final Function0<ExecutorService> executorServiceInvoker;
    private final Function1<String, Unit> loadSoInvoker;
    private final Log log;
    private final Logger logger;
    private final Function0<Handler> loopHandlerInvoker;
    private final Function1<String, File> rootFileInvoker;
    private final boolean sdkVersionMatch;
    private final Function1<String, SharedPreferences> sharedPreferencesInvoker;
    private final Function1<SharedPreferences, Set<String>> sharedPreferencesKeysInvoker;
    private final Function0<String> versionNameInvoker;

    private CommonConfig(Application application2, Function1<? super String, ? extends File> function1, Function1<? super String, ? extends SharedPreferences> function12, Function1<? super SharedPreferences, ? extends Set<String>> function13, boolean z, boolean z2, Function0<String> function0, Logger logger2, Log log2, Function1<? super String, Unit> function14, Function0<? extends ExecutorService> function02, Function0<? extends Handler> function03) {
        this.application = application2;
        this.rootFileInvoker = function1;
        this.sharedPreferencesInvoker = function12;
        this.sharedPreferencesKeysInvoker = function13;
        this.debugMode = z;
        this.sdkVersionMatch = z2;
        this.versionNameInvoker = function0;
        this.logger = logger2;
        this.log = log2;
        this.loadSoInvoker = function14;
        this.executorServiceInvoker = function02;
        this.loopHandlerInvoker = function03;
    }

    public /* synthetic */ CommonConfig(Application application2, Function1 function1, Function1 function12, Function1 function13, boolean z, boolean z2, Function0 function0, Logger logger2, Log log2, Function1 function14, Function0 function02, Function0 function03, DefaultConstructorMarker defaultConstructorMarker) {
        this(application2, function1, function12, function13, z, z2, function0, logger2, log2, function14, function02, function03);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final Function1<String, File> getRootFileInvoker() {
        return this.rootFileInvoker;
    }

    public final Function1<String, SharedPreferences> getSharedPreferencesInvoker() {
        return this.sharedPreferencesInvoker;
    }

    public final Function1<SharedPreferences, Set<String>> getSharedPreferencesKeysInvoker() {
        return this.sharedPreferencesKeysInvoker;
    }

    public final boolean getDebugMode$koom_monitor_base_SharedCppRelease() {
        return this.debugMode;
    }

    public final boolean getSdkVersionMatch$koom_monitor_base_SharedCppRelease() {
        return this.sdkVersionMatch;
    }

    public final Function0<String> getVersionNameInvoker$koom_monitor_base_SharedCppRelease() {
        return this.versionNameInvoker;
    }

    public final Logger getLogger$koom_monitor_base_SharedCppRelease() {
        return this.logger;
    }

    public final Log getLog$koom_monitor_base_SharedCppRelease() {
        return this.log;
    }

    public final Function1<String, Unit> getLoadSoInvoker$koom_monitor_base_SharedCppRelease() {
        return this.loadSoInvoker;
    }

    public final Function0<ExecutorService> getExecutorServiceInvoker$koom_monitor_base_SharedCppRelease() {
        return this.executorServiceInvoker;
    }

    public final Function0<Handler> getLoopHandlerInvoker$koom_monitor_base_SharedCppRelease() {
        return this.loopHandlerInvoker;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0006J\u0014\u0010#\u001a\u00020\u00002\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ\u001a\u0010%\u001a\u00020\u00002\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0012J\u0014\u0010+\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\bJ\u001a\u0010-\u001a\u00020\u00002\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\rJ\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0006J\u001a\u00101\u001a\u00020\u00002\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190\rJ \u00103\u001a\u00020\u00002\u0018\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\rJ\u0014\u00105\u001a\u00020\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0019\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/kwai/koom/base/CommonConfig$Builder;", "", "()V", "mApplication", "Landroid/app/Application;", "mDebugMode", "", "mDeviceIdInvoker", "Lkotlin/Function0;", "", "mExecutorServiceInvoker", "Ljava/util/concurrent/ExecutorService;", "mLoadSoInvoker", "Lkotlin/Function1;", "", "mLog", "Lcom/kwai/koom/base/Log;", "mLogger", "Lcom/kwai/koom/base/Logger;", "mLoopHandlerInvoker", "Landroid/os/Handler;", "mRootFileInvoker", "Ljava/io/File;", "mSdkVersionMatch", "mSharedPreferencesInvoker", "Landroid/content/SharedPreferences;", "mSharedPreferencesKeysInvoker", "", "mVersionNameInvoker", "build", "Lcom/kwai/koom/base/CommonConfig;", "setApplication", "application", "setDebugMode", "debugMode", "setExecutorServiceInvoker", "executorServiceInvoker", "setLoadSoInvoker", "LoadSoInvoker", "setLog", "log", "setLogger", "logger", "setLoopHandlerInvoker", "loopHandlerInvoker", "setRootFileInvoker", "rootFileInvoker", "setSdkVersionMatch", "sdkVersionMatch", "setSharedPreferencesInvoker", "sharedPreferencesInvoker", "setSharedPreferencesKeysInvoker", "sharedPreferencesKeysInvoker", "setVersionNameInvoker", "versionNameInvoker", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
    /* compiled from: CommonConfig.kt */
    public static final class Builder {
        /* access modifiers changed from: private */
        public Application mApplication;
        private boolean mDebugMode = true;
        private Function0<String> mDeviceIdInvoker;
        private Function0<? extends ExecutorService> mExecutorServiceInvoker;
        private Function1<? super String, Unit> mLoadSoInvoker;
        private Log mLog;
        private Logger mLogger;
        private Function0<? extends Handler> mLoopHandlerInvoker;
        private Function1<? super String, ? extends File> mRootFileInvoker;
        private boolean mSdkVersionMatch;
        private Function1<? super String, ? extends SharedPreferences> mSharedPreferencesInvoker;
        private Function1<? super SharedPreferences, ? extends Set<String>> mSharedPreferencesKeysInvoker;
        private Function0<String> mVersionNameInvoker;

        public static final /* synthetic */ Application access$getMApplication$p(Builder builder) {
            Application application = builder.mApplication;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApplication");
            }
            return application;
        }

        public final Builder setApplication(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            Builder builder = this;
            builder.mApplication = application;
            return builder;
        }

        public final Builder setDebugMode(boolean z) {
            Builder builder = this;
            builder.mDebugMode = z;
            return builder;
        }

        public final Builder setSdkVersionMatch(boolean z) {
            Builder builder = this;
            builder.mSdkVersionMatch = z;
            return builder;
        }

        public final Builder setVersionNameInvoker(Function0<String> function0) {
            Intrinsics.checkNotNullParameter(function0, "versionNameInvoker");
            Builder builder = this;
            builder.mVersionNameInvoker = function0;
            return builder;
        }

        public final Builder setRootFileInvoker(Function1<? super String, ? extends File> function1) {
            Intrinsics.checkNotNullParameter(function1, "rootFileInvoker");
            Builder builder = this;
            builder.mRootFileInvoker = function1;
            return builder;
        }

        public final Builder setSharedPreferencesInvoker(Function1<? super String, ? extends SharedPreferences> function1) {
            Intrinsics.checkNotNullParameter(function1, "sharedPreferencesInvoker");
            Builder builder = this;
            builder.mSharedPreferencesInvoker = function1;
            return builder;
        }

        public final Builder setSharedPreferencesKeysInvoker(Function1<? super SharedPreferences, ? extends Set<String>> function1) {
            Intrinsics.checkNotNullParameter(function1, "sharedPreferencesKeysInvoker");
            Builder builder = this;
            builder.mSharedPreferencesKeysInvoker = function1;
            return builder;
        }

        public final Builder setLoadSoInvoker(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "LoadSoInvoker");
            Builder builder = this;
            builder.mLoadSoInvoker = function1;
            return builder;
        }

        public final Builder setLogger(Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            Builder builder = this;
            builder.mLogger = logger;
            return builder;
        }

        public final Builder setLog(Log log) {
            Intrinsics.checkNotNullParameter(log, WSMsg.TYPE_LOG);
            Builder builder = this;
            builder.mLog = log;
            return builder;
        }

        public final Builder setExecutorServiceInvoker(Function0<? extends ExecutorService> function0) {
            Intrinsics.checkNotNullParameter(function0, "executorServiceInvoker");
            Builder builder = this;
            builder.mExecutorServiceInvoker = function0;
            return builder;
        }

        public final Builder setLoopHandlerInvoker(Function0<? extends Handler> function0) {
            Intrinsics.checkNotNullParameter(function0, "loopHandlerInvoker");
            Builder builder = this;
            builder.mLoopHandlerInvoker = function0;
            return builder;
        }

        public final CommonConfig build() {
            Application application = this.mApplication;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApplication");
            }
            boolean z = this.mDebugMode;
            boolean z2 = this.mSdkVersionMatch;
            Function0<String> function0 = this.mVersionNameInvoker;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVersionNameInvoker");
            }
            Function1<? super String, ? extends File> function1 = this.mRootFileInvoker;
            if (function1 == null) {
                function1 = (Function1) new CommonConfig$Builder$build$1(this);
            }
            Function1<? super String, ? extends File> function12 = function1;
            Function1<? super String, ? extends SharedPreferences> function13 = this.mSharedPreferencesInvoker;
            if (function13 == null) {
                function13 = (Function1) new CommonConfig$Builder$build$2(this);
            }
            Function1<? super String, ? extends SharedPreferences> function14 = function13;
            Function1<? super SharedPreferences, ? extends Set<String>> function15 = this.mSharedPreferencesKeysInvoker;
            if (function15 == null) {
                function15 = (Function1) CommonConfig$Builder$build$3.INSTANCE;
            }
            Function1<? super SharedPreferences, ? extends Set<String>> function16 = function15;
            Logger logger = this.mLogger;
            if (logger == null) {
                logger = new CommonConfig$Builder$build$4();
            }
            Logger logger2 = logger;
            Log log = this.mLog;
            if (log == null) {
                log = new CommonConfig$Builder$build$5();
            }
            Log log2 = log;
            Function1<? super String, Unit> function17 = this.mLoadSoInvoker;
            if (function17 == null) {
                function17 = (Function1) CommonConfig$Builder$build$6.INSTANCE;
            }
            Function1<? super String, Unit> function18 = function17;
            Function0<? extends ExecutorService> function02 = this.mExecutorServiceInvoker;
            Function0<? extends Handler> function03 = this.mLoopHandlerInvoker;
            if (function03 == null) {
                function03 = (Function0) CommonConfig$Builder$build$7.INSTANCE;
            }
            return new CommonConfig(application, function12, function14, function16, z, z2, function0, logger2, log2, function18, function02, function03, (DefaultConstructorMarker) null);
        }
    }
}
