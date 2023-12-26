package com.kwai.koom.javaoom.monitor;

import android.os.StatFs;
import com.kwai.koom.base.MonitorBuildConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0007J\u001c\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0012H\u0007J\u0012\u0010&\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010*\u001a\u00020+H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\u00020\u00068FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\u00020\u00068FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\tR\u001b\u0010\u0018\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0019\u0010\tR!\u0010\u001b\u001a\u00020\u00068FX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\t¨\u0006,"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/OOMFileManager;", "", "()V", "TIME_FORMAT", "", "fdDumpDir", "Ljava/io/File;", "getFdDumpDir$annotations", "getFdDumpDir", "()Ljava/io/File;", "fdDumpDir$delegate", "Lkotlin/Lazy;", "hprofAnalysisDir", "getHprofAnalysisDir$annotations", "getHprofAnalysisDir", "hprofAnalysisDir$delegate", "mPrefix", "mRootDirInvoker", "Lkotlin/Function1;", "mRootPath", "manualDumpDir", "getManualDumpDir$annotations", "getManualDumpDir", "manualDumpDir$delegate", "rootDir", "getRootDir", "rootDir$delegate", "threadDumpDir", "getThreadDumpDir$annotations", "getThreadDumpDir", "threadDumpDir$delegate", "createDumpFile", "dumpDir", "createHprofAnalysisFile", "date", "Ljava/util/Date;", "createHprofOOMDumpFile", "createJsonAnalysisFile", "init", "", "rootDirInvoker", "rootPath", "isSpaceEnough", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMFileManager.kt */
public final class OOMFileManager {
    public static final OOMFileManager INSTANCE = new OOMFileManager();
    private static final String TIME_FORMAT = "yyyy-MM-dd_HH-mm-ss_SSS";
    private static final Lazy fdDumpDir$delegate = LazyKt.lazy(OOMFileManager$fdDumpDir$2.INSTANCE);
    private static final Lazy hprofAnalysisDir$delegate = LazyKt.lazy(OOMFileManager$hprofAnalysisDir$2.INSTANCE);
    private static String mPrefix;
    /* access modifiers changed from: private */
    public static Function1<? super String, ? extends File> mRootDirInvoker;
    /* access modifiers changed from: private */
    public static String mRootPath;
    private static final Lazy manualDumpDir$delegate = LazyKt.lazy(OOMFileManager$manualDumpDir$2.INSTANCE);
    private static final Lazy rootDir$delegate = LazyKt.lazy(OOMFileManager$rootDir$2.INSTANCE);
    private static final Lazy threadDumpDir$delegate = LazyKt.lazy(OOMFileManager$threadDumpDir$2.INSTANCE);

    @JvmStatic
    public static /* synthetic */ void getFdDumpDir$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getHprofAnalysisDir$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getManualDumpDir$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getThreadDumpDir$annotations() {
    }

    private OOMFileManager() {
    }

    public final File getRootDir() {
        return (File) rootDir$delegate.getValue();
    }

    public static final File getHprofAnalysisDir() {
        return (File) hprofAnalysisDir$delegate.getValue();
    }

    public static final File getManualDumpDir() {
        return (File) manualDumpDir$delegate.getValue();
    }

    public static final File getThreadDumpDir() {
        return (File) threadDumpDir$delegate.getValue();
    }

    public static final File getFdDumpDir() {
        return (File) fdDumpDir$delegate.getValue();
    }

    @JvmStatic
    public static final void init(Function1<? super String, ? extends File> function1) {
        Intrinsics.checkNotNullParameter(function1, "rootDirInvoker");
        mRootDirInvoker = function1;
        mPrefix = Intrinsics.stringPlus(MonitorBuildConfig.getVERSION_NAME(), "_");
    }

    @JvmStatic
    public static final void init(String str) {
        if (str != null) {
            mRootPath = str;
        }
        mPrefix = Intrinsics.stringPlus(MonitorBuildConfig.getVERSION_NAME(), "_");
    }

    @JvmStatic
    public static final File createHprofAnalysisFile(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat(TIME_FORMAT, Locale.CHINESE).format(date);
        File hprofAnalysisDir = getHprofAnalysisDir();
        StringBuilder sb = new StringBuilder();
        String str = mPrefix;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        sb.append(str);
        sb.append(format);
        sb.append(".hprof");
        File file = new File(hprofAnalysisDir, sb.toString());
        getHprofAnalysisDir().mkdirs();
        return file;
    }

    @JvmStatic
    public static final File createJsonAnalysisFile(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat(TIME_FORMAT, Locale.CHINESE).format(date);
        File hprofAnalysisDir = getHprofAnalysisDir();
        StringBuilder sb = new StringBuilder();
        String str = mPrefix;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        sb.append(str);
        sb.append(format);
        sb.append(".json");
        File file = new File(hprofAnalysisDir, sb.toString());
        getHprofAnalysisDir().mkdirs();
        return file;
    }

    @JvmStatic
    public static final File createHprofOOMDumpFile(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat(TIME_FORMAT, Locale.CHINESE).format(date);
        File manualDumpDir = getManualDumpDir();
        StringBuilder sb = new StringBuilder();
        String str = mPrefix;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPrefix");
            str = null;
        }
        sb.append(str);
        sb.append(format);
        sb.append(".hprof");
        File file = new File(manualDumpDir, sb.toString());
        getManualDumpDir().mkdirs();
        return file;
    }

    @JvmStatic
    public static final File createDumpFile(File file) {
        Intrinsics.checkNotNullParameter(file, "dumpDir");
        File file2 = new File(file, "dump.txt");
        file.mkdirs();
        return file2;
    }

    @JvmStatic
    public static final boolean isSpaceEnough() {
        StatFs statFs = new StatFs(getHprofAnalysisDir().getCanonicalPath());
        return ((double) (statFs.getBlockSizeLong() * ((long) statFs.getAvailableBlocks()))) > 1258291.2d;
    }
}
