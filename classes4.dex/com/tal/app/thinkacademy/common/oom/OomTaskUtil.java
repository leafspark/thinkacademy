package com.tal.app.thinkacademy.common.oom;

import android.app.Application;
import com.kwai.koom.javaoom.monitor.OOMMonitor;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/oom/OomTaskUtil;", "", "()V", "TAG", "", "mIsInit", "", "init", "", "application", "Landroid/app/Application;", "isOomMonitOpen", "start", "stop", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OomTaskUtil.kt */
public final class OomTaskUtil {
    public static final OomTaskUtil INSTANCE = new OomTaskUtil();
    private static final String TAG = "OOM信息";
    private static boolean mIsInit;

    private OomTaskUtil() {
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        HwOomInitTask.INSTANCE.init(application);
        OOMMonitorInitTask.INSTANCE.init(application);
        mIsInit = true;
    }

    public final boolean isOomMonitOpen() {
        boolean areEqual = Intrinsics.areEqual("1", HwCloudControlHelper.Companion.get().getCloudKeyValue("hw_oom_monitor_enable"));
        XesLog.it(TAG, Intrinsics.stringPlus("云控配置是否打开内存监控=", Boolean.valueOf(areEqual)));
        return areEqual;
    }

    public final void start() {
        if (isOomMonitOpen()) {
            try {
                if (!mIsInit) {
                    Application app = Utils.getApp();
                    Intrinsics.checkNotNullExpressionValue(app, "getApp()");
                    init(app);
                }
                OOMMonitor.INSTANCE.stopLoop();
                OOMMonitor.INSTANCE.startLoop(true, false, 5000);
                XesLog.it(TAG, "启动内存监控！！！");
            } catch (Exception e) {
                XesLog.et(TAG, Intrinsics.stringPlus("启动监控失败=", e));
            }
        }
    }

    public final void stop() {
        try {
            if (mIsInit) {
                OOMMonitor.INSTANCE.stopLoop();
            }
            XesLog.it(TAG, "关闭内存监控！！！");
        } catch (Exception e) {
            XesLog.et(TAG, Intrinsics.stringPlus("关闭内存监控失败=", e));
        }
    }
}
