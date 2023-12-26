package com.kwai.koom.javaoom.monitor;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.kwai.koom.base.CommonConfig;
import com.kwai.koom.base.MonitorBuildConfig;
import com.kwai.koom.base.MonitorLog;
import com.kwai.koom.base.MonitorManager;
import com.kwai.koom.base.Monitor_ApplicationKt;
import com.kwai.koom.base.Monitor_ProcessKt;
import com.kwai.koom.base.Monitor_ThreadKt;
import com.kwai.koom.base.loop.LoopMonitor;
import com.kwai.koom.javaoom.OOMReportInfo;
import com.kwai.koom.javaoom.monitor.OOMHprofUploader;
import com.kwai.koom.javaoom.monitor.tracker.FastHugeMemoryOOMTracker;
import com.kwai.koom.javaoom.monitor.tracker.FdOOMTracker;
import com.kwai.koom.javaoom.monitor.tracker.HeapOOMTracker;
import com.kwai.koom.javaoom.monitor.tracker.OOMTracker;
import com.kwai.koom.javaoom.monitor.tracker.PhysicalMemoryOOMTracker;
import com.kwai.koom.javaoom.monitor.tracker.ThreadOOMTracker;
import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0014J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J \u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0006H\u0002J \u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0011H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMMonitor;", "Lcom/kwai/koom/base/loop/LoopMonitor;", "Lcom/kwai/koom/javaoom/monitor/OOMMonitorConfig;", "Landroidx/lifecycle/LifecycleEventObserver;", "()V", "TAG", "", "mForegroundPendingRunnables", "", "Ljava/lang/Runnable;", "mHasDumped", "", "mHasHitHwTrack", "mHasProcessOldHprof", "mIsLoopPendingStart", "mIsLoopStarted", "mMonitorInitTime", "", "mOOMTrackers", "Lcom/kwai/koom/javaoom/monitor/tracker/OOMTracker;", "mTrackReasons", "call", "Lcom/kwai/koom/base/loop/LoopMonitor$LoopState;", "dumpAndAnalysis", "", "getLoopInterval", "init", "commonConfig", "Lcom/kwai/koom/base/CommonConfig;", "monitorConfig", "isExceedAnalysisPeriod", "isExceedAnalysisTimes", "manualDumpHprof", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "processOldHprofFile", "reAnalysisHprof", "startAnalysisService", "hprofFile", "Ljava/io/File;", "jsonFile", "reason", "startLoop", "clearQueue", "postAtFront", "delayMillis", "stopLoop", "trackOOM", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitor.kt */
public final class OOMMonitor extends LoopMonitor<OOMMonitorConfig> implements LifecycleEventObserver {
    public static final OOMMonitor INSTANCE = new OOMMonitor();
    private static final String TAG = "OOMMonitor";
    private static List<Runnable> mForegroundPendingRunnables = new ArrayList();
    private static volatile boolean mHasDumped;
    private static volatile boolean mHasHitHwTrack;
    private static volatile boolean mHasProcessOldHprof;
    private static volatile boolean mIsLoopPendingStart;
    private static volatile boolean mIsLoopStarted;
    private static long mMonitorInitTime;
    private static final List<OOMTracker> mOOMTrackers = CollectionsKt.mutableListOf(new OOMTracker[]{new HeapOOMTracker(), new ThreadOOMTracker(), new FdOOMTracker(), new PhysicalMemoryOOMTracker(), new FastHugeMemoryOOMTracker()});
    private static final List<String> mTrackReasons = new ArrayList();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OOMMonitor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void startAnalysisService(File file, File file2, String str) {
    }

    private OOMMonitor() {
    }

    public void init(CommonConfig commonConfig, OOMMonitorConfig oOMMonitorConfig) {
        Intrinsics.checkNotNullParameter(commonConfig, "commonConfig");
        Intrinsics.checkNotNullParameter(oOMMonitorConfig, "monitorConfig");
        super.init(commonConfig, oOMMonitorConfig);
        mMonitorInitTime = SystemClock.elapsedRealtime();
        OOMPreferenceManager.INSTANCE.init(commonConfig.getSharedPreferencesInvoker());
        OOMFileManager.init((Function1<? super String, ? extends File>) commonConfig.getRootFileInvoker());
        for (OOMTracker init : mOOMTrackers) {
            init.init(commonConfig, oOMMonitorConfig);
        }
        Monitor_ApplicationKt.registerProcessLifecycleObserver(MonitorManager.getApplication(), (LifecycleEventObserver) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: startLoop$lambda-1  reason: not valid java name */
    public static final void m25startLoop$lambda1() {
        Monitor_ThreadKt.async$default(0, OOMMonitor$startLoop$2$1.INSTANCE, 1, (Object) null);
    }

    public LoopMonitor.LoopState call() {
        if (!Monitor_ApplicationKt.sdkVersionMatch()) {
            return LoopMonitor.LoopState.Terminate.INSTANCE;
        }
        if (mHasDumped) {
            return LoopMonitor.LoopState.Terminate.INSTANCE;
        }
        return trackOOM();
    }

    /* access modifiers changed from: protected */
    public long getLoopInterval() {
        return ((OOMMonitorConfig) getMonitorConfig()).getLoopInterval();
    }

    private final boolean isExceedAnalysisTimes() {
        MonitorLog.i(TAG, Intrinsics.stringPlus("OOMPreferenceManager.getAnalysisTimes:", Integer.valueOf(OOMPreferenceManager.INSTANCE.getAnalysisTimes())));
        boolean z = false;
        if (MonitorBuildConfig.getDEBUG()) {
            return false;
        }
        if (OOMPreferenceManager.INSTANCE.getAnalysisTimes() > ((OOMMonitorConfig) getMonitorConfig()).getAnalysisMaxTimesPerVersion()) {
            z = true;
        }
        if (z) {
            MonitorLog.e(TAG, "current version is out of max analysis times!");
        }
        return z;
    }

    private final boolean isExceedAnalysisPeriod() {
        MonitorLog.i(TAG, Intrinsics.stringPlus("OOMPreferenceManager.getFirstAnalysisTime():", Long.valueOf(OOMPreferenceManager.INSTANCE.getFirstLaunchTime())));
        boolean z = false;
        if (MonitorBuildConfig.getDEBUG()) {
            return false;
        }
        if (System.currentTimeMillis() - OOMPreferenceManager.INSTANCE.getFirstLaunchTime() > ((long) ((OOMMonitorConfig) getMonitorConfig()).getAnalysisPeriodPerVersion())) {
            z = true;
        }
        if (z) {
            MonitorLog.e(TAG, "current version is out of max analysis period!");
        }
        return z;
    }

    private final LoopMonitor.LoopState trackOOM() {
        SystemInfo.INSTANCE.refresh();
        mTrackReasons.clear();
        for (OOMTracker next : mOOMTrackers) {
            if (next.track()) {
                mTrackReasons.add(next.reason());
            }
        }
        OOMReportInfo reportInfo = ((OOMMonitorConfig) getMonitorConfig()).getReportInfo();
        if (reportInfo != null) {
            reportInfo.onLoopReport();
        }
        List<String> list = mTrackReasons;
        if ((!list.isEmpty()) && !mHasHitHwTrack) {
            OOMReportInfo reportInfo2 = ((OOMMonitorConfig) getMonitorConfig()).getReportInfo();
            if (reportInfo2 != null) {
                reportInfo2.onHitTracker(list);
            }
            mHasHitHwTrack = true;
        }
        return LoopMonitor.LoopState.Continue.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void processOldHprofFile() {
        MonitorLog.i(TAG, "processHprofFile");
    }

    private final void reAnalysisHprof() {
        Object listFiles = OOMFileManager.getHprofAnalysisDir().listFiles();
        if (listFiles == null) {
            listFiles = (Object[]) new File[0];
        }
        File[] fileArr = (File[]) listFiles;
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            i++;
            if (file.exists()) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                if (!StringsKt.startsWith$default(name, MonitorBuildConfig.getVERSION_NAME(), false, 2, (Object) null)) {
                    MonitorLog.i(TAG, Intrinsics.stringPlus("delete other version files ", file.getName()));
                    file.delete();
                } else {
                    String canonicalPath = file.getCanonicalPath();
                    Intrinsics.checkNotNullExpressionValue(canonicalPath, "file.canonicalPath");
                    if (StringsKt.endsWith$default(canonicalPath, ".hprof", false, 2, (Object) null)) {
                        String canonicalPath2 = file.getCanonicalPath();
                        Intrinsics.checkNotNullExpressionValue(canonicalPath2, "file.canonicalPath");
                        File file2 = new File(StringsKt.replace$default(canonicalPath2, ".hprof", ".json", false, 4, (Object) null));
                        if (!file2.exists()) {
                            MonitorLog.i(TAG, "create json file and then start service");
                            file2.createNewFile();
                            Intrinsics.checkNotNullExpressionValue(file, "file");
                            startAnalysisService(file, file2, "reanalysis");
                        } else {
                            MonitorLog.i(TAG, file2.length() == 0 ? "last analysis isn't succeed, delete file" : "delete old files", true);
                            file2.delete();
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    private final void manualDumpHprof() {
        Object listFiles = OOMFileManager.getManualDumpDir().listFiles();
        int i = 0;
        if (listFiles == null) {
            listFiles = (Object[]) new File[0];
        }
        File[] fileArr = (File[]) listFiles;
        int length = fileArr.length;
        while (i < length) {
            File file = fileArr[i];
            i++;
            MonitorLog.i(TAG, Intrinsics.stringPlus("manualDumpHprof upload:", file.getAbsolutePath()));
            OOMHprofUploader hprofUploader = ((OOMMonitorConfig) getMonitorConfig()).getHprofUploader();
            if (hprofUploader != null) {
                Intrinsics.checkNotNullExpressionValue(file, "hprofFile");
                hprofUploader.upload(file, OOMHprofUploader.HprofType.STRIPPED);
            }
        }
    }

    private final void dumpAndAnalysis() {
        MonitorLog.i(TAG, "dumpAndAnalysis");
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            if (!mHasDumped && mIsLoopPendingStart) {
                MonitorLog.i(TAG, "foreground");
                LoopMonitor.startLoop$default(this, false, false, 0, 7, (Object) null);
            }
            for (Runnable run : mForegroundPendingRunnables) {
                run.run();
            }
            mForegroundPendingRunnables.clear();
        } else if (i == 2) {
            mIsLoopPendingStart = mIsLoopStarted;
            MonitorLog.i(TAG, "background");
            stopLoop();
        }
    }

    public void startLoop(boolean z, boolean z2, long j) {
        if (isInitialized()) {
            if (Monitor_ProcessKt.isMainProcess()) {
                MonitorLog.i(TAG, "startLoop()");
                if (!mIsLoopStarted) {
                    mIsLoopStarted = true;
                    super.startLoop(z, z2, j);
                    getLoopHandler().postDelayed(OOMMonitor$$ExternalSyntheticLambda0.INSTANCE, j);
                }
            }
        } else if (MonitorBuildConfig.getDEBUG()) {
            throw new RuntimeException("Monitor is not initialized");
        }
    }

    public void stopLoop() {
        if (isInitialized()) {
            if (Monitor_ProcessKt.isMainProcess()) {
                super.stopLoop();
                MonitorLog.i(TAG, "stopLoop()");
                mIsLoopStarted = false;
                mHasHitHwTrack = false;
            }
        } else if (MonitorBuildConfig.getDEBUG()) {
            throw new RuntimeException("Monitor is not initialized");
        }
    }
}
