package com.kwai.koom.javaoom.monitor;

import com.huawei.multimedia.audiokit.config.ResultCode;
import com.kwai.koom.base.MonitorConfig;
import com.kwai.koom.javaoom.OOMReportInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B{\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006/"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMMonitorConfig;", "Lcom/kwai/koom/base/MonitorConfig;", "Lcom/kwai/koom/javaoom/monitor/OOMMonitor;", "analysisMaxTimesPerVersion", "", "analysisPeriodPerVersion", "heapThreshold", "", "fdThreshold", "threadThreshold", "deviceMemoryThreshold", "maxOverThresholdCount", "forceDumpJavaHeapMaxThreshold", "forceDumpJavaHeapDeltaThreshold", "loopInterval", "", "enableHprofDumpAnalysis", "", "hprofUploader", "Lcom/kwai/koom/javaoom/monitor/OOMHprofUploader;", "reportUploader", "Lcom/kwai/koom/javaoom/monitor/OOMReportUploader;", "reportInfo", "Lcom/kwai/koom/javaoom/OOMReportInfo;", "(IIFIIFIFIJZLcom/kwai/koom/javaoom/monitor/OOMHprofUploader;Lcom/kwai/koom/javaoom/monitor/OOMReportUploader;Lcom/kwai/koom/javaoom/OOMReportInfo;)V", "getAnalysisMaxTimesPerVersion", "()I", "getAnalysisPeriodPerVersion", "getDeviceMemoryThreshold", "()F", "getEnableHprofDumpAnalysis", "()Z", "getFdThreshold", "getForceDumpJavaHeapDeltaThreshold", "getForceDumpJavaHeapMaxThreshold", "getHeapThreshold", "getHprofUploader", "()Lcom/kwai/koom/javaoom/monitor/OOMHprofUploader;", "getLoopInterval", "()J", "getMaxOverThresholdCount", "getReportInfo", "()Lcom/kwai/koom/javaoom/OOMReportInfo;", "getReportUploader", "()Lcom/kwai/koom/javaoom/monitor/OOMReportUploader;", "getThreadThreshold", "Builder", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorConfig.kt */
public final class OOMMonitorConfig extends MonitorConfig<OOMMonitor> {
    private final int analysisMaxTimesPerVersion;
    private final int analysisPeriodPerVersion;
    private final float deviceMemoryThreshold;
    private final boolean enableHprofDumpAnalysis;
    private final int fdThreshold;
    private final int forceDumpJavaHeapDeltaThreshold;
    private final float forceDumpJavaHeapMaxThreshold;
    private final float heapThreshold;
    private final OOMHprofUploader hprofUploader;
    private final long loopInterval;
    private final int maxOverThresholdCount;
    private final OOMReportInfo reportInfo;
    private final OOMReportUploader reportUploader;
    private final int threadThreshold;

    public final int getAnalysisMaxTimesPerVersion() {
        return this.analysisMaxTimesPerVersion;
    }

    public final int getAnalysisPeriodPerVersion() {
        return this.analysisPeriodPerVersion;
    }

    public final float getHeapThreshold() {
        return this.heapThreshold;
    }

    public final int getFdThreshold() {
        return this.fdThreshold;
    }

    public final int getThreadThreshold() {
        return this.threadThreshold;
    }

    public final float getDeviceMemoryThreshold() {
        return this.deviceMemoryThreshold;
    }

    public final int getMaxOverThresholdCount() {
        return this.maxOverThresholdCount;
    }

    public final float getForceDumpJavaHeapMaxThreshold() {
        return this.forceDumpJavaHeapMaxThreshold;
    }

    public final int getForceDumpJavaHeapDeltaThreshold() {
        return this.forceDumpJavaHeapDeltaThreshold;
    }

    public final long getLoopInterval() {
        return this.loopInterval;
    }

    public final boolean getEnableHprofDumpAnalysis() {
        return this.enableHprofDumpAnalysis;
    }

    public final OOMHprofUploader getHprofUploader() {
        return this.hprofUploader;
    }

    public final OOMReportUploader getReportUploader() {
        return this.reportUploader;
    }

    public final OOMReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public OOMMonitorConfig(int i, int i2, float f, int i3, int i4, float f2, int i5, float f3, int i6, long j, boolean z, OOMHprofUploader oOMHprofUploader, OOMReportUploader oOMReportUploader, OOMReportInfo oOMReportInfo) {
        this.analysisMaxTimesPerVersion = i;
        this.analysisPeriodPerVersion = i2;
        this.heapThreshold = f;
        this.fdThreshold = i3;
        this.threadThreshold = i4;
        this.deviceMemoryThreshold = f2;
        this.maxOverThresholdCount = i5;
        this.forceDumpJavaHeapMaxThreshold = f3;
        this.forceDumpJavaHeapDeltaThreshold = i6;
        this.loopInterval = j;
        this.enableHprofDumpAnalysis = z;
        this.hprofUploader = oOMHprofUploader;
        this.reportUploader = oOMReportUploader;
        this.reportInfo = oOMReportInfo;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\bJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0013J\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0005J\u0010\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0016J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0018J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0005J\u000e\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMMonitorConfig$Builder;", "Lcom/kwai/koom/base/MonitorConfig$Builder;", "Lcom/kwai/koom/javaoom/monitor/OOMMonitorConfig;", "()V", "mAnalysisMaxTimesPerVersion", "", "mAnalysisPeriodPerVersion", "mDeviceMemoryThreshold", "", "mEnableHprofDumpAnalysis", "", "mFdThreshold", "mForceDumpJavaHeapDeltaThreshold", "mForceDumpJavaHeapMaxThreshold", "mHeapThreshold", "Ljava/lang/Float;", "mHprofUploader", "Lcom/kwai/koom/javaoom/monitor/OOMHprofUploader;", "mLoopInterval", "", "mMaxOverThresholdCount", "mReportInfo", "Lcom/kwai/koom/javaoom/OOMReportInfo;", "mReportUploader", "Lcom/kwai/koom/javaoom/monitor/OOMReportUploader;", "mThreadThreshold", "Ljava/lang/Integer;", "mVssSizeThreshold", "build", "setAnalysisMaxTimesPerVersion", "analysisMaxTimesPerVersion", "setAnalysisPeriodPerVersion", "analysisPeriodPerVersion", "setDeviceMemoryThreshold", "deviceMemoryThreshold", "setEnableHprofDumpAnalysis", "enableHprofDumpAnalysis", "setFdThreshold", "fdThreshold", "setForceDumpJavaHeapDeltaThreshold", "forceDumpJavaHeapDeltaThreshold", "setForceDumpJavaHeapMaxThreshold", "forceDumpJavaHeapMaxThreshold", "setHeapThreshold", "heapThreshold", "setHprofUploader", "hprofUploader", "setLoopInterval", "loopInterval", "setMaxOverThresholdCount", "maxOverThresholdCount", "setReportInfo", "reportInfo", "setReportUploader", "reportUploader", "setThreadThreshold", "threadThreshold", "setVssSizeThreshold", "vssSizeThreshold", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OOMMonitorConfig.kt */
    public static final class Builder implements MonitorConfig.Builder<OOMMonitorConfig> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Lazy<Float> DEFAULT_HEAP_THRESHOLD$delegate = LazyKt.lazy(OOMMonitorConfig$Builder$Companion$DEFAULT_HEAP_THRESHOLD$2.INSTANCE);
        /* access modifiers changed from: private */
        public static final Lazy<Integer> DEFAULT_THREAD_THRESHOLD$delegate = LazyKt.lazy(OOMMonitorConfig$Builder$Companion$DEFAULT_THREAD_THRESHOLD$2.INSTANCE);
        private int mAnalysisMaxTimesPerVersion = 5;
        private int mAnalysisPeriodPerVersion = 1296000000;
        private float mDeviceMemoryThreshold = 0.05f;
        private boolean mEnableHprofDumpAnalysis = true;
        private int mFdThreshold = ResultCode.KARAOKE_SUCCESS;
        private int mForceDumpJavaHeapDeltaThreshold = 350000;
        private float mForceDumpJavaHeapMaxThreshold = 0.9f;
        private Float mHeapThreshold;
        private OOMHprofUploader mHprofUploader;
        private long mLoopInterval = 15000;
        private int mMaxOverThresholdCount = 3;
        private OOMReportInfo mReportInfo;
        private OOMReportUploader mReportUploader;
        private Integer mThreadThreshold;
        private int mVssSizeThreshold = 3650000;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMMonitorConfig$Builder$Companion;", "", "()V", "DEFAULT_HEAP_THRESHOLD", "", "getDEFAULT_HEAP_THRESHOLD", "()F", "DEFAULT_HEAP_THRESHOLD$delegate", "Lkotlin/Lazy;", "DEFAULT_THREAD_THRESHOLD", "", "getDEFAULT_THREAD_THRESHOLD", "()I", "DEFAULT_THREAD_THRESHOLD$delegate", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: OOMMonitorConfig.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: private */
            public final float getDEFAULT_HEAP_THRESHOLD() {
                return ((Number) Builder.DEFAULT_HEAP_THRESHOLD$delegate.getValue()).floatValue();
            }

            /* access modifiers changed from: private */
            public final int getDEFAULT_THREAD_THRESHOLD() {
                return ((Number) Builder.DEFAULT_THREAD_THRESHOLD$delegate.getValue()).intValue();
            }
        }

        public final Builder setAnalysisMaxTimesPerVersion(int i) {
            Builder builder = this;
            builder.mAnalysisMaxTimesPerVersion = i;
            return builder;
        }

        public final Builder setAnalysisPeriodPerVersion(int i) {
            Builder builder = this;
            builder.mAnalysisPeriodPerVersion = i;
            return builder;
        }

        public final Builder setHeapThreshold(float f) {
            Builder builder = this;
            builder.mHeapThreshold = Float.valueOf(f);
            return builder;
        }

        public final Builder setVssSizeThreshold(int i) {
            Builder builder = this;
            builder.mVssSizeThreshold = i;
            return builder;
        }

        public final Builder setFdThreshold(int i) {
            Builder builder = this;
            builder.mFdThreshold = i;
            return builder;
        }

        public final Builder setThreadThreshold(int i) {
            Builder builder = this;
            builder.mThreadThreshold = Integer.valueOf(i);
            return builder;
        }

        public final Builder setMaxOverThresholdCount(int i) {
            Builder builder = this;
            builder.mMaxOverThresholdCount = i;
            return builder;
        }

        public final Builder setLoopInterval(long j) {
            Builder builder = this;
            builder.mLoopInterval = j;
            return builder;
        }

        public final Builder setEnableHprofDumpAnalysis(boolean z) {
            Builder builder = this;
            builder.mEnableHprofDumpAnalysis = z;
            return builder;
        }

        public final Builder setDeviceMemoryThreshold(float f) {
            Builder builder = this;
            builder.mDeviceMemoryThreshold = f;
            return builder;
        }

        public final Builder setForceDumpJavaHeapDeltaThreshold(int i) {
            Builder builder = this;
            builder.mForceDumpJavaHeapDeltaThreshold = i;
            return builder;
        }

        public final Builder setForceDumpJavaHeapMaxThreshold(float f) {
            Builder builder = this;
            builder.mForceDumpJavaHeapMaxThreshold = f;
            return builder;
        }

        public final Builder setHprofUploader(OOMHprofUploader oOMHprofUploader) {
            Intrinsics.checkNotNullParameter(oOMHprofUploader, "hprofUploader");
            Builder builder = this;
            builder.mHprofUploader = oOMHprofUploader;
            return builder;
        }

        public final Builder setReportUploader(OOMReportUploader oOMReportUploader) {
            Intrinsics.checkNotNullParameter(oOMReportUploader, "reportUploader");
            Builder builder = this;
            builder.mReportUploader = oOMReportUploader;
            return builder;
        }

        public final Builder setReportInfo(OOMReportInfo oOMReportInfo) {
            Builder builder = this;
            builder.mReportInfo = oOMReportInfo;
            return builder;
        }

        public OOMMonitorConfig build() {
            int i = this.mAnalysisMaxTimesPerVersion;
            int i2 = this.mAnalysisPeriodPerVersion;
            Float f = this.mHeapThreshold;
            float access$getDEFAULT_HEAP_THRESHOLD = f == null ? Companion.getDEFAULT_HEAP_THRESHOLD() : f.floatValue();
            int i3 = this.mFdThreshold;
            Integer num = this.mThreadThreshold;
            return new OOMMonitorConfig(i, i2, access$getDEFAULT_HEAP_THRESHOLD, i3, num == null ? Companion.getDEFAULT_THREAD_THRESHOLD() : num.intValue(), this.mDeviceMemoryThreshold, this.mMaxOverThresholdCount, this.mForceDumpJavaHeapMaxThreshold, this.mForceDumpJavaHeapDeltaThreshold, this.mLoopInterval, this.mEnableHprofDumpAnalysis, this.mHprofUploader, this.mReportUploader, this.mReportInfo);
        }
    }
}
